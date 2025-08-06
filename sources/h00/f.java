package h00;

import io.reactivex.rxjava3.disposables.b;

public interface f<T> {
    void onComplete();

    void onError(Throwable th2);

    void onSubscribe(b bVar);

    void onSuccess(T t11);
}
