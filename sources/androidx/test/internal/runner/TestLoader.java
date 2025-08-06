package androidx.test.internal.runner;

import android.util.Log;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.junit.runner.Description;
import org.junit.runner.Runner;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.RunnerBuilder;

class TestLoader {

    /* renamed from: a  reason: collision with root package name */
    public final ClassLoader f11476a;

    /* renamed from: b  reason: collision with root package name */
    public final RunnerBuilder f11477b;

    /* renamed from: c  reason: collision with root package name */
    public final Map<String, Runner> f11478c = new LinkedHashMap();

    public static class ScanningRunnerBuilder extends RunnerBuilder {

        /* renamed from: b  reason: collision with root package name */
        public final RunnerBuilder f11479b;

        public ScanningRunnerBuilder(RunnerBuilder runnerBuilder) {
            this.f11479b = runnerBuilder;
        }

        public Runner a(Class<?> cls) throws Throwable {
            if (!Modifier.isAbstract(cls.getModifiers())) {
                return this.f11479b.a(cls);
            }
            TestLoader.d(String.format("Skipping abstract class %s: not a test", new Object[]{cls.getName()}));
            return null;
        }
    }

    public static class UnloadableClassRunner extends Runner {

        /* renamed from: a  reason: collision with root package name */
        public final Description f11480a;

        /* renamed from: b  reason: collision with root package name */
        public final Failure f11481b;

        public UnloadableClassRunner(Description description, Failure failure) {
            this.f11480a = description;
            this.f11481b = failure;
        }

        public void b(RunNotifier runNotifier) {
            runNotifier.l(this.f11480a);
            runNotifier.f(this.f11481b);
            runNotifier.h(this.f11480a);
        }

        public Description getDescription() {
            return this.f11480a;
        }
    }

    public TestLoader(ClassLoader classLoader, RunnerBuilder runnerBuilder) {
        this.f11476a = classLoader;
        this.f11477b = runnerBuilder;
    }

    public static void d(String str) {
        if (Log.isLoggable("TestLoader", 3)) {
            Log.d("TestLoader", str);
        }
    }

    public static TestLoader e(ClassLoader classLoader, RunnerBuilder runnerBuilder, boolean z11) {
        if (z11) {
            runnerBuilder = new ScanningRunnerBuilder(runnerBuilder);
        }
        if (classLoader == null) {
            classLoader = TestLoader.class.getClassLoader();
        }
        return new TestLoader(classLoader, runnerBuilder);
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(java.lang.String r8, boolean r9) {
        /*
            r7 = this;
            java.util.Map<java.lang.String, org.junit.runner.Runner> r0 = r7.f11478c
            boolean r0 = r0.containsKey(r8)
            if (r0 == 0) goto L_0x0009
            return
        L_0x0009:
            r0 = 0
            r1 = 1
            r2 = 0
            java.lang.ClassLoader r3 = r7.f11476a     // Catch:{ ClassNotFoundException -> 0x0044 }
            java.lang.Class r3 = java.lang.Class.forName(r8, r2, r3)     // Catch:{ ClassNotFoundException -> 0x0044 }
            org.junit.runners.model.RunnerBuilder r4 = r7.f11477b     // Catch:{ ClassNotFoundException -> 0x0044 }
            org.junit.runner.Runner r4 = r4.b(r3)     // Catch:{ ClassNotFoundException -> 0x0044 }
            if (r4 != 0) goto L_0x002c
            java.lang.String r5 = "Skipping class %s: not a test"
            java.lang.Object[] r6 = new java.lang.Object[r1]     // Catch:{ ClassNotFoundException -> 0x0044 }
            java.lang.String r3 = r3.getName()     // Catch:{ ClassNotFoundException -> 0x0044 }
            r6[r2] = r3     // Catch:{ ClassNotFoundException -> 0x0044 }
            java.lang.String r3 = java.lang.String.format(r5, r6)     // Catch:{ ClassNotFoundException -> 0x0044 }
            d(r3)     // Catch:{ ClassNotFoundException -> 0x0044 }
            goto L_0x0042
        L_0x002c:
            org.junit.runner.Runner r5 = androidx.test.internal.runner.junit3.AndroidJUnit3Builder.f11522d     // Catch:{ ClassNotFoundException -> 0x0044 }
            if (r4 != r5) goto L_0x0042
            java.lang.String r4 = "Skipping class %s: not a valid test"
            java.lang.Object[] r5 = new java.lang.Object[r1]     // Catch:{ ClassNotFoundException -> 0x0044 }
            java.lang.String r3 = r3.getName()     // Catch:{ ClassNotFoundException -> 0x0044 }
            r5[r2] = r3     // Catch:{ ClassNotFoundException -> 0x0044 }
            java.lang.String r3 = java.lang.String.format(r4, r5)     // Catch:{ ClassNotFoundException -> 0x0044 }
            d(r3)     // Catch:{ ClassNotFoundException -> 0x0044 }
            goto L_0x0066
        L_0x0042:
            r0 = r4
            goto L_0x0066
        L_0x0044:
            r3 = move-exception
            java.lang.Object[] r1 = new java.lang.Object[r1]
            r1[r2] = r8
            java.lang.String r4 = "Could not find class: %s"
            java.lang.String r1 = java.lang.String.format(r4, r1)
            java.lang.String r4 = "TestLoader"
            android.util.Log.e(r4, r1)
            java.lang.annotation.Annotation[] r1 = new java.lang.annotation.Annotation[r2]
            org.junit.runner.Description r1 = org.junit.runner.Description.createSuiteDescription(r8, r1)
            org.junit.runner.notification.Failure r2 = new org.junit.runner.notification.Failure
            r2.<init>(r1, r3)
            if (r9 != 0) goto L_0x0066
            androidx.test.internal.runner.TestLoader$UnloadableClassRunner r0 = new androidx.test.internal.runner.TestLoader$UnloadableClassRunner
            r0.<init>(r1, r2)
        L_0x0066:
            if (r0 == 0) goto L_0x006d
            java.util.Map<java.lang.String, org.junit.runner.Runner> r9 = r7.f11478c
            r9.put(r8, r0)
        L_0x006d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.test.internal.runner.TestLoader.b(java.lang.String, boolean):void");
    }

    public List<Runner> c(Collection<String> collection, boolean z11) {
        for (String b11 : collection) {
            b(b11, z11);
        }
        return new ArrayList(this.f11478c.values());
    }
}
