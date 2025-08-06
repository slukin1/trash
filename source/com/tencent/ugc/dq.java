package com.tencent.ugc;

import java.util.List;

final /* synthetic */ class dq implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final UGCMediaListSource f50377a;

    /* renamed from: b  reason: collision with root package name */
    private final List f50378b;

    /* renamed from: c  reason: collision with root package name */
    private final int f50379c;

    private dq(UGCMediaListSource uGCMediaListSource, List list, int i11) {
        this.f50377a = uGCMediaListSource;
        this.f50378b = list;
        this.f50379c = i11;
    }

    public static Runnable a(UGCMediaListSource uGCMediaListSource, List list, int i11) {
        return new dq(uGCMediaListSource, list, i11);
    }

    public final void run() {
        UGCMediaListSource.lambda$setPictureList$6(this.f50377a, this.f50378b, this.f50379c);
    }
}
