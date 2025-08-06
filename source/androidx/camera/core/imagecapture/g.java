package androidx.camera.core.imagecapture;

import androidx.camera.core.imagecapture.ProcessingNode;

public final /* synthetic */ class g implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ ProcessingNode f5530b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ProcessingNode.InputPacket f5531c;

    public /* synthetic */ g(ProcessingNode processingNode, ProcessingNode.InputPacket inputPacket) {
        this.f5530b = processingNode;
        this.f5531c = inputPacket;
    }

    public final void run() {
        this.f5530b.lambda$transform$0(this.f5531c);
    }
}
