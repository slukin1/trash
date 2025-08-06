package zendesk.classic.messaging;

import java.util.concurrent.atomic.AtomicInteger;

public class m {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicInteger f62550a = new AtomicInteger();

    /* renamed from: b  reason: collision with root package name */
    public final a f62551b;

    public interface a {
        void a();
    }

    public m(a aVar) {
        this.f62551b = aVar;
    }

    public void a() {
        if (this.f62550a.decrementAndGet() == 0) {
            this.f62551b.a();
        }
    }

    public void b(int i11) {
        this.f62550a.addAndGet(i11);
    }
}
