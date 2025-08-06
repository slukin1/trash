package com.google.zxing.qrcode;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import com.google.zxing.qrcode.encoder.Encoder;
import com.google.zxing.qrcode.encoder.QRCode;
import java.util.Map;

public final class QRCodeWriter implements Writer {
    private static final int QUIET_ZONE_SIZE = 4;

    private static BitMatrix renderResult(QRCode qRCode, int i11, int i12, int i13) {
        ByteMatrix matrix = qRCode.getMatrix();
        if (matrix != null) {
            int width = matrix.getWidth();
            int height = matrix.getHeight();
            int i14 = i13 << 1;
            int i15 = width + i14;
            int i16 = i14 + height;
            int max = Math.max(i11, i15);
            int max2 = Math.max(i12, i16);
            int min = Math.min(max / i15, max2 / i16);
            int i17 = (max - (width * min)) / 2;
            int i18 = (max2 - (height * min)) / 2;
            BitMatrix bitMatrix = new BitMatrix(max, max2);
            int i19 = 0;
            while (i19 < height) {
                int i21 = 0;
                int i22 = i17;
                while (i21 < width) {
                    if (matrix.get(i21, i19) == 1) {
                        bitMatrix.setRegion(i22, i18, min, min);
                    }
                    i21++;
                    i22 += min;
                }
                i19++;
                i18 += min;
            }
            return bitMatrix;
        }
        throw new IllegalStateException();
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i11, int i12) throws WriterException {
        return encode(str, barcodeFormat, i11, i12, (Map<EncodeHintType, ?>) null);
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i11, int i12, Map<EncodeHintType, ?> map) throws WriterException {
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (barcodeFormat != BarcodeFormat.QR_CODE) {
            throw new IllegalArgumentException("Can only encode QR_CODE, but got ".concat(String.valueOf(barcodeFormat)));
        } else if (i11 < 0 || i12 < 0) {
            throw new IllegalArgumentException("Requested dimensions are too small: " + i11 + 'x' + i12);
        } else {
            ErrorCorrectionLevel errorCorrectionLevel = ErrorCorrectionLevel.L;
            int i13 = 4;
            if (map != null) {
                EncodeHintType encodeHintType = EncodeHintType.ERROR_CORRECTION;
                if (map.containsKey(encodeHintType)) {
                    errorCorrectionLevel = ErrorCorrectionLevel.valueOf(map.get(encodeHintType).toString());
                }
                EncodeHintType encodeHintType2 = EncodeHintType.MARGIN;
                if (map.containsKey(encodeHintType2)) {
                    i13 = Integer.parseInt(map.get(encodeHintType2).toString());
                }
            }
            return renderResult(Encoder.encode(str, errorCorrectionLevel, map), i11, i12, i13);
        }
    }
}
