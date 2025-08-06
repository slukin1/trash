package kotlinx.coroutines;

import d10.l;
import java.util.concurrent.CancellationException;
import kotlin.Unit;
import kotlin.coroutines.a;
import kotlin.coroutines.c;
import kotlin.sequences.g;

public final class v1 extends a implements n1 {

    /* renamed from: b  reason: collision with root package name */
    public static final v1 f57574b = new v1();

    public v1() {
        super(n1.f57382r0);
    }

    public CancellationException A() {
        throw new IllegalStateException("This job is always active");
    }

    public x0 E(boolean z11, boolean z12, l<? super Throwable, Unit> lVar) {
        return w1.f57576b;
    }

    public Object F(c<? super Unit> cVar) {
        throw new UnsupportedOperationException("This job is always active");
    }

    public x0 L(l<? super Throwable, Unit> lVar) {
        return w1.f57576b;
    }

    public boolean a() {
        return false;
    }

    public void b(CancellationException cancellationException) {
    }

    public g<n1> getChildren() {
        return SequencesKt__SequencesKt.e();
    }

    public n1 getParent() {
        return null;
    }

    public boolean isActive() {
        return true;
    }

    public boolean isCancelled() {
        return false;
    }

    public boolean start() {
        return false;
    }

    public String toString() {
        return "NonCancellable";
    }

    public q v(s sVar) {
        return w1.f57576b;
    }
}
