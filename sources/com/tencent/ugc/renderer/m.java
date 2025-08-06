package com.tencent.ugc.renderer;

import com.tencent.ugc.renderer.TextureViewRenderHelper;

final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TextureViewRenderHelper.AnonymousClass1 f50781a;

    private m(TextureViewRenderHelper.AnonymousClass1 r12) {
        this.f50781a = r12;
    }

    public static Runnable a(TextureViewRenderHelper.AnonymousClass1 r12) {
        return new m(r12);
    }

    public final void run() {
        TextureViewRenderHelper.this.notifyFirstFrameRendered();
    }
}
