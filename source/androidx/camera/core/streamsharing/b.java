package androidx.camera.core.streamsharing;

import androidx.camera.core.streamsharing.StreamSharing;
import com.google.common.util.concurrent.ListenableFuture;

public final /* synthetic */ class b implements StreamSharing.Control {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ StreamSharing f5719a;

    public /* synthetic */ b(StreamSharing streamSharing) {
        this.f5719a = streamSharing;
    }

    public final ListenableFuture jpegSnapshot(int i11, int i12) {
        return this.f5719a.lambda$new$0(i11, i12);
    }
}
