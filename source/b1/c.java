package b1;

import android.os.Build;
import android.view.View;
import android.view.accessibility.AccessibilityRecord;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public final AccessibilityRecord f12287a;

    public static class a {
        public static int a(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollX();
        }

        public static int b(AccessibilityRecord accessibilityRecord) {
            return accessibilityRecord.getMaxScrollY();
        }

        public static void c(AccessibilityRecord accessibilityRecord, int i11) {
            accessibilityRecord.setMaxScrollX(i11);
        }

        public static void d(AccessibilityRecord accessibilityRecord, int i11) {
            accessibilityRecord.setMaxScrollY(i11);
        }
    }

    public static class b {
        public static void a(AccessibilityRecord accessibilityRecord, View view, int i11) {
            accessibilityRecord.setSource(view, i11);
        }
    }

    @Deprecated
    public c(Object obj) {
        this.f12287a = (AccessibilityRecord) obj;
    }

    @Deprecated
    public static c a() {
        return new c(AccessibilityRecord.obtain());
    }

    public static void d(AccessibilityRecord accessibilityRecord, int i11) {
        if (Build.VERSION.SDK_INT >= 15) {
            a.c(accessibilityRecord, i11);
        }
    }

    public static void e(AccessibilityRecord accessibilityRecord, int i11) {
        if (Build.VERSION.SDK_INT >= 15) {
            a.d(accessibilityRecord, i11);
        }
    }

    public static void g(AccessibilityRecord accessibilityRecord, View view, int i11) {
        if (Build.VERSION.SDK_INT >= 16) {
            b.a(accessibilityRecord, view, i11);
        }
    }

    @Deprecated
    public void b(int i11) {
        this.f12287a.setFromIndex(i11);
    }

    @Deprecated
    public void c(int i11) {
        this.f12287a.setItemCount(i11);
    }

    @Deprecated
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        AccessibilityRecord accessibilityRecord = this.f12287a;
        if (accessibilityRecord != null) {
            return accessibilityRecord.equals(cVar.f12287a);
        }
        if (cVar.f12287a == null) {
            return true;
        }
        return false;
    }

    @Deprecated
    public void f(boolean z11) {
        this.f12287a.setScrollable(z11);
    }

    @Deprecated
    public void h(int i11) {
        this.f12287a.setToIndex(i11);
    }

    @Deprecated
    public int hashCode() {
        AccessibilityRecord accessibilityRecord = this.f12287a;
        if (accessibilityRecord == null) {
            return 0;
        }
        return accessibilityRecord.hashCode();
    }
}
