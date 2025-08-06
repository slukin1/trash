package com.huobi.index.viewhandler;

import android.view.View;
import com.huobi.index.bean.IndexFeatureItem;
import v9.c;

public final /* synthetic */ class a implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f74429b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ IndexFeatureItem f74430c;

    public /* synthetic */ a(c cVar, IndexFeatureItem indexFeatureItem) {
        this.f74429b = cVar;
        this.f74430c = indexFeatureItem;
    }

    public final void onClick(View view) {
        IndexBearItemHandler.d(this.f74429b, this.f74430c, view);
    }
}
