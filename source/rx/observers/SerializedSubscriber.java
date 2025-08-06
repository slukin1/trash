package rx.observers;

import rx.Observer;
import rx.Subscriber;

public class SerializedSubscriber<T> extends Subscriber<T> {

    /* renamed from: s  reason: collision with root package name */
    private final Observer<T> f47815s;

    public SerializedSubscriber(Subscriber<? super T> subscriber) {
        this(subscriber, true);
    }

    public void onCompleted() {
        this.f47815s.onCompleted();
    }

    public void onError(Throwable th2) {
        this.f47815s.onError(th2);
    }

    public void onNext(T t11) {
        this.f47815s.onNext(t11);
    }

    public SerializedSubscriber(Subscriber<? super T> subscriber, boolean z11) {
        super(subscriber, z11);
        this.f47815s = new SerializedObserver(subscriber);
    }
}
