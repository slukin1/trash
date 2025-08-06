package q2;

import android.app.Application;
import android.content.Context;
import com.alibaba.sdk.android.crashdefend.CrashDefendApi;
import com.alibaba.sdk.android.httpdns.HttpDnsSettings;
import com.alibaba.sdk.android.httpdns.InitConfig;
import com.alibaba.sdk.android.httpdns.RequestIpType;
import com.alibaba.sdk.android.httpdns.f.g;
import com.alibaba.sdk.android.httpdns.f.j;
import com.alibaba.sdk.android.httpdns.f.k;
import com.alibaba.sdk.android.httpdns.f.o;
import com.alibaba.sdk.android.httpdns.log.HttpDnsLog;
import com.alibaba.sdk.android.sender.AlicloudSender;
import com.alibaba.sdk.android.sender.SdkInfo;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import m2.c;
import r2.a;
import u2.a;

public class d implements c, a.c, a.b {

    /* renamed from: a  reason: collision with root package name */
    public a f16400a;

    /* renamed from: b  reason: collision with root package name */
    public j f16401b;

    /* renamed from: c  reason: collision with root package name */
    public g f16402c;

    /* renamed from: d  reason: collision with root package name */
    public u2.a f16403d;

    /* renamed from: e  reason: collision with root package name */
    public x2.c f16404e;

    /* renamed from: f  reason: collision with root package name */
    public k f16405f;

    /* renamed from: g  reason: collision with root package name */
    public o f16406g;

    /* renamed from: h  reason: collision with root package name */
    public com.alibaba.sdk.android.httpdns.f.b f16407h;

    /* renamed from: i  reason: collision with root package name */
    public e f16408i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f16409j = true;

    /* renamed from: k  reason: collision with root package name */
    public com.alibaba.sdk.android.httpdns.e.c f16410k = new com.alibaba.sdk.android.httpdns.e.c();

    public class a implements k2.a {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f16411a;

        public a(a aVar) {
            this.f16411a = aVar;
        }

        public void a(int i11, int i12, int i13) {
            this.f16411a.k(false);
        }

        public void b(int i11, int i12, int i13, long j11) {
            this.f16411a.k(true);
            HttpDnsLog.i("sdk is not safe to run");
        }

        public void c(int i11) {
            this.f16411a.k(true);
            HttpDnsLog.c("sdk will not run any more");
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            HashMap<String, RequestIpType> a11 = d.this.f16401b.a();
            HttpDnsLog.b("network change, clean record");
            d.this.f16401b.j();
            if (d.this.f16409j && d.this.f16400a.w()) {
                ArrayList arrayList = new ArrayList();
                ArrayList arrayList2 = new ArrayList();
                ArrayList arrayList3 = new ArrayList();
                for (Map.Entry next : a11.entrySet()) {
                    if (next.getValue() == RequestIpType.v4) {
                        arrayList.add(next.getKey());
                    } else {
                        Object value = next.getValue();
                        RequestIpType requestIpType = RequestIpType.v6;
                        Object key = next.getKey();
                        if (value == requestIpType) {
                            arrayList2.add(key);
                        } else {
                            arrayList3.add(key);
                        }
                    }
                }
                if (arrayList.size() > 0) {
                    d.this.f16406g.d(arrayList, RequestIpType.v4);
                }
                if (arrayList2.size() > 0) {
                    d.this.f16406g.d(arrayList2, RequestIpType.v6);
                }
                if (arrayList3.size() > 0) {
                    d.this.f16406g.d(arrayList3, RequestIpType.both);
                }
                if (arrayList.size() > 0 || arrayList2.size() > 0 || arrayList3.size() > 0) {
                    HttpDnsLog.b("network change, resolve hosts");
                }
            }
        }
    }

    public d(Context context, String str, String str2) {
        Context context2 = context;
        String str3 = str;
        try {
            this.f16400a = new a(context2, str3);
            this.f16407h = new com.alibaba.sdk.android.httpdns.f.b();
            this.f16408i = new e(str2);
            x2.c cVar = new x2.c(this.f16400a);
            this.f16404e = cVar;
            this.f16401b = new j(this.f16400a, cVar, new o2.a(this.f16400a.t(), this.f16400a.s()), new com.alibaba.sdk.android.httpdns.f.d());
            u2.a aVar = new u2.a(this.f16400a, this);
            this.f16403d = aVar;
            g gVar = new g(this.f16400a, aVar, this.f16408i);
            this.f16402c = gVar;
            this.f16405f = new k(this.f16400a, this.f16404e, gVar, this.f16401b, this.f16407h, this.f16410k);
            this.f16406g = new o(this.f16400a, this.f16401b, this.f16402c, this.f16404e, this.f16407h, this.f16410k);
            k();
            m(str3);
            l(context2, this.f16400a);
            if (!this.f16400a.w()) {
                HttpDnsLog.i("init fail, crashdefend");
                return;
            }
            r2.a.f().g(context2);
            r2.a.f().h(this);
            if (this.f16400a.e().j() || !this.f16400a.o()) {
                this.f16403d.f();
            }
            s2.b.c(context);
            s2.b.b(str).g(str3);
            h(context, str);
            i(context2, str3, this.f16400a);
            if (HttpDnsLog.f()) {
                HttpDnsLog.b("httpdns service is inited " + str3);
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public void a(String str) {
        if (this.f16400a.w()) {
            try {
                this.f16400a.c().execute(new b());
            } catch (Exception unused) {
            }
        }
    }

    public String b(String str) {
        StringBuilder sb2;
        String str2;
        String sb3;
        if (!this.f16400a.w()) {
            sb3 = "service is disabled";
        } else {
            if (!w2.a.n(str)) {
                sb2 = new StringBuilder();
                str2 = "host is invalid. ";
            } else if (w2.a.q(str)) {
                sb2 = new StringBuilder();
                str2 = "host is ip. ";
            } else {
                String[] o11 = o(str);
                if (o11 == null || o11.length == 0) {
                    return null;
                }
                return o11[0];
            }
            sb2.append(str2);
            sb2.append(str);
            sb3 = sb2.toString();
        }
        HttpDnsLog.g(sb3);
        return null;
    }

    public void c(boolean z11) {
        if (this.f16400a.w() && this.f16400a.h(z11) && z11 && this.f16400a.e().j()) {
            this.f16403d.f();
        }
    }

    public void d(ArrayList<String> arrayList) {
        if (!this.f16400a.w()) {
            HttpDnsLog.g("service is disabled");
        } else if (arrayList == null || arrayList.size() == 0) {
            HttpDnsLog.g("setPreResolveHosts empty list");
        } else {
            t(arrayList, RequestIpType.v4);
        }
    }

    public void e(String str) {
        if (!this.f16400a.w()) {
            HttpDnsLog.g("service is disabled");
            return;
        }
        String h11 = w2.a.h(str);
        if (!w2.a.e(this.f16400a.u(), h11) || !this.f16400a.o() || this.f16400a.q()) {
            if (this.f16400a.g(h11)) {
                this.f16401b.j();
            }
            this.f16403d.g(h11);
        } else if (HttpDnsLog.f()) {
            HttpDnsLog.b("region " + h11 + " is same, do not update serverIps");
        }
    }

    public void e(boolean z11) {
        if (this.f16400a.w()) {
            if (z11) {
                this.f16401b.j();
            }
            this.f16402c.c();
        }
    }

    public void f(m2.d dVar) {
        HttpDnsLog.h(dVar);
    }

    public void h(Context context, String str) {
        if (HttpDnsSettings.b()) {
            try {
                HashMap hashMap = new HashMap();
                hashMap.put("accountId", str);
                SdkInfo sdkInfo = new SdkInfo();
                sdkInfo.e("httpdns");
                sdkInfo.f("2.2.2");
                sdkInfo.d(hashMap);
                if (context.getApplicationContext() instanceof Application) {
                    AlicloudSender.g((Application) context.getApplicationContext(), sdkInfo);
                } else {
                    AlicloudSender.h(context.getApplicationContext(), sdkInfo);
                }
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }
    }

    public void i(Context context, String str, a aVar) {
        n2.a.a(context, str, aVar);
    }

    public void k() {
    }

    public void l(Context context, a aVar) {
        CrashDefendApi.a(context, "httpdns", "2.2.2", 2, 7, new a(aVar));
    }

    public final void m(String str) {
        InitConfig a11 = InitConfig.a(str);
        if (a11 != null) {
            this.f16400a.y(a11.d());
            this.f16400a.h(a11.g());
            r(a11.f());
            if (a11.b() != null) {
                s(a11.b());
            }
            this.f16400a.g(a11.c());
            p(a11.e());
        }
    }

    public void n(String str) {
        if (this.f16400a.w()) {
            if (str == null || str.equals("")) {
                HttpDnsLog.c("set empty secret!?");
            }
            this.f16408i.b(str);
        }
    }

    public String[] o(String str) {
        if (!this.f16400a.w()) {
            HttpDnsLog.g("service is disabled");
            return new String[0];
        } else if (!w2.a.n(str)) {
            HttpDnsLog.g("host is invalid. " + str);
            return new String[0];
        } else if (!w2.a.q(str)) {
            return this.f16405f.c(str, RequestIpType.v4, (Map<String, String>) null, (String) null).a();
        } else {
            HttpDnsLog.g("host is ip. " + str);
            return new String[0];
        }
    }

    public void p(boolean z11) {
        if (this.f16400a.w()) {
            q(z11, false);
        }
    }

    public void q(boolean z11, boolean z12) {
        if (this.f16400a.w()) {
            this.f16401b.l(z11, z12);
        }
    }

    public void r(boolean z11) {
        if (this.f16400a.w()) {
            this.f16405f.e(z11);
        }
    }

    public void s(List<x2.a> list) {
        if (this.f16400a.w()) {
            this.f16404e.d(list);
        }
    }

    public void setLogEnabled(boolean z11) {
        if (this.f16400a.w()) {
            HttpDnsLog.e(z11);
        }
    }

    public void t(ArrayList<String> arrayList, RequestIpType requestIpType) {
        if (!this.f16400a.w()) {
            HttpDnsLog.g("service is disabled");
        } else if (arrayList == null || arrayList.size() == 0) {
            HttpDnsLog.g("setPreResolveHosts empty list");
        } else {
            this.f16406g.d(arrayList, requestIpType);
        }
    }
}
