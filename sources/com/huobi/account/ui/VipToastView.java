package com.huobi.account.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import os.c;
import pro.huobi.R;

public class VipToastView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public View f41632b;

    /* renamed from: c  reason: collision with root package name */
    public ImageView f41633c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f41634d;

    public VipToastView(Context context) {
        this(context, (AttributeSet) null);
    }

    public boolean a() {
        int h11 = c.h();
        if (h11 == 1) {
            this.f41632b.setBackgroundResource(R.drawable.toast_elite_bg);
            this.f41633c.setImageResource(R.drawable.toast_elite_icon);
            this.f41634d.setText(getResources().getString(R.string.account_vip_login_tips_elite));
            this.f41634d.setTextColor(getResources().getColor(R.color.color_account_vip_toast_elite));
            return true;
        } else if (h11 == 2) {
            this.f41632b.setBackgroundResource(R.drawable.toast_silver_bg);
            this.f41633c.setImageResource(R.drawable.toast_silver_icon);
            this.f41634d.setText(getResources().getString(R.string.account_vip_login_tips_silver));
            this.f41634d.setTextColor(getResources().getColor(R.color.color_account_vip_toast_silver));
            return true;
        } else if (h11 == 3) {
            this.f41632b.setBackgroundResource(R.drawable.toast_gold_bg);
            this.f41633c.setImageResource(R.drawable.toast_gold_icon);
            this.f41634d.setText(getResources().getString(R.string.account_vip_login_tips_gold));
            this.f41634d.setTextColor(getResources().getColor(R.color.color_account_vip_toast_gold));
            return true;
        } else if (h11 == 4) {
            this.f41632b.setBackgroundResource(R.drawable.toast_platinum_bg);
            this.f41633c.setImageResource(R.drawable.toast_platinum_icon);
            this.f41634d.setText(getResources().getString(R.string.account_vip_login_tips_platinum));
            this.f41634d.setTextColor(getResources().getColor(R.color.color_account_vip_toast_platinum));
            return true;
        } else if (h11 != 5) {
            return false;
        } else {
            this.f41632b.setBackgroundResource(R.drawable.toast_black_bg);
            this.f41633c.setImageResource(R.drawable.toast_black_icon);
            this.f41634d.setText(getResources().getString(R.string.account_vip_login_tips_black));
            this.f41634d.setTextColor(getResources().getColor(R.color.color_account_vip_toast_black));
            return true;
        }
    }

    public VipToastView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public VipToastView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        FrameLayout.inflate(context, R.layout.layout_vip_toast, this);
        this.f41632b = findViewById(R.id.id_vip_toast_bg);
        this.f41633c = (ImageView) findViewById(R.id.id_vip_toast_logo);
        this.f41634d = (TextView) findViewById(R.id.id_vip_toast_tv);
    }
}
