package androidx.camera.core.imagecapture;

import androidx.core.util.Consumer;

public final /* synthetic */ class d implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ CaptureNode f5525b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ NoMetadataImageReader f5526c;

    public /* synthetic */ d(CaptureNode captureNode, NoMetadataImageReader noMetadataImageReader) {
        this.f5525b = captureNode;
        this.f5526c = noMetadataImageReader;
    }

    public final void accept(Object obj) {
        this.f5525b.lambda$transform$0(this.f5526c, (ProcessingRequest) obj);
    }
}
