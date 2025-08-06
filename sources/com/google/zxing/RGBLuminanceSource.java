package com.google.zxing;

public final class RGBLuminanceSource extends LuminanceSource {
    private final int dataHeight;
    private final int dataWidth;
    private final int left;
    private final byte[] luminances;
    private final int top;

    public RGBLuminanceSource(int i11, int i12, int[] iArr) {
        super(i11, i12);
        this.dataWidth = i11;
        this.dataHeight = i12;
        this.left = 0;
        this.top = 0;
        int i13 = i11 * i12;
        this.luminances = new byte[i13];
        for (int i14 = 0; i14 < i13; i14++) {
            int i15 = iArr[i14];
            this.luminances[i14] = (byte) (((((i15 >> 16) & 255) + ((i15 >> 7) & 510)) + (i15 & 255)) / 4);
        }
    }

    public LuminanceSource crop(int i11, int i12, int i13, int i14) {
        return new RGBLuminanceSource(this.luminances, this.dataWidth, this.dataHeight, this.left + i11, this.top + i12, i13, i14);
    }

    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        int i11 = this.dataWidth;
        if (width == i11 && height == this.dataHeight) {
            return this.luminances;
        }
        int i12 = width * height;
        byte[] bArr = new byte[i12];
        int i13 = (this.top * i11) + this.left;
        if (width == i11) {
            System.arraycopy(this.luminances, i13, bArr, 0, i12);
            return bArr;
        }
        for (int i14 = 0; i14 < height; i14++) {
            System.arraycopy(this.luminances, i13, bArr, i14 * width, width);
            i13 += this.dataWidth;
        }
        return bArr;
    }

    public byte[] getRow(int i11, byte[] bArr) {
        if (i11 < 0 || i11 >= getHeight()) {
            throw new IllegalArgumentException("Requested row is outside the image: ".concat(String.valueOf(i11)));
        }
        int width = getWidth();
        if (bArr == null || bArr.length < width) {
            bArr = new byte[width];
        }
        System.arraycopy(this.luminances, ((i11 + this.top) * this.dataWidth) + this.left, bArr, 0, width);
        return bArr;
    }

    public boolean isCropSupported() {
        return true;
    }

    private RGBLuminanceSource(byte[] bArr, int i11, int i12, int i13, int i14, int i15, int i16) {
        super(i15, i16);
        if (i15 + i13 > i11 || i16 + i14 > i12) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.luminances = bArr;
        this.dataWidth = i11;
        this.dataHeight = i12;
        this.left = i13;
        this.top = i14;
    }
}
