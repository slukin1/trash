package com.google.zxing.qrcode.detector;

import com.google.zxing.ResultPoint;

public final class FinderPattern extends ResultPoint {
    private final int count;
    private final float estimatedModuleSize;

    public FinderPattern(float f11, float f12, float f13) {
        this(f11, f12, f13, 1);
    }

    public boolean aboutEquals(float f11, float f12, float f13) {
        if (Math.abs(f12 - getY()) > f11 || Math.abs(f13 - getX()) > f11) {
            return false;
        }
        float abs = Math.abs(f11 - this.estimatedModuleSize);
        if (abs <= 1.0f || abs <= this.estimatedModuleSize) {
            return true;
        }
        return false;
    }

    public FinderPattern combineEstimate(float f11, float f12, float f13) {
        int i11 = this.count;
        int i12 = i11 + 1;
        float x11 = (((float) i11) * getX()) + f12;
        float f14 = (float) i12;
        return new FinderPattern(x11 / f14, ((((float) this.count) * getY()) + f11) / f14, ((((float) this.count) * this.estimatedModuleSize) + f13) / f14, i12);
    }

    public int getCount() {
        return this.count;
    }

    public float getEstimatedModuleSize() {
        return this.estimatedModuleSize;
    }

    private FinderPattern(float f11, float f12, float f13, int i11) {
        super(f11, f12);
        this.estimatedModuleSize = f13;
        this.count = i11;
    }
}
