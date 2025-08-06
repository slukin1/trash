package com.google.android.exoplayer2.extractor.mp4;

import com.google.android.exoplayer2.extractor.ExtractorInput;
import com.google.android.exoplayer2.util.ParsableByteArray;
import java.io.IOException;

final class TrackFragment {
    public long atomPosition;
    public long auxiliaryDataPosition;
    public long dataPosition;
    public boolean definesEncryptionData;
    public DefaultSampleValues header;
    public long nextFragmentDecodeTime;
    public boolean nextFragmentDecodeTimeIncludesMoov;
    public int[] sampleCompositionTimeOffsetUsTable = new int[0];
    public int sampleCount;
    public long[] sampleDecodingTimeUsTable = new long[0];
    public final ParsableByteArray sampleEncryptionData = new ParsableByteArray();
    public boolean sampleEncryptionDataNeedsFill;
    public boolean[] sampleHasSubsampleEncryptionTable = new boolean[0];
    public boolean[] sampleIsSyncFrameTable = new boolean[0];
    public int[] sampleSizeTable = new int[0];
    public TrackEncryptionBox trackEncryptionBox;
    public int trunCount;
    public long[] trunDataPosition = new long[0];
    public int[] trunLength = new int[0];

    public void fillEncryptionData(ExtractorInput extractorInput) throws IOException {
        extractorInput.readFully(this.sampleEncryptionData.getData(), 0, this.sampleEncryptionData.limit());
        this.sampleEncryptionData.setPosition(0);
        this.sampleEncryptionDataNeedsFill = false;
    }

    public long getSamplePresentationTimeUs(int i11) {
        return this.sampleDecodingTimeUsTable[i11] + ((long) this.sampleCompositionTimeOffsetUsTable[i11]);
    }

    public void initEncryptionData(int i11) {
        this.sampleEncryptionData.reset(i11);
        this.definesEncryptionData = true;
        this.sampleEncryptionDataNeedsFill = true;
    }

    public void initTables(int i11, int i12) {
        this.trunCount = i11;
        this.sampleCount = i12;
        if (this.trunLength.length < i11) {
            this.trunDataPosition = new long[i11];
            this.trunLength = new int[i11];
        }
        if (this.sampleSizeTable.length < i12) {
            int i13 = (i12 * 125) / 100;
            this.sampleSizeTable = new int[i13];
            this.sampleCompositionTimeOffsetUsTable = new int[i13];
            this.sampleDecodingTimeUsTable = new long[i13];
            this.sampleIsSyncFrameTable = new boolean[i13];
            this.sampleHasSubsampleEncryptionTable = new boolean[i13];
        }
    }

    public void reset() {
        this.trunCount = 0;
        this.nextFragmentDecodeTime = 0;
        this.nextFragmentDecodeTimeIncludesMoov = false;
        this.definesEncryptionData = false;
        this.sampleEncryptionDataNeedsFill = false;
        this.trackEncryptionBox = null;
    }

    public boolean sampleHasSubsampleEncryptionTable(int i11) {
        return this.definesEncryptionData && this.sampleHasSubsampleEncryptionTable[i11];
    }

    public void fillEncryptionData(ParsableByteArray parsableByteArray) {
        parsableByteArray.readBytes(this.sampleEncryptionData.getData(), 0, this.sampleEncryptionData.limit());
        this.sampleEncryptionData.setPosition(0);
        this.sampleEncryptionDataNeedsFill = false;
    }
}
