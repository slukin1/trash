package y00;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.io.PrintStream;
import junit.framework.AssertionFailedError;
import junit.framework.Test;
import x00.f;

public class a implements f {

    /* renamed from: a  reason: collision with root package name */
    public PrintStream f60216a;

    /* renamed from: b  reason: collision with root package name */
    public int f60217b = 0;

    public a(PrintStream printStream) {
        this.f60216a = printStream;
    }

    public void a(Test test, Throwable th2) {
        e().print("E");
    }

    public void b(Test test, AssertionFailedError assertionFailedError) {
        e().print("F");
    }

    public void c(Test test) {
    }

    public void d(Test test) {
        e().print(InstructionFileId.DOT);
        int i11 = this.f60217b;
        this.f60217b = i11 + 1;
        if (i11 >= 40) {
            e().println();
            this.f60217b = 0;
        }
    }

    public PrintStream e() {
        return this.f60216a;
    }
}
