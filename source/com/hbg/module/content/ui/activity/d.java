package com.hbg.module.content.ui.activity;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.widget.PopupWindow;

public class d extends PopupWindow {
    public d(Context context, View view, int i11, boolean z11) {
        super(context);
        a(view, i11, z11);
    }

    public final void a(View view, int i11, boolean z11) {
        setContentView(view);
        setWidth(-2);
        setHeight(-2);
        setBackgroundDrawable(new ColorDrawable());
        setFocusable(true);
        if (z11) {
            setAnimationStyle(i11);
        }
    }
}
