package com.google.android.exoplayer2.extractor.ts;

import android.util.SparseArray;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;
import com.google.android.exoplayer2.util.Util;
import java.util.ArrayList;
import java.util.Arrays;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class H264Reader implements ElementaryStreamReader {
    private static final int NAL_UNIT_TYPE_PPS = 8;
    private static final int NAL_UNIT_TYPE_SEI = 6;
    private static final int NAL_UNIT_TYPE_SPS = 7;
    private final boolean allowNonIdrKeyframes;
    private final boolean detectAccessUnits;
    private String formatId;
    private boolean hasOutputFormat;
    private TrackOutput output;
    private long pesTimeUs;
    private final NalUnitTargetBuffer pps = new NalUnitTargetBuffer(8, 128);
    private final boolean[] prefixFlags = new boolean[3];
    private boolean randomAccessIndicator;
    private SampleReader sampleReader;
    private final NalUnitTargetBuffer sei = new NalUnitTargetBuffer(6, 128);
    private final SeiReader seiReader;
    private final ParsableByteArray seiWrapper = new ParsableByteArray();
    private final NalUnitTargetBuffer sps = new NalUnitTargetBuffer(7, 128);
    private long totalBytesWritten;

    public static final class SampleReader {
        private static final int DEFAULT_BUFFER_SIZE = 128;
        private static final int NAL_UNIT_TYPE_AUD = 9;
        private static final int NAL_UNIT_TYPE_IDR = 5;
        private static final int NAL_UNIT_TYPE_NON_IDR = 1;
        private static final int NAL_UNIT_TYPE_PARTITION_A = 2;
        private final boolean allowNonIdrKeyframes;
        private final ParsableNalUnitBitArray bitArray;
        private byte[] buffer;
        private int bufferLength;
        private final boolean detectAccessUnits;
        private boolean isFilling;
        private long nalUnitStartPosition;
        private long nalUnitTimeUs;
        private int nalUnitType;
        private final TrackOutput output;
        private final SparseArray<NalUnitUtil.PpsData> pps = new SparseArray<>();
        private SliceHeaderData previousSliceHeader = new SliceHeaderData();
        private boolean readingSample;
        private boolean sampleIsKeyframe;
        private long samplePosition;
        private long sampleTimeUs;
        private SliceHeaderData sliceHeader = new SliceHeaderData();
        private final SparseArray<NalUnitUtil.SpsData> sps = new SparseArray<>();

        public static final class SliceHeaderData {
            private static final int SLICE_TYPE_ALL_I = 7;
            private static final int SLICE_TYPE_I = 2;
            private boolean bottomFieldFlag;
            private boolean bottomFieldFlagPresent;
            private int deltaPicOrderCnt0;
            private int deltaPicOrderCnt1;
            private int deltaPicOrderCntBottom;
            private boolean fieldPicFlag;
            private int frameNum;
            private boolean hasSliceType;
            private boolean idrPicFlag;
            private int idrPicId;
            private boolean isComplete;
            private int nalRefIdc;
            private int picOrderCntLsb;
            private int picParameterSetId;
            private int sliceType;
            private NalUnitUtil.SpsData spsData;

            private SliceHeaderData() {
            }

            /* access modifiers changed from: private */
            public boolean isFirstVclNalUnitOfPicture(SliceHeaderData sliceHeaderData) {
                int i11;
                int i12;
                int i13;
                boolean z11;
                if (!this.isComplete) {
                    return false;
                }
                if (!sliceHeaderData.isComplete) {
                    return true;
                }
                NalUnitUtil.SpsData spsData2 = (NalUnitUtil.SpsData) Assertions.checkStateNotNull(this.spsData);
                NalUnitUtil.SpsData spsData3 = (NalUnitUtil.SpsData) Assertions.checkStateNotNull(sliceHeaderData.spsData);
                if (this.frameNum == sliceHeaderData.frameNum && this.picParameterSetId == sliceHeaderData.picParameterSetId && this.fieldPicFlag == sliceHeaderData.fieldPicFlag && ((!this.bottomFieldFlagPresent || !sliceHeaderData.bottomFieldFlagPresent || this.bottomFieldFlag == sliceHeaderData.bottomFieldFlag) && (((i11 = this.nalRefIdc) == (i12 = sliceHeaderData.nalRefIdc) || (i11 != 0 && i12 != 0)) && (((i13 = spsData2.picOrderCountType) != 0 || spsData3.picOrderCountType != 0 || (this.picOrderCntLsb == sliceHeaderData.picOrderCntLsb && this.deltaPicOrderCntBottom == sliceHeaderData.deltaPicOrderCntBottom)) && ((i13 != 1 || spsData3.picOrderCountType != 1 || (this.deltaPicOrderCnt0 == sliceHeaderData.deltaPicOrderCnt0 && this.deltaPicOrderCnt1 == sliceHeaderData.deltaPicOrderCnt1)) && (z11 = this.idrPicFlag) == sliceHeaderData.idrPicFlag && (!z11 || this.idrPicId == sliceHeaderData.idrPicId)))))) {
                    return false;
                }
                return true;
            }

            public void clear() {
                this.hasSliceType = false;
                this.isComplete = false;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
                r0 = r2.sliceType;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public boolean isISlice() {
                /*
                    r2 = this;
                    boolean r0 = r2.hasSliceType
                    if (r0 == 0) goto L_0x000e
                    int r0 = r2.sliceType
                    r1 = 7
                    if (r0 == r1) goto L_0x000c
                    r1 = 2
                    if (r0 != r1) goto L_0x000e
                L_0x000c:
                    r0 = 1
                    goto L_0x000f
                L_0x000e:
                    r0 = 0
                L_0x000f:
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader.SliceHeaderData.isISlice():boolean");
            }

            public void setAll(NalUnitUtil.SpsData spsData2, int i11, int i12, int i13, int i14, boolean z11, boolean z12, boolean z13, boolean z14, int i15, int i16, int i17, int i18, int i19) {
                this.spsData = spsData2;
                this.nalRefIdc = i11;
                this.sliceType = i12;
                this.frameNum = i13;
                this.picParameterSetId = i14;
                this.fieldPicFlag = z11;
                this.bottomFieldFlagPresent = z12;
                this.bottomFieldFlag = z13;
                this.idrPicFlag = z14;
                this.idrPicId = i15;
                this.picOrderCntLsb = i16;
                this.deltaPicOrderCntBottom = i17;
                this.deltaPicOrderCnt0 = i18;
                this.deltaPicOrderCnt1 = i19;
                this.isComplete = true;
                this.hasSliceType = true;
            }

            public void setSliceType(int i11) {
                this.sliceType = i11;
                this.hasSliceType = true;
            }
        }

        public SampleReader(TrackOutput trackOutput, boolean z11, boolean z12) {
            this.output = trackOutput;
            this.allowNonIdrKeyframes = z11;
            this.detectAccessUnits = z12;
            byte[] bArr = new byte[128];
            this.buffer = bArr;
            this.bitArray = new ParsableNalUnitBitArray(bArr, 0, 0);
            reset();
        }

        private void outputSample(int i11) {
            boolean z11 = this.sampleIsKeyframe;
            int i12 = (int) (this.nalUnitStartPosition - this.samplePosition);
            this.output.sampleMetadata(this.sampleTimeUs, z11 ? 1 : 0, i12, i11, (TrackOutput.CryptoData) null);
        }

        /* JADX WARNING: Removed duplicated region for block: B:51:0x00ff  */
        /* JADX WARNING: Removed duplicated region for block: B:52:0x0102  */
        /* JADX WARNING: Removed duplicated region for block: B:54:0x0106  */
        /* JADX WARNING: Removed duplicated region for block: B:58:0x0118  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x011e  */
        /* JADX WARNING: Removed duplicated region for block: B:72:0x0152  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void appendToNalUnit(byte[] r24, int r25, int r26) {
            /*
                r23 = this;
                r0 = r23
                r1 = r25
                boolean r2 = r0.isFilling
                if (r2 != 0) goto L_0x0009
                return
            L_0x0009:
                int r2 = r26 - r1
                byte[] r3 = r0.buffer
                int r4 = r3.length
                int r5 = r0.bufferLength
                int r6 = r5 + r2
                r7 = 2
                if (r4 >= r6) goto L_0x001d
                int r5 = r5 + r2
                int r5 = r5 * r7
                byte[] r3 = java.util.Arrays.copyOf(r3, r5)
                r0.buffer = r3
            L_0x001d:
                byte[] r3 = r0.buffer
                int r4 = r0.bufferLength
                r5 = r24
                java.lang.System.arraycopy(r5, r1, r3, r4, r2)
                int r1 = r0.bufferLength
                int r1 = r1 + r2
                r0.bufferLength = r1
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r2 = r0.bitArray
                byte[] r3 = r0.buffer
                r4 = 0
                r2.reset(r3, r4, r1)
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                r2 = 8
                boolean r1 = r1.canReadBits(r2)
                if (r1 != 0) goto L_0x003e
                return
            L_0x003e:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                r1.skipBit()
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                int r10 = r1.readBits(r7)
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                r2 = 5
                r1.skipBits(r2)
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                boolean r1 = r1.canReadExpGolombCodedNum()
                if (r1 != 0) goto L_0x0058
                return
            L_0x0058:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                r1.readUnsignedExpGolombCodedInt()
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                boolean r1 = r1.canReadExpGolombCodedNum()
                if (r1 != 0) goto L_0x0066
                return
            L_0x0066:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                int r11 = r1.readUnsignedExpGolombCodedInt()
                boolean r1 = r0.detectAccessUnits
                if (r1 != 0) goto L_0x0078
                r0.isFilling = r4
                com.google.android.exoplayer2.extractor.ts.H264Reader$SampleReader$SliceHeaderData r1 = r0.sliceHeader
                r1.setSliceType(r11)
                return
            L_0x0078:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                boolean r1 = r1.canReadExpGolombCodedNum()
                if (r1 != 0) goto L_0x0081
                return
            L_0x0081:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                int r13 = r1.readUnsignedExpGolombCodedInt()
                android.util.SparseArray<com.google.android.exoplayer2.util.NalUnitUtil$PpsData> r1 = r0.pps
                int r1 = r1.indexOfKey(r13)
                if (r1 >= 0) goto L_0x0092
                r0.isFilling = r4
                return
            L_0x0092:
                android.util.SparseArray<com.google.android.exoplayer2.util.NalUnitUtil$PpsData> r1 = r0.pps
                java.lang.Object r1 = r1.get(r13)
                com.google.android.exoplayer2.util.NalUnitUtil$PpsData r1 = (com.google.android.exoplayer2.util.NalUnitUtil.PpsData) r1
                android.util.SparseArray<com.google.android.exoplayer2.util.NalUnitUtil$SpsData> r3 = r0.sps
                int r5 = r1.seqParameterSetId
                java.lang.Object r3 = r3.get(r5)
                r9 = r3
                com.google.android.exoplayer2.util.NalUnitUtil$SpsData r9 = (com.google.android.exoplayer2.util.NalUnitUtil.SpsData) r9
                boolean r3 = r9.separateColorPlaneFlag
                if (r3 == 0) goto L_0x00b7
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r3 = r0.bitArray
                boolean r3 = r3.canReadBits(r7)
                if (r3 != 0) goto L_0x00b2
                return
            L_0x00b2:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r3 = r0.bitArray
                r3.skipBits(r7)
            L_0x00b7:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r3 = r0.bitArray
                int r5 = r9.frameNumLength
                boolean r3 = r3.canReadBits(r5)
                if (r3 != 0) goto L_0x00c2
                return
            L_0x00c2:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r3 = r0.bitArray
                int r5 = r9.frameNumLength
                int r12 = r3.readBits(r5)
                boolean r3 = r9.frameMbsOnlyFlag
                r5 = 1
                if (r3 != 0) goto L_0x00f7
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r3 = r0.bitArray
                boolean r3 = r3.canReadBits(r5)
                if (r3 != 0) goto L_0x00d8
                return
            L_0x00d8:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r3 = r0.bitArray
                boolean r3 = r3.readBit()
                if (r3 == 0) goto L_0x00f4
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r6 = r0.bitArray
                boolean r6 = r6.canReadBits(r5)
                if (r6 != 0) goto L_0x00e9
                return
            L_0x00e9:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r6 = r0.bitArray
                boolean r6 = r6.readBit()
                r14 = r3
                r15 = r5
                r16 = r6
                goto L_0x00fb
            L_0x00f4:
                r14 = r3
                r15 = r4
                goto L_0x00f9
            L_0x00f7:
                r14 = r4
                r15 = r14
            L_0x00f9:
                r16 = r15
            L_0x00fb:
                int r3 = r0.nalUnitType
                if (r3 != r2) goto L_0x0102
                r17 = r5
                goto L_0x0104
            L_0x0102:
                r17 = r4
            L_0x0104:
                if (r17 == 0) goto L_0x0118
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r2 = r0.bitArray
                boolean r2 = r2.canReadExpGolombCodedNum()
                if (r2 != 0) goto L_0x010f
                return
            L_0x010f:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r2 = r0.bitArray
                int r2 = r2.readUnsignedExpGolombCodedInt()
                r18 = r2
                goto L_0x011a
            L_0x0118:
                r18 = r4
            L_0x011a:
                int r2 = r9.picOrderCountType
                if (r2 != 0) goto L_0x0152
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r2 = r0.bitArray
                int r3 = r9.picOrderCntLsbLength
                boolean r2 = r2.canReadBits(r3)
                if (r2 != 0) goto L_0x0129
                return
            L_0x0129:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r2 = r0.bitArray
                int r3 = r9.picOrderCntLsbLength
                int r2 = r2.readBits(r3)
                boolean r1 = r1.bottomFieldPicOrderInFramePresentFlag
                if (r1 == 0) goto L_0x014d
                if (r14 != 0) goto L_0x014d
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                boolean r1 = r1.canReadExpGolombCodedNum()
                if (r1 != 0) goto L_0x0140
                return
            L_0x0140:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                int r1 = r1.readSignedExpGolombCodedInt()
                r20 = r1
                r19 = r2
                r21 = r4
                goto L_0x0194
            L_0x014d:
                r19 = r2
                r20 = r4
                goto L_0x0192
            L_0x0152:
                if (r2 != r5) goto L_0x018e
                boolean r2 = r9.deltaPicOrderAlwaysZeroFlag
                if (r2 != 0) goto L_0x018e
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r2 = r0.bitArray
                boolean r2 = r2.canReadExpGolombCodedNum()
                if (r2 != 0) goto L_0x0161
                return
            L_0x0161:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r2 = r0.bitArray
                int r2 = r2.readSignedExpGolombCodedInt()
                boolean r1 = r1.bottomFieldPicOrderInFramePresentFlag
                if (r1 == 0) goto L_0x0185
                if (r14 != 0) goto L_0x0185
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                boolean r1 = r1.canReadExpGolombCodedNum()
                if (r1 != 0) goto L_0x0176
                return
            L_0x0176:
                com.google.android.exoplayer2.util.ParsableNalUnitBitArray r1 = r0.bitArray
                int r1 = r1.readSignedExpGolombCodedInt()
                r22 = r1
                r21 = r2
                r19 = r4
                r20 = r19
                goto L_0x0196
            L_0x0185:
                r21 = r2
                r19 = r4
                r20 = r19
                r22 = r20
                goto L_0x0196
            L_0x018e:
                r19 = r4
                r20 = r19
            L_0x0192:
                r21 = r20
            L_0x0194:
                r22 = r21
            L_0x0196:
                com.google.android.exoplayer2.extractor.ts.H264Reader$SampleReader$SliceHeaderData r8 = r0.sliceHeader
                r8.setAll(r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21, r22)
                r0.isFilling = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.extractor.ts.H264Reader.SampleReader.appendToNalUnit(byte[], int, int):void");
        }

        public boolean endNalUnit(long j11, int i11, boolean z11, boolean z12) {
            boolean z13 = false;
            if (this.nalUnitType == 9 || (this.detectAccessUnits && this.sliceHeader.isFirstVclNalUnitOfPicture(this.previousSliceHeader))) {
                if (z11 && this.readingSample) {
                    outputSample(i11 + ((int) (j11 - this.nalUnitStartPosition)));
                }
                this.samplePosition = this.nalUnitStartPosition;
                this.sampleTimeUs = this.nalUnitTimeUs;
                this.sampleIsKeyframe = false;
                this.readingSample = true;
            }
            if (this.allowNonIdrKeyframes) {
                z12 = this.sliceHeader.isISlice();
            }
            boolean z14 = this.sampleIsKeyframe;
            int i12 = this.nalUnitType;
            if (i12 == 5 || (z12 && i12 == 1)) {
                z13 = true;
            }
            boolean z15 = z14 | z13;
            this.sampleIsKeyframe = z15;
            return z15;
        }

        public boolean needsSpsPps() {
            return this.detectAccessUnits;
        }

        public void putPps(NalUnitUtil.PpsData ppsData) {
            this.pps.append(ppsData.picParameterSetId, ppsData);
        }

        public void putSps(NalUnitUtil.SpsData spsData) {
            this.sps.append(spsData.seqParameterSetId, spsData);
        }

        public void reset() {
            this.isFilling = false;
            this.readingSample = false;
            this.sliceHeader.clear();
        }

        public void startNalUnit(long j11, int i11, long j12) {
            this.nalUnitType = i11;
            this.nalUnitTimeUs = j12;
            this.nalUnitStartPosition = j11;
            if (!this.allowNonIdrKeyframes || i11 != 1) {
                if (!this.detectAccessUnits) {
                    return;
                }
                if (!(i11 == 5 || i11 == 1 || i11 == 2)) {
                    return;
                }
            }
            SliceHeaderData sliceHeaderData = this.previousSliceHeader;
            this.previousSliceHeader = this.sliceHeader;
            this.sliceHeader = sliceHeaderData;
            sliceHeaderData.clear();
            this.bufferLength = 0;
            this.isFilling = true;
        }
    }

    public H264Reader(SeiReader seiReader2, boolean z11, boolean z12) {
        this.seiReader = seiReader2;
        this.allowNonIdrKeyframes = z11;
        this.detectAccessUnits = z12;
    }

    @EnsuresNonNull({"output", "sampleReader"})
    private void assertTracksCreated() {
        Assertions.checkStateNotNull(this.output);
        Util.castNonNull(this.sampleReader);
    }

    @RequiresNonNull({"output", "sampleReader"})
    private void endNalUnit(long j11, int i11, int i12, long j12) {
        if (!this.hasOutputFormat || this.sampleReader.needsSpsPps()) {
            this.sps.endNalUnit(i12);
            this.pps.endNalUnit(i12);
            if (!this.hasOutputFormat) {
                if (this.sps.isCompleted() && this.pps.isCompleted()) {
                    ArrayList arrayList = new ArrayList();
                    NalUnitTargetBuffer nalUnitTargetBuffer = this.sps;
                    arrayList.add(Arrays.copyOf(nalUnitTargetBuffer.nalData, nalUnitTargetBuffer.nalLength));
                    NalUnitTargetBuffer nalUnitTargetBuffer2 = this.pps;
                    arrayList.add(Arrays.copyOf(nalUnitTargetBuffer2.nalData, nalUnitTargetBuffer2.nalLength));
                    NalUnitTargetBuffer nalUnitTargetBuffer3 = this.sps;
                    NalUnitUtil.SpsData parseSpsNalUnit = NalUnitUtil.parseSpsNalUnit(nalUnitTargetBuffer3.nalData, 3, nalUnitTargetBuffer3.nalLength);
                    NalUnitTargetBuffer nalUnitTargetBuffer4 = this.pps;
                    NalUnitUtil.PpsData parsePpsNalUnit = NalUnitUtil.parsePpsNalUnit(nalUnitTargetBuffer4.nalData, 3, nalUnitTargetBuffer4.nalLength);
                    this.output.format(new Format.Builder().setId(this.formatId).setSampleMimeType("video/avc").setCodecs(CodecSpecificDataUtil.buildAvcCodecString(parseSpsNalUnit.profileIdc, parseSpsNalUnit.constraintsFlagsAndReservedZero2Bits, parseSpsNalUnit.levelIdc)).setWidth(parseSpsNalUnit.width).setHeight(parseSpsNalUnit.height).setPixelWidthHeightRatio(parseSpsNalUnit.pixelWidthAspectRatio).setInitializationData(arrayList).build());
                    this.hasOutputFormat = true;
                    this.sampleReader.putSps(parseSpsNalUnit);
                    this.sampleReader.putPps(parsePpsNalUnit);
                    this.sps.reset();
                    this.pps.reset();
                }
            } else if (this.sps.isCompleted()) {
                NalUnitTargetBuffer nalUnitTargetBuffer5 = this.sps;
                this.sampleReader.putSps(NalUnitUtil.parseSpsNalUnit(nalUnitTargetBuffer5.nalData, 3, nalUnitTargetBuffer5.nalLength));
                this.sps.reset();
            } else if (this.pps.isCompleted()) {
                NalUnitTargetBuffer nalUnitTargetBuffer6 = this.pps;
                this.sampleReader.putPps(NalUnitUtil.parsePpsNalUnit(nalUnitTargetBuffer6.nalData, 3, nalUnitTargetBuffer6.nalLength));
                this.pps.reset();
            }
        }
        if (this.sei.endNalUnit(i12)) {
            NalUnitTargetBuffer nalUnitTargetBuffer7 = this.sei;
            this.seiWrapper.reset(this.sei.nalData, NalUnitUtil.unescapeStream(nalUnitTargetBuffer7.nalData, nalUnitTargetBuffer7.nalLength));
            this.seiWrapper.setPosition(4);
            this.seiReader.consume(j12, this.seiWrapper);
        }
        if (this.sampleReader.endNalUnit(j11, i11, this.hasOutputFormat, this.randomAccessIndicator)) {
            this.randomAccessIndicator = false;
        }
    }

    @RequiresNonNull({"sampleReader"})
    private void nalUnitData(byte[] bArr, int i11, int i12) {
        if (!this.hasOutputFormat || this.sampleReader.needsSpsPps()) {
            this.sps.appendToNalUnit(bArr, i11, i12);
            this.pps.appendToNalUnit(bArr, i11, i12);
        }
        this.sei.appendToNalUnit(bArr, i11, i12);
        this.sampleReader.appendToNalUnit(bArr, i11, i12);
    }

    @RequiresNonNull({"sampleReader"})
    private void startNalUnit(long j11, int i11, long j12) {
        if (!this.hasOutputFormat || this.sampleReader.needsSpsPps()) {
            this.sps.startNalUnit(i11);
            this.pps.startNalUnit(i11);
        }
        this.sei.startNalUnit(i11);
        this.sampleReader.startNalUnit(j11, i11, j12);
    }

    public void consume(ParsableByteArray parsableByteArray) {
        assertTracksCreated();
        int position = parsableByteArray.getPosition();
        int limit = parsableByteArray.limit();
        byte[] data = parsableByteArray.getData();
        this.totalBytesWritten += (long) parsableByteArray.bytesLeft();
        this.output.sampleData(parsableByteArray, parsableByteArray.bytesLeft());
        while (true) {
            int findNalUnit = NalUnitUtil.findNalUnit(data, position, limit, this.prefixFlags);
            if (findNalUnit == limit) {
                nalUnitData(data, position, limit);
                return;
            }
            int nalUnitType = NalUnitUtil.getNalUnitType(data, findNalUnit);
            int i11 = findNalUnit - position;
            if (i11 > 0) {
                nalUnitData(data, position, findNalUnit);
            }
            int i12 = limit - findNalUnit;
            long j11 = this.totalBytesWritten - ((long) i12);
            endNalUnit(j11, i12, i11 < 0 ? -i11 : 0, this.pesTimeUs);
            startNalUnit(j11, nalUnitType, this.pesTimeUs);
            position = findNalUnit + 3;
        }
    }

    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        this.output = track;
        this.sampleReader = new SampleReader(track, this.allowNonIdrKeyframes, this.detectAccessUnits);
        this.seiReader.createTracks(extractorOutput, trackIdGenerator);
    }

    public void packetFinished() {
    }

    public void packetStarted(long j11, int i11) {
        this.pesTimeUs = j11;
        this.randomAccessIndicator |= (i11 & 2) != 0;
    }

    public void seek() {
        this.totalBytesWritten = 0;
        this.randomAccessIndicator = false;
        NalUnitUtil.clearPrefixFlags(this.prefixFlags);
        this.sps.reset();
        this.pps.reset();
        this.sei.reset();
        SampleReader sampleReader2 = this.sampleReader;
        if (sampleReader2 != null) {
            sampleReader2.reset();
        }
    }
}
