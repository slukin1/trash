package com.hbg.lib.core.util;

import android.app.Activity;

public final /* synthetic */ class q implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ NightHelper f68745b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f68746c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Class f68747d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f68748e;

    public /* synthetic */ q(NightHelper nightHelper, Activity activity, Class cls, String str) {
        this.f68745b = nightHelper;
        this.f68746c = activity;
        this.f68747d = cls;
        this.f68748e = str;
    }

    public final void run() {
        this.f68745b.h(this.f68746c, this.f68747d, this.f68748e);
    }
}
