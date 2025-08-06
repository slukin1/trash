package kotlinx.coroutines.sync;

import java.util.concurrent.atomic.AtomicReferenceArray;
import kotlin.coroutines.CoroutineContext;
import kotlinx.coroutines.internal.z;

public final class c extends z<c> {

    /* renamed from: f  reason: collision with root package name */
    public final AtomicReferenceArray f57564f = new AtomicReferenceArray(SemaphoreKt.f57563f);

    public c(long j11, c cVar, int i11) {
        super(j11, cVar, i11);
    }

    public int n() {
        return SemaphoreKt.f57563f;
    }

    public void o(int i11, Throwable th2, CoroutineContext coroutineContext) {
        r().set(i11, SemaphoreKt.f57562e);
        p();
    }

    public final AtomicReferenceArray r() {
        return this.f57564f;
    }

    public String toString() {
        return "SemaphoreSegment[id=" + this.f57353d + ", hashCode=" + hashCode() + ']';
    }
}
