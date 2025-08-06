package androidx.test.internal.runner.listener;

import android.util.Log;
import androidx.test.internal.runner.TestSize;
import com.amazonaws.services.s3.model.InstructionFileId;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;

public class SuiteAssignmentPrinter extends InstrumentationRunListener {

    /* renamed from: b  reason: collision with root package name */
    public long f11579b;

    /* renamed from: c  reason: collision with root package name */
    public long f11580c;

    /* renamed from: d  reason: collision with root package name */
    public boolean f11581d;

    public void a(Failure failure) {
        this.f11581d = false;
    }

    public void b(Failure failure) throws Exception {
        this.f11581d = false;
    }

    public void c(Description description) throws Exception {
        long m11 = m();
        this.f11580c = m11;
        if (this.f11581d) {
            long j11 = this.f11579b;
            if (j11 >= 0) {
                long j12 = m11 - j11;
                TestSize g11 = TestSize.g((float) j12);
                TestSize a11 = TestSize.a(description);
                if (!g11.equals(a11)) {
                    k(String.format("\n%s#%s: current size: %s. suggested: %s runTime: %d ms\n", new Object[]{description.getClassName(), description.getMethodName(), a11, g11.f(), Long.valueOf(j12)}));
                } else {
                    k(InstructionFileId.DOT);
                    Log.d("SuiteAssignmentPrinter", String.format("%s#%s assigned correctly as %s. runTime: %d ms\n", new Object[]{description.getClassName(), description.getMethodName(), g11.f(), Long.valueOf(j12)}));
                }
                this.f11579b = -1;
            }
        }
        k("F");
        Log.d("SuiteAssignmentPrinter", String.format("%s#%s: skipping suite assignment due to test failure\n", new Object[]{description.getClassName(), description.getMethodName()}));
        this.f11579b = -1;
    }

    public void d(Description description) throws Exception {
        this.f11581d = false;
    }

    public void g(Description description) throws Exception {
        this.f11581d = true;
        this.f11579b = m();
    }

    public long m() {
        return System.currentTimeMillis();
    }
}
