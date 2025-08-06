package androidx.camera.core.imagecapture;

import androidx.core.util.Consumer;

public final /* synthetic */ class n implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SingleBundlingNode f5541b;

    public /* synthetic */ n(SingleBundlingNode singleBundlingNode) {
        this.f5541b = singleBundlingNode;
    }

    public final void accept(Object obj) {
        this.f5541b.trackIncomingRequest((ProcessingRequest) obj);
    }
}
