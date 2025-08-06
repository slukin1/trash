package org.junit.runner.manipulation;

import org.junit.runner.Description;

public abstract class Filter {

    /* renamed from: a  reason: collision with root package name */
    public static final Filter f25463a = new a();

    public static class a extends Filter {
        public void a(Object obj) throws NoTestsRemainException {
        }

        public Filter b(Filter filter) {
            return filter;
        }

        public boolean c(Description description) {
            return true;
        }
    }

    public class b extends Filter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Filter f25464b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Filter f25465c;

        public b(Filter filter, Filter filter2) {
            this.f25464b = filter;
            this.f25465c = filter2;
        }

        public boolean c(Description description) {
            return this.f25464b.c(description) && this.f25465c.c(description);
        }
    }

    public void a(Object obj) throws NoTestsRemainException {
        if (obj instanceof v20.a) {
            ((v20.a) obj).a(this);
        }
    }

    public Filter b(Filter filter) {
        return (filter == this || filter == f25463a) ? this : new b(this, filter);
    }

    public abstract boolean c(Description description);
}
