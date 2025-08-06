package com.jumio.core.api;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.jumio.ale.swig.ALECore;
import com.jumio.ale.swig.ALESettings;
import com.jumio.analytics.AnalyticsEvent;
import com.jumio.core.ServiceLocator;
import com.jumio.core.ServiceLocatorInterface;
import com.jumio.core.api.calls.AnalyticsCall;
import com.jumio.core.api.calls.DigitalIdentityOutcomeCall;
import com.jumio.core.api.calls.DigitalIdentityWebViewCall;
import com.jumio.core.api.calls.IproovTokenCall;
import com.jumio.core.api.calls.IproovValidateCall;
import com.jumio.core.api.calls.SettingsCall;
import com.jumio.core.api.calls.UploadCall;
import com.jumio.core.api.calls.UsabilityCall;
import com.jumio.core.enums.ErrorCase;
import com.jumio.core.enums.UploadType;
import com.jumio.core.environment.Environment;
import com.jumio.core.error.Error;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.models.AuthorizationModel;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.models.SettingsModel;
import com.jumio.core.models.TimeoutModel;
import com.jumio.core.network.ApiBinding;
import com.jumio.core.network.ApiCall;
import com.jumio.core.network.TrustManagerInterface;
import com.jumio.core.persistence.DataManager;
import com.jumio.sdk.credentials.JumioCredential;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.net.ssl.SSLException;
import jumio.core.d1;
import jumio.core.e;
import jumio.core.f1;
import jumio.core.h;
import jumio.core.i;
import jumio.core.j;
import jumio.core.k2;
import jumio.core.l;
import jumio.core.l1;
import jumio.core.r2;
import jumio.core.t2;
import jumio.core.y1;
import jumio.core.z1;
import kotlin.Unit;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class BackendManager implements h, i {
    public static final Companion Companion = new Companion((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final Context f39028a;

    /* renamed from: b  reason: collision with root package name */
    public final DataManager f39029b;

    /* renamed from: c  reason: collision with root package name */
    public final AuthorizationModel f39030c;

    /* renamed from: d  reason: collision with root package name */
    public final kotlin.i f39031d = LazyKt__LazyJVMKt.a(new b(this));

    /* renamed from: e  reason: collision with root package name */
    public final SingleProcessor f39032e = new SingleProcessor(Executors.newSingleThreadExecutor(), this, this);

    /* renamed from: f  reason: collision with root package name */
    public final QueueProcessor f39033f;

    /* renamed from: g  reason: collision with root package name */
    public final TimeoutModel f39034g;

    /* renamed from: h  reason: collision with root package name */
    public final Object f39035h;

    /* renamed from: i  reason: collision with root package name */
    public final HashMap<Class<?>, ApiBinding> f39036i;

    /* renamed from: j  reason: collision with root package name */
    public final l f39037j;

    /* renamed from: k  reason: collision with root package name */
    public final String f39038k;

    /* renamed from: l  reason: collision with root package name */
    public final String f39039l;

    /* renamed from: m  reason: collision with root package name */
    public final TrustManagerInterface f39040m;

    /* renamed from: n  reason: collision with root package name */
    public int f39041n;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final int requestCode$jumio_core_release(Class<?> cls) {
            if (x.b(cls, SettingsCall.class)) {
                return 1;
            }
            if (x.b(cls, f1.class)) {
                return 3;
            }
            if (x.b(cls, UploadCall.class)) {
                return 4;
            }
            if (x.b(cls, k2.class)) {
                return 5;
            }
            if (x.b(cls, l1.class)) {
                return 6;
            }
            if (x.b(cls, UsabilityCall.class)) {
                return 7;
            }
            if (x.b(cls, IproovTokenCall.class)) {
                return 8;
            }
            if (x.b(cls, IproovValidateCall.class)) {
                return 9;
            }
            if (x.b(cls, DigitalIdentityWebViewCall.class)) {
                return 10;
            }
            return x.b(cls, DigitalIdentityOutcomeCall.class) ? 11 : 0;
        }
    }

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f39042a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f39043b;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|5|6|7|8|9|10|11|12|13|14|15|16|17|19) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x003c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0045 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0021 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002a */
        static {
            /*
                com.jumio.core.data.ScanMode[] r0 = com.jumio.core.data.ScanMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.jumio.core.data.ScanMode r2 = com.jumio.core.data.ScanMode.JUMIO_LIVENESS     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                f39042a = r0
                com.jumio.sdk.enums.JumioCredentialPart[] r0 = com.jumio.sdk.enums.JumioCredentialPart.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.jumio.sdk.enums.JumioCredentialPart r2 = com.jumio.sdk.enums.JumioCredentialPart.FRONT     // Catch:{ NoSuchFieldError -> 0x0021 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0021 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0021 }
            L_0x0021:
                com.jumio.sdk.enums.JumioCredentialPart r1 = com.jumio.sdk.enums.JumioCredentialPart.NFC     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.jumio.sdk.enums.JumioCredentialPart r1 = com.jumio.sdk.enums.JumioCredentialPart.BACK     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.jumio.sdk.enums.JumioCredentialPart r1 = com.jumio.sdk.enums.JumioCredentialPart.FACE     // Catch:{ NoSuchFieldError -> 0x003c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003c }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003c }
            L_0x003c:
                com.jumio.sdk.enums.JumioCredentialPart r1 = com.jumio.sdk.enums.JumioCredentialPart.DOCUMENT     // Catch:{ NoSuchFieldError -> 0x0045 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0045 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0045 }
            L_0x0045:
                com.jumio.sdk.enums.JumioCredentialPart r1 = com.jumio.sdk.enums.JumioCredentialPart.DEVICE_RISK     // Catch:{ NoSuchFieldError -> 0x004e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004e }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004e }
            L_0x004e:
                f39043b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.api.BackendManager.a.<clinit>():void");
        }
    }

    public static final class b extends Lambda implements d10.a<r2> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ BackendManager f39044a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(BackendManager backendManager) {
            super(0);
            this.f39044a = backendManager;
        }

        /* renamed from: a */
        public final r2 invoke() {
            Environment environment = Environment.INSTANCE;
            if (!environment.loadAleLib(this.f39044a.getContext())) {
                return null;
            }
            String a11 = e.a(this.f39044a.f39037j.c());
            String str = environment.getDataDirectory(this.f39044a.getContext()).getAbsolutePath() + "/ale/";
            if (a11 != null) {
                str = str + a11 + "/";
            }
            File file = new File(str);
            if (!file.exists() && !file.mkdirs()) {
                return null;
            }
            ALESettings aLESettings = new ALESettings();
            BackendManager backendManager = this.f39044a;
            aLESettings.setKeyID(backendManager.f39037j.a());
            aLESettings.setPublicKey(backendManager.f39037j.b());
            aLESettings.setDirectory(str);
            return new r2(aLESettings);
        }
    }

    public /* synthetic */ class c extends FunctionReferenceImpl implements d10.a<Boolean> {
        public c(Object obj) {
            super(0, obj, BackendManager.class, "determineKeyPinning", "determineKeyPinning()Z", 0);
        }

        public final Object invoke() {
            return Boolean.valueOf(BackendManager.access$determineKeyPinning((BackendManager) this.receiver));
        }
    }

    public BackendManager(Context context, DataManager dataManager, AuthorizationModel authorizationModel, d10.l<? super d10.a<Unit>, Unit> lVar) {
        this.f39028a = context;
        this.f39029b = dataManager;
        this.f39030c = authorizationModel;
        this.f39033f = new QueueProcessor(Executors.newSingleThreadExecutor(), lVar, this, this);
        this.f39034g = (TimeoutModel) getDataManager().get(TimeoutModel.class);
        this.f39035h = new Object();
        this.f39036i = new HashMap<>();
        ServiceLocator serviceLocator = ServiceLocator.INSTANCE;
        l a11 = ((j) ServiceLocatorInterface.DefaultImpls.getServiceImplementation$default(serviceLocator, j.class, (d10.a) null, 2, (Object) null)).a(authorizationModel.getDataCenter());
        this.f39037j = a11;
        this.f39038k = a11.c();
        this.f39039l = "Netverify Android SDK 4.8.2 (6)";
        TrustManagerInterface trustManagerInterface = (TrustManagerInterface) ServiceLocatorInterface.DefaultImpls.getServiceImplementation$default(serviceLocator, TrustManagerInterface.class, (d10.a) null, 2, (Object) null);
        trustManagerInterface.setHostname(new URL(getHost()).getHost());
        trustManagerInterface.setKeyPinning(new c(this));
        this.f39040m = trustManagerInterface;
    }

    public static final boolean access$determineKeyPinning(BackendManager backendManager) {
        SettingsModel settingsModel = (SettingsModel) backendManager.getDataManager().get(SettingsModel.class);
        if (settingsModel.isLoaded()) {
            return settingsModel.getKeyPinningEnabled();
        }
        return backendManager.f39041n < 3;
    }

    public static /* synthetic */ void addRequest$jumio_core_release$default(BackendManager backendManager, ApiCallDataModel apiCallDataModel, boolean z11, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            z11 = true;
        }
        backendManager.addRequest$jumio_core_release(apiCallDataModel, z11);
    }

    public static /* synthetic */ void digitalIdentityWebView$default(BackendManager backendManager, String str, String str2, String str3, boolean z11, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str3 = "en-US";
        }
        if ((i11 & 8) != 0) {
            z11 = false;
        }
        backendManager.digitalIdentityWebView(str, str2, str3, z11);
    }

    public static /* synthetic */ void uploadRawData$default(BackendManager backendManager, JumioCredential jumioCredential, HashMap hashMap, String str, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            str = "";
        }
        backendManager.uploadRawData(jumioCredential, hashMap, str);
    }

    public final void addBinding(ApiBinding apiBinding) {
        synchronized (this.f39035h) {
            for (Class put : apiBinding.getBindingClasses()) {
                this.f39036i.put(put, apiBinding);
            }
            Unit unit = Unit.f56620a;
        }
    }

    public final void addRequest$jumio_core_release(ApiCallDataModel<?> apiCallDataModel, boolean z11) {
        if (!Environment.INSTANCE.loadAleLib(getContext())) {
            onError(apiCallDataModel, new Error(ErrorCase.OCR_LOADING_FAILED, 0, 0, 6, (r) null));
        } else if (z11) {
            this.f39033f.a(apiCallDataModel);
        } else {
            this.f39032e.a(apiCallDataModel);
        }
    }

    public final void analytics(List<AnalyticsEvent> list, long j11, long j12, boolean z11) {
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(AnalyticsCall.class);
        apiCallDataModel.setTimeout(this.f39034g.getAnalytics());
        apiCallDataModel.setFireAndForget(z11);
        apiCallDataModel.setIgnoreErrors(z11);
        apiCallDataModel.getData().put("DATA_EVENTS", new ArrayList(list));
        apiCallDataModel.getData().put("DATA_SERVER_TIME", Long.valueOf(j11));
        apiCallDataModel.getData().put("DATA_START_ELAPSED_MILLIS", Long.valueOf(j12));
        addRequest$jumio_core_release(apiCallDataModel, z11);
    }

    public final void cancelCall(boolean z11) {
        this.f39033f.a();
        if (z11) {
            QueueProcessor queueProcessor = this.f39033f;
            synchronized (queueProcessor.f39049e) {
                queueProcessor.f39048d.clear();
                Unit unit = Unit.f56620a;
            }
        }
    }

    public final void digitalIdentityOutcome(String str) {
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(DigitalIdentityOutcomeCall.class);
        apiCallDataModel.setTimeout(10000);
        apiCallDataModel.getData().put("DATA_JWT", str);
        addRequest$jumio_core_release$default(this, apiCallDataModel, false, 2, (Object) null);
    }

    public final void digitalIdentityWebView(String str, String str2, String str3, boolean z11) {
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(DigitalIdentityWebViewCall.class);
        apiCallDataModel.setTimeout(10000);
        apiCallDataModel.getData().put("DATA_JWT", str);
        apiCallDataModel.getData().put("DATA_DI_SUBTYPE", str2);
        apiCallDataModel.getData().put("DATA_LOCALE", str3);
        apiCallDataModel.getData().put("DATA_DARK_MODE", Boolean.valueOf(z11));
        addRequest$jumio_core_release$default(this, apiCallDataModel, false, 2, (Object) null);
    }

    public final Error errorFromThrowable(Throwable th2, Class<?> cls) {
        ErrorCase errorCase;
        if (th2 instanceof Error) {
            return (Error) th2;
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getContext().getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            errorCase = ErrorCase.DEVICE_IS_OFFLINE;
        } else {
            boolean z11 = th2 instanceof t2;
            if (z11 && ((t2) th2).f56325a == 401) {
                errorCase = ErrorCase.AUTH_FAILED;
            } else if (z11 && ((t2) th2).f56325a == 305) {
                errorCase = ErrorCase.ALE_KEY_NOT_VALID;
            } else if (z11 && ((t2) th2).f56325a == 412) {
                errorCase = ErrorCase.TRANSACTION_FINISHED;
            } else if (th2 instanceof SSLException) {
                errorCase = ErrorCase.CERTIFICATE_ERROR;
            } else if (!z11 || ((t2) th2).f56325a != 400 || !x.b(cls, l1.class)) {
                errorCase = ErrorCase.GENERAL_NETWORK_ERROR;
            } else {
                errorCase = ErrorCase.PROCESS_CANT_BE_COMPLETED;
            }
        }
        return new Error(errorCase, Companion.requestCode$jumio_core_release(cls), th2 instanceof t2 ? ((t2) th2).f56325a : 0);
    }

    public final void extractData() {
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(f1.class);
        apiCallDataModel.setTimeout(this.f39034g.getExtractdata());
        addRequest$jumio_core_release$default(this, apiCallDataModel, false, 2, (Object) null);
    }

    public final void finalizeCall() {
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(l1.class);
        apiCallDataModel.setTimeout(this.f39034g.getFinalize());
        addRequest$jumio_core_release$default(this, apiCallDataModel, false, 2, (Object) null);
    }

    public Context getContext() {
        return this.f39028a;
    }

    public DataManager getDataManager() {
        return this.f39029b;
    }

    public synchronized d1 getEncryptionProvider() {
        ALECore aLECore;
        aLECore = (ALECore) this.f39031d.getValue();
        return aLECore != null ? new jumio.core.c(aLECore, this.f39030c.getAuthorization()) : null;
    }

    public String getHost() {
        return this.f39038k;
    }

    public TrustManagerInterface getTrustManager() {
        return this.f39040m;
    }

    public String getUserAgent() {
        return this.f39039l;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0066, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onError(com.jumio.core.models.ApiCallDataModel<?> r5, java.lang.Throwable r6) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.f39035h
            monitor-enter(r0)
            java.lang.Class r1 = r5.getCall()     // Catch:{ all -> 0x0067 }
            java.lang.Class<com.jumio.core.api.calls.SettingsCall> r2 = com.jumio.core.api.calls.SettingsCall.class
            boolean r1 = kotlin.jvm.internal.x.b(r1, r2)     // Catch:{ all -> 0x0067 }
            r2 = 1
            if (r1 == 0) goto L_0x0022
            boolean r1 = r6 instanceof javax.net.ssl.SSLException     // Catch:{ all -> 0x0067 }
            if (r1 == 0) goto L_0x0022
            int r1 = r4.f39041n     // Catch:{ all -> 0x0067 }
            r3 = 3
            if (r1 >= r3) goto L_0x0022
            int r1 = r1 + r2
            r4.f39041n = r1     // Catch:{ all -> 0x0067 }
            com.jumio.core.api.QueueProcessor r1 = r4.f39033f     // Catch:{ all -> 0x0067 }
            r1.c()     // Catch:{ all -> 0x0067 }
            goto L_0x0023
        L_0x0022:
            r2 = 0
        L_0x0023:
            if (r2 == 0) goto L_0x0027
            monitor-exit(r0)
            return
        L_0x0027:
            java.util.HashMap<java.lang.Class<?>, com.jumio.core.network.ApiBinding> r1 = r4.f39036i     // Catch:{ all -> 0x0067 }
            java.lang.Class r2 = r5.getCall()     // Catch:{ all -> 0x0067 }
            boolean r1 = r1.containsKey(r2)     // Catch:{ all -> 0x0067 }
            if (r1 == 0) goto L_0x0047
            java.util.HashMap<java.lang.Class<?>, com.jumio.core.network.ApiBinding> r1 = r4.f39036i     // Catch:{ all -> 0x0067 }
            java.lang.Class r2 = r5.getCall()     // Catch:{ all -> 0x0067 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x0067 }
            com.jumio.core.network.ApiBinding r1 = (com.jumio.core.network.ApiBinding) r1     // Catch:{ all -> 0x0067 }
            if (r1 == 0) goto L_0x0065
            r1.onError(r5, r6)     // Catch:{ all -> 0x0067 }
            kotlin.Unit r5 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0067 }
            goto L_0x0065
        L_0x0047:
            java.lang.Class r5 = r5.getCall()     // Catch:{ all -> 0x0067 }
            java.lang.String r5 = r5.getSimpleName()     // Catch:{ all -> 0x0067 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0067 }
            r6.<init>()     // Catch:{ all -> 0x0067 }
            java.lang.String r1 = "No error binding for "
            r6.append(r1)     // Catch:{ all -> 0x0067 }
            r6.append(r5)     // Catch:{ all -> 0x0067 }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x0067 }
            com.jumio.commons.log.Log.e(r5)     // Catch:{ all -> 0x0067 }
            kotlin.Unit r5 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0067 }
        L_0x0065:
            monitor-exit(r0)
            return
        L_0x0067:
            r5 = move-exception
            monitor-exit(r0)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.api.BackendManager.onError(com.jumio.core.models.ApiCallDataModel, java.lang.Throwable):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:30:0x007c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onResult(com.jumio.core.models.ApiCallDataModel<?> r6, java.lang.Object r7) {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f39035h
            monitor-enter(r0)
            java.lang.Class r1 = r6.getCall()     // Catch:{ all -> 0x007d }
            java.lang.Class<com.jumio.core.api.calls.SettingsCall> r2 = com.jumio.core.api.calls.SettingsCall.class
            boolean r1 = kotlin.jvm.internal.x.b(r1, r2)     // Catch:{ all -> 0x007d }
            r2 = 0
            r3 = 1
            if (r1 == 0) goto L_0x0039
            boolean r1 = r7 instanceof org.json.JSONObject     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x0019
            r1 = r7
            org.json.JSONObject r1 = (org.json.JSONObject) r1     // Catch:{ all -> 0x007d }
            goto L_0x001a
        L_0x0019:
            r1 = 0
        L_0x001a:
            if (r1 == 0) goto L_0x0026
            java.lang.String r4 = "keyPinning"
            boolean r1 = r1.optBoolean(r4, r3)     // Catch:{ all -> 0x007d }
            if (r1 != r3) goto L_0x0026
            r1 = r3
            goto L_0x0027
        L_0x0026:
            r1 = r2
        L_0x0027:
            if (r1 == 0) goto L_0x0039
            int r1 = r5.f39041n     // Catch:{ all -> 0x007d }
            r4 = 3
            if (r1 < r4) goto L_0x0039
            javax.net.ssl.SSLException r1 = new javax.net.ssl.SSLException     // Catch:{ all -> 0x007d }
            java.lang.String r2 = "key pinning missmatch"
            r1.<init>(r2)     // Catch:{ all -> 0x007d }
            r5.onError(r6, r1)     // Catch:{ all -> 0x007d }
            r2 = r3
        L_0x0039:
            if (r2 == 0) goto L_0x003d
            monitor-exit(r0)
            return
        L_0x003d:
            java.util.HashMap<java.lang.Class<?>, com.jumio.core.network.ApiBinding> r1 = r5.f39036i     // Catch:{ all -> 0x007d }
            java.lang.Class r2 = r6.getCall()     // Catch:{ all -> 0x007d }
            boolean r1 = r1.containsKey(r2)     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x005d
            java.util.HashMap<java.lang.Class<?>, com.jumio.core.network.ApiBinding> r1 = r5.f39036i     // Catch:{ all -> 0x007d }
            java.lang.Class r2 = r6.getCall()     // Catch:{ all -> 0x007d }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x007d }
            com.jumio.core.network.ApiBinding r1 = (com.jumio.core.network.ApiBinding) r1     // Catch:{ all -> 0x007d }
            if (r1 == 0) goto L_0x007b
            r1.onResult(r6, r7)     // Catch:{ all -> 0x007d }
            kotlin.Unit r6 = kotlin.Unit.f56620a     // Catch:{ all -> 0x007d }
            goto L_0x007b
        L_0x005d:
            java.lang.Class r6 = r6.getCall()     // Catch:{ all -> 0x007d }
            java.lang.String r6 = r6.getSimpleName()     // Catch:{ all -> 0x007d }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x007d }
            r7.<init>()     // Catch:{ all -> 0x007d }
            java.lang.String r1 = "No result binding for "
            r7.append(r1)     // Catch:{ all -> 0x007d }
            r7.append(r6)     // Catch:{ all -> 0x007d }
            java.lang.String r6 = r7.toString()     // Catch:{ all -> 0x007d }
            com.jumio.commons.log.Log.w(r6)     // Catch:{ all -> 0x007d }
            kotlin.Unit r6 = kotlin.Unit.f56620a     // Catch:{ all -> 0x007d }
        L_0x007b:
            monitor-exit(r0)
            return
        L_0x007d:
            r6 = move-exception
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.api.BackendManager.onResult(com.jumio.core.models.ApiCallDataModel, java.lang.Object):void");
    }

    public final void persist(y1 y1Var, boolean z11) {
        if (z11) {
            synchronized (this.f39035h) {
                this.f39036i.clear();
                Unit unit = Unit.f56620a;
            }
        }
        SingleProcessor singleProcessor = this.f39032e;
        singleProcessor.getClass();
        ApiCallDataModel<?> apiCallDataModel = null;
        if (z11) {
            try {
                ApiCall<?> apiCall = singleProcessor.f39056d;
                if (apiCall != null) {
                    apiCall.removeAllSubscriber();
                }
                Future<ApiCall<?>> future = singleProcessor.f39057e;
                if (future != null) {
                    future.cancel(true);
                }
            } catch (Exception unused) {
            } catch (Throwable th2) {
                singleProcessor.f39057e = null;
                throw th2;
            }
            singleProcessor.f39057e = null;
            ApiCall<?> apiCall2 = singleProcessor.f39056d;
            if (apiCall2 != null) {
                apiCallDataModel = apiCall2.getApiCallDataModel();
            }
        }
        y1Var.a(apiCallDataModel);
        this.f39033f.a(y1Var, z11);
    }

    public final void remove(Class<? extends ApiCall<?>> cls) {
        QueueProcessor queueProcessor = this.f39033f;
        queueProcessor.getClass();
        synchronized (queueProcessor.f39049e) {
            Iterator<ApiCallDataModel<?>> it2 = queueProcessor.f39048d.iterator();
            while (it2.hasNext()) {
                ApiCallDataModel next = it2.next();
                if (x.b(next.getCall(), cls)) {
                    queueProcessor.f39048d.remove(next);
                }
            }
            Unit unit = Unit.f56620a;
        }
    }

    public final void removeBinding(ApiBinding apiBinding) {
        synchronized (this.f39035h) {
            for (Class remove : apiBinding.getBindingClasses()) {
                this.f39036i.remove(remove);
            }
            Unit unit = Unit.f56620a;
        }
    }

    public final void reporting(List<AnalyticsEvent> list, long j11, long j12, boolean z11) {
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(k2.class);
        apiCallDataModel.setFireAndForget(z11);
        apiCallDataModel.setTimeout(this.f39034g.getReporting());
        apiCallDataModel.setIgnoreErrors(z11);
        apiCallDataModel.getData().put("DATA_EVENTS", new ArrayList(list));
        apiCallDataModel.getData().put("DATA_SERVER_TIME", Long.valueOf(j11));
        apiCallDataModel.getData().put("DATA_START_ELAPSED_MILLIS", Long.valueOf(j12));
        addRequest$jumio_core_release$default(this, apiCallDataModel, false, 2, (Object) null);
    }

    public final void requestIproovToken() {
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(IproovTokenCall.class);
        apiCallDataModel.setTimeout(this.f39034g.getIproovtoken());
        addRequest$jumio_core_release$default(this, apiCallDataModel, false, 2, (Object) null);
    }

    public final void restore(z1 z1Var) {
        SingleProcessor singleProcessor = this.f39032e;
        singleProcessor.getClass();
        ApiCallDataModel apiCallDataModel = (ApiCallDataModel) z1Var.a();
        if (apiCallDataModel != null) {
            singleProcessor.a(apiCallDataModel);
        }
        QueueProcessor queueProcessor = this.f39033f;
        queueProcessor.getClass();
        synchronized (queueProcessor.f39049e) {
            ConcurrentLinkedQueue concurrentLinkedQueue = (ConcurrentLinkedQueue) z1Var.a();
            if (concurrentLinkedQueue != null) {
                queueProcessor.f39048d.addAll(concurrentLinkedQueue);
            }
        }
    }

    public final void retry() {
        this.f39033f.b();
    }

    public final void settings(List<String> list) {
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(SettingsCall.class);
        apiCallDataModel.setTimeout(10000);
        apiCallDataModel.getData().put("DATA_AVAILABLE_PLUGIN_NAMES", list.toArray(new String[0]));
        addRequest$jumio_core_release$default(this, apiCallDataModel, false, 2, (Object) null);
    }

    public final void uploadPart(JumioCredential jumioCredential, ScanPartModel scanPartModel) {
        UploadType uploadType;
        switch (a.f39043b[scanPartModel.getCredentialPart().ordinal()]) {
            case 1:
                uploadType = UploadType.FRONTSIDE;
                break;
            case 2:
                uploadType = UploadType.FACE;
                break;
            case 3:
                uploadType = UploadType.BACKSIDE;
                break;
            case 4:
                if (a.f39042a[scanPartModel.getMode().ordinal()] != 1) {
                    uploadType = UploadType.FACE;
                    break;
                } else {
                    uploadType = UploadType.JUMIO_LIVENESS;
                    break;
                }
            case 5:
                uploadType = UploadType.DOCUMENT;
                break;
            case 6:
                uploadType = UploadType.DEVICE_RISK;
                break;
            default:
                uploadType = UploadType.FRONTSIDE;
                break;
        }
        uploadRawData(jumioCredential, MapsKt__MapsKt.j(kotlin.l.a(uploadType, scanPartModel)), scanPartModel.getId());
    }

    public final void uploadRawData(JumioCredential jumioCredential, HashMap<UploadType, Object> hashMap, String str) {
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(UploadCall.class);
        apiCallDataModel.setTimeout(this.f39034g.getUpload());
        apiCallDataModel.setScanPartId(str);
        apiCallDataModel.getData().put(UploadCall.DATA_CREDENTIAL_ID, jumioCredential.getData$jumio_core_release().f56143a);
        apiCallDataModel.getData().put(UploadCall.DATA_PARTS, hashMap);
        addRequest$jumio_core_release$default(this, apiCallDataModel, false, 2, (Object) null);
    }

    public final void usability(String str, String str2) {
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(UsabilityCall.class);
        apiCallDataModel.setScanPartId(str2);
        apiCallDataModel.setTimeout(this.f39034g.getUsability());
        apiCallDataModel.getData().put("DATA_RESULT_KEY", str);
        addRequest$jumio_core_release$default(this, apiCallDataModel, false, 2, (Object) null);
    }

    public final void validateIproovToken() {
        ApiCallDataModel apiCallDataModel = new ApiCallDataModel(IproovValidateCall.class);
        apiCallDataModel.setTimeout(this.f39034g.getIproovvalidate());
        addRequest$jumio_core_release$default(this, apiCallDataModel, false, 2, (Object) null);
    }
}
