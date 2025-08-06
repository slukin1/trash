package t20;

import java.util.List;
import org.junit.runners.model.Statement;
import x20.c;

public class f extends Statement {

    /* renamed from: a  reason: collision with root package name */
    public final Statement f26198a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f26199b;

    /* renamed from: c  reason: collision with root package name */
    public final List<c> f26200c;

    public f(Statement statement, List<c> list, Object obj) {
        this.f26198a = statement;
        this.f26200c = list;
        this.f26199b = obj;
    }

    public void a() throws Throwable {
        for (c m11 : this.f26200c) {
            m11.m(this.f26199b, new Object[0]);
        }
        this.f26198a.a();
    }
}
