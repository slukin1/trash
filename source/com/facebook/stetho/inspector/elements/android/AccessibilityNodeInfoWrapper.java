package com.facebook.stetho.inspector.elements.android;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.view.h0;
import com.facebook.stetho.common.android.AccessibilityUtil;

public final class AccessibilityNodeInfoWrapper {
    public static AccessibilityNodeInfoCompat createNodeInfoFromView(View view) {
        AccessibilityNodeInfoCompat a02 = AccessibilityNodeInfoCompat.a0();
        h0.j0(view, a02);
        return a02;
    }

    public static String getActions(View view) {
        AccessibilityNodeInfoCompat createNodeInfoFromView = createNodeInfoFromView(view);
        try {
            StringBuilder sb2 = new StringBuilder();
            for (AccessibilityNodeInfoCompat.a next : createNodeInfoFromView.i()) {
                if (sb2.length() > 0) {
                    sb2.append(", ");
                }
                int b11 = next.b();
                if (b11 == 1) {
                    sb2.append("focus");
                } else if (b11 != 2) {
                    switch (b11) {
                        case 4:
                            sb2.append("select");
                            break;
                        case 8:
                            sb2.append("clear-selection");
                            break;
                        case 16:
                            sb2.append("click");
                            break;
                        case 32:
                            sb2.append("long-click");
                            break;
                        case 64:
                            sb2.append("accessibility-focus");
                            break;
                        case 128:
                            sb2.append("clear-accessibility-focus");
                            break;
                        case 256:
                            sb2.append("next-at-movement-granularity");
                            break;
                        case 512:
                            sb2.append("previous-at-movement-granularity");
                            break;
                        case 1024:
                            sb2.append("next-html-element");
                            break;
                        case 2048:
                            sb2.append("previous-html-element");
                            break;
                        case 4096:
                            sb2.append("scroll-forward");
                            break;
                        case 8192:
                            sb2.append("scroll-backward");
                            break;
                        case 16384:
                            sb2.append("copy");
                            break;
                        case 32768:
                            sb2.append("paste");
                            break;
                        case 65536:
                            sb2.append("cut");
                            break;
                        case 131072:
                            sb2.append("set-selection");
                            break;
                        default:
                            CharSequence c11 = next.c();
                            if (c11 == null) {
                                sb2.append("unknown");
                                break;
                            } else {
                                sb2.append(c11);
                                break;
                            }
                    }
                } else {
                    sb2.append("clear-focus");
                }
            }
            return sb2.length() > 0 ? sb2.toString() : null;
        } finally {
            createNodeInfoFromView.e0();
        }
    }

    public static CharSequence getDescription(View view) {
        AccessibilityNodeInfoCompat createNodeInfoFromView = createNodeInfoFromView(view);
        try {
            CharSequence t11 = createNodeInfoFromView.t();
            CharSequence C = createNodeInfoFromView.C();
            boolean z11 = !TextUtils.isEmpty(C);
            boolean z12 = view instanceof EditText;
            if (!TextUtils.isEmpty(t11) && (!z12 || !z11)) {
                return t11;
            }
            if (z11) {
                createNodeInfoFromView.e0();
                return C;
            }
            String str = null;
            if (view instanceof ViewGroup) {
                StringBuilder sb2 = new StringBuilder();
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i11 = 0; i11 < childCount; i11++) {
                    View childAt = viewGroup.getChildAt(i11);
                    AccessibilityNodeInfoCompat a02 = AccessibilityNodeInfoCompat.a0();
                    h0.j0(childAt, a02);
                    CharSequence description = (!AccessibilityUtil.isSpeakingNode(a02, childAt) || AccessibilityUtil.isAccessibilityFocusable(a02, childAt)) ? null : getDescription(childAt);
                    if (!TextUtils.isEmpty(description)) {
                        if (sb2.length() > 0) {
                            sb2.append(", ");
                        }
                        sb2.append(description);
                    }
                    a02.e0();
                }
                if (sb2.length() > 0) {
                    str = sb2.toString();
                }
                createNodeInfoFromView.e0();
                return str;
            }
            createNodeInfoFromView.e0();
            return null;
        } finally {
            createNodeInfoFromView.e0();
        }
    }

    public static String getFocusableReasons(View view) {
        AccessibilityNodeInfoCompat createNodeInfoFromView = createNodeInfoFromView(view);
        try {
            boolean hasText = AccessibilityUtil.hasText(createNodeInfoFromView);
            boolean K = createNodeInfoFromView.K();
            boolean hasNonActionableSpeakingDescendants = AccessibilityUtil.hasNonActionableSpeakingDescendants(createNodeInfoFromView, view);
            if (AccessibilityUtil.isActionableForAccessibility(createNodeInfoFromView)) {
                if (createNodeInfoFromView.p() <= 0) {
                    return "View is actionable and has no children.";
                }
                if (hasText) {
                    createNodeInfoFromView.e0();
                    return "View is actionable and has a description.";
                } else if (K) {
                    createNodeInfoFromView.e0();
                    return "View is actionable and checkable.";
                } else if (hasNonActionableSpeakingDescendants) {
                    createNodeInfoFromView.e0();
                    return "View is actionable and has non-actionable descendants with descriptions.";
                }
            }
            if (AccessibilityUtil.isTopLevelScrollItem(createNodeInfoFromView, view)) {
                if (hasText) {
                    createNodeInfoFromView.e0();
                    return "View is a direct child of a scrollable container and has a description.";
                } else if (K) {
                    createNodeInfoFromView.e0();
                    return "View is a direct child of a scrollable container and is checkable.";
                } else if (hasNonActionableSpeakingDescendants) {
                    createNodeInfoFromView.e0();
                    return "View is a direct child of a scrollable container and has non-actionable descendants with descriptions.";
                }
            }
            if (hasText) {
                createNodeInfoFromView.e0();
                return "View has a description and is not actionable, but has no actionable ancestor.";
            }
            createNodeInfoFromView.e0();
            return null;
        } finally {
            createNodeInfoFromView.e0();
        }
    }

    public static boolean getIgnored(View view) {
        int D = h0.D(view);
        if (D == 2 || D == 4) {
            return true;
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (h0.D((View) parent) == 4) {
                return true;
            }
        }
        AccessibilityNodeInfoCompat createNodeInfoFromView = createNodeInfoFromView(view);
        try {
            if (!createNodeInfoFromView.Z()) {
                return true;
            }
            if (AccessibilityUtil.isAccessibilityFocusable(createNodeInfoFromView, view)) {
                if (createNodeInfoFromView.p() <= 0) {
                    createNodeInfoFromView.e0();
                    return false;
                } else if (AccessibilityUtil.isSpeakingNode(createNodeInfoFromView, view)) {
                    createNodeInfoFromView.e0();
                    return false;
                } else {
                    createNodeInfoFromView.e0();
                    return true;
                }
            } else if (AccessibilityUtil.hasFocusableAncestor(createNodeInfoFromView, view) || !AccessibilityUtil.hasText(createNodeInfoFromView)) {
                createNodeInfoFromView.e0();
                return true;
            } else {
                createNodeInfoFromView.e0();
                return false;
            }
        } finally {
            createNodeInfoFromView.e0();
        }
    }

    public static String getIgnoredReasons(View view) {
        int D = h0.D(view);
        if (D == 2) {
            return "View has importantForAccessibility set to 'NO'.";
        }
        if (D == 4) {
            return "View has importantForAccessibility set to 'NO_HIDE_DESCENDANTS'.";
        }
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            if (h0.D((View) parent) == 4) {
                return "An ancestor View has importantForAccessibility set to 'NO_HIDE_DESCENDANTS'.";
            }
        }
        AccessibilityNodeInfoCompat createNodeInfoFromView = createNodeInfoFromView(view);
        try {
            if (!createNodeInfoFromView.Z()) {
                return "View is not visible.";
            }
            if (AccessibilityUtil.isAccessibilityFocusable(createNodeInfoFromView, view)) {
                createNodeInfoFromView.e0();
                return "View is actionable, but has no description.";
            } else if (AccessibilityUtil.hasText(createNodeInfoFromView)) {
                createNodeInfoFromView.e0();
                return "View is not actionable, and an ancestor View has co-opted its description.";
            } else {
                createNodeInfoFromView.e0();
                return "View is not actionable and has no description.";
            }
        } finally {
            createNodeInfoFromView.e0();
        }
    }

    public static boolean getIsAccessibilityFocused(View view) {
        AccessibilityNodeInfoCompat createNodeInfoFromView = createNodeInfoFromView(view);
        boolean J = createNodeInfoFromView.J();
        createNodeInfoFromView.e0();
        return J;
    }
}
