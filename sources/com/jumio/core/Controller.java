package com.jumio.core;

import android.content.Context;
import android.os.Bundle;
import com.google.android.exoplayer2.audio.SilenceSkippingAudioProcessor;
import com.jumio.analytics.Analytics;
import com.jumio.analytics.MetaInfo;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.enums.Rotation;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.LogUtils;
import com.jumio.commons.utils.DeviceRotationManager;
import com.jumio.commons.utils.FileUtil;
import com.jumio.core.ServiceLocatorInterface;
import com.jumio.core.api.BackendManager;
import com.jumio.core.api.calls.SettingsCall;
import com.jumio.core.cdn.CDNFeatureModel;
import com.jumio.core.data.document.DefaultCountryDocumentProvider;
import com.jumio.core.enums.ErrorCase;
import com.jumio.core.environment.Environment;
import com.jumio.core.error.Error;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.models.AuthorizationModel;
import com.jumio.core.models.ConsentModel;
import com.jumio.core.models.CountryDocumentModel;
import com.jumio.core.models.CredentialsModel;
import com.jumio.core.models.DataDogModel;
import com.jumio.core.models.DeviceRiskTokenDataModel;
import com.jumio.core.models.DocfinderSettingsModel;
import com.jumio.core.models.DocumentModel;
import com.jumio.core.models.InitiateModel;
import com.jumio.core.models.IproovTokenModel;
import com.jumio.core.models.LivenessSettingsModel;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.models.SettingsModel;
import com.jumio.core.models.TimeoutModel;
import com.jumio.core.network.ApiBinding;
import com.jumio.core.persistence.DataManager;
import com.jumio.core.plugins.AnalyticsPlugin;
import com.jumio.core.plugins.ExtractionPlugin;
import com.jumio.core.plugins.ScanPartPlugin;
import com.jumio.core.util.DataDogHelper;
import com.jumio.core.util.DataPointsUtil;
import com.jumio.core.util.ReflectionUtil;
import com.jumio.sdk.JumioSDK;
import com.jumio.sdk.consent.JumioConsentItem;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.credentials.JumioCredentialCategory;
import com.jumio.sdk.credentials.JumioCredentialInfo;
import com.jumio.sdk.enums.JumioCredentialPart;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.error.JumioError;
import com.jumio.sdk.exceptions.SDKNotConfiguredException;
import com.jumio.sdk.interfaces.JumioControllerInterface;
import com.jumio.sdk.interfaces.JumioScanPartInterface;
import com.jumio.sdk.result.JumioCredentialResult;
import com.jumio.sdk.result.JumioImageData;
import com.jumio.sdk.result.JumioResult;
import com.jumio.sdk.scanpart.JumioScanPart;
import d10.l;
import d10.p;
import java.io.File;
import java.lang.Thread;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import jumio.core.c0;
import jumio.core.d2;
import jumio.core.e1;
import jumio.core.e2;
import jumio.core.f1;
import jumio.core.k2;
import jumio.core.l1;
import jumio.core.l2;
import jumio.core.q1;
import jumio.core.y;
import jumio.core.z;
import jumio.core.z1;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;
import org.json.JSONArray;
import org.json.JSONObject;

public final class Controller implements ApiBinding {

    /* renamed from: a  reason: collision with root package name */
    public AuthorizationModel f38986a;

    /* renamed from: b  reason: collision with root package name */
    public MobileContext f38987b;

    /* renamed from: c  reason: collision with root package name */
    public final DeviceRotationManager f38988c;

    /* renamed from: d  reason: collision with root package name */
    public final DataManager f38989d;

    /* renamed from: e  reason: collision with root package name */
    public final BackendManager f38990e;

    /* renamed from: f  reason: collision with root package name */
    public final e2 f38991f;

    /* renamed from: g  reason: collision with root package name */
    public final Analytics f38992g;

    /* renamed from: h  reason: collision with root package name */
    public final h0 f38993h;

    /* renamed from: i  reason: collision with root package name */
    public JumioControllerInterface f38994i;

    /* renamed from: j  reason: collision with root package name */
    public final JumioScanPartInterface f38995j;

    /* renamed from: k  reason: collision with root package name */
    public JumioError f38996k;

    /* renamed from: l  reason: collision with root package name */
    public JumioCredential f38997l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f38998m;

    public /* synthetic */ class a extends AdaptedFunctionReference implements l<d10.a<? extends Unit>, Unit> {
        public a(Object obj) {
            super(1, obj, Controller.class, "runOnMain", "runOnMain(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/Job;", 8);
        }

        public final Object invoke(Object obj) {
            Controller.access$runOnMain((Controller) this.receiver, (d10.a) obj);
            return Unit.f56620a;
        }
    }

    public /* synthetic */ class b extends AdaptedFunctionReference implements l<d10.a<? extends Unit>, Unit> {
        public b(Object obj) {
            super(1, obj, Controller.class, "runOnMain", "runOnMain(Lkotlin/jvm/functions/Function0;)Lkotlinx/coroutines/Job;", 8);
        }

        public final Object invoke(Object obj) {
            Controller.access$runOnMain((Controller) this.receiver, (d10.a) obj);
            return Unit.f56620a;
        }
    }

    public /* synthetic */ class c {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f38999a;

        /* renamed from: b  reason: collision with root package name */
        public static final /* synthetic */ int[] f39000b;

        /* JADX WARNING: Can't wrap try/catch for region: R(17:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|17|18|19|20|21|23) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0043 */
        static {
            /*
                com.jumio.core.data.ScanMode[] r0 = com.jumio.core.data.ScanMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.jumio.core.data.ScanMode r2 = com.jumio.core.data.ScanMode.FACE_IPROOV     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.jumio.core.data.ScanMode r3 = com.jumio.core.data.ScanMode.FACE_MANUAL     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.jumio.core.data.ScanMode r4 = com.jumio.core.data.ScanMode.JUMIO_LIVENESS     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                f38999a = r0
                com.jumio.sdk.credentials.JumioCredentialCategory[] r0 = com.jumio.sdk.credentials.JumioCredentialCategory.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.jumio.sdk.credentials.JumioCredentialCategory r4 = com.jumio.sdk.credentials.JumioCredentialCategory.ID     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.jumio.sdk.credentials.JumioCredentialCategory r1 = com.jumio.sdk.credentials.JumioCredentialCategory.FACE     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                com.jumio.sdk.credentials.JumioCredentialCategory r1 = com.jumio.sdk.credentials.JumioCredentialCategory.DOCUMENT     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                com.jumio.sdk.credentials.JumioCredentialCategory r1 = com.jumio.sdk.credentials.JumioCredentialCategory.DATA     // Catch:{ NoSuchFieldError -> 0x004c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004c }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004c }
            L_0x004c:
                f39000b = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.Controller.c.<clinit>():void");
        }
    }

    public static final class d extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Controller f39001a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JumioResult f39002b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(Controller controller, JumioResult jumioResult) {
            super(0);
            this.f39001a = controller;
            this.f39002b = jumioResult;
        }

        public final Object invoke() {
            JumioControllerInterface access$getControllerInterface$p = this.f39001a.f38994i;
            if (access$getControllerInterface$p != null) {
                access$getControllerInterface$p.onFinished(this.f39002b);
            }
            return Unit.f56620a;
        }
    }

    public static final class e extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Controller f39003a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ List<JumioConsentItem> f39004b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(Controller controller, List<JumioConsentItem> list) {
            super(0);
            this.f39003a = controller;
            this.f39004b = list;
        }

        public final Object invoke() {
            JumioControllerInterface access$getControllerInterface$p = this.f39003a.f38994i;
            if (access$getControllerInterface$p != null) {
                access$getControllerInterface$p.onInitialized(((CredentialsModel) this.f39003a.getDataManager().get(CredentialsModel.class)).c(), this.f39004b);
            }
            return Unit.f56620a;
        }
    }

    public static final class f extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Controller f39005a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JumioError f39006b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Controller controller, JumioError jumioError) {
            super(0);
            this.f39005a = controller;
            this.f39006b = jumioError;
        }

        public final Object invoke() {
            JumioControllerInterface access$getControllerInterface$p = this.f39005a.f38994i;
            if (access$getControllerInterface$p != null) {
                access$getControllerInterface$p.onError(this.f39006b);
            }
            return Unit.f56620a;
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.jumio.core.Controller$onResult$1", f = "Controller.kt", l = {575}, m = "invokeSuspend")
    public static final class g extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f39007a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Controller f39008b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Object f39009c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(Controller controller, Object obj, kotlin.coroutines.c<? super g> cVar) {
            super(2, cVar);
            this.f39008b = controller;
            this.f39009c = obj;
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new g(this.f39008b, this.f39009c, cVar);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((g) create((h0) obj, (kotlin.coroutines.c) obj2)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f39007a;
            if (i11 == 0) {
                k.b(obj);
                Controller controller = this.f39008b;
                Object obj2 = this.f39009c;
                this.f39007a = 1;
                if (Controller.access$onSettingsCallResult(controller, obj2, this) == d11) {
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

    public static final class h extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Controller f39010a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ JumioResult f39011b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(Controller controller, JumioResult jumioResult) {
            super(0);
            this.f39010a = controller;
            this.f39011b = jumioResult;
        }

        public final Object invoke() {
            JumioControllerInterface access$getControllerInterface$p = this.f39010a.f38994i;
            if (access$getControllerInterface$p != null) {
                access$getControllerInterface$p.onFinished(this.f39011b);
            }
            return Unit.f56620a;
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Controller(Context context, AuthorizationModel authorizationModel, JumioControllerInterface jumioControllerInterface, int i11, int i12, r rVar) {
        this(context, authorizationModel, jumioControllerInterface, (i12 & 8) != 0 ? 0 : i11);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v10, resolved type: com.jumio.sdk.result.JumioFaceResult} */
    /* JADX WARNING: type inference failed for: r8v1 */
    /* JADX WARNING: type inference failed for: r8v2, types: [com.jumio.sdk.result.JumioIDResult] */
    /* JADX WARNING: type inference failed for: r8v14, types: [com.jumio.sdk.result.JumioCredentialResult] */
    /* JADX WARNING: type inference failed for: r8v16, types: [com.jumio.sdk.result.JumioCredentialResult] */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.jumio.sdk.result.JumioCredentialResult a(java.util.HashMap r7, jumio.core.c0 r8) {
        /*
            java.lang.String r0 = r8.f56143a
            java.lang.Object r1 = r7.get(r0)
            if (r1 != 0) goto L_0x0081
            com.jumio.sdk.credentials.JumioCredentialCategory r1 = r8.f56144b
            int[] r2 = com.jumio.core.Controller.c.f39000b
            int r1 = r1.ordinal()
            r1 = r2[r1]
            r2 = 1
            if (r1 == r2) goto L_0x0078
            r3 = 3
            r4 = 2
            if (r1 == r4) goto L_0x0030
            if (r1 == r3) goto L_0x002a
            r8 = 4
            if (r1 != r8) goto L_0x0024
            com.jumio.sdk.result.JumioCredentialResult r8 = new com.jumio.sdk.result.JumioCredentialResult
            r8.<init>()
            goto L_0x007d
        L_0x0024:
            kotlin.NoWhenBranchMatchedException r7 = new kotlin.NoWhenBranchMatchedException
            r7.<init>()
            throw r7
        L_0x002a:
            com.jumio.sdk.result.JumioCredentialResult r8 = new com.jumio.sdk.result.JumioCredentialResult
            r8.<init>()
            goto L_0x007d
        L_0x0030:
            com.jumio.sdk.result.JumioFaceResult r1 = new com.jumio.sdk.result.JumioFaceResult
            r1.<init>()
            java.util.SortedMap<com.jumio.sdk.enums.JumioCredentialPart, com.jumio.core.models.ScanPartModel> r8 = r8.f56147e
            com.jumio.sdk.enums.JumioCredentialPart r5 = com.jumio.sdk.enums.JumioCredentialPart.FACE
            java.lang.Object r8 = r8.get(r5)
            boolean r5 = r8 instanceof com.jumio.core.models.FaceScanPartModel
            r6 = 0
            if (r5 == 0) goto L_0x0045
            com.jumio.core.models.FaceScanPartModel r8 = (com.jumio.core.models.FaceScanPartModel) r8
            goto L_0x0046
        L_0x0045:
            r8 = r6
        L_0x0046:
            if (r8 == 0) goto L_0x007e
            com.jumio.core.extraction.liveness.extraction.LivenessDataModel r8 = r8.getLivenessData()
            if (r8 == 0) goto L_0x007e
            java.lang.Boolean r5 = r8.isPassed()
            r1.setPassed(r5)
            com.jumio.core.data.ScanMode r8 = r8.getType()
            if (r8 != 0) goto L_0x005d
            r8 = -1
            goto L_0x0065
        L_0x005d:
            int[] r5 = com.jumio.core.Controller.c.f38999a
            int r8 = r8.ordinal()
            r8 = r5[r8]
        L_0x0065:
            if (r8 == r2) goto L_0x0072
            if (r8 == r4) goto L_0x006f
            if (r8 == r3) goto L_0x006c
            goto L_0x0074
        L_0x006c:
            com.jumio.sdk.enums.JumioScanMode r6 = com.jumio.sdk.enums.JumioScanMode.JUMIO_LIVENESS
            goto L_0x0074
        L_0x006f:
            com.jumio.sdk.enums.JumioScanMode r6 = com.jumio.sdk.enums.JumioScanMode.FACE_MANUAL
            goto L_0x0074
        L_0x0072:
            com.jumio.sdk.enums.JumioScanMode r6 = com.jumio.sdk.enums.JumioScanMode.FACE_IPROOV
        L_0x0074:
            r1.setExtractionMode(r6)
            goto L_0x007e
        L_0x0078:
            com.jumio.sdk.result.JumioIDResult r8 = new com.jumio.sdk.result.JumioIDResult
            r8.<init>()
        L_0x007d:
            r1 = r8
        L_0x007e:
            r7.put(r0, r1)
        L_0x0081:
            com.jumio.sdk.result.JumioCredentialResult r1 = (com.jumio.sdk.result.JumioCredentialResult) r1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.Controller.a(java.util.HashMap, jumio.core.c0):com.jumio.sdk.result.JumioCredentialResult");
    }

    public static final Object access$onSettingsCallResult(Controller controller, Object obj, kotlin.coroutines.c cVar) {
        controller.getClass();
        Object g11 = kotlinx.coroutines.g.g(v0.a(), new y(controller, obj, (kotlin.coroutines.c) null), cVar);
        return g11 == IntrinsicsKt__IntrinsicsKt.d() ? g11 : Unit.f56620a;
    }

    public static final n1 access$runOnMain(Controller controller, d10.a aVar) {
        return i.d(controller.f38993h, (CoroutineContext) null, (CoroutineStart) null, new z(aVar, (kotlin.coroutines.c<? super z>) null), 3, (Object) null);
    }

    public static final void access$setupCDNFeatures(Controller controller, JSONObject jSONObject) {
        JSONArray optJSONArray;
        controller.getClass();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("cdnEnc")) != null) {
            ((CDNFeatureModel) controller.f38989d.get(CDNFeatureModel.class)).setup(optJSONArray);
        }
    }

    public static final void access$setupConsent(Controller controller, JSONObject jSONObject) {
        controller.getClass();
        JSONArray optJSONArray = jSONObject.optJSONArray("consents");
        if (optJSONArray != null) {
            controller.f38989d.put(ConsentModel.class, ConsentModel.Companion.fromJson(optJSONArray));
        }
    }

    public static final void access$setupCountryDocuments(Controller controller, JSONObject jSONObject) {
        JSONArray optJSONArray;
        controller.getClass();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("supportedCountries")) != null) {
            controller.f38989d.put(CountryDocumentModel.class, new CountryDocumentModel(new DefaultCountryDocumentProvider(optJSONArray, CountryDocumentModel.Companion.checkForLocalization(controller.f38987b))));
        }
    }

    public static final void access$setupCredentials(Controller controller, JSONObject jSONObject) {
        CredentialsModel fromJson;
        T t11;
        T t12;
        T t13;
        ExtractionPlugin extractionPlugin;
        boolean z11;
        boolean z12;
        controller.getClass();
        JSONArray optJSONArray = jSONObject.optJSONArray("credentials");
        if (optJSONArray == null || (fromJson = CredentialsModel.f39258d.fromJson(optJSONArray)) == null) {
            throw new Exception("No credentials available");
        }
        controller.f38989d.put(CredentialsModel.class, fromJson);
        if (!fromJson.f39259a.isEmpty()) {
            Iterator<T> it2 = fromJson.f39259a.iterator();
            while (true) {
                t11 = null;
                if (!it2.hasNext()) {
                    t12 = null;
                    break;
                }
                t12 = it2.next();
                if (((c0) t12).f56144b == JumioCredentialCategory.ID) {
                    z12 = true;
                    continue;
                } else {
                    z12 = false;
                    continue;
                }
                if (z12) {
                    break;
                }
            }
            if (((c0) t12) != null) {
                ExtractionPlugin extractionPlugin2 = (ExtractionPlugin) controller.f38991f.a(d2.DOCFINDER);
                if (extractionPlugin2 != null) {
                    extractionPlugin2.preload(controller);
                }
                ScanPartPlugin scanPartPlugin = (ScanPartPlugin) controller.f38991f.a(d2.NFC);
                if (scanPartPlugin != null) {
                    scanPartPlugin.preload(controller);
                }
            }
            Iterator<T> it3 = fromJson.f39259a.iterator();
            while (true) {
                if (!it3.hasNext()) {
                    t13 = null;
                    break;
                }
                t13 = it3.next();
                if (((c0) t13).f56144b == JumioCredentialCategory.FACE) {
                    z11 = true;
                    continue;
                } else {
                    z11 = false;
                    continue;
                }
                if (z11) {
                    break;
                }
            }
            if (!(((c0) t13) == null || (extractionPlugin = (ExtractionPlugin) controller.f38991f.a(d2.JUMIO_LIVENESS)) == null)) {
                extractionPlugin.preload(controller);
            }
            Iterator<T> it4 = fromJson.f39259a.iterator();
            while (true) {
                if (!it4.hasNext()) {
                    break;
                }
                T next = it4.next();
                if (((c0) next).a(controller)) {
                    t11 = next;
                    break;
                }
            }
            if (t11 != null) {
                throw new Exception("Credential not supported");
            }
            return;
        }
        throw new Exception("No credentials available");
    }

    public static final void access$setupDataDog(Controller controller, JSONObject jSONObject, long j11) {
        JSONObject optJSONObject;
        controller.getClass();
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("dataDog")) != null) {
            controller.f38989d.put(DataDogModel.class, DataDogModel.Companion.fromJson(optJSONObject, j11));
        }
    }

    public static final void access$setupDeviceRisk(Controller controller, JSONObject jSONObject) {
        controller.getClass();
        JSONArray optJSONArray = jSONObject.optJSONArray("deviceRiskTokenData");
        if (optJSONArray != null) {
            controller.f38989d.put(DeviceRiskTokenDataModel.class, DeviceRiskTokenDataModel.Companion.fromJson(optJSONArray));
        }
    }

    public static final void access$setupDocfinderSettings(Controller controller, JSONObject jSONObject) {
        JSONObject optJSONObject;
        controller.getClass();
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("docFinder")) != null) {
            controller.f38989d.put(DocfinderSettingsModel.class, DocfinderSettingsModel.Companion.fromJson(optJSONObject));
        }
    }

    public static final void access$setupDocuments(Controller controller, JSONObject jSONObject) {
        JSONArray optJSONArray;
        controller.getClass();
        if (jSONObject != null && (optJSONArray = jSONObject.optJSONArray("supportedDocumentTypes")) != null) {
            controller.f38989d.put(DocumentModel.class, DocumentModel.f39304b.fromJson(optJSONArray));
        }
    }

    public static final void access$setupIproov(Controller controller, JSONObject jSONObject) {
        controller.getClass();
        JSONObject optJSONObject = jSONObject.optJSONObject("iproovTokenData");
        if (optJSONObject != null) {
            try {
                controller.f38989d.put(IproovTokenModel.class, IproovTokenModel.Companion.fromJson(optJSONObject));
            } catch (Exception e11) {
                Log.printStackTrace(e11);
            }
        }
    }

    public static final void access$setupLivenessSettings(Controller controller, JSONObject jSONObject) {
        JSONObject optJSONObject;
        controller.getClass();
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("jumioLiveness")) != null) {
            controller.f38989d.put(LivenessSettingsModel.class, LivenessSettingsModel.Companion.fromJson(optJSONObject));
        }
    }

    public static final void access$setupTimeouts(Controller controller, JSONObject jSONObject) {
        JSONObject optJSONObject;
        controller.getClass();
        if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("networkTimeouts")) != null) {
            controller.f38989d.put(TimeoutModel.class, TimeoutModel.Companion.fromJson(optJSONObject));
        }
    }

    public static /* synthetic */ void onError$default(Controller controller, Throwable th2, Class<Object> cls, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            cls = Object.class;
        }
        controller.onError(th2, (Class<?>) cls);
    }

    public final void b() {
        i0.e(this.f38993h, "Destruction", (Throwable) null, 2, (Object) null);
        ServiceLocator.INSTANCE.destroy();
        this.f38990e.removeBinding(this);
        this.f38988c.destroy();
        this.f38991f.a();
        this.f38994i = null;
        try {
            this.f38989d.removeAll();
        } catch (Exception e11) {
            Log.printStackTrace(e11);
        }
        try {
            File[] listFiles = new File(this.f38987b.getFilesDir(), "jumio").listFiles(new FileUtil.a());
            if (listFiles != null) {
                for (File file : listFiles) {
                    if (file.isFile() && !file.delete()) {
                        file.deleteOnExit();
                    }
                }
            }
        } catch (Exception e12) {
            Log.printStackTrace(e12);
        }
        Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
        if (defaultUncaughtExceptionHandler instanceof e1) {
            e1 e1Var = (e1) defaultUncaughtExceptionHandler;
            e1Var.getClass();
            if (Thread.getDefaultUncaughtExceptionHandler() == e1Var) {
                Thread.setDefaultUncaughtExceptionHandler(e1Var.f56182a);
            }
        }
        this.f38998m = false;
    }

    public final void cancel() throws SDKNotConfiguredException, IllegalArgumentException {
        JumioCredential jumioCredential = this.f38997l;
        if (jumioCredential != null) {
            jumioCredential.cancel();
        }
        InitiateModel initiateModel = (InitiateModel) this.f38989d.get(InitiateModel.class);
        String str = initiateModel.f39311b;
        String str2 = initiateModel.f39310a;
        JumioError jumioError = this.f38996k;
        if (jumioError == null) {
            jumioError = new Error(ErrorCase.CANCEL_TYPE_USER, 0, 0, 6, (r) null).getJumioError(this.f38987b);
        }
        n1 unused = i.d(this.f38993h, (CoroutineContext) null, (CoroutineStart) null, new z(new d(this, new JumioResult(str, str2, false, (List) null, (Map) null, jumioError, 24, (r) null)), (kotlin.coroutines.c<? super z>) null), 3, (Object) null);
        this.f38990e.cancelCall(true);
        reporting(true);
        try {
            DataPointsUtil.INSTANCE.increment(this.f38987b, DataPointsUtil.NUMBER_OF_CANCELS);
            Analytics.Companion.add(MobileEvents.lifecycle$default(q1.CANCELLED, (Object) null, 2, (Object) null));
        } catch (Exception e11) {
            Log.printStackTrace(e11);
        }
        try {
            this.f38992g.stop();
        } catch (Exception e12) {
            Log.printStackTrace(e12);
        }
        b();
    }

    public final void finish() throws IllegalArgumentException {
        if (isComplete()) {
            reporting(false);
            this.f38990e.finalizeCall();
            return;
        }
        throw new IllegalArgumentException("Workflow is not completed".toString());
    }

    public final synchronized void finishCredential$jumio_core_release(JumioCredential jumioCredential) {
        if (jumioCredential == this.f38997l) {
            this.f38997l = null;
        }
    }

    public final JumioCredential getActiveCredential$jumio_core_release() {
        return this.f38997l;
    }

    public final Analytics getAnalytics() {
        return this.f38992g;
    }

    public final AuthorizationModel getAuthorizationModel() {
        return this.f38986a;
    }

    public final BackendManager getBackendManager() {
        return this.f38990e;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<? extends com.jumio.core.network.ApiCall<?>>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Class<? extends com.jumio.core.network.ApiCall<?>>[] getBindingClasses() {
        /*
            r3 = this;
            r0 = 4
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<jumio.core.f1> r2 = jumio.core.f1.class
            r0[r1] = r2
            r1 = 1
            java.lang.Class<jumio.core.l1> r2 = jumio.core.l1.class
            r0[r1] = r2
            r1 = 2
            java.lang.Class<jumio.core.k2> r2 = jumio.core.k2.class
            r0[r1] = r2
            r1 = 3
            java.lang.Class<com.jumio.core.api.calls.SettingsCall> r2 = com.jumio.core.api.calls.SettingsCall.class
            r0[r1] = r2
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.Controller.getBindingClasses():java.lang.Class[]");
    }

    public final MobileContext getContext() {
        return this.f38987b;
    }

    public final DataManager getDataManager() {
        return this.f38989d;
    }

    public final h0 getMainScope() {
        return this.f38993h;
    }

    public final e2 getPluginRegistry() {
        return this.f38991f;
    }

    public final DeviceRotationManager getRotationManager() {
        return this.f38988c;
    }

    public final List<JumioConsentItem> getUnconsentedItems() {
        return ((ConsentModel) this.f38989d.get(ConsentModel.class)).getNonConsentedItems();
    }

    public final boolean isActive$jumio_core_release() {
        return this.f38998m;
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0046  */
    /* JADX WARNING: Removed duplicated region for block: B:24:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isComplete() {
        /*
            r4 = this;
            com.jumio.sdk.credentials.JumioCredential r0 = r4.f38997l
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0047
            com.jumio.core.persistence.DataManager r0 = r4.f38989d
            java.lang.Class<com.jumio.core.models.CredentialsModel> r3 = com.jumio.core.models.CredentialsModel.class
            java.io.Serializable r0 = r0.get(r3)
            com.jumio.core.models.CredentialsModel r0 = (com.jumio.core.models.CredentialsModel) r0
            java.util.List<jumio.core.c0> r3 = r0.f39259a
            boolean r3 = r3.isEmpty()
            r3 = r3 ^ r2
            if (r3 == 0) goto L_0x0043
            java.util.List<jumio.core.c0> r0 = r0.f39259a
            boolean r3 = r0 instanceof java.util.Collection
            if (r3 == 0) goto L_0x0026
            boolean r3 = r0.isEmpty()
            if (r3 == 0) goto L_0x0026
            goto L_0x003e
        L_0x0026:
            java.util.Iterator r0 = r0.iterator()
        L_0x002a:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x003e
            java.lang.Object r3 = r0.next()
            jumio.core.c0 r3 = (jumio.core.c0) r3
            boolean r3 = r3.c()
            if (r3 != 0) goto L_0x002a
            r0 = r1
            goto L_0x003f
        L_0x003e:
            r0 = r2
        L_0x003f:
            if (r0 == 0) goto L_0x0043
            r0 = r2
            goto L_0x0044
        L_0x0043:
            r0 = r1
        L_0x0044:
            if (r0 == 0) goto L_0x0047
            r1 = r2
        L_0x0047:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.Controller.isComplete():boolean");
    }

    public final void onError(Throwable th2, Class<?> cls) {
        Error errorFromThrowable = this.f38990e.errorFromThrowable(th2, cls);
        Analytics.Companion.add(MobileEvents.lifecycle(q1.ERROR, errorFromThrowable));
        JumioError jumioError = errorFromThrowable.getJumioError(this.f38987b);
        n1 unused = i.d(this.f38993h, (CoroutineContext) null, (CoroutineStart) null, new z(new f(this, jumioError), (kotlin.coroutines.c<? super z>) null), 3, (Object) null);
        this.f38996k = jumioError;
    }

    public void onResult(ApiCallDataModel<?> apiCallDataModel, Object obj) {
        Class<?> call = apiCallDataModel.getCall();
        if (x.b(call, SettingsCall.class)) {
            n1 unused = i.d(this.f38993h, (CoroutineContext) null, (CoroutineStart) null, new g(this, obj, (kotlin.coroutines.c<? super g>) null), 3, (Object) null);
        } else if (x.b(call, k2.class)) {
        } else {
            if (x.b(call, l1.class)) {
                if (((JSONObject) obj).optBoolean("extractDataExecuted", false)) {
                    this.f38990e.extractData();
                } else {
                    a((HashMap<String, JumioCredentialResult>) new HashMap());
                }
            } else if (x.b(call, f1.class)) {
                a((HashMap<String, JumioCredentialResult>) (HashMap) obj);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0056, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        kotlin.io.b.a(r6, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x005a, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void persistAllData(boolean r6) {
        /*
            r5 = this;
            jumio.core.y1 r0 = new jumio.core.y1
            com.jumio.core.models.AuthorizationModel r1 = r5.f38986a
            com.jumio.core.models.AuthorizationModel$SessionKey r1 = r1.getSessionKey()
            java.io.File r2 = new java.io.File
            com.jumio.core.environment.Environment r3 = com.jumio.core.environment.Environment.INSTANCE
            com.jumio.core.MobileContext r4 = r5.f38987b
            java.io.File r3 = r3.getDataDirectory(r4)
            java.lang.String r4 = "tmp_store"
            r2.<init>(r3, r4)
            r0.<init>(r1, r2)
            if (r6 == 0) goto L_0x0021
            com.jumio.analytics.Analytics r1 = r5.f38992g
            r1.pause()
        L_0x0021:
            com.jumio.core.MobileContext r1 = r5.f38987b
            int r1 = r1.getCustomThemeId()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            r0.a(r1)
            boolean r1 = r5.f38998m
            java.lang.Boolean r1 = java.lang.Boolean.valueOf(r1)
            r0.a(r1)
            com.jumio.sdk.error.JumioError r1 = r5.f38996k
            r0.a(r1)
            com.jumio.core.api.BackendManager r1 = r5.f38990e
            r1.persist(r0, r6)
            com.jumio.core.persistence.DataManager r6 = r5.f38989d
            r6.persist(r0)
            java.io.ObjectOutputStream r6 = r0.f56348a     // Catch:{ Exception -> 0x005b }
            if (r6 == 0) goto L_0x0063
            r0 = 0
            r6.flush()     // Catch:{ all -> 0x0054 }
            kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0054 }
            kotlin.io.b.a(r6, r0)     // Catch:{ Exception -> 0x005b }
            goto L_0x0063
        L_0x0054:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0056 }
        L_0x0056:
            r1 = move-exception
            kotlin.io.b.a(r6, r0)     // Catch:{ Exception -> 0x005b }
            throw r1     // Catch:{ Exception -> 0x005b }
        L_0x005b:
            r6 = move-exception
            java.lang.String r0 = "PersistenceUtil"
            java.lang.String r1 = "Error finishing persistence"
            com.jumio.commons.log.Log.w((java.lang.String) r0, (java.lang.String) r1, (java.lang.Throwable) r6)
        L_0x0063:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.Controller.persistAllData(boolean):void");
    }

    public final void reporting(boolean z11) {
        try {
            if (((SettingsModel) this.f38989d.get(SettingsModel.class)).isAdditionalDataPointsEnabled()) {
                Analytics.Companion.add(MobileEvents.additionalDatapoints(this.f38987b, this.f38989d));
            }
        } catch (Exception e11) {
            Log.printStackTrace(e11);
        }
        try {
            Analytics.Companion.add(MobileEvents.reporting((l2) this.f38989d.get(l2.class), (CredentialsModel) this.f38989d.get(CredentialsModel.class), z11));
        } catch (Exception e12) {
            Log.printStackTrace(e12);
        }
        this.f38992g.reporting(z11);
    }

    public final void retry(JumioError jumioError) {
        if (x.b(jumioError, this.f38996k)) {
            this.f38996k = null;
            this.f38990e.retry();
            Analytics.Companion.add(MobileEvents.userAction$default("retry_error", (JumioScanStep) null, (Object) null, 6, (Object) null));
            return;
        }
        throw new IllegalArgumentException("Specified error is not valid".toString());
    }

    public final void saveState(Bundle bundle) {
        bundle.putSerializable("Jumio1", this.f38986a);
        persistAllData(false);
    }

    public final void setActive$jumio_core_release(boolean z11) {
        this.f38998m = z11;
    }

    public final void setActiveCredential$jumio_core_release(JumioCredential jumioCredential) {
        this.f38997l = jumioCredential;
    }

    public final void setAuthorizationModel(AuthorizationModel authorizationModel) {
        this.f38986a = authorizationModel;
    }

    public final void setContext(MobileContext mobileContext) {
        this.f38987b = mobileContext;
    }

    public final synchronized JumioCredential startCredential(JumioCredentialInfo jumioCredentialInfo) throws IllegalArgumentException {
        if (((ConsentModel) this.f38989d.get(ConsentModel.class)).getAllConsented()) {
            boolean z11 = true;
            if (this.f38997l == null) {
                JumioCredential a11 = ((CredentialsModel) this.f38989d.get(CredentialsModel.class)).a(this, jumioCredentialInfo.getId());
                this.f38997l = a11;
                if (a11 == null) {
                    z11 = false;
                }
                if (z11) {
                    if (a11 != null) {
                        a11.start$jumio_core_release();
                    }
                } else {
                    throw new IllegalArgumentException("Could not start credential".toString());
                }
            } else {
                throw new IllegalArgumentException("Please finish the active credential first".toString());
            }
        } else {
            throw new IllegalArgumentException("User consent is missing".toString());
        }
        return this.f38997l;
    }

    public final void userConsented(JumioConsentItem jumioConsentItem, boolean z11) {
        long currentTimeMillis = System.currentTimeMillis();
        MetaInfo metaInfo = new MetaInfo();
        metaInfo.putAll(jumio.core.x.a(jumioConsentItem, Long.valueOf(currentTimeMillis)));
        metaInfo.put("decision", Boolean.valueOf(z11));
        Analytics.Companion.add(MobileEvents.alert("consent", metaInfo));
        ((ConsentModel) this.f38989d.get(ConsentModel.class)).saveResult(jumioConsentItem, z11, currentTimeMillis);
    }

    public Controller(Context context, AuthorizationModel authorizationModel, JumioControllerInterface jumioControllerInterface, int i11) {
        this.f38993h = i0.a(v0.c().G());
        this.f38998m = true;
        MobileContext mobileContext = new MobileContext(context.getApplicationContext(), authorizationModel, i11);
        ServiceLocator serviceLocator = ServiceLocator.INSTANCE;
        serviceLocator.init(mobileContext);
        this.f38987b = mobileContext;
        this.f38991f = (e2) ServiceLocatorInterface.DefaultImpls.getServiceImplementation$default(serviceLocator, e2.class, (d10.a) null, 2, (Object) null);
        this.f38988c = new DeviceRotationManager(context, Rotation.NATIVE);
        DataManager dataManager = new DataManager();
        this.f38989d = dataManager;
        BackendManager backendManager = new BackendManager(this.f38987b, dataManager, authorizationModel, new a(this));
        this.f38990e = backendManager;
        backendManager.addBinding(this);
        jumio.core.f fVar = new jumio.core.f();
        dataManager.put(jumio.core.f.class, fVar);
        Analytics analytics = new Analytics(backendManager, fVar);
        analytics.configure$jumio_core_release();
        analytics.add(MobileEvents.lifecycle$default(q1.CREATED, (Object) null, 2, (Object) null));
        this.f38992g = analytics;
        this.f38986a = authorizationModel;
        this.f38994i = jumioControllerInterface;
        a(false);
    }

    public void onError(ApiCallDataModel<?> apiCallDataModel, Throwable th2) {
        onError(th2, apiCallDataModel.getCall());
    }

    public final void a(JumioCredential jumioCredential, JumioScanPartInterface jumioScanPartInterface) {
        ScanPartPlugin scanPartPlugin;
        JumioCredentialPart jumioCredentialPart = jumioCredential.getData$jumio_core_release().f56149g;
        if (jumioCredentialPart == null) {
            return;
        }
        if (!(!jumioCredential.getData$jumio_core_release().f56148f.isEmpty()) || !jumioCredential.getData$jumio_core_release().f56148f.containsKey(jumioCredential.getData$jumio_core_release().f56149g)) {
            jumioCredential.initScanPart(jumioCredentialPart, jumioScanPartInterface).getScanPart$jumio_core_release().restore();
            return;
        }
        ScanPartModel scanPartModel = jumioCredential.getData$jumio_core_release().f56148f.get(jumioCredential.getData$jumio_core_release().f56149g);
        if (scanPartModel != null && jumioCredential.getData$jumio_core_release().f56149g == JumioCredentialPart.NFC && (scanPartPlugin = (ScanPartPlugin) this.f38991f.a(d2.NFC)) != null) {
            jumioCredential.setActiveScanPart$jumio_core_release(new JumioScanPart(scanPartPlugin.getScanPart(jumioCredential.getController$jumio_core_release(), jumioCredential, scanPartModel, jumioScanPartInterface)));
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Controller(Context context, Bundle bundle, JumioControllerInterface jumioControllerInterface, JumioScanPartInterface jumioScanPartInterface, int i11, r rVar) {
        this(context, bundle, jumioControllerInterface, (i11 & 8) != 0 ? null : jumioScanPartInterface);
    }

    public Controller(Context context, Bundle bundle, JumioControllerInterface jumioControllerInterface, JumioScanPartInterface jumioScanPartInterface) {
        this.f38993h = i0.a(v0.c().G());
        this.f38998m = true;
        AuthorizationModel authorizationModel = (AuthorizationModel) bundle.getSerializable("Jumio1");
        this.f38986a = authorizationModel;
        this.f38995j = jumioScanPartInterface;
        z1 z1Var = new z1(authorizationModel.getSessionKey(), new File(Environment.INSTANCE.getDataDirectory(context), "tmp_store"));
        Context applicationContext = context.getApplicationContext();
        AuthorizationModel authorizationModel2 = this.f38986a;
        Integer num = (Integer) z1Var.a();
        MobileContext mobileContext = new MobileContext(applicationContext, authorizationModel2, num != null ? num.intValue() : 0);
        ServiceLocator serviceLocator = ServiceLocator.INSTANCE;
        serviceLocator.init(mobileContext);
        this.f38987b = mobileContext;
        this.f38991f = (e2) ServiceLocatorInterface.DefaultImpls.getServiceImplementation$default(serviceLocator, e2.class, (d10.a) null, 2, (Object) null);
        Boolean bool = (Boolean) z1Var.a();
        this.f38998m = bool != null ? bool.booleanValue() : true;
        this.f38996k = (JumioError) z1Var.a();
        DataManager dataManager = new DataManager();
        this.f38989d = dataManager;
        BackendManager backendManager = new BackendManager(this.f38987b, dataManager, this.f38986a, new b(this));
        this.f38990e = backendManager;
        backendManager.restore(z1Var);
        dataManager.restore(z1Var);
        this.f38988c = new DeviceRotationManager(context, Rotation.NATIVE);
        this.f38994i = jumioControllerInterface;
        backendManager.addBinding(this);
        Analytics analytics = new Analytics(backendManager, (jumio.core.f) dataManager.get(jumio.core.f.class));
        analytics.configure$jumio_core_release();
        analytics.resume();
        this.f38992g = analytics;
        CredentialsModel credentialsModel = (CredentialsModel) dataManager.get(CredentialsModel.class);
        String a11 = credentialsModel.a();
        if (a11 != null) {
            JumioCredential a12 = credentialsModel.a(this, a11);
            this.f38997l = a12;
            if (!(a12 == null || jumioScanPartInterface == null)) {
                a(a12, jumioScanPartInterface);
            }
        }
        a(true);
        backendManager.retry();
    }

    public final void a(boolean z11) {
        if (!JumioSDK.Companion.isSupportedPlatform(this.f38987b)) {
            onError$default(this, new Error(ErrorCase.OCR_LOADING_FAILED, 0, 1, 2, (r) null), (Class) null, 2, (Object) null);
            return;
        }
        Thread.setDefaultUncaughtExceptionHandler(new e1(Thread.getDefaultUncaughtExceptionHandler()));
        CDNFeatureModel cDNFeatureModel = (CDNFeatureModel) this.f38989d.get(CDNFeatureModel.class);
        cDNFeatureModel.setDirectory(Environment.INSTANCE.getDataDirectory(this.f38987b));
        cDNFeatureModel.setAssetManager(this.f38987b.getAssets());
        if (!z11) {
            l2 l2Var = (l2) this.f38989d.get(l2.class);
            l2Var.getClass();
            l2Var.f56248f = System.currentTimeMillis();
            DataPointsUtil dataPointsUtil = DataPointsUtil.INSTANCE;
            dataPointsUtil.setSecondsInSdk(this.f38987b, System.currentTimeMillis());
            dataPointsUtil.set(this.f38987b, DataPointsUtil.NUMBER_OF_RETAKES, 0);
            if (((SettingsModel) this.f38989d.get(SettingsModel.class)).isLoaded()) {
                a();
            } else {
                this.f38990e.settings(this.f38991f.c());
            }
        }
    }

    public final void a() {
        List<JumioConsentItem> list;
        kotlin.reflect.c<?> c11;
        SettingsModel settingsModel = (SettingsModel) this.f38989d.get(SettingsModel.class);
        InitiateModel initiateModel = (InitiateModel) this.f38989d.get(InitiateModel.class);
        DataDogModel dataDogModel = (DataDogModel) this.f38989d.get(DataDogModel.class);
        AnalyticsPlugin<DataDogModel> plugin = DataDogHelper.INSTANCE.getPlugin();
        boolean z11 = false;
        if (plugin == null) {
            Log.i(com.sumsub.sns.internal.core.analytics.e.f31898f, "DataDog plugin is turned off");
        } else {
            boolean z12 = true;
            if (!(dataDogModel.getClientId().length() == 0)) {
                if (!(dataDogModel.getAppId().length() == 0)) {
                    Map<String, String> attributes = dataDogModel.getAttributes();
                    attributes.clear();
                    attributes.put("SDK version", Environment.BUILD_VERSION);
                    if (initiateModel.f39312c.length() > 0) {
                        attributes.put("merchantId", initiateModel.f39312c);
                    }
                    if (initiateModel.f39313d.length() <= 0) {
                        z12 = false;
                    }
                    if (z12) {
                        attributes.put("merchantName", initiateModel.f39313d);
                    }
                    plugin.run(this.f38987b.getApplicationContext(), dataDogModel);
                }
            }
            Log.w(com.sumsub.sns.internal.core.analytics.e.f31898f, "Credentials are not provided for launching DataDog, skipping launch!");
        }
        this.f38992g.start(settingsModel.isAnalyticsEnabled(), settingsModel.getServerTimestamp(), SilenceSkippingAudioProcessor.DEFAULT_PADDING_SILENCE_US, 20);
        DataPointsUtil.INSTANCE.collect(this.f38987b, this.f38989d);
        Analytics.Companion companion = Analytics.Companion;
        companion.add(MobileEvents.deviceInformation(this.f38987b));
        MobileContext mobileContext = this.f38987b;
        DataManager dataManager = this.f38989d;
        AuthorizationModel authorizationModel = this.f38986a;
        e2 e2Var = this.f38991f;
        Class<?> cls = ReflectionUtil.getClass("com.jumio.defaultui.utils.DefaultUIProvider");
        if (!(cls == null || (c11 = c10.a.c(cls)) == null)) {
            z11 = c11.d(this.f38994i);
        }
        companion.add(MobileEvents.sdkParameters(mobileContext, dataManager, authorizationModel, e2Var, z11));
        if (!((ConsentModel) this.f38989d.get(ConsentModel.class)).getAllConsented()) {
            list = getUnconsentedItems();
            MetaInfo metaInfo = new MetaInfo();
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
            for (JumioConsentItem a11 : list) {
                arrayList.add(jumio.core.x.a(a11, (Long) null));
            }
            metaInfo.put("consents", arrayList);
            Analytics.Companion.add(MobileEvents.alert("consentRequired", metaInfo));
        } else {
            list = null;
        }
        n1 unused = i.d(this.f38993h, (CoroutineContext) null, (CoroutineStart) null, new z(new e(this, list), (kotlin.coroutines.c<? super z>) null), 3, (Object) null);
    }

    public final void a(HashMap<String, JumioCredentialResult> hashMap) {
        SettingsModel settingsModel = (SettingsModel) this.f38989d.get(SettingsModel.class);
        InitiateModel initiateModel = (InitiateModel) this.f38989d.get(InitiateModel.class);
        try {
            for (c0 c0Var : ((CredentialsModel) this.f38989d.get(CredentialsModel.class)).f39259a) {
                a(a((HashMap) hashMap, c0Var), c0Var, settingsModel);
            }
        } catch (Exception e11) {
            onError$default(this, e11, (Class) null, 2, (Object) null);
        }
        JumioResult jumioResult = new JumioResult(initiateModel.f39311b, initiateModel.f39310a, true, ((CredentialsModel) this.f38989d.get(CredentialsModel.class)).c(), hashMap, (JumioError) null, 32, (r) null);
        try {
            DataPointsUtil.INSTANCE.increment(this.f38987b, DataPointsUtil.NUMBER_OF_VERIFICATIONS);
            Analytics.Companion.add(MobileEvents.lifecycle$default(q1.FINISHED, (Object) null, 2, (Object) null));
        } catch (Exception e12) {
            Log.printStackTrace(e12);
        }
        try {
            this.f38992g.stop();
        } catch (Exception e13) {
            Log.printStackTrace(e13);
        }
        n1 unused = i.d(this.f38993h, (CoroutineContext) null, (CoroutineStart) null, new z(new h(this, jumioResult), (kotlin.coroutines.c<? super z>) null), 3, (Object) null);
        b();
    }

    public final void a(JumioCredentialResult jumioCredentialResult, c0 c0Var, SettingsModel settingsModel) {
        if (settingsModel.getReturnImages()) {
            JumioImageData jumioImageData = new JumioImageData(this.f38986a);
            for (ScanPartModel scanPartModel : c0Var.f56147e.values()) {
                if (scanPartModel.getFileData().getHasPath()) {
                    try {
                        jumioImageData.addImage$jumio_core_release(this.f38987b, FileUtil.INSTANCE.readFile(scanPartModel.getFileData().getPath(), this.f38986a.getSessionKey()), scanPartModel.getCredentialPart());
                    } catch (Exception e11) {
                        Log.e("ImageData", "Error reading File", (Throwable) e11);
                    }
                }
            }
            jumioCredentialResult.setImageData(jumioImageData);
        }
    }

    public final InitiateModel a(JSONObject jSONObject) {
        InitiateModel fromJson = InitiateModel.f39309e.fromJson(jSONObject);
        this.f38989d.put(InitiateModel.class, fromJson);
        if (Log.isFileLoggingActivated()) {
            LogUtils logUtils = LogUtils.INSTANCE;
            String a11 = fromJson.a();
            logUtils.setSessionLogFolderName("SDK_" + a11);
        }
        return fromJson;
    }
}
