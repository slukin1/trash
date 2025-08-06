package junit.framework;

import java.util.ArrayList;
import java.util.List;
import x00.d;
import x00.e;
import x00.f;

public class TestResult {

    /* renamed from: a  reason: collision with root package name */
    public List<e> f56526a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public List<e> f56527b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<f> f56528c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    public int f56529d = 0;

    /* renamed from: e  reason: collision with root package name */
    public boolean f56530e = false;

    public class a implements d {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TestCase f56531a;

        public a(TestCase testCase) throws Throwable {
            this.f56531a = testCase;
        }

        public void a() throws Throwable {
            this.f56531a.runBare();
        }
    }

    public synchronized void a(Test test, Throwable th2) {
        this.f56527b.add(new e(test, th2));
        for (f a11 : d()) {
            a11.a(test, th2);
        }
    }

    public synchronized void b(Test test, AssertionFailedError assertionFailedError) {
        this.f56526a.add(new e(test, assertionFailedError));
        for (f b11 : d()) {
            b11.b(test, assertionFailedError);
        }
    }

    public synchronized void c(f fVar) {
        this.f56528c.add(fVar);
    }

    public final synchronized List<f> d() {
        ArrayList arrayList;
        arrayList = new ArrayList();
        arrayList.addAll(this.f56528c);
        return arrayList;
    }

    public void e(Test test) {
        for (f c11 : d()) {
            c11.c(test);
        }
    }

    public void f(TestCase testCase) {
        i(testCase);
        g(testCase, new a(testCase));
        e(testCase);
    }

    public void g(Test test, d dVar) {
        try {
            dVar.a();
        } catch (AssertionFailedError e11) {
            b(test, e11);
        } catch (ThreadDeath e12) {
            throw e12;
        } catch (Throwable th2) {
            a(test, th2);
        }
    }

    public synchronized boolean h() {
        return this.f56530e;
    }

    public void i(Test test) {
        int countTestCases = test.countTestCases();
        synchronized (this) {
            this.f56529d += countTestCases;
        }
        for (f d11 : d()) {
            d11.d(test);
        }
    }
}
