package androidx.test.internal.runner.listener;

import android.util.Log;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunListener;

public class LogRunListener extends RunListener {
    public void a(Failure failure) {
        String valueOf = String.valueOf(failure.getDescription().getDisplayName());
        Log.e("TestRunner", valueOf.length() != 0 ? "assumption failed: ".concat(valueOf) : new String("assumption failed: "));
        Log.e("TestRunner", "----- begin exception -----");
        Log.e("TestRunner", failure.getTrace());
        Log.e("TestRunner", "----- end exception -----");
    }

    public void b(Failure failure) throws Exception {
        String valueOf = String.valueOf(failure.getDescription().getDisplayName());
        Log.e("TestRunner", valueOf.length() != 0 ? "failed: ".concat(valueOf) : new String("failed: "));
        Log.e("TestRunner", "----- begin exception -----");
        Log.e("TestRunner", failure.getTrace());
        Log.e("TestRunner", "----- end exception -----");
    }

    public void c(Description description) throws Exception {
        String valueOf = String.valueOf(description.getDisplayName());
        Log.i("TestRunner", valueOf.length() != 0 ? "finished: ".concat(valueOf) : new String("finished: "));
    }

    public void d(Description description) throws Exception {
        String valueOf = String.valueOf(description.getDisplayName());
        Log.i("TestRunner", valueOf.length() != 0 ? "ignored: ".concat(valueOf) : new String("ignored: "));
    }

    public void e(Result result) throws Exception {
        Log.i("TestRunner", String.format("run finished: %d tests, %d failed, %d ignored", new Object[]{Integer.valueOf(result.getRunCount()), Integer.valueOf(result.getFailureCount()), Integer.valueOf(result.getIgnoreCount())}));
    }

    public void f(Description description) throws Exception {
        Log.i("TestRunner", String.format("run started: %d tests", new Object[]{Integer.valueOf(description.testCount())}));
    }

    public void g(Description description) throws Exception {
        String valueOf = String.valueOf(description.getDisplayName());
        Log.i("TestRunner", valueOf.length() != 0 ? "started: ".concat(valueOf) : new String("started: "));
    }
}
