package com.tencent.ugc.renderer;

final /* synthetic */ class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TextureViewRenderHelper f50777a;

    /* renamed from: b  reason: collision with root package name */
    private final boolean f50778b;

    private j(TextureViewRenderHelper textureViewRenderHelper, boolean z11) {
        this.f50777a = textureViewRenderHelper;
        this.f50778b = z11;
    }

    public static Runnable a(TextureViewRenderHelper textureViewRenderHelper, boolean z11) {
        return new j(textureViewRenderHelper, z11);
    }

    public final void run() {
        TextureViewRenderHelper.lambda$release$2(this.f50777a, this.f50778b);
    }
}
