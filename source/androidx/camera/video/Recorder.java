package androidx.camera.video;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.location.Location;
import android.media.MediaMuxer;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.ParcelFileDescriptor;
import android.util.Pair;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import androidx.camera.core.CameraInfo;
import androidx.camera.core.DynamicRange;
import androidx.camera.core.Logger;
import androidx.camera.core.SurfaceRequest;
import androidx.camera.core.impl.MutableStateObservable;
import androidx.camera.core.impl.Observable;
import androidx.camera.core.impl.StateObservable;
import androidx.camera.core.impl.Timebase;
import androidx.camera.core.impl.utils.CloseGuardHelper;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureCallback;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.camera.core.internal.utils.ArrayRingBuffer;
import androidx.camera.core.internal.utils.RingBuffer;
import androidx.camera.video.StreamInfo;
import androidx.camera.video.VideoOutput;
import androidx.camera.video.internal.VideoValidatedEncoderProfilesProxy;
import androidx.camera.video.internal.audio.AudioSource;
import androidx.camera.video.internal.audio.AudioSourceAccessException;
import androidx.camera.video.internal.audio.n;
import androidx.camera.video.internal.compat.quirk.DeactivateEncoderSurfaceBeforeStopEncoderQuirk;
import androidx.camera.video.internal.compat.quirk.EncoderNotUsePersistentInputSurfaceQuirk;
import androidx.camera.video.internal.config.AudioMimeInfo;
import androidx.camera.video.internal.encoder.EncodeException;
import androidx.camera.video.internal.encoder.EncoderImpl;
import androidx.camera.video.internal.encoder.InvalidConfigException;
import androidx.camera.video.internal.encoder.g1;
import androidx.camera.video.internal.encoder.k;
import androidx.camera.video.internal.encoder.k1;
import androidx.camera.video.internal.encoder.l;
import androidx.camera.video.internal.encoder.m;
import androidx.camera.video.internal.encoder.o;
import androidx.camera.video.r;
import androidx.camera.video.v1;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import androidx.core.util.Consumer;
import com.google.auto.value.AutoValue;
import com.google.common.util.concurrent.ListenableFuture;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public final class Recorder implements VideoOutput {

    /* renamed from: g0  reason: collision with root package name */
    public static final Set<State> f5782g0 = Collections.unmodifiableSet(EnumSet.of(State.PENDING_RECORDING, State.PENDING_PAUSED));

    /* renamed from: h0  reason: collision with root package name */
    public static final Set<State> f5783h0 = Collections.unmodifiableSet(EnumSet.of(State.CONFIGURING, State.IDLING, State.RESETTING, State.STOPPING, State.ERROR));

    /* renamed from: i0  reason: collision with root package name */
    public static final y f5784i0;

    /* renamed from: j0  reason: collision with root package name */
    public static final w1 f5785j0;

    /* renamed from: k0  reason: collision with root package name */
    public static final r f5786k0;

    /* renamed from: l0  reason: collision with root package name */
    public static final Exception f5787l0 = new RuntimeException("The video frame producer became inactive before any data was received.");

    /* renamed from: m0  reason: collision with root package name */
    public static final o f5788m0 = h0.f5963a;

    /* renamed from: n0  reason: collision with root package name */
    public static final Executor f5789n0 = CameraXExecutors.newSequentialExecutor(CameraXExecutors.ioExecutor());
    public MediaMuxer A;
    public final MutableStateObservable<r> B;
    public AudioSource C;
    public k D;
    public g1 E;
    public k F;
    public g1 G;
    public AudioState H;
    public Uri I;
    public long J;
    public long K;
    public long L;
    public int M;
    public Range<Integer> N;
    public long O;
    public long P;
    public long Q;
    public long R;
    public long S;
    public int T;
    public Throwable U;
    public androidx.camera.video.internal.encoder.h V;
    public final RingBuffer<androidx.camera.video.internal.encoder.h> W;
    public Throwable X;
    public boolean Y;
    public VideoOutput.SourceState Z;

    /* renamed from: a  reason: collision with root package name */
    public final MutableStateObservable<StreamInfo> f5790a;

    /* renamed from: a0  reason: collision with root package name */
    public ScheduledFuture<?> f5791a0;

    /* renamed from: b  reason: collision with root package name */
    public final Executor f5792b;

    /* renamed from: b0  reason: collision with root package name */
    public boolean f5793b0;

    /* renamed from: c  reason: collision with root package name */
    public final Executor f5794c;

    /* renamed from: c0  reason: collision with root package name */
    public VideoEncoderSession f5795c0;

    /* renamed from: d  reason: collision with root package name */
    public final Executor f5796d;

    /* renamed from: d0  reason: collision with root package name */
    public VideoEncoderSession f5797d0;

    /* renamed from: e  reason: collision with root package name */
    public final o f5798e;

    /* renamed from: e0  reason: collision with root package name */
    public double f5799e0;

    /* renamed from: f  reason: collision with root package name */
    public final o f5800f;

    /* renamed from: f0  reason: collision with root package name */
    public boolean f5801f0;

    /* renamed from: g  reason: collision with root package name */
    public final Object f5802g = new Object();

    /* renamed from: h  reason: collision with root package name */
    public final boolean f5803h;

    /* renamed from: i  reason: collision with root package name */
    public State f5804i;

    /* renamed from: j  reason: collision with root package name */
    public State f5805j;

    /* renamed from: k  reason: collision with root package name */
    public int f5806k;

    /* renamed from: l  reason: collision with root package name */
    public i f5807l;

    /* renamed from: m  reason: collision with root package name */
    public i f5808m;

    /* renamed from: n  reason: collision with root package name */
    public long f5809n;

    /* renamed from: o  reason: collision with root package name */
    public i f5810o;

    /* renamed from: p  reason: collision with root package name */
    public boolean f5811p;

    /* renamed from: q  reason: collision with root package name */
    public SurfaceRequest.TransformationInfo f5812q;

    /* renamed from: r  reason: collision with root package name */
    public SurfaceRequest.TransformationInfo f5813r;

    /* renamed from: s  reason: collision with root package name */
    public VideoValidatedEncoderProfilesProxy f5814s;

    /* renamed from: t  reason: collision with root package name */
    public final List<ListenableFuture<Void>> f5815t;

    /* renamed from: u  reason: collision with root package name */
    public Integer f5816u;

    /* renamed from: v  reason: collision with root package name */
    public Integer f5817v;

    /* renamed from: w  reason: collision with root package name */
    public SurfaceRequest f5818w;

    /* renamed from: x  reason: collision with root package name */
    public Timebase f5819x;

    /* renamed from: y  reason: collision with root package name */
    public Surface f5820y;

    /* renamed from: z  reason: collision with root package name */
    public Surface f5821z;

    public enum AudioState {
        INITIALIZING,
        IDLING,
        DISABLED,
        ENABLED,
        ERROR_ENCODER,
        ERROR_SOURCE
    }

    public static final class Builder {

        /* renamed from: a  reason: collision with root package name */
        public final r.a f5822a;

        /* renamed from: b  reason: collision with root package name */
        public Executor f5823b = null;

        /* renamed from: c  reason: collision with root package name */
        public o f5824c;

        /* renamed from: d  reason: collision with root package name */
        public o f5825d;

        public Builder() {
            o oVar = Recorder.f5788m0;
            this.f5824c = oVar;
            this.f5825d = oVar;
            this.f5822a = r.a();
        }

        public Recorder c() {
            return new Recorder(this.f5823b, this.f5822a.a(), this.f5824c, this.f5825d);
        }

        public Builder f(y yVar) {
            androidx.core.util.h.h(yVar, "The specified quality selector can't be null.");
            this.f5822a.b(new q0(yVar));
            return this;
        }

        public Builder g(int i11) {
            if (i11 > 0) {
                this.f5822a.b(new p0(i11));
                return this;
            }
            throw new IllegalArgumentException("The requested target bitrate " + i11 + " is not supported. Target bitrate must be greater than 0.");
        }
    }

    public enum State {
        CONFIGURING,
        PENDING_RECORDING,
        PENDING_PAUSED,
        IDLING,
        RECORDING,
        PAUSED,
        STOPPING,
        RESETTING,
        ERROR
    }

    public class a implements FutureCallback<k> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoEncoderSession f5826a;

        public a(VideoEncoderSession videoEncoderSession) {
            this.f5826a = videoEncoderSession;
        }

        /* renamed from: a */
        public void onSuccess(k kVar) {
            Logger.d("Recorder", "VideoEncoder is created. " + kVar);
            if (kVar != null) {
                boolean z11 = true;
                androidx.core.util.h.i(Recorder.this.f5795c0 == this.f5826a);
                if (Recorder.this.D != null) {
                    z11 = false;
                }
                androidx.core.util.h.i(z11);
                Recorder.this.d0(this.f5826a);
                Recorder.this.W();
            }
        }

        public void onFailure(Throwable th2) {
            Logger.d("Recorder", "VideoEncoder Setup error: " + th2);
            Recorder.this.X(th2);
        }
    }

    public class b implements FutureCallback<k> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ VideoEncoderSession f5828a;

        public b(VideoEncoderSession videoEncoderSession) {
            this.f5828a = videoEncoderSession;
        }

        /* renamed from: a */
        public void onSuccess(k kVar) {
            k kVar2;
            Logger.d("Recorder", "VideoEncoder can be released: " + kVar);
            if (kVar != null) {
                ScheduledFuture<?> scheduledFuture = Recorder.this.f5791a0;
                if (scheduledFuture != null && scheduledFuture.cancel(false) && (kVar2 = Recorder.this.D) != null && kVar2 == kVar) {
                    Recorder.V(kVar2);
                }
                Recorder recorder = Recorder.this;
                recorder.f5797d0 = this.f5828a;
                recorder.p0((Surface) null);
                Recorder recorder2 = Recorder.this;
                recorder2.i0(4, (Throwable) null, recorder2.F());
            }
        }

        public void onFailure(Throwable th2) {
            Logger.d("Recorder", "Error in ReadyToReleaseFuture: " + th2);
        }
    }

    public class c implements FutureCallback<Void> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ AudioSource f5830a;

        public c(AudioSource audioSource) {
            this.f5830a = audioSource;
        }

        /* renamed from: a */
        public void onSuccess(Void voidR) {
            Logger.d("Recorder", String.format("Released audio source successfully: 0x%x", new Object[]{Integer.valueOf(this.f5830a.hashCode())}));
        }

        public void onFailure(Throwable th2) {
            Logger.d("Recorder", String.format("An error occurred while attempting to release audio source: 0x%x", new Object[]{Integer.valueOf(this.f5830a.hashCode())}));
        }
    }

    public class d implements m {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackToFutureAdapter.a f5832b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ i f5833c;

        public d(CallbackToFutureAdapter.a aVar, i iVar) {
            this.f5832b = aVar;
            this.f5833c = iVar;
        }

        public /* synthetic */ void a() {
            l.a(this);
        }

        public void b() {
        }

        public void c(EncodeException encodeException) {
            this.f5832b.f(encodeException);
        }

        public void d(g1 g1Var) {
            Recorder.this.E = g1Var;
        }

        public void e() {
            this.f5832b.c(null);
        }

        public void f(androidx.camera.video.internal.encoder.h hVar) {
            Recorder recorder = Recorder.this;
            if (recorder.A != null) {
                try {
                    recorder.I0(hVar, this.f5833c);
                    if (hVar != null) {
                        hVar.close();
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            } else if (!recorder.f5811p) {
                boolean z11 = false;
                androidx.camera.video.internal.encoder.h hVar2 = recorder.V;
                if (hVar2 != null) {
                    z11 = true;
                    hVar2.close();
                    Recorder.this.V = null;
                }
                if (hVar.i()) {
                    Recorder recorder2 = Recorder.this;
                    recorder2.V = hVar;
                    if (!recorder2.D() || !Recorder.this.W.isEmpty()) {
                        Logger.d("Recorder", "Received video keyframe. Starting muxer...");
                        Recorder.this.s0(this.f5833c);
                        return;
                    } else if (z11) {
                        Logger.d("Recorder", "Replaced cached video keyframe with newer keyframe.");
                        return;
                    } else {
                        Logger.d("Recorder", "Cached video keyframe while we wait for first audio sample before starting muxer.");
                        return;
                    }
                } else {
                    if (z11) {
                        Logger.d("Recorder", "Dropped cached keyframe since we have new video data and have not yet received audio data.");
                    }
                    Logger.d("Recorder", "Dropped video data since muxer has not yet started and data is not a keyframe.");
                    Recorder.this.D.f();
                    hVar.close();
                    return;
                }
            } else {
                Logger.d("Recorder", "Drop video data since recording is stopping.");
                hVar.close();
                return;
            }
            throw th;
        }
    }

    public class e implements AudioSource.d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Consumer f5835a;

        public e(Consumer consumer) {
            this.f5835a = consumer;
        }

        public void a(boolean z11) {
            Recorder recorder = Recorder.this;
            if (recorder.Y != z11) {
                recorder.Y = z11;
                recorder.F0();
                return;
            }
            Logger.w("Recorder", "Audio source silenced transitions to the same state " + z11);
        }

        public void b(double d11) {
            Recorder.this.f5799e0 = d11;
        }

        public /* synthetic */ void c(boolean z11) {
            n.a(this, z11);
        }

        public void onError(Throwable th2) {
            Logger.e("Recorder", "Error occurred after audio source started.", th2);
            if (th2 instanceof AudioSourceAccessException) {
                this.f5835a.accept(th2);
            }
        }
    }

    public class f implements m {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ CallbackToFutureAdapter.a f5837b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Consumer f5838c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ i f5839d;

        public f(CallbackToFutureAdapter.a aVar, Consumer consumer, i iVar) {
            this.f5837b = aVar;
            this.f5838c = consumer;
            this.f5839d = iVar;
        }

        public /* synthetic */ void a() {
            l.a(this);
        }

        public void b() {
        }

        public void c(EncodeException encodeException) {
            if (Recorder.this.X == null) {
                this.f5838c.accept(encodeException);
            }
        }

        public void d(g1 g1Var) {
            Recorder.this.G = g1Var;
        }

        public void e() {
            this.f5837b.c(null);
        }

        public void f(androidx.camera.video.internal.encoder.h hVar) {
            Recorder recorder = Recorder.this;
            if (recorder.H == AudioState.DISABLED) {
                hVar.close();
                throw new AssertionError("Audio is not enabled but audio encoded data is being produced.");
            } else if (recorder.A == null) {
                if (!recorder.f5811p) {
                    recorder.W.enqueue(new androidx.camera.video.internal.encoder.g(hVar));
                    if (Recorder.this.V != null) {
                        Logger.d("Recorder", "Received audio data. Starting muxer...");
                        Recorder.this.s0(this.f5839d);
                    } else {
                        Logger.d("Recorder", "Cached audio data while we wait for video keyframe before starting muxer.");
                    }
                } else {
                    Logger.d("Recorder", "Drop audio data since recording is stopping.");
                }
                hVar.close();
                return;
            } else {
                try {
                    recorder.H0(hVar, this.f5839d);
                    if (hVar != null) {
                        hVar.close();
                        return;
                    }
                    return;
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public class g implements FutureCallback<List<Void>> {
        public g() {
        }

        /* renamed from: a */
        public void onSuccess(List<Void> list) {
            Logger.d("Recorder", "Encodings end successfully.");
            Recorder recorder = Recorder.this;
            recorder.v(recorder.T, recorder.U);
        }

        public void onFailure(Throwable th2) {
            androidx.core.util.h.j(Recorder.this.f5810o != null, "In-progress recording shouldn't be null");
            if (!Recorder.this.f5810o.w()) {
                Logger.d("Recorder", "Encodings end with error: " + th2);
                Recorder recorder = Recorder.this;
                recorder.v(recorder.A == null ? 8 : 6, th2);
            }
        }
    }

    public static /* synthetic */ class h {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f5842a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f5843b;

        /* JADX WARNING: Can't wrap try/catch for region: R(34:0|(2:1|2)|3|(2:5|6)|7|9|10|11|(2:13|14)|15|(2:17|18)|19|21|22|23|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|44) */
        /* JADX WARNING: Can't wrap try/catch for region: R(36:0|(2:1|2)|3|5|6|7|9|10|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|44) */
        /* JADX WARNING: Can't wrap try/catch for region: R(38:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|44) */
        /* JADX WARNING: Code restructure failed: missing block: B:45:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x005a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x0064 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x006e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x0082 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x008c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x0097 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00a3 */
        static {
            /*
                androidx.camera.video.Recorder$AudioState[] r0 = androidx.camera.video.Recorder.AudioState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5843b = r0
                r1 = 1
                androidx.camera.video.Recorder$AudioState r2 = androidx.camera.video.Recorder.AudioState.ERROR_ENCODER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                r0 = 2
                int[] r2 = f5843b     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.camera.video.Recorder$AudioState r3 = androidx.camera.video.Recorder.AudioState.ERROR_SOURCE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2[r3] = r0     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                r2 = 3
                int[] r3 = f5843b     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.camera.video.Recorder$AudioState r4 = androidx.camera.video.Recorder.AudioState.ENABLED     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r3[r4] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                r3 = 4
                int[] r4 = f5843b     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.camera.video.Recorder$AudioState r5 = androidx.camera.video.Recorder.AudioState.DISABLED     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r4[r5] = r3     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                r4 = 5
                int[] r5 = f5843b     // Catch:{ NoSuchFieldError -> 0x003e }
                androidx.camera.video.Recorder$AudioState r6 = androidx.camera.video.Recorder.AudioState.IDLING     // Catch:{ NoSuchFieldError -> 0x003e }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r5[r6] = r4     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                r5 = 6
                int[] r6 = f5843b     // Catch:{ NoSuchFieldError -> 0x0049 }
                androidx.camera.video.Recorder$AudioState r7 = androidx.camera.video.Recorder.AudioState.INITIALIZING     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r6[r7] = r5     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                androidx.camera.video.Recorder$State[] r6 = androidx.camera.video.Recorder.State.values()
                int r6 = r6.length
                int[] r6 = new int[r6]
                f5842a = r6
                androidx.camera.video.Recorder$State r7 = androidx.camera.video.Recorder.State.PAUSED     // Catch:{ NoSuchFieldError -> 0x005a }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r6[r7] = r1     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                int[] r1 = f5842a     // Catch:{ NoSuchFieldError -> 0x0064 }
                androidx.camera.video.Recorder$State r6 = androidx.camera.video.Recorder.State.RECORDING     // Catch:{ NoSuchFieldError -> 0x0064 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0064 }
                r1[r6] = r0     // Catch:{ NoSuchFieldError -> 0x0064 }
            L_0x0064:
                int[] r0 = f5842a     // Catch:{ NoSuchFieldError -> 0x006e }
                androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.PENDING_PAUSED     // Catch:{ NoSuchFieldError -> 0x006e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006e }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006e }
            L_0x006e:
                int[] r0 = f5842a     // Catch:{ NoSuchFieldError -> 0x0078 }
                androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.PENDING_RECORDING     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = f5842a     // Catch:{ NoSuchFieldError -> 0x0082 }
                androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.RESETTING     // Catch:{ NoSuchFieldError -> 0x0082 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0082 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0082 }
            L_0x0082:
                int[] r0 = f5842a     // Catch:{ NoSuchFieldError -> 0x008c }
                androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.STOPPING     // Catch:{ NoSuchFieldError -> 0x008c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x008c }
                r0[r1] = r5     // Catch:{ NoSuchFieldError -> 0x008c }
            L_0x008c:
                int[] r0 = f5842a     // Catch:{ NoSuchFieldError -> 0x0097 }
                androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.CONFIGURING     // Catch:{ NoSuchFieldError -> 0x0097 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0097 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0097 }
            L_0x0097:
                int[] r0 = f5842a     // Catch:{ NoSuchFieldError -> 0x00a3 }
                androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.ERROR     // Catch:{ NoSuchFieldError -> 0x00a3 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a3 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a3 }
            L_0x00a3:
                int[] r0 = f5842a     // Catch:{ NoSuchFieldError -> 0x00af }
                androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.IDLING     // Catch:{ NoSuchFieldError -> 0x00af }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00af }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00af }
            L_0x00af:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.Recorder.h.<clinit>():void");
        }
    }

    @AutoValue
    public static abstract class i implements AutoCloseable {

        /* renamed from: b  reason: collision with root package name */
        public final CloseGuardHelper f5844b = CloseGuardHelper.create();

        /* renamed from: c  reason: collision with root package name */
        public final AtomicBoolean f5845c = new AtomicBoolean(false);

        /* renamed from: d  reason: collision with root package name */
        public final AtomicReference<d> f5846d = new AtomicReference<>((Object) null);

        /* renamed from: e  reason: collision with root package name */
        public final AtomicReference<c> f5847e = new AtomicReference<>((Object) null);

        /* renamed from: f  reason: collision with root package name */
        public final AtomicReference<Consumer<Uri>> f5848f = new AtomicReference<>(w0.f6382b);

        /* renamed from: g  reason: collision with root package name */
        public final AtomicBoolean f5849g = new AtomicBoolean(false);

        public class a implements c {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ Context f5850a;

            public a(Context context) {
                this.f5850a = context;
            }

            public AudioSource a(androidx.camera.video.internal.audio.a aVar, Executor executor) throws AudioSourceAccessException {
                return new AudioSource(aVar, executor, this.f5850a);
            }
        }

        public class b implements c {
            public b() {
            }

            public AudioSource a(androidx.camera.video.internal.audio.a aVar, Executor executor) throws AudioSourceAccessException {
                return new AudioSource(aVar, executor, (Context) null);
            }
        }

        public interface c {
            AudioSource a(androidx.camera.video.internal.audio.a aVar, Executor executor) throws AudioSourceAccessException;
        }

        public interface d {
            MediaMuxer a(int i11, Consumer<Uri> consumer) throws IOException;
        }

        public static /* synthetic */ void A(s sVar, Context context, Uri uri) {
            if (!uri.equals(Uri.EMPTY)) {
                String b11 = c0.b.b(sVar.e(), uri, "_data");
                if (b11 != null) {
                    MediaScannerConnection.scanFile(context, new String[]{b11}, (String[]) null, r0.f6345a);
                    return;
                }
                Logger.d("Recorder", "Skipping media scanner scan. Unable to retrieve file path from URI: " + uri);
            }
        }

        public static /* synthetic */ void B(ParcelFileDescriptor parcelFileDescriptor, Uri uri) {
            try {
                parcelFileDescriptor.close();
            } catch (IOException e11) {
                Logger.e("Recorder", "Failed to close dup'd ParcelFileDescriptor", e11);
            }
        }

        public static /* synthetic */ void C(Uri uri) {
        }

        /* access modifiers changed from: private */
        public /* synthetic */ void D(v1 v1Var) {
            p().accept(v1Var);
        }

        public static i n(u uVar, long j11) {
            return new k(uVar.d(), uVar.c(), uVar.b(), uVar.f(), uVar.g(), j11);
        }

        public static /* synthetic */ MediaMuxer x(t tVar, ParcelFileDescriptor parcelFileDescriptor, int i11, Consumer consumer) throws IOException {
            MediaMuxer mediaMuxer;
            MediaMuxer mediaMuxer2;
            Uri uri = Uri.EMPTY;
            if (tVar instanceof q) {
                File d11 = ((q) tVar).d();
                if (!c0.b.a(d11)) {
                    Logger.w("Recorder", "Failed to create folder for " + d11.getAbsolutePath());
                }
                mediaMuxer = new MediaMuxer(d11.getAbsolutePath(), i11);
                uri = Uri.fromFile(d11);
            } else if (tVar instanceof p) {
                if (Build.VERSION.SDK_INT >= 26) {
                    mediaMuxer = z.c.a(parcelFileDescriptor.getFileDescriptor(), i11);
                } else {
                    throw new IOException("MediaMuxer doesn't accept FileDescriptor as output destination.");
                }
            } else if (tVar instanceof s) {
                s sVar = (s) tVar;
                ContentValues contentValues = new ContentValues(sVar.f());
                int i12 = Build.VERSION.SDK_INT;
                if (i12 >= 29) {
                    contentValues.put("is_pending", 1);
                }
                try {
                    Uri insert = sVar.e().insert(sVar.d(), contentValues);
                    if (insert != null) {
                        if (i12 < 26) {
                            String b11 = c0.b.b(sVar.e(), insert, "_data");
                            if (b11 != null) {
                                if (!c0.b.a(new File(b11))) {
                                    Logger.w("Recorder", "Failed to create folder for " + b11);
                                }
                                mediaMuxer2 = new MediaMuxer(b11, i11);
                            } else {
                                throw new IOException("Unable to get path from uri " + insert);
                            }
                        } else {
                            ParcelFileDescriptor openFileDescriptor = sVar.e().openFileDescriptor(insert, "rw");
                            mediaMuxer2 = z.c.a(openFileDescriptor.getFileDescriptor(), i11);
                            openFileDescriptor.close();
                        }
                        uri = insert;
                        mediaMuxer = mediaMuxer2;
                    } else {
                        throw new IOException("Unable to create MediaStore entry.");
                    }
                } catch (RuntimeException e11) {
                    throw new IOException("Unable to create MediaStore entry by " + e11, e11);
                }
            } else {
                throw new AssertionError("Invalid output options type: " + tVar.getClass().getSimpleName());
            }
            consumer.accept(uri);
            return mediaMuxer;
        }

        public static /* synthetic */ void y(s sVar, Uri uri) {
            if (!uri.equals(Uri.EMPTY)) {
                ContentValues contentValues = new ContentValues();
                contentValues.put("is_pending", 0);
                sVar.e().update(uri, contentValues, (String) null, (String[]) null);
            }
        }

        public static /* synthetic */ void z(String str, Uri uri) {
            if (uri == null) {
                Logger.e("Recorder", String.format("File scanning operation failed [path: %s]", new Object[]{str}));
                return;
            }
            Logger.d("Recorder", String.format("File scan completed successfully [path: %s, URI: %s]", new Object[]{str, uri}));
        }

        public AudioSource E(androidx.camera.video.internal.audio.a aVar, Executor executor) throws AudioSourceAccessException {
            if (t()) {
                c andSet = this.f5847e.getAndSet((Object) null);
                if (andSet != null) {
                    return andSet.a(aVar, executor);
                }
                throw new AssertionError("One-time audio source creation has already occurred for recording " + this);
            }
            throw new AssertionError("Recording does not have audio enabled. Unable to create audio source for recording " + this);
        }

        public MediaMuxer F(int i11, Consumer<Uri> consumer) throws IOException {
            if (this.f5845c.get()) {
                d andSet = this.f5846d.getAndSet((Object) null);
                if (andSet != null) {
                    try {
                        return andSet.a(i11, consumer);
                    } catch (RuntimeException e11) {
                        throw new IOException("Failed to create MediaMuxer by " + e11, e11);
                    }
                } else {
                    throw new AssertionError("One-time media muxer creation has already occurred for recording " + this);
                }
            } else {
                throw new AssertionError("Recording " + this + " has not been initialized");
            }
        }

        public void G(v1 v1Var) {
            if (Objects.equals(v1Var.c(), r())) {
                String str = "Sending VideoRecordEvent " + v1Var.getClass().getSimpleName();
                if (v1Var instanceof v1.a) {
                    v1.a aVar = (v1.a) v1Var;
                    if (aVar.l()) {
                        str = str + String.format(" [error: %s]", new Object[]{v1.a.i(aVar.k())});
                    }
                }
                Logger.d("Recorder", str);
                if (o() != null && p() != null) {
                    try {
                        o().execute(new x0(this, v1Var));
                    } catch (RejectedExecutionException e11) {
                        Logger.e("Recorder", "The callback executor is invalid.", e11);
                    }
                }
            } else {
                throw new AssertionError("Attempted to update event listener with event from incorrect recording [Recording: " + v1Var.c() + ", Expected: " + r() + "]");
            }
        }

        public void close() {
            l(Uri.EMPTY);
        }

        public void finalize() throws Throwable {
            try {
                this.f5844b.warnIfOpen();
                Consumer andSet = this.f5848f.getAndSet((Object) null);
                if (andSet != null) {
                    m(andSet, Uri.EMPTY);
                }
            } finally {
                super.finalize();
            }
        }

        public void l(Uri uri) {
            if (this.f5845c.get()) {
                m(this.f5848f.getAndSet((Object) null), uri);
            }
        }

        public final void m(Consumer<Uri> consumer, Uri uri) {
            if (consumer != null) {
                this.f5844b.close();
                consumer.accept(uri);
                return;
            }
            throw new AssertionError("Recording " + this + " has already been finalized");
        }

        public abstract Executor o();

        public abstract Consumer<v1> p();

        public abstract t r();

        public abstract long s();

        public abstract boolean t();

        public void u(Context context) throws IOException {
            if (!this.f5845c.getAndSet(true)) {
                t r11 = r();
                boolean z11 = r11 instanceof p;
                Consumer consumer = null;
                ParcelFileDescriptor dup = z11 ? ((p) r11).d().dup() : null;
                this.f5844b.open("finalizeRecording");
                this.f5846d.set(new s0(r11, dup));
                if (t()) {
                    if (Build.VERSION.SDK_INT >= 31) {
                        this.f5847e.set(new a(context));
                    } else {
                        this.f5847e.set(new b());
                    }
                }
                if (r11 instanceof s) {
                    s sVar = (s) r11;
                    if (Build.VERSION.SDK_INT >= 29) {
                        consumer = new u0(sVar);
                    } else {
                        consumer = new v0(sVar, context);
                    }
                } else if (z11) {
                    consumer = new t0(dup);
                }
                if (consumer != null) {
                    this.f5848f.set(consumer);
                    return;
                }
                return;
            }
            throw new AssertionError("Recording " + this + " has already been initialized");
        }

        public boolean v() {
            return this.f5849g.get();
        }

        public abstract boolean w();
    }

    static {
        v vVar = v.f6367c;
        y e11 = y.e(Arrays.asList(new v[]{vVar, v.f6366b, v.f6365a}), o.a(vVar));
        f5784i0 = e11;
        w1 a11 = w1.a().e(e11).b(-1).a();
        f5785j0 = a11;
        f5786k0 = r.a().e(-1).f(a11).a();
    }

    public Recorder(Executor executor, r rVar, o oVar, o oVar2) {
        this.f5803h = a0.a.a(EncoderNotUsePersistentInputSurfaceQuirk.class) != null;
        this.f5804i = State.CONFIGURING;
        this.f5805j = null;
        this.f5806k = 0;
        this.f5807l = null;
        this.f5808m = null;
        this.f5809n = 0;
        this.f5810o = null;
        this.f5811p = false;
        this.f5812q = null;
        this.f5813r = null;
        this.f5814s = null;
        this.f5815t = new ArrayList();
        this.f5816u = null;
        this.f5817v = null;
        this.f5820y = null;
        this.f5821z = null;
        this.A = null;
        this.C = null;
        this.D = null;
        this.E = null;
        this.F = null;
        this.G = null;
        this.H = AudioState.INITIALIZING;
        this.I = Uri.EMPTY;
        this.J = 0;
        this.K = 0;
        this.L = Long.MAX_VALUE;
        this.M = 0;
        this.N = null;
        this.O = Long.MAX_VALUE;
        this.P = Long.MAX_VALUE;
        this.Q = Long.MAX_VALUE;
        this.R = 0;
        this.S = 0;
        this.T = 1;
        this.U = null;
        this.V = null;
        this.W = new ArrayRingBuffer(60);
        this.X = null;
        this.Y = false;
        this.Z = VideoOutput.SourceState.INACTIVE;
        this.f5791a0 = null;
        this.f5793b0 = false;
        this.f5797d0 = null;
        this.f5799e0 = 0.0d;
        this.f5801f0 = false;
        this.f5792b = executor;
        executor = executor == null ? CameraXExecutors.ioExecutor() : executor;
        this.f5794c = executor;
        Executor newSequentialExecutor = CameraXExecutors.newSequentialExecutor(executor);
        this.f5796d = newSequentialExecutor;
        this.B = MutableStateObservable.withInitialState(t(rVar));
        this.f5790a = MutableStateObservable.withInitialState(StreamInfo.d(this.f5806k, C(this.f5804i)));
        this.f5798e = oVar;
        this.f5800f = oVar2;
        this.f5795c0 = new VideoEncoderSession(oVar, newSequentialExecutor, executor);
    }

    public static c1 A(CameraInfo cameraInfo) {
        return y0.h(cameraInfo);
    }

    public static int B0(VideoValidatedEncoderProfilesProxy videoValidatedEncoderProfilesProxy, int i11) {
        if (videoValidatedEncoderProfilesProxy != null) {
            int recommendedFileFormat = videoValidatedEncoderProfilesProxy.getRecommendedFileFormat();
            if (recommendedFileFormat == 1) {
                return Build.VERSION.SDK_INT < 26 ? 0 : 2;
            }
            if (recommendedFileFormat == 2) {
                return 0;
            }
            if (recommendedFileFormat != 9) {
                return i11;
            }
            return 1;
        }
        return i11;
    }

    public static boolean G(z0 z0Var, i iVar) {
        return iVar != null && z0Var.f() == iVar.s();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void I(SurfaceRequest.TransformationInfo transformationInfo) {
        this.f5813r = transformationInfo;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void L(Uri uri) {
        this.I = uri;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void M(SurfaceRequest surfaceRequest, Timebase timebase) {
        if (surfaceRequest.isServiced() || (this.f5795c0.n(surfaceRequest) && !F())) {
            Logger.w("Recorder", "Ignore the SurfaceRequest " + surfaceRequest + " isServiced: " + surfaceRequest.isServiced() + " VideoEncoderSession: " + this.f5795c0 + " has been configured with a persistent in-progress recording.");
            return;
        }
        VideoEncoderSession videoEncoderSession = new VideoEncoderSession(this.f5798e, this.f5796d, this.f5794c);
        ListenableFuture<k> i11 = videoEncoderSession.i(surfaceRequest, timebase, (r) z(this.B), this.f5814s);
        this.f5795c0 = videoEncoderSession;
        Futures.addCallback(i11, new a(videoEncoderSession), this.f5796d);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void N() {
        SurfaceRequest surfaceRequest = this.f5818w;
        if (surfaceRequest != null) {
            u(surfaceRequest, this.f5819x);
            return;
        }
        throw new AssertionError("surface request is required to retry initialization.");
    }

    public static /* synthetic */ void P(k kVar) {
        Logger.d("Recorder", "The source didn't become non-streaming before timeout. Waited 1000ms");
        if (a0.a.a(DeactivateEncoderSurfaceBeforeStopEncoderQuirk.class) != null) {
            V(kVar);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void Q(k kVar) {
        this.f5796d.execute(new f0(kVar));
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object R(i iVar, CallbackToFutureAdapter.a aVar) throws Exception {
        this.D.a(new d(aVar, iVar), this.f5796d);
        return "videoEncodingFuture";
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void S(CallbackToFutureAdapter.a aVar, Throwable th2) {
        if (this.X == null) {
            if (th2 instanceof EncodeException) {
                n0(AudioState.ERROR_ENCODER);
            } else {
                n0(AudioState.ERROR_SOURCE);
            }
            this.X = th2;
            F0();
            aVar.c(null);
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ Object T(i iVar, CallbackToFutureAdapter.a aVar) throws Exception {
        l0 l0Var = new l0(this, aVar);
        this.C.L(this.f5796d, new e(l0Var));
        this.F.a(new f(aVar, l0Var, iVar), this.f5796d);
        return "audioEncodingFuture";
    }

    public static void V(k kVar) {
        if (kVar instanceof EncoderImpl) {
            ((EncoderImpl) kVar).g0();
        }
    }

    /* renamed from: A0 */
    public void O(i iVar, long j11, int i11, Throwable th2) {
        if (this.f5810o == iVar && !this.f5811p) {
            this.f5811p = true;
            this.T = i11;
            this.U = th2;
            if (D()) {
                s();
                this.F.b(j11);
            }
            androidx.camera.video.internal.encoder.h hVar = this.V;
            if (hVar != null) {
                hVar.close();
                this.V = null;
            }
            if (this.Z != VideoOutput.SourceState.ACTIVE_NON_STREAMING) {
                this.f5791a0 = CameraXExecutors.mainThreadExecutor().schedule(new e0(this, this.D), 1000, TimeUnit.MILLISECONDS);
            } else {
                V(this.D);
            }
            this.D.b(j11);
        }
    }

    public final int B(AudioState audioState) {
        int i11 = h.f5843b[audioState.ordinal()];
        if (i11 == 1) {
            return 3;
        }
        if (i11 == 2) {
            return 4;
        }
        if (i11 == 3) {
            i iVar = this.f5810o;
            if (iVar != null && iVar.v()) {
                return 5;
            }
            if (this.Y) {
                return 2;
            }
            return 0;
        } else if (i11 == 4 || i11 == 6) {
            return 1;
        } else {
            throw new AssertionError("Invalid internal audio state: " + audioState);
        }
    }

    public final StreamInfo.StreamState C(State state) {
        return (state == State.RECORDING || (state == State.STOPPING && ((DeactivateEncoderSurfaceBeforeStopEncoderQuirk) a0.a.a(DeactivateEncoderSurfaceBeforeStopEncoderQuirk.class)) == null)) ? StreamInfo.StreamState.ACTIVE : StreamInfo.StreamState.INACTIVE;
    }

    public final void C0() {
        VideoEncoderSession videoEncoderSession = this.f5797d0;
        if (videoEncoderSession != null) {
            androidx.core.util.h.i(videoEncoderSession.m() == this.D);
            Logger.d("Recorder", "Releasing video encoder: " + this.D);
            this.f5797d0.x();
            this.f5797d0 = null;
            this.D = null;
            this.E = null;
            p0((Surface) null);
            return;
        }
        m0();
    }

    public boolean D() {
        return this.H == AudioState.ENABLED;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: java.lang.Exception} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.Exception} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: java.lang.Exception} */
    /* JADX WARNING: type inference failed for: r1v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:12:0x0020  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void D0() {
        /*
            r8 = this;
            java.lang.Object r0 = r8.f5802g
            monitor-enter(r0)
            int[] r1 = androidx.camera.video.Recorder.h.f5842a     // Catch:{ all -> 0x0058 }
            androidx.camera.video.Recorder$State r2 = r8.f5804i     // Catch:{ all -> 0x0058 }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x0058 }
            r1 = r1[r2]     // Catch:{ all -> 0x0058 }
            r2 = 3
            r3 = 4
            r4 = 0
            r5 = 0
            if (r1 == r2) goto L_0x001b
            if (r1 == r3) goto L_0x0019
            r3 = r4
            r1 = r5
        L_0x0017:
            r2 = r1
            goto L_0x004b
        L_0x0019:
            r1 = r4
            goto L_0x001c
        L_0x001b:
            r1 = 1
        L_0x001c:
            androidx.camera.video.Recorder$i r2 = r8.f5807l     // Catch:{ all -> 0x0058 }
            if (r2 != 0) goto L_0x0047
            boolean r2 = r8.f5793b0     // Catch:{ all -> 0x0058 }
            if (r2 == 0) goto L_0x0025
            goto L_0x0047
        L_0x0025:
            androidx.camera.video.VideoOutput$SourceState r2 = r8.Z     // Catch:{ all -> 0x0058 }
            androidx.camera.video.VideoOutput$SourceState r6 = androidx.camera.video.VideoOutput.SourceState.INACTIVE     // Catch:{ all -> 0x0058 }
            if (r2 != r6) goto L_0x0038
            androidx.camera.video.Recorder$i r2 = r8.f5808m     // Catch:{ all -> 0x0058 }
            r8.f5808m = r5     // Catch:{ all -> 0x0058 }
            r8.l0()     // Catch:{ all -> 0x0058 }
            java.lang.Exception r4 = f5787l0     // Catch:{ all -> 0x0058 }
            r7 = r4
            r4 = r1
            r1 = r7
            goto L_0x004b
        L_0x0038:
            androidx.camera.video.internal.encoder.k r2 = r8.D     // Catch:{ all -> 0x0058 }
            if (r2 == 0) goto L_0x0047
            androidx.camera.video.Recorder$State r2 = r8.f5804i     // Catch:{ all -> 0x0058 }
            androidx.camera.video.Recorder$i r2 = r8.U(r2)     // Catch:{ all -> 0x0058 }
            r3 = r4
            r4 = r1
            r1 = r5
            r5 = r2
            goto L_0x0017
        L_0x0047:
            r3 = r4
            r2 = r5
            r4 = r1
            r1 = r2
        L_0x004b:
            monitor-exit(r0)     // Catch:{ all -> 0x0058 }
            if (r5 == 0) goto L_0x0052
            r8.y0(r5, r4)
            goto L_0x0057
        L_0x0052:
            if (r2 == 0) goto L_0x0057
            r8.w(r2, r3, r1)
        L_0x0057:
            return
        L_0x0058:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0058 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.Recorder.D0():void");
    }

    public boolean E() {
        return ((r) z(this.B)).b().c() != 0;
    }

    public final void E0(i iVar, boolean z11) {
        if (!this.f5815t.isEmpty()) {
            ListenableFuture<List<V>> allAsList = Futures.allAsList(this.f5815t);
            if (!allAsList.isDone()) {
                allAsList.cancel(true);
            }
            this.f5815t.clear();
        }
        this.f5815t.add(CallbackToFutureAdapter.a(new i0(this, iVar)));
        if (D() && !z11) {
            this.f5815t.add(CallbackToFutureAdapter.a(new j0(this, iVar)));
        }
        Futures.addCallback(Futures.allAsList(this.f5815t), new g(), CameraXExecutors.directExecutor());
    }

    public boolean F() {
        i iVar = this.f5810o;
        return iVar != null && iVar.w();
    }

    public void F0() {
        i iVar = this.f5810o;
        if (iVar != null) {
            iVar.G(v1.h(iVar.r(), y()));
        }
    }

    public final void G0(State state) {
        if (!f5782g0.contains(this.f5804i)) {
            throw new AssertionError("Can only updated non-pending state from a pending state, but state is " + this.f5804i);
        } else if (!f5783h0.contains(state)) {
            throw new AssertionError("Invalid state transition. State is not a valid non-pending state while in a pending state: " + state);
        } else if (this.f5805j != state) {
            this.f5805j = state;
            this.f5790a.setState(StreamInfo.e(this.f5806k, C(state), this.f5812q));
        }
    }

    public void H0(androidx.camera.video.internal.encoder.h hVar, i iVar) {
        i iVar2 = iVar;
        long size = this.J + hVar.size();
        long j11 = this.R;
        if (j11 == 0 || size <= j11) {
            long q11 = hVar.q();
            long j12 = this.O;
            if (j12 == Long.MAX_VALUE) {
                this.O = q11;
                Logger.d("Recorder", String.format("First audio time: %d (%s)", new Object[]{Long.valueOf(q11), y.d.j(this.O)}));
            } else {
                TimeUnit timeUnit = TimeUnit.MICROSECONDS;
                String str = "Recorder";
                long nanos = timeUnit.toNanos(q11 - Math.min(this.L, j12));
                androidx.core.util.h.j(this.Q != Long.MAX_VALUE, "There should be a previous data for adjusting the duration.");
                long nanos2 = nanos + timeUnit.toNanos(q11 - this.Q);
                long j13 = this.S;
                if (j13 != 0 && nanos2 > j13) {
                    Logger.d(str, String.format("Audio data reaches duration limit %d > %d", new Object[]{Long.valueOf(nanos2), Long.valueOf(this.S)}));
                    Y(iVar2, 9, (Throwable) null);
                    return;
                }
            }
            this.A.writeSampleData(this.f5816u.intValue(), hVar.d(), hVar.h());
            this.J = size;
            this.Q = q11;
            return;
        }
        Logger.d("Recorder", String.format("Reach file size limit %d > %d", new Object[]{Long.valueOf(size), Long.valueOf(this.R)}));
        Y(iVar2, 2, (Throwable) null);
    }

    public void I0(androidx.camera.video.internal.encoder.h hVar, i iVar) {
        i iVar2 = iVar;
        if (this.f5817v != null) {
            long size = this.J + hVar.size();
            long j11 = this.R;
            long j12 = 0;
            if (j11 == 0 || size <= j11) {
                long q11 = hVar.q();
                long j13 = this.L;
                if (j13 == Long.MAX_VALUE) {
                    this.L = q11;
                    Logger.d("Recorder", String.format("First video time: %d (%s)", new Object[]{Long.valueOf(q11), y.d.j(this.L)}));
                } else {
                    TimeUnit timeUnit = TimeUnit.MICROSECONDS;
                    String str = "Recorder";
                    long nanos = timeUnit.toNanos(q11 - Math.min(j13, this.O));
                    androidx.core.util.h.j(this.P != Long.MAX_VALUE, "There should be a previous data for adjusting the duration.");
                    long nanos2 = timeUnit.toNanos(q11 - this.P) + nanos;
                    long j14 = this.S;
                    if (j14 == 0 || nanos2 <= j14) {
                        j12 = nanos;
                    } else {
                        Logger.d(str, String.format("Video data reaches duration limit %d > %d", new Object[]{Long.valueOf(nanos2), Long.valueOf(this.S)}));
                        Y(iVar2, 9, (Throwable) null);
                        return;
                    }
                }
                this.A.writeSampleData(this.f5817v.intValue(), hVar.d(), hVar.h());
                this.J = size;
                this.K = j12;
                this.P = q11;
                F0();
                return;
            }
            Logger.d("Recorder", String.format("Reach file size limit %d > %d", new Object[]{Long.valueOf(size), Long.valueOf(this.R)}));
            Y(iVar2, 2, (Throwable) null);
            return;
        }
        throw new AssertionError("Video data comes before the track is added to MediaMuxer.");
    }

    public final i U(State state) {
        boolean z11;
        if (state == State.PENDING_PAUSED) {
            z11 = true;
        } else if (state == State.PENDING_RECORDING) {
            z11 = false;
        } else {
            throw new AssertionError("makePendingRecordingActiveLocked() can only be called from a pending state.");
        }
        if (this.f5807l == null) {
            i iVar = this.f5808m;
            if (iVar != null) {
                this.f5807l = iVar;
                this.f5808m = null;
                if (z11) {
                    q0(State.PAUSED);
                } else {
                    q0(State.RECORDING);
                }
                return iVar;
            }
            throw new AssertionError("Pending recording should exist when in a PENDING state.");
        }
        throw new AssertionError("Cannot make pending recording active because another recording is already active.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0051, code lost:
        if (r9.f5807l == null) goto L_0x0055;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0053, code lost:
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0059, code lost:
        if (r9.Z != androidx.camera.video.VideoOutput.SourceState.INACTIVE) goto L_0x0067;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x005b, code lost:
        r5 = r9.f5808m;
        r9.f5808m = null;
        l0();
        r6 = 4;
        r7 = f5787l0;
        r8 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0067, code lost:
        r6 = 0;
        r8 = 0;
        r7 = null;
        r4 = U(r9.f5804i);
        r5 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0076, code lost:
        androidx.core.util.h.j(F(), "Unexpectedly invoke onConfigured() when there's a non-persistent in-progress recording");
        r8 = 1;
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0082, code lost:
        r1 = false;
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0084, code lost:
        r8 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0085, code lost:
        r5 = null;
        r7 = null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void W() {
        /*
            r9 = this;
            java.lang.Object r0 = r9.f5802g
            monitor-enter(r0)
            int[] r1 = androidx.camera.video.Recorder.h.f5842a     // Catch:{ all -> 0x00bf }
            androidx.camera.video.Recorder$State r2 = r9.f5804i     // Catch:{ all -> 0x00bf }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x00bf }
            r1 = r1[r2]     // Catch:{ all -> 0x00bf }
            r2 = 1
            r3 = 0
            r4 = 0
            switch(r1) {
                case 1: goto L_0x0075;
                case 2: goto L_0x0073;
                case 3: goto L_0x004e;
                case 4: goto L_0x004c;
                case 5: goto L_0x0033;
                case 6: goto L_0x0025;
                case 7: goto L_0x001e;
                case 8: goto L_0x0015;
                case 9: goto L_0x0033;
                default: goto L_0x0013;
            }     // Catch:{ all -> 0x00bf }
        L_0x0013:
            goto L_0x0082
        L_0x0015:
            java.lang.String r1 = "Recorder"
            java.lang.String r5 = "onConfigured() was invoked when the Recorder had encountered error"
            androidx.camera.core.Logger.e(r1, r5)     // Catch:{ all -> 0x00bf }
            goto L_0x0082
        L_0x001e:
            androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.IDLING     // Catch:{ all -> 0x00bf }
            r9.q0(r1)     // Catch:{ all -> 0x00bf }
            goto L_0x0082
        L_0x0025:
            boolean r1 = r9.f5803h     // Catch:{ all -> 0x00bf }
            if (r1 == 0) goto L_0x002b
            goto L_0x0082
        L_0x002b:
            java.lang.AssertionError r1 = new java.lang.AssertionError     // Catch:{ all -> 0x00bf }
            java.lang.String r2 = "Unexpectedly invoke onConfigured() in a STOPPING state when it's not waiting for a new surface."
            r1.<init>(r2)     // Catch:{ all -> 0x00bf }
            throw r1     // Catch:{ all -> 0x00bf }
        L_0x0033:
            java.lang.AssertionError r1 = new java.lang.AssertionError     // Catch:{ all -> 0x00bf }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bf }
            r2.<init>()     // Catch:{ all -> 0x00bf }
            java.lang.String r3 = "Incorrectly invoke onConfigured() in state "
            r2.append(r3)     // Catch:{ all -> 0x00bf }
            androidx.camera.video.Recorder$State r3 = r9.f5804i     // Catch:{ all -> 0x00bf }
            r2.append(r3)     // Catch:{ all -> 0x00bf }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x00bf }
            r1.<init>(r2)     // Catch:{ all -> 0x00bf }
            throw r1     // Catch:{ all -> 0x00bf }
        L_0x004c:
            r1 = r3
            goto L_0x004f
        L_0x004e:
            r1 = r2
        L_0x004f:
            androidx.camera.video.Recorder$i r5 = r9.f5807l     // Catch:{ all -> 0x00bf }
            if (r5 == 0) goto L_0x0055
            r6 = r3
            goto L_0x0084
        L_0x0055:
            androidx.camera.video.VideoOutput$SourceState r5 = r9.Z     // Catch:{ all -> 0x00bf }
            androidx.camera.video.VideoOutput$SourceState r6 = androidx.camera.video.VideoOutput.SourceState.INACTIVE     // Catch:{ all -> 0x00bf }
            if (r5 != r6) goto L_0x0067
            androidx.camera.video.Recorder$i r5 = r9.f5808m     // Catch:{ all -> 0x00bf }
            r9.f5808m = r4     // Catch:{ all -> 0x00bf }
            r9.l0()     // Catch:{ all -> 0x00bf }
            r6 = 4
            java.lang.Exception r7 = f5787l0     // Catch:{ all -> 0x00bf }
            r8 = r3
            goto L_0x0087
        L_0x0067:
            androidx.camera.video.Recorder$State r5 = r9.f5804i     // Catch:{ all -> 0x00bf }
            androidx.camera.video.Recorder$i r5 = r9.U(r5)     // Catch:{ all -> 0x00bf }
            r6 = r3
            r8 = r6
            r7 = r4
            r4 = r5
            r5 = r7
            goto L_0x0087
        L_0x0073:
            r1 = r3
            goto L_0x0076
        L_0x0075:
            r1 = r2
        L_0x0076:
            boolean r5 = r9.F()     // Catch:{ all -> 0x00bf }
            java.lang.String r6 = "Unexpectedly invoke onConfigured() when there's a non-persistent in-progress recording"
            androidx.core.util.h.j(r5, r6)     // Catch:{ all -> 0x00bf }
            r8 = r2
            r6 = r3
            goto L_0x0085
        L_0x0082:
            r1 = r3
            r6 = r1
        L_0x0084:
            r8 = r6
        L_0x0085:
            r5 = r4
            r7 = r5
        L_0x0087:
            monitor-exit(r0)     // Catch:{ all -> 0x00bf }
            if (r8 == 0) goto L_0x00b3
            androidx.camera.video.Recorder$i r0 = r9.f5810o
            r9.E0(r0, r2)
            androidx.camera.video.internal.encoder.k r0 = r9.D
            r0.start()
            boolean r0 = r9.f5801f0
            if (r0 == 0) goto L_0x00ab
            androidx.camera.video.Recorder$i r0 = r9.f5810o
            androidx.camera.video.t r2 = r0.r()
            androidx.camera.video.a1 r4 = r9.y()
            androidx.camera.video.v1$c r2 = androidx.camera.video.v1.f(r2, r4)
            r0.G(r2)
            r9.f5801f0 = r3
        L_0x00ab:
            if (r1 == 0) goto L_0x00be
            androidx.camera.video.internal.encoder.k r0 = r9.D
            r0.pause()
            goto L_0x00be
        L_0x00b3:
            if (r4 == 0) goto L_0x00b9
            r9.y0(r4, r1)
            goto L_0x00be
        L_0x00b9:
            if (r5 == 0) goto L_0x00be
            r9.w(r5, r6, r7)
        L_0x00be:
            return
        L_0x00bf:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00bf }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.Recorder.W():void");
    }

    public void X(Throwable th2) {
        i iVar;
        synchronized (this.f5802g) {
            iVar = null;
            switch (h.f5842a[this.f5804i.ordinal()]) {
                case 1:
                case 2:
                case 5:
                case 6:
                case 9:
                    throw new AssertionError("Encountered encoder setup error while in unexpected state " + this.f5804i + com.sumsub.sns.internal.fingerprint.infoproviders.l.f34627b + th2);
                case 3:
                case 4:
                    i iVar2 = this.f5808m;
                    this.f5808m = null;
                    iVar = iVar2;
                    break;
                case 7:
                    break;
            }
            r0(-1);
            q0(State.ERROR);
        }
        if (iVar != null) {
            w(iVar, 7, th2);
        }
    }

    public void Y(i iVar, int i11, Throwable th2) {
        if (iVar == this.f5810o) {
            boolean z11 = false;
            synchronized (this.f5802g) {
                switch (h.f5842a[this.f5804i.ordinal()]) {
                    case 1:
                    case 2:
                        q0(State.STOPPING);
                        z11 = true;
                        break;
                    case 3:
                    case 4:
                    case 5:
                    case 6:
                        break;
                    case 7:
                    case 8:
                    case 9:
                        throw new AssertionError("In-progress recording error occurred while in unexpected state: " + this.f5804i);
                }
                if (iVar != this.f5807l) {
                    throw new AssertionError("Internal error occurred for recording but it is not the active recording.");
                }
            }
            if (z11) {
                O(iVar, -1, i11, th2);
                return;
            }
            return;
        }
        throw new AssertionError("Internal error occurred on recording that is not the current in-progress recording.");
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v6, resolved type: androidx.camera.video.Recorder$i} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: androidx.camera.video.Recorder$i} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: androidx.camera.video.Recorder$i} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v18, resolved type: androidx.camera.video.Recorder$i} */
    /* JADX WARNING: type inference failed for: r2v17 */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0024, code lost:
        r2 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x002e, code lost:
        if (r7.Z != androidx.camera.video.VideoOutput.SourceState.INACTIVE) goto L_0x0040;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0030, code lost:
        r2 = r7.f5808m;
        r7.f5808m = null;
        q0(androidx.camera.video.Recorder.State.CONFIGURING);
        r4 = 4;
        r5 = f5787l0;
        r6 = r1;
        r1 = false;
        r2 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        if (r7.f5803h == false) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0044, code lost:
        r7.f5821z = null;
        r4 = r7.f5818w;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0048, code lost:
        if (r4 == null) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x004e, code lost:
        if (r4.isServiced() != false) goto L_0x0051;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0051, code lost:
        r2 = false;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0052, code lost:
        G0(androidx.camera.video.Recorder.State.CONFIGURING);
        r5 = null;
        r6 = r1;
        r1 = r2;
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x005e, code lost:
        if (r7.D == null) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0060, code lost:
        r5 = null;
        r6 = r1;
        r1 = false;
        r4 = 0;
        r8 = U(r7.f5804i);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x006c, code lost:
        r2 = null;
        r5 = null;
        r6 = r1;
        r1 = false;
        r4 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0093, code lost:
        r2 = null;
        r5 = null;
        r1 = false;
        r4 = 0;
        r6 = false;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void Z(androidx.camera.video.Recorder.i r8) {
        /*
            r7 = this;
            java.lang.Object r0 = r7.f5802g
            monitor-enter(r0)
            androidx.camera.video.Recorder$i r1 = r7.f5807l     // Catch:{ all -> 0x00e2 }
            if (r1 != r8) goto L_0x00da
            r8 = 0
            r7.f5807l = r8     // Catch:{ all -> 0x00e2 }
            int[] r1 = androidx.camera.video.Recorder.h.f5842a     // Catch:{ all -> 0x00e2 }
            androidx.camera.video.Recorder$State r2 = r7.f5804i     // Catch:{ all -> 0x00e2 }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x00e2 }
            r1 = r1[r2]     // Catch:{ all -> 0x00e2 }
            r2 = 9
            if (r1 == r2) goto L_0x00c1
            r2 = 1
            r3 = 0
            switch(r1) {
                case 1: goto L_0x0072;
                case 2: goto L_0x0072;
                case 3: goto L_0x0029;
                case 4: goto L_0x0027;
                case 5: goto L_0x001f;
                case 6: goto L_0x0072;
                default: goto L_0x001d;
            }     // Catch:{ all -> 0x00e2 }
        L_0x001d:
            goto L_0x0093
        L_0x001f:
            r5 = r8
            r1 = r3
            r4 = r1
            r6 = r4
            r3 = r2
        L_0x0024:
            r2 = r5
            goto L_0x0098
        L_0x0027:
            r1 = r3
            goto L_0x002a
        L_0x0029:
            r1 = r2
        L_0x002a:
            androidx.camera.video.VideoOutput$SourceState r4 = r7.Z     // Catch:{ all -> 0x00e2 }
            androidx.camera.video.VideoOutput$SourceState r5 = androidx.camera.video.VideoOutput.SourceState.INACTIVE     // Catch:{ all -> 0x00e2 }
            if (r4 != r5) goto L_0x0040
            androidx.camera.video.Recorder$i r2 = r7.f5808m     // Catch:{ all -> 0x00e2 }
            r7.f5808m = r8     // Catch:{ all -> 0x00e2 }
            androidx.camera.video.Recorder$State r4 = androidx.camera.video.Recorder.State.CONFIGURING     // Catch:{ all -> 0x00e2 }
            r7.q0(r4)     // Catch:{ all -> 0x00e2 }
            r4 = 4
            java.lang.Exception r5 = f5787l0     // Catch:{ all -> 0x00e2 }
            r6 = r1
            r1 = r3
            goto L_0x0098
        L_0x0040:
            boolean r4 = r7.f5803h     // Catch:{ all -> 0x00e2 }
            if (r4 == 0) goto L_0x005c
            r7.f5821z = r8     // Catch:{ all -> 0x00e2 }
            androidx.camera.core.SurfaceRequest r4 = r7.f5818w     // Catch:{ all -> 0x00e2 }
            if (r4 == 0) goto L_0x0051
            boolean r4 = r4.isServiced()     // Catch:{ all -> 0x00e2 }
            if (r4 != 0) goto L_0x0051
            goto L_0x0052
        L_0x0051:
            r2 = r3
        L_0x0052:
            androidx.camera.video.Recorder$State r4 = androidx.camera.video.Recorder.State.CONFIGURING     // Catch:{ all -> 0x00e2 }
            r7.G0(r4)     // Catch:{ all -> 0x00e2 }
            r5 = r8
            r6 = r1
            r1 = r2
            r4 = r3
            goto L_0x0024
        L_0x005c:
            androidx.camera.video.internal.encoder.k r2 = r7.D     // Catch:{ all -> 0x00e2 }
            if (r2 == 0) goto L_0x006c
            androidx.camera.video.Recorder$State r2 = r7.f5804i     // Catch:{ all -> 0x00e2 }
            androidx.camera.video.Recorder$i r2 = r7.U(r2)     // Catch:{ all -> 0x00e2 }
            r5 = r8
            r6 = r1
            r1 = r3
            r4 = r1
            r8 = r2
            goto L_0x0024
        L_0x006c:
            r2 = r8
            r5 = r2
            r6 = r1
            r1 = r3
            r4 = r1
            goto L_0x0098
        L_0x0072:
            boolean r1 = r7.f5803h     // Catch:{ all -> 0x00e2 }
            if (r1 == 0) goto L_0x008e
            r7.f5821z = r8     // Catch:{ all -> 0x00e2 }
            androidx.camera.core.SurfaceRequest r1 = r7.f5818w     // Catch:{ all -> 0x00e2 }
            if (r1 == 0) goto L_0x0083
            boolean r1 = r1.isServiced()     // Catch:{ all -> 0x00e2 }
            if (r1 != 0) goto L_0x0083
            goto L_0x0084
        L_0x0083:
            r2 = r3
        L_0x0084:
            androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.CONFIGURING     // Catch:{ all -> 0x00e2 }
            r7.q0(r1)     // Catch:{ all -> 0x00e2 }
            r5 = r8
            r1 = r2
            r4 = r3
            r6 = r4
            goto L_0x0024
        L_0x008e:
            androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.IDLING     // Catch:{ all -> 0x00e2 }
            r7.q0(r1)     // Catch:{ all -> 0x00e2 }
        L_0x0093:
            r2 = r8
            r5 = r2
            r1 = r3
            r4 = r1
            r6 = r4
        L_0x0098:
            monitor-exit(r0)     // Catch:{ all -> 0x00e2 }
            if (r1 == 0) goto L_0x00a3
            androidx.camera.core.SurfaceRequest r8 = r7.f5818w
            androidx.camera.core.impl.Timebase r0 = r7.f5819x
            r7.u(r8, r0)
            goto L_0x00c0
        L_0x00a3:
            if (r3 == 0) goto L_0x00a9
            r7.j0()
            goto L_0x00c0
        L_0x00a9:
            if (r8 == 0) goto L_0x00bb
            boolean r0 = r7.f5803h
            if (r0 != 0) goto L_0x00b3
            r7.y0(r8, r6)
            goto L_0x00c0
        L_0x00b3:
            java.lang.AssertionError r8 = new java.lang.AssertionError
            java.lang.String r0 = "Attempt to start a pending recording while the Recorder is waiting for a new surface request."
            r8.<init>(r0)
            throw r8
        L_0x00bb:
            if (r2 == 0) goto L_0x00c0
            r7.w(r2, r4, r5)
        L_0x00c0:
            return
        L_0x00c1:
            java.lang.AssertionError r8 = new java.lang.AssertionError     // Catch:{ all -> 0x00e2 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x00e2 }
            r1.<init>()     // Catch:{ all -> 0x00e2 }
            java.lang.String r2 = "Unexpected state on finalize of recording: "
            r1.append(r2)     // Catch:{ all -> 0x00e2 }
            androidx.camera.video.Recorder$State r2 = r7.f5804i     // Catch:{ all -> 0x00e2 }
            r1.append(r2)     // Catch:{ all -> 0x00e2 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x00e2 }
            r8.<init>(r1)     // Catch:{ all -> 0x00e2 }
            throw r8     // Catch:{ all -> 0x00e2 }
        L_0x00da:
            java.lang.AssertionError r8 = new java.lang.AssertionError     // Catch:{ all -> 0x00e2 }
            java.lang.String r1 = "Active recording did not match finalized recording on finalize."
            r8.<init>(r1)     // Catch:{ all -> 0x00e2 }
            throw r8     // Catch:{ all -> 0x00e2 }
        L_0x00e2:
            r8 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00e2 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.Recorder.Z(androidx.camera.video.Recorder$i):void");
    }

    public void a(SurfaceRequest surfaceRequest, Timebase timebase) {
        synchronized (this.f5802g) {
            Logger.d("Recorder", "Surface is requested in state: " + this.f5804i + ", Current surface: " + this.f5806k);
            if (this.f5804i == State.ERROR) {
                q0(State.CONFIGURING);
            }
        }
        this.f5796d.execute(new a0(this, surfaceRequest, timebase));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        q0(androidx.camera.video.Recorder.State.CONFIGURING);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0025, code lost:
        r1 = true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a0() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f5802g
            monitor-enter(r0)
            int[] r1 = androidx.camera.video.Recorder.h.f5842a     // Catch:{ all -> 0x003d }
            androidx.camera.video.Recorder$State r2 = r3.f5804i     // Catch:{ all -> 0x003d }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x003d }
            r1 = r1[r2]     // Catch:{ all -> 0x003d }
            r2 = 0
            switch(r1) {
                case 1: goto L_0x0018;
                case 2: goto L_0x0018;
                case 3: goto L_0x0012;
                case 4: goto L_0x0012;
                case 5: goto L_0x0020;
                case 6: goto L_0x0020;
                case 7: goto L_0x0011;
                case 8: goto L_0x0018;
                case 9: goto L_0x0020;
                default: goto L_0x0011;
            }     // Catch:{ all -> 0x003d }
        L_0x0011:
            goto L_0x0025
        L_0x0012:
            androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.CONFIGURING     // Catch:{ all -> 0x003d }
            r3.G0(r1)     // Catch:{ all -> 0x003d }
            goto L_0x0025
        L_0x0018:
            boolean r1 = r3.F()     // Catch:{ all -> 0x003d }
            if (r1 == 0) goto L_0x0020
            r1 = r2
            goto L_0x0026
        L_0x0020:
            androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.CONFIGURING     // Catch:{ all -> 0x003d }
            r3.q0(r1)     // Catch:{ all -> 0x003d }
        L_0x0025:
            r1 = 1
        L_0x0026:
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            r3.f5793b0 = r2
            if (r1 == 0) goto L_0x003c
            androidx.camera.core.SurfaceRequest r0 = r3.f5818w
            if (r0 == 0) goto L_0x003c
            boolean r0 = r0.isServiced()
            if (r0 != 0) goto L_0x003c
            androidx.camera.core.SurfaceRequest r0 = r3.f5818w
            androidx.camera.core.impl.Timebase r1 = r3.f5819x
            r3.u(r0, r1)
        L_0x003c:
            return
        L_0x003d:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x003d }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.Recorder.a0():void");
    }

    public Observable<r> b() {
        return this.B;
    }

    /* renamed from: b0 */
    public void J(VideoOutput.SourceState sourceState) {
        ScheduledFuture<?> scheduledFuture;
        k kVar;
        VideoOutput.SourceState sourceState2 = this.Z;
        this.Z = sourceState;
        if (sourceState2 != sourceState) {
            Logger.d("Recorder", "Video source has transitioned to state: " + sourceState);
            if (sourceState == VideoOutput.SourceState.INACTIVE) {
                if (this.f5821z == null) {
                    i0(4, (Throwable) null, false);
                    return;
                }
                this.f5793b0 = true;
                i iVar = this.f5810o;
                if (iVar != null && !iVar.w()) {
                    Y(this.f5810o, 4, (Throwable) null);
                }
            } else if (sourceState == VideoOutput.SourceState.ACTIVE_NON_STREAMING && (scheduledFuture = this.f5791a0) != null && scheduledFuture.cancel(false) && (kVar = this.D) != null) {
                V(kVar);
            }
        } else {
            Logger.d("Recorder", "Video source transitions to the same state: " + sourceState);
        }
    }

    public Observable<StreamInfo> c() {
        return this.f5790a;
    }

    /* renamed from: c0 */
    public final void K(SurfaceRequest surfaceRequest, Timebase timebase) {
        SurfaceRequest surfaceRequest2 = this.f5818w;
        if (surfaceRequest2 != null && !surfaceRequest2.isServiced()) {
            this.f5818w.willNotProvideSurface();
        }
        this.f5818w = surfaceRequest;
        this.f5819x = timebase;
        u(surfaceRequest, timebase);
    }

    public void d(VideoOutput.SourceState sourceState) {
        this.f5796d.execute(new d0(this, sourceState));
    }

    public void d0(VideoEncoderSession videoEncoderSession) {
        k m11 = videoEncoderSession.m();
        this.D = m11;
        this.N = ((k1) m11.c()).b();
        this.M = this.D.g();
        Surface k11 = videoEncoderSession.k();
        this.f5821z = k11;
        p0(k11);
        videoEncoderSession.v(this.f5796d, new g0(this));
        Futures.addCallback(videoEncoderSession.l(), new b(videoEncoderSession), this.f5796d);
    }

    public c1 e(CameraInfo cameraInfo) {
        return A(cameraInfo);
    }

    public final void e0(i iVar) {
        if (this.f5810o == iVar && !this.f5811p) {
            if (D()) {
                this.F.pause();
            }
            this.D.pause();
            i iVar2 = this.f5810o;
            iVar2.G(v1.e(iVar2.r(), y()));
        }
    }

    public u f0(Context context, q qVar) {
        return g0(context, qVar);
    }

    public final u g0(Context context, t tVar) {
        androidx.core.util.h.h(tVar, "The OutputOptions cannot be null.");
        return new u(context, this, tVar);
    }

    public final void h0() {
        AudioSource audioSource = this.C;
        if (audioSource != null) {
            this.C = null;
            Logger.d("Recorder", String.format("Releasing audio source: 0x%x", new Object[]{Integer.valueOf(audioSource.hashCode())}));
            Futures.addCallback(audioSource.H(), new c(audioSource), CameraXExecutors.directExecutor());
            return;
        }
        throw new AssertionError("Cannot release null audio source.");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005b, code lost:
        r3 = false;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i0(int r12, java.lang.Throwable r13, boolean r14) {
        /*
            r11 = this;
            java.lang.Object r0 = r11.f5802g
            monitor-enter(r0)
            int[] r1 = androidx.camera.video.Recorder.h.f5842a     // Catch:{ all -> 0x0076 }
            androidx.camera.video.Recorder$State r2 = r11.f5804i     // Catch:{ all -> 0x0076 }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x0076 }
            r1 = r1[r2]     // Catch:{ all -> 0x0076 }
            r2 = 0
            r3 = 1
            switch(r1) {
                case 1: goto L_0x0023;
                case 2: goto L_0x0023;
                case 3: goto L_0x001d;
                case 4: goto L_0x001d;
                case 5: goto L_0x0012;
                case 6: goto L_0x0017;
                case 7: goto L_0x0013;
                case 8: goto L_0x0013;
                case 9: goto L_0x0013;
                default: goto L_0x0012;
            }     // Catch:{ all -> 0x0076 }
        L_0x0012:
            goto L_0x005b
        L_0x0013:
            r10 = r3
            r3 = r2
            r2 = r10
            goto L_0x005c
        L_0x0017:
            androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.RESETTING     // Catch:{ all -> 0x0076 }
            r11.q0(r1)     // Catch:{ all -> 0x0076 }
            goto L_0x005b
        L_0x001d:
            androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.RESETTING     // Catch:{ all -> 0x0076 }
            r11.G0(r1)     // Catch:{ all -> 0x0076 }
            goto L_0x0013
        L_0x0023:
            androidx.camera.video.Recorder$i r1 = r11.f5810o     // Catch:{ all -> 0x0076 }
            if (r1 == 0) goto L_0x0029
            r1 = r3
            goto L_0x002a
        L_0x0029:
            r1 = r2
        L_0x002a:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0076 }
            r4.<init>()     // Catch:{ all -> 0x0076 }
            java.lang.String r5 = "In-progress recording shouldn't be null when in state "
            r4.append(r5)     // Catch:{ all -> 0x0076 }
            androidx.camera.video.Recorder$State r5 = r11.f5804i     // Catch:{ all -> 0x0076 }
            r4.append(r5)     // Catch:{ all -> 0x0076 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0076 }
            androidx.core.util.h.j(r1, r4)     // Catch:{ all -> 0x0076 }
            androidx.camera.video.Recorder$i r1 = r11.f5807l     // Catch:{ all -> 0x0076 }
            androidx.camera.video.Recorder$i r4 = r11.f5810o     // Catch:{ all -> 0x0076 }
            if (r1 != r4) goto L_0x0053
            boolean r1 = r11.F()     // Catch:{ all -> 0x0076 }
            if (r1 == 0) goto L_0x004d
            goto L_0x0013
        L_0x004d:
            androidx.camera.video.Recorder$State r1 = androidx.camera.video.Recorder.State.RESETTING     // Catch:{ all -> 0x0076 }
            r11.q0(r1)     // Catch:{ all -> 0x0076 }
            goto L_0x005c
        L_0x0053:
            java.lang.AssertionError r12 = new java.lang.AssertionError     // Catch:{ all -> 0x0076 }
            java.lang.String r13 = "In-progress recording does not match the active recording. Unable to reset encoder."
            r12.<init>(r13)     // Catch:{ all -> 0x0076 }
            throw r12     // Catch:{ all -> 0x0076 }
        L_0x005b:
            r3 = r2
        L_0x005c:
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            if (r2 == 0) goto L_0x0069
            if (r14 == 0) goto L_0x0065
            r11.k0()
            goto L_0x0075
        L_0x0065:
            r11.j0()
            goto L_0x0075
        L_0x0069:
            if (r3 == 0) goto L_0x0075
            androidx.camera.video.Recorder$i r5 = r11.f5810o
            r6 = -1
            r4 = r11
            r8 = r12
            r9 = r13
            r4.O(r5, r6, r8, r9)
        L_0x0075:
            return
        L_0x0076:
            r12 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0076 }
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.Recorder.i0(int, java.lang.Throwable, boolean):void");
    }

    public final void j0() {
        if (this.F != null) {
            Logger.d("Recorder", "Releasing audio encoder.");
            this.F.release();
            this.F = null;
            this.G = null;
        }
        if (this.C != null) {
            h0();
        }
        n0(AudioState.INITIALIZING);
        k0();
    }

    public final void k0() {
        if (this.D != null) {
            Logger.d("Recorder", "Releasing video encoder.");
            C0();
        }
        a0();
    }

    public final void l0() {
        if (f5782g0.contains(this.f5804i)) {
            q0(this.f5805j);
            return;
        }
        throw new AssertionError("Cannot restore non-pending state when in state " + this.f5804i);
    }

    public final ListenableFuture<Void> m0() {
        Logger.d("Recorder", "Try to safely release video encoder: " + this.D);
        return this.f5795c0.w();
    }

    public void n0(AudioState audioState) {
        Logger.d("Recorder", "Transitioning audio state: " + this.H + " --> " + audioState);
        this.H = audioState;
    }

    public void o0(SurfaceRequest.TransformationInfo transformationInfo) {
        Logger.d("Recorder", "Update stream transformation info: " + transformationInfo);
        this.f5812q = transformationInfo;
        synchronized (this.f5802g) {
            this.f5790a.setState(StreamInfo.e(this.f5806k, C(this.f5804i), transformationInfo));
        }
    }

    public void onSurfaceRequested(SurfaceRequest surfaceRequest) {
        a(surfaceRequest, Timebase.UPTIME);
    }

    public void p0(Surface surface) {
        int i11;
        if (this.f5820y != surface) {
            this.f5820y = surface;
            synchronized (this.f5802g) {
                if (surface != null) {
                    try {
                        i11 = surface.hashCode();
                    } catch (Throwable th2) {
                        throw th2;
                    }
                } else {
                    i11 = 0;
                }
                r0(i11);
            }
        }
    }

    public void q0(State state) {
        if (this.f5804i != state) {
            Logger.d("Recorder", "Transitioning Recorder internal state: " + this.f5804i + " --> " + state);
            Set<State> set = f5782g0;
            StreamInfo.StreamState streamState = null;
            if (set.contains(state)) {
                if (!set.contains(this.f5804i)) {
                    if (f5783h0.contains(this.f5804i)) {
                        State state2 = this.f5804i;
                        this.f5805j = state2;
                        streamState = C(state2);
                    } else {
                        throw new AssertionError("Invalid state transition. Should not be transitioning to a PENDING state from state " + this.f5804i);
                    }
                }
            } else if (this.f5805j != null) {
                this.f5805j = null;
            }
            this.f5804i = state;
            if (streamState == null) {
                streamState = C(state);
            }
            this.f5790a.setState(StreamInfo.e(this.f5806k, streamState, this.f5812q));
            return;
        }
        throw new AssertionError("Attempted to transition to state " + state + ", but Recorder is already in state " + state);
    }

    public final void r0(int i11) {
        if (this.f5806k != i11) {
            Logger.d("Recorder", "Transitioning streamId: " + this.f5806k + " --> " + i11);
            this.f5806k = i11;
            this.f5790a.setState(StreamInfo.e(i11, C(this.f5804i), this.f5812q));
        }
    }

    public final void s() {
        while (!this.W.isEmpty()) {
            this.W.dequeue();
        }
    }

    public void s0(i iVar) {
        int i11;
        MediaMuxer F2;
        if (this.A != null) {
            throw new AssertionError("Unable to set up media muxer when one already exists.");
        } else if (!D() || !this.W.isEmpty()) {
            androidx.camera.video.internal.encoder.h hVar = this.V;
            if (hVar != null) {
                try {
                    this.V = null;
                    List<androidx.camera.video.internal.encoder.h> x11 = x(hVar.q());
                    long size = hVar.size();
                    for (androidx.camera.video.internal.encoder.h size2 : x11) {
                        size += size2.size();
                    }
                    long j11 = this.R;
                    if (j11 == 0 || size <= j11) {
                        try {
                            r rVar = (r) z(this.B);
                            if (rVar.c() == -1) {
                                i11 = B0(this.f5814s, r.g(f5786k0.c()));
                            } else {
                                i11 = r.g(rVar.c());
                            }
                            F2 = iVar.F(i11, new k0(this));
                            SurfaceRequest.TransformationInfo transformationInfo = this.f5813r;
                            if (transformationInfo != null) {
                                o0(transformationInfo);
                                F2.setOrientationHint(transformationInfo.getRotationDegrees());
                            }
                            Location c11 = iVar.r().c();
                            if (c11 != null) {
                                Pair<Double, Double> a11 = d0.a.a(c11.getLatitude(), c11.getLongitude());
                                F2.setLocation((float) ((Double) a11.first).doubleValue(), (float) ((Double) a11.second).doubleValue());
                            }
                            this.f5817v = Integer.valueOf(F2.addTrack(this.E.a()));
                            if (D()) {
                                this.f5816u = Integer.valueOf(F2.addTrack(this.G.a()));
                            }
                            F2.start();
                            this.A = F2;
                            I0(hVar, iVar);
                            for (androidx.camera.video.internal.encoder.h H0 : x11) {
                                H0(H0, iVar);
                            }
                            hVar.close();
                        } catch (IOException e11) {
                            Y(iVar, 5, e11);
                            hVar.close();
                        }
                    } else {
                        Logger.d("Recorder", String.format("Initial data exceeds file size limit %d > %d", new Object[]{Long.valueOf(size), Long.valueOf(this.R)}));
                        Y(iVar, 2, (Throwable) null);
                        hVar.close();
                    }
                } catch (IllegalArgumentException e12) {
                    F2.release();
                    Y(iVar, 5, e12);
                    hVar.close();
                } catch (Throwable th2) {
                    if (hVar != null) {
                        try {
                            hVar.close();
                        } catch (Throwable th3) {
                            th2.addSuppressed(th3);
                        }
                    }
                    throw th2;
                }
            } else {
                throw new AssertionError("Media muxer cannot be started without an encoded video frame.");
            }
        } else {
            throw new AssertionError("Audio is enabled but no audio sample is ready. Cannot start media muxer.");
        }
    }

    public final r t(r rVar) {
        r.a i11 = rVar.i();
        if (rVar.d().b() == -1) {
            i11.b(m0.f6317b);
        }
        return i11.a();
    }

    public final void t0(i iVar) throws AudioSourceAccessException, InvalidConfigException {
        r rVar = (r) z(this.B);
        AudioMimeInfo d11 = androidx.camera.video.internal.config.a.d(rVar, this.f5814s);
        Timebase timebase = Timebase.UPTIME;
        androidx.camera.video.internal.audio.a e11 = androidx.camera.video.internal.config.a.e(d11, rVar.b());
        if (this.C != null) {
            h0();
        }
        AudioSource u02 = u0(iVar, e11);
        this.C = u02;
        Logger.d("Recorder", String.format("Set up new audio source: 0x%x", new Object[]{Integer.valueOf(u02.hashCode())}));
        k a11 = this.f5800f.a(this.f5794c, androidx.camera.video.internal.config.a.c(d11, timebase, e11, rVar.b()));
        this.F = a11;
        k.b d12 = a11.d();
        if (d12 instanceof k.a) {
            this.C.M((k.a) d12);
            return;
        }
        throw new AssertionError("The EncoderInput of audio isn't a ByteBufferInput.");
    }

    public final void u(SurfaceRequest surfaceRequest, Timebase timebase) {
        if (surfaceRequest.isServiced()) {
            Logger.w("Recorder", "Ignore the SurfaceRequest since it is already served.");
            return;
        }
        surfaceRequest.setTransformationInfoListener(this.f5796d, new z(this));
        Size resolution = surfaceRequest.getResolution();
        DynamicRange dynamicRange = surfaceRequest.getDynamicRange();
        c1 A2 = A(surfaceRequest.getCamera().getCameraInfo());
        v a11 = A2.a(resolution, dynamicRange);
        Logger.d("Recorder", "Using supported quality of " + a11 + " for surface size " + resolution);
        if (a11 != v.f6371g) {
            VideoValidatedEncoderProfilesProxy d11 = A2.d(a11, dynamicRange);
            this.f5814s = d11;
            if (d11 == null) {
                throw new AssertionError("Camera advertised available quality but did not produce EncoderProfiles  for advertised quality.");
            }
        }
        v0(surfaceRequest, timebase);
    }

    public final AudioSource u0(i iVar, androidx.camera.video.internal.audio.a aVar) throws AudioSourceAccessException {
        return iVar.E(aVar, f5789n0);
    }

    public void v(int i11, Throwable th2) {
        v1.a aVar;
        if (this.f5810o != null) {
            MediaMuxer mediaMuxer = this.A;
            if (mediaMuxer != null) {
                try {
                    mediaMuxer.stop();
                    this.A.release();
                } catch (IllegalStateException e11) {
                    Logger.e("Recorder", "MediaMuxer failed to stop or release with error: " + e11.getMessage());
                    if (i11 == 0) {
                        i11 = 1;
                    }
                }
                this.A = null;
            } else if (i11 == 0) {
                i11 = 8;
            }
            this.f5810o.l(this.I);
            t r11 = this.f5810o.r();
            a1 y11 = y();
            OutputResults b11 = OutputResults.b(this.I);
            i iVar = this.f5810o;
            if (i11 == 0) {
                aVar = v1.a(r11, y11, b11);
            } else {
                aVar = v1.b(r11, y11, b11, i11, th2);
            }
            iVar.G(aVar);
            i iVar2 = this.f5810o;
            this.f5810o = null;
            this.f5811p = false;
            this.f5816u = null;
            this.f5817v = null;
            this.f5815t.clear();
            this.I = Uri.EMPTY;
            this.J = 0;
            this.K = 0;
            this.L = Long.MAX_VALUE;
            this.O = Long.MAX_VALUE;
            this.P = Long.MAX_VALUE;
            this.Q = Long.MAX_VALUE;
            this.T = 1;
            this.U = null;
            this.X = null;
            this.f5799e0 = 0.0d;
            s();
            o0((SurfaceRequest.TransformationInfo) null);
            int i12 = h.f5843b[this.H.ordinal()];
            if (i12 == 1 || i12 == 2) {
                n0(AudioState.INITIALIZING);
            } else if (i12 == 3 || i12 == 4) {
                n0(AudioState.IDLING);
                this.C.Q();
            } else if (i12 == 5) {
                throw new AssertionError("Incorrectly finalize recording when audio state is IDLING");
            }
            Z(iVar2);
            return;
        }
        throw new AssertionError("Attempted to finalize in-progress recording, but no recording is in progress.");
    }

    public final void v0(SurfaceRequest surfaceRequest, Timebase timebase) {
        m0().addListener(new b0(this, surfaceRequest, timebase), this.f5796d);
    }

    public final void w(i iVar, int i11, Throwable th2) {
        iVar.l(Uri.EMPTY);
        iVar.G(v1.b(iVar.r(), a1.d(0, 0, b.d(1, this.X, 0.0d)), OutputResults.b(Uri.EMPTY), i11, th2));
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x007f, code lost:
        r5 = r3;
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0083, code lost:
        r3 = null;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0087  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x00b0  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public androidx.camera.video.z0 w0(androidx.camera.video.u r10) {
        /*
            r9 = this;
            java.lang.String r0 = "The given PendingRecording cannot be null."
            androidx.core.util.h.h(r10, r0)
            java.lang.Object r0 = r9.f5802g
            monitor-enter(r0)
            long r1 = r9.f5809n     // Catch:{ all -> 0x00b8 }
            r3 = 1
            long r1 = r1 + r3
            r9.f5809n = r1     // Catch:{ all -> 0x00b8 }
            int[] r3 = androidx.camera.video.Recorder.h.f5842a     // Catch:{ all -> 0x00b8 }
            androidx.camera.video.Recorder$State r4 = r9.f5804i     // Catch:{ all -> 0x00b8 }
            int r4 = r4.ordinal()     // Catch:{ all -> 0x00b8 }
            r3 = r3[r4]     // Catch:{ all -> 0x00b8 }
            r4 = 0
            r5 = 0
            switch(r3) {
                case 1: goto L_0x007d;
                case 2: goto L_0x007d;
                case 3: goto L_0x0074;
                case 4: goto L_0x0074;
                case 5: goto L_0x0020;
                case 6: goto L_0x0020;
                case 7: goto L_0x0020;
                case 8: goto L_0x0020;
                case 9: goto L_0x0020;
                default: goto L_0x001e;
            }     // Catch:{ all -> 0x00b8 }
        L_0x001e:
            goto L_0x0083
        L_0x0020:
            androidx.camera.video.Recorder$State r3 = r9.f5804i     // Catch:{ all -> 0x00b8 }
            androidx.camera.video.Recorder$State r6 = androidx.camera.video.Recorder.State.IDLING     // Catch:{ all -> 0x00b8 }
            if (r3 != r6) goto L_0x0036
            androidx.camera.video.Recorder$i r3 = r9.f5807l     // Catch:{ all -> 0x00b8 }
            if (r3 != 0) goto L_0x0030
            androidx.camera.video.Recorder$i r3 = r9.f5808m     // Catch:{ all -> 0x00b8 }
            if (r3 != 0) goto L_0x0030
            r3 = 1
            goto L_0x0031
        L_0x0030:
            r3 = r4
        L_0x0031:
            java.lang.String r7 = "Expected recorder to be idle but a recording is either pending or in progress."
            androidx.core.util.h.j(r3, r7)     // Catch:{ all -> 0x00b8 }
        L_0x0036:
            androidx.camera.video.Recorder$i r3 = androidx.camera.video.Recorder.i.n(r10, r1)     // Catch:{ IOException -> 0x0071 }
            android.content.Context r7 = r10.a()     // Catch:{ IOException -> 0x0071 }
            r3.u(r7)     // Catch:{ IOException -> 0x0071 }
            r9.f5808m = r3     // Catch:{ IOException -> 0x0071 }
            androidx.camera.video.Recorder$State r3 = r9.f5804i     // Catch:{ IOException -> 0x0071 }
            if (r3 != r6) goto L_0x0057
            androidx.camera.video.Recorder$State r3 = androidx.camera.video.Recorder.State.PENDING_RECORDING     // Catch:{ IOException -> 0x0071 }
            r9.q0(r3)     // Catch:{ IOException -> 0x0071 }
            java.util.concurrent.Executor r3 = r9.f5796d     // Catch:{ IOException -> 0x0071 }
            androidx.camera.video.n0 r6 = new androidx.camera.video.n0     // Catch:{ IOException -> 0x0071 }
            r6.<init>(r9)     // Catch:{ IOException -> 0x0071 }
            r3.execute(r6)     // Catch:{ IOException -> 0x0071 }
            goto L_0x0083
        L_0x0057:
            androidx.camera.video.Recorder$State r6 = androidx.camera.video.Recorder.State.ERROR     // Catch:{ IOException -> 0x0071 }
            if (r3 != r6) goto L_0x006b
            androidx.camera.video.Recorder$State r3 = androidx.camera.video.Recorder.State.PENDING_RECORDING     // Catch:{ IOException -> 0x0071 }
            r9.q0(r3)     // Catch:{ IOException -> 0x0071 }
            java.util.concurrent.Executor r3 = r9.f5796d     // Catch:{ IOException -> 0x0071 }
            androidx.camera.video.o0 r6 = new androidx.camera.video.o0     // Catch:{ IOException -> 0x0071 }
            r6.<init>(r9)     // Catch:{ IOException -> 0x0071 }
            r3.execute(r6)     // Catch:{ IOException -> 0x0071 }
            goto L_0x0083
        L_0x006b:
            androidx.camera.video.Recorder$State r3 = androidx.camera.video.Recorder.State.PENDING_RECORDING     // Catch:{ IOException -> 0x0071 }
            r9.q0(r3)     // Catch:{ IOException -> 0x0071 }
            goto L_0x0083
        L_0x0071:
            r3 = move-exception
            r4 = 5
            goto L_0x0084
        L_0x0074:
            androidx.camera.video.Recorder$i r3 = r9.f5808m     // Catch:{ all -> 0x00b8 }
            java.lang.Object r3 = androidx.core.util.h.g(r3)     // Catch:{ all -> 0x00b8 }
            androidx.camera.video.Recorder$i r3 = (androidx.camera.video.Recorder.i) r3     // Catch:{ all -> 0x00b8 }
            goto L_0x007f
        L_0x007d:
            androidx.camera.video.Recorder$i r3 = r9.f5807l     // Catch:{ all -> 0x00b8 }
        L_0x007f:
            r8 = r5
            r5 = r3
            r3 = r8
            goto L_0x0084
        L_0x0083:
            r3 = r5
        L_0x0084:
            monitor-exit(r0)     // Catch:{ all -> 0x00b8 }
            if (r5 != 0) goto L_0x00b0
            if (r4 == 0) goto L_0x00ab
            java.lang.String r0 = "Recorder"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "Recording was started when the Recorder had encountered error "
            r5.append(r6)
            r5.append(r3)
            java.lang.String r5 = r5.toString()
            androidx.camera.core.Logger.e(r0, r5)
            androidx.camera.video.Recorder$i r0 = androidx.camera.video.Recorder.i.n(r10, r1)
            r9.w(r0, r4, r3)
            androidx.camera.video.z0 r10 = androidx.camera.video.z0.a(r10, r1)
            return r10
        L_0x00ab:
            androidx.camera.video.z0 r10 = androidx.camera.video.z0.b(r10, r1)
            return r10
        L_0x00b0:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "A recording is already in progress. Previous recordings must be stopped before a new recording can be started."
            r10.<init>(r0)
            throw r10
        L_0x00b8:
            r10 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00b8 }
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.Recorder.w0(androidx.camera.video.u):androidx.camera.video.z0");
    }

    public final List<androidx.camera.video.internal.encoder.h> x(long j11) {
        ArrayList arrayList = new ArrayList();
        while (!this.W.isEmpty()) {
            androidx.camera.video.internal.encoder.h dequeue = this.W.dequeue();
            if (dequeue.q() >= j11) {
                arrayList.add(dequeue);
            }
        }
        return arrayList;
    }

    @SuppressLint({"MissingPermission"})
    public final void x0(i iVar) {
        AudioState audioState;
        AudioState audioState2;
        if (this.f5810o == null) {
            if (iVar.r().b() > 0) {
                this.R = Math.round(((double) iVar.r().b()) * 0.95d);
                Logger.d("Recorder", "File size limit in bytes: " + this.R);
            } else {
                this.R = 0;
            }
            if (iVar.r().a() > 0) {
                this.S = TimeUnit.MILLISECONDS.toNanos(iVar.r().a());
                Logger.d("Recorder", "Duration limit in nanoseconds: " + this.S);
            } else {
                this.S = 0;
            }
            this.f5810o = iVar;
            switch (h.f5843b[this.H.ordinal()]) {
                case 1:
                case 2:
                case 3:
                case 4:
                    throw new AssertionError("Incorrectly invoke startInternal in audio state " + this.H);
                case 5:
                    if (iVar.t()) {
                        audioState = AudioState.ENABLED;
                    } else {
                        audioState = AudioState.DISABLED;
                    }
                    n0(audioState);
                    break;
                case 6:
                    if (iVar.t()) {
                        if (E()) {
                            try {
                                if (!this.f5810o.w() || this.F == null) {
                                    t0(iVar);
                                }
                                n0(AudioState.ENABLED);
                                break;
                            } catch (AudioSourceAccessException | InvalidConfigException e11) {
                                Logger.e("Recorder", "Unable to create audio resource with error: ", e11);
                                if (e11 instanceof InvalidConfigException) {
                                    audioState2 = AudioState.ERROR_ENCODER;
                                } else {
                                    audioState2 = AudioState.ERROR_SOURCE;
                                }
                                n0(audioState2);
                                this.X = e11;
                                break;
                            }
                        } else {
                            throw new AssertionError("The Recorder doesn't support recording with audio");
                        }
                    }
                    break;
            }
            E0(iVar, false);
            if (D()) {
                this.C.O(iVar.v());
                this.F.start();
            }
            this.D.start();
            i iVar2 = this.f5810o;
            iVar2.G(v1.g(iVar2.r(), y()));
            return;
        }
        throw new AssertionError("Attempted to start a new recording while another was in progress.");
    }

    public a1 y() {
        return a1.d(this.K, this.J, b.d(B(this.H), this.X, this.f5799e0));
    }

    public final void y0(i iVar, boolean z11) {
        x0(iVar);
        if (z11) {
            e0(iVar);
        }
    }

    public <T> T z(StateObservable<T> stateObservable) {
        try {
            return stateObservable.fetchData().get();
        } catch (InterruptedException | ExecutionException e11) {
            throw new IllegalStateException(e11);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0082, code lost:
        if (r2 == null) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0086, code lost:
        if (r14 != 10) goto L_0x008f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0088, code lost:
        androidx.camera.core.Logger.e("Recorder", "Recording was stopped due to recording being garbage collected before any valid data has been produced.");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x008f, code lost:
        w(r2, 8, new java.lang.RuntimeException("Recording was stopped before any data could be produced.", r15));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void z0(androidx.camera.video.z0 r13, int r14, java.lang.Throwable r15) {
        /*
            r12 = this;
            java.lang.Object r0 = r12.f5802g
            monitor-enter(r0)
            androidx.camera.video.Recorder$i r1 = r12.f5808m     // Catch:{ all -> 0x009c }
            boolean r1 = G(r13, r1)     // Catch:{ all -> 0x009c }
            if (r1 != 0) goto L_0x002f
            androidx.camera.video.Recorder$i r1 = r12.f5807l     // Catch:{ all -> 0x009c }
            boolean r1 = G(r13, r1)     // Catch:{ all -> 0x009c }
            if (r1 != 0) goto L_0x002f
            java.lang.String r14 = "Recorder"
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x009c }
            r15.<init>()     // Catch:{ all -> 0x009c }
            java.lang.String r1 = "stop() called on a recording that is no longer active: "
            r15.append(r1)     // Catch:{ all -> 0x009c }
            androidx.camera.video.t r13 = r13.e()     // Catch:{ all -> 0x009c }
            r15.append(r13)     // Catch:{ all -> 0x009c }
            java.lang.String r13 = r15.toString()     // Catch:{ all -> 0x009c }
            androidx.camera.core.Logger.d(r14, r13)     // Catch:{ all -> 0x009c }
            monitor-exit(r0)     // Catch:{ all -> 0x009c }
            return
        L_0x002f:
            int[] r1 = androidx.camera.video.Recorder.h.f5842a     // Catch:{ all -> 0x009c }
            androidx.camera.video.Recorder$State r2 = r12.f5804i     // Catch:{ all -> 0x009c }
            int r2 = r2.ordinal()     // Catch:{ all -> 0x009c }
            r1 = r1[r2]     // Catch:{ all -> 0x009c }
            r2 = 0
            switch(r1) {
                case 1: goto L_0x0062;
                case 2: goto L_0x0062;
                case 3: goto L_0x0050;
                case 4: goto L_0x0050;
                case 5: goto L_0x0046;
                case 6: goto L_0x0046;
                case 7: goto L_0x003e;
                case 8: goto L_0x003d;
                case 9: goto L_0x003e;
                default: goto L_0x003d;
            }     // Catch:{ all -> 0x009c }
        L_0x003d:
            goto L_0x0081
        L_0x003e:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException     // Catch:{ all -> 0x009c }
            java.lang.String r14 = "Calling stop() while idling or initializing is invalid."
            r13.<init>(r14)     // Catch:{ all -> 0x009c }
            throw r13     // Catch:{ all -> 0x009c }
        L_0x0046:
            androidx.camera.video.Recorder$i r1 = r12.f5807l     // Catch:{ all -> 0x009c }
            boolean r13 = G(r13, r1)     // Catch:{ all -> 0x009c }
            androidx.core.util.h.i(r13)     // Catch:{ all -> 0x009c }
            goto L_0x0081
        L_0x0050:
            androidx.camera.video.Recorder$i r1 = r12.f5808m     // Catch:{ all -> 0x009c }
            boolean r13 = G(r13, r1)     // Catch:{ all -> 0x009c }
            androidx.core.util.h.i(r13)     // Catch:{ all -> 0x009c }
            androidx.camera.video.Recorder$i r13 = r12.f5808m     // Catch:{ all -> 0x009c }
            r12.f5808m = r2     // Catch:{ all -> 0x009c }
            r12.l0()     // Catch:{ all -> 0x009c }
            r2 = r13
            goto L_0x0081
        L_0x0062:
            androidx.camera.video.Recorder$State r13 = androidx.camera.video.Recorder.State.STOPPING     // Catch:{ all -> 0x009c }
            r12.q0(r13)     // Catch:{ all -> 0x009c }
            java.util.concurrent.TimeUnit r13 = java.util.concurrent.TimeUnit.NANOSECONDS     // Catch:{ all -> 0x009c }
            long r3 = java.lang.System.nanoTime()     // Catch:{ all -> 0x009c }
            long r8 = r13.toMicros(r3)     // Catch:{ all -> 0x009c }
            androidx.camera.video.Recorder$i r7 = r12.f5807l     // Catch:{ all -> 0x009c }
            java.util.concurrent.Executor r13 = r12.f5796d     // Catch:{ all -> 0x009c }
            androidx.camera.video.c0 r1 = new androidx.camera.video.c0     // Catch:{ all -> 0x009c }
            r5 = r1
            r6 = r12
            r10 = r14
            r11 = r15
            r5.<init>(r6, r7, r8, r10, r11)     // Catch:{ all -> 0x009c }
            r13.execute(r1)     // Catch:{ all -> 0x009c }
        L_0x0081:
            monitor-exit(r0)     // Catch:{ all -> 0x009c }
            if (r2 == 0) goto L_0x009b
            r13 = 10
            if (r14 != r13) goto L_0x008f
            java.lang.String r13 = "Recorder"
            java.lang.String r14 = "Recording was stopped due to recording being garbage collected before any valid data has been produced."
            androidx.camera.core.Logger.e(r13, r14)
        L_0x008f:
            r13 = 8
            java.lang.RuntimeException r14 = new java.lang.RuntimeException
            java.lang.String r0 = "Recording was stopped before any data could be produced."
            r14.<init>(r0, r15)
            r12.w(r2, r13, r14)
        L_0x009b:
            return
        L_0x009c:
            r13 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x009c }
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.camera.video.Recorder.z0(androidx.camera.video.z0, int, java.lang.Throwable):void");
    }
}
