package androidx.test.internal.runner.junit3;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;
import x00.d;

class NonExecutingTestResult extends DelegatingTestResult {
    public NonExecutingTestResult(TestResult testResult) {
        super(testResult);
    }

    public void f(TestCase testCase) {
        i(testCase);
        e(testCase);
    }

    public void g(Test test, d dVar) {
    }
}
