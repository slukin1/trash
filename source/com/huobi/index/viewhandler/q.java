package com.huobi.index.viewhandler;

import android.view.View;
import com.huobi.index.bean.IndexDeep;

public final /* synthetic */ class q implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexDeep f74480b;

    public /* synthetic */ q(IndexDeep indexDeep) {
        this.f74480b = indexDeep;
    }

    public final void onClick(View view) {
        NewDeepHandler.h(this.f74480b, view);
    }
}
