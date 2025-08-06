package com.appsflyer.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Color;
import android.os.Build;
import android.text.AndroidCharacter;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewConfiguration;
import com.appsflyer.AppsFlyerProperties;
import com.facebook.devicerequests.internal.DeviceRequestsHelper;
import com.facebook.internal.ServerProtocol;
import com.tencent.thumbplayer.tcmedia.core.downloadproxy.api.TPDownloadProxyEnum;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import javax.net.ssl.HttpsURLConnection;
import net.sf.scuba.smartcards.ISO7816;
import org.json.JSONException;

public abstract class ak implements Runnable {
    public static String AFInAppEventParameterName = null;
    private static int AFLogger$LogLevel = 0;
    private static int AFVersionDeclaration = 0;
    private static int onAppOpenAttributionNative = 1;
    private static short[] onAttributionFailureNative;
    private static int onDeepLinkingNative;
    private static int onInstallConversionDataLoadedNative;
    private static byte[] onInstallConversionFailureNative;
    private static String valueOf = "v2";
    public final String AFInAppEventType;
    public String AFKeystoreWrapper;
    public final String AppsFlyer2dXConversionCallback = UUID.randomUUID().toString();
    public final Map<String, Object> getLevel = valueOf();
    private final Context init;
    private final ae values;

    static {
        values();
        StringBuilder sb2 = new StringBuilder("https://%sonelink.%s/shortlink-sdk/");
        sb2.append(valueOf);
        AFInAppEventParameterName = sb2.toString();
        int i11 = onInstallConversionDataLoadedNative + 43;
        onAppOpenAttributionNative = i11 % 128;
        if (!(i11 % 2 != 0)) {
            int i12 = 74 / 0;
        }
    }

    public ak(ae aeVar, Context context, String str) {
        this.values = aeVar;
        this.init = context;
        this.AFInAppEventType = str;
    }

    private Map<String, Object> valueOf() {
        HashMap hashMap = new HashMap();
        hashMap.put("build_number", "6.3.2");
        hashMap.put("counter", Integer.valueOf(ae.valueOf(ae.values(this.init), "appsFlyerCount", false)));
        hashMap.put(DeviceRequestsHelper.DEVICE_INFO_MODEL, Build.MODEL);
        hashMap.put("brand", Build.BRAND);
        hashMap.put(ServerProtocol.DIALOG_PARAM_SDK_VERSION, Integer.toString(Build.VERSION.SDK_INT));
        try {
            hashMap.put(TPDownloadProxyEnum.USER_APP_VERSION, this.init.getPackageManager().getPackageInfo(this.init.getPackageName(), 0).versionName);
            int i11 = onAppOpenAttributionNative + 101;
            onInstallConversionDataLoadedNative = i11 % 128;
            int i12 = i11 % 2;
        } catch (PackageManager.NameNotFoundException unused) {
        }
        hashMap.put("app_id", this.init.getPackageName());
        hashMap.put("platformextension", new al().AFInAppEventParameterName());
        return hashMap;
    }

    public static void values() {
        AFLogger$LogLevel = 91;
        AFVersionDeclaration = -784549513;
        onDeepLinkingNative = -1400650653;
        onInstallConversionFailureNative = new byte[]{ISO7816.INS_READ_BINARY2, -13, -3, 1, 19, -13, 7, -2, 22, 38, -57, 37};
    }

    public abstract String AFInAppEventParameterName();

    public abstract void AFInAppEventParameterName(HttpsURLConnection httpsURLConnection) throws JSONException, IOException;

    public abstract void AFInAppEventType();

    public abstract void AFKeystoreWrapper(String str);

    /* JADX WARNING: Removed duplicated region for block: B:18:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a4  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x00b5  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r8 = this;
            java.lang.String r0 = ""
            java.lang.String r1 = r8.AFInAppEventParameterName()
            java.lang.String r2 = java.lang.String.valueOf(r1)
            java.lang.String r3 = "oneLinkUrl: "
            java.lang.String r2 = r3.concat(r2)
            com.appsflyer.AFLogger.AFInAppEventParameterName(r2)
            r2 = 1
            r3 = 0
            java.net.URL r4 = new java.net.URL     // Catch:{ all -> 0x0071 }
            r4.<init>(r1)     // Catch:{ all -> 0x0071 }
            java.net.URLConnection r4 = r4.openConnection()     // Catch:{ all -> 0x0071 }
            javax.net.ssl.HttpsURLConnection r4 = (javax.net.ssl.HttpsURLConnection) r4     // Catch:{ all -> 0x0071 }
            java.lang.String r5 = "content-type"
            java.lang.String r6 = "application/json"
            r4.setRequestProperty(r5, r6)     // Catch:{ all -> 0x0071 }
            r5 = 3000(0xbb8, float:4.204E-42)
            r4.setReadTimeout(r5)     // Catch:{ all -> 0x0071 }
            r4.setConnectTimeout(r5)     // Catch:{ all -> 0x0071 }
            java.lang.String r5 = r8.AFInAppEventType     // Catch:{ all -> 0x0071 }
            r4.setRequestMethod(r5)     // Catch:{ all -> 0x0071 }
            r8.AFInAppEventParameterName(r4)     // Catch:{ all -> 0x0071 }
            int r5 = r4.getResponseCode()     // Catch:{ all -> 0x0071 }
            java.lang.String r4 = com.appsflyer.internal.ae.AFKeystoreWrapper((java.net.HttpURLConnection) r4)     // Catch:{ all -> 0x0071 }
            r6 = 200(0xc8, float:2.8E-43)
            if (r5 != r6) goto L_0x0045
            r6 = r2
            goto L_0x0046
        L_0x0045:
            r6 = r3
        L_0x0046:
            if (r6 == 0) goto L_0x0058
            int r5 = onInstallConversionDataLoadedNative
            int r5 = r5 + 107
            int r6 = r5 % 128
            onAppOpenAttributionNative = r6
            int r5 = r5 % 2
            java.lang.String r5 = "Status 200 ok"
            com.appsflyer.AFLogger.AFKeystoreWrapper(r5)     // Catch:{ all -> 0x006f }
            goto L_0x009a
        L_0x0058:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x006f }
            java.lang.String r6 = "Response code = "
            r0.<init>(r6)     // Catch:{ all -> 0x006f }
            r0.append(r5)     // Catch:{ all -> 0x006f }
            java.lang.String r5 = " content = "
            r0.append(r5)     // Catch:{ all -> 0x006f }
            r0.append(r4)     // Catch:{ all -> 0x006f }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x006f }
            goto L_0x009a
        L_0x006f:
            r0 = move-exception
            goto L_0x0075
        L_0x0071:
            r4 = move-exception
            r7 = r4
            r4 = r0
            r0 = r7
        L_0x0075:
            java.lang.String r5 = java.lang.String.valueOf(r1)
            java.lang.String r6 = "Error while calling "
            java.lang.String r5 = r6.concat(r5)
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r5, (java.lang.Throwable) r0)
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>(r6)
            r5.append(r1)
            java.lang.String r1 = " stacktrace: "
            r5.append(r1)
            java.lang.String r0 = r0.toString()
            r5.append(r0)
            java.lang.String r0 = r5.toString()
        L_0x009a:
            boolean r1 = android.text.TextUtils.isEmpty(r0)
            if (r1 == 0) goto L_0x00a1
            goto L_0x00a2
        L_0x00a1:
            r2 = r3
        L_0x00a2:
            if (r2 == 0) goto L_0x00b5
            java.lang.String r0 = java.lang.String.valueOf(r4)
            java.lang.String r1 = "Connection call succeeded: "
            java.lang.String r0 = r1.concat(r0)
            com.appsflyer.AFLogger.AFKeystoreWrapper(r0)
            r8.AFKeystoreWrapper(r4)
            return
        L_0x00b5:
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r1 = "Connection error: "
            java.lang.String r0 = r1.concat(r0)
            com.appsflyer.AFLogger.init(r0)
            r8.AFInAppEventType()
            int r0 = onInstallConversionDataLoadedNative
            int r0 = r0 + 115
            int r1 = r0 % 128
            onAppOpenAttributionNative = r1
            int r0 = r0 % 2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ak.run():void");
    }

    public final void values(HttpsURLConnection httpsURLConnection, String... strArr) {
        ArrayList arrayList = new ArrayList(Arrays.asList(strArr));
        arrayList.add(1, valueOf);
        String join = TextUtils.join("⁣", arrayList.toArray());
        StringBuilder sb2 = new StringBuilder();
        sb2.append(AppsFlyerProperties.getInstance().getString(AppsFlyerProperties.AF_KEY));
        sb2.append(this.AppsFlyer2dXConversionCallback);
        sb2.append(valueOf);
        httpsURLConnection.setRequestProperty(valueOf((byte) (ViewConfiguration.getPressedStateDuration() >> 16), 1400650718 - (ViewConfiguration.getWindowTouchSlop() >> 8), (short) View.getDefaultSize(0, 0), Color.rgb(0, 0, 0) + 801326729, -88 - AndroidCharacter.getEastAsianWidth('0')).intern(), af.values(join, sb2.toString()));
        int i11 = onAppOpenAttributionNative + 33;
        onInstallConversionDataLoadedNative = i11 % 128;
        int i12 = i11 % 2;
    }

    private static String valueOf(byte b11, int i11, short s11, int i12, int i13) {
        int i14;
        int i15;
        StringBuilder sb2 = new StringBuilder();
        int i16 = AFLogger$LogLevel;
        int i17 = i13 + i16;
        int i18 = 0;
        boolean z11 = (i17 == -1 ? 17 : ';') == 17;
        if (z11) {
            byte[] bArr = onInstallConversionFailureNative;
            if (bArr != null) {
                i17 = (byte) (bArr[AFVersionDeclaration + i12] + i16);
            } else {
                i17 = (short) (onAttributionFailureNative[AFVersionDeclaration + i12] + i16);
            }
        }
        if (i17 > 0) {
            int i19 = ((i12 + i17) - 2) + AFVersionDeclaration;
            if (z11) {
                i18 = 1;
            }
            int i21 = i19 + i18;
            char c11 = (char) (i11 + onDeepLinkingNative);
            sb2.append(c11);
            for (int i22 = 1; i22 < i17; i22++) {
                int i23 = onAppOpenAttributionNative;
                int i24 = i23 + 45;
                onInstallConversionDataLoadedNative = i24 % 128;
                int i25 = i24 % 2;
                byte[] bArr2 = onInstallConversionFailureNative;
                if ((bArr2 != null ? 19 : '.') != 19) {
                    c11 = (char) (c11 + (((short) (onAttributionFailureNative[i21] + s11)) ^ b11));
                    int i26 = i23 + 11;
                    onInstallConversionDataLoadedNative = i26 % 128;
                    int i27 = i26 % 2;
                    i21--;
                } else {
                    int i28 = i23 + 17;
                    onInstallConversionDataLoadedNative = i28 % 128;
                    if (i28 % 2 != 0) {
                        i15 = i21 + 119;
                        i14 = c11 >> (((byte) (bArr2[i21] >>> s11)) | b11);
                    } else {
                        i15 = i21 - 1;
                        i14 = c11 + (((byte) (bArr2[i21] + s11)) ^ b11);
                    }
                    c11 = (char) i14;
                    i21 = i15;
                }
                sb2.append(c11);
            }
        }
        String obj = sb2.toString();
        int i29 = onAppOpenAttributionNative + 25;
        onInstallConversionDataLoadedNative = i29 % 128;
        int i30 = i29 % 2;
        return obj;
    }
}
