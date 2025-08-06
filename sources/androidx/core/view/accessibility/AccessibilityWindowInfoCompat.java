package androidx.core.view.accessibility;

import android.graphics.Rect;
import android.os.Build;
import android.os.LocaleList;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityWindowInfo;
import androidx.core.os.LocaleListCompat;

public class AccessibilityWindowInfoCompat {

    /* renamed from: a  reason: collision with root package name */
    public final Object f8566a;

    public static class a {
        public static void a(AccessibilityWindowInfo accessibilityWindowInfo, Rect rect) {
            accessibilityWindowInfo.getBoundsInScreen(rect);
        }

        public static AccessibilityWindowInfo b(AccessibilityWindowInfo accessibilityWindowInfo, int i11) {
            return accessibilityWindowInfo.getChild(i11);
        }

        public static int c(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getChildCount();
        }

        public static int d(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getId();
        }

        public static int e(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getLayer();
        }

        public static AccessibilityWindowInfo f(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getParent();
        }

        public static AccessibilityNodeInfo g(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getRoot();
        }

        public static int h(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getType();
        }

        public static boolean i(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isAccessibilityFocused();
        }

        public static boolean j(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isActive();
        }

        public static boolean k(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.isFocused();
        }

        public static AccessibilityWindowInfo l() {
            return AccessibilityWindowInfo.obtain();
        }

        public static AccessibilityWindowInfo m(AccessibilityWindowInfo accessibilityWindowInfo) {
            return AccessibilityWindowInfo.obtain(accessibilityWindowInfo);
        }
    }

    public static class b {
        public static AccessibilityWindowInfo a() {
            return new AccessibilityWindowInfo();
        }
    }

    public static class c {
        public static LocaleList a(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getLocales();
        }

        public static long b(AccessibilityWindowInfo accessibilityWindowInfo) {
            return accessibilityWindowInfo.getTransitionTimeMillis();
        }
    }

    public AccessibilityWindowInfoCompat() {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f8566a = b.a();
        } else {
            this.f8566a = null;
        }
    }

    public static String k(int i11) {
        return i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? "<UNKNOWN>" : "TYPE_ACCESSIBILITY_OVERLAY" : "TYPE_SYSTEM" : "TYPE_INPUT_METHOD" : "TYPE_APPLICATION";
    }

    public static AccessibilityWindowInfoCompat l(Object obj) {
        if (obj != null) {
            return new AccessibilityWindowInfoCompat(obj);
        }
        return null;
    }

    public void a(Rect rect) {
        if (Build.VERSION.SDK_INT >= 21) {
            a.a((AccessibilityWindowInfo) this.f8566a, rect);
        }
    }

    public int b() {
        if (Build.VERSION.SDK_INT >= 21) {
            return a.c((AccessibilityWindowInfo) this.f8566a);
        }
        return 0;
    }

    public int c() {
        if (Build.VERSION.SDK_INT >= 21) {
            return a.d((AccessibilityWindowInfo) this.f8566a);
        }
        return -1;
    }

    public int d() {
        if (Build.VERSION.SDK_INT >= 21) {
            return a.e((AccessibilityWindowInfo) this.f8566a);
        }
        return -1;
    }

    public LocaleListCompat e() {
        if (Build.VERSION.SDK_INT >= 34) {
            return LocaleListCompat.j(c.a((AccessibilityWindowInfo) this.f8566a));
        }
        return LocaleListCompat.e();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AccessibilityWindowInfoCompat)) {
            return false;
        }
        AccessibilityWindowInfoCompat accessibilityWindowInfoCompat = (AccessibilityWindowInfoCompat) obj;
        Object obj2 = this.f8566a;
        if (obj2 != null) {
            return obj2.equals(accessibilityWindowInfoCompat.f8566a);
        }
        if (accessibilityWindowInfoCompat.f8566a == null) {
            return true;
        }
        return false;
    }

    public AccessibilityWindowInfoCompat f() {
        if (Build.VERSION.SDK_INT >= 21) {
            return l(a.f((AccessibilityWindowInfo) this.f8566a));
        }
        return null;
    }

    public long g() {
        if (Build.VERSION.SDK_INT >= 34) {
            return c.b((AccessibilityWindowInfo) this.f8566a);
        }
        return 0;
    }

    public int h() {
        if (Build.VERSION.SDK_INT >= 21) {
            return a.h((AccessibilityWindowInfo) this.f8566a);
        }
        return -1;
    }

    public int hashCode() {
        Object obj = this.f8566a;
        if (obj == null) {
            return 0;
        }
        return obj.hashCode();
    }

    public boolean i() {
        if (Build.VERSION.SDK_INT >= 21) {
            return a.j((AccessibilityWindowInfo) this.f8566a);
        }
        return true;
    }

    public boolean j() {
        if (Build.VERSION.SDK_INT >= 21) {
            return a.k((AccessibilityWindowInfo) this.f8566a);
        }
        return true;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        Rect rect = new Rect();
        a(rect);
        sb2.append("AccessibilityWindowInfo[");
        sb2.append("id=");
        sb2.append(c());
        sb2.append(", type=");
        sb2.append(k(h()));
        sb2.append(", layer=");
        sb2.append(d());
        sb2.append(", bounds=");
        sb2.append(rect);
        sb2.append(", focused=");
        sb2.append(j());
        sb2.append(", active=");
        sb2.append(i());
        sb2.append(", hasParent=");
        boolean z11 = true;
        sb2.append(f() != null);
        sb2.append(", hasChildren=");
        if (b() <= 0) {
            z11 = false;
        }
        sb2.append(z11);
        sb2.append(", transitionTime=");
        sb2.append(g());
        sb2.append(", locales=");
        sb2.append(e());
        sb2.append(']');
        return sb2.toString();
    }

    public AccessibilityWindowInfoCompat(Object obj) {
        this.f8566a = obj;
    }
}
