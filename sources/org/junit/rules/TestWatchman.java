package org.junit.rules;

import org.junit.internal.AssumptionViolatedException;
import org.junit.runners.model.Statement;
import x20.c;

@Deprecated
public class TestWatchman implements u20.a {

    public class a extends Statement {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ c f25455a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ Statement f25456b;

        public a(c cVar, Statement statement) throws Throwable {
            this.f25455a = cVar;
            this.f25456b = statement;
        }

        public void a() throws Throwable {
            TestWatchman.this.d(this.f25455a);
            try {
                this.f25456b.a();
                TestWatchman.this.e(this.f25455a);
                TestWatchman.this.c(this.f25455a);
            } catch (AssumptionViolatedException e11) {
                throw e11;
            } catch (Throwable th2) {
                TestWatchman.this.c(this.f25455a);
                throw th2;
            }
        }
    }

    public Statement a(Statement statement, c cVar, Object obj) {
        return new a(cVar, statement);
    }

    public void b(Throwable th2, c cVar) {
    }

    public void c(c cVar) {
    }

    public void d(c cVar) {
    }

    public void e(c cVar) {
    }
}
