package androidx.camera.video.internal.encoder;

import androidx.camera.core.impl.Observable;
import androidx.camera.video.internal.BufferProvider;
import java.util.Map;

public final /* synthetic */ class o0 implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Map.Entry f6248b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ BufferProvider.State f6249c;

    public /* synthetic */ o0(Map.Entry entry, BufferProvider.State state) {
        this.f6248b = entry;
        this.f6249c = state;
    }

    public final void run() {
        ((Observable.Observer) this.f6248b.getKey()).onNewData(this.f6249c);
    }
}
