package androidx.test.internal.runner.junit3;

import android.util.Log;
import androidx.test.internal.util.AndroidRunnerParams;
import junit.framework.Test;
import junit.framework.TestSuite;
import org.junit.internal.builders.SuiteMethodBuilder;
import org.junit.internal.runners.c;
import org.junit.runner.Runner;

public class AndroidSuiteBuilder extends SuiteMethodBuilder {

    /* renamed from: b  reason: collision with root package name */
    public final AndroidRunnerParams f11525b;

    public AndroidSuiteBuilder(AndroidRunnerParams androidRunnerParams) {
        this.f11525b = androidRunnerParams;
    }

    public Runner a(Class<?> cls) throws Throwable {
        if (this.f11525b.d()) {
            return null;
        }
        try {
            if (!c(cls)) {
                return null;
            }
            Test i11 = c.i(cls);
            if (i11 instanceof TestSuite) {
                return new JUnit38ClassRunner(new AndroidTestSuite((TestSuite) i11, this.f11525b));
            }
            throw new IllegalArgumentException(cls.getName().concat("#suite() did not return a TestSuite"));
        } catch (Throwable th2) {
            Log.e("AndroidSuiteBuilder", "Error constructing runner", th2);
            throw th2;
        }
    }
}
