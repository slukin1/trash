package androidx.core.view;

import android.os.Build;
import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.accessibility.AccessibilityNodeProvider;
import androidx.core.R$id;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.accessibility.AccessibilityNodeProviderCompat;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;

public class AccessibilityDelegateCompat {
    private static final View.AccessibilityDelegate DEFAULT_DELEGATE = new View.AccessibilityDelegate();
    private final View.AccessibilityDelegate mBridge;
    private final View.AccessibilityDelegate mOriginalDelegate;

    public static final class a extends View.AccessibilityDelegate {

        /* renamed from: a  reason: collision with root package name */
        public final AccessibilityDelegateCompat f8485a;

        public a(AccessibilityDelegateCompat accessibilityDelegateCompat) {
            this.f8485a = accessibilityDelegateCompat;
        }

        public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            return this.f8485a.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public AccessibilityNodeProvider getAccessibilityNodeProvider(View view) {
            AccessibilityNodeProviderCompat accessibilityNodeProvider = this.f8485a.getAccessibilityNodeProvider(view);
            if (accessibilityNodeProvider != null) {
                return (AccessibilityNodeProvider) accessibilityNodeProvider.e();
            }
            return null;
        }

        public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f8485a.onInitializeAccessibilityEvent(view, accessibilityEvent);
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfo accessibilityNodeInfo) {
            AccessibilityNodeInfoCompat U0 = AccessibilityNodeInfoCompat.U0(accessibilityNodeInfo);
            U0.J0(h0.d0(view));
            U0.y0(h0.Y(view));
            U0.E0(h0.s(view));
            U0.P0(h0.O(view));
            this.f8485a.onInitializeAccessibilityNodeInfo(view, U0);
            U0.f(accessibilityNodeInfo.getText(), view);
            List<AccessibilityNodeInfoCompat.a> actionList = AccessibilityDelegateCompat.getActionList(view);
            for (int i11 = 0; i11 < actionList.size(); i11++) {
                U0.b(actionList.get(i11));
            }
        }

        public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
            this.f8485a.onPopulateAccessibilityEvent(view, accessibilityEvent);
        }

        public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
            return this.f8485a.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
        }

        public boolean performAccessibilityAction(View view, int i11, Bundle bundle) {
            return this.f8485a.performAccessibilityAction(view, i11, bundle);
        }

        public void sendAccessibilityEvent(View view, int i11) {
            this.f8485a.sendAccessibilityEvent(view, i11);
        }

        public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
            this.f8485a.sendAccessibilityEventUnchecked(view, accessibilityEvent);
        }
    }

    public static class b {
        public static AccessibilityNodeProvider a(View.AccessibilityDelegate accessibilityDelegate, View view) {
            return accessibilityDelegate.getAccessibilityNodeProvider(view);
        }

        public static boolean b(View.AccessibilityDelegate accessibilityDelegate, View view, int i11, Bundle bundle) {
            return accessibilityDelegate.performAccessibilityAction(view, i11, bundle);
        }
    }

    public AccessibilityDelegateCompat() {
        this(DEFAULT_DELEGATE);
    }

    public static List<AccessibilityNodeInfoCompat.a> getActionList(View view) {
        List<AccessibilityNodeInfoCompat.a> list = (List) view.getTag(R$id.tag_accessibility_actions);
        return list == null ? Collections.emptyList() : list;
    }

    private boolean isSpanStillValid(ClickableSpan clickableSpan, View view) {
        if (clickableSpan != null) {
            ClickableSpan[] r11 = AccessibilityNodeInfoCompat.r(view.createAccessibilityNodeInfo().getText());
            int i11 = 0;
            while (r11 != null && i11 < r11.length) {
                if (clickableSpan.equals(r11[i11])) {
                    return true;
                }
                i11++;
            }
        }
        return false;
    }

    private boolean performClickableSpanAction(int i11, View view) {
        WeakReference weakReference;
        SparseArray sparseArray = (SparseArray) view.getTag(R$id.tag_accessibility_clickable_spans);
        if (sparseArray == null || (weakReference = (WeakReference) sparseArray.get(i11)) == null) {
            return false;
        }
        ClickableSpan clickableSpan = (ClickableSpan) weakReference.get();
        if (!isSpanStillValid(clickableSpan, view)) {
            return false;
        }
        clickableSpan.onClick(view);
        return true;
    }

    public boolean dispatchPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.dispatchPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public AccessibilityNodeProviderCompat getAccessibilityNodeProvider(View view) {
        AccessibilityNodeProvider a11;
        if (Build.VERSION.SDK_INT < 16 || (a11 = b.a(this.mOriginalDelegate, view)) == null) {
            return null;
        }
        return new AccessibilityNodeProviderCompat(a11);
    }

    public View.AccessibilityDelegate getBridge() {
        return this.mBridge;
    }

    public void onInitializeAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onInitializeAccessibilityEvent(view, accessibilityEvent);
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        this.mOriginalDelegate.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat.T0());
    }

    public void onPopulateAccessibilityEvent(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.onPopulateAccessibilityEvent(view, accessibilityEvent);
    }

    public boolean onRequestSendAccessibilityEvent(ViewGroup viewGroup, View view, AccessibilityEvent accessibilityEvent) {
        return this.mOriginalDelegate.onRequestSendAccessibilityEvent(viewGroup, view, accessibilityEvent);
    }

    public boolean performAccessibilityAction(View view, int i11, Bundle bundle) {
        List<AccessibilityNodeInfoCompat.a> actionList = getActionList(view);
        boolean z11 = false;
        int i12 = 0;
        while (true) {
            if (i12 >= actionList.size()) {
                break;
            }
            AccessibilityNodeInfoCompat.a aVar = actionList.get(i12);
            if (aVar.b() == i11) {
                z11 = aVar.d(view, bundle);
                break;
            }
            i12++;
        }
        if (!z11 && Build.VERSION.SDK_INT >= 16) {
            z11 = b.b(this.mOriginalDelegate, view, i11, bundle);
        }
        return (z11 || i11 != R$id.accessibility_action_clickable_span || bundle == null) ? z11 : performClickableSpanAction(bundle.getInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", -1), view);
    }

    public void sendAccessibilityEvent(View view, int i11) {
        this.mOriginalDelegate.sendAccessibilityEvent(view, i11);
    }

    public void sendAccessibilityEventUnchecked(View view, AccessibilityEvent accessibilityEvent) {
        this.mOriginalDelegate.sendAccessibilityEventUnchecked(view, accessibilityEvent);
    }

    public AccessibilityDelegateCompat(View.AccessibilityDelegate accessibilityDelegate) {
        this.mOriginalDelegate = accessibilityDelegate;
        this.mBridge = new a(this);
    }
}
