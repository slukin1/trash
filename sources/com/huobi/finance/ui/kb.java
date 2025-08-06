package com.huobi.finance.ui;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.IntegrationDetailSubmitResult;
import com.huobi.finance.ui.UnifyWithdrawActivity;

public final /* synthetic */ class kb implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyWithdrawActivity.d f47210b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ IntegrationDetailSubmitResult f47211c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f47212d;

    public /* synthetic */ kb(UnifyWithdrawActivity.d dVar, IntegrationDetailSubmitResult integrationDetailSubmitResult, String str) {
        this.f47210b = dVar;
        this.f47211c = integrationDetailSubmitResult;
        this.f47212d = str;
    }

    public final void onClick(View view) {
        this.f47210b.d(this.f47211c, this.f47212d, view);
    }
}
