package i6;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Build;
import java.lang.reflect.Method;
import java.net.Inet4Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import java.util.List;

public class l {
    public static ConnectivityManager a(Context context) {
        return (ConnectivityManager) context.getSystemService("connectivity");
    }

    public static int b(Context context) {
        try {
            NetworkInfo activeNetworkInfo = a(context).getActiveNetworkInfo();
            if (activeNetworkInfo != null) {
                int type = activeNetworkInfo.getType();
                if (type == 0) {
                    return 1;
                }
                if (type != 1) {
                    return 2;
                }
                return 0;
            }
        } catch (Exception unused) {
        }
        return 2;
    }

    @SuppressLint({"MissingPermission"})
    public static String c(Context context) {
        try {
            ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
            List<InetAddress> list = null;
            if (Build.VERSION.SDK_INT >= 23) {
                list = connectivityManager.getLinkProperties(connectivityManager.getActiveNetwork()).getDnsServers();
            }
            return (list == null || list.size() <= 0) ? "UnKnow" : list.get(0).toString();
        } catch (Throwable unused) {
            return "UnKnow";
        }
    }

    public static String d(Context context) {
        try {
            int b11 = b(context);
            if (1 == b11) {
                return e();
            }
            if (b11 == 0) {
                return g(context);
            }
            return "127.0.0.1";
        } catch (Exception e11) {
            d.f("getIp-->Error::", e11);
            return "127.0.0.1";
        }
    }

    public static String e() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (true) {
                    if (inetAddresses.hasMoreElements()) {
                        InetAddress nextElement = inetAddresses.nextElement();
                        if (!nextElement.isLoopbackAddress() && (nextElement instanceof Inet4Address)) {
                            return nextElement.getHostAddress().toString();
                        }
                    }
                }
            }
            return "127.0.0.1";
        } catch (Exception e11) {
            d.f("getIp-->Error::", e11);
            return "127.0.0.1";
        }
    }

    public static String f() {
        return "okhttp/3.8.0";
    }

    public static String g(Context context) {
        try {
            int ipAddress = ((WifiManager) context.getSystemService("wifi")).getConnectionInfo().getIpAddress();
            return String.format("%d.%d.%d.%d", new Object[]{Integer.valueOf(ipAddress & 255), Integer.valueOf((ipAddress >> 8) & 255), Integer.valueOf((ipAddress >> 16) & 255), Integer.valueOf((ipAddress >> 24) & 255)});
        } catch (Exception e11) {
            d.f("getIp-->Error::", e11);
            return "127.0.0.1";
        }
    }

    public static boolean h(Context context) {
        return m(context) || (k(context) && l(context));
    }

    public static boolean i(Context context) {
        try {
            NetworkInfo activeNetworkInfo = a(context).getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:4:0x0012 A[Catch:{ Exception -> 0x0039 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean j() {
        /*
            java.util.Enumeration r0 = java.net.NetworkInterface.getNetworkInterfaces()     // Catch:{ Exception -> 0x0039 }
            java.util.ArrayList r0 = java.util.Collections.list(r0)     // Catch:{ Exception -> 0x0039 }
            java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x0039 }
        L_0x000c:
            boolean r1 = r0.hasNext()     // Catch:{ Exception -> 0x0039 }
            if (r1 == 0) goto L_0x003d
            java.lang.Object r1 = r0.next()     // Catch:{ Exception -> 0x0039 }
            java.net.NetworkInterface r1 = (java.net.NetworkInterface) r1     // Catch:{ Exception -> 0x0039 }
            java.lang.String r2 = r1.getName()     // Catch:{ Exception -> 0x0039 }
            java.lang.String r3 = "tun0"
            boolean r2 = r2.contains(r3)     // Catch:{ Exception -> 0x0039 }
            if (r2 != 0) goto L_0x0030
            java.lang.String r1 = r1.getName()     // Catch:{ Exception -> 0x0039 }
            java.lang.String r2 = "ppp0"
            boolean r1 = r1.contains(r2)     // Catch:{ Exception -> 0x0039 }
            if (r1 == 0) goto L_0x000c
        L_0x0030:
            java.lang.String r0 = "TAG"
            java.lang.String r1 = "isDeviceInVPN  current device is in VPN."
            i6.k.o(r0, r1)     // Catch:{ Exception -> 0x0039 }
            r0 = 1
            return r0
        L_0x0039:
            r0 = move-exception
            r0.printStackTrace()
        L_0x003d:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: i6.l.j():boolean");
    }

    public static boolean k(Context context) {
        NetworkInfo[] allNetworkInfo = a(context).getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.getType() == 0) {
                    return networkInfo.isAvailable();
                }
            }
        }
        return false;
    }

    public static boolean l(Context context) {
        try {
            Method declaredMethod = ConnectivityManager.class.getDeclaredMethod("getMobileDataEnabled", new Class[0]);
            declaredMethod.setAccessible(true);
            return ((Boolean) declaredMethod.invoke(a(context), new Object[0])).booleanValue();
        } catch (Exception e11) {
            d.i(e11.getMessage());
            return true;
        }
    }

    public static boolean m(Context context) {
        NetworkInfo[] allNetworkInfo = a(context).getAllNetworkInfo();
        if (allNetworkInfo != null) {
            for (NetworkInfo networkInfo : allNetworkInfo) {
                if (networkInfo.getType() == 1) {
                    return networkInfo.isAvailable();
                }
            }
        }
        return false;
    }

    public static boolean n(Context context) {
        NetworkInfo activeNetworkInfo = a(context).getActiveNetworkInfo();
        if (activeNetworkInfo == null || activeNetworkInfo.getType() != 1 || !activeNetworkInfo.isConnected()) {
            return false;
        }
        return true;
    }
}
