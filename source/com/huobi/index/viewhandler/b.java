package com.huobi.index.viewhandler;

import android.content.Context;
import android.view.View;
import com.hbg.lib.network.hbg.core.bean.HomePageBizData;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ HomePageBizData f74432b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f74433c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f74434d;

    public /* synthetic */ b(HomePageBizData homePageBizData, Context context, int i11) {
        this.f74432b = homePageBizData;
        this.f74433c = context;
        this.f74434d = i11;
    }

    public final void onClick(View view) {
        IndexBizItemHandler.g(this.f74432b, this.f74433c, this.f74434d, view);
    }
}
