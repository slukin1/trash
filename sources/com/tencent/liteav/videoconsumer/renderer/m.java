package com.tencent.liteav.videoconsumer.renderer;

import android.view.TextureView;

final /* synthetic */ class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final k f22459a;

    /* renamed from: b  reason: collision with root package name */
    private final TextureView f22460b;

    private m(k kVar, TextureView textureView) {
        this.f22459a = kVar;
        this.f22460b = textureView;
    }

    public static Runnable a(k kVar, TextureView textureView) {
        return new m(kVar, textureView);
    }

    public final void run() {
        this.f22459a.a(this.f22460b);
    }
}
