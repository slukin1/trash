package androidx.camera.video.internal.encoder;

import android.annotation.SuppressLint;
import android.media.MediaCodec;
import android.media.MediaCodecInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Range;
import android.view.Surface;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.video.internal.BufferProvider;
import androidx.camera.video.internal.compat.quirk.AudioEncoderIgnoresInputTimestampQuirk;
import androidx.camera.video.internal.compat.quirk.CameraUseInconsistentTimebaseQuirk;
import androidx.camera.video.internal.compat.quirk.EncoderNotUsePersistentInputSurfaceQuirk;
import androidx.camera.video.internal.compat.quirk.VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk;
import androidx.camera.video.internal.encoder.k;
import androidx.camera.video.internal.workaround.EncoderFinder;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.atomic.AtomicReference;

public class EncoderImpl implements k {
    public static final Range<Long> E = Range.create(Long.MAX_VALUE, Long.MAX_VALUE);
    public boolean A = false;
    public boolean B = false;
    public boolean C = false;
    public final EncoderFinder D;

    /* renamed from: a  reason: collision with root package name */
    public final String f6106a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f6107b = new Object();

    /* renamed from: c  reason: collision with root package name */
    public final boolean f6108c;

    /* renamed from: d  reason: collision with root package name */
    public final MediaFormat f6109d;

    /* renamed from: e  reason: collision with root package name */
    public final MediaCodec f6110e;

    /* renamed from: f  reason: collision with root package name */
    public final k.b f6111f;

    /* renamed from: g  reason: collision with root package name */
    public final b1 f6112g;

    /* renamed from: h  reason: collision with root package name */
    public final Executor f6113h;

    /* renamed from: i  reason: collision with root package name */
    public final ListenableFuture<Void> f6114i;

    /* renamed from: j  reason: collision with root package name */
    public final CallbackToFutureAdapter.a<Void> f6115j;

    /* renamed from: k  reason: collision with root package name */
    public final Queue<Integer> f6116k = new ArrayDeque();

    /* renamed from: l  reason: collision with root package name */
    public final Queue<CallbackToFutureAdapter.a<d1>> f6117l = new ArrayDeque();

    /* renamed from: m  reason: collision with root package name */
    public final Set<d1> f6118m = new HashSet();

    /* renamed from: n  reason: collision with root package name */
    public final Set<j> f6119n = new HashSet();

    /* renamed from: o  reason: collision with root package name */
    public final Deque<Range<Long>> f6120o = new ArrayDeque();

    /* renamed from: p  reason: collision with root package name */
    public final Timebase f6121p;

    /* renamed from: q  reason: collision with root package name */
    public final h1 f6122q = new SystemTimeProvider();

    /* renamed from: r  reason: collision with root package name */
    public m f6123r = m.f6243a;

    /* renamed from: s  reason: collision with root package name */
    public Executor f6124s = CameraXExecutors.directExecutor();

    /* renamed from: t  reason: collision with root package name */
    public InternalState f6125t;

    /* renamed from: u  reason: collision with root package name */
    public Range<Long> f6126u = E;

    /* renamed from: v  reason: collision with root package name */
    public long f6127v = 0;

    /* renamed from: w  reason: collision with root package name */
    public boolean f6128w = false;

    /* renamed from: x  reason: collision with root package name */
    public Long f6129x = null;

    /* renamed from: y  reason: collision with root package name */
    public Future<?> f6130y = null;

    /* renamed from: z  reason: collision with root package name */
    public e f6131z = null;

    public enum InternalState {
        CONFIGURED,
        STARTED,
        PAUSED,
        STOPPING,
        PENDING_START,
        PENDING_START_PAUSED,
        PENDING_RELEASE,
        ERROR,
        RELEASED
    }

    public class a implements FutureCallback<d1> {

        /* renamed from: androidx.camera.video.internal.encoder.EncoderImpl$a$a  reason: collision with other inner class name */
        public class C0012a implements FutureCallback<Void> {
            public C0012a() {
            }

            /* renamed from: a */
            public void onSuccess(Void voidR) {
            }

            public void onFailure(Throwable th2) {
                if (th2 instanceof MediaCodec.CodecException) {
                    EncoderImpl.this.D((MediaCodec.CodecException) th2);
                } else {
                    EncoderImpl.this.C(0, th2.getMessage(), th2);
                }
            }
        }

        public a() {
        }

        /* renamed from: a */
        public void onSuccess(d1 d1Var) {
            d1Var.e(EncoderImpl.this.A());
            d1Var.a(true);
            d1Var.b();
            Futures.addCallback(d1Var.c(), new C0012a(), EncoderImpl.this.f6113h);
        }

        public void onFailure(Throwable th2) {
            EncoderImpl.this.C(0, "Unable to acquire InputBuffer.", th2);
        }
    }

    public static /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f6134a;

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
                androidx.camera.video.internal.encoder.EncoderImpl$InternalState[] r0 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6134a = r0
                androidx.camera.video.internal.encoder.EncoderImpl$InternalState r1 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.CONFIGURED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f6134a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.video.internal.encoder.EncoderImpl$InternalState r1 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f6134a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.video.internal.encoder.EncoderImpl$InternalState r1 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.PAUSED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f6134a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.camera.video.internal.encoder.EncoderImpl$InternalState r1 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.STOPPING     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f6134a     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.camera.video.internal.encoder.EncoderImpl$InternalState r1 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.PENDING_START_PAUSED     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f6134a     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.camera.video.internal.encoder.EncoderImpl$InternalState r1 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.PENDING_START     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = f6134a     // Catch:{ NoSuchFieldError -> 0x0054 }
                androidx.camera.video.internal.encoder.EncoderImpl$InternalState r1 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.PENDING_RELEASE     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = f6134a     // Catch:{ NoSuchFieldError -> 0x0060 }
                androidx.camera.video.internal.encoder.EncoderImpl$InternalState r1 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.ERROR     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = f6134a     // Catch:{ NoSuchFieldError -> 0x006c }
                androidx.camera.video.internal.encoder.EncoderImpl$InternalState r1 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.RELEASED     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.encoder.EncoderImpl.b.<clinit>():void");
        }
    }

    public static class c {
        public static Surface a() {
            return MediaCodec.createPersistentInputSurface();
        }

        public static void b(MediaCodec mediaCodec, Surface surface) {
            mediaCodec.setInputSurface(surface);
        }
    }

    public class d implements k.a {

        /* renamed from: a  reason: collision with root package name */
        public final Map<Observable.Observer<? super BufferProvider.State>, Executor> f6135a = new LinkedHashMap();

        /* renamed from: b  reason: collision with root package name */
        public BufferProvider.State f6136b = BufferProvider.State.INACTIVE;

        /* renamed from: c  reason: collision with root package name */
        public final List<ListenableFuture<d1>> f6137c = new ArrayList();

        public d() {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void o(ListenableFuture listenableFuture) {
            this.f6137c.remove(listenableFuture);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void p(CallbackToFutureAdapter.a aVar) {
            BufferProvider.State state = this.f6136b;
            if (state == BufferProvider.State.ACTIVE) {
                ListenableFuture<d1> x11 = EncoderImpl.this.x();
                Futures.propagate(x11, aVar);
                aVar.a(new n0(this, x11), CameraXExecutors.directExecutor());
                this.f6137c.add(x11);
                x11.addListener(new m0(this, x11), EncoderImpl.this.f6113h);
            } else if (state == BufferProvider.State.INACTIVE) {
                aVar.f(new IllegalStateException("BufferProvider is not active."));
            } else {
                aVar.f(new IllegalStateException("Unknown state: " + this.f6136b));
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object q(CallbackToFutureAdapter.a aVar) throws Exception {
            EncoderImpl.this.f6113h.execute(new k0(this, aVar));
            return "acquireBuffer";
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void s(Observable.Observer observer, Executor executor) {
            this.f6135a.put((Observable.Observer) h.g(observer), (Executor) h.g(executor));
            executor.execute(new h0(observer, this.f6136b));
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void t(CallbackToFutureAdapter.a aVar) {
            aVar.c(this.f6136b);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object u(CallbackToFutureAdapter.a aVar) throws Exception {
            EncoderImpl.this.f6113h.execute(new l0(this, aVar));
            return "fetchData";
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void v(Observable.Observer observer) {
            this.f6135a.remove(h.g(observer));
        }

        public void addObserver(Executor executor, Observable.Observer<? super BufferProvider.State> observer) {
            EncoderImpl.this.f6113h.execute(new j0(this, observer, executor));
        }

        public ListenableFuture<d1> b() {
            return CallbackToFutureAdapter.a(new f0(this));
        }

        public ListenableFuture<BufferProvider.State> fetchData() {
            return CallbackToFutureAdapter.a(new g0(this));
        }

        /* renamed from: m */
        public final void n(ListenableFuture<d1> listenableFuture) {
            if (!listenableFuture.cancel(true)) {
                h.i(listenableFuture.isDone());
                try {
                    listenableFuture.get().cancel();
                } catch (InterruptedException | CancellationException | ExecutionException e11) {
                    String str = EncoderImpl.this.f6106a;
                    Logger.w(str, "Unable to cancel the input buffer: " + e11);
                }
            }
        }

        public void removeObserver(Observable.Observer<? super BufferProvider.State> observer) {
            EncoderImpl.this.f6113h.execute(new i0(this, observer));
        }

        public void x(boolean z11) {
            BufferProvider.State state = z11 ? BufferProvider.State.ACTIVE : BufferProvider.State.INACTIVE;
            if (this.f6136b != state) {
                this.f6136b = state;
                if (state == BufferProvider.State.INACTIVE) {
                    for (ListenableFuture<d1> cancel : this.f6137c) {
                        cancel.cancel(true);
                    }
                    this.f6137c.clear();
                }
                for (Map.Entry next : this.f6135a.entrySet()) {
                    try {
                        ((Executor) next.getValue()).execute(new o0(next, state));
                    } catch (RejectedExecutionException e11) {
                        Logger.e(EncoderImpl.this.f6106a, "Unable to post to the supplied executor.", e11);
                    }
                }
            }
        }
    }

    public class e extends MediaCodec.Callback {

        /* renamed from: a  reason: collision with root package name */
        public final d0.d f6139a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f6140b = false;

        /* renamed from: c  reason: collision with root package name */
        public boolean f6141c = false;

        /* renamed from: d  reason: collision with root package name */
        public boolean f6142d = false;

        /* renamed from: e  reason: collision with root package name */
        public long f6143e = 0;

        /* renamed from: f  reason: collision with root package name */
        public long f6144f = 0;

        /* renamed from: g  reason: collision with root package name */
        public boolean f6145g = false;

        /* renamed from: h  reason: collision with root package name */
        public boolean f6146h = false;

        /* renamed from: i  reason: collision with root package name */
        public boolean f6147i = false;

        public class a implements FutureCallback<Void> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ j f6149a;

            public a(j jVar) {
                this.f6149a = jVar;
            }

            /* renamed from: a */
            public void onSuccess(Void voidR) {
                EncoderImpl.this.f6119n.remove(this.f6149a);
            }

            public void onFailure(Throwable th2) {
                EncoderImpl.this.f6119n.remove(this.f6149a);
                if (th2 instanceof MediaCodec.CodecException) {
                    EncoderImpl.this.D((MediaCodec.CodecException) th2);
                } else {
                    EncoderImpl.this.C(0, th2.getMessage(), th2);
                }
            }
        }

        public e() {
            Timebase timebase = null;
            if (EncoderImpl.this.f6108c) {
                if (a0.a.a(CameraUseInconsistentTimebaseQuirk.class) != null) {
                    Logger.w(EncoderImpl.this.f6106a, "CameraUseInconsistentTimebaseQuirk is enabled");
                } else {
                    timebase = EncoderImpl.this.f6121p;
                }
                this.f6139a = new d0.d(EncoderImpl.this.f6122q, timebase);
                return;
            }
            this.f6139a = null;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void l(MediaCodec.CodecException codecException) {
            switch (b.f6134a[EncoderImpl.this.f6125t.ordinal()]) {
                case 1:
                case 8:
                case 9:
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    EncoderImpl.this.D(codecException);
                    return;
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.f6125t);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void m(int i11) {
            if (this.f6147i) {
                Logger.w(EncoderImpl.this.f6106a, "Receives input frame after codec is reset.");
                return;
            }
            switch (b.f6134a[EncoderImpl.this.f6125t.ordinal()]) {
                case 1:
                case 8:
                case 9:
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    EncoderImpl.this.f6116k.offer(Integer.valueOf(i11));
                    EncoderImpl.this.X();
                    return;
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.f6125t);
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void n(Executor executor, m mVar) {
            if (EncoderImpl.this.f6125t != InternalState.ERROR) {
                try {
                    Objects.requireNonNull(mVar);
                    executor.execute(new t0(mVar));
                } catch (RejectedExecutionException e11) {
                    Logger.e(EncoderImpl.this.f6106a, "Unable to post to the supplied executor.", e11);
                }
            }
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void o(MediaCodec.BufferInfo bufferInfo, MediaCodec mediaCodec, int i11) {
            m mVar;
            Executor executor;
            if (this.f6147i) {
                Logger.w(EncoderImpl.this.f6106a, "Receives frame after codec is reset.");
                return;
            }
            switch (b.f6134a[EncoderImpl.this.f6125t.ordinal()]) {
                case 1:
                case 8:
                case 9:
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    synchronized (EncoderImpl.this.f6107b) {
                        EncoderImpl encoderImpl = EncoderImpl.this;
                        mVar = encoderImpl.f6123r;
                        executor = encoderImpl.f6124s;
                    }
                    if (!this.f6140b) {
                        this.f6140b = true;
                        try {
                            Objects.requireNonNull(mVar);
                            executor.execute(new s0(mVar));
                        } catch (RejectedExecutionException e11) {
                            Logger.e(EncoderImpl.this.f6106a, "Unable to post to the supplied executor.", e11);
                        }
                    }
                    if (i(bufferInfo)) {
                        if (!this.f6141c) {
                            this.f6141c = true;
                            String str = EncoderImpl.this.f6106a;
                            Logger.d(str, "data timestampUs = " + bufferInfo.presentationTimeUs + ", data timebase = " + EncoderImpl.this.f6121p + ", current system uptimeMs = " + SystemClock.uptimeMillis() + ", current system realtimeMs = " + SystemClock.elapsedRealtime());
                        }
                        MediaCodec.BufferInfo t11 = t(bufferInfo);
                        this.f6144f = t11.presentationTimeUs;
                        try {
                            u(new j(mediaCodec, i11, t11), mVar, executor);
                        } catch (MediaCodec.CodecException e12) {
                            EncoderImpl.this.D(e12);
                            return;
                        }
                    } else if (i11 != -9999) {
                        try {
                            EncoderImpl.this.f6110e.releaseOutputBuffer(i11, false);
                        } catch (MediaCodec.CodecException e13) {
                            EncoderImpl.this.D(e13);
                            return;
                        }
                    }
                    if (!this.f6142d && j(bufferInfo)) {
                        this.f6142d = true;
                        EncoderImpl.this.h0(new q0(this, executor, mVar));
                        return;
                    }
                    return;
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.f6125t);
            }
        }

        public static /* synthetic */ MediaFormat p(MediaFormat mediaFormat) {
            return mediaFormat;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void r(MediaFormat mediaFormat) {
            m mVar;
            Executor executor;
            if (this.f6147i) {
                Logger.w(EncoderImpl.this.f6106a, "Receives onOutputFormatChanged after codec is reset.");
                return;
            }
            switch (b.f6134a[EncoderImpl.this.f6125t.ordinal()]) {
                case 1:
                case 8:
                case 9:
                    return;
                case 2:
                case 3:
                case 4:
                case 5:
                case 6:
                case 7:
                    synchronized (EncoderImpl.this.f6107b) {
                        EncoderImpl encoderImpl = EncoderImpl.this;
                        mVar = encoderImpl.f6123r;
                        executor = encoderImpl.f6124s;
                    }
                    try {
                        executor.execute(new u0(mVar, mediaFormat));
                        return;
                    } catch (RejectedExecutionException e11) {
                        Logger.e(EncoderImpl.this.f6106a, "Unable to post to the supplied executor.", e11);
                        return;
                    }
                default:
                    throw new IllegalStateException("Unknown state: " + EncoderImpl.this.f6125t);
            }
        }

        public final boolean i(MediaCodec.BufferInfo bufferInfo) {
            if (this.f6142d) {
                Logger.d(EncoderImpl.this.f6106a, "Drop buffer by already reach end of stream.");
                return false;
            } else if (bufferInfo.size <= 0) {
                Logger.d(EncoderImpl.this.f6106a, "Drop buffer by invalid buffer size.");
                return false;
            } else if ((bufferInfo.flags & 2) != 0) {
                Logger.d(EncoderImpl.this.f6106a, "Drop buffer by codec config.");
                return false;
            } else {
                d0.d dVar = this.f6139a;
                if (dVar != null) {
                    bufferInfo.presentationTimeUs = dVar.b(bufferInfo.presentationTimeUs);
                }
                long j11 = bufferInfo.presentationTimeUs;
                if (j11 <= this.f6143e) {
                    Logger.d(EncoderImpl.this.f6106a, "Drop buffer by out of order buffer from MediaCodec.");
                    return false;
                }
                this.f6143e = j11;
                if (!EncoderImpl.this.f6126u.contains(Long.valueOf(j11))) {
                    Logger.d(EncoderImpl.this.f6106a, "Drop buffer by not in start-stop range.");
                    EncoderImpl encoderImpl = EncoderImpl.this;
                    if (encoderImpl.f6128w && bufferInfo.presentationTimeUs >= encoderImpl.f6126u.getUpper().longValue()) {
                        Future<?> future = EncoderImpl.this.f6130y;
                        if (future != null) {
                            future.cancel(true);
                        }
                        EncoderImpl.this.f6129x = Long.valueOf(bufferInfo.presentationTimeUs);
                        EncoderImpl.this.e0();
                        EncoderImpl.this.f6128w = false;
                    }
                    return false;
                } else if (w(bufferInfo)) {
                    Logger.d(EncoderImpl.this.f6106a, "Drop buffer by pause.");
                    return false;
                } else if (EncoderImpl.this.B(bufferInfo) <= this.f6144f) {
                    Logger.d(EncoderImpl.this.f6106a, "Drop buffer by adjusted time is less than the last sent time.");
                    if (EncoderImpl.this.f6108c && EncoderImpl.H(bufferInfo)) {
                        this.f6146h = true;
                    }
                    return false;
                } else {
                    if (!this.f6141c && !this.f6146h && EncoderImpl.this.f6108c) {
                        this.f6146h = true;
                    }
                    if (this.f6146h) {
                        if (!EncoderImpl.H(bufferInfo)) {
                            Logger.d(EncoderImpl.this.f6106a, "Drop buffer by not a key frame.");
                            EncoderImpl.this.a0();
                            return false;
                        }
                        this.f6146h = false;
                    }
                    return true;
                }
            }
        }

        public final boolean j(MediaCodec.BufferInfo bufferInfo) {
            return EncoderImpl.F(bufferInfo) || k(bufferInfo);
        }

        public final boolean k(MediaCodec.BufferInfo bufferInfo) {
            EncoderImpl encoderImpl = EncoderImpl.this;
            return encoderImpl.C && bufferInfo.presentationTimeUs > encoderImpl.f6126u.getUpper().longValue();
        }

        public void onError(MediaCodec mediaCodec, MediaCodec.CodecException codecException) {
            EncoderImpl.this.f6113h.execute(new y0(this, codecException));
        }

        public void onInputBufferAvailable(MediaCodec mediaCodec, int i11) {
            EncoderImpl.this.f6113h.execute(new w0(this, i11));
        }

        public void onOutputBufferAvailable(MediaCodec mediaCodec, int i11, MediaCodec.BufferInfo bufferInfo) {
            EncoderImpl.this.f6113h.execute(new x0(this, bufferInfo, mediaCodec, i11));
        }

        public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
            EncoderImpl.this.f6113h.execute(new z0(this, mediaFormat));
        }

        public final MediaCodec.BufferInfo t(MediaCodec.BufferInfo bufferInfo) {
            long B = EncoderImpl.this.B(bufferInfo);
            if (bufferInfo.presentationTimeUs == B) {
                return bufferInfo;
            }
            h.i(B > this.f6144f);
            MediaCodec.BufferInfo bufferInfo2 = new MediaCodec.BufferInfo();
            bufferInfo2.set(bufferInfo.offset, bufferInfo.size, B, bufferInfo.flags);
            return bufferInfo2;
        }

        public final void u(j jVar, m mVar, Executor executor) {
            EncoderImpl.this.f6119n.add(jVar);
            Futures.addCallback(jVar.b(), new a(jVar), EncoderImpl.this.f6113h);
            try {
                executor.execute(new v0(mVar, jVar));
            } catch (RejectedExecutionException e11) {
                Logger.e(EncoderImpl.this.f6106a, "Unable to post to the supplied executor.", e11);
                jVar.close();
            }
        }

        public void v() {
            this.f6147i = true;
        }

        public final boolean w(MediaCodec.BufferInfo bufferInfo) {
            Executor executor;
            m mVar;
            EncoderImpl.this.i0(bufferInfo.presentationTimeUs);
            boolean G = EncoderImpl.this.G(bufferInfo.presentationTimeUs);
            boolean z11 = this.f6145g;
            if (!z11 && G) {
                Logger.d(EncoderImpl.this.f6106a, "Switch to pause state");
                this.f6145g = true;
                synchronized (EncoderImpl.this.f6107b) {
                    EncoderImpl encoderImpl = EncoderImpl.this;
                    executor = encoderImpl.f6124s;
                    mVar = encoderImpl.f6123r;
                }
                Objects.requireNonNull(mVar);
                executor.execute(new r0(mVar));
                EncoderImpl encoderImpl2 = EncoderImpl.this;
                if (encoderImpl2.f6125t == InternalState.PAUSED && ((encoderImpl2.f6108c || a0.a.a(AudioEncoderIgnoresInputTimestampQuirk.class) == null) && (!EncoderImpl.this.f6108c || a0.a.a(VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk.class) == null))) {
                    k.b bVar = EncoderImpl.this.f6111f;
                    if (bVar instanceof d) {
                        ((d) bVar).x(false);
                    }
                    EncoderImpl.this.c0(true);
                }
                EncoderImpl.this.f6129x = Long.valueOf(bufferInfo.presentationTimeUs);
                EncoderImpl encoderImpl3 = EncoderImpl.this;
                if (encoderImpl3.f6128w) {
                    Future<?> future = encoderImpl3.f6130y;
                    if (future != null) {
                        future.cancel(true);
                    }
                    EncoderImpl.this.e0();
                    EncoderImpl.this.f6128w = false;
                }
            } else if (z11 && !G) {
                Logger.d(EncoderImpl.this.f6106a, "Switch to resume state");
                this.f6145g = false;
                if (EncoderImpl.this.f6108c && !EncoderImpl.H(bufferInfo)) {
                    this.f6146h = true;
                }
            }
            return this.f6145g;
        }
    }

    public class f implements k.c {

        /* renamed from: a  reason: collision with root package name */
        public final Object f6151a = new Object();

        /* renamed from: b  reason: collision with root package name */
        public Surface f6152b;

        /* renamed from: c  reason: collision with root package name */
        public final Set<Surface> f6153c = new HashSet();

        /* renamed from: d  reason: collision with root package name */
        public k.c.a f6154d;

        /* renamed from: e  reason: collision with root package name */
        public Executor f6155e;

        public f() {
        }

        public void a(Executor executor, k.c.a aVar) {
            Surface surface;
            synchronized (this.f6151a) {
                this.f6154d = (k.c.a) h.g(aVar);
                this.f6155e = (Executor) h.g(executor);
                surface = this.f6152b;
            }
            if (surface != null) {
                d(executor, aVar, surface);
            }
        }

        public final void d(Executor executor, k.c.a aVar, Surface surface) {
            try {
                executor.execute(new a1(aVar, surface));
            } catch (RejectedExecutionException e11) {
                Logger.e(EncoderImpl.this.f6106a, "Unable to post to the supplied executor.", e11);
            }
        }

        public void e() {
            Surface surface;
            HashSet<Surface> hashSet;
            synchronized (this.f6151a) {
                surface = this.f6152b;
                this.f6152b = null;
                hashSet = new HashSet<>(this.f6153c);
                this.f6153c.clear();
            }
            if (surface != null) {
                surface.release();
            }
            for (Surface release : hashSet) {
                release.release();
            }
        }

        @SuppressLint({"NewApi"})
        public void f() {
            Surface surface;
            k.c.a aVar;
            Executor executor;
            EncoderNotUsePersistentInputSurfaceQuirk encoderNotUsePersistentInputSurfaceQuirk = (EncoderNotUsePersistentInputSurfaceQuirk) a0.a.a(EncoderNotUsePersistentInputSurfaceQuirk.class);
            synchronized (this.f6151a) {
                if (encoderNotUsePersistentInputSurfaceQuirk == null) {
                    if (this.f6152b == null) {
                        surface = c.a();
                        this.f6152b = surface;
                    } else {
                        surface = null;
                    }
                    c.b(EncoderImpl.this.f6110e, this.f6152b);
                } else {
                    Surface surface2 = this.f6152b;
                    if (surface2 != null) {
                        this.f6153c.add(surface2);
                    }
                    surface = EncoderImpl.this.f6110e.createInputSurface();
                    this.f6152b = surface;
                }
                aVar = this.f6154d;
                executor = this.f6155e;
            }
            if (surface != null && aVar != null && executor != null) {
                d(executor, aVar, surface);
            }
        }
    }

    public EncoderImpl(Executor executor, n nVar) throws InvalidConfigException {
        EncoderFinder encoderFinder = new EncoderFinder();
        this.D = encoderFinder;
        h.g(executor);
        h.g(nVar);
        this.f6113h = CameraXExecutors.newSequentialExecutor(executor);
        if (nVar instanceof a) {
            this.f6106a = "AudioEncoder";
            this.f6108c = false;
            this.f6111f = new d();
        } else if (nVar instanceof i1) {
            this.f6106a = "VideoEncoder";
            this.f6108c = true;
            this.f6111f = new f();
        } else {
            throw new InvalidConfigException("Unknown encoder config type");
        }
        Timebase a11 = nVar.a();
        this.f6121p = a11;
        String str = this.f6106a;
        Logger.d(str, "mInputTimebase = " + a11);
        MediaFormat b11 = nVar.b();
        this.f6109d = b11;
        String str2 = this.f6106a;
        Logger.d(str2, "mMediaFormat = " + b11);
        MediaCodec a12 = encoderFinder.a(b11);
        this.f6110e = a12;
        String str3 = this.f6106a;
        Logger.i(str3, "Selected encoder: " + a12.getName());
        b1 z11 = z(this.f6108c, a12.getCodecInfo(), nVar.getMimeType());
        this.f6112g = z11;
        if (this.f6108c) {
            y((k1) z11, b11);
        }
        try {
            b0();
            AtomicReference atomicReference = new AtomicReference();
            this.f6114i = Futures.nonCancellationPropagating(CallbackToFutureAdapter.a(new p(atomicReference)));
            this.f6115j = (CallbackToFutureAdapter.a) h.g((CallbackToFutureAdapter.a) atomicReference.get());
            d0(InternalState.CONFIGURED);
        } catch (MediaCodec.CodecException e11) {
            throw new InvalidConfigException((Throwable) e11);
        }
    }

    public static boolean F(MediaCodec.BufferInfo bufferInfo) {
        return (bufferInfo.flags & 4) != 0;
    }

    public static boolean H(MediaCodec.BufferInfo bufferInfo) {
        return (bufferInfo.flags & 1) != 0;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void J(CallbackToFutureAdapter.a aVar) {
        this.f6117l.remove(aVar);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L(f1 f1Var) {
        this.f6118m.remove(f1Var);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void O(long j11) {
        switch (b.f6134a[this.f6125t.ordinal()]) {
            case 1:
            case 3:
            case 4:
            case 5:
            case 8:
                return;
            case 2:
                String str = this.f6106a;
                Logger.d(str, "Pause on " + y.d.j(j11));
                this.f6120o.addLast(Range.create(Long.valueOf(j11), Long.MAX_VALUE));
                d0(InternalState.PAUSED);
                return;
            case 6:
                d0(InternalState.PENDING_START_PAUSED);
                return;
            case 7:
            case 9:
                throw new IllegalStateException("Encoder is released");
            default:
                throw new IllegalStateException("Unknown state: " + this.f6125t);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void P() {
        switch (b.f6134a[this.f6125t.ordinal()]) {
            case 1:
            case 2:
            case 3:
            case 8:
                Z();
                return;
            case 4:
            case 5:
            case 6:
                d0(InternalState.PENDING_RELEASE);
                return;
            case 7:
            case 9:
                return;
            default:
                throw new IllegalStateException("Unknown state: " + this.f6125t);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q() {
        int i11 = b.f6134a[this.f6125t.ordinal()];
        if (i11 == 2) {
            a0();
        } else if (i11 == 7 || i11 == 9) {
            throw new IllegalStateException("Encoder is released");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void R() {
        this.B = true;
        if (this.A) {
            this.f6110e.stop();
            b0();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S(long j11) {
        switch (b.f6134a[this.f6125t.ordinal()]) {
            case 1:
                this.f6129x = null;
                String str = this.f6106a;
                Logger.d(str, "Start on " + y.d.j(j11));
                try {
                    if (this.A) {
                        b0();
                    }
                    this.f6126u = Range.create(Long.valueOf(j11), Long.MAX_VALUE);
                    this.f6110e.start();
                    k.b bVar = this.f6111f;
                    if (bVar instanceof d) {
                        ((d) bVar).x(true);
                    }
                    d0(InternalState.STARTED);
                    return;
                } catch (MediaCodec.CodecException e11) {
                    D(e11);
                    return;
                }
            case 2:
            case 6:
            case 8:
                return;
            case 3:
                this.f6129x = null;
                Range removeLast = this.f6120o.removeLast();
                h.j(removeLast != null && ((Long) removeLast.getUpper()).longValue() == Long.MAX_VALUE, "There should be a \"pause\" before \"resume\"");
                long longValue = ((Long) removeLast.getLower()).longValue();
                this.f6120o.addLast(Range.create(Long.valueOf(longValue), Long.valueOf(j11)));
                String str2 = this.f6106a;
                Logger.d(str2, "Resume on " + y.d.j(j11) + "\nPaused duration = " + y.d.j(j11 - longValue));
                if ((this.f6108c || a0.a.a(AudioEncoderIgnoresInputTimestampQuirk.class) == null) && (!this.f6108c || a0.a.a(VideoEncoderSuspendDoesNotIncludeSuspendTimeQuirk.class) == null)) {
                    c0(false);
                    k.b bVar2 = this.f6111f;
                    if (bVar2 instanceof d) {
                        ((d) bVar2).x(true);
                    }
                }
                if (this.f6108c) {
                    a0();
                }
                d0(InternalState.STARTED);
                return;
            case 4:
            case 5:
                d0(InternalState.PENDING_START);
                return;
            case 7:
            case 9:
                throw new IllegalStateException("Encoder is released");
            default:
                throw new IllegalStateException("Unknown state: " + this.f6125t);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void T() {
        if (this.f6128w) {
            Logger.w(this.f6106a, "The data didn't reach the expected timestamp before timeout, stop the codec.");
            this.f6129x = null;
            e0();
            this.f6128w = false;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void U() {
        this.f6113h.execute(new y(this));
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00b3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ void V(long r6, long r8) {
        /*
            r5 = this;
            int[] r0 = androidx.camera.video.internal.encoder.EncoderImpl.b.f6134a
            androidx.camera.video.internal.encoder.EncoderImpl$InternalState r1 = r5.f6125t
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x00c3;
                case 2: goto L_0x0035;
                case 3: goto L_0x0035;
                case 4: goto L_0x00c3;
                case 5: goto L_0x002e;
                case 6: goto L_0x002e;
                case 7: goto L_0x0026;
                case 8: goto L_0x00c3;
                case 9: goto L_0x0026;
                default: goto L_0x000d;
            }
        L_0x000d:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Unknown state: "
            r7.append(r8)
            androidx.camera.video.internal.encoder.EncoderImpl$InternalState r8 = r5.f6125t
            r7.append(r8)
            java.lang.String r7 = r7.toString()
            r6.<init>(r7)
            throw r6
        L_0x0026:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "Encoder is released"
            r6.<init>(r7)
            throw r6
        L_0x002e:
            androidx.camera.video.internal.encoder.EncoderImpl$InternalState r6 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.CONFIGURED
            r5.d0(r6)
            goto L_0x00c3
        L_0x0035:
            androidx.camera.video.internal.encoder.EncoderImpl$InternalState r0 = r5.f6125t
            androidx.camera.video.internal.encoder.EncoderImpl$InternalState r1 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.STOPPING
            r5.d0(r1)
            android.util.Range<java.lang.Long> r1 = r5.f6126u
            java.lang.Comparable r1 = r1.getLower()
            java.lang.Long r1 = (java.lang.Long) r1
            long r1 = r1.longValue()
            r3 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r3 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r3 == 0) goto L_0x00bb
            r3 = -1
            int r3 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r3 != 0) goto L_0x0058
            goto L_0x0063
        L_0x0058:
            int r3 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r3 >= 0) goto L_0x0064
            java.lang.String r6 = r5.f6106a
            java.lang.String r7 = "The expected stop time is less than the start time. Use current time as stop time."
            androidx.camera.core.Logger.w(r6, r7)
        L_0x0063:
            r6 = r8
        L_0x0064:
            int r8 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r8 < 0) goto L_0x00b3
            java.lang.Long r8 = java.lang.Long.valueOf(r1)
            java.lang.Long r9 = java.lang.Long.valueOf(r6)
            android.util.Range r8 = android.util.Range.create(r8, r9)
            r5.f6126u = r8
            java.lang.String r8 = r5.f6106a
            java.lang.StringBuilder r9 = new java.lang.StringBuilder
            r9.<init>()
            java.lang.String r1 = "Stop on "
            r9.append(r1)
            java.lang.String r6 = y.d.j(r6)
            r9.append(r6)
            java.lang.String r6 = r9.toString()
            androidx.camera.core.Logger.d(r8, r6)
            androidx.camera.video.internal.encoder.EncoderImpl$InternalState r6 = androidx.camera.video.internal.encoder.EncoderImpl.InternalState.PAUSED
            if (r0 != r6) goto L_0x009c
            java.lang.Long r6 = r5.f6129x
            if (r6 == 0) goto L_0x009c
            r5.e0()
            goto L_0x00c3
        L_0x009c:
            r6 = 1
            r5.f6128w = r6
            java.util.concurrent.ScheduledExecutorService r6 = androidx.camera.core.impl.utils.executor.CameraXExecutors.mainThreadExecutor()
            androidx.camera.video.internal.encoder.z r7 = new androidx.camera.video.internal.encoder.z
            r7.<init>(r5)
            r8 = 1000(0x3e8, double:4.94E-321)
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS
            java.util.concurrent.ScheduledFuture r6 = r6.schedule(r7, r8, r0)
            r5.f6130y = r6
            goto L_0x00c3
        L_0x00b3:
            java.lang.AssertionError r6 = new java.lang.AssertionError
            java.lang.String r7 = "The start time should be before the stop time."
            r6.<init>(r7)
            throw r6
        L_0x00bb:
            java.lang.AssertionError r6 = new java.lang.AssertionError
            java.lang.String r7 = "There should be a \"start\" before \"stop\""
            r6.<init>(r7)
            throw r6
        L_0x00c3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.encoder.EncoderImpl.V(long, long):void");
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void W(List list, Runnable runnable) {
        if (this.f6125t != InternalState.ERROR) {
            if (!list.isEmpty()) {
                Logger.d(this.f6106a, "encoded data and input buffers are returned");
            }
            if (!(this.f6111f instanceof f) || this.B) {
                this.f6110e.stop();
            } else {
                this.f6110e.flush();
                this.A = true;
            }
        }
        if (runnable != null) {
            runnable.run();
        }
        E();
    }

    public static b1 z(boolean z11, MediaCodecInfo mediaCodecInfo, String str) throws InvalidConfigException {
        if (z11) {
            return new l1(mediaCodecInfo, str);
        }
        return new b(mediaCodecInfo, str);
    }

    public long A() {
        return this.f6122q.b();
    }

    public long B(MediaCodec.BufferInfo bufferInfo) {
        long j11 = this.f6127v;
        if (j11 > 0) {
            return bufferInfo.presentationTimeUs - j11;
        }
        return bufferInfo.presentationTimeUs;
    }

    public void C(int i11, String str, Throwable th2) {
        switch (b.f6134a[this.f6125t.ordinal()]) {
            case 1:
                K(i11, str, th2);
                b0();
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                d0(InternalState.ERROR);
                h0(new e0(this, i11, str, th2));
                return;
            case 8:
                String str2 = this.f6106a;
                Logger.w(str2, "Get more than one error: " + str + "(" + i11 + ")", th2);
                return;
            default:
                return;
        }
    }

    public void D(MediaCodec.CodecException codecException) {
        C(1, codecException.getMessage(), codecException);
    }

    public void E() {
        InternalState internalState = this.f6125t;
        if (internalState == InternalState.PENDING_RELEASE) {
            Z();
            return;
        }
        if (!this.A) {
            b0();
        }
        d0(InternalState.CONFIGURED);
        if (internalState == InternalState.PENDING_START || internalState == InternalState.PENDING_START_PAUSED) {
            start();
            if (internalState == InternalState.PENDING_START_PAUSED) {
                pause();
            }
        }
    }

    public boolean G(long j11) {
        for (Range next : this.f6120o) {
            if (!next.contains(Long.valueOf(j11))) {
                if (j11 < ((Long) next.getLower()).longValue()) {
                    break;
                }
            } else {
                return true;
            }
        }
        return false;
    }

    public void X() {
        while (!this.f6117l.isEmpty() && !this.f6116k.isEmpty()) {
            CallbackToFutureAdapter.a poll = this.f6117l.poll();
            Objects.requireNonNull(poll);
            Integer poll2 = this.f6116k.poll();
            Objects.requireNonNull(poll2);
            try {
                f1 f1Var = new f1(this.f6110e, poll2.intValue());
                if (poll.c(f1Var)) {
                    this.f6118m.add(f1Var);
                    f1Var.c().addListener(new t(this, f1Var), this.f6113h);
                } else {
                    f1Var.cancel();
                }
            } catch (MediaCodec.CodecException e11) {
                D(e11);
                return;
            }
        }
    }

    /* renamed from: Y */
    public void K(int i11, String str, Throwable th2) {
        m mVar;
        Executor executor;
        synchronized (this.f6107b) {
            mVar = this.f6123r;
            executor = this.f6124s;
        }
        try {
            executor.execute(new x(mVar, i11, str, th2));
        } catch (RejectedExecutionException e11) {
            Logger.e(this.f6106a, "Unable to post to the supplied executor.", e11);
        }
    }

    public final void Z() {
        if (this.A) {
            this.f6110e.stop();
            this.A = false;
        }
        this.f6110e.release();
        k.b bVar = this.f6111f;
        if (bVar instanceof f) {
            ((f) bVar).e();
        }
        d0(InternalState.RELEASED);
        this.f6115j.c(null);
    }

    public void a(m mVar, Executor executor) {
        synchronized (this.f6107b) {
            this.f6123r = mVar;
            this.f6124s = executor;
        }
    }

    public void a0() {
        Bundle bundle = new Bundle();
        bundle.putInt("request-sync", 0);
        this.f6110e.setParameters(bundle);
    }

    public void b(long j11) {
        this.f6113h.execute(new s(this, j11, A()));
    }

    public final void b0() {
        this.f6126u = E;
        this.f6127v = 0;
        this.f6120o.clear();
        this.f6116k.clear();
        for (CallbackToFutureAdapter.a d11 : this.f6117l) {
            d11.d();
        }
        this.f6117l.clear();
        this.f6110e.reset();
        this.A = false;
        this.B = false;
        this.C = false;
        this.f6128w = false;
        Future<?> future = this.f6130y;
        if (future != null) {
            future.cancel(true);
            this.f6130y = null;
        }
        e eVar = this.f6131z;
        if (eVar != null) {
            eVar.v();
        }
        e eVar2 = new e();
        this.f6131z = eVar2;
        this.f6110e.setCallback(eVar2);
        this.f6110e.configure(this.f6109d, (Surface) null, (MediaCrypto) null, 1);
        k.b bVar = this.f6111f;
        if (bVar instanceof f) {
            ((f) bVar).f();
        }
    }

    public b1 c() {
        return this.f6112g;
    }

    public void c0(boolean z11) {
        Bundle bundle = new Bundle();
        bundle.putInt("drop-input-frames", z11 ? 1 : 0);
        this.f6110e.setParameters(bundle);
    }

    public k.b d() {
        return this.f6111f;
    }

    public final void d0(InternalState internalState) {
        if (this.f6125t != internalState) {
            String str = this.f6106a;
            Logger.d(str, "Transitioning encoder internal state: " + this.f6125t + " --> " + internalState);
            this.f6125t = internalState;
        }
    }

    public ListenableFuture<Void> e() {
        return this.f6114i;
    }

    public void e0() {
        k.b bVar = this.f6111f;
        if (bVar instanceof d) {
            ((d) bVar).x(false);
            ArrayList arrayList = new ArrayList();
            for (d1 c11 : this.f6118m) {
                arrayList.add(c11.c());
            }
            Futures.successfulAsList(arrayList).addListener(new c0(this), this.f6113h);
        } else if (bVar instanceof f) {
            try {
                this.f6110e.signalEndOfInputStream();
                this.C = true;
            } catch (MediaCodec.CodecException e11) {
                D(e11);
            }
        }
    }

    public void f() {
        this.f6113h.execute(new b0(this));
    }

    public final void f0() {
        Futures.addCallback(x(), new a(), this.f6113h);
    }

    public int g() {
        if (this.f6109d.containsKey("bitrate")) {
            return this.f6109d.getInteger("bitrate");
        }
        return 0;
    }

    public void g0() {
        this.f6113h.execute(new d0(this));
    }

    public void h0(Runnable runnable) {
        ArrayList arrayList = new ArrayList();
        for (j b11 : this.f6119n) {
            arrayList.add(b11.b());
        }
        for (d1 c11 : this.f6118m) {
            arrayList.add(c11.c());
        }
        if (!arrayList.isEmpty()) {
            String str = this.f6106a;
            Logger.d(str, "Waiting for resources to return. encoded data = " + this.f6119n.size() + ", input buffers = " + this.f6118m.size());
        }
        Futures.successfulAsList(arrayList).addListener(new v(this, arrayList, runnable), this.f6113h);
    }

    public void i0(long j11) {
        while (!this.f6120o.isEmpty()) {
            Range first = this.f6120o.getFirst();
            if (j11 > ((Long) first.getUpper()).longValue()) {
                this.f6120o.removeFirst();
                this.f6127v += ((Long) first.getUpper()).longValue() - ((Long) first.getLower()).longValue();
                Logger.d(this.f6106a, "Total paused duration = " + y.d.j(this.f6127v));
            } else {
                return;
            }
        }
    }

    public void pause() {
        this.f6113h.execute(new r(this, A()));
    }

    public void release() {
        this.f6113h.execute(new a0(this));
    }

    public void start() {
        this.f6113h.execute(new q(this, A()));
    }

    public ListenableFuture<d1> x() {
        switch (b.f6134a[this.f6125t.ordinal()]) {
            case 1:
                return Futures.immediateFailedFuture(new IllegalStateException("Encoder is not started yet."));
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                AtomicReference atomicReference = new AtomicReference();
                ListenableFuture<d1> a11 = CallbackToFutureAdapter.a(new w(atomicReference));
                CallbackToFutureAdapter.a aVar = (CallbackToFutureAdapter.a) h.g((CallbackToFutureAdapter.a) atomicReference.get());
                this.f6117l.offer(aVar);
                aVar.a(new u(this, aVar), this.f6113h);
                X();
                return a11;
            case 8:
                return Futures.immediateFailedFuture(new IllegalStateException("Encoder is in error state."));
            case 9:
                return Futures.immediateFailedFuture(new IllegalStateException("Encoder is released."));
            default:
                throw new IllegalStateException("Unknown state: " + this.f6125t);
        }
    }

    public final void y(k1 k1Var, MediaFormat mediaFormat) {
        h.i(this.f6108c);
        if (mediaFormat.containsKey("bitrate")) {
            int integer = mediaFormat.getInteger("bitrate");
            int intValue = k1Var.b().clamp(Integer.valueOf(integer)).intValue();
            if (integer != intValue) {
                mediaFormat.setInteger("bitrate", intValue);
                String str = this.f6106a;
                Logger.d(str, "updated bitrate from " + integer + " to " + intValue);
            }
        }
    }
}
