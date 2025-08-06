package w20;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import o20.h;
import o20.i;
import org.junit.Test;
import org.junit.internal.runners.model.ReflectiveCallable;
import org.junit.runner.Description;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import t20.b;
import t20.d;
import t20.e;
import t20.f;
import x20.c;

public class a extends b<c> {

    /* renamed from: f  reason: collision with root package name */
    public final ConcurrentHashMap<c, Description> f26290f = new ConcurrentHashMap<>();

    /* renamed from: w20.a$a  reason: collision with other inner class name */
    public class C0229a extends ReflectiveCallable {
        public C0229a() throws Exception {
        }

        public Object b() throws Throwable {
            return a.this.C();
        }
    }

    public a(Class<?> cls) throws InitializationError {
        super(cls);
    }

    public List<c> B() {
        return p().i(Test.class);
    }

    public Object C() throws Exception {
        return p().l().newInstance(new Object[0]);
    }

    /* renamed from: D */
    public Description k(c cVar) {
        Description description = this.f26290f.get(cVar);
        if (description != null) {
            return description;
        }
        Description createTestDescription = Description.createTestDescription(p().j(), Q(cVar), cVar.getAnnotations());
        this.f26290f.putIfAbsent(cVar, createTestDescription);
        return createTestDescription;
    }

    public final boolean E(Test test) {
        return F(test) != null;
    }

    public final Class<? extends Throwable> F(Test test) {
        if (test == null || test.expected() == Test.None.class) {
            return null;
        }
        return test.expected();
    }

    public final List<u20.a> G(Object obj) {
        return O(obj);
    }

    public List<u20.c> H(Object obj) {
        Class<u20.c> cls = u20.c.class;
        List<u20.c> g11 = p().g(obj, i.class, cls);
        g11.addAll(p().c(obj, i.class, cls));
        return g11;
    }

    public final long I(Test test) {
        if (test == null) {
            return 0;
        }
        return test.timeout();
    }

    public final boolean J() {
        return p().j().getConstructors().length == 1;
    }

    /* renamed from: K */
    public boolean q(c cVar) {
        return cVar.getAnnotation(h.class) != null;
    }

    public Statement L(c cVar) {
        try {
            Object a11 = new C0229a().a();
            return d0(cVar, a11, Z(cVar, a11, a0(cVar, a11, c0(cVar, a11, N(cVar, a11, M(cVar, a11))))));
        } catch (Throwable th2) {
            return new b(th2);
        }
    }

    public Statement M(c cVar, Object obj) {
        return new d(cVar, obj);
    }

    public Statement N(c cVar, Object obj, Statement statement) {
        Test test = (Test) cVar.getAnnotation(Test.class);
        return E(test) ? new t20.a(statement, F(test)) : statement;
    }

    public List<u20.a> O(Object obj) {
        Class<u20.a> cls = u20.a.class;
        List<u20.a> g11 = p().g(obj, i.class, cls);
        g11.addAll(p().c(obj, i.class, cls));
        return g11;
    }

    /* renamed from: P */
    public void r(c cVar, RunNotifier runNotifier) {
        Description D = k(cVar);
        if (q(cVar)) {
            runNotifier.i(D);
        } else {
            t(L(cVar), D, runNotifier);
        }
    }

    public String Q(c cVar) {
        return cVar.c();
    }

    public void R(List<Throwable> list) {
        W(list);
        Y(list);
    }

    public void S(List<Throwable> list) {
        org.junit.internal.runners.rules.a.f25433e.i(p(), list);
    }

    @Deprecated
    public void T(List<Throwable> list) {
        x(o20.a.class, false, list);
        x(o20.d.class, false, list);
        X(list);
        if (B().size() == 0) {
            list.add(new Exception("No runnable methods"));
        }
    }

    public final void U(List<Throwable> list) {
        org.junit.internal.runners.rules.a.f25435g.i(p(), list);
    }

    public void V(List<Throwable> list) {
        if (p().o()) {
            list.add(new Exception("The inner class " + p().k() + " is not static."));
        }
    }

    public void W(List<Throwable> list) {
        if (!J()) {
            list.add(new Exception("Test class should have exactly one public constructor"));
        }
    }

    public void X(List<Throwable> list) {
        x(Test.class, false, list);
    }

    public void Y(List<Throwable> list) {
        if (!p().o() && J() && p().l().getParameterTypes().length != 0) {
            list.add(new Exception("Test class should have exactly one public zero-argument constructor"));
        }
    }

    public Statement Z(c cVar, Object obj, Statement statement) {
        List<c> i11 = p().i(o20.a.class);
        return i11.isEmpty() ? statement : new e(statement, i11, obj);
    }

    public Statement a0(c cVar, Object obj, Statement statement) {
        List<c> i11 = p().i(o20.d.class);
        return i11.isEmpty() ? statement : new f(statement, i11, obj);
    }

    public final Statement b0(c cVar, List<u20.c> list, Object obj, Statement statement) {
        for (u20.a next : G(obj)) {
            if (!list.contains(next)) {
                statement = next.a(statement, cVar, obj);
            }
        }
        return statement;
    }

    @Deprecated
    public Statement c0(c cVar, Object obj, Statement statement) {
        long I = I((Test) cVar.getAnnotation(Test.class));
        if (I <= 0) {
            return statement;
        }
        return t20.c.c().e(I, TimeUnit.MILLISECONDS).d(statement);
    }

    public final Statement d0(c cVar, Object obj, Statement statement) {
        List<u20.c> H = H(obj);
        return e0(cVar, H, b0(cVar, H, obj, statement));
    }

    public final Statement e0(c cVar, List<u20.c> list, Statement statement) {
        return list.isEmpty() ? statement : new u20.b(statement, list, k(cVar));
    }

    public void i(List<Throwable> list) {
        super.i(list);
        V(list);
        R(list);
        T(list);
        S(list);
        U(list);
    }

    public List<c> l() {
        return B();
    }
}
