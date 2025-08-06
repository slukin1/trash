package com.huochat.community.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.huochat.community.R;
import com.huochat.community.util.DisplayTool;

public class TopicDetailBehavior extends AppBarLayout.ScrollingViewBehavior {
    private int childHeight = 0;
    private int dependBottom = 0;
    private int marginTop = DisplayTool.dp2px(10.0f);
    private int originalToolHeight = 0;

    public TopicDetailBehavior() {
    }

    public boolean onDependentViewChanged(CoordinatorLayout coordinatorLayout, View view, View view2) {
        super.onDependentViewChanged(coordinatorLayout, view, view2);
        if (view2.getY() == 0.0f) {
            view.setTranslationY((float) (-this.marginTop));
            this.originalToolHeight = view2.findViewById(R.id.tlPageToolbar).getHeight();
            this.dependBottom = view2.getBottom();
        } else {
            float bottom = (((float) this.originalToolHeight) * 1.0f) / ((float) view2.getBottom());
            int i11 = this.marginTop;
            view.setTranslationY(((float) (-i11)) + (((float) i11) * bottom));
        }
        if (view2.getBottom() >= this.originalToolHeight + this.marginTop) {
            return false;
        }
        view.setY((float) view2.getBottom());
        return false;
    }

    public TopicDetailBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }
}
