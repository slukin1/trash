package t20;

import org.junit.internal.AssumptionViolatedException;
import org.junit.runners.model.Statement;

public class a extends Statement {

    /* renamed from: a  reason: collision with root package name */
    public final Statement f26180a;

    /* renamed from: b  reason: collision with root package name */
    public final Class<? extends Throwable> f26181b;

    public a(Statement statement, Class<? extends Throwable> cls) {
        this.f26180a = statement;
        this.f26181b = cls;
    }

    public void a() throws Exception {
        boolean z11;
        try {
            this.f26180a.a();
            z11 = true;
        } catch (AssumptionViolatedException e11) {
            throw e11;
        } catch (Throwable th2) {
            if (this.f26181b.isAssignableFrom(th2.getClass())) {
                z11 = false;
            } else {
                throw new Exception("Unexpected exception, expected<" + this.f26181b.getName() + "> but was<" + th2.getClass().getName() + ">", th2);
            }
        }
        if (z11) {
            throw new AssertionError("Expected exception: " + this.f26181b.getName());
        }
    }
}
