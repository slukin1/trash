package androidx.camera.video;

import androidx.camera.video.Recorder;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class i0 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Recorder f5971a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Recorder.i f5972b;

    public /* synthetic */ i0(Recorder recorder, Recorder.i iVar) {
        this.f5971a = recorder;
        this.f5972b = iVar;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f5971a.R(this.f5972b, aVar);
    }
}
