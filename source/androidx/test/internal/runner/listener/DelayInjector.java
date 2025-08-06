package androidx.test.internal.runner.listener;

import android.util.Log;
import org.junit.runner.Description;
import org.junit.runner.notification.RunListener;

public class DelayInjector extends RunListener {

    /* renamed from: a  reason: collision with root package name */
    public final int f11571a;

    public DelayInjector(int i11) {
        this.f11571a = i11;
    }

    public void c(Description description) throws Exception {
        h();
    }

    public void f(Description description) throws Exception {
        h();
    }

    public final void h() {
        try {
            Thread.sleep((long) this.f11571a);
        } catch (InterruptedException e11) {
            Log.e("DelayInjector", "interrupted", e11);
        }
    }
}
