package h00;

import io.reactivex.rxjava3.disposables.b;

public interface k<T> {
    void onComplete();

    void onError(Throwable th2);

    void onNext(T t11);

    void onSubscribe(b bVar);
}
