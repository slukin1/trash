package com.google.android.material.timepicker;

import android.content.Context;
import android.view.View;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;

class ClickActionDelegate extends AccessibilityDelegateCompat {
    private final AccessibilityNodeInfoCompat.a clickAction;

    public ClickActionDelegate(Context context, int i11) {
        this.clickAction = new AccessibilityNodeInfoCompat.a(16, context.getString(i11));
    }

    public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
        super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
        accessibilityNodeInfoCompat.b(this.clickAction);
    }
}
