package rx;

public interface Observer<T> {
    void onCompleted();

    void onError(Throwable th2);

    void onNext(T t11);
}
