package com.google.zxing.pdf417.decoder;

final class BarcodeMetadata {
    private final int columnCount;
    private final int errorCorrectionLevel;
    private final int rowCount;
    private final int rowCountLowerPart;
    private final int rowCountUpperPart;

    public BarcodeMetadata(int i11, int i12, int i13, int i14) {
        this.columnCount = i11;
        this.errorCorrectionLevel = i14;
        this.rowCountUpperPart = i12;
        this.rowCountLowerPart = i13;
        this.rowCount = i12 + i13;
    }

    public int getColumnCount() {
        return this.columnCount;
    }

    public int getErrorCorrectionLevel() {
        return this.errorCorrectionLevel;
    }

    public int getRowCount() {
        return this.rowCount;
    }

    public int getRowCountLowerPart() {
        return this.rowCountLowerPart;
    }

    public int getRowCountUpperPart() {
        return this.rowCountUpperPart;
    }
}
