package com.huobi.otc.widget;

import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import java.math.BigDecimal;

public class OtcReceiveOrderFlagView extends FrameLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f80044b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f80045c;

    /* renamed from: d  reason: collision with root package name */
    public Activity f80046d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f80047e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f80048f;

    /* renamed from: g  reason: collision with root package name */
    public BigDecimal f80049g;

    public OtcReceiveOrderFlagView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        b(context);
    }

    public final void a() {
    }

    public final void b(Context context) {
        FrameLayout.inflate(context, R$layout.view_receive_order_layout, this);
        this.f80044b = (TextView) findViewById(R$id.id_receive_order_flag_content_enable_tv);
        this.f80045c = (TextView) findViewById(R$id.id_receive_order_flag_content_unable_tv);
        a();
    }

    public void setAcceptOrder(boolean z11) {
        this.f80048f = z11;
    }

    public void setActivity(Activity activity) {
        this.f80046d = activity;
    }

    public void setFast(boolean z11) {
        this.f80047e = z11;
    }

    public void setMinReceiveAmount(BigDecimal bigDecimal) {
        this.f80049g = bigDecimal;
    }

    public OtcReceiveOrderFlagView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        b(context);
    }
}
