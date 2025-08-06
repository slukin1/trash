package s0;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.LinearGradient;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import androidx.core.R$styleable;
import java.io.IOException;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public final class e {
    public static a a(a aVar, int i11, int i12, boolean z11, int i13) {
        if (aVar != null) {
            return aVar;
        }
        if (z11) {
            return new a(i11, i13, i12);
        }
        return new a(i11, i12);
    }

    public static Shader b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws IOException, XmlPullParserException {
        XmlPullParser xmlPullParser2 = xmlPullParser;
        String name = xmlPullParser.getName();
        if (name.equals("gradient")) {
            Resources.Theme theme2 = theme;
            TypedArray k11 = i.k(resources, theme2, attributeSet, R$styleable.GradientColor);
            float f11 = i.f(k11, xmlPullParser2, "startX", R$styleable.GradientColor_android_startX, 0.0f);
            float f12 = i.f(k11, xmlPullParser2, "startY", R$styleable.GradientColor_android_startY, 0.0f);
            float f13 = i.f(k11, xmlPullParser2, "endX", R$styleable.GradientColor_android_endX, 0.0f);
            float f14 = i.f(k11, xmlPullParser2, "endY", R$styleable.GradientColor_android_endY, 0.0f);
            float f15 = i.f(k11, xmlPullParser2, "centerX", R$styleable.GradientColor_android_centerX, 0.0f);
            float f16 = i.f(k11, xmlPullParser2, "centerY", R$styleable.GradientColor_android_centerY, 0.0f);
            int g11 = i.g(k11, xmlPullParser2, "type", R$styleable.GradientColor_android_type, 0);
            int b11 = i.b(k11, xmlPullParser2, "startColor", R$styleable.GradientColor_android_startColor, 0);
            boolean j11 = i.j(xmlPullParser2, "centerColor");
            int b12 = i.b(k11, xmlPullParser2, "centerColor", R$styleable.GradientColor_android_centerColor, 0);
            int b13 = i.b(k11, xmlPullParser2, "endColor", R$styleable.GradientColor_android_endColor, 0);
            int g12 = i.g(k11, xmlPullParser2, "tileMode", R$styleable.GradientColor_android_tileMode, 0);
            float f17 = f15;
            float f18 = i.f(k11, xmlPullParser2, "gradientRadius", R$styleable.GradientColor_android_gradientRadius, 0.0f);
            k11.recycle();
            a a11 = a(c(resources, xmlPullParser, attributeSet, theme), b11, b13, j11, b12);
            if (g11 == 1) {
                float f19 = f17;
                if (f18 > 0.0f) {
                    int[] iArr = a11.f16474a;
                    return new RadialGradient(f19, f16, f18, iArr, a11.f16475b, d(g12));
                }
                throw new XmlPullParserException("<gradient> tag requires 'gradientRadius' attribute with radial type");
            } else if (g11 != 2) {
                return new LinearGradient(f11, f12, f13, f14, a11.f16474a, a11.f16475b, d(g12));
            } else {
                return new SweepGradient(f17, f16, a11.f16474a, a11.f16475b);
            }
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid gradient color tag " + name);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0080, code lost:
        throw new org.xmlpull.v1.XmlPullParserException(r10.getPositionDescription() + ": <item> tag requires a 'color' attribute and a 'offset' attribute!");
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static s0.e.a c(android.content.res.Resources r9, org.xmlpull.v1.XmlPullParser r10, android.util.AttributeSet r11, android.content.res.Resources.Theme r12) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            int r0 = r10.getDepth()
            r1 = 1
            int r0 = r0 + r1
            java.util.ArrayList r2 = new java.util.ArrayList
            r3 = 20
            r2.<init>(r3)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
        L_0x0012:
            int r3 = r10.next()
            if (r3 == r1) goto L_0x0081
            int r5 = r10.getDepth()
            if (r5 >= r0) goto L_0x0021
            r6 = 3
            if (r3 == r6) goto L_0x0081
        L_0x0021:
            r6 = 2
            if (r3 == r6) goto L_0x0025
            goto L_0x0012
        L_0x0025:
            if (r5 > r0) goto L_0x0012
            java.lang.String r3 = r10.getName()
            java.lang.String r5 = "item"
            boolean r3 = r3.equals(r5)
            if (r3 != 0) goto L_0x0034
            goto L_0x0012
        L_0x0034:
            int[] r3 = androidx.core.R$styleable.GradientColorItem
            android.content.res.TypedArray r3 = s0.i.k(r9, r12, r11, r3)
            int r5 = androidx.core.R$styleable.GradientColorItem_android_color
            boolean r6 = r3.hasValue(r5)
            int r7 = androidx.core.R$styleable.GradientColorItem_android_offset
            boolean r8 = r3.hasValue(r7)
            if (r6 == 0) goto L_0x0066
            if (r8 == 0) goto L_0x0066
            r6 = 0
            int r5 = r3.getColor(r5, r6)
            r6 = 0
            float r6 = r3.getFloat(r7, r6)
            r3.recycle()
            java.lang.Integer r3 = java.lang.Integer.valueOf(r5)
            r4.add(r3)
            java.lang.Float r3 = java.lang.Float.valueOf(r6)
            r2.add(r3)
            goto L_0x0012
        L_0x0066:
            org.xmlpull.v1.XmlPullParserException r9 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            java.lang.String r10 = r10.getPositionDescription()
            r11.append(r10)
            java.lang.String r10 = ": <item> tag requires a 'color' attribute and a 'offset' attribute!"
            r11.append(r10)
            java.lang.String r10 = r11.toString()
            r9.<init>(r10)
            throw r9
        L_0x0081:
            int r9 = r4.size()
            if (r9 <= 0) goto L_0x008d
            s0.e$a r9 = new s0.e$a
            r9.<init>((java.util.List<java.lang.Integer>) r4, (java.util.List<java.lang.Float>) r2)
            return r9
        L_0x008d:
            r9 = 0
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: s0.e.c(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):s0.e$a");
    }

    public static Shader.TileMode d(int i11) {
        if (i11 == 1) {
            return Shader.TileMode.REPEAT;
        }
        if (i11 != 2) {
            return Shader.TileMode.CLAMP;
        }
        return Shader.TileMode.MIRROR;
    }

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final int[] f16474a;

        /* renamed from: b  reason: collision with root package name */
        public final float[] f16475b;

        public a(List<Integer> list, List<Float> list2) {
            int size = list.size();
            this.f16474a = new int[size];
            this.f16475b = new float[size];
            for (int i11 = 0; i11 < size; i11++) {
                this.f16474a[i11] = list.get(i11).intValue();
                this.f16475b[i11] = list2.get(i11).floatValue();
            }
        }

        public a(int i11, int i12) {
            this.f16474a = new int[]{i11, i12};
            this.f16475b = new float[]{0.0f, 1.0f};
        }

        public a(int i11, int i12, int i13) {
            this.f16474a = new int[]{i11, i12, i13};
            this.f16475b = new float[]{0.0f, 0.5f, 1.0f};
        }
    }
}
