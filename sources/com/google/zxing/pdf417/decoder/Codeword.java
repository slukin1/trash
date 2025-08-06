package com.google.zxing.pdf417.decoder;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;

final class Codeword {
    private static final int BARCODE_ROW_UNKNOWN = -1;
    private final int bucket;
    private final int endX;
    private int rowNumber = -1;
    private final int startX;
    private final int value;

    public Codeword(int i11, int i12, int i13, int i14) {
        this.startX = i11;
        this.endX = i12;
        this.bucket = i13;
        this.value = i14;
    }

    public int getBucket() {
        return this.bucket;
    }

    public int getEndX() {
        return this.endX;
    }

    public int getRowNumber() {
        return this.rowNumber;
    }

    public int getStartX() {
        return this.startX;
    }

    public int getValue() {
        return this.value;
    }

    public int getWidth() {
        return this.endX - this.startX;
    }

    public boolean hasValidRowNumber() {
        return isValidRowNumber(this.rowNumber);
    }

    public boolean isValidRowNumber(int i11) {
        return i11 != -1 && this.bucket == (i11 % 3) * 3;
    }

    public void setRowNumber(int i11) {
        this.rowNumber = i11;
    }

    public void setRowNumberAsRowIndicatorColumn() {
        this.rowNumber = ((this.value / 30) * 3) + (this.bucket / 3);
    }

    public String toString() {
        return this.rowNumber + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.value;
    }
}
