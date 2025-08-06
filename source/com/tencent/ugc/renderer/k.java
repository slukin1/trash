package com.tencent.ugc.renderer;

final /* synthetic */ class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TextureViewRenderHelper f50779a;

    private k(TextureViewRenderHelper textureViewRenderHelper) {
        this.f50779a = textureViewRenderHelper;
    }

    public static Runnable a(TextureViewRenderHelper textureViewRenderHelper) {
        return new k(textureViewRenderHelper);
    }

    public final void run() {
        TextureViewRenderHelper.lambda$checkViewAvailability$3(this.f50779a);
    }
}
