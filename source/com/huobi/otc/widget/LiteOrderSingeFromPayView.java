package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;

public class LiteOrderSingeFromPayView extends RelativeLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f79898b = ((TextView) findViewById(R$id.title_tv));

    /* renamed from: c  reason: collision with root package name */
    public TextView f79899c = ((TextView) findViewById(R$id.content_tv));

    /* renamed from: d  reason: collision with root package name */
    public ImageView f79900d = ((ImageView) findViewById(R$id.content_icon_fist_iv));

    /* renamed from: e  reason: collision with root package name */
    public ImageView f79901e = ((ImageView) findViewById(R$id.content_icon_two_iv));

    /* renamed from: f  reason: collision with root package name */
    public ImageView f79902f = ((ImageView) findViewById(R$id.icon_iv));

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f79903g = ((LinearLayout) findViewById(R$id.id_payment_ll));

    /* renamed from: h  reason: collision with root package name */
    public View f79904h = findViewById(R$id.id_payment_color);

    /* renamed from: i  reason: collision with root package name */
    public TextView f79905i = ((TextView) findViewById(R$id.id_payment_name));

    public LiteOrderSingeFromPayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(context, R$layout.lite_order_singe_from_pay_view, this);
    }
}
