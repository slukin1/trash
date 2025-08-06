package com.appsflyer.internal;

import android.content.Context;
import com.appsflyer.AFLogger;
import com.appsflyer.deeplink.DeepLink;
import com.appsflyer.deeplink.DeepLinkResult;
import com.appsflyer.internal.bt;
import com.appsflyer.internal.d;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class aq extends bf {
    private static String onAttributionFailure = "https://%sdlsdk.%s/v1.0/android/";
    public static long onInstallConversionDataLoadedNative;
    private boolean AppsFlyerConversionListener;
    private int AppsFlyerInAppPurchaseValidatorListener;
    private int AppsFlyerLib;
    private final List<bt> onAppOpenAttribution = new ArrayList();
    private final CountDownLatch onConversionDataSuccess = new CountDownLatch(1);
    private final au onDeepLinking;
    public int onDeepLinkingNative;
    private final JSONObject onValidateInAppFailure = new JSONObject();

    /* renamed from: com.appsflyer.internal.aq$1  reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] valueOf;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.appsflyer.internal.bt$e[] r0 = com.appsflyer.internal.bt.e.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                valueOf = r0
                com.appsflyer.internal.bt$e r1 = com.appsflyer.internal.bt.e.FINISHED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = valueOf     // Catch:{ NoSuchFieldError -> 0x001d }
                com.appsflyer.internal.bt$e r1 = com.appsflyer.internal.bt.e.STARTED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.aq.AnonymousClass1.<clinit>():void");
        }
    }

    public aq(Context context, au auVar) {
        super((String) null, onAttributionFailure, Boolean.FALSE, Boolean.TRUE, (Boolean) null, context);
        this.onDeepLinking = auVar;
    }

    private Map<String, Object> AFInAppEventParameterName(final d.e.C0074d dVar) {
        Boolean bool;
        boolean z11 = false;
        if (!(dVar == null || dVar.values == null || ((bool = dVar.valueOf) != null && bool.booleanValue()))) {
            z11 = true;
        }
        if (z11) {
            return new HashMap<String, Object>() {
                {
                    put("type", "unhashed");
                    put("value", d.e.C0074d.this.values);
                }
            };
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0121  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x00e8 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void AFKeystoreWrapper(android.content.Context r9) {
        /*
            r8 = this;
            int r0 = r8.onDeepLinkingNative
            r1 = 1
            int r0 = r0 + r1
            r8.onDeepLinkingNative = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r2 = "[DDL] Preparing request "
            r0.<init>(r2)
            int r2 = r8.onDeepLinkingNative
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            com.appsflyer.AFLogger.values((java.lang.String) r0)
            int r0 = r8.onDeepLinkingNative
            if (r0 != r1) goto L_0x00aa
            com.appsflyer.internal.ae r0 = com.appsflyer.internal.ae.values()
            java.util.Map<java.lang.String, java.lang.Object> r2 = r8.AFInAppEventType
            boolean r3 = com.appsflyer.internal.ae.AFInAppEventParameterName((android.content.Context) r9)
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r3)
            java.lang.String r4 = "is_first"
            r2.put(r4, r3)
            java.util.Map<java.lang.String, java.lang.Object> r2 = r8.AFInAppEventType
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.util.Locale r4 = java.util.Locale.getDefault()
            java.lang.String r4 = r4.getLanguage()
            r3.append(r4)
            java.lang.String r4 = "-"
            r3.append(r4)
            java.util.Locale r4 = java.util.Locale.getDefault()
            java.lang.String r4 = r4.getCountry()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            java.lang.String r4 = "lang"
            r2.put(r4, r3)
            java.util.Map<java.lang.String, java.lang.Object> r2 = r8.AFInAppEventType
            java.lang.String r3 = android.os.Build.VERSION.RELEASE
            java.lang.String r4 = "os"
            r2.put(r4, r3)
            java.util.Map<java.lang.String, java.lang.Object> r2 = r8.AFInAppEventType
            java.lang.String r3 = android.os.Build.MODEL
            java.lang.String r4 = "type"
            r2.put(r4, r3)
            java.util.Map<java.lang.String, java.lang.Object> r2 = r8.AFInAppEventType
            java.lang.String r3 = r0.getAppsFlyerUID(r9)
            java.lang.String r4 = "request_id"
            r2.put(r4, r3)
            java.lang.String[] r0 = r0.getLevel
            if (r0 == 0) goto L_0x0083
            java.util.Map<java.lang.String, java.lang.Object> r2 = r8.AFInAppEventType
            java.lang.String r3 = "sharing_filter"
            r2.put(r3, r0)
        L_0x0083:
            java.util.HashMap r0 = new java.util.HashMap
            r0.<init>()
            com.appsflyer.internal.d$e$d r0 = com.appsflyer.internal.ab.valueOf(r9, r0)
            java.util.Map r0 = r8.AFInAppEventParameterName((com.appsflyer.internal.d.e.C0074d) r0)
            com.appsflyer.internal.d$e$d r2 = com.appsflyer.internal.ab.values(r9)
            java.util.Map r2 = r8.AFInAppEventParameterName((com.appsflyer.internal.d.e.C0074d) r2)
            if (r0 == 0) goto L_0x00a1
            java.util.Map<java.lang.String, java.lang.Object> r3 = r8.AFInAppEventType
            java.lang.String r4 = "gaid"
            r3.put(r4, r0)
        L_0x00a1:
            if (r2 == 0) goto L_0x00aa
            java.util.Map<java.lang.String, java.lang.Object> r0 = r8.AFInAppEventType
            java.lang.String r3 = "oaid"
            r0.put(r3, r2)
        L_0x00aa:
            java.util.Map<java.lang.String, java.lang.Object> r0 = r8.AFInAppEventType
            java.text.SimpleDateFormat r2 = new java.text.SimpleDateFormat
            java.util.Locale r3 = java.util.Locale.US
            java.lang.String r4 = "yyyy-MM-dd'T'HH:mm:ss.SSS"
            r2.<init>(r4, r3)
            long r3 = java.lang.System.currentTimeMillis()
            java.lang.String r5 = "UTC"
            java.util.TimeZone r5 = java.util.TimeZone.getTimeZone(r5)
            r2.setTimeZone(r5)
            java.util.Date r5 = new java.util.Date
            r5.<init>(r3)
            java.lang.String r2 = r2.format(r5)
            java.lang.String r3 = "timestamp"
            r0.put(r3, r2)
            java.util.Map<java.lang.String, java.lang.Object> r0 = r8.AFInAppEventType
            int r2 = r8.onDeepLinkingNative
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.String r4 = "request_count"
            r0.put(r4, r2)
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List<com.appsflyer.internal.bt> r2 = r8.onAppOpenAttribution
            java.util.Iterator r2 = r2.iterator()
        L_0x00e8:
            boolean r4 = r2.hasNext()
            if (r4 == 0) goto L_0x0125
            java.lang.Object r4 = r2.next()
            com.appsflyer.internal.bt r4 = (com.appsflyer.internal.bt) r4
            com.appsflyer.internal.bt$e r5 = r4.AFInAppEventParameterName
            com.appsflyer.internal.bt$e r6 = com.appsflyer.internal.bt.e.FINISHED
            if (r5 != r6) goto L_0x011e
            java.util.HashMap r5 = new java.util.HashMap
            r5.<init>()
            java.util.Map<java.lang.String, java.lang.Object> r6 = r4.AFKeystoreWrapper
            java.lang.String r7 = "referrer"
            java.lang.Object r6 = r6.get(r7)
            java.lang.String r6 = (java.lang.String) r6
            if (r6 == 0) goto L_0x011e
            java.util.Map<java.lang.String, java.lang.Object> r4 = r4.AFKeystoreWrapper
            java.lang.String r7 = "source"
            java.lang.Object r4 = r4.get(r7)
            java.lang.String r4 = (java.lang.String) r4
            r5.put(r7, r4)
            java.lang.String r4 = "value"
            r5.put(r4, r6)
            goto L_0x011f
        L_0x011e:
            r5 = 0
        L_0x011f:
            if (r5 == 0) goto L_0x00e8
            r0.add(r5)
            goto L_0x00e8
        L_0x0125:
            boolean r2 = r0.isEmpty()
            if (r2 != 0) goto L_0x0132
            java.util.Map<java.lang.String, java.lang.Object> r2 = r8.AFInAppEventType
            java.lang.String r4 = "referrers"
            r2.put(r4, r0)
        L_0x0132:
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = "AppsFlyerKey"
            java.lang.String r0 = r0.getString(r2)
            java.lang.String r2 = r8.onAppOpenAttributionNative
            r4 = 2
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r5 = 0
            com.appsflyer.AppsFlyerLib r6 = com.appsflyer.AppsFlyerLib.getInstance()
            java.lang.String r6 = r6.getHostPrefix()
            r4[r5] = r6
            com.appsflyer.internal.ae r5 = com.appsflyer.internal.ae.values()
            java.lang.String r5 = r5.getHostName()
            r4[r1] = r5
            java.lang.String r1 = java.lang.String.format(r2, r4)
            android.net.Uri r1 = android.net.Uri.parse(r1)
            android.net.Uri$Builder r1 = r1.buildUpon()
            java.lang.String r9 = r9.getPackageName()
            android.net.Uri$Builder r9 = r1.appendPath(r9)
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.util.Map<java.lang.String, java.lang.Object> r2 = r8.AFInAppEventType
            java.lang.Object r2 = r2.get(r3)
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            java.lang.String r0 = com.appsflyer.internal.af.values(r1, r0)
            java.lang.String r1 = "af_sig"
            android.net.Uri$Builder r9 = r9.appendQueryParameter(r1, r0)
            java.lang.String r0 = com.appsflyer.internal.ae.AFInAppEventType
            java.lang.String r1 = "sdk_version"
            android.net.Uri$Builder r9 = r9.appendQueryParameter(r1, r0)
            android.net.Uri r9 = r9.build()
            java.lang.String r9 = r9.toString()
            r8.AFInAppEventParameterName(r9)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.aq.AFKeystoreWrapper(android.content.Context):void");
    }

    private boolean valueOf() {
        List list = (List) this.AFInAppEventType.get("referrers");
        if ((list != null ? list.size() : 0) >= this.AppsFlyerLib || this.AFInAppEventType.containsKey("referrers")) {
            return false;
        }
        return true;
    }

    public final void values(DeepLinkResult deepLinkResult) {
        try {
            this.onValidateInAppFailure.put("status", deepLinkResult.getStatus().toString());
            this.onValidateInAppFailure.put("timeout_value", onInstallConversionDataLoadedNative);
        } catch (JSONException unused) {
        }
        au auVar = this.onDeepLinking;
        auVar.valueOf.edit().putString("ddl", this.onValidateInAppFailure.toString()).apply();
        ap.AFInAppEventParameterName(deepLinkResult);
    }

    public static /* synthetic */ void AFInAppEventParameterName(aq aqVar) {
        ArrayList<bt> arrayList = new ArrayList<>();
        for (bt btVar : ae.values().onAppOpenAttributionNative) {
            if (!(btVar == null || btVar.AFInAppEventParameterName == bt.e.NOT_STARTED)) {
                arrayList.add(btVar);
            }
        }
        aqVar.AppsFlyerLib = arrayList.size();
        for (final bt btVar2 : arrayList) {
            int i11 = AnonymousClass1.valueOf[btVar2.AFInAppEventParameterName.ordinal()];
            if (i11 == 1) {
                StringBuilder sb2 = new StringBuilder("[DDL] ");
                sb2.append(btVar2.AFKeystoreWrapper.get("source"));
                sb2.append(" referrer collected earlier");
                AFLogger.values(sb2.toString());
                aqVar.valueOf(btVar2);
            } else if (i11 == 2) {
                btVar2.addObserver(new Observer() {
                    public final void update(Observable observable, Object obj) {
                        StringBuilder sb2 = new StringBuilder("[DDL] ");
                        sb2.append(btVar2.AFKeystoreWrapper.get("source"));
                        sb2.append(" referrer collected via observer");
                        AFLogger.values(sb2.toString());
                        aq.this.valueOf((bt) observable);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    public void valueOf(bt btVar) {
        if (AFKeystoreWrapper(btVar)) {
            this.onAppOpenAttribution.add(btVar);
            this.onConversionDataSuccess.countDown();
            StringBuilder sb2 = new StringBuilder("[DDL] Added non-organic ");
            sb2.append(btVar.getClass().getSimpleName());
            AFLogger.values(sb2.toString());
            return;
        }
        int i11 = this.AppsFlyerInAppPurchaseValidatorListener + 1;
        this.AppsFlyerInAppPurchaseValidatorListener = i11;
        if (i11 == this.AppsFlyerLib) {
            this.onConversionDataSuccess.countDown();
        }
    }

    public static /* synthetic */ DeepLinkResult valueOf(aq aqVar, Context context) throws IOException, JSONException, InterruptedException {
        DeepLink deepLink;
        while (true) {
            long currentTimeMillis = System.currentTimeMillis();
            if (aqVar.onDeepLinkingNative == 1) {
                aqVar.onValidateInAppFailure.put("from_fg", currentTimeMillis - aqVar.onDeepLinking.valueOf.getLong("fg_ts", 0));
            }
            HttpURLConnection AFInAppEventType = new m(aqVar).AFInAppEventType();
            JSONArray optJSONArray = aqVar.onValidateInAppFailure.optJSONArray("net");
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            long currentTimeMillis2 = System.currentTimeMillis();
            optJSONArray.put(aqVar.onDeepLinkingNative - 1, currentTimeMillis2 - currentTimeMillis);
            aqVar.onValidateInAppFailure.put("net", optJSONArray);
            if (AFInAppEventType.getResponseCode() == 200) {
                ae.values();
                JSONObject jSONObject = new JSONObject(ae.AFKeystoreWrapper(AFInAppEventType));
                aqVar.AppsFlyerConversionListener = jSONObject.optBoolean("is_second_ping", true);
                if (!jSONObject.optBoolean("found")) {
                    deepLink = null;
                } else {
                    deepLink = DeepLink.AFInAppEventParameterName(jSONObject.optJSONObject("click_event"));
                    deepLink.AFInAppEventParameterName.put("is_deferred", true);
                }
                if (deepLink != null) {
                    return new DeepLinkResult(deepLink, (DeepLinkResult.Error) null);
                }
                if (aqVar.onDeepLinkingNative <= 1 && aqVar.valueOf() && aqVar.AppsFlyerConversionListener) {
                    AFLogger.values("[DDL] Waiting for referrers...");
                    aqVar.onConversionDataSuccess.await();
                    aqVar.onValidateInAppFailure.put("rfr_wait", System.currentTimeMillis() - currentTimeMillis2);
                    if (aqVar.AppsFlyerInAppPurchaseValidatorListener == aqVar.AppsFlyerLib) {
                        return new DeepLinkResult((DeepLink) null, (DeepLinkResult.Error) null);
                    }
                    aqVar.AFKeystoreWrapper(context);
                }
            } else {
                StringBuilder sb2 = new StringBuilder("[DDL] Error occurred. Server response code = ");
                sb2.append(AFInAppEventType.getResponseCode());
                AFLogger.values(sb2.toString());
                return new DeepLinkResult((DeepLink) null, DeepLinkResult.Error.HTTP_STATUS_CODE);
            }
        }
        return new DeepLinkResult((DeepLink) null, (DeepLinkResult.Error) null);
    }

    private static boolean AFKeystoreWrapper(bt btVar) {
        Long l11 = (Long) btVar.AFKeystoreWrapper.get("click_ts");
        if (l11 != null && System.currentTimeMillis() - TimeUnit.SECONDS.toMillis(l11.longValue()) < TimeUnit.DAYS.toMillis(1)) {
            return true;
        }
        return false;
    }
}
