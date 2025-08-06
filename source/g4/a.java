package g4;

import android.util.Log;
import java.util.ArrayList;
import java.util.List;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final g<Object> f66264a = new C0717a();

    /* renamed from: g4.a$a  reason: collision with other inner class name */
    public class C0717a implements g<Object> {
        public void a(Object obj) {
        }
    }

    public class b implements d<List<T>> {
        /* renamed from: a */
        public List<T> create() {
            return new ArrayList();
        }
    }

    public class c implements g<List<T>> {
        /* renamed from: b */
        public void a(List<T> list) {
            list.clear();
        }
    }

    public interface d<T> {
        T create();
    }

    public static final class e<T> implements androidx.core.util.e<T> {

        /* renamed from: a  reason: collision with root package name */
        public final d<T> f66265a;

        /* renamed from: b  reason: collision with root package name */
        public final g<T> f66266b;

        /* renamed from: c  reason: collision with root package name */
        public final androidx.core.util.e<T> f66267c;

        public e(androidx.core.util.e<T> eVar, d<T> dVar, g<T> gVar) {
            this.f66267c = eVar;
            this.f66265a = dVar;
            this.f66266b = gVar;
        }

        public T acquire() {
            T acquire = this.f66267c.acquire();
            if (acquire == null) {
                acquire = this.f66265a.create();
                if (Log.isLoggable("FactoryPools", 2)) {
                    Log.v("FactoryPools", "Created new " + acquire.getClass());
                }
            }
            if (acquire instanceof f) {
                ((f) acquire).e().b(false);
            }
            return acquire;
        }

        public boolean release(T t11) {
            if (t11 instanceof f) {
                ((f) t11).e().b(true);
            }
            this.f66266b.a(t11);
            return this.f66267c.release(t11);
        }
    }

    public interface f {
        c e();
    }

    public interface g<T> {
        void a(T t11);
    }

    public static <T extends f> androidx.core.util.e<T> a(androidx.core.util.e<T> eVar, d<T> dVar) {
        return b(eVar, dVar, c());
    }

    public static <T> androidx.core.util.e<T> b(androidx.core.util.e<T> eVar, d<T> dVar, g<T> gVar) {
        return new e(eVar, dVar, gVar);
    }

    public static <T> g<T> c() {
        return f66264a;
    }

    public static <T extends f> androidx.core.util.e<T> d(int i11, d<T> dVar) {
        return a(new androidx.core.util.g(i11), dVar);
    }

    public static <T> androidx.core.util.e<List<T>> e() {
        return f(20);
    }

    public static <T> androidx.core.util.e<List<T>> f(int i11) {
        return b(new androidx.core.util.g(i11), new b(), new c());
    }
}
