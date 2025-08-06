package com.tencent.ugc;

import com.tencent.ugc.TXVideoJoiner;

final /* synthetic */ class da implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoJoiner.AnonymousClass3 f50318a;

    /* renamed from: b  reason: collision with root package name */
    private final int f50319b;

    /* renamed from: c  reason: collision with root package name */
    private final String f50320c;

    private da(TXVideoJoiner.AnonymousClass3 r12, int i11, String str) {
        this.f50318a = r12;
        this.f50319b = i11;
        this.f50320c = str;
    }

    public static Runnable a(TXVideoJoiner.AnonymousClass3 r12, int i11, String str) {
        return new da(r12, i11, str);
    }

    public final void run() {
        TXVideoJoiner.AnonymousClass3.a(this.f50318a, this.f50319b, this.f50320c);
    }
}
