package x2;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentSkipListSet;
import x2.d;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public q2.a f16767a;

    /* renamed from: b  reason: collision with root package name */
    public List<a> f16768b;

    /* renamed from: c  reason: collision with root package name */
    public d.a f16769c = new a();

    /* renamed from: d  reason: collision with root package name */
    public ConcurrentSkipListSet<String> f16770d = new ConcurrentSkipListSet<>();

    public class a implements d.a {
        public a() {
        }

        public Socket a() {
            return new Socket();
        }
    }

    public class b implements b {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ b f16772a;

        public b(b bVar) {
            this.f16772a = bVar;
        }

        public void a(String str, String[] strArr) {
            c.this.f16770d.remove(str);
            b bVar = this.f16772a;
            if (bVar != null) {
                bVar.a(str, strArr);
            }
        }
    }

    public c(q2.a aVar) {
        this.f16767a = aVar;
    }

    public final a b(String str) {
        List<a> list = this.f16768b;
        if (list == null || list.size() <= 0) {
            return null;
        }
        Iterator it2 = new ArrayList(this.f16768b).iterator();
        while (it2.hasNext()) {
            a aVar = (a) it2.next();
            if (str.equals(aVar.a())) {
                return aVar;
            }
        }
        return null;
    }

    public void c(String str, String[] strArr, b bVar) {
        a b11;
        if (!this.f16767a.r() && (b11 = b(str)) != null && strArr != null && strArr.length > 1 && !this.f16770d.contains(str)) {
            this.f16770d.add(str);
            try {
                this.f16767a.c().execute(new d(this.f16769c, str, strArr, b11, new b(bVar)));
            } catch (Exception unused) {
                this.f16770d.remove(str);
            }
        }
    }

    public void d(List<a> list) {
        this.f16768b = list;
    }
}
