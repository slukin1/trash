package androidx.core.view.accessibility;

import android.os.Build;
import android.os.Bundle;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import java.util.ArrayList;
import java.util.List;

public class AccessibilityNodeProviderCompat {

    /* renamed from: a  reason: collision with root package name */
    public final Object f8563a;

    public static class a extends AccessibilityNodeProvider {

        /* renamed from: a  reason: collision with root package name */
        public final AccessibilityNodeProviderCompat f8564a;

        public a(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            this.f8564a = accessibilityNodeProviderCompat;
        }

        public AccessibilityNodeInfo createAccessibilityNodeInfo(int i11) {
            AccessibilityNodeInfoCompat b11 = this.f8564a.b(i11);
            if (b11 == null) {
                return null;
            }
            return b11.T0();
        }

        public List<AccessibilityNodeInfo> findAccessibilityNodeInfosByText(String str, int i11) {
            List<AccessibilityNodeInfoCompat> c11 = this.f8564a.c(str, i11);
            if (c11 == null) {
                return null;
            }
            ArrayList arrayList = new ArrayList();
            int size = c11.size();
            for (int i12 = 0; i12 < size; i12++) {
                arrayList.add(c11.get(i12).T0());
            }
            return arrayList;
        }

        public boolean performAction(int i11, int i12, Bundle bundle) {
            return this.f8564a.f(i11, i12, bundle);
        }
    }

    public static class b extends a {
        public b(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            super(accessibilityNodeProviderCompat);
        }

        public AccessibilityNodeInfo findFocus(int i11) {
            AccessibilityNodeInfoCompat d11 = this.f8564a.d(i11);
            if (d11 == null) {
                return null;
            }
            return d11.T0();
        }
    }

    public static class c extends b {
        public c(AccessibilityNodeProviderCompat accessibilityNodeProviderCompat) {
            super(accessibilityNodeProviderCompat);
        }

        public void addExtraDataToAccessibilityNodeInfo(int i11, AccessibilityNodeInfo accessibilityNodeInfo, String str, Bundle bundle) {
            this.f8564a.a(i11, AccessibilityNodeInfoCompat.U0(accessibilityNodeInfo), str, bundle);
        }
    }

    public AccessibilityNodeProviderCompat() {
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 26) {
            this.f8563a = new c(this);
        } else if (i11 >= 19) {
            this.f8563a = new b(this);
        } else if (i11 >= 16) {
            this.f8563a = new a(this);
        } else {
            this.f8563a = null;
        }
    }

    public void a(int i11, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, String str, Bundle bundle) {
    }

    public AccessibilityNodeInfoCompat b(int i11) {
        return null;
    }

    public List<AccessibilityNodeInfoCompat> c(String str, int i11) {
        return null;
    }

    public AccessibilityNodeInfoCompat d(int i11) {
        return null;
    }

    public Object e() {
        return this.f8563a;
    }

    public boolean f(int i11, int i12, Bundle bundle) {
        return false;
    }

    public AccessibilityNodeProviderCompat(Object obj) {
        this.f8563a = obj;
    }
}
