package com.sumsub.sns.presentation.screen.verification;

import android.content.DialogInterface;
import java.util.Map;

public final /* synthetic */ class e implements DialogInterface.OnDismissListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f40147b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Map f40148c;

    public /* synthetic */ e(a aVar, Map map) {
        this.f40147b = aVar;
        this.f40148c = map;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        a.a(this.f40147b, this.f40148c, dialogInterface);
    }
}
