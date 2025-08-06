package com.huobi.woodpecker.utils;

import java.net.NetworkInterface;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;

public class CheckVPNUtils {

    /* renamed from: a  reason: collision with root package name */
    public static Boolean f21159a;

    /* renamed from: b  reason: collision with root package name */
    public static long f21160b;

    public static boolean a() {
        if (f21159a == null || System.currentTimeMillis() - f21160b > 10000) {
            return b();
        }
        return f21159a.booleanValue();
    }

    public static boolean b() {
        try {
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            if (networkInterfaces != null) {
                Iterator<T> it2 = Collections.list(networkInterfaces).iterator();
                while (it2.hasNext()) {
                    NetworkInterface networkInterface = (NetworkInterface) it2.next();
                    if (networkInterface.isUp()) {
                        if (networkInterface.getInterfaceAddresses().size() != 0) {
                            if ("tun0".equals(networkInterface.getName()) || "ppp0".equals(networkInterface.getName())) {
                                f21159a = Boolean.TRUE;
                                f21160b = System.currentTimeMillis();
                                return f21159a.booleanValue();
                            }
                        }
                    }
                }
            }
        } catch (Throwable unused) {
        }
        f21159a = Boolean.FALSE;
        f21160b = System.currentTimeMillis();
        return false;
    }
}
