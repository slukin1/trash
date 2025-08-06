package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import s0.i;
import t0.f;
import v1.l;

public class PatternPathMotion extends PathMotion {

    /* renamed from: a  reason: collision with root package name */
    public Path f11824a;

    /* renamed from: b  reason: collision with root package name */
    public final Path f11825b;

    /* renamed from: c  reason: collision with root package name */
    public final Matrix f11826c;

    public PatternPathMotion() {
        Path path = new Path();
        this.f11825b = path;
        this.f11826c = new Matrix();
        path.lineTo(1.0f, 0.0f);
        this.f11824a = path;
    }

    public static float a(float f11, float f12) {
        return (float) Math.sqrt((double) ((f11 * f11) + (f12 * f12)));
    }

    public void b(Path path) {
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float[] fArr = new float[2];
        pathMeasure.getPosTan(pathMeasure.getLength(), fArr, (float[]) null);
        float f11 = fArr[0];
        float f12 = fArr[1];
        pathMeasure.getPosTan(0.0f, fArr, (float[]) null);
        float f13 = fArr[0];
        float f14 = fArr[1];
        if (f13 == f11 && f14 == f12) {
            throw new IllegalArgumentException("pattern must not end at the starting point");
        }
        this.f11826c.setTranslate(-f13, -f14);
        float f15 = f11 - f13;
        float f16 = f12 - f14;
        float a11 = 1.0f / a(f15, f16);
        this.f11826c.postScale(a11, a11);
        this.f11826c.postRotate((float) Math.toDegrees(-Math.atan2((double) f16, (double) f15)));
        path.transform(this.f11826c, this.f11825b);
        this.f11824a = path;
    }

    public Path getPath(float f11, float f12, float f13, float f14) {
        float f15 = f13 - f11;
        float f16 = f14 - f12;
        float a11 = a(f15, f16);
        double atan2 = Math.atan2((double) f16, (double) f15);
        this.f11826c.setScale(a11, a11);
        this.f11826c.postRotate((float) Math.toDegrees(atan2));
        this.f11826c.postTranslate(f11, f12);
        Path path = new Path();
        this.f11825b.transform(this.f11826c, path);
        return path;
    }

    @SuppressLint({"RestrictedApi"})
    public PatternPathMotion(Context context, AttributeSet attributeSet) {
        this.f11825b = new Path();
        this.f11826c = new Matrix();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f16672k);
        try {
            String i11 = i.i(obtainStyledAttributes, (XmlPullParser) attributeSet, "patternPathData", 0);
            if (i11 != null) {
                b(f.e(i11));
                return;
            }
            throw new RuntimeException("pathData must be supplied for patternPathMotion");
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    public PatternPathMotion(Path path) {
        this.f11825b = new Path();
        this.f11826c = new Matrix();
        b(path);
    }
}
