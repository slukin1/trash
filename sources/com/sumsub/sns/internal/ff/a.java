package com.sumsub.sns.internal.ff;

import com.sumsub.sns.internal.core.data.source.dynamic.b;
import com.sumsub.sns.internal.ff.core.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Pair;

public final class a {
    public static final com.sumsub.sns.internal.ff.core.a A;
    public static final com.sumsub.sns.internal.ff.core.a B;
    public static final com.sumsub.sns.internal.ff.core.a C;
    public static final com.sumsub.sns.internal.ff.core.a D;
    public static final com.sumsub.sns.internal.ff.core.a E;
    public static final com.sumsub.sns.internal.ff.core.a F;

    /* renamed from: a  reason: collision with root package name */
    public static final a f34215a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final b f34216b;

    /* renamed from: c  reason: collision with root package name */
    public static final ConcurrentHashMap<String, Pair<Boolean, String>> f34217c = new ConcurrentHashMap<>();

    /* renamed from: d  reason: collision with root package name */
    public static final com.sumsub.sns.internal.ff.core.a f34218d;

    /* renamed from: e  reason: collision with root package name */
    public static final com.sumsub.sns.internal.ff.core.a f34219e;

    /* renamed from: f  reason: collision with root package name */
    public static final com.sumsub.sns.internal.ff.core.a f34220f;

    /* renamed from: g  reason: collision with root package name */
    public static final com.sumsub.sns.internal.ff.core.a f34221g;

    /* renamed from: h  reason: collision with root package name */
    public static final com.sumsub.sns.internal.ff.core.a f34222h;

    /* renamed from: i  reason: collision with root package name */
    public static final com.sumsub.sns.internal.ff.core.a f34223i;

    /* renamed from: j  reason: collision with root package name */
    public static final com.sumsub.sns.internal.ff.core.a f34224j;

    /* renamed from: k  reason: collision with root package name */
    public static final com.sumsub.sns.internal.ff.core.a f34225k;

    /* renamed from: l  reason: collision with root package name */
    public static final com.sumsub.sns.internal.ff.core.a f34226l;

    /* renamed from: m  reason: collision with root package name */
    public static final com.sumsub.sns.internal.ff.core.a f34227m;

    /* renamed from: n  reason: collision with root package name */
    public static final com.sumsub.sns.internal.ff.core.a f34228n;

    /* renamed from: o  reason: collision with root package name */
    public static final com.sumsub.sns.internal.ff.core.a f34229o;

    /* renamed from: p  reason: collision with root package name */
    public static final com.sumsub.sns.internal.ff.core.a f34230p;

    /* renamed from: q  reason: collision with root package name */
    public static final com.sumsub.sns.internal.ff.core.a f34231q;

    /* renamed from: r  reason: collision with root package name */
    public static final com.sumsub.sns.internal.ff.core.a f34232r;

    /* renamed from: s  reason: collision with root package name */
    public static final com.sumsub.sns.internal.ff.core.a f34233s;

    /* renamed from: t  reason: collision with root package name */
    public static final com.sumsub.sns.internal.ff.core.a f34234t;

    /* renamed from: u  reason: collision with root package name */
    public static final com.sumsub.sns.internal.ff.core.a f34235u;

    /* renamed from: v  reason: collision with root package name */
    public static final com.sumsub.sns.internal.ff.core.a f34236v;

    /* renamed from: w  reason: collision with root package name */
    public static final com.sumsub.sns.internal.ff.core.a f34237w;

    /* renamed from: x  reason: collision with root package name */
    public static final com.sumsub.sns.internal.ff.core.a f34238x;

    /* renamed from: y  reason: collision with root package name */
    public static final com.sumsub.sns.internal.ff.core.a f34239y;

    /* renamed from: z  reason: collision with root package name */
    public static final com.sumsub.sns.internal.ff.core.a f34240z;

    static {
        b bVar = new b();
        f34216b = bVar;
        f34218d = bVar.a("androidVideoIdentConfig", "Video ident config.\n\nPreferred video encoding codec used in VI.\nKey: 'codec'. Values: h264 or vp8", "{\"codec\":\"vp8\"}");
        f34219e = b.b(bVar, "videoIdentSkipNotificationPermission", "Disables notification permission request for Android 13 or later", (String) null, 4, (Object) null);
        f34220f = bVar.a("androidFaceDetector", "Face detector config in liveness step.\n\nEnable or disable MLKit face detector.\nKey: 'mlkit'. Values: 'true' or 'false'.\n\nAddition delay between frames in liveness.\nKey: 'frameDelay'. Values: any reasonable integer.", "{\"mlkit\":\"true\", \"frameDelay\":500}");
        f34221g = b.a(bVar, "androidTFFaceDetectorToggle", "Enabling Tensorflow face detector on Android", (String) null, 4, (Object) null);
        f34222h = b.b(bVar, "skipGeolocationForm", "Skip address confirmation form", (String) null, 4, (Object) null);
        f34223i = b.b(bVar, "livenessFullscreenCamera", "Full-screen camera in liveness check (transparent status bar)", (String) null, 4, (Object) null);
        f34224j = b.b(bVar, "enableFaceDetectionDebug", "Draw a box around face during liveness", (String) null, 4, (Object) null);
        f34225k = b.b(bVar, "enableFaceShowSettings", "Display a dialog asking for edit settings, in order to change the brightness to full during liveness to highlight the face", (String) null, 4, (Object) null);
        f34226l = b.a(bVar, "makeCountryStateDropdownRequiredIfNeeded", "On the Applicant Data screen, set the State (StateOfBirth) field required if the corresponding field (Country or CountryOfBirth) is required and there is a list of states for the selected country", (String) null, 4, (Object) null);
        f34227m = b.b(bVar, "stringResourcesKeys", "Show string key instead of empty value, or show only keys (value = key)", (String) null, 4, (Object) null);
        f34228n = b.b(bVar, "showBadPhotosDebugInfo", "Show technical info on screen after analyzing photo quality)", (String) null, 4, (Object) null);
        f34229o = b.a(bVar, "unsatisfactoryPhotosMobileToggle", "Enabling bad photos detection as a separate feature", (String) null, 4, (Object) null);
        f34230p = bVar.a("unsatisfactoryPhotosMobileConfigV2", "Config for unsatisfactory photos detector in document capture.                ", "{\n  \"android\":{\n    \"model\":\"unsatisfactory_photos_v2.tflite\",\n    \"high_quality_threshold\":0.75,\n    \"low_quality_threshold\":0.2,\n    \"execution_timeout_ms\":3000,\n    \"allow_cache\":true,\n    \"max_blocked_attempts\": 1,\n    \"allowed_steps\":[\n      \"IDENTITY\",\n      \"IDENTITY2\",\n      \"IDENTITY3\",\n      \"IDENTITY4\"\n    ]\n  }\n}");
        f34231q = b.a(bVar, "seamlessDocaptureAndroidToggle", "Disable seamless android only. Just in case and for testing purposes", (String) null, 4, (Object) null);
        f34232r = bVar.a("seamlessDocaptureMobileConfig", "For advanced seamlessDocapture configuration ....", "{\n    \"android\": {\n        \"videoBitrate\": 1500000,\n        \"maxRecordedDurationSec\": 60,\n        \"videoQuality\": \"HD\",\n        \"videoFallbackQuality\": \"SD\",\n        \"maxRecordedFileSizeMB\": 30\n    }\n}");
        f34233s = b.a(bVar, "documentAutocaptureMobileToggle", "Enabling autocapture as separate feature", (String) null, 4, (Object) null);
        f34234t = bVar.a("documentAutocaptureMobileConfigV2", "Json configuration documentAutocapture ....", "{\n    \"android\": {\n        \"requiredFrameFillRatio\": 0.4,\n        \"requiredLargestSizeOffsetRatio\": 0.2,\n        \"frameAspectRatio\": 1.0,\n        \"autoCaptureModel\": {\n            \"name\": \"autocapture_v2.tflite\",\n            \"threshold\": 0.7,\n            \"allowCache\": true,\n            \"inputSize\": {\n                \"width\": 384,\n                \"height\": 640\n            },\n            \"outputSize\": 5040\n        }\n    }\n}");
        f34235u = b.a(bVar, "filterCountriesByDocumentsOnQuestionnaireStep", "Filter countries by allowed docs in the countrySelect field. Deprecated", (String) null, 4, (Object) null);
        f34236v = b.a(bVar, "dontLimitCountriesOnAppDataStep", "Don't limit country field list on applicant data step", (String) null, 4, (Object) null);
        f34237w = b.b(bVar, "ekycTestMasks", "Ekyc masks configuration", (String) null, 4, (Object) null);
        f34238x = b.a(bVar, "msdkSkipAgreementSigning", "Don't show agreement selector screen if multiple agreements available, or skip signing the agreement on status screen if only one agreement available.", (String) null, 4, (Object) null);
        f34239y = b.b(bVar, "agreementsCount", "Specify agreements count for the agreement selector screen. Random countries with random agreements will be generated.", (String) null, 4, (Object) null);
        f34240z = bVar.b("testIpHeader", "value to pass X-Test-Ip over.", "85.214.132.117");
        A = b.a(bVar, "msdkEnableVerificationExitPopup", "Show confirmation dialog on closing VideoIdent flow and close the SDK", (String) null, 4, (Object) null);
        B = bVar.a("overrideVerificationUrl", "Override base URL and access token to emulate verificationUrl and accessToken on msdkInit", "{\n    \"verificationUrl\": \"http://dev-in.sumsub.com/\",\n    \"accessToken\" : \"AAA\"\n}");
        C = b.a(bVar, "androidAllowFaceScanFrameCalibration", "Enable fingerprint collection with FaceScan segment", (String) null, 4, (Object) null);
        D = b.a(bVar, "obligatoryNfcScan", "Hide Skip NFC button", (String) null, 4, (Object) null);
        E = b.a(bVar, "androidDisableAALCardUnblocking", "Disable eid card using PUK", (String) null, 4, (Object) null);
        F = b.b(bVar, "eidPinChangeTesting", "Allow to change 5-digit PIN to 6-digit PIN multiple times.\n\nIMPORTANT: under the hood this is a real 6-digit to 6-digit PIN changing! Be careful and try not to block the card by providing the wrong PIN!\n\nHow to use: on the first screen provide first 5 digits of the old 6-digit PIN, then on the second test screen provide the last digit of the old 6-digit PIN. On the third and fourth screens provide the new 6-digit PIN.", (String) null, 4, (Object) null);
    }

    public final com.sumsub.sns.internal.ff.core.a A() {
        return f34240z;
    }

    public final com.sumsub.sns.internal.ff.core.a B() {
        return f34230p;
    }

    public final com.sumsub.sns.internal.ff.core.a C() {
        return f34229o;
    }

    public final com.sumsub.sns.internal.ff.core.a D() {
        return f34218d;
    }

    public final com.sumsub.sns.internal.ff.core.a E() {
        return f34219e;
    }

    public final com.sumsub.sns.internal.ff.model.a F() {
        Collection<com.sumsub.sns.internal.ff.core.a> b11 = f34216b.b();
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(b11, 10));
        for (com.sumsub.sns.internal.ff.core.a e11 : b11) {
            arrayList.add(e11.e());
        }
        return new com.sumsub.sns.internal.ff.model.a(arrayList);
    }

    public final void G() {
        f34216b.c();
        for (Map.Entry entry : f34217c.entrySet()) {
            com.sumsub.sns.internal.ff.core.a a11 = f34216b.a((String) entry.getKey());
            if (a11 != null) {
                a11.b(((Boolean) ((Pair) entry.getValue()).getFirst()).booleanValue(), (String) ((Pair) entry.getValue()).getSecond());
            }
        }
    }

    public final void a(String str, boolean z11, String str2) {
        f34217c.put(str, new Pair(Boolean.valueOf(z11), str2));
        com.sumsub.sns.internal.ff.core.a a11 = f34216b.a(str);
        if (a11 != null) {
            a11.b(z11, str2);
        }
    }

    public final com.sumsub.sns.internal.ff.core.a b() {
        return f34226l;
    }

    public final Map<String, Object> c() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Collection<com.sumsub.sns.internal.ff.core.a> b11 = f34216b.b();
        ArrayList arrayList = new ArrayList();
        for (T next : b11) {
            if (((com.sumsub.sns.internal.ff.core.a) next).g()) {
                arrayList.add(next);
            }
        }
        Collection<com.sumsub.sns.internal.ff.core.a> a11 = f34216b.a();
        ArrayList arrayList2 = new ArrayList();
        for (T next2 : a11) {
            if (((com.sumsub.sns.internal.ff.core.a) next2).g()) {
                arrayList2.add(next2);
            }
        }
        List<com.sumsub.sns.internal.ff.core.a> q02 = CollectionsKt___CollectionsKt.q0(arrayList, arrayList2);
        ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.u(q02, 10));
        for (com.sumsub.sns.internal.ff.core.a e11 : q02) {
            arrayList3.add(e11.e());
        }
        if (!(!arrayList3.isEmpty())) {
            arrayList3 = null;
        }
        if (arrayList3 != null) {
            linkedHashMap.put("enabledFFs", arrayList3);
        }
        return linkedHashMap;
    }

    public final com.sumsub.sns.internal.ff.core.a d() {
        return C;
    }

    public final com.sumsub.sns.internal.ff.core.a e() {
        return f34221g;
    }

    public final com.sumsub.sns.internal.ff.core.a f() {
        return f34231q;
    }

    public final com.sumsub.sns.internal.ff.core.a g() {
        return f34234t;
    }

    public final com.sumsub.sns.internal.ff.core.a h() {
        return f34233s;
    }

    public final com.sumsub.sns.internal.ff.core.a i() {
        return f34236v;
    }

    public final com.sumsub.sns.internal.ff.core.a j() {
        return F;
    }

    public final com.sumsub.sns.internal.ff.core.a k() {
        return E;
    }

    public final com.sumsub.sns.internal.ff.core.a l() {
        return f34237w;
    }

    public final com.sumsub.sns.internal.ff.core.a m() {
        return f34220f;
    }

    public final com.sumsub.sns.internal.ff.core.a n() {
        return f34235u;
    }

    public final com.sumsub.sns.internal.ff.core.a o() {
        return f34223i;
    }

    public final com.sumsub.sns.internal.ff.core.a p() {
        return f34224j;
    }

    public final com.sumsub.sns.internal.ff.core.a q() {
        return f34225k;
    }

    public final b r() {
        return f34216b;
    }

    public final com.sumsub.sns.internal.ff.core.a s() {
        return A;
    }

    public final com.sumsub.sns.internal.ff.core.a t() {
        return D;
    }

    public final com.sumsub.sns.internal.ff.core.a u() {
        return B;
    }

    public final com.sumsub.sns.internal.ff.core.a v() {
        return f34232r;
    }

    public final com.sumsub.sns.internal.ff.core.a w() {
        return f34228n;
    }

    public final com.sumsub.sns.internal.ff.core.a x() {
        return f34238x;
    }

    public final com.sumsub.sns.internal.ff.core.a y() {
        return f34222h;
    }

    public final com.sumsub.sns.internal.ff.core.a z() {
        return f34227m;
    }

    public final void a(String str) {
        f34217c.remove(str);
        com.sumsub.sns.internal.ff.core.a a11 = f34216b.a(str);
        if (a11 != null) {
            a11.a();
        }
    }

    public final void a(b.C0365b bVar) {
        f34216b.a(bVar);
    }

    public final com.sumsub.sns.internal.ff.core.a a() {
        return f34239y;
    }
}
