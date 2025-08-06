package androidx.camera.video;

import androidx.camera.core.impl.SessionConfig;
import androidx.camera.video.VideoCapture;

public final /* synthetic */ class k1 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ VideoCapture.b f6306b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ SessionConfig.Builder f6307c;

    public /* synthetic */ k1(VideoCapture.b bVar, SessionConfig.Builder builder) {
        this.f6306b = bVar;
        this.f6307c = builder;
    }

    public final void run() {
        this.f6306b.b(this.f6307c);
    }
}
