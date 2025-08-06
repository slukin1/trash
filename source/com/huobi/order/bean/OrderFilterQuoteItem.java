package com.huobi.order.bean;

import android.view.View;
import com.huobi.order.handler.OrderFilterQuoteHandler;
import s9.a;

public class OrderFilterQuoteItem implements a {

    /* renamed from: b  reason: collision with root package name */
    public String f78110b;

    /* renamed from: c  reason: collision with root package name */
    public String f78111c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f78112d;

    /* renamed from: e  reason: collision with root package name */
    public View.OnClickListener f78113e;

    public View.OnClickListener a() {
        return this.f78113e;
    }

    public String c() {
        return this.f78111c;
    }

    public boolean d() {
        return this.f78112d;
    }

    public void e(View.OnClickListener onClickListener) {
        this.f78113e = onClickListener;
    }

    public void f(String str) {
        this.f78110b = str;
    }

    public void g(String str) {
        this.f78111c = str;
    }

    public String getViewHandlerName() {
        return OrderFilterQuoteHandler.class.getName();
    }

    public void h(boolean z11) {
        this.f78112d = z11;
    }
}
