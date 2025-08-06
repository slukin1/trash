package com.hbg.module.content.adapter;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.SisterBean;

public final /* synthetic */ class s implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ t f17938b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SisterBean f17939c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f17940d;

    public /* synthetic */ s(t tVar, SisterBean sisterBean, int i11) {
        this.f17938b = tVar;
        this.f17939c = sisterBean;
        this.f17940d = i11;
    }

    public final void onClick(View view) {
        t.n(this.f17938b, this.f17939c, this.f17940d, view);
    }
}
