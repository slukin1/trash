package rx.internal.observers;

import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Producer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.observers.AssertableSubscriber;
import rx.observers.TestSubscriber;

public class AssertableSubscriberObservable<T> extends Subscriber<T> implements AssertableSubscriber<T> {

    /* renamed from: ts  reason: collision with root package name */
    private final TestSubscriber<T> f29197ts;

    public AssertableSubscriberObservable(TestSubscriber<T> testSubscriber) {
        this.f29197ts = testSubscriber;
    }

    public static <T> AssertableSubscriberObservable<T> create(long j11) {
        TestSubscriber testSubscriber = new TestSubscriber(j11);
        AssertableSubscriberObservable<T> assertableSubscriberObservable = new AssertableSubscriberObservable<>(testSubscriber);
        assertableSubscriberObservable.add(testSubscriber);
        return assertableSubscriberObservable;
    }

    public AssertableSubscriber<T> assertCompleted() {
        this.f29197ts.assertCompleted();
        return this;
    }

    public AssertableSubscriber<T> assertError(Class<? extends Throwable> cls) {
        this.f29197ts.assertError(cls);
        return this;
    }

    public final AssertableSubscriber<T> assertFailure(Class<? extends Throwable> cls, T... tArr) {
        this.f29197ts.assertValues(tArr);
        this.f29197ts.assertError(cls);
        this.f29197ts.assertNotCompleted();
        return this;
    }

    public final AssertableSubscriber<T> assertFailureAndMessage(Class<? extends Throwable> cls, String str, T... tArr) {
        this.f29197ts.assertValues(tArr);
        this.f29197ts.assertError(cls);
        this.f29197ts.assertNotCompleted();
        String message = this.f29197ts.getOnErrorEvents().get(0).getMessage();
        if (message == str || (str != null && str.equals(message))) {
            return this;
        }
        throw new AssertionError("Error message differs. Expected: '" + str + "', Received: '" + message + "'");
    }

    public AssertableSubscriber<T> assertNoErrors() {
        this.f29197ts.assertNoErrors();
        return this;
    }

    public AssertableSubscriber<T> assertNoTerminalEvent() {
        this.f29197ts.assertNoTerminalEvent();
        return this;
    }

    public AssertableSubscriber<T> assertNoValues() {
        this.f29197ts.assertNoValues();
        return this;
    }

    public AssertableSubscriber<T> assertNotCompleted() {
        this.f29197ts.assertNotCompleted();
        return this;
    }

    public AssertableSubscriber<T> assertReceivedOnNext(List<T> list) {
        this.f29197ts.assertReceivedOnNext(list);
        return this;
    }

    public final AssertableSubscriber<T> assertResult(T... tArr) {
        this.f29197ts.assertValues(tArr);
        this.f29197ts.assertNoErrors();
        this.f29197ts.assertCompleted();
        return this;
    }

    public AssertableSubscriber<T> assertTerminalEvent() {
        this.f29197ts.assertTerminalEvent();
        return this;
    }

    public AssertableSubscriber<T> assertUnsubscribed() {
        this.f29197ts.assertUnsubscribed();
        return this;
    }

    public AssertableSubscriber<T> assertValue(T t11) {
        this.f29197ts.assertValue(t11);
        return this;
    }

    public AssertableSubscriber<T> assertValueCount(int i11) {
        this.f29197ts.assertValueCount(i11);
        return this;
    }

    public AssertableSubscriber<T> assertValues(T... tArr) {
        this.f29197ts.assertValues(tArr);
        return this;
    }

    public final AssertableSubscriber<T> assertValuesAndClear(T t11, T... tArr) {
        this.f29197ts.assertValuesAndClear(t11, tArr);
        return this;
    }

    public AssertableSubscriber<T> awaitTerminalEvent() {
        this.f29197ts.awaitTerminalEvent();
        return this;
    }

    public AssertableSubscriber<T> awaitTerminalEventAndUnsubscribeOnTimeout(long j11, TimeUnit timeUnit) {
        this.f29197ts.awaitTerminalEventAndUnsubscribeOnTimeout(j11, timeUnit);
        return this;
    }

    public final AssertableSubscriber<T> awaitValueCount(int i11, long j11, TimeUnit timeUnit) {
        if (this.f29197ts.awaitValueCount(i11, j11, timeUnit)) {
            return this;
        }
        throw new AssertionError("Did not receive enough values in time. Expected: " + i11 + ", Actual: " + this.f29197ts.getValueCount());
    }

    public final int getCompletions() {
        return this.f29197ts.getCompletions();
    }

    public Thread getLastSeenThread() {
        return this.f29197ts.getLastSeenThread();
    }

    public List<Throwable> getOnErrorEvents() {
        return this.f29197ts.getOnErrorEvents();
    }

    public List<T> getOnNextEvents() {
        return this.f29197ts.getOnNextEvents();
    }

    public final int getValueCount() {
        return this.f29197ts.getValueCount();
    }

    public void onCompleted() {
        this.f29197ts.onCompleted();
    }

    public void onError(Throwable th2) {
        this.f29197ts.onError(th2);
    }

    public void onNext(T t11) {
        this.f29197ts.onNext(t11);
    }

    public void onStart() {
        this.f29197ts.onStart();
    }

    public final AssertableSubscriber<T> perform(Action0 action0) {
        action0.call();
        return this;
    }

    public AssertableSubscriber<T> requestMore(long j11) {
        this.f29197ts.requestMore(j11);
        return this;
    }

    public void setProducer(Producer producer) {
        this.f29197ts.setProducer(producer);
    }

    public String toString() {
        return this.f29197ts.toString();
    }

    public AssertableSubscriber<T> assertError(Throwable th2) {
        this.f29197ts.assertError(th2);
        return this;
    }

    public AssertableSubscriber<T> awaitTerminalEvent(long j11, TimeUnit timeUnit) {
        this.f29197ts.awaitTerminalEvent(j11, timeUnit);
        return this;
    }
}
