package androidx.camera.video.internal.audio;

import android.content.Context;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.video.internal.BufferProvider;
import androidx.camera.video.internal.audio.AudioStream;
import androidx.camera.video.internal.encoder.d1;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.h;
import com.google.common.util.concurrent.ListenableFuture;
import java.nio.ByteBuffer;
import java.nio.ShortBuffer;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class AudioSource {

    /* renamed from: a  reason: collision with root package name */
    public final Executor f5976a;

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<Boolean> f5977b;

    /* renamed from: c  reason: collision with root package name */
    public final AtomicBoolean f5978c;

    /* renamed from: d  reason: collision with root package name */
    public final AudioStream f5979d;

    /* renamed from: e  reason: collision with root package name */
    public final c0 f5980e;

    /* renamed from: f  reason: collision with root package name */
    public final long f5981f;

    /* renamed from: g  reason: collision with root package name */
    public InternalState f5982g;

    /* renamed from: h  reason: collision with root package name */
    public BufferProvider.State f5983h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f5984i;

    /* renamed from: j  reason: collision with root package name */
    public Executor f5985j;

    /* renamed from: k  reason: collision with root package name */
    public d f5986k;

    /* renamed from: l  reason: collision with root package name */
    public BufferProvider<? extends d1> f5987l;

    /* renamed from: m  reason: collision with root package name */
    public FutureCallback<d1> f5988m;

    /* renamed from: n  reason: collision with root package name */
    public Observable.Observer<BufferProvider.State> f5989n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f5990o;

    /* renamed from: p  reason: collision with root package name */
    public long f5991p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f5992q;

    /* renamed from: r  reason: collision with root package name */
    public boolean f5993r;

    /* renamed from: s  reason: collision with root package name */
    public byte[] f5994s;

    /* renamed from: t  reason: collision with root package name */
    public double f5995t;

    /* renamed from: u  reason: collision with root package name */
    public long f5996u;

    /* renamed from: v  reason: collision with root package name */
    public final int f5997v;

    public enum InternalState {
        CONFIGURED,
        STARTED,
        RELEASED
    }

    public class a implements Observable.Observer<BufferProvider.State> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BufferProvider f5998a;

        public a(BufferProvider bufferProvider) {
            this.f5998a = bufferProvider;
        }

        /* renamed from: a */
        public void onNewData(BufferProvider.State state) {
            Objects.requireNonNull(state);
            if (AudioSource.this.f5987l == this.f5998a) {
                Logger.d("AudioSource", "Receive BufferProvider state change: " + AudioSource.this.f5983h + " to " + state);
                AudioSource audioSource = AudioSource.this;
                if (audioSource.f5983h != state) {
                    audioSource.f5983h = state;
                    audioSource.S();
                }
            }
        }

        public void onError(Throwable th2) {
            AudioSource audioSource = AudioSource.this;
            if (audioSource.f5987l == this.f5998a) {
                audioSource.C(th2);
            }
        }
    }

    public class b implements FutureCallback<d1> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BufferProvider f6000a;

        public b(BufferProvider bufferProvider) {
            this.f6000a = bufferProvider;
        }

        /* renamed from: a */
        public void onSuccess(d1 d1Var) {
            AudioSource audioSource = AudioSource.this;
            if (!audioSource.f5984i || audioSource.f5987l != this.f6000a) {
                d1Var.cancel();
                return;
            }
            if (audioSource.f5990o && audioSource.p()) {
                AudioSource.this.J();
            }
            AudioStream m11 = AudioSource.this.m();
            ByteBuffer d11 = d1Var.d();
            AudioStream.PacketInfo read = m11.read(d11);
            if (read.a() > 0) {
                AudioSource audioSource2 = AudioSource.this;
                if (audioSource2.f5993r) {
                    audioSource2.F(d11, read.a());
                }
                if (AudioSource.this.f5985j != null) {
                    long b11 = read.b();
                    AudioSource audioSource3 = AudioSource.this;
                    if (b11 - audioSource3.f5996u >= 200) {
                        audioSource3.f5996u = read.b();
                        AudioSource.this.G(d11);
                    }
                }
                d11.limit(d11.position() + read.a());
                d1Var.e(TimeUnit.NANOSECONDS.toMicros(read.b()));
                d1Var.b();
            } else {
                Logger.w("AudioSource", "Unable to read data from AudioStream.");
                d1Var.cancel();
            }
            AudioSource.this.K();
        }

        public void onFailure(Throwable th2) {
            if (AudioSource.this.f5987l == this.f6000a) {
                Logger.d("AudioSource", "Unable to get input buffer, the BufferProvider could be transitioning to INACTIVE state.");
                if (!(th2 instanceof IllegalStateException)) {
                    AudioSource.this.C(th2);
                }
            }
        }
    }

    public static /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f6002a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                androidx.camera.video.internal.audio.AudioSource$InternalState[] r0 = androidx.camera.video.internal.audio.AudioSource.InternalState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f6002a = r0
                androidx.camera.video.internal.audio.AudioSource$InternalState r1 = androidx.camera.video.internal.audio.AudioSource.InternalState.CONFIGURED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f6002a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.video.internal.audio.AudioSource$InternalState r1 = androidx.camera.video.internal.audio.AudioSource.InternalState.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f6002a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.video.internal.audio.AudioSource$InternalState r1 = androidx.camera.video.internal.audio.AudioSource.InternalState.RELEASED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.internal.audio.AudioSource.c.<clinit>():void");
        }
    }

    public interface d {
        void a(boolean z11);

        void b(double d11);

        void c(boolean z11);

        void onError(Throwable th2);
    }

    public class e implements AudioStream.a {
        public e() {
        }

        public void a(boolean z11) {
            AudioSource audioSource = AudioSource.this;
            audioSource.f5992q = z11;
            if (audioSource.f5982g == InternalState.STARTED) {
                audioSource.D();
            }
        }
    }

    public AudioSource(a aVar, Executor executor, Context context) throws AudioSourceAccessException {
        this(aVar, executor, context, b.f6021a, 3000);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void A() {
        int i11 = c.f6002a[this.f5982g.ordinal()];
        if (i11 == 2) {
            N(InternalState.CONFIGURED);
            S();
        } else if (i11 == 3) {
            Logger.w("AudioSource", "AudioSource is released. Calling stop() is a no-op.");
        }
    }

    public static BufferProvider.State l(BufferProvider<? extends d1> bufferProvider) {
        try {
            ListenableFuture<? extends d1> fetchData = bufferProvider.fetchData();
            if (fetchData.isDone()) {
                return (BufferProvider.State) fetchData.get();
            }
            return null;
        } catch (InterruptedException | ExecutionException unused) {
            return null;
        }
    }

    public static long n() {
        return System.nanoTime();
    }

    public static boolean o(int i11, int i12, int i13) {
        return q.i(i11, i12, i13);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void q(boolean z11) {
        int i11 = c.f6002a[this.f5982g.ordinal()];
        if (i11 == 1 || i11 == 2) {
            if (this.f5993r != z11) {
                this.f5993r = z11;
                if (this.f5982g == InternalState.STARTED) {
                    D();
                }
            }
        } else if (i11 == 3) {
            throw new AssertionError("AudioSource is released");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void u(d dVar) {
        dVar.b(this.f5995t);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void v(CallbackToFutureAdapter.a aVar) {
        try {
            int i11 = c.f6002a[this.f5982g.ordinal()];
            if (i11 == 1 || i11 == 2) {
                I((BufferProvider<? extends d1>) null);
                this.f5980e.release();
                this.f5979d.release();
                R();
                N(InternalState.RELEASED);
            }
            aVar.c(null);
        } catch (Throwable th2) {
            aVar.f(th2);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object w(CallbackToFutureAdapter.a aVar) throws Exception {
        this.f5976a.execute(new l(this, aVar));
        return "AudioSource-release";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void x(Executor executor, d dVar) {
        int i11 = c.f6002a[this.f5982g.ordinal()];
        if (i11 == 1) {
            this.f5985j = executor;
            this.f5986k = dVar;
        } else if (i11 == 2 || i11 == 3) {
            throw new AssertionError("The audio recording callback must be registered before the audio source is started.");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void y(BufferProvider bufferProvider) {
        int i11 = c.f6002a[this.f5982g.ordinal()];
        if (i11 == 1 || i11 == 2) {
            if (this.f5987l != bufferProvider) {
                I(bufferProvider);
            }
        } else if (i11 == 3) {
            throw new AssertionError("AudioSource is released");
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void z(boolean z11) {
        int i11 = c.f6002a[this.f5982g.ordinal()];
        if (i11 == 1) {
            this.f5977b.set((Object) null);
            this.f5978c.set(false);
            N(InternalState.STARTED);
            B(z11);
            S();
        } else if (i11 == 3) {
            throw new AssertionError("AudioSource is released");
        }
    }

    public void B(boolean z11) {
        this.f5976a.execute(new d(this, z11));
    }

    public void C(Throwable th2) {
        Executor executor = this.f5985j;
        d dVar = this.f5986k;
        if (executor != null && dVar != null) {
            executor.execute(new f(dVar, th2));
        }
    }

    public void D() {
        Executor executor = this.f5985j;
        d dVar = this.f5986k;
        if (executor != null && dVar != null) {
            boolean z11 = this.f5993r || this.f5990o || this.f5992q;
            if (!Objects.equals(this.f5977b.getAndSet(Boolean.valueOf(z11)), Boolean.valueOf(z11))) {
                executor.execute(new h(dVar, z11));
            }
        }
    }

    public void E(boolean z11) {
        Executor executor = this.f5985j;
        d dVar = this.f5986k;
        if (executor != null && dVar != null && this.f5978c.getAndSet(z11) != z11) {
            executor.execute(new g(dVar, z11));
        }
    }

    public void F(ByteBuffer byteBuffer, int i11) {
        byte[] bArr = this.f5994s;
        if (bArr == null || bArr.length < i11) {
            this.f5994s = new byte[i11];
        }
        int position = byteBuffer.position();
        byteBuffer.put(this.f5994s, 0, i11);
        byteBuffer.limit(byteBuffer.position()).position(position);
    }

    public void G(ByteBuffer byteBuffer) {
        Executor executor = this.f5985j;
        d dVar = this.f5986k;
        if (this.f5997v == 2) {
            ShortBuffer asShortBuffer = byteBuffer.asShortBuffer();
            double d11 = 0.0d;
            while (asShortBuffer.hasRemaining()) {
                d11 = Math.max(d11, (double) Math.abs(asShortBuffer.get()));
            }
            this.f5995t = d11 / 32767.0d;
            if (executor != null && dVar != null) {
                executor.execute(new k(this, dVar));
            }
        }
    }

    public ListenableFuture<Void> H() {
        return CallbackToFutureAdapter.a(new e(this));
    }

    public final void I(BufferProvider<? extends d1> bufferProvider) {
        BufferProvider<? extends d1> bufferProvider2 = this.f5987l;
        if (bufferProvider2 != null) {
            Observable.Observer<BufferProvider.State> observer = this.f5989n;
            Objects.requireNonNull(observer);
            bufferProvider2.removeObserver(observer);
            this.f5987l = null;
            this.f5989n = null;
            this.f5988m = null;
            this.f5983h = BufferProvider.State.INACTIVE;
            S();
        }
        if (bufferProvider != null) {
            this.f5987l = bufferProvider;
            this.f5989n = new a(bufferProvider);
            this.f5988m = new b(bufferProvider);
            BufferProvider.State l11 = l(bufferProvider);
            if (l11 != null) {
                this.f5983h = l11;
                S();
            }
            this.f5987l.addObserver(this.f5976a, this.f5989n);
        }
    }

    public void J() {
        h.i(this.f5990o);
        try {
            this.f5979d.start();
            Logger.d("AudioSource", "Retry start AudioStream succeed");
            this.f5980e.stop();
            this.f5990o = false;
        } catch (AudioStream.AudioStreamException e11) {
            Logger.w("AudioSource", "Retry start AudioStream failed", e11);
            this.f5991p = n();
        }
    }

    public void K() {
        BufferProvider<? extends d1> bufferProvider = this.f5987l;
        Objects.requireNonNull(bufferProvider);
        ListenableFuture b11 = bufferProvider.b();
        FutureCallback<d1> futureCallback = this.f5988m;
        Objects.requireNonNull(futureCallback);
        Futures.addCallback(b11, futureCallback, this.f5976a);
    }

    public void L(Executor executor, d dVar) {
        this.f5976a.execute(new m(this, executor, dVar));
    }

    public void M(BufferProvider<? extends d1> bufferProvider) {
        this.f5976a.execute(new j(this, bufferProvider));
    }

    public void N(InternalState internalState) {
        Logger.d("AudioSource", "Transitioning internal state: " + this.f5982g + " --> " + internalState);
        this.f5982g = internalState;
    }

    public void O(boolean z11) {
        this.f5976a.execute(new c(this, z11));
    }

    public final void P() {
        if (!this.f5984i) {
            try {
                Logger.d("AudioSource", "startSendingAudio");
                this.f5979d.start();
                this.f5990o = false;
            } catch (AudioStream.AudioStreamException e11) {
                Logger.w("AudioSource", "Failed to start AudioStream", e11);
                this.f5990o = true;
                this.f5980e.start();
                this.f5991p = n();
                D();
            }
            this.f5984i = true;
            K();
        }
    }

    public void Q() {
        this.f5976a.execute(new i(this));
    }

    public final void R() {
        if (this.f5984i) {
            this.f5984i = false;
            Logger.d("AudioSource", "stopSendingAudio");
            this.f5979d.stop();
        }
    }

    public void S() {
        if (this.f5982g == InternalState.STARTED) {
            boolean z11 = this.f5983h == BufferProvider.State.ACTIVE;
            E(!z11);
            if (z11) {
                P();
            } else {
                R();
            }
        } else {
            R();
        }
    }

    public AudioStream m() {
        return this.f5990o ? this.f5980e : this.f5979d;
    }

    public boolean p() {
        h.i(this.f5991p > 0);
        if (n() - this.f5991p >= this.f5981f) {
            return true;
        }
        return false;
    }

    public AudioSource(a aVar, Executor executor, Context context, o oVar, long j11) throws AudioSourceAccessException {
        this.f5977b = new AtomicReference<>((Object) null);
        this.f5978c = new AtomicBoolean(false);
        this.f5982g = InternalState.CONFIGURED;
        this.f5983h = BufferProvider.State.INACTIVE;
        this.f5996u = 0;
        Executor newSequentialExecutor = CameraXExecutors.newSequentialExecutor(executor);
        this.f5976a = newSequentialExecutor;
        this.f5981f = TimeUnit.MILLISECONDS.toNanos(j11);
        try {
            a0 a0Var = new a0(oVar.a(aVar, context), aVar);
            this.f5979d = a0Var;
            a0Var.a(new e(), newSequentialExecutor);
            this.f5980e = new c0(aVar);
            this.f5997v = aVar.b();
        } catch (AudioStream.AudioStreamException | IllegalArgumentException e11) {
            throw new AudioSourceAccessException("Unable to create AudioStream", e11);
        }
    }
}
