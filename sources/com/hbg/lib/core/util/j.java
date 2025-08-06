package com.hbg.lib.core.util;

import android.app.Activity;
import android.widget.ImageView;

public final /* synthetic */ class j implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ n f68712b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Activity f68713c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ ImageView f68714d;

    public /* synthetic */ j(n nVar, Activity activity, ImageView imageView) {
        this.f68712b = nVar;
        this.f68713c = activity;
        this.f68714d = imageView;
    }

    public final void run() {
        this.f68712b.q(this.f68713c, this.f68714d);
    }
}
