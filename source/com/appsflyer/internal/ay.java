package com.appsflyer.internal;

import android.app.Application;
import com.appsflyer.AFLogger;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.atomic.AtomicInteger;

public final class ay implements Runnable {
    private static String valueOf = "https://%sgcdsdk.%s/install_data/v4.0/";
    private static final List<String> values = Arrays.asList(new String[]{"googleplay", "playstore", "googleplaystore"});
    private final String AFInAppEventParameterName;
    public final ScheduledExecutorService AFInAppEventType;
    private final Application AFKeystoreWrapper;
    private final ae AFLogger$LogLevel;
    private final int AFVersionDeclaration;
    private final AtomicInteger getLevel;

    public ay(ae aeVar, Application application, String str) {
        if (k.valueOf == null) {
            k.valueOf = new k();
        }
        this.AFInAppEventType = k.valueOf.AFInAppEventParameterName();
        this.getLevel = new AtomicInteger(0);
        this.AFLogger$LogLevel = aeVar;
        this.AFKeystoreWrapper = application;
        this.AFInAppEventParameterName = str;
        this.AFVersionDeclaration = 0;
    }

    public static void AFInAppEventParameterName(String str) {
        if (ae.valueOf != null) {
            AFLogger.values("[GCD-A02] Calling onConversionFailure with:\n".concat(String.valueOf(str)));
            ae.valueOf.onConversionDataFail(str);
        }
    }

    public static void AFInAppEventType(Map<String, Object> map) {
        StringBuilder sb2 = new StringBuilder("[GCD-A02] Calling onConversionDataSuccess with:\n");
        sb2.append(map.toString());
        AFLogger.values(sb2.toString());
        ae.valueOf.onConversionDataSuccess(map);
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0120 A[Catch:{ az -> 0x025b, all -> 0x0284 }] */
    /* JADX WARNING: Removed duplicated region for block: B:42:0x018e A[Catch:{ az -> 0x025b, all -> 0x0284 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x028c A[Catch:{ all -> 0x02be }] */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x029b A[Catch:{ all -> 0x02be }] */
    /* JADX WARNING: Removed duplicated region for block: B:92:0x02b0 A[DONT_GENERATE] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void run() {
        /*
            r16 = this;
            r1 = r16
            java.lang.String r0 = "is_first_launch"
            java.lang.String r2 = "af_siteid"
            java.lang.String r3 = r1.AFInAppEventParameterName
            if (r3 == 0) goto L_0x02ca
            int r3 = r3.length()
            if (r3 != 0) goto L_0x0012
            goto L_0x02ca
        L_0x0012:
            com.appsflyer.internal.ae r3 = r1.AFLogger$LogLevel
            boolean r3 = r3.isStopped()
            if (r3 == 0) goto L_0x0025
            java.lang.String r0 = "[GCD-E03] 'isStopTracking' enabled"
            com.appsflyer.AFLogger.values((java.lang.String) r0)
            java.lang.String r0 = "'isStopTracking' enabled"
            AFInAppEventParameterName(r0)
            return
        L_0x0025:
            java.util.concurrent.atomic.AtomicInteger r3 = r1.getLevel
            r3.incrementAndGet()
            r3 = 0
            r6 = 2
            android.app.Application r7 = r1.AFKeystoreWrapper     // Catch:{ all -> 0x0287 }
            if (r7 != 0) goto L_0x0040
            java.lang.String r0 = "[GCD-E06] Context null"
            com.appsflyer.AFLogger.values((java.lang.String) r0)     // Catch:{ all -> 0x0287 }
            java.lang.String r0 = "Context null"
            AFInAppEventParameterName(r0)     // Catch:{ all -> 0x0287 }
            java.util.concurrent.atomic.AtomicInteger r0 = r1.getLevel
            r0.decrementAndGet()
            return
        L_0x0040:
            com.appsflyer.internal.ae r8 = r1.AFLogger$LogLevel     // Catch:{ all -> 0x0287 }
            java.lang.String r9 = r8.valueOf((android.content.Context) r7)     // Catch:{ all -> 0x0287 }
            java.lang.String r7 = r8.AFKeystoreWrapper((android.content.Context) r7, (java.lang.String) r9)     // Catch:{ all -> 0x0287 }
            java.lang.String r8 = ""
            r9 = 1
            r10 = 0
            if (r7 == 0) goto L_0x0070
            java.util.List<java.lang.String> r11 = values     // Catch:{ all -> 0x0287 }
            java.lang.String r12 = r7.toLowerCase()     // Catch:{ all -> 0x0287 }
            boolean r11 = r11.contains(r12)     // Catch:{ all -> 0x0287 }
            if (r11 != 0) goto L_0x0063
            java.lang.String r11 = "-"
            java.lang.String r7 = r11.concat(r7)     // Catch:{ all -> 0x0287 }
            goto L_0x0071
        L_0x0063:
            java.lang.String r11 = "AF detected using redundant Google-Play channel for attribution - %s. Using without channel postfix."
            java.lang.Object[] r12 = new java.lang.Object[r9]     // Catch:{ all -> 0x0287 }
            r12[r10] = r7     // Catch:{ all -> 0x0287 }
            java.lang.String r7 = java.lang.String.format(r11, r12)     // Catch:{ all -> 0x0287 }
            com.appsflyer.AFLogger.init(r7)     // Catch:{ all -> 0x0287 }
        L_0x0070:
            r7 = r8
        L_0x0071:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x0287 }
            r11.<init>()     // Catch:{ all -> 0x0287 }
            java.lang.String r12 = valueOf     // Catch:{ all -> 0x0287 }
            java.lang.Object[] r13 = new java.lang.Object[r6]     // Catch:{ all -> 0x0287 }
            com.appsflyer.AppsFlyerLib r14 = com.appsflyer.AppsFlyerLib.getInstance()     // Catch:{ all -> 0x0287 }
            java.lang.String r14 = r14.getHostPrefix()     // Catch:{ all -> 0x0287 }
            r13[r10] = r14     // Catch:{ all -> 0x0287 }
            com.appsflyer.internal.ae r14 = com.appsflyer.internal.ae.values()     // Catch:{ all -> 0x0287 }
            java.lang.String r14 = r14.getHostName()     // Catch:{ all -> 0x0287 }
            r13[r9] = r14     // Catch:{ all -> 0x0287 }
            java.lang.String r12 = java.lang.String.format(r12, r13)     // Catch:{ all -> 0x0287 }
            r11.append(r12)     // Catch:{ all -> 0x0287 }
            android.app.Application r12 = r1.AFKeystoreWrapper     // Catch:{ all -> 0x0287 }
            java.lang.String r12 = r12.getPackageName()     // Catch:{ all -> 0x0287 }
            r11.append(r12)     // Catch:{ all -> 0x0287 }
            r11.append(r7)     // Catch:{ all -> 0x0287 }
            java.lang.String r7 = "?devkey="
            r11.append(r7)     // Catch:{ all -> 0x0287 }
            java.lang.String r7 = r1.AFInAppEventParameterName     // Catch:{ all -> 0x0287 }
            r11.append(r7)     // Catch:{ all -> 0x0287 }
            java.lang.String r7 = "&device_id="
            r11.append(r7)     // Catch:{ all -> 0x0287 }
            java.lang.ref.WeakReference r7 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0287 }
            android.app.Application r12 = r1.AFKeystoreWrapper     // Catch:{ all -> 0x0287 }
            r7.<init>(r12)     // Catch:{ all -> 0x0287 }
            java.lang.String r7 = com.appsflyer.internal.an.AFKeystoreWrapper(r7)     // Catch:{ all -> 0x0287 }
            r11.append(r7)     // Catch:{ all -> 0x0287 }
            java.lang.String r7 = r11.toString()     // Catch:{ all -> 0x0287 }
            com.appsflyer.internal.aj r11 = com.appsflyer.internal.aj.valueOf()     // Catch:{ all -> 0x0287 }
            java.lang.String r12 = "server_request"
            java.lang.String[] r8 = new java.lang.String[]{r8}     // Catch:{ all -> 0x0287 }
            r11.AFInAppEventType(r12, r7, r8)     // Catch:{ all -> 0x0287 }
            java.lang.String r8 = "[GCD-B01] URL: "
            java.lang.String r11 = java.lang.String.valueOf(r7)     // Catch:{ all -> 0x0287 }
            java.lang.String r8 = r8.concat(r11)     // Catch:{ all -> 0x0287 }
            com.appsflyer.internal.am.AFKeystoreWrapper(r8)     // Catch:{ all -> 0x0287 }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0287 }
            java.net.URL r8 = new java.net.URL     // Catch:{ all -> 0x0287 }
            r8.<init>(r7)     // Catch:{ all -> 0x0287 }
            java.net.URLConnection r8 = r8.openConnection()     // Catch:{ all -> 0x0287 }
            java.net.HttpURLConnection r8 = (java.net.HttpURLConnection) r8     // Catch:{ all -> 0x0287 }
            java.lang.String r3 = "GET"
            r8.setRequestMethod(r3)     // Catch:{ all -> 0x0284 }
            r3 = 10000(0x2710, float:1.4013E-41)
            r8.setConnectTimeout(r3)     // Catch:{ all -> 0x0284 }
            java.lang.String r3 = "Connection"
            java.lang.String r13 = "close"
            r8.setRequestProperty(r3, r13)     // Catch:{ all -> 0x0284 }
            r8.connect()     // Catch:{ all -> 0x0284 }
            int r3 = r8.getResponseCode()     // Catch:{ all -> 0x0284 }
            java.lang.String r13 = com.appsflyer.internal.ae.AFKeystoreWrapper((java.net.HttpURLConnection) r8)     // Catch:{ all -> 0x0284 }
            com.appsflyer.internal.aj r14 = com.appsflyer.internal.aj.valueOf()     // Catch:{ all -> 0x0284 }
            java.lang.String r15 = "server_response"
            java.lang.String[] r4 = new java.lang.String[r6]     // Catch:{ all -> 0x0284 }
            java.lang.String r5 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0284 }
            r4[r10] = r5     // Catch:{ all -> 0x0284 }
            r4[r9] = r13     // Catch:{ all -> 0x0284 }
            r14.AFInAppEventType(r15, r7, r4)     // Catch:{ all -> 0x0284 }
            r4 = 200(0xc8, float:2.8E-43)
            r5 = 404(0x194, float:5.66E-43)
            if (r3 == r4) goto L_0x014e
            if (r3 != r5) goto L_0x0123
            goto L_0x014e
        L_0x0123:
            r0 = 403(0x193, float:5.65E-43)
            if (r3 == r0) goto L_0x012b
            r0 = 500(0x1f4, float:7.0E-43)
            if (r3 < r0) goto L_0x013f
        L_0x012b:
            int r0 = r1.AFVersionDeclaration     // Catch:{ all -> 0x0284 }
            if (r0 >= r6) goto L_0x013f
            com.appsflyer.internal.ay r0 = new com.appsflyer.internal.ay     // Catch:{ all -> 0x0284 }
            r0.<init>(r1)     // Catch:{ all -> 0x0284 }
            java.util.concurrent.ScheduledExecutorService r2 = r0.AFInAppEventType     // Catch:{ all -> 0x0284 }
            java.util.concurrent.TimeUnit r3 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x0284 }
            r4 = 10
            com.appsflyer.internal.ae.AFInAppEventType(r2, r0, r4, r3)     // Catch:{ all -> 0x0284 }
            goto L_0x027b
        L_0x013f:
            java.lang.String r0 = "Error connection to server: "
            java.lang.String r2 = java.lang.String.valueOf(r3)     // Catch:{ all -> 0x0284 }
            java.lang.String r0 = r0.concat(r2)     // Catch:{ all -> 0x0284 }
            AFInAppEventParameterName(r0)     // Catch:{ all -> 0x0284 }
            goto L_0x027b
        L_0x014e:
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ all -> 0x0284 }
            r4.<init>()     // Catch:{ all -> 0x0284 }
            java.lang.String r7 = "net"
            long r14 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0284 }
            long r14 = r14 - r11
            r4.put(r7, r14)     // Catch:{ all -> 0x0284 }
            java.lang.String r7 = "retries"
            int r11 = r1.AFVersionDeclaration     // Catch:{ all -> 0x0284 }
            r4.put(r7, r11)     // Catch:{ all -> 0x0284 }
            com.appsflyer.internal.ae r7 = r1.AFLogger$LogLevel     // Catch:{ all -> 0x0284 }
            com.appsflyer.internal.au r7 = r7.init     // Catch:{ all -> 0x0284 }
            java.lang.String r11 = "gcd"
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0284 }
            android.content.SharedPreferences r7 = r7.valueOf     // Catch:{ all -> 0x0284 }
            android.content.SharedPreferences$Editor r7 = r7.edit()     // Catch:{ all -> 0x0284 }
            android.content.SharedPreferences$Editor r4 = r7.putString(r11, r4)     // Catch:{ all -> 0x0284 }
            r4.apply()     // Catch:{ all -> 0x0284 }
            java.lang.String r4 = "Attribution data: "
            java.lang.String r7 = java.lang.String.valueOf(r13)     // Catch:{ all -> 0x0284 }
            java.lang.String r4 = r4.concat(r7)     // Catch:{ all -> 0x0284 }
            com.appsflyer.internal.am.AFKeystoreWrapper(r4)     // Catch:{ all -> 0x0284 }
            int r4 = r13.length()     // Catch:{ all -> 0x0284 }
            if (r4 <= 0) goto L_0x027b
            java.util.Map r4 = com.appsflyer.internal.ba.valueOf(r13)     // Catch:{ all -> 0x0284 }
            java.lang.String r7 = "iscache"
            java.lang.Object r7 = r4.get(r7)     // Catch:{ all -> 0x0284 }
            java.lang.Boolean r7 = (java.lang.Boolean) r7     // Catch:{ all -> 0x0284 }
            if (r3 != r5) goto L_0x01b4
            java.lang.String r3 = "error_reason"
            r4.remove(r3)     // Catch:{ all -> 0x0284 }
            java.lang.String r3 = "status_code"
            r4.remove(r3)     // Catch:{ all -> 0x0284 }
            java.lang.String r3 = "af_status"
            java.lang.String r5 = "Organic"
            r4.put(r3, r5)     // Catch:{ all -> 0x0284 }
            java.lang.String r3 = "af_message"
            java.lang.String r5 = "organic install"
            r4.put(r3, r5)     // Catch:{ all -> 0x0284 }
        L_0x01b4:
            if (r7 == 0) goto L_0x01c9
            boolean r3 = r7.booleanValue()     // Catch:{ all -> 0x0284 }
            if (r3 != 0) goto L_0x01c9
            com.appsflyer.internal.ae r3 = r1.AFLogger$LogLevel     // Catch:{ all -> 0x0284 }
            android.app.Application r5 = r1.AFKeystoreWrapper     // Catch:{ all -> 0x0284 }
            java.lang.String r7 = "appsflyerConversionDataCacheExpiration"
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0284 }
            r3.valueOf((android.content.Context) r5, (java.lang.String) r7, (long) r11)     // Catch:{ all -> 0x0284 }
        L_0x01c9:
            boolean r3 = r4.containsKey(r2)     // Catch:{ all -> 0x0284 }
            java.lang.String r5 = "[Invite] Detected App-Invite via channel: "
            java.lang.String r7 = "af_channel"
            if (r3 == 0) goto L_0x01fe
            boolean r3 = r4.containsKey(r7)     // Catch:{ all -> 0x0284 }
            if (r3 == 0) goto L_0x01ed
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0284 }
            r3.<init>(r5)     // Catch:{ all -> 0x0284 }
            java.lang.Object r11 = r4.get(r7)     // Catch:{ all -> 0x0284 }
            r3.append(r11)     // Catch:{ all -> 0x0284 }
            java.lang.String r3 = r3.toString()     // Catch:{ all -> 0x0284 }
            com.appsflyer.AFLogger.values((java.lang.String) r3)     // Catch:{ all -> 0x0284 }
            goto L_0x01fe
        L_0x01ed:
            java.lang.String r3 = "[CrossPromotion] App was installed via %s's Cross Promotion"
            java.lang.Object[] r11 = new java.lang.Object[r9]     // Catch:{ all -> 0x0284 }
            java.lang.Object r12 = r4.get(r2)     // Catch:{ all -> 0x0284 }
            r11[r10] = r12     // Catch:{ all -> 0x0284 }
            java.lang.String r3 = java.lang.String.format(r3, r11)     // Catch:{ all -> 0x0284 }
            com.appsflyer.AFLogger.values((java.lang.String) r3)     // Catch:{ all -> 0x0284 }
        L_0x01fe:
            boolean r2 = r4.containsKey(r2)     // Catch:{ all -> 0x0284 }
            if (r2 == 0) goto L_0x0217
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0284 }
            r2.<init>(r5)     // Catch:{ all -> 0x0284 }
            java.lang.Object r3 = r4.get(r7)     // Catch:{ all -> 0x0284 }
            r2.append(r3)     // Catch:{ all -> 0x0284 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0284 }
            com.appsflyer.AFLogger.values((java.lang.String) r2)     // Catch:{ all -> 0x0284 }
        L_0x0217:
            java.lang.Boolean r2 = java.lang.Boolean.FALSE     // Catch:{ all -> 0x0284 }
            r4.put(r0, r2)     // Catch:{ all -> 0x0284 }
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch:{ all -> 0x0284 }
            r2.<init>(r4)     // Catch:{ all -> 0x0284 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0284 }
            java.lang.String r3 = "attributionId"
            if (r2 == 0) goto L_0x022f
            android.app.Application r5 = r1.AFKeystoreWrapper     // Catch:{ all -> 0x0284 }
            com.appsflyer.internal.ae.AFKeystoreWrapper((android.content.Context) r5, (java.lang.String) r3, (java.lang.String) r2)     // Catch:{ all -> 0x0284 }
            goto L_0x0234
        L_0x022f:
            android.app.Application r2 = r1.AFKeystoreWrapper     // Catch:{ all -> 0x0284 }
            com.appsflyer.internal.ae.AFKeystoreWrapper((android.content.Context) r2, (java.lang.String) r3, (java.lang.String) r13)     // Catch:{ all -> 0x0284 }
        L_0x0234:
            com.appsflyer.AppsFlyerConversionListener r2 = com.appsflyer.internal.ae.valueOf     // Catch:{ all -> 0x0284 }
            if (r2 == 0) goto L_0x027b
            java.util.concurrent.atomic.AtomicInteger r2 = r1.getLevel     // Catch:{ all -> 0x0284 }
            int r2 = r2.intValue()     // Catch:{ all -> 0x0284 }
            if (r2 > r9) goto L_0x027b
            android.app.Application r2 = r1.AFKeystoreWrapper     // Catch:{ az -> 0x025b }
            java.util.Map r2 = com.appsflyer.internal.ba.values(r2)     // Catch:{ az -> 0x025b }
            android.app.Application r3 = r1.AFKeystoreWrapper     // Catch:{ az -> 0x025b }
            android.content.SharedPreferences r3 = com.appsflyer.internal.ae.values((android.content.Context) r3)     // Catch:{ az -> 0x025b }
            java.lang.String r5 = "sixtyDayConversionData"
            boolean r3 = r3.getBoolean(r5, r10)     // Catch:{ az -> 0x025b }
            if (r3 != 0) goto L_0x0259
            java.lang.Boolean r3 = java.lang.Boolean.TRUE     // Catch:{ az -> 0x025b }
            r2.put(r0, r3)     // Catch:{ az -> 0x025b }
        L_0x0259:
            r4 = r2
            goto L_0x0261
        L_0x025b:
            r0 = move-exception
            java.lang.String r2 = "Exception while trying to fetch attribution data. "
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r2, (java.lang.Throwable) r0)     // Catch:{ all -> 0x0284 }
        L_0x0261:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0284 }
            java.lang.String r2 = "[GCD-A02] Calling onConversionDataSuccess with:\n"
            r0.<init>(r2)     // Catch:{ all -> 0x0284 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0284 }
            r0.append(r2)     // Catch:{ all -> 0x0284 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0284 }
            com.appsflyer.AFLogger.values((java.lang.String) r0)     // Catch:{ all -> 0x0284 }
            com.appsflyer.AppsFlyerConversionListener r0 = com.appsflyer.internal.ae.valueOf     // Catch:{ all -> 0x0284 }
            r0.onConversionDataSuccess(r4)     // Catch:{ all -> 0x0284 }
        L_0x027b:
            java.util.concurrent.atomic.AtomicInteger r0 = r1.getLevel
            r0.decrementAndGet()
            r8.disconnect()
            goto L_0x02b3
        L_0x0284:
            r0 = move-exception
            r3 = r8
            goto L_0x0288
        L_0x0287:
            r0 = move-exception
        L_0x0288:
            int r2 = r1.AFVersionDeclaration     // Catch:{ all -> 0x02be }
            if (r2 >= r6) goto L_0x029b
            com.appsflyer.internal.ay r2 = new com.appsflyer.internal.ay     // Catch:{ all -> 0x02be }
            r2.<init>(r1)     // Catch:{ all -> 0x02be }
            java.util.concurrent.ScheduledExecutorService r4 = r2.AFInAppEventType     // Catch:{ all -> 0x02be }
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x02be }
            r6 = 10
            com.appsflyer.internal.ae.AFInAppEventType(r4, r2, r6, r5)     // Catch:{ all -> 0x02be }
            goto L_0x02a2
        L_0x029b:
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x02be }
            AFInAppEventParameterName(r2)     // Catch:{ all -> 0x02be }
        L_0x02a2:
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x02be }
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r2, (java.lang.Throwable) r0)     // Catch:{ all -> 0x02be }
            java.util.concurrent.atomic.AtomicInteger r0 = r1.getLevel
            r0.decrementAndGet()
            if (r3 == 0) goto L_0x02b3
            r3.disconnect()
        L_0x02b3:
            java.util.concurrent.ScheduledExecutorService r0 = r1.AFInAppEventType
            r0.shutdown()
            java.lang.String r0 = "[GCD-A03] Server retrieving attempt finished"
            com.appsflyer.AFLogger.values((java.lang.String) r0)
            return
        L_0x02be:
            r0 = move-exception
            java.util.concurrent.atomic.AtomicInteger r2 = r1.getLevel
            r2.decrementAndGet()
            if (r3 == 0) goto L_0x02c9
            r3.disconnect()
        L_0x02c9:
            throw r0
        L_0x02ca:
            java.lang.String r0 = "[GCD-E05] AppsFlyer dev key is missing"
            com.appsflyer.AFLogger.values((java.lang.String) r0)
            java.lang.String r0 = "AppsFlyer dev key is missing"
            AFInAppEventParameterName(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ay.run():void");
    }

    private ay(ay ayVar) {
        if (k.valueOf == null) {
            k.valueOf = new k();
        }
        this.AFInAppEventType = k.valueOf.AFInAppEventParameterName();
        this.getLevel = new AtomicInteger(0);
        this.AFLogger$LogLevel = ayVar.AFLogger$LogLevel;
        this.AFKeystoreWrapper = ayVar.AFKeystoreWrapper;
        this.AFInAppEventParameterName = ayVar.AFInAppEventParameterName;
        this.AFVersionDeclaration = ayVar.AFVersionDeclaration + 1;
    }
}
