package kotlin.jvm.internal;

import com.iproov.sdk.bridge.OptionsBridge;
import d10.f;
import d10.g;
import d10.h;
import d10.i;
import d10.j;
import d10.k;
import d10.l;
import d10.m;
import d10.n;
import d10.o;
import d10.p;
import d10.q;
import d10.r;
import d10.s;
import d10.t;
import d10.u;
import d10.v;
import d10.w;
import e10.a;
import e10.b;
import e10.c;
import e10.d;
import e10.e;
import java.util.Collection;
import java.util.List;
import java.util.Map;

public class TypeIntrinsics {
    public static Collection a(Object obj) {
        if ((obj instanceof a) && !(obj instanceof b)) {
            o(obj, "kotlin.collections.MutableCollection");
        }
        return f(obj);
    }

    public static Iterable b(Object obj) {
        if ((obj instanceof a) && !(obj instanceof c)) {
            o(obj, "kotlin.collections.MutableIterable");
        }
        return g(obj);
    }

    public static List c(Object obj) {
        if ((obj instanceof a) && !(obj instanceof d)) {
            o(obj, "kotlin.collections.MutableList");
        }
        return h(obj);
    }

    public static Map d(Object obj) {
        if ((obj instanceof a) && !(obj instanceof e)) {
            o(obj, "kotlin.collections.MutableMap");
        }
        return i(obj);
    }

    public static Object e(Object obj, int i11) {
        if (obj != null && !k(obj, i11)) {
            o(obj, "kotlin.jvm.functions.Function" + i11);
        }
        return obj;
    }

    public static Collection f(Object obj) {
        try {
            return (Collection) obj;
        } catch (ClassCastException e11) {
            throw n(e11);
        }
    }

    public static Iterable g(Object obj) {
        try {
            return (Iterable) obj;
        } catch (ClassCastException e11) {
            throw n(e11);
        }
    }

    public static List h(Object obj) {
        try {
            return (List) obj;
        } catch (ClassCastException e11) {
            throw n(e11);
        }
    }

    public static Map i(Object obj) {
        try {
            return (Map) obj;
        } catch (ClassCastException e11) {
            throw n(e11);
        }
    }

    public static int j(Object obj) {
        if (obj instanceof v) {
            return ((v) obj).getArity();
        }
        if (obj instanceof d10.a) {
            return 0;
        }
        if (obj instanceof l) {
            return 1;
        }
        if (obj instanceof p) {
            return 2;
        }
        if (obj instanceof q) {
            return 3;
        }
        if (obj instanceof r) {
            return 4;
        }
        if (obj instanceof s) {
            return 5;
        }
        if (obj instanceof t) {
            return 6;
        }
        if (obj instanceof u) {
            return 7;
        }
        if (obj instanceof v) {
            return 8;
        }
        if (obj instanceof w) {
            return 9;
        }
        if (obj instanceof d10.b) {
            return 10;
        }
        if (obj instanceof d10.c) {
            return 11;
        }
        if (obj instanceof d10.d) {
            return 12;
        }
        if (obj instanceof d10.e) {
            return 13;
        }
        if (obj instanceof f) {
            return 14;
        }
        if (obj instanceof g) {
            return 15;
        }
        if (obj instanceof h) {
            return 16;
        }
        if (obj instanceof i) {
            return 17;
        }
        if (obj instanceof j) {
            return 18;
        }
        if (obj instanceof k) {
            return 19;
        }
        if (obj instanceof m) {
            return 20;
        }
        if (obj instanceof n) {
            return 21;
        }
        return obj instanceof o ? 22 : -1;
    }

    public static boolean k(Object obj, int i11) {
        return (obj instanceof kotlin.f) && j(obj) == i11;
    }

    public static boolean l(Object obj) {
        return (obj instanceof Map) && (!(obj instanceof a) || (obj instanceof e));
    }

    public static <T extends Throwable> T m(T t11) {
        return x.h(t11, TypeIntrinsics.class.getName());
    }

    public static ClassCastException n(ClassCastException classCastException) {
        throw ((ClassCastException) m(classCastException));
    }

    public static void o(Object obj, String str) {
        String name = obj == null ? OptionsBridge.NULL_VALUE : obj.getClass().getName();
        p(name + " cannot be cast to " + str);
    }

    public static void p(String str) {
        throw n(new ClassCastException(str));
    }
}
