package com.huobi.webview2.action;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import g6.b;
import tu.a;

public final /* synthetic */ class f0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f20821b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ DisplayImageOptions f20822c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ a f20823d;

    public /* synthetic */ f0(String str, DisplayImageOptions displayImageOptions, a aVar) {
        this.f20821b = str;
        this.f20822c = displayImageOptions;
        this.f20823d = aVar;
    }

    public final void run() {
        b.c().l(this.f20821b, this.f20822c, this.f20823d);
    }
}
