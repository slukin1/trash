package androidx.camera.camera2.internal;

import android.annotation.SuppressLint;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.os.Build;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Rational;
import android.util.Size;
import android.view.Surface;
import androidx.camera.camera2.internal.b4;
import androidx.camera.camera2.internal.compat.CameraAccessExceptionCompat;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.CameraState;
import androidx.camera.core.CameraUnavailableException;
import androidx.camera.core.Logger;
import androidx.camera.core.Preview;
import androidx.camera.core.UseCase;
import androidx.camera.core.concurrent.CameraCoordinator;
import androidx.camera.core.impl.CameraConfig;
import androidx.camera.core.impl.CameraConfigs;
import androidx.camera.core.impl.CameraControlInternal;
import androidx.camera.core.impl.CameraInfoInternal;
import androidx.camera.core.impl.CameraInternal;
import androidx.camera.core.impl.CameraStateRegistry;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.DeferrableSurface;
import androidx.camera.core.impl.ImmediateSurface;
import androidx.camera.core.impl.LiveDataObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.SessionConfig;
import androidx.camera.core.impl.SessionProcessor;
import androidx.camera.core.impl.UseCaseAttachState;
import androidx.camera.core.impl.UseCaseConfig;
import androidx.camera.core.impl.j;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.adjust.sdk.Constants;
import com.google.auto.value.AutoValue;
import com.google.common.util.concurrent.ListenableFuture;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import com.tencent.rtmp.downloader.TXVodDownloadDataSource;
import com.tencent.thumbplayer.tcmedia.api.TPErrorCode;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;
import o.l0;
import o.y;

public final class Camera2CameraImpl implements CameraInternal {
    public final Set<String> A;
    public CameraConfig B;
    public final Object C;
    public SessionProcessor D;
    public boolean E;
    public final g2 F;
    public final y G;
    public final p.b H;

    /* renamed from: b  reason: collision with root package name */
    public final UseCaseAttachState f4899b;

    /* renamed from: c  reason: collision with root package name */
    public final l0 f4900c;

    /* renamed from: d  reason: collision with root package name */
    public final Executor f4901d;

    /* renamed from: e  reason: collision with root package name */
    public final ScheduledExecutorService f4902e;

    /* renamed from: f  reason: collision with root package name */
    public volatile InternalState f4903f = InternalState.INITIALIZED;

    /* renamed from: g  reason: collision with root package name */
    public final LiveDataObservable<CameraInternal.State> f4904g;

    /* renamed from: h  reason: collision with root package name */
    public final u1 f4905h;

    /* renamed from: i  reason: collision with root package name */
    public final u f4906i;

    /* renamed from: j  reason: collision with root package name */
    public final g f4907j;

    /* renamed from: k  reason: collision with root package name */
    public final s0 f4908k;

    /* renamed from: l  reason: collision with root package name */
    public CameraDevice f4909l;

    /* renamed from: m  reason: collision with root package name */
    public int f4910m;

    /* renamed from: n  reason: collision with root package name */
    public c2 f4911n;

    /* renamed from: o  reason: collision with root package name */
    public final AtomicInteger f4912o;

    /* renamed from: p  reason: collision with root package name */
    public ListenableFuture<Void> f4913p;

    /* renamed from: q  reason: collision with root package name */
    public CallbackToFutureAdapter.a<Void> f4914q;

    /* renamed from: r  reason: collision with root package name */
    public final Map<c2, ListenableFuture<Void>> f4915r;

    /* renamed from: s  reason: collision with root package name */
    public final d f4916s;

    /* renamed from: t  reason: collision with root package name */
    public final e f4917t;

    /* renamed from: u  reason: collision with root package name */
    public final CameraCoordinator f4918u;

    /* renamed from: v  reason: collision with root package name */
    public final CameraStateRegistry f4919v;

    /* renamed from: w  reason: collision with root package name */
    public final Set<CaptureSession> f4920w;

    /* renamed from: x  reason: collision with root package name */
    public e3 f4921x;

    /* renamed from: y  reason: collision with root package name */
    public final e2 f4922y;

    /* renamed from: z  reason: collision with root package name */
    public final b4.a f4923z;

    public enum InternalState {
        INITIALIZED,
        PENDING_OPEN,
        OPENING,
        OPENED,
        CONFIGURED,
        CLOSING,
        REOPENING,
        RELEASING,
        RELEASED
    }

    public class a implements FutureCallback<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c2 f4924a;

        public a(c2 c2Var) {
            this.f4924a = c2Var;
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
            CameraDevice cameraDevice;
            Camera2CameraImpl.this.f4915r.remove(this.f4924a);
            int i11 = c.f4927a[Camera2CameraImpl.this.f4903f.ordinal()];
            if (i11 != 3) {
                if (i11 != 7) {
                    if (i11 != 8) {
                        return;
                    }
                } else if (Camera2CameraImpl.this.f4910m == 0) {
                    return;
                }
            }
            if (Camera2CameraImpl.this.J() && (cameraDevice = Camera2CameraImpl.this.f4909l) != null) {
                o.a.a(cameraDevice);
                Camera2CameraImpl.this.f4909l = null;
            }
        }

        public void onFailure(Throwable th2) {
        }
    }

    public class b implements FutureCallback<Void> {
        public b() {
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
            if (Camera2CameraImpl.this.f4918u.getCameraOperatingMode() == 2 && Camera2CameraImpl.this.f4903f == InternalState.OPENED) {
                Camera2CameraImpl.this.n0(InternalState.CONFIGURED);
            }
        }

        public void onFailure(Throwable th2) {
            if (th2 instanceof DeferrableSurface.SurfaceClosedException) {
                SessionConfig B = Camera2CameraImpl.this.B(((DeferrableSurface.SurfaceClosedException) th2).getDeferrableSurface());
                if (B != null) {
                    Camera2CameraImpl.this.g0(B);
                }
            } else if (th2 instanceof CancellationException) {
                Camera2CameraImpl.this.z("Unable to configure camera cancelled");
            } else {
                InternalState internalState = Camera2CameraImpl.this.f4903f;
                InternalState internalState2 = InternalState.OPENED;
                if (internalState == internalState2) {
                    Camera2CameraImpl.this.o0(internalState2, CameraState.StateError.create(4, th2));
                }
                if (th2 instanceof CameraAccessException) {
                    Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
                    camera2CameraImpl.z("Unable to configure camera due to " + th2.getMessage());
                } else if (th2 instanceof TimeoutException) {
                    Logger.e("Camera2CameraImpl", "Unable to configure camera " + Camera2CameraImpl.this.f4908k.getCameraId() + ", timeout!");
                }
            }
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f4927a;

        /* JADX WARNING: Can't wrap try/catch for region: R(18:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|(3:17|18|20)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState[] r0 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f4927a = r0
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState r1 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.INITIALIZED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f4927a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState r1 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.PENDING_OPEN     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f4927a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState r1 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.CLOSING     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f4927a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState r1 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.OPENED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f4927a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState r1 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.CONFIGURED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f4927a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState r1 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.OPENING     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f4927a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState r1 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.REOPENING     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f4927a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState r1 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.RELEASING     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f4927a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.camera.camera2.internal.Camera2CameraImpl$InternalState r1 = androidx.camera.camera2.internal.Camera2CameraImpl.InternalState.RELEASED     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.Camera2CameraImpl.c.<clinit>():void");
        }
    }

    public final class d extends CameraManager.AvailabilityCallback implements CameraStateRegistry.OnOpenAvailableListener {

        /* renamed from: a  reason: collision with root package name */
        public final String f4928a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f4929b = true;

        public d(String str) {
            this.f4928a = str;
        }

        public boolean a() {
            return this.f4929b;
        }

        public void onCameraAvailable(String str) {
            if (this.f4928a.equals(str)) {
                this.f4929b = true;
                if (Camera2CameraImpl.this.f4903f == InternalState.PENDING_OPEN) {
                    Camera2CameraImpl.this.v0(false);
                }
            }
        }

        public void onCameraUnavailable(String str) {
            if (this.f4928a.equals(str)) {
                this.f4929b = false;
            }
        }

        public void onOpenAvailable() {
            if (Camera2CameraImpl.this.f4903f == InternalState.PENDING_OPEN) {
                Camera2CameraImpl.this.v0(false);
            }
        }
    }

    public final class e implements CameraStateRegistry.OnConfigureAvailableListener {
        public e() {
        }

        public void onConfigureAvailable() {
            if (Camera2CameraImpl.this.f4903f == InternalState.OPENED) {
                Camera2CameraImpl.this.e0();
            }
        }
    }

    public final class f implements CameraControlInternal.ControlUpdateCallback {
        public f() {
        }

        public void onCameraControlCaptureRequests(List<CaptureConfig> list) {
            Camera2CameraImpl.this.q0((List) androidx.core.util.h.g(list));
        }

        public void onCameraControlUpdateSessionConfig() {
            Camera2CameraImpl.this.w0();
        }
    }

    public final class g extends CameraDevice.StateCallback {

        /* renamed from: a  reason: collision with root package name */
        public final Executor f4933a;

        /* renamed from: b  reason: collision with root package name */
        public final ScheduledExecutorService f4934b;

        /* renamed from: c  reason: collision with root package name */
        public b f4935c;

        /* renamed from: d  reason: collision with root package name */
        public ScheduledFuture<?> f4936d;

        /* renamed from: e  reason: collision with root package name */
        public final a f4937e = new a();

        public class a {

            /* renamed from: a  reason: collision with root package name */
            public long f4939a = -1;

            public a() {
            }

            public boolean a() {
                if (!(b() >= ((long) d()))) {
                    return true;
                }
                e();
                return false;
            }

            public long b() {
                long uptimeMillis = SystemClock.uptimeMillis();
                if (this.f4939a == -1) {
                    this.f4939a = uptimeMillis;
                }
                return uptimeMillis - this.f4939a;
            }

            public int c() {
                if (!g.this.f()) {
                    return 700;
                }
                long b11 = b();
                if (b11 <= com.sumsub.sns.internal.core.data.source.dynamic.c.f33305t) {
                    return 1000;
                }
                if (b11 <= 300000) {
                    return 2000;
                }
                return TPErrorCode.TP_ERROR_TYPE_DOWNLOAD_PROXY;
            }

            public int d() {
                if (!g.this.f()) {
                    return 10000;
                }
                return Constants.THIRTY_MINUTES;
            }

            public void e() {
                this.f4939a = -1;
            }
        }

        public class b implements Runnable {

            /* renamed from: b  reason: collision with root package name */
            public Executor f4941b;

            /* renamed from: c  reason: collision with root package name */
            public boolean f4942c = false;

            public b(Executor executor) {
                this.f4941b = executor;
            }

            /* access modifiers changed from: private */
            public /* synthetic */ void c() {
                if (!this.f4942c) {
                    androidx.core.util.h.i(Camera2CameraImpl.this.f4903f == InternalState.REOPENING);
                    if (g.this.f()) {
                        Camera2CameraImpl.this.u0(true);
                    } else {
                        Camera2CameraImpl.this.v0(true);
                    }
                }
            }

            public void b() {
                this.f4942c = true;
            }

            public void run() {
                this.f4941b.execute(new p0(this));
            }
        }

        public g(Executor executor, ScheduledExecutorService scheduledExecutorService) {
            this.f4933a = executor;
            this.f4934b = scheduledExecutorService;
        }

        public boolean a() {
            if (this.f4936d == null) {
                return false;
            }
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            camera2CameraImpl.z("Cancelling scheduled re-open: " + this.f4935c);
            this.f4935c.b();
            this.f4935c = null;
            this.f4936d.cancel(false);
            this.f4936d = null;
            return true;
        }

        public final void b(CameraDevice cameraDevice, int i11) {
            boolean z11 = Camera2CameraImpl.this.f4903f == InternalState.OPENING || Camera2CameraImpl.this.f4903f == InternalState.OPENED || Camera2CameraImpl.this.f4903f == InternalState.CONFIGURED || Camera2CameraImpl.this.f4903f == InternalState.REOPENING;
            androidx.core.util.h.j(z11, "Attempt to handle open error from non open state: " + Camera2CameraImpl.this.f4903f);
            if (i11 == 1 || i11 == 2 || i11 == 4) {
                Logger.d("Camera2CameraImpl", String.format("Attempt to reopen camera[%s] after error[%s]", new Object[]{cameraDevice.getId(), Camera2CameraImpl.D(i11)}));
                c(i11);
                return;
            }
            Logger.e("Camera2CameraImpl", "Error observed on open (or opening) camera device " + cameraDevice.getId() + l.f34627b + Camera2CameraImpl.D(i11) + " closing camera.");
            Camera2CameraImpl.this.o0(InternalState.CLOSING, CameraState.StateError.create(i11 == 3 ? 5 : 6));
            Camera2CameraImpl.this.v(false);
        }

        public final void c(int i11) {
            int i12 = 1;
            androidx.core.util.h.j(Camera2CameraImpl.this.f4910m != 0, "Can only reopen camera device after error if the camera device is actually in an error state.");
            if (i11 == 1) {
                i12 = 2;
            } else if (i11 != 2) {
                i12 = 3;
            }
            Camera2CameraImpl.this.o0(InternalState.REOPENING, CameraState.StateError.create(i12));
            Camera2CameraImpl.this.v(false);
        }

        public void d() {
            this.f4937e.e();
        }

        public void e() {
            boolean z11 = true;
            androidx.core.util.h.i(this.f4935c == null);
            if (this.f4936d != null) {
                z11 = false;
            }
            androidx.core.util.h.i(z11);
            if (this.f4937e.a()) {
                this.f4935c = new b(this.f4933a);
                Camera2CameraImpl.this.z("Attempting camera re-open in " + this.f4937e.c() + "ms: " + this.f4935c + " activeResuming = " + Camera2CameraImpl.this.E);
                this.f4936d = this.f4934b.schedule(this.f4935c, (long) this.f4937e.c(), TimeUnit.MILLISECONDS);
                return;
            }
            Logger.e("Camera2CameraImpl", "Camera reopening attempted for " + this.f4937e.d() + "ms without success.");
            Camera2CameraImpl.this.p0(InternalState.PENDING_OPEN, (CameraState.StateError) null, false);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0007, code lost:
            r0 = r0.f4910m;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean f() {
            /*
                r3 = this;
                androidx.camera.camera2.internal.Camera2CameraImpl r0 = androidx.camera.camera2.internal.Camera2CameraImpl.this
                boolean r1 = r0.E
                r2 = 1
                if (r1 == 0) goto L_0x000f
                int r0 = r0.f4910m
                if (r0 == r2) goto L_0x0010
                r1 = 2
                if (r0 != r1) goto L_0x000f
                goto L_0x0010
            L_0x000f:
                r2 = 0
            L_0x0010:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.camera2.internal.Camera2CameraImpl.g.f():boolean");
        }

        public void onClosed(CameraDevice cameraDevice) {
            Camera2CameraImpl.this.z("CameraDevice.onClosed()");
            boolean z11 = Camera2CameraImpl.this.f4909l == null;
            androidx.core.util.h.j(z11, "Unexpected onClose callback on camera device: " + cameraDevice);
            int i11 = c.f4927a[Camera2CameraImpl.this.f4903f.ordinal()];
            if (i11 != 3) {
                if (i11 == 7) {
                    Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
                    if (camera2CameraImpl.f4910m != 0) {
                        camera2CameraImpl.z("Camera closed due to error: " + Camera2CameraImpl.D(Camera2CameraImpl.this.f4910m));
                        e();
                        return;
                    }
                    camera2CameraImpl.v0(false);
                    return;
                } else if (i11 != 8) {
                    throw new IllegalStateException("Camera closed while in state: " + Camera2CameraImpl.this.f4903f);
                }
            }
            androidx.core.util.h.i(Camera2CameraImpl.this.J());
            Camera2CameraImpl.this.C();
        }

        public void onDisconnected(CameraDevice cameraDevice) {
            Camera2CameraImpl.this.z("CameraDevice.onDisconnected()");
            onError(cameraDevice, 1);
        }

        public void onError(CameraDevice cameraDevice, int i11) {
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            camera2CameraImpl.f4909l = cameraDevice;
            camera2CameraImpl.f4910m = i11;
            switch (c.f4927a[camera2CameraImpl.f4903f.ordinal()]) {
                case 3:
                case 8:
                    Logger.e("Camera2CameraImpl", String.format("CameraDevice.onError(): %s failed with %s while in %s state. Will finish closing camera.", new Object[]{cameraDevice.getId(), Camera2CameraImpl.D(i11), Camera2CameraImpl.this.f4903f.name()}));
                    Camera2CameraImpl.this.v(false);
                    return;
                case 4:
                case 5:
                case 6:
                case 7:
                    Logger.d("Camera2CameraImpl", String.format("CameraDevice.onError(): %s failed with %s while in %s state. Will attempt recovering from error.", new Object[]{cameraDevice.getId(), Camera2CameraImpl.D(i11), Camera2CameraImpl.this.f4903f.name()}));
                    b(cameraDevice, i11);
                    return;
                default:
                    throw new IllegalStateException("onError() should not be possible from state: " + Camera2CameraImpl.this.f4903f);
            }
        }

        public void onOpened(CameraDevice cameraDevice) {
            Camera2CameraImpl.this.z("CameraDevice.onOpened()");
            Camera2CameraImpl camera2CameraImpl = Camera2CameraImpl.this;
            camera2CameraImpl.f4909l = cameraDevice;
            camera2CameraImpl.f4910m = 0;
            d();
            int i11 = c.f4927a[Camera2CameraImpl.this.f4903f.ordinal()];
            if (i11 != 3) {
                if (i11 == 6 || i11 == 7) {
                    Camera2CameraImpl.this.n0(InternalState.OPENED);
                    CameraStateRegistry cameraStateRegistry = Camera2CameraImpl.this.f4919v;
                    String id2 = cameraDevice.getId();
                    Camera2CameraImpl camera2CameraImpl2 = Camera2CameraImpl.this;
                    if (cameraStateRegistry.tryOpenCaptureSession(id2, camera2CameraImpl2.f4918u.getPairedConcurrentCameraId(camera2CameraImpl2.f4909l.getId()))) {
                        Camera2CameraImpl.this.e0();
                        return;
                    }
                    return;
                } else if (i11 != 8) {
                    throw new IllegalStateException("onOpened() should not be possible from state: " + Camera2CameraImpl.this.f4903f);
                }
            }
            androidx.core.util.h.i(Camera2CameraImpl.this.J());
            Camera2CameraImpl.this.f4909l.close();
            Camera2CameraImpl.this.f4909l = null;
        }
    }

    @AutoValue
    public static abstract class h {
        public static h a(String str, Class<?> cls, SessionConfig sessionConfig, UseCaseConfig<?> useCaseConfig, Size size) {
            return new b(str, cls, sessionConfig, useCaseConfig, size);
        }

        public static h b(UseCase useCase) {
            return a(Camera2CameraImpl.G(useCase), useCase.getClass(), useCase.getSessionConfig(), useCase.getCurrentConfig(), useCase.getAttachedSurfaceResolution());
        }

        public abstract SessionConfig c();

        public abstract Size d();

        public abstract UseCaseConfig<?> e();

        public abstract String f();

        public abstract Class<?> g();
    }

    public Camera2CameraImpl(l0 l0Var, String str, s0 s0Var, CameraCoordinator cameraCoordinator, CameraStateRegistry cameraStateRegistry, Executor executor, Handler handler, g2 g2Var) throws CameraUnavailableException {
        String str2 = str;
        s0 s0Var2 = s0Var;
        CameraStateRegistry cameraStateRegistry2 = cameraStateRegistry;
        LiveDataObservable<CameraInternal.State> liveDataObservable = new LiveDataObservable<>();
        this.f4904g = liveDataObservable;
        this.f4910m = 0;
        this.f4912o = new AtomicInteger(0);
        this.f4915r = new LinkedHashMap();
        this.f4920w = new HashSet();
        this.A = new HashSet();
        this.B = CameraConfigs.emptyConfig();
        this.C = new Object();
        this.E = false;
        this.f4900c = l0Var;
        this.f4918u = cameraCoordinator;
        this.f4919v = cameraStateRegistry2;
        ScheduledExecutorService newHandlerExecutor = CameraXExecutors.newHandlerExecutor(handler);
        this.f4902e = newHandlerExecutor;
        Executor newSequentialExecutor = CameraXExecutors.newSequentialExecutor(executor);
        this.f4901d = newSequentialExecutor;
        this.f4907j = new g(newSequentialExecutor, newHandlerExecutor);
        this.f4899b = new UseCaseAttachState(str2);
        liveDataObservable.postValue(CameraInternal.State.CLOSED);
        u1 u1Var = new u1(cameraStateRegistry2);
        this.f4905h = u1Var;
        e2 e2Var = new e2(newSequentialExecutor);
        this.f4922y = e2Var;
        this.F = g2Var;
        try {
            y c11 = l0Var.c(str);
            this.G = c11;
            u uVar = r6;
            u uVar2 = new u(c11, newHandlerExecutor, newSequentialExecutor, new f(), s0Var.getCameraQuirks());
            this.f4906i = uVar;
            this.f4908k = s0Var2;
            s0Var2.e(uVar);
            s0Var2.h(u1Var.a());
            this.H = p.b.a(c11);
            this.f4911n = a0();
            this.f4923z = new b4.a(newSequentialExecutor, newHandlerExecutor, handler, e2Var, s0Var.getCameraQuirks(), q.d.b());
            d dVar = new d(str2);
            this.f4916s = dVar;
            e eVar = new e();
            this.f4917t = eVar;
            cameraStateRegistry2.registerCamera(this, newSequentialExecutor, eVar, dVar);
            l0Var.g(newSequentialExecutor, dVar);
        } catch (CameraAccessExceptionCompat e11) {
            throw v1.a(e11);
        }
    }

    public static String D(int i11) {
        return i11 != 0 ? i11 != 1 ? i11 != 2 ? i11 != 3 ? i11 != 4 ? i11 != 5 ? "UNKNOWN ERROR" : "ERROR_CAMERA_SERVICE" : "ERROR_CAMERA_DEVICE" : "ERROR_CAMERA_DISABLED" : "ERROR_MAX_CAMERAS_IN_USE" : "ERROR_CAMERA_IN_USE" : "ERROR_NONE";
    }

    public static String E(e3 e3Var) {
        return e3Var.e() + e3Var.hashCode();
    }

    public static String G(UseCase useCase) {
        return useCase.getName() + useCase.hashCode();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void K() {
        if (I()) {
            m0(E(this.f4921x), this.f4921x.g(), this.f4921x.h());
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L(List list) {
        try {
            s0(list);
        } finally {
            this.f4906i.m();
        }
    }

    public static /* synthetic */ void M(Surface surface, SurfaceTexture surfaceTexture) {
        surface.release();
        surfaceTexture.release();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object P(CallbackToFutureAdapter.a aVar) throws Exception {
        androidx.core.util.h.j(this.f4914q == null, "Camera can only be released once, so release completer should be null on creation.");
        this.f4914q = aVar;
        return "Release[camera=" + this + "]";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q(CallbackToFutureAdapter.a aVar) {
        e3 e3Var = this.f4921x;
        if (e3Var == null) {
            aVar.c(Boolean.FALSE);
            return;
        }
        aVar.c(Boolean.valueOf(this.f4899b.isUseCaseAttached(E(e3Var))));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object R(CallbackToFutureAdapter.a aVar) throws Exception {
        try {
            this.f4901d.execute(new o0(this, aVar));
            return "isMeteringRepeatingAttached";
        } catch (RejectedExecutionException unused) {
            aVar.f(new RuntimeException("Unable to check if MeteringRepeating is attached. Camera executor shut down."));
            return "isMeteringRepeatingAttached";
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S(String str, SessionConfig sessionConfig, UseCaseConfig useCaseConfig) {
        z("Use case " + str + " ACTIVE");
        this.f4899b.setUseCaseActive(str, sessionConfig, useCaseConfig);
        this.f4899b.updateUseCase(str, sessionConfig, useCaseConfig);
        w0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T(String str) {
        z("Use case " + str + " INACTIVE");
        this.f4899b.setUseCaseInactive(str);
        w0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U(String str, SessionConfig sessionConfig, UseCaseConfig useCaseConfig) {
        z("Use case " + str + " UPDATED");
        this.f4899b.updateUseCase(str, sessionConfig, useCaseConfig);
        w0();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W(CallbackToFutureAdapter.a aVar) {
        Futures.propagate(h0(), aVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object X(CallbackToFutureAdapter.a aVar) throws Exception {
        this.f4901d.execute(new n0(this, aVar));
        return "Release[request=" + this.f4912o.getAndIncrement() + "]";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Y(String str, SessionConfig sessionConfig, UseCaseConfig useCaseConfig) {
        z("Use case " + str + " RESET");
        this.f4899b.updateUseCase(str, sessionConfig, useCaseConfig);
        t();
        l0(false);
        w0();
        if (this.f4903f == InternalState.OPENED) {
            e0();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Z(boolean z11) {
        this.E = z11;
        if (z11 && this.f4903f == InternalState.PENDING_OPEN) {
            u0(false);
        }
    }

    public final void A(String str, Throwable th2) {
        Logger.d("Camera2CameraImpl", String.format("{%s} %s", new Object[]{toString(), str}), th2);
    }

    public SessionConfig B(DeferrableSurface deferrableSurface) {
        for (SessionConfig next : this.f4899b.getAttachedSessionConfigs()) {
            if (next.getSurfaces().contains(deferrableSurface)) {
                return next;
            }
        }
        return null;
    }

    public void C() {
        androidx.core.util.h.i(this.f4903f == InternalState.RELEASING || this.f4903f == InternalState.CLOSING);
        androidx.core.util.h.i(this.f4915r.isEmpty());
        this.f4909l = null;
        if (this.f4903f == InternalState.CLOSING) {
            n0(InternalState.INITIALIZED);
            return;
        }
        this.f4900c.h(this.f4916s);
        n0(InternalState.RELEASED);
        CallbackToFutureAdapter.a<Void> aVar = this.f4914q;
        if (aVar != null) {
            aVar.c(null);
            this.f4914q = null;
        }
    }

    public final ListenableFuture<Void> F() {
        if (this.f4913p == null) {
            if (this.f4903f != InternalState.RELEASED) {
                this.f4913p = CallbackToFutureAdapter.a(new h0(this));
            } else {
                this.f4913p = Futures.immediateFuture(null);
            }
        }
        return this.f4913p;
    }

    public final boolean H() {
        return ((s0) getCameraInfoInternal()).d() == 2;
    }

    public boolean I() {
        try {
            return ((Boolean) CallbackToFutureAdapter.a(new g0(this)).get()).booleanValue();
        } catch (InterruptedException | ExecutionException e11) {
            throw new RuntimeException("Unable to check if MeteringRepeating is attached.", e11);
        }
    }

    public boolean J() {
        return this.f4915r.isEmpty() && this.f4920w.isEmpty();
    }

    public final c2 a0() {
        synchronized (this.C) {
            if (this.D == null) {
                CaptureSession captureSession = new CaptureSession(this.H);
                return captureSession;
            }
            ProcessingCaptureSession processingCaptureSession = new ProcessingCaptureSession(this.D, this.f4908k, this.H, this.f4901d, this.f4902e);
            return processingCaptureSession;
        }
    }

    public void attachUseCases(Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList(collection);
        if (!arrayList.isEmpty()) {
            this.f4906i.C();
            b0(new ArrayList(arrayList));
            try {
                this.f4901d.execute(new d0(this, new ArrayList(r0(arrayList))));
            } catch (RejectedExecutionException e11) {
                A("Unable to attach use cases.", e11);
                this.f4906i.m();
            }
        }
    }

    public final void b0(List<UseCase> list) {
        for (UseCase next : list) {
            String G2 = G(next);
            if (!this.A.contains(G2)) {
                this.A.add(G2);
                next.onStateAttached();
                next.onCameraControlReady();
            }
        }
    }

    public final void c0(List<UseCase> list) {
        for (UseCase next : list) {
            String G2 = G(next);
            if (this.A.contains(G2)) {
                next.onStateDetached();
                this.A.remove(G2);
            }
        }
    }

    public void close() {
        this.f4901d.execute(new l0(this));
    }

    @SuppressLint({"MissingPermission"})
    public final void d0(boolean z11) {
        if (!z11) {
            this.f4907j.d();
        }
        this.f4907j.a();
        z("Opening camera.");
        n0(InternalState.OPENING);
        try {
            this.f4900c.f(this.f4908k.getCameraId(), this.f4901d, y());
        } catch (CameraAccessExceptionCompat e11) {
            z("Unable to open camera due to " + e11.getMessage());
            if (e11.getReason() == 10001) {
                o0(InternalState.INITIALIZED, CameraState.StateError.create(7, e11));
            }
        } catch (SecurityException e12) {
            z("Unable to open camera due to " + e12.getMessage());
            n0(InternalState.REOPENING);
            this.f4907j.e();
        }
    }

    public void detachUseCases(Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList(collection);
        if (!arrayList.isEmpty()) {
            ArrayList arrayList2 = new ArrayList(r0(arrayList));
            c0(new ArrayList(arrayList));
            this.f4901d.execute(new c0(this, arrayList2));
        }
    }

    public void e0() {
        androidx.core.util.h.i(this.f4903f == InternalState.OPENED);
        SessionConfig.ValidatingBuilder attachedBuilder = this.f4899b.getAttachedBuilder();
        if (!attachedBuilder.isValid()) {
            z("Unable to create capture session due to conflicting configurations");
        } else if (!this.f4919v.tryOpenCaptureSession(this.f4909l.getId(), this.f4918u.getPairedConcurrentCameraId(this.f4909l.getId()))) {
            z("Unable to create capture session in camera operating mode = " + this.f4918u.getCameraOperatingMode());
        } else {
            HashMap hashMap = new HashMap();
            o3.m(this.f4899b.getAttachedSessionConfigs(), this.f4899b.getAttachedUseCaseConfigs(), hashMap);
            this.f4911n.g(hashMap);
            Futures.addCallback(this.f4911n.f(attachedBuilder.build(), (CameraDevice) androidx.core.util.h.g(this.f4909l), this.f4923z.a()), new b(), this.f4901d);
        }
    }

    public final void f0() {
        int i11 = c.f4927a[this.f4903f.ordinal()];
        boolean z11 = false;
        if (i11 == 1 || i11 == 2) {
            u0(false);
        } else if (i11 != 3) {
            z("open() ignored due to being in state: " + this.f4903f);
        } else {
            n0(InternalState.REOPENING);
            if (!J() && this.f4910m == 0) {
                if (this.f4909l != null) {
                    z11 = true;
                }
                androidx.core.util.h.j(z11, "Camera Device should be open if session close is not complete");
                n0(InternalState.OPENED);
                e0();
            }
        }
    }

    public void g0(SessionConfig sessionConfig) {
        ScheduledExecutorService mainThreadExecutor = CameraXExecutors.mainThreadExecutor();
        List<SessionConfig.ErrorListener> errorListeners = sessionConfig.getErrorListeners();
        if (!errorListeners.isEmpty()) {
            A("Posting surface closed", new Throwable());
            mainThreadExecutor.execute(new f0(errorListeners.get(0), sessionConfig));
        }
    }

    public /* synthetic */ CameraControl getCameraControl() {
        return j.a(this);
    }

    public CameraControlInternal getCameraControlInternal() {
        return this.f4906i;
    }

    public /* synthetic */ CameraInfo getCameraInfo() {
        return j.b(this);
    }

    public CameraInfoInternal getCameraInfoInternal() {
        return this.f4908k;
    }

    public /* synthetic */ LinkedHashSet getCameraInternals() {
        return j.c(this);
    }

    public Observable<CameraInternal.State> getCameraState() {
        return this.f4904g;
    }

    public CameraConfig getExtendedConfig() {
        return this.B;
    }

    public /* synthetic */ boolean getHasTransform() {
        return j.e(this);
    }

    public final ListenableFuture<Void> h0() {
        ListenableFuture<Void> F2 = F();
        boolean z11 = false;
        switch (c.f4927a[this.f4903f.ordinal()]) {
            case 1:
            case 2:
                if (this.f4909l == null) {
                    z11 = true;
                }
                androidx.core.util.h.i(z11);
                n0(InternalState.RELEASING);
                androidx.core.util.h.i(J());
                C();
                break;
            case 3:
            case 6:
            case 7:
            case 8:
                boolean a11 = this.f4907j.a();
                n0(InternalState.RELEASING);
                if (a11) {
                    androidx.core.util.h.i(J());
                    C();
                    break;
                }
                break;
            case 4:
            case 5:
                n0(InternalState.RELEASING);
                v(false);
                break;
            default:
                z("release() ignored due to being in state: " + this.f4903f);
                break;
        }
        return F2;
    }

    /* renamed from: i0 */
    public void N(CaptureSession captureSession, DeferrableSurface deferrableSurface, Runnable runnable) {
        this.f4920w.remove(captureSession);
        ListenableFuture<Void> j02 = j0(captureSession, false);
        deferrableSurface.close();
        Futures.successfulAsList(Arrays.asList(new ListenableFuture[]{j02, deferrableSurface.getTerminationFuture()})).addListener(runnable, CameraXExecutors.directExecutor());
    }

    public /* synthetic */ boolean isFrontFacing() {
        return j.f(this);
    }

    public /* synthetic */ boolean isUseCasesCombinationSupported(UseCase... useCaseArr) {
        return androidx.camera.core.c.a(this, useCaseArr);
    }

    public ListenableFuture<Void> j0(c2 c2Var, boolean z11) {
        c2Var.close();
        ListenableFuture<Void> a11 = c2Var.a(z11);
        z("Releasing session in state " + this.f4903f.name());
        this.f4915r.put(c2Var, a11);
        Futures.addCallback(a11, new a(c2Var), CameraXExecutors.directExecutor());
        return a11;
    }

    public final void k0() {
        if (this.f4921x != null) {
            UseCaseAttachState useCaseAttachState = this.f4899b;
            useCaseAttachState.setUseCaseDetached(this.f4921x.e() + this.f4921x.hashCode());
            UseCaseAttachState useCaseAttachState2 = this.f4899b;
            useCaseAttachState2.setUseCaseInactive(this.f4921x.e() + this.f4921x.hashCode());
            this.f4921x.c();
            this.f4921x = null;
        }
    }

    public void l0(boolean z11) {
        androidx.core.util.h.i(this.f4911n != null);
        z("Resetting Capture Session");
        c2 c2Var = this.f4911n;
        SessionConfig sessionConfig = c2Var.getSessionConfig();
        List<CaptureConfig> e11 = c2Var.e();
        c2 a02 = a0();
        this.f4911n = a02;
        a02.b(sessionConfig);
        this.f4911n.c(e11);
        j0(c2Var, z11);
    }

    public final void m0(String str, SessionConfig sessionConfig, UseCaseConfig<?> useCaseConfig) {
        this.f4901d.execute(new a0(this, str, sessionConfig, useCaseConfig));
    }

    public void n0(InternalState internalState) {
        o0(internalState, (CameraState.StateError) null);
    }

    public void o0(InternalState internalState, CameraState.StateError stateError) {
        p0(internalState, stateError, true);
    }

    public void onUseCaseActive(UseCase useCase) {
        androidx.core.util.h.g(useCase);
        this.f4901d.execute(new b0(this, G(useCase), useCase.getSessionConfig(), useCase.getCurrentConfig()));
    }

    public void onUseCaseInactive(UseCase useCase) {
        androidx.core.util.h.g(useCase);
        this.f4901d.execute(new y(this, G(useCase)));
    }

    public void onUseCaseReset(UseCase useCase) {
        androidx.core.util.h.g(useCase);
        m0(G(useCase), useCase.getSessionConfig(), useCase.getCurrentConfig());
    }

    public void onUseCaseUpdated(UseCase useCase) {
        androidx.core.util.h.g(useCase);
        this.f4901d.execute(new z(this, G(useCase), useCase.getSessionConfig(), useCase.getCurrentConfig()));
    }

    public void open() {
        this.f4901d.execute(new k0(this));
    }

    public void p0(InternalState internalState, CameraState.StateError stateError, boolean z11) {
        CameraInternal.State state;
        z("Transitioning camera internal state: " + this.f4903f + " --> " + internalState);
        this.f4903f = internalState;
        switch (c.f4927a[internalState.ordinal()]) {
            case 1:
                state = CameraInternal.State.CLOSED;
                break;
            case 2:
                state = CameraInternal.State.PENDING_OPEN;
                break;
            case 3:
                state = CameraInternal.State.CLOSING;
                break;
            case 4:
                state = CameraInternal.State.OPEN;
                break;
            case 5:
                state = CameraInternal.State.CONFIGURED;
                break;
            case 6:
            case 7:
                state = CameraInternal.State.OPENING;
                break;
            case 8:
                state = CameraInternal.State.RELEASING;
                break;
            case 9:
                state = CameraInternal.State.RELEASED;
                break;
            default:
                throw new IllegalStateException("Unknown state: " + internalState);
        }
        this.f4919v.markCameraState(this, state, z11);
        this.f4904g.postValue(state);
        this.f4905h.c(state, stateError);
    }

    public void q0(List<CaptureConfig> list) {
        ArrayList arrayList = new ArrayList();
        for (CaptureConfig next : list) {
            CaptureConfig.Builder from = CaptureConfig.Builder.from(next);
            if (next.getTemplateType() == 5 && next.getCameraCaptureResult() != null) {
                from.setCameraCaptureResult(next.getCameraCaptureResult());
            }
            if (!next.getSurfaces().isEmpty() || !next.isUseRepeatingSurface() || u(from)) {
                arrayList.add(from.build());
            }
        }
        z("Issue capture request");
        this.f4911n.c(arrayList);
    }

    public final Collection<h> r0(Collection<UseCase> collection) {
        ArrayList arrayList = new ArrayList();
        for (UseCase b11 : collection) {
            arrayList.add(h.b(b11));
        }
        return arrayList;
    }

    public ListenableFuture<Void> release() {
        return CallbackToFutureAdapter.a(new i0(this));
    }

    public final void s() {
        e3 e3Var = this.f4921x;
        if (e3Var != null) {
            String E2 = E(e3Var);
            this.f4899b.setUseCaseAttached(E2, this.f4921x.g(), this.f4921x.h());
            this.f4899b.setUseCaseActive(E2, this.f4921x.g(), this.f4921x.h());
        }
    }

    public final void s0(Collection<h> collection) {
        Size d11;
        boolean isEmpty = this.f4899b.getAttachedSessionConfigs().isEmpty();
        ArrayList arrayList = new ArrayList();
        Rational rational = null;
        for (h next : collection) {
            if (!this.f4899b.isUseCaseAttached(next.f())) {
                this.f4899b.setUseCaseAttached(next.f(), next.c(), next.e());
                arrayList.add(next.f());
                if (next.g() == Preview.class && (d11 = next.d()) != null) {
                    rational = new Rational(d11.getWidth(), d11.getHeight());
                }
            }
        }
        if (!arrayList.isEmpty()) {
            z("Use cases [" + TextUtils.join(", ", arrayList) + "] now ATTACHED");
            if (isEmpty) {
                this.f4906i.U(true);
                this.f4906i.C();
            }
            t();
            x0();
            w0();
            l0(false);
            if (this.f4903f == InternalState.OPENED) {
                e0();
            } else {
                f0();
            }
            if (rational != null) {
                this.f4906i.V(rational);
            }
        }
    }

    public void setActiveResumingMode(boolean z11) {
        this.f4901d.execute(new e0(this, z11));
    }

    public void setExtendedConfig(CameraConfig cameraConfig) {
        if (cameraConfig == null) {
            cameraConfig = CameraConfigs.emptyConfig();
        }
        SessionProcessor sessionProcessor = cameraConfig.getSessionProcessor((SessionProcessor) null);
        this.B = cameraConfig;
        synchronized (this.C) {
            this.D = sessionProcessor;
        }
    }

    public final void t() {
        SessionConfig build = this.f4899b.getAttachedBuilder().build();
        CaptureConfig repeatingCaptureConfig = build.getRepeatingCaptureConfig();
        int size = repeatingCaptureConfig.getSurfaces().size();
        int size2 = build.getSurfaces().size();
        if (build.getSurfaces().isEmpty()) {
            return;
        }
        if (repeatingCaptureConfig.getSurfaces().isEmpty()) {
            if (this.f4921x == null) {
                this.f4921x = new e3(this.f4908k.b(), this.F, new x(this));
            }
            s();
        } else if (size2 == 1 && size == 1) {
            k0();
        } else if (size >= 2) {
            k0();
        } else {
            Logger.d("Camera2CameraImpl", "mMeteringRepeating is ATTACHED, SessionConfig Surfaces: " + size2 + ", CaptureConfig Surfaces: " + size);
        }
    }

    /* renamed from: t0 */
    public final void O(Collection<h> collection) {
        ArrayList arrayList = new ArrayList();
        boolean z11 = false;
        for (h next : collection) {
            if (this.f4899b.isUseCaseAttached(next.f())) {
                this.f4899b.removeUseCase(next.f());
                arrayList.add(next.f());
                if (next.g() == Preview.class) {
                    z11 = true;
                }
            }
        }
        if (!arrayList.isEmpty()) {
            z("Use cases [" + TextUtils.join(", ", arrayList) + "] now DETACHED for camera");
            if (z11) {
                this.f4906i.V((Rational) null);
            }
            t();
            if (this.f4899b.getAttachedUseCaseConfigs().isEmpty()) {
                this.f4906i.setZslDisabledByUserCaseConfig(false);
            } else {
                x0();
            }
            if (this.f4899b.getAttachedSessionConfigs().isEmpty()) {
                this.f4906i.m();
                l0(false);
                this.f4906i.U(false);
                this.f4911n = a0();
                w();
                return;
            }
            w0();
            l0(false);
            if (this.f4903f == InternalState.OPENED) {
                e0();
            }
        }
    }

    public String toString() {
        return String.format(Locale.US, "Camera@%x[id=%s]", new Object[]{Integer.valueOf(hashCode()), this.f4908k.getCameraId()});
    }

    public final boolean u(CaptureConfig.Builder builder) {
        if (!builder.getSurfaces().isEmpty()) {
            Logger.w("Camera2CameraImpl", "The capture config builder already has surface inside.");
            return false;
        }
        for (SessionConfig repeatingCaptureConfig : this.f4899b.getActiveAndAttachedSessionConfigs()) {
            List<DeferrableSurface> surfaces = repeatingCaptureConfig.getRepeatingCaptureConfig().getSurfaces();
            if (!surfaces.isEmpty()) {
                for (DeferrableSurface addSurface : surfaces) {
                    builder.addSurface(addSurface);
                }
            }
        }
        if (!builder.getSurfaces().isEmpty()) {
            return true;
        }
        Logger.w("Camera2CameraImpl", "Unable to find a repeating surface to attach to CaptureConfig");
        return false;
    }

    public void u0(boolean z11) {
        z("Attempting to force open the camera.");
        if (!this.f4919v.tryOpenCamera(this)) {
            z("No cameras available. Waiting for available camera before opening camera.");
            n0(InternalState.PENDING_OPEN);
            return;
        }
        d0(z11);
    }

    public void v(boolean z11) {
        boolean z12 = this.f4903f == InternalState.CLOSING || this.f4903f == InternalState.RELEASING || (this.f4903f == InternalState.REOPENING && this.f4910m != 0);
        androidx.core.util.h.j(z12, "closeCamera should only be called in a CLOSING, RELEASING or REOPENING (with error) state. Current state: " + this.f4903f + " (error: " + D(this.f4910m) + ")");
        int i11 = Build.VERSION.SDK_INT;
        if (i11 <= 23 || i11 >= 29 || !H() || this.f4910m != 0) {
            l0(z11);
        } else {
            x(z11);
        }
        this.f4911n.d();
    }

    public void v0(boolean z11) {
        z("Attempting to open the camera.");
        if (!(this.f4916s.a() && this.f4919v.tryOpenCamera(this))) {
            z("No cameras available. Waiting for available camera before opening camera.");
            n0(InternalState.PENDING_OPEN);
            return;
        }
        d0(z11);
    }

    public final void w() {
        z("Closing camera.");
        int i11 = c.f4927a[this.f4903f.ordinal()];
        boolean z11 = false;
        if (i11 == 2) {
            if (this.f4909l == null) {
                z11 = true;
            }
            androidx.core.util.h.i(z11);
            n0(InternalState.INITIALIZED);
        } else if (i11 == 4 || i11 == 5) {
            n0(InternalState.CLOSING);
            v(false);
        } else if (i11 == 6 || i11 == 7) {
            boolean a11 = this.f4907j.a();
            n0(InternalState.CLOSING);
            if (a11) {
                androidx.core.util.h.i(J());
                C();
            }
        } else {
            z("close() ignored due to being in state: " + this.f4903f);
        }
    }

    public void w0() {
        SessionConfig.ValidatingBuilder activeAndAttachedBuilder = this.f4899b.getActiveAndAttachedBuilder();
        if (activeAndAttachedBuilder.isValid()) {
            this.f4906i.W(activeAndAttachedBuilder.build().getTemplateType());
            activeAndAttachedBuilder.add(this.f4906i.getSessionConfig());
            this.f4911n.b(activeAndAttachedBuilder.build());
            return;
        }
        this.f4906i.T();
        this.f4911n.b(this.f4906i.getSessionConfig());
    }

    public final void x(boolean z11) {
        CaptureSession captureSession = new CaptureSession(this.H);
        this.f4920w.add(captureSession);
        l0(z11);
        SurfaceTexture surfaceTexture = new SurfaceTexture(0);
        surfaceTexture.setDefaultBufferSize(com.sumsub.sns.internal.ml.autocapture.b.f34944a, TXVodDownloadDataSource.QUALITY_480P);
        Surface surface = new Surface(surfaceTexture);
        j0 j0Var = new j0(surface, surfaceTexture);
        SessionConfig.Builder builder = new SessionConfig.Builder();
        ImmediateSurface immediateSurface = new ImmediateSurface(surface);
        builder.addNonRepeatingSurface(immediateSurface);
        builder.setTemplateType(1);
        z("Start configAndClose.");
        captureSession.f(builder.build(), (CameraDevice) androidx.core.util.h.g(this.f4909l), this.f4923z.a()).addListener(new m0(this, captureSession, immediateSurface, j0Var), this.f4901d);
    }

    public final void x0() {
        boolean z11 = false;
        for (UseCaseConfig<?> isZslDisabled : this.f4899b.getAttachedUseCaseConfigs()) {
            z11 |= isZslDisabled.isZslDisabled(false);
        }
        this.f4906i.setZslDisabledByUserCaseConfig(z11);
    }

    public final CameraDevice.StateCallback y() {
        ArrayList arrayList = new ArrayList(this.f4899b.getAttachedBuilder().build().getDeviceStateCallbacks());
        arrayList.add(this.f4922y.c());
        arrayList.add(this.f4907j);
        return s1.a(arrayList);
    }

    public void z(String str) {
        A(str, (Throwable) null);
    }
}
