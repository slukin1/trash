package com.huobi.index.viewhandler;

import android.content.Context;
import com.hbg.lib.network.hbg.core.bean.DeepNews;
import rx.functions.Action1;

public final /* synthetic */ class d implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexDeepHandler f74438b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DeepNews f74439c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f74440d;

    public /* synthetic */ d(IndexDeepHandler indexDeepHandler, DeepNews deepNews, Context context) {
        this.f74438b = indexDeepHandler;
        this.f74439c = deepNews;
        this.f74440d = context;
    }

    public final void call(Object obj) {
        this.f74438b.f(this.f74439c, this.f74440d, (Void) obj);
    }
}
