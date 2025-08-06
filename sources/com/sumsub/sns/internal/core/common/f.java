package com.sumsub.sns.internal.core.common;

import android.os.Build;

public final class f {
    public static /* synthetic */ void g() {
    }

    public final String a() {
        return Build.TAGS;
    }

    public final String b() {
        return Build.MANUFACTURER;
    }

    public final String c() {
        return Build.MODEL;
    }

    public final int d() {
        return Build.VERSION.SDK_INT;
    }

    public final String e() {
        return Build.VERSION.RELEASE;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0091, code lost:
        if (kotlin.text.StringsKt__StringsKt.R(r1, "simulator", false, 2, (java.lang.Object) null) == false) goto L_0x0094;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.Boolean f() {
        /*
            r6 = this;
            java.lang.String r0 = "google_sdk"
            java.lang.String r1 = "generic"
            r2 = 0
            java.lang.String r3 = android.os.Build.BRAND     // Catch:{ all -> 0x0099 }
            r4 = 2
            r5 = 0
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.M(r3, r1, r5, r4, r2)     // Catch:{ all -> 0x0099 }
            if (r3 == 0) goto L_0x0017
            java.lang.String r3 = android.os.Build.DEVICE     // Catch:{ all -> 0x0099 }
            boolean r3 = kotlin.text.StringsKt__StringsJVMKt.M(r3, r1, r5, r4, r2)     // Catch:{ all -> 0x0099 }
            if (r3 != 0) goto L_0x0093
        L_0x0017:
            java.lang.String r3 = android.os.Build.FINGERPRINT     // Catch:{ all -> 0x0099 }
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.M(r3, r1, r5, r4, r2)     // Catch:{ all -> 0x0099 }
            if (r1 != 0) goto L_0x0093
            java.lang.String r1 = "unknown"
            boolean r1 = kotlin.text.StringsKt__StringsJVMKt.M(r3, r1, r5, r4, r2)     // Catch:{ all -> 0x0099 }
            if (r1 != 0) goto L_0x0093
            java.lang.String r1 = android.os.Build.HARDWARE     // Catch:{ all -> 0x0099 }
            java.lang.String r3 = "goldfish"
            boolean r3 = kotlin.text.StringsKt__StringsKt.R(r1, r3, r5, r4, r2)     // Catch:{ all -> 0x0099 }
            if (r3 != 0) goto L_0x0093
            java.lang.String r3 = "ranchu"
            boolean r1 = kotlin.text.StringsKt__StringsKt.R(r1, r3, r5, r4, r2)     // Catch:{ all -> 0x0099 }
            if (r1 != 0) goto L_0x0093
            java.lang.String r1 = android.os.Build.MODEL     // Catch:{ all -> 0x0099 }
            boolean r3 = kotlin.text.StringsKt__StringsKt.R(r1, r0, r5, r4, r2)     // Catch:{ all -> 0x0099 }
            if (r3 != 0) goto L_0x0093
            java.lang.String r3 = "Emulator"
            boolean r3 = kotlin.text.StringsKt__StringsKt.R(r1, r3, r5, r4, r2)     // Catch:{ all -> 0x0099 }
            if (r3 != 0) goto L_0x0093
            java.lang.String r3 = "Android SDK built for x86"
            boolean r1 = kotlin.text.StringsKt__StringsKt.R(r1, r3, r5, r4, r2)     // Catch:{ all -> 0x0099 }
            if (r1 != 0) goto L_0x0093
            java.lang.String r1 = android.os.Build.MANUFACTURER     // Catch:{ all -> 0x0099 }
            java.lang.String r3 = "Genymotion"
            boolean r1 = kotlin.text.StringsKt__StringsKt.R(r1, r3, r5, r4, r2)     // Catch:{ all -> 0x0099 }
            if (r1 != 0) goto L_0x0093
            java.lang.String r1 = android.os.Build.PRODUCT     // Catch:{ all -> 0x0099 }
            java.lang.String r3 = "sdk_google"
            boolean r3 = kotlin.text.StringsKt__StringsKt.R(r1, r3, r5, r4, r2)     // Catch:{ all -> 0x0099 }
            if (r3 != 0) goto L_0x0093
            boolean r0 = kotlin.text.StringsKt__StringsKt.R(r1, r0, r5, r4, r2)     // Catch:{ all -> 0x0099 }
            if (r0 != 0) goto L_0x0093
            java.lang.String r0 = "sdk"
            boolean r0 = kotlin.text.StringsKt__StringsKt.R(r1, r0, r5, r4, r2)     // Catch:{ all -> 0x0099 }
            if (r0 != 0) goto L_0x0093
            java.lang.String r0 = "sdk_x86"
            boolean r0 = kotlin.text.StringsKt__StringsKt.R(r1, r0, r5, r4, r2)     // Catch:{ all -> 0x0099 }
            if (r0 != 0) goto L_0x0093
            java.lang.String r0 = "vbox86p"
            boolean r0 = kotlin.text.StringsKt__StringsKt.R(r1, r0, r5, r4, r2)     // Catch:{ all -> 0x0099 }
            if (r0 != 0) goto L_0x0093
            java.lang.String r0 = "emulator"
            boolean r0 = kotlin.text.StringsKt__StringsKt.R(r1, r0, r5, r4, r2)     // Catch:{ all -> 0x0099 }
            if (r0 != 0) goto L_0x0093
            java.lang.String r0 = "simulator"
            boolean r0 = kotlin.text.StringsKt__StringsKt.R(r1, r0, r5, r4, r2)     // Catch:{ all -> 0x0099 }
            if (r0 == 0) goto L_0x0094
        L_0x0093:
            r5 = 1
        L_0x0094:
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r5)     // Catch:{ all -> 0x0099 }
            goto L_0x00a5
        L_0x0099:
            r0 = move-exception
            com.sumsub.sns.internal.log.a r1 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r3 = com.sumsub.sns.internal.log.c.a(r6)
            java.lang.String r4 = "Error checking whether application is running in an emulator."
            r1.e(r3, r4, r0)
        L_0x00a5:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.internal.core.common.f.f():java.lang.Boolean");
    }
}
