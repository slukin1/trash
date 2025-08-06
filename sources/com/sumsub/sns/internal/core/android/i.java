package com.sumsub.sns.internal.core.android;

import android.app.Activity;
import android.content.DialogInterface;
import d10.a;

public final /* synthetic */ class i implements DialogInterface.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f31957b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f31958c;

    public /* synthetic */ i(a aVar, Activity activity) {
        this.f31957b = aVar;
        this.f31958c = activity;
    }

    public final void onClick(DialogInterface dialogInterface, int i11) {
        c.a(this.f31957b, this.f31958c, dialogInterface, i11);
    }
}
