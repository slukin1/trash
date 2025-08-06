package com.sumsub.sns.presentation.screen.verification;

import android.content.DialogInterface;
import java.util.Map;

public final /* synthetic */ class f implements DialogInterface.OnShowListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f40149a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map f40150b;

    public /* synthetic */ f(a aVar, Map map) {
        this.f40149a = aVar;
        this.f40150b = map;
    }

    public final void onShow(DialogInterface dialogInterface) {
        a.b(this.f40149a, this.f40150b, dialogInterface);
    }
}
