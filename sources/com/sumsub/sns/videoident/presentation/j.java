package com.sumsub.sns.videoident.presentation;

import android.content.DialogInterface;

public final /* synthetic */ class j implements DialogInterface.OnDismissListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SNSVideoIdentFragment f40342b;

    public /* synthetic */ j(SNSVideoIdentFragment sNSVideoIdentFragment) {
        this.f40342b = sNSVideoIdentFragment;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        SNSVideoIdentFragment.m2295showCameraPermissionDialog$lambda31(this.f40342b, dialogInterface);
    }
}
