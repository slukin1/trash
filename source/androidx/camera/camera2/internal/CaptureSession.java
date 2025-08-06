package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.TotalCaptureResult;
import android.hardware.camera2.params.DynamicRangeProfiles;
import android.os.Build;
import android.view.Surface;
import androidx.camera.camera2.internal.SynchronizedCaptureSession;
import androidx.camera.camera2.internal.compat.workaround.StillCaptureFlow;
import androidx.camera.camera2.internal.compat.workaround.TorchStateReset;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.MutableOptionsBundle;
import androidx.camera.core.impl.OptionsBundle;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.CancellationException;
import p.f;

public final class CaptureSession implements c2 {

    /* renamed from: a  reason: collision with root package name */
    public final Object f4944a;

    /* renamed from: b  reason: collision with root package name */
    public final List<CaptureConfig> f4945b;

    /* renamed from: c  reason: collision with root package name */
    public final CameraCaptureSession.CaptureCallback f4946c;

    /* renamed from: d  reason: collision with root package name */
    public final e f4947d;

    /* renamed from: e  reason: collision with root package name */
    public b4 f4948e;

    /* renamed from: f  reason: collision with root package name */
    public SynchronizedCaptureSession f4949f;

    /* renamed from: g  reason: collision with root package name */
    public SessionConfig f4950g;

    /* renamed from: h  reason: collision with root package name */
    public Config f4951h;

    /* renamed from: i  reason: collision with root package name */
    public n.b f4952i;

    /* renamed from: j  reason: collision with root package name */
    public final Map<DeferrableSurface, Surface> f4953j;

    /* renamed from: k  reason: collision with root package name */
    public List<DeferrableSurface> f4954k;

    /* renamed from: l  reason: collision with root package name */
    public State f4955l;

    /* renamed from: m  reason: collision with root package name */
    public ListenableFuture<Void> f4956m;

    /* renamed from: n  reason: collision with root package name */
    public CallbackToFutureAdapter.a<Void> f4957n;

    /* renamed from: o  reason: collision with root package name */
    public Map<DeferrableSurface, Long> f4958o;

    /* renamed from: p  reason: collision with root package name */
    public final StillCaptureFlow f4959p;

    /* renamed from: q  reason: collision with root package name */
    public final TorchStateReset f4960q;

    /* renamed from: r  reason: collision with root package name */
    public final p.b f4961r;

    public enum State {
        UNINITIALIZED,
        INITIALIZED,
        GET_SURFACE,
        OPENING,
        OPENED,
        CLOSED,
        RELEASING,
        RELEASED
    }

    public class a extends CameraCaptureSession.CaptureCallback {
        public a() {
        }

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
        }
    }

    public class b implements FutureCallback<Void> {
        public b() {
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
        }

        public void onFailure(Throwable th2) {
            synchronized (CaptureSession.this.f4944a) {
                CaptureSession.this.f4948e.e();
                int i11 = d.f4965a[CaptureSession.this.f4955l.ordinal()];
                if (i11 == 4 || i11 == 6 || i11 == 7) {
                    if (!(th2 instanceof CancellationException)) {
                        Logger.w("CaptureSession", "Opening session with fail " + CaptureSession.this.f4955l, th2);
                        CaptureSession.this.m();
                    }
                }
            }
        }
    }

    public class c extends CameraCaptureSession.CaptureCallback {
        public c() {
        }

        public void onCaptureCompleted(CameraCaptureSession cameraCaptureSession, CaptureRequest captureRequest, TotalCaptureResult totalCaptureResult) {
            synchronized (CaptureSession.this.f4944a) {
                SessionConfig sessionConfig = CaptureSession.this.f4950g;
                if (sessionConfig != null) {
                    CaptureConfig repeatingCaptureConfig = sessionConfig.getRepeatingCaptureConfig();
                    Logger.d("CaptureSession", "Submit FLASH_MODE_OFF request");
                    CaptureSession captureSession = CaptureSession.this;
                    captureSession.c(Collections.singletonList(captureSession.f4960q.a(repeatingCaptureConfig)));
                }
            }
        }
    }

    public static /* synthetic */ class d {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f4965a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|18) */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.camera.camera2.internal.CaptureSession$State[] r0 = androidx.camera.camera2.internal.CaptureSession.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4965a = r0
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.UNINITIALIZED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4965a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4965a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.GET_SURFACE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4965a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.OPENING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f4965a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.OPENED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f4965a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.CLOSED     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f4965a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.RELEASING     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f4965a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.camera.camera2.internal.CaptureSession$State r1 = androidx.camera.camera2.internal.CaptureSession.State.RELEASED     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.CaptureSession.d.<clinit>():void");
        }
    }

    public final class e extends SynchronizedCaptureSession.StateCallback {
        public e() {
        }

        public void o(SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.f4944a) {
                switch (d.f4965a[CaptureSession.this.f4955l.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                        throw new IllegalStateException("onConfigureFailed() should not be possible in state: " + CaptureSession.this.f4955l);
                    case 4:
                    case 6:
                    case 7:
                        CaptureSession.this.m();
                        break;
                    case 8:
                        Logger.d("CaptureSession", "ConfigureFailed callback after change to RELEASED state");
                        break;
                }
                Logger.e("CaptureSession", "CameraCaptureSession.onConfigureFailed() " + CaptureSession.this.f4955l);
            }
        }

        public void p(SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.f4944a) {
                switch (d.f4965a[CaptureSession.this.f4955l.ordinal()]) {
                    case 1:
                    case 2:
                    case 3:
                    case 5:
                    case 8:
                        throw new IllegalStateException("onConfigured() should not be possible in state: " + CaptureSession.this.f4955l);
                    case 4:
                        CaptureSession captureSession = CaptureSession.this;
                        captureSession.f4955l = State.OPENED;
                        captureSession.f4949f = synchronizedCaptureSession;
                        if (captureSession.f4950g != null) {
                            List<CaptureConfig> c11 = captureSession.f4952i.a().c();
                            if (!c11.isEmpty()) {
                                CaptureSession captureSession2 = CaptureSession.this;
                                captureSession2.p(captureSession2.x(c11));
                            }
                        }
                        Logger.d("CaptureSession", "Attempting to send capture request onConfigured");
                        CaptureSession captureSession3 = CaptureSession.this;
                        captureSession3.r(captureSession3.f4950g);
                        CaptureSession.this.q();
                        break;
                    case 6:
                        CaptureSession.this.f4949f = synchronizedCaptureSession;
                        break;
                    case 7:
                        synchronizedCaptureSession.close();
                        break;
                }
                Logger.d("CaptureSession", "CameraCaptureSession.onConfigured() mState=" + CaptureSession.this.f4955l);
            }
        }

        public void q(SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.f4944a) {
                if (d.f4965a[CaptureSession.this.f4955l.ordinal()] != 1) {
                    Logger.d("CaptureSession", "CameraCaptureSession.onReady() " + CaptureSession.this.f4955l);
                } else {
                    throw new IllegalStateException("onReady() should not be possible in state: " + CaptureSession.this.f4955l);
                }
            }
        }

        public void r(SynchronizedCaptureSession synchronizedCaptureSession) {
            synchronized (CaptureSession.this.f4944a) {
                if (CaptureSession.this.f4955l != State.UNINITIALIZED) {
                    Logger.d("CaptureSession", "onSessionFinished()");
                    CaptureSession.this.m();
                } else {
                    throw new IllegalStateException("onSessionFinished() should not be possible in state: " + CaptureSession.this.f4955l);
                }
            }
        }
    }

    public CaptureSession(p.b bVar) {
        this.f4944a = new Object();
        this.f4945b = new ArrayList();
        this.f4946c = new a();
        this.f4951h = OptionsBundle.emptyBundle();
        this.f4952i = n.b.b();
        this.f4953j = new HashMap();
        this.f4954k = Collections.emptyList();
        this.f4955l = State.UNINITIALIZED;
        this.f4958o = new HashMap();
        this.f4959p = new StillCaptureFlow();
        this.f4960q = new TorchStateReset();
        this.f4955l = State.INITIALIZED;
        this.f4961r = bVar;
        this.f4947d = new e();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void s(CameraCaptureSession cameraCaptureSession, int i11, boolean z11) {
        synchronized (this.f4944a) {
            if (this.f4955l == State.OPENED) {
                r(this.f4950g);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object u(CallbackToFutureAdapter.a aVar) throws Exception {
        String str;
        synchronized (this.f4944a) {
            h.j(this.f4957n == null, "Release completer expected to be null");
            this.f4957n = aVar;
            str = "Release[session=" + this + "]";
        }
        return str;
    }

    public static Config v(List<CaptureConfig> list) {
        MutableOptionsBundle create = MutableOptionsBundle.create();
        for (CaptureConfig implementationOptions : list) {
            Config implementationOptions2 = implementationOptions.getImplementationOptions();
            for (Config.Option next : implementationOptions2.listOptions()) {
                Object retrieveOption = implementationOptions2.retrieveOption(next, null);
                if (create.containsOption(next)) {
                    Object retrieveOption2 = create.retrieveOption(next, null);
                    if (!Objects.equals(retrieveOption2, retrieveOption)) {
                        Logger.d("CaptureSession", "Detect conflicting option " + next.getId() + " : " + retrieveOption + " != " + retrieveOption2);
                    }
                } else {
                    create.insertOption(next, retrieveOption);
                }
            }
        }
        return create;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0029, code lost:
        r3.f4952i.a().a();
        r3.f4955l = androidx.camera.camera2.internal.CaptureSession.State.RELEASING;
        r4 = r3.f4948e;
        androidx.core.util.h.h(r4, "The Opener shouldn't null in state:" + r3.f4955l);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0054, code lost:
        if (r3.f4948e.e() == false) goto L_0x005a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0056, code lost:
        m();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x005c, code lost:
        if (r3.f4956m != null) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005e, code lost:
        r3.f4956m = androidx.concurrent.futures.CallbackToFutureAdapter.a(new androidx.camera.camera2.internal.b2(r3));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0069, code lost:
        r4 = r3.f4956m;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x006c, code lost:
        return r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x008a, code lost:
        r3.f4955l = androidx.camera.camera2.internal.CaptureSession.State.RELEASED;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00ae, code lost:
        return androidx.camera.core.impl.utils.futures.Futures.immediateFuture(null);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.google.common.util.concurrent.ListenableFuture<java.lang.Void> a(boolean r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f4944a
            monitor-enter(r0)
            int[] r1 = androidx.camera.camera2.internal.CaptureSession.d.f4965a     // Catch:{ all -> 0x00af }
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.f4955l     // Catch:{ all -> 0x00af }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x00af }
            r1 = r1[r2]     // Catch:{ all -> 0x00af }
            switch(r1) {
                case 1: goto L_0x008f;
                case 2: goto L_0x008a;
                case 3: goto L_0x006d;
                case 4: goto L_0x0029;
                case 5: goto L_0x0012;
                case 6: goto L_0x0012;
                case 7: goto L_0x005a;
                default: goto L_0x0010;
            }     // Catch:{ all -> 0x00af }
        L_0x0010:
            goto L_0x00a8
        L_0x0012:
            androidx.camera.camera2.internal.SynchronizedCaptureSession r1 = r3.f4949f     // Catch:{ all -> 0x00af }
            if (r1 == 0) goto L_0x0029
            if (r4 == 0) goto L_0x0024
            r1.abortCaptures()     // Catch:{ CameraAccessException -> 0x001c }
            goto L_0x0024
        L_0x001c:
            r4 = move-exception
            java.lang.String r1 = "CaptureSession"
            java.lang.String r2 = "Unable to abort captures."
            androidx.camera.core.Logger.e(r1, r2, r4)     // Catch:{ all -> 0x00af }
        L_0x0024:
            androidx.camera.camera2.internal.SynchronizedCaptureSession r4 = r3.f4949f     // Catch:{ all -> 0x00af }
            r4.close()     // Catch:{ all -> 0x00af }
        L_0x0029:
            n.b r4 = r3.f4952i     // Catch:{ all -> 0x00af }
            n.b$a r4 = r4.a()     // Catch:{ all -> 0x00af }
            r4.a()     // Catch:{ all -> 0x00af }
            androidx.camera.camera2.internal.CaptureSession$State r4 = androidx.camera.camera2.internal.CaptureSession.State.RELEASING     // Catch:{ all -> 0x00af }
            r3.f4955l = r4     // Catch:{ all -> 0x00af }
            androidx.camera.camera2.internal.b4 r4 = r3.f4948e     // Catch:{ all -> 0x00af }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00af }
            r1.<init>()     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "The Opener shouldn't null in state:"
            r1.append(r2)     // Catch:{ all -> 0x00af }
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.f4955l     // Catch:{ all -> 0x00af }
            r1.append(r2)     // Catch:{ all -> 0x00af }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00af }
            androidx.core.util.h.h(r4, r1)     // Catch:{ all -> 0x00af }
            androidx.camera.camera2.internal.b4 r4 = r3.f4948e     // Catch:{ all -> 0x00af }
            boolean r4 = r4.e()     // Catch:{ all -> 0x00af }
            if (r4 == 0) goto L_0x005a
            r3.m()     // Catch:{ all -> 0x00af }
            goto L_0x00a8
        L_0x005a:
            com.google.common.util.concurrent.ListenableFuture<java.lang.Void> r4 = r3.f4956m     // Catch:{ all -> 0x00af }
            if (r4 != 0) goto L_0x0069
            androidx.camera.camera2.internal.b2 r4 = new androidx.camera.camera2.internal.b2     // Catch:{ all -> 0x00af }
            r4.<init>(r3)     // Catch:{ all -> 0x00af }
            com.google.common.util.concurrent.ListenableFuture r4 = androidx.concurrent.futures.CallbackToFutureAdapter.a(r4)     // Catch:{ all -> 0x00af }
            r3.f4956m = r4     // Catch:{ all -> 0x00af }
        L_0x0069:
            com.google.common.util.concurrent.ListenableFuture<java.lang.Void> r4 = r3.f4956m     // Catch:{ all -> 0x00af }
            monitor-exit(r0)     // Catch:{ all -> 0x00af }
            return r4
        L_0x006d:
            androidx.camera.camera2.internal.b4 r4 = r3.f4948e     // Catch:{ all -> 0x00af }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00af }
            r1.<init>()     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "The Opener shouldn't null in state:"
            r1.append(r2)     // Catch:{ all -> 0x00af }
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.f4955l     // Catch:{ all -> 0x00af }
            r1.append(r2)     // Catch:{ all -> 0x00af }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00af }
            androidx.core.util.h.h(r4, r1)     // Catch:{ all -> 0x00af }
            androidx.camera.camera2.internal.b4 r4 = r3.f4948e     // Catch:{ all -> 0x00af }
            r4.e()     // Catch:{ all -> 0x00af }
        L_0x008a:
            androidx.camera.camera2.internal.CaptureSession$State r4 = androidx.camera.camera2.internal.CaptureSession.State.RELEASED     // Catch:{ all -> 0x00af }
            r3.f4955l = r4     // Catch:{ all -> 0x00af }
            goto L_0x00a8
        L_0x008f:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00af }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00af }
            r1.<init>()     // Catch:{ all -> 0x00af }
            java.lang.String r2 = "release() should not be possible in state: "
            r1.append(r2)     // Catch:{ all -> 0x00af }
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.f4955l     // Catch:{ all -> 0x00af }
            r1.append(r2)     // Catch:{ all -> 0x00af }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00af }
            r4.<init>(r1)     // Catch:{ all -> 0x00af }
            throw r4     // Catch:{ all -> 0x00af }
        L_0x00a8:
            monitor-exit(r0)     // Catch:{ all -> 0x00af }
            r4 = 0
            com.google.common.util.concurrent.ListenableFuture r4 = androidx.camera.core.impl.utils.futures.Futures.immediateFuture(r4)
            return r4
        L_0x00af:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00af }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.CaptureSession.a(boolean):com.google.common.util.concurrent.ListenableFuture");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0062, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void b(androidx.camera.core.impl.SessionConfig r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f4944a
            monitor-enter(r0)
            int[] r1 = androidx.camera.camera2.internal.CaptureSession.d.f4965a     // Catch:{ all -> 0x0063 }
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.f4955l     // Catch:{ all -> 0x0063 }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x0063 }
            r1 = r1[r2]     // Catch:{ all -> 0x0063 }
            switch(r1) {
                case 1: goto L_0x0048;
                case 2: goto L_0x0045;
                case 3: goto L_0x0045;
                case 4: goto L_0x0045;
                case 5: goto L_0x0019;
                case 6: goto L_0x0011;
                case 7: goto L_0x0011;
                case 8: goto L_0x0011;
                default: goto L_0x0010;
            }     // Catch:{ all -> 0x0063 }
        L_0x0010:
            goto L_0x0061
        L_0x0011:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0063 }
            java.lang.String r1 = "Session configuration cannot be set on a closed/released session."
            r4.<init>(r1)     // Catch:{ all -> 0x0063 }
            throw r4     // Catch:{ all -> 0x0063 }
        L_0x0019:
            r3.f4950g = r4     // Catch:{ all -> 0x0063 }
            if (r4 != 0) goto L_0x001f
            monitor-exit(r0)     // Catch:{ all -> 0x0063 }
            return
        L_0x001f:
            java.util.Map<androidx.camera.core.impl.DeferrableSurface, android.view.Surface> r1 = r3.f4953j     // Catch:{ all -> 0x0063 }
            java.util.Set r1 = r1.keySet()     // Catch:{ all -> 0x0063 }
            java.util.List r4 = r4.getSurfaces()     // Catch:{ all -> 0x0063 }
            boolean r4 = r1.containsAll(r4)     // Catch:{ all -> 0x0063 }
            if (r4 != 0) goto L_0x0038
            java.lang.String r4 = "CaptureSession"
            java.lang.String r1 = "Does not have the proper configured lists"
            androidx.camera.core.Logger.e(r4, r1)     // Catch:{ all -> 0x0063 }
            monitor-exit(r0)     // Catch:{ all -> 0x0063 }
            return
        L_0x0038:
            java.lang.String r4 = "CaptureSession"
            java.lang.String r1 = "Attempting to submit CaptureRequest after setting"
            androidx.camera.core.Logger.d(r4, r1)     // Catch:{ all -> 0x0063 }
            androidx.camera.core.impl.SessionConfig r4 = r3.f4950g     // Catch:{ all -> 0x0063 }
            r3.r(r4)     // Catch:{ all -> 0x0063 }
            goto L_0x0061
        L_0x0045:
            r3.f4950g = r4     // Catch:{ all -> 0x0063 }
            goto L_0x0061
        L_0x0048:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0063 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0063 }
            r1.<init>()     // Catch:{ all -> 0x0063 }
            java.lang.String r2 = "setSessionConfig() should not be possible in state: "
            r1.append(r2)     // Catch:{ all -> 0x0063 }
            androidx.camera.camera2.internal.CaptureSession$State r2 = r3.f4955l     // Catch:{ all -> 0x0063 }
            r1.append(r2)     // Catch:{ all -> 0x0063 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0063 }
            r4.<init>(r1)     // Catch:{ all -> 0x0063 }
            throw r4     // Catch:{ all -> 0x0063 }
        L_0x0061:
            monitor-exit(r0)     // Catch:{ all -> 0x0063 }
            return
        L_0x0063:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0063 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.CaptureSession.b(androidx.camera.core.impl.SessionConfig):void");
    }

    public void c(List<CaptureConfig> list) {
        synchronized (this.f4944a) {
            switch (d.f4965a[this.f4955l.ordinal()]) {
                case 1:
                    throw new IllegalStateException("issueCaptureRequests() should not be possible in state: " + this.f4955l);
                case 2:
                case 3:
                case 4:
                    this.f4945b.addAll(list);
                    break;
                case 5:
                    this.f4945b.addAll(list);
                    q();
                    break;
                case 6:
                case 7:
                case 8:
                    throw new IllegalStateException("Cannot issue capture request on a closed/released session.");
            }
        }
    }

    public void close() {
        synchronized (this.f4944a) {
            int i11 = d.f4965a[this.f4955l.ordinal()];
            if (i11 != 1) {
                if (i11 != 2) {
                    if (i11 != 3) {
                        if (i11 != 4) {
                            if (i11 == 5) {
                                if (this.f4950g != null) {
                                    List<CaptureConfig> b11 = this.f4952i.a().b();
                                    if (!b11.isEmpty()) {
                                        try {
                                            c(x(b11));
                                        } catch (IllegalStateException e11) {
                                            Logger.e("CaptureSession", "Unable to issue the request before close the capture session", e11);
                                        }
                                    }
                                }
                            }
                        }
                        b4 b4Var = this.f4948e;
                        h.h(b4Var, "The Opener shouldn't null in state:" + this.f4955l);
                        this.f4948e.e();
                        this.f4955l = State.CLOSED;
                        this.f4950g = null;
                    } else {
                        b4 b4Var2 = this.f4948e;
                        h.h(b4Var2, "The Opener shouldn't null in state:" + this.f4955l);
                        this.f4948e.e();
                    }
                }
                this.f4955l = State.RELEASED;
            } else {
                throw new IllegalStateException("close() should not be possible in state: " + this.f4955l);
            }
        }
    }

    public void d() {
        ArrayList<CaptureConfig> arrayList;
        synchronized (this.f4944a) {
            if (!this.f4945b.isEmpty()) {
                arrayList = new ArrayList<>(this.f4945b);
                this.f4945b.clear();
            } else {
                arrayList = null;
            }
        }
        if (arrayList != null) {
            for (CaptureConfig cameraCaptureCallbacks : arrayList) {
                for (CameraCaptureCallback onCaptureCancelled : cameraCaptureCallbacks.getCameraCaptureCallbacks()) {
                    onCaptureCancelled.onCaptureCancelled();
                }
            }
        }
    }

    public List<CaptureConfig> e() {
        List<CaptureConfig> unmodifiableList;
        synchronized (this.f4944a) {
            unmodifiableList = Collections.unmodifiableList(this.f4945b);
        }
        return unmodifiableList;
    }

    public ListenableFuture<Void> f(SessionConfig sessionConfig, CameraDevice cameraDevice, b4 b4Var) {
        synchronized (this.f4944a) {
            if (d.f4965a[this.f4955l.ordinal()] != 2) {
                Logger.e("CaptureSession", "Open not allowed in state: " + this.f4955l);
                ListenableFuture<Void> immediateFailedFuture = Futures.immediateFailedFuture(new IllegalStateException("open() should not allow the state: " + this.f4955l));
                return immediateFailedFuture;
            }
            this.f4955l = State.GET_SURFACE;
            ArrayList arrayList = new ArrayList(sessionConfig.getSurfaces());
            this.f4954k = arrayList;
            this.f4948e = b4Var;
            FutureChain<T> transformAsync = FutureChain.from(b4Var.d(arrayList, 5000)).transformAsync(new a2(this, sessionConfig, cameraDevice), this.f4948e.b());
            Futures.addCallback(transformAsync, new b(), this.f4948e.b());
            ListenableFuture<Void> nonCancellationPropagating = Futures.nonCancellationPropagating(transformAsync);
            return nonCancellationPropagating;
        }
    }

    public void g(Map<DeferrableSurface, Long> map) {
        synchronized (this.f4944a) {
            this.f4958o = map;
        }
    }

    public SessionConfig getSessionConfig() {
        SessionConfig sessionConfig;
        synchronized (this.f4944a) {
            sessionConfig = this.f4950g;
        }
        return sessionConfig;
    }

    public void k() {
        synchronized (this.f4944a) {
            if (this.f4955l != State.OPENED) {
                Logger.e("CaptureSession", "Unable to abort captures. Incorrect state:" + this.f4955l);
                return;
            }
            try {
                this.f4949f.abortCaptures();
            } catch (CameraAccessException e11) {
                Logger.e("CaptureSession", "Unable to abort captures.", e11);
            }
        }
    }

    public final CameraCaptureSession.CaptureCallback l(List<CameraCaptureCallback> list, CameraCaptureSession.CaptureCallback... captureCallbackArr) {
        ArrayList arrayList = new ArrayList(list.size() + captureCallbackArr.length);
        for (CameraCaptureCallback a11 : list) {
            arrayList.add(y1.a(a11));
        }
        Collections.addAll(arrayList, captureCallbackArr);
        return t0.a(arrayList);
    }

    public void m() {
        State state = this.f4955l;
        State state2 = State.RELEASED;
        if (state == state2) {
            Logger.d("CaptureSession", "Skipping finishClose due to being state RELEASED.");
            return;
        }
        this.f4955l = state2;
        this.f4949f = null;
        CallbackToFutureAdapter.a<Void> aVar = this.f4957n;
        if (aVar != null) {
            aVar.c(null);
            this.f4957n = null;
        }
    }

    public final f n(SessionConfig.OutputConfig outputConfig, Map<DeferrableSurface, Surface> map, String str) {
        DynamicRangeProfiles d11;
        Surface surface = map.get(outputConfig.getSurface());
        h.h(surface, "Surface in OutputConfig not found in configuredSurfaceMap.");
        f fVar = new f(outputConfig.getSurfaceGroupId(), surface);
        if (str != null) {
            fVar.f(str);
        } else {
            fVar.f(outputConfig.getPhysicalCameraId());
        }
        if (!outputConfig.getSharedSurfaces().isEmpty()) {
            fVar.b();
            for (DeferrableSurface deferrableSurface : outputConfig.getSharedSurfaces()) {
                Surface surface2 = map.get(deferrableSurface);
                h.h(surface2, "Surface in OutputConfig not found in configuredSurfaceMap.");
                fVar.a(surface2);
            }
        }
        long j11 = 1;
        if (Build.VERSION.SDK_INT >= 33 && (d11 = this.f4961r.d()) != null) {
            DynamicRange dynamicRange = outputConfig.getDynamicRange();
            Long a11 = p.a.a(dynamicRange, d11);
            if (a11 == null) {
                Logger.e("CaptureSession", "Requested dynamic range is not supported. Defaulting to STANDARD dynamic range profile.\nRequested dynamic range:\n  " + dynamicRange);
            } else {
                j11 = a11.longValue();
            }
        }
        fVar.e(j11);
        return fVar;
    }

    public final List<f> o(List<f> list) {
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        for (f next : list) {
            if (!arrayList.contains(next.d())) {
                arrayList.add(next.d());
                arrayList2.add(next);
            }
        }
        return arrayList2;
    }

    public int p(List<CaptureConfig> list) {
        boolean z11;
        synchronized (this.f4944a) {
            if (this.f4955l != State.OPENED) {
                Logger.d("CaptureSession", "Skipping issueBurstCaptureRequest due to session closed");
                return -1;
            } else if (list.isEmpty()) {
                return -1;
            } else {
                try {
                    q1 q1Var = new q1();
                    ArrayList arrayList = new ArrayList();
                    Logger.d("CaptureSession", "Issuing capture request.");
                    boolean z12 = false;
                    for (CaptureConfig next : list) {
                        if (next.getSurfaces().isEmpty()) {
                            Logger.d("CaptureSession", "Skipping issuing empty capture request.");
                        } else {
                            Iterator<DeferrableSurface> it2 = next.getSurfaces().iterator();
                            while (true) {
                                if (!it2.hasNext()) {
                                    z11 = true;
                                    break;
                                }
                                DeferrableSurface next2 = it2.next();
                                if (!this.f4953j.containsKey(next2)) {
                                    Logger.d("CaptureSession", "Skipping capture request with invalid surface: " + next2);
                                    z11 = false;
                                    break;
                                }
                            }
                            if (z11) {
                                if (next.getTemplateType() == 2) {
                                    z12 = true;
                                }
                                CaptureConfig.Builder from = CaptureConfig.Builder.from(next);
                                if (next.getTemplateType() == 5 && next.getCameraCaptureResult() != null) {
                                    from.setCameraCaptureResult(next.getCameraCaptureResult());
                                }
                                SessionConfig sessionConfig = this.f4950g;
                                if (sessionConfig != null) {
                                    from.addImplementationOptions(sessionConfig.getRepeatingCaptureConfig().getImplementationOptions());
                                }
                                from.addImplementationOptions(this.f4951h);
                                from.addImplementationOptions(next.getImplementationOptions());
                                CaptureRequest c11 = k1.c(from.build(), this.f4949f.d(), this.f4953j);
                                if (c11 == null) {
                                    Logger.d("CaptureSession", "Skipping issuing request without surface.");
                                    return -1;
                                }
                                ArrayList arrayList2 = new ArrayList();
                                for (CameraCaptureCallback b11 : next.getCameraCaptureCallbacks()) {
                                    y1.b(b11, arrayList2);
                                }
                                q1Var.a(c11, arrayList2);
                                arrayList.add(c11);
                            }
                        }
                    }
                    if (!arrayList.isEmpty()) {
                        if (this.f4959p.a(arrayList, z12)) {
                            this.f4949f.stopRepeating();
                            q1Var.c(new z1(this));
                        }
                        if (this.f4960q.b(arrayList, z12)) {
                            q1Var.a((CaptureRequest) arrayList.get(arrayList.size() - 1), Collections.singletonList(new c()));
                        }
                        int e11 = this.f4949f.e(arrayList, q1Var);
                        return e11;
                    }
                    Logger.d("CaptureSession", "Skipping issuing burst request due to no valid request elements");
                } catch (CameraAccessException e12) {
                    Logger.e("CaptureSession", "Unable to access camera: " + e12.getMessage());
                    Thread.dumpStack();
                }
            }
        }
        return -1;
    }

    public void q() {
        if (!this.f4945b.isEmpty()) {
            try {
                p(this.f4945b);
            } finally {
                this.f4945b.clear();
            }
        }
    }

    public int r(SessionConfig sessionConfig) {
        synchronized (this.f4944a) {
            if (sessionConfig == null) {
                Logger.d("CaptureSession", "Skipping issueRepeatingCaptureRequests for no configuration case.");
                return -1;
            } else if (this.f4955l != State.OPENED) {
                Logger.d("CaptureSession", "Skipping issueRepeatingCaptureRequests due to session closed");
                return -1;
            } else {
                CaptureConfig repeatingCaptureConfig = sessionConfig.getRepeatingCaptureConfig();
                if (repeatingCaptureConfig.getSurfaces().isEmpty()) {
                    Logger.d("CaptureSession", "Skipping issueRepeatingCaptureRequests for no surface.");
                    try {
                        this.f4949f.stopRepeating();
                    } catch (CameraAccessException e11) {
                        Logger.e("CaptureSession", "Unable to access camera: " + e11.getMessage());
                        Thread.dumpStack();
                    }
                } else {
                    try {
                        Logger.d("CaptureSession", "Issuing request for session.");
                        CaptureConfig.Builder from = CaptureConfig.Builder.from(repeatingCaptureConfig);
                        Config v11 = v(this.f4952i.a().e());
                        this.f4951h = v11;
                        from.addImplementationOptions(v11);
                        CaptureRequest c11 = k1.c(from.build(), this.f4949f.d(), this.f4953j);
                        if (c11 == null) {
                            Logger.d("CaptureSession", "Skipping issuing empty request for session.");
                            return -1;
                        }
                        int i11 = this.f4949f.i(c11, l(repeatingCaptureConfig.getCameraCaptureCallbacks(), this.f4946c));
                        return i11;
                    } catch (CameraAccessException e12) {
                        Logger.e("CaptureSession", "Unable to access camera: " + e12.getMessage());
                        Thread.dumpStack();
                        return -1;
                    }
                }
            }
        }
        return -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0134, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x013a, code lost:
        return androidx.camera.core.impl.utils.futures.Futures.immediateFailedFuture(r12);
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* renamed from: w */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.google.common.util.concurrent.ListenableFuture<java.lang.Void> t(java.util.List<android.view.Surface> r12, androidx.camera.core.impl.SessionConfig r13, android.hardware.camera2.CameraDevice r14) {
        /*
            r11 = this;
            java.lang.Object r0 = r11.f4944a
            monitor-enter(r0)
            int[] r1 = androidx.camera.camera2.internal.CaptureSession.d.f4965a     // Catch:{ all -> 0x0159 }
            androidx.camera.camera2.internal.CaptureSession$State r2 = r11.f4955l     // Catch:{ all -> 0x0159 }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x0159 }
            r1 = r1[r2]     // Catch:{ all -> 0x0159 }
            r2 = 1
            if (r1 == r2) goto L_0x013b
            r3 = 2
            if (r1 == r3) goto L_0x013b
            r4 = 3
            r5 = 5
            if (r1 == r4) goto L_0x0037
            if (r1 == r5) goto L_0x013b
            java.util.concurrent.CancellationException r12 = new java.util.concurrent.CancellationException     // Catch:{ all -> 0x0159 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0159 }
            r13.<init>()     // Catch:{ all -> 0x0159 }
            java.lang.String r14 = "openCaptureSession() not execute in state: "
            r13.append(r14)     // Catch:{ all -> 0x0159 }
            androidx.camera.camera2.internal.CaptureSession$State r14 = r11.f4955l     // Catch:{ all -> 0x0159 }
            r13.append(r14)     // Catch:{ all -> 0x0159 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0159 }
            r12.<init>(r13)     // Catch:{ all -> 0x0159 }
            com.google.common.util.concurrent.ListenableFuture r12 = androidx.camera.core.impl.utils.futures.Futures.immediateFailedFuture(r12)     // Catch:{ all -> 0x0159 }
            monitor-exit(r0)     // Catch:{ all -> 0x0159 }
            return r12
        L_0x0037:
            java.util.Map<androidx.camera.core.impl.DeferrableSurface, android.view.Surface> r1 = r11.f4953j     // Catch:{ all -> 0x0159 }
            r1.clear()     // Catch:{ all -> 0x0159 }
            r1 = 0
            r4 = r1
        L_0x003e:
            int r6 = r12.size()     // Catch:{ all -> 0x0159 }
            if (r4 >= r6) goto L_0x005a
            java.util.Map<androidx.camera.core.impl.DeferrableSurface, android.view.Surface> r6 = r11.f4953j     // Catch:{ all -> 0x0159 }
            java.util.List<androidx.camera.core.impl.DeferrableSurface> r7 = r11.f4954k     // Catch:{ all -> 0x0159 }
            java.lang.Object r7 = r7.get(r4)     // Catch:{ all -> 0x0159 }
            androidx.camera.core.impl.DeferrableSurface r7 = (androidx.camera.core.impl.DeferrableSurface) r7     // Catch:{ all -> 0x0159 }
            java.lang.Object r8 = r12.get(r4)     // Catch:{ all -> 0x0159 }
            android.view.Surface r8 = (android.view.Surface) r8     // Catch:{ all -> 0x0159 }
            r6.put(r7, r8)     // Catch:{ all -> 0x0159 }
            int r4 = r4 + 1
            goto L_0x003e
        L_0x005a:
            androidx.camera.camera2.internal.CaptureSession$State r12 = androidx.camera.camera2.internal.CaptureSession.State.OPENING     // Catch:{ all -> 0x0159 }
            r11.f4955l = r12     // Catch:{ all -> 0x0159 }
            java.lang.String r12 = "CaptureSession"
            java.lang.String r4 = "Opening capture session."
            androidx.camera.core.Logger.d(r12, r4)     // Catch:{ all -> 0x0159 }
            androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback[] r12 = new androidx.camera.camera2.internal.SynchronizedCaptureSession.StateCallback[r3]     // Catch:{ all -> 0x0159 }
            androidx.camera.camera2.internal.CaptureSession$e r3 = r11.f4947d     // Catch:{ all -> 0x0159 }
            r12[r1] = r3     // Catch:{ all -> 0x0159 }
            androidx.camera.camera2.internal.c4$a r3 = new androidx.camera.camera2.internal.c4$a     // Catch:{ all -> 0x0159 }
            java.util.List r4 = r13.getSessionStateCallbacks()     // Catch:{ all -> 0x0159 }
            r3.<init>((java.util.List<android.hardware.camera2.CameraCaptureSession.StateCallback>) r4)     // Catch:{ all -> 0x0159 }
            r12[r2] = r3     // Catch:{ all -> 0x0159 }
            androidx.camera.camera2.internal.SynchronizedCaptureSession$StateCallback r12 = androidx.camera.camera2.internal.c4.t(r12)     // Catch:{ all -> 0x0159 }
            androidx.camera.camera2.impl.Camera2ImplConfig r2 = new androidx.camera.camera2.impl.Camera2ImplConfig     // Catch:{ all -> 0x0159 }
            androidx.camera.core.impl.Config r3 = r13.getImplementationOptions()     // Catch:{ all -> 0x0159 }
            r2.<init>(r3)     // Catch:{ all -> 0x0159 }
            n.b r3 = n.b.b()     // Catch:{ all -> 0x0159 }
            n.b r3 = r2.b(r3)     // Catch:{ all -> 0x0159 }
            r11.f4952i = r3     // Catch:{ all -> 0x0159 }
            n.b$a r3 = r3.a()     // Catch:{ all -> 0x0159 }
            java.util.List r3 = r3.d()     // Catch:{ all -> 0x0159 }
            androidx.camera.core.impl.CaptureConfig r4 = r13.getRepeatingCaptureConfig()     // Catch:{ all -> 0x0159 }
            androidx.camera.core.impl.CaptureConfig$Builder r4 = androidx.camera.core.impl.CaptureConfig.Builder.from(r4)     // Catch:{ all -> 0x0159 }
            java.util.Iterator r3 = r3.iterator()     // Catch:{ all -> 0x0159 }
        L_0x00a1:
            boolean r6 = r3.hasNext()     // Catch:{ all -> 0x0159 }
            if (r6 == 0) goto L_0x00b5
            java.lang.Object r6 = r3.next()     // Catch:{ all -> 0x0159 }
            androidx.camera.core.impl.CaptureConfig r6 = (androidx.camera.core.impl.CaptureConfig) r6     // Catch:{ all -> 0x0159 }
            androidx.camera.core.impl.Config r6 = r6.getImplementationOptions()     // Catch:{ all -> 0x0159 }
            r4.addImplementationOptions(r6)     // Catch:{ all -> 0x0159 }
            goto L_0x00a1
        L_0x00b5:
            java.util.ArrayList r3 = new java.util.ArrayList     // Catch:{ all -> 0x0159 }
            r3.<init>()     // Catch:{ all -> 0x0159 }
            r6 = 0
            java.lang.String r2 = r2.g(r6)     // Catch:{ all -> 0x0159 }
            java.util.List r6 = r13.getOutputConfigs()     // Catch:{ all -> 0x0159 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0159 }
        L_0x00c7:
            boolean r7 = r6.hasNext()     // Catch:{ all -> 0x0159 }
            if (r7 == 0) goto L_0x00fc
            java.lang.Object r7 = r6.next()     // Catch:{ all -> 0x0159 }
            androidx.camera.core.impl.SessionConfig$OutputConfig r7 = (androidx.camera.core.impl.SessionConfig.OutputConfig) r7     // Catch:{ all -> 0x0159 }
            java.util.Map<androidx.camera.core.impl.DeferrableSurface, android.view.Surface> r8 = r11.f4953j     // Catch:{ all -> 0x0159 }
            p.f r8 = r11.n(r7, r8, r2)     // Catch:{ all -> 0x0159 }
            java.util.Map<androidx.camera.core.impl.DeferrableSurface, java.lang.Long> r9 = r11.f4958o     // Catch:{ all -> 0x0159 }
            androidx.camera.core.impl.DeferrableSurface r10 = r7.getSurface()     // Catch:{ all -> 0x0159 }
            boolean r9 = r9.containsKey(r10)     // Catch:{ all -> 0x0159 }
            if (r9 == 0) goto L_0x00f8
            java.util.Map<androidx.camera.core.impl.DeferrableSurface, java.lang.Long> r9 = r11.f4958o     // Catch:{ all -> 0x0159 }
            androidx.camera.core.impl.DeferrableSurface r7 = r7.getSurface()     // Catch:{ all -> 0x0159 }
            java.lang.Object r7 = r9.get(r7)     // Catch:{ all -> 0x0159 }
            java.lang.Long r7 = (java.lang.Long) r7     // Catch:{ all -> 0x0159 }
            long r9 = r7.longValue()     // Catch:{ all -> 0x0159 }
            r8.g(r9)     // Catch:{ all -> 0x0159 }
        L_0x00f8:
            r3.add(r8)     // Catch:{ all -> 0x0159 }
            goto L_0x00c7
        L_0x00fc:
            java.util.List r2 = r11.o(r3)     // Catch:{ all -> 0x0159 }
            androidx.camera.camera2.internal.b4 r3 = r11.f4948e     // Catch:{ all -> 0x0159 }
            p.l r12 = r3.a(r1, r2, r12)     // Catch:{ all -> 0x0159 }
            int r1 = r13.getTemplateType()     // Catch:{ all -> 0x0159 }
            if (r1 != r5) goto L_0x011d
            android.hardware.camera2.params.InputConfiguration r1 = r13.getInputConfiguration()     // Catch:{ all -> 0x0159 }
            if (r1 == 0) goto L_0x011d
            android.hardware.camera2.params.InputConfiguration r13 = r13.getInputConfiguration()     // Catch:{ all -> 0x0159 }
            p.e r13 = p.e.b(r13)     // Catch:{ all -> 0x0159 }
            r12.f(r13)     // Catch:{ all -> 0x0159 }
        L_0x011d:
            androidx.camera.core.impl.CaptureConfig r13 = r4.build()     // Catch:{ CameraAccessException -> 0x0134 }
            android.hardware.camera2.CaptureRequest r13 = androidx.camera.camera2.internal.k1.d(r13, r14)     // Catch:{ CameraAccessException -> 0x0134 }
            if (r13 == 0) goto L_0x012a
            r12.g(r13)     // Catch:{ CameraAccessException -> 0x0134 }
        L_0x012a:
            androidx.camera.camera2.internal.b4 r13 = r11.f4948e     // Catch:{ all -> 0x0159 }
            java.util.List<androidx.camera.core.impl.DeferrableSurface> r1 = r11.f4954k     // Catch:{ all -> 0x0159 }
            com.google.common.util.concurrent.ListenableFuture r12 = r13.c(r14, r12, r1)     // Catch:{ all -> 0x0159 }
            monitor-exit(r0)     // Catch:{ all -> 0x0159 }
            return r12
        L_0x0134:
            r12 = move-exception
            com.google.common.util.concurrent.ListenableFuture r12 = androidx.camera.core.impl.utils.futures.Futures.immediateFailedFuture(r12)     // Catch:{ all -> 0x0159 }
            monitor-exit(r0)     // Catch:{ all -> 0x0159 }
            return r12
        L_0x013b:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException     // Catch:{ all -> 0x0159 }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0159 }
            r13.<init>()     // Catch:{ all -> 0x0159 }
            java.lang.String r14 = "openCaptureSession() should not be possible in state: "
            r13.append(r14)     // Catch:{ all -> 0x0159 }
            androidx.camera.camera2.internal.CaptureSession$State r14 = r11.f4955l     // Catch:{ all -> 0x0159 }
            r13.append(r14)     // Catch:{ all -> 0x0159 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0159 }
            r12.<init>(r13)     // Catch:{ all -> 0x0159 }
            com.google.common.util.concurrent.ListenableFuture r12 = androidx.camera.core.impl.utils.futures.Futures.immediateFailedFuture(r12)     // Catch:{ all -> 0x0159 }
            monitor-exit(r0)     // Catch:{ all -> 0x0159 }
            return r12
        L_0x0159:
            r12 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0159 }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.CaptureSession.t(java.util.List, androidx.camera.core.impl.SessionConfig, android.hardware.camera2.CameraDevice):com.google.common.util.concurrent.ListenableFuture");
    }

    public List<CaptureConfig> x(List<CaptureConfig> list) {
        ArrayList arrayList = new ArrayList();
        for (CaptureConfig from : list) {
            CaptureConfig.Builder from2 = CaptureConfig.Builder.from(from);
            from2.setTemplateType(1);
            for (DeferrableSurface addSurface : this.f4950g.getRepeatingCaptureConfig().getSurfaces()) {
                from2.addSurface(addSurface);
            }
            arrayList.add(from2.build());
        }
        return arrayList;
    }

    public void y() {
        synchronized (this.f4944a) {
            if (this.f4955l != State.OPENED) {
                Logger.e("CaptureSession", "Unable to stop repeating. Incorrect state:" + this.f4955l);
                return;
            }
            try {
                this.f4949f.stopRepeating();
            } catch (CameraAccessException e11) {
                Logger.e("CaptureSession", "Unable to stop repeating.", e11);
            }
        }
    }
}
