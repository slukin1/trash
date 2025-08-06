package androidx.test.internal.runner.junit3;

import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import o20.h;

@h
class DelegatingTestSuite extends TestSuite {

    /* renamed from: c  reason: collision with root package name */
    public TestSuite f11534c;

    public DelegatingTestSuite(TestSuite testSuite) {
        this.f11534c = testSuite;
    }

    public void b(Test test) {
        this.f11534c.b(test);
    }

    public int countTestCases() {
        return this.f11534c.countTestCases();
    }

    public String g() {
        return this.f11534c.g();
    }

    public void k(Test test, TestResult testResult) {
        this.f11534c.k(test, testResult);
    }

    public void l(String str) {
        this.f11534c.l(str);
    }

    public Test m(int i11) {
        return this.f11534c.m(i11);
    }

    public int n() {
        return this.f11534c.n();
    }

    public TestSuite p() {
        return this.f11534c;
    }

    public void q(TestSuite testSuite) {
        this.f11534c = testSuite;
    }

    public void run(TestResult testResult) {
        this.f11534c.run(testResult);
    }

    public String toString() {
        return this.f11534c.toString();
    }
}
