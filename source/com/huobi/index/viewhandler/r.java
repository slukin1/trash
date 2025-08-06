package com.huobi.index.viewhandler;

import android.content.Context;
import android.view.View;
import com.huobi.index.bean.IndexDeep;

public final /* synthetic */ class r implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ IndexDeep f74481b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Context f74482c;

    public /* synthetic */ r(IndexDeep indexDeep, Context context) {
        this.f74481b = indexDeep;
        this.f74482c = context;
    }

    public final void onClick(View view) {
        NewDeepHandler.i(this.f74481b, this.f74482c, view);
    }
}
