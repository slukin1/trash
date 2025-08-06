package androidx.test.internal.runner.junit3;

import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestResult;
import x00.f;

class DelegatingTestResult extends TestResult {

    /* renamed from: f  reason: collision with root package name */
    public TestResult f11533f;

    public DelegatingTestResult(TestResult testResult) {
        this.f11533f = testResult;
    }

    public void a(Test test, Throwable th2) {
        this.f11533f.a(test, th2);
    }

    public void b(Test test, AssertionFailedError assertionFailedError) {
        this.f11533f.b(test, assertionFailedError);
    }

    public void c(f fVar) {
        this.f11533f.c(fVar);
    }

    public void e(Test test) {
        this.f11533f.e(test);
    }

    public boolean h() {
        return this.f11533f.h();
    }

    public void i(Test test) {
        this.f11533f.i(test);
    }
}
