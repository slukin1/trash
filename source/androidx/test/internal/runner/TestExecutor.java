package androidx.test.internal.runner;

import android.app.Instrumentation;
import android.os.Bundle;
import android.util.Log;
import androidx.test.internal.runner.listener.InstrumentationRunListener;
import androidx.test.internal.util.Checks;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import org.junit.runner.JUnitCore;
import org.junit.runner.Request;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

public final class TestExecutor {

    /* renamed from: a  reason: collision with root package name */
    public final List<RunListener> f11472a;

    /* renamed from: b  reason: collision with root package name */
    public final Instrumentation f11473b;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public final List<RunListener> f11474a = new ArrayList();

        /* renamed from: b  reason: collision with root package name */
        public final Instrumentation f11475b;

        public Builder(Instrumentation instrumentation) {
            this.f11475b = instrumentation;
        }

        public Builder c(RunListener runListener) {
            this.f11474a.add(runListener);
            return this;
        }

        public TestExecutor d() {
            return new TestExecutor(this);
        }
    }

    public Bundle a(Request request) {
        String format;
        Bundle bundle = new Bundle();
        Result result = new Result();
        try {
            JUnitCore jUnitCore = new JUnitCore();
            c(jUnitCore);
            Result c11 = jUnitCore.c(request);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            PrintStream printStream = new PrintStream(byteArrayOutputStream);
            b(this.f11472a, printStream, bundle, c11);
            printStream.close();
            format = String.format("\n%s", new Object[]{byteArrayOutputStream.toString()});
        } catch (Throwable th2) {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            PrintStream printStream2 = new PrintStream(byteArrayOutputStream2);
            b(this.f11472a, printStream2, bundle, result);
            printStream2.close();
            bundle.putString("stream", String.format("\n%s", new Object[]{byteArrayOutputStream2.toString()}));
            throw th2;
        }
        bundle.putString("stream", format);
        return bundle;
    }

    public final void b(List<RunListener> list, PrintStream printStream, Bundle bundle, Result result) {
        for (RunListener next : list) {
            if (next instanceof InstrumentationRunListener) {
                ((InstrumentationRunListener) next).i(printStream, bundle, result);
            }
        }
    }

    public final void c(JUnitCore jUnitCore) {
        for (RunListener next : this.f11472a) {
            String name = next.getClass().getName();
            Log.d("TestExecutor", name.length() != 0 ? "Adding listener ".concat(name) : new String("Adding listener "));
            jUnitCore.a(next);
            if (next instanceof InstrumentationRunListener) {
                ((InstrumentationRunListener) next).l(this.f11473b);
            }
        }
    }

    public TestExecutor(Builder builder) {
        this.f11472a = (List) Checks.b(builder.f11474a);
        this.f11473b = builder.f11475b;
    }
}
