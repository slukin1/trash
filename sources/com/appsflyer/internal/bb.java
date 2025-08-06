package com.appsflyer.internal;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerLib;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.FirebaseMessagingServiceListener;
import com.appsflyer.internal.d;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.ServerProtocol;
import com.google.firebase.messaging.ServiceStarter;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyEnum;
import com.xiaomi.mipush.sdk.Constants;
import java.lang.ref.WeakReference;
import java.net.HttpURLConnection;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class bb extends bf {
    private static String onDeepLinkingNative;
    private final SharedPreferences onInstallConversionDataLoadedNative;

    static {
        StringBuilder sb2 = new StringBuilder("https://%sregister.%s/api/v");
        sb2.append(ae.AFKeystoreWrapper);
        onDeepLinkingNative = sb2.toString();
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public bb(android.content.Context r10) {
        /*
            r9 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = onDeepLinkingNative
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            com.appsflyer.AppsFlyerLib r3 = com.appsflyer.AppsFlyerLib.getInstance()
            java.lang.String r3 = r3.getHostPrefix()
            r4 = 0
            r2[r4] = r3
            com.appsflyer.internal.ae r3 = com.appsflyer.internal.ae.values()
            java.lang.String r3 = r3.getHostName()
            r4 = 1
            r2[r4] = r3
            java.lang.String r1 = java.lang.String.format(r1, r2)
            r0.append(r1)
            java.lang.String r1 = r10.getPackageName()
            r0.append(r1)
            java.lang.String r4 = r0.toString()
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r2 = r9
            r8 = r10
            r2.<init>(r3, r4, r5, r6, r7, r8)
            android.content.SharedPreferences r10 = com.appsflyer.internal.ae.values((android.content.Context) r10)
            r9.onInstallConversionDataLoadedNative = r10
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.bb.<init>(android.content.Context):void");
    }

    public static boolean AFInAppEventParameterName(SharedPreferences sharedPreferences) {
        return sharedPreferences.getBoolean("sentRegisterRequestToAF", false);
    }

    public static boolean values(Context context) {
        if (AppsFlyerLib.getInstance().isStopped()) {
            return false;
        }
        try {
            Class.forName("com.google.firebase.messaging.FirebaseMessagingService");
            if (aa.AFInAppEventParameterName(context, new Intent(ServiceStarter.ACTION_MESSAGING_EVENT, (Uri) null, context, FirebaseMessagingServiceListener.class))) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException unused) {
        } catch (Throwable th2) {
            AFLogger.AFInAppEventType("An error occurred while trying to verify manifest declarations: ", th2);
        }
    }

    public void AFInAppEventType(String str) {
        Application application = this.valueOf;
        final ae values = ae.values();
        if (ae.valueOf()) {
            AFLogger.AFInAppEventType("CustomerUserId not set, Tracking is disabled", true);
            return;
        }
        String AFKeystoreWrapper = ae.AFKeystoreWrapper(AppsFlyerProperties.AF_KEY);
        if (AFKeystoreWrapper == null) {
            AFLogger.init("[registerUninstall] AppsFlyer's SDK cannot send any event without providing DevKey.");
            return;
        }
        PackageManager packageManager = application.getPackageManager();
        try {
            PackageInfo packageInfo = packageManager.getPackageInfo(application.getPackageName(), 0);
            this.AFInAppEventType.put("app_version_code", Integer.toString(packageInfo.versionCode));
            this.AFInAppEventType.put(TPDownloadProxyEnum.USER_APP_VERSION, packageInfo.versionName);
            this.AFInAppEventType.put("app_name", packageManager.getApplicationLabel(packageInfo.applicationInfo).toString());
            long j11 = packageInfo.firstInstallTime;
            this.AFInAppEventType.put("installDate", ae.AFInAppEventParameterName(new SimpleDateFormat("yyyy-MM-dd_HHmmssZ", Locale.US), j11));
        } catch (Throwable th2) {
            AFLogger.AFInAppEventType("Exception while collecting application version info.", th2);
        }
        ae.valueOf((Context) application, (Map<String, ? super String>) this.AFInAppEventType);
        String string = AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.APP_USER_ID);
        if (string != null) {
            this.AFInAppEventType.put("appUserId", string);
        }
        try {
            this.AFInAppEventType.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL);
            this.AFInAppEventType.put("brand", Build.BRAND);
        } catch (Throwable th3) {
            AFLogger.AFInAppEventType("Exception while collecting device brand and model.", th3);
        }
        if (AppsFlyerProperties.getInstance().getBoolean(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, false)) {
            this.AFInAppEventType.put(AppsFlyerProperties.DEVICE_TRACKING_DISABLED, "true");
        }
        d.e.C0074d AFInAppEventParameterName = ab.AFInAppEventParameterName(application.getContentResolver());
        if (AFInAppEventParameterName != null) {
            this.AFInAppEventType.put("amazon_aid", AFInAppEventParameterName.values);
            this.AFInAppEventType.put("amazon_aid_limit", String.valueOf(AFInAppEventParameterName.valueOf));
        }
        String string2 = AppsFlyerProperties.getInstance().getString("advertiserId");
        if (string2 != null) {
            this.AFInAppEventType.put("advertiserId", string2);
        }
        this.AFInAppEventType.put("devkey", AFKeystoreWrapper);
        this.AFInAppEventType.put("uid", an.AFKeystoreWrapper(new WeakReference(application)));
        this.AFInAppEventType.put("af_gcm_token", str);
        this.AFInAppEventType.put("launch_counter", Integer.toString(ae.valueOf(this.onInstallConversionDataLoadedNative, "appsFlyerCount", false)));
        this.AFInAppEventType.put(ServerProtocol.DIALOG_PARAM_SDK_VERSION, Integer.toString(Build.VERSION.SDK_INT));
        String valueOf = values.valueOf((Context) application);
        if (valueOf != null) {
            this.AFInAppEventType.put(AppsFlyerProperties.CHANNEL, valueOf);
        }
        new Thread(new Runnable() {
            public final void run() {
                try {
                    bb bbVar = bb.this;
                    bbVar.onConversionDataFail = values.isStopped();
                    HttpURLConnection AFInAppEventType2 = new m(bbVar).AFInAppEventType();
                    if (AFInAppEventType2 != null) {
                        if (AFInAppEventType2.getResponseCode() == 200) {
                            bb.AFInAppEventType(bb.this);
                        }
                        AFInAppEventType2.disconnect();
                    }
                } catch (Throwable th2) {
                    AFLogger.AFInAppEventType(th2.getMessage(), th2);
                }
            }
        }).start();
    }

    public final void valueOf(String str) {
        if (str != null) {
            AFLogger.AFKeystoreWrapper("Firebase Refreshed Token = ".concat(str));
            l valueOf = valueOf();
            if (valueOf == null || !str.equals(valueOf.values)) {
                long currentTimeMillis = System.currentTimeMillis();
                boolean z11 = ae.values(this.onInstallConversionDataLoadedNative) && (valueOf == null || currentTimeMillis - valueOf.valueOf > TimeUnit.SECONDS.toMillis(2));
                AFInAppEventParameterName(new l(str, currentTimeMillis, !z11));
                if (z11) {
                    AFInAppEventType(str);
                }
            }
        }
    }

    private void AFInAppEventParameterName(l lVar) {
        this.onInstallConversionDataLoadedNative.edit().putString("afUninstallToken", lVar.values).putLong("afUninstallToken_received_time", lVar.valueOf).putBoolean("afUninstallToken_queued", lVar.AFInAppEventParameterName()).apply();
    }

    public l valueOf() {
        String string;
        String string2;
        String string3 = this.onInstallConversionDataLoadedNative.getString("afUninstallToken", (String) null);
        long j11 = this.onInstallConversionDataLoadedNative.getLong("afUninstallToken_received_time", 0);
        boolean z11 = this.onInstallConversionDataLoadedNative.getBoolean("afUninstallToken_queued", false);
        this.onInstallConversionDataLoadedNative.edit().putBoolean("afUninstallToken_queued", false).apply();
        if (string3 == null && (string2 = AppsFlyerProperties.getInstance().getString("afUninstallToken")) != null) {
            String[] split = string2.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            string3 = split[split.length - 1];
        }
        if (j11 == 0 && (string = AppsFlyerProperties.getInstance().getString("afUninstallToken")) != null) {
            String[] split2 = string.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
            if (split2.length >= 2) {
                try {
                    j11 = Long.parseLong(split2[split2.length - 2]);
                } catch (NumberFormatException unused) {
                }
            }
        }
        if (string3 != null) {
            return new l(string3, j11, z11);
        }
        return null;
    }

    public static /* synthetic */ void AFInAppEventType(bb bbVar) {
        bbVar.onInstallConversionDataLoadedNative.edit().putBoolean("sentRegisterRequestToAF", true).apply();
        AFLogger.values("Successfully registered for Uninstall Tracking");
    }
}
