package androidx.vectordrawable.graphics.drawable;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.InflateException;
import android.view.animation.Interpolator;
import com.xiaomi.mipush.sdk.Constants;
import org.xmlpull.v1.XmlPullParser;
import s0.i;
import t0.f;

public class e implements Interpolator {

    /* renamed from: a  reason: collision with root package name */
    public float[] f12006a;

    /* renamed from: b  reason: collision with root package name */
    public float[] f12007b;

    public e(Context context, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        this(context.getResources(), context.getTheme(), attributeSet, xmlPullParser);
    }

    public final void a(float f11, float f12, float f13, float f14) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.cubicTo(f11, f12, f13, f14, 1.0f, 1.0f);
        b(path);
    }

    public final void b(Path path) {
        int i11 = 0;
        PathMeasure pathMeasure = new PathMeasure(path, false);
        float length = pathMeasure.getLength();
        int min = Math.min(3000, ((int) (length / 0.002f)) + 1);
        if (min > 0) {
            this.f12006a = new float[min];
            this.f12007b = new float[min];
            float[] fArr = new float[2];
            for (int i12 = 0; i12 < min; i12++) {
                pathMeasure.getPosTan((((float) i12) * length) / ((float) (min - 1)), fArr, (float[]) null);
                this.f12006a[i12] = fArr[0];
                this.f12007b[i12] = fArr[1];
            }
            if (((double) Math.abs(this.f12006a[0])) <= 1.0E-5d && ((double) Math.abs(this.f12007b[0])) <= 1.0E-5d) {
                int i13 = min - 1;
                if (((double) Math.abs(this.f12006a[i13] - 1.0f)) <= 1.0E-5d && ((double) Math.abs(this.f12007b[i13] - 1.0f)) <= 1.0E-5d) {
                    float f11 = 0.0f;
                    int i14 = 0;
                    while (i11 < min) {
                        float[] fArr2 = this.f12006a;
                        int i15 = i14 + 1;
                        float f12 = fArr2[i14];
                        if (f12 >= f11) {
                            fArr2[i11] = f12;
                            i11++;
                            f11 = f12;
                            i14 = i15;
                        } else {
                            throw new IllegalArgumentException("The Path cannot loop back on itself, x :" + f12);
                        }
                    }
                    if (pathMeasure.nextContour()) {
                        throw new IllegalArgumentException("The Path should be continuous, can't have 2+ contours");
                    }
                    return;
                }
            }
            StringBuilder sb2 = new StringBuilder();
            sb2.append("The Path must start at (0,0) and end at (1,1) start: ");
            sb2.append(this.f12006a[0]);
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb2.append(this.f12007b[0]);
            sb2.append(" end:");
            int i16 = min - 1;
            sb2.append(this.f12006a[i16]);
            sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
            sb2.append(this.f12007b[i16]);
            throw new IllegalArgumentException(sb2.toString());
        }
        throw new IllegalArgumentException("The Path has a invalid length " + length);
    }

    public final void c(float f11, float f12) {
        Path path = new Path();
        path.moveTo(0.0f, 0.0f);
        path.quadTo(f11, f12, 1.0f, 1.0f);
        b(path);
    }

    public final void d(TypedArray typedArray, XmlPullParser xmlPullParser) {
        if (i.j(xmlPullParser, "pathData")) {
            String i11 = i.i(typedArray, xmlPullParser, "pathData", 4);
            Path e11 = f.e(i11);
            if (e11 != null) {
                b(e11);
                return;
            }
            throw new InflateException("The path is null, which is created from " + i11);
        } else if (!i.j(xmlPullParser, "controlX1")) {
            throw new InflateException("pathInterpolator requires the controlX1 attribute");
        } else if (i.j(xmlPullParser, "controlY1")) {
            float f11 = i.f(typedArray, xmlPullParser, "controlX1", 0, 0.0f);
            float f12 = i.f(typedArray, xmlPullParser, "controlY1", 1, 0.0f);
            boolean j11 = i.j(xmlPullParser, "controlX2");
            if (j11 != i.j(xmlPullParser, "controlY2")) {
                throw new InflateException("pathInterpolator requires both controlX2 and controlY2 for cubic Beziers.");
            } else if (!j11) {
                c(f11, f12);
            } else {
                a(f11, f12, i.f(typedArray, xmlPullParser, "controlX2", 2, 0.0f), i.f(typedArray, xmlPullParser, "controlY2", 3, 0.0f));
            }
        } else {
            throw new InflateException("pathInterpolator requires the controlY1 attribute");
        }
    }

    public float getInterpolation(float f11) {
        if (f11 <= 0.0f) {
            return 0.0f;
        }
        if (f11 >= 1.0f) {
            return 1.0f;
        }
        int i11 = 0;
        int length = this.f12006a.length - 1;
        while (length - i11 > 1) {
            int i12 = (i11 + length) / 2;
            if (f11 < this.f12006a[i12]) {
                length = i12;
            } else {
                i11 = i12;
            }
        }
        float[] fArr = this.f12006a;
        float f12 = fArr[length] - fArr[i11];
        if (f12 == 0.0f) {
            return this.f12007b[i11];
        }
        float[] fArr2 = this.f12007b;
        float f13 = fArr2[i11];
        return f13 + (((f11 - fArr[i11]) / f12) * (fArr2[length] - f13));
    }

    public e(Resources resources, Resources.Theme theme, AttributeSet attributeSet, XmlPullParser xmlPullParser) {
        TypedArray k11 = i.k(resources, theme, attributeSet, a.f11989l);
        d(k11, xmlPullParser);
        k11.recycle();
    }
}
