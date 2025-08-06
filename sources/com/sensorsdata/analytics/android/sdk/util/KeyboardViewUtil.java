package com.sensorsdata.analytics.android.sdk.util;

import android.view.View;
import android.view.ViewGroup;
import com.sensorsdata.analytics.android.sdk.R;
import java.util.regex.Pattern;

public class KeyboardViewUtil {
    private static final String MATCH_RULE_KEYBOARD = "^([A-Za-z]|[0-9])";
    private static final String TAG_KEYBOARD = "keyboard_tag";
    private static boolean isSensorsCheckKeyboard = true;

    private static boolean getKeyboardSimilarFatherView(View view) {
        boolean z11;
        if (!(view.getParent() instanceof ViewGroup)) {
            return false;
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup.getTag(R.id.sensors_analytics_tag_view_keyboard) != null) {
            return true;
        }
        int childCount = viewGroup.getChildCount();
        if (childCount <= 1) {
            return false;
        }
        int indexOfChild = viewGroup.indexOfChild(view);
        for (int i11 = 0; i11 < childCount; i11++) {
            if (indexOfChild != i11) {
                View childAt = viewGroup.getChildAt(i11);
                int i12 = R.id.sensors_analytics_tag_view_keyboard;
                if (childAt.getTag(i12) == null) {
                    if (childAt instanceof ViewGroup) {
                        ViewGroup viewGroup2 = (ViewGroup) childAt;
                        int childCount2 = viewGroup2.getChildCount();
                        int i13 = 0;
                        while (true) {
                            if (i13 >= childCount2) {
                                z11 = false;
                                break;
                            } else if (Pattern.matches(MATCH_RULE_KEYBOARD, ViewUtil.getViewContentAndType(viewGroup2.getChildAt(i13)).getViewContent())) {
                                z11 = true;
                                break;
                            } else {
                                i13++;
                            }
                        }
                        if (z11) {
                            int i14 = R.id.sensors_analytics_tag_view_keyboard;
                            viewGroup2.setTag(i14, TAG_KEYBOARD);
                            viewGroup.setTag(i14, TAG_KEYBOARD);
                        }
                    } else if (Pattern.matches(MATCH_RULE_KEYBOARD, ViewUtil.getViewContentAndType(childAt).getViewContent())) {
                        childAt.setTag(i12, TAG_KEYBOARD);
                        viewGroup.setTag(i12, TAG_KEYBOARD);
                    }
                }
                return true;
            }
        }
        return false;
    }

    private static boolean getKeyboardSimilarView(View view) {
        if (!(view.getParent() instanceof ViewGroup)) {
            return getKeyboardSimilarFatherView((View) view.getParent());
        }
        ViewGroup viewGroup = (ViewGroup) view.getParent();
        if (viewGroup.getTag(R.id.sensors_analytics_tag_view_keyboard) != null) {
            return true;
        }
        int indexOfChild = viewGroup.indexOfChild(view);
        int childCount = viewGroup.getChildCount();
        if (childCount <= 1) {
            return getKeyboardSimilarFatherView(viewGroup);
        }
        boolean z11 = false;
        int i11 = 0;
        while (true) {
            if (i11 < childCount) {
                if (indexOfChild != i11 && Pattern.matches(MATCH_RULE_KEYBOARD, ViewUtil.getViewContentAndType(viewGroup.getChildAt(i11)).getViewContent())) {
                    z11 = true;
                    break;
                }
                i11++;
            } else {
                break;
            }
        }
        if (!z11) {
            return getKeyboardSimilarFatherView(viewGroup);
        }
        viewGroup.setTag(R.id.sensors_analytics_tag_view_keyboard, TAG_KEYBOARD);
        return true;
    }

    public static boolean isKeyboardView(View view) {
        if (!isSensorsCheckKeyboard || view == null || !Pattern.matches(MATCH_RULE_KEYBOARD, ViewUtil.getViewContentAndType(view).getViewContent())) {
            return false;
        }
        return getKeyboardSimilarView(view);
    }
}
