package com.hbg.module.kline.index;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hbg.module.kline.R$id;
import com.hbg.module.kline.R$layout;
import com.hbg.module.kline.R$styleable;

public class IndexSettingContentGroup extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f23579b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f23580c;

    /* renamed from: d  reason: collision with root package name */
    public String f23581d;

    /* renamed from: e  reason: collision with root package name */
    public String f23582e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f23583f;

    public IndexSettingContentGroup(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        LayoutInflater.from(context).inflate(R$layout.index_setting_content_group, this, true);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.IndexSettingContentGroup);
        this.f23582e = obtainStyledAttributes.getString(R$styleable.IndexSettingContentGroup_contentText);
        this.f23581d = obtainStyledAttributes.getString(R$styleable.IndexSettingContentGroup_howToUseText);
        obtainStyledAttributes.recycle();
    }

    public void onFinishInflate() {
        super.onFinishInflate();
        this.f23579b = (TextView) findViewById(R$id.indroduce_content);
        this.f23580c = (TextView) findViewById(R$id.how_to_use_content);
        this.f23583f = (LinearLayout) findViewById(R$id.reset_linear);
        if (!TextUtils.isEmpty(this.f23581d)) {
            this.f23580c.setText(this.f23581d);
        }
        if (!TextUtils.isEmpty(this.f23582e)) {
            this.f23579b.setText(this.f23582e);
        }
    }

    public void setRestClickListener(View.OnClickListener onClickListener) {
        this.f23583f.setOnClickListener(onClickListener);
    }
}
