package com.huobi.account.ui;

import android.view.View;
import com.huobi.kyc.ui.VerificationTipsDialog;

public final /* synthetic */ class x0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SecurityLinkActivity f41848b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ VerificationTipsDialog f41849c;

    public /* synthetic */ x0(SecurityLinkActivity securityLinkActivity, VerificationTipsDialog verificationTipsDialog) {
        this.f41848b = securityLinkActivity;
        this.f41849c = verificationTipsDialog;
    }

    public final void onClick(View view) {
        this.f41848b.Nh(this.f41849c, view);
    }
}
