package com.sumsub.sns.internal.core.domain;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.sumsub.sns.internal.core.domain.b;
import com.sumsub.sns.internal.core.domain.o;
import d10.l;

public final /* synthetic */ class t implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ b f33683b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Bitmap f33684c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ RectF f33685d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ l f33686e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ o f33687f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ o.a f33688g;

    public /* synthetic */ t(b bVar, Bitmap bitmap, RectF rectF, l lVar, o oVar, o.a aVar) {
        this.f33683b = bVar;
        this.f33684c = bitmap;
        this.f33685d = rectF;
        this.f33686e = lVar;
        this.f33687f = oVar;
        this.f33688g = aVar;
    }

    public final void run() {
        b.a.a(this.f33683b, this.f33684c, this.f33685d, this.f33686e, this.f33687f, this.f33688g);
    }
}
