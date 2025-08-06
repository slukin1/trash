package androidx.test.internal.runner.junit3;

import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import o20.h;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;

@h
public class NonExecutingTestSuite extends DelegatingFilterableTestSuite {
    public NonExecutingTestSuite(Class<?> cls) {
        this(new TestSuite(cls));
    }

    public /* bridge */ /* synthetic */ void a(Filter filter) throws NoTestsRemainException {
        super.a(filter);
    }

    public /* bridge */ /* synthetic */ void b(Test test) {
        super.b(test);
    }

    public /* bridge */ /* synthetic */ int countTestCases() {
        return super.countTestCases();
    }

    public /* bridge */ /* synthetic */ String g() {
        return super.g();
    }

    public /* bridge */ /* synthetic */ void k(Test test, TestResult testResult) {
        super.k(test, testResult);
    }

    public /* bridge */ /* synthetic */ void l(String str) {
        super.l(str);
    }

    public /* bridge */ /* synthetic */ Test m(int i11) {
        return super.m(i11);
    }

    public /* bridge */ /* synthetic */ int n() {
        return super.n();
    }

    public /* bridge */ /* synthetic */ TestSuite p() {
        return super.p();
    }

    public /* bridge */ /* synthetic */ void q(TestSuite testSuite) {
        super.q(testSuite);
    }

    public void run(TestResult testResult) {
        super.run(new NonExecutingTestResult(testResult));
    }

    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    public NonExecutingTestSuite(TestSuite testSuite) {
        super(testSuite);
    }
}
