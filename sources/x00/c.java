package x00;

import junit.framework.Test;
import junit.framework.TestResult;
import org.junit.runner.Description;
import org.junit.runner.a;

public class c implements Test, a {

    /* renamed from: a  reason: collision with root package name */
    public final Description f60211a;

    public c(Description description) {
        this.f60211a = description;
    }

    public int countTestCases() {
        return 1;
    }

    public Description getDescription() {
        return this.f60211a;
    }

    public void run(TestResult testResult) {
        throw new RuntimeException("This test stub created only for informational purposes.");
    }

    public String toString() {
        return getDescription().toString();
    }
}
