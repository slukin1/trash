package androidx.test.internal.runner.junit3;

import java.lang.annotation.Annotation;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.manipulation.Filter;
import org.junit.runner.manipulation.NoTestsRemainException;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import v20.a;
import x00.f;

public class JUnit38ClassRunner extends Runner implements a {

    /* renamed from: a  reason: collision with root package name */
    public volatile Test f11535a;

    public static final class OldTestClassAdaptingListener implements f {

        /* renamed from: a  reason: collision with root package name */
        public final RunNotifier f11536a;

        /* renamed from: b  reason: collision with root package name */
        public Test f11537b;

        /* renamed from: c  reason: collision with root package name */
        public Description f11538c;

        public void a(Test test, Throwable th2) {
            this.f11536a.f(new Failure(e(test), th2));
        }

        public void b(Test test, AssertionFailedError assertionFailedError) {
            a(test, assertionFailedError);
        }

        public void c(Test test) {
            this.f11536a.h(e(test));
        }

        public void d(Test test) {
            this.f11536a.l(e(test));
        }

        public final Description e(Test test) {
            Description description;
            Test test2 = this.f11537b;
            if (test2 != null && test2.equals(test) && (description = this.f11538c) != null) {
                return description;
            }
            this.f11537b = test;
            if (test instanceof org.junit.runner.a) {
                this.f11538c = ((org.junit.runner.a) test).getDescription();
            } else if (test instanceof TestCase) {
                this.f11538c = JUnit38ClassRunner.g(test);
            } else {
                this.f11538c = Description.createTestDescription(f(test), test.toString());
            }
            return this.f11538c;
        }

        public final Class<? extends Test> f(Test test) {
            return test.getClass();
        }

        public OldTestClassAdaptingListener(RunNotifier runNotifier) {
            this.f11537b = null;
            this.f11538c = null;
            this.f11536a = runNotifier;
        }
    }

    public JUnit38ClassRunner(Test test) {
        h(test);
    }

    public static String d(TestSuite testSuite) {
        String str;
        int countTestCases = testSuite.countTestCases();
        if (countTestCases == 0) {
            str = "";
        } else {
            str = String.format(" [example: %s]", new Object[]{testSuite.m(0)});
        }
        return String.format("TestSuite with %s tests%s", new Object[]{Integer.valueOf(countTestCases), str});
    }

    public static Annotation[] e(TestCase testCase) {
        try {
            return testCase.getClass().getMethod(testCase.getName(), new Class[0]).getDeclaredAnnotations();
        } catch (NoSuchMethodException | SecurityException unused) {
            return new Annotation[0];
        }
    }

    public static Description g(Test test) {
        if (test instanceof TestCase) {
            TestCase testCase = (TestCase) test;
            return Description.createTestDescription(testCase.getClass(), testCase.getName(), e(testCase));
        } else if (test instanceof TestSuite) {
            TestSuite testSuite = (TestSuite) test;
            Description createSuiteDescription = Description.createSuiteDescription(testSuite.g() == null ? d(testSuite) : testSuite.g(), new Annotation[0]);
            int n11 = testSuite.n();
            for (int i11 = 0; i11 < n11; i11++) {
                createSuiteDescription.addChild(g(testSuite.m(i11)));
            }
            return createSuiteDescription;
        } else if (test instanceof org.junit.runner.a) {
            return ((org.junit.runner.a) test).getDescription();
        } else {
            if (test instanceof w00.a) {
                return g(((w00.a) test).b());
            }
            return Description.createSuiteDescription(test.getClass());
        }
    }

    public void a(Filter filter) throws NoTestsRemainException {
        if (f() instanceof a) {
            ((a) f()).a(filter);
        } else if (f() instanceof TestSuite) {
            TestSuite testSuite = (TestSuite) f();
            TestSuite testSuite2 = new TestSuite(testSuite.g());
            int n11 = testSuite.n();
            for (int i11 = 0; i11 < n11; i11++) {
                Test m11 = testSuite.m(i11);
                if (filter.c(g(m11))) {
                    testSuite2.b(m11);
                }
            }
            h(testSuite2);
            if (testSuite2.n() == 0) {
                throw new NoTestsRemainException();
            }
        }
    }

    public void b(RunNotifier runNotifier) {
        TestResult testResult = new TestResult();
        testResult.c(c(runNotifier));
        f().run(testResult);
    }

    public f c(RunNotifier runNotifier) {
        return new OldTestClassAdaptingListener(runNotifier);
    }

    public final Test f() {
        return this.f11535a;
    }

    public Description getDescription() {
        return g(f());
    }

    public final void h(Test test) {
        this.f11535a = test;
    }
}
