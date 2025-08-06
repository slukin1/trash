package org.junit.rules;

import java.util.ArrayList;
import java.util.List;
import org.junit.internal.AssumptionViolatedException;
import org.junit.runner.Description;
import org.junit.runners.model.MultipleFailureException;
import org.junit.runners.model.Statement;
import u20.c;

public abstract class TestWatcher implements c {

    public class a extends Statement {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Description f25452a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Statement f25453b;

        public a(Description description, Statement statement) throws Exception {
            this.f25452a = description;
            this.f25453b = statement;
        }

        public void a() throws Throwable {
            ArrayList arrayList = new ArrayList();
            TestWatcher.this.o(this.f25452a, arrayList);
            try {
                this.f25453b.a();
                TestWatcher.this.q(this.f25452a, arrayList);
            } catch (AssumptionViolatedException e11) {
                arrayList.add(e11);
                TestWatcher.this.m(e11, this.f25452a, arrayList);
            } catch (Throwable th2) {
                TestWatcher.this.j(this.f25452a, arrayList);
                throw th2;
            }
            TestWatcher.this.j(this.f25452a, arrayList);
            MultipleFailureException.assertEmpty(arrayList);
        }
    }

    public Statement a(Statement statement, Description description) {
        return new a(description, statement);
    }

    public void g(Throwable th2, Description description) {
    }

    public final void h(Throwable th2, Description description, List<Throwable> list) {
        try {
            g(th2, description);
        } catch (Throwable th3) {
            list.add(th3);
        }
    }

    public void i(Description description) {
    }

    public final void j(Description description, List<Throwable> list) {
        try {
            i(description);
        } catch (Throwable th2) {
            list.add(th2);
        }
    }

    public void k(org.junit.AssumptionViolatedException assumptionViolatedException, Description description) {
        l(assumptionViolatedException, description);
    }

    @Deprecated
    public void l(AssumptionViolatedException assumptionViolatedException, Description description) {
    }

    public final void m(AssumptionViolatedException assumptionViolatedException, Description description, List<Throwable> list) {
        try {
            if (assumptionViolatedException instanceof org.junit.AssumptionViolatedException) {
                k((org.junit.AssumptionViolatedException) assumptionViolatedException, description);
            } else {
                l(assumptionViolatedException, description);
            }
        } catch (Throwable th2) {
            list.add(th2);
        }
    }

    public void n(Description description) {
    }

    public final void o(Description description, List<Throwable> list) {
        try {
            n(description);
        } catch (Throwable th2) {
            list.add(th2);
        }
    }

    public void p(Description description) {
    }

    public final void q(Description description, List<Throwable> list) {
        try {
            p(description);
        } catch (Throwable th2) {
            list.add(th2);
        }
    }
}
