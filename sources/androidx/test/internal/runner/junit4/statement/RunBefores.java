package androidx.test.internal.runner.junit4.statement;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.junit.runners.model.Statement;
import x20.c;

public class RunBefores extends UiThreadStatement {

    /* renamed from: c  reason: collision with root package name */
    public final Statement f11551c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f11552d;

    /* renamed from: e  reason: collision with root package name */
    public final List<c> f11553e;

    public RunBefores(c cVar, Statement statement, List<c> list, Object obj) {
        super(statement, UiThreadStatement.e(cVar));
        this.f11551c = statement;
        this.f11553e = list;
        this.f11552d = obj;
    }

    public void a() throws Throwable {
        final AtomicReference atomicReference = new AtomicReference();
        for (final c next : this.f11553e) {
            if (UiThreadStatement.e(next)) {
                UiThreadStatement.d(new Runnable() {
                    public void run() {
                        try {
                            next.m(RunBefores.this.f11552d, new Object[0]);
                        } catch (Throwable th2) {
                            atomicReference.set(th2);
                        }
                    }
                });
                Throwable th2 = (Throwable) atomicReference.get();
                if (th2 != null) {
                    throw th2;
                }
            } else {
                next.m(this.f11552d, new Object[0]);
            }
        }
        this.f11551c.a();
    }
}
