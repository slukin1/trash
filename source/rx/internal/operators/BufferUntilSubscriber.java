package rx.internal.operators;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicReference;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Action0;
import rx.subjects.Subject;
import rx.subscriptions.Subscriptions;

public final class BufferUntilSubscriber<T> extends Subject<T, T> {
    public static final Observer EMPTY_OBSERVER = new Observer() {
        public void onCompleted() {
        }

        public void onError(Throwable th2) {
        }

        public void onNext(Object obj) {
        }
    };
    private boolean forward;
    public final State<T> state;

    public static final class OnSubscribeAction<T> implements Observable.OnSubscribe<T> {
        public final State<T> state;

        public OnSubscribeAction(State<T> state2) {
            this.state = state2;
        }

        public void call(Subscriber<? super T> subscriber) {
            boolean z11;
            if (this.state.casObserverRef((Observer) null, subscriber)) {
                subscriber.add(Subscriptions.create(new Action0() {
                    public void call() {
                        OnSubscribeAction.this.state.set(BufferUntilSubscriber.EMPTY_OBSERVER);
                    }
                }));
                synchronized (this.state.guard) {
                    State<T> state2 = this.state;
                    z11 = true;
                    if (!state2.emitting) {
                        state2.emitting = true;
                    } else {
                        z11 = false;
                    }
                }
                if (z11) {
                    while (true) {
                        Object poll = this.state.buffer.poll();
                        if (poll != null) {
                            NotificationLite.accept((Observer) this.state.get(), poll);
                        } else {
                            synchronized (this.state.guard) {
                                if (this.state.buffer.isEmpty()) {
                                    this.state.emitting = false;
                                    return;
                                }
                            }
                        }
                    }
                }
            } else {
                subscriber.onError(new IllegalStateException("Only one subscriber allowed!"));
            }
        }
    }

    public static final class State<T> extends AtomicReference<Observer<? super T>> {
        private static final long serialVersionUID = 8026705089538090368L;
        public final ConcurrentLinkedQueue<Object> buffer = new ConcurrentLinkedQueue<>();
        public boolean emitting;
        public final Object guard = new Object();

        public boolean casObserverRef(Observer<? super T> observer, Observer<? super T> observer2) {
            return compareAndSet(observer, observer2);
        }
    }

    private BufferUntilSubscriber(State<T> state2) {
        super(new OnSubscribeAction(state2));
        this.state = state2;
    }

    public static <T> BufferUntilSubscriber<T> create() {
        return new BufferUntilSubscriber<>(new State());
    }

    private void emit(Object obj) {
        synchronized (this.state.guard) {
            this.state.buffer.add(obj);
            if (this.state.get() != null) {
                State<T> state2 = this.state;
                if (!state2.emitting) {
                    this.forward = true;
                    state2.emitting = true;
                }
            }
        }
        if (this.forward) {
            while (true) {
                Object poll = this.state.buffer.poll();
                if (poll != null) {
                    NotificationLite.accept((Observer) this.state.get(), poll);
                } else {
                    return;
                }
            }
        }
    }

    public boolean hasObservers() {
        boolean z11;
        synchronized (this.state.guard) {
            z11 = this.state.get() != null;
        }
        return z11;
    }

    public void onCompleted() {
        if (this.forward) {
            ((Observer) this.state.get()).onCompleted();
        } else {
            emit(NotificationLite.completed());
        }
    }

    public void onError(Throwable th2) {
        if (this.forward) {
            ((Observer) this.state.get()).onError(th2);
        } else {
            emit(NotificationLite.error(th2));
        }
    }

    public void onNext(T t11) {
        if (this.forward) {
            ((Observer) this.state.get()).onNext(t11);
        } else {
            emit(NotificationLite.next(t11));
        }
    }
}
