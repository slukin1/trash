package com.huobi.finance.ui;

import android.view.View;
import com.hbg.lib.network.hbg.core.bean.IntegrationNoticeInfo;

public final /* synthetic */ class ka implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UnifyWithdrawActivity f47208b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ IntegrationNoticeInfo f47209c;

    public /* synthetic */ ka(UnifyWithdrawActivity unifyWithdrawActivity, IntegrationNoticeInfo integrationNoticeInfo) {
        this.f47208b = unifyWithdrawActivity;
        this.f47209c = integrationNoticeInfo;
    }

    public final void onClick(View view) {
        this.f47208b.fj(this.f47209c, view);
    }
}
