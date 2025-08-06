package com.huobi.finance.ui;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.IntegrationDetailSubmitResult;
import com.huobi.finance.ui.UnifyWithdrawActivity;

public final /* synthetic */ class jb implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyWithdrawActivity.d f47191b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ IntegrationDetailSubmitResult f47192c;

    public /* synthetic */ jb(UnifyWithdrawActivity.d dVar, IntegrationDetailSubmitResult integrationDetailSubmitResult) {
        this.f47191b = dVar;
        this.f47192c = integrationDetailSubmitResult;
    }

    public final void onClick(View view) {
        this.f47191b.c(this.f47192c, view);
    }
}
