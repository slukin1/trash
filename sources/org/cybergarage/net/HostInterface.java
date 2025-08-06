package org.cybergarage.net;

import com.huochat.community.network.domain.DomainTool;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.util.Enumeration;
import org.cybergarage.util.Debug;

public class HostInterface {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f59827a = false;

    /* renamed from: b  reason: collision with root package name */
    public static boolean f59828b = false;

    /* renamed from: c  reason: collision with root package name */
    public static boolean f59829c = false;

    /* renamed from: d  reason: collision with root package name */
    public static String f59830d = "";

    public static final String a(int i11) {
        if (e()) {
            return c();
        }
        int i12 = 0;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    InetAddress nextElement = inetAddresses.nextElement();
                    if (h(nextElement)) {
                        if (i12 >= i11) {
                            return nextElement.getHostAddress();
                        }
                        i12++;
                    }
                }
            }
            return "";
        } catch (Exception unused) {
            return "";
        }
    }

    public static final String b(String str, int i11, String str2) {
        if (g(str)) {
            str = "[" + str + "]";
        }
        return DomainTool.DOMAIN_PREFIX_HTTP + str + ":" + Integer.toString(i11) + str2;
    }

    public static final String c() {
        return f59830d;
    }

    public static final int d() {
        if (e()) {
            return 1;
        }
        int i11 = 0;
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
                while (inetAddresses.hasMoreElements()) {
                    if (h(inetAddresses.nextElement())) {
                        i11++;
                    }
                }
            }
        } catch (Exception e11) {
            Debug.d(e11);
        }
        return i11;
    }

    public static final boolean e() {
        return f59830d.length() > 0;
    }

    public static final boolean f(String str) {
        try {
            if (InetAddress.getByName(str) instanceof Inet4Address) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }

    public static final boolean g(String str) {
        try {
            if (InetAddress.getByName(str) instanceof Inet6Address) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }

    public static final boolean h(InetAddress inetAddress) {
        if (!f59827a && inetAddress.isLoopbackAddress()) {
            return false;
        }
        if (f59828b && (inetAddress instanceof Inet6Address)) {
            return false;
        }
        if (!f59829c || !(inetAddress instanceof Inet4Address)) {
            return true;
        }
        return false;
    }
}
