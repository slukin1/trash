package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.common.BitArray;

final class AI013103decoder extends AI013x0xDecoder {
    public AI013103decoder(BitArray bitArray) {
        super(bitArray);
    }

    public void addWeightCode(StringBuilder sb2, int i11) {
        sb2.append("(3103)");
    }

    public int checkWeight(int i11) {
        return i11;
    }
}
