package com.tencent.liteav.videoconsumer.renderer;

import android.view.TextureView;
import com.tencent.rtmp.ui.TXCloudVideoView;

final /* synthetic */ class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    private final k f22456a;

    /* renamed from: b  reason: collision with root package name */
    private final TXCloudVideoView f22457b;

    /* renamed from: c  reason: collision with root package name */
    private final TextureView f22458c;

    private l(k kVar, TXCloudVideoView tXCloudVideoView, TextureView textureView) {
        this.f22456a = kVar;
        this.f22457b = tXCloudVideoView;
        this.f22458c = textureView;
    }

    public static Runnable a(k kVar, TXCloudVideoView tXCloudVideoView, TextureView textureView) {
        return new l(kVar, tXCloudVideoView, textureView);
    }

    public final void run() {
        k.a(this.f22456a, this.f22457b, this.f22458c);
    }
}
