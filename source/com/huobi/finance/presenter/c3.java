package com.huobi.finance.presenter;

import android.view.View;
import com.hbg.lib.data.future.bean.FutureContractInfo;

public final /* synthetic */ class c3 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ l3 f45832b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ FutureContractInfo f45833c;

    public /* synthetic */ c3(l3 l3Var, FutureContractInfo futureContractInfo) {
        this.f45832b = l3Var;
        this.f45833c = futureContractInfo;
    }

    public final void onClick(View view) {
        this.f45832b.N(this.f45833c, view);
    }
}
