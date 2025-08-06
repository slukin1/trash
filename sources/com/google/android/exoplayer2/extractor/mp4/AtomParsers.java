package com.google.android.exoplayer2.extractor.mp4;

import android.util.Pair;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.ParserException;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.extractor.GaplessInfoHolder;
import com.google.android.exoplayer2.extractor.mp4.Atom;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.mp4.MdtaMetadataEntry;
import com.google.android.exoplayer2.metadata.mp4.SmtaMetadataEntry;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.video.AvcConfig;
import com.google.android.exoplayer2.video.DolbyVisionConfig;
import com.google.android.exoplayer2.video.HevcConfig;
import com.google.common.base.Function;
import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class AtomParsers {
    private static final int MAX_GAPLESS_TRIM_SIZE_SAMPLES = 4;
    private static final String TAG = "AtomParsers";
    private static final int TYPE_clcp = 1668047728;
    private static final int TYPE_mdta = 1835299937;
    private static final int TYPE_meta = 1835365473;
    private static final int TYPE_sbtl = 1935832172;
    private static final int TYPE_soun = 1936684398;
    private static final int TYPE_subt = 1937072756;
    private static final int TYPE_text = 1952807028;
    private static final int TYPE_vide = 1986618469;
    private static final byte[] opusMagic = Util.getUtf8Bytes("OpusHead");

    public static final class ChunkIterator {
        private final ParsableByteArray chunkOffsets;
        private final boolean chunkOffsetsAreLongs;
        public int index;
        public final int length;
        private int nextSamplesPerChunkChangeIndex;
        public int numSamples;
        public long offset;
        private int remainingSamplesPerChunkChanges;
        private final ParsableByteArray stsc;

        public ChunkIterator(ParsableByteArray parsableByteArray, ParsableByteArray parsableByteArray2, boolean z11) {
            this.stsc = parsableByteArray;
            this.chunkOffsets = parsableByteArray2;
            this.chunkOffsetsAreLongs = z11;
            parsableByteArray2.setPosition(12);
            this.length = parsableByteArray2.readUnsignedIntToInt();
            parsableByteArray.setPosition(12);
            this.remainingSamplesPerChunkChanges = parsableByteArray.readUnsignedIntToInt();
            Assertions.checkState(parsableByteArray.readInt() != 1 ? false : true, "first_chunk must be 1");
            this.index = -1;
        }

        public boolean moveNext() {
            long j11;
            int i11 = this.index + 1;
            this.index = i11;
            if (i11 == this.length) {
                return false;
            }
            if (this.chunkOffsetsAreLongs) {
                j11 = this.chunkOffsets.readUnsignedLongToLong();
            } else {
                j11 = this.chunkOffsets.readUnsignedInt();
            }
            this.offset = j11;
            if (this.index == this.nextSamplesPerChunkChangeIndex) {
                this.numSamples = this.stsc.readUnsignedIntToInt();
                this.stsc.skipBytes(4);
                int i12 = this.remainingSamplesPerChunkChanges - 1;
                this.remainingSamplesPerChunkChanges = i12;
                this.nextSamplesPerChunkChangeIndex = i12 > 0 ? this.stsc.readUnsignedIntToInt() - 1 : -1;
            }
            return true;
        }
    }

    public interface SampleSizeBox {
        int getFixedSampleSize();

        int getSampleCount();

        int readNextSampleSize();
    }

    public static final class StsdData {
        public static final int STSD_HEADER_SIZE = 8;
        public Format format;
        public int nalUnitLengthFieldLength;
        public int requiredSampleTransformation = 0;
        public final TrackEncryptionBox[] trackEncryptionBoxes;

        public StsdData(int i11) {
            this.trackEncryptionBoxes = new TrackEncryptionBox[i11];
        }
    }

    public static final class StszSampleSizeBox implements SampleSizeBox {
        private final ParsableByteArray data;
        private final int fixedSampleSize;
        private final int sampleCount;

        public StszSampleSizeBox(Atom.LeafAtom leafAtom, Format format) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
            if (MimeTypes.AUDIO_RAW.equals(format.sampleMimeType)) {
                int pcmFrameSize = Util.getPcmFrameSize(format.pcmEncoding, format.channelCount);
                if (readUnsignedIntToInt == 0 || readUnsignedIntToInt % pcmFrameSize != 0) {
                    StringBuilder sb2 = new StringBuilder(88);
                    sb2.append("Audio sample size mismatch. stsd sample size: ");
                    sb2.append(pcmFrameSize);
                    sb2.append(", stsz sample size: ");
                    sb2.append(readUnsignedIntToInt);
                    Log.w(AtomParsers.TAG, sb2.toString());
                    readUnsignedIntToInt = pcmFrameSize;
                }
            }
            this.fixedSampleSize = readUnsignedIntToInt == 0 ? -1 : readUnsignedIntToInt;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        public int getFixedSampleSize() {
            return this.fixedSampleSize;
        }

        public int getSampleCount() {
            return this.sampleCount;
        }

        public int readNextSampleSize() {
            int i11 = this.fixedSampleSize;
            return i11 == -1 ? this.data.readUnsignedIntToInt() : i11;
        }
    }

    public static final class Stz2SampleSizeBox implements SampleSizeBox {
        private int currentByte;
        private final ParsableByteArray data;
        private final int fieldSize;
        private final int sampleCount;
        private int sampleIndex;

        public Stz2SampleSizeBox(Atom.LeafAtom leafAtom) {
            ParsableByteArray parsableByteArray = leafAtom.data;
            this.data = parsableByteArray;
            parsableByteArray.setPosition(12);
            this.fieldSize = parsableByteArray.readUnsignedIntToInt() & 255;
            this.sampleCount = parsableByteArray.readUnsignedIntToInt();
        }

        public int getFixedSampleSize() {
            return -1;
        }

        public int getSampleCount() {
            return this.sampleCount;
        }

        public int readNextSampleSize() {
            int i11 = this.fieldSize;
            if (i11 == 8) {
                return this.data.readUnsignedByte();
            }
            if (i11 == 16) {
                return this.data.readUnsignedShort();
            }
            int i12 = this.sampleIndex;
            this.sampleIndex = i12 + 1;
            if (i12 % 2 != 0) {
                return this.currentByte & 15;
            }
            int readUnsignedByte = this.data.readUnsignedByte();
            this.currentByte = readUnsignedByte;
            return (readUnsignedByte & 240) >> 4;
        }
    }

    public static final class TkhdData {
        /* access modifiers changed from: private */
        public final long duration;
        /* access modifiers changed from: private */

        /* renamed from: id  reason: collision with root package name */
        public final int f65896id;
        /* access modifiers changed from: private */
        public final int rotationDegrees;

        public TkhdData(int i11, long j11, int i12) {
            this.f65896id = i11;
            this.duration = j11;
            this.rotationDegrees = i12;
        }
    }

    private AtomParsers() {
    }

    private static boolean canApplyEditWithGaplessInfo(long[] jArr, long j11, long j12, long j13) {
        int length = jArr.length - 1;
        int constrainValue = Util.constrainValue(4, 0, length);
        int constrainValue2 = Util.constrainValue(jArr.length - 4, 0, length);
        if (jArr[0] > j12 || j12 >= jArr[constrainValue] || jArr[constrainValue2] >= j13 || j13 > j11) {
            return false;
        }
        return true;
    }

    private static int findEsdsPosition(ParsableByteArray parsableByteArray, int i11, int i12) {
        int position = parsableByteArray.getPosition();
        while (position - i11 < i12) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            Assertions.checkState(readInt > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == 1702061171) {
                return position;
            }
            position += readInt;
        }
        return -1;
    }

    private static int getTrackTypeForHdlr(int i11) {
        if (i11 == TYPE_soun) {
            return 1;
        }
        if (i11 == TYPE_vide) {
            return 2;
        }
        if (i11 == TYPE_text || i11 == TYPE_sbtl || i11 == TYPE_subt || i11 == TYPE_clcp) {
            return 3;
        }
        return i11 == 1835365473 ? 5 : -1;
    }

    public static void maybeSkipRemainingMetaAtomHeaderBytes(ParsableByteArray parsableByteArray) {
        int position = parsableByteArray.getPosition();
        parsableByteArray.skipBytes(4);
        if (parsableByteArray.readInt() != 1751411826) {
            position += 4;
        }
        parsableByteArray.setPosition(position);
    }

    /* JADX WARNING: Removed duplicated region for block: B:142:0x02c5 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:152:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x0147  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static void parseAudioSampleEntry(com.google.android.exoplayer2.util.ParsableByteArray r20, int r21, int r22, int r23, int r24, java.lang.String r25, boolean r26, com.google.android.exoplayer2.drm.DrmInitData r27, com.google.android.exoplayer2.extractor.mp4.AtomParsers.StsdData r28, int r29) throws com.google.android.exoplayer2.ParserException {
        /*
            r0 = r20
            r1 = r22
            r2 = r23
            r3 = r24
            r4 = r25
            r5 = r27
            r6 = r28
            int r7 = r1 + 8
            r8 = 8
            int r7 = r7 + r8
            r0.setPosition(r7)
            r7 = 6
            if (r26 == 0) goto L_0x0021
            int r8 = r20.readUnsignedShort()
            r0.skipBytes(r7)
            goto L_0x0025
        L_0x0021:
            r0.skipBytes(r8)
            r8 = 0
        L_0x0025:
            r10 = 16
            r11 = 2
            r12 = 1
            if (r8 == 0) goto L_0x0047
            if (r8 != r12) goto L_0x002e
            goto L_0x0047
        L_0x002e:
            if (r8 != r11) goto L_0x0046
            r0.skipBytes(r10)
            double r7 = r20.readDouble()
            long r7 = java.lang.Math.round(r7)
            int r7 = (int) r7
            int r8 = r20.readUnsignedIntToInt()
            r10 = 20
            r0.skipBytes(r10)
            goto L_0x0058
        L_0x0046:
            return
        L_0x0047:
            int r13 = r20.readUnsignedShort()
            r0.skipBytes(r7)
            int r7 = r20.readUnsignedFixedPoint1616()
            if (r8 != r12) goto L_0x0057
            r0.skipBytes(r10)
        L_0x0057:
            r8 = r13
        L_0x0058:
            int r10 = r20.getPosition()
            r13 = 1701733217(0x656e6361, float:7.0359778E22)
            r15 = r21
            if (r15 != r13) goto L_0x008e
            android.util.Pair r13 = parseSampleEntryEncryptionData(r0, r1, r2)
            if (r13 == 0) goto L_0x0089
            java.lang.Object r15 = r13.first
            java.lang.Integer r15 = (java.lang.Integer) r15
            int r15 = r15.intValue()
            if (r5 != 0) goto L_0x0075
            r14 = 0
            goto L_0x0080
        L_0x0075:
            java.lang.Object r14 = r13.second
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox r14 = (com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox) r14
            java.lang.String r14 = r14.schemeType
            com.google.android.exoplayer2.drm.DrmInitData r5 = r5.copyWithSchemeType(r14)
            r14 = r5
        L_0x0080:
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox[] r5 = r6.trackEncryptionBoxes
            java.lang.Object r13 = r13.second
            com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox r13 = (com.google.android.exoplayer2.extractor.mp4.TrackEncryptionBox) r13
            r5[r29] = r13
            goto L_0x008a
        L_0x0089:
            r14 = r5
        L_0x008a:
            r0.setPosition(r10)
            goto L_0x008f
        L_0x008e:
            r14 = r5
        L_0x008f:
            r5 = 1633889587(0x61632d33, float:2.6191674E20)
            r13 = 1634492771(0x616c6163, float:2.7252807E20)
            java.lang.String r17 = "audio/raw"
            if (r15 != r5) goto L_0x009e
            java.lang.String r17 = "audio/ac3"
        L_0x009b:
            r5 = -1
            goto L_0x013e
        L_0x009e:
            r5 = 1700998451(0x65632d33, float:6.7050686E22)
            if (r15 != r5) goto L_0x00a6
            java.lang.String r17 = "audio/eac3"
            goto L_0x009b
        L_0x00a6:
            r5 = 1633889588(0x61632d34, float:2.6191676E20)
            if (r15 != r5) goto L_0x00ae
            java.lang.String r17 = "audio/ac4"
            goto L_0x009b
        L_0x00ae:
            r5 = 1685353315(0x64747363, float:1.803728E22)
            if (r15 != r5) goto L_0x00b6
            java.lang.String r17 = "audio/vnd.dts"
            goto L_0x009b
        L_0x00b6:
            r5 = 1685353320(0x64747368, float:1.8037286E22)
            if (r15 == r5) goto L_0x013a
            r5 = 1685353324(0x6474736c, float:1.803729E22)
            if (r15 != r5) goto L_0x00c2
            goto L_0x013a
        L_0x00c2:
            r5 = 1685353317(0x64747365, float:1.8037282E22)
            if (r15 != r5) goto L_0x00ca
            java.lang.String r17 = "audio/vnd.dts.hd;profile=lbr"
            goto L_0x009b
        L_0x00ca:
            r5 = 1935764850(0x73616d72, float:1.7860208E31)
            if (r15 != r5) goto L_0x00d2
            java.lang.String r17 = "audio/3gpp"
            goto L_0x009b
        L_0x00d2:
            r5 = 1935767394(0x73617762, float:1.7863284E31)
            if (r15 != r5) goto L_0x00da
            java.lang.String r17 = "audio/amr-wb"
            goto L_0x009b
        L_0x00da:
            r5 = 1819304813(0x6c70636d, float:1.1624469E27)
            if (r15 == r5) goto L_0x0138
            r5 = 1936684916(0x736f7774, float:1.89725E31)
            if (r15 != r5) goto L_0x00e5
            goto L_0x0138
        L_0x00e5:
            r5 = 1953984371(0x74776f73, float:7.841539E31)
            if (r15 != r5) goto L_0x00ed
            r5 = 268435456(0x10000000, float:2.5243549E-29)
            goto L_0x013e
        L_0x00ed:
            r5 = 778924082(0x2e6d7032, float:5.398721E-11)
            if (r15 == r5) goto L_0x0134
            r5 = 778924083(0x2e6d7033, float:5.3987214E-11)
            if (r15 != r5) goto L_0x00f8
            goto L_0x0134
        L_0x00f8:
            r5 = 1835557169(0x6d686131, float:4.4948762E27)
            if (r15 != r5) goto L_0x0100
            java.lang.String r17 = "audio/mha1"
            goto L_0x009b
        L_0x0100:
            r5 = 1835560241(0x6d686d31, float:4.495783E27)
            if (r15 != r5) goto L_0x0108
            java.lang.String r17 = "audio/mhm1"
            goto L_0x009b
        L_0x0108:
            if (r15 != r13) goto L_0x010d
            java.lang.String r17 = "audio/alac"
            goto L_0x009b
        L_0x010d:
            r5 = 1634492791(0x616c6177, float:2.7252842E20)
            if (r15 != r5) goto L_0x0115
            java.lang.String r17 = "audio/g711-alaw"
            goto L_0x009b
        L_0x0115:
            r5 = 1970037111(0x756c6177, float:2.9964816E32)
            if (r15 != r5) goto L_0x011e
            java.lang.String r17 = "audio/g711-mlaw"
            goto L_0x009b
        L_0x011e:
            r5 = 1332770163(0x4f707573, float:4.03422899E9)
            if (r15 != r5) goto L_0x0127
            java.lang.String r17 = "audio/opus"
            goto L_0x009b
        L_0x0127:
            r5 = 1716281667(0x664c6143, float:2.4128923E23)
            if (r15 != r5) goto L_0x0130
            java.lang.String r17 = "audio/flac"
            goto L_0x009b
        L_0x0130:
            r5 = -1
            r17 = 0
            goto L_0x013e
        L_0x0134:
            java.lang.String r17 = "audio/mpeg"
            goto L_0x009b
        L_0x0138:
            r5 = 2
            goto L_0x013e
        L_0x013a:
            java.lang.String r17 = "audio/vnd.dts.hd"
            goto L_0x009b
        L_0x013e:
            r11 = r17
            r15 = 0
            r19 = 0
        L_0x0143:
            int r13 = r10 - r1
            if (r13 >= r2) goto L_0x02c1
            r0.setPosition(r10)
            int r13 = r20.readInt()
            if (r13 <= 0) goto L_0x0151
            goto L_0x0152
        L_0x0151:
            r12 = 0
        L_0x0152:
            java.lang.String r9 = "childAtomSize should be positive"
            com.google.android.exoplayer2.util.Assertions.checkState(r12, r9)
            int r9 = r20.readInt()
            r12 = 1835557187(0x6d686143, float:4.4948815E27)
            if (r9 != r12) goto L_0x017b
            int r9 = r13 + -13
            byte[] r12 = new byte[r9]
            int r1 = r10 + 13
            r0.setPosition(r1)
            r1 = 0
            r0.readBytes(r12, r1, r9)
            com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.of(r12)
        L_0x0171:
            r19 = r1
            r9 = -1
            r12 = 1
            r16 = 2
        L_0x0177:
            r17 = 0
            goto L_0x02ba
        L_0x017b:
            r1 = 1702061171(0x65736473, float:7.183675E22)
            if (r9 == r1) goto L_0x0283
            if (r26 == 0) goto L_0x0189
            r12 = 2002876005(0x77617665, float:4.5729223E33)
            if (r9 != r12) goto L_0x0189
            goto L_0x0283
        L_0x0189:
            r1 = 1684103987(0x64616333, float:1.6630662E22)
            if (r9 != r1) goto L_0x01a6
            int r1 = r10 + 8
            r0.setPosition(r1)
            java.lang.String r1 = java.lang.Integer.toString(r24)
            com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.audio.Ac3Util.parseAc3AnnexFFormat(r0, r1, r4, r14)
            r6.format = r1
        L_0x019d:
            r2 = 1634492771(0x616c6163, float:2.7252807E20)
            r9 = 0
            r12 = 1
            r16 = 2
            goto L_0x027f
        L_0x01a6:
            r1 = 1684366131(0x64656333, float:1.692581E22)
            if (r9 != r1) goto L_0x01bb
            int r1 = r10 + 8
            r0.setPosition(r1)
            java.lang.String r1 = java.lang.Integer.toString(r24)
            com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.audio.Ac3Util.parseEAc3AnnexFFormat(r0, r1, r4, r14)
            r6.format = r1
            goto L_0x019d
        L_0x01bb:
            r1 = 1684103988(0x64616334, float:1.6630663E22)
            if (r9 != r1) goto L_0x01d0
            int r1 = r10 + 8
            r0.setPosition(r1)
            java.lang.String r1 = java.lang.Integer.toString(r24)
            com.google.android.exoplayer2.Format r1 = com.google.android.exoplayer2.audio.Ac4Util.parseAc4AnnexEFormat(r0, r1, r4, r14)
            r6.format = r1
            goto L_0x019d
        L_0x01d0:
            r1 = 1684305011(0x64647473, float:1.6856995E22)
            if (r9 != r1) goto L_0x01f9
            com.google.android.exoplayer2.Format$Builder r1 = new com.google.android.exoplayer2.Format$Builder
            r1.<init>()
            com.google.android.exoplayer2.Format$Builder r1 = r1.setId((int) r3)
            com.google.android.exoplayer2.Format$Builder r1 = r1.setSampleMimeType(r11)
            com.google.android.exoplayer2.Format$Builder r1 = r1.setChannelCount(r8)
            com.google.android.exoplayer2.Format$Builder r1 = r1.setSampleRate(r7)
            com.google.android.exoplayer2.Format$Builder r1 = r1.setDrmInitData(r14)
            com.google.android.exoplayer2.Format$Builder r1 = r1.setLanguage(r4)
            com.google.android.exoplayer2.Format r1 = r1.build()
            r6.format = r1
            goto L_0x019d
        L_0x01f9:
            r1 = 1682927731(0x644f7073, float:1.5306315E22)
            if (r9 != r1) goto L_0x0217
            int r1 = r13 + -8
            byte[] r9 = opusMagic
            int r12 = r9.length
            int r12 = r12 + r1
            byte[] r12 = java.util.Arrays.copyOf(r9, r12)
            int r2 = r10 + 8
            r0.setPosition(r2)
            int r2 = r9.length
            r0.readBytes(r12, r2, r1)
            java.util.List r1 = com.google.android.exoplayer2.audio.OpusUtil.buildInitializationData(r12)
            goto L_0x0171
        L_0x0217:
            r1 = 1684425825(0x64664c61, float:1.6993019E22)
            if (r9 != r1) goto L_0x0249
            int r1 = r13 + -12
            int r2 = r1 + 4
            byte[] r2 = new byte[r2]
            r9 = 102(0x66, float:1.43E-43)
            r12 = 0
            r2[r12] = r9
            r9 = 76
            r12 = 1
            r2[r12] = r9
            r9 = 97
            r16 = 2
            r2[r16] = r9
            r9 = 3
            r18 = 67
            r2[r9] = r18
            int r9 = r10 + 12
            r0.setPosition(r9)
            r9 = 4
            r0.readBytes(r2, r9, r1)
            com.google.common.collect.ImmutableList r1 = com.google.common.collect.ImmutableList.of(r2)
            r19 = r1
            r9 = -1
            goto L_0x0177
        L_0x0249:
            r2 = 1634492771(0x616c6163, float:2.7252807E20)
            r12 = 1
            r16 = 2
            if (r9 != r2) goto L_0x027e
            int r1 = r13 + -12
            byte[] r7 = new byte[r1]
            int r8 = r10 + 12
            r0.setPosition(r8)
            r9 = 0
            r0.readBytes(r7, r9, r1)
            android.util.Pair r1 = com.google.android.exoplayer2.util.CodecSpecificDataUtil.parseAlacAudioSpecificConfig(r7)
            java.lang.Object r8 = r1.first
            java.lang.Integer r8 = (java.lang.Integer) r8
            int r8 = r8.intValue()
            java.lang.Object r1 = r1.second
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            com.google.common.collect.ImmutableList r7 = com.google.common.collect.ImmutableList.of(r7)
            r19 = r7
            r7 = r8
            r17 = r9
            r9 = -1
            r8 = r1
            goto L_0x02ba
        L_0x027e:
            r9 = 0
        L_0x027f:
            r17 = r9
            r9 = -1
            goto L_0x02ba
        L_0x0283:
            r2 = 1634492771(0x616c6163, float:2.7252807E20)
            r12 = 1
            r16 = 2
            r17 = 0
            if (r9 != r1) goto L_0x028f
            r1 = r10
            goto L_0x0293
        L_0x028f:
            int r1 = findEsdsPosition(r0, r10, r13)
        L_0x0293:
            r9 = -1
            if (r1 == r9) goto L_0x02ba
            android.util.Pair r1 = parseEsdsFromParent(r0, r1)
            java.lang.Object r11 = r1.first
            java.lang.String r11 = (java.lang.String) r11
            java.lang.Object r1 = r1.second
            byte[] r1 = (byte[]) r1
            if (r1 == 0) goto L_0x02ba
            java.lang.String r2 = "audio/mp4a-latm"
            boolean r2 = r2.equals(r11)
            if (r2 == 0) goto L_0x02b6
            com.google.android.exoplayer2.audio.AacUtil$Config r2 = com.google.android.exoplayer2.audio.AacUtil.parseAudioSpecificConfig(r1)
            int r7 = r2.sampleRateHz
            int r8 = r2.channelCount
            java.lang.String r15 = r2.codecs
        L_0x02b6:
            com.google.common.collect.ImmutableList r19 = com.google.common.collect.ImmutableList.of(r1)
        L_0x02ba:
            int r10 = r10 + r13
            r1 = r22
            r2 = r23
            goto L_0x0143
        L_0x02c1:
            com.google.android.exoplayer2.Format r0 = r6.format
            if (r0 != 0) goto L_0x02f8
            if (r11 == 0) goto L_0x02f8
            com.google.android.exoplayer2.Format$Builder r0 = new com.google.android.exoplayer2.Format$Builder
            r0.<init>()
            com.google.android.exoplayer2.Format$Builder r0 = r0.setId((int) r3)
            com.google.android.exoplayer2.Format$Builder r0 = r0.setSampleMimeType(r11)
            com.google.android.exoplayer2.Format$Builder r0 = r0.setCodecs(r15)
            com.google.android.exoplayer2.Format$Builder r0 = r0.setChannelCount(r8)
            com.google.android.exoplayer2.Format$Builder r0 = r0.setSampleRate(r7)
            com.google.android.exoplayer2.Format$Builder r0 = r0.setPcmEncoding(r5)
            r1 = r19
            com.google.android.exoplayer2.Format$Builder r0 = r0.setInitializationData(r1)
            com.google.android.exoplayer2.Format$Builder r0 = r0.setDrmInitData(r14)
            com.google.android.exoplayer2.Format$Builder r0 = r0.setLanguage(r4)
            com.google.android.exoplayer2.Format r0 = r0.build()
            r6.format = r0
        L_0x02f8:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.AtomParsers.parseAudioSampleEntry(com.google.android.exoplayer2.util.ParsableByteArray, int, int, int, int, java.lang.String, boolean, com.google.android.exoplayer2.drm.DrmInitData, com.google.android.exoplayer2.extractor.mp4.AtomParsers$StsdData, int):void");
    }

    public static Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent(ParsableByteArray parsableByteArray, int i11, int i12) {
        int i13 = i11 + 8;
        boolean z11 = false;
        int i14 = 0;
        int i15 = -1;
        String str = null;
        Integer num = null;
        while (i13 - i11 < i12) {
            parsableByteArray.setPosition(i13);
            int readInt = parsableByteArray.readInt();
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == 1718775137) {
                num = Integer.valueOf(parsableByteArray.readInt());
            } else if (readInt2 == 1935894637) {
                parsableByteArray.skipBytes(4);
                str = parsableByteArray.readString(4);
            } else if (readInt2 == 1935894633) {
                i15 = i13;
                i14 = readInt;
            }
            i13 += readInt;
        }
        if (!C.CENC_TYPE_cenc.equals(str) && !C.CENC_TYPE_cbc1.equals(str) && !C.CENC_TYPE_cens.equals(str) && !C.CENC_TYPE_cbcs.equals(str)) {
            return null;
        }
        Assertions.checkStateNotNull(num, "frma atom is mandatory");
        if (i15 != -1) {
            z11 = true;
        }
        Assertions.checkState(z11, "schi atom is mandatory");
        return Pair.create(num, (TrackEncryptionBox) Assertions.checkStateNotNull(parseSchiFromParent(parsableByteArray, i15, i14, str), "tenc atom is mandatory"));
    }

    private static Pair<long[], long[]> parseEdts(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_elst);
        if (leafAtomOfType == null) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType.data;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        int readUnsignedIntToInt = parsableByteArray.readUnsignedIntToInt();
        long[] jArr = new long[readUnsignedIntToInt];
        long[] jArr2 = new long[readUnsignedIntToInt];
        int i11 = 0;
        while (i11 < readUnsignedIntToInt) {
            jArr[i11] = parseFullAtomVersion == 1 ? parsableByteArray.readUnsignedLongToLong() : parsableByteArray.readUnsignedInt();
            jArr2[i11] = parseFullAtomVersion == 1 ? parsableByteArray.readLong() : (long) parsableByteArray.readInt();
            if (parsableByteArray.readShort() == 1) {
                parsableByteArray.skipBytes(2);
                i11++;
            } else {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
        }
        return Pair.create(jArr, jArr2);
    }

    private static Pair<String, byte[]> parseEsdsFromParent(ParsableByteArray parsableByteArray, int i11) {
        parsableByteArray.setPosition(i11 + 8 + 4);
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        parsableByteArray.skipBytes(2);
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        if ((readUnsignedByte & 128) != 0) {
            parsableByteArray.skipBytes(2);
        }
        if ((readUnsignedByte & 64) != 0) {
            parsableByteArray.skipBytes(parsableByteArray.readUnsignedShort());
        }
        if ((readUnsignedByte & 32) != 0) {
            parsableByteArray.skipBytes(2);
        }
        parsableByteArray.skipBytes(1);
        parseExpandableClassSize(parsableByteArray);
        String mimeTypeFromMp4ObjectType = MimeTypes.getMimeTypeFromMp4ObjectType(parsableByteArray.readUnsignedByte());
        if ("audio/mpeg".equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS.equals(mimeTypeFromMp4ObjectType) || MimeTypes.AUDIO_DTS_HD.equals(mimeTypeFromMp4ObjectType)) {
            return Pair.create(mimeTypeFromMp4ObjectType, (Object) null);
        }
        parsableByteArray.skipBytes(12);
        parsableByteArray.skipBytes(1);
        int parseExpandableClassSize = parseExpandableClassSize(parsableByteArray);
        byte[] bArr = new byte[parseExpandableClassSize];
        parsableByteArray.readBytes(bArr, 0, parseExpandableClassSize);
        return Pair.create(mimeTypeFromMp4ObjectType, bArr);
    }

    private static int parseExpandableClassSize(ParsableByteArray parsableByteArray) {
        int readUnsignedByte = parsableByteArray.readUnsignedByte();
        int i11 = readUnsignedByte & 127;
        while ((readUnsignedByte & 128) == 128) {
            readUnsignedByte = parsableByteArray.readUnsignedByte();
            i11 = (i11 << 7) | (readUnsignedByte & 127);
        }
        return i11;
    }

    private static int parseHdlr(ParsableByteArray parsableByteArray) {
        parsableByteArray.setPosition(16);
        return parsableByteArray.readInt();
    }

    private static Metadata parseIlst(ParsableByteArray parsableByteArray, int i11) {
        parsableByteArray.skipBytes(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray.getPosition() < i11) {
            Metadata.Entry parseIlstElement = MetadataUtil.parseIlstElement(parsableByteArray);
            if (parseIlstElement != null) {
                arrayList.add(parseIlstElement);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    private static Pair<Long, String> parseMdhd(ParsableByteArray parsableByteArray) {
        int i11 = 8;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 8 : 16);
        long readUnsignedInt = parsableByteArray.readUnsignedInt();
        if (parseFullAtomVersion == 0) {
            i11 = 4;
        }
        parsableByteArray.skipBytes(i11);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        StringBuilder sb2 = new StringBuilder(3);
        sb2.append((char) (((readUnsignedShort >> 10) & 31) + 96));
        sb2.append((char) (((readUnsignedShort >> 5) & 31) + 96));
        sb2.append((char) ((readUnsignedShort & 31) + 96));
        return Pair.create(Long.valueOf(readUnsignedInt), sb2.toString());
    }

    public static Metadata parseMdtaFromMeta(Atom.ContainerAtom containerAtom) {
        Atom.LeafAtom leafAtomOfType = containerAtom.getLeafAtomOfType(Atom.TYPE_hdlr);
        Atom.LeafAtom leafAtomOfType2 = containerAtom.getLeafAtomOfType(Atom.TYPE_keys);
        Atom.LeafAtom leafAtomOfType3 = containerAtom.getLeafAtomOfType(Atom.TYPE_ilst);
        if (leafAtomOfType == null || leafAtomOfType2 == null || leafAtomOfType3 == null || parseHdlr(leafAtomOfType.data) != TYPE_mdta) {
            return null;
        }
        ParsableByteArray parsableByteArray = leafAtomOfType2.data;
        parsableByteArray.setPosition(12);
        int readInt = parsableByteArray.readInt();
        String[] strArr = new String[readInt];
        for (int i11 = 0; i11 < readInt; i11++) {
            int readInt2 = parsableByteArray.readInt();
            parsableByteArray.skipBytes(4);
            strArr[i11] = parsableByteArray.readString(readInt2 - 8);
        }
        ParsableByteArray parsableByteArray2 = leafAtomOfType3.data;
        parsableByteArray2.setPosition(8);
        ArrayList arrayList = new ArrayList();
        while (parsableByteArray2.bytesLeft() > 8) {
            int position = parsableByteArray2.getPosition();
            int readInt3 = parsableByteArray2.readInt();
            int readInt4 = parsableByteArray2.readInt() - 1;
            if (readInt4 < 0 || readInt4 >= readInt) {
                StringBuilder sb2 = new StringBuilder(52);
                sb2.append("Skipped metadata with unknown key index: ");
                sb2.append(readInt4);
                Log.w(TAG, sb2.toString());
            } else {
                MdtaMetadataEntry parseMdtaMetadataEntryFromIlst = MetadataUtil.parseMdtaMetadataEntryFromIlst(parsableByteArray2, position + readInt3, strArr[readInt4]);
                if (parseMdtaMetadataEntryFromIlst != null) {
                    arrayList.add(parseMdtaMetadataEntryFromIlst);
                }
            }
            parsableByteArray2.setPosition(position + readInt3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new Metadata((List<? extends Metadata.Entry>) arrayList);
    }

    private static void parseMetaDataSampleEntry(ParsableByteArray parsableByteArray, int i11, int i12, int i13, StsdData stsdData) {
        parsableByteArray.setPosition(i12 + 8 + 8);
        if (i11 == 1835365492) {
            parsableByteArray.readNullTerminatedString();
            String readNullTerminatedString = parsableByteArray.readNullTerminatedString();
            if (readNullTerminatedString != null) {
                stsdData.format = new Format.Builder().setId(i13).setSampleMimeType(readNullTerminatedString).build();
            }
        }
    }

    private static long parseMvhd(ParsableByteArray parsableByteArray) {
        int i11 = 8;
        parsableByteArray.setPosition(8);
        if (Atom.parseFullAtomVersion(parsableByteArray.readInt()) != 0) {
            i11 = 16;
        }
        parsableByteArray.skipBytes(i11);
        return parsableByteArray.readUnsignedInt();
    }

    private static float parsePaspFromParent(ParsableByteArray parsableByteArray, int i11) {
        parsableByteArray.setPosition(i11 + 8);
        return ((float) parsableByteArray.readUnsignedIntToInt()) / ((float) parsableByteArray.readUnsignedIntToInt());
    }

    private static byte[] parseProjFromParent(ParsableByteArray parsableByteArray, int i11, int i12) {
        int i13 = i11 + 8;
        while (i13 - i11 < i12) {
            parsableByteArray.setPosition(i13);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1886547818) {
                return Arrays.copyOfRange(parsableByteArray.getData(), i13, readInt + i13);
            }
            i13 += readInt;
        }
        return null;
    }

    private static Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData(ParsableByteArray parsableByteArray, int i11, int i12) {
        Pair<Integer, TrackEncryptionBox> parseCommonEncryptionSinfFromParent;
        int position = parsableByteArray.getPosition();
        while (position - i11 < i12) {
            parsableByteArray.setPosition(position);
            int readInt = parsableByteArray.readInt();
            Assertions.checkState(readInt > 0, "childAtomSize should be positive");
            if (parsableByteArray.readInt() == 1936289382 && (parseCommonEncryptionSinfFromParent = parseCommonEncryptionSinfFromParent(parsableByteArray, position, readInt)) != null) {
                return parseCommonEncryptionSinfFromParent;
            }
            position += readInt;
        }
        return null;
    }

    private static TrackEncryptionBox parseSchiFromParent(ParsableByteArray parsableByteArray, int i11, int i12, String str) {
        int i13;
        int i14;
        int i15 = i11 + 8;
        while (true) {
            byte[] bArr = null;
            if (i15 - i11 >= i12) {
                return null;
            }
            parsableByteArray.setPosition(i15);
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1952804451) {
                int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
                parsableByteArray.skipBytes(1);
                if (parseFullAtomVersion == 0) {
                    parsableByteArray.skipBytes(1);
                    i14 = 0;
                    i13 = 0;
                } else {
                    int readUnsignedByte = parsableByteArray.readUnsignedByte();
                    i13 = readUnsignedByte & 15;
                    i14 = (readUnsignedByte & 240) >> 4;
                }
                boolean z11 = parsableByteArray.readUnsignedByte() == 1;
                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                byte[] bArr2 = new byte[16];
                parsableByteArray.readBytes(bArr2, 0, 16);
                if (z11 && readUnsignedByte2 == 0) {
                    int readUnsignedByte3 = parsableByteArray.readUnsignedByte();
                    bArr = new byte[readUnsignedByte3];
                    parsableByteArray.readBytes(bArr, 0, readUnsignedByte3);
                }
                return new TrackEncryptionBox(z11, str, readUnsignedByte2, bArr2, i14, i13, bArr);
            }
            i15 += readInt;
        }
    }

    private static Metadata parseSmta(ParsableByteArray parsableByteArray, int i11) {
        parsableByteArray.skipBytes(12);
        while (parsableByteArray.getPosition() < i11) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() != 1935766900) {
                parsableByteArray.setPosition(position + readInt);
            } else if (readInt < 14) {
                return null;
            } else {
                parsableByteArray.skipBytes(5);
                int readUnsignedByte = parsableByteArray.readUnsignedByte();
                if (readUnsignedByte != 12 && readUnsignedByte != 13) {
                    return null;
                }
                float f11 = readUnsignedByte == 12 ? 240.0f : 120.0f;
                parsableByteArray.skipBytes(1);
                return new Metadata(new SmtaMetadataEntry(f11, parsableByteArray.readUnsignedByte()));
            }
        }
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:106:0x0254  */
    /* JADX WARNING: Removed duplicated region for block: B:107:0x0257  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x0380  */
    /* JADX WARNING: Removed duplicated region for block: B:144:0x03b8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.google.android.exoplayer2.extractor.mp4.TrackSampleTable parseStbl(com.google.android.exoplayer2.extractor.mp4.Track r37, com.google.android.exoplayer2.extractor.mp4.Atom.ContainerAtom r38, com.google.android.exoplayer2.extractor.GaplessInfoHolder r39) throws com.google.android.exoplayer2.ParserException {
        /*
            r1 = r37
            r0 = r38
            r2 = r39
            r3 = 1937011578(0x7374737a, float:1.936741E31)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r3 = r0.getLeafAtomOfType(r3)
            if (r3 == 0) goto L_0x0017
            com.google.android.exoplayer2.extractor.mp4.AtomParsers$StszSampleSizeBox r4 = new com.google.android.exoplayer2.extractor.mp4.AtomParsers$StszSampleSizeBox
            com.google.android.exoplayer2.Format r5 = r1.format
            r4.<init>(r3, r5)
            goto L_0x0025
        L_0x0017:
            r3 = 1937013298(0x73747a32, float:1.9369489E31)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r3 = r0.getLeafAtomOfType(r3)
            if (r3 == 0) goto L_0x0529
            com.google.android.exoplayer2.extractor.mp4.AtomParsers$Stz2SampleSizeBox r4 = new com.google.android.exoplayer2.extractor.mp4.AtomParsers$Stz2SampleSizeBox
            r4.<init>(r3)
        L_0x0025:
            int r3 = r4.getSampleCount()
            r5 = 0
            if (r3 != 0) goto L_0x0043
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r9 = new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable
            long[] r2 = new long[r5]
            int[] r3 = new int[r5]
            r4 = 0
            long[] r6 = new long[r5]
            int[] r7 = new int[r5]
            r10 = 0
            r0 = r9
            r1 = r37
            r5 = r6
            r6 = r7
            r7 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x0043:
            r6 = 1937007471(0x7374636f, float:1.9362445E31)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r6 = r0.getLeafAtomOfType(r6)
            r7 = 1
            if (r6 != 0) goto L_0x005c
            r6 = 1668232756(0x636f3634, float:4.4126776E21)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r6 = r0.getLeafAtomOfType(r6)
            java.lang.Object r6 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r6)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r6 = (com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom) r6
            r8 = r7
            goto L_0x005d
        L_0x005c:
            r8 = r5
        L_0x005d:
            com.google.android.exoplayer2.util.ParsableByteArray r6 = r6.data
            r9 = 1937011555(0x73747363, float:1.9367382E31)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r9 = r0.getLeafAtomOfType(r9)
            java.lang.Object r9 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r9)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r9 = (com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom) r9
            com.google.android.exoplayer2.util.ParsableByteArray r9 = r9.data
            r10 = 1937011827(0x73747473, float:1.9367711E31)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r10 = r0.getLeafAtomOfType(r10)
            java.lang.Object r10 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r10)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r10 = (com.google.android.exoplayer2.extractor.mp4.Atom.LeafAtom) r10
            com.google.android.exoplayer2.util.ParsableByteArray r10 = r10.data
            r11 = 1937011571(0x73747373, float:1.9367401E31)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r11 = r0.getLeafAtomOfType(r11)
            if (r11 == 0) goto L_0x0089
            com.google.android.exoplayer2.util.ParsableByteArray r11 = r11.data
            goto L_0x008a
        L_0x0089:
            r11 = 0
        L_0x008a:
            r13 = 1668576371(0x63747473, float:4.5093966E21)
            com.google.android.exoplayer2.extractor.mp4.Atom$LeafAtom r0 = r0.getLeafAtomOfType(r13)
            if (r0 == 0) goto L_0x0096
            com.google.android.exoplayer2.util.ParsableByteArray r0 = r0.data
            goto L_0x0097
        L_0x0096:
            r0 = 0
        L_0x0097:
            com.google.android.exoplayer2.extractor.mp4.AtomParsers$ChunkIterator r13 = new com.google.android.exoplayer2.extractor.mp4.AtomParsers$ChunkIterator
            r13.<init>(r9, r6, r8)
            r6 = 12
            r10.setPosition(r6)
            int r8 = r10.readUnsignedIntToInt()
            int r8 = r8 - r7
            int r9 = r10.readUnsignedIntToInt()
            int r14 = r10.readUnsignedIntToInt()
            if (r0 == 0) goto L_0x00b8
            r0.setPosition(r6)
            int r15 = r0.readUnsignedIntToInt()
            goto L_0x00b9
        L_0x00b8:
            r15 = r5
        L_0x00b9:
            r12 = -1
            if (r11 == 0) goto L_0x00d0
            r11.setPosition(r6)
            int r6 = r11.readUnsignedIntToInt()
            if (r6 <= 0) goto L_0x00cc
            int r16 = r11.readUnsignedIntToInt()
            int r16 = r16 + -1
            goto L_0x00d3
        L_0x00cc:
            r16 = r12
            r11 = 0
            goto L_0x00d3
        L_0x00d0:
            r6 = r5
            r16 = r12
        L_0x00d3:
            int r5 = r4.getFixedSampleSize()
            com.google.android.exoplayer2.Format r7 = r1.format
            java.lang.String r7 = r7.sampleMimeType
            if (r5 == r12) goto L_0x0100
            java.lang.String r12 = "audio/raw"
            boolean r12 = r12.equals(r7)
            if (r12 != 0) goto L_0x00f5
            java.lang.String r12 = "audio/g711-mlaw"
            boolean r12 = r12.equals(r7)
            if (r12 != 0) goto L_0x00f5
            java.lang.String r12 = "audio/g711-alaw"
            boolean r7 = r12.equals(r7)
            if (r7 == 0) goto L_0x0100
        L_0x00f5:
            if (r8 != 0) goto L_0x0100
            if (r15 != 0) goto L_0x0100
            if (r6 != 0) goto L_0x0100
            r38 = r8
            r12 = r9
            r7 = 1
            goto L_0x0104
        L_0x0100:
            r38 = r8
            r12 = r9
            r7 = 0
        L_0x0104:
            if (r7 == 0) goto L_0x0137
            int r0 = r13.length
            long[] r4 = new long[r0]
            int[] r0 = new int[r0]
        L_0x010c:
            boolean r6 = r13.moveNext()
            if (r6 == 0) goto L_0x011d
            int r6 = r13.index
            long r10 = r13.offset
            r4[r6] = r10
            int r7 = r13.numSamples
            r0[r6] = r7
            goto L_0x010c
        L_0x011d:
            long r6 = (long) r14
            com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker$Results r0 = com.google.android.exoplayer2.extractor.mp4.FixedSampleSizeRechunker.rechunk(r5, r4, r0, r6)
            long[] r4 = r0.offsets
            int[] r5 = r0.sizes
            int r6 = r0.maximumSize
            long[] r7 = r0.timestamps
            int[] r10 = r0.flags
            long r11 = r0.duration
            r0 = r3
            r2 = r4
            r3 = r5
            r5 = r7
            r14 = r10
            r15 = r11
            r4 = r1
            goto L_0x02ac
        L_0x0137:
            long[] r5 = new long[r3]
            int[] r7 = new int[r3]
            long[] r8 = new long[r3]
            int[] r9 = new int[r3]
            r22 = r10
            r2 = r16
            r1 = 0
            r10 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r23 = 0
            r25 = 0
            r16 = r15
            r15 = r14
            r14 = r12
        L_0x0153:
            java.lang.String r12 = "AtomParsers"
            if (r1 >= r3) goto L_0x021a
            r26 = r25
            r25 = r20
            r20 = 1
        L_0x015d:
            if (r25 != 0) goto L_0x017a
            boolean r20 = r13.moveNext()
            if (r20 == 0) goto L_0x017a
            r28 = r14
            r29 = r15
            long r14 = r13.offset
            r30 = r3
            int r3 = r13.numSamples
            r25 = r3
            r26 = r14
            r14 = r28
            r15 = r29
            r3 = r30
            goto L_0x015d
        L_0x017a:
            r30 = r3
            r28 = r14
            r29 = r15
            if (r20 != 0) goto L_0x019e
            java.lang.String r2 = "Unexpected end of chunk data"
            com.google.android.exoplayer2.util.Log.w(r12, r2)
            long[] r5 = java.util.Arrays.copyOf(r5, r1)
            int[] r7 = java.util.Arrays.copyOf(r7, r1)
            long[] r8 = java.util.Arrays.copyOf(r8, r1)
            int[] r9 = java.util.Arrays.copyOf(r9, r1)
            r3 = r1
            r2 = r19
            r1 = r25
            goto L_0x0222
        L_0x019e:
            if (r0 == 0) goto L_0x01b1
        L_0x01a0:
            if (r21 != 0) goto L_0x01af
            if (r16 <= 0) goto L_0x01af
            int r21 = r0.readUnsignedIntToInt()
            int r19 = r0.readInt()
            int r16 = r16 + -1
            goto L_0x01a0
        L_0x01af:
            int r21 = r21 + -1
        L_0x01b1:
            r3 = r19
            r5[r1] = r26
            int r12 = r4.readNextSampleSize()
            r7[r1] = r12
            r12 = r7[r1]
            if (r12 <= r10) goto L_0x01c1
            r10 = r7[r1]
        L_0x01c1:
            long r14 = (long) r3
            long r14 = r23 + r14
            r8[r1] = r14
            if (r11 != 0) goto L_0x01ca
            r12 = 1
            goto L_0x01cb
        L_0x01ca:
            r12 = 0
        L_0x01cb:
            r9[r1] = r12
            if (r1 != r2) goto L_0x01e1
            r12 = 1
            r9[r1] = r12
            int r6 = r6 + -1
            if (r6 <= 0) goto L_0x01e1
            java.lang.Object r2 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r11)
            com.google.android.exoplayer2.util.ParsableByteArray r2 = (com.google.android.exoplayer2.util.ParsableByteArray) r2
            int r2 = r2.readUnsignedIntToInt()
            int r2 = r2 - r12
        L_0x01e1:
            r15 = r2
            r12 = r3
            r14 = r29
            long r2 = (long) r14
            long r23 = r23 + r2
            int r2 = r28 + -1
            if (r2 != 0) goto L_0x01f9
            if (r38 <= 0) goto L_0x01f9
            int r2 = r22.readUnsignedIntToInt()
            int r3 = r22.readInt()
            int r14 = r38 + -1
            goto L_0x01fc
        L_0x01f9:
            r3 = r14
            r14 = r38
        L_0x01fc:
            r38 = r2
            r2 = r7[r1]
            r19 = r3
            long r2 = (long) r2
            long r2 = r26 + r2
            int r20 = r25 + -1
            int r1 = r1 + 1
            r25 = r2
            r2 = r15
            r15 = r19
            r3 = r30
            r19 = r12
            r36 = r14
            r14 = r38
            r38 = r36
            goto L_0x0153
        L_0x021a:
            r30 = r3
            r28 = r14
            r2 = r19
            r1 = r20
        L_0x0222:
            long r13 = (long) r2
            long r13 = r23 + r13
            if (r0 == 0) goto L_0x0237
        L_0x0227:
            if (r16 <= 0) goto L_0x0237
            int r2 = r0.readUnsignedIntToInt()
            if (r2 == 0) goto L_0x0231
            r0 = 0
            goto L_0x0238
        L_0x0231:
            r0.readInt()
            int r16 = r16 + -1
            goto L_0x0227
        L_0x0237:
            r0 = 1
        L_0x0238:
            if (r6 != 0) goto L_0x024c
            if (r28 != 0) goto L_0x024c
            if (r1 != 0) goto L_0x024c
            if (r38 != 0) goto L_0x024c
            r2 = r21
            if (r2 != 0) goto L_0x024e
            if (r0 != 0) goto L_0x0247
            goto L_0x024e
        L_0x0247:
            r4 = r37
            r16 = r3
            goto L_0x02a4
        L_0x024c:
            r2 = r21
        L_0x024e:
            r4 = r37
            int r11 = r4.f65897id
            if (r0 != 0) goto L_0x0257
            java.lang.String r0 = ", ctts invalid"
            goto L_0x0259
        L_0x0257:
            java.lang.String r0 = ""
        L_0x0259:
            int r15 = r0.length()
            int r15 = r15 + 262
            r16 = r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r15)
            java.lang.String r15 = "Inconsistent stbl box for track "
            r3.append(r15)
            r3.append(r11)
            java.lang.String r11 = ": remainingSynchronizationSamples "
            r3.append(r11)
            r3.append(r6)
            java.lang.String r6 = ", remainingSamplesAtTimestampDelta "
            r3.append(r6)
            r6 = r28
            r3.append(r6)
            java.lang.String r6 = ", remainingSamplesInChunk "
            r3.append(r6)
            r3.append(r1)
            java.lang.String r1 = ", remainingTimestampDeltaChanges "
            r3.append(r1)
            r1 = r38
            r3.append(r1)
            java.lang.String r1 = ", remainingSamplesAtTimestampOffset "
            r3.append(r1)
            r3.append(r2)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            com.google.android.exoplayer2.util.Log.w(r12, r0)
        L_0x02a4:
            r2 = r5
            r3 = r7
            r5 = r8
            r6 = r10
            r0 = r16
            r15 = r13
            r14 = r9
        L_0x02ac:
            r9 = 1000000(0xf4240, double:4.940656E-318)
            long r11 = r4.timescale
            r7 = r15
            long r7 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r7, r9, r11)
            long[] r1 = r4.editListDurations
            r12 = 1000000(0xf4240, double:4.940656E-318)
            if (r1 != 0) goto L_0x02cd
            long r0 = r4.timescale
            com.google.android.exoplayer2.util.Util.scaleLargeTimestampsInPlace(r5, r12, r0)
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r9 = new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable
            r0 = r9
            r1 = r37
            r4 = r6
            r6 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x02cd:
            int r1 = r1.length
            r7 = 1
            if (r1 != r7) goto L_0x036b
            int r1 = r4.type
            if (r1 != r7) goto L_0x036b
            int r1 = r5.length
            r7 = 2
            if (r1 < r7) goto L_0x036b
            long[] r1 = r4.editListMediaTimes
            java.lang.Object r1 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r1)
            long[] r1 = (long[]) r1
            r7 = 0
            r19 = r1[r7]
            long[] r1 = r4.editListDurations
            r21 = r1[r7]
            long r7 = r4.timescale
            long r9 = r4.movieTimescale
            r23 = r7
            r25 = r9
            long r7 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r21, r23, r25)
            long r21 = r19 + r7
            r7 = r5
            r8 = r15
            r10 = r19
            r23 = r0
            r0 = r12
            r12 = r21
            boolean r7 = canApplyEditWithGaplessInfo(r7, r8, r10, r12)
            if (r7 == 0) goto L_0x036d
            long r8 = r15 - r21
            r7 = 0
            r10 = r5[r7]
            long r24 = r19 - r10
            com.google.android.exoplayer2.Format r7 = r4.format
            int r7 = r7.sampleRate
            long r10 = (long) r7
            long r12 = r4.timescale
            r26 = r10
            r28 = r12
            long r12 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r24, r26, r28)
            com.google.android.exoplayer2.Format r7 = r4.format
            int r7 = r7.sampleRate
            long r10 = (long) r7
            long r0 = r4.timescale
            r38 = r14
            r21 = r15
            r14 = r12
            r12 = r0
            long r0 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r8, r10, r12)
            r7 = 0
            int r9 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r9 != 0) goto L_0x0336
            int r9 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r9 == 0) goto L_0x0371
        L_0x0336:
            r7 = 2147483647(0x7fffffff, double:1.060997895E-314)
            int r9 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r9 > 0) goto L_0x0371
            int r7 = (r0 > r7 ? 1 : (r0 == r7 ? 0 : -1))
            if (r7 > 0) goto L_0x0371
            int r7 = (int) r14
            r8 = r39
            r8.encoderDelay = r7
            int r0 = (int) r0
            r8.encoderPadding = r0
            long r0 = r4.timescale
            r7 = 1000000(0xf4240, double:4.940656E-318)
            com.google.android.exoplayer2.util.Util.scaleLargeTimestampsInPlace(r5, r7, r0)
            long[] r0 = r4.editListDurations
            r1 = 0
            r7 = r0[r1]
            r9 = 1000000(0xf4240, double:4.940656E-318)
            long r11 = r4.movieTimescale
            long r7 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r7, r9, r11)
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r9 = new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable
            r0 = r9
            r1 = r37
            r4 = r6
            r6 = r38
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x036b:
            r23 = r0
        L_0x036d:
            r38 = r14
            r21 = r15
        L_0x0371:
            long[] r0 = r4.editListDurations
            int r1 = r0.length
            r7 = 1
            if (r1 != r7) goto L_0x03b8
            r1 = 0
            r7 = r0[r1]
            r9 = 0
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 != 0) goto L_0x03b8
            long[] r0 = r4.editListMediaTimes
            java.lang.Object r0 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r0)
            long[] r0 = (long[]) r0
            r7 = r0[r1]
            r0 = 0
        L_0x038b:
            int r1 = r5.length
            if (r0 >= r1) goto L_0x03a1
            r9 = r5[r0]
            long r11 = r9 - r7
            r13 = 1000000(0xf4240, double:4.940656E-318)
            long r9 = r4.timescale
            r15 = r9
            long r9 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r11, r13, r15)
            r5[r0] = r9
            int r0 = r0 + 1
            goto L_0x038b
        L_0x03a1:
            long r9 = r21 - r7
            r11 = 1000000(0xf4240, double:4.940656E-318)
            long r13 = r4.timescale
            long r7 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r9, r11, r13)
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r9 = new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable
            r0 = r9
            r1 = r37
            r4 = r6
            r6 = r38
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r9
        L_0x03b8:
            int r1 = r4.type
            r7 = 1
            if (r1 != r7) goto L_0x03bf
            r12 = 1
            goto L_0x03c0
        L_0x03bf:
            r12 = 0
        L_0x03c0:
            int r1 = r0.length
            int[] r1 = new int[r1]
            int r0 = r0.length
            int[] r0 = new int[r0]
            long[] r7 = r4.editListMediaTimes
            java.lang.Object r7 = com.google.android.exoplayer2.util.Assertions.checkNotNull(r7)
            long[] r7 = (long[]) r7
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
        L_0x03d2:
            long[] r13 = r4.editListDurations
            int r14 = r13.length
            if (r8 >= r14) goto L_0x043c
            r14 = r7[r8]
            r19 = -1
            int r16 = (r14 > r19 ? 1 : (r14 == r19 ? 0 : -1))
            if (r16 == 0) goto L_0x0429
            r24 = r13[r8]
            r13 = r6
            r39 = r7
            long r6 = r4.timescale
            r16 = r2
            r19 = r3
            long r2 = r4.movieTimescale
            r26 = r6
            r28 = r2
            long r2 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r24, r26, r28)
            r6 = 1
            int r7 = com.google.android.exoplayer2.util.Util.binarySearchFloor((long[]) r5, (long) r14, (boolean) r6, (boolean) r6)
            r1[r8] = r7
            long r14 = r14 + r2
            r2 = 0
            int r3 = com.google.android.exoplayer2.util.Util.binarySearchCeil((long[]) r5, (long) r14, (boolean) r12, (boolean) r2)
            r0[r8] = r3
        L_0x0403:
            r3 = r1[r8]
            r7 = r0[r8]
            if (r3 >= r7) goto L_0x0416
            r3 = r1[r8]
            r3 = r38[r3]
            r3 = r3 & r6
            if (r3 != 0) goto L_0x0416
            r3 = r1[r8]
            int r3 = r3 + r6
            r1[r8] = r3
            goto L_0x0403
        L_0x0416:
            r3 = r0[r8]
            r7 = r1[r8]
            int r3 = r3 - r7
            int r10 = r10 + r3
            r3 = r1[r8]
            if (r11 == r3) goto L_0x0422
            r3 = r6
            goto L_0x0423
        L_0x0422:
            r3 = r2
        L_0x0423:
            r3 = r3 | r9
            r7 = r0[r8]
            r9 = r3
            r11 = r7
            goto L_0x0432
        L_0x0429:
            r16 = r2
            r19 = r3
            r13 = r6
            r39 = r7
            r2 = 0
            r6 = 1
        L_0x0432:
            int r8 = r8 + 1
            r7 = r39
            r6 = r13
            r2 = r16
            r3 = r19
            goto L_0x03d2
        L_0x043c:
            r16 = r2
            r19 = r3
            r13 = r6
            r3 = r23
            r2 = 0
            r6 = 1
            if (r10 == r3) goto L_0x0449
            r7 = r6
            goto L_0x044a
        L_0x0449:
            r7 = r2
        L_0x044a:
            r3 = r9 | r7
            if (r3 == 0) goto L_0x0451
            long[] r6 = new long[r10]
            goto L_0x0453
        L_0x0451:
            r6 = r16
        L_0x0453:
            if (r3 == 0) goto L_0x0458
            int[] r7 = new int[r10]
            goto L_0x045a
        L_0x0458:
            r7 = r19
        L_0x045a:
            if (r3 == 0) goto L_0x045d
            r13 = r2
        L_0x045d:
            if (r3 == 0) goto L_0x0462
            int[] r8 = new int[r10]
            goto L_0x0464
        L_0x0462:
            r8 = r38
        L_0x0464:
            long[] r9 = new long[r10]
            r10 = r2
            r11 = 0
        L_0x0469:
            long[] r14 = r4.editListDurations
            int r14 = r14.length
            if (r2 >= r14) goto L_0x0507
            long[] r14 = r4.editListMediaTimes
            r17 = r14[r2]
            r14 = r1[r2]
            r15 = r0[r2]
            r26 = r0
            if (r3 == 0) goto L_0x0490
            int r0 = r15 - r14
            r27 = r1
            r1 = r16
            java.lang.System.arraycopy(r1, r14, r6, r10, r0)
            r1 = r19
            java.lang.System.arraycopy(r1, r14, r7, r10, r0)
            r39 = r13
            r13 = r38
            java.lang.System.arraycopy(r13, r14, r8, r10, r0)
            goto L_0x0498
        L_0x0490:
            r27 = r1
            r39 = r13
            r1 = r19
            r13 = r38
        L_0x0498:
            r0 = r39
        L_0x049a:
            if (r14 >= r15) goto L_0x04e2
            r22 = 1000000(0xf4240, double:4.940656E-318)
            r28 = r1
            r19 = r2
            long r1 = r4.movieTimescale
            r20 = r11
            r24 = r1
            long r1 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r20, r22, r24)
            r20 = r5[r14]
            r22 = r5
            r29 = r6
            long r5 = r20 - r17
            r20 = r11
            r11 = 0
            long r30 = java.lang.Math.max(r11, r5)
            r32 = 1000000(0xf4240, double:4.940656E-318)
            long r5 = r4.timescale
            r34 = r5
            long r5 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r30, r32, r34)
            long r1 = r1 + r5
            r9[r10] = r1
            if (r3 == 0) goto L_0x04d3
            r1 = r7[r10]
            if (r1 <= r0) goto L_0x04d3
            r0 = r28[r14]
        L_0x04d3:
            int r10 = r10 + 1
            int r14 = r14 + 1
            r2 = r19
            r11 = r20
            r5 = r22
            r1 = r28
            r6 = r29
            goto L_0x049a
        L_0x04e2:
            r28 = r1
            r19 = r2
            r22 = r5
            r29 = r6
            r20 = r11
            r11 = 0
            long[] r1 = r4.editListDurations
            r5 = r1[r19]
            long r1 = r20 + r5
            int r5 = r19 + 1
            r11 = r1
            r2 = r5
            r38 = r13
            r5 = r22
            r1 = r27
            r19 = r28
            r6 = r29
            r13 = r0
            r0 = r26
            goto L_0x0469
        L_0x0507:
            r29 = r6
            r20 = r11
            r39 = r13
            r22 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r4.movieTimescale
            r24 = r0
            long r10 = com.google.android.exoplayer2.util.Util.scaleLargeTimestamp(r20, r22, r24)
            com.google.android.exoplayer2.extractor.mp4.TrackSampleTable r12 = new com.google.android.exoplayer2.extractor.mp4.TrackSampleTable
            r0 = r12
            r1 = r37
            r2 = r29
            r3 = r7
            r4 = r39
            r5 = r9
            r6 = r8
            r7 = r10
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            return r12
        L_0x0529:
            com.google.android.exoplayer2.ParserException r0 = new com.google.android.exoplayer2.ParserException
            java.lang.String r1 = "Track has no sample table size information"
            r0.<init>((java.lang.String) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.mp4.AtomParsers.parseStbl(com.google.android.exoplayer2.extractor.mp4.Track, com.google.android.exoplayer2.extractor.mp4.Atom$ContainerAtom, com.google.android.exoplayer2.extractor.GaplessInfoHolder):com.google.android.exoplayer2.extractor.mp4.TrackSampleTable");
    }

    private static StsdData parseStsd(ParsableByteArray parsableByteArray, int i11, int i12, String str, DrmInitData drmInitData, boolean z11) throws ParserException {
        int i13;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i14 = i11;
        parsableByteArray2.setPosition(12);
        int readInt = parsableByteArray.readInt();
        StsdData stsdData = new StsdData(readInt);
        for (int i15 = 0; i15 < readInt; i15++) {
            int position = parsableByteArray.getPosition();
            int readInt2 = parsableByteArray.readInt();
            Assertions.checkState(readInt2 > 0, "childAtomSize should be positive");
            int readInt3 = parsableByteArray.readInt();
            if (readInt3 == 1635148593 || readInt3 == 1635148595 || readInt3 == 1701733238 || readInt3 == 1831958048 || readInt3 == 1836070006 || readInt3 == 1752589105 || readInt3 == 1751479857 || readInt3 == 1932670515 || readInt3 == 1987063864 || readInt3 == 1987063865 || readInt3 == 1635135537 || readInt3 == 1685479798 || readInt3 == 1685479729 || readInt3 == 1685481573 || readInt3 == 1685481521) {
                i13 = position;
                parseVideoSampleEntry(parsableByteArray, readInt3, i13, readInt2, i11, i12, drmInitData, stsdData, i15);
            } else if (readInt3 == 1836069985 || readInt3 == 1701733217 || readInt3 == 1633889587 || readInt3 == 1700998451 || readInt3 == 1633889588 || readInt3 == 1685353315 || readInt3 == 1685353317 || readInt3 == 1685353320 || readInt3 == 1685353324 || readInt3 == 1935764850 || readInt3 == 1935767394 || readInt3 == 1819304813 || readInt3 == 1936684916 || readInt3 == 1953984371 || readInt3 == 778924082 || readInt3 == 778924083 || readInt3 == 1835557169 || readInt3 == 1835560241 || readInt3 == 1634492771 || readInt3 == 1634492791 || readInt3 == 1970037111 || readInt3 == 1332770163 || readInt3 == 1716281667) {
                i13 = position;
                parseAudioSampleEntry(parsableByteArray, readInt3, position, readInt2, i11, str, z11, drmInitData, stsdData, i15);
            } else {
                if (readInt3 == 1414810956 || readInt3 == 1954034535 || readInt3 == 2004251764 || readInt3 == 1937010800 || readInt3 == 1664495672) {
                    parseTextSampleEntry(parsableByteArray, readInt3, position, readInt2, i11, str, stsdData);
                } else if (readInt3 == 1835365492) {
                    parseMetaDataSampleEntry(parsableByteArray2, readInt3, position, i14, stsdData);
                } else if (readInt3 == 1667329389) {
                    stsdData.format = new Format.Builder().setId(i14).setSampleMimeType(MimeTypes.APPLICATION_CAMERA_MOTION).build();
                }
                i13 = position;
            }
            parsableByteArray2.setPosition(i13 + readInt2);
        }
        return stsdData;
    }

    private static void parseTextSampleEntry(ParsableByteArray parsableByteArray, int i11, int i12, int i13, int i14, String str, StsdData stsdData) {
        parsableByteArray.setPosition(i12 + 8 + 8);
        String str2 = MimeTypes.APPLICATION_TTML;
        ImmutableList immutableList = null;
        long j11 = Long.MAX_VALUE;
        if (i11 != 1414810956) {
            if (i11 == 1954034535) {
                int i15 = (i13 - 8) - 8;
                byte[] bArr = new byte[i15];
                parsableByteArray.readBytes(bArr, 0, i15);
                immutableList = ImmutableList.of(bArr);
                str2 = MimeTypes.APPLICATION_TX3G;
            } else if (i11 == 2004251764) {
                str2 = MimeTypes.APPLICATION_MP4VTT;
            } else if (i11 == 1937010800) {
                j11 = 0;
            } else if (i11 == 1664495672) {
                stsdData.requiredSampleTransformation = 1;
                str2 = MimeTypes.APPLICATION_MP4CEA608;
            } else {
                throw new IllegalStateException();
            }
        }
        stsdData.format = new Format.Builder().setId(i14).setSampleMimeType(str2).setLanguage(str).setSubsampleOffsetUs(j11).setInitializationData(immutableList).build();
    }

    private static TkhdData parseTkhd(ParsableByteArray parsableByteArray) {
        boolean z11;
        int i11 = 8;
        parsableByteArray.setPosition(8);
        int parseFullAtomVersion = Atom.parseFullAtomVersion(parsableByteArray.readInt());
        parsableByteArray.skipBytes(parseFullAtomVersion == 0 ? 8 : 16);
        int readInt = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int position = parsableByteArray.getPosition();
        if (parseFullAtomVersion == 0) {
            i11 = 4;
        }
        int i12 = 0;
        int i13 = 0;
        while (true) {
            if (i13 >= i11) {
                z11 = true;
                break;
            } else if (parsableByteArray.getData()[position + i13] != -1) {
                z11 = false;
                break;
            } else {
                i13++;
            }
        }
        long j11 = -9223372036854775807L;
        if (z11) {
            parsableByteArray.skipBytes(i11);
        } else {
            long readUnsignedInt = parseFullAtomVersion == 0 ? parsableByteArray.readUnsignedInt() : parsableByteArray.readUnsignedLongToLong();
            if (readUnsignedInt != 0) {
                j11 = readUnsignedInt;
            }
        }
        parsableByteArray.skipBytes(16);
        int readInt2 = parsableByteArray.readInt();
        int readInt3 = parsableByteArray.readInt();
        parsableByteArray.skipBytes(4);
        int readInt4 = parsableByteArray.readInt();
        int readInt5 = parsableByteArray.readInt();
        if (readInt2 == 0 && readInt3 == 65536 && readInt4 == -65536 && readInt5 == 0) {
            i12 = 90;
        } else if (readInt2 == 0 && readInt3 == -65536 && readInt4 == 65536 && readInt5 == 0) {
            i12 = 270;
        } else if (readInt2 == -65536 && readInt3 == 0 && readInt4 == 0 && readInt5 == -65536) {
            i12 = 180;
        }
        return new TkhdData(readInt, j11, i12);
    }

    private static Track parseTrak(Atom.ContainerAtom containerAtom, Atom.LeafAtom leafAtom, long j11, DrmInitData drmInitData, boolean z11, boolean z12) throws ParserException {
        long j12;
        Atom.LeafAtom leafAtom2;
        long[] jArr;
        long[] jArr2;
        Atom.ContainerAtom containerAtomOfType;
        Pair<long[], long[]> parseEdts;
        Atom.ContainerAtom containerAtom2 = containerAtom;
        Atom.ContainerAtom containerAtom3 = (Atom.ContainerAtom) Assertions.checkNotNull(containerAtom2.getContainerAtomOfType(Atom.TYPE_mdia));
        int trackTypeForHdlr = getTrackTypeForHdlr(parseHdlr(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom3.getLeafAtomOfType(Atom.TYPE_hdlr))).data));
        if (trackTypeForHdlr == -1) {
            return null;
        }
        TkhdData parseTkhd = parseTkhd(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom2.getLeafAtomOfType(Atom.TYPE_tkhd))).data);
        long j13 = -9223372036854775807L;
        if (j11 == -9223372036854775807L) {
            leafAtom2 = leafAtom;
            j12 = parseTkhd.duration;
        } else {
            leafAtom2 = leafAtom;
            j12 = j11;
        }
        long parseMvhd = parseMvhd(leafAtom2.data);
        if (j12 != -9223372036854775807L) {
            j13 = Util.scaleLargeTimestamp(j12, 1000000, parseMvhd);
        }
        long j14 = j13;
        Pair<Long, String> parseMdhd = parseMdhd(((Atom.LeafAtom) Assertions.checkNotNull(containerAtom3.getLeafAtomOfType(Atom.TYPE_mdhd))).data);
        StsdData parseStsd = parseStsd(((Atom.LeafAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(containerAtom3.getContainerAtomOfType(Atom.TYPE_minf))).getContainerAtomOfType(Atom.TYPE_stbl))).getLeafAtomOfType(Atom.TYPE_stsd))).data, parseTkhd.f65896id, parseTkhd.rotationDegrees, (String) parseMdhd.second, drmInitData, z12);
        if (z11 || (containerAtomOfType = containerAtom2.getContainerAtomOfType(Atom.TYPE_edts)) == null || (parseEdts = parseEdts(containerAtomOfType)) == null) {
            jArr2 = null;
            jArr = null;
        } else {
            jArr = (long[]) parseEdts.second;
            jArr2 = (long[]) parseEdts.first;
        }
        if (parseStsd.format == null) {
            return null;
        }
        return new Track(parseTkhd.f65896id, trackTypeForHdlr, ((Long) parseMdhd.first).longValue(), parseMvhd, j14, parseStsd.format, parseStsd.requiredSampleTransformation, parseStsd.trackEncryptionBoxes, parseStsd.nalUnitLengthFieldLength, jArr2, jArr);
    }

    public static List<TrackSampleTable> parseTraks(Atom.ContainerAtom containerAtom, GaplessInfoHolder gaplessInfoHolder, long j11, DrmInitData drmInitData, boolean z11, boolean z12, Function<Track, Track> function) throws ParserException {
        Atom.ContainerAtom containerAtom2 = containerAtom;
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 < containerAtom2.containerChildren.size(); i11++) {
            Atom.ContainerAtom containerAtom3 = containerAtom2.containerChildren.get(i11);
            if (containerAtom3.type != 1953653099) {
                GaplessInfoHolder gaplessInfoHolder2 = gaplessInfoHolder;
                Function<Track, Track> function2 = function;
            } else {
                Track apply = function.apply(parseTrak(containerAtom3, (Atom.LeafAtom) Assertions.checkNotNull(containerAtom.getLeafAtomOfType(Atom.TYPE_mvhd)), j11, drmInitData, z11, z12));
                if (apply == null) {
                    GaplessInfoHolder gaplessInfoHolder3 = gaplessInfoHolder;
                } else {
                    GaplessInfoHolder gaplessInfoHolder4 = gaplessInfoHolder;
                    arrayList.add(parseStbl(apply, (Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(((Atom.ContainerAtom) Assertions.checkNotNull(containerAtom3.getContainerAtomOfType(Atom.TYPE_mdia))).getContainerAtomOfType(Atom.TYPE_minf))).getContainerAtomOfType(Atom.TYPE_stbl)), gaplessInfoHolder));
                }
            }
        }
        return arrayList;
    }

    public static Pair<Metadata, Metadata> parseUdta(Atom.LeafAtom leafAtom) {
        ParsableByteArray parsableByteArray = leafAtom.data;
        parsableByteArray.setPosition(8);
        Metadata metadata = null;
        Metadata metadata2 = null;
        while (parsableByteArray.bytesLeft() >= 8) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == 1835365473) {
                parsableByteArray.setPosition(position);
                metadata = parseUdtaMeta(parsableByteArray, position + readInt);
            } else if (readInt2 == 1936553057) {
                parsableByteArray.setPosition(position);
                metadata2 = parseSmta(parsableByteArray, position + readInt);
            }
            parsableByteArray.setPosition(position + readInt);
        }
        return Pair.create(metadata, metadata2);
    }

    private static Metadata parseUdtaMeta(ParsableByteArray parsableByteArray, int i11) {
        parsableByteArray.skipBytes(8);
        maybeSkipRemainingMetaAtomHeaderBytes(parsableByteArray);
        while (parsableByteArray.getPosition() < i11) {
            int position = parsableByteArray.getPosition();
            int readInt = parsableByteArray.readInt();
            if (parsableByteArray.readInt() == 1768715124) {
                parsableByteArray.setPosition(position);
                return parseIlst(parsableByteArray, position + readInt);
            }
            parsableByteArray.setPosition(position + readInt);
        }
        return null;
    }

    private static void parseVideoSampleEntry(ParsableByteArray parsableByteArray, int i11, int i12, int i13, int i14, int i15, DrmInitData drmInitData, StsdData stsdData, int i16) throws ParserException {
        DrmInitData drmInitData2;
        List<byte[]> list;
        String str;
        List<byte[]> list2;
        String str2;
        String str3;
        ParsableByteArray parsableByteArray2 = parsableByteArray;
        int i17 = i12;
        int i18 = i13;
        DrmInitData drmInitData3 = drmInitData;
        StsdData stsdData2 = stsdData;
        parsableByteArray2.setPosition(i17 + 8 + 8);
        parsableByteArray2.skipBytes(16);
        int readUnsignedShort = parsableByteArray.readUnsignedShort();
        int readUnsignedShort2 = parsableByteArray.readUnsignedShort();
        parsableByteArray2.skipBytes(50);
        int position = parsableByteArray.getPosition();
        String str4 = null;
        int i19 = i11;
        if (i19 == 1701733238) {
            Pair<Integer, TrackEncryptionBox> parseSampleEntryEncryptionData = parseSampleEntryEncryptionData(parsableByteArray2, i17, i18);
            if (parseSampleEntryEncryptionData != null) {
                i19 = ((Integer) parseSampleEntryEncryptionData.first).intValue();
                if (drmInitData3 == null) {
                    drmInitData3 = null;
                } else {
                    drmInitData3 = drmInitData3.copyWithSchemeType(((TrackEncryptionBox) parseSampleEntryEncryptionData.second).schemeType);
                }
                stsdData2.trackEncryptionBoxes[i16] = (TrackEncryptionBox) parseSampleEntryEncryptionData.second;
            }
            parsableByteArray2.setPosition(position);
        }
        int i21 = -1;
        float f11 = 1.0f;
        boolean z11 = false;
        List<byte[]> list3 = null;
        String str5 = i19 == 1831958048 ? MimeTypes.VIDEO_MPEG : null;
        byte[] bArr = null;
        while (true) {
            if (position - i17 >= i18) {
                drmInitData2 = drmInitData3;
                list = list3;
                break;
            }
            parsableByteArray2.setPosition(position);
            int position2 = parsableByteArray.getPosition();
            drmInitData2 = drmInitData3;
            int readInt = parsableByteArray.readInt();
            if (readInt == 0) {
                list = list3;
                if (parsableByteArray.getPosition() - i17 == i18) {
                    break;
                }
            } else {
                list = list3;
            }
            Assertions.checkState(readInt > 0, "childAtomSize should be positive");
            int readInt2 = parsableByteArray.readInt();
            if (readInt2 == 1635148611) {
                Assertions.checkState(str5 == null);
                parsableByteArray2.setPosition(position2 + 8);
                AvcConfig parse = AvcConfig.parse(parsableByteArray);
                list2 = parse.initializationData;
                stsdData2.nalUnitLengthFieldLength = parse.nalUnitLengthFieldLength;
                if (!z11) {
                    f11 = parse.pixelWidthAspectRatio;
                }
                str2 = parse.codecs;
                str = "video/avc";
            } else if (readInt2 == 1752589123) {
                Assertions.checkState(str5 == null);
                parsableByteArray2.setPosition(position2 + 8);
                HevcConfig parse2 = HevcConfig.parse(parsableByteArray);
                list2 = parse2.initializationData;
                stsdData2.nalUnitLengthFieldLength = parse2.nalUnitLengthFieldLength;
                str2 = parse2.codecs;
                str = "video/hevc";
            } else {
                if (readInt2 == 1685480259 || readInt2 == 1685485123) {
                    DolbyVisionConfig parse3 = DolbyVisionConfig.parse(parsableByteArray);
                    if (parse3 != null) {
                        str4 = parse3.codecs;
                        str5 = "video/dolby-vision";
                    }
                } else {
                    if (readInt2 == 1987076931) {
                        Assertions.checkState(str5 == null);
                        str3 = i19 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                    } else if (readInt2 == 1635135811) {
                        Assertions.checkState(str5 == null);
                        str3 = "video/av01";
                    } else if (readInt2 == 1681012275) {
                        Assertions.checkState(str5 == null);
                        str3 = MimeTypes.VIDEO_H263;
                    } else {
                        if (readInt2 == 1702061171) {
                            Assertions.checkState(str5 == null);
                            Pair<String, byte[]> parseEsdsFromParent = parseEsdsFromParent(parsableByteArray2, position2);
                            String str6 = (String) parseEsdsFromParent.first;
                            byte[] bArr2 = (byte[]) parseEsdsFromParent.second;
                            list3 = bArr2 != null ? ImmutableList.of(bArr2) : list;
                            str5 = str6;
                        } else if (readInt2 == 1885434736) {
                            list3 = list;
                            f11 = parsePaspFromParent(parsableByteArray2, position2);
                            z11 = true;
                        } else if (readInt2 == 1937126244) {
                            list3 = list;
                            bArr = parseProjFromParent(parsableByteArray2, position2, readInt);
                        } else if (readInt2 == 1936995172) {
                            int readUnsignedByte = parsableByteArray.readUnsignedByte();
                            parsableByteArray2.skipBytes(3);
                            if (readUnsignedByte == 0) {
                                int readUnsignedByte2 = parsableByteArray.readUnsignedByte();
                                if (readUnsignedByte2 == 0) {
                                    list3 = list;
                                    i21 = 0;
                                } else if (readUnsignedByte2 == 1) {
                                    i21 = 1;
                                } else if (readUnsignedByte2 == 2) {
                                    list3 = list;
                                    i21 = 2;
                                } else if (readUnsignedByte2 == 3) {
                                    list3 = list;
                                    i21 = 3;
                                }
                            }
                        }
                        position += readInt;
                        i17 = i12;
                        i18 = i13;
                        drmInitData3 = drmInitData2;
                    }
                    list3 = list;
                    str5 = str3;
                    position += readInt;
                    i17 = i12;
                    i18 = i13;
                    drmInitData3 = drmInitData2;
                }
                list3 = list;
                position += readInt;
                i17 = i12;
                i18 = i13;
                drmInitData3 = drmInitData2;
            }
            list3 = list2;
            str5 = str;
            str4 = str2;
            position += readInt;
            i17 = i12;
            i18 = i13;
            drmInitData3 = drmInitData2;
        }
        if (str5 != null) {
            stsdData2.format = new Format.Builder().setId(i14).setSampleMimeType(str5).setCodecs(str4).setWidth(readUnsignedShort).setHeight(readUnsignedShort2).setPixelWidthHeightRatio(f11).setRotationDegrees(i15).setProjectionData(bArr).setStereoMode(i21).setInitializationData(list).setDrmInitData(drmInitData2).build();
        }
    }
}
