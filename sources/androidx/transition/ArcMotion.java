package androidx.transition;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Path;
import android.util.AttributeSet;
import org.xmlpull.v1.XmlPullParser;
import s0.i;
import v1.l;

public class ArcMotion extends PathMotion {

    /* renamed from: g  reason: collision with root package name */
    public static final float f11707g = ((float) Math.tan(Math.toRadians(35.0d)));

    /* renamed from: a  reason: collision with root package name */
    public float f11708a = 0.0f;

    /* renamed from: b  reason: collision with root package name */
    public float f11709b = 0.0f;

    /* renamed from: c  reason: collision with root package name */
    public float f11710c = 70.0f;

    /* renamed from: d  reason: collision with root package name */
    public float f11711d = 0.0f;

    /* renamed from: e  reason: collision with root package name */
    public float f11712e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    public float f11713f = f11707g;

    public ArcMotion() {
    }

    public static float d(float f11) {
        if (f11 >= 0.0f && f11 <= 90.0f) {
            return (float) Math.tan(Math.toRadians((double) (f11 / 2.0f)));
        }
        throw new IllegalArgumentException("Arc must be between 0 and 90 degrees");
    }

    public void a(float f11) {
        this.f11710c = f11;
        this.f11713f = d(f11);
    }

    public void b(float f11) {
        this.f11708a = f11;
        this.f11711d = d(f11);
    }

    public void c(float f11) {
        this.f11709b = f11;
        this.f11712e = d(f11);
    }

    public Path getPath(float f11, float f12, float f13, float f14) {
        float f15;
        float f16;
        float f17;
        float f18;
        float f19;
        Path path = new Path();
        path.moveTo(f11, f12);
        float f21 = f13 - f11;
        float f22 = f14 - f12;
        float f23 = (f21 * f21) + (f22 * f22);
        float f24 = (f11 + f13) / 2.0f;
        float f25 = (f12 + f14) / 2.0f;
        float f26 = 0.25f * f23;
        boolean z11 = f12 > f14;
        if (Math.abs(f21) < Math.abs(f22)) {
            float abs = Math.abs(f23 / (f22 * 2.0f));
            if (z11) {
                f17 = abs + f14;
                f16 = f13;
            } else {
                f17 = abs + f12;
                f16 = f11;
            }
            f15 = this.f11712e;
        } else {
            float f27 = f23 / (f21 * 2.0f);
            if (z11) {
                f19 = f12;
                f18 = f27 + f11;
            } else {
                f18 = f13 - f27;
                f19 = f14;
            }
            f15 = this.f11711d;
        }
        float f28 = f26 * f15 * f15;
        float f29 = f24 - f16;
        float f31 = f25 - f17;
        float f32 = (f29 * f29) + (f31 * f31);
        float f33 = this.f11713f;
        float f34 = f26 * f33 * f33;
        if (f32 >= f28) {
            f28 = f32 > f34 ? f34 : 0.0f;
        }
        if (f28 != 0.0f) {
            float sqrt = (float) Math.sqrt((double) (f28 / f32));
            f16 = ((f16 - f24) * sqrt) + f24;
            f17 = f25 + (sqrt * (f17 - f25));
        }
        path.cubicTo((f11 + f16) / 2.0f, (f12 + f17) / 2.0f, (f16 + f13) / 2.0f, (f17 + f14) / 2.0f, f13, f14);
        return path;
    }

    @SuppressLint({"RestrictedApi"})
    public ArcMotion(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f16671j);
        XmlPullParser xmlPullParser = (XmlPullParser) attributeSet;
        c(i.f(obtainStyledAttributes, xmlPullParser, "minimumVerticalAngle", 1, 0.0f));
        b(i.f(obtainStyledAttributes, xmlPullParser, "minimumHorizontalAngle", 0, 0.0f));
        a(i.f(obtainStyledAttributes, xmlPullParser, "maximumAngle", 2, 70.0f));
        obtainStyledAttributes.recycle();
    }
}
