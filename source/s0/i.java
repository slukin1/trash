package s0;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import org.xmlpull.v1.XmlPullParser;

public class i {
    public static boolean a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i11, boolean z11) {
        if (!j(xmlPullParser, str)) {
            return z11;
        }
        return typedArray.getBoolean(i11, z11);
    }

    public static int b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i11, int i12) {
        if (!j(xmlPullParser, str)) {
            return i12;
        }
        return typedArray.getColor(i11, i12);
    }

    public static ColorStateList c(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i11) {
        if (!j(xmlPullParser, str)) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i11, typedValue);
        int i12 = typedValue.type;
        if (i12 == 2) {
            throw new UnsupportedOperationException("Failed to resolve attribute at index " + i11 + l.f34627b + typedValue);
        } else if (i12 < 28 || i12 > 31) {
            return c.d(typedArray.getResources(), typedArray.getResourceId(i11, 0), theme);
        } else {
            return d(typedValue);
        }
    }

    public static ColorStateList d(TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    public static d e(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i11, int i12) {
        if (j(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i11, typedValue);
            int i13 = typedValue.type;
            if (i13 >= 28 && i13 <= 31) {
                return d.b(typedValue.data);
            }
            d g11 = d.g(typedArray.getResources(), typedArray.getResourceId(i11, 0), theme);
            if (g11 != null) {
                return g11;
            }
        }
        return d.b(i12);
    }

    public static float f(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i11, float f11) {
        if (!j(xmlPullParser, str)) {
            return f11;
        }
        return typedArray.getFloat(i11, f11);
    }

    public static int g(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i11, int i12) {
        if (!j(xmlPullParser, str)) {
            return i12;
        }
        return typedArray.getInt(i11, i12);
    }

    public static int h(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i11, int i12) {
        if (!j(xmlPullParser, str)) {
            return i12;
        }
        return typedArray.getResourceId(i11, i12);
    }

    public static String i(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i11) {
        if (!j(xmlPullParser, str)) {
            return null;
        }
        return typedArray.getString(i11);
    }

    public static boolean j(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    public static TypedArray k(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        if (theme == null) {
            return resources.obtainAttributes(attributeSet, iArr);
        }
        return theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    public static TypedValue l(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i11) {
        if (!j(xmlPullParser, str)) {
            return null;
        }
        return typedArray.peekValue(i11);
    }
}
