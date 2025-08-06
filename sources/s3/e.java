package s3;

import com.bumptech.glide.Registry;
import com.bumptech.glide.load.model.d;
import com.bumptech.glide.load.model.f;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class e {

    /* renamed from: a  reason: collision with root package name */
    public final f f66606a;

    /* renamed from: b  reason: collision with root package name */
    public final a f66607b;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public final Map<Class<?>, C0729a<?>> f66608a = new HashMap();

        /* renamed from: s3.e$a$a  reason: collision with other inner class name */
        public static class C0729a<Model> {

            /* renamed from: a  reason: collision with root package name */
            public final List<d<Model, ?>> f66609a;

            public C0729a(List<d<Model, ?>> list) {
                this.f66609a = list;
            }
        }

        public void a() {
            this.f66608a.clear();
        }

        public <Model> List<d<Model, ?>> b(Class<Model> cls) {
            C0729a aVar = this.f66608a.get(cls);
            if (aVar == null) {
                return null;
            }
            return aVar.f66609a;
        }

        public <Model> void c(Class<Model> cls, List<d<Model, ?>> list) {
            if (this.f66608a.put(cls, new C0729a(list)) != null) {
                throw new IllegalStateException("Already cached loaders for model: " + cls);
            }
        }
    }

    public e(androidx.core.util.e<List<Throwable>> eVar) {
        this(new f(eVar));
    }

    public static <A> Class<A> b(A a11) {
        return a11.getClass();
    }

    public synchronized <Model, Data> void a(Class<Model> cls, Class<Data> cls2, d<? extends Model, ? extends Data> dVar) {
        this.f66606a.b(cls, cls2, dVar);
        this.f66607b.a();
    }

    public synchronized List<Class<?>> c(Class<?> cls) {
        return this.f66606a.g(cls);
    }

    public <A> List<d<A, ?>> d(A a11) {
        List e11 = e(b(a11));
        if (!e11.isEmpty()) {
            int size = e11.size();
            List<d<A, ?>> emptyList = Collections.emptyList();
            boolean z11 = true;
            for (int i11 = 0; i11 < size; i11++) {
                d dVar = (d) e11.get(i11);
                if (dVar.b(a11)) {
                    if (z11) {
                        emptyList = new ArrayList<>(size - i11);
                        z11 = false;
                    }
                    emptyList.add(dVar);
                }
            }
            if (!emptyList.isEmpty()) {
                return emptyList;
            }
            throw new Registry.NoModelLoaderAvailableException(a11, e11);
        }
        throw new Registry.NoModelLoaderAvailableException(a11);
    }

    public final synchronized <A> List<d<A, ?>> e(Class<A> cls) {
        List<d<A, ?>> b11;
        b11 = this.f66607b.b(cls);
        if (b11 == null) {
            b11 = Collections.unmodifiableList(this.f66606a.e(cls));
            this.f66607b.c(cls, b11);
        }
        return b11;
    }

    public synchronized <Model, Data> void f(Class<Model> cls, Class<Data> cls2, d<? extends Model, ? extends Data> dVar) {
        g(this.f66606a.j(cls, cls2, dVar));
        this.f66607b.a();
    }

    public final <Model, Data> void g(List<d<? extends Model, ? extends Data>> list) {
        for (d<? extends Model, ? extends Data> teardown : list) {
            teardown.teardown();
        }
    }

    public e(f fVar) {
        this.f66607b = new a();
        this.f66606a = fVar;
    }
}
