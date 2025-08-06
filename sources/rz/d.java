package rz;

import java.util.HashMap;
import java.util.Map;

public class d implements c {

    /* renamed from: a  reason: collision with root package name */
    public final Map<b, Object> f60120a = new HashMap(3);

    public <T> T a(b<T> bVar, T t11) {
        T t12 = this.f60120a.get(bVar);
        return t12 != null ? t12 : t11;
    }

    public <T> void b(b<T> bVar, T t11) {
        if (t11 == null) {
            this.f60120a.remove(bVar);
        } else {
            this.f60120a.put(bVar, t11);
        }
    }

    public <T> T c(b<T> bVar) {
        return this.f60120a.get(bVar);
    }
}
