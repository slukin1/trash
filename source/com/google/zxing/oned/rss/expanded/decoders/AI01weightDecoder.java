package com.google.zxing.oned.rss.expanded.decoders;

import com.google.android.exoplayer2.audio.AacUtil;
import com.google.zxing.common.BitArray;

abstract class AI01weightDecoder extends AI01decoder {
    public AI01weightDecoder(BitArray bitArray) {
        super(bitArray);
    }

    public abstract void addWeightCode(StringBuilder sb2, int i11);

    public abstract int checkWeight(int i11);

    public final void encodeCompressedWeight(StringBuilder sb2, int i11, int i12) {
        int extractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(i11, i12);
        addWeightCode(sb2, extractNumericValueFromBitArray);
        int checkWeight = checkWeight(extractNumericValueFromBitArray);
        int i13 = AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND;
        for (int i14 = 0; i14 < 5; i14++) {
            if (checkWeight / i13 == 0) {
                sb2.append('0');
            }
            i13 /= 10;
        }
        sb2.append(checkWeight);
    }
}
