package com.tencent.ugc;

import java.util.concurrent.Callable;

final /* synthetic */ class di implements Callable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCImageProvider f50363a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50364b;

    private di(UGCImageProvider uGCImageProvider, int i11) {
        this.f50363a = uGCImageProvider;
        this.f50364b = i11;
    }

    public static Callable a(UGCImageProvider uGCImageProvider, int i11) {
        return new di(uGCImageProvider, i11);
    }

    public final Object call() {
        return this.f50363a.setPictureTransitionInternal(this.f50364b);
    }
}
