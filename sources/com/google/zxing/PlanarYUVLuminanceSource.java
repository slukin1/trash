package com.google.zxing;

import com.huobi.view.roundimg.RoundedDrawable;

public final class PlanarYUVLuminanceSource extends LuminanceSource {
    private static final int THUMBNAIL_SCALE_FACTOR = 2;
    private final int dataHeight;
    private final int dataWidth;
    private final int left;
    private final int top;
    private final byte[] yuvData;

    public PlanarYUVLuminanceSource(byte[] bArr, int i11, int i12, int i13, int i14, int i15, int i16, boolean z11) {
        super(i15, i16);
        if (i13 + i15 > i11 || i14 + i16 > i12) {
            throw new IllegalArgumentException("Crop rectangle does not fit within image data.");
        }
        this.yuvData = bArr;
        this.dataWidth = i11;
        this.dataHeight = i12;
        this.left = i13;
        this.top = i14;
        if (z11) {
            reverseHorizontal(i15, i16);
        }
    }

    private void reverseHorizontal(int i11, int i12) {
        byte[] bArr = this.yuvData;
        int i13 = (this.top * this.dataWidth) + this.left;
        int i14 = 0;
        while (i14 < i12) {
            int i15 = (i11 / 2) + i13;
            int i16 = (i13 + i11) - 1;
            int i17 = i13;
            while (i17 < i15) {
                byte b11 = bArr[i17];
                bArr[i17] = bArr[i16];
                bArr[i16] = b11;
                i17++;
                i16--;
            }
            i14++;
            i13 += this.dataWidth;
        }
    }

    public LuminanceSource crop(int i11, int i12, int i13, int i14) {
        return new PlanarYUVLuminanceSource(this.yuvData, this.dataWidth, this.dataHeight, this.left + i11, this.top + i12, i13, i14, false);
    }

    public byte[] getMatrix() {
        int width = getWidth();
        int height = getHeight();
        int i11 = this.dataWidth;
        if (width == i11 && height == this.dataHeight) {
            return this.yuvData;
        }
        int i12 = width * height;
        byte[] bArr = new byte[i12];
        int i13 = (this.top * i11) + this.left;
        if (width == i11) {
            System.arraycopy(this.yuvData, i13, bArr, 0, i12);
            return bArr;
        }
        for (int i14 = 0; i14 < height; i14++) {
            System.arraycopy(this.yuvData, i13, bArr, i14 * width, width);
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
        System.arraycopy(this.yuvData, ((i11 + this.top) * this.dataWidth) + this.left, bArr, 0, width);
        return bArr;
    }

    public int getThumbnailHeight() {
        return getHeight() / 2;
    }

    public int getThumbnailWidth() {
        return getWidth() / 2;
    }

    public boolean isCropSupported() {
        return true;
    }

    public int[] renderThumbnail() {
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        int[] iArr = new int[(width * height)];
        byte[] bArr = this.yuvData;
        int i11 = (this.top * this.dataWidth) + this.left;
        for (int i12 = 0; i12 < height; i12++) {
            int i13 = i12 * width;
            for (int i14 = 0; i14 < width; i14++) {
                iArr[i13 + i14] = ((bArr[(i14 << 1) + i11] & 255) * 65793) | RoundedDrawable.DEFAULT_BORDER_COLOR;
            }
            i11 += this.dataWidth << 1;
        }
        return iArr;
    }
}
