package os;

import android.annotation.SuppressLint;
import java.util.ArrayList;
import java.util.List;
import rx.Subscription;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public Subscription f84549a;

    /* renamed from: b  reason: collision with root package name */
    public final List<a> f84550b;

    public interface a {
        void a(boolean z11, int i11);
    }

    public static class b {
        @SuppressLint({"StaticFieldLeak"})

        /* renamed from: a  reason: collision with root package name */
        public static e f84551a = new e((d) null);
    }

    public /* synthetic */ e(d dVar) {
        this();
    }

    public static e b() {
        return b.f84551a;
    }

    public void a() {
        Subscription subscription = this.f84549a;
        if (subscription != null) {
            subscription.unsubscribe();
            this.f84549a = null;
        }
        for (a next : this.f84550b) {
            if (next != null) {
                next.a(false, -1);
            }
        }
    }

    public e() {
        this.f84550b = new ArrayList(2);
    }
}
