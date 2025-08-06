package com.sumsub.sns.internal.core.domain;

import android.graphics.Bitmap;
import com.google.android.gms.tasks.OnFailureListener;
import d10.l;

public final /* synthetic */ class u implements OnFailureListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ l f33689a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Bitmap f33690b;

    public /* synthetic */ u(l lVar, Bitmap bitmap) {
        this.f33689a = lVar;
        this.f33690b = bitmap;
    }

    public final void onFailure(Exception exc) {
        l.a(this.f33689a, this.f33690b, exc);
    }
}
