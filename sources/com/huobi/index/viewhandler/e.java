package com.huobi.index.viewhandler;

import android.content.Context;
import android.view.View;
import com.huobi.index.bean.IndexEarnItem;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexEarnItem f74441b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f74442c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f74443d;

    public /* synthetic */ e(IndexEarnItem indexEarnItem, Context context, int i11) {
        this.f74441b = indexEarnItem;
        this.f74442c = context;
        this.f74443d = i11;
    }

    public final void onClick(View view) {
        IndexEarnItemHandler.d(this.f74441b, this.f74442c, this.f74443d, view);
    }
}
