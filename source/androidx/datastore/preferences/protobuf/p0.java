package androidx.datastore.preferences.protobuf;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class p0 {

    /* renamed from: c  reason: collision with root package name */
    public static final p0 f9190c = new p0();

    /* renamed from: a  reason: collision with root package name */
    public final u0 f9191a = new ManifestSchemaFactory();

    /* renamed from: b  reason: collision with root package name */
    public final ConcurrentMap<Class<?>, t0<?>> f9192b = new ConcurrentHashMap();

    public static p0 a() {
        return f9190c;
    }

    public <T> void b(T t11, s0 s0Var, l lVar) throws IOException {
        e(t11).b(t11, s0Var, lVar);
    }

    public t0<?> c(Class<?> cls, t0<?> t0Var) {
        u.b(cls, "messageType");
        u.b(t0Var, "schema");
        return this.f9192b.putIfAbsent(cls, t0Var);
    }

    public <T> t0<T> d(Class<T> cls) {
        u.b(cls, "messageType");
        t0<T> t0Var = (t0) this.f9192b.get(cls);
        if (t0Var != null) {
            return t0Var;
        }
        t0<T> createSchema = this.f9191a.createSchema(cls);
        t0<?> c11 = c(cls, createSchema);
        return c11 != null ? c11 : createSchema;
    }

    public <T> t0<T> e(T t11) {
        return d(t11.getClass());
    }
}
