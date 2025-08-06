package com.huobi.account.ui;

import android.view.View;
import com.huobi.kyc.ui.VerificationTipsDialog;

public final /* synthetic */ class w0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SecurityLinkActivity f41839b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VerificationTipsDialog f41840c;

    public /* synthetic */ w0(SecurityLinkActivity securityLinkActivity, VerificationTipsDialog verificationTipsDialog) {
        this.f41839b = securityLinkActivity;
        this.f41840c = verificationTipsDialog;
    }

    public final void onClick(View view) {
        this.f41839b.Oh(this.f41840c, view);
    }
}
