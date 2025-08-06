package jumio.liveness;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.SystemClock;
import com.jumio.analytics.Analytics;
import com.jumio.analytics.MetaInfo;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.camera.CameraUtils;
import com.jumio.commons.camera.Frame;
import com.jumio.commons.camera.PreviewProperties;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.LogLevel;
import com.jumio.core.cdn.CDNFeatureModel;
import com.jumio.core.environment.Environment;
import com.jumio.core.extraction.ExtractionClient;
import com.jumio.core.extraction.ExtractionUpdateInterface;
import com.jumio.core.extraction.ExtractionUpdateState;
import com.jumio.core.extraction.liveness.extraction.LivenessUpdateState;
import com.jumio.core.interfaces.QAInterface;
import com.jumio.core.model.StaticModel;
import com.jumio.core.models.LivenessSettingsModel;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.performance.FrameRateUtils;
import com.jumio.core.persistence.DataManager;
import com.jumio.core.util.QAKt;
import com.jumio.jvision.jvcorejava.swig.ImageSource;
import com.jumio.liveness.DaClient;
import com.jumio.liveness.IEventHandler;
import com.jumio.sdk.enums.JumioFallbackReason;
import d10.p;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import jumio.liveness.r;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.TypeIntrinsics;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlin.l;
import kotlin.ranges.h;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;

public final class e extends ExtractionClient implements IEventHandler {

    /* renamed from: a  reason: collision with root package name */
    public d f56454a;

    /* renamed from: b  reason: collision with root package name */
    public o f56455b;

    /* renamed from: c  reason: collision with root package name */
    public final m f56456c = new m();

    /* renamed from: d  reason: collision with root package name */
    public CDNFeatureModel f56457d;

    /* renamed from: e  reason: collision with root package name */
    public LivenessSettingsModel f56458e = new LivenessSettingsModel(0, 0, 0, 0, false, 0, 0.0d, 0.0d, 0.0d, 0, 0, 0, 0, 0, 0, 0, 0, 0.0d, 0, 0.0d, 0, false, 0, 0, 0, 0, 67108863, (r) null);

    /* renamed from: f  reason: collision with root package name */
    public boolean f56459f;

    /* renamed from: g  reason: collision with root package name */
    public Rect f56460g = new Rect();

    /* renamed from: h  reason: collision with root package name */
    public int f56461h;

    /* renamed from: i  reason: collision with root package name */
    public final ArrayList f56462i = new ArrayList();

    /* renamed from: j  reason: collision with root package name */
    public boolean f56463j;

    /* renamed from: k  reason: collision with root package name */
    public final c f56464k = new c();

    /* renamed from: l  reason: collision with root package name */
    public final AtomicBoolean f56465l = new AtomicBoolean(false);

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f56466a;

        static {
            int[] iArr = new int[a.values().length];
            try {
                iArr[0] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[1] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            f56466a = iArr;
        }
    }

    public static final class c extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ e f56467a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(e eVar) {
            super(0);
            this.f56467a = eVar;
        }

        public final Object invoke() {
            int i11;
            e eVar = this.f56467a;
            d dVar = eVar.f56454a;
            if (dVar == null) {
                dVar = null;
            }
            a aVar = dVar.f56452h;
            if (aVar == null) {
                i11 = -1;
            } else {
                i11 = b.f56466a[aVar.ordinal()];
            }
            eVar.a((ExtractionUpdateInterface<?>) ExtractionUpdateInterface.Companion.build$default(ExtractionUpdateInterface.Companion, ExtractionUpdateState.resetOverlay, Float.valueOf(i11 == 1 ? 0.85f : 1.0f), (MetaInfo) null, 4, (Object) null), false);
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.jumio.liveness.LivenessExtractionClient$init$1", f = "LivenessExtractionClient.kt", l = {146}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f56468a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ e f56469b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(e eVar, kotlin.coroutines.c<? super d> cVar) {
            super(2, cVar);
            this.f56469b = eVar;
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new d(this.f56469b, cVar);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((d) create((h0) obj, (kotlin.coroutines.c) obj2)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f56468a;
            if (i11 == 0) {
                k.b(obj);
                this.f56468a = 1;
                if (DelayKt.b(500, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this.f56469b.f56459f = true;
            Log.i("LivenessExtractionClient", "Initial delay passed, starting to capture");
            return Unit.f56620a;
        }
    }

    public e(Context context) {
        super(context);
    }

    public static void e(k kVar, a aVar) {
        int i11 = aVar == null ? -1 : b.f56466a[aVar.ordinal()];
        if (i11 == 1 || i11 == 2) {
            Log.i("LivenessExtractionClient", "Finished capturing images for second distance (" + aVar + ")");
            j b11 = kVar.b();
            QAInterface qa2 = QAKt.getQA();
            ImageSource imageSource = b11.f56482b;
            qa2.getClass();
            return;
        }
        Log.w("LivenessExtractionClient", "Illegal state (" + aVar + ") when completing the first distance");
    }

    public final void a(ByteBuffer byteBuffer, String str, String str2, IEventHandler iEventHandler) {
        if (DaClient.hasStarted()) {
            runOnMain(g.f56471a);
        }
        if (DaClient.isInitialized()) {
            runOnMain(f.f56470a);
        }
        String f11 = Reflection.b(e.class).f();
        Log.i("LivenessExtractionClient", "Starting " + f11);
        runOnMain(new h(byteBuffer, str, str2, iEventHandler));
    }

    public final boolean b(k kVar, a aVar) {
        o oVar = this.f56455b;
        o oVar2 = null;
        if (oVar == null) {
            oVar = null;
        }
        t tVar = t.TRANSITION;
        if (oVar.c(tVar)) {
            return true;
        }
        int width = kVar.c().a().width();
        int transitionImages = this.f56458e.getTransitionImages();
        if (aVar == a.NEAR) {
            a((ExtractionUpdateInterface<?>) ExtractionUpdateInterface.Companion.build$default(ExtractionUpdateInterface.Companion, LivenessUpdateState.INSTANCE.getFaceTooClose(), (Object) null, (MetaInfo) null, 4, (Object) null), false);
        } else if (aVar == a.FAR) {
            a((ExtractionUpdateInterface<?>) ExtractionUpdateInterface.Companion.build$default(ExtractionUpdateInterface.Companion, LivenessUpdateState.INSTANCE.getMoveFaceCloser(), (Object) null, (MetaInfo) null, 4, (Object) null), false);
        }
        o oVar3 = this.f56455b;
        if (oVar3 == null) {
            oVar3 = null;
        }
        int a11 = oVar3.a() + 1;
        d dVar = this.f56454a;
        if (dVar == null) {
            dVar = null;
        }
        if (dVar.a(width, aVar, a11)) {
            Log.i("LivenessExtractionClient", "Capturing " + a11 + "/" + transitionImages + " transition image");
            o oVar4 = this.f56455b;
            if (oVar4 == null) {
                oVar4 = null;
            }
            if (oVar4.a(kVar, tVar)) {
                o oVar5 = this.f56455b;
                if (oVar5 != null) {
                    oVar2 = oVar5;
                }
                if (oVar2.c(tVar)) {
                    Log.i("LivenessExtractionClient", "Finished capturing transition images");
                }
            }
            j b11 = kVar.b();
            QAInterface qa2 = QAKt.getQA();
            ImageSource imageSource = b11.f56482b;
            qa2.getClass();
        } else {
            Log.d("LivenessExtractionClient", width + " is not at transitioning position");
            kVar.a();
        }
        return false;
    }

    public final void c(k kVar, a aVar) {
        int i11;
        t tVar;
        Log.d("LivenessExtractionClient", "Processing first distance image with currentDistance = " + aVar);
        if (aVar == null) {
            i11 = -1;
        } else {
            i11 = b.f56466a[aVar.ordinal()];
        }
        boolean z11 = true;
        o oVar = null;
        if (i11 == -1) {
            tVar = t.TRANSITION;
        } else if (i11 == 1) {
            tVar = t.NEAR;
        } else if (i11 != 2) {
            tVar = null;
        } else {
            tVar = t.FAR;
        }
        if (!(tVar == t.FAR || tVar == t.NEAR)) {
            z11 = false;
        }
        if (!z11) {
            tVar = null;
        }
        if (tVar == null) {
            o oVar2 = this.f56455b;
            if (oVar2 != null) {
                oVar = oVar2;
            }
            oVar.b();
            kVar.a();
            return;
        }
        a((ExtractionUpdateInterface<?>) ExtractionUpdateInterface.Companion.build$default(ExtractionUpdateInterface.Companion, ExtractionUpdateState.holdStill, (Object) null, (MetaInfo) null, 4, (Object) null), false);
        o oVar3 = this.f56455b;
        if (oVar3 == null) {
            oVar3 = null;
        }
        if (oVar3.a(kVar, tVar)) {
            o oVar4 = this.f56455b;
            if (oVar4 != null) {
                oVar = oVar4;
            }
            if (oVar.c(tVar)) {
                a(kVar, aVar);
            }
        }
    }

    public final void cancel() {
        super.cancel();
        String f11 = Reflection.b(e.class).f();
        Log.i("LivenessExtractionClient", "Cancelling " + f11);
        if (DaClient.hasStarted()) {
            runOnMain(g.f56471a);
        }
        if (this.f56462i.size() != 0) {
            Log log = Log.INSTANCE;
            LogLevel logLevel = LogLevel.VERBOSE;
        }
    }

    public final void configure(DataManager dataManager, StaticModel staticModel) {
        super.configure(dataManager, staticModel);
        try {
            setConfigured(isConfigured() && Environment.INSTANCE.loadDaClientLib(getContext()));
            if (staticModel instanceof ScanPartModel) {
                this.f56457d = (CDNFeatureModel) dataManager.get(CDNFeatureModel.class);
                this.f56458e = (LivenessSettingsModel) dataManager.get(LivenessSettingsModel.class);
                return;
            }
            throw new IllegalArgumentException("Configuration model should be an instance of ScanPartModel");
        } catch (Exception e11) {
            Log.printStackTrace(e11);
            setConfigured(false);
        }
    }

    public final void d(k kVar, a aVar) {
        int i11;
        t tVar;
        Log.d("LivenessExtractionClient", "Processing second distance image with currentDistance = " + aVar);
        if (aVar == null) {
            i11 = -1;
        } else {
            i11 = b.f56466a[aVar.ordinal()];
        }
        boolean z11 = true;
        o oVar = null;
        if (i11 == -1) {
            tVar = t.TRANSITION;
        } else if (i11 == 1) {
            tVar = t.NEAR;
        } else if (i11 != 2) {
            tVar = null;
        } else {
            tVar = t.FAR;
        }
        if (!(tVar == t.NEAR || tVar == t.FAR)) {
            z11 = false;
        }
        if (!z11) {
            tVar = null;
        }
        if (tVar == null) {
            o oVar2 = this.f56455b;
            if (oVar2 != null) {
                oVar = oVar2;
            }
            oVar.b();
            kVar.a();
            return;
        }
        d dVar = this.f56454a;
        if (dVar == null) {
            dVar = null;
        }
        a a11 = dVar.a();
        if (a11 == aVar) {
            a((ExtractionUpdateInterface<?>) ExtractionUpdateInterface.Companion.build$default(ExtractionUpdateInterface.Companion, ExtractionUpdateState.holdStill, (Object) null, (MetaInfo) null, 4, (Object) null), false);
            o oVar3 = this.f56455b;
            if (oVar3 == null) {
                oVar3 = null;
            }
            if (oVar3.a(kVar, tVar)) {
                o oVar4 = this.f56455b;
                if (oVar4 != null) {
                    oVar = oVar4;
                }
                if (oVar.c(tVar)) {
                    e(kVar, aVar);
                    return;
                }
                return;
            }
            return;
        }
        if (a11 == a.FAR) {
            a((ExtractionUpdateInterface<?>) ExtractionUpdateInterface.Companion.build$default(ExtractionUpdateInterface.Companion, LivenessUpdateState.INSTANCE.getFaceTooClose(), (Object) null, (MetaInfo) null, 4, (Object) null), false);
        } else {
            a((ExtractionUpdateInterface<?>) ExtractionUpdateInterface.Companion.build$default(ExtractionUpdateInterface.Companion, LivenessUpdateState.INSTANCE.getMoveFaceCloser(), (Object) null, (MetaInfo) null, 4, (Object) null), false);
        }
        o oVar5 = this.f56455b;
        if (oVar5 != null) {
            oVar = oVar5;
        }
        oVar.b();
        kVar.a();
    }

    public final void destroy() {
        super.destroy();
        String f11 = Reflection.b(e.class).f();
        Log.i("LivenessExtractionClient", "Destroying " + f11);
        o oVar = this.f56455b;
        if (oVar != null) {
            o.a(oVar);
        }
        this.f56456c.a();
        if (DaClient.hasStarted()) {
            runOnMain(g.f56471a);
        }
        if (DaClient.isInitialized()) {
            runOnMain(f.f56470a);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r16v0, resolved type: android.graphics.Rect} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v9, resolved type: android.graphics.Rect} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v11, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v12, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v13, resolved type: android.graphics.Rect} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v15, resolved type: android.graphics.Rect} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v16, resolved type: android.graphics.Rect} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v17, resolved type: android.graphics.Rect} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void init() {
        /*
            r25 = this;
            r1 = r25
            super.init()
            kotlinx.coroutines.h0 r2 = r25.getMainScope()
            jumio.liveness.e$d r5 = new jumio.liveness.e$d
            r8 = 0
            r5.<init>(r1, r8)
            r3 = 0
            r4 = 0
            r6 = 3
            r7 = 0
            kotlinx.coroutines.n1 unused = kotlinx.coroutines.i.d(r2, r3, r4, r5, r6, r7)
            java.lang.Class<jumio.liveness.e> r0 = jumio.liveness.e.class
            kotlin.reflect.c r0 = kotlin.jvm.internal.Reflection.b(r0)
            java.lang.String r0 = r0.f()
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Initialising "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            java.lang.String r2 = "LivenessExtractionClient"
            com.jumio.commons.log.Log.i((java.lang.String) r2, (java.lang.String) r0)
            com.jumio.core.cdn.CDNFeatureModel r0 = r1.f56457d
            java.lang.String r3 = "livenessAssetsNotAvailable"
            java.lang.String r4 = "Liveness is not available!"
            r5 = 2
            if (r0 == 0) goto L_0x016c
            java.lang.String r6 = "livenessAssets"
            boolean r7 = r0.has(r6)
            if (r7 != 0) goto L_0x0049
            goto L_0x016c
        L_0x0049:
            r25.a()
            com.jumio.commons.camera.PreviewProperties r7 = r25.getPreviewProperties()
            com.jumio.commons.camera.Size r7 = r7.getPreview()
            jumio.liveness.d r9 = new jumio.liveness.d
            com.jumio.core.models.LivenessSettingsModel r10 = r1.f56458e
            r9.<init>(r7, r10)
            r1.f56454a = r9
            com.jumio.core.models.LivenessSettingsModel r9 = r1.f56458e
            double r9 = r9.getMaxFaceCenterDifference()
            int r11 = r7.getWidth()
            double r11 = (double) r11
            double r9 = r9 * r11
            com.jumio.core.models.LivenessSettingsModel r11 = r1.f56458e
            double r11 = r11.getMaxFaceCenterDifference()
            int r13 = r7.getHeight()
            double r13 = (double) r13
            double r11 = r11 * r13
            android.graphics.Rect r13 = new android.graphics.Rect
            int r14 = r7.getWidth()
            int r14 = r14 / r5
            double r14 = (double) r14
            r16 = r3
            r17 = r4
            double r3 = (double) r5
            double r9 = r9 / r3
            double r14 = r14 - r9
            int r14 = (int) r14
            int r15 = r7.getHeight()
            int r15 = r15 / r5
            r18 = r9
            double r8 = (double) r15
            double r11 = r11 / r3
            double r8 = r8 - r11
            r3 = 4607632778762754458(0x3ff199999999999a, double:1.1)
            double r8 = r8 * r3
            int r8 = (int) r8
            int r9 = r7.getWidth()
            int r9 = r9 / r5
            double r9 = (double) r9
            double r9 = r9 + r18
            int r9 = (int) r9
            int r7 = r7.getHeight()
            int r7 = r7 / r5
            r15 = r6
            double r5 = (double) r7
            double r5 = r5 + r11
            double r5 = r5 * r3
            int r3 = (int) r5
            r13.<init>(r14, r8, r9, r3)
            r1.f56460g = r13
            com.jumio.core.extraction.ExtractionUpdateInterface$Companion r18 = com.jumio.core.extraction.ExtractionUpdateInterface.Companion
            com.jumio.core.extraction.liveness.extraction.LivenessUpdateState r3 = com.jumio.core.extraction.liveness.extraction.LivenessUpdateState.INSTANCE
            int r19 = r3.getFaceCenterArea()
            com.jumio.commons.camera.CameraUtils r3 = com.jumio.commons.camera.CameraUtils.INSTANCE
            com.jumio.commons.camera.PreviewProperties r4 = r25.getPreviewProperties()
            android.graphics.Rect r5 = r1.f56460g
            android.graphics.RectF r6 = new android.graphics.RectF
            r6.<init>(r5)
            android.graphics.RectF r20 = r3.previewToSurface(r4, r6)
            r21 = 0
            r22 = 4
            r23 = 0
            com.jumio.core.extraction.ExtractionUpdateInterface r3 = com.jumio.core.extraction.ExtractionUpdateInterface.Companion.build$default(r18, r19, r20, r21, r22, r23)
            r4 = 0
            r1.a((com.jumio.core.extraction.ExtractionUpdateInterface<?>) r3, (boolean) r4)
            r3 = r15
            com.jumio.core.cdn.CDNEncryptedEntry r0 = r0.get(r3)     // Catch:{ Exception -> 0x0150 }
            if (r0 != 0) goto L_0x00fd
            java.lang.String r0 = "Could not find encrypted model for livenessAssets"
            com.jumio.commons.log.Log.e((java.lang.String) r2, (java.lang.String) r0)     // Catch:{ Exception -> 0x0150 }
            r3 = r17
            com.jumio.commons.log.Log.w((java.lang.String) r2, (java.lang.String) r3)     // Catch:{ Exception -> 0x00f9 }
            com.jumio.analytics.Analytics$Companion r0 = com.jumio.analytics.Analytics.Companion     // Catch:{ Exception -> 0x00f9 }
            r5 = r16
            r4 = 2
            r6 = 0
            com.jumio.analytics.AnalyticsEvent r7 = com.jumio.analytics.MobileEvents.misc$default(r5, r6, r4, r6)     // Catch:{ Exception -> 0x014e }
            r0.add(r7)     // Catch:{ Exception -> 0x014e }
            com.jumio.sdk.enums.JumioFallbackReason r0 = com.jumio.sdk.enums.JumioFallbackReason.LOW_PERFORMANCE     // Catch:{ Exception -> 0x014e }
            r1.triggerFallback(r0)     // Catch:{ Exception -> 0x014e }
            return
        L_0x00f9:
            r0 = move-exception
            r5 = r16
            goto L_0x0155
        L_0x00fd:
            r5 = r16
            r3 = r17
            com.jumio.core.models.LivenessSettingsModel r6 = r1.f56458e     // Catch:{ Exception -> 0x014e }
            long r6 = r6.getModelInitTimeoutInMs()     // Catch:{ Exception -> 0x014e }
            java.nio.ByteBuffer r0 = r0.load(r6)     // Catch:{ Exception -> 0x014e }
            com.jumio.core.util.DataPointsUtil r6 = com.jumio.core.util.DataPointsUtil.INSTANCE     // Catch:{ Exception -> 0x014e }
            android.content.Context r7 = r25.getContext()     // Catch:{ Exception -> 0x014e }
            java.lang.String r6 = r6.getDeviceId(r7)     // Catch:{ Exception -> 0x014e }
            java.lang.String r7 = ""
            if (r6 != 0) goto L_0x011a
            r6 = r7
        L_0x011a:
            r1.a(r0, r6, r7, r1)     // Catch:{ Exception -> 0x014e }
            com.jumio.core.ServiceLocator r0 = com.jumio.core.ServiceLocator.INSTANCE     // Catch:{ Exception -> 0x014e }
            java.lang.Class<com.jumio.core.image.ImageStoreInterface> r6 = com.jumio.core.image.ImageStoreInterface.class
            r7 = 2
            r8 = 0
            java.lang.Object r0 = com.jumio.core.ServiceLocatorInterface.DefaultImpls.getServiceImplementation$default(r0, r6, r8, r7, r8)     // Catch:{ Exception -> 0x014e }
            com.jumio.core.image.ImageStoreInterface r0 = (com.jumio.core.image.ImageStoreInterface) r0     // Catch:{ Exception -> 0x014e }
            android.content.Context r6 = r25.getContext()     // Catch:{ Exception -> 0x014e }
            com.jumio.core.MobileContext r6 = (com.jumio.core.MobileContext) r6     // Catch:{ Exception -> 0x014e }
            com.jumio.core.models.AuthorizationModel$SessionKey r12 = r6.getSessionKey()     // Catch:{ Exception -> 0x014e }
            android.graphics.Bitmap$CompressFormat r13 = android.graphics.Bitmap.CompressFormat.WEBP     // Catch:{ Exception -> 0x014e }
            r14 = 95
            java.lang.String r15 = "image/webp"
            java.lang.String r16 = "WEBP"
            r11 = r0
            r11.configure(r12, r13, r14, r15, r16)     // Catch:{ Exception -> 0x014e }
            jumio.liveness.o r6 = new jumio.liveness.o     // Catch:{ Exception -> 0x014e }
            com.jumio.core.models.LivenessSettingsModel r7 = r1.f56458e     // Catch:{ Exception -> 0x014e }
            r6.<init>(r7, r0)     // Catch:{ Exception -> 0x014e }
            r1.f56455b = r6     // Catch:{ Exception -> 0x014e }
            java.util.concurrent.atomic.AtomicBoolean r0 = r1.f56465l     // Catch:{ Exception -> 0x014e }
            r0.set(r4)     // Catch:{ Exception -> 0x014e }
            goto L_0x016b
        L_0x014e:
            r0 = move-exception
            goto L_0x0155
        L_0x0150:
            r0 = move-exception
            r5 = r16
            r3 = r17
        L_0x0155:
            com.jumio.commons.log.Log.w((java.lang.String) r2, (java.lang.Throwable) r0)
            com.jumio.commons.log.Log.w((java.lang.String) r2, (java.lang.String) r3)
            com.jumio.analytics.Analytics$Companion r0 = com.jumio.analytics.Analytics.Companion
            r4 = 2
            r6 = 0
            com.jumio.analytics.AnalyticsEvent r2 = com.jumio.analytics.MobileEvents.misc$default(r5, r6, r4, r6)
            r0.add(r2)
            com.jumio.sdk.enums.JumioFallbackReason r0 = com.jumio.sdk.enums.JumioFallbackReason.LOW_PERFORMANCE
            r1.triggerFallback(r0)
        L_0x016b:
            return
        L_0x016c:
            r6 = r8
            r24 = r5
            r5 = r3
            r3 = r4
            r4 = r24
            com.jumio.commons.log.Log.w((java.lang.String) r2, (java.lang.String) r3)
            com.jumio.analytics.Analytics$Companion r0 = com.jumio.analytics.Analytics.Companion
            com.jumio.analytics.AnalyticsEvent r2 = com.jumio.analytics.MobileEvents.misc$default(r5, r6, r4, r6)
            r0.add(r2)
            com.jumio.sdk.enums.JumioFallbackReason r0 = com.jumio.sdk.enums.JumioFallbackReason.LOW_PERFORMANCE
            r1.triggerFallback(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.liveness.e.init():void");
    }

    public final void onEvent(String str, String str2, byte[] bArr) {
        j jVar;
        if (!x.b(str, DaClient.EVENT_POSE)) {
            Log.d("LivenessExtractionClient", "Received event " + str + ", ignoring...");
        } else if (!this.f56463j) {
            if (str2 == null) {
                Log.d("LivenessExtractionClient", "No face found, discarding event");
                a((ExtractionUpdateInterface<?>) ExtractionUpdateInterface.Companion.build$default(ExtractionUpdateInterface.Companion, LivenessUpdateState.INSTANCE.getCenterFace(), (Object) null, (MetaInfo) null, 4, (Object) null), true);
                c cVar = this.f56464k;
                b bVar = b.NO_FACE;
                cVar.a();
                cVar.f56442a = bVar;
                m mVar = this.f56456c;
                synchronized (mVar.f56490a) {
                    Object c02 = CollectionsKt___CollectionsKt.c0(mVar.f56491b);
                    TypeIntrinsics.a(mVar.f56491b).remove((j) c02);
                    jVar = (j) c02;
                }
                if (jVar != null) {
                    jVar.f56482b.delete();
                    return;
                }
                return;
            }
            r a11 = r.a.a(str2);
            if (a11 != null) {
                a(a11);
                if (a11.e() && !getPreviewProperties().isEmpty()) {
                    a((ExtractionUpdateInterface<?>) ExtractionUpdateInterface.Companion.build$default(ExtractionUpdateInterface.Companion, LivenessUpdateState.INSTANCE.getFaceRoiRect(), CameraUtils.INSTANCE.previewToSurface(getPreviewProperties(), new RectF(a11.f56509b.toRect())), (MetaInfo) null, 4, (Object) null), false);
                }
            }
        }
    }

    public final void onFramesSampled(List<Long> list) {
        FrameRateUtils frameRateUtils = FrameRateUtils.INSTANCE;
        long frameRateFromSample = frameRateUtils.getFrameRateFromSample(list, 1000000000);
        if (frameRateUtils.checkThresholdForFrameRate(frameRateFromSample, this.f56458e.getFrameRateThreshold())) {
            long frameRateThreshold = this.f56458e.getFrameRateThreshold();
            Log.v("LivenessFrameSampling", "Frame Rate is " + frameRateFromSample + ", threshold is " + frameRateThreshold);
            int i11 = this.f56461h + -1;
            this.f56461h = i11;
            this.f56461h = x0.a.c(i11, 0, this.f56458e.getViolationLimit());
            return;
        }
        LivenessSettingsModel livenessSettingsModel = this.f56458e;
        Log.w("LivenessFrameSampling", "Threshold failure: Frame Rate is " + frameRateFromSample + ", threshold is " + livenessSettingsModel + ".frameRateThreshold");
        int i12 = this.f56461h + 1;
        this.f56461h = i12;
        if (i12 >= this.f56458e.getViolationLimit()) {
            int i13 = this.f56461h;
            Log.w("LivenessFrameSampling", "Threshold failures reached the amount of " + i13 + ", falling back to other extraction method");
            Analytics.Companion.add(MobileEvents.misc$default("livenessFrameRateFallback", (MetaInfo) null, 2, (Object) null));
            triggerFallback(JumioFallbackReason.LOW_PERFORMANCE);
        }
    }

    public final void process(ImageSource imageSource, PreviewProperties previewProperties, Frame.MetaData metaData, Rect rect) {
        if (!this.f56459f) {
            setResult(false);
            return;
        }
        SystemClock.uptimeMillis();
        if (imageSource.Width() != 0 && imageSource.Height() != 0) {
            j jVar = new j(metaData.getTimeStamp(), imageSource, metaData, previewProperties, rect);
            o oVar = this.f56455b;
            o oVar2 = null;
            if (oVar == null) {
                oVar = null;
            }
            t tVar = t.INITIAL;
            if (!oVar.c(tVar)) {
                o oVar3 = this.f56455b;
                if (oVar3 != null) {
                    oVar2 = oVar3;
                }
                oVar2.a(new k(jVar), tVar);
                setResult(false);
            } else if (!DaClient.hasStarted()) {
                Log.w("LivenessExtractionClient", "Liveness client not started, could not process image!");
                setResult(false);
            } else if (this.f56463j) {
                setResult(false);
            } else {
                this.f56456c.a(jVar);
                Log.d("LivenessExtractionClient", "Processing frame with timeStamp=" + metaData.getTimeStamp() + ", width=" + imageSource.Width() + ", height=" + imageSource.Height() + ", rotation=" + metaData.getRotation() + ", orientation=" + metaData.getOrientation());
                DaClient.sendFrame(metaData.getTimeStamp(), imageSource.getImage().toBytes(), imageSource.Width(), imageSource.Height(), imageSource.Stride(), metaData.getRotation(), (int) metaData.getShutterSpeed(), metaData.getIso());
                Log log = Log.INSTANCE;
                LogLevel logLevel = LogLevel.VERBOSE;
                setResult(false);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0017, code lost:
        if ((r0 != null && r0.c(jumio.liveness.t.f56515a)) == false) goto L_0x0019;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean shouldFeed() {
        /*
            r4 = this;
            boolean r0 = com.jumio.liveness.DaClient.hasStarted()
            r1 = 1
            r2 = 0
            if (r0 != 0) goto L_0x0019
            jumio.liveness.o r0 = r4.f56455b
            if (r0 == 0) goto L_0x0016
            jumio.liveness.t r3 = jumio.liveness.t.INITIAL
            boolean r0 = r0.c(r3)
            if (r0 == 0) goto L_0x0016
            r0 = r1
            goto L_0x0017
        L_0x0016:
            r0 = r2
        L_0x0017:
            if (r0 != 0) goto L_0x0022
        L_0x0019:
            java.util.concurrent.atomic.AtomicBoolean r0 = r4.f56465l
            boolean r0 = r0.get()
            if (r0 != 0) goto L_0x0022
            goto L_0x0023
        L_0x0022:
            r1 = r2
        L_0x0023:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.liveness.e.shouldFeed():boolean");
    }

    public static final class a {
        public static boolean a(r rVar, Rect rect) {
            Rect rect2 = rVar.a().toRect();
            boolean contains = rect.contains(rect2.centerX(), rect2.centerY());
            Log.d("LivenessExtractionClient", "Face is centered: " + contains);
            return contains;
        }

        public static boolean a(r rVar, int i11, int i12, int i13, int i14) {
            Integer b11 = rVar.b();
            Integer c11 = rVar.c();
            Log.d("LivenessExtractionClient", "Checking pitch=" + b11 + ", yaw=" + c11);
            return b11 != null && c11 != null && new h(i11, i12).h(b11.intValue()) && new h(i13, i14).h(c11.intValue());
        }
    }

    public final void a() {
        long convert = TimeUnit.NANOSECONDS.convert(this.f56458e.getSamplingTimeInMs(), TimeUnit.MILLISECONDS);
        startFrameRateObservation(convert, this);
        long frameRateThreshold = this.f56458e.getFrameRateThreshold();
        int violationLimit = this.f56458e.getViolationLimit();
        Log.d("LivenessExtractionClient", "Frame rate observation initialised with:\n" + frameRateThreshold + " FPS threshold\n" + convert + " Ns sampling time\n" + violationLimit + " violation limit");
    }

    /* JADX WARNING: Removed duplicated region for block: B:126:0x0284  */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0289  */
    /* JADX WARNING: Removed duplicated region for block: B:130:0x0290  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x0295  */
    /* JADX WARNING: Removed duplicated region for block: B:133:0x0298  */
    /* JADX WARNING: Removed duplicated region for block: B:138:0x02a8  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(jumio.liveness.r r14) {
        /*
            r13 = this;
            jumio.liveness.o r0 = r13.f56455b
            r1 = 0
            if (r0 != 0) goto L_0x0006
            r0 = r1
        L_0x0006:
            jumio.liveness.t r2 = jumio.liveness.t.INITIAL
            boolean r0 = r0.c(r2)
            if (r0 != 0) goto L_0x000f
            return
        L_0x000f:
            jumio.liveness.m r0 = r13.f56456c
            long r2 = r14.d()
            jumio.liveness.j r0 = r0.a((long) r2)
            if (r0 != 0) goto L_0x003b
            long r0 = r14.d()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r2 = "No queued frame for pose event: "
            r14.append(r2)
            r14.append(r0)
            java.lang.String r0 = ", ignoring event..."
            r14.append(r0)
            java.lang.String r14 = r14.toString()
            java.lang.String r0 = "LivenessExtractionClient"
            com.jumio.commons.log.Log.d((java.lang.String) r0, (java.lang.String) r14)
            return
        L_0x003b:
            boolean r2 = r14.e()
            if (r2 != 0) goto L_0x0063
            long r2 = r14.d()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "No valid roi for pose event: "
            r4.append(r5)
            r4.append(r2)
            java.lang.String r2 = ", ignoring event and discarding frame"
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            java.lang.String r3 = "LivenessExtractionClient"
            com.jumio.commons.log.Log.d((java.lang.String) r3, (java.lang.String) r2)
            r0.a()
        L_0x0063:
            android.graphics.Rect r2 = r13.f56460g
            boolean r2 = jumio.liveness.e.a.a(r14, r2)
            r3 = 0
            if (r2 != 0) goto L_0x008a
            java.lang.String r14 = "LivenessExtractionClient"
            java.lang.String r1 = "Face is not centered, skipping frame"
            com.jumio.commons.log.Log.d((java.lang.String) r14, (java.lang.String) r1)
            r0.a()
            com.jumio.core.extraction.ExtractionUpdateInterface$Companion r4 = com.jumio.core.extraction.ExtractionUpdateInterface.Companion
            com.jumio.core.extraction.liveness.extraction.LivenessUpdateState r14 = com.jumio.core.extraction.liveness.extraction.LivenessUpdateState.INSTANCE
            int r5 = r14.getCenterFace()
            r6 = 0
            r7 = 0
            r8 = 4
            r9 = 0
            com.jumio.core.extraction.ExtractionUpdateInterface r14 = com.jumio.core.extraction.ExtractionUpdateInterface.Companion.build$default(r4, r5, r6, r7, r8, r9)
            r13.a((com.jumio.core.extraction.ExtractionUpdateInterface<?>) r14, (boolean) r3)
            return
        L_0x008a:
            com.jumio.core.models.LivenessSettingsModel r2 = r13.f56458e
            int r4 = r2.getMinimumPitch()
            int r5 = r2.getMaximumPitch()
            int r6 = r2.getMinimumYaw()
            int r2 = r2.getMaximumYaw()
            boolean r2 = jumio.liveness.e.a.a(r14, r4, r5, r6, r2)
            if (r2 != 0) goto L_0x00c0
            java.lang.String r14 = "LivenessExtractionClient"
            java.lang.String r1 = "Device and eye is not levelled, skipping frame"
            com.jumio.commons.log.Log.d((java.lang.String) r14, (java.lang.String) r1)
            r0.a()
            com.jumio.core.extraction.ExtractionUpdateInterface$Companion r4 = com.jumio.core.extraction.ExtractionUpdateInterface.Companion
            com.jumio.core.extraction.liveness.extraction.LivenessUpdateState r14 = com.jumio.core.extraction.liveness.extraction.LivenessUpdateState.INSTANCE
            int r5 = r14.getLevelEyesAndDevice()
            r6 = 0
            r7 = 0
            r8 = 4
            r9 = 0
            com.jumio.core.extraction.ExtractionUpdateInterface r14 = com.jumio.core.extraction.ExtractionUpdateInterface.Companion.build$default(r4, r5, r6, r7, r8, r9)
            r13.a((com.jumio.core.extraction.ExtractionUpdateInterface<?>) r14, (boolean) r3)
            return
        L_0x00c0:
            jumio.liveness.d r2 = r13.f56454a
            if (r2 != 0) goto L_0x00c5
            r2 = r1
        L_0x00c5:
            com.jumio.core.extraction.JumioRect r4 = r14.a()
            int r4 = r4.width()
            jumio.liveness.a r2 = r2.b(r4)
            jumio.liveness.a r4 = jumio.liveness.a.TOO_NEAR
            if (r2 != r4) goto L_0x00ec
            com.jumio.core.extraction.ExtractionUpdateInterface$Companion r5 = com.jumio.core.extraction.ExtractionUpdateInterface.Companion
            com.jumio.core.extraction.liveness.extraction.LivenessUpdateState r14 = com.jumio.core.extraction.liveness.extraction.LivenessUpdateState.INSTANCE
            int r6 = r14.getFaceTooClose()
            r7 = 0
            r8 = 0
            r9 = 4
            r10 = 0
            com.jumio.core.extraction.ExtractionUpdateInterface r14 = com.jumio.core.extraction.ExtractionUpdateInterface.Companion.build$default(r5, r6, r7, r8, r9, r10)
            r13.a((com.jumio.core.extraction.ExtractionUpdateInterface<?>) r14, (boolean) r3)
            r0.a()
            return
        L_0x00ec:
            jumio.liveness.a r4 = jumio.liveness.a.TOO_FAR
            if (r2 != r4) goto L_0x0107
            com.jumio.core.extraction.ExtractionUpdateInterface$Companion r5 = com.jumio.core.extraction.ExtractionUpdateInterface.Companion
            com.jumio.core.extraction.liveness.extraction.LivenessUpdateState r14 = com.jumio.core.extraction.liveness.extraction.LivenessUpdateState.INSTANCE
            int r6 = r14.getMoveFaceCloser()
            r7 = 0
            r8 = 0
            r9 = 4
            r10 = 0
            com.jumio.core.extraction.ExtractionUpdateInterface r14 = com.jumio.core.extraction.ExtractionUpdateInterface.Companion.build$default(r5, r6, r7, r8, r9, r10)
            r13.a((com.jumio.core.extraction.ExtractionUpdateInterface<?>) r14, (boolean) r3)
            r0.a()
            return
        L_0x0107:
            jumio.liveness.k r4 = new jumio.liveness.k
            r4.<init>(r0, r14)
            jumio.liveness.d r14 = r13.f56454a
            if (r14 != 0) goto L_0x0111
            r14 = r1
        L_0x0111:
            jumio.liveness.a r14 = r14.f56452h
            r0 = -1
            if (r14 != 0) goto L_0x0118
            r14 = r0
            goto L_0x0120
        L_0x0118:
            int[] r5 = jumio.liveness.e.b.f56466a
            int r14 = r14.ordinal()
            r14 = r5[r14]
        L_0x0120:
            r5 = 2
            r6 = 1
            if (r14 == r6) goto L_0x0134
            if (r14 == r5) goto L_0x0128
            r14 = r3
            goto L_0x013f
        L_0x0128:
            jumio.liveness.o r14 = r13.f56455b
            if (r14 != 0) goto L_0x012d
            r14 = r1
        L_0x012d:
            jumio.liveness.t r7 = jumio.liveness.t.FAR
            boolean r14 = r14.c(r7)
            goto L_0x013f
        L_0x0134:
            jumio.liveness.o r14 = r13.f56455b
            if (r14 != 0) goto L_0x0139
            r14 = r1
        L_0x0139:
            jumio.liveness.t r7 = jumio.liveness.t.NEAR
            boolean r14 = r14.c(r7)
        L_0x013f:
            if (r14 == 0) goto L_0x0143
            r14 = r6
            goto L_0x0147
        L_0x0143:
            r13.c(r4, r2)
            r14 = r3
        L_0x0147:
            if (r14 != 0) goto L_0x014a
            return
        L_0x014a:
            boolean r14 = r13.b(r4, r2)
            if (r14 != 0) goto L_0x0151
            return
        L_0x0151:
            jumio.liveness.d r14 = r13.f56454a
            if (r14 != 0) goto L_0x0156
            r14 = r1
        L_0x0156:
            jumio.liveness.a r14 = r14.f56452h
            if (r14 != 0) goto L_0x015b
            goto L_0x0163
        L_0x015b:
            int[] r0 = jumio.liveness.e.b.f56466a
            int r14 = r14.ordinal()
            r0 = r0[r14]
        L_0x0163:
            if (r0 == r6) goto L_0x0175
            if (r0 == r5) goto L_0x0169
            r14 = r3
            goto L_0x0180
        L_0x0169:
            jumio.liveness.o r14 = r13.f56455b
            if (r14 != 0) goto L_0x016e
            r14 = r1
        L_0x016e:
            jumio.liveness.t r0 = jumio.liveness.t.NEAR
            boolean r14 = r14.c(r0)
            goto L_0x0180
        L_0x0175:
            jumio.liveness.o r14 = r13.f56455b
            if (r14 != 0) goto L_0x017a
            r14 = r1
        L_0x017a:
            jumio.liveness.t r0 = jumio.liveness.t.FAR
            boolean r14 = r14.c(r0)
        L_0x0180:
            if (r14 == 0) goto L_0x0184
            r14 = r6
            goto L_0x0188
        L_0x0184:
            r13.d(r4, r2)
            r14 = r3
        L_0x0188:
            if (r14 != 0) goto L_0x018b
            return
        L_0x018b:
            java.util.concurrent.atomic.AtomicBoolean r14 = r13.f56465l
            boolean r14 = r14.getAndSet(r6)
            if (r14 == 0) goto L_0x0195
            goto L_0x02c4
        L_0x0195:
            jumio.liveness.d r14 = r13.f56454a
            if (r14 != 0) goto L_0x019a
            r14 = r1
        L_0x019a:
            jumio.liveness.a r14 = r14.a()
            if (r14 != 0) goto L_0x01a2
            goto L_0x02c4
        L_0x01a2:
            com.jumio.core.extraction.ExtractionUpdateInterface r14 = r13.a((jumio.liveness.a) r14)
            r13.a((com.jumio.core.extraction.ExtractionUpdateInterface<?>) r14, (boolean) r3)
            r13.setResult(r6)
            java.lang.String r14 = "LivenessExtractionClient"
            java.lang.String r0 = "Finished image capturing"
            com.jumio.commons.log.Log.i((java.lang.String) r14, (java.lang.String) r0)
            jumio.liveness.m r14 = r13.f56456c
            r14.a()
            boolean r14 = com.jumio.liveness.DaClient.hasStarted()
            if (r14 != 0) goto L_0x01bf
            goto L_0x01c4
        L_0x01bf:
            jumio.liveness.g r14 = jumio.liveness.g.f56471a
            r13.runOnMain(r14)
        L_0x01c4:
            java.util.ArrayList r14 = r13.f56462i
            int r14 = r14.size()
            if (r14 != 0) goto L_0x01cd
            goto L_0x01d1
        L_0x01cd:
            com.jumio.commons.log.Log r14 = com.jumio.commons.log.Log.INSTANCE
            com.jumio.commons.log.LogLevel r14 = com.jumio.commons.log.LogLevel.VERBOSE
        L_0x01d1:
            com.jumio.core.extraction.ExtractionUpdateInterface$Companion r7 = com.jumio.core.extraction.ExtractionUpdateInterface.Companion
            com.jumio.core.extraction.liveness.extraction.LivenessUpdateState r14 = com.jumio.core.extraction.liveness.extraction.LivenessUpdateState.INSTANCE
            int r8 = r14.getLivenessFinished()
            r9 = 0
            r10 = 0
            r11 = 4
            r12 = 0
            com.jumio.core.extraction.ExtractionUpdateInterface r14 = com.jumio.core.extraction.ExtractionUpdateInterface.Companion.build$default(r7, r8, r9, r10, r11, r12)
            r13.a((com.jumio.core.extraction.ExtractionUpdateInterface<?>) r14, (boolean) r3)
            com.jumio.core.extraction.liveness.extraction.LivenessDataModel r14 = new com.jumio.core.extraction.liveness.extraction.LivenessDataModel
            r14.<init>()
            com.jumio.core.data.ScanMode r0 = com.jumio.core.data.ScanMode.JUMIO_LIVENESS
            r14.setType(r0)
            r14.setPassed(r1)
            jumio.liveness.o r0 = r13.f56455b
            if (r0 != 0) goto L_0x01f6
            r0 = r1
        L_0x01f6:
            com.jumio.core.image.ImageStoreInterface r2 = r0.f56493b
            r2.stop(r6)
            java.lang.Object r2 = r0.f56499h
            monitor-enter(r2)
            java.util.ArrayList r4 = r0.f56498g     // Catch:{ all -> 0x02cb }
            jumio.liveness.n r5 = new jumio.liveness.n     // Catch:{ all -> 0x02cb }
            r5.<init>()     // Catch:{ all -> 0x02cb }
            java.util.List r4 = kotlin.collections.CollectionsKt___CollectionsKt.z0(r4, r5)     // Catch:{ all -> 0x02cb }
            int r5 = r4.size()     // Catch:{ all -> 0x02cb }
            com.jumio.core.models.LivenessSettingsModel r7 = r0.f56492a     // Catch:{ all -> 0x02cb }
            int r7 = r7.getInitialImages()     // Catch:{ all -> 0x02cb }
            com.jumio.core.models.LivenessSettingsModel r8 = r0.f56492a     // Catch:{ all -> 0x02cb }
            int r8 = r8.getNearImages()     // Catch:{ all -> 0x02cb }
            int r7 = r7 + r8
            if (r5 >= r7) goto L_0x021f
            monitor-exit(r2)
            goto L_0x02b6
        L_0x021f:
            com.jumio.core.models.LivenessSettingsModel r5 = r0.f56492a     // Catch:{ all -> 0x02cb }
            int r5 = r5.getInitialImages()     // Catch:{ all -> 0x02cb }
            java.util.List r5 = kotlin.collections.CollectionsKt___CollectionsKt.T(r4, r5)     // Catch:{ all -> 0x02cb }
            com.jumio.core.models.LivenessSettingsModel r0 = r0.f56492a     // Catch:{ all -> 0x02cb }
            int r0 = r0.getNearImages()     // Catch:{ all -> 0x02cb }
            java.util.List r0 = kotlin.collections.CollectionsKt___CollectionsKt.B0(r5, r0)     // Catch:{ all -> 0x02cb }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ all -> 0x02cb }
            boolean r5 = r0.hasNext()     // Catch:{ all -> 0x02cb }
            if (r5 == 0) goto L_0x02c5
            java.lang.Object r5 = r0.next()     // Catch:{ all -> 0x02cb }
            boolean r7 = r0.hasNext()     // Catch:{ all -> 0x02cb }
            if (r7 != 0) goto L_0x0249
            goto L_0x02b0
        L_0x0249:
            r7 = r5
            com.jumio.liveness.image.LivenessImageData r7 = (com.jumio.liveness.image.LivenessImageData) r7     // Catch:{ all -> 0x02cb }
            com.jumio.liveness.dto.Pitch r8 = r7.getPseudoPitch()     // Catch:{ all -> 0x02cb }
            if (r8 == 0) goto L_0x0257
            java.lang.Integer r8 = r8.getOffset()     // Catch:{ all -> 0x02cb }
            goto L_0x0258
        L_0x0257:
            r8 = r1
        L_0x0258:
            com.jumio.liveness.dto.Yaw r7 = r7.getPseudoYaw()     // Catch:{ all -> 0x02cb }
            if (r7 == 0) goto L_0x0263
            java.lang.Integer r7 = r7.getOffset()     // Catch:{ all -> 0x02cb }
            goto L_0x0264
        L_0x0263:
            r7 = r1
        L_0x0264:
            r9 = 2147483647(0x7fffffff, float:NaN)
            if (r8 == 0) goto L_0x0276
            if (r7 != 0) goto L_0x026c
            goto L_0x0276
        L_0x026c:
            int r8 = r8.intValue()     // Catch:{ all -> 0x02cb }
            int r7 = r7.intValue()     // Catch:{ all -> 0x02cb }
            int r8 = r8 + r7
            goto L_0x0277
        L_0x0276:
            r8 = r9
        L_0x0277:
            java.lang.Object r7 = r0.next()     // Catch:{ all -> 0x02cb }
            r10 = r7
            com.jumio.liveness.image.LivenessImageData r10 = (com.jumio.liveness.image.LivenessImageData) r10     // Catch:{ all -> 0x02cb }
            com.jumio.liveness.dto.Pitch r11 = r10.getPseudoPitch()     // Catch:{ all -> 0x02cb }
            if (r11 == 0) goto L_0x0289
            java.lang.Integer r11 = r11.getOffset()     // Catch:{ all -> 0x02cb }
            goto L_0x028a
        L_0x0289:
            r11 = r1
        L_0x028a:
            com.jumio.liveness.dto.Yaw r10 = r10.getPseudoYaw()     // Catch:{ all -> 0x02cb }
            if (r10 == 0) goto L_0x0295
            java.lang.Integer r10 = r10.getOffset()     // Catch:{ all -> 0x02cb }
            goto L_0x0296
        L_0x0295:
            r10 = r1
        L_0x0296:
            if (r11 == 0) goto L_0x02a5
            if (r10 != 0) goto L_0x029b
            goto L_0x02a5
        L_0x029b:
            int r11 = r11.intValue()     // Catch:{ all -> 0x02cb }
            int r10 = r10.intValue()     // Catch:{ all -> 0x02cb }
            int r11 = r11 + r10
            goto L_0x02a6
        L_0x02a5:
            r11 = r9
        L_0x02a6:
            if (r8 <= r11) goto L_0x02aa
            r5 = r7
            r8 = r11
        L_0x02aa:
            boolean r7 = r0.hasNext()     // Catch:{ all -> 0x02cb }
            if (r7 != 0) goto L_0x0277
        L_0x02b0:
            com.jumio.liveness.image.LivenessImageData r5 = (com.jumio.liveness.image.LivenessImageData) r5     // Catch:{ all -> 0x02cb }
            r5.setBestSelfie(r6)     // Catch:{ all -> 0x02cb }
            monitor-exit(r2)
        L_0x02b6:
            com.jumio.commons.camera.ImageData[] r0 = new com.jumio.commons.camera.ImageData[r3]
            java.lang.Object[] r0 = r4.toArray(r0)
            com.jumio.commons.camera.ImageData[] r0 = (com.jumio.commons.camera.ImageData[]) r0
            r14.setFrames(r0)
            r13.publishResult((com.jumio.core.model.StaticModel) r14)
        L_0x02c4:
            return
        L_0x02c5:
            java.util.NoSuchElementException r14 = new java.util.NoSuchElementException     // Catch:{ all -> 0x02cb }
            r14.<init>()     // Catch:{ all -> 0x02cb }
            throw r14     // Catch:{ all -> 0x02cb }
        L_0x02cb:
            r14 = move-exception
            monitor-exit(r2)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.liveness.e.a(jumio.liveness.r):void");
    }

    public final void a(k kVar, a aVar) {
        int i11 = aVar == null ? -1 : b.f56466a[aVar.ordinal()];
        if (i11 == 1 || i11 == 2) {
            Log.i("LivenessExtractionClient", "Finished capturing images for first distance (" + aVar + ")");
            j b11 = kVar.b();
            QAInterface qa2 = QAKt.getQA();
            ImageSource imageSource = b11.f56482b;
            qa2.getClass();
            d dVar = this.f56454a;
            d dVar2 = null;
            if (dVar == null) {
                dVar = null;
            }
            dVar.a(aVar, kVar.c().a());
            d dVar3 = this.f56454a;
            if (dVar3 != null) {
                dVar2 = dVar3;
            }
            dVar2.a(this.f56458e.getTransitionImages());
            a((ExtractionUpdateInterface<?>) a(aVar), false);
        } else {
            Log.w("LivenessExtractionClient", "Illegal state (" + aVar + ") when completing the first distance");
        }
        c cVar = new c(this);
        this.f56463j = true;
        n1 unused = i.d(getMainScope(), (CoroutineContext) null, (CoroutineStart) null, new i(com.sumsub.sns.internal.ml.autocapture.a.f34923p, this, cVar, (kotlin.coroutines.c<? super i>) null), 3, (Object) null);
    }

    public final void a(ExtractionUpdateInterface<?> extractionUpdateInterface, boolean z11) {
        if (this.f56463j) {
            Integer state = extractionUpdateInterface.getState();
            int i11 = ExtractionUpdateState.fallbackRequired;
            if (state == null || state.intValue() != i11) {
                Integer state2 = extractionUpdateInterface.getState();
                Object data = extractionUpdateInterface.getData();
                Log.d("LivenessExtractionClient", "Already paused, skipping update of " + state2 + " and " + data);
                return;
            }
        }
        if (!z11) {
            this.f56464k.a(extractionUpdateInterface);
        }
        publishUpdate(extractionUpdateInterface);
    }

    public final ExtractionUpdateInterface a(a aVar) {
        LinkedHashMap linkedHashMap;
        ExtractionUpdateInterface.Companion companion = ExtractionUpdateInterface.Companion;
        int i11 = ExtractionUpdateState.shotTaken;
        c cVar = this.f56464k;
        cVar.getClass();
        MetaInfo metaInfo = new MetaInfo();
        cVar.a();
        if (!cVar.f56444c.isEmpty()) {
            Set<Map.Entry> entrySet = cVar.f56444c.entrySet();
            linkedHashMap = new LinkedHashMap(RangesKt___RangesKt.d(MapsKt__MapsJVMKt.d(CollectionsKt__IterablesKt.u(entrySet, 10)), 16));
            for (Map.Entry entry : entrySet) {
                Pair a11 = l.a(((b) entry.getKey()).toString(), Double.valueOf(((Number) entry.getValue()).doubleValue() / 1000.0d));
                linkedHashMap.put(a11.getFirst(), a11.getSecond());
            }
        } else {
            linkedHashMap = null;
        }
        if (linkedHashMap != null) {
            metaInfo.put("extractionStates", linkedHashMap);
        }
        metaInfo.put(DaClient.ATTR_DISTANCE, aVar.toString());
        cVar.f56442a = null;
        cVar.f56443b = null;
        cVar.f56444c.clear();
        return companion.build(i11, null, metaInfo);
    }
}
