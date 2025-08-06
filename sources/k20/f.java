package k20;

import java.util.ArrayList;
import java.util.List;

public final class f {

    /* renamed from: d  reason: collision with root package name */
    public static final List<f> f68225d = new ArrayList();

    /* renamed from: a  reason: collision with root package name */
    public Object f68226a;

    /* renamed from: b  reason: collision with root package name */
    public l f68227b;

    /* renamed from: c  reason: collision with root package name */
    public f f68228c;

    public f(Object obj, l lVar) {
        this.f68226a = obj;
        this.f68227b = lVar;
    }

    public static f a(l lVar, Object obj) {
        List<f> list = f68225d;
        synchronized (list) {
            int size = list.size();
            if (size <= 0) {
                return new f(obj, lVar);
            }
            f remove = list.remove(size - 1);
            remove.f68226a = obj;
            remove.f68227b = lVar;
            remove.f68228c = null;
            return remove;
        }
    }

    public static void b(f fVar) {
        fVar.f68226a = null;
        fVar.f68227b = null;
        fVar.f68228c = null;
        List<f> list = f68225d;
        synchronized (list) {
            if (list.size() < 10000) {
                list.add(fVar);
            }
        }
    }
}
