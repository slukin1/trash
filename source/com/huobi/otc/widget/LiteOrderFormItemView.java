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
import vp.v;

public final class LiteOrderFormItemView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f79867b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f79868c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f79869d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f79870e;

    public LiteOrderFormItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(context, R$layout.lite_order_item_form_view, this);
        b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(Void voidR) {
    }

    public final void b() {
        this.f79867b = (TextView) findViewById(R$id.title_tv);
        this.f79868c = (TextView) findViewById(R$id.value_tv);
        this.f79869d = (ImageView) findViewById(R$id.qrcode_iv);
        this.f79870e = (LinearLayout) findViewById(R$id.root_view);
        a.a(this.f79869d).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new v(this));
    }

    public TextView getValueTv() {
        return this.f79868c;
    }
}
