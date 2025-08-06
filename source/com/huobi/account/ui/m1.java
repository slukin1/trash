package com.huobi.account.ui;

import android.view.View;

public final /* synthetic */ class m1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SecurityPasskeyEditActivity f41749b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f41750c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ String f41751d;

    public /* synthetic */ m1(SecurityPasskeyEditActivity securityPasskeyEditActivity, String str, String str2) {
        this.f41749b = securityPasskeyEditActivity;
        this.f41750c = str;
        this.f41751d = str2;
    }

    public final void onClick(View view) {
        this.f41749b.rh(this.f41750c, this.f41751d, view);
    }
}
