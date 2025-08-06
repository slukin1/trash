package com.jumio.core.extraction;

import android.content.Context;
import android.graphics.Rect;
import com.jumio.analytics.MetaInfo;
import com.jumio.commons.camera.CameraManagerInterface;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.Frame;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.camera.Size;
import com.jumio.commons.log.Log;
import com.jumio.core.environment.Environment;
import com.jumio.core.extraction.ExtractionUpdateInterface;
import com.jumio.core.model.PublisherWithUpdate;
import com.jumio.core.model.StaticModel;
import com.jumio.core.performance.FrameRateObserver;
import com.jumio.core.performance.FrameRateUtils;
import com.jumio.core.performance.JDisplayListener;
import com.jumio.core.persistence.DataManager;
import com.jumio.jvision.jvcorejava.swig.ImageSource;
import com.jumio.sdk.enums.JumioFallbackReason;
import com.tencent.android.tpush.common.MessageKey;
import d10.p;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;
import jumio.core.h1;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import kotlin.k;
import kotlin.l;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.g;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.r1;
import kotlinx.coroutines.sync.SemaphoreKt;
import kotlinx.coroutines.v0;

public abstract class ExtractionClient extends PublisherWithUpdate<ExtractionUpdateInterface<?>, StaticModel> implements JDisplayListener {

    /* renamed from: c  reason: collision with root package name */
    public Context f39146c;

    /* renamed from: d  reason: collision with root package name */
    public final AtomicBoolean f39147d = new AtomicBoolean(false);

    /* renamed from: e  reason: collision with root package name */
    public final AtomicBoolean f39148e = new AtomicBoolean(false);

    /* renamed from: f  reason: collision with root package name */
    public FrameRateObserver f39149f = new FrameRateObserver(1000000000, this, FrameRateObserver.THREAD.MAIN);

    /* renamed from: g  reason: collision with root package name */
    public ImageSource f39150g;

    /* renamed from: h  reason: collision with root package name */
    public Frame.MetaData f39151h = new Frame.MetaData((Size) null, 0, 0, 0, 0, false, 0, 0, 255, (r) null);

    /* renamed from: i  reason: collision with root package name */
    public final kotlinx.coroutines.sync.b f39152i = SemaphoreKt.a(1, 1);

    /* renamed from: j  reason: collision with root package name */
    public n1 f39153j;

    /* renamed from: k  reason: collision with root package name */
    public final SubExtractionProxy f39154k = new SubExtractionProxy();

    /* renamed from: l  reason: collision with root package name */
    public boolean f39155l;

    /* renamed from: m  reason: collision with root package name */
    public final CoroutineDispatcher f39156m = v0.a();

    /* renamed from: n  reason: collision with root package name */
    public boolean f39157n;

    /* renamed from: o  reason: collision with root package name */
    public boolean f39158o;

    /* renamed from: p  reason: collision with root package name */
    public DataManager f39159p;

    /* renamed from: q  reason: collision with root package name */
    public boolean f39160q;

    /* renamed from: r  reason: collision with root package name */
    public PreviewProperties f39161r = new PreviewProperties();

    /* renamed from: s  reason: collision with root package name */
    public Rect f39162s = new Rect(0, 0, 0, 0);

    /* renamed from: t  reason: collision with root package name */
    public boolean f39163t;

    public static final class FramePerformance {

        /* renamed from: a  reason: collision with root package name */
        public final double f39164a;

        /* renamed from: b  reason: collision with root package name */
        public final long f39165b;

        /* renamed from: c  reason: collision with root package name */
        public final long f39166c;

        public FramePerformance() {
            this(0.0d, 0, 0, 7, (r) null);
        }

        public FramePerformance(double d11, long j11, long j12) {
            this.f39164a = d11;
            this.f39165b = j11;
            this.f39166c = j12;
        }

        public static /* synthetic */ FramePerformance copy$default(FramePerformance framePerformance, double d11, long j11, long j12, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                d11 = framePerformance.f39164a;
            }
            double d12 = d11;
            if ((i11 & 2) != 0) {
                j11 = framePerformance.f39165b;
            }
            long j13 = j11;
            if ((i11 & 4) != 0) {
                j12 = framePerformance.f39166c;
            }
            return framePerformance.copy(d12, j13, j12);
        }

        public final double component1() {
            return this.f39164a;
        }

        public final long component2() {
            return this.f39165b;
        }

        public final long component3() {
            return this.f39166c;
        }

        public final FramePerformance copy(double d11, long j11, long j12) {
            return new FramePerformance(d11, j11, j12);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof FramePerformance)) {
                return false;
            }
            FramePerformance framePerformance = (FramePerformance) obj;
            return Double.compare(this.f39164a, framePerformance.f39164a) == 0 && this.f39165b == framePerformance.f39165b && this.f39166c == framePerformance.f39166c;
        }

        public final Map<String, Object> getAsMap() {
            return MapsKt__MapsKt.l(l.a("mean", Double.valueOf(this.f39164a)), l.a(MessageKey.MSG_ACCEPT_TIME_MIN, Long.valueOf(this.f39165b)), l.a("max", Long.valueOf(this.f39166c)));
        }

        public final long getMax() {
            return this.f39166c;
        }

        public final double getMean() {
            return this.f39164a;
        }

        public final long getMin() {
            return this.f39165b;
        }

        public int hashCode() {
            int a11 = com.fluttercandies.photo_manager.core.entity.a.a(this.f39165b);
            return com.fluttercandies.photo_manager.core.entity.a.a(this.f39166c) + ((a11 + (Double.doubleToLongBits(this.f39164a) * 31)) * 31);
        }

        public String toString() {
            double d11 = this.f39164a;
            long j11 = this.f39165b;
            long j12 = this.f39166c;
            return "FramePerformance(mean=" + d11 + ", min=" + j11 + ", max=" + j12 + ")";
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ FramePerformance(double d11, long j11, long j12, int i11, r rVar) {
            this((i11 & 1) != 0 ? 0.0d : d11, (i11 & 2) != 0 ? 0 : j11, (i11 & 4) != 0 ? 0 : j12);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.jumio.core.extraction.ExtractionClient$reinit$1", f = "ExtractionClient.kt", l = {144}, m = "invokeSuspend")
    public static final class a extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f39167a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f39168b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ ExtractionClient f39169c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ExtractionClient extractionClient, kotlin.coroutines.c<? super a> cVar) {
            super(2, cVar);
            this.f39169c = extractionClient;
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            a aVar = new a(this.f39169c, cVar);
            aVar.f39168b = obj;
            return aVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create((h0) obj, (kotlin.coroutines.c) obj2)).invokeSuspend(Unit.f56620a);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.h0} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r4) {
            /*
                r3 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r3.f39167a
                r2 = 1
                if (r1 == 0) goto L_0x001b
                if (r1 != r2) goto L_0x0013
                java.lang.Object r1 = r3.f39168b
                kotlinx.coroutines.h0 r1 = (kotlinx.coroutines.h0) r1
                kotlin.k.b(r4)
                goto L_0x0023
            L_0x0013:
                java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r4.<init>(r0)
                throw r4
            L_0x001b:
                kotlin.k.b(r4)
                java.lang.Object r4 = r3.f39168b
                r1 = r4
                kotlinx.coroutines.h0 r1 = (kotlinx.coroutines.h0) r1
            L_0x0023:
                boolean r4 = kotlinx.coroutines.i0.i(r1)
                if (r4 == 0) goto L_0x0036
                com.jumio.core.extraction.ExtractionClient r4 = r3.f39169c
                r3.f39168b = r1
                r3.f39167a = r2
                java.lang.Object r4 = com.jumio.core.extraction.ExtractionClient.access$extract(r4, r3)
                if (r4 != r0) goto L_0x0023
                return r0
            L_0x0036:
                kotlin.Unit r4 = kotlin.Unit.f56620a
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.extraction.ExtractionClient.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.jumio.core.extraction.ExtractionClient$reinit$2", f = "ExtractionClient.kt", l = {152}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f39170a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ExtractionClient f39171b;

        @kotlin.coroutines.jvm.internal.d(c = "com.jumio.core.extraction.ExtractionClient$reinit$2$1", f = "ExtractionClient.kt", l = {}, m = "invokeSuspend")
        public static final class a extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

            /* renamed from: a  reason: collision with root package name */
            public final /* synthetic */ ExtractionClient f39172a;

            /* JADX INFO: super call moved to the top of the method (can break code semantics) */
            public a(ExtractionClient extractionClient, kotlin.coroutines.c<? super a> cVar) {
                super(2, cVar);
                this.f39172a = extractionClient;
            }

            public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
                return new a(this.f39172a, cVar);
            }

            public final Object invoke(Object obj, Object obj2) {
                return ((a) create((h0) obj, (kotlin.coroutines.c) obj2)).invokeSuspend(Unit.f56620a);
            }

            public final Object invokeSuspend(Object obj) {
                Object unused = IntrinsicsKt__IntrinsicsKt.d();
                k.b(obj);
                this.f39172a.init();
                return Unit.f56620a;
            }
        }

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(ExtractionClient extractionClient, kotlin.coroutines.c<? super b> cVar) {
            super(2, cVar);
            this.f39171b = extractionClient;
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new b(this.f39171b, cVar);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((b) create((h0) obj, (kotlin.coroutines.c) obj2)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f39170a;
            if (i11 == 0) {
                k.b(obj);
                CoroutineDispatcher backgroundDispatcher = this.f39171b.getBackgroundDispatcher();
                a aVar = new a(this.f39171b, (kotlin.coroutines.c<? super a>) null);
                this.f39170a = 1;
                if (g.g(backgroundDispatcher, aVar, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.jumio.core.extraction.ExtractionClient$runOnMain$1", f = "ExtractionClient.kt", l = {}, m = "invokeSuspend")
    public static final class c extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a<Unit> f39173a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(d10.a<Unit> aVar, kotlin.coroutines.c<? super c> cVar) {
            super(2, cVar);
            this.f39173a = aVar;
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new c(this.f39173a, cVar);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((c) create((h0) obj, (kotlin.coroutines.c) obj2)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            k.b(obj);
            this.f39173a.invoke();
            return Unit.f56620a;
        }
    }

    public static final class d extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ExtractionClient f39174a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JumioFallbackReason f39175b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ExtractionClient extractionClient, JumioFallbackReason jumioFallbackReason) {
            super(0);
            this.f39174a = extractionClient;
            this.f39175b = jumioFallbackReason;
        }

        public final Object invoke() {
            this.f39174a.publishUpdate((ExtractionUpdateInterface<?>) ExtractionUpdateInterface.Companion.build$default(ExtractionUpdateInterface.Companion, ExtractionUpdateState.fallbackRequired, this.f39175b, (MetaInfo) null, 4, (Object) null));
            return Unit.f56620a;
        }
    }

    public ExtractionClient(Context context) {
        this.f39146c = context;
        boolean z11 = false;
        Environment environment = Environment.INSTANCE;
        if (environment.loadJniJvCoreLib(this.f39146c) && environment.loadJniImageQualityLib(this.f39146c)) {
            z11 = true;
        }
        this.f39160q = z11;
        this.f39150g = new ImageSource();
    }

    public static final Object access$extract(ExtractionClient extractionClient, kotlin.coroutines.c cVar) {
        Object g11 = g.g(extractionClient.f39156m, new h1(extractionClient, (kotlin.coroutines.c<? super h1>) null), cVar);
        return g11 == IntrinsicsKt__IntrinsicsKt.d() ? g11 : Unit.f56620a;
    }

    public final void a(boolean z11) {
        if (z11 != this.f39155l) {
            if (z11) {
                Log.d("ExtractionClient", "Starting frame rate observation");
                this.f39149f.start();
            } else {
                Log.d("ExtractionClient", "Stopping frame rate observation");
                this.f39149f.stop();
            }
            this.f39155l = z11;
        }
    }

    public final void addSubExtraction(ExtractionClient extractionClient, p<? super StaticModel, ? super StaticModel, ? extends StaticModel> pVar) {
        this.f39154k.add(extractionClient, pVar);
    }

    public void cancel() {
        setDataExtraction(false);
        this.f39154k.cancel();
    }

    public final void cleanImages(ImageSource... imageSourceArr) {
        for (ImageSource imageSource : imageSourceArr) {
            if (imageSource != null) {
                imageSource.delete();
            }
        }
    }

    public void configure(DataManager dataManager, StaticModel staticModel) {
        this.f39159p = dataManager;
        this.f39154k.configure(dataManager, staticModel);
        this.f39160q = this.f39160q && this.f39154k.getAreConfigured();
    }

    public void destroy() {
        cancel();
        n1 n1Var = this.f39153j;
        if (n1Var != null) {
            n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
        }
        this.f39153j = null;
        r1.f(getMainScope().getCoroutineContext(), (CancellationException) null, 1, (Object) null);
        this.f39154k.destroy();
    }

    public final synchronized void feed(Frame frame) {
        if (!this.f39161r.isEmpty() && !this.f39162s.isEmpty() && getDataExtraction() && shouldFeed() && this.f39147d.compareAndSet(false, true)) {
            synchronized (this.f39152i) {
                int width = frame.getMetaData().getSize().getWidth();
                this.f39150g = ImageSource.CreateFromUncompressedByteArray(frame.getByteArray(), width, frame.getMetaData().getSize().getHeight(), CameraManagerInterface.f38958a.getJVisionImageFormat(), width);
                this.f39151h = frame.getMetaData();
                Unit unit = Unit.f56620a;
            }
            this.f39152i.release();
        }
        this.f39154k.feed(frame);
    }

    public final CoroutineDispatcher getBackgroundDispatcher() {
        return this.f39156m;
    }

    public final boolean getCenterCropExtractionArea() {
        return this.f39158o;
    }

    public final Context getContext() {
        return this.f39146c;
    }

    public final boolean getDataExtraction() {
        return this.f39148e.get();
    }

    public final DataManager getDataManager() {
        return this.f39159p;
    }

    public final Rect getExtractionArea() {
        return this.f39162s;
    }

    public FramePerformance getFramePerformance() {
        return null;
    }

    public Size getPreferredPreviewSize() {
        return null;
    }

    public final PreviewProperties getPreviewProperties() {
        return this.f39161r;
    }

    public final boolean getShouldInitAsync() {
        return this.f39157n;
    }

    public void init() {
    }

    public final boolean isConfigured() {
        return this.f39160q;
    }

    public final boolean isSubExtraction() {
        return this.f39163t;
    }

    public void onFramesSampled(List<Long> list) {
        if (this.f39155l) {
            FrameRateUtils frameRateUtils = FrameRateUtils.INSTANCE;
            long frameRateFromSample = frameRateUtils.getFrameRateFromSample(list, 1000000000);
            long frameRate = frameRateUtils.getFrameRate(this.f39146c);
            if (frameRateUtils.checkThresholdForFrameRate(frameRate, frameRateFromSample, 0.8f)) {
                Log.d("ExtractionClient", "Frame Rate is " + frameRate + "/" + frameRateFromSample);
                return;
            }
            Log.w("ExtractionClient", "Frame Rate is " + frameRate + "/" + frameRateFromSample + ", falling back to other extraction method");
            triggerFallback(JumioFallbackReason.LOW_PERFORMANCE);
            a(false);
        }
    }

    public abstract void process(ImageSource imageSource, PreviewProperties previewProperties, Frame.MetaData metaData, Rect rect);

    public final void reinit() {
        if (this.f39160q && !this.f39162s.isEmpty() && !this.f39161r.isEmpty()) {
            n1 n1Var = this.f39153j;
            if (n1Var != null) {
                n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
            }
            this.f39153j = i.d(getMainScope(), (CoroutineContext) null, (CoroutineStart) null, new a(this, (kotlin.coroutines.c<? super a>) null), 3, (Object) null);
            if (!getDataExtraction() && !this.f39157n) {
                init();
            } else if (!getDataExtraction()) {
                n1 unused = i.d(getMainScope(), (CoroutineContext) null, (CoroutineStart) null, new b(this, (kotlin.coroutines.c<? super b>) null), 3, (Object) null);
            }
            this.f39147d.set(false);
            this.f39154k.reinit();
        }
    }

    public final void removeSubExtraction(ExtractionClient extractionClient) {
        this.f39154k.remove(extractionClient);
    }

    public final n1 runOnMain(d10.a<Unit> aVar) {
        return i.d(getMainScope(), (CoroutineContext) null, (CoroutineStart) null, new c(aVar, (kotlin.coroutines.c<? super c>) null), 3, (Object) null);
    }

    public final void setCenterCropExtractionArea(boolean z11) {
        this.f39158o = z11;
    }

    public final void setConfigured(boolean z11) {
        this.f39160q = z11;
    }

    public final void setContext(Context context) {
        this.f39146c = context;
    }

    public final void setDataExtraction(boolean z11) {
        this.f39148e.set(z11);
        this.f39154k.setDataExtraction(z11);
    }

    public final void setDataManager(DataManager dataManager) {
        this.f39159p = dataManager;
    }

    public final void setExtractionArea(Rect rect) {
        Rect rect2;
        if (this.f39158o) {
            rect2 = CameraUtils.determineCropRect$default(CameraUtils.INSTANCE, rect, 0.0f, 2, (Object) null);
        } else {
            rect2 = new Rect(rect);
        }
        this.f39162s = rect2;
        this.f39154k.setExtractionArea(rect2);
    }

    public final void setPreviewProperties(PreviewProperties previewProperties) {
        this.f39161r = previewProperties.copy();
        this.f39154k.setPreviewProperties(previewProperties);
    }

    public final void setResult(boolean z11) {
        this.f39147d.set(z11);
        if (z11 && this.f39155l) {
            a(false);
        }
    }

    public final void setShouldInitAsync(boolean z11) {
        this.f39157n = z11;
    }

    public final void setSubExtraction(boolean z11) {
        this.f39163t = z11;
    }

    public abstract boolean shouldFeed();

    public final void startFrameRateObservation(long j11, JDisplayListener jDisplayListener) {
        this.f39149f.stop();
        this.f39149f = new FrameRateObserver(j11, jDisplayListener, FrameRateObserver.THREAD.WORKER);
        a(true);
    }

    public void takePicture() {
    }

    public boolean takePictureManually() {
        return false;
    }

    public final n1 triggerFallback(JumioFallbackReason jumioFallbackReason) {
        return runOnMain(new d(this, jumioFallbackReason));
    }

    public void publishResult(StaticModel staticModel) {
        super.publishResult(this.f39154k.mergeResult(staticModel));
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0034  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0043  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void publishUpdate(com.jumio.core.extraction.ExtractionUpdateInterface<?> r6) {
        /*
            r5 = this;
            java.lang.Integer r0 = r6.getState()
            int r1 = com.jumio.core.extraction.ExtractionUpdateState.holdStill
            r2 = 1
            if (r0 != 0) goto L_0x000a
            goto L_0x0016
        L_0x000a:
            int r3 = r0.intValue()
            if (r3 != r1) goto L_0x0016
            com.jumio.core.extraction.SubExtractionProxy r0 = r5.f39154k
            r0.setActive(r2)
            goto L_0x0048
        L_0x0016:
            int r1 = com.jumio.core.extraction.ExtractionUpdateState.tooClose
            r3 = 0
            if (r0 != 0) goto L_0x001c
            goto L_0x0023
        L_0x001c:
            int r4 = r0.intValue()
            if (r4 != r1) goto L_0x0023
            goto L_0x002e
        L_0x0023:
            int r1 = com.jumio.core.extraction.ExtractionUpdateState.moveCloser
            if (r0 != 0) goto L_0x0028
            goto L_0x0030
        L_0x0028:
            int r4 = r0.intValue()
            if (r4 != r1) goto L_0x0030
        L_0x002e:
            r1 = r2
            goto L_0x0031
        L_0x0030:
            r1 = r3
        L_0x0031:
            if (r1 == 0) goto L_0x0034
            goto L_0x0041
        L_0x0034:
            int r1 = com.jumio.core.extraction.ExtractionUpdateState.centerId
            if (r0 != 0) goto L_0x0039
            goto L_0x0040
        L_0x0039:
            int r0 = r0.intValue()
            if (r0 != r1) goto L_0x0040
            goto L_0x0041
        L_0x0040:
            r2 = r3
        L_0x0041:
            if (r2 == 0) goto L_0x0048
            com.jumio.core.extraction.SubExtractionProxy r0 = r5.f39154k
            r0.setActive(r3)
        L_0x0048:
            super.publishUpdate(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.extraction.ExtractionClient.publishUpdate(com.jumio.core.extraction.ExtractionUpdateInterface):void");
    }
}
