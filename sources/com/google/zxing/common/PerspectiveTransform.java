package com.google.zxing.common;

public final class PerspectiveTransform {
    private final float a11;
    private final float a12;
    private final float a13;
    private final float a21;
    private final float a22;
    private final float a23;
    private final float a31;
    private final float a32;
    private final float a33;

    private PerspectiveTransform(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19) {
        this.a11 = f11;
        this.a12 = f14;
        this.a13 = f17;
        this.a21 = f12;
        this.a22 = f15;
        this.a23 = f18;
        this.a31 = f13;
        this.a32 = f16;
        this.a33 = f19;
    }

    public static PerspectiveTransform quadrilateralToQuadrilateral(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18, float f19, float f21, float f22, float f23, float f24, float f25, float f26, float f27) {
        return squareToQuadrilateral(f19, f21, f22, f23, f24, f25, f26, f27).times(quadrilateralToSquare(f11, f12, f13, f14, f15, f16, f17, f18));
    }

    public static PerspectiveTransform quadrilateralToSquare(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        return squareToQuadrilateral(f11, f12, f13, f14, f15, f16, f17, f18).buildAdjoint();
    }

    public static PerspectiveTransform squareToQuadrilateral(float f11, float f12, float f13, float f14, float f15, float f16, float f17, float f18) {
        float f19 = ((f11 - f13) + f15) - f17;
        float f21 = ((f12 - f14) + f16) - f18;
        if (f19 == 0.0f && f21 == 0.0f) {
            return new PerspectiveTransform(f13 - f11, f15 - f13, f11, f14 - f12, f16 - f14, f12, 0.0f, 0.0f, 1.0f);
        }
        float f22 = f13 - f15;
        float f23 = f17 - f15;
        float f24 = f14 - f16;
        float f25 = f18 - f16;
        float f26 = (f22 * f25) - (f23 * f24);
        float f27 = ((f25 * f19) - (f23 * f21)) / f26;
        float f28 = ((f22 * f21) - (f19 * f24)) / f26;
        return new PerspectiveTransform((f27 * f13) + (f13 - f11), (f28 * f17) + (f17 - f11), f11, (f14 - f12) + (f27 * f14), (f18 - f12) + (f28 * f18), f12, f27, f28, 1.0f);
    }

    public PerspectiveTransform buildAdjoint() {
        float f11 = this.a22;
        float f12 = this.a33;
        float f13 = this.a23;
        float f14 = this.a32;
        float f15 = (f11 * f12) - (f13 * f14);
        float f16 = this.a31;
        float f17 = this.a21;
        float f18 = (f13 * f16) - (f17 * f12);
        float f19 = (f17 * f14) - (f11 * f16);
        float f21 = this.a13;
        float f22 = this.a12;
        float f23 = (f21 * f14) - (f22 * f12);
        float f24 = this.a11;
        return new PerspectiveTransform(f15, f18, f19, f23, (f12 * f24) - (f21 * f16), (f16 * f22) - (f14 * f24), (f22 * f13) - (f21 * f11), (f21 * f17) - (f13 * f24), (f24 * f11) - (f22 * f17));
    }

    public PerspectiveTransform times(PerspectiveTransform perspectiveTransform) {
        PerspectiveTransform perspectiveTransform2 = perspectiveTransform;
        float f11 = this.a11;
        float f12 = perspectiveTransform2.a11;
        float f13 = this.a21;
        float f14 = perspectiveTransform2.a12;
        float f15 = this.a31;
        float f16 = perspectiveTransform2.a13;
        float f17 = (f11 * f12) + (f13 * f14) + (f15 * f16);
        float f18 = perspectiveTransform2.a21;
        float f19 = perspectiveTransform2.a22;
        float f21 = perspectiveTransform2.a23;
        float f22 = (f11 * f18) + (f13 * f19) + (f15 * f21);
        float f23 = perspectiveTransform2.a31;
        float f24 = perspectiveTransform2.a32;
        float f25 = perspectiveTransform2.a33;
        float f26 = (f11 * f23) + (f13 * f24) + (f15 * f25);
        float f27 = this.a12;
        float f28 = f26;
        float f29 = this.a22;
        float f31 = f22;
        float f32 = this.a32;
        float f33 = (f27 * f12) + (f29 * f14) + (f32 * f16);
        float f34 = (f32 * f25) + (f27 * f23) + (f29 * f24);
        float f35 = this.a13;
        float f36 = this.a23;
        float f37 = (f12 * f35) + (f14 * f36);
        float f38 = this.a33;
        float f39 = (f35 * f23) + (f36 * f24) + (f38 * f25);
        return new PerspectiveTransform(f17, f31, f28, f33, (f27 * f18) + (f29 * f19) + (f32 * f21), f34, (f16 * f38) + f37, (f18 * f35) + (f19 * f36) + (f21 * f38), f39);
    }

    public void transformPoints(float[] fArr) {
        float[] fArr2 = fArr;
        int length = fArr2.length;
        float f11 = this.a11;
        float f12 = this.a12;
        float f13 = this.a13;
        float f14 = this.a21;
        float f15 = this.a22;
        float f16 = this.a23;
        float f17 = this.a31;
        float f18 = this.a32;
        float f19 = this.a33;
        for (int i11 = 0; i11 < length; i11 += 2) {
            float f21 = fArr2[i11];
            int i12 = i11 + 1;
            float f22 = fArr2[i12];
            float f23 = (f13 * f21) + (f16 * f22) + f19;
            fArr2[i11] = (((f11 * f21) + (f14 * f22)) + f17) / f23;
            fArr2[i12] = (((f21 * f12) + (f22 * f15)) + f18) / f23;
        }
    }

    public void transformPoints(float[] fArr, float[] fArr2) {
        int length = fArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            float f11 = fArr[i11];
            float f12 = fArr2[i11];
            float f13 = (this.a13 * f11) + (this.a23 * f12) + this.a33;
            fArr[i11] = (((this.a11 * f11) + (this.a21 * f12)) + this.a31) / f13;
            fArr2[i11] = (((this.a12 * f11) + (this.a22 * f12)) + this.a32) / f13;
        }
    }
}
