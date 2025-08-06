package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.audio.Ac4Util;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.SeekPoint;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MotionPhotoMetadata;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class Mp4Extractor implements Extractor, SeekMap {
    public static final ExtractorsFactory FACTORY = c.f65900a;
    private static final int FILE_TYPE_HEIC = 2;
    private static final int FILE_TYPE_MP4 = 0;
    private static final int FILE_TYPE_QUICKTIME = 1;
    public static final int FLAG_READ_MOTION_PHOTO_METADATA = 2;
    public static final int FLAG_READ_SEF_DATA = 4;
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 1;
    private static final long MAXIMUM_READ_AHEAD_BYTES_STREAM = 10485760;
    private static final long RELOAD_MINIMUM_SEEK_DISTANCE = 262144;
    private static final int STATE_READING_ATOM_HEADER = 0;
    private static final int STATE_READING_ATOM_PAYLOAD = 1;
    private static final int STATE_READING_SAMPLE = 2;
    private static final int STATE_READING_SEF = 3;
    private long[][] accumulatedSampleSizes;
    private ParsableByteArray atomData;
    private final ParsableByteArray atomHeader;
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private final ArrayDeque<Atom.ContainerAtom> containerAtoms;
    private long durationUs;
    private ExtractorOutput extractorOutput;
    private int fileType;
    private int firstVideoTrackIndex;
    private final int flags;
    private MotionPhotoMetadata motionPhotoMetadata;
    private final ParsableByteArray nalLength;
    private final ParsableByteArray nalStartCode;
    private int parserState;
    private int sampleBytesRead;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private int sampleTrackIndex;
    private final ParsableByteArray scratch;
    private final SefReader sefReader;
    private final List<Metadata.Entry> slowMotionMetadataEntries;
    private Mp4Track[] tracks;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static final class Mp4Track {
        public int sampleIndex;
        public final TrackSampleTable sampleTable;
        public final Track track;
        public final TrackOutput trackOutput;

        public Mp4Track(Track track2, TrackSampleTable trackSampleTable, TrackOutput trackOutput2) {
            this.track = track2;
            this.sampleTable = trackSampleTable;
            this.trackOutput = trackOutput2;
        }
    }

    public Mp4Extractor() {
        this(0);
    }

    private static int brandToFileType(int i11) {
        if (i11 != 1751476579) {
            return i11 != 1903435808 ? 0 : 1;
        }
        return 2;
    }

    private static long[][] calculateAccumulatedSampleSizes(Mp4Track[] mp4TrackArr) {
        long[][] jArr = new long[mp4TrackArr.length][];
        int[] iArr = new int[mp4TrackArr.length];
        long[] jArr2 = new long[mp4TrackArr.length];
        boolean[] zArr = new boolean[mp4TrackArr.length];
        for (int i11 = 0; i11 < mp4TrackArr.length; i11++) {
            jArr[i11] = new long[mp4TrackArr[i11].sampleTable.sampleCount];
            jArr2[i11] = mp4TrackArr[i11].sampleTable.timestampsUs[0];
        }
        long j11 = 0;
        int i12 = 0;
        while (i12 < mp4TrackArr.length) {
            long j12 = Long.MAX_VALUE;
            int i13 = -1;
            for (int i14 = 0; i14 < mp4TrackArr.length; i14++) {
                if (!zArr[i14] && jArr2[i14] <= j12) {
                    j12 = jArr2[i14];
                    i13 = i14;
                }
            }
            int i15 = iArr[i13];
            jArr[i13][i15] = j11;
            j11 += (long) mp4TrackArr[i13].sampleTable.sizes[i15];
            int i16 = i15 + 1;
            iArr[i13] = i16;
            if (i16 < jArr[i13].length) {
                jArr2[i13] = mp4TrackArr[i13].sampleTable.timestampsUs[i16];
            } else {
                zArr[i13] = true;
                i12++;
            }
        }
        return jArr;
    }

    private void enterReadingAtomHeaderState() {
        this.parserState = 0;
        this.atomHeaderBytesRead = 0;
    }

    private static int getSynchronizationSampleIndex(TrackSampleTable trackSampleTable, long j11) {
        int indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(j11);
        return indexOfEarlierOrEqualSynchronizationSample == -1 ? trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j11) : indexOfEarlierOrEqualSynchronizationSample;
    }

    private int getTrackIndexOfNextReadSample(long j11) {
        int i11 = -1;
        int i12 = -1;
        long j12 = Long.MAX_VALUE;
        boolean z11 = true;
        long j13 = Long.MAX_VALUE;
        boolean z12 = true;
        long j14 = Long.MAX_VALUE;
        for (int i13 = 0; i13 < ((Mp4Track[]) Util.castNonNull(this.tracks)).length; i13++) {
            Mp4Track mp4Track = this.tracks[i13];
            int i14 = mp4Track.sampleIndex;
            TrackSampleTable trackSampleTable = mp4Track.sampleTable;
            if (i14 != trackSampleTable.sampleCount) {
                long j15 = trackSampleTable.offsets[i14];
                long j16 = ((long[][]) Util.castNonNull(this.accumulatedSampleSizes))[i13][i14];
                long j17 = j15 - j11;
                boolean z13 = j17 < 0 || j17 >= 262144;
                if ((!z13 && z12) || (z13 == z12 && j17 < j14)) {
                    z12 = z13;
                    j14 = j17;
                    i12 = i13;
                    j13 = j16;
                }
                if (j16 < j12) {
                    z11 = z13;
                    i11 = i13;
                    j12 = j16;
                }
            }
        }
        return (j12 == Long.MAX_VALUE || !z11 || j13 < j12 + MAXIMUM_READ_AHEAD_BYTES_STREAM) ? i12 : i11;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Track lambda$processMoovAtom$1(Track track) {
        return track;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new Mp4Extractor()};
    }

    private static long maybeAdjustSeekOffset(TrackSampleTable trackSampleTable, long j11, long j12) {
        int synchronizationSampleIndex = getSynchronizationSampleIndex(trackSampleTable, j11);
        if (synchronizationSampleIndex == -1) {
            return j12;
        }
        return Math.min(trackSampleTable.offsets[synchronizationSampleIndex], j12);
    }

    private void maybeSkipRemainingMetaAtomHeaderBytes(ExtractorInput extractorInput) throws IOException {
        this.scratch.reset(8);
        extractorInput.peekFully(this.scratch.getData(), 0, 8);
        AtomParsers.maybeSkipRemainingMetaAtomHeaderBytes(this.scratch);
        extractorInput.skipFully(this.scratch.getPosition());
        extractorInput.resetPeekPosition();
    }

    private void processAtomEnded(long j11) throws ParserException {
        while (!this.containerAtoms.isEmpty() && this.containerAtoms.peek().endPosition == j11) {
            Atom.ContainerAtom pop = this.containerAtoms.pop();
            if (pop.type == 1836019574) {
                processMoovAtom(pop);
                this.containerAtoms.clear();
                this.parserState = 2;
            } else if (!this.containerAtoms.isEmpty()) {
                this.containerAtoms.peek().add(pop);
            }
        }
        if (this.parserState != 2) {
            enterReadingAtomHeaderState();
        }
    }

    private void processEndOfStreamReadingAtomHeader() {
        Metadata metadata;
        if (this.fileType == 2 && (this.flags & 2) != 0) {
            ExtractorOutput extractorOutput2 = (ExtractorOutput) Assertions.checkNotNull(this.extractorOutput);
            TrackOutput track = extractorOutput2.track(0, 4);
            if (this.motionPhotoMetadata == null) {
                metadata = null;
            } else {
                metadata = new Metadata(this.motionPhotoMetadata);
            }
            track.format(new Format.Builder().setMetadata(metadata).build());
            extractorOutput2.endTracks();
            extractorOutput2.seekMap(new SeekMap.Unseekable(-9223372036854775807L));
        }
    }

    private static int processFtypAtom(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        int brandToFileType = brandToFileType(parsableByteArray.readInt());
        if (brandToFileType != 0) {
            return brandToFileType;
        }
        parsableByteArray.skipBytes(4);
        while (parsableByteArray.bytesLeft() > 0) {
            int brandToFileType2 = brandToFileType(parsableByteArray.readInt());
            if (brandToFileType2 != 0) {
                return brandToFileType2;
            }
        }
        return 0;
    }

    private void processMoovAtom(Atom.ContainerAtom containerAtom) throws ParserException {
        Metadata metadata;
        Metadata metadata2;
        int i11;
        List<TrackSampleTable> list;
        ArrayList arrayList;
        int i12;
        Atom.ContainerAtom containerAtom2 = containerAtom;
        ArrayList arrayList2 = new ArrayList();
        boolean z11 = this.fileType == 1;
        GaplessInfoHolder gaplessInfoHolder = new GaplessInfoHolder();
        Atom.LeafAtom leafAtomOfType = containerAtom2.getLeafAtomOfType(Atom.TYPE_udta);
        if (leafAtomOfType != null) {
            Pair<Metadata, Metadata> parseUdta = AtomParsers.parseUdta(leafAtomOfType);
            Metadata metadata3 = (Metadata) parseUdta.first;
            Metadata metadata4 = (Metadata) parseUdta.second;
            if (metadata3 != null) {
                gaplessInfoHolder.setFromMetadata(metadata3);
            }
            metadata2 = metadata4;
            metadata = metadata3;
        } else {
            metadata2 = null;
            metadata = null;
        }
        Atom.ContainerAtom containerAtomOfType = containerAtom2.getContainerAtomOfType(Atom.TYPE_meta);
        Metadata parseMdtaFromMeta = containerAtomOfType != null ? AtomParsers.parseMdtaFromMeta(containerAtomOfType) : null;
        List<TrackSampleTable> parseTraks = AtomParsers.parseTraks(containerAtom, gaplessInfoHolder, -9223372036854775807L, (DrmInitData) null, (this.flags & 1) != 0, z11, d.f65901b);
        ExtractorOutput extractorOutput2 = (ExtractorOutput) Assertions.checkNotNull(this.extractorOutput);
        int size = parseTraks.size();
        int i13 = 0;
        int i14 = -1;
        long j11 = -9223372036854775807L;
        while (i13 < size) {
            TrackSampleTable trackSampleTable = parseTraks.get(i13);
            if (trackSampleTable.sampleCount == 0) {
                list = parseTraks;
                i11 = size;
                arrayList = arrayList2;
            } else {
                Track track = trackSampleTable.track;
                int i15 = i14;
                arrayList = arrayList2;
                long j12 = track.durationUs;
                if (j12 == -9223372036854775807L) {
                    j12 = trackSampleTable.durationUs;
                }
                long max = Math.max(j11, j12);
                list = parseTraks;
                i11 = size;
                Mp4Track mp4Track = new Mp4Track(track, trackSampleTable, extractorOutput2.track(i13, track.type));
                long j13 = max;
                Format.Builder buildUpon = track.format.buildUpon();
                buildUpon.setMaxInputSize(trackSampleTable.maximumSize + 30);
                if (track.type == 2 && j12 > 0 && (i12 = trackSampleTable.sampleCount) > 1) {
                    buildUpon.setFrameRate(((float) i12) / (((float) j12) / 1000000.0f));
                }
                MetadataUtil.setFormatGaplessInfo(track.type, gaplessInfoHolder, buildUpon);
                int i16 = track.type;
                Metadata[] metadataArr = new Metadata[2];
                metadataArr[0] = metadata2;
                metadataArr[1] = this.slowMotionMetadataEntries.isEmpty() ? null : new Metadata((List<? extends Metadata.Entry>) this.slowMotionMetadataEntries);
                MetadataUtil.setFormatMetadata(i16, metadata, parseMdtaFromMeta, buildUpon, metadataArr);
                mp4Track.trackOutput.format(buildUpon.build());
                int i17 = i15;
                if (track.type == 2) {
                    if (i17 == -1) {
                        i14 = arrayList.size();
                        arrayList.add(mp4Track);
                        j11 = j13;
                    }
                }
                i14 = i17;
                arrayList.add(mp4Track);
                j11 = j13;
            }
            i13++;
            arrayList2 = arrayList;
            parseTraks = list;
            size = i11;
        }
        this.firstVideoTrackIndex = i14;
        this.durationUs = j11;
        Mp4Track[] mp4TrackArr = (Mp4Track[]) arrayList2.toArray(new Mp4Track[0]);
        this.tracks = mp4TrackArr;
        this.accumulatedSampleSizes = calculateAccumulatedSampleSizes(mp4TrackArr);
        extractorOutput2.endTracks();
        extractorOutput2.seekMap(this);
    }

    private void processUnparsedAtom(long j11) {
        if (this.atomType == 1836086884) {
            int i11 = this.atomHeaderBytesRead;
            this.motionPhotoMetadata = new MotionPhotoMetadata(0, j11, -9223372036854775807L, j11 + ((long) i11), this.atomSize - ((long) i11));
        }
    }

    private boolean readAtomHeader(ExtractorInput extractorInput) throws IOException {
        Atom.ContainerAtom peek;
        if (this.atomHeaderBytesRead == 0) {
            if (!extractorInput.readFully(this.atomHeader.getData(), 0, 8, true)) {
                processEndOfStreamReadingAtomHeader();
                return false;
            }
            this.atomHeaderBytesRead = 8;
            this.atomHeader.setPosition(0);
            this.atomSize = this.atomHeader.readUnsignedInt();
            this.atomType = this.atomHeader.readInt();
        }
        long j11 = this.atomSize;
        if (j11 == 1) {
            extractorInput.readFully(this.atomHeader.getData(), 8, 8);
            this.atomHeaderBytesRead += 8;
            this.atomSize = this.atomHeader.readUnsignedLongToLong();
        } else if (j11 == 0) {
            long length = extractorInput.getLength();
            if (length == -1 && (peek = this.containerAtoms.peek()) != null) {
                length = peek.endPosition;
            }
            if (length != -1) {
                this.atomSize = (length - extractorInput.getPosition()) + ((long) this.atomHeaderBytesRead);
            }
        }
        if (this.atomSize >= ((long) this.atomHeaderBytesRead)) {
            if (shouldParseContainerAtom(this.atomType)) {
                long position = extractorInput.getPosition();
                long j12 = this.atomSize;
                int i11 = this.atomHeaderBytesRead;
                long j13 = (position + j12) - ((long) i11);
                if (j12 != ((long) i11) && this.atomType == 1835365473) {
                    maybeSkipRemainingMetaAtomHeaderBytes(extractorInput);
                }
                this.containerAtoms.push(new Atom.ContainerAtom(this.atomType, j13));
                if (this.atomSize == ((long) this.atomHeaderBytesRead)) {
                    processAtomEnded(j13);
                } else {
                    enterReadingAtomHeaderState();
                }
            } else if (shouldParseLeafAtom(this.atomType)) {
                Assertions.checkState(this.atomHeaderBytesRead == 8);
                Assertions.checkState(this.atomSize <= 2147483647L);
                ParsableByteArray parsableByteArray = new ParsableByteArray((int) this.atomSize);
                System.arraycopy(this.atomHeader.getData(), 0, parsableByteArray.getData(), 0, 8);
                this.atomData = parsableByteArray;
                this.parserState = 1;
            } else {
                processUnparsedAtom(extractorInput.getPosition() - ((long) this.atomHeaderBytesRead));
                this.atomData = null;
                this.parserState = 1;
            }
            return true;
        }
        throw new ParserException("Atom size less than header length (unsupported).");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean readAtomPayload(com.google.android.exoplayer2.extractor.ExtractorInput r10, com.google.android.exoplayer2.extractor.PositionHolder r11) throws java.io.IOException {
        /*
            r9 = this;
            long r0 = r9.atomSize
            int r2 = r9.atomHeaderBytesRead
            long r2 = (long) r2
            long r0 = r0 - r2
            long r2 = r10.getPosition()
            long r2 = r2 + r0
            com.google.android.exoplayer2.util.ParsableByteArray r4 = r9.atomData
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0044
            byte[] r11 = r4.getData()
            int r7 = r9.atomHeaderBytesRead
            int r0 = (int) r0
            r10.readFully(r11, r7, r0)
            int r10 = r9.atomType
            r11 = 1718909296(0x66747970, float:2.8862439E23)
            if (r10 != r11) goto L_0x0029
            int r10 = processFtypAtom(r4)
            r9.fileType = r10
            goto L_0x004f
        L_0x0029:
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.Atom$ContainerAtom> r10 = r9.containerAtoms
            boolean r10 = r10.isEmpty()
            if (r10 != 0) goto L_0x004f
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.Atom$ContainerAtom> r10 = r9.containerAtoms
            java.lang.Object r10 = r10.peek()
            com.google.android.exoplayer2.extractor.mp4.Atom$ContainerAtom r10 = (com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom) r10
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r11 = new com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom
            int r0 = r9.atomType
            r11.<init>(r0, r4)
            r10.add((com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom) r11)
            goto L_0x004f
        L_0x0044:
            r7 = 262144(0x40000, double:1.295163E-318)
            int r4 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r4 >= 0) goto L_0x0051
            int r11 = (int) r0
            r10.skipFully(r11)
        L_0x004f:
            r10 = r6
            goto L_0x0059
        L_0x0051:
            long r7 = r10.getPosition()
            long r7 = r7 + r0
            r11.position = r7
            r10 = r5
        L_0x0059:
            r9.processAtomEnded(r2)
            if (r10 == 0) goto L_0x0064
            int r10 = r9.parserState
            r11 = 2
            if (r10 == r11) goto L_0x0064
            goto L_0x0065
        L_0x0064:
            r5 = r6
        L_0x0065:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.Mp4Extractor.readAtomPayload(com.google.android.exoplayer2.extractor.ExtractorInput, com.google.android.exoplayer2.extractor.PositionHolder):boolean");
    }

    private int readSample(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        ExtractorInput extractorInput2 = extractorInput;
        long position = extractorInput.getPosition();
        if (this.sampleTrackIndex == -1) {
            int trackIndexOfNextReadSample = getTrackIndexOfNextReadSample(position);
            this.sampleTrackIndex = trackIndexOfNextReadSample;
            if (trackIndexOfNextReadSample == -1) {
                return -1;
            }
        }
        Mp4Track mp4Track = ((Mp4Track[]) Util.castNonNull(this.tracks))[this.sampleTrackIndex];
        TrackOutput trackOutput = mp4Track.trackOutput;
        int i11 = mp4Track.sampleIndex;
        TrackSampleTable trackSampleTable = mp4Track.sampleTable;
        long j11 = trackSampleTable.offsets[i11];
        int i12 = trackSampleTable.sizes[i11];
        long j12 = (j11 - position) + ((long) this.sampleBytesRead);
        if (j12 < 0 || j12 >= 262144) {
            positionHolder.position = j11;
            return 1;
        }
        if (mp4Track.track.sampleTransformation == 1) {
            j12 += 8;
            i12 -= 8;
        }
        extractorInput2.skipFully((int) j12);
        Track track = mp4Track.track;
        if (track.nalUnitLengthFieldLength == 0) {
            if (MimeTypes.AUDIO_AC4.equals(track.format.sampleMimeType)) {
                if (this.sampleBytesWritten == 0) {
                    Ac4Util.getAc4SampleHeader(i12, this.scratch);
                    trackOutput.sampleData(this.scratch, 7);
                    this.sampleBytesWritten += 7;
                }
                i12 += 7;
            }
            while (true) {
                int i13 = this.sampleBytesWritten;
                if (i13 >= i12) {
                    break;
                }
                int sampleData = trackOutput.sampleData((DataReader) extractorInput2, i12 - i13, false);
                this.sampleBytesRead += sampleData;
                this.sampleBytesWritten += sampleData;
                this.sampleCurrentNalBytesRemaining -= sampleData;
            }
        } else {
            byte[] data = this.nalLength.getData();
            data[0] = 0;
            data[1] = 0;
            data[2] = 0;
            int i14 = mp4Track.track.nalUnitLengthFieldLength;
            int i15 = 4 - i14;
            while (this.sampleBytesWritten < i12) {
                int i16 = this.sampleCurrentNalBytesRemaining;
                if (i16 == 0) {
                    extractorInput2.readFully(data, i15, i14);
                    this.sampleBytesRead += i14;
                    this.nalLength.setPosition(0);
                    int readInt = this.nalLength.readInt();
                    if (readInt >= 0) {
                        this.sampleCurrentNalBytesRemaining = readInt;
                        this.nalStartCode.setPosition(0);
                        trackOutput.sampleData(this.nalStartCode, 4);
                        this.sampleBytesWritten += 4;
                        i12 += i15;
                    } else {
                        throw new ParserException("Invalid NAL length");
                    }
                } else {
                    int sampleData2 = trackOutput.sampleData((DataReader) extractorInput2, i16, false);
                    this.sampleBytesRead += sampleData2;
                    this.sampleBytesWritten += sampleData2;
                    this.sampleCurrentNalBytesRemaining -= sampleData2;
                }
            }
        }
        TrackSampleTable trackSampleTable2 = mp4Track.sampleTable;
        trackOutput.sampleMetadata(trackSampleTable2.timestampsUs[i11], trackSampleTable2.flags[i11], i12, 0, (TrackOutput.CryptoData) null);
        mp4Track.sampleIndex++;
        this.sampleTrackIndex = -1;
        this.sampleBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        return 0;
    }

    private int readSefData(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        int read = this.sefReader.read(extractorInput, positionHolder, this.slowMotionMetadataEntries);
        if (read == 1 && positionHolder.position == 0) {
            enterReadingAtomHeaderState();
        }
        return read;
    }

    private static boolean shouldParseContainerAtom(int i11) {
        return i11 == 1836019574 || i11 == 1953653099 || i11 == 1835297121 || i11 == 1835626086 || i11 == 1937007212 || i11 == 1701082227 || i11 == 1835365473;
    }

    private static boolean shouldParseLeafAtom(int i11) {
        return i11 == 1835296868 || i11 == 1836476516 || i11 == 1751411826 || i11 == 1937011556 || i11 == 1937011827 || i11 == 1937011571 || i11 == 1668576371 || i11 == 1701606260 || i11 == 1937011555 || i11 == 1937011578 || i11 == 1937013298 || i11 == 1937007471 || i11 == 1668232756 || i11 == 1953196132 || i11 == 1718909296 || i11 == 1969517665 || i11 == 1801812339 || i11 == 1768715124;
    }

    @RequiresNonNull({"tracks"})
    private void updateSampleIndices(long j11) {
        for (Mp4Track mp4Track : this.tracks) {
            TrackSampleTable trackSampleTable = mp4Track.sampleTable;
            int indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfEarlierOrEqualSynchronizationSample(j11);
            if (indexOfEarlierOrEqualSynchronizationSample == -1) {
                indexOfEarlierOrEqualSynchronizationSample = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j11);
            }
            mp4Track.sampleIndex = indexOfEarlierOrEqualSynchronizationSample;
        }
    }

    public long getDurationUs() {
        return this.durationUs;
    }

    public SeekMap.SeekPoints getSeekPoints(long j11) {
        long j12;
        long j13;
        long j14;
        long j15;
        int indexOfLaterOrEqualSynchronizationSample;
        if (((Mp4Track[]) Assertions.checkNotNull(this.tracks)).length == 0) {
            return new SeekMap.SeekPoints(SeekPoint.START);
        }
        int i11 = this.firstVideoTrackIndex;
        if (i11 != -1) {
            TrackSampleTable trackSampleTable = this.tracks[i11].sampleTable;
            int synchronizationSampleIndex = getSynchronizationSampleIndex(trackSampleTable, j11);
            if (synchronizationSampleIndex == -1) {
                return new SeekMap.SeekPoints(SeekPoint.START);
            }
            long j16 = trackSampleTable.timestampsUs[synchronizationSampleIndex];
            j12 = trackSampleTable.offsets[synchronizationSampleIndex];
            if (j16 >= j11 || synchronizationSampleIndex >= trackSampleTable.sampleCount - 1 || (indexOfLaterOrEqualSynchronizationSample = trackSampleTable.getIndexOfLaterOrEqualSynchronizationSample(j11)) == -1 || indexOfLaterOrEqualSynchronizationSample == synchronizationSampleIndex) {
                j15 = -1;
                j14 = -9223372036854775807L;
            } else {
                j14 = trackSampleTable.timestampsUs[indexOfLaterOrEqualSynchronizationSample];
                j15 = trackSampleTable.offsets[indexOfLaterOrEqualSynchronizationSample];
            }
            j13 = j15;
            j11 = j16;
        } else {
            j12 = Long.MAX_VALUE;
            j13 = -1;
            j14 = -9223372036854775807L;
        }
        int i12 = 0;
        while (true) {
            Mp4Track[] mp4TrackArr = this.tracks;
            if (i12 >= mp4TrackArr.length) {
                break;
            }
            if (i12 != this.firstVideoTrackIndex) {
                TrackSampleTable trackSampleTable2 = mp4TrackArr[i12].sampleTable;
                long maybeAdjustSeekOffset = maybeAdjustSeekOffset(trackSampleTable2, j11, j12);
                if (j14 != -9223372036854775807L) {
                    j13 = maybeAdjustSeekOffset(trackSampleTable2, j14, j13);
                }
                j12 = maybeAdjustSeekOffset;
            }
            i12++;
        }
        SeekPoint seekPoint = new SeekPoint(j11, j12);
        if (j14 == -9223372036854775807L) {
            return new SeekMap.SeekPoints(seekPoint);
        }
        return new SeekMap.SeekPoints(seekPoint, new SeekPoint(j14, j13));
    }

    public void init(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
    }

    public boolean isSeekable() {
        return true;
    }

    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        while (true) {
            int i11 = this.parserState;
            if (i11 != 0) {
                if (i11 != 1) {
                    if (i11 == 2) {
                        return readSample(extractorInput, positionHolder);
                    }
                    if (i11 == 3) {
                        return readSefData(extractorInput, positionHolder);
                    }
                    throw new IllegalStateException();
                } else if (readAtomPayload(extractorInput, positionHolder)) {
                    return 1;
                }
            } else if (!readAtomHeader(extractorInput)) {
                return -1;
            }
        }
    }

    public void release() {
    }

    public void seek(long j11, long j12) {
        this.containerAtoms.clear();
        this.atomHeaderBytesRead = 0;
        this.sampleTrackIndex = -1;
        this.sampleBytesRead = 0;
        this.sampleBytesWritten = 0;
        this.sampleCurrentNalBytesRemaining = 0;
        if (j11 == 0) {
            if (this.parserState != 3) {
                enterReadingAtomHeaderState();
                return;
            }
            this.sefReader.reset();
            this.slowMotionMetadataEntries.clear();
        } else if (this.tracks != null) {
            updateSampleIndices(j12);
        }
    }

    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        return Sniffer.sniffUnfragmented(extractorInput, (this.flags & 2) != 0);
    }

    public Mp4Extractor(int i11) {
        this.flags = i11;
        this.parserState = (i11 & 4) != 0 ? 3 : 0;
        this.sefReader = new SefReader();
        this.slowMotionMetadataEntries = new ArrayList();
        this.atomHeader = new ParsableByteArray(16);
        this.containerAtoms = new ArrayDeque<>();
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalLength = new ParsableByteArray(4);
        this.scratch = new ParsableByteArray();
        this.sampleTrackIndex = -1;
    }
}
