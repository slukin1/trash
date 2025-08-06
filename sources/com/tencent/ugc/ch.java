package com.tencent.ugc;

import com.tencent.ugc.TXVideoInfoReader;

final /* synthetic */ class ch implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TXVideoInfoReader.a f50282a;

    /* renamed from: b  reason: collision with root package name */
    private final String f50283b;

    public ch(TXVideoInfoReader.a aVar, String str) {
        this.f50282a = aVar;
        this.f50283b = str;
    }

    public final void run() {
        TXVideoInfoReader.a.a(this.f50282a, this.f50283b);
    }
}
