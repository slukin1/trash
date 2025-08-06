package b1;

import android.os.Build;
import android.view.accessibility.AccessibilityEvent;

public final class b {

    public static class a {
        public static int a(AccessibilityEvent accessibilityEvent) {
            return accessibilityEvent.getContentChangeTypes();
        }

        public static void b(AccessibilityEvent accessibilityEvent, int i11) {
            accessibilityEvent.setContentChangeTypes(i11);
        }
    }

    public static int a(AccessibilityEvent accessibilityEvent) {
        if (Build.VERSION.SDK_INT >= 19) {
            return a.a(accessibilityEvent);
        }
        return 0;
    }

    public static void b(AccessibilityEvent accessibilityEvent, int i11) {
        if (Build.VERSION.SDK_INT >= 19) {
            a.b(accessibilityEvent, i11);
        }
    }
}
