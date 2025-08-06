package com.huobi.home.util;

import android.view.View;
import kotlinx.coroutines.channels.k;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ k f72579b;

    public /* synthetic */ c(k kVar) {
        this.f72579b = kVar;
    }

    public final void onClick(View view) {
        ViewExtKt$clickFlow$1.invokeSuspend$lambda$0(this.f72579b, view);
    }
}
