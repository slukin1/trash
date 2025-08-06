package androidx.test.internal.runner;

import androidx.test.filters.LargeTest;
import androidx.test.filters.MediumTest;
import androidx.test.filters.SmallTest;
import com.adjust.sdk.Constants;
import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import org.junit.runner.Description;

public final class TestSize {

    /* renamed from: e  reason: collision with root package name */
    public static final TestSize f11512e;

    /* renamed from: f  reason: collision with root package name */
    public static final TestSize f11513f;

    /* renamed from: g  reason: collision with root package name */
    public static final TestSize f11514g;

    /* renamed from: h  reason: collision with root package name */
    public static final TestSize f11515h = new TestSize("", (Class<? extends Annotation>) null, (Class<? extends Annotation>) null, 0.0f);

    /* renamed from: i  reason: collision with root package name */
    public static final Set<TestSize> f11516i;

    /* renamed from: a  reason: collision with root package name */
    public final String f11517a;

    /* renamed from: b  reason: collision with root package name */
    public final Class<? extends Annotation> f11518b;

    /* renamed from: c  reason: collision with root package name */
    public final Class<? extends Annotation> f11519c;

    /* renamed from: d  reason: collision with root package name */
    public final float f11520d;

    static {
        TestSize testSize = new TestSize(Constants.SMALL, SmallTest.class, android.test.suitebuilder.annotation.SmallTest.class, 200.0f);
        f11512e = testSize;
        TestSize testSize2 = new TestSize("medium", MediumTest.class, android.test.suitebuilder.annotation.MediumTest.class, 1000.0f);
        f11513f = testSize2;
        TestSize testSize3 = new TestSize(Constants.LARGE, LargeTest.class, android.test.suitebuilder.annotation.LargeTest.class, Float.MAX_VALUE);
        f11514g = testSize3;
        f11516i = Collections.unmodifiableSet(new HashSet(Arrays.asList(new TestSize[]{testSize, testSize2, testSize3})));
    }

    public TestSize(String str, Class<? extends Annotation> cls, Class<? extends Annotation> cls2, float f11) {
        this.f11517a = str;
        this.f11518b = cls;
        this.f11519c = cls2;
        this.f11520d = f11;
    }

    public static TestSize a(Description description) {
        TestSize testSize = f11515h;
        Iterator<TestSize> it2 = f11516i.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            TestSize next = it2.next();
            if (next.k(description)) {
                testSize = next;
                break;
            }
        }
        if (!f11515h.equals(testSize)) {
            return testSize;
        }
        for (TestSize next2 : f11516i) {
            if (next2.j(description)) {
                return next2;
            }
        }
        return testSize;
    }

    public static TestSize b(String str) {
        TestSize testSize = f11515h;
        for (TestSize next : f11516i) {
            if (next.f().equals(str)) {
                testSize = next;
            }
        }
        return testSize;
    }

    public static TestSize g(float f11) {
        TestSize testSize = f11512e;
        if (i(f11, testSize.d())) {
            return testSize;
        }
        TestSize testSize2 = f11513f;
        if (i(f11, testSize2.d())) {
            return testSize2;
        }
        return f11514g;
    }

    /* JADX WARNING: Removed duplicated region for block: B:3:0x000c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean h(java.lang.Class<? extends java.lang.annotation.Annotation> r3) {
        /*
            java.util.Set<androidx.test.internal.runner.TestSize> r0 = f11516i
            java.util.Iterator r0 = r0.iterator()
        L_0x0006:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0020
            java.lang.Object r1 = r0.next()
            androidx.test.internal.runner.TestSize r1 = (androidx.test.internal.runner.TestSize) r1
            java.lang.Class r2 = r1.e()
            if (r2 == r3) goto L_0x001e
            java.lang.Class r1 = r1.c()
            if (r1 != r3) goto L_0x0006
        L_0x001e:
            r3 = 1
            return r3
        L_0x0020:
            r3 = 0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.test.internal.runner.TestSize.h(java.lang.Class):boolean");
    }

    public static boolean i(float f11, float f12) {
        return Float.compare(f11, f12) < 0;
    }

    public final Class<? extends Annotation> c() {
        return this.f11518b;
    }

    public float d() {
        return this.f11520d;
    }

    public final Class<? extends Annotation> e() {
        return this.f11519c;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || TestSize.class != obj.getClass()) {
            return false;
        }
        return this.f11517a.equals(((TestSize) obj).f11517a);
    }

    public String f() {
        return this.f11517a;
    }

    public int hashCode() {
        return this.f11517a.hashCode();
    }

    public boolean j(Description description) {
        Class<?> testClass = description.getTestClass();
        if (testClass == null) {
            return false;
        }
        if (testClass.isAnnotationPresent(this.f11519c) || testClass.isAnnotationPresent(this.f11518b)) {
            return true;
        }
        return false;
    }

    public boolean k(Description description) {
        return (description.getAnnotation(this.f11519c) == null && description.getAnnotation(this.f11518b) == null) ? false : true;
    }
}
