package com.google.zxing.datamatrix;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Dimension;
import com.google.zxing.EncodeHintType;
import com.google.zxing.Writer;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.datamatrix.encoder.DefaultPlacement;
import com.google.zxing.datamatrix.encoder.ErrorCorrection;
import com.google.zxing.datamatrix.encoder.HighLevelEncoder;
import com.google.zxing.datamatrix.encoder.SymbolInfo;
import com.google.zxing.datamatrix.encoder.SymbolShapeHint;
import com.google.zxing.qrcode.encoder.ByteMatrix;
import java.util.Map;

public final class DataMatrixWriter implements Writer {
    private static BitMatrix convertByteMatrixToBitMatrix(ByteMatrix byteMatrix, int i11, int i12) {
        BitMatrix bitMatrix;
        int width = byteMatrix.getWidth();
        int height = byteMatrix.getHeight();
        int max = Math.max(i11, width);
        int max2 = Math.max(i12, height);
        int min = Math.min(max / width, max2 / height);
        int i13 = (max - (width * min)) / 2;
        int i14 = (max2 - (height * min)) / 2;
        if (i12 < height || i11 < width) {
            bitMatrix = new BitMatrix(width, height);
            i13 = 0;
            i14 = 0;
        } else {
            bitMatrix = new BitMatrix(i11, i12);
        }
        bitMatrix.clear();
        int i15 = 0;
        while (i15 < height) {
            int i16 = i13;
            int i17 = 0;
            while (i17 < width) {
                if (byteMatrix.get(i17, i15) == 1) {
                    bitMatrix.setRegion(i16, i14, min, min);
                }
                i17++;
                i16 += min;
            }
            i15++;
            i14 += min;
        }
        return bitMatrix;
    }

    private static BitMatrix encodeLowLevel(DefaultPlacement defaultPlacement, SymbolInfo symbolInfo, int i11, int i12) {
        int symbolDataWidth = symbolInfo.getSymbolDataWidth();
        int symbolDataHeight = symbolInfo.getSymbolDataHeight();
        ByteMatrix byteMatrix = new ByteMatrix(symbolInfo.getSymbolWidth(), symbolInfo.getSymbolHeight());
        int i13 = 0;
        for (int i14 = 0; i14 < symbolDataHeight; i14++) {
            if (i14 % symbolInfo.matrixHeight == 0) {
                int i15 = 0;
                for (int i16 = 0; i16 < symbolInfo.getSymbolWidth(); i16++) {
                    byteMatrix.set(i15, i13, i16 % 2 == 0);
                    i15++;
                }
                i13++;
            }
            int i17 = 0;
            for (int i18 = 0; i18 < symbolDataWidth; i18++) {
                if (i18 % symbolInfo.matrixWidth == 0) {
                    byteMatrix.set(i17, i13, true);
                    i17++;
                }
                byteMatrix.set(i17, i13, defaultPlacement.getBit(i18, i14));
                i17++;
                int i19 = symbolInfo.matrixWidth;
                if (i18 % i19 == i19 - 1) {
                    byteMatrix.set(i17, i13, i14 % 2 == 0);
                    i17++;
                }
            }
            i13++;
            int i21 = symbolInfo.matrixHeight;
            if (i14 % i21 == i21 - 1) {
                int i22 = 0;
                for (int i23 = 0; i23 < symbolInfo.getSymbolWidth(); i23++) {
                    byteMatrix.set(i22, i13, true);
                    i22++;
                }
                i13++;
            }
        }
        return convertByteMatrixToBitMatrix(byteMatrix, i11, i12);
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i11, int i12) {
        return encode(str, barcodeFormat, i11, i12, (Map<EncodeHintType, ?>) null);
    }

    public BitMatrix encode(String str, BarcodeFormat barcodeFormat, int i11, int i12, Map<EncodeHintType, ?> map) {
        Dimension dimension;
        if (str.isEmpty()) {
            throw new IllegalArgumentException("Found empty contents");
        } else if (barcodeFormat != BarcodeFormat.DATA_MATRIX) {
            throw new IllegalArgumentException("Can only encode DATA_MATRIX, but got ".concat(String.valueOf(barcodeFormat)));
        } else if (i11 < 0 || i12 < 0) {
            throw new IllegalArgumentException("Requested dimensions can't be negative: " + i11 + 'x' + i12);
        } else {
            SymbolShapeHint symbolShapeHint = SymbolShapeHint.FORCE_NONE;
            Dimension dimension2 = null;
            if (map != null) {
                SymbolShapeHint symbolShapeHint2 = (SymbolShapeHint) map.get(EncodeHintType.DATA_MATRIX_SHAPE);
                if (symbolShapeHint2 != null) {
                    symbolShapeHint = symbolShapeHint2;
                }
                Dimension dimension3 = (Dimension) map.get(EncodeHintType.MIN_SIZE);
                if (dimension3 == null) {
                    dimension3 = null;
                }
                dimension = (Dimension) map.get(EncodeHintType.MAX_SIZE);
                if (dimension == null) {
                    dimension = null;
                }
                dimension2 = dimension3;
            } else {
                dimension = null;
            }
            String encodeHighLevel = HighLevelEncoder.encodeHighLevel(str, symbolShapeHint, dimension2, dimension);
            SymbolInfo lookup = SymbolInfo.lookup(encodeHighLevel.length(), symbolShapeHint, dimension2, dimension, true);
            DefaultPlacement defaultPlacement = new DefaultPlacement(ErrorCorrection.encodeECC200(encodeHighLevel, lookup), lookup.getSymbolDataWidth(), lookup.getSymbolDataHeight());
            defaultPlacement.place();
            return encodeLowLevel(defaultPlacement, lookup, i11, i12);
        }
    }
}
