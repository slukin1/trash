package androidx.test.internal.runner.junit4;

import androidx.test.internal.util.AndroidRunnerParams;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;
import r20.b;

public class AndroidAnnotatedBuilder extends b {

    /* renamed from: c  reason: collision with root package name */
    public final AndroidRunnerParams f11541c;

    public AndroidAnnotatedBuilder(RunnerBuilder runnerBuilder, AndroidRunnerParams androidRunnerParams) {
        super(runnerBuilder);
        this.f11541c = androidRunnerParams;
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:11|12|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0025, code lost:
        return super.c(r0, r4);
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0021 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public org.junit.runner.Runner a(java.lang.Class<?> r4) throws java.lang.Exception {
        /*
            r3 = this;
            java.lang.Class<org.junit.runner.b> r0 = org.junit.runner.b.class
            java.lang.annotation.Annotation r0 = r4.getAnnotation(r0)     // Catch:{ all -> 0x002b }
            org.junit.runner.b r0 = (org.junit.runner.b) r0     // Catch:{ all -> 0x002b }
            if (r0 == 0) goto L_0x0026
            java.lang.Class<androidx.test.runner.AndroidJUnit4> r1 = androidx.test.runner.AndroidJUnit4.class
            java.lang.Class r2 = r0.value()     // Catch:{ all -> 0x002b }
            boolean r1 = r1.equals(r2)     // Catch:{ all -> 0x002b }
            if (r1 == 0) goto L_0x0026
            java.lang.Class r0 = r0.value()     // Catch:{ all -> 0x002b }
            org.junit.runner.Runner r0 = r3.e(r0, r4)     // Catch:{ NoSuchMethodException -> 0x0021 }
            if (r0 == 0) goto L_0x0026
            return r0
        L_0x0021:
            org.junit.runner.Runner r4 = super.c(r0, r4)     // Catch:{ all -> 0x002b }
            return r4
        L_0x0026:
            org.junit.runner.Runner r4 = super.a(r4)
            return r4
        L_0x002b:
            r4 = move-exception
            java.lang.String r0 = "AndroidAnnotatedBuilder"
            java.lang.String r1 = "Error constructing runner"
            android.util.Log.e(r0, r1, r4)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.test.internal.runner.junit4.AndroidAnnotatedBuilder.a(java.lang.Class):org.junit.runner.Runner");
    }

    public Runner e(Class<? extends Runner> cls, Class<?> cls2) throws Exception {
        return (Runner) cls.getConstructor(new Class[]{Class.class, AndroidRunnerParams.class}).newInstance(new Object[]{cls2, this.f11541c});
    }
}
