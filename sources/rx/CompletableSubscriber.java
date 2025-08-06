package rx;

public interface CompletableSubscriber {
    void onCompleted();

    void onError(Throwable th2);

    void onSubscribe(Subscription subscription);
}
