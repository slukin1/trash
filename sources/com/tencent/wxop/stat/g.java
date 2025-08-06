package com.tencent.wxop.stat;

import android.content.Context;
import android.content.IntentFilter;
import com.huochat.community.network.domain.DomainTool;
import com.tencent.wxop.stat.b.b;
import com.tencent.wxop.stat.b.f;
import com.tencent.wxop.stat.b.l;
import com.tencent.wxop.stat.b.r;
import java.net.InetAddress;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import org.apache.http.HttpHost;
import org.json.JSONObject;

public class g {

    /* renamed from: bg  reason: collision with root package name */
    private static g f51069bg;

    /* renamed from: bc  reason: collision with root package name */
    private List<String> f51070bc = null;

    /* renamed from: bd  reason: collision with root package name */
    private volatile HttpHost f51071bd = null;
    /* access modifiers changed from: private */

    /* renamed from: be  reason: collision with root package name */
    public f f51072be = null;

    /* renamed from: bf  reason: collision with root package name */
    private int f51073bf = 0;

    /* renamed from: bh  reason: collision with root package name */
    private Context f51074bh = null;

    /* renamed from: bi  reason: collision with root package name */
    private b f51075bi = null;

    /* renamed from: c  reason: collision with root package name */
    private volatile String f51076c = "";

    /* renamed from: g  reason: collision with root package name */
    private volatile int f51077g = 2;

    private g(Context context) {
        this.f51074bh = context.getApplicationContext();
        this.f51072be = new f();
        ak.j(context);
        this.f51075bi = l.av();
        Y();
        ArrayList arrayList = new ArrayList(10);
        this.f51070bc = arrayList;
        arrayList.add("117.135.169.101");
        this.f51070bc.add("140.207.54.125");
        this.f51070bc.add("180.153.8.53");
        this.f51070bc.add("120.198.203.175");
        this.f51070bc.add("14.17.43.18");
        this.f51070bc.add("163.177.71.186");
        this.f51070bc.add("111.30.131.31");
        this.f51070bc.add("123.126.121.167");
        this.f51070bc.add("123.151.152.111");
        this.f51070bc.add("113.142.45.79");
        this.f51070bc.add("123.138.162.90");
        this.f51070bc.add("103.7.30.94");
        Z();
    }

    private String O() {
        try {
            return !d("pingma.qq.com") ? InetAddress.getByName("pingma.qq.com").getHostAddress() : "";
        } catch (Exception e11) {
            this.f51075bi.b((Throwable) e11);
            return "";
        }
    }

    private void Y() {
        this.f51077g = 0;
        this.f51071bd = null;
        this.f51076c = null;
    }

    private static boolean d(String str) {
        return Pattern.compile("(2[5][0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})\\.(25[0-5]|2[0-4]\\d|1\\d{2}|\\d{1,2})").matcher(str).matches();
    }

    public static g r(Context context) {
        if (f51069bg == null) {
            synchronized (g.class) {
                if (f51069bg == null) {
                    f51069bg = new g(context);
                }
            }
        }
        return f51069bg;
    }

    public final int D() {
        return this.f51077g;
    }

    public final void I() {
        this.f51073bf = (this.f51073bf + 1) % this.f51070bc.size();
    }

    public final HttpHost V() {
        return this.f51071bd;
    }

    public final boolean W() {
        return this.f51077g == 1;
    }

    public final boolean X() {
        return this.f51077g != 0;
    }

    public final void Z() {
        if (r.W(this.f51074bh)) {
            if (c.f51034ad) {
                String O = O();
                if (c.k()) {
                    b bVar = this.f51075bi;
                    bVar.b((Object) "remoteIp ip is " + O);
                }
                if (l.e(O)) {
                    if (!this.f51070bc.contains(O)) {
                        String str = this.f51070bc.get(this.f51073bf);
                        if (c.k()) {
                            b bVar2 = this.f51075bi;
                            bVar2.c(O + " not in ip list, change to:" + str);
                        }
                        O = str;
                    }
                    c.o(DomainTool.DOMAIN_PREFIX_HTTP + O + ":80/mstat/report");
                }
            }
            this.f51076c = l.E(this.f51074bh);
            if (c.k()) {
                b bVar3 = this.f51075bi;
                bVar3.b((Object) "NETWORK name:" + this.f51076c);
            }
            if (l.e(this.f51076c)) {
                this.f51077g = "WIFI".equalsIgnoreCase(this.f51076c) ? 1 : 2;
                this.f51071bd = l.v(this.f51074bh);
            }
            if (e.a()) {
                e.n(this.f51074bh);
                return;
            }
            return;
        }
        if (c.k()) {
            this.f51075bi.b((Object) "NETWORK TYPE: network is close.");
        }
        Y();
    }

    public final void aa() {
        this.f51074bh.getApplicationContext().registerReceiver(new z(this), new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
    }

    public final String b() {
        return this.f51076c;
    }

    public final void b(String str) {
        if (c.k()) {
            this.f51075bi.b((Object) "updateIpList " + str);
        }
        try {
            if (l.e(str)) {
                JSONObject jSONObject = new JSONObject(str);
                if (jSONObject.length() > 0) {
                    Iterator<String> keys = jSONObject.keys();
                    while (keys.hasNext()) {
                        String string = jSONObject.getString(keys.next());
                        if (l.e(string)) {
                            for (String str2 : string.split(";")) {
                                if (l.e(str2)) {
                                    String[] split = str2.split(":");
                                    if (split.length > 1) {
                                        String str3 = split[0];
                                        if (d(str3) && !this.f51070bc.contains(str3)) {
                                            if (c.k()) {
                                                this.f51075bi.b((Object) "add new ip:" + str3);
                                            }
                                            this.f51070bc.add(str3);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        } catch (Exception e11) {
            this.f51075bi.b((Throwable) e11);
        }
        this.f51073bf = new Random().nextInt(this.f51070bc.size());
    }
}
