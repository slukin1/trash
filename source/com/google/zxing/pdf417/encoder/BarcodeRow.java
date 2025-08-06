package com.google.zxing.pdf417.encoder;

final class BarcodeRow {
    private int currentLocation = 0;
    private final byte[] row;

    public BarcodeRow(int i11) {
        this.row = new byte[i11];
    }

    public void addBar(boolean z11, int i11) {
        for (int i12 = 0; i12 < i11; i12++) {
            int i13 = this.currentLocation;
            this.currentLocation = i13 + 1;
            set(i13, z11);
        }
    }

    public byte[] getScaledRow(int i11) {
        int length = this.row.length * i11;
        byte[] bArr = new byte[length];
        for (int i12 = 0; i12 < length; i12++) {
            bArr[i12] = this.row[i12 / i11];
        }
        return bArr;
    }

    public void set(int i11, byte b11) {
        this.row[i11] = b11;
    }

    private void set(int i11, boolean z11) {
        this.row[i11] = z11 ? (byte) 1 : 0;
    }
}
