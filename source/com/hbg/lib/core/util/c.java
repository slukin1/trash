package com.hbg.lib.core.util;

import android.app.Activity;

public final /* synthetic */ class c implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AppLanguageHelper f68694b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f68695c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Class f68696d;

    public /* synthetic */ c(AppLanguageHelper appLanguageHelper, Activity activity, Class cls) {
        this.f68694b = appLanguageHelper;
        this.f68695c = activity;
        this.f68696d = cls;
    }

    public final void run() {
        this.f68694b.lambda$openAppLanguageActivity$0(this.f68695c, this.f68696d);
    }
}
