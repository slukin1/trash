package com.lauzy.freedom.lbehaviorlib.behavior;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import cx.b;

public class FabScaleBehavior extends CommonBehavior {
    public FabScaleBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public b a(CoordinatorLayout coordinatorLayout, View view) {
        return new dx.b(view);
    }
}
