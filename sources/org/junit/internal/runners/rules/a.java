package org.junit.internal.runners.rules;

import java.lang.annotation.Annotation;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.List;
import org.junit.runners.model.FrameworkMember;

public class a {

    /* renamed from: d  reason: collision with root package name */
    public static final a f25432d = d().f(new c()).f(new h()).f(new g()).f(new e()).d();

    /* renamed from: e  reason: collision with root package name */
    public static final a f25433e = h().f(new f()).f(new g()).f(new d()).d();

    /* renamed from: f  reason: collision with root package name */
    public static final a f25434f = d().e().f(new c()).f(new h()).f(new g()).f(new j()).d();

    /* renamed from: g  reason: collision with root package name */
    public static final a f25435g = h().e().f(new f()).f(new g()).f(new i()).d();

    /* renamed from: a  reason: collision with root package name */
    public final Class<? extends Annotation> f25436a;

    /* renamed from: b  reason: collision with root package name */
    public final boolean f25437b;

    /* renamed from: c  reason: collision with root package name */
    public final List<k> f25438c;

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public final Class<? extends Annotation> f25439a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f25440b;

        /* renamed from: c  reason: collision with root package name */
        public final List<k> f25441c;

        public a d() {
            return new a(this);
        }

        public b e() {
            this.f25440b = true;
            return this;
        }

        public b f(k kVar) {
            this.f25441c.add(kVar);
            return this;
        }

        public b(Class<? extends Annotation> cls) {
            this.f25439a = cls;
            this.f25440b = false;
            this.f25441c = new ArrayList();
        }
    }

    public static final class c implements k {
        public c() {
        }

        public void a(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!b(frameworkMember)) {
                list.add(new ValidationError(frameworkMember, cls, "must be declared in a public class."));
            }
        }

        public final boolean b(FrameworkMember<?> frameworkMember) {
            return Modifier.isPublic(frameworkMember.a().getModifiers());
        }
    }

    public static final class d implements k {
        public d() {
        }

        public void a(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!a.f(frameworkMember)) {
                list.add(new ValidationError(frameworkMember, cls, "must implement MethodRule or TestRule."));
            }
        }
    }

    public static final class e implements k {
        public e() {
        }

        public void a(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!a.g(frameworkMember)) {
                list.add(new ValidationError(frameworkMember, cls, "must implement TestRule."));
            }
        }
    }

    public static final class f implements k {
        public f() {
        }

        public void a(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            boolean a11 = a.e(frameworkMember);
            boolean z11 = frameworkMember.getAnnotation(o20.f.class) != null;
            if (!frameworkMember.h()) {
                return;
            }
            if (a11 || !z11) {
                list.add(new ValidationError(frameworkMember, cls, a.e(frameworkMember) ? "must not be static." : "must not be static or it must be annotated with @ClassRule."));
            }
        }
    }

    public static final class g implements k {
        public g() {
        }

        public void a(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!frameworkMember.e()) {
                list.add(new ValidationError(frameworkMember, cls, "must be public."));
            }
        }
    }

    public static final class h implements k {
        public h() {
        }

        public void a(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!frameworkMember.h()) {
                list.add(new ValidationError(frameworkMember, cls, "must be static."));
            }
        }
    }

    public static final class i implements k {
        public i() {
        }

        public void a(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!a.f(frameworkMember)) {
                list.add(new ValidationError(frameworkMember, cls, "must return an implementation of MethodRule or TestRule."));
            }
        }
    }

    public static final class j implements k {
        public j() {
        }

        public void a(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list) {
            if (!a.g(frameworkMember)) {
                list.add(new ValidationError(frameworkMember, cls, "must return an implementation of TestRule."));
            }
        }
    }

    public interface k {
        void a(FrameworkMember<?> frameworkMember, Class<? extends Annotation> cls, List<Throwable> list);
    }

    public a(b bVar) {
        this.f25436a = bVar.f25439a;
        this.f25437b = bVar.f25440b;
        this.f25438c = bVar.f25441c;
    }

    public static b d() {
        return new b(o20.f.class);
    }

    public static boolean e(FrameworkMember<?> frameworkMember) {
        return u20.a.class.isAssignableFrom(frameworkMember.d());
    }

    public static boolean f(FrameworkMember<?> frameworkMember) {
        return e(frameworkMember) || g(frameworkMember);
    }

    public static boolean g(FrameworkMember<?> frameworkMember) {
        return u20.c.class.isAssignableFrom(frameworkMember.d());
    }

    public static b h() {
        return new b(o20.i.class);
    }

    public void i(x20.e eVar, List<Throwable> list) {
        for (FrameworkMember j11 : this.f25437b ? eVar.i(this.f25436a) : eVar.e(this.f25436a)) {
            j(j11, list);
        }
    }

    public final void j(FrameworkMember<?> frameworkMember, List<Throwable> list) {
        for (k a11 : this.f25438c) {
            a11.a(frameworkMember, this.f25436a, list);
        }
    }
}
