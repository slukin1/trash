package com.hbg.lite.guide.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.hbg.lib.widgets.SafeLottieView;
import com.hbg.lite.R$id;
import com.hbg.lite.R$layout;
import com.hbg.lite.R$styleable;

public class VersionSwitchCardView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public SafeLottieView f77068b;

    /* renamed from: c  reason: collision with root package name */
    public View f77069c;

    public VersionSwitchCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        LayoutInflater.from(context).inflate(R$layout.lite_item_version_switch, this);
        this.f77069c = findViewById(R$id.root);
        TextView textView = (TextView) findViewById(R$id.tv_title);
        TextView textView2 = (TextView) findViewById(R$id.tv_desc);
        this.f77068b = (SafeLottieView) findViewById(R$id.iv_anim);
        TextView textView3 = (TextView) findViewById(R$id.tv_tag);
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.VersionSwitchCardView);
            String string = obtainStyledAttributes.getString(R$styleable.VersionSwitchCardView_tag);
            String string2 = obtainStyledAttributes.getString(R$styleable.VersionSwitchCardView_title);
            String string3 = obtainStyledAttributes.getString(R$styleable.VersionSwitchCardView_desc);
            int resourceId = obtainStyledAttributes.getResourceId(R$styleable.VersionSwitchCardView_rawRes, 0);
            textView3.setText(string);
            textView.setText(string2);
            textView2.setText(string3);
            this.f77068b.setAnimation(resourceId);
            obtainStyledAttributes.recycle();
        }
    }

    public VersionSwitchCardView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context, attributeSet);
    }
}
