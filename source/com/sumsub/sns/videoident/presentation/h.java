package com.sumsub.sns.videoident.presentation;

import android.content.DialogInterface;
import java.util.Map;

public final /* synthetic */ class h implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SNSVideoIdentFragment f40338b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f40339c;

    public /* synthetic */ h(SNSVideoIdentFragment sNSVideoIdentFragment, Map map) {
        this.f40338b = sNSVideoIdentFragment;
        this.f40339c = map;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        SNSVideoIdentFragment.m2297showExitConfirmationState$lambda58$lambda55(this.f40338b, this.f40339c, dialogInterface, i11);
    }
}
