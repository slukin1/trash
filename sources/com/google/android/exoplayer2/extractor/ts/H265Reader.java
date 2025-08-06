package com.google.android.exoplayer2.extractor.ts;

import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.ExtractorOutput;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.extractor.ts.TsPayloadReader;
import com.google.android.exoplayer2.util.Assertions;
import com.google.android.exoplayer2.util.CodecSpecificDataUtil;
import com.google.android.exoplayer2.util.Log;
import com.google.android.exoplayer2.util.NalUnitUtil;
import com.google.android.exoplayer2.util.ParsableByteArray;
import com.google.android.exoplayer2.util.ParsableNalUnitBitArray;
import com.google.android.exoplayer2.util.Util;
import java.util.Collections;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.RequiresNonNull;

public final class H265Reader implements ElementaryStreamReader {
    private static final int AUD_NUT = 35;
    private static final int BLA_W_LP = 16;
    private static final int CRA_NUT = 21;
    private static final int PPS_NUT = 34;
    private static final int PREFIX_SEI_NUT = 39;
    private static final int RASL_R = 9;
    private static final int SPS_NUT = 33;
    private static final int SUFFIX_SEI_NUT = 40;
    private static final String TAG = "H265Reader";
    private static final int VPS_NUT = 32;
    private String formatId;
    private boolean hasOutputFormat;
    private TrackOutput output;
    private long pesTimeUs;
    private final NalUnitTargetBuffer pps = new NalUnitTargetBuffer(34, 128);
    private final boolean[] prefixFlags = new boolean[3];
    private final NalUnitTargetBuffer prefixSei = new NalUnitTargetBuffer(39, 128);
    private SampleReader sampleReader;
    private final SeiReader seiReader;
    private final ParsableByteArray seiWrapper = new ParsableByteArray();
    private final NalUnitTargetBuffer sps = new NalUnitTargetBuffer(33, 128);
    private final NalUnitTargetBuffer suffixSei = new NalUnitTargetBuffer(40, 128);
    private long totalBytesWritten;
    private final NalUnitTargetBuffer vps = new NalUnitTargetBuffer(32, 128);

    public static final class SampleReader {
        private static final int FIRST_SLICE_FLAG_OFFSET = 2;
        private boolean isFirstPrefixNalUnit;
        private boolean isFirstSlice;
        private boolean lookingForFirstSliceFlag;
        private int nalUnitBytesRead;
        private boolean nalUnitHasKeyframeData;
        private long nalUnitPosition;
        private long nalUnitTimeUs;
        private final TrackOutput output;
        private boolean readingPrefix;
        private boolean readingSample;
        private boolean sampleIsKeyframe;
        private long samplePosition;
        private long sampleTimeUs;

        public SampleReader(TrackOutput trackOutput) {
            this.output = trackOutput;
        }

        private static boolean isPrefixNalUnit(int i11) {
            return (32 <= i11 && i11 <= 35) || i11 == 39;
        }

        private static boolean isVclBodyNalUnit(int i11) {
            return i11 < 32 || i11 == 40;
        }

        private void outputSample(int i11) {
            boolean z11 = this.sampleIsKeyframe;
            int i12 = (int) (this.nalUnitPosition - this.samplePosition);
            this.output.sampleMetadata(this.sampleTimeUs, z11 ? 1 : 0, i12, i11, (TrackOutput.CryptoData) null);
        }

        public void endNalUnit(long j11, int i11, boolean z11) {
            if (this.readingPrefix && this.isFirstSlice) {
                this.sampleIsKeyframe = this.nalUnitHasKeyframeData;
                this.readingPrefix = false;
            } else if (this.isFirstPrefixNalUnit || this.isFirstSlice) {
                if (z11 && this.readingSample) {
                    outputSample(i11 + ((int) (j11 - this.nalUnitPosition)));
                }
                this.samplePosition = this.nalUnitPosition;
                this.sampleTimeUs = this.nalUnitTimeUs;
                this.sampleIsKeyframe = this.nalUnitHasKeyframeData;
                this.readingSample = true;
            }
        }

        public void readNalUnitData(byte[] bArr, int i11, int i12) {
            if (this.lookingForFirstSliceFlag) {
                int i13 = this.nalUnitBytesRead;
                int i14 = (i11 + 2) - i13;
                if (i14 < i12) {
                    this.isFirstSlice = (bArr[i14] & 128) != 0;
                    this.lookingForFirstSliceFlag = false;
                    return;
                }
                this.nalUnitBytesRead = i13 + (i12 - i11);
            }
        }

        public void reset() {
            this.lookingForFirstSliceFlag = false;
            this.isFirstSlice = false;
            this.isFirstPrefixNalUnit = false;
            this.readingSample = false;
            this.readingPrefix = false;
        }

        public void startNalUnit(long j11, int i11, int i12, long j12, boolean z11) {
            boolean z12 = false;
            this.isFirstSlice = false;
            this.isFirstPrefixNalUnit = false;
            this.nalUnitTimeUs = j12;
            this.nalUnitBytesRead = 0;
            this.nalUnitPosition = j11;
            if (!isVclBodyNalUnit(i12)) {
                if (this.readingSample && !this.readingPrefix) {
                    if (z11) {
                        outputSample(i11);
                    }
                    this.readingSample = false;
                }
                if (isPrefixNalUnit(i12)) {
                    this.isFirstPrefixNalUnit = !this.readingPrefix;
                    this.readingPrefix = true;
                }
            }
            boolean z13 = i12 >= 16 && i12 <= 21;
            this.nalUnitHasKeyframeData = z13;
            if (z13 || i12 <= 9) {
                z12 = true;
            }
            this.lookingForFirstSliceFlag = z12;
        }
    }

    public H265Reader(SeiReader seiReader2) {
        this.seiReader = seiReader2;
    }

    @EnsuresNonNull({"output", "sampleReader"})
    private void assertTracksCreated() {
        Assertions.checkStateNotNull(this.output);
        Util.castNonNull(this.sampleReader);
    }

    @RequiresNonNull({"output", "sampleReader"})
    private void endNalUnit(long j11, int i11, int i12, long j12) {
        this.sampleReader.endNalUnit(j11, i11, this.hasOutputFormat);
        if (!this.hasOutputFormat) {
            this.vps.endNalUnit(i12);
            this.sps.endNalUnit(i12);
            this.pps.endNalUnit(i12);
            if (this.vps.isCompleted() && this.sps.isCompleted() && this.pps.isCompleted()) {
                this.output.format(parseMediaFormat(this.formatId, this.vps, this.sps, this.pps));
                this.hasOutputFormat = true;
            }
        }
        if (this.prefixSei.endNalUnit(i12)) {
            NalUnitTargetBuffer nalUnitTargetBuffer = this.prefixSei;
            this.seiWrapper.reset(this.prefixSei.nalData, NalUnitUtil.unescapeStream(nalUnitTargetBuffer.nalData, nalUnitTargetBuffer.nalLength));
            this.seiWrapper.skipBytes(5);
            this.seiReader.consume(j12, this.seiWrapper);
        }
        if (this.suffixSei.endNalUnit(i12)) {
            NalUnitTargetBuffer nalUnitTargetBuffer2 = this.suffixSei;
            this.seiWrapper.reset(this.suffixSei.nalData, NalUnitUtil.unescapeStream(nalUnitTargetBuffer2.nalData, nalUnitTargetBuffer2.nalLength));
            this.seiWrapper.skipBytes(5);
            this.seiReader.consume(j12, this.seiWrapper);
        }
    }

    @RequiresNonNull({"sampleReader"})
    private void nalUnitData(byte[] bArr, int i11, int i12) {
        this.sampleReader.readNalUnitData(bArr, i11, i12);
        if (!this.hasOutputFormat) {
            this.vps.appendToNalUnit(bArr, i11, i12);
            this.sps.appendToNalUnit(bArr, i11, i12);
            this.pps.appendToNalUnit(bArr, i11, i12);
        }
        this.prefixSei.appendToNalUnit(bArr, i11, i12);
        this.suffixSei.appendToNalUnit(bArr, i11, i12);
    }

    private static Format parseMediaFormat(String str, NalUnitTargetBuffer nalUnitTargetBuffer, NalUnitTargetBuffer nalUnitTargetBuffer2, NalUnitTargetBuffer nalUnitTargetBuffer3) {
        NalUnitTargetBuffer nalUnitTargetBuffer4 = nalUnitTargetBuffer;
        NalUnitTargetBuffer nalUnitTargetBuffer5 = nalUnitTargetBuffer2;
        NalUnitTargetBuffer nalUnitTargetBuffer6 = nalUnitTargetBuffer3;
        int i11 = nalUnitTargetBuffer4.nalLength;
        byte[] bArr = new byte[(nalUnitTargetBuffer5.nalLength + i11 + nalUnitTargetBuffer6.nalLength)];
        System.arraycopy(nalUnitTargetBuffer4.nalData, 0, bArr, 0, i11);
        System.arraycopy(nalUnitTargetBuffer5.nalData, 0, bArr, nalUnitTargetBuffer4.nalLength, nalUnitTargetBuffer5.nalLength);
        System.arraycopy(nalUnitTargetBuffer6.nalData, 0, bArr, nalUnitTargetBuffer4.nalLength + nalUnitTargetBuffer5.nalLength, nalUnitTargetBuffer6.nalLength);
        ParsableNalUnitBitArray parsableNalUnitBitArray = new ParsableNalUnitBitArray(nalUnitTargetBuffer5.nalData, 0, nalUnitTargetBuffer5.nalLength);
        parsableNalUnitBitArray.skipBits(44);
        int readBits = parsableNalUnitBitArray.readBits(3);
        parsableNalUnitBitArray.skipBit();
        parsableNalUnitBitArray.skipBits(88);
        parsableNalUnitBitArray.skipBits(8);
        int i12 = 0;
        for (int i13 = 0; i13 < readBits; i13++) {
            if (parsableNalUnitBitArray.readBit()) {
                i12 += 89;
            }
            if (parsableNalUnitBitArray.readBit()) {
                i12 += 8;
            }
        }
        parsableNalUnitBitArray.skipBits(i12);
        if (readBits > 0) {
            parsableNalUnitBitArray.skipBits((8 - readBits) * 2);
        }
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (readUnsignedExpGolombCodedInt == 3) {
            parsableNalUnitBitArray.skipBit();
        }
        int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (parsableNalUnitBitArray.readBit()) {
            int readUnsignedExpGolombCodedInt4 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt5 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt6 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            int readUnsignedExpGolombCodedInt7 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            readUnsignedExpGolombCodedInt2 -= ((readUnsignedExpGolombCodedInt == 1 || readUnsignedExpGolombCodedInt == 2) ? 2 : 1) * (readUnsignedExpGolombCodedInt4 + readUnsignedExpGolombCodedInt5);
            readUnsignedExpGolombCodedInt3 -= (readUnsignedExpGolombCodedInt == 1 ? 2 : 1) * (readUnsignedExpGolombCodedInt6 + readUnsignedExpGolombCodedInt7);
        }
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        int readUnsignedExpGolombCodedInt8 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        for (int i14 = parsableNalUnitBitArray.readBit() ? 0 : readBits; i14 <= readBits; i14++) {
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        }
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        if (parsableNalUnitBitArray.readBit() && parsableNalUnitBitArray.readBit()) {
            skipScalingList(parsableNalUnitBitArray);
        }
        parsableNalUnitBitArray.skipBits(2);
        if (parsableNalUnitBitArray.readBit()) {
            parsableNalUnitBitArray.skipBits(8);
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            parsableNalUnitBitArray.skipBit();
        }
        skipShortTermRefPicSets(parsableNalUnitBitArray);
        if (parsableNalUnitBitArray.readBit()) {
            for (int i15 = 0; i15 < parsableNalUnitBitArray.readUnsignedExpGolombCodedInt(); i15++) {
                parsableNalUnitBitArray.skipBits(readUnsignedExpGolombCodedInt8 + 4 + 1);
            }
        }
        parsableNalUnitBitArray.skipBits(2);
        float f11 = 1.0f;
        if (parsableNalUnitBitArray.readBit()) {
            if (parsableNalUnitBitArray.readBit()) {
                int readBits2 = parsableNalUnitBitArray.readBits(8);
                if (readBits2 == 255) {
                    int readBits3 = parsableNalUnitBitArray.readBits(16);
                    int readBits4 = parsableNalUnitBitArray.readBits(16);
                    if (!(readBits3 == 0 || readBits4 == 0)) {
                        f11 = ((float) readBits3) / ((float) readBits4);
                    }
                } else {
                    float[] fArr = NalUnitUtil.ASPECT_RATIO_IDC_VALUES;
                    if (readBits2 < fArr.length) {
                        f11 = fArr[readBits2];
                    } else {
                        StringBuilder sb2 = new StringBuilder(46);
                        sb2.append("Unexpected aspect_ratio_idc value: ");
                        sb2.append(readBits2);
                        Log.w(TAG, sb2.toString());
                    }
                }
            }
            if (parsableNalUnitBitArray.readBit()) {
                parsableNalUnitBitArray.skipBit();
            }
            if (parsableNalUnitBitArray.readBit()) {
                parsableNalUnitBitArray.skipBits(4);
                if (parsableNalUnitBitArray.readBit()) {
                    parsableNalUnitBitArray.skipBits(24);
                }
            }
            if (parsableNalUnitBitArray.readBit()) {
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
            }
            parsableNalUnitBitArray.skipBit();
            if (parsableNalUnitBitArray.readBit()) {
                readUnsignedExpGolombCodedInt3 *= 2;
            }
        }
        parsableNalUnitBitArray.reset(nalUnitTargetBuffer5.nalData, 0, nalUnitTargetBuffer5.nalLength);
        parsableNalUnitBitArray.skipBits(24);
        return new Format.Builder().setId(str).setSampleMimeType("video/hevc").setCodecs(CodecSpecificDataUtil.buildHevcCodecStringFromSps(parsableNalUnitBitArray)).setWidth(readUnsignedExpGolombCodedInt2).setHeight(readUnsignedExpGolombCodedInt3).setPixelWidthHeightRatio(f11).setInitializationData(Collections.singletonList(bArr)).build();
    }

    private static void skipScalingList(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        for (int i11 = 0; i11 < 4; i11++) {
            int i12 = 0;
            while (i12 < 6) {
                int i13 = 1;
                if (!parsableNalUnitBitArray.readBit()) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                } else {
                    int min = Math.min(64, 1 << ((i11 << 1) + 4));
                    if (i11 > 1) {
                        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                    }
                    for (int i14 = 0; i14 < min; i14++) {
                        parsableNalUnitBitArray.readSignedExpGolombCodedInt();
                    }
                }
                if (i11 == 3) {
                    i13 = 3;
                }
                i12 += i13;
            }
        }
    }

    private static void skipShortTermRefPicSets(ParsableNalUnitBitArray parsableNalUnitBitArray) {
        int readUnsignedExpGolombCodedInt = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
        boolean z11 = false;
        int i11 = 0;
        for (int i12 = 0; i12 < readUnsignedExpGolombCodedInt; i12++) {
            if (i12 != 0) {
                z11 = parsableNalUnitBitArray.readBit();
            }
            if (z11) {
                parsableNalUnitBitArray.skipBit();
                parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                for (int i13 = 0; i13 <= i11; i13++) {
                    if (parsableNalUnitBitArray.readBit()) {
                        parsableNalUnitBitArray.skipBit();
                    }
                }
            } else {
                int readUnsignedExpGolombCodedInt2 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int readUnsignedExpGolombCodedInt3 = parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                int i14 = readUnsignedExpGolombCodedInt2 + readUnsignedExpGolombCodedInt3;
                for (int i15 = 0; i15 < readUnsignedExpGolombCodedInt2; i15++) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    parsableNalUnitBitArray.skipBit();
                }
                for (int i16 = 0; i16 < readUnsignedExpGolombCodedInt3; i16++) {
                    parsableNalUnitBitArray.readUnsignedExpGolombCodedInt();
                    parsableNalUnitBitArray.skipBit();
                }
                i11 = i14;
            }
        }
    }

    @RequiresNonNull({"sampleReader"})
    private void startNalUnit(long j11, int i11, int i12, long j12) {
        this.sampleReader.startNalUnit(j11, i11, i12, j12, this.hasOutputFormat);
        if (!this.hasOutputFormat) {
            this.vps.startNalUnit(i12);
            this.sps.startNalUnit(i12);
            this.pps.startNalUnit(i12);
        }
        this.prefixSei.startNalUnit(i12);
        this.suffixSei.startNalUnit(i12);
    }

    public void consume(ParsableByteArray parsableByteArray) {
        assertTracksCreated();
        while (parsableByteArray.bytesLeft() > 0) {
            int position = parsableByteArray.getPosition();
            int limit = parsableByteArray.limit();
            byte[] data = parsableByteArray.getData();
            this.totalBytesWritten += (long) parsableByteArray.bytesLeft();
            this.output.sampleData(parsableByteArray, parsableByteArray.bytesLeft());
            while (true) {
                if (position < limit) {
                    int findNalUnit = NalUnitUtil.findNalUnit(data, position, limit, this.prefixFlags);
                    if (findNalUnit == limit) {
                        nalUnitData(data, position, limit);
                        return;
                    }
                    int h265NalUnitType = NalUnitUtil.getH265NalUnitType(data, findNalUnit);
                    int i11 = findNalUnit - position;
                    if (i11 > 0) {
                        nalUnitData(data, position, findNalUnit);
                    }
                    int i12 = limit - findNalUnit;
                    long j11 = this.totalBytesWritten - ((long) i12);
                    int i13 = i11 < 0 ? -i11 : 0;
                    long j12 = j11;
                    int i14 = i12;
                    endNalUnit(j12, i14, i13, this.pesTimeUs);
                    startNalUnit(j12, i14, h265NalUnitType, this.pesTimeUs);
                    position = findNalUnit + 3;
                }
            }
        }
    }

    public void createTracks(ExtractorOutput extractorOutput, TsPayloadReader.TrackIdGenerator trackIdGenerator) {
        trackIdGenerator.generateNewId();
        this.formatId = trackIdGenerator.getFormatId();
        TrackOutput track = extractorOutput.track(trackIdGenerator.getTrackId(), 2);
        this.output = track;
        this.sampleReader = new SampleReader(track);
        this.seiReader.createTracks(extractorOutput, trackIdGenerator);
    }

    public void packetFinished() {
    }

    public void packetStarted(long j11, int i11) {
        this.pesTimeUs = j11;
    }

    public void seek() {
        this.totalBytesWritten = 0;
        NalUnitUtil.clearPrefixFlags(this.prefixFlags);
        this.vps.reset();
        this.sps.reset();
        this.pps.reset();
        this.prefixSei.reset();
        this.suffixSei.reset();
        SampleReader sampleReader2 = this.sampleReader;
        if (sampleReader2 != null) {
            sampleReader2.reset();
        }
    }
}
