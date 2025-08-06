package androidx.camera.core.imagecapture;

import androidx.camera.core.imagecapture.ProcessingNode;
import androidx.core.util.Consumer;

public final /* synthetic */ class f implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProcessingNode f5529b;

    public /* synthetic */ f(ProcessingNode processingNode) {
        this.f5529b = processingNode;
    }

    public final void accept(Object obj) {
        this.f5529b.lambda$transform$1((ProcessingNode.InputPacket) obj);
    }
}
