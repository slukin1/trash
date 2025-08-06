package com.google.android.material.internal;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.Toolbar;

public class ToolbarUtils {
    private ToolbarUtils() {
    }

    public static ActionMenuItemView getActionMenuItemView(Toolbar toolbar, int i11) {
        ActionMenuView actionMenuView = getActionMenuView(toolbar);
        if (actionMenuView == null) {
            return null;
        }
        for (int i12 = 0; i12 < actionMenuView.getChildCount(); i12++) {
            View childAt = actionMenuView.getChildAt(i12);
            if (childAt instanceof ActionMenuItemView) {
                ActionMenuItemView actionMenuItemView = (ActionMenuItemView) childAt;
                if (actionMenuItemView.getItemData().getItemId() == i11) {
                    return actionMenuItemView;
                }
            }
        }
        return null;
    }

    public static ActionMenuView getActionMenuView(Toolbar toolbar) {
        for (int i11 = 0; i11 < toolbar.getChildCount(); i11++) {
            View childAt = toolbar.getChildAt(i11);
            if (childAt instanceof ActionMenuView) {
                return (ActionMenuView) childAt;
            }
        }
        return null;
    }

    public static ImageButton getNavigationIconButton(Toolbar toolbar) {
        Drawable navigationIcon = toolbar.getNavigationIcon();
        if (navigationIcon == null) {
            return null;
        }
        for (int i11 = 0; i11 < toolbar.getChildCount(); i11++) {
            View childAt = toolbar.getChildAt(i11);
            if (childAt instanceof ImageButton) {
                ImageButton imageButton = (ImageButton) childAt;
                if (imageButton.getDrawable() == navigationIcon) {
                    return imageButton;
                }
            }
        }
        return null;
    }

    public static View getSecondaryActionMenuItemView(Toolbar toolbar) {
        ActionMenuView actionMenuView = getActionMenuView(toolbar);
        if (actionMenuView == null || actionMenuView.getChildCount() <= 1) {
            return null;
        }
        return actionMenuView.getChildAt(0);
    }

    public static TextView getSubtitleTextView(Toolbar toolbar) {
        return getTextView(toolbar, toolbar.getSubtitle());
    }

    private static TextView getTextView(Toolbar toolbar, CharSequence charSequence) {
        for (int i11 = 0; i11 < toolbar.getChildCount(); i11++) {
            View childAt = toolbar.getChildAt(i11);
            if (childAt instanceof TextView) {
                TextView textView = (TextView) childAt;
                if (TextUtils.equals(textView.getText(), charSequence)) {
                    return textView;
                }
            }
        }
        return null;
    }

    public static TextView getTitleTextView(Toolbar toolbar) {
        return getTextView(toolbar, toolbar.getTitle());
    }
}
