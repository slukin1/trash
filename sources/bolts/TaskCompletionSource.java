package bolts;

import y1.g;

public class TaskCompletionSource<TResult> {

    /* renamed from: a  reason: collision with root package name */
    public final g<TResult> f12864a = new g<>();

    public g<TResult> a() {
        return this.f12864a;
    }

    public void b() {
        if (!e()) {
            throw new IllegalStateException("Cannot cancel a completed task.");
        }
    }

    public void c(Exception exc) {
        if (!f(exc)) {
            throw new IllegalStateException("Cannot set the error on a completed task.");
        }
    }

    public void d(TResult tresult) {
        if (!g(tresult)) {
            throw new IllegalStateException("Cannot set the result of a completed task.");
        }
    }

    public boolean e() {
        return this.f12864a.v();
    }

    public boolean f(Exception exc) {
        return this.f12864a.w(exc);
    }

    public boolean g(TResult tresult) {
        return this.f12864a.x(tresult);
    }
}
