package com.sumsub.sns.videoident.presentation;

import android.content.DialogInterface;
import java.util.Map;

public final /* synthetic */ class m implements DialogInterface.OnShowListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ SNSVideoIdentFragment f40346a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f40347b;

    public /* synthetic */ m(SNSVideoIdentFragment sNSVideoIdentFragment, Map map) {
        this.f40346a = sNSVideoIdentFragment;
        this.f40347b = map;
    }

    public final void onShow(DialogInterface dialogInterface) {
        SNSVideoIdentFragment.m2300showExitConfirmationState$lambda60$lambda59(this.f40346a, this.f40347b, dialogInterface);
    }
}
