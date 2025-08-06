package com.huobi.woodpecker.kalle.connect;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;

public class NetworkChecker {

    /* renamed from: a  reason: collision with root package name */
    public ConnectivityManager f21051a;

    public enum NetType {
        Wifi,
        Wired,
        Mobile,
        Mobile2G,
        Mobile3G,
        Mobile4G
    }

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f21052a;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.huobi.woodpecker.kalle.connect.NetworkChecker$NetType[] r0 = com.huobi.woodpecker.kalle.connect.NetworkChecker.NetType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f21052a = r0
                com.huobi.woodpecker.kalle.connect.NetworkChecker$NetType r1 = com.huobi.woodpecker.kalle.connect.NetworkChecker.NetType.Wifi     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f21052a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.huobi.woodpecker.kalle.connect.NetworkChecker$NetType r1 = com.huobi.woodpecker.kalle.connect.NetworkChecker.NetType.Wired     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f21052a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.huobi.woodpecker.kalle.connect.NetworkChecker$NetType r1 = com.huobi.woodpecker.kalle.connect.NetworkChecker.NetType.Mobile     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f21052a     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.huobi.woodpecker.kalle.connect.NetworkChecker$NetType r1 = com.huobi.woodpecker.kalle.connect.NetworkChecker.NetType.Mobile2G     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f21052a     // Catch:{ NoSuchFieldError -> 0x003e }
                com.huobi.woodpecker.kalle.connect.NetworkChecker$NetType r1 = com.huobi.woodpecker.kalle.connect.NetworkChecker.NetType.Mobile3G     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f21052a     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.huobi.woodpecker.kalle.connect.NetworkChecker$NetType r1 = com.huobi.woodpecker.kalle.connect.NetworkChecker.NetType.Mobile4G     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.huobi.woodpecker.kalle.connect.NetworkChecker.a.<clinit>():void");
        }
    }

    public NetworkChecker(Context context) {
        this.f21051a = (ConnectivityManager) context.getSystemService("connectivity");
    }

    public static boolean c(NetworkInfo networkInfo) {
        return networkInfo != null && networkInfo.isAvailable() && networkInfo.isConnected();
    }

    public static boolean d(NetType netType, NetworkInfo networkInfo) {
        if (networkInfo == null) {
            return false;
        }
        switch (a.f21052a[netType.ordinal()]) {
            case 1:
                if (c(networkInfo) && networkInfo.getType() == 1) {
                    return true;
                }
                return false;
            case 2:
                if (c(networkInfo) && Build.VERSION.SDK_INT >= 13 && networkInfo.getType() == 9) {
                    return true;
                }
                return false;
            case 3:
                if (c(networkInfo) && networkInfo.getType() == 0) {
                    return true;
                }
                return false;
            case 4:
                if (!d(NetType.Mobile, networkInfo)) {
                    return false;
                }
                return f(NetType.Mobile2G, networkInfo);
            case 5:
                if (!d(NetType.Mobile, networkInfo)) {
                    return false;
                }
                return f(NetType.Mobile3G, networkInfo);
            case 6:
                if (!d(NetType.Mobile, networkInfo)) {
                    return false;
                }
                return f(NetType.Mobile4G, networkInfo);
            default:
                return false;
        }
    }

    public static boolean f(NetType netType, NetworkInfo networkInfo) {
        switch (networkInfo.getType()) {
            case 1:
            case 2:
            case 4:
            case 7:
            case 11:
            case 16:
                if (netType == NetType.Mobile2G) {
                    return true;
                }
                return false;
            case 3:
            case 5:
            case 6:
            case 8:
            case 9:
            case 10:
            case 12:
            case 14:
            case 15:
            case 17:
                if (netType == NetType.Mobile3G) {
                    return true;
                }
                return false;
            case 13:
            case 18:
                if (netType == NetType.Mobile4G) {
                    return true;
                }
                return false;
            default:
                String subtypeName = networkInfo.getSubtypeName();
                if (!subtypeName.equalsIgnoreCase("TD-SCDMA") && !subtypeName.equalsIgnoreCase("WCDMA") && !subtypeName.equalsIgnoreCase("CDMA2000")) {
                    return false;
                }
                if (netType == NetType.Mobile3G) {
                    return true;
                }
                return false;
        }
    }

    public boolean a() {
        return g() || h() || e();
    }

    public final boolean b(NetType netType) {
        return d(netType, this.f21051a.getActiveNetworkInfo());
    }

    public final boolean e() {
        return b(NetType.Mobile);
    }

    public final boolean g() {
        return b(NetType.Wifi);
    }

    public final boolean h() {
        return b(NetType.Wired);
    }
}
