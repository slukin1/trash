package org.junit.rules;

import org.junit.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public abstract class Stopwatch implements u20.c {

    /* renamed from: a  reason: collision with root package name */
    public final b f25445a;

    /* renamed from: b  reason: collision with root package name */
    public volatile long f25446b;

    /* renamed from: c  reason: collision with root package name */
    public volatile long f25447c;

    public static class b {
        public long a() {
            return System.nanoTime();
        }
    }

    public class c extends TestWatcher {
        public c() {
        }

        public void g(Throwable th2, Description description) {
            Stopwatch.this.j();
            Stopwatch stopwatch = Stopwatch.this;
            stopwatch.e(stopwatch.g(), th2, description);
        }

        public void i(Description description) {
            Stopwatch stopwatch = Stopwatch.this;
            stopwatch.f(stopwatch.g(), description);
        }

        public void k(AssumptionViolatedException assumptionViolatedException, Description description) {
            Stopwatch.this.j();
            Stopwatch stopwatch = Stopwatch.this;
            stopwatch.h(stopwatch.g(), assumptionViolatedException, description);
        }

        public void n(Description description) {
            Stopwatch.this.i();
        }

        public void p(Description description) {
            Stopwatch.this.j();
            Stopwatch stopwatch = Stopwatch.this;
            stopwatch.k(stopwatch.g(), description);
        }
    }

    public Stopwatch() {
        this(new b());
    }

    public final Statement a(Statement statement, Description description) {
        return new c().a(statement, description);
    }

    public void e(long j11, Throwable th2, Description description) {
    }

    public void f(long j11, Description description) {
    }

    public final long g() {
        if (this.f25446b != 0) {
            long j11 = this.f25447c;
            if (j11 == 0) {
                j11 = this.f25445a.a();
            }
            return j11 - this.f25446b;
        }
        throw new IllegalStateException("Test has not started");
    }

    public void h(long j11, AssumptionViolatedException assumptionViolatedException, Description description) {
    }

    public final void i() {
        this.f25446b = this.f25445a.a();
        this.f25447c = 0;
    }

    public final void j() {
        this.f25447c = this.f25445a.a();
    }

    public void k(long j11, Description description) {
    }

    public Stopwatch(b bVar) {
        this.f25445a = bVar;
    }
}
