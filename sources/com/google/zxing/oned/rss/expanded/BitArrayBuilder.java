package com.google.zxing.oned.rss.expanded;

import com.google.zxing.common.BitArray;
import java.util.List;

final class BitArrayBuilder {
    private BitArrayBuilder() {
    }

    public static BitArray buildBitArray(List<ExpandedPair> list) {
        int size = (list.size() << 1) - 1;
        if (list.get(list.size() - 1).getRightChar() == null) {
            size--;
        }
        BitArray bitArray = new BitArray(size * 12);
        int i11 = 0;
        int value = list.get(0).getRightChar().getValue();
        for (int i12 = 11; i12 >= 0; i12--) {
            if (((1 << i12) & value) != 0) {
                bitArray.set(i11);
            }
            i11++;
        }
        for (int i13 = 1; i13 < list.size(); i13++) {
            ExpandedPair expandedPair = list.get(i13);
            int value2 = expandedPair.getLeftChar().getValue();
            for (int i14 = 11; i14 >= 0; i14--) {
                if (((1 << i14) & value2) != 0) {
                    bitArray.set(i11);
                }
                i11++;
            }
            if (expandedPair.getRightChar() != null) {
                int value3 = expandedPair.getRightChar().getValue();
                for (int i15 = 11; i15 >= 0; i15--) {
                    if (((1 << i15) & value3) != 0) {
                        bitArray.set(i11);
                    }
                    i11++;
                }
            }
        }
        return bitArray;
    }
}
