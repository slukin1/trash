package com.sumsub.sns.videoident.presentation;

import android.content.DialogInterface;

public final /* synthetic */ class b implements DialogInterface.OnCancelListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SNSVideoIdentFragment f40332b;

    public /* synthetic */ b(SNSVideoIdentFragment sNSVideoIdentFragment) {
        this.f40332b = sNSVideoIdentFragment;
    }

    public final void onCancel(DialogInterface dialogInterface) {
        SNSVideoIdentFragment.m2298showExitConfirmationState$lambda58$lambda56(this.f40332b, dialogInterface);
    }
}
