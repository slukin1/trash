package q20;

import e7.s;
import java.io.PrintStream;
import java.text.NumberFormat;
import java.util.List;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class b extends RunListener {

    /* renamed from: a  reason: collision with root package name */
    public final PrintStream f25600a;

    public b(PrintStream printStream) {
        this.f25600a = printStream;
    }

    public void b(Failure failure) {
        this.f25600a.append('E');
    }

    public void d(Description description) {
        this.f25600a.append('I');
    }

    public void e(Result result) {
        m(result.getRunTime());
        k(result);
        l(result);
    }

    public void g(Description description) {
        this.f25600a.append('.');
    }

    public String h(long j11) {
        return NumberFormat.getInstance().format(((double) j11) / 1000.0d);
    }

    public final PrintStream i() {
        return this.f25600a;
    }

    public void j(Failure failure, String str) {
        PrintStream i11 = i();
        i11.println(str + ") " + failure.getTestHeader());
        i().print(failure.getTrace());
    }

    public void k(Result result) {
        List<Failure> failures = result.getFailures();
        if (failures.size() != 0) {
            int i11 = 1;
            if (failures.size() == 1) {
                PrintStream i12 = i();
                i12.println("There was " + failures.size() + " failure:");
            } else {
                PrintStream i13 = i();
                i13.println("There were " + failures.size() + " failures:");
            }
            for (Failure j11 : failures) {
                j(j11, "" + i11);
                i11++;
            }
        }
    }

    public void l(Result result) {
        if (result.wasSuccessful()) {
            i().println();
            i().print("OK");
            PrintStream i11 = i();
            StringBuilder sb2 = new StringBuilder();
            sb2.append(" (");
            sb2.append(result.getRunCount());
            sb2.append(" test");
            sb2.append(result.getRunCount() == 1 ? "" : s.f70071a);
            sb2.append(")");
            i11.println(sb2.toString());
        } else {
            i().println();
            i().println("FAILURES!!!");
            PrintStream i12 = i();
            i12.println("Tests run: " + result.getRunCount() + ",  Failures: " + result.getFailureCount());
        }
        i().println();
    }

    public void m(long j11) {
        i().println();
        PrintStream i11 = i();
        i11.println("Time: " + h(j11));
    }
}
