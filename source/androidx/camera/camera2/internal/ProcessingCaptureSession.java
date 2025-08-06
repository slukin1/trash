package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.util.Size;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.interop.CaptureRequestOptions;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.DeferrableSurfaces;
import androidx.camera.core.impl.OutputSurface;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.SessionProcessorSurface;
import androidx.camera.core.impl.j0;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.core.util.h;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;

public final class ProcessingCaptureSession implements c2 {

    /* renamed from: q  reason: collision with root package name */
    public static List<DeferrableSurface> f4967q = new ArrayList();

    /* renamed from: r  reason: collision with root package name */
    public static int f4968r = 0;

    /* renamed from: a  reason: collision with root package name */
    public final SessionProcessor f4969a;

    /* renamed from: b  reason: collision with root package name */
    public final s0 f4970b;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f4971c;

    /* renamed from: d  reason: collision with root package name */
    public final ScheduledExecutorService f4972d;

    /* renamed from: e  reason: collision with root package name */
    public final CaptureSession f4973e;

    /* renamed from: f  reason: collision with root package name */
    public List<DeferrableSurface> f4974f = new ArrayList();

    /* renamed from: g  reason: collision with root package name */
    public SessionConfig f4975g;

    /* renamed from: h  reason: collision with root package name */
    public n1 f4976h;

    /* renamed from: i  reason: collision with root package name */
    public SessionConfig f4977i;

    /* renamed from: j  reason: collision with root package name */
    public ProcessorState f4978j;

    /* renamed from: k  reason: collision with root package name */
    public volatile List<CaptureConfig> f4979k = null;

    /* renamed from: l  reason: collision with root package name */
    public volatile boolean f4980l = false;

    /* renamed from: m  reason: collision with root package name */
    public final e f4981m;

    /* renamed from: n  reason: collision with root package name */
    public CaptureRequestOptions f4982n = new CaptureRequestOptions.Builder().build();

    /* renamed from: o  reason: collision with root package name */
    public CaptureRequestOptions f4983o = new CaptureRequestOptions.Builder().build();

    /* renamed from: p  reason: collision with root package name */
    public int f4984p = 0;

    public enum ProcessorState {
        UNINITIALIZED,
        SESSION_INITIALIZED,
        ON_CAPTURE_SESSION_STARTED,
        ON_CAPTURE_SESSION_ENDED,
        DE_INITIALIZED
    }

    public class a implements FutureCallback<Void> {
        public a() {
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
        }

        public void onFailure(Throwable th2) {
            Logger.e("ProcessingCaptureSession", "open session failed ", th2);
            ProcessingCaptureSession.this.close();
            ProcessingCaptureSession.this.a(false);
        }
    }

    public class b implements SessionProcessor.CaptureCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CaptureConfig f4986a;

        public b(CaptureConfig captureConfig) {
            this.f4986a = captureConfig;
        }

        public static /* synthetic */ void c(CaptureConfig captureConfig) {
            for (CameraCaptureCallback onCaptureFailed : captureConfig.getCameraCaptureCallbacks()) {
                onCaptureFailed.onCaptureFailed(new CameraCaptureFailure(CameraCaptureFailure.Reason.ERROR));
            }
        }

        public static /* synthetic */ void d(CaptureConfig captureConfig) {
            for (CameraCaptureCallback onCaptureCompleted : captureConfig.getCameraCaptureCallbacks()) {
                onCaptureCompleted.onCaptureCompleted(new CameraCaptureResult.EmptyCameraCaptureResult());
            }
        }

        public /* synthetic */ void onCaptureCompleted(long j11, int i11, Map map) {
            j0.a(this, j11, i11, map);
        }

        public void onCaptureFailed(int i11) {
            ProcessingCaptureSession.this.f4971c.execute(new k3(this.f4986a));
        }

        public /* synthetic */ void onCaptureProcessStarted(int i11) {
            j0.c(this, i11);
        }

        public /* synthetic */ void onCaptureSequenceAborted(int i11) {
            j0.d(this, i11);
        }

        public void onCaptureSequenceCompleted(int i11) {
            ProcessingCaptureSession.this.f4971c.execute(new l3(this.f4986a));
        }

        public /* synthetic */ void onCaptureStarted(int i11, long j11) {
            j0.f(this, i11, j11);
        }
    }

    public class c implements SessionProcessor.CaptureCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CaptureConfig f4988a;

        public c(CaptureConfig captureConfig) {
            this.f4988a = captureConfig;
        }

        public static /* synthetic */ void c(CaptureConfig captureConfig) {
            for (CameraCaptureCallback onCaptureFailed : captureConfig.getCameraCaptureCallbacks()) {
                onCaptureFailed.onCaptureFailed(new CameraCaptureFailure(CameraCaptureFailure.Reason.ERROR));
            }
        }

        public static /* synthetic */ void d(CaptureConfig captureConfig) {
            for (CameraCaptureCallback onCaptureCompleted : captureConfig.getCameraCaptureCallbacks()) {
                onCaptureCompleted.onCaptureCompleted(new CameraCaptureResult.EmptyCameraCaptureResult());
            }
        }

        public /* synthetic */ void onCaptureCompleted(long j11, int i11, Map map) {
            j0.a(this, j11, i11, map);
        }

        public void onCaptureFailed(int i11) {
            ProcessingCaptureSession.this.f4971c.execute(new n3(this.f4988a));
        }

        public /* synthetic */ void onCaptureProcessStarted(int i11) {
            j0.c(this, i11);
        }

        public /* synthetic */ void onCaptureSequenceAborted(int i11) {
            j0.d(this, i11);
        }

        public void onCaptureSequenceCompleted(int i11) {
            ProcessingCaptureSession.this.f4971c.execute(new m3(this.f4988a));
        }

        public /* synthetic */ void onCaptureStarted(int i11, long j11) {
            j0.f(this, i11, j11);
        }
    }

    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f4990a;

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
                androidx.camera.camera2.internal.ProcessingCaptureSession$ProcessorState[] r0 = androidx.camera.camera2.internal.ProcessingCaptureSession.ProcessorState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4990a = r0
                androidx.camera.camera2.internal.ProcessingCaptureSession$ProcessorState r1 = androidx.camera.camera2.internal.ProcessingCaptureSession.ProcessorState.UNINITIALIZED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4990a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.camera2.internal.ProcessingCaptureSession$ProcessorState r1 = androidx.camera.camera2.internal.ProcessingCaptureSession.ProcessorState.SESSION_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4990a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.camera2.internal.ProcessingCaptureSession$ProcessorState r1 = androidx.camera.camera2.internal.ProcessingCaptureSession.ProcessorState.ON_CAPTURE_SESSION_STARTED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4990a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.camera.camera2.internal.ProcessingCaptureSession$ProcessorState r1 = androidx.camera.camera2.internal.ProcessingCaptureSession.ProcessorState.ON_CAPTURE_SESSION_ENDED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f4990a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.camera.camera2.internal.ProcessingCaptureSession$ProcessorState r1 = androidx.camera.camera2.internal.ProcessingCaptureSession.ProcessorState.DE_INITIALIZED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.ProcessingCaptureSession.d.<clinit>():void");
        }
    }

    public static class e implements SessionProcessor.CaptureCallback {
        public void onCaptureCompleted(long j11, int i11, Map<CaptureResult.Key, Object> map) {
        }

        public void onCaptureFailed(int i11) {
        }

        public void onCaptureProcessStarted(int i11) {
        }

        public void onCaptureSequenceAborted(int i11) {
        }

        public void onCaptureSequenceCompleted(int i11) {
        }

        public void onCaptureStarted(int i11, long j11) {
        }
    }

    public ProcessingCaptureSession(SessionProcessor sessionProcessor, s0 s0Var, p.b bVar, Executor executor, ScheduledExecutorService scheduledExecutorService) {
        this.f4973e = new CaptureSession(bVar);
        this.f4969a = sessionProcessor;
        this.f4970b = s0Var;
        this.f4971c = executor;
        this.f4972d = scheduledExecutorService;
        this.f4978j = ProcessorState.UNINITIALIZED;
        this.f4981m = new e();
        int i11 = f4968r;
        f4968r = i11 + 1;
        this.f4984p = i11;
        Logger.d("ProcessingCaptureSession", "New ProcessingCaptureSession (id=" + this.f4984p + ")");
    }

    public static void m(List<CaptureConfig> list) {
        for (CaptureConfig cameraCaptureCallbacks : list) {
            for (CameraCaptureCallback onCaptureCancelled : cameraCaptureCallbacks.getCameraCaptureCallbacks()) {
                onCaptureCancelled.onCaptureCancelled();
            }
        }
    }

    public static List<SessionProcessorSurface> n(List<DeferrableSurface> list) {
        ArrayList arrayList = new ArrayList();
        for (DeferrableSurface next : list) {
            h.b(next instanceof SessionProcessorSurface, "Surface must be SessionProcessorSurface");
            arrayList.add((SessionProcessorSurface) next);
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void r() {
        DeferrableSurfaces.decrementAll(this.f4974f);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ ListenableFuture t(SessionConfig sessionConfig, CameraDevice cameraDevice, b4 b4Var, List list) throws Exception {
        Logger.d("ProcessingCaptureSession", "-- getSurfaces done, start init (id=" + this.f4984p + ")");
        if (this.f4978j == ProcessorState.DE_INITIALIZED) {
            return Futures.immediateFailedFuture(new IllegalStateException("SessionProcessorCaptureSession is closed."));
        }
        OutputSurface outputSurface = null;
        if (list.contains((Object) null)) {
            return Futures.immediateFailedFuture(new DeferrableSurface.SurfaceClosedException("Surface closed", sessionConfig.getSurfaces().get(list.indexOf((Object) null))));
        }
        OutputSurface outputSurface2 = null;
        OutputSurface outputSurface3 = null;
        for (int i11 = 0; i11 < sessionConfig.getSurfaces().size(); i11++) {
            DeferrableSurface deferrableSurface = sessionConfig.getSurfaces().get(i11);
            if (Objects.equals(deferrableSurface.getContainerClass(), Preview.class)) {
                outputSurface = OutputSurface.create(deferrableSurface.getSurface().get(), new Size(deferrableSurface.getPrescribedSize().getWidth(), deferrableSurface.getPrescribedSize().getHeight()), deferrableSurface.getPrescribedStreamFormat());
            } else if (Objects.equals(deferrableSurface.getContainerClass(), ImageCapture.class)) {
                outputSurface2 = OutputSurface.create(deferrableSurface.getSurface().get(), new Size(deferrableSurface.getPrescribedSize().getWidth(), deferrableSurface.getPrescribedSize().getHeight()), deferrableSurface.getPrescribedStreamFormat());
            } else if (Objects.equals(deferrableSurface.getContainerClass(), ImageAnalysis.class)) {
                outputSurface3 = OutputSurface.create(deferrableSurface.getSurface().get(), new Size(deferrableSurface.getPrescribedSize().getWidth(), deferrableSurface.getPrescribedSize().getHeight()), deferrableSurface.getPrescribedStreamFormat());
            }
        }
        this.f4978j = ProcessorState.SESSION_INITIALIZED;
        try {
            DeferrableSurfaces.incrementAll(this.f4974f);
            Logger.w("ProcessingCaptureSession", "== initSession (id=" + this.f4984p + ")");
            try {
                SessionConfig initSession = this.f4969a.initSession(this.f4970b, outputSurface, outputSurface2, outputSurface3);
                this.f4977i = initSession;
                initSession.getSurfaces().get(0).getTerminationFuture().addListener(new h3(this), CameraXExecutors.directExecutor());
                for (DeferrableSurface next : this.f4977i.getSurfaces()) {
                    f4967q.add(next);
                    next.getTerminationFuture().addListener(new j3(next), this.f4971c);
                }
                SessionConfig.ValidatingBuilder validatingBuilder = new SessionConfig.ValidatingBuilder();
                validatingBuilder.add(sessionConfig);
                validatingBuilder.clearSurfaces();
                validatingBuilder.add(this.f4977i);
                h.b(validatingBuilder.isValid(), "Cannot transform the SessionConfig");
                ListenableFuture<Void> f11 = this.f4973e.f(validatingBuilder.build(), (CameraDevice) h.g(cameraDevice), b4Var);
                Futures.addCallback(f11, new a(), this.f4971c);
                return f11;
            } catch (Throwable th2) {
                DeferrableSurfaces.decrementAll(this.f4974f);
                throw th2;
            }
        } catch (DeferrableSurface.SurfaceClosedException e11) {
            return Futures.immediateFailedFuture(e11);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Void u(Void voidR) {
        w(this.f4973e);
        return null;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v() {
        Logger.d("ProcessingCaptureSession", "== deInitSession (id=" + this.f4984p + ")");
        this.f4969a.deInitSession();
    }

    public ListenableFuture<Void> a(boolean z11) {
        Logger.d("ProcessingCaptureSession", "release (id=" + this.f4984p + ") mProcessorState=" + this.f4978j);
        ListenableFuture<Void> a11 = this.f4973e.a(z11);
        int i11 = d.f4990a[this.f4978j.ordinal()];
        if (i11 == 2 || i11 == 4) {
            a11.addListener(new i3(this), CameraXExecutors.directExecutor());
        }
        this.f4978j = ProcessorState.DE_INITIALIZED;
        return a11;
    }

    public void b(SessionConfig sessionConfig) {
        Logger.d("ProcessingCaptureSession", "setSessionConfig (id=" + this.f4984p + ")");
        this.f4975g = sessionConfig;
        if (sessionConfig != null) {
            n1 n1Var = this.f4976h;
            if (n1Var != null) {
                n1Var.f(sessionConfig);
            }
            if (this.f4978j == ProcessorState.ON_CAPTURE_SESSION_STARTED) {
                CaptureRequestOptions b11 = CaptureRequestOptions.Builder.c(sessionConfig.getImplementationOptions()).build();
                this.f4982n = b11;
                x(b11, this.f4983o);
                if (!o(sessionConfig.getRepeatingCaptureConfig())) {
                    this.f4969a.stopRepeating();
                } else {
                    this.f4969a.startRepeating(this.f4981m);
                }
            }
        }
    }

    public void c(List<CaptureConfig> list) {
        if (!list.isEmpty()) {
            Logger.d("ProcessingCaptureSession", "issueCaptureRequests (id=" + this.f4984p + ") + state =" + this.f4978j);
            int i11 = d.f4990a[this.f4978j.ordinal()];
            if (i11 == 1 || i11 == 2) {
                this.f4979k = list;
            } else if (i11 == 3) {
                for (CaptureConfig next : list) {
                    if (next.getTemplateType() == 2) {
                        p(next);
                    } else {
                        q(next);
                    }
                }
            } else if (i11 == 4 || i11 == 5) {
                Logger.d("ProcessingCaptureSession", "Run issueCaptureRequests in wrong state, state = " + this.f4978j);
                m(list);
            }
        }
    }

    public void close() {
        Logger.d("ProcessingCaptureSession", "close (id=" + this.f4984p + ") state=" + this.f4978j);
        if (this.f4978j == ProcessorState.ON_CAPTURE_SESSION_STARTED) {
            Logger.d("ProcessingCaptureSession", "== onCaptureSessionEnd (id = " + this.f4984p + ")");
            this.f4969a.onCaptureSessionEnd();
            n1 n1Var = this.f4976h;
            if (n1Var != null) {
                n1Var.b();
            }
            this.f4978j = ProcessorState.ON_CAPTURE_SESSION_ENDED;
        }
        this.f4973e.close();
    }

    public void d() {
        Logger.d("ProcessingCaptureSession", "cancelIssuedCaptureRequests (id=" + this.f4984p + ")");
        if (this.f4979k != null) {
            for (CaptureConfig cameraCaptureCallbacks : this.f4979k) {
                for (CameraCaptureCallback onCaptureCancelled : cameraCaptureCallbacks.getCameraCaptureCallbacks()) {
                    onCaptureCancelled.onCaptureCancelled();
                }
            }
            this.f4979k = null;
        }
    }

    public List<CaptureConfig> e() {
        return this.f4979k != null ? this.f4979k : Collections.emptyList();
    }

    public ListenableFuture<Void> f(SessionConfig sessionConfig, CameraDevice cameraDevice, b4 b4Var) {
        boolean z11 = this.f4978j == ProcessorState.UNINITIALIZED;
        h.b(z11, "Invalid state state:" + this.f4978j);
        h.b(sessionConfig.getSurfaces().isEmpty() ^ true, "SessionConfig contains no surfaces");
        Logger.d("ProcessingCaptureSession", "open (id=" + this.f4984p + ")");
        List<DeferrableSurface> surfaces = sessionConfig.getSurfaces();
        this.f4974f = surfaces;
        return FutureChain.from(DeferrableSurfaces.surfaceListWithTimeout(surfaces, false, 5000, this.f4971c, this.f4972d)).transformAsync(new g3(this, sessionConfig, cameraDevice, b4Var), this.f4971c).transform(new f3(this), this.f4971c);
    }

    public void g(Map<DeferrableSurface, Long> map) {
    }

    public SessionConfig getSessionConfig() {
        return this.f4975g;
    }

    public final boolean o(CaptureConfig captureConfig) {
        for (DeferrableSurface containerClass : captureConfig.getSurfaces()) {
            if (Objects.equals(containerClass.getContainerClass(), Preview.class)) {
                return true;
            }
        }
        return false;
    }

    public void p(CaptureConfig captureConfig) {
        CaptureRequestOptions.Builder c11 = CaptureRequestOptions.Builder.c(captureConfig.getImplementationOptions());
        Config implementationOptions = captureConfig.getImplementationOptions();
        Config.Option<Integer> option = CaptureConfig.OPTION_ROTATION;
        if (implementationOptions.containsOption(option)) {
            c11.e(CaptureRequest.JPEG_ORIENTATION, (Integer) captureConfig.getImplementationOptions().retrieveOption(option));
        }
        Config implementationOptions2 = captureConfig.getImplementationOptions();
        Config.Option<Integer> option2 = CaptureConfig.OPTION_JPEG_QUALITY;
        if (implementationOptions2.containsOption(option2)) {
            c11.e(CaptureRequest.JPEG_QUALITY, Byte.valueOf(((Integer) captureConfig.getImplementationOptions().retrieveOption(option2)).byteValue()));
        }
        CaptureRequestOptions b11 = c11.build();
        this.f4983o = b11;
        x(this.f4982n, b11);
        this.f4969a.startCapture(new c(captureConfig));
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:0x0041 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:3:0x0023  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void q(androidx.camera.core.impl.CaptureConfig r7) {
        /*
            r6 = this;
            java.lang.String r0 = "ProcessingCaptureSession"
            java.lang.String r1 = "issueTriggerRequest"
            androidx.camera.core.Logger.d(r0, r1)
            androidx.camera.core.impl.Config r0 = r7.getImplementationOptions()
            androidx.camera.camera2.interop.CaptureRequestOptions$Builder r0 = androidx.camera.camera2.interop.CaptureRequestOptions.Builder.c(r0)
            androidx.camera.camera2.interop.CaptureRequestOptions r0 = r0.build()
            java.util.Set r1 = r0.listOptions()
            java.util.Iterator r1 = r1.iterator()
        L_0x001b:
            boolean r2 = r1.hasNext()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x0041
            java.lang.Object r2 = r1.next()
            androidx.camera.core.impl.Config$Option r2 = (androidx.camera.core.impl.Config.Option) r2
            java.lang.Object r2 = r2.getToken()
            android.hardware.camera2.CaptureRequest$Key r2 = (android.hardware.camera2.CaptureRequest.Key) r2
            android.hardware.camera2.CaptureRequest$Key r5 = android.hardware.camera2.CaptureRequest.CONTROL_AF_TRIGGER
            boolean r5 = r2.equals(r5)
            if (r5 != 0) goto L_0x003f
            android.hardware.camera2.CaptureRequest$Key r5 = android.hardware.camera2.CaptureRequest.CONTROL_AE_PRECAPTURE_TRIGGER
            boolean r2 = r2.equals(r5)
            if (r2 == 0) goto L_0x001b
        L_0x003f:
            r1 = r3
            goto L_0x0042
        L_0x0041:
            r1 = r4
        L_0x0042:
            if (r1 != 0) goto L_0x0050
            androidx.camera.core.impl.CaptureConfig[] r0 = new androidx.camera.core.impl.CaptureConfig[r3]
            r0[r4] = r7
            java.util.List r7 = java.util.Arrays.asList(r0)
            m(r7)
            return
        L_0x0050:
            androidx.camera.core.impl.SessionProcessor r1 = r6.f4969a
            androidx.camera.camera2.internal.ProcessingCaptureSession$b r2 = new androidx.camera.camera2.internal.ProcessingCaptureSession$b
            r2.<init>(r7)
            r1.startTrigger(r0, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.ProcessingCaptureSession.q(androidx.camera.core.impl.CaptureConfig):void");
    }

    public void w(CaptureSession captureSession) {
        boolean z11 = this.f4978j == ProcessorState.SESSION_INITIALIZED;
        h.b(z11, "Invalid state state:" + this.f4978j);
        this.f4976h = new n1(captureSession, n(this.f4977i.getSurfaces()));
        Logger.d("ProcessingCaptureSession", "== onCaptureSessinStarted (id = " + this.f4984p + ")");
        this.f4969a.onCaptureSessionStart(this.f4976h);
        this.f4978j = ProcessorState.ON_CAPTURE_SESSION_STARTED;
        SessionConfig sessionConfig = this.f4975g;
        if (sessionConfig != null) {
            b(sessionConfig);
        }
        if (this.f4979k != null) {
            c(this.f4979k);
            this.f4979k = null;
        }
    }

    public final void x(CaptureRequestOptions captureRequestOptions, CaptureRequestOptions captureRequestOptions2) {
        Camera2ImplConfig.Builder builder = new Camera2ImplConfig.Builder();
        builder.b(captureRequestOptions);
        builder.b(captureRequestOptions2);
        this.f4969a.setParameters(builder.build());
    }
}
