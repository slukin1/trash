package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import java.util.Map;

public abstract class OneDimensionalCodeWriter implements Writer {
    public static int appendPattern(boolean[] zArr, int i11, int[] iArr, boolean z11) {
        int i12 = 0;
        for (int i13 : iArr) {
            int i14 = 0;
            while (i14 < i13) {
                zArr[i11] = z11;
                i14++;
                i11++;
            }
            i12 += i13;
            z11 = !z11;
        }
        return i12;
    }

    private static BitMatrix renderResult(boolean[] zArr, int i11, int i12, int i13) {
        int length = zArr.length;
        int i14 = i13 + length;
        int max = Math.max(i11, i14);
        int max2 = Math.max(1, i12);
        int i15 = max / i14;
        int i16 = (max - (length * i15)) / 2;
        BitMatrix bitMatrix = new BitMatrix(max, max2);
        int i17 = 0;
        while (i17 < length) {
            if (zArr[i17]) {
                bitMatrix.setRegion(i16, 0, i15, max2);
            }
            i17++;
            i16 += i15;
        }
        return bitMatrix;
    }

    public final BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i11, int i12) throws WriterException {
        return encode(str, barcodeFormat, i11, i12, (Map<EncodeHintType, ?>) null);
    }

    public abstract boolean[] encode(String str);

    public int getDefaultMargin() {
        return 10;
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i11, int i12, Map<EncodeHintType, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (i11 < 0 || i12 < 0) {
            throw new IllegalArgumentException("Negative size is not allowed. Input: " + i11 + 'x' + i12);
        } else {
            int defaultMargin = getDefaultMargin();
            if (map != null) {
                EncodeHintType encodeHintType = EncodeHintType.MARGIN;
                if (map.containsKey(encodeHintType)) {
                    defaultMargin = Integer.parseInt(map.get(encodeHintType).toString());
                }
            }
            return renderResult(encode(str), i11, i12, defaultMargin);
        }
    }
}
