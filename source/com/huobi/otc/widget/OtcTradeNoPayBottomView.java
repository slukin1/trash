package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;

public class OtcTradeNoPayBottomView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public View f80117b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f80118c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f80119d;

    public OtcTradeNoPayBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public void a(Context context) {
        View.inflate(context, R$layout.otc_trade_no_pay_bottom_layout, this);
        this.f80118c = (TextView) findViewById(R$id.tv_left);
        this.f80119d = (TextView) findViewById(R$id.tv_right);
        this.f80117b = findViewById(R$id.view_divide);
    }
}
