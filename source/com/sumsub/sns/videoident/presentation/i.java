package com.sumsub.sns.videoident.presentation;

import android.content.DialogInterface;
import java.util.Map;

public final /* synthetic */ class i implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SNSVideoIdentFragment f40340b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f40341c;

    public /* synthetic */ i(SNSVideoIdentFragment sNSVideoIdentFragment, Map map) {
        this.f40340b = sNSVideoIdentFragment;
        this.f40341c = map;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        SNSVideoIdentFragment.m2296showExitConfirmationState$lambda58$lambda54(this.f40340b, this.f40341c, dialogInterface, i11);
    }
}
