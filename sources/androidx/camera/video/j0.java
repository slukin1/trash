package androidx.camera.video;

import androidx.camera.video.Recorder;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class j0 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ Recorder f6296a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Recorder.i f6297b;

    public /* synthetic */ j0(Recorder recorder, Recorder.i iVar) {
        this.f6296a = recorder;
        this.f6297b = iVar;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f6296a.T(this.f6297b, aVar);
    }
}
