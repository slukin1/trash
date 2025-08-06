package junit.textui;

import java.io.PrintStream;
import junit.framework.Test;
import junit.runner.BaseTestRunner;
import y00.a;

public class TestRunner extends BaseTestRunner {

    /* renamed from: d  reason: collision with root package name */
    public a f56539d;

    public TestRunner() {
        this(System.out);
    }

    public void k(String str) {
    }

    public void l(int i11, Test test, Throwable th2) {
    }

    public void m(String str) {
    }

    public TestRunner(PrintStream printStream) {
        this(new a(printStream));
    }

    public TestRunner(a aVar) {
        this.f56539d = aVar;
    }
}
