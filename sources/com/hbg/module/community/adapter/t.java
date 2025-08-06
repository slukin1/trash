package com.hbg.module.community.adapter;

import android.content.Context;
import android.view.View;
import com.hbg.lib.network.pro.socket.bean.SymbolPrice;

public final /* synthetic */ class t implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f17217b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SymbolPrice f17218c;

    public /* synthetic */ t(Context context, SymbolPrice symbolPrice) {
        this.f17217b = context;
        this.f17218c = symbolPrice;
    }

    public final void onClick(View view) {
        u.f(this.f17217b, this.f17218c, view);
    }
}
