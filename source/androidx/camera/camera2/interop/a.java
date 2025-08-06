package androidx.camera.camera2.interop;

import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.u;
import androidx.camera.core.CameraControl;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Executor;
import t.b;
import t.c;
import t.d;
import t.e;
import t.f;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public boolean f5485a = false;

    /* renamed from: b  reason: collision with root package name */
    public boolean f5486b = false;

    /* renamed from: c  reason: collision with root package name */
    public final u f5487c;

    /* renamed from: d  reason: collision with root package name */
    public final Executor f5488d;

    /* renamed from: e  reason: collision with root package name */
    public final Object f5489e = new Object();

    /* renamed from: f  reason: collision with root package name */
    public Camera2ImplConfig.Builder f5490f = new Camera2ImplConfig.Builder();

    /* renamed from: g  reason: collision with root package name */
    public CallbackToFutureAdapter.a<Void> f5491g;

    /* renamed from: h  reason: collision with root package name */
    public final u.c f5492h = new t.a(this);

    public a(u uVar, Executor executor) {
        this.f5487c = uVar;
        this.f5488d = executor;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object n(CallbackToFutureAdapter.a aVar) throws Exception {
        this.f5488d.execute(new e(this, aVar));
        return "addCaptureRequestOptions";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object p(CallbackToFutureAdapter.a aVar) throws Exception {
        this.f5488d.execute(new d(this, aVar));
        return "clearCaptureRequestOptions";
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:13:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ boolean q(android.hardware.camera2.TotalCaptureResult r3) {
        /*
            r2 = this;
            androidx.concurrent.futures.CallbackToFutureAdapter$a<java.lang.Void> r0 = r2.f5491g
            r1 = 0
            if (r0 == 0) goto L_0x0032
            android.hardware.camera2.CaptureRequest r3 = r3.getRequest()
            java.lang.Object r3 = r3.getTag()
            boolean r0 = r3 instanceof androidx.camera.core.impl.TagBundle
            if (r0 == 0) goto L_0x0032
            androidx.camera.core.impl.TagBundle r3 = (androidx.camera.core.impl.TagBundle) r3
            java.lang.String r0 = "Camera2CameraControl"
            java.lang.Object r3 = r3.getTag(r0)
            java.lang.Integer r3 = (java.lang.Integer) r3
            if (r3 == 0) goto L_0x0032
            androidx.concurrent.futures.CallbackToFutureAdapter$a<java.lang.Void> r0 = r2.f5491g
            int r0 = r0.hashCode()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0032
            androidx.concurrent.futures.CallbackToFutureAdapter$a<java.lang.Void> r3 = r2.f5491g
            r2.f5491g = r1
            goto L_0x0033
        L_0x0032:
            r3 = r1
        L_0x0033:
            if (r3 == 0) goto L_0x0038
            r3.c(r1)
        L_0x0038:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.interop.a.q(android.hardware.camera2.TotalCaptureResult):boolean");
    }

    public ListenableFuture<Void> g(CaptureRequestOptions captureRequestOptions) {
        h(captureRequestOptions);
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.a(new c(this)));
    }

    public final void h(CaptureRequestOptions captureRequestOptions) {
        synchronized (this.f5489e) {
            for (Config.Option option : captureRequestOptions.listOptions()) {
                this.f5490f.getMutableConfig().insertOption(option, captureRequestOptions.retrieveOption(option));
            }
        }
    }

    public ListenableFuture<Void> i() {
        j();
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.a(new b(this)));
    }

    public final void j() {
        synchronized (this.f5489e) {
            this.f5490f = new Camera2ImplConfig.Builder();
        }
    }

    public Camera2ImplConfig k() {
        Camera2ImplConfig a11;
        synchronized (this.f5489e) {
            if (this.f5491g != null) {
                this.f5490f.getMutableConfig().insertOption(Camera2ImplConfig.f4896h, Integer.valueOf(this.f5491g.hashCode()));
            }
            a11 = this.f5490f.build();
        }
        return a11;
    }

    public u.c l() {
        return this.f5492h;
    }

    public void s(boolean z11) {
        this.f5488d.execute(new f(this, z11));
    }

    /* renamed from: t */
    public final void r(boolean z11) {
        if (this.f5485a != z11) {
            this.f5485a = z11;
            if (!z11) {
                CallbackToFutureAdapter.a<Void> aVar = this.f5491g;
                if (aVar != null) {
                    aVar.f(new CameraControl.OperationCanceledException("The camera control has became inactive."));
                    this.f5491g = null;
                }
            } else if (this.f5486b) {
                v();
            }
        }
    }

    /* renamed from: u */
    public final void o(CallbackToFutureAdapter.a<Void> aVar) {
        this.f5486b = true;
        CallbackToFutureAdapter.a<Void> aVar2 = this.f5491g;
        if (aVar2 == null) {
            aVar2 = null;
        }
        this.f5491g = aVar;
        if (this.f5485a) {
            v();
        }
        if (aVar2 != null) {
            aVar2.f(new CameraControl.OperationCanceledException("Camera2CameraControl was updated with new options."));
        }
    }

    public final void v() {
        this.f5487c.Y();
        this.f5486b = false;
    }
}
