package androidx.test.internal.runner.listener;

import android.app.Instrumentation;
import android.os.Bundle;
import java.io.PrintStream;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

public abstract class InstrumentationRunListener extends RunListener {

    /* renamed from: a  reason: collision with root package name */
    public Instrumentation f11578a;

    public Instrumentation h() {
        return this.f11578a;
    }

    public void i(PrintStream printStream, Bundle bundle, Result result) {
    }

    public void j(int i11, Bundle bundle) {
        h().sendStatus(i11, bundle);
    }

    public void k(String str) {
        Bundle bundle = new Bundle();
        bundle.putString("stream", str);
        j(0, bundle);
    }

    public void l(Instrumentation instrumentation) {
        this.f11578a = instrumentation;
    }
}
