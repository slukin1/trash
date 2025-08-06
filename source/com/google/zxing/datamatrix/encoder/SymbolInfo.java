package com.google.zxing.datamatrix.encoder;

import com.google.android.material.behavior.HideBottomViewOnScrollBehavior;
import com.google.zxing.Dimension;
import com.luck.picture.lib.config.Crop;
import com.tencent.ugc.datereport.UGCDataReportDef;

public class SymbolInfo {
    public static final SymbolInfo[] PROD_SYMBOLS;
    private static SymbolInfo[] symbols;
    private final int dataCapacity;
    private final int dataRegions;
    private final int errorCodewords;
    public final int matrixHeight;
    public final int matrixWidth;
    private final boolean rectangular;
    private final int rsBlockData;
    private final int rsBlockError;

    static {
        SymbolInfo[] symbolInfoArr = {new SymbolInfo(false, 3, 5, 8, 8, 1), new SymbolInfo(false, 5, 7, 10, 10, 1), new SymbolInfo(true, 5, 7, 16, 6, 1), new SymbolInfo(false, 8, 10, 12, 12, 1), new SymbolInfo(true, 10, 11, 14, 6, 2), new SymbolInfo(false, 12, 12, 14, 14, 1), new SymbolInfo(true, 16, 14, 24, 10, 1), new SymbolInfo(false, 18, 14, 16, 16, 1), new SymbolInfo(false, 22, 18, 18, 18, 1), new SymbolInfo(true, 22, 18, 16, 10, 2), new SymbolInfo(false, 30, 20, 20, 20, 1), new SymbolInfo(true, 32, 24, 16, 14, 2), new SymbolInfo(false, 36, 24, 22, 22, 1), new SymbolInfo(false, 44, 28, 24, 24, 1), new SymbolInfo(true, 49, 28, 22, 14, 2), new SymbolInfo(false, 62, 36, 14, 14, 4), new SymbolInfo(false, 86, 42, 16, 16, 4), new SymbolInfo(false, 114, 48, 18, 18, 4), new SymbolInfo(false, 144, 56, 20, 20, 4), new SymbolInfo(false, 174, 68, 22, 22, 4), new SymbolInfo(false, 204, 84, 24, 24, 4, 102, 42), new SymbolInfo(false, 280, 112, 14, 14, 16, 140, 56), new SymbolInfo(false, 368, 144, 16, 16, 16, 92, 36), new SymbolInfo(false, 456, 192, 18, 18, 16, 114, 48), new SymbolInfo(false, 576, 224, 20, 20, 16, 144, 56), new SymbolInfo(false, Crop.REQUEST_EDIT_CROP, 272, 22, 22, 16, 174, 68), new SymbolInfo(false, 816, 336, 24, 24, 16, 136, 56), new SymbolInfo(false, UGCDataReportDef.DR_DAU_EVENT_ID_RECORD_GOP, 408, 18, 18, 36, HideBottomViewOnScrollBehavior.EXIT_ANIMATION_DURATION, 68), new SymbolInfo(false, 1304, 496, 20, 20, 36, 163, 62), new DataMatrixSymbolInfo144()};
        PROD_SYMBOLS = symbolInfoArr;
        symbols = symbolInfoArr;
    }

    public SymbolInfo(boolean z11, int i11, int i12, int i13, int i14, int i15) {
        this(z11, i11, i12, i13, i14, i15, i11, i12);
    }

    private int getHorizontalDataRegions() {
        int i11 = this.dataRegions;
        int i12 = 1;
        if (i11 != 1) {
            i12 = 2;
            if (!(i11 == 2 || i11 == 4)) {
                if (i11 == 16) {
                    return 4;
                }
                if (i11 == 36) {
                    return 6;
                }
                throw new IllegalStateException("Cannot handle this number of data regions");
            }
        }
        return i12;
    }

    private int getVerticalDataRegions() {
        int i11 = this.dataRegions;
        if (i11 == 1 || i11 == 2) {
            return 1;
        }
        if (i11 == 4) {
            return 2;
        }
        if (i11 == 16) {
            return 4;
        }
        if (i11 == 36) {
            return 6;
        }
        throw new IllegalStateException("Cannot handle this number of data regions");
    }

    public static SymbolInfo lookup(int i11) {
        return lookup(i11, SymbolShapeHint.FORCE_NONE, true);
    }

    public static void overrideSymbolSet(SymbolInfo[] symbolInfoArr) {
        symbols = symbolInfoArr;
    }

    public int getCodewordCount() {
        return this.dataCapacity + this.errorCodewords;
    }

    public final int getDataCapacity() {
        return this.dataCapacity;
    }

    public int getDataLengthForInterleavedBlock(int i11) {
        return this.rsBlockData;
    }

    public final int getErrorCodewords() {
        return this.errorCodewords;
    }

    public final int getErrorLengthForInterleavedBlock(int i11) {
        return this.rsBlockError;
    }

    public int getInterleavedBlockCount() {
        return this.dataCapacity / this.rsBlockData;
    }

    public final int getSymbolDataHeight() {
        return getVerticalDataRegions() * this.matrixHeight;
    }

    public final int getSymbolDataWidth() {
        return getHorizontalDataRegions() * this.matrixWidth;
    }

    public final int getSymbolHeight() {
        return getSymbolDataHeight() + (getVerticalDataRegions() << 1);
    }

    public final int getSymbolWidth() {
        return getSymbolDataWidth() + (getHorizontalDataRegions() << 1);
    }

    public final String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(this.rectangular ? "Rectangular Symbol:" : "Square Symbol:");
        sb2.append(" data region ");
        sb2.append(this.matrixWidth);
        sb2.append('x');
        sb2.append(this.matrixHeight);
        sb2.append(", symbol size ");
        sb2.append(getSymbolWidth());
        sb2.append('x');
        sb2.append(getSymbolHeight());
        sb2.append(", symbol data size ");
        sb2.append(getSymbolDataWidth());
        sb2.append('x');
        sb2.append(getSymbolDataHeight());
        sb2.append(", codewords ");
        sb2.append(this.dataCapacity);
        sb2.append('+');
        sb2.append(this.errorCodewords);
        return sb2.toString();
    }

    public SymbolInfo(boolean z11, int i11, int i12, int i13, int i14, int i15, int i16, int i17) {
        this.rectangular = z11;
        this.dataCapacity = i11;
        this.errorCodewords = i12;
        this.matrixWidth = i13;
        this.matrixHeight = i14;
        this.dataRegions = i15;
        this.rsBlockData = i16;
        this.rsBlockError = i17;
    }

    public static SymbolInfo lookup(int i11, SymbolShapeHint symbolShapeHint) {
        return lookup(i11, symbolShapeHint, true);
    }

    public static SymbolInfo lookup(int i11, boolean z11, boolean z12) {
        return lookup(i11, z11 ? SymbolShapeHint.FORCE_NONE : SymbolShapeHint.FORCE_SQUARE, z12);
    }

    private static SymbolInfo lookup(int i11, SymbolShapeHint symbolShapeHint, boolean z11) {
        return lookup(i11, symbolShapeHint, (Dimension) null, (Dimension) null, z11);
    }

    public static SymbolInfo lookup(int i11, SymbolShapeHint symbolShapeHint, Dimension dimension, Dimension dimension2, boolean z11) {
        for (SymbolInfo symbolInfo : symbols) {
            if ((symbolShapeHint != SymbolShapeHint.FORCE_SQUARE || !symbolInfo.rectangular) && ((symbolShapeHint != SymbolShapeHint.FORCE_RECTANGLE || symbolInfo.rectangular) && ((dimension == null || (symbolInfo.getSymbolWidth() >= dimension.getWidth() && symbolInfo.getSymbolHeight() >= dimension.getHeight())) && ((dimension2 == null || (symbolInfo.getSymbolWidth() <= dimension2.getWidth() && symbolInfo.getSymbolHeight() <= dimension2.getHeight())) && i11 <= symbolInfo.dataCapacity)))) {
                return symbolInfo;
            }
        }
        if (!z11) {
            return null;
        }
        throw new IllegalArgumentException("Can't find a symbol arrangement that matches the message. Data codewords: ".concat(String.valueOf(i11)));
    }
}
