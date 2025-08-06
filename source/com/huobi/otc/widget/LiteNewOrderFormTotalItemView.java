package com.huobi.otc.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.hbg.module.otc.R$id;
import com.hbg.module.otc.R$layout;
import dw.a;
import java.util.concurrent.TimeUnit;
import vp.s;

public final class LiteNewOrderFormTotalItemView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f79850b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f79851c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f79852d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f79853e;

    /* renamed from: f  reason: collision with root package name */
    public View f79854f;

    public LiteNewOrderFormTotalItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(context, R$layout.lite_order_item_form_total_view, this);
        b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(Void voidR) {
    }

    public final void b() {
        this.f79850b = (TextView) findViewById(R$id.title_tv);
        this.f79851c = (TextView) findViewById(R$id.value_tv);
        this.f79852d = (ImageView) findViewById(R$id.qrcode_iv);
        this.f79853e = (LinearLayout) findViewById(R$id.root_view);
        this.f79854f = findViewById(R$id.divide_view);
        a.a(this.f79852d).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new s(this));
    }

    public TextView getValueTv() {
        return this.f79851c;
    }

    public void setDivideViewVisible(boolean z11) {
        this.f79854f.setVisibility(z11 ? 0 : 8);
    }
}
