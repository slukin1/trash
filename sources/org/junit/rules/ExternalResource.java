package org.junit.rules;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import u20.c;

public abstract class ExternalResource implements c {

    public class a extends Statement {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Statement f25443a;

        public a(Statement statement) throws Throwable {
            this.f25443a = statement;
        }

        public void a() throws Throwable {
            ExternalResource.this.c();
            try {
                this.f25443a.a();
            } finally {
                ExternalResource.this.b();
            }
        }
    }

    public Statement a(Statement statement, Description description) {
        return d(statement);
    }

    public void b() {
    }

    public void c() throws Throwable {
    }

    public final Statement d(Statement statement) {
        return new a(statement);
    }
}
