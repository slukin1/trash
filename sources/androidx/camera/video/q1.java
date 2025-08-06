package androidx.camera.video;

import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Timebase;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.concurrent.futures.CallbackToFutureAdapter;

public final /* synthetic */ class q1 implements CallbackToFutureAdapter.b {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ VideoEncoderSession f6340a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ SurfaceRequest f6341b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Timebase f6342c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ VideoValidatedEncoderProfilesProxy f6343d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ r f6344e;

    public /* synthetic */ q1(VideoEncoderSession videoEncoderSession, SurfaceRequest surfaceRequest, Timebase timebase, VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy, r rVar) {
        this.f6340a = videoEncoderSession;
        this.f6341b = surfaceRequest;
        this.f6342c = timebase;
        this.f6343d = videoValidatedEncoderProfilesProxy;
        this.f6344e = rVar;
    }

    public final Object attachCompleter(CallbackToFutureAdapter.a aVar) {
        return this.f6340a.q(this.f6341b, this.f6342c, this.f6343d, this.f6344e, aVar);
    }
}
