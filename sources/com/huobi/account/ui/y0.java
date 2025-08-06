package com.huobi.account.ui;

import android.view.View;
import com.huobi.kyc.ui.VerificationTipsDialog;

public final /* synthetic */ class y0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SecurityLinkActivity f41857b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VerificationTipsDialog f41858c;

    public /* synthetic */ y0(SecurityLinkActivity securityLinkActivity, VerificationTipsDialog verificationTipsDialog) {
        this.f41857b = securityLinkActivity;
        this.f41858c = verificationTipsDialog;
    }

    public final void onClick(View view) {
        this.f41857b.Qh(this.f41858c, view);
    }
}
