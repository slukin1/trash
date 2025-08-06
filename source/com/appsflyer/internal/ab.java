package com.appsflyer.internal;

import android.content.ContentResolver;
import android.os.Build;
import android.provider.Settings;
import com.appsflyer.AFLogger;
import com.appsflyer.AppsFlyerProperties;
import com.appsflyer.internal.d;

public final class ab {
    public static Boolean AFInAppEventType;
    public static String valueOf;

    public static d.e.C0074d AFInAppEventParameterName(ContentResolver contentResolver) {
        String str;
        if (!AFKeystoreWrapper() || contentResolver == null || AppsFlyerProperties.getInstance().getString("amazon_aid") != null || !"Amazon".equals(Build.MANUFACTURER)) {
            return null;
        }
        int i11 = Settings.Secure.getInt(contentResolver, "limit_ad_tracking", 2);
        if (i11 == 0) {
            return new d.e.C0074d(Settings.Secure.getString(contentResolver, "advertising_id"), Boolean.FALSE);
        }
        if (i11 == 2) {
            return null;
        }
        try {
            str = Settings.Secure.getString(contentResolver, "advertising_id");
        } catch (Throwable th2) {
            AFLogger.AFInAppEventType("Couldn't fetch Amazon Advertising ID (Ad-Tracking is limited!)", th2);
            str = "";
        }
        return new d.e.C0074d(str, Boolean.TRUE);
    }

    private static boolean AFKeystoreWrapper() {
        Boolean bool = AFInAppEventType;
        return bool == null || bool.booleanValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0039, code lost:
        if (r8.length() == 0) goto L_0x003b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0087 A[SYNTHETIC, Splitter:B:32:0x0087] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0121  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.appsflyer.internal.d.e.C0074d valueOf(android.content.Context r12, java.util.Map<java.lang.String, java.lang.Object> r13) {
        /*
            java.lang.String r0 = "advertiserIdEnabled"
            java.lang.String r1 = "advertiserId"
            boolean r2 = AFKeystoreWrapper()
            r3 = 0
            if (r2 != 0) goto L_0x000c
            return r3
        L_0x000c:
            java.lang.String r2 = "Trying to fetch GAID.."
            com.appsflyer.AFLogger.AFKeystoreWrapper(r2)
            r2 = 0
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            r5 = -1
            com.google.android.gms.common.GoogleApiAvailability r6 = com.google.android.gms.common.GoogleApiAvailability.getInstance()     // Catch:{ all -> 0x0020 }
            int r5 = r6.isGooglePlayServicesAvailable(r12)     // Catch:{ all -> 0x0020 }
        L_0x0020:
            r6 = 1
            com.google.android.gms.ads.identifier.AdvertisingIdClient$Info r7 = com.google.android.gms.ads.identifier.AdvertisingIdClient.getAdvertisingIdInfo(r12)     // Catch:{ all -> 0x005a }
            if (r7 == 0) goto L_0x004d
            java.lang.String r8 = r7.getId()     // Catch:{ all -> 0x005a }
            boolean r7 = r7.isLimitAdTrackingEnabled()     // Catch:{ all -> 0x0047 }
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r7)     // Catch:{ all -> 0x0047 }
            if (r8 == 0) goto L_0x003b
            int r2 = r8.length()     // Catch:{ all -> 0x0043 }
            if (r2 != 0) goto L_0x0040
        L_0x003b:
            java.lang.String r2 = "emptyOrNull |"
            r4.append(r2)     // Catch:{ all -> 0x0043 }
        L_0x0040:
            r2 = r6
            goto L_0x00ed
        L_0x0043:
            r2 = move-exception
            r7 = r3
            r3 = r6
            goto L_0x005f
        L_0x0047:
            r7 = move-exception
            r11 = r3
            r3 = r2
            r2 = r7
            r7 = r11
            goto L_0x005f
        L_0x004d:
            java.lang.String r7 = "gpsAdInfo-null |"
            r4.append(r7)     // Catch:{ all -> 0x005a }
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException     // Catch:{ all -> 0x005a }
            java.lang.String r8 = "GpsAdIndo is null"
            r7.<init>(r8)     // Catch:{ all -> 0x005a }
            throw r7     // Catch:{ all -> 0x005a }
        L_0x005a:
            r7 = move-exception
            r8 = r3
            r3 = r2
            r2 = r7
            r7 = r8
        L_0x005f:
            java.lang.String r9 = r2.getMessage()
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r9, (java.lang.Throwable) r2)
            java.lang.Class r2 = r2.getClass()
            java.lang.String r2 = r2.getSimpleName()
            r4.append(r2)
            java.lang.String r2 = " |"
            r4.append(r2)
            java.lang.String r9 = "WARNING: Google Play Services is missing."
            com.appsflyer.AFLogger.AFKeystoreWrapper(r9)
            com.appsflyer.AppsFlyerProperties r9 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r10 = "enableGpsFallback"
            boolean r9 = r9.getBoolean(r10, r6)
            if (r9 == 0) goto L_0x00eb
            com.appsflyer.internal.ac$c r7 = com.appsflyer.internal.ac.AFInAppEventParameterName(r12)     // Catch:{ all -> 0x00a3 }
            java.lang.String r8 = r7.valueOf     // Catch:{ all -> 0x00a3 }
            boolean r7 = r7.AFInAppEventParameterName()     // Catch:{ all -> 0x00a3 }
            java.lang.Boolean r7 = java.lang.Boolean.valueOf(r7)     // Catch:{ all -> 0x00a3 }
            if (r8 == 0) goto L_0x009d
            int r9 = r8.length()     // Catch:{ all -> 0x00a3 }
            if (r9 != 0) goto L_0x00eb
        L_0x009d:
            java.lang.String r9 = "emptyOrNull (bypass) |"
            r4.append(r9)     // Catch:{ all -> 0x00a3 }
            goto L_0x00eb
        L_0x00a3:
            r7 = move-exception
            java.lang.String r8 = r7.getMessage()
            com.appsflyer.AFLogger.AFInAppEventType((java.lang.String) r8, (java.lang.Throwable) r7)
            java.lang.Class r8 = r7.getClass()
            java.lang.String r8 = r8.getSimpleName()
            r4.append(r8)
            r4.append(r2)
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r8 = r2.getString(r1)
            com.appsflyer.AppsFlyerProperties r2 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r2 = r2.getString(r0)
            boolean r2 = java.lang.Boolean.parseBoolean(r2)
            r2 = r2 ^ r6
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.String r9 = r7.getLocalizedMessage()
            if (r9 == 0) goto L_0x00e0
            java.lang.String r7 = r7.getLocalizedMessage()
            com.appsflyer.AFLogger.AFKeystoreWrapper(r7)
            goto L_0x00e7
        L_0x00e0:
            java.lang.String r7 = r7.toString()
            com.appsflyer.AFLogger.AFKeystoreWrapper(r7)
        L_0x00e7:
            r11 = r3
            r3 = r2
            r2 = r11
            goto L_0x00ed
        L_0x00eb:
            r2 = r3
            r3 = r7
        L_0x00ed:
            java.lang.Class r12 = r12.getClass()
            java.lang.String r12 = r12.getName()
            java.lang.String r7 = "android.app.ReceiverRestrictedContext"
            boolean r12 = r12.equals(r7)
            if (r12 == 0) goto L_0x011b
            com.appsflyer.AppsFlyerProperties r12 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r8 = r12.getString(r1)
            com.appsflyer.AppsFlyerProperties r12 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r12 = r12.getString(r0)
            boolean r12 = java.lang.Boolean.parseBoolean(r12)
            r12 = r12 ^ r6
            java.lang.Boolean r3 = java.lang.Boolean.valueOf(r12)
            java.lang.String r12 = "context = android.app.ReceiverRestrictedContext |"
            r4.append(r12)
        L_0x011b:
            int r12 = r4.length()
            if (r12 <= 0) goto L_0x013a
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r5)
            java.lang.String r5 = ": "
            r12.append(r5)
            r12.append(r4)
            java.lang.String r12 = r12.toString()
            java.lang.String r4 = "gaidError"
            r13.put(r4, r12)
        L_0x013a:
            if (r8 == 0) goto L_0x016d
            if (r3 == 0) goto L_0x016d
            r13.put(r1, r8)
            boolean r12 = r3.booleanValue()
            r12 = r12 ^ r6
            java.lang.String r12 = java.lang.String.valueOf(r12)
            r13.put(r0, r12)
            com.appsflyer.AppsFlyerProperties r12 = com.appsflyer.AppsFlyerProperties.getInstance()
            r12.set((java.lang.String) r1, (java.lang.String) r8)
            com.appsflyer.AppsFlyerProperties r12 = com.appsflyer.AppsFlyerProperties.getInstance()
            boolean r1 = r3.booleanValue()
            r1 = r1 ^ r6
            java.lang.String r1 = java.lang.String.valueOf(r1)
            r12.set((java.lang.String) r0, (java.lang.String) r1)
            java.lang.String r12 = java.lang.String.valueOf(r2)
            java.lang.String r0 = "isGaidWithGps"
            r13.put(r0, r12)
        L_0x016d:
            com.appsflyer.internal.d$e$d r12 = new com.appsflyer.internal.d$e$d
            r12.<init>(r8, r3)
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ab.valueOf(android.content.Context, java.util.Map):com.appsflyer.internal.d$e$d");
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0050  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x005c A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.appsflyer.internal.d.e.C0074d values(android.content.Context r5) {
        /*
            com.appsflyer.AppsFlyerProperties r0 = com.appsflyer.AppsFlyerProperties.getInstance()
            java.lang.String r1 = valueOf
            r2 = 1
            if (r1 == 0) goto L_0x000b
            r3 = r2
            goto L_0x000c
        L_0x000b:
            r3 = 0
        L_0x000c:
            r4 = 0
            if (r3 == 0) goto L_0x0011
        L_0x000f:
            r5 = r4
            goto L_0x004e
        L_0x0011:
            java.lang.Boolean r1 = AFInAppEventType
            if (r1 == 0) goto L_0x001b
            boolean r1 = r1.booleanValue()
            if (r1 != 0) goto L_0x0027
        L_0x001b:
            java.lang.Boolean r1 = AFInAppEventType
            if (r1 != 0) goto L_0x004c
            java.lang.String r1 = "collectOAID"
            boolean r1 = r0.getBoolean(r1, r2)
            if (r1 == 0) goto L_0x004c
        L_0x0027:
            com.appsflyer.oaid.OaidClient r1 = new com.appsflyer.oaid.OaidClient     // Catch:{ all -> 0x0045 }
            r1.<init>(r5)     // Catch:{ all -> 0x0045 }
            boolean r5 = r0.isEnableLog()     // Catch:{ all -> 0x0045 }
            r1.setLogging(r5)     // Catch:{ all -> 0x0045 }
            com.appsflyer.oaid.OaidClient$Info r5 = r1.fetch()     // Catch:{ all -> 0x0045 }
            if (r5 == 0) goto L_0x004c
            java.lang.String r0 = r5.getId()     // Catch:{ all -> 0x0045 }
            java.lang.Boolean r5 = r5.getLat()     // Catch:{ all -> 0x0043 }
            r1 = r0
            goto L_0x004e
        L_0x0043:
            r1 = r0
            goto L_0x0046
        L_0x0045:
            r1 = r4
        L_0x0046:
            java.lang.String r5 = "No OAID library"
            com.appsflyer.AFLogger.values((java.lang.String) r5)
            goto L_0x000f
        L_0x004c:
            r5 = r4
            r1 = r5
        L_0x004e:
            if (r1 == 0) goto L_0x005c
            com.appsflyer.internal.d$e$d r0 = new com.appsflyer.internal.d$e$d
            r0.<init>(r1, r5)
            java.lang.Boolean r5 = java.lang.Boolean.valueOf(r3)
            r0.AFInAppEventParameterName = r5
            return r0
        L_0x005c:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.appsflyer.internal.ab.values(android.content.Context):com.appsflyer.internal.d$e$d");
    }
}
