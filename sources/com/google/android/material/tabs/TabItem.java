package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.d0;
import com.google.android.material.R;

public class TabItem extends View {
    public final int customLayout;
    public final Drawable icon;
    public final CharSequence text;

    public TabItem(Context context) {
        this(context, (AttributeSet) null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        d0 u11 = d0.u(context, attributeSet, R.styleable.TabItem);
        this.text = u11.p(R.styleable.TabItem_android_text);
        this.icon = u11.g(R.styleable.TabItem_android_icon);
        this.customLayout = u11.n(R.styleable.TabItem_android_layout, 0);
        u11.w();
    }
}
