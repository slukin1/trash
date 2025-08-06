package com.nostra13.universalimageloader.core;

import android.graphics.Bitmap;
import com.nostra13.universalimageloader.core.assist.LoadedFrom;
import vx.c;

public final class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final Bitmap f28355b;

    /* renamed from: c  reason: collision with root package name */
    public final String f28356c;

    /* renamed from: d  reason: collision with root package name */
    public final sx.a f28357d;

    /* renamed from: e  reason: collision with root package name */
    public final String f28358e;

    /* renamed from: f  reason: collision with root package name */
    public final qx.a f28359f;

    /* renamed from: g  reason: collision with root package name */
    public final tx.a f28360g;

    /* renamed from: h  reason: collision with root package name */
    public final d f28361h;

    /* renamed from: i  reason: collision with root package name */
    public final LoadedFrom f28362i;

    public a(Bitmap bitmap, e eVar, d dVar, LoadedFrom loadedFrom) {
        this.f28355b = bitmap;
        this.f28356c = eVar.f28454a;
        this.f28357d = eVar.f28456c;
        this.f28358e = eVar.f28455b;
        this.f28359f = eVar.f28458e.w();
        this.f28360g = eVar.f28459f;
        this.f28361h = dVar;
        this.f28362i = loadedFrom;
    }

    public final boolean a() {
        return !this.f28358e.equals(this.f28361h.g(this.f28357d));
    }

    public void run() {
        if (this.f28357d.e()) {
            c.a("ImageAware was collected by GC. Task is cancelled. [%s]", this.f28358e);
            this.f28360g.d(this.f28356c, this.f28357d.c());
        } else if (a()) {
            c.a("ImageAware is reused for another image. Task is cancelled. [%s]", this.f28358e);
            this.f28360g.d(this.f28356c, this.f28357d.c());
        } else {
            c.a("Display image in ImageAware (loaded from %1$s) [%2$s]", this.f28362i, this.f28358e);
            this.f28359f.a(this.f28355b, this.f28357d, this.f28362i);
            this.f28361h.d(this.f28357d);
            this.f28360g.c(this.f28356c, this.f28357d.c(), this.f28355b);
        }
    }
}
