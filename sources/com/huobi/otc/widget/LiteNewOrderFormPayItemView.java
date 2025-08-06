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
import vp.r;

public final class LiteNewOrderFormPayItemView extends LinearLayout {

    /* renamed from: b  reason: collision with root package name */
    public TextView f79846b;

    /* renamed from: c  reason: collision with root package name */
    public TextView f79847c;

    /* renamed from: d  reason: collision with root package name */
    public ImageView f79848d;

    /* renamed from: e  reason: collision with root package name */
    public LinearLayout f79849e;

    public LiteNewOrderFormPayItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        View.inflate(context, R$layout.lite_order_item_form_pay_view, this);
        b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(Void voidR) {
    }

    public final void b() {
        this.f79846b = (TextView) findViewById(R$id.title_tv);
        this.f79847c = (TextView) findViewById(R$id.value_tv);
        this.f79848d = (ImageView) findViewById(R$id.qrcode_iv);
        this.f79849e = (LinearLayout) findViewById(R$id.root_view);
        a.a(this.f79848d).throttleFirst(300, TimeUnit.MILLISECONDS).subscribe(new r(this));
    }

    public View getRootView() {
        return this.f79849e;
    }

    public TextView getValueTv() {
        return this.f79847c;
    }
}
