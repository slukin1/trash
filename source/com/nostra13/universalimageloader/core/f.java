package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import android.os.Handler;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import vx.c;

public final class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final d f28462b;

    /* renamed from: c  reason: collision with root package name */
    public final Bitmap f28463c;

    /* renamed from: d  reason: collision with root package name */
    public final e f28464d;

    /* renamed from: e  reason: collision with root package name */
    public final Handler f28465e;

    public f(d dVar, Bitmap bitmap, e eVar, Handler handler) {
        this.f28462b = dVar;
        this.f28463c = bitmap;
        this.f28464d = eVar;
        this.f28465e = handler;
    }

    public void run() {
        c.a("PostProcess image before displaying [%s]", this.f28464d.f28455b);
        LoadAndDisplayImageTask.t(new a(this.f28464d.f28458e.D().a(this.f28463c), this.f28464d, this.f28462b, LoadedFrom.MEMORY_CACHE), this.f28464d.f28458e.J(), this.f28465e, this.f28462b);
    }
}
