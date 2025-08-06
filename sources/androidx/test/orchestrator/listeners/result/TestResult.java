package androidx.test.orchestrator.listeners.result;

import java.util.Arrays;
import java.util.Map;

public class TestResult {

    /* renamed from: a  reason: collision with root package name */
    public TestStatus f11625a;

    /* renamed from: b  reason: collision with root package name */
    public String f11626b;

    /* renamed from: c  reason: collision with root package name */
    public Map<String, String> f11627c;

    /* renamed from: d  reason: collision with root package name */
    public long f11628d;

    /* renamed from: e  reason: collision with root package name */
    public long f11629e;

    public enum TestStatus {
        FAILURE,
        PASSED,
        INCOMPLETE,
        ASSUMPTION_FAILURE,
        IGNORED
    }

    public TestResult() {
        this.f11628d = 0;
        this.f11629e = 0;
        this.f11625a = TestStatus.INCOMPLETE;
        this.f11628d = System.currentTimeMillis();
    }

    public static boolean a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        TestResult testResult = (TestResult) obj;
        if (!a(this.f11627c, testResult.f11627c) || !a(this.f11626b, testResult.f11626b) || !a(this.f11625a, testResult.f11625a)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{this.f11627c, this.f11626b, this.f11625a});
    }
}
