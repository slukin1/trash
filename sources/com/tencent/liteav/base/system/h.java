package com.tencent.liteav.base.system;

import com.tencent.liteav.base.util.i;

final /* synthetic */ class h implements i.a {

    /* renamed from: a  reason: collision with root package name */
    private static final h f21507a = new h();

    private h() {
    }

    public static i.a a() {
        return f21507a;
    }

    public final void a(boolean z11) {
        LiteavSystemInfo.onAppBackgroundStateChanged(z11);
    }
}
