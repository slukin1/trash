package s0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import java.io.IOException;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import x0.a;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<TypedValue> f16470a = new ThreadLocal<>();

    /* JADX WARNING: Removed duplicated region for block: B:6:0x0011  */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0016  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.ColorStateList a(android.content.res.Resources r4, org.xmlpull.v1.XmlPullParser r5, android.content.res.Resources.Theme r6) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r5)
        L_0x0004:
            int r1 = r5.next()
            r2 = 2
            if (r1 == r2) goto L_0x000f
            r3 = 1
            if (r1 == r3) goto L_0x000f
            goto L_0x0004
        L_0x000f:
            if (r1 != r2) goto L_0x0016
            android.content.res.ColorStateList r4 = b(r4, r5, r0, r6)
            return r4
        L_0x0016:
            org.xmlpull.v1.XmlPullParserException r4 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r5 = "No start tag found"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: s0.c.a(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }

    public static ColorStateList b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) throws XmlPullParserException, IOException {
        String name = xmlPullParser.getName();
        if (name.equals("selector")) {
            return e(resources, xmlPullParser, attributeSet, theme);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid color state list tag " + name);
    }

    public static TypedValue c() {
        ThreadLocal<TypedValue> threadLocal = f16470a;
        TypedValue typedValue = threadLocal.get();
        if (typedValue != null) {
            return typedValue;
        }
        TypedValue typedValue2 = new TypedValue();
        threadLocal.set(typedValue2);
        return typedValue2;
    }

    public static ColorStateList d(Resources resources, int i11, Resources.Theme theme) {
        try {
            return a(resources, resources.getXml(i11), theme);
        } catch (Exception e11) {
            Log.e("CSLCompat", "Failed to inflate ColorStateList.", e11);
            return null;
        }
    }

    /* JADX WARNING: type inference failed for: r0v5, types: [java.lang.Object[]] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static android.content.res.ColorStateList e(android.content.res.Resources r17, org.xmlpull.v1.XmlPullParser r18, android.util.AttributeSet r19, android.content.res.Resources.Theme r20) throws org.xmlpull.v1.XmlPullParserException, java.io.IOException {
        /*
            r0 = r17
            r1 = r19
            r2 = r20
            int r3 = r18.getDepth()
            r4 = 1
            int r3 = r3 + r4
            r5 = 20
            int[][] r6 = new int[r5][]
            int[] r5 = new int[r5]
            r8 = 0
        L_0x0013:
            int r9 = r18.next()
            if (r9 == r4) goto L_0x00ec
            int r10 = r18.getDepth()
            if (r10 >= r3) goto L_0x0022
            r11 = 3
            if (r9 == r11) goto L_0x00ec
        L_0x0022:
            r11 = 2
            if (r9 != r11) goto L_0x00e7
            if (r10 > r3) goto L_0x00e7
            java.lang.String r9 = r18.getName()
            java.lang.String r10 = "item"
            boolean r9 = r9.equals(r10)
            if (r9 != 0) goto L_0x0035
            goto L_0x00e7
        L_0x0035:
            int[] r9 = androidx.core.R$styleable.ColorStateListItem
            android.content.res.TypedArray r9 = h(r0, r2, r1, r9)
            int r10 = androidx.core.R$styleable.ColorStateListItem_android_color
            r11 = -1
            int r12 = r9.getResourceId(r10, r11)
            r13 = -65281(0xffffffffffff00ff, float:NaN)
            if (r12 == r11) goto L_0x0061
            boolean r11 = f(r0, r12)
            if (r11 != 0) goto L_0x0061
            android.content.res.XmlResourceParser r10 = r0.getXml(r12)     // Catch:{ Exception -> 0x005a }
            android.content.res.ColorStateList r10 = a(r0, r10, r2)     // Catch:{ Exception -> 0x005a }
            int r10 = r10.getDefaultColor()     // Catch:{ Exception -> 0x005a }
            goto L_0x0065
        L_0x005a:
            int r10 = androidx.core.R$styleable.ColorStateListItem_android_color
            int r10 = r9.getColor(r10, r13)
            goto L_0x0065
        L_0x0061:
            int r10 = r9.getColor(r10, r13)
        L_0x0065:
            r11 = 1065353216(0x3f800000, float:1.0)
            int r12 = androidx.core.R$styleable.ColorStateListItem_android_alpha
            boolean r13 = r9.hasValue(r12)
            if (r13 == 0) goto L_0x0074
            float r11 = r9.getFloat(r12, r11)
            goto L_0x0080
        L_0x0074:
            int r12 = androidx.core.R$styleable.ColorStateListItem_alpha
            boolean r13 = r9.hasValue(r12)
            if (r13 == 0) goto L_0x0080
            float r11 = r9.getFloat(r12, r11)
        L_0x0080:
            int r12 = android.os.Build.VERSION.SDK_INT
            r13 = 31
            r14 = -1082130432(0xffffffffbf800000, float:-1.0)
            if (r12 < r13) goto L_0x0095
            int r12 = androidx.core.R$styleable.ColorStateListItem_android_lStar
            boolean r13 = r9.hasValue(r12)
            if (r13 == 0) goto L_0x0095
            float r12 = r9.getFloat(r12, r14)
            goto L_0x009b
        L_0x0095:
            int r12 = androidx.core.R$styleable.ColorStateListItem_lStar
            float r12 = r9.getFloat(r12, r14)
        L_0x009b:
            r9.recycle()
            int r9 = r19.getAttributeCount()
            int[] r13 = new int[r9]
            r14 = 0
            r15 = 0
        L_0x00a6:
            if (r14 >= r9) goto L_0x00d2
            int r4 = r1.getAttributeNameResource(r14)
            r7 = 16843173(0x10101a5, float:2.3694738E-38)
            if (r4 == r7) goto L_0x00cc
            r7 = 16843551(0x101031f, float:2.3695797E-38)
            if (r4 == r7) goto L_0x00cc
            int r7 = androidx.core.R$attr.alpha
            if (r4 == r7) goto L_0x00cc
            int r7 = androidx.core.R$attr.lStar
            if (r4 == r7) goto L_0x00cc
            int r7 = r15 + 1
            r0 = 0
            boolean r16 = r1.getAttributeBooleanValue(r14, r0)
            if (r16 == 0) goto L_0x00c8
            goto L_0x00c9
        L_0x00c8:
            int r4 = -r4
        L_0x00c9:
            r13[r15] = r4
            r15 = r7
        L_0x00cc:
            int r14 = r14 + 1
            r4 = 1
            r0 = r17
            goto L_0x00a6
        L_0x00d2:
            int[] r0 = android.util.StateSet.trimStateSet(r13, r15)
            int r4 = g(r10, r11, r12)
            int[] r5 = s0.f.a(r5, r8, r4)
            java.lang.Object[] r0 = s0.f.b(r6, r8, r0)
            r6 = r0
            int[][] r6 = (int[][]) r6
            int r8 = r8 + 1
        L_0x00e7:
            r4 = 1
            r0 = r17
            goto L_0x0013
        L_0x00ec:
            int[] r0 = new int[r8]
            int[][] r1 = new int[r8][]
            r2 = 0
            java.lang.System.arraycopy(r5, r2, r0, r2, r8)
            java.lang.System.arraycopy(r6, r2, r1, r2, r8)
            android.content.res.ColorStateList r2 = new android.content.res.ColorStateList
            r2.<init>(r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: s0.c.e(android.content.res.Resources, org.xmlpull.v1.XmlPullParser, android.util.AttributeSet, android.content.res.Resources$Theme):android.content.res.ColorStateList");
    }

    public static boolean f(Resources resources, int i11) {
        TypedValue c11 = c();
        resources.getValue(i11, c11, true);
        int i12 = c11.type;
        if (i12 < 28 || i12 > 31) {
            return false;
        }
        return true;
    }

    public static int g(int i11, float f11, float f12) {
        boolean z11 = f12 >= 0.0f && f12 <= 100.0f;
        if (f11 == 1.0f && !z11) {
            return i11;
        }
        int c11 = a.c((int) ((((float) Color.alpha(i11)) * f11) + 0.5f), 0, 255);
        if (z11) {
            a c12 = a.c(i11);
            i11 = a.m(c12.j(), c12.i(), f12);
        }
        return (i11 & FlexItem.MAX_SIZE) | (c11 << 24);
    }

    public static TypedArray h(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }
}
