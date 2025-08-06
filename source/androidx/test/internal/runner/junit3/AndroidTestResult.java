package androidx.test.internal.runner.junit3;

import android.app.Instrumentation;
import android.os.Bundle;
import android.test.AndroidTestCase;
import android.test.InstrumentationTestCase;
import java.util.concurrent.TimeoutException;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestResult;
import x00.d;

class AndroidTestResult extends DelegatingTestResult {

    /* renamed from: g  reason: collision with root package name */
    public final Instrumentation f11526g;

    /* renamed from: h  reason: collision with root package name */
    public final Bundle f11527h;

    /* renamed from: i  reason: collision with root package name */
    public long f11528i;

    public AndroidTestResult(Bundle bundle, Instrumentation instrumentation, TestResult testResult) {
        super(testResult);
        this.f11527h = bundle;
        this.f11526g = instrumentation;
    }

    public void f(TestCase testCase) {
        if (testCase instanceof AndroidTestCase) {
            ((AndroidTestCase) testCase).setContext(this.f11526g.getTargetContext());
        }
        if (testCase instanceof InstrumentationTestCase) {
            ((InstrumentationTestCase) testCase).injectInstrumentation(this.f11526g);
        }
        super.f(testCase);
    }

    public void g(Test test, d dVar) {
        try {
            dVar.a();
        } catch (AssertionFailedError e11) {
            super.b(test, e11);
        } catch (ThreadDeath e12) {
            throw e12;
        } catch (InterruptedException unused) {
            super.a(test, new TimeoutException(String.format("Test timed out after %d milliseconds", new Object[]{Long.valueOf(this.f11528i)})));
        } catch (Throwable th2) {
            super.a(test, th2);
        }
    }

    public void j(long j11) {
        this.f11528i = j11;
    }
}
