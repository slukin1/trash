package org.junit.rules;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;
import u20.c;

public abstract class Verifier implements c {

    public class a extends Statement {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Statement f25458a;

        public a(Statement statement) throws Throwable {
            this.f25458a = statement;
        }

        public void a() throws Throwable {
            this.f25458a.a();
            Verifier.this.b();
        }
    }

    public Statement a(Statement statement, Description description) {
        return new a(statement);
    }

    public void b() throws Throwable {
    }
}
