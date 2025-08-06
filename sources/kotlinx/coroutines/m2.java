package kotlinx.coroutines;

import kotlin.coroutines.c;
import kotlinx.coroutines.internal.y;

public final class m2<U, T extends U> extends y<T> implements Runnable {

    /* renamed from: f  reason: collision with root package name */
    public final long f57381f;

    public m2(long j11, c<? super U> cVar) {
        super(cVar.getContext(), cVar);
        this.f57381f = j11;
    }

    public String D0() {
        return super.D0() + "(timeMillis=" + this.f57381f + ')';
    }

    public void run() {
        X(TimeoutKt.a(this.f57381f, DelayKt.c(getContext()), this));
    }
}
