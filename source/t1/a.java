package t1;

import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.os.Bundle;
import androidx.startup.InitializationProvider;
import androidx.startup.R$string;
import androidx.startup.StartupException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class a {

    /* renamed from: d  reason: collision with root package name */
    public static volatile a f16536d;

    /* renamed from: e  reason: collision with root package name */
    public static final Object f16537e = new Object();

    /* renamed from: a  reason: collision with root package name */
    public final Map<Class<?>, Object> f16538a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public final Set<Class<? extends b<?>>> f16539b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public final Context f16540c;

    public a(Context context) {
        this.f16540c = context.getApplicationContext();
    }

    public static a e(Context context) {
        if (f16536d == null) {
            synchronized (f16537e) {
                if (f16536d == null) {
                    f16536d = new a(context);
                }
            }
        }
        return f16536d;
    }

    public void a() {
        try {
            u1.a.c("Startup");
            b(this.f16540c.getPackageManager().getProviderInfo(new ComponentName(this.f16540c.getPackageName(), InitializationProvider.class.getName()), 128).metaData);
            u1.a.f();
        } catch (PackageManager.NameNotFoundException e11) {
            throw new StartupException((Throwable) e11);
        } catch (Throwable th2) {
            u1.a.f();
            throw th2;
        }
    }

    public void b(Bundle bundle) {
        String string = this.f16540c.getString(R$string.androidx_startup);
        if (bundle != null) {
            try {
                HashSet hashSet = new HashSet();
                for (String str : bundle.keySet()) {
                    if (string.equals(bundle.getString(str, (String) null))) {
                        Class<?> cls = Class.forName(str);
                        if (b.class.isAssignableFrom(cls)) {
                            this.f16539b.add(cls);
                        }
                    }
                }
                for (Class<? extends b<?>> d11 : this.f16539b) {
                    d(d11, hashSet);
                }
            } catch (ClassNotFoundException e11) {
                throw new StartupException((Throwable) e11);
            }
        }
    }

    public <T> T c(Class<? extends b<?>> cls) {
        T t11;
        synchronized (f16537e) {
            t11 = this.f16538a.get(cls);
            if (t11 == null) {
                t11 = d(cls, new HashSet());
            }
        }
        return t11;
    }

    public final <T> T d(Class<? extends b<?>> cls, Set<Class<?>> set) {
        T t11;
        if (u1.a.h()) {
            try {
                u1.a.c(cls.getSimpleName());
            } catch (Throwable th2) {
                u1.a.f();
                throw th2;
            }
        }
        if (!set.contains(cls)) {
            if (!this.f16538a.containsKey(cls)) {
                set.add(cls);
                b bVar = (b) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                List<Class<? extends b<?>>> dependencies = bVar.dependencies();
                if (!dependencies.isEmpty()) {
                    for (Class next : dependencies) {
                        if (!this.f16538a.containsKey(next)) {
                            d(next, set);
                        }
                    }
                }
                t11 = bVar.create(this.f16540c);
                set.remove(cls);
                this.f16538a.put(cls, t11);
            } else {
                t11 = this.f16538a.get(cls);
            }
            u1.a.f();
            return t11;
        }
        throw new IllegalStateException(String.format("Cannot initialize %s. Cycle detected.", new Object[]{cls.getName()}));
    }

    public <T> T f(Class<? extends b<T>> cls) {
        return c(cls);
    }

    public boolean g(Class<? extends b<?>> cls) {
        return this.f16539b.contains(cls);
    }
}
