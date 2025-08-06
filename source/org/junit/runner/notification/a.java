package org.junit.runner.notification;

import org.junit.runner.Description;
import org.junit.runner.Result;
import org.junit.runner.notification.RunListener;

@RunListener.a
public final class a extends RunListener {

    /* renamed from: a  reason: collision with root package name */
    public final RunListener f25485a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f25486b;

    public a(RunListener runListener, Object obj) {
        this.f25485a = runListener;
        this.f25486b = obj;
    }

    public void a(Failure failure) {
        synchronized (this.f25486b) {
            this.f25485a.a(failure);
        }
    }

    public void b(Failure failure) throws Exception {
        synchronized (this.f25486b) {
            this.f25485a.b(failure);
        }
    }

    public void c(Description description) throws Exception {
        synchronized (this.f25486b) {
            this.f25485a.c(description);
        }
    }

    public void d(Description description) throws Exception {
        synchronized (this.f25486b) {
            this.f25485a.d(description);
        }
    }

    public void e(Result result) throws Exception {
        synchronized (this.f25486b) {
            this.f25485a.e(result);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof a)) {
            return false;
        }
        return this.f25485a.equals(((a) obj).f25485a);
    }

    public void f(Description description) throws Exception {
        synchronized (this.f25486b) {
            this.f25485a.f(description);
        }
    }

    public void g(Description description) throws Exception {
        synchronized (this.f25486b) {
            this.f25485a.g(description);
        }
    }

    public int hashCode() {
        return this.f25485a.hashCode();
    }

    public String toString() {
        return this.f25485a.toString() + " (with synchronization wrapper)";
    }
}
