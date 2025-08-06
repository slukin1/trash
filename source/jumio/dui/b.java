package jumio.dui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.SavedStateHandle;
import com.jumio.commons.log.Log;
import com.jumio.core.enums.ErrorCase;
import com.jumio.defaultui.utils.DefaultUIProvider;
import com.jumio.sdk.consent.JumioConsentItem;
import com.jumio.sdk.controller.JumioController;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.credentials.JumioCredentialInfo;
import com.jumio.sdk.credentials.JumioDocumentCredential;
import com.jumio.sdk.credentials.JumioFaceCredential;
import com.jumio.sdk.credentials.JumioIDCredential;
import com.jumio.sdk.document.JumioDocument;
import com.jumio.sdk.document.JumioDocumentType;
import com.jumio.sdk.enums.JumioCredentialPart;
import com.jumio.sdk.enums.JumioFallbackReason;
import com.jumio.sdk.enums.JumioScanMode;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.enums.JumioScanUpdate;
import com.jumio.sdk.error.JumioError;
import com.jumio.sdk.exceptions.SDKNotConfiguredException;
import com.jumio.sdk.interfaces.JumioControllerInterface;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import com.jumio.sdk.result.JumioResult;
import com.jumio.sdk.retry.JumioRetryReason;
import com.jumio.sdk.scanpart.JumioScanPart;
import d10.l;
import d10.r;
import java.util.List;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;

public final class b extends androidx.lifecycle.a implements Handler.Callback, JumioControllerInterface, JumioScanPartInterface, DefaultUIProvider {

    /* renamed from: a  reason: collision with root package name */
    public final SavedStateHandle f56353a;

    /* renamed from: b  reason: collision with root package name */
    public final Handler f56354b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f56355c = new Object();

    /* renamed from: d  reason: collision with root package name */
    public JumioController f56356d;

    /* renamed from: e  reason: collision with root package name */
    public List<JumioCredentialInfo> f56357e = CollectionsKt__CollectionsKt.k();

    /* renamed from: f  reason: collision with root package name */
    public JumioCredential f56358f;

    /* renamed from: g  reason: collision with root package name */
    public JumioScanPart f56359g;

    /* renamed from: h  reason: collision with root package name */
    public JumioFallbackReason f56360h;

    /* renamed from: i  reason: collision with root package name */
    public final f<C0659b> f56361i;

    /* renamed from: j  reason: collision with root package name */
    public final MutableLiveData<JumioScanStep> f56362j;

    /* renamed from: k  reason: collision with root package name */
    public final MutableLiveData<Pair<JumioScanUpdate, JumioCredentialPart>> f56363k;

    /* renamed from: l  reason: collision with root package name */
    public final MutableLiveData<Boolean> f56364l;

    /* renamed from: m  reason: collision with root package name */
    public final MutableLiveData<Boolean> f56365m;

    /* renamed from: n  reason: collision with root package name */
    public final MutableLiveData<JumioResult> f56366n;

    /* renamed from: o  reason: collision with root package name */
    public final MutableLiveData<JumioError> f56367o;

    public static final class a extends Lambda implements r<JumioController, List<? extends JumioCredentialInfo>, JumioCredential, JumioScanPart, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f56368a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(b bVar) {
            super(4);
            this.f56368a = bVar;
        }

        public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
            Unit unit;
            JumioScanPart jumioScanPart = (JumioScanPart) obj4;
            b bVar = this.f56368a;
            bVar.f56356d = (JumioController) obj;
            bVar.f56357e = (List) obj2;
            b bVar2 = this.f56368a;
            bVar2.f56358f = (JumioCredential) obj3;
            synchronized (bVar2.f56355c) {
                bVar2.a(jumioScanPart);
                unit = Unit.f56620a;
            }
            return unit;
        }
    }

    /* renamed from: jumio.dui.b$b  reason: collision with other inner class name */
    public enum C0659b {
        START,
        LOADING,
        SELECTION_DOCUMENT,
        SELECTION_VARIANT,
        SELECTION_DI_DOCUMENT,
        SELECTION_COUNTRY,
        SELECTION_METHOD,
        SCAN,
        FACE_HELP,
        NFC,
        CONFIRMATION,
        REJECT,
        UPLOAD
    }

    public /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f56383a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f56384b;

        /* renamed from: c  reason: collision with root package name */
        public static final /* synthetic */ int[] f56385c;

        /* JADX WARNING: Can't wrap try/catch for region: R(21:0|(2:1|2)|3|(2:5|6)|7|9|10|(2:11|12)|13|15|16|17|18|19|20|21|22|23|24|25|27) */
        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|1|2|3|(2:5|6)|7|9|10|11|12|13|15|16|17|18|19|20|21|22|23|24|25|27) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0043 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005d */
        static {
            /*
                com.jumio.sdk.enums.JumioScanMode[] r0 = com.jumio.sdk.enums.JumioScanMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.jumio.sdk.enums.JumioScanMode r2 = com.jumio.sdk.enums.JumioScanMode.FACE_IPROOV     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.jumio.sdk.enums.JumioScanMode r3 = com.jumio.sdk.enums.JumioScanMode.JUMIO_LIVENESS     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                f56383a = r0
                com.jumio.sdk.enums.JumioScanUpdate[] r0 = com.jumio.sdk.enums.JumioScanUpdate.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.jumio.sdk.enums.JumioScanUpdate r3 = com.jumio.sdk.enums.JumioScanUpdate.FALLBACK     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.jumio.sdk.enums.JumioScanUpdate r3 = com.jumio.sdk.enums.JumioScanUpdate.NFC_EXTRACTION_PROGRESS     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                f56384b = r0
                com.jumio.sdk.enums.JumioScanStep[] r0 = com.jumio.sdk.enums.JumioScanStep.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.jumio.sdk.enums.JumioScanStep r3 = com.jumio.sdk.enums.JumioScanStep.RETRY     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.REJECT_VIEW     // Catch:{ NoSuchFieldError -> 0x004b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004b }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004b }
            L_0x004b:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.STARTED     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.NEXT_PART     // Catch:{ NoSuchFieldError -> 0x005d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005d }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005d }
            L_0x005d:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.CAN_FINISH     // Catch:{ NoSuchFieldError -> 0x0066 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0066 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0066 }
            L_0x0066:
                f56385c = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: jumio.dui.b.c.<clinit>():void");
        }
    }

    public static final class d extends Lambda implements l<JumioCredentialPart, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public static final d f56386a = new d();

        public d() {
            super(1);
        }

        public final Object invoke(Object obj) {
            return ((JumioCredentialPart) obj).name();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v23, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: com.jumio.sdk.enums.JumioCredentialPart} */
    /* JADX WARNING: Illegal instructions before constructor call */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public b(androidx.lifecycle.SavedStateHandle r16, android.app.Application r17, java.lang.String r18, com.jumio.sdk.enums.JumioDataCenter r19, int r20) {
        /*
            r15 = this;
            r6 = r15
            r0 = r16
            r1 = r17
            r2 = r20
            r15.<init>(r1)
            r6.f56353a = r0
            android.os.Handler r3 = new android.os.Handler
            android.os.Looper r4 = r17.getMainLooper()
            r3.<init>(r4, r15)
            r6.f56354b = r3
            java.lang.Object r3 = new java.lang.Object
            r3.<init>()
            r6.f56355c = r3
            java.util.List r3 = kotlin.collections.CollectionsKt__CollectionsKt.k()
            r6.f56357e = r3
            jumio.dui.f r7 = new jumio.dui.f
            r7.<init>()
            r6.f56361i = r7
            androidx.lifecycle.MutableLiveData r8 = new androidx.lifecycle.MutableLiveData
            r8.<init>()
            r6.f56362j = r8
            androidx.lifecycle.MutableLiveData r9 = new androidx.lifecycle.MutableLiveData
            r9.<init>()
            r6.f56363k = r9
            androidx.lifecycle.MutableLiveData r10 = new androidx.lifecycle.MutableLiveData
            r10.<init>()
            r6.f56364l = r10
            androidx.lifecycle.MutableLiveData r11 = new androidx.lifecycle.MutableLiveData
            r11.<init>()
            r6.f56365m = r11
            androidx.lifecycle.MutableLiveData r12 = new androidx.lifecycle.MutableLiveData
            r12.<init>()
            r6.f56366n = r12
            androidx.lifecycle.MutableLiveData r13 = new androidx.lifecycle.MutableLiveData
            r13.<init>()
            r6.f56367o = r13
            java.lang.String r3 = "jumioSDK"
            java.lang.Object r4 = r0.f(r3)
            r14 = r4
            android.os.Bundle r14 = (android.os.Bundle) r14
            u00.a r4 = new u00.a
            r4.<init>(r15)
            r0.l(r3, r4)
            com.jumio.sdk.JumioSDK r0 = new com.jumio.sdk.JumioSDK
            android.content.Context r3 = r17.getApplicationContext()
            r0.<init>(r3)
            if (r2 == 0) goto L_0x0074
            r0.setCustomThemeId(r2)
        L_0x0074:
            r2 = r18
            r0.setToken(r2)
            r2 = r19
            r0.setDataCenter(r2)
            if (r14 != 0) goto L_0x008d
            jumio.dui.b$b r2 = jumio.dui.b.C0659b.LOADING
            r7.setValue(r2)
            com.jumio.sdk.controller.JumioController r0 = r0.start(r1, r15)
            r6.f56356d = r0
            goto L_0x0121
        L_0x008d:
            android.app.Application r1 = r15.getApplication()
            jumio.dui.b$a r5 = new jumio.dui.b$a
            r5.<init>(r15)
            r2 = r14
            r3 = r15
            r4 = r15
            r0.restore(r1, r2, r3, r4, r5)
            java.lang.Class<jumio.dui.b$b> r0 = jumio.dui.b.C0659b.class
            java.lang.String r1 = "sdkStateEvent"
            java.io.Serializable r0 = jumio.dui.d.a(r14, r1, r0)
            jumio.dui.b$b r0 = (jumio.dui.b.C0659b) r0
            if (r0 == 0) goto L_0x00ab
            r7.setValue(r0)
        L_0x00ab:
            java.lang.Class<com.jumio.sdk.enums.JumioScanStep> r0 = com.jumio.sdk.enums.JumioScanStep.class
            java.lang.String r1 = "scanStepEvent"
            java.io.Serializable r0 = jumio.dui.d.a(r14, r1, r0)
            com.jumio.sdk.enums.JumioScanStep r0 = (com.jumio.sdk.enums.JumioScanStep) r0
            if (r0 == 0) goto L_0x00ba
            r8.setValue(r0)
        L_0x00ba:
            java.lang.Class<kotlin.Pair> r0 = kotlin.Pair.class
            java.lang.String r1 = "scanUpdateEvent"
            java.io.Serializable r0 = jumio.dui.d.a(r14, r1, r0)
            kotlin.Pair r0 = (kotlin.Pair) r0
            if (r0 == 0) goto L_0x00e7
            java.lang.Object r1 = r0.getFirst()
            boolean r2 = r1 instanceof com.jumio.sdk.enums.JumioScanUpdate
            r3 = 0
            if (r2 == 0) goto L_0x00d2
            com.jumio.sdk.enums.JumioScanUpdate r1 = (com.jumio.sdk.enums.JumioScanUpdate) r1
            goto L_0x00d3
        L_0x00d2:
            r1 = r3
        L_0x00d3:
            if (r1 == 0) goto L_0x00e7
            java.lang.Object r0 = r0.getSecond()
            boolean r2 = r0 instanceof com.jumio.sdk.enums.JumioCredentialPart
            if (r2 == 0) goto L_0x00e0
            r3 = r0
            com.jumio.sdk.enums.JumioCredentialPart r3 = (com.jumio.sdk.enums.JumioCredentialPart) r3
        L_0x00e0:
            kotlin.Pair r0 = kotlin.l.a(r1, r3)
            r9.setValue(r0)
        L_0x00e7:
            r0 = 0
            java.lang.String r1 = "helpViewVisible"
            boolean r0 = r14.getBoolean(r1, r0)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r10.setValue(r0)
            r0 = 1
            java.lang.String r1 = "consumeHelpButtonClicks"
            boolean r0 = r14.getBoolean(r1, r0)
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r0)
            r11.setValue(r0)
            java.lang.Class<com.jumio.sdk.result.JumioResult> r0 = com.jumio.sdk.result.JumioResult.class
            java.lang.String r1 = "sdkResult"
            java.io.Serializable r0 = jumio.dui.d.a(r14, r1, r0)
            com.jumio.sdk.result.JumioResult r0 = (com.jumio.sdk.result.JumioResult) r0
            if (r0 == 0) goto L_0x0112
            r12.setValue(r0)
        L_0x0112:
            java.lang.Class<com.jumio.sdk.error.JumioError> r0 = com.jumio.sdk.error.JumioError.class
            java.lang.String r1 = "error"
            java.io.Serializable r0 = jumio.dui.d.a(r14, r1, r0)
            com.jumio.sdk.error.JumioError r0 = (com.jumio.sdk.error.JumioError) r0
            if (r0 == 0) goto L_0x0121
            r13.setValue(r0)
        L_0x0121:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.dui.b.<init>(androidx.lifecycle.SavedStateHandle, android.app.Application, java.lang.String, com.jumio.sdk.enums.JumioDataCenter, int):void");
    }

    public final void a(JumioScanPart jumioScanPart) {
        synchronized (this.f56355c) {
            this.f56359g = jumioScanPart;
            Unit unit = Unit.f56620a;
        }
    }

    public final void b(String str) {
        this.f56353a.k("currentlySelectedCountry", str);
    }

    public final void c(String str) {
        this.f56353a.k("selectedFilePath", str);
    }

    public final JumioCredential d() {
        return this.f56358f;
    }

    public final JumioCredentialPart e() {
        return (JumioCredentialPart) this.f56353a.f("currentCredentialPart");
    }

    public final JumioCredentialPart f() {
        return (JumioCredentialPart) this.f56353a.f("currentCredentialSubPart");
    }

    public final JumioDocument g() {
        return (JumioDocument) this.f56353a.f("currentDocument");
    }

    public final Map<JumioCredentialPart, String> h() {
        return (Map) this.f56353a.f("currentRejectData");
    }

    public final boolean handleMessage(Message message) {
        if (message.what != 1000) {
            return false;
        }
        try {
            c();
            JumioCredential jumioCredential = this.f56358f;
            a(jumioCredential != null ? jumioCredential.getAddonPart() : null);
            if (j() != null) {
                this.f56361i.setValue(C0659b.NFC);
            } else {
                b();
            }
        } catch (SDKNotConfiguredException e11) {
            Log.w("JumioViewModel", (Throwable) e11);
        } catch (IllegalArgumentException e12) {
            Log.w("JumioViewModel", (Throwable) e12);
        }
        return true;
    }

    public final JumioRetryReason i() {
        return (JumioRetryReason) this.f56353a.f("currentRetryData");
    }

    public final JumioScanPart j() {
        JumioScanPart jumioScanPart;
        synchronized (this.f56355c) {
            jumioScanPart = this.f56359g;
        }
        return jumioScanPart;
    }

    public final String k() {
        String str = (String) this.f56353a.f("currentlySelectedCountry");
        return str == null ? "" : str;
    }

    public final MutableLiveData<Boolean> l() {
        return this.f56364l;
    }

    public final int m() {
        Integer num = (Integer) this.f56353a.f("nfcProgressPercentage");
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public final MutableLiveData<JumioScanStep> n() {
        return this.f56362j;
    }

    public final MutableLiveData<Pair<JumioScanUpdate, JumioCredentialPart>> o() {
        return this.f56363k;
    }

    public final void onCleared() {
        JumioController jumioController;
        super.onCleared();
        a("onCleared");
        JumioController jumioController2 = this.f56356d;
        if ((jumioController2 != null && !jumioController2.isComplete()) && (jumioController = this.f56356d) != null) {
            jumioController.stop();
        }
    }

    public final void onError(JumioError jumioError) {
        String code = jumioError.getCode();
        String message = jumioError.getMessage();
        a("onError: " + code + message);
        this.f56367o.setValue(jumioError);
    }

    public final void onFinished(JumioResult jumioResult) {
        a("onFinished");
        this.f56366n.setValue(jumioResult);
    }

    public final void onInitialized(List<JumioCredentialInfo> list, List<JumioConsentItem> list2) {
        this.f56357e = list;
        this.f56353a.k("consentItems", list2);
        Integer valueOf = list2 != null ? Integer.valueOf(list2.size()) : null;
        Log.i("JumioViewModel", "onInitialized: consent items , size: " + valueOf);
        int size = list.size();
        Log.i("JumioViewModel", "onInitialized: credentials received , size: " + size);
        Log.i("SdkState: ViewModel set START");
        this.f56361i.setValue(C0659b.START);
    }

    public final void onScanStep(JumioScanStep jumioScanStep, Object obj) {
        String name = jumioScanStep.name();
        a("onScanStep: " + name);
        int i11 = c.f56385c[jumioScanStep.ordinal()];
        JumioScanPart jumioScanPart = null;
        if (i11 == 1) {
            this.f56353a.k("currentRetryData", (JumioRetryReason) obj);
            JumioRetryReason i12 = i();
            Integer valueOf = i12 != null ? Integer.valueOf(i12.getCode()) : null;
            a("retry reason: " + valueOf);
            JumioRetryReason i13 = i();
            String message = i13 != null ? i13.getMessage() : null;
            a("retry message: " + message);
        } else if (i11 == 2) {
            this.f56353a.k("currentRejectData", (Map) obj);
            Map<JumioCredentialPart, String> h11 = h();
            if (h11 != null) {
                for (Map.Entry next : h11.entrySet()) {
                    String name2 = ((JumioCredentialPart) next.getKey()).name();
                    Object value = next.getValue();
                    a("reject reason: " + name2 + " -> " + value);
                }
            }
        } else if (i11 == 3 || i11 == 4) {
            JumioCredentialPart jumioCredentialPart = obj instanceof JumioCredentialPart ? (JumioCredentialPart) obj : null;
            if (jumioCredentialPart != null) {
                this.f56353a.k("currentCredentialSubPart", jumioCredentialPart);
            }
        }
        this.f56362j.setValue(jumioScanStep);
        if (this.f56361i.getValue() == C0659b.SCAN) {
            if (jumioScanStep == JumioScanStep.CONFIRMATION_VIEW) {
                this.f56361i.setValue(C0659b.CONFIRMATION);
            } else if (jumioScanStep == JumioScanStep.REJECT_VIEW) {
                JumioCredential jumioCredential = this.f56358f;
                if (jumioCredential instanceof JumioIDCredential) {
                    this.f56361i.setValue(C0659b.REJECT);
                } else if (jumioCredential instanceof JumioFaceCredential) {
                    this.f56361i.setValue(C0659b.FACE_HELP);
                }
            }
        }
        if (c.f56385c[jumioScanStep.ordinal()] != 5) {
            return;
        }
        if (this.f56358f instanceof JumioIDCredential) {
            this.f56354b.sendEmptyMessageDelayed(1000, com.sumsub.sns.internal.ml.autocapture.a.f34923p);
            return;
        }
        try {
            c();
            JumioCredential jumioCredential2 = this.f56358f;
            if (jumioCredential2 != null) {
                jumioScanPart = jumioCredential2.getAddonPart();
            }
            a(jumioScanPart);
            if (j() != null) {
                this.f56361i.setValue(C0659b.NFC);
            } else {
                b();
            }
        } catch (SDKNotConfiguredException e11) {
            Log.w("JumioViewModel", (Throwable) e11);
        } catch (IllegalArgumentException e12) {
            Log.w("JumioViewModel", (Throwable) e12);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v3, resolved type: com.jumio.sdk.enums.JumioFallbackReason} */
    /* JADX WARNING: type inference failed for: r1v2 */
    /* JADX WARNING: type inference failed for: r1v6, types: [java.lang.Number] */
    /* JADX WARNING: type inference failed for: r1v10 */
    /* JADX WARNING: type inference failed for: r1v11 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onUpdate(com.jumio.sdk.enums.JumioScanUpdate r4, java.lang.Object r5) {
        /*
            r3 = this;
            java.lang.String r0 = r4.name()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "onJumioUpdateType: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            a((java.lang.String) r0)
            int[] r0 = jumio.dui.b.c.f56384b
            int r1 = r4.ordinal()
            r0 = r0[r1]
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L_0x0046
            r2 = 2
            if (r0 == r2) goto L_0x0028
            goto L_0x004f
        L_0x0028:
            boolean r0 = r5 instanceof java.lang.Integer
            if (r0 == 0) goto L_0x002f
            r1 = r5
            java.lang.Integer r1 = (java.lang.Integer) r1
        L_0x002f:
            if (r1 == 0) goto L_0x004f
            r1.intValue()
            java.lang.Number r5 = (java.lang.Number) r5
            int r5 = r5.intValue()
            androidx.lifecycle.SavedStateHandle r0 = r3.f56353a
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            java.lang.String r1 = "nfcProgressPercentage"
            r0.k(r1, r5)
            goto L_0x004f
        L_0x0046:
            boolean r0 = r5 instanceof com.jumio.sdk.enums.JumioFallbackReason
            if (r0 == 0) goto L_0x004d
            r1 = r5
            com.jumio.sdk.enums.JumioFallbackReason r1 = (com.jumio.sdk.enums.JumioFallbackReason) r1
        L_0x004d:
            r3.f56360h = r1
        L_0x004f:
            androidx.lifecycle.MutableLiveData<kotlin.Pair<com.jumio.sdk.enums.JumioScanUpdate, com.jumio.sdk.enums.JumioCredentialPart>> r5 = r3.f56363k
            com.jumio.sdk.enums.JumioCredentialPart r0 = r3.e()
            kotlin.Pair r4 = kotlin.l.a(r4, r0)
            r5.setValue(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.dui.b.onUpdate(com.jumio.sdk.enums.JumioScanUpdate, java.lang.Object):void");
    }

    public final f<C0659b> p() {
        return this.f56361i;
    }

    public final void q() {
        this.f56353a.k("currentSelectionSkipped", Boolean.FALSE);
        JumioCredential jumioCredential = this.f56358f;
        boolean z11 = jumioCredential instanceof JumioIDCredential;
        if (z11) {
            JumioIDCredential jumioIDCredential = z11 ? (JumioIDCredential) jumioCredential : null;
            if (jumioIDCredential != null) {
                String suggestedCountry = jumioIDCredential.getSuggestedCountry();
                if (suggestedCountry != null) {
                    this.f56353a.k("currentlySelectedCountry", suggestedCountry);
                    this.f56361i.setValue(C0659b.SELECTION_DOCUMENT);
                } else if (jumioIDCredential.getSupportedCountries().size() == 1) {
                    b((String) CollectionsKt___CollectionsKt.a0(jumioIDCredential.getSupportedCountries()));
                    this.f56361i.setValue(C0659b.SELECTION_DOCUMENT);
                } else {
                    this.f56361i.setValue(C0659b.SELECTION_COUNTRY);
                }
            }
        } else {
            boolean z12 = jumioCredential instanceof JumioDocumentCredential;
            if (!z12) {
                ErrorCase errorCase = ErrorCase.PROCESS_CANT_BE_COMPLETED;
                onError(new JumioError(errorCase.getRetry(), errorCase.getDomain(), "N00002", getApplication().getString(errorCase.getMessage())));
            } else if (z12) {
                this.f56361i.setValue(C0659b.SELECTION_METHOD);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v34, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: com.jumio.sdk.enums.JumioCredentialPart} */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0009, code lost:
        r1 = r1.getCredentialParts();
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b() {
        /*
            r8 = this;
            com.jumio.sdk.enums.JumioCredentialPart r0 = r8.e()
            com.jumio.sdk.credentials.JumioCredential r1 = r8.f56358f
            r2 = 0
            if (r1 == 0) goto L_0x0016
            java.util.List r1 = r1.getCredentialParts()
            if (r1 == 0) goto L_0x0016
            java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.m0(r1)
            com.jumio.sdk.enums.JumioCredentialPart r1 = (com.jumio.sdk.enums.JumioCredentialPart) r1
            goto L_0x0017
        L_0x0016:
            r1 = r2
        L_0x0017:
            r3 = 1
            if (r0 != r1) goto L_0x011e
            com.jumio.sdk.credentials.JumioCredential r0 = r8.f56358f
            r1 = 0
            if (r0 == 0) goto L_0x0027
            boolean r0 = r0.isComplete()
            if (r0 != r3) goto L_0x0027
            r0 = r3
            goto L_0x0028
        L_0x0027:
            r0 = r1
        L_0x0028:
            if (r0 == 0) goto L_0x011e
            com.jumio.sdk.credentials.JumioCredential r0 = r8.f56358f
            if (r0 == 0) goto L_0x0031
            r0.finish()
        L_0x0031:
            androidx.lifecycle.SavedStateHandle r0 = r8.f56353a
            java.lang.String r4 = "currentCredentialInfo"
            java.lang.Object r0 = r0.f(r4)
            com.jumio.sdk.credentials.JumioCredentialInfo r0 = (com.jumio.sdk.credentials.JumioCredentialInfo) r0
            if (r0 == 0) goto L_0x0042
            java.lang.String r0 = r0.getId()
            goto L_0x0043
        L_0x0042:
            r0 = r2
        L_0x0043:
            java.util.List<com.jumio.sdk.credentials.JumioCredentialInfo> r5 = r8.f56357e
            java.lang.Object r5 = kotlin.collections.CollectionsKt___CollectionsKt.m0(r5)
            com.jumio.sdk.credentials.JumioCredentialInfo r5 = (com.jumio.sdk.credentials.JumioCredentialInfo) r5
            java.lang.String r5 = r5.getId()
            boolean r0 = kotlin.jvm.internal.x.b(r0, r5)
            if (r0 == 0) goto L_0x0067
            r8.f56358f = r2
            jumio.dui.f<jumio.dui.b$b> r0 = r8.f56361i
            jumio.dui.b$b r1 = jumio.dui.b.C0659b.UPLOAD
            r0.setValue(r1)
            com.jumio.sdk.controller.JumioController r0 = r8.f56356d
            if (r0 == 0) goto L_0x017b
            r0.finish()
            goto L_0x017b
        L_0x0067:
            java.util.List<com.jumio.sdk.credentials.JumioCredentialInfo> r0 = r8.f56357e
            java.util.Iterator r0 = r0.iterator()
            r5 = r1
        L_0x006e:
            boolean r6 = r0.hasNext()
            if (r6 == 0) goto L_0x0098
            java.lang.Object r6 = r0.next()
            com.jumio.sdk.credentials.JumioCredentialInfo r6 = (com.jumio.sdk.credentials.JumioCredentialInfo) r6
            java.lang.String r6 = r6.getId()
            androidx.lifecycle.SavedStateHandle r7 = r8.f56353a
            java.lang.Object r7 = r7.f(r4)
            com.jumio.sdk.credentials.JumioCredentialInfo r7 = (com.jumio.sdk.credentials.JumioCredentialInfo) r7
            if (r7 == 0) goto L_0x008d
            java.lang.String r7 = r7.getId()
            goto L_0x008e
        L_0x008d:
            r7 = r2
        L_0x008e:
            boolean r6 = kotlin.jvm.internal.x.b(r6, r7)
            if (r6 == 0) goto L_0x0095
            goto L_0x0099
        L_0x0095:
            int r5 = r5 + 1
            goto L_0x006e
        L_0x0098:
            r5 = -1
        L_0x0099:
            int r5 = r5 + r3
            java.util.List<com.jumio.sdk.credentials.JumioCredentialInfo> r0 = r8.f56357e
            java.lang.Object r0 = r0.get(r5)
            com.jumio.sdk.credentials.JumioCredentialInfo r0 = (com.jumio.sdk.credentials.JumioCredentialInfo) r0
            androidx.lifecycle.SavedStateHandle r5 = r8.f56353a
            r5.k(r4, r0)
            androidx.lifecycle.SavedStateHandle r0 = r8.f56353a
            java.lang.Object r0 = r0.f(r4)
            com.jumio.sdk.credentials.JumioCredentialInfo r0 = (com.jumio.sdk.credentials.JumioCredentialInfo) r0
            if (r0 == 0) goto L_0x00ba
            com.jumio.sdk.controller.JumioController r4 = r8.f56356d
            if (r4 == 0) goto L_0x00ba
            com.jumio.sdk.credentials.JumioCredential r0 = r4.start(r0)
            goto L_0x00bb
        L_0x00ba:
            r0 = r2
        L_0x00bb:
            r8.f56358f = r0
            if (r0 == 0) goto L_0x00c6
            boolean r0 = r0.isConfigured()
            if (r0 != r3) goto L_0x00c6
            r1 = r3
        L_0x00c6:
            if (r1 == 0) goto L_0x011a
            androidx.lifecycle.SavedStateHandle r0 = r8.f56353a
            java.lang.Boolean r1 = java.lang.Boolean.TRUE
            java.lang.String r4 = "currentSelectionSkipped"
            r0.k(r4, r1)
            com.jumio.sdk.credentials.JumioCredential r0 = r8.f56358f
            boolean r1 = r0 instanceof com.jumio.sdk.credentials.JumioIDCredential
            if (r1 == 0) goto L_0x00da
            com.jumio.sdk.credentials.JumioIDCredential r0 = (com.jumio.sdk.credentials.JumioIDCredential) r0
            goto L_0x00db
        L_0x00da:
            r0 = r2
        L_0x00db:
            if (r0 == 0) goto L_0x00fa
            java.util.List r1 = r0.getSupportedCountries()
            java.lang.Object r1 = kotlin.collections.CollectionsKt___CollectionsKt.a0(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.util.List r4 = r0.getPhysicalDocumentsForCountry(r1)
            int r5 = r4.size()
            if (r5 != r3) goto L_0x00fa
            java.lang.Object r3 = kotlin.collections.CollectionsKt___CollectionsKt.a0(r4)
            com.jumio.sdk.document.JumioDocument r3 = (com.jumio.sdk.document.JumioDocument) r3
            r8.a(r0, r1, r3)
        L_0x00fa:
            com.jumio.sdk.credentials.JumioCredential r0 = r8.f56358f
            if (r0 == 0) goto L_0x010b
            java.util.List r0 = r0.getCredentialParts()
            if (r0 == 0) goto L_0x010b
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.a0(r0)
            r2 = r0
            com.jumio.sdk.enums.JumioCredentialPart r2 = (com.jumio.sdk.enums.JumioCredentialPart) r2
        L_0x010b:
            androidx.lifecycle.SavedStateHandle r0 = r8.f56353a
            java.lang.String r1 = "currentCredentialPart"
            r0.k(r1, r2)
            com.jumio.sdk.enums.JumioCredentialPart r0 = r8.e()
            r8.a((com.jumio.sdk.enums.JumioCredentialPart) r0)
            goto L_0x017b
        L_0x011a:
            r8.q()
            goto L_0x017b
        L_0x011e:
            com.jumio.sdk.credentials.JumioCredential r0 = r8.f56358f
            if (r0 == 0) goto L_0x0136
            java.util.List r0 = r0.getCredentialParts()
            if (r0 == 0) goto L_0x0136
            com.jumio.sdk.enums.JumioCredentialPart r1 = r8.e()
            int r0 = kotlin.collections.CollectionsKt___CollectionsKt.f0(r0, r1)
            int r0 = r0 + r3
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            goto L_0x0137
        L_0x0136:
            r0 = r2
        L_0x0137:
            if (r0 == 0) goto L_0x017b
            com.jumio.sdk.credentials.JumioCredential r1 = r8.f56358f
            if (r1 == 0) goto L_0x0142
            java.util.List r1 = r1.getCredentialParts()
            goto L_0x0143
        L_0x0142:
            r1 = r2
        L_0x0143:
            if (r1 == 0) goto L_0x017b
            com.jumio.sdk.credentials.JumioCredential r1 = r8.f56358f
            if (r1 == 0) goto L_0x0158
            java.util.List r1 = r1.getCredentialParts()
            if (r1 == 0) goto L_0x0158
            int r1 = r1.size()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x0159
        L_0x0158:
            r1 = r2
        L_0x0159:
            int r1 = r1.intValue()
            int r3 = r0.intValue()
            if (r1 <= r3) goto L_0x017b
            com.jumio.sdk.credentials.JumioCredential r1 = r8.f56358f
            if (r1 == 0) goto L_0x0178
            java.util.List r1 = r1.getCredentialParts()
            if (r1 == 0) goto L_0x0178
            int r0 = r0.intValue()
            java.lang.Object r0 = r1.get(r0)
            r2 = r0
            com.jumio.sdk.enums.JumioCredentialPart r2 = (com.jumio.sdk.enums.JumioCredentialPart) r2
        L_0x0178:
            r8.a((com.jumio.sdk.enums.JumioCredentialPart) r2)
        L_0x017b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.dui.b.b():void");
    }

    public final void c() {
        synchronized (this.f56355c) {
            JumioScanPart j11 = j();
            if (j11 != null) {
                j11.finish();
            }
            a((JumioScanPart) null);
            Unit unit = Unit.f56620a;
        }
    }

    public final void a(JumioCredentialPart jumioCredentialPart) {
        if (jumioCredentialPart != null) {
            this.f56353a.k("currentCredentialPart", jumioCredentialPart);
            a();
            try {
                JumioCredential jumioCredential = this.f56358f;
                JumioScanMode jumioScanMode = null;
                a(jumioCredential != null ? jumioCredential.initScanPart(jumioCredentialPart, this) : null);
                JumioScanPart j11 = j();
                if (j11 != null) {
                    jumioScanMode = j11.getScanMode();
                }
                int i11 = jumioScanMode == null ? -1 : c.f56383a[jumioScanMode.ordinal()];
                if (i11 == 1 || i11 == 2) {
                    this.f56361i.setValue(C0659b.FACE_HELP);
                    return;
                }
                this.f56361i.setValue(C0659b.SCAN);
                JumioScanPart j12 = j();
                if (j12 != null) {
                    j12.start();
                }
            } catch (Exception e11) {
                Log.w("JumioViewModel", (Throwable) e11);
                ErrorCase errorCase = ErrorCase.PROCESS_CANT_BE_COMPLETED;
                onError(new JumioError(errorCase.getRetry(), errorCase.getDomain(), "N00001", getApplication().getString(errorCase.getMessage())));
            }
        }
    }

    public final void a(JumioDocumentType jumioDocumentType) {
        this.f56353a.k("selectedDocumentType", jumioDocumentType);
        this.f56361i.setValue(C0659b.SELECTION_VARIANT);
    }

    public static final Bundle a(b bVar) {
        Bundle bundle = new Bundle();
        JumioController jumioController = bVar.f56356d;
        if (jumioController != null) {
            jumioController.persist(bundle);
        }
        bundle.putSerializable("sdkStateEvent", bVar.f56361i.getValue());
        bundle.putSerializable("scanStepEvent", bVar.f56362j.getValue());
        bundle.putSerializable("scanUpdateEvent", bVar.f56363k.getValue());
        Boolean value = bVar.f56364l.getValue();
        if (value == null) {
            value = Boolean.FALSE;
        }
        bundle.putBoolean("helpViewVisible", value.booleanValue());
        Boolean value2 = bVar.f56365m.getValue();
        if (value2 == null) {
            value2 = Boolean.TRUE;
        }
        bundle.putBoolean("consumeHelpButtonClicks", value2.booleanValue());
        bundle.putSerializable("sdkResult", bVar.f56366n.getValue());
        bundle.putSerializable("error", bVar.f56367o.getValue());
        return bundle;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: com.jumio.sdk.enums.JumioCredentialPart} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(java.lang.String r4, com.jumio.sdk.document.JumioDocument r5) {
        /*
            r3 = this;
            if (r5 != 0) goto L_0x0003
            return
        L_0x0003:
            com.jumio.sdk.credentials.JumioCredential r0 = r3.f56358f
            boolean r1 = r0 instanceof com.jumio.sdk.credentials.JumioIDCredential
            r2 = 0
            if (r1 == 0) goto L_0x000d
            com.jumio.sdk.credentials.JumioIDCredential r0 = (com.jumio.sdk.credentials.JumioIDCredential) r0
            goto L_0x000e
        L_0x000d:
            r0 = r2
        L_0x000e:
            if (r0 != 0) goto L_0x0011
            return
        L_0x0011:
            r3.a(r0, r4, r5)
            com.jumio.sdk.credentials.JumioCredential r4 = r3.f56358f
            if (r4 == 0) goto L_0x0025
            java.util.List r4 = r4.getCredentialParts()
            if (r4 == 0) goto L_0x0025
            java.lang.Object r4 = kotlin.collections.CollectionsKt___CollectionsKt.a0(r4)
            r2 = r4
            com.jumio.sdk.enums.JumioCredentialPart r2 = (com.jumio.sdk.enums.JumioCredentialPart) r2
        L_0x0025:
            androidx.lifecycle.SavedStateHandle r4 = r3.f56353a
            java.lang.String r5 = "currentCredentialPart"
            r4.k(r5, r2)
            com.jumio.sdk.enums.JumioCredentialPart r4 = r3.e()
            r3.a((com.jumio.sdk.enums.JumioCredentialPart) r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.dui.b.a(java.lang.String, com.jumio.sdk.document.JumioDocument):void");
    }

    /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x0028 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a() {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f56355c
            monitor-enter(r0)
            android.os.Handler r1 = r4.f56354b     // Catch:{ SDKNotConfiguredException -> 0x0028 }
            r2 = 1000(0x3e8, float:1.401E-42)
            r1.removeMessages(r2)     // Catch:{ SDKNotConfiguredException -> 0x0028 }
            com.jumio.sdk.scanpart.JumioScanPart r1 = r4.j()     // Catch:{ SDKNotConfiguredException -> 0x0028 }
            if (r1 == 0) goto L_0x0013
            r1.cancel()     // Catch:{ SDKNotConfiguredException -> 0x0028 }
        L_0x0013:
            r1 = 0
            r4.a((com.jumio.sdk.scanpart.JumioScanPart) r1)     // Catch:{ SDKNotConfiguredException -> 0x0028 }
            androidx.lifecycle.SavedStateHandle r2 = r4.f56353a     // Catch:{ SDKNotConfiguredException -> 0x0028 }
            java.lang.String r3 = "currentRetryData"
            r2.k(r3, r1)     // Catch:{ SDKNotConfiguredException -> 0x0028 }
            androidx.lifecycle.SavedStateHandle r2 = r4.f56353a     // Catch:{ SDKNotConfiguredException -> 0x0028 }
            java.lang.String r3 = "currentRejectData"
            r2.k(r3, r1)     // Catch:{ SDKNotConfiguredException -> 0x0028 }
            goto L_0x0028
        L_0x0026:
            r1 = move-exception
            goto L_0x002c
        L_0x0028:
            kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0026 }
            monitor-exit(r0)
            return
        L_0x002c:
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.dui.b.a():void");
    }

    public final void a(JumioIDCredential jumioIDCredential, String str, JumioDocument jumioDocument) {
        jumioIDCredential.setConfiguration(str, jumioDocument);
        this.f56353a.k("currentDocument", jumioDocument);
        String k02 = CollectionsKt___CollectionsKt.k0(jumioIDCredential.getCredentialParts(), (CharSequence) null, (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, d.f56386a, 31, (Object) null);
        Log.d("JumioViewModel", "Credential parts " + k02);
    }

    public static void a(String str) {
        Log.i("JumioViewModel", "Received : " + str);
    }
}
