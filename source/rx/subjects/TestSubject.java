package rx.subjects;

import java.util.concurrent.TimeUnit;
import rx.Observable;
import rx.Scheduler;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.internal.operators.NotificationLite;
import rx.schedulers.TestScheduler;
import rx.subjects.SubjectSubscriptionManager;

public final class TestSubject<T> extends Subject<T, T> {
    private final Scheduler.Worker innerScheduler;
    private final SubjectSubscriptionManager<T> state;

    public TestSubject(Observable.OnSubscribe<T> onSubscribe, SubjectSubscriptionManager<T> subjectSubscriptionManager, TestScheduler testScheduler) {
        super(onSubscribe);
        this.state = subjectSubscriptionManager;
        this.innerScheduler = testScheduler.createWorker();
    }

    public static <T> TestSubject<T> create(TestScheduler testScheduler) {
        final SubjectSubscriptionManager subjectSubscriptionManager = new SubjectSubscriptionManager();
        AnonymousClass1 r12 = new Action1<SubjectSubscriptionManager.SubjectObserver<T>>() {
            public void call(SubjectSubscriptionManager.SubjectObserver<T> subjectObserver) {
                subjectObserver.emitFirst(subjectSubscriptionManager.getLatest());
            }
        };
        subjectSubscriptionManager.onAdded = r12;
        subjectSubscriptionManager.onTerminated = r12;
        return new TestSubject<>(subjectSubscriptionManager, subjectSubscriptionManager, testScheduler);
    }

    public boolean hasObservers() {
        return this.state.observers().length > 0;
    }

    public void internalOnCompleted() {
        SubjectSubscriptionManager<T> subjectSubscriptionManager = this.state;
        if (subjectSubscriptionManager.active) {
            for (SubjectSubscriptionManager.SubjectObserver onCompleted : subjectSubscriptionManager.terminate(NotificationLite.completed())) {
                onCompleted.onCompleted();
            }
        }
    }

    public void internalOnError(Throwable th2) {
        SubjectSubscriptionManager<T> subjectSubscriptionManager = this.state;
        if (subjectSubscriptionManager.active) {
            for (SubjectSubscriptionManager.SubjectObserver onError : subjectSubscriptionManager.terminate(NotificationLite.error(th2))) {
                onError.onError(th2);
            }
        }
    }

    public void internalOnNext(T t11) {
        for (SubjectSubscriptionManager.SubjectObserver onNext : this.state.observers()) {
            onNext.onNext(t11);
        }
    }

    public void onCompleted() {
        onCompleted(0);
    }

    public void onError(Throwable th2) {
        onError(th2, 0);
    }

    public void onNext(T t11) {
        onNext(t11, 0);
    }

    public void onCompleted(long j11) {
        this.innerScheduler.schedule(new Action0() {
            public void call() {
                TestSubject.this.internalOnCompleted();
            }
        }, j11, TimeUnit.MILLISECONDS);
    }

    public void onError(final Throwable th2, long j11) {
        this.innerScheduler.schedule(new Action0() {
            public void call() {
                TestSubject.this.internalOnError(th2);
            }
        }, j11, TimeUnit.MILLISECONDS);
    }

    public void onNext(final T t11, long j11) {
        this.innerScheduler.schedule(new Action0() {
            public void call() {
                TestSubject.this.internalOnNext(t11);
            }
        }, j11, TimeUnit.MILLISECONDS);
    }
}
