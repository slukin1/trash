package androidx.test.internal.runner.listener;

import android.os.Bundle;
import android.util.Log;
import cn.sharesdk.framework.InnerShareParams;
import com.amazonaws.services.s3.model.InstructionFileId;
import io.flutter.plugins.firebase.crashlytics.Constants;
import java.io.PrintStream;
import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;
import q20.b;

public class InstrumentationResultPrinter extends InstrumentationRunListener {

    /* renamed from: b  reason: collision with root package name */
    public final Bundle f11572b;

    /* renamed from: c  reason: collision with root package name */
    public Bundle f11573c;

    /* renamed from: d  reason: collision with root package name */
    public int f11574d = 0;

    /* renamed from: e  reason: collision with root package name */
    public int f11575e = -999;

    /* renamed from: f  reason: collision with root package name */
    public String f11576f = null;

    /* renamed from: g  reason: collision with root package name */
    public Description f11577g = Description.EMPTY;

    public InstrumentationResultPrinter() {
        Bundle bundle = new Bundle();
        this.f11572b = bundle;
        this.f11573c = new Bundle(bundle);
    }

    public void a(Failure failure) {
        this.f11575e = -4;
        this.f11573c.putString(InnerShareParams.STACK, failure.getTrace());
    }

    public void b(Failure failure) throws Exception {
        boolean z11;
        if (this.f11577g.equals(Description.EMPTY) && this.f11574d == 0 && this.f11576f == null) {
            g(failure.getDescription());
            z11 = true;
        } else {
            z11 = false;
        }
        this.f11575e = -2;
        m(failure);
        if (z11) {
            c(failure.getDescription());
        }
    }

    public void c(Description description) throws Exception {
        if (this.f11575e == 0) {
            this.f11573c.putString("stream", InstructionFileId.DOT);
        }
        j(this.f11575e, this.f11573c);
    }

    public void d(Description description) throws Exception {
        g(description);
        this.f11575e = -3;
        c(description);
    }

    public void f(Description description) throws Exception {
        this.f11572b.putString("id", "AndroidJUnitRunner");
        this.f11572b.putInt("numtests", description.testCount());
    }

    public void g(Description description) throws Exception {
        this.f11577g = description;
        String className = description.getClassName();
        String methodName = description.getMethodName();
        Bundle bundle = new Bundle(this.f11572b);
        this.f11573c = bundle;
        bundle.putString(Constants.CLASS, className);
        this.f11573c.putString("test", methodName);
        Bundle bundle2 = this.f11573c;
        int i11 = this.f11574d + 1;
        this.f11574d = i11;
        bundle2.putInt("current", i11);
        if (className == null || className.equals(this.f11576f)) {
            this.f11573c.putString("stream", "");
        } else {
            this.f11573c.putString("stream", String.format("\n%s:", new Object[]{className}));
            this.f11576f = className;
        }
        j(1, this.f11573c);
        this.f11575e = 0;
    }

    public void i(PrintStream printStream, Bundle bundle, Result result) {
        new b(printStream).e(result);
    }

    public final void m(Failure failure) {
        String trace = failure.getTrace();
        if (trace.length() > 32768) {
            Log.w("InstrumentationResultPrinter", String.format("Stack trace too long, trimmed to first %s characters.", new Object[]{32768}));
            trace = String.valueOf(trace.substring(0, 32768)).concat("\n");
        }
        this.f11573c.putString(InnerShareParams.STACK, trace);
        this.f11573c.putString("stream", String.format("\nError in %s:\n%s", new Object[]{failure.getDescription().getDisplayName(), failure.getTrace()}));
    }

    public void n(Throwable th2) {
        try {
            this.f11575e = -2;
            Failure failure = new Failure(this.f11577g, th2);
            this.f11573c.putString(InnerShareParams.STACK, failure.getTrace());
            this.f11573c.putString("stream", String.format("\nProcess crashed while executing %s:\n%s", new Object[]{this.f11577g.getDisplayName(), failure.getTrace()}));
            c(this.f11577g);
        } catch (Exception unused) {
            Description description = this.f11577g;
            if (description == null) {
                Log.e("InstrumentationResultPrinter", "Failed to initialize test before process crash");
                return;
            }
            String displayName = description.getDisplayName();
            StringBuilder sb2 = new StringBuilder(String.valueOf(displayName).length() + 52);
            sb2.append("Failed to mark test ");
            sb2.append(displayName);
            sb2.append(" as finished after process crash");
            Log.e("InstrumentationResultPrinter", sb2.toString());
        }
    }
}
