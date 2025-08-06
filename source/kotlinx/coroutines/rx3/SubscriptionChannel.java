package kotlinx.coroutines.rx3;

import d10.l;
import h00.f;
import h00.k;
import io.reactivex.rxjava3.disposables.b;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.channels.BufferedChannel;

final class SubscriptionChannel<T> extends BufferedChannel<T> implements k<T>, f<T> {

    /* renamed from: n  reason: collision with root package name */
    public static final AtomicReferenceFieldUpdater f57447n = AtomicReferenceFieldUpdater.newUpdater(SubscriptionChannel.class, Object.class, "_subscription");
    private volatile Object _subscription;

    public SubscriptionChannel() {
        super(Integer.MAX_VALUE, (l) null, 2, (r) null);
    }

    public void onComplete() {
        K((Throwable) null);
    }

    public void onError(Throwable th2) {
        K(th2);
    }

    public void onNext(T t11) {
        q(t11);
    }

    public void onSubscribe(b bVar) {
        f57447n.set(this, bVar);
    }

    public void onSuccess(T t11) {
        q(t11);
        K((Throwable) null);
    }

    public void q0() {
        b bVar = (b) f57447n.getAndSet(this, (Object) null);
        if (bVar != null) {
            bVar.dispose();
        }
    }
}
