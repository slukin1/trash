package com.tencent.ugc.renderer;

import android.view.TextureView;
import com.tencent.rtmp.ui.TXCloudVideoView;

final /* synthetic */ class h implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final TextureViewRenderHelper f50772a;

    /* renamed from: b  reason: collision with root package name */
    private final TXCloudVideoView f50773b;

    /* renamed from: c  reason: collision with root package name */
    private final TextureView f50774c;

    private h(TextureViewRenderHelper textureViewRenderHelper, TXCloudVideoView tXCloudVideoView, TextureView textureView) {
        this.f50772a = textureViewRenderHelper;
        this.f50773b = tXCloudVideoView;
        this.f50774c = textureView;
    }

    public static Runnable a(TextureViewRenderHelper textureViewRenderHelper, TXCloudVideoView tXCloudVideoView, TextureView textureView) {
        return new h(textureViewRenderHelper, tXCloudVideoView, textureView);
    }

    public final void run() {
        TextureViewRenderHelper.lambda$new$0(this.f50772a, this.f50773b, this.f50774c);
    }
}
