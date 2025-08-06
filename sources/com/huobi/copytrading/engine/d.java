package com.huobi.copytrading.engine;

import android.app.Activity;
import android.content.Context;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Activity f43599b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f43600c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ Context f43601d;

    public /* synthetic */ d(Activity activity, String str, Context context) {
        this.f43599b = activity;
        this.f43600c = str;
        this.f43601d = context;
    }

    public final void run() {
        CopytradingNativeAbility.l(this.f43599b, this.f43600c, this.f43601d);
    }
}
