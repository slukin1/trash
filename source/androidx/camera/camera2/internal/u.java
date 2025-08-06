package androidx.camera.camera2.internal;

import android.graphics.Rect;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.os.Build;
import android.util.ArrayMap;
import android.util.Rational;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.core.CameraControl;
import androidx.camera.core.FocusMeteringAction;
import androidx.camera.core.FocusMeteringResult;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.TagBundle;
import androidx.camera.core.impl.e;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicLong;
import o.y;

public class u implements CameraControlInternal {

    /* renamed from: a  reason: collision with root package name */
    public final b f5333a;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f5334b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f5335c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public final y f5336d;

    /* renamed from: e  reason: collision with root package name */
    public final CameraControlInternal.ControlUpdateCallback f5337e;

    /* renamed from: f  reason: collision with root package name */
    public final SessionConfig.Builder f5338f;

    /* renamed from: g  reason: collision with root package name */
    public final x2 f5339g;

    /* renamed from: h  reason: collision with root package name */
    public final m4 f5340h;

    /* renamed from: i  reason: collision with root package name */
    public final h4 f5341i;

    /* renamed from: j  reason: collision with root package name */
    public final l2 f5342j;

    /* renamed from: k  reason: collision with root package name */
    public o4 f5343k;

    /* renamed from: l  reason: collision with root package name */
    public final androidx.camera.camera2.interop.a f5344l;

    /* renamed from: m  reason: collision with root package name */
    public final x0 f5345m;

    /* renamed from: n  reason: collision with root package name */
    public int f5346n;

    /* renamed from: o  reason: collision with root package name */
    public volatile boolean f5347o;

    /* renamed from: p  reason: collision with root package name */
    public volatile int f5348p;

    /* renamed from: q  reason: collision with root package name */
    public final r.a f5349q;

    /* renamed from: r  reason: collision with root package name */
    public final r.b f5350r;

    /* renamed from: s  reason: collision with root package name */
    public final AtomicLong f5351s;

    /* renamed from: t  reason: collision with root package name */
    public volatile ListenableFuture<Void> f5352t;

    /* renamed from: u  reason: collision with root package name */
    public int f5353u;

    /* renamed from: v  reason: collision with root package name */
    public long f5354v;

    /* renamed from: w  reason: collision with root package name */
    public final a f5355w;

    public static final class a extends CameraCaptureCallback {

        /* renamed from: a  reason: collision with root package name */
        public Set<CameraCaptureCallback> f5356a = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        public Map<CameraCaptureCallback, Executor> f5357b = new ArrayMap();

        public void d(Executor executor, CameraCaptureCallback cameraCaptureCallback) {
            this.f5356a.add(cameraCaptureCallback);
            this.f5357b.put(cameraCaptureCallback, executor);
        }

        public void h(CameraCaptureCallback cameraCaptureCallback) {
            this.f5356a.remove(cameraCaptureCallback);
            this.f5357b.remove(cameraCaptureCallback);
        }

        public void onCaptureCancelled() {
            for (CameraCaptureCallback next : this.f5356a) {
                try {
                    this.f5357b.get(next).execute(new r(next));
                } catch (RejectedExecutionException e11) {
                    Logger.e("Camera2CameraControlImp", "Executor rejected to invoke onCaptureCancelled.", e11);
                }
            }
        }

        public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
            for (CameraCaptureCallback next : this.f5356a) {
                try {
                    this.f5357b.get(next).execute(new t(next, cameraCaptureResult));
                } catch (RejectedExecutionException e11) {
                    Logger.e("Camera2CameraControlImp", "Executor rejected to invoke onCaptureCompleted.", e11);
                }
            }
        }

        public void onCaptureFailed(CameraCaptureFailure cameraCaptureFailure) {
            for (CameraCaptureCallback next : this.f5356a) {
                try {
                    this.f5357b.get(next).execute(new s(next, cameraCaptureFailure));
                } catch (RejectedExecutionException e11) {
                    Logger.e("Camera2CameraControlImp", "Executor rejected to invoke onCaptureFailed.", e11);
                }
            }
        }
    }

    public static final class b extends CameraCaptureSession.CaptureCallback {

        /* renamed from: a  reason: collision with root package name */
        public final Set<c> f5358a = new HashSet();

        /* renamed from: b  reason: collision with root package name */
        public final Executor f5359b;

        public b(Executor executor) {
            this.f5359b = executor;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void c(TotalCaptureResult totalCaptureResult) {
            HashSet hashSet = new HashSet();
            for (c next : this.f5358a) {
                if (next.a(totalCaptureResult)) {
                    hashSet.add(next);
                }
            }
            if (!hashSet.isEmpty()) {
                this.f5358a.removeAll(hashSet);
            }
        }

        public void b(c cVar) {
            this.f5358a.add(cVar);
        }

        public void d(c cVar) {
            this.f5358a.remove(cVar);
        }

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            this.f5359b.execute(new v(this, totalCaptureResult));
        }
    }

    public interface c {
        boolean a(TotalCaptureResult totalCaptureResult);
    }

    public u(y yVar, ScheduledExecutorService scheduledExecutorService, Executor executor, CameraControlInternal.ControlUpdateCallback controlUpdateCallback, Quirks quirks) {
        SessionConfig.Builder builder = new SessionConfig.Builder();
        this.f5338f = builder;
        this.f5346n = 0;
        this.f5347o = false;
        this.f5348p = 2;
        this.f5351s = new AtomicLong(0);
        this.f5352t = Futures.immediateFuture(null);
        this.f5353u = 1;
        this.f5354v = 0;
        a aVar = new a();
        this.f5355w = aVar;
        this.f5336d = yVar;
        this.f5337e = controlUpdateCallback;
        this.f5334b = executor;
        b bVar = new b(executor);
        this.f5333a = bVar;
        builder.setTemplateType(this.f5353u);
        builder.addRepeatingCameraCaptureCallback(x1.a(bVar));
        builder.addRepeatingCameraCaptureCallback(aVar);
        this.f5342j = new l2(this, yVar, executor);
        this.f5339g = new x2(this, scheduledExecutorService, executor, quirks);
        this.f5340h = new m4(this, yVar, executor);
        this.f5341i = new h4(this, yVar, executor);
        if (Build.VERSION.SDK_INT >= 23) {
            this.f5343k = new s4(yVar);
        } else {
            this.f5343k = new ZslControlNoOpImpl();
        }
        this.f5349q = new r.a(quirks);
        this.f5350r = new r.b(quirks);
        this.f5344l = new androidx.camera.camera2.interop.a(this, executor);
        this.f5345m = new x0(this, yVar, quirks, executor);
        executor.execute(new m(this));
    }

    public static boolean F(TotalCaptureResult totalCaptureResult, long j11) {
        Long l11;
        if (totalCaptureResult.getRequest() == null) {
            return false;
        }
        Object tag = totalCaptureResult.getRequest().getTag();
        if (!(tag instanceof TagBundle) || (l11 = (Long) ((TagBundle) tag).getTag("CameraControlSessionUpdateId")) == null || l11.longValue() < j11) {
            return false;
        }
        return true;
    }

    public static /* synthetic */ void H() {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(Executor executor, CameraCaptureCallback cameraCaptureCallback) {
        this.f5355w.d(executor, cameraCaptureCallback);
    }

    public static /* synthetic */ void J() {
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K() {
        k(this.f5344l.l());
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L(CameraCaptureCallback cameraCaptureCallback) {
        this.f5355w.h(cameraCaptureCallback);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ListenableFuture M(List list, int i11, int i12, int i13, Void voidR) throws Exception {
        return this.f5345m.e(list, i11, i12, i13);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N(CallbackToFutureAdapter.a aVar) {
        Futures.propagate(b0(a0()), aVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object O(CallbackToFutureAdapter.a aVar) throws Exception {
        this.f5334b.execute(new o(this, aVar));
        return "updateSessionConfigAsync";
    }

    public static /* synthetic */ boolean P(long j11, CallbackToFutureAdapter.a aVar, TotalCaptureResult totalCaptureResult) {
        if (!F(totalCaptureResult, j11)) {
            return false;
        }
        aVar.c(null);
        return true;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object Q(long j11, CallbackToFutureAdapter.a aVar) throws Exception {
        k(new g(j11, aVar));
        return "waitForSessionUpdateId:" + j11;
    }

    public m4 A() {
        return this.f5340h;
    }

    public o4 B() {
        return this.f5343k;
    }

    public void C() {
        synchronized (this.f5335c) {
            this.f5346n++;
        }
    }

    public final boolean D() {
        return z() > 0;
    }

    public final boolean E(int i11, int[] iArr) {
        for (int i12 : iArr) {
            if (i11 == i12) {
                return true;
            }
        }
        return false;
    }

    public boolean G() {
        return this.f5347o;
    }

    public void R(c cVar) {
        this.f5333a.d(cVar);
    }

    public void S(CameraCaptureCallback cameraCaptureCallback) {
        this.f5334b.execute(new n(this, cameraCaptureCallback));
    }

    public void T() {
        W(1);
    }

    public void U(boolean z11) {
        this.f5339g.P(z11);
        this.f5340h.p(z11);
        this.f5341i.j(z11);
        this.f5342j.j(z11);
        this.f5344l.s(z11);
    }

    public void V(Rational rational) {
        this.f5339g.Q(rational);
    }

    public void W(int i11) {
        this.f5353u = i11;
        this.f5339g.R(i11);
        this.f5345m.d(this.f5353u);
    }

    public void X(List<CaptureConfig> list) {
        this.f5337e.onCameraControlCaptureRequests(list);
    }

    public void Y() {
        this.f5334b.execute(new l(this));
    }

    public ListenableFuture<Void> Z() {
        return Futures.nonCancellationPropagating(CallbackToFutureAdapter.a(new j(this)));
    }

    public long a0() {
        this.f5354v = this.f5351s.getAndIncrement();
        this.f5337e.onCameraControlUpdateSessionConfig();
        return this.f5354v;
    }

    public void addInteropConfig(Config config) {
        this.f5344l.g(CaptureRequestOptions.Builder.c(config).build()).addListener(h.f5135b, CameraXExecutors.directExecutor());
    }

    public void addZslConfig(SessionConfig.Builder builder) {
        this.f5343k.addZslConfig(builder);
    }

    public final ListenableFuture<Void> b0(long j11) {
        return CallbackToFutureAdapter.a(new k(this, j11));
    }

    public ListenableFuture<Void> cancelFocusAndMetering() {
        if (!D()) {
            return Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
        }
        return Futures.nonCancellationPropagating(this.f5339g.m());
    }

    public void clearInteropConfig() {
        this.f5344l.i().addListener(q.f5275b, CameraXExecutors.directExecutor());
    }

    public ListenableFuture<Void> enableTorch(boolean z11) {
        if (!D()) {
            return Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
        }
        return Futures.nonCancellationPropagating(this.f5341i.d(z11));
    }

    public int getFlashMode() {
        return this.f5348p;
    }

    public /* synthetic */ CameraControlInternal getImplementation() {
        return e.a(this);
    }

    public Config getInteropConfig() {
        return this.f5344l.k();
    }

    public Rect getSensorRect() {
        return (Rect) h.g((Rect) this.f5336d.a(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE));
    }

    public SessionConfig getSessionConfig() {
        this.f5338f.setTemplateType(this.f5353u);
        this.f5338f.setImplementationOptions(u());
        Object d11 = this.f5344l.k().d((Object) null);
        if (d11 != null && (d11 instanceof Integer)) {
            this.f5338f.addTag("Camera2CameraControl", d11);
        }
        this.f5338f.addTag("CameraControlSessionUpdateId", Long.valueOf(this.f5354v));
        return this.f5338f.build();
    }

    public boolean isZslDisabledByByUserCaseConfig() {
        return this.f5343k.a();
    }

    public void k(c cVar) {
        this.f5333a.b(cVar);
    }

    public void l(Executor executor, CameraCaptureCallback cameraCaptureCallback) {
        this.f5334b.execute(new p(this, executor, cameraCaptureCallback));
    }

    public void m() {
        synchronized (this.f5335c) {
            int i11 = this.f5346n;
            if (i11 != 0) {
                this.f5346n = i11 - 1;
            } else {
                throw new IllegalStateException("Decrementing use count occurs more times than incrementing");
            }
        }
    }

    public void n(boolean z11) {
        this.f5347o = z11;
        if (!z11) {
            CaptureConfig.Builder builder = new CaptureConfig.Builder();
            builder.setTemplateType(this.f5353u);
            builder.setUseRepeatingSurface(true);
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            builder2.c(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(v(1)));
            builder2.c(CaptureRequest.FLASH_MODE, 0);
            builder.addImplementationOptions(builder2.build());
            X(Collections.singletonList(builder.build()));
        }
        a0();
    }

    public Rect o() {
        return this.f5340h.g();
    }

    public l2 p() {
        return this.f5342j;
    }

    public x2 q() {
        return this.f5339g;
    }

    public int r() {
        Integer num = (Integer) this.f5336d.a(CameraCharacteristics.CONTROL_MAX_REGIONS_AE);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public int s() {
        Integer num = (Integer) this.f5336d.a(CameraCharacteristics.CONTROL_MAX_REGIONS_AF);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public ListenableFuture<Integer> setExposureCompensationIndex(int i11) {
        if (!D()) {
            return Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
        }
        return this.f5342j.l(i11);
    }

    public void setFlashMode(int i11) {
        if (!D()) {
            Logger.w("Camera2CameraControlImp", "Camera is not active.");
            return;
        }
        this.f5348p = i11;
        o4 o4Var = this.f5343k;
        boolean z11 = true;
        if (!(this.f5348p == 1 || this.f5348p == 0)) {
            z11 = false;
        }
        o4Var.b(z11);
        this.f5352t = Z();
    }

    public ListenableFuture<Void> setLinearZoom(float f11) {
        if (!D()) {
            return Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
        }
        return Futures.nonCancellationPropagating(this.f5340h.q(f11));
    }

    public ListenableFuture<Void> setZoomRatio(float f11) {
        if (!D()) {
            return Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
        }
        return Futures.nonCancellationPropagating(this.f5340h.r(f11));
    }

    public void setZslDisabledByUserCaseConfig(boolean z11) {
        this.f5343k.setZslDisabledByUserCaseConfig(z11);
    }

    public ListenableFuture<FocusMeteringResult> startFocusAndMetering(FocusMeteringAction focusMeteringAction) {
        if (!D()) {
            return Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
        }
        return Futures.nonCancellationPropagating(this.f5339g.T(focusMeteringAction));
    }

    public ListenableFuture<List<Void>> submitStillCaptureRequests(List<CaptureConfig> list, int i11, int i12) {
        if (!D()) {
            Logger.w("Camera2CameraControlImp", "Camera is not active.");
            return Futures.immediateFailedFuture(new CameraControl.OperationCanceledException("Camera is not active."));
        }
        return FutureChain.from(Futures.nonCancellationPropagating(this.f5352t)).transformAsync(new i(this, list, i11, getFlashMode(), i12), this.f5334b);
    }

    public int t() {
        Integer num = (Integer) this.f5336d.a(CameraCharacteristics.CONTROL_MAX_REGIONS_AWB);
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0070 A[LOOP:0: B:10:0x006a->B:12:0x0070, LOOP_END] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.camera.core.impl.Config u() {
        /*
            r7 = this;
            androidx.camera.camera2.impl.Camera2ImplConfig$Builder r0 = new androidx.camera.camera2.impl.Camera2ImplConfig$Builder
            r0.<init>()
            android.hardware.camera2.CaptureRequest$Key r1 = android.hardware.camera2.CaptureRequest.CONTROL_MODE
            r2 = 1
            java.lang.Integer r3 = java.lang.Integer.valueOf(r2)
            r0.c(r1, r3)
            androidx.camera.camera2.internal.x2 r1 = r7.f5339g
            r1.k(r0)
            r.a r1 = r7.f5349q
            r1.a(r0)
            androidx.camera.camera2.internal.m4 r1 = r7.f5340h
            r1.e(r0)
            boolean r1 = r7.f5347o
            r3 = 2
            if (r1 == 0) goto L_0x002d
            android.hardware.camera2.CaptureRequest$Key r1 = android.hardware.camera2.CaptureRequest.FLASH_MODE
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)
            r0.c(r1, r3)
            goto L_0x0033
        L_0x002d:
            int r1 = r7.f5348p
            if (r1 == 0) goto L_0x0037
            if (r1 == r2) goto L_0x0035
        L_0x0033:
            r1 = r2
            goto L_0x003d
        L_0x0035:
            r1 = 3
            goto L_0x003d
        L_0x0037:
            r.b r1 = r7.f5350r
            int r1 = r1.a(r3)
        L_0x003d:
            android.hardware.camera2.CaptureRequest$Key r3 = android.hardware.camera2.CaptureRequest.CONTROL_AE_MODE
            int r1 = r7.v(r1)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.c(r3, r1)
            android.hardware.camera2.CaptureRequest$Key r1 = android.hardware.camera2.CaptureRequest.CONTROL_AWB_MODE
            int r2 = r7.x(r2)
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.c(r1, r2)
            androidx.camera.camera2.internal.l2 r1 = r7.f5342j
            r1.k(r0)
            androidx.camera.camera2.interop.a r1 = r7.f5344l
            androidx.camera.camera2.impl.Camera2ImplConfig r1 = r1.k()
            java.util.Set r2 = r1.listOptions()
            java.util.Iterator r2 = r2.iterator()
        L_0x006a:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x0084
            java.lang.Object r3 = r2.next()
            androidx.camera.core.impl.Config$Option r3 = (androidx.camera.core.impl.Config.Option) r3
            androidx.camera.core.impl.MutableConfig r4 = r0.getMutableConfig()
            androidx.camera.core.impl.Config$OptionPriority r5 = androidx.camera.core.impl.Config.OptionPriority.ALWAYS_OVERRIDE
            java.lang.Object r6 = r1.retrieveOption(r3)
            r4.insertOption(r3, r5, r6)
            goto L_0x006a
        L_0x0084:
            androidx.camera.camera2.impl.Camera2ImplConfig r0 = r0.build()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.u.u():androidx.camera.core.impl.Config");
    }

    public int v(int i11) {
        int[] iArr = (int[]) this.f5336d.a(CameraCharacteristics.CONTROL_AE_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        if (E(i11, iArr)) {
            return i11;
        }
        if (E(1, iArr)) {
            return 1;
        }
        return 0;
    }

    public int w(int i11) {
        int[] iArr = (int[]) this.f5336d.a(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        if (E(i11, iArr)) {
            return i11;
        }
        if (E(4, iArr)) {
            return 4;
        }
        if (E(1, iArr)) {
            return 1;
        }
        return 0;
    }

    public final int x(int i11) {
        int[] iArr = (int[]) this.f5336d.a(CameraCharacteristics.CONTROL_AWB_AVAILABLE_MODES);
        if (iArr == null) {
            return 0;
        }
        if (E(i11, iArr)) {
            return i11;
        }
        if (E(1, iArr)) {
            return 1;
        }
        return 0;
    }

    public h4 y() {
        return this.f5341i;
    }

    public int z() {
        int i11;
        synchronized (this.f5335c) {
            i11 = this.f5346n;
        }
        return i11;
    }
}
