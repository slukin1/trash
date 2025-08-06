package com.google.zxing.oned.rss.expanded.decoders;

import com.google.android.exoplayer2.audio.AacUtil;
import com.google.zxing.NotFoundException;
import com.google.zxing.common.BitArray;

final class AI013x0x1xDecoder extends AI01weightDecoder {
    private static final int DATE_SIZE = 16;
    private static final int HEADER_SIZE = 8;
    private static final int WEIGHT_SIZE = 20;
    private final String dateCode;
    private final String firstAIdigits;

    public AI013x0x1xDecoder(BitArray bitArray, String str, String str2) {
        super(bitArray);
        this.dateCode = str2;
        this.firstAIdigits = str;
    }

    private void encodeCompressedDate(StringBuilder sb2, int i11) {
        int extractNumericValueFromBitArray = getGeneralDecoder().extractNumericValueFromBitArray(i11, 16);
        if (extractNumericValueFromBitArray != 38400) {
            sb2.append('(');
            sb2.append(this.dateCode);
            sb2.append(')');
            int i12 = extractNumericValueFromBitArray % 32;
            int i13 = extractNumericValueFromBitArray / 32;
            int i14 = (i13 % 12) + 1;
            int i15 = i13 / 12;
            if (i15 / 10 == 0) {
                sb2.append('0');
            }
            sb2.append(i15);
            if (i14 / 10 == 0) {
                sb2.append('0');
            }
            sb2.append(i14);
            if (i12 / 10 == 0) {
                sb2.append('0');
            }
            sb2.append(i12);
        }
    }

    public void addWeightCode(StringBuilder sb2, int i11) {
        sb2.append('(');
        sb2.append(this.firstAIdigits);
        sb2.append(i11 / AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND);
        sb2.append(')');
    }

    public int checkWeight(int i11) {
        return i11 % AacUtil.AAC_LC_MAX_RATE_BYTES_PER_SECOND;
    }

    public String parseInformation() throws NotFoundException {
        if (getInformation().getSize() == 84) {
            StringBuilder sb2 = new StringBuilder();
            encodeCompressedGtin(sb2, 8);
            encodeCompressedWeight(sb2, 48, 20);
            encodeCompressedDate(sb2, 68);
            return sb2.toString();
        }
        throw NotFoundException.getNotFoundInstance();
    }
}
