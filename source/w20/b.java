package w20;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import o20.f;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.notification.RunNotifier;
import org.junit.runner.notification.StoppedByUserException;
import org.junit.runners.model.InitializationError;
import org.junit.runners.model.Statement;
import org.junit.validator.AnnotationsValidator;
import org.junit.validator.PublicClassValidator;
import x20.d;
import x20.e;

public abstract class b<T> extends Runner implements v20.a {

    /* renamed from: e  reason: collision with root package name */
    public static final List<y20.a> f26292e = Arrays.asList(new y20.a[]{new AnnotationsValidator(), new PublicClassValidator()});

    /* renamed from: a  reason: collision with root package name */
    public final Object f26293a = new Object();

    /* renamed from: b  reason: collision with root package name */
    public final e f26294b;

    /* renamed from: c  reason: collision with root package name */
    public volatile Collection<T> f26295c = null;

    /* renamed from: d  reason: collision with root package name */
    public volatile d f26296d = new a();

    public class a implements d {
        public a() {
        }

        public void a(Runnable runnable) {
            runnable.run();
        }

        public void b() {
        }
    }

    /* renamed from: w20.b$b  reason: collision with other inner class name */
    public class C0230b extends Statement {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ RunNotifier f26298a;

        public C0230b(RunNotifier runNotifier) {
            this.f26298a = runNotifier;
        }

        public void a() {
            b.this.s(this.f26298a);
        }
    }

    public class c implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Object f26300b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ RunNotifier f26301c;

        public c(Object obj, RunNotifier runNotifier) {
            this.f26300b = obj;
            this.f26301c = runNotifier;
        }

        public void run() {
            b.this.r(this.f26300b, this.f26301c);
        }
    }

    public b(Class<?> cls) throws InitializationError {
        this.f26294b = j(cls);
        v();
    }

    public final Statement A(Statement statement) {
        List<u20.c> h11 = h();
        return h11.isEmpty() ? statement : new u20.b(statement, h11, getDescription());
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:8|9|10|11|25) */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0010, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x0024 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(org.junit.runner.manipulation.Filter r6) throws org.junit.runner.manipulation.NoTestsRemainException {
        /*
            r5 = this;
            java.lang.Object r0 = r5.f26293a
            monitor-enter(r0)
            java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0042 }
            java.util.Collection r2 = r5.m()     // Catch:{ all -> 0x0042 }
            r1.<init>(r2)     // Catch:{ all -> 0x0042 }
            java.util.Iterator r2 = r1.iterator()     // Catch:{ all -> 0x0042 }
        L_0x0010:
            boolean r3 = r2.hasNext()     // Catch:{ all -> 0x0042 }
            if (r3 == 0) goto L_0x002c
            java.lang.Object r3 = r2.next()     // Catch:{ all -> 0x0042 }
            boolean r4 = r5.u(r6, r3)     // Catch:{ all -> 0x0042 }
            if (r4 == 0) goto L_0x0028
            r6.a(r3)     // Catch:{ NoTestsRemainException -> 0x0024 }
            goto L_0x0010
        L_0x0024:
            r2.remove()     // Catch:{ all -> 0x0042 }
            goto L_0x0010
        L_0x0028:
            r2.remove()     // Catch:{ all -> 0x0042 }
            goto L_0x0010
        L_0x002c:
            java.util.Collection r6 = java.util.Collections.unmodifiableCollection(r1)     // Catch:{ all -> 0x0042 }
            r5.f26295c = r6     // Catch:{ all -> 0x0042 }
            java.util.Collection<T> r6 = r5.f26295c     // Catch:{ all -> 0x0042 }
            boolean r6 = r6.isEmpty()     // Catch:{ all -> 0x0042 }
            if (r6 != 0) goto L_0x003c
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            return
        L_0x003c:
            org.junit.runner.manipulation.NoTestsRemainException r6 = new org.junit.runner.manipulation.NoTestsRemainException     // Catch:{ all -> 0x0042 }
            r6.<init>()     // Catch:{ all -> 0x0042 }
            throw r6     // Catch:{ all -> 0x0042 }
        L_0x0042:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0042 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: w20.b.a(org.junit.runner.manipulation.Filter):void");
    }

    public void b(RunNotifier runNotifier) {
        s20.a aVar = new s20.a(runNotifier, getDescription());
        try {
            g(runNotifier).a();
        } catch (AssumptionViolatedException e11) {
            aVar.a(e11);
        } catch (StoppedByUserException e12) {
            throw e12;
        } catch (Throwable th2) {
            aVar.b(th2);
        }
    }

    public final void d(List<Throwable> list) {
        if (p().j() != null) {
            for (y20.a a11 : f26292e) {
                list.addAll(a11.a(p()));
            }
        }
    }

    public final boolean e() {
        for (Object q11 : m()) {
            if (!q(q11)) {
                return false;
            }
        }
        return true;
    }

    public Statement f(RunNotifier runNotifier) {
        return new C0230b(runNotifier);
    }

    public Statement g(RunNotifier runNotifier) {
        Statement f11 = f(runNotifier);
        return !e() ? A(y(z(f11))) : f11;
    }

    public Description getDescription() {
        Description createSuiteDescription = Description.createSuiteDescription(n(), o());
        for (Object k11 : m()) {
            createSuiteDescription.addChild(k(k11));
        }
        return createSuiteDescription;
    }

    public List<u20.c> h() {
        Class<u20.c> cls = u20.c.class;
        List<u20.c> g11 = this.f26294b.g((Object) null, f.class, cls);
        g11.addAll(this.f26294b.c((Object) null, f.class, cls));
        return g11;
    }

    public void i(List<Throwable> list) {
        x(o20.e.class, true, list);
        x(o20.b.class, true, list);
        w(list);
        d(list);
    }

    public e j(Class<?> cls) {
        return new e(cls);
    }

    public abstract Description k(T t11);

    public abstract List<T> l();

    public final Collection<T> m() {
        if (this.f26295c == null) {
            synchronized (this.f26293a) {
                if (this.f26295c == null) {
                    this.f26295c = Collections.unmodifiableCollection(l());
                }
            }
        }
        return this.f26295c;
    }

    public String n() {
        return this.f26294b.k();
    }

    public Annotation[] o() {
        return this.f26294b.getAnnotations();
    }

    public final e p() {
        return this.f26294b;
    }

    public boolean q(T t11) {
        return false;
    }

    public abstract void r(T t11, RunNotifier runNotifier);

    public final void s(RunNotifier runNotifier) {
        d dVar = this.f26296d;
        try {
            for (Object cVar : m()) {
                dVar.a(new c(cVar, runNotifier));
            }
        } finally {
            dVar.b();
        }
    }

    public final void t(Statement statement, Description description, RunNotifier runNotifier) {
        s20.a aVar = new s20.a(runNotifier, description);
        aVar.e();
        try {
            statement.a();
        } catch (AssumptionViolatedException e11) {
            aVar.a(e11);
        } catch (Throwable th2) {
            aVar.d();
            throw th2;
        }
        aVar.d();
    }

    public final boolean u(Filter filter, T t11) {
        return filter.c(k(t11));
    }

    public final void v() throws InitializationError {
        ArrayList arrayList = new ArrayList();
        i(arrayList);
        if (!arrayList.isEmpty()) {
            throw new InitializationError((List<Throwable>) arrayList);
        }
    }

    public final void w(List<Throwable> list) {
        org.junit.internal.runners.rules.a.f25432d.i(p(), list);
        org.junit.internal.runners.rules.a.f25434f.i(p(), list);
    }

    public void x(Class<? extends Annotation> cls, boolean z11, List<Throwable> list) {
        for (x20.c p11 : p().i(cls)) {
            p11.p(z11, list);
        }
    }

    public Statement y(Statement statement) {
        List<x20.c> i11 = this.f26294b.i(o20.b.class);
        return i11.isEmpty() ? statement : new t20.e(statement, i11, (Object) null);
    }

    public Statement z(Statement statement) {
        List<x20.c> i11 = this.f26294b.i(o20.e.class);
        return i11.isEmpty() ? statement : new t20.f(statement, i11, (Object) null);
    }
}
