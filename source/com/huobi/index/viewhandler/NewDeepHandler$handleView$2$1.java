package com.huobi.index.viewhandler;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.IHbgApi;
import com.hbg.lib.widgets.dialog.DialogUtils;
import com.hbg.module.content.utls.m;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import com.huobi.index.bean.IndexDeep;
import v7.b;

public final class NewDeepHandler$handleView$2$1 implements m {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ IndexDeep f74253a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f74254b;

    public NewDeepHandler$handleView$2$1(IndexDeep indexDeep, Context context) {
        this.f74253a = indexDeep;
        this.f74254b = context;
    }

    public void a() {
        m.a.c(this);
        DialogUtils.S((FragmentActivity) this.f74254b);
    }

    public void b() {
        m.a.e(this);
    }

    public void c(int i11) {
        m.a.b(this, i11);
    }

    public void d() {
        m.a.d(this);
    }

    public void e() {
        m.a.a(this);
        IHbgApi a11 = b.a();
        IndexDeep indexDeep = this.f74253a;
        RequestExtKt.d(a11.y0(String.valueOf(indexDeep != null ? Long.valueOf(indexDeep.getId()) : null)), new NewDeepHandler$handleView$2$1$onDelClick$1(this.f74253a), NewDeepHandler$handleView$2$1$onDelClick$2.INSTANCE, (MutableLiveData) null, 4, (Object) null);
    }
}
