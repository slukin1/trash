package com.sumsub.sns.videoident.presentation;

import android.content.DialogInterface;

public final /* synthetic */ class k implements DialogInterface.OnDismissListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SNSVideoIdentFragment f40343b;

    public /* synthetic */ k(SNSVideoIdentFragment sNSVideoIdentFragment) {
        this.f40343b = sNSVideoIdentFragment;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        SNSVideoIdentFragment.m2302showRecordAudioPermissionDialog$lambda29(this.f40343b, dialogInterface);
    }
}
