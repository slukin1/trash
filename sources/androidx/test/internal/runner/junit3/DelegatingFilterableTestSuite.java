package androidx.test.internal.runner.junit3;

import junit.framework.Test;
import junit.framework.TestSuite;
import o20.h;
import org.junit.runner.Description;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;
import v20.a;

@h
class DelegatingFilterableTestSuite extends DelegatingTestSuite implements a {
    public DelegatingFilterableTestSuite(TestSuite testSuite) {
        super(testSuite);
    }

    public static Description r(Test test) {
        return JUnit38ClassRunner.g(test);
    }

    public void a(Filter filter) throws NoTestsRemainException {
        TestSuite p11 = p();
        TestSuite testSuite = new TestSuite(p11.g());
        int n11 = p11.n();
        for (int i11 = 0; i11 < n11; i11++) {
            Test m11 = p11.m(i11);
            if (filter.c(r(m11))) {
                testSuite.b(m11);
            }
        }
        q(testSuite);
        if (testSuite.n() == 0) {
            throw new NoTestsRemainException();
        }
    }
}
