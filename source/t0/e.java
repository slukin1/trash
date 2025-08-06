package t0;

import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import androidx.core.util.c;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<c<Rect, Rect>> f16516a = new ThreadLocal<>();

    public static class a {
        public static boolean a(Paint paint, String str) {
            return paint.hasGlyph(str);
        }
    }

    public static boolean a(Paint paint, String str) {
        if (Build.VERSION.SDK_INT >= 23) {
            return a.a(paint, str);
        }
        int length = str.length();
        if (length == 1 && Character.isWhitespace(str.charAt(0))) {
            return true;
        }
        float measureText = paint.measureText("󟿽");
        float measureText2 = paint.measureText("m");
        float measureText3 = paint.measureText(str);
        float f11 = 0.0f;
        if (measureText3 == 0.0f) {
            return false;
        }
        if (str.codePointCount(0, str.length()) > 1) {
            if (measureText3 > measureText2 * 2.0f) {
                return false;
            }
            int i11 = 0;
            while (i11 < length) {
                int charCount = Character.charCount(str.codePointAt(i11)) + i11;
                f11 += paint.measureText(str, i11, charCount);
                i11 = charCount;
            }
            if (measureText3 >= f11) {
                return false;
            }
        }
        if (measureText3 != measureText) {
            return true;
        }
        c<Rect, Rect> b11 = b();
        paint.getTextBounds("󟿽", 0, 2, (Rect) b11.f8468a);
        paint.getTextBounds(str, 0, length, (Rect) b11.f8469b);
        return !((Rect) b11.f8468a).equals(b11.f8469b);
    }

    public static c<Rect, Rect> b() {
        ThreadLocal<c<Rect, Rect>> threadLocal = f16516a;
        c<Rect, Rect> cVar = threadLocal.get();
        if (cVar == null) {
            c<Rect, Rect> cVar2 = new c<>(new Rect(), new Rect());
            threadLocal.set(cVar2);
            return cVar2;
        }
        ((Rect) cVar.f8468a).setEmpty();
        ((Rect) cVar.f8469b).setEmpty();
        return cVar;
    }
}
