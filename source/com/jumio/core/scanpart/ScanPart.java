package com.jumio.core.scanpart;

import com.jumio.analytics.Analytics;
import com.jumio.analytics.MetaInfo;
import com.jumio.analytics.MobileEvents;
import com.jumio.core.Controller;
import com.jumio.core.data.ScanMode;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.network.ApiBinding;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.enums.JumioFallbackReason;
import com.jumio.sdk.enums.JumioScanMode;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.enums.JumioScanUpdate;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import com.jumio.sdk.retry.JumioRetryReason;
import com.jumio.sdk.scanpart.JumioScanPart;
import com.jumio.sdk.views.JumioAnimationView;
import d10.l;
import d10.p;
import jumio.core.d2;
import jumio.core.l2;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;

public abstract class ScanPart<T extends ScanPartModel> {

    /* renamed from: a  reason: collision with root package name */
    public final Controller f39486a;

    /* renamed from: b  reason: collision with root package name */
    public final JumioCredential f39487b;

    /* renamed from: c  reason: collision with root package name */
    public T f39488c;

    /* renamed from: d  reason: collision with root package name */
    public final JumioScanPartInterface f39489d;

    /* renamed from: e  reason: collision with root package name */
    public JumioScanUpdate f39490e;

    /* renamed from: f  reason: collision with root package name */
    public final l2 f39491f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f39492g;

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f39493a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f39494b;

        /* JADX WARNING: Can't wrap try/catch for region: R(27:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|31) */
        /* JADX WARNING: Can't wrap try/catch for region: R(28:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|31) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005f */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0069 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x0073 */
        static {
            /*
                com.jumio.sdk.enums.JumioScanStep[] r0 = com.jumio.sdk.enums.JumioScanStep.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.jumio.sdk.enums.JumioScanStep r2 = com.jumio.sdk.enums.JumioScanStep.RETRY     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.jumio.sdk.enums.JumioScanStep r3 = com.jumio.sdk.enums.JumioScanStep.IMAGE_TAKEN     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f39493a = r0
                com.jumio.core.data.ScanMode[] r0 = com.jumio.core.data.ScanMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.jumio.core.data.ScanMode r3 = com.jumio.core.data.ScanMode.DOCFINDER     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.jumio.core.data.ScanMode r1 = com.jumio.core.data.ScanMode.PDF417     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                com.jumio.core.data.ScanMode r1 = com.jumio.core.data.ScanMode.FACE_MANUAL     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                com.jumio.core.data.ScanMode r1 = com.jumio.core.data.ScanMode.MANUAL     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                com.jumio.core.data.ScanMode r1 = com.jumio.core.data.ScanMode.NFC     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                com.jumio.core.data.ScanMode r1 = com.jumio.core.data.ScanMode.FACE_IPROOV     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                com.jumio.core.data.ScanMode r1 = com.jumio.core.data.ScanMode.JUMIO_LIVENESS     // Catch:{ NoSuchFieldError -> 0x005f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005f }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005f }
            L_0x005f:
                com.jumio.core.data.ScanMode r1 = com.jumio.core.data.ScanMode.DEVICE_RISK     // Catch:{ NoSuchFieldError -> 0x0069 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0069 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0069 }
            L_0x0069:
                com.jumio.core.data.ScanMode r1 = com.jumio.core.data.ScanMode.FILE     // Catch:{ NoSuchFieldError -> 0x0073 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0073 }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                com.jumio.core.data.ScanMode r1 = com.jumio.core.data.ScanMode.WEB     // Catch:{ NoSuchFieldError -> 0x007d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x007d }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x007d }
            L_0x007d:
                f39494b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.scanpart.ScanPart.a.<clinit>():void");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.jumio.core.scanpart.ScanPart$runOnMain$1", f = "ScanPart.kt", l = {}, m = "invokeSuspend")
    public static final class b extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a<Unit> f39495a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(d10.a<Unit> aVar, kotlin.coroutines.c<? super b> cVar) {
            super(2, cVar);
            this.f39495a = aVar;
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new b(this.f39495a, cVar);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((b) create((h0) obj, (kotlin.coroutines.c) obj2)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            k.b(obj);
            this.f39495a.invoke();
            return Unit.f56620a;
        }
    }

    public static final class c extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScanPart<T> f39496a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JumioScanStep f39497b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object f39498c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ScanPart<T> scanPart, JumioScanStep jumioScanStep, Object obj) {
            super(0);
            this.f39496a = scanPart;
            this.f39497b = jumioScanStep;
            this.f39498c = obj;
        }

        public final Object invoke() {
            this.f39496a.getScanPartInterface().onScanStep(this.f39497b, this.f39498c);
            return Unit.f56620a;
        }
    }

    public static final class d extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ScanPart<T> f39499a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JumioScanUpdate f39500b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object f39501c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(ScanPart<T> scanPart, JumioScanUpdate jumioScanUpdate, Object obj) {
            super(0);
            this.f39499a = scanPart;
            this.f39500b = jumioScanUpdate;
            this.f39501c = obj;
        }

        public final Object invoke() {
            this.f39499a.getScanPartInterface().onUpdate(this.f39500b, this.f39501c);
            return Unit.f56620a;
        }
    }

    public ScanPart(Controller controller, JumioCredential jumioCredential, T t11, JumioScanPartInterface jumioScanPartInterface) {
        this.f39486a = controller;
        this.f39487b = jumioCredential;
        this.f39488c = t11;
        this.f39489d = jumioScanPartInterface;
        this.f39491f = (l2) controller.getDataManager().get(l2.class);
        if (this instanceof ApiBinding) {
            controller.getBackendManager().addBinding((ApiBinding) this);
        }
    }

    public static /* synthetic */ void sendScanStep$default(ScanPart scanPart, JumioScanStep jumioScanStep, Object obj, Object obj2, int i11, Object obj3) {
        if (obj3 == null) {
            if ((i11 & 2) != 0) {
                obj = null;
            }
            if ((i11 & 4) != 0) {
                obj2 = obj;
            }
            scanPart.sendScanStep(jumioScanStep, obj, obj2);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendScanStep");
    }

    public static /* synthetic */ n1 sendUpdate$default(ScanPart scanPart, JumioScanUpdate jumioScanUpdate, Object obj, int i11, Object obj2) {
        if (obj2 == null) {
            if ((i11 & 2) != 0) {
                obj = null;
            }
            return scanPart.sendUpdate(jumioScanUpdate, obj);
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendUpdate");
    }

    public static /* synthetic */ void sendUpdateFiltered$default(ScanPart scanPart, JumioScanUpdate jumioScanUpdate, Object obj, int i11, Object obj2) {
        if (obj2 == null) {
            if ((i11 & 2) != 0) {
                obj = null;
            }
            scanPart.sendUpdateFiltered(jumioScanUpdate, obj);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendUpdateFiltered");
    }

    public void cancel() {
        Analytics.Companion.add(MobileEvents.userAction("cancel", this.f39488c.getScanStep(), this.f39488c.getCredentialPart().name()));
        this.f39491f.a(this.f39488c.getCredentialPart(), this.f39487b.getData$jumio_core_release().f56143a);
        if (this instanceof ApiBinding) {
            this.f39486a.getBackendManager().removeBinding((ApiBinding) this);
        }
    }

    public void checkForAddon(l<? super JumioScanPart, Unit> lVar) {
        lVar.invoke(null);
    }

    public void fallback(JumioFallbackReason jumioFallbackReason) {
        Analytics.Companion.add(MobileEvents.userAction("fallback", this.f39488c.getScanStep(), this.f39488c.getCredentialPart().name()));
    }

    public void finish() {
        Analytics.Companion.add(MobileEvents.userAction("finish", this.f39488c.getScanStep(), this.f39488c.getCredentialPart().name()));
        this.f39491f.a(this.f39488c.getCredentialPart(), this.f39487b.getData$jumio_core_release().f56143a);
        if (this instanceof ApiBinding) {
            this.f39486a.getBackendManager().removeBinding((ApiBinding) this);
        }
    }

    public final MetaInfo getAnalyticsScanData() {
        MetaInfo metaInfo = new MetaInfo();
        metaInfo.put("side", this.f39488c.getCredentialPart().toString());
        metaInfo.put("type", getScanPluginMode(this.f39488c.getMode()).toString());
        return metaInfo;
    }

    public final Controller getController() {
        return this.f39486a;
    }

    public final JumioCredential getCredential() {
        return this.f39487b;
    }

    public abstract boolean getHasFallback();

    public abstract void getHelpAnimation(JumioAnimationView jumioAnimationView);

    public final h0 getMainScope() {
        return this.f39486a.getMainScope();
    }

    public final l2 getReportingModel() {
        return this.f39491f;
    }

    public abstract JumioScanMode getScanMode();

    public final JumioScanPartInterface getScanPartInterface() {
        return this.f39489d;
    }

    public final T getScanPartModel() {
        return this.f39488c;
    }

    public final d2 getScanPluginMode(ScanMode scanMode) {
        switch (a.f39494b[scanMode.ordinal()]) {
            case 1:
                return d2.DOCFINDER;
            case 2:
                return d2.BARCODE_NATIVE;
            case 3:
                return d2.FACE_MANUAL;
            case 4:
                return d2.MANUAL;
            case 5:
                return d2.NFC;
            case 6:
                return d2.FACE_IPROOV;
            case 7:
                return d2.JUMIO_LIVENESS;
            case 8:
                return d2.SARDINE;
            case 9:
                return d2.MANUAL;
            case 10:
                return d2.DIGITAL_IDENTITY;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public abstract boolean isCancelable();

    public final boolean isComplete() {
        return this.f39492g;
    }

    public void persist() {
    }

    public void reset() {
        this.f39488c.getFileData().clear();
    }

    public void restore() {
    }

    public void retry(JumioRetryReason jumioRetryReason) {
        JumioRetryReason lastRetryReason = this.f39488c.getLastRetryReason();
        if (lastRetryReason != null && jumioRetryReason.getCode() == lastRetryReason.getCode()) {
            this.f39488c.setLastRetryReason((JumioRetryReason) null);
            Analytics.Companion.add(MobileEvents.userAction("retry", this.f39488c.getScanStep(), this.f39488c.getCredentialPart().name()));
            return;
        }
        throw new IllegalArgumentException("Specified retry reason is not valid".toString());
    }

    public final n1 runOnMain(d10.a<Unit> aVar) {
        return i.d(getMainScope(), (CoroutineContext) null, (CoroutineStart) null, new b(aVar, (kotlin.coroutines.c<? super b>) null), 3, (Object) null);
    }

    public final void sendScanStep(JumioScanStep jumioScanStep, Object obj, Object obj2) {
        this.f39488c.setScanStep(jumioScanStep);
        this.f39491f.f56247e = jumioScanStep;
        int i11 = a.f39493a[jumioScanStep.ordinal()];
        if (i11 == 1) {
            this.f39488c.setLastRetryReason((JumioRetryReason) obj);
        } else if (i11 == 2) {
            l2 l2Var = this.f39491f;
            d2 scanPluginMode = getScanPluginMode(this.f39488c.getMode());
            l2Var.getClass();
            if (!l2Var.f56244b.contains(scanPluginMode)) {
                l2Var.f56244b.add(scanPluginMode);
            }
        }
        Analytics.Companion.add(MobileEvents.scanStep(jumioScanStep, obj2));
        runOnMain(new c(this, jumioScanStep, obj));
    }

    public final n1 sendUpdate(JumioScanUpdate jumioScanUpdate, Object obj) {
        return runOnMain(new d(this, jumioScanUpdate, obj));
    }

    public final synchronized void sendUpdateFiltered(JumioScanUpdate jumioScanUpdate, Object obj) {
        if (this.f39490e != jumioScanUpdate) {
            this.f39490e = jumioScanUpdate;
            sendUpdate(jumioScanUpdate, obj);
        }
    }

    public final void setComplete(boolean z11) {
        this.f39492g = z11;
    }

    public final void setScanPartModel(T t11) {
        this.f39488c = t11;
    }

    public void start() {
        this.f39491f.b(this.f39488c.getCredentialPart(), this.f39487b.getData$jumio_core_release().f56143a);
        Analytics.Companion.add(MobileEvents.userAction("start", this.f39488c.getScanStep(), this.f39488c.getCredentialPart().name()));
    }
}
