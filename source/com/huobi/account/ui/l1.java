package com.huobi.account.ui;

import android.view.View;

public final /* synthetic */ class l1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SecurityPasskeyEditActivity f41740b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f41741c;

    public /* synthetic */ l1(SecurityPasskeyEditActivity securityPasskeyEditActivity, String str) {
        this.f41740b = securityPasskeyEditActivity;
        this.f41741c = str;
    }

    public final void onClick(View view) {
        this.f41740b.qh(this.f41741c, view);
    }
}
