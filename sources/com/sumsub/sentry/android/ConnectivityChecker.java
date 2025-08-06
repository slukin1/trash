package com.sumsub.sentry.android;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.sumsub.log.logger.a;
import com.sumsub.sns.internal.log.c;
import kotlin.Metadata;

public final class ConnectivityChecker {

    /* renamed from: a  reason: collision with root package name */
    public static final ConnectivityChecker f30259a = new ConnectivityChecker();

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/sumsub/sentry/android/ConnectivityChecker$Status;", "", "(Ljava/lang/String;I)V", "CONNECTED", "NOT_CONNECTED", "NO_PERMISSION", "UNKNOWN", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum Status {
        CONNECTED,
        NOT_CONNECTED,
        NO_PERMISSION,
        UNKNOWN
    }

    public final Status a(Context context) {
        ConnectivityManager b11 = b(context);
        if (b11 == null) {
            return Status.UNKNOWN;
        }
        return a(context, b11);
    }

    public final ConnectivityManager b(Context context) {
        Object systemService = context.getSystemService("connectivity");
        ConnectivityManager connectivityManager = systemService instanceof ConnectivityManager ? (ConnectivityManager) systemService : null;
        if (connectivityManager == null) {
            a.c(com.sumsub.sns.internal.log.a.f34862a, c.a(this), "ConnectivityManager is null and cannot check network status", (Throwable) null, 4, (Object) null);
        }
        return connectivityManager;
    }

    @SuppressLint({"MissingPermission"})
    public final Status a(Context context, ConnectivityManager connectivityManager) {
        if (!g.f30280a.a(context, "android.permission.ACCESS_NETWORK_STATE")) {
            a.c(com.sumsub.sns.internal.log.a.f34862a, c.a(this), "No permission (ACCESS_NETWORK_STATE) to check network status.", (Throwable) null, 4, (Object) null);
            return Status.NO_PERMISSION;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo != null) {
            return activeNetworkInfo.isConnected() ? Status.CONNECTED : Status.NOT_CONNECTED;
        }
        a.c(com.sumsub.sns.internal.log.a.f34862a, c.a(this), "NetworkInfo is null, there's no active network.", (Throwable) null, 4, (Object) null);
        return Status.NOT_CONNECTED;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x008f, code lost:
        if (r11 == 0) goto L_0x0091;
     */
    @android.annotation.SuppressLint({"ObsoleteSdkInt", "MissingPermission", "NewApi"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String a(android.content.Context r11, com.sumsub.sentry.android.a r12) {
        /*
            r10 = this;
            android.net.ConnectivityManager r0 = r10.b(r11)
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            com.sumsub.sentry.android.g r2 = com.sumsub.sentry.android.g.f30280a
            java.lang.String r3 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r11 = r2.a(r11, r3)
            if (r11 != 0) goto L_0x0021
            com.sumsub.sns.internal.log.a r2 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r3 = com.sumsub.sns.internal.log.c.a(r10)
            r5 = 0
            r6 = 4
            r7 = 0
            java.lang.String r4 = "No permission (ACCESS_NETWORK_STATE) to check network status."
            com.sumsub.log.logger.a.c(r2, r3, r4, r5, r6, r7)
            return r1
        L_0x0021:
            int r11 = r12.d()
            r12 = 23
            r2 = 0
            r3 = 1
            if (r11 < r12) goto L_0x0068
            android.net.Network r11 = r0.getActiveNetwork()
            if (r11 != 0) goto L_0x0040
            com.sumsub.sns.internal.log.a r4 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r5 = com.sumsub.sns.internal.log.c.a(r10)
            r7 = 0
            r8 = 4
            r9 = 0
            java.lang.String r6 = "Network is null and cannot check network status"
            com.sumsub.log.logger.a.c(r4, r5, r6, r7, r8, r9)
            return r1
        L_0x0040:
            android.net.NetworkCapabilities r11 = r0.getNetworkCapabilities(r11)
            if (r11 != 0) goto L_0x0055
            com.sumsub.sns.internal.log.a r4 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r5 = com.sumsub.sns.internal.log.c.a(r10)
            r7 = 0
            r8 = 4
            r9 = 0
            java.lang.String r6 = "NetworkCapabilities is null and cannot check network type"
            com.sumsub.log.logger.a.c(r4, r5, r6, r7, r8, r9)
            return r1
        L_0x0055:
            r12 = 3
            boolean r12 = r11.hasTransport(r12)
            boolean r0 = r11.hasTransport(r3)
            boolean r11 = r11.hasTransport(r2)
            if (r11 == 0) goto L_0x0065
            goto L_0x0066
        L_0x0065:
            r3 = r2
        L_0x0066:
            r2 = r12
            goto L_0x0091
        L_0x0068:
            android.net.NetworkInfo r11 = r0.getActiveNetworkInfo()
            if (r11 != 0) goto L_0x007d
            com.sumsub.sns.internal.log.a r4 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r5 = com.sumsub.sns.internal.log.c.a(r10)
            r7 = 0
            r8 = 4
            r9 = 0
            java.lang.String r6 = "NetworkInfo is null, there's no active network."
            com.sumsub.log.logger.a.c(r4, r5, r6, r7, r8, r9)
            return r1
        L_0x007d:
            int r11 = r11.getType()
            r12 = 9
            if (r11 != r12) goto L_0x0089
            r0 = r2
            r2 = r3
        L_0x0087:
            r3 = r0
            goto L_0x0091
        L_0x0089:
            if (r11 != r3) goto L_0x008e
            r0 = r3
            r3 = r2
            goto L_0x0091
        L_0x008e:
            r0 = r2
            if (r11 != 0) goto L_0x0087
        L_0x0091:
            if (r2 == 0) goto L_0x0096
            java.lang.String r1 = "ethernet"
            goto L_0x009f
        L_0x0096:
            if (r0 == 0) goto L_0x009b
            java.lang.String r1 = "wifi"
            goto L_0x009f
        L_0x009b:
            if (r3 == 0) goto L_0x009f
            java.lang.String r1 = "cellular"
        L_0x009f:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sentry.android.ConnectivityChecker.a(android.content.Context, com.sumsub.sentry.android.a):java.lang.String");
    }
}
