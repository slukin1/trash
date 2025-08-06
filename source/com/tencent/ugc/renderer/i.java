package com.tencent.ugc.renderer;

import android.view.TextureView;

final /* synthetic */ class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TextureViewRenderHelper f50775a;

    /* renamed from: b  reason: collision with root package name */
    private final TextureView f50776b;

    private i(TextureViewRenderHelper textureViewRenderHelper, TextureView textureView) {
        this.f50775a = textureViewRenderHelper;
        this.f50776b = textureView;
    }

    public static Runnable a(TextureViewRenderHelper textureViewRenderHelper, TextureView textureView) {
        return new i(textureViewRenderHelper, textureView);
    }

    public final void run() {
        this.f50775a.setup(this.f50776b);
    }
}
