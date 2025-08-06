package com.appsflyer.internal;

import android.content.Context;
import com.adjust.sdk.Constants;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerInAppPurchaseValidatorListener;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import com.tencent.qcloud.tuicore.TUIConstants;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

public final class ad implements Runnable {
    private static String AFInAppEventParameterName = "https://%ssdk-services.%s/validate-android-signature";
    private static String AFInAppEventType;
    private String AFKeystoreWrapper;
    /* access modifiers changed from: private */
    public Map<String, String> AFLogger$LogLevel;
    private String AFVersionDeclaration;
    private String AppsFlyer2dXConversionCallback;
    private String getLevel;
    private String init;
    /* access modifiers changed from: private */
    public WeakReference<Context> valueOf;
    private String values;

    static {
        StringBuilder sb2 = new StringBuilder("https://%svalidate.%s/api/v");
        sb2.append(ae.AFInAppEventType);
        sb2.append("/androidevent?buildnumber=6.3.2&app_id=");
        AFInAppEventType = sb2.toString();
    }

    public ad(Context context, String str, String str2, String str3, String str4, String str5, String str6, Map<String, String> map) {
        this.valueOf = new WeakReference<>(context);
        this.values = str;
        this.AFKeystoreWrapper = str2;
        this.init = str4;
        this.getLevel = str5;
        this.AFVersionDeclaration = str6;
        this.AFLogger$LogLevel = map;
        this.AppsFlyer2dXConversionCallback = str3;
    }

    public static /* synthetic */ void AFInAppEventParameterName(ad adVar, Map map, Map map2, WeakReference weakReference) {
        if (weakReference.get() != null) {
            z.AFKeystoreWrapper((Context) weakReference.get()).AFInAppEventType();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(String.format(AFInAppEventType, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), ae.values().getHostName()}));
            sb2.append(((Context) weakReference.get()).getPackageName());
            String obj = sb2.toString();
            String string = ae.values((Context) weakReference.get()).getString(Constants.REFERRER, "");
            bn bnVar = new bn((Context) weakReference.get());
            bnVar.AFVersionDeclaration = adVar.values;
            bnVar.init = string;
            ae values2 = ae.values();
            Map<String, Object> values3 = values2.values((g) bnVar);
            values3.put(FirebaseAnalytics.Param.PRICE, adVar.getLevel);
            values3.put(FirebaseAnalytics.Param.CURRENCY, adVar.AFVersionDeclaration);
            values3.put("receipt_data", map);
            if (map2 != null) {
                values3.put("extra_prms", map2);
            }
            values3.putAll(values2.AFInAppEventParameterName());
            String jSONObject = new JSONObject(values3).toString();
            aj.valueOf().AFInAppEventType("server_request", obj, jSONObject);
            HttpURLConnection httpURLConnection = null;
            try {
                HttpURLConnection AFKeystoreWrapper2 = AFKeystoreWrapper((bk) bnVar.valueOf(values3).AFInAppEventParameterName(obj));
                int i11 = -1;
                if (AFKeystoreWrapper2 != null) {
                    i11 = AFKeystoreWrapper2.getResponseCode();
                }
                String AFKeystoreWrapper3 = ae.AFKeystoreWrapper(AFKeystoreWrapper2);
                aj.valueOf().AFInAppEventType("server_response", obj, String.valueOf(i11), AFKeystoreWrapper3);
                StringBuilder sb3 = new StringBuilder("Validate-WH response - ");
                sb3.append(i11);
                sb3.append(l.f34627b);
                sb3.append(new JSONObject(AFKeystoreWrapper3).toString());
                AFLogger.AFKeystoreWrapper(sb3.toString());
                if (AFKeystoreWrapper2 != null) {
                    AFKeystoreWrapper2.disconnect();
                }
            } catch (Throwable th2) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th2;
            }
        }
    }

    private static HttpURLConnection AFKeystoreWrapper(bk bkVar) {
        StringBuilder sb2 = new StringBuilder("Calling ");
        sb2.append(bkVar.onAppOpenAttributionNative);
        AFLogger.values(sb2.toString());
        bkVar.onConversionDataFail = AppsFlyerLib.getInstance().isStopped();
        return new m(bkVar).AFInAppEventType();
    }

    public final void run() {
        String str = this.values;
        if (str != null && str.length() != 0 && !AppsFlyerLib.getInstance().isStopped()) {
            HttpURLConnection httpURLConnection = null;
            try {
                Context context = this.valueOf.get();
                if (context != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("public-key", this.AFKeystoreWrapper);
                    hashMap.put("sig-data", this.init);
                    hashMap.put(TUIConstants.TUICalling.PARAM_NAME_AUDIO_SIGNATURE, this.AppsFlyer2dXConversionCallback);
                    final HashMap hashMap2 = new HashMap(hashMap);
                    new Thread(new Runnable() {
                        public final void run() {
                            ad adVar = ad.this;
                            ad.AFInAppEventParameterName(adVar, hashMap2, adVar.AFLogger$LogLevel, ad.this.valueOf);
                        }
                    }).start();
                    hashMap.put("dev_key", this.values);
                    hashMap.put("app_id", context.getPackageName());
                    hashMap.put("uid", AppsFlyerLib.getInstance().getAppsFlyerUID(context));
                    String string = AppsFlyerProperties.getInstance().getString("advertiserId");
                    if (string != null) {
                        hashMap.put("advertiserId", string);
                    }
                    String jSONObject = new JSONObject(hashMap).toString();
                    String format = String.format(AFInAppEventParameterName, new Object[]{AppsFlyerLib.getInstance().getHostPrefix(), ae.values().getHostName()});
                    aj.valueOf().AFInAppEventType("server_request", format, jSONObject);
                    HttpURLConnection AFKeystoreWrapper2 = AFKeystoreWrapper((bk) new bm().valueOf(hashMap).AFInAppEventParameterName(format));
                    int i11 = -1;
                    if (AFKeystoreWrapper2 != null) {
                        i11 = AFKeystoreWrapper2.getResponseCode();
                    }
                    ae.values();
                    String AFKeystoreWrapper3 = ae.AFKeystoreWrapper(AFKeystoreWrapper2);
                    aj.valueOf().AFInAppEventType("server_response", format, String.valueOf(i11), AFKeystoreWrapper3);
                    JSONObject jSONObject2 = new JSONObject(AFKeystoreWrapper3);
                    jSONObject2.put("code", i11);
                    if (i11 == 200) {
                        StringBuilder sb2 = new StringBuilder("Validate response 200 ok: ");
                        sb2.append(jSONObject2.toString());
                        AFLogger.AFKeystoreWrapper(sb2.toString());
                        valueOf(jSONObject2.optBoolean("result"), this.init, this.getLevel, this.AFVersionDeclaration, jSONObject2.toString());
                    } else {
                        AFLogger.AFKeystoreWrapper("Failed Validate request");
                        valueOf(false, this.init, this.getLevel, this.AFVersionDeclaration, jSONObject2.toString());
                    }
                    if (AFKeystoreWrapper2 != null) {
                        AFKeystoreWrapper2.disconnect();
                    }
                }
            } catch (Throwable th2) {
                if (httpURLConnection != null) {
                    httpURLConnection.disconnect();
                }
                throw th2;
            }
        }
    }

    private static void valueOf(boolean z11, String str, String str2, String str3, String str4) {
        if (ae.values != null) {
            StringBuilder sb2 = new StringBuilder("Validate callback parameters: ");
            sb2.append(str);
            sb2.append(" ");
            sb2.append(str2);
            sb2.append(" ");
            sb2.append(str3);
            AFLogger.values(sb2.toString());
            if (z11) {
                AFLogger.values("Validate in app purchase success: ".concat(String.valueOf(str4)));
                ae.values.onValidateInApp();
                return;
            }
            AFLogger.values("Validate in app purchase failed: ".concat(String.valueOf(str4)));
            AppsFlyerInAppPurchaseValidatorListener appsFlyerInAppPurchaseValidatorListener = ae.values;
            if (str4 == null) {
                str4 = "Failed validating";
            }
            appsFlyerInAppPurchaseValidatorListener.onValidateInAppFailure(str4);
        }
    }
}
