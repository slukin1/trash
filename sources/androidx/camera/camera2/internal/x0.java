package androidx.camera.camera2.internal;

import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import androidx.camera.camera2.impl.Camera2ImplConfig;
import androidx.camera.camera2.internal.u;
import androidx.camera.core.ImageCaptureException;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Logger;
import androidx.camera.core.impl.CameraCaptureCallback;
import androidx.camera.core.impl.CameraCaptureFailure;
import androidx.camera.core.impl.CameraCaptureMetaData;
import androidx.camera.core.impl.CameraCaptureResult;
import androidx.camera.core.impl.CameraCaptureResults;
import androidx.camera.core.impl.CaptureConfig;
import androidx.camera.core.impl.Quirks;
import androidx.camera.core.impl.utils.executor.CameraXExecutors;
import androidx.camera.core.impl.utils.futures.FutureChain;
import androidx.camera.core.impl.utils.futures.Futures;
import androidx.concurrent.futures.CallbackToFutureAdapter;
import com.google.common.util.concurrent.ListenableFuture;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import o.y;
import r.j;
import r.l;

public class x0 {

    /* renamed from: h  reason: collision with root package name */
    public static final Set<CameraCaptureMetaData.AfState> f5404h = Collections.unmodifiableSet(EnumSet.of(CameraCaptureMetaData.AfState.PASSIVE_FOCUSED, CameraCaptureMetaData.AfState.PASSIVE_NOT_FOCUSED, CameraCaptureMetaData.AfState.LOCKED_FOCUSED, CameraCaptureMetaData.AfState.LOCKED_NOT_FOCUSED));

    /* renamed from: i  reason: collision with root package name */
    public static final Set<CameraCaptureMetaData.AwbState> f5405i = Collections.unmodifiableSet(EnumSet.of(CameraCaptureMetaData.AwbState.CONVERGED, CameraCaptureMetaData.AwbState.UNKNOWN));

    /* renamed from: j  reason: collision with root package name */
    public static final Set<CameraCaptureMetaData.AeState> f5406j;

    /* renamed from: k  reason: collision with root package name */
    public static final Set<CameraCaptureMetaData.AeState> f5407k;

    /* renamed from: a  reason: collision with root package name */
    public final u f5408a;

    /* renamed from: b  reason: collision with root package name */
    public final l f5409b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f5410c;

    /* renamed from: d  reason: collision with root package name */
    public final Quirks f5411d;

    /* renamed from: e  reason: collision with root package name */
    public final Executor f5412e;

    /* renamed from: f  reason: collision with root package name */
    public final boolean f5413f;

    /* renamed from: g  reason: collision with root package name */
    public int f5414g = 1;

    public static class a implements d {

        /* renamed from: a  reason: collision with root package name */
        public final u f5415a;

        /* renamed from: b  reason: collision with root package name */
        public final j f5416b;

        /* renamed from: c  reason: collision with root package name */
        public final int f5417c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f5418d = false;

        public a(u uVar, int i11, j jVar) {
            this.f5415a = uVar;
            this.f5417c = i11;
            this.f5416b = jVar;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object f(CallbackToFutureAdapter.a aVar) throws Exception {
            this.f5415a.q().W(aVar);
            this.f5416b.b();
            return "AePreCapture";
        }

        public ListenableFuture<Boolean> a(TotalCaptureResult totalCaptureResult) {
            if (!x0.b(this.f5417c, totalCaptureResult)) {
                return Futures.immediateFuture(Boolean.FALSE);
            }
            Logger.d("Camera2CapturePipeline", "Trigger AE");
            this.f5418d = true;
            return FutureChain.from(CallbackToFutureAdapter.a(new w0(this))).transform(v0.f5370a, CameraXExecutors.directExecutor());
        }

        public boolean b() {
            return this.f5417c == 0;
        }

        public void c() {
            if (this.f5418d) {
                Logger.d("Camera2CapturePipeline", "cancel TriggerAePreCapture");
                this.f5415a.q().l(false, true);
                this.f5416b.a();
            }
        }
    }

    public static class b implements d {

        /* renamed from: a  reason: collision with root package name */
        public final u f5419a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f5420b = false;

        public b(u uVar) {
            this.f5419a = uVar;
        }

        public ListenableFuture<Boolean> a(TotalCaptureResult totalCaptureResult) {
            Integer num;
            ListenableFuture<Boolean> immediateFuture = Futures.immediateFuture(Boolean.TRUE);
            if (totalCaptureResult == null || (num = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_MODE)) == null) {
                return immediateFuture;
            }
            int intValue = num.intValue();
            if (intValue == 1 || intValue == 2) {
                Logger.d("Camera2CapturePipeline", "TriggerAf? AF mode auto");
                Integer num2 = (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AF_STATE);
                if (num2 != null && num2.intValue() == 0) {
                    Logger.d("Camera2CapturePipeline", "Trigger AF");
                    this.f5420b = true;
                    this.f5419a.q().X((CallbackToFutureAdapter.a<CameraCaptureResult>) null, false);
                }
            }
            return immediateFuture;
        }

        public boolean b() {
            return true;
        }

        public void c() {
            if (this.f5420b) {
                Logger.d("Camera2CapturePipeline", "cancel TriggerAF");
                this.f5419a.q().l(true, false);
            }
        }
    }

    public static class c {

        /* renamed from: i  reason: collision with root package name */
        public static final long f5421i;

        /* renamed from: j  reason: collision with root package name */
        public static final long f5422j;

        /* renamed from: a  reason: collision with root package name */
        public final int f5423a;

        /* renamed from: b  reason: collision with root package name */
        public final Executor f5424b;

        /* renamed from: c  reason: collision with root package name */
        public final u f5425c;

        /* renamed from: d  reason: collision with root package name */
        public final j f5426d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f5427e;

        /* renamed from: f  reason: collision with root package name */
        public long f5428f = f5421i;

        /* renamed from: g  reason: collision with root package name */
        public final List<d> f5429g = new ArrayList();

        /* renamed from: h  reason: collision with root package name */
        public final d f5430h = new a();

        public class a implements d {
            public a() {
            }

            public ListenableFuture<Boolean> a(TotalCaptureResult totalCaptureResult) {
                ArrayList arrayList = new ArrayList();
                for (d a11 : c.this.f5429g) {
                    arrayList.add(a11.a(totalCaptureResult));
                }
                return Futures.transform(Futures.allAsList(arrayList), e1.f5084a, CameraXExecutors.directExecutor());
            }

            public boolean b() {
                for (d b11 : c.this.f5429g) {
                    if (b11.b()) {
                        return true;
                    }
                }
                return false;
            }

            public void c() {
                for (d c11 : c.this.f5429g) {
                    c11.c();
                }
            }
        }

        public class b extends CameraCaptureCallback {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ CallbackToFutureAdapter.a f5432a;

            public b(CallbackToFutureAdapter.a aVar) {
                this.f5432a = aVar;
            }

            public void onCaptureCancelled() {
                this.f5432a.f(new ImageCaptureException(3, "Capture request is cancelled because camera is closed", (Throwable) null));
            }

            public void onCaptureCompleted(CameraCaptureResult cameraCaptureResult) {
                this.f5432a.c(null);
            }

            public void onCaptureFailed(CameraCaptureFailure cameraCaptureFailure) {
                this.f5432a.f(new ImageCaptureException(2, "Capture request failed with reason " + cameraCaptureFailure.getReason(), (Throwable) null));
            }
        }

        static {
            TimeUnit timeUnit = TimeUnit.SECONDS;
            f5421i = timeUnit.toNanos(1);
            f5422j = timeUnit.toNanos(5);
        }

        public c(int i11, Executor executor, u uVar, boolean z11, j jVar) {
            this.f5423a = i11;
            this.f5424b = executor;
            this.f5425c = uVar;
            this.f5427e = z11;
            this.f5426d = jVar;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ ListenableFuture j(int i11, TotalCaptureResult totalCaptureResult) throws Exception {
            if (x0.b(i11, totalCaptureResult)) {
                o(f5422j);
            }
            return this.f5430h.a(totalCaptureResult);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ ListenableFuture l(Boolean bool) throws Exception {
            if (Boolean.TRUE.equals(bool)) {
                return x0.f(this.f5428f, this.f5425c, y0.f5474a);
            }
            return Futures.immediateFuture(null);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ ListenableFuture m(List list, int i11, TotalCaptureResult totalCaptureResult) throws Exception {
            return p(list, i11);
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object n(CaptureConfig.Builder builder, CallbackToFutureAdapter.a aVar) throws Exception {
            builder.addCameraCaptureCallback(new b(aVar));
            return "submitStillCapture";
        }

        public void f(d dVar) {
            this.f5429g.add(dVar);
        }

        public final void g(CaptureConfig.Builder builder) {
            Camera2ImplConfig.Builder builder2 = new Camera2ImplConfig.Builder();
            builder2.c(CaptureRequest.CONTROL_AE_MODE, 3);
            builder.addImplementationOptions(builder2.build());
        }

        public final void h(CaptureConfig.Builder builder, CaptureConfig captureConfig) {
            int i11;
            if (this.f5423a != 3 || this.f5427e) {
                i11 = (captureConfig.getTemplateType() == -1 || captureConfig.getTemplateType() == 5) ? 2 : -1;
            } else {
                i11 = 4;
            }
            if (i11 != -1) {
                builder.setTemplateType(i11);
            }
        }

        public ListenableFuture<List<Void>> i(List<CaptureConfig> list, int i11) {
            ListenableFuture listenableFuture;
            ListenableFuture immediateFuture = Futures.immediateFuture(null);
            if (!this.f5429g.isEmpty()) {
                if (this.f5430h.b()) {
                    listenableFuture = x0.f(0, this.f5425c, (e.a) null);
                } else {
                    listenableFuture = Futures.immediateFuture(null);
                }
                immediateFuture = FutureChain.from(listenableFuture).transformAsync(new a1(this, i11), this.f5424b).transformAsync(new z0(this), this.f5424b);
            }
            FutureChain transformAsync = FutureChain.from(immediateFuture).transformAsync(new b1(this, list, i11), this.f5424b);
            d dVar = this.f5430h;
            Objects.requireNonNull(dVar);
            transformAsync.addListener(new d1(dVar), this.f5424b);
            return transformAsync;
        }

        public final void o(long j11) {
            this.f5428f = j11;
        }

        public ListenableFuture<List<Void>> p(List<CaptureConfig> list, int i11) {
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (CaptureConfig next : list) {
                CaptureConfig.Builder from = CaptureConfig.Builder.from(next);
                CameraCaptureResult cameraCaptureResult = null;
                if (next.getTemplateType() == 5 && !this.f5425c.B().e() && !this.f5425c.B().a()) {
                    ImageProxy c11 = this.f5425c.B().c();
                    if (c11 != null && this.f5425c.B().d(c11)) {
                        cameraCaptureResult = CameraCaptureResults.retrieveCameraCaptureResult(c11.getImageInfo());
                    }
                }
                if (cameraCaptureResult != null) {
                    from.setCameraCaptureResult(cameraCaptureResult);
                } else {
                    h(from, next);
                }
                if (this.f5426d.c(i11)) {
                    g(from);
                }
                arrayList.add(CallbackToFutureAdapter.a(new c1(this, from)));
                arrayList2.add(from.build());
            }
            this.f5425c.X(arrayList2);
            return Futures.allAsList(arrayList);
        }
    }

    public interface d {
        ListenableFuture<Boolean> a(TotalCaptureResult totalCaptureResult);

        boolean b();

        void c();
    }

    public static class e implements u.c {

        /* renamed from: a  reason: collision with root package name */
        public CallbackToFutureAdapter.a<TotalCaptureResult> f5434a;

        /* renamed from: b  reason: collision with root package name */
        public final ListenableFuture<TotalCaptureResult> f5435b = CallbackToFutureAdapter.a(new f1(this));

        /* renamed from: c  reason: collision with root package name */
        public final long f5436c;

        /* renamed from: d  reason: collision with root package name */
        public final a f5437d;

        /* renamed from: e  reason: collision with root package name */
        public volatile Long f5438e = null;

        public interface a {
            boolean a(TotalCaptureResult totalCaptureResult);
        }

        public e(long j11, a aVar) {
            this.f5436c = j11;
            this.f5437d = aVar;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object d(CallbackToFutureAdapter.a aVar) throws Exception {
            this.f5434a = aVar;
            return "waitFor3AResult";
        }

        public boolean a(TotalCaptureResult totalCaptureResult) {
            Long l11 = (Long) totalCaptureResult.get(CaptureResult.SENSOR_TIMESTAMP);
            if (l11 != null && this.f5438e == null) {
                this.f5438e = l11;
            }
            Long l12 = this.f5438e;
            if (0 == this.f5436c || l12 == null || l11 == null || l11.longValue() - l12.longValue() <= this.f5436c) {
                a aVar = this.f5437d;
                if (aVar != null && !aVar.a(totalCaptureResult)) {
                    return false;
                }
                this.f5434a.c(totalCaptureResult);
                return true;
            }
            this.f5434a.c(null);
            Logger.d("Camera2CapturePipeline", "Wait for capture result timeout, current:" + l11 + " first: " + l12);
            return true;
        }

        public ListenableFuture<TotalCaptureResult> c() {
            return this.f5435b;
        }
    }

    public static class f implements d {

        /* renamed from: e  reason: collision with root package name */
        public static final long f5439e = TimeUnit.SECONDS.toNanos(2);

        /* renamed from: a  reason: collision with root package name */
        public final u f5440a;

        /* renamed from: b  reason: collision with root package name */
        public final int f5441b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f5442c = false;

        /* renamed from: d  reason: collision with root package name */
        public final Executor f5443d;

        public f(u uVar, int i11, Executor executor) {
            this.f5440a = uVar;
            this.f5441b = i11;
            this.f5443d = executor;
        }

        /* access modifiers changed from: private */
        public /* synthetic */ Object h(CallbackToFutureAdapter.a aVar) throws Exception {
            this.f5440a.y().g(aVar, true);
            return "TorchOn";
        }

        /* access modifiers changed from: private */
        public /* synthetic */ ListenableFuture j(Void voidR) throws Exception {
            return x0.f(f5439e, this.f5440a, h1.f5137a);
        }

        public ListenableFuture<Boolean> a(TotalCaptureResult totalCaptureResult) {
            if (x0.b(this.f5441b, totalCaptureResult)) {
                if (this.f5440a.G()) {
                    Logger.d("Camera2CapturePipeline", "Torch already on, not turn on");
                } else {
                    Logger.d("Camera2CapturePipeline", "Turn on torch");
                    this.f5442c = true;
                    return FutureChain.from(CallbackToFutureAdapter.a(new j1(this))).transformAsync(new i1(this), this.f5443d).transform(g1.f5118a, CameraXExecutors.directExecutor());
                }
            }
            return Futures.immediateFuture(Boolean.FALSE);
        }

        public boolean b() {
            return this.f5441b == 0;
        }

        public void c() {
            if (this.f5442c) {
                this.f5440a.y().g((CallbackToFutureAdapter.a<Void>) null, false);
                Logger.d("Camera2CapturePipeline", "Turn off torch");
            }
        }
    }

    static {
        CameraCaptureMetaData.AeState aeState = CameraCaptureMetaData.AeState.CONVERGED;
        CameraCaptureMetaData.AeState aeState2 = CameraCaptureMetaData.AeState.FLASH_REQUIRED;
        CameraCaptureMetaData.AeState aeState3 = CameraCaptureMetaData.AeState.UNKNOWN;
        Set<CameraCaptureMetaData.AeState> unmodifiableSet = Collections.unmodifiableSet(EnumSet.of(aeState, aeState2, aeState3));
        f5406j = unmodifiableSet;
        EnumSet<CameraCaptureMetaData.AeState> copyOf = EnumSet.copyOf(unmodifiableSet);
        copyOf.remove(aeState2);
        copyOf.remove(aeState3);
        f5407k = Collections.unmodifiableSet(copyOf);
    }

    public x0(u uVar, y yVar, Quirks quirks, Executor executor) {
        boolean z11 = true;
        this.f5408a = uVar;
        Integer num = (Integer) yVar.a(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL);
        this.f5413f = (num == null || num.intValue() != 2) ? false : z11;
        this.f5412e = executor;
        this.f5411d = quirks;
        this.f5409b = new l(quirks);
        this.f5410c = r.e.a(new q0(yVar));
    }

    public static boolean a(TotalCaptureResult totalCaptureResult, boolean z11) {
        if (totalCaptureResult == null) {
            return false;
        }
        f fVar = new f(totalCaptureResult);
        boolean z12 = fVar.getAfMode() == CameraCaptureMetaData.AfMode.OFF || fVar.getAfMode() == CameraCaptureMetaData.AfMode.UNKNOWN || f5404h.contains(fVar.getAfState());
        boolean z13 = ((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_MODE)).intValue() == 0;
        boolean z14 = !z11 ? z13 || f5406j.contains(fVar.getAeState()) : z13 || f5407k.contains(fVar.getAeState());
        boolean z15 = (((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AWB_MODE)).intValue() == 0) || f5405i.contains(fVar.getAwbState());
        Logger.d("Camera2CapturePipeline", "checkCaptureResult, AE=" + fVar.getAeState() + " AF =" + fVar.getAfState() + " AWB=" + fVar.getAwbState());
        if (!z12 || !z14 || !z15) {
            return false;
        }
        return true;
    }

    public static boolean b(int i11, TotalCaptureResult totalCaptureResult) {
        if (i11 == 0) {
            Integer num = totalCaptureResult != null ? (Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_STATE) : null;
            if (num == null || num.intValue() != 4) {
                return false;
            }
            return true;
        } else if (i11 == 1) {
            return true;
        } else {
            if (i11 == 2) {
                return false;
            }
            throw new AssertionError(i11);
        }
    }

    public static ListenableFuture<TotalCaptureResult> f(long j11, u uVar, e.a aVar) {
        e eVar = new e(j11, aVar);
        uVar.k(eVar);
        return eVar.c();
    }

    public final boolean c(int i11) {
        return this.f5409b.a() || this.f5414g == 3 || i11 == 1;
    }

    public void d(int i11) {
        this.f5414g = i11;
    }

    public ListenableFuture<List<Void>> e(List<CaptureConfig> list, int i11, int i12, int i13) {
        j jVar = new j(this.f5411d);
        c cVar = new c(this.f5414g, this.f5412e, this.f5408a, this.f5413f, jVar);
        if (i11 == 0) {
            cVar.f(new b(this.f5408a));
        }
        if (this.f5410c) {
            if (c(i13)) {
                cVar.f(new f(this.f5408a, i12, this.f5412e));
            } else {
                cVar.f(new a(this.f5408a, i12, jVar));
            }
        }
        return Futures.nonCancellationPropagating(cVar.i(list, i12));
    }
}
