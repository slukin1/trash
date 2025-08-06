package com.zopim.android.sdk.chatlog.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.snackbar.Snackbar;

public class PushViewBehavior extends CoordinatorLayout.Behavior<View> {
    public PushViewBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public boolean layoutDependsOn(CoordinatorLayout coordinatorLayout, View view, View view2) {
        return view2 instanceof Snackbar.SnackbarLayout;
    }

    @TargetApi(11)
    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        if (Build.VERSION.SDK_INT < 11) {
            return false;
        }
        view.setTranslationY(Math.min(0.0f, view2.getTranslationY() - ((float) view2.getHeight())));
        return true;
    }
}
