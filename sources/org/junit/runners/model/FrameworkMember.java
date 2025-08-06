package org.junit.runners.model;

import java.lang.reflect.Modifier;
import java.util.List;
import org.junit.runners.model.FrameworkMember;
import x20.a;

public abstract class FrameworkMember<T extends FrameworkMember<T>> implements a {
    public abstract Class<?> a();

    public abstract int b();

    public abstract String c();

    public abstract Class<?> d();

    public boolean e() {
        return Modifier.isPublic(b());
    }

    public boolean f(List<T> list) {
        for (T g11 : list) {
            if (g(g11)) {
                return true;
            }
        }
        return false;
    }

    public abstract boolean g(T t11);

    public boolean h() {
        return Modifier.isStatic(b());
    }
}
