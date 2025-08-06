package com.tencent.wxop.stat;

import android.content.Context;
import com.jumio.core.cdn.CDNDownload;
import com.tencent.wxop.stat.a.g;
import com.tencent.wxop.stat.b.b;
import com.xiaomi.mipush.sdk.Constants;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;

final class o implements Runnable {
    private f bM = null;
    private Map<String, Integer> bO = null;

    /* renamed from: e  reason: collision with root package name */
    private Context f51085e = null;

    public o(Context context) {
        this.f51085e = context;
        this.bM = null;
    }

    private static b a(String str, int i11) {
        int i12;
        b bVar = new b();
        Socket socket = new Socket();
        try {
            bVar.setDomain(str);
            bVar.setPort(i11);
            long currentTimeMillis = System.currentTimeMillis();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(str, i11);
            socket.connect(inetSocketAddress, CDNDownload.DEFAULT_TIMEOUT);
            bVar.a(System.currentTimeMillis() - currentTimeMillis);
            bVar.k(inetSocketAddress.getAddress().getHostAddress());
            socket.close();
            try {
                socket.close();
            } catch (Throwable th2) {
                e.aV.b(th2);
            }
            i12 = 0;
        } catch (IOException e11) {
            try {
                e.aV.b((Throwable) e11);
                socket.close();
            } catch (Throwable th3) {
                e.aV.b(th3);
            }
        } catch (Throwable th4) {
            e.aV.b(th4);
        }
        bVar.setStatusCode(i12);
        return bVar;
        i12 = -1;
        bVar.setStatusCode(i12);
        return bVar;
        throw th;
    }

    private static Map<String, Integer> ag() {
        String str;
        HashMap hashMap = new HashMap();
        String l11 = c.l("__MTA_TEST_SPEED__");
        if (!(l11 == null || l11.trim().length() == 0)) {
            for (String split : l11.split(";")) {
                String[] split2 = split.split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                if (!(split2 == null || split2.length != 2 || (str = split2[0]) == null || str.trim().length() == 0)) {
                    try {
                        hashMap.put(str, Integer.valueOf(Integer.valueOf(split2[1]).intValue()));
                    } catch (NumberFormatException e11) {
                        e.aV.b((Throwable) e11);
                    }
                }
            }
        }
        return hashMap;
    }

    public final void run() {
        b K;
        String str;
        try {
            if (this.bO == null) {
                this.bO = ag();
            }
            Map<String, Integer> map = this.bO;
            if (map != null) {
                if (map.size() != 0) {
                    JSONArray jSONArray = new JSONArray();
                    for (Map.Entry next : this.bO.entrySet()) {
                        String str2 = (String) next.getKey();
                        if (str2 != null) {
                            if (str2.length() != 0) {
                                if (((Integer) next.getValue()) == null) {
                                    K = e.aV;
                                    str = "port is null for " + str2;
                                    K.c(str);
                                } else {
                                    jSONArray.put(a((String) next.getKey(), ((Integer) next.getValue()).intValue()).i());
                                }
                            }
                        }
                        K = e.aV;
                        str = "empty domain name.";
                        K.c(str);
                    }
                    if (jSONArray.length() != 0) {
                        Context context = this.f51085e;
                        g gVar = new g(context, e.a(context, false, this.bM), this.bM);
                        gVar.b(jSONArray.toString());
                        new p(gVar).ah();
                        return;
                    }
                    return;
                }
            }
            e.aV.b((Object) "empty domain list.");
        } catch (Throwable th2) {
            e.aV.b(th2);
        }
    }
}
