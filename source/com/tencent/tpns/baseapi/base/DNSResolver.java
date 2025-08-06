package com.tencent.tpns.baseapi.base;

import com.iproov.sdk.bridge.OptionsBridge;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;
import com.tencent.tpns.baseapi.base.util.Logger;
import com.tencent.tpns.baseapi.base.util.TTask;
import com.tencent.tpns.baseapi.base.util.Util;
import java.net.Inet4Address;
import java.net.Inet6Address;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import org.json.JSONArray;
import org.json.JSONException;

public class DNSResolver extends TTask {
    public static byte DNS_REASON = 0;

    /* renamed from: a  reason: collision with root package name */
    private static String f49742a = "DNSResolver";

    /* renamed from: b  reason: collision with root package name */
    private String f49743b;

    /* renamed from: c  reason: collision with root package name */
    private String f49744c;

    private DNSResolver(String str) {
        this.f49743b = str;
    }

    private static boolean a(String str) {
        return str == null || str.equals("");
    }

    private static String b(String str) {
        InetAddress inetAddress;
        if (a(str)) {
            return null;
        }
        try {
            long nanoTime = System.nanoTime();
            InetAddress[] allByName = InetAddress.getAllByName(str);
            long nanoTime2 = System.nanoTime();
            if (allByName == null || allByName.length <= 0) {
                inetAddress = null;
            } else {
                inetAddress = allByName[0];
                DNS_REASON = 2;
                TBaseLogger.dd(f49742a, "getAllByName: " + Arrays.toString(allByName) + " in " + ((nanoTime2 - nanoTime) / 1000000) + "ms");
            }
            if (inetAddress != null) {
                TBaseLogger.d(f49742a, "addr:" + inetAddress.getHostAddress());
                if (inetAddress instanceof Inet4Address) {
                    return inetAddress.getHostAddress();
                }
                if (inetAddress instanceof Inet6Address) {
                    return "[" + inetAddress.getHostAddress() + "]";
                }
            }
        } catch (Throwable th2) {
            Logger.e(f49742a, "NSLookup error: ", th2);
            DNS_REASON = 2;
        }
        return null;
    }

    public static String hostToIp(String str, String str2) {
        String str3;
        String str4;
        String str5 = f49742a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("Get MqttServer address: ");
        sb2.append(str);
        sb2.append(", portList:");
        sb2.append(str2 == null ? OptionsBridge.NULL_VALUE : str2);
        Logger.i(str5, sb2.toString());
        ArrayList arrayList = new ArrayList();
        if (!Util.isNullOrEmptyString(str2)) {
            try {
                JSONArray jSONArray = new JSONArray(str2);
                for (int i11 = 0; i11 < jSONArray.length(); i11++) {
                    arrayList.add(jSONArray.getString(i11));
                }
            } catch (JSONException e11) {
                Logger.e(f49742a, "Get MqttServer parse mqttPortList error ", e11);
            }
        }
        if (arrayList.size() > 0) {
            str3 = (String) arrayList.get(new Random().nextInt(arrayList.size()));
            Logger.i(f49742a, "Get MqttServer random port: " + str3);
        } else {
            str3 = "1883";
            Logger.i(f49742a, "Get MqttServer use default port: " + str3);
        }
        String str6 = null;
        if (str.startsWith("tcp://")) {
            try {
                String[] split = str.substring(6).split(":");
                if (split.length > 1) {
                    str4 = split[0];
                    Logger.i(f49742a, "Get MqttServer address no need to parse, ip: ");
                }
            } catch (Throwable th2) {
                Logger.e(f49742a, "Get MqttServer parse tcp ip error ", th2);
            }
            str4 = null;
            Logger.i(f49742a, "Get MqttServer address no need to parse, ip: ");
        } else if (str.startsWith("ssl://")) {
            return str;
        } else {
            DNSResolver dNSResolver = new DNSResolver(str);
            try {
                Thread thread = new Thread(dNSResolver);
                thread.setName("tpns-dns");
                thread.start();
                thread.join(4000);
            } catch (Throwable th3) {
                Logger.e(f49742a, "t.join", th3);
            }
            str4 = dNSResolver.get();
        }
        if (Util.isNullOrEmptyString(str4)) {
            TBaseLogger.ee(f49742a, "Get MqttServer ip is null");
        } else {
            str6 = "tcp://" + str4 + ":" + str3;
        }
        TBaseLogger.i(f49742a, "DNS " + str + " -> " + str6);
        return str6;
    }

    public void TRun() {
        try {
            set(b(this.f49743b));
        } catch (Throwable th2) {
            String str = f49742a;
            TBaseLogger.ww(str, "unexpected for dns resolver:" + th2.getMessage());
        }
    }

    public synchronized String get() {
        return this.f49744c;
    }

    public synchronized void set(String str) {
        this.f49744c = str;
    }
}
