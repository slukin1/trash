package com.huobi.index.viewhandler;

import android.view.View;
import com.huobi.index.bean.IndexFeatureItem;
import v9.c;

public final /* synthetic */ class t implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f74484b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ IndexFeatureItem f74485c;

    public /* synthetic */ t(c cVar, IndexFeatureItem indexFeatureItem) {
        this.f74484b = cVar;
        this.f74485c = indexFeatureItem;
    }

    public final void onClick(View view) {
        NewVideoGuideHandler.d(this.f74484b, this.f74485c, view);
    }
}
