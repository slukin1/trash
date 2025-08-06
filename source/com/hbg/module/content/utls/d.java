package com.hbg.module.content.utls;

import android.view.View;

public final /* synthetic */ class d implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f18905b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f18906c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e f18907d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f18908e;

    public /* synthetic */ d(View view, String str, e eVar, String str2) {
        this.f18905b = view;
        this.f18906c = str;
        this.f18907d = eVar;
        this.f18908e = str2;
    }

    public final void run() {
        e.f(this.f18905b, this.f18906c, this.f18907d, this.f18908e);
    }
}
