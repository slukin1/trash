package kotlinx.coroutines.internal;

import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;
import kotlinx.coroutines.MainCoroutineDispatcher;

public final class t {

    /* renamed from: a  reason: collision with root package name */
    public static final t f57344a;

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f57345b = d0.f("kotlinx.coroutines.fast.service.loader", true);

    /* renamed from: c  reason: collision with root package name */
    public static final MainCoroutineDispatcher f57346c;

    static {
        t tVar = new t();
        f57344a = tVar;
        f57346c = tVar.a();
    }

    public final MainCoroutineDispatcher a() {
        List<s> list;
        T t11;
        MainCoroutineDispatcher e11;
        Class<s> cls = s.class;
        try {
            if (f57345b) {
                list = k.f57323a.c();
            } else {
                list = SequencesKt___SequencesKt.w(SequencesKt__SequencesKt.c(ServiceLoader.load(cls, cls.getClassLoader()).iterator()));
            }
            Iterator<T> it2 = list.iterator();
            if (!it2.hasNext()) {
                t11 = null;
            } else {
                t11 = it2.next();
                if (it2.hasNext()) {
                    int a11 = ((s) t11).a();
                    do {
                        T next = it2.next();
                        int a12 = ((s) next).a();
                        if (a11 < a12) {
                            t11 = next;
                            a11 = a12;
                        }
                    } while (it2.hasNext());
                }
            }
            s sVar = (s) t11;
            if (sVar == null || (e11 = u.e(sVar, list)) == null) {
                return u.b((Throwable) null, (String) null, 3, (Object) null);
            }
            return e11;
        } catch (Throwable th2) {
            return u.b(th2, (String) null, 2, (Object) null);
        }
    }
}
