package com.huobi.account.ui;

import android.view.View;
import com.huobi.kyc.ui.VerificationTipsDialog;

public final /* synthetic */ class b0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ KycAuthInfoActivity f41644b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VerificationTipsDialog f41645c;

    public /* synthetic */ b0(KycAuthInfoActivity kycAuthInfoActivity, VerificationTipsDialog verificationTipsDialog) {
        this.f41644b = kycAuthInfoActivity;
        this.f41645c = verificationTipsDialog;
    }

    public final void onClick(View view) {
        this.f41644b.Li(this.f41645c, view);
    }
}
