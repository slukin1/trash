package com.hbg.module.content.adapter;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.DeepNewsInfo;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ g f17849b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DeepNewsInfo f17850c;

    public /* synthetic */ f(g gVar, DeepNewsInfo deepNewsInfo) {
        this.f17849b = gVar;
        this.f17850c = deepNewsInfo;
    }

    public final void onClick(View view) {
        g.m(this.f17849b, this.f17850c, view);
    }
}
