package androidx.test.internal.runner.junit3;

import junit.framework.Test;
import junit.framework.TestResult;
import junit.framework.TestSuite;
import o20.h;
import org.junit.runner.Description;
import org.junit.runner.a;

@h
public class NonLeakyTestSuite extends TestSuite {

    public static class NonLeakyTest implements Test, a {

        /* renamed from: a  reason: collision with root package name */
        public Test f11539a;

        /* renamed from: b  reason: collision with root package name */
        public final Description f11540b;

        public NonLeakyTest(Test test) {
            this.f11539a = test;
            this.f11540b = JUnit38ClassRunner.g(test);
        }

        public int countTestCases() {
            Test test = this.f11539a;
            if (test != null) {
                return test.countTestCases();
            }
            return 0;
        }

        public Description getDescription() {
            return this.f11540b;
        }

        public void run(TestResult testResult) {
            this.f11539a.run(testResult);
            this.f11539a = null;
        }

        public String toString() {
            Test test = this.f11539a;
            if (test != null) {
                return test.toString();
            }
            return this.f11540b.toString();
        }
    }

    public NonLeakyTestSuite(Class<?> cls) {
        super(cls);
    }

    public void b(Test test) {
        super.b(new NonLeakyTest(test));
    }
}
