package androidx.camera.video;

import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;

public final /* synthetic */ class l0 implements Consumer {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Recorder f6311b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ CallbackToFutureAdapter.a f6312c;

    public /* synthetic */ l0(Recorder recorder, CallbackToFutureAdapter.a aVar) {
        this.f6311b = recorder;
        this.f6312c = aVar;
    }

    public final void accept(Object obj) {
        this.f6311b.S(this.f6312c, (Throwable) obj);
    }
}
