package com.google.zxing;

import com.sumsub.sns.internal.core.common.n0;

public abstract class LuminanceSource {
    private final int height;
    private final int width;

    public LuminanceSource(int i11, int i12) {
        this.width = i11;
        this.height = i12;
    }

    public LuminanceSource crop(int i11, int i12, int i13, int i14) {
        throw new UnsupportedOperationException("This luminance source does not support cropping.");
    }

    public final int getHeight() {
        return this.height;
    }

    public abstract byte[] getMatrix();

    public abstract byte[] getRow(int i11, byte[] bArr);

    public final int getWidth() {
        return this.width;
    }

    public LuminanceSource invert() {
        return new InvertedLuminanceSource(this);
    }

    public boolean isCropSupported() {
        return false;
    }

    public boolean isRotateSupported() {
        return false;
    }

    public LuminanceSource rotateCounterClockwise() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 90 degrees.");
    }

    public LuminanceSource rotateCounterClockwise45() {
        throw new UnsupportedOperationException("This luminance source does not support rotation by 45 degrees.");
    }

    public final String toString() {
        int i11 = this.width;
        byte[] bArr = new byte[i11];
        StringBuilder sb2 = new StringBuilder(this.height * (i11 + 1));
        for (int i12 = 0; i12 < this.height; i12++) {
            bArr = getRow(i12, bArr);
            for (int i13 = 0; i13 < this.width; i13++) {
                byte b11 = bArr[i13] & 255;
                sb2.append(b11 < 64 ? n0.h.f32179b : b11 < 128 ? '+' : b11 < 192 ? '.' : ' ');
            }
            sb2.append(10);
        }
        return sb2.toString();
    }
}
