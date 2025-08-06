package rx.observers;

import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Observer;
import rx.Producer;
import rx.Subscription;
import rx.functions.Action0;

public interface AssertableSubscriber<T> extends Observer<T>, Subscription {
    AssertableSubscriber<T> assertCompleted();

    AssertableSubscriber<T> assertError(Class<? extends Throwable> cls);

    AssertableSubscriber<T> assertError(Throwable th2);

    AssertableSubscriber<T> assertFailure(Class<? extends Throwable> cls, T... tArr);

    AssertableSubscriber<T> assertFailureAndMessage(Class<? extends Throwable> cls, String str, T... tArr);

    AssertableSubscriber<T> assertNoErrors();

    AssertableSubscriber<T> assertNoTerminalEvent();

    AssertableSubscriber<T> assertNoValues();

    AssertableSubscriber<T> assertNotCompleted();

    AssertableSubscriber<T> assertReceivedOnNext(List<T> list);

    AssertableSubscriber<T> assertResult(T... tArr);

    AssertableSubscriber<T> assertTerminalEvent();

    AssertableSubscriber<T> assertUnsubscribed();

    AssertableSubscriber<T> assertValue(T t11);

    AssertableSubscriber<T> assertValueCount(int i11);

    AssertableSubscriber<T> assertValues(T... tArr);

    AssertableSubscriber<T> assertValuesAndClear(T t11, T... tArr);

    AssertableSubscriber<T> awaitTerminalEvent();

    AssertableSubscriber<T> awaitTerminalEvent(long j11, TimeUnit timeUnit);

    AssertableSubscriber<T> awaitTerminalEventAndUnsubscribeOnTimeout(long j11, TimeUnit timeUnit);

    AssertableSubscriber<T> awaitValueCount(int i11, long j11, TimeUnit timeUnit);

    int getCompletions();

    Thread getLastSeenThread();

    List<Throwable> getOnErrorEvents();

    List<T> getOnNextEvents();

    int getValueCount();

    boolean isUnsubscribed();

    void onStart();

    AssertableSubscriber<T> perform(Action0 action0);

    AssertableSubscriber<T> requestMore(long j11);

    void setProducer(Producer producer);

    void unsubscribe();
}
