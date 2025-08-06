package com.alibaba.sdk.android.httpdns.f;

import com.alibaba.sdk.android.httpdns.RequestIpType;
import com.alibaba.sdk.android.httpdns.log.HttpDnsLog;
import java.util.ArrayList;
import java.util.Iterator;
import t2.i;
import x2.b;
import x2.c;

public class o {

    /* renamed from: a  reason: collision with root package name */
    public q2.a f14637a;

    /* renamed from: b  reason: collision with root package name */
    public j f14638b;

    /* renamed from: c  reason: collision with root package name */
    public g f14639c;

    /* renamed from: d  reason: collision with root package name */
    public c f14640d;

    /* renamed from: e  reason: collision with root package name */
    public b f14641e;

    /* renamed from: f  reason: collision with root package name */
    public com.alibaba.sdk.android.httpdns.e.c f14642f;

    public class a implements i<m> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ArrayList f14643a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ RequestIpType f14644b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ String f14645c;

        /* renamed from: com.alibaba.sdk.android.httpdns.f.o$a$a  reason: collision with other inner class name */
        public class C0072a implements b {
            public C0072a() {
            }

            public void a(String str, String[] strArr) {
                o.this.f14638b.h(str, RequestIpType.v4, (String) null, strArr);
            }
        }

        public a(ArrayList arrayList, RequestIpType requestIpType, String str) {
            this.f14643a = arrayList;
            this.f14644b = requestIpType;
            this.f14645c = str;
        }

        public void a(Throwable th2) {
            HttpDnsLog.j("resolve hosts for " + this.f14643a.toString() + " fail", th2);
            Iterator it2 = this.f14643a.iterator();
            while (it2.hasNext()) {
                o.this.f14642f.b((String) it2.next(), this.f14644b);
            }
        }

        /* renamed from: b */
        public void a(m mVar) {
            if (HttpDnsLog.f()) {
                HttpDnsLog.b("resolve hosts for " + this.f14643a.toString() + " " + this.f14644b + " return " + mVar.toString());
            }
            o.this.f14638b.e(this.f14645c, this.f14644b, mVar);
            RequestIpType requestIpType = this.f14644b;
            if (requestIpType == RequestIpType.v4 || requestIpType == RequestIpType.both) {
                for (String next : mVar.c()) {
                    o.this.f14640d.c(next, mVar.a(next).d(), new C0072a());
                }
            }
            Iterator it2 = this.f14643a.iterator();
            while (it2.hasNext()) {
                o.this.f14642f.b((String) it2.next(), this.f14644b);
            }
        }
    }

    public o(q2.a aVar, j jVar, g gVar, c cVar, b bVar, com.alibaba.sdk.android.httpdns.e.c cVar2) {
        this.f14637a = aVar;
        this.f14638b = jVar;
        this.f14639c = gVar;
        this.f14640d = cVar;
        this.f14641e = bVar;
        this.f14642f = cVar2;
    }

    public void d(ArrayList<String> arrayList, RequestIpType requestIpType) {
        if (HttpDnsLog.f()) {
            HttpDnsLog.b("resolve host " + arrayList.toString() + " " + requestIpType);
        }
        ArrayList arrayList2 = new ArrayList(arrayList);
        int size = (arrayList.size() / 5) + 1;
        for (int i11 = 0; i11 < size; i11++) {
            ArrayList arrayList3 = new ArrayList();
            while (arrayList3.size() < 5 && arrayList2.size() > 0) {
                String str = (String) arrayList2.remove(0);
                m2.b b11 = this.f14638b.b(str, requestIpType, (String) null);
                if (w2.a.n(str) && !w2.a.q(str) && !this.f14641e.a(str) && ((b11 == null || b11.b()) && this.f14642f.d(str, requestIpType))) {
                    arrayList3.add(str);
                } else if (HttpDnsLog.f()) {
                    HttpDnsLog.b("resolve ignore host " + str);
                }
            }
            if (arrayList3.size() > 0) {
                if (HttpDnsLog.f()) {
                    HttpDnsLog.g("resolve host " + arrayList3.toString() + " " + requestIpType);
                }
                this.f14639c.b(arrayList3, requestIpType, new a(arrayList3, requestIpType, this.f14637a.u()));
            }
        }
    }
}
