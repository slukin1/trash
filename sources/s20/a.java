package s20;

import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runner.notification.Failure;
import org.junit.runner.notification.RunNotifier;
import org.junit.runners.model.MultipleFailureException;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public final RunNotifier f25972a;

    /* renamed from: b  reason: collision with root package name */
    public final Description f25973b;

    public a(RunNotifier runNotifier, Description description) {
        this.f25972a = runNotifier;
        this.f25973b = description;
    }

    public void a(AssumptionViolatedException assumptionViolatedException) {
        this.f25972a.e(new Failure(this.f25973b, assumptionViolatedException));
    }

    public void b(Throwable th2) {
        if (th2 instanceof MultipleFailureException) {
            c((MultipleFailureException) th2);
        } else {
            this.f25972a.f(new Failure(this.f25973b, th2));
        }
    }

    public final void c(MultipleFailureException multipleFailureException) {
        for (Throwable b11 : multipleFailureException.getFailures()) {
            b(b11);
        }
    }

    public void d() {
        this.f25972a.h(this.f25973b);
    }

    public void e() {
        this.f25972a.l(this.f25973b);
    }
}
