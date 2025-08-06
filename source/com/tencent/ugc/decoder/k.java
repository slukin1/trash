package com.tencent.ugc.decoder;

import com.tencent.liteav.base.util.w;

final /* synthetic */ class k implements w.a {

    /* renamed from: a  reason: collision with root package name */
    private final UGCVideoDecodeController f50346a;

    public k(UGCVideoDecodeController uGCVideoDecodeController) {
        this.f50346a = uGCVideoDecodeController;
    }

    public final void onTimeout() {
        this.f50346a.decodeInternal();
    }
}
