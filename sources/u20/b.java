package u20;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class b extends Statement {

    /* renamed from: a  reason: collision with root package name */
    public final Statement f26257a;

    public b(Statement statement, Iterable<c> iterable, Description description) {
        this.f26257a = b(statement, iterable, description);
    }

    public static Statement b(Statement statement, Iterable<c> iterable, Description description) {
        for (c a11 : iterable) {
            statement = a11.a(statement, description);
        }
        return statement;
    }

    public void a() throws Throwable {
        this.f26257a.a();
    }
}
