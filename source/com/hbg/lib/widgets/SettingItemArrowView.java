package com.hbg.lib.widgets;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;

public class SettingItemArrowView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f71609b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f71610c;

    public SettingItemArrowView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void setDesc(String str) {
        if (str == null) {
            str = "";
        }
        TextView textView = this.f71610c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void setTitle(String str) {
        if (str == null) {
            str = "";
        }
        TextView textView = this.f71609b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public SettingItemArrowView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.SettingItemArrowView, i11, 0);
        String string = obtainStyledAttributes.getString(R$styleable.SettingItemArrowView_setting_item_arrow_title);
        String string2 = obtainStyledAttributes.getString(R$styleable.SettingItemArrowView_setting_item_arrow_desc);
        obtainStyledAttributes.recycle();
        FrameLayout.inflate(context, R$layout.layout_setting_item_arrow, this);
        this.f71609b = (TextView) findViewById(R$id.id_setting_list_item_title);
        this.f71610c = (TextView) findViewById(R$id.id_setting_list_item_desc);
        setTitle(string);
        setDesc(string2);
    }
}
