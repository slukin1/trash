package com.huobi.account.ui;

import android.view.View;
import com.huobi.kyc.ui.VerificationTipsDialog;

public final /* synthetic */ class z0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SecurityLinkActivity f41865b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VerificationTipsDialog f41866c;

    public /* synthetic */ z0(SecurityLinkActivity securityLinkActivity, VerificationTipsDialog verificationTipsDialog) {
        this.f41865b = securityLinkActivity;
        this.f41866c = verificationTipsDialog;
    }

    public final void onClick(View view) {
        this.f41865b.Ph(this.f41866c, view);
    }
}
