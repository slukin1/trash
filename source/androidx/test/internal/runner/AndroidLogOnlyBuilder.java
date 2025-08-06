package androidx.test.internal.runner;

import androidx.test.internal.runner.junit3.JUnit38ClassRunner;
import androidx.test.internal.runner.junit3.NonExecutingTestSuite;
import androidx.test.internal.util.AndroidRunnerBuilderUtil;
import androidx.test.internal.util.AndroidRunnerParams;
import androidx.test.internal.util.Checks;
import java.util.List;
import junit.framework.Test;
import junit.framework.TestSuite;
import org.junit.internal.runners.a;
import org.junit.internal.runners.c;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

class AndroidLogOnlyBuilder extends RunnerBuilder {

    /* renamed from: b  reason: collision with root package name */
    public final AndroidRunnerBuilder f11383b;

    /* renamed from: c  reason: collision with root package name */
    public final AndroidRunnerParams f11384c;

    /* renamed from: d  reason: collision with root package name */
    public final boolean f11385d;

    /* renamed from: e  reason: collision with root package name */
    public int f11386e = 0;

    public AndroidLogOnlyBuilder(AndroidRunnerParams androidRunnerParams, boolean z11, List<Class<? extends RunnerBuilder>> list) {
        this.f11384c = (AndroidRunnerParams) Checks.c(androidRunnerParams, "runnerParams cannot be null!");
        this.f11385d = z11;
        this.f11383b = new AndroidRunnerBuilder(this, androidRunnerParams, z11, list);
    }

    public Runner a(Class<?> cls) throws Throwable {
        this.f11386e++;
        if (AndroidRunnerBuilderUtil.c(cls)) {
            if (!this.f11385d || AndroidRunnerBuilderUtil.a(cls)) {
                return new JUnit38ClassRunner(new NonExecutingTestSuite(cls));
            }
            return null;
        } else if (!AndroidRunnerBuilderUtil.b(cls)) {
            int i11 = this.f11386e;
            Runner a11 = this.f11383b.a(cls);
            if (a11 == null) {
                return null;
            }
            if (!(a11 instanceof a) && this.f11386e <= i11) {
                return new NonExecutingRunner(a11);
            }
            return a11;
        } else if (this.f11384c.d()) {
            return null;
        } else {
            Test i12 = c.i(cls);
            if (i12 instanceof TestSuite) {
                return new JUnit38ClassRunner(new NonExecutingTestSuite((TestSuite) i12));
            }
            throw new IllegalArgumentException(cls.getName().concat("#suite() did not return a TestSuite"));
        }
    }
}
