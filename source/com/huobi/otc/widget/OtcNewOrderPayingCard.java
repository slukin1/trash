package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.lib.common.utils.ViewUtil;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;

public class OtcNewOrderPayingCard extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f80001b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f80002c;

    /* renamed from: d  reason: collision with root package name */
    public TextView f80003d;

    /* renamed from: e  reason: collision with root package name */
    public TextView f80004e;

    /* renamed from: f  reason: collision with root package name */
    public LinearLayout f80005f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f80006g;

    /* renamed from: h  reason: collision with root package name */
    public TextView f80007h;

    /* renamed from: i  reason: collision with root package name */
    public a f80008i;

    public interface a {
    }

    public OtcNewOrderPayingCard(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context);
    }

    public final void a(Context context) {
        FrameLayout.inflate(context, R$layout.otc_new_order_paying_card_layout, this);
        this.f80001b = (TextView) findViewById(R$id.id_new_order_tips);
        this.f80002c = (TextView) findViewById(R$id.id_process_title_1);
        this.f80003d = (TextView) findViewById(R$id.id_process_title_2);
        this.f80004e = (TextView) findViewById(R$id.id_process_title_3);
        this.f80005f = (LinearLayout) findViewById(R$id.payment_info_container);
        this.f80006g = (LinearLayout) findViewById(R$id.otc_item_open_alipay);
        this.f80007h = (TextView) findViewById(R$id.alipay_tv);
    }

    public void setAlipayItemVisible(boolean z11) {
        ViewUtil.m(this.f80006g, z11);
    }

    public void setCardCallback(a aVar) {
        this.f80008i = aVar;
    }

    public OtcNewOrderPayingCard(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a(context);
    }
}
