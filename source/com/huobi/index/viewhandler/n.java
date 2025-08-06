package com.huobi.index.viewhandler;

import android.view.View;
import com.huobi.index.bean.IndexFeatureItem;

public final /* synthetic */ class n implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexQuickHandler f74473b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ IndexFeatureItem f74474c;

    public /* synthetic */ n(IndexQuickHandler indexQuickHandler, IndexFeatureItem indexFeatureItem) {
        this.f74473b = indexQuickHandler;
        this.f74474c = indexFeatureItem;
    }

    public final void onClick(View view) {
        this.f74473b.f(this.f74474c, view);
    }
}
