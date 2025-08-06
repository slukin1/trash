package androidx.camera.video;

import android.view.Surface;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.config.d;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import androidx.camera.video.internal.encoder.k;
import androidx.camera.video.internal.encoder.o;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Objects;
import java.util.concurrent.Executor;

public final class VideoEncoderSession {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f5887a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f5888b;

    /* renamed from: c  reason: collision with root package name */
    public final o f5889c;

    /* renamed from: d  reason: collision with root package name */
    public k f5890d = null;

    /* renamed from: e  reason: collision with root package name */
    public Surface f5891e = null;

    /* renamed from: f  reason: collision with root package name */
    public SurfaceRequest f5892f = null;

    /* renamed from: g  reason: collision with root package name */
    public Executor f5893g = null;

    /* renamed from: h  reason: collision with root package name */
    public k.c.a f5894h = null;

    /* renamed from: i  reason: collision with root package name */
    public VideoEncoderState f5895i = VideoEncoderState.NOT_INITIALIZED;

    /* renamed from: j  reason: collision with root package name */
    public ListenableFuture<Void> f5896j = Futures.immediateFailedFuture(new IllegalStateException("Cannot close the encoder before configuring."));

    /* renamed from: k  reason: collision with root package name */
    public CallbackToFutureAdapter.a<Void> f5897k = null;

    /* renamed from: l  reason: collision with root package name */
    public ListenableFuture<k> f5898l = Futures.immediateFailedFuture(new IllegalStateException("Cannot close the encoder before configuring."));

    /* renamed from: m  reason: collision with root package name */
    public CallbackToFutureAdapter.a<k> f5899m = null;

    public enum VideoEncoderState {
        NOT_INITIALIZED,
        INITIALIZING,
        PENDING_RELEASE,
        READY,
        RELEASED
    }

    public class a implements FutureCallback<k> {
        public a() {
        }

        /* renamed from: a */
        public void onSuccess(k kVar) {
        }

        public void onFailure(Throwable th2) {
            Logger.w("VideoEncoderSession", "VideoEncoder configuration failed.", th2);
            VideoEncoderSession.this.x();
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5901a;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.camera.video.VideoEncoderSession$VideoEncoderState[] r0 = androidx.camera.video.VideoEncoderSession.VideoEncoderState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5901a = r0
                androidx.camera.video.VideoEncoderSession$VideoEncoderState r1 = androidx.camera.video.VideoEncoderSession.VideoEncoderState.NOT_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5901a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.video.VideoEncoderSession$VideoEncoderState r1 = androidx.camera.video.VideoEncoderSession.VideoEncoderState.INITIALIZING     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f5901a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.video.VideoEncoderSession$VideoEncoderState r1 = androidx.camera.video.VideoEncoderSession.VideoEncoderState.READY     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f5901a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.camera.video.VideoEncoderSession$VideoEncoderState r1 = androidx.camera.video.VideoEncoderSession.VideoEncoderState.PENDING_RELEASE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f5901a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.camera.video.VideoEncoderSession$VideoEncoderState r1 = androidx.camera.video.VideoEncoderSession.VideoEncoderState.RELEASED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.VideoEncoderSession.b.<clinit>():void");
        }
    }

    public VideoEncoderSession(o oVar, Executor executor, Executor executor2) {
        this.f5887a = executor2;
        this.f5888b = executor;
        this.f5889c = oVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object o(CallbackToFutureAdapter.a aVar) throws Exception {
        this.f5897k = aVar;
        return "ReleasedFuture " + this;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object p(CallbackToFutureAdapter.a aVar) throws Exception {
        this.f5899m = aVar;
        return "ReadyToReleaseFuture " + this;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object q(SurfaceRequest surfaceRequest, Timebase timebase, VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy, r rVar, CallbackToFutureAdapter.a aVar) throws Exception {
        j(surfaceRequest, timebase, videoValidatedEncoderProfilesProxy, rVar, aVar);
        return "ConfigureVideoEncoderFuture " + this;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r(Surface surface) {
        this.f5894h.a(surface);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(CallbackToFutureAdapter.a aVar, SurfaceRequest surfaceRequest, Surface surface) {
        Executor executor;
        int i11 = b.f5901a[this.f5895i.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 == 3) {
                    if (!(this.f5894h == null || (executor = this.f5893g) == null)) {
                        executor.execute(new t1(this, surface));
                    }
                    Logger.w("VideoEncoderSession", "Surface is updated in READY state: " + surface);
                    return;
                } else if (!(i11 == 4 || i11 == 5)) {
                    throw new IllegalStateException("State " + this.f5895i + " is not handled");
                }
            } else if (surfaceRequest.isServiced()) {
                Logger.d("VideoEncoderSession", "Not provide surface, " + Objects.toString(surfaceRequest, "EMPTY") + " is already serviced.");
                aVar.c(null);
                h();
                return;
            } else {
                this.f5891e = surface;
                Logger.d("VideoEncoderSession", "provide surface: " + surface);
                surfaceRequest.provideSurface(surface, this.f5888b, new r1(this));
                this.f5895i = VideoEncoderState.READY;
                aVar.c(this.f5890d);
                return;
            }
        }
        Logger.d("VideoEncoderSession", "Not provide surface in " + this.f5895i);
        aVar.c(null);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void t() {
        this.f5897k.c(null);
    }

    public final void h() {
        int i11 = b.f5901a[this.f5895i.ordinal()];
        if (i11 == 1 || i11 == 2) {
            x();
        } else if (i11 == 3 || i11 == 4) {
            Logger.d("VideoEncoderSession", "closeInternal in " + this.f5895i + " state");
            this.f5895i = VideoEncoderState.PENDING_RELEASE;
        } else if (i11 == 5) {
            Logger.d("VideoEncoderSession", "closeInternal in RELEASED state, No-op");
        } else {
            throw new IllegalStateException("State " + this.f5895i + " is not handled");
        }
    }

    public ListenableFuture<k> i(SurfaceRequest surfaceRequest, Timebase timebase, r rVar, VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy) {
        if (b.f5901a[this.f5895i.ordinal()] != 1) {
            return Futures.immediateFailedFuture(new IllegalStateException("configure() shouldn't be called in " + this.f5895i));
        }
        this.f5895i = VideoEncoderState.INITIALIZING;
        this.f5892f = surfaceRequest;
        Logger.d("VideoEncoderSession", "Create VideoEncoderSession: " + this);
        this.f5896j = CallbackToFutureAdapter.a(new p1(this));
        this.f5898l = CallbackToFutureAdapter.a(new o1(this));
        ListenableFuture a11 = CallbackToFutureAdapter.a(new q1(this, surfaceRequest, timebase, videoValidatedEncoderProfilesProxy, rVar));
        Futures.addCallback(a11, new a(), this.f5888b);
        return Futures.nonCancellationPropagating(a11);
    }

    public final void j(SurfaceRequest surfaceRequest, Timebase timebase, VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy, r rVar, CallbackToFutureAdapter.a<k> aVar) {
        DynamicRange dynamicRange = surfaceRequest.getDynamicRange();
        try {
            k a11 = this.f5889c.a(this.f5887a, d.c(d.d(rVar, dynamicRange, videoValidatedEncoderProfilesProxy), timebase, rVar.d(), surfaceRequest.getResolution(), dynamicRange, surfaceRequest.getExpectedFrameRate()));
            this.f5890d = a11;
            k.b d11 = a11.d();
            if (!(d11 instanceof k.c)) {
                aVar.f(new AssertionError("The EncoderInput of video isn't a SurfaceInput."));
            } else {
                ((k.c) d11).a(this.f5888b, new n1(this, aVar, surfaceRequest));
            }
        } catch (InvalidConfigException e11) {
            Logger.e("VideoEncoderSession", "Unable to initialize video encoder.", e11);
            aVar.f(e11);
        }
    }

    public Surface k() {
        if (this.f5895i != VideoEncoderState.READY) {
            return null;
        }
        return this.f5891e;
    }

    public ListenableFuture<k> l() {
        return Futures.nonCancellationPropagating(this.f5898l);
    }

    public k m() {
        return this.f5890d;
    }

    public boolean n(SurfaceRequest surfaceRequest) {
        int i11 = b.f5901a[this.f5895i.ordinal()];
        if (i11 == 1) {
            return false;
        }
        if (i11 == 2 || i11 == 3) {
            if (this.f5892f == surfaceRequest) {
                return true;
            }
            return false;
        } else if (i11 == 4 || i11 == 5) {
            return false;
        } else {
            throw new IllegalStateException("State " + this.f5895i + " is not handled");
        }
    }

    public String toString() {
        return "VideoEncoderSession@" + hashCode() + " for " + Objects.toString(this.f5892f, "SURFACE_REQUEST_NOT_CONFIGURED");
    }

    public final void u(SurfaceRequest.Result result) {
        Logger.d("VideoEncoderSession", "Surface can be closed: " + result.getSurface().hashCode());
        Surface surface = result.getSurface();
        if (surface == this.f5891e) {
            this.f5891e = null;
            this.f5899m.c(this.f5890d);
            h();
            return;
        }
        surface.release();
    }

    public void v(Executor executor, k.c.a aVar) {
        this.f5893g = executor;
        this.f5894h = aVar;
    }

    public ListenableFuture<Void> w() {
        h();
        return Futures.nonCancellationPropagating(this.f5896j);
    }

    public void x() {
        int i11 = b.f5901a[this.f5895i.ordinal()];
        if (i11 == 1) {
            this.f5895i = VideoEncoderState.RELEASED;
        } else if (i11 == 2 || i11 == 3 || i11 == 4) {
            this.f5895i = VideoEncoderState.RELEASED;
            this.f5899m.c(this.f5890d);
            this.f5892f = null;
            if (this.f5890d != null) {
                Logger.d("VideoEncoderSession", "VideoEncoder is releasing: " + this.f5890d);
                this.f5890d.release();
                this.f5890d.e().addListener(new s1(this), this.f5888b);
                this.f5890d = null;
                return;
            }
            Logger.w("VideoEncoderSession", "There's no VideoEncoder to release! Finish release completer.");
            this.f5897k.c(null);
        } else if (i11 == 5) {
            Logger.d("VideoEncoderSession", "terminateNow in " + this.f5895i + ", No-op");
        } else {
            throw new IllegalStateException("State " + this.f5895i + " is not handled");
        }
    }
}
