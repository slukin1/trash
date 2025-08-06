package com.jumio.analytics;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.nfc.NfcAdapter;
import android.os.Build;
import android.text.TextUtils;
import com.facebook.appevents.UserDataStore;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.huawei.hms.push.AttributionReporter;
import com.jumio.commons.log.Log;
import com.jumio.commons.utils.DeviceRotationManager;
import com.jumio.core.environment.Environment;
import com.jumio.core.error.Error;
import com.jumio.core.models.AuthorizationModel;
import com.jumio.core.models.DeviceRiskScanPartModel;
import com.jumio.core.models.DigitalSelectionModel;
import com.jumio.core.models.InitiateModel;
import com.jumio.core.models.PhysicalSelectionModel;
import com.jumio.core.models.ScanPartModel;
import com.jumio.core.models.SettingsModel;
import com.jumio.core.persistence.DataManager;
import com.jumio.core.util.DataPointsUtil;
import com.jumio.core.util.ReflectionUtil;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.retry.JumioRetryReason;
import com.sumsub.sentry.q;
import com.sumsub.sns.internal.core.common.n0;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import jumio.core.b;
import jumio.core.e2;
import jumio.core.q1;
import kotlin.jvm.internal.d0;

public final class MobileEvents {
    public static final int EVENTTYPE_ADDITIONAL_DATAPOINTS = 313;
    public static final int EVENTTYPE_ALERT = 311;
    public static final int EVENTTYPE_CV = 315;
    public static final int EVENTTYPE_EXCEPTION = 305;
    public static final int EVENTTYPE_MISC = 317;
    public static final int EVENTTYPE_MOBILE_DEVICE_INFO = 307;
    public static final int EVENTTYPE_NETWORKCALL = 309;
    public static final int EVENTTYPE_PERFORMANCE = 319;
    public static final int EVENTTYPE_REPORTING = 316;
    public static final int EVENTTYPE_SCANSTEP = 300;
    public static final int EVENTTYPE_SDKLIFECYCLE = 302;
    public static final int EVENTTYPE_SDKPARAMETERS = 306;
    public static final int EVENTTYPE_USERACTION = 301;
    public static final MobileEvents INSTANCE = new MobileEvents();

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f38921a;

        static {
            int[] iArr = new int[q1.values().length];
            try {
                iArr[4] = 1;
            } catch (NoSuchFieldError unused) {
            }
            f38921a = iArr;
        }
    }

    public static final AnalyticsEvent additionalDatapoints(Context context, DataManager dataManager) {
        long j11;
        b bVar = (b) dataManager.get(b.class);
        bVar.getClass();
        try {
            j11 = (System.currentTimeMillis() - DataPointsUtil.INSTANCE.getSecondsInSdk(context)) / ((long) 1000);
        } catch (Exception e11) {
            Log.printStackTrace(e11);
            j11 = 0;
        }
        MetaInfo metaInfo = new MetaInfo();
        metaInfo.put("locale", bVar.f56127a);
        metaInfo.put("srX", Integer.valueOf(bVar.f56128b));
        metaInfo.put("srY", Integer.valueOf(bVar.f56129c));
        metaInfo.put("timezone", Integer.valueOf(bVar.f56130d));
        metaInfo.put(n0.a.C0327a.f32128g, Boolean.valueOf(bVar.f56131e));
        metaInfo.put("countryForIP", bVar.f56132f);
        metaInfo.put("stateForIp", bVar.f56133g);
        metaInfo.put("localeCountry", bVar.f56134h);
        metaInfo.put("issuingCountry", bVar.f56135i);
        DataPointsUtil dataPointsUtil = DataPointsUtil.INSTANCE;
        metaInfo.put("numOfVerifications", Integer.valueOf(dataPointsUtil.get(context, DataPointsUtil.NUMBER_OF_VERIFICATIONS)));
        metaInfo.put("numOfRetakes", Integer.valueOf(dataPointsUtil.get(context, DataPointsUtil.NUMBER_OF_RETAKES)));
        metaInfo.put("numOfCancels", Integer.valueOf(dataPointsUtil.get(context, DataPointsUtil.NUMBER_OF_CANCELS)));
        HashSet hashSet = new HashSet();
        if (!TextUtils.isEmpty(bVar.f56134h)) {
            hashSet.add(bVar.f56134h);
        }
        if (!TextUtils.isEmpty(bVar.f56135i)) {
            hashSet.add(bVar.f56135i);
        }
        if (!TextUtils.isEmpty(bVar.f56132f)) {
            hashSet.add(bVar.f56132f);
        }
        metaInfo.put("numOfCountries", Integer.valueOf(hashSet.size()));
        metaInfo.put("secInSdk", Long.valueOf(j11));
        metaInfo.put("grantedPermissions", bVar.f56136j);
        return new AnalyticsEvent(313, "noValue", metaInfo);
    }

    public static final AnalyticsEvent alert(String str, MetaInfo metaInfo) {
        return new AnalyticsEvent(311, str, metaInfo);
    }

    public static /* synthetic */ AnalyticsEvent alert$default(String str, MetaInfo metaInfo, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            metaInfo = null;
        }
        return alert(str, metaInfo);
    }

    public static final AnalyticsEvent cvDebugging(String str, MetaInfo metaInfo) {
        return new AnalyticsEvent(EVENTTYPE_CV, str, metaInfo);
    }

    public static /* synthetic */ AnalyticsEvent cvDebugging$default(String str, MetaInfo metaInfo, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            metaInfo = null;
        }
        return cvDebugging(str, metaInfo);
    }

    public static final AnalyticsEvent deviceInformation(Context context) {
        NfcAdapter defaultAdapter = NfcAdapter.getDefaultAdapter(context);
        boolean z11 = false;
        String substring = Environment.BUILD_VERSION.substring(0, StringsKt__StringsKt.g0(Environment.BUILD_VERSION, " (", 0, false, 6, (Object) null));
        String valueOf = String.valueOf(Build.VERSION.SDK_INT);
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        MetaInfo metaInfo = new MetaInfo();
        metaInfo.put("sdk-version", substring);
        metaInfo.put(q.f30469g, n0.f32119g);
        metaInfo.put("os-version", valueOf);
        metaInfo.put("manufacturer", str);
        metaInfo.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, str2);
        metaInfo.put("hasDeviceNFC", Boolean.valueOf(context.getPackageManager().hasSystemFeature("android.hardware.nfc")));
        if (defaultAdapter != null && defaultAdapter.isEnabled()) {
            z11 = true;
        }
        metaInfo.put("wasNFCenabled", Boolean.valueOf(z11));
        metaInfo.put("isTablet", Boolean.valueOf(DeviceRotationManager.isTabletDevice(context)));
        return new AnalyticsEvent(307, "noValue", metaInfo);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0059, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x005a, code lost:
        kotlin.io.b.a(r1, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x005d, code lost:
        throw r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.jumio.analytics.AnalyticsEvent exception(java.lang.Exception r8) {
        /*
            com.jumio.analytics.MetaInfo r0 = new com.jumio.analytics.MetaInfo
            r0.<init>()
            java.io.StringWriter r1 = new java.io.StringWriter
            r1.<init>()
            java.lang.Class r2 = r8.getClass()     // Catch:{ all -> 0x0057 }
            java.lang.String r2 = r2.getName()     // Catch:{ all -> 0x0057 }
            java.lang.Appendable r2 = r1.append(r2)     // Catch:{ all -> 0x0057 }
            r3 = 10
            r2.append(r3)     // Catch:{ all -> 0x0057 }
            java.lang.StackTraceElement[] r8 = r8.getStackTrace()     // Catch:{ all -> 0x0057 }
            r2 = 0
            int r4 = r8.length     // Catch:{ all -> 0x0057 }
        L_0x0021:
            if (r2 >= r4) goto L_0x0040
            r5 = r8[r2]     // Catch:{ all -> 0x0057 }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0057 }
            r6.<init>()     // Catch:{ all -> 0x0057 }
            java.lang.String r7 = "\tat "
            r6.append(r7)     // Catch:{ all -> 0x0057 }
            r6.append(r5)     // Catch:{ all -> 0x0057 }
            java.lang.String r5 = r6.toString()     // Catch:{ all -> 0x0057 }
            java.lang.Appendable r5 = r1.append(r5)     // Catch:{ all -> 0x0057 }
            r5.append(r3)     // Catch:{ all -> 0x0057 }
            int r2 = r2 + 1
            goto L_0x0021
        L_0x0040:
            java.lang.String r8 = r1.toString()     // Catch:{ all -> 0x0057 }
            r2 = 0
            kotlin.io.b.a(r1, r2)
            java.lang.String r1 = "message"
            r0.put(r1, r8)
            com.jumio.analytics.AnalyticsEvent r8 = new com.jumio.analytics.AnalyticsEvent
            r1 = 305(0x131, float:4.27E-43)
            java.lang.String r2 = "exception"
            r8.<init>(r1, r2, r0)
            return r8
        L_0x0057:
            r8 = move-exception
            throw r8     // Catch:{ all -> 0x0059 }
        L_0x0059:
            r0 = move-exception
            kotlin.io.b.a(r1, r8)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.analytics.MobileEvents.exception(java.lang.Exception):com.jumio.analytics.AnalyticsEvent");
    }

    public static final AnalyticsEvent lifecycle(q1 q1Var, Object obj) {
        Error error;
        MetaInfo metaInfo = new MetaInfo();
        if (a.f38921a[q1Var.ordinal()] == 1 && (error = (Error) obj) != null) {
            metaInfo.put("code", error.getCode());
            metaInfo.put("retryPossible", Boolean.valueOf(error.isRetryable()));
        }
        return new AnalyticsEvent(302, q1Var.toString(), metaInfo);
    }

    public static /* synthetic */ AnalyticsEvent lifecycle$default(q1 q1Var, Object obj, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            obj = null;
        }
        return lifecycle(q1Var, obj);
    }

    public static final AnalyticsEvent misc(String str, MetaInfo metaInfo) {
        return new AnalyticsEvent(EVENTTYPE_MISC, str, metaInfo);
    }

    public static /* synthetic */ AnalyticsEvent misc$default(String str, MetaInfo metaInfo, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            metaInfo = null;
        }
        return misc(str, metaInfo);
    }

    public static final AnalyticsEvent networkRequest(int i11, int i12, long j11) {
        MetaInfo metaInfo = new MetaInfo();
        metaInfo.put("http", Integer.valueOf(i12));
        metaInfo.put("roundtrip", Long.valueOf(j11));
        return new AnalyticsEvent(EVENTTYPE_NETWORKCALL, StringsKt__StringsKt.u0(String.valueOf(i11), 2, '0'), metaInfo);
    }

    public static final AnalyticsEvent performance(String str, MetaInfo metaInfo) {
        return new AnalyticsEvent(EVENTTYPE_PERFORMANCE, str, metaInfo);
    }

    public static /* synthetic */ AnalyticsEvent performance$default(String str, MetaInfo metaInfo, int i11, Object obj) {
        if ((i11 & 2) != 0) {
            metaInfo = null;
        }
        return performance(str, metaInfo);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r12v12, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v8, resolved type: java.lang.Boolean} */
    /* JADX WARNING: type inference failed for: r3v3, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v4, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v6, types: [java.lang.String] */
    /* JADX WARNING: type inference failed for: r3v7, types: [java.lang.String] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final com.jumio.analytics.AnalyticsEvent reporting(jumio.core.l2 r12, com.jumio.core.models.CredentialsModel r13, boolean r14) {
        /*
            com.jumio.analytics.AnalyticsEvent r0 = new com.jumio.analytics.AnalyticsEvent
            r12.getClass()
            com.jumio.analytics.MetaInfo r1 = new com.jumio.analytics.MetaInfo
            r1.<init>()
            if (r14 == 0) goto L_0x0015
            java.lang.String r14 = r12.a(r13)
            java.lang.String r2 = "dropOffInfo"
            r1.put(r2, r14)
        L_0x0015:
            java.util.LinkedHashMap r14 = new java.util.LinkedHashMap
            r14.<init>()
            java.util.TreeMap<java.lang.String, jumio.core.l2$a> r2 = r12.f56243a
            java.util.Set r2 = r2.entrySet()
            java.util.Iterator r2 = r2.iterator()
        L_0x0024:
            boolean r3 = r2.hasNext()
            java.lang.String r4 = "total"
            r5 = 1000(0x3e8, float:1.401E-42)
            if (r3 == 0) goto L_0x008a
            java.lang.Object r3 = r2.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r6 = r3.getKey()
            java.lang.Object r3 = r3.getValue()
            jumio.core.l2$a r3 = (jumio.core.l2.a) r3
            r3.getClass()
            java.util.LinkedHashMap r7 = new java.util.LinkedHashMap
            r7.<init>()
            jumio.core.l2$b r8 = r3.f56249a
            long r8 = r8.f56252b
            long r10 = (long) r5
            long r8 = r8 / r10
            int r5 = (int) r8
            java.lang.Integer r5 = java.lang.Integer.valueOf(r5)
            r7.put(r4, r5)
            java.util.HashMap<com.jumio.sdk.enums.JumioCredentialPart, jumio.core.l2$b> r3 = r3.f56250b
            java.util.Set r3 = r3.entrySet()
            java.util.Iterator r3 = r3.iterator()
        L_0x005e:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0086
            java.lang.Object r4 = r3.next()
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4
            java.lang.Object r5 = r4.getKey()
            com.jumio.sdk.enums.JumioCredentialPart r5 = (com.jumio.sdk.enums.JumioCredentialPart) r5
            java.lang.String r5 = r5.toString()
            java.lang.Object r4 = r4.getValue()
            jumio.core.l2$b r4 = (jumio.core.l2.b) r4
            long r8 = r4.f56252b
            long r8 = r8 / r10
            int r4 = (int) r8
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r7.put(r5, r4)
            goto L_0x005e
        L_0x0086:
            r14.put(r6, r7)
            goto L_0x0024
        L_0x008a:
            long r2 = java.lang.System.currentTimeMillis()
            long r6 = r12.f56248f
            long r2 = r2 - r6
            long r5 = (long) r5
            long r2 = r2 / r5
            int r2 = (int) r2
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r14.put(r4, r2)
            java.lang.String r2 = "sec"
            r1.put(r2, r14)
            com.jumio.core.util.ConcurrentMutableList<jumio.core.d2> r12 = r12.f56244b
            java.util.ArrayList r14 = new java.util.ArrayList
            r2 = 10
            int r2 = kotlin.collections.CollectionsKt__IterablesKt.u(r12, r2)
            r14.<init>(r2)
            java.util.Iterator r12 = r12.iterator()
        L_0x00b1:
            boolean r2 = r12.hasNext()
            if (r2 == 0) goto L_0x00c5
            java.lang.Object r2 = r12.next()
            jumio.core.d2 r2 = (jumio.core.d2) r2
            java.lang.String r2 = r2.toString()
            r14.add(r2)
            goto L_0x00b1
        L_0x00c5:
            java.lang.String r12 = "usedModules"
            r1.put(r12, r14)
            java.util.List<jumio.core.c0> r12 = r13.f39259a
            java.util.Iterator r12 = r12.iterator()
        L_0x00d0:
            boolean r13 = r12.hasNext()
            r14 = 1
            r2 = 0
            r3 = 0
            if (r13 == 0) goto L_0x00ec
            java.lang.Object r13 = r12.next()
            r4 = r13
            jumio.core.c0 r4 = (jumio.core.c0) r4
            com.jumio.sdk.credentials.JumioCredentialCategory r4 = r4.f56144b
            com.jumio.sdk.credentials.JumioCredentialCategory r5 = com.jumio.sdk.credentials.JumioCredentialCategory.FACE
            if (r4 != r5) goto L_0x00e8
            r4 = r14
            goto L_0x00e9
        L_0x00e8:
            r4 = r2
        L_0x00e9:
            if (r4 == 0) goto L_0x00d0
            goto L_0x00ed
        L_0x00ec:
            r13 = r3
        L_0x00ed:
            jumio.core.c0 r13 = (jumio.core.c0) r13
            if (r13 != 0) goto L_0x00f2
            goto L_0x0138
        L_0x00f2:
            java.util.SortedMap<com.jumio.sdk.enums.JumioCredentialPart, com.jumio.core.models.ScanPartModel> r12 = r13.f56147e
            com.jumio.sdk.enums.JumioCredentialPart r13 = com.jumio.sdk.enums.JumioCredentialPart.FACE
            java.lang.Object r12 = r12.get(r13)
            com.jumio.core.models.ScanPartModel r12 = (com.jumio.core.models.ScanPartModel) r12
            if (r12 != 0) goto L_0x00ff
            goto L_0x0138
        L_0x00ff:
            com.jumio.core.data.ScanMode r13 = r12.getMode()
            int[] r4 = jumio.core.l2.c.f56253a
            int r13 = r13.ordinal()
            r13 = r4[r13]
            if (r13 == r14) goto L_0x0136
            r14 = 2
            if (r13 == r14) goto L_0x0133
            r14 = 3
            if (r13 == r14) goto L_0x0114
            goto L_0x0138
        L_0x0114:
            java.util.HashMap r12 = r12.getData()
            java.lang.String r13 = "isGpa"
            java.lang.Object r12 = r12.get(r13)
            boolean r13 = r12 instanceof java.lang.Boolean
            if (r13 == 0) goto L_0x0125
            r3 = r12
            java.lang.Boolean r3 = (java.lang.Boolean) r3
        L_0x0125:
            if (r3 == 0) goto L_0x012b
            boolean r2 = r3.booleanValue()
        L_0x012b:
            if (r2 == 0) goto L_0x0130
            java.lang.String r3 = "IPROOV_PREMIUM"
            goto L_0x0138
        L_0x0130:
            java.lang.String r3 = "IPROOV_STANDARD"
            goto L_0x0138
        L_0x0133:
            java.lang.String r3 = "JUMIO_STANDARD"
            goto L_0x0138
        L_0x0136:
            java.lang.String r3 = "JUMIO_LIVENESS"
        L_0x0138:
            if (r3 == 0) goto L_0x013f
            java.lang.String r12 = "livenessCaptureType"
            r1.put(r12, r3)
        L_0x013f:
            r12 = 316(0x13c, float:4.43E-43)
            java.lang.String r13 = "noValue"
            r0.<init>(r12, r13, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.analytics.MobileEvents.reporting(jumio.core.l2, com.jumio.core.models.CredentialsModel, boolean):com.jumio.analytics.AnalyticsEvent");
    }

    public static final AnalyticsEvent scanStep(JumioScanStep jumioScanStep, Object obj) {
        MetaInfo metaInfo = new MetaInfo();
        if (obj instanceof ScanPartModel) {
            ScanPartModel scanPartModel = (ScanPartModel) obj;
            metaInfo.put("side", scanPartModel.getCredentialPart().toString());
            metaInfo.put("type", scanPartModel.getMode().toString());
            if (obj instanceof DeviceRiskScanPartModel) {
                metaInfo.put("additionalData", String.valueOf(((DeviceRiskScanPartModel) obj).getDeviceRiskVendor()));
            }
        } else if (obj instanceof JumioRetryReason) {
            metaInfo.put("retryCode", Integer.valueOf(((JumioRetryReason) obj).getCode()));
        } else if (obj instanceof MetaInfo) {
            metaInfo.putAll((Map) obj);
        } else if (obj instanceof Map) {
            metaInfo.put("additionalData", obj);
        } else if (obj instanceof String) {
            metaInfo.put("additionalData", obj);
        }
        return new AnalyticsEvent(300, jumioScanStep.toString().toLowerCase(Locale.ROOT), metaInfo);
    }

    public static /* synthetic */ AnalyticsEvent scanStep$default(JumioScanStep jumioScanStep, Object obj, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            obj = null;
        }
        return scanStep(jumioScanStep, obj);
    }

    public static final AnalyticsEvent sdkParameters(Context context, DataManager dataManager, AuthorizationModel authorizationModel, e2 e2Var, boolean z11) {
        String str;
        MetaInfo metaInfo = new MetaInfo();
        metaInfo.put("dataCenter", authorizationModel.getDataCenter().toString());
        metaInfo.put("modules", e2Var.b());
        if (ReflectionUtil.hasClass("com.facebook.react.ReactActivity")) {
            str = "React";
        } else if (ReflectionUtil.hasClass("org.apache.cordova.CordovaActivity")) {
            str = "Cordova";
        } else {
            str = ReflectionUtil.hasClass("io.flutter.embedding.android.FlutterActivity") ? "Flutter" : "Native";
        }
        metaInfo.put("platform", str);
        metaInfo.put("integration", z11 ? "DUI" : "CUI");
        try {
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            d0 d0Var = d0.f56774a;
            metaInfo.put(AttributionReporter.APP_VERSION, String.format(Locale.ENGLISH, "%s (%d)", Arrays.copyOf(new Object[]{packageInfo.versionName, Integer.valueOf(packageInfo.versionCode)}, 2)));
        } catch (Exception e11) {
            Log.printStackTrace(e11);
        }
        metaInfo.put("accountId", ((InitiateModel) dataManager.get(InitiateModel.class)).f39310a);
        metaInfo.put("scanMode", ((SettingsModel) dataManager.get(SettingsModel.class)).getWorkflowDefinitionKey());
        return new AnalyticsEvent(EVENTTYPE_SDKPARAMETERS, "noValue", metaInfo);
    }

    public static final AnalyticsEvent userAction(String str, JumioScanStep jumioScanStep, Object obj) {
        MetaInfo metaInfo = new MetaInfo();
        if (obj instanceof String) {
            metaInfo.put("additionalData", obj);
        } else if (obj instanceof PhysicalSelectionModel) {
            PhysicalSelectionModel physicalSelectionModel = (PhysicalSelectionModel) obj;
            metaInfo.put(UserDataStore.COUNTRY, physicalSelectionModel.getCountry().getIsoCode());
            metaInfo.put("type", physicalSelectionModel.getPhysicalDocumentType().getIdType().toString());
            metaInfo.put("idStyle", physicalSelectionModel.getVariant().getVariant().toString());
        } else if (obj instanceof DigitalSelectionModel) {
            DigitalSelectionModel digitalSelectionModel = (DigitalSelectionModel) obj;
            metaInfo.put(UserDataStore.COUNTRY, digitalSelectionModel.getCountry().getIsoCode());
            metaInfo.put("type", "DIGITAL");
            metaInfo.put("idStyle", digitalSelectionModel.getDigitalDocumentType().getType());
        } else if (obj instanceof MetaInfo) {
            metaInfo.putAll((Map) obj);
        }
        if (jumioScanStep != null) {
            metaInfo.put("view", jumioScanStep.toString());
        }
        return new AnalyticsEvent(301, str, metaInfo);
    }

    public static /* synthetic */ AnalyticsEvent userAction$default(String str, JumioScanStep jumioScanStep, Object obj, int i11, Object obj2) {
        if ((i11 & 2) != 0) {
            jumioScanStep = null;
        }
        if ((i11 & 4) != 0) {
            obj = null;
        }
        return userAction(str, jumioScanStep, obj);
    }
}
