package com.sumsub.sns.videoident.presentation;

import android.content.DialogInterface;
import java.util.Map;

public final /* synthetic */ class l implements DialogInterface.OnDismissListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SNSVideoIdentFragment f40344b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f40345c;

    public /* synthetic */ l(SNSVideoIdentFragment sNSVideoIdentFragment, Map map) {
        this.f40344b = sNSVideoIdentFragment;
        this.f40345c = map;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        SNSVideoIdentFragment.m2299showExitConfirmationState$lambda58$lambda57(this.f40344b, this.f40345c, dialogInterface);
    }
}
