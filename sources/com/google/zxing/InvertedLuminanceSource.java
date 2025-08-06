package com.google.zxing;

public final class InvertedLuminanceSource extends LuminanceSource {
    private final LuminanceSource delegate;

    public InvertedLuminanceSource(LuminanceSource luminanceSource) {
        super(luminanceSource.getWidth(), luminanceSource.getHeight());
        this.delegate = luminanceSource;
    }

    public LuminanceSource crop(int i11, int i12, int i13, int i14) {
        return new InvertedLuminanceSource(this.delegate.crop(i11, i12, i13, i14));
    }

    public byte[] getMatrix() {
        byte[] matrix = this.delegate.getMatrix();
        int width = getWidth() * getHeight();
        byte[] bArr = new byte[width];
        for (int i11 = 0; i11 < width; i11++) {
            bArr[i11] = (byte) (255 - (matrix[i11] & 255));
        }
        return bArr;
    }

    public byte[] getRow(int i11, byte[] bArr) {
        byte[] row = this.delegate.getRow(i11, bArr);
        int width = getWidth();
        for (int i12 = 0; i12 < width; i12++) {
            row[i12] = (byte) (255 - (row[i12] & 255));
        }
        return row;
    }

    public LuminanceSource invert() {
        return this.delegate;
    }

    public boolean isCropSupported() {
        return this.delegate.isCropSupported();
    }

    public boolean isRotateSupported() {
        return this.delegate.isRotateSupported();
    }

    public LuminanceSource rotateCounterClockwise() {
        return new InvertedLuminanceSource(this.delegate.rotateCounterClockwise());
    }

    public LuminanceSource rotateCounterClockwise45() {
        return new InvertedLuminanceSource(this.delegate.rotateCounterClockwise45());
    }
}
