package v1;

import android.graphics.Matrix;
import android.graphics.RectF;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final Matrix f16648a = new a();

    public static class a extends Matrix {
        public void a() {
            throw new IllegalStateException("Matrix can not be modified");
        }

        public boolean postConcat(Matrix matrix) {
            a();
            return false;
        }

        public boolean postRotate(float f11, float f12, float f13) {
            a();
            return false;
        }

        public boolean postScale(float f11, float f12, float f13, float f14) {
            a();
            return false;
        }

        public boolean postSkew(float f11, float f12, float f13, float f14) {
            a();
            return false;
        }

        public boolean postTranslate(float f11, float f12) {
            a();
            return false;
        }

        public boolean preConcat(Matrix matrix) {
            a();
            return false;
        }

        public boolean preRotate(float f11, float f12, float f13) {
            a();
            return false;
        }

        public boolean preScale(float f11, float f12, float f13, float f14) {
            a();
            return false;
        }

        public boolean preSkew(float f11, float f12, float f13, float f14) {
            a();
            return false;
        }

        public boolean preTranslate(float f11, float f12) {
            a();
            return false;
        }

        public void reset() {
            a();
        }

        public void set(Matrix matrix) {
            a();
        }

        public boolean setConcat(Matrix matrix, Matrix matrix2) {
            a();
            return false;
        }

        public boolean setPolyToPoly(float[] fArr, int i11, float[] fArr2, int i12, int i13) {
            a();
            return false;
        }

        public boolean setRectToRect(RectF rectF, RectF rectF2, Matrix.ScaleToFit scaleToFit) {
            a();
            return false;
        }

        public void setRotate(float f11, float f12, float f13) {
            a();
        }

        public void setScale(float f11, float f12, float f13, float f14) {
            a();
        }

        public void setSinCos(float f11, float f12, float f13, float f14) {
            a();
        }

        public void setSkew(float f11, float f12, float f13, float f14) {
            a();
        }

        public void setTranslate(float f11, float f12) {
            a();
        }

        public void setValues(float[] fArr) {
            a();
        }

        public boolean postRotate(float f11) {
            a();
            return false;
        }

        public boolean postScale(float f11, float f12) {
            a();
            return false;
        }

        public boolean postSkew(float f11, float f12) {
            a();
            return false;
        }

        public boolean preRotate(float f11) {
            a();
            return false;
        }

        public boolean preScale(float f11, float f12) {
            a();
            return false;
        }

        public boolean preSkew(float f11, float f12) {
            a();
            return false;
        }

        public void setRotate(float f11) {
            a();
        }

        public void setScale(float f11, float f12) {
            a();
        }

        public void setSinCos(float f11, float f12) {
            a();
        }

        public void setSkew(float f11, float f12) {
            a();
        }
    }
}
