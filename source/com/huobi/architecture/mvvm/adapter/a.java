package com.huobi.architecture.mvvm.adapter;

import android.view.View;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseBindAdapter f42229b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ c f42230c;

    public /* synthetic */ a(BaseBindAdapter baseBindAdapter, c cVar) {
        this.f42229b = baseBindAdapter;
        this.f42230c = cVar;
    }

    public final void onClick(View view) {
        BaseBindAdapter.g(this.f42229b, this.f42230c, view);
    }
}
