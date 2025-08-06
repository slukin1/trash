package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.ChunkIndex;
import com.google.android.exoplayer2.extractor.Extractor;
import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.PositionHolder;
import com.google.android.exoplayer2.extractor.SeekMap;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.TimestampAdjuster;
import com.google.android.exoplayer2.util.Util;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import org.jmrtd.lds.CVCAFile;

public class FragmentedMp4Extractor implements Extractor {
    private static final Format EMSG_FORMAT = new Format.Builder().setSampleMimeType(MimeTypes.APPLICATION_EMSG).build();
    private static final int EXTRA_TRACKS_BASE_ID = 100;
    public static final ExtractorsFactory FACTORY = a.f65898a;
    public static final int FLAG_ENABLE_EMSG_TRACK = 4;
    public static final int FLAG_WORKAROUND_EVERY_VIDEO_FRAME_IS_SYNC_FRAME = 1;
    public static final int FLAG_WORKAROUND_IGNORE_EDIT_LISTS = 16;
    public static final int FLAG_WORKAROUND_IGNORE_TFDT_BOX = 2;
    private static final byte[] PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE = {-94, 57, 79, 82, 90, -101, 79, 20, -94, ISO7816.INS_REHABILITATE_CHV, 108, CVCAFile.CAR_TAG, 124, 100, ISOFileInfo.ENV_TEMP_EF, -12};
    private static final int SAMPLE_GROUP_TYPE_seig = 1936025959;
    private static final int STATE_READING_ATOM_HEADER = 0;
    private static final int STATE_READING_ATOM_PAYLOAD = 1;
    private static final int STATE_READING_ENCRYPTION_DATA = 2;
    private static final int STATE_READING_SAMPLE_CONTINUE = 4;
    private static final int STATE_READING_SAMPLE_START = 3;
    private static final String TAG = "FragmentedMp4Extractor";
    private final TrackOutput additionalEmsgTrackOutput;
    private ParsableByteArray atomData;
    private final ParsableByteArray atomHeader;
    private int atomHeaderBytesRead;
    private long atomSize;
    private int atomType;
    private TrackOutput[] ceaTrackOutputs;
    private final List<Format> closedCaptionFormats;
    private final ArrayDeque<Atom.ContainerAtom> containerAtoms;
    private TrackBundle currentTrackBundle;
    private long durationUs;
    private TrackOutput[] emsgTrackOutputs;
    private long endOfMdatPosition;
    private final EventMessageEncoder eventMessageEncoder;
    private ExtractorOutput extractorOutput;
    private final int flags;
    private boolean haveOutputSeekMap;
    private final ParsableByteArray nalBuffer;
    private final ParsableByteArray nalPrefix;
    private final ParsableByteArray nalStartCode;
    private int parserState;
    private int pendingMetadataSampleBytes;
    private final ArrayDeque<MetadataSampleInfo> pendingMetadataSampleInfos;
    private long pendingSeekTimeUs;
    private boolean processSeiNalUnitPayload;
    private int sampleBytesWritten;
    private int sampleCurrentNalBytesRemaining;
    private int sampleSize;
    private final ParsableByteArray scratch;
    private final byte[] scratchBytes;
    private long segmentIndexEarliestPresentationTimeUs;
    private final Track sideloadedTrack;
    private final TimestampAdjuster timestampAdjuster;
    private final SparseArray<TrackBundle> trackBundles;

    @Documented
    @Retention(RetentionPolicy.SOURCE)
    public @interface Flags {
    }

    public static final class MetadataSampleInfo {
        public final long presentationTimeDeltaUs;
        public final int size;

        public MetadataSampleInfo(long j11, int i11) {
            this.presentationTimeDeltaUs = j11;
            this.size = i11;
        }
    }

    public static final class TrackBundle {
        private static final int SINGLE_SUBSAMPLE_ENCRYPTION_DATA_LENGTH = 8;
        public int currentSampleInTrackRun;
        public int currentSampleIndex;
        public int currentTrackRunIndex;
        /* access modifiers changed from: private */
        public boolean currentlyInFragment;
        private final ParsableByteArray defaultInitializationVector = new ParsableByteArray();
        public DefaultSampleValues defaultSampleValues;
        private final ParsableByteArray encryptionSignalByte = new ParsableByteArray(1);
        public int firstSampleToOutputIndex;
        public final TrackFragment fragment = new TrackFragment();
        public TrackSampleTable moovSampleTable;
        public final TrackOutput output;
        public final ParsableByteArray scratch = new ParsableByteArray();

        public TrackBundle(TrackOutput trackOutput, TrackSampleTable trackSampleTable, DefaultSampleValues defaultSampleValues2) {
            this.output = trackOutput;
            this.moovSampleTable = trackSampleTable;
            this.defaultSampleValues = defaultSampleValues2;
            reset(trackSampleTable, defaultSampleValues2);
        }

        public int getCurrentSampleFlags() {
            int i11;
            if (!this.currentlyInFragment) {
                i11 = this.moovSampleTable.flags[this.currentSampleIndex];
            } else {
                i11 = this.fragment.sampleIsSyncFrameTable[this.currentSampleIndex] ? 1 : 0;
            }
            return getEncryptionBoxIfEncrypted() != null ? i11 | 1073741824 : i11;
        }

        public long getCurrentSampleOffset() {
            if (!this.currentlyInFragment) {
                return this.moovSampleTable.offsets[this.currentSampleIndex];
            }
            return this.fragment.trunDataPosition[this.currentTrackRunIndex];
        }

        public long getCurrentSamplePresentationTimeUs() {
            if (!this.currentlyInFragment) {
                return this.moovSampleTable.timestampsUs[this.currentSampleIndex];
            }
            return this.fragment.getSamplePresentationTimeUs(this.currentSampleIndex);
        }

        public int getCurrentSampleSize() {
            if (!this.currentlyInFragment) {
                return this.moovSampleTable.sizes[this.currentSampleIndex];
            }
            return this.fragment.sampleSizeTable[this.currentSampleIndex];
        }

        public TrackEncryptionBox getEncryptionBoxIfEncrypted() {
            if (!this.currentlyInFragment) {
                return null;
            }
            int i11 = ((DefaultSampleValues) Util.castNonNull(this.fragment.header)).sampleDescriptionIndex;
            TrackEncryptionBox trackEncryptionBox = this.fragment.trackEncryptionBox;
            if (trackEncryptionBox == null) {
                trackEncryptionBox = this.moovSampleTable.track.getSampleDescriptionEncryptionBox(i11);
            }
            if (trackEncryptionBox == null || !trackEncryptionBox.isEncrypted) {
                return null;
            }
            return trackEncryptionBox;
        }

        public boolean next() {
            this.currentSampleIndex++;
            if (!this.currentlyInFragment) {
                return false;
            }
            int i11 = this.currentSampleInTrackRun + 1;
            this.currentSampleInTrackRun = i11;
            int[] iArr = this.fragment.trunLength;
            int i12 = this.currentTrackRunIndex;
            if (i11 != iArr[i12]) {
                return true;
            }
            this.currentTrackRunIndex = i12 + 1;
            this.currentSampleInTrackRun = 0;
            return false;
        }

        public int outputSampleEncryptionData(int i11, int i12) {
            ParsableByteArray parsableByteArray;
            TrackEncryptionBox encryptionBoxIfEncrypted = getEncryptionBoxIfEncrypted();
            if (encryptionBoxIfEncrypted == null) {
                return 0;
            }
            int i13 = encryptionBoxIfEncrypted.perSampleIvSize;
            if (i13 != 0) {
                parsableByteArray = this.fragment.sampleEncryptionData;
            } else {
                byte[] bArr = (byte[]) Util.castNonNull(encryptionBoxIfEncrypted.defaultInitializationVector);
                this.defaultInitializationVector.reset(bArr, bArr.length);
                ParsableByteArray parsableByteArray2 = this.defaultInitializationVector;
                i13 = bArr.length;
                parsableByteArray = parsableByteArray2;
            }
            boolean sampleHasSubsampleEncryptionTable = this.fragment.sampleHasSubsampleEncryptionTable(this.currentSampleIndex);
            boolean z11 = sampleHasSubsampleEncryptionTable || i12 != 0;
            this.encryptionSignalByte.getData()[0] = (byte) ((z11 ? 128 : 0) | i13);
            this.encryptionSignalByte.setPosition(0);
            this.output.sampleData(this.encryptionSignalByte, 1, 1);
            this.output.sampleData(parsableByteArray, i13, 1);
            if (!z11) {
                return i13 + 1;
            }
            if (!sampleHasSubsampleEncryptionTable) {
                this.scratch.reset(8);
                byte[] data = this.scratch.getData();
                data[0] = 0;
                data[1] = 1;
                data[2] = (byte) ((i12 >> 8) & 255);
                data[3] = (byte) (i12 & 255);
                data[4] = (byte) ((i11 >> 24) & 255);
                data[5] = (byte) ((i11 >> 16) & 255);
                data[6] = (byte) ((i11 >> 8) & 255);
                data[7] = (byte) (i11 & 255);
                this.output.sampleData(this.scratch, 8, 1);
                return i13 + 1 + 8;
            }
            ParsableByteArray parsableByteArray3 = this.fragment.sampleEncryptionData;
            int readUnsignedShort = parsableByteArray3.readUnsignedShort();
            parsableByteArray3.skipBytes(-2);
            int i14 = (readUnsignedShort * 6) + 2;
            if (i12 != 0) {
                this.scratch.reset(i14);
                byte[] data2 = this.scratch.getData();
                parsableByteArray3.readBytes(data2, 0, i14);
                int i15 = (((data2[2] & 255) << 8) | (data2[3] & 255)) + i12;
                data2[2] = (byte) ((i15 >> 8) & 255);
                data2[3] = (byte) (i15 & 255);
                parsableByteArray3 = this.scratch;
            }
            this.output.sampleData(parsableByteArray3, i14, 1);
            return i13 + 1 + i14;
        }

        public void reset(TrackSampleTable trackSampleTable, DefaultSampleValues defaultSampleValues2) {
            this.moovSampleTable = trackSampleTable;
            this.defaultSampleValues = defaultSampleValues2;
            this.output.format(trackSampleTable.track.format);
            resetFragmentInfo();
        }

        public void resetFragmentInfo() {
            this.fragment.reset();
            this.currentSampleIndex = 0;
            this.currentTrackRunIndex = 0;
            this.currentSampleInTrackRun = 0;
            this.firstSampleToOutputIndex = 0;
            this.currentlyInFragment = false;
        }

        public void seek(long j11) {
            int i11 = this.currentSampleIndex;
            while (true) {
                TrackFragment trackFragment = this.fragment;
                if (i11 < trackFragment.sampleCount && trackFragment.getSamplePresentationTimeUs(i11) < j11) {
                    if (this.fragment.sampleIsSyncFrameTable[i11]) {
                        this.firstSampleToOutputIndex = i11;
                    }
                    i11++;
                } else {
                    return;
                }
            }
        }

        public void skipSampleEncryptionData() {
            TrackEncryptionBox encryptionBoxIfEncrypted = getEncryptionBoxIfEncrypted();
            if (encryptionBoxIfEncrypted != null) {
                ParsableByteArray parsableByteArray = this.fragment.sampleEncryptionData;
                int i11 = encryptionBoxIfEncrypted.perSampleIvSize;
                if (i11 != 0) {
                    parsableByteArray.skipBytes(i11);
                }
                if (this.fragment.sampleHasSubsampleEncryptionTable(this.currentSampleIndex)) {
                    parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort() * 6);
                }
            }
        }

        public void updateDrmInitData(DrmInitData drmInitData) {
            TrackEncryptionBox sampleDescriptionEncryptionBox = this.moovSampleTable.track.getSampleDescriptionEncryptionBox(((DefaultSampleValues) Util.castNonNull(this.fragment.header)).sampleDescriptionIndex);
            this.output.format(this.moovSampleTable.track.format.buildUpon().setDrmInitData(drmInitData.copyWithSchemeType(sampleDescriptionEncryptionBox != null ? sampleDescriptionEncryptionBox.schemeType : null)).build());
        }
    }

    public FragmentedMp4Extractor() {
        this(0);
    }

    private static int checkNonNegative(int i11) throws ParserException {
        if (i11 >= 0) {
            return i11;
        }
        StringBuilder sb2 = new StringBuilder(38);
        sb2.append("Unexpected negative value: ");
        sb2.append(i11);
        throw new ParserException(sb2.toString());
    }

    private void enterReadingAtomHeaderState() {
        this.parserState = 0;
        this.atomHeaderBytesRead = 0;
    }

    private DefaultSampleValues getDefaultSampleValues(SparseArray<DefaultSampleValues> sparseArray, int i11) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return (DefaultSampleValues) Assertions.checkNotNull(sparseArray.get(i11));
    }

    private static DrmInitData getDrmInitDataFromAtoms(List<Atom.LeafAtom> list) {
        int size = list.size();
        ArrayList arrayList = null;
        for (int i11 = 0; i11 < size; i11++) {
            Atom.LeafAtom leafAtom = list.get(i11);
            if (leafAtom.type == 1886614376) {
                if (arrayList == null) {
                    arrayList = new ArrayList();
                }
                byte[] data = leafAtom.data.getData();
                UUID parseUuid = PsshAtomUtil.parseUuid(data);
                if (parseUuid == null) {
                    Log.w(TAG, "Skipped pssh atom (failed to extract uuid)");
                } else {
                    arrayList.add(new DrmInitData.SchemeData(parseUuid, "video/mp4", data));
                }
            }
        }
        if (arrayList == null) {
            return null;
        }
        return new DrmInitData((List<DrmInitData.SchemeData>) arrayList);
    }

    private static TrackBundle getNextTrackBundle(SparseArray<TrackBundle> sparseArray) {
        int size = sparseArray.size();
        TrackBundle trackBundle = null;
        long j11 = Long.MAX_VALUE;
        for (int i11 = 0; i11 < size; i11++) {
            TrackBundle valueAt = sparseArray.valueAt(i11);
            if ((valueAt.currentlyInFragment || valueAt.currentSampleIndex != valueAt.moovSampleTable.sampleCount) && (!valueAt.currentlyInFragment || valueAt.currentTrackRunIndex != valueAt.fragment.trunCount)) {
                long currentSampleOffset = valueAt.getCurrentSampleOffset();
                if (currentSampleOffset < j11) {
                    trackBundle = valueAt;
                    j11 = currentSampleOffset;
                }
            }
        }
        return trackBundle;
    }

    private static TrackBundle getTrackBundle(SparseArray<TrackBundle> sparseArray, int i11) {
        if (sparseArray.size() == 1) {
            return sparseArray.valueAt(0);
        }
        return sparseArray.get(i11);
    }

    private void initExtraTracks() {
        int i11;
        TrackOutput[] trackOutputArr = new TrackOutput[2];
        this.emsgTrackOutputs = trackOutputArr;
        TrackOutput trackOutput = this.additionalEmsgTrackOutput;
        int i12 = 0;
        if (trackOutput != null) {
            trackOutputArr[0] = trackOutput;
            i11 = 1;
        } else {
            i11 = 0;
        }
        int i13 = 100;
        if ((this.flags & 4) != 0) {
            trackOutputArr[i11] = this.extractorOutput.track(100, 5);
            i11++;
            i13 = 101;
        }
        TrackOutput[] trackOutputArr2 = (TrackOutput[]) Util.nullSafeArrayCopy(this.emsgTrackOutputs, i11);
        this.emsgTrackOutputs = trackOutputArr2;
        for (TrackOutput format : trackOutputArr2) {
            format.format(EMSG_FORMAT);
        }
        this.ceaTrackOutputs = new TrackOutput[this.closedCaptionFormats.size()];
        while (i12 < this.ceaTrackOutputs.length) {
            TrackOutput track = this.extractorOutput.track(i13, 3);
            track.format(this.closedCaptionFormats.get(i12));
            this.ceaTrackOutputs[i12] = track;
            i12++;
            i13++;
        }
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ Extractor[] lambda$static$0() {
        return new Extractor[]{new FragmentedMp4Extractor()};
    }

    private void onContainerAtomRead(Atom.ContainerAtom containerAtom) throws ParserException {
        int i11 = containerAtom.type;
        if (i11 == 1836019574) {
            onMoovContainerAtomRead(containerAtom);
        } else if (i11 == 1836019558) {
            onMoofContainerAtomRead(containerAtom);
        } else if (!this.containerAtoms.isEmpty()) {
            this.containerAtoms.peek().add(containerAtom);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v4, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r9v1, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void onEmsgLeafAtomRead(com.google.android.exoplayer2.util.ParsableByteArray r27) {
        /*
            r26 = this;
            r0 = r26
            r1 = r27
            com.google.android.exoplayer2.extractor.TrackOutput[] r2 = r0.emsgTrackOutputs
            int r2 = r2.length
            if (r2 != 0) goto L_0x000a
            return
        L_0x000a:
            r2 = 8
            r1.setPosition(r2)
            int r2 = r27.readInt()
            int r2 = com.google.android.exoplayer2.extractor.mp4.Atom.parseFullAtomVersion(r2)
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            if (r2 == 0) goto L_0x0076
            r5 = 1
            if (r2 == r5) goto L_0x003a
            r1 = 46
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r1)
            java.lang.String r1 = "Skipping unsupported emsg version: "
            r3.append(r1)
            r3.append(r2)
            java.lang.String r1 = r3.toString()
            java.lang.String r2 = "FragmentedMp4Extractor"
            com.google.android.exoplayer2.util.Log.w(r2, r1)
            return
        L_0x003a:
            long r11 = r27.readUnsignedInt()
            long r5 = r27.readUnsignedLongToLong()
            r7 = 1000000(0xf4240, double:4.940656E-318)
            r9 = r11
            long r13 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r5, r7, r9)
            long r5 = r27.readUnsignedInt()
            r7 = 1000(0x3e8, double:4.94E-321)
            long r5 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r5, r7, r9)
            long r7 = r27.readUnsignedInt()
            java.lang.String r2 = r27.readNullTerminatedString()
            java.lang.Object r2 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r9 = r27.readNullTerminatedString()
            java.lang.Object r9 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r9)
            java.lang.String r9 = (java.lang.String) r9
            r19 = r2
            r21 = r5
            r23 = r7
            r20 = r9
            r7 = r3
            goto L_0x00c0
        L_0x0076:
            java.lang.String r2 = r27.readNullTerminatedString()
            java.lang.Object r2 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r5 = r27.readNullTerminatedString()
            java.lang.Object r5 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r5)
            r9 = r5
            java.lang.String r9 = (java.lang.String) r9
            long r5 = r27.readUnsignedInt()
            long r10 = r27.readUnsignedInt()
            r12 = 1000000(0xf4240, double:4.940656E-318)
            r14 = r5
            long r7 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r10, r12, r14)
            long r10 = r0.segmentIndexEarliestPresentationTimeUs
            int r12 = (r10 > r3 ? 1 : (r10 == r3 ? 0 : -1))
            if (r12 == 0) goto L_0x00a5
            long r10 = r10 + r7
            r16 = r10
            goto L_0x00a7
        L_0x00a5:
            r16 = r3
        L_0x00a7:
            long r10 = r27.readUnsignedInt()
            r12 = 1000(0x3e8, double:4.94E-321)
            r14 = r5
            long r5 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r10, r12, r14)
            long r10 = r27.readUnsignedInt()
            r19 = r2
            r21 = r5
            r20 = r9
            r23 = r10
            r13 = r16
        L_0x00c0:
            int r2 = r27.bytesLeft()
            byte[] r2 = new byte[r2]
            int r5 = r27.bytesLeft()
            r6 = 0
            r1.readBytes(r2, r6, r5)
            com.google.android.exoplayer2.metadata.emsg.EventMessage r1 = new com.google.android.exoplayer2.metadata.emsg.EventMessage
            r18 = r1
            r25 = r2
            r18.<init>(r19, r20, r21, r23, r25)
            com.google.android.exoplayer2.util.ParsableByteArray r2 = new com.google.android.exoplayer2.util.ParsableByteArray
            com.google.android.exoplayer2.metadata.emsg.EventMessageEncoder r5 = r0.eventMessageEncoder
            byte[] r1 = r5.encode(r1)
            r2.<init>((byte[]) r1)
            int r1 = r2.bytesLeft()
            com.google.android.exoplayer2.extractor.TrackOutput[] r5 = r0.emsgTrackOutputs
            int r9 = r5.length
            r10 = r6
        L_0x00ea:
            if (r10 >= r9) goto L_0x00f7
            r11 = r5[r10]
            r2.setPosition(r6)
            r11.sampleData(r2, r1)
            int r10 = r10 + 1
            goto L_0x00ea
        L_0x00f7:
            int r2 = (r13 > r3 ? 1 : (r13 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x010b
            java.util.ArrayDeque<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo> r2 = r0.pendingMetadataSampleInfos
            com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo r3 = new com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$MetadataSampleInfo
            r3.<init>(r7, r1)
            r2.addLast(r3)
            int r2 = r0.pendingMetadataSampleBytes
            int r2 = r2 + r1
            r0.pendingMetadataSampleBytes = r2
            goto L_0x012a
        L_0x010b:
            com.google.android.exoplayer2.util.TimestampAdjuster r2 = r0.timestampAdjuster
            if (r2 == 0) goto L_0x0113
            long r13 = r2.adjustSampleTimestamp(r13)
        L_0x0113:
            com.google.android.exoplayer2.extractor.TrackOutput[] r2 = r0.emsgTrackOutputs
            int r3 = r2.length
        L_0x0116:
            if (r6 >= r3) goto L_0x012a
            r15 = r2[r6]
            r18 = 1
            r20 = 0
            r21 = 0
            r16 = r13
            r19 = r1
            r15.sampleMetadata(r16, r18, r19, r20, r21)
            int r6 = r6 + 1
            goto L_0x0116
        L_0x012a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.onEmsgLeafAtomRead(com.google.android.exoplayer2.util.ParsableByteArray):void");
    }

    private void onLeafAtomRead(Atom.LeafAtom leafAtom, long j11) throws ParserException {
        if (!this.containerAtoms.isEmpty()) {
            this.containerAtoms.peek().add(leafAtom);
            return;
        }
        int i11 = leafAtom.type;
        if (i11 == 1936286840) {
            Pair<Long, ChunkIndex> parseSidx = parseSidx(leafAtom.data, j11);
            this.segmentIndexEarliestPresentationTimeUs = ((Long) parseSidx.first).longValue();
            this.extractorOutput.seekMap((SeekMap) parseSidx.second);
            this.haveOutputSeekMap = true;
        } else if (i11 == 1701671783) {
            onEmsgLeafAtomRead(leafAtom.data);
        }
    }

    private void onMoofContainerAtomRead(Atom.ContainerAtom containerAtom) throws ParserException {
        parseMoof(containerAtom, this.trackBundles, this.flags, this.scratchBytes);
        DrmInitData drmInitDataFromAtoms = getDrmInitDataFromAtoms(containerAtom.leafChildren);
        if (drmInitDataFromAtoms != null) {
            int size = this.trackBundles.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.trackBundles.valueAt(i11).updateDrmInitData(drmInitDataFromAtoms);
            }
        }
        if (this.pendingSeekTimeUs != -9223372036854775807L) {
            int size2 = this.trackBundles.size();
            for (int i12 = 0; i12 < size2; i12++) {
                this.trackBundles.valueAt(i12).seek(this.pendingSeekTimeUs);
            }
            this.pendingSeekTimeUs = -9223372036854775807L;
        }
    }

    private void onMoovContainerAtomRead(Atom.ContainerAtom containerAtom) throws ParserException {
        boolean z11 = true;
        int i11 = 0;
        Assertions.checkState(this.sideloadedTrack == null, "Unexpected moov box.");
        DrmInitData drmInitDataFromAtoms = getDrmInitDataFromAtoms(containerAtom.leafChildren);
        Atom.ContainerAtom containerAtom2 = (Atom.ContainerAtom) Assertions.checkNotNull(containerAtom.getContainerAtomOfType(Atom.TYPE_mvex));
        SparseArray sparseArray = new SparseArray();
        int size = containerAtom2.leafChildren.size();
        long j11 = -9223372036854775807L;
        for (int i12 = 0; i12 < size; i12++) {
            Atom.LeafAtom leafAtom = containerAtom2.leafChildren.get(i12);
            int i13 = leafAtom.type;
            if (i13 == 1953654136) {
                Pair<Integer, DefaultSampleValues> parseTrex = parseTrex(leafAtom.data);
                sparseArray.put(((Integer) parseTrex.first).intValue(), (DefaultSampleValues) parseTrex.second);
            } else if (i13 == 1835362404) {
                j11 = parseMehd(leafAtom.data);
            }
        }
        List<TrackSampleTable> parseTraks = AtomParsers.parseTraks(containerAtom, new GaplessInfoHolder(), j11, drmInitDataFromAtoms, (this.flags & 16) != 0, false, new b(this));
        int size2 = parseTraks.size();
        if (this.trackBundles.size() == 0) {
            while (i11 < size2) {
                TrackSampleTable trackSampleTable = parseTraks.get(i11);
                Track track = trackSampleTable.track;
                this.trackBundles.put(track.f65897id, new TrackBundle(this.extractorOutput.track(i11, track.type), trackSampleTable, getDefaultSampleValues(sparseArray, track.f65897id)));
                this.durationUs = Math.max(this.durationUs, track.durationUs);
                i11++;
            }
            this.extractorOutput.endTracks();
            return;
        }
        if (this.trackBundles.size() != size2) {
            z11 = false;
        }
        Assertions.checkState(z11);
        while (i11 < size2) {
            TrackSampleTable trackSampleTable2 = parseTraks.get(i11);
            Track track2 = trackSampleTable2.track;
            this.trackBundles.get(track2.f65897id).reset(trackSampleTable2, getDefaultSampleValues(sparseArray, track2.f65897id));
            i11++;
        }
    }

    private void outputPendingMetadataSamples(long j11) {
        while (!this.pendingMetadataSampleInfos.isEmpty()) {
            MetadataSampleInfo removeFirst = this.pendingMetadataSampleInfos.removeFirst();
            this.pendingMetadataSampleBytes -= removeFirst.size;
            long j12 = removeFirst.presentationTimeDeltaUs + j11;
            TimestampAdjuster timestampAdjuster2 = this.timestampAdjuster;
            if (timestampAdjuster2 != null) {
                j12 = timestampAdjuster2.adjustSampleTimestamp(j12);
            }
            for (TrackOutput sampleMetadata : this.emsgTrackOutputs) {
                sampleMetadata.sampleMetadata(j12, 1, removeFirst.size, this.pendingMetadataSampleBytes, (TrackOutput.CryptoData) null);
            }
        }
    }

    private static long parseMehd(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        return Atom.parseFullAtomVersion(parsableByteArray.readInt()) == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
    }

    private static void parseMoof(Atom.ContainerAtom containerAtom, SparseArray<TrackBundle> sparseArray, int i11, byte[] bArr) throws ParserException {
        int size = containerAtom.containerChildren.size();
        for (int i12 = 0; i12 < size; i12++) {
            Atom.ContainerAtom containerAtom2 = containerAtom.containerChildren.get(i12);
            if (containerAtom2.type == 1953653094) {
                parseTraf(containerAtom2, sparseArray, i11, bArr);
            }
        }
    }

    private static void parseSaio(ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        parsableByteArray.setPosition(8);
        int readInt = parsableByteArray.readInt();
        if ((Atom.parseFullAtomFlags(readInt) & 1) == 1) {
            parsableByteArray.skipBytes(8);
        }
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (readUnsignedIntToInt == 1) {
            trackFragment.auxiliaryDataPosition += Atom.parseFullAtomVersion(readInt) == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
            return;
        }
        StringBuilder sb2 = new StringBuilder(40);
        sb2.append("Unexpected saio entry count: ");
        sb2.append(readUnsignedIntToInt);
        throw new ParserException(sb2.toString());
    }

    private static void parseSaiz(TrackEncryptionBox trackEncryptionBox, ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        int i11;
        int i12 = trackEncryptionBox.perSampleIvSize;
        parsableByteArray.setPosition(8);
        boolean z11 = true;
        if ((Atom.parseFullAtomFlags(parsableByteArray.readInt()) & 1) == 1) {
            parsableByteArray.skipBytes(8);
        }
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        if (readUnsignedIntToInt <= trackFragment.sampleCount) {
            if (readUnsignedByte == 0) {
                boolean[] zArr = trackFragment.sampleHasSubsampleEncryptionTable;
                i11 = 0;
                for (int i13 = 0; i13 < readUnsignedIntToInt; i13++) {
                    int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                    i11 += readUnsignedByte2;
                    zArr[i13] = readUnsignedByte2 > i12;
                }
            } else {
                if (readUnsignedByte <= i12) {
                    z11 = false;
                }
                i11 = (readUnsignedByte * readUnsignedIntToInt) + 0;
                Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, readUnsignedIntToInt, z11);
            }
            Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, readUnsignedIntToInt, trackFragment.sampleCount, false);
            if (i11 > 0) {
                trackFragment.initEncryptionData(i11);
                return;
            }
            return;
        }
        int i14 = trackFragment.sampleCount;
        StringBuilder sb2 = new StringBuilder(78);
        sb2.append("Saiz sample count ");
        sb2.append(readUnsignedIntToInt);
        sb2.append(" is greater than fragment sample count");
        sb2.append(i14);
        throw new ParserException(sb2.toString());
    }

    private static void parseSampleGroups(Atom.ContainerAtom containerAtom, String str, TrackFragment trackFragment) throws ParserException {
        Atom.ContainerAtom containerAtom2 = containerAtom;
        TrackFragment trackFragment2 = trackFragment;
        byte[] bArr = null;
        ParsableByteArray parsableByteArray = null;
        ParsableByteArray parsableByteArray2 = null;
        for (int i11 = 0; i11 < containerAtom2.leafChildren.size(); i11++) {
            Atom.LeafAtom leafAtom = containerAtom2.leafChildren.get(i11);
            ParsableByteArray parsableByteArray3 = leafAtom.data;
            int i12 = leafAtom.type;
            if (i12 == 1935828848) {
                parsableByteArray3.setPosition(12);
                if (parsableByteArray3.readInt() == SAMPLE_GROUP_TYPE_seig) {
                    parsableByteArray = parsableByteArray3;
                }
            } else if (i12 == 1936158820) {
                parsableByteArray3.setPosition(12);
                if (parsableByteArray3.readInt() == SAMPLE_GROUP_TYPE_seig) {
                    parsableByteArray2 = parsableByteArray3;
                }
            }
        }
        if (parsableByteArray != null && parsableByteArray2 != null) {
            parsableByteArray.setPosition(8);
            int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
            parsableByteArray.skipBytes(4);
            if (parseFullAtomVersion == 1) {
                parsableByteArray.skipBytes(4);
            }
            if (parsableByteArray.readInt() == 1) {
                parsableByteArray2.setPosition(8);
                int parseFullAtomVersion2 = Atom.parseFullAtomVersion(parsableByteArray2.readInt());
                parsableByteArray2.skipBytes(4);
                if (parseFullAtomVersion2 == 1) {
                    if (parsableByteArray2.readUnsignedInt() == 0) {
                        throw new ParserException("Variable length description in sgpd found (unsupported)");
                    }
                } else if (parseFullAtomVersion2 >= 2) {
                    parsableByteArray2.skipBytes(4);
                }
                if (parsableByteArray2.readUnsignedInt() == 1) {
                    parsableByteArray2.skipBytes(1);
                    int readUnsignedByte = parsableByteArray2.readUnsignedByte();
                    int i13 = (readUnsignedByte & 240) >> 4;
                    int i14 = readUnsignedByte & 15;
                    boolean z11 = parsableByteArray2.readUnsignedByte() == 1;
                    if (z11) {
                        int readUnsignedByte2 = parsableByteArray2.readUnsignedByte();
                        byte[] bArr2 = new byte[16];
                        parsableByteArray2.readBytes(bArr2, 0, 16);
                        if (readUnsignedByte2 == 0) {
                            int readUnsignedByte3 = parsableByteArray2.readUnsignedByte();
                            bArr = new byte[readUnsignedByte3];
                            parsableByteArray2.readBytes(bArr, 0, readUnsignedByte3);
                        }
                        trackFragment2.definesEncryptionData = true;
                        trackFragment2.trackEncryptionBox = new TrackEncryptionBox(z11, str, readUnsignedByte2, bArr2, i13, i14, bArr);
                        return;
                    }
                    return;
                }
                throw new ParserException("Entry count in sgpd != 1 (unsupported).");
            }
            throw new ParserException("Entry count in sbgp != 1 (unsupported).");
        }
    }

    private static void parseSenc(ParsableByteArray parsableByteArray, TrackFragment trackFragment) throws ParserException {
        parseSenc(parsableByteArray, 0, trackFragment);
    }

    private static Pair<Long, ChunkIndex> parseSidx(ParsableByteArray parsableByteArray, long j11) throws ParserException {
        long j12;
        long j13;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        parsableByteArray2.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray2.skipBytes(4);
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        if (parseFullAtomVersion == 0) {
            j13 = parsableByteArray.readUnsignedInt();
            j12 = parsableByteArray.readUnsignedInt();
        } else {
            j13 = parsableByteArray.readUnsignedLongToLong();
            j12 = parsableByteArray.readUnsignedLongToLong();
        }
        long j14 = j13;
        long j15 = j11 + j12;
        long scaleLargeTimestamp = Util.scaleLargeTimestamp(j14, 1000000, readUnsignedInt);
        parsableByteArray2.skipBytes(2);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int[] iArr = new int[readUnsignedShort];
        long[] jArr = new long[readUnsignedShort];
        long[] jArr2 = new long[readUnsignedShort];
        long[] jArr3 = new long[readUnsignedShort];
        long j16 = scaleLargeTimestamp;
        long j17 = j14;
        int i11 = 0;
        long j18 = j17;
        while (i11 < readUnsignedShort) {
            int readInt = parsableByteArray.readInt();
            if ((readInt & Integer.MIN_VALUE) == 0) {
                long readUnsignedInt2 = parsableByteArray.readUnsignedInt();
                iArr[i11] = readInt & Integer.MAX_VALUE;
                jArr[i11] = j15;
                jArr3[i11] = j16;
                long j19 = j18 + readUnsignedInt2;
                long[] jArr4 = jArr2;
                long[] jArr5 = jArr3;
                int i12 = readUnsignedShort;
                int[] iArr2 = iArr;
                long scaleLargeTimestamp2 = Util.scaleLargeTimestamp(j19, 1000000, readUnsignedInt);
                jArr4[i11] = scaleLargeTimestamp2 - jArr5[i11];
                parsableByteArray2.skipBytes(4);
                j15 += (long) iArr2[i11];
                i11++;
                iArr = iArr2;
                jArr3 = jArr5;
                jArr2 = jArr4;
                jArr = jArr;
                readUnsignedShort = i12;
                long j21 = scaleLargeTimestamp2;
                j18 = j19;
                j16 = j21;
            } else {
                throw new ParserException("Unhandled indirect reference");
            }
        }
        return Pair.create(Long.valueOf(scaleLargeTimestamp), new ChunkIndex(iArr, jArr, jArr2, jArr3));
    }

    private static long parseTfdt(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(8);
        return Atom.parseFullAtomVersion(parsableByteArray.readInt()) == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
    }

    private static TrackBundle parseTfhd(ParsableByteArray parsableByteArray, SparseArray<TrackBundle> sparseArray) {
        int i11;
        int i12;
        int i13;
        int i14;
        parsableByteArray.setPosition(8);
        int parseFullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
        TrackBundle trackBundle = getTrackBundle(sparseArray, parsableByteArray.readInt());
        if (trackBundle == null) {
            return null;
        }
        if ((parseFullAtomFlags & 1) != 0) {
            long readUnsignedLongToLong = parsableByteArray.readUnsignedLongToLong();
            TrackFragment trackFragment = trackBundle.fragment;
            trackFragment.dataPosition = readUnsignedLongToLong;
            trackFragment.auxiliaryDataPosition = readUnsignedLongToLong;
        }
        DefaultSampleValues defaultSampleValues = trackBundle.defaultSampleValues;
        if ((parseFullAtomFlags & 2) != 0) {
            i11 = parsableByteArray.readInt() - 1;
        } else {
            i11 = defaultSampleValues.sampleDescriptionIndex;
        }
        if ((parseFullAtomFlags & 8) != 0) {
            i12 = parsableByteArray.readInt();
        } else {
            i12 = defaultSampleValues.duration;
        }
        if ((parseFullAtomFlags & 16) != 0) {
            i13 = parsableByteArray.readInt();
        } else {
            i13 = defaultSampleValues.size;
        }
        if ((parseFullAtomFlags & 32) != 0) {
            i14 = parsableByteArray.readInt();
        } else {
            i14 = defaultSampleValues.flags;
        }
        trackBundle.fragment.header = new DefaultSampleValues(i11, i12, i13, i14);
        return trackBundle;
    }

    private static void parseTraf(Atom.ContainerAtom containerAtom, SparseArray<TrackBundle> sparseArray, int i11, byte[] bArr) throws ParserException {
        TrackBundle parseTfhd = parseTfhd(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(Atom.TYPE_tfhd))).data, sparseArray);
        if (parseTfhd != null) {
            TrackFragment trackFragment = parseTfhd.fragment;
            long j11 = trackFragment.nextFragmentDecodeTime;
            boolean z11 = trackFragment.nextFragmentDecodeTimeIncludesMoov;
            parseTfhd.resetFragmentInfo();
            boolean unused = parseTfhd.currentlyInFragment = true;
            Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_tfdt);
            if (leafAtomOfType == null || (i11 & 2) != 0) {
                trackFragment.nextFragmentDecodeTime = j11;
                trackFragment.nextFragmentDecodeTimeIncludesMoov = z11;
            } else {
                trackFragment.nextFragmentDecodeTime = parseTfdt(leafAtomOfType.data);
                trackFragment.nextFragmentDecodeTimeIncludesMoov = true;
            }
            parseTruns(containerAtom, parseTfhd, i11);
            TrackEncryptionBox sampleDescriptionEncryptionBox = parseTfhd.moovSampleTable.track.getSampleDescriptionEncryptionBox(((DefaultSampleValues) Assertions.checkNotNull(trackFragment.header)).sampleDescriptionIndex);
            Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(Atom.TYPE_saiz);
            if (leafAtomOfType2 != null) {
                parseSaiz((TrackEncryptionBox) Assertions.checkNotNull(sampleDescriptionEncryptionBox), leafAtomOfType2.data, trackFragment);
            }
            Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_saio);
            if (leafAtomOfType3 != null) {
                parseSaio(leafAtomOfType3.data, trackFragment);
            }
            Atom.LeafAtom leafAtomOfType4 = containerAtom.getLeafAtomOfType(Atom.TYPE_senc);
            if (leafAtomOfType4 != null) {
                parseSenc(leafAtomOfType4.data, trackFragment);
            }
            parseSampleGroups(containerAtom, sampleDescriptionEncryptionBox != null ? sampleDescriptionEncryptionBox.schemeType : null, trackFragment);
            int size = containerAtom.leafChildren.size();
            for (int i12 = 0; i12 < size; i12++) {
                Atom.LeafAtom leafAtom = containerAtom.leafChildren.get(i12);
                if (leafAtom.type == 1970628964) {
                    parseUuid(leafAtom.data, trackFragment, bArr);
                }
            }
        }
    }

    private static Pair<Integer, DefaultSampleValues> parseTrex(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(12);
        return Pair.create(Integer.valueOf(parsableByteArray.readInt()), new DefaultSampleValues(parsableByteArray.readInt() - 1, parsableByteArray.readInt(), parsableByteArray.readInt(), parsableByteArray.readInt()));
    }

    /* JADX WARNING: Removed duplicated region for block: B:39:0x00a7  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x00bf  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int parseTrun(com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.TrackBundle r36, int r37, int r38, com.google.android.exoplayer2.util.ParsableByteArray r39, int r40) throws com.google.android.exoplayer2.ParserException {
        /*
            r0 = r36
            r1 = 8
            r2 = r39
            r2.setPosition(r1)
            int r1 = r39.readInt()
            int r1 = com.google.android.exoplayer2.extractor.mp4.Atom.parseFullAtomFlags(r1)
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r3 = r0.moovSampleTable
            com.google.android.exoplayer2.extractor.mp4.Track r3 = r3.track
            com.google.android.exoplayer2.extractor.mp4.TrackFragment r4 = r0.fragment
            com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues r5 = r4.header
            java.lang.Object r5 = com.google.android.exoplayer2.util.Util.castNonNull(r5)
            com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues r5 = (com.google.android.exoplayer2.extractor.mp4.DefaultSampleValues) r5
            int[] r6 = r4.trunLength
            int r7 = r39.readUnsignedIntToInt()
            r6[r37] = r7
            long[] r6 = r4.trunDataPosition
            long r7 = r4.dataPosition
            r6[r37] = r7
            r7 = r1 & 1
            if (r7 == 0) goto L_0x003b
            r7 = r6[r37]
            int r9 = r39.readInt()
            long r9 = (long) r9
            long r7 = r7 + r9
            r6[r37] = r7
        L_0x003b:
            r6 = r1 & 4
            r7 = 0
            r8 = 1
            if (r6 == 0) goto L_0x0043
            r6 = r8
            goto L_0x0044
        L_0x0043:
            r6 = r7
        L_0x0044:
            int r9 = r5.flags
            if (r6 == 0) goto L_0x004c
            int r9 = r39.readInt()
        L_0x004c:
            r10 = r1 & 256(0x100, float:3.59E-43)
            if (r10 == 0) goto L_0x0052
            r10 = r8
            goto L_0x0053
        L_0x0052:
            r10 = r7
        L_0x0053:
            r11 = r1 & 512(0x200, float:7.175E-43)
            if (r11 == 0) goto L_0x0059
            r11 = r8
            goto L_0x005a
        L_0x0059:
            r11 = r7
        L_0x005a:
            r12 = r1 & 1024(0x400, float:1.435E-42)
            if (r12 == 0) goto L_0x0060
            r12 = r8
            goto L_0x0061
        L_0x0060:
            r12 = r7
        L_0x0061:
            r1 = r1 & 2048(0x800, float:2.87E-42)
            if (r1 == 0) goto L_0x0067
            r1 = r8
            goto L_0x0068
        L_0x0067:
            r1 = r7
        L_0x0068:
            long[] r13 = r3.editListDurations
            if (r13 == 0) goto L_0x008d
            int r14 = r13.length
            if (r14 != r8) goto L_0x008d
            r14 = r13[r7]
            r16 = 0
            int r13 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r13 != 0) goto L_0x008f
            long[] r13 = r3.editListMediaTimes
            java.lang.Object r13 = com.google.android.exoplayer2.util.Util.castNonNull(r13)
            long[] r13 = (long[]) r13
            r14 = r13[r7]
            r16 = 1000000(0xf4240, double:4.940656E-318)
            long r7 = r3.timescale
            r18 = r7
            long r14 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r14, r16, r18)
            goto L_0x0091
        L_0x008d:
            r16 = 0
        L_0x008f:
            r14 = r16
        L_0x0091:
            int[] r7 = r4.sampleSizeTable
            int[] r8 = r4.sampleCompositionTimeOffsetUsTable
            long[] r13 = r4.sampleDecodingTimeUsTable
            boolean[] r2 = r4.sampleIsSyncFrameTable
            r17 = r9
            int r9 = r3.type
            r18 = r2
            r2 = 2
            if (r9 != r2) goto L_0x00a9
            r2 = 1
            r9 = r38 & 1
            if (r9 == 0) goto L_0x00a9
            r2 = 1
            goto L_0x00aa
        L_0x00a9:
            r2 = 0
        L_0x00aa:
            int[] r9 = r4.trunLength
            r9 = r9[r37]
            int r9 = r40 + r9
            r38 = r2
            long r2 = r3.timescale
            r27 = r14
            r15 = r13
            long r13 = r4.nextFragmentDecodeTime
            r29 = r13
            r13 = r40
        L_0x00bd:
            if (r13 >= r9) goto L_0x0163
            if (r10 == 0) goto L_0x00c6
            int r14 = r39.readInt()
            goto L_0x00c8
        L_0x00c6:
            int r14 = r5.duration
        L_0x00c8:
            int r14 = checkNonNegative(r14)
            if (r11 == 0) goto L_0x00d9
            int r19 = r39.readInt()
            r35 = r19
            r19 = r10
            r10 = r35
            goto L_0x00dd
        L_0x00d9:
            r19 = r10
            int r10 = r5.size
        L_0x00dd:
            int r10 = checkNonNegative(r10)
            if (r12 == 0) goto L_0x00ec
            int r21 = r39.readInt()
            r31 = r6
            r6 = r21
            goto L_0x00f9
        L_0x00ec:
            if (r13 != 0) goto L_0x00f5
            if (r6 == 0) goto L_0x00f5
            r31 = r6
            r6 = r17
            goto L_0x00f9
        L_0x00f5:
            r31 = r6
            int r6 = r5.flags
        L_0x00f9:
            if (r1 == 0) goto L_0x0112
            r32 = r1
            int r1 = r39.readInt()
            r33 = r11
            r34 = r12
            long r11 = (long) r1
            r21 = 1000000(0xf4240, double:4.940656E-318)
            long r11 = r11 * r21
            long r11 = r11 / r2
            int r1 = (int) r11
            r8[r13] = r1
            r16 = 0
            goto L_0x011c
        L_0x0112:
            r32 = r1
            r33 = r11
            r34 = r12
            r16 = 0
            r8[r13] = r16
        L_0x011c:
            r23 = 1000000(0xf4240, double:4.940656E-318)
            r21 = r29
            r25 = r2
            long r11 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r21, r23, r25)
            long r11 = r11 - r27
            r15[r13] = r11
            boolean r1 = r4.nextFragmentDecodeTimeIncludesMoov
            if (r1 != 0) goto L_0x0138
            r11 = r15[r13]
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r1 = r0.moovSampleTable
            long r0 = r1.durationUs
            long r11 = r11 + r0
            r15[r13] = r11
        L_0x0138:
            r7[r13] = r10
            int r0 = r6 >> 16
            r1 = 1
            r0 = r0 & r1
            if (r0 != 0) goto L_0x0146
            if (r38 == 0) goto L_0x0144
            if (r13 != 0) goto L_0x0146
        L_0x0144:
            r0 = r1
            goto L_0x0148
        L_0x0146:
            r0 = r16
        L_0x0148:
            r18[r13] = r0
            long r10 = (long) r14
            r20 = r2
            r1 = r29
            long r29 = r1 + r10
            int r13 = r13 + 1
            r0 = r36
            r10 = r19
            r2 = r20
            r6 = r31
            r1 = r32
            r11 = r33
            r12 = r34
            goto L_0x00bd
        L_0x0163:
            r1 = r29
            r4.nextFragmentDecodeTime = r1
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.parseTrun(com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$TrackBundle, int, int, com.google.android.exoplayer2.util.ParsableByteArray, int):int");
    }

    private static void parseTruns(Atom.ContainerAtom containerAtom, TrackBundle trackBundle, int i11) throws ParserException {
        List<Atom.LeafAtom> list = containerAtom.leafChildren;
        int size = list.size();
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < size; i14++) {
            Atom.LeafAtom leafAtom = list.get(i14);
            if (leafAtom.type == 1953658222) {
                ParsableByteArray parsableByteArray = leafAtom.data;
                parsableByteArray.setPosition(12);
                int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
                if (readUnsignedIntToInt > 0) {
                    i13 += readUnsignedIntToInt;
                    i12++;
                }
            }
        }
        trackBundle.currentTrackRunIndex = 0;
        trackBundle.currentSampleInTrackRun = 0;
        trackBundle.currentSampleIndex = 0;
        trackBundle.fragment.initTables(i12, i13);
        int i15 = 0;
        int i16 = 0;
        for (int i17 = 0; i17 < size; i17++) {
            Atom.LeafAtom leafAtom2 = list.get(i17);
            if (leafAtom2.type == 1953658222) {
                i16 = parseTrun(trackBundle, i15, i11, leafAtom2.data, i16);
                i15++;
            }
        }
    }

    private static void parseUuid(ParsableByteArray parsableByteArray, TrackFragment trackFragment, byte[] bArr) throws ParserException {
        parsableByteArray.setPosition(8);
        parsableByteArray.readBytes(bArr, 0, 16);
        if (Arrays.equals(bArr, PIFF_SAMPLE_ENCRYPTION_BOX_EXTENDED_TYPE)) {
            parseSenc(parsableByteArray, 16, trackFragment);
        }
    }

    private void processAtomEnded(long j11) throws ParserException {
        while (!this.containerAtoms.isEmpty() && this.containerAtoms.peek().endPosition == j11) {
            onContainerAtomRead(this.containerAtoms.pop());
        }
        enterReadingAtomHeaderState();
    }

    private boolean readAtomHeader(ExtractorInput extractorInput) throws IOException {
        if (this.atomHeaderBytesRead == 0) {
            if (!extractorInput.readFully(this.atomHeader.getData(), 0, 8, true)) {
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
            if (length == -1 && !this.containerAtoms.isEmpty()) {
                length = this.containerAtoms.peek().endPosition;
            }
            if (length != -1) {
                this.atomSize = (length - extractorInput.getPosition()) + ((long) this.atomHeaderBytesRead);
            }
        }
        if (this.atomSize >= ((long) this.atomHeaderBytesRead)) {
            long position = extractorInput.getPosition() - ((long) this.atomHeaderBytesRead);
            int i11 = this.atomType;
            if ((i11 == 1836019558 || i11 == 1835295092) && !this.haveOutputSeekMap) {
                this.extractorOutput.seekMap(new SeekMap.Unseekable(this.durationUs, position));
                this.haveOutputSeekMap = true;
            }
            if (this.atomType == 1836019558) {
                int size = this.trackBundles.size();
                for (int i12 = 0; i12 < size; i12++) {
                    TrackFragment trackFragment = this.trackBundles.valueAt(i12).fragment;
                    trackFragment.atomPosition = position;
                    trackFragment.auxiliaryDataPosition = position;
                    trackFragment.dataPosition = position;
                }
            }
            int i13 = this.atomType;
            if (i13 == 1835295092) {
                this.currentTrackBundle = null;
                this.endOfMdatPosition = position + this.atomSize;
                this.parserState = 2;
                return true;
            }
            if (shouldParseContainerAtom(i13)) {
                long position2 = (extractorInput.getPosition() + this.atomSize) - 8;
                this.containerAtoms.push(new Atom.ContainerAtom(this.atomType, position2));
                if (this.atomSize == ((long) this.atomHeaderBytesRead)) {
                    processAtomEnded(position2);
                } else {
                    enterReadingAtomHeaderState();
                }
            } else if (shouldParseLeafAtom(this.atomType)) {
                if (this.atomHeaderBytesRead == 8) {
                    long j12 = this.atomSize;
                    if (j12 <= 2147483647L) {
                        ParsableByteArray parsableByteArray = new ParsableByteArray((int) j12);
                        System.arraycopy(this.atomHeader.getData(), 0, parsableByteArray.getData(), 0, 8);
                        this.atomData = parsableByteArray;
                        this.parserState = 1;
                    } else {
                        throw new ParserException("Leaf atom with length > 2147483647 (unsupported).");
                    }
                } else {
                    throw new ParserException("Leaf atom defines extended atom size (unsupported).");
                }
            } else if (this.atomSize <= 2147483647L) {
                this.atomData = null;
                this.parserState = 1;
            } else {
                throw new ParserException("Skipping atom with length > 2147483647 (unsupported).");
            }
            return true;
        }
        throw new ParserException("Atom size less than header length (unsupported).");
    }

    private void readAtomPayload(ExtractorInput extractorInput) throws IOException {
        int i11 = ((int) this.atomSize) - this.atomHeaderBytesRead;
        ParsableByteArray parsableByteArray = this.atomData;
        if (parsableByteArray != null) {
            extractorInput.readFully(parsableByteArray.getData(), 8, i11);
            onLeafAtomRead(new Atom.LeafAtom(this.atomType, parsableByteArray), extractorInput.getPosition());
        } else {
            extractorInput.skipFully(i11);
        }
        processAtomEnded(extractorInput.getPosition());
    }

    private void readEncryptionData(ExtractorInput extractorInput) throws IOException {
        int size = this.trackBundles.size();
        TrackBundle trackBundle = null;
        long j11 = Long.MAX_VALUE;
        for (int i11 = 0; i11 < size; i11++) {
            TrackFragment trackFragment = this.trackBundles.valueAt(i11).fragment;
            if (trackFragment.sampleEncryptionDataNeedsFill) {
                long j12 = trackFragment.auxiliaryDataPosition;
                if (j12 < j11) {
                    trackBundle = this.trackBundles.valueAt(i11);
                    j11 = j12;
                }
            }
        }
        if (trackBundle == null) {
            this.parserState = 3;
            return;
        }
        int position = (int) (j11 - extractorInput.getPosition());
        if (position >= 0) {
            extractorInput.skipFully(position);
            trackBundle.fragment.fillEncryptionData(extractorInput);
            return;
        }
        throw new ParserException("Offset to encryption data was negative.");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v0, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v1, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r8v3, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v19, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v25, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v29, resolved type: boolean} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean readSample(com.google.android.exoplayer2.extractor.ExtractorInput r17) throws java.io.IOException {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$TrackBundle r2 = r0.currentTrackBundle
            r3 = 0
            if (r2 != 0) goto L_0x0043
            android.util.SparseArray<com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$TrackBundle> r2 = r0.trackBundles
            com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor$TrackBundle r2 = getNextTrackBundle(r2)
            if (r2 != 0) goto L_0x002a
            long r4 = r0.endOfMdatPosition
            long r6 = r17.getPosition()
            long r4 = r4 - r6
            int r2 = (int) r4
            if (r2 < 0) goto L_0x0022
            r1.skipFully(r2)
            r16.enterReadingAtomHeaderState()
            return r3
        L_0x0022:
            com.google.android.exoplayer2.ParserException r1 = new com.google.android.exoplayer2.ParserException
            java.lang.String r2 = "Offset to end of mdat was negative."
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x002a:
            long r4 = r2.getCurrentSampleOffset()
            long r6 = r17.getPosition()
            long r4 = r4 - r6
            int r4 = (int) r4
            if (r4 >= 0) goto L_0x003e
            java.lang.String r4 = "FragmentedMp4Extractor"
            java.lang.String r5 = "Ignoring negative offset to sample data."
            com.google.android.exoplayer2.util.Log.w(r4, r5)
            r4 = r3
        L_0x003e:
            r1.skipFully(r4)
            r0.currentTrackBundle = r2
        L_0x0043:
            int r4 = r0.parserState
            r5 = 0
            r6 = 3
            r7 = 4
            r8 = 1
            if (r4 != r6) goto L_0x00b8
            int r4 = r2.getCurrentSampleSize()
            r0.sampleSize = r4
            int r9 = r2.currentSampleIndex
            int r10 = r2.firstSampleToOutputIndex
            if (r9 >= r10) goto L_0x0068
            r1.skipFully(r4)
            r2.skipSampleEncryptionData()
            boolean r1 = r2.next()
            if (r1 != 0) goto L_0x0065
            r0.currentTrackBundle = r5
        L_0x0065:
            r0.parserState = r6
            return r8
        L_0x0068:
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r9 = r2.moovSampleTable
            com.google.android.exoplayer2.extractor.mp4.Track r9 = r9.track
            int r9 = r9.sampleTransformation
            if (r9 != r8) goto L_0x0078
            r9 = 8
            int r4 = r4 - r9
            r0.sampleSize = r4
            r1.skipFully(r9)
        L_0x0078:
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r4 = r2.moovSampleTable
            com.google.android.exoplayer2.extractor.mp4.Track r4 = r4.track
            com.google.android.exoplayer2.Format r4 = r4.format
            java.lang.String r4 = r4.sampleMimeType
            java.lang.String r9 = "audio/ac4"
            boolean r4 = r9.equals(r4)
            if (r4 == 0) goto L_0x00a5
            int r4 = r0.sampleSize
            r9 = 7
            int r4 = r2.outputSampleEncryptionData(r4, r9)
            r0.sampleBytesWritten = r4
            int r4 = r0.sampleSize
            com.google.android.exoplayer2.util.ParsableByteArray r10 = r0.scratch
            com.google.android.exoplayer2.audio.Ac4Util.getAc4SampleHeader(r4, r10)
            com.google.android.exoplayer2.extractor.TrackOutput r4 = r2.output
            com.google.android.exoplayer2.util.ParsableByteArray r10 = r0.scratch
            r4.sampleData(r10, r9)
            int r4 = r0.sampleBytesWritten
            int r4 = r4 + r9
            r0.sampleBytesWritten = r4
            goto L_0x00ad
        L_0x00a5:
            int r4 = r0.sampleSize
            int r4 = r2.outputSampleEncryptionData(r4, r3)
            r0.sampleBytesWritten = r4
        L_0x00ad:
            int r4 = r0.sampleSize
            int r9 = r0.sampleBytesWritten
            int r4 = r4 + r9
            r0.sampleSize = r4
            r0.parserState = r7
            r0.sampleCurrentNalBytesRemaining = r3
        L_0x00b8:
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r4 = r2.moovSampleTable
            com.google.android.exoplayer2.extractor.mp4.Track r4 = r4.track
            com.google.android.exoplayer2.extractor.TrackOutput r9 = r2.output
            long r10 = r2.getCurrentSamplePresentationTimeUs()
            com.google.android.exoplayer2.util.TimestampAdjuster r12 = r0.timestampAdjuster
            if (r12 == 0) goto L_0x00ca
            long r10 = r12.adjustSampleTimestamp(r10)
        L_0x00ca:
            r14 = r10
            int r10 = r4.nalUnitLengthFieldLength
            if (r10 == 0) goto L_0x0198
            com.google.android.exoplayer2.util.ParsableByteArray r10 = r0.nalPrefix
            byte[] r10 = r10.getData()
            r10[r3] = r3
            r10[r8] = r3
            r11 = 2
            r10[r11] = r3
            int r11 = r4.nalUnitLengthFieldLength
            int r12 = r11 + 1
            int r11 = 4 - r11
        L_0x00e2:
            int r13 = r0.sampleBytesWritten
            int r6 = r0.sampleSize
            if (r13 >= r6) goto L_0x01a9
            int r6 = r0.sampleCurrentNalBytesRemaining
            if (r6 != 0) goto L_0x013a
            r1.readFully(r10, r11, r12)
            com.google.android.exoplayer2.util.ParsableByteArray r6 = r0.nalPrefix
            r6.setPosition(r3)
            com.google.android.exoplayer2.util.ParsableByteArray r6 = r0.nalPrefix
            int r6 = r6.readInt()
            if (r6 < r8) goto L_0x0132
            int r6 = r6 + -1
            r0.sampleCurrentNalBytesRemaining = r6
            com.google.android.exoplayer2.util.ParsableByteArray r6 = r0.nalStartCode
            r6.setPosition(r3)
            com.google.android.exoplayer2.util.ParsableByteArray r6 = r0.nalStartCode
            r9.sampleData(r6, r7)
            com.google.android.exoplayer2.util.ParsableByteArray r6 = r0.nalPrefix
            r9.sampleData(r6, r8)
            com.google.android.exoplayer2.extractor.TrackOutput[] r6 = r0.ceaTrackOutputs
            int r6 = r6.length
            if (r6 <= 0) goto L_0x0122
            com.google.android.exoplayer2.Format r6 = r4.format
            java.lang.String r6 = r6.sampleMimeType
            byte r13 = r10[r7]
            boolean r6 = com.google.android.exoplayer2.util.NalUnitUtil.isNalUnitSei(r6, r13)
            if (r6 == 0) goto L_0x0122
            r6 = r8
            goto L_0x0123
        L_0x0122:
            r6 = r3
        L_0x0123:
            r0.processSeiNalUnitPayload = r6
            int r6 = r0.sampleBytesWritten
            int r6 = r6 + 5
            r0.sampleBytesWritten = r6
            int r6 = r0.sampleSize
            int r6 = r6 + r11
            r0.sampleSize = r6
            r6 = 3
            goto L_0x00e2
        L_0x0132:
            com.google.android.exoplayer2.ParserException r1 = new com.google.android.exoplayer2.ParserException
            java.lang.String r2 = "Invalid NAL length"
            r1.<init>((java.lang.String) r2)
            throw r1
        L_0x013a:
            boolean r13 = r0.processSeiNalUnitPayload
            if (r13 == 0) goto L_0x0184
            com.google.android.exoplayer2.util.ParsableByteArray r13 = r0.nalBuffer
            r13.reset((int) r6)
            com.google.android.exoplayer2.util.ParsableByteArray r6 = r0.nalBuffer
            byte[] r6 = r6.getData()
            int r13 = r0.sampleCurrentNalBytesRemaining
            r1.readFully(r6, r3, r13)
            com.google.android.exoplayer2.util.ParsableByteArray r6 = r0.nalBuffer
            int r13 = r0.sampleCurrentNalBytesRemaining
            r9.sampleData(r6, r13)
            int r6 = r0.sampleCurrentNalBytesRemaining
            com.google.android.exoplayer2.util.ParsableByteArray r13 = r0.nalBuffer
            byte[] r13 = r13.getData()
            com.google.android.exoplayer2.util.ParsableByteArray r7 = r0.nalBuffer
            int r7 = r7.limit()
            int r7 = com.google.android.exoplayer2.util.NalUnitUtil.unescapeStream(r13, r7)
            com.google.android.exoplayer2.util.ParsableByteArray r13 = r0.nalBuffer
            com.google.android.exoplayer2.Format r8 = r4.format
            java.lang.String r8 = r8.sampleMimeType
            java.lang.String r5 = "video/hevc"
            boolean r5 = r5.equals(r8)
            r13.setPosition(r5)
            com.google.android.exoplayer2.util.ParsableByteArray r5 = r0.nalBuffer
            r5.setLimit(r7)
            com.google.android.exoplayer2.util.ParsableByteArray r5 = r0.nalBuffer
            com.google.android.exoplayer2.extractor.TrackOutput[] r7 = r0.ceaTrackOutputs
            com.google.android.exoplayer2.extractor.CeaUtil.consume(r14, r5, r7)
            goto L_0x0188
        L_0x0184:
            int r6 = r9.sampleData((com.google.android.exoplayer2.upstream.DataReader) r1, (int) r6, (boolean) r3)
        L_0x0188:
            int r5 = r0.sampleBytesWritten
            int r5 = r5 + r6
            r0.sampleBytesWritten = r5
            int r5 = r0.sampleCurrentNalBytesRemaining
            int r5 = r5 - r6
            r0.sampleCurrentNalBytesRemaining = r5
            r5 = 0
            r6 = 3
            r7 = 4
            r8 = 1
            goto L_0x00e2
        L_0x0198:
            int r4 = r0.sampleBytesWritten
            int r5 = r0.sampleSize
            if (r4 >= r5) goto L_0x01a9
            int r5 = r5 - r4
            int r4 = r9.sampleData((com.google.android.exoplayer2.upstream.DataReader) r1, (int) r5, (boolean) r3)
            int r5 = r0.sampleBytesWritten
            int r5 = r5 + r4
            r0.sampleBytesWritten = r5
            goto L_0x0198
        L_0x01a9:
            int r12 = r2.getCurrentSampleFlags()
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox r1 = r2.getEncryptionBoxIfEncrypted()
            if (r1 == 0) goto L_0x01b6
            com.google.android.exoplayer2.extractor.TrackOutput$CryptoData r1 = r1.cryptoData
            goto L_0x01b7
        L_0x01b6:
            r1 = 0
        L_0x01b7:
            int r13 = r0.sampleSize
            r3 = 0
            r10 = r14
            r4 = r14
            r14 = r3
            r15 = r1
            r9.sampleMetadata(r10, r12, r13, r14, r15)
            r0.outputPendingMetadataSamples(r4)
            boolean r1 = r2.next()
            if (r1 != 0) goto L_0x01cd
            r1 = 0
            r0.currentTrackBundle = r1
        L_0x01cd:
            r1 = 3
            r0.parserState = r1
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.FragmentedMp4Extractor.readSample(com.google.android.exoplayer2.extractor.ExtractorInput):boolean");
    }

    private static boolean shouldParseContainerAtom(int i11) {
        return i11 == 1836019574 || i11 == 1953653099 || i11 == 1835297121 || i11 == 1835626086 || i11 == 1937007212 || i11 == 1836019558 || i11 == 1953653094 || i11 == 1836475768 || i11 == 1701082227;
    }

    private static boolean shouldParseLeafAtom(int i11) {
        return i11 == 1751411826 || i11 == 1835296868 || i11 == 1836476516 || i11 == 1936286840 || i11 == 1937011556 || i11 == 1937011827 || i11 == 1668576371 || i11 == 1937011555 || i11 == 1937011578 || i11 == 1937013298 || i11 == 1937007471 || i11 == 1668232756 || i11 == 1937011571 || i11 == 1952867444 || i11 == 1952868452 || i11 == 1953196132 || i11 == 1953654136 || i11 == 1953658222 || i11 == 1886614376 || i11 == 1935763834 || i11 == 1935763823 || i11 == 1936027235 || i11 == 1970628964 || i11 == 1935828848 || i11 == 1936158820 || i11 == 1701606260 || i11 == 1835362404 || i11 == 1701671783;
    }

    public void init(ExtractorOutput extractorOutput2) {
        this.extractorOutput = extractorOutput2;
        enterReadingAtomHeaderState();
        initExtraTracks();
        Track track = this.sideloadedTrack;
        if (track != null) {
            this.trackBundles.put(0, new TrackBundle(extractorOutput2.track(0, track.type), new TrackSampleTable(this.sideloadedTrack, new long[0], new int[0], 0, new long[0], new int[0], 0), new DefaultSampleValues(0, 0, 0, 0)));
            this.extractorOutput.endTracks();
        }
    }

    public Track modifyTrack(Track track) {
        return track;
    }

    public int read(ExtractorInput extractorInput, PositionHolder positionHolder) throws IOException {
        while (true) {
            int i11 = this.parserState;
            if (i11 != 0) {
                if (i11 == 1) {
                    readAtomPayload(extractorInput);
                } else if (i11 == 2) {
                    readEncryptionData(extractorInput);
                } else if (readSample(extractorInput)) {
                    return 0;
                }
            } else if (!readAtomHeader(extractorInput)) {
                return -1;
            }
        }
    }

    public void release() {
    }

    public void seek(long j11, long j12) {
        int size = this.trackBundles.size();
        for (int i11 = 0; i11 < size; i11++) {
            this.trackBundles.valueAt(i11).resetFragmentInfo();
        }
        this.pendingMetadataSampleInfos.clear();
        this.pendingMetadataSampleBytes = 0;
        this.pendingSeekTimeUs = j12;
        this.containerAtoms.clear();
        enterReadingAtomHeaderState();
    }

    public boolean sniff(ExtractorInput extractorInput) throws IOException {
        return Sniffer.sniffFragmented(extractorInput);
    }

    public FragmentedMp4Extractor(int i11) {
        this(i11, (TimestampAdjuster) null);
    }

    private static void parseSenc(ParsableByteArray parsableByteArray, int i11, TrackFragment trackFragment) throws ParserException {
        parsableByteArray.setPosition(i11 + 8);
        int parseFullAtomFlags = Atom.parseFullAtomFlags(parsableByteArray.readInt());
        if ((parseFullAtomFlags & 1) == 0) {
            boolean z11 = (parseFullAtomFlags & 2) != 0;
            int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if (readUnsignedIntToInt == 0) {
                Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, trackFragment.sampleCount, false);
            } else if (readUnsignedIntToInt == trackFragment.sampleCount) {
                Arrays.fill(trackFragment.sampleHasSubsampleEncryptionTable, 0, readUnsignedIntToInt, z11);
                trackFragment.initEncryptionData(parsableByteArray.bytesLeft());
                trackFragment.fillEncryptionData(parsableByteArray);
            } else {
                int i12 = trackFragment.sampleCount;
                StringBuilder sb2 = new StringBuilder(80);
                sb2.append("Senc sample count ");
                sb2.append(readUnsignedIntToInt);
                sb2.append(" is different from fragment sample count");
                sb2.append(i12);
                throw new ParserException(sb2.toString());
            }
        } else {
            throw new ParserException("Overriding TrackEncryptionBox parameters is unsupported.");
        }
    }

    public FragmentedMp4Extractor(int i11, TimestampAdjuster timestampAdjuster2) {
        this(i11, timestampAdjuster2, (Track) null, Collections.emptyList());
    }

    public FragmentedMp4Extractor(int i11, TimestampAdjuster timestampAdjuster2, Track track) {
        this(i11, timestampAdjuster2, track, Collections.emptyList());
    }

    public FragmentedMp4Extractor(int i11, TimestampAdjuster timestampAdjuster2, Track track, List<Format> list) {
        this(i11, timestampAdjuster2, track, list, (TrackOutput) null);
    }

    public FragmentedMp4Extractor(int i11, TimestampAdjuster timestampAdjuster2, Track track, List<Format> list, TrackOutput trackOutput) {
        this.flags = i11;
        this.timestampAdjuster = timestampAdjuster2;
        this.sideloadedTrack = track;
        this.closedCaptionFormats = Collections.unmodifiableList(list);
        this.additionalEmsgTrackOutput = trackOutput;
        this.eventMessageEncoder = new EventMessageEncoder();
        this.atomHeader = new ParsableByteArray(16);
        this.nalStartCode = new ParsableByteArray(NalUnitUtil.NAL_START_CODE);
        this.nalPrefix = new ParsableByteArray(5);
        this.nalBuffer = new ParsableByteArray();
        byte[] bArr = new byte[16];
        this.scratchBytes = bArr;
        this.scratch = new ParsableByteArray(bArr);
        this.containerAtoms = new ArrayDeque<>();
        this.pendingMetadataSampleInfos = new ArrayDeque<>();
        this.trackBundles = new SparseArray<>();
        this.durationUs = -9223372036854775807L;
        this.pendingSeekTimeUs = -9223372036854775807L;
        this.segmentIndexEarliestPresentationTimeUs = -9223372036854775807L;
        this.extractorOutput = ExtractorOutput.PLACEHOLDER;
        this.emsgTrackOutputs = new TrackOutput[0];
        this.ceaTrackOutputs = new TrackOutput[0];
    }
}
