package com.sumsub.sns.internal.core.domain;

import android.graphics.Bitmap;
import android.graphics.RectF;
import d10.l;

public final /* synthetic */ class r implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f33678b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bitmap f33679c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ RectF f33680d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ l f33681e;

    public /* synthetic */ r(b bVar, Bitmap bitmap, RectF rectF, l lVar) {
        this.f33678b = bVar;
        this.f33679c = bitmap;
        this.f33680d = rectF;
        this.f33681e = lVar;
    }

    public final void run() {
        b.a(this.f33678b, this.f33679c, this.f33680d, this.f33681e);
    }
}
