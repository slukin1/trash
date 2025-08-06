package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

final class AI01320xDecoder extends AI013x0xDecoder {
    public AI01320xDecoder(BitArray bitArray) {
        super(bitArray);
    }

    public void addWeightCode(StringBuilder sb2, int i11) {
        if (i11 < 10000) {
            sb2.append("(3202)");
        } else {
            sb2.append("(3203)");
        }
    }

    public int checkWeight(int i11) {
        return i11 < 10000 ? i11 : i11 - 10000;
    }
}
