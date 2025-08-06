package f4;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class f<T, Y> {

    /* renamed from: a  reason: collision with root package name */
    public final Map<T, Y> f66256a = new LinkedHashMap(100, 0.75f, true);

    /* renamed from: b  reason: collision with root package name */
    public final long f66257b;

    /* renamed from: c  reason: collision with root package name */
    public long f66258c;

    /* renamed from: d  reason: collision with root package name */
    public long f66259d;

    public f(long j11) {
        this.f66257b = j11;
        this.f66258c = j11;
    }

    public void b() {
        m(0);
    }

    public final void f() {
        m(this.f66258c);
    }

    public synchronized Y g(T t11) {
        return this.f66256a.get(t11);
    }

    public synchronized long h() {
        return this.f66258c;
    }

    public int i(Y y11) {
        return 1;
    }

    public void j(T t11, Y y11) {
    }

    public synchronized Y k(T t11, Y y11) {
        long i11 = (long) i(y11);
        if (i11 >= this.f66258c) {
            j(t11, y11);
            return null;
        }
        if (y11 != null) {
            this.f66259d += i11;
        }
        Y put = this.f66256a.put(t11, y11);
        if (put != null) {
            this.f66259d -= (long) i(put);
            if (!put.equals(y11)) {
                j(t11, put);
            }
        }
        f();
        return put;
    }

    public synchronized Y l(T t11) {
        Y remove;
        remove = this.f66256a.remove(t11);
        if (remove != null) {
            this.f66259d -= (long) i(remove);
        }
        return remove;
    }

    public synchronized void m(long j11) {
        while (this.f66259d > j11) {
            Iterator<Map.Entry<T, Y>> it2 = this.f66256a.entrySet().iterator();
            Map.Entry next = it2.next();
            Object value = next.getValue();
            this.f66259d -= (long) i(value);
            Object key = next.getKey();
            it2.remove();
            j(key, value);
        }
    }
}
