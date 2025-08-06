package com.tencent.ugc.renderer;

final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TextureViewRenderHelper f50780a;

    private l(TextureViewRenderHelper textureViewRenderHelper) {
        this.f50780a = textureViewRenderHelper;
    }

    public static Runnable a(TextureViewRenderHelper textureViewRenderHelper) {
        return new l(textureViewRenderHelper);
    }

    public final void run() {
        this.f50780a.updateTextureViewRenderMatrix(this.f50780a.mTextureView);
    }
}
