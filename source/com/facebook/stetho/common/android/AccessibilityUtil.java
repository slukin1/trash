package com.facebook.stetho.common.android;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import android.widget.Spinner;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.h0;
import java.util.List;

public final class AccessibilityUtil {
    private AccessibilityUtil() {
    }

    public static boolean hasFocusableAncestor(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, View view) {
        if (accessibilityNodeInfoCompat == null || view == null) {
            return false;
        }
        ViewParent M = h0.M(view);
        if (!(M instanceof View)) {
            return false;
        }
        AccessibilityNodeInfoCompat a02 = AccessibilityNodeInfoCompat.a0();
        try {
            h0.j0((View) M, a02);
            if (a02 == null) {
                return false;
            }
            if (isAccessibilityFocusable(a02, (View) M)) {
                a02.e0();
                return true;
            } else if (hasFocusableAncestor(a02, (View) M)) {
                a02.e0();
                return true;
            } else {
                a02.e0();
                return false;
            }
        } finally {
            a02.e0();
        }
    }

    public static boolean hasNonActionableSpeakingDescendants(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, View view) {
        if (!(accessibilityNodeInfoCompat == null || view == null || !(view instanceof ViewGroup))) {
            ViewGroup viewGroup = (ViewGroup) view;
            int childCount = viewGroup.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = viewGroup.getChildAt(i11);
                if (childAt != null) {
                    AccessibilityNodeInfoCompat a02 = AccessibilityNodeInfoCompat.a0();
                    try {
                        h0.j0(childAt, a02);
                        if (!isAccessibilityFocusable(a02, childAt)) {
                            if (isSpeakingNode(a02, childAt)) {
                                a02.e0();
                                return true;
                            }
                        }
                    } finally {
                        a02.e0();
                    }
                }
            }
        }
        return false;
    }

    public static boolean hasText(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (accessibilityNodeInfoCompat == null) {
            return false;
        }
        return !TextUtils.isEmpty(accessibilityNodeInfoCompat.C()) || !TextUtils.isEmpty(accessibilityNodeInfoCompat.t());
    }

    public static boolean isAccessibilityFocusable(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, View view) {
        if (accessibilityNodeInfoCompat == null || view == null || !accessibilityNodeInfoCompat.Z()) {
            return false;
        }
        if (isActionableForAccessibility(accessibilityNodeInfoCompat)) {
            return true;
        }
        if (!isTopLevelScrollItem(accessibilityNodeInfoCompat, view) || !isSpeakingNode(accessibilityNodeInfoCompat, view)) {
            return false;
        }
        return true;
    }

    public static boolean isActionableForAccessibility(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        if (accessibilityNodeInfoCompat == null) {
            return false;
        }
        if (accessibilityNodeInfoCompat.M() || accessibilityNodeInfoCompat.T() || accessibilityNodeInfoCompat.P()) {
            return true;
        }
        List<AccessibilityNodeInfoCompat.a> i11 = accessibilityNodeInfoCompat.i();
        if (i11.contains(16) || i11.contains(32) || i11.contains(1)) {
            return true;
        }
        return false;
    }

    public static boolean isSpeakingNode(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, View view) {
        int D;
        if (accessibilityNodeInfoCompat == null || view == null || !accessibilityNodeInfoCompat.Z() || (D = h0.D(view)) == 4) {
            return false;
        }
        if (D == 2 && accessibilityNodeInfoCompat.p() <= 0) {
            return false;
        }
        if (accessibilityNodeInfoCompat.K() || hasText(accessibilityNodeInfoCompat) || hasNonActionableSpeakingDescendants(accessibilityNodeInfoCompat, view)) {
            return true;
        }
        return false;
    }

    public static boolean isTopLevelScrollItem(AccessibilityNodeInfoCompat accessibilityNodeInfoCompat, View view) {
        View view2;
        if (accessibilityNodeInfoCompat == null || view == null || (view2 = (View) h0.M(view)) == null) {
            return false;
        }
        if (accessibilityNodeInfoCompat.V()) {
            return true;
        }
        List<AccessibilityNodeInfoCompat.a> i11 = accessibilityNodeInfoCompat.i();
        if (i11.contains(4096) || i11.contains(8192)) {
            return true;
        }
        if (view2 instanceof Spinner) {
            return false;
        }
        if ((view2 instanceof AdapterView) || (view2 instanceof ScrollView) || (view2 instanceof HorizontalScrollView)) {
            return true;
        }
        return false;
    }
}
