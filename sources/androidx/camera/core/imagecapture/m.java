package androidx.camera.core.imagecapture;

import androidx.camera.core.ImageProxy;
import androidx.core.util.Consumer;

public final /* synthetic */ class m implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SingleBundlingNode f5540b;

    public /* synthetic */ m(SingleBundlingNode singleBundlingNode) {
        this.f5540b = singleBundlingNode;
    }

    public final void accept(Object obj) {
        this.f5540b.matchImageWithRequest((ImageProxy) obj);
    }
}
