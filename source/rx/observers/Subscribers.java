package rx.observers;

import rx.Observer;
import rx.Subscriber;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action0;
import rx.functions.Action1;

public final class Subscribers {
    private Subscribers() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Subscriber<T> create(final Action1<? super T> action1) {
        if (action1 != null) {
            return new Subscriber<T>() {
                public final void onCompleted() {
                }

                public final void onError(Throwable th2) {
                    throw new OnErrorNotImplementedException(th2);
                }

                public final void onNext(T t11) {
                    action1.call(t11);
                }
            };
        }
        throw new IllegalArgumentException("onNext can not be null");
    }

    public static <T> Subscriber<T> empty() {
        return from(Observers.empty());
    }

    public static <T> Subscriber<T> from(final Observer<? super T> observer) {
        return new Subscriber<T>() {
            public void onCompleted() {
                observer.onCompleted();
            }

            public void onError(Throwable th2) {
                observer.onError(th2);
            }

            public void onNext(T t11) {
                observer.onNext(t11);
            }
        };
    }

    public static <T> Subscriber<T> wrap(final Subscriber<? super T> subscriber) {
        return new Subscriber<T>(subscriber) {
            public void onCompleted() {
                subscriber.onCompleted();
            }

            public void onError(Throwable th2) {
                subscriber.onError(th2);
            }

            public void onNext(T t11) {
                subscriber.onNext(t11);
            }
        };
    }

    public static <T> Subscriber<T> create(final Action1<? super T> action1, final Action1<Throwable> action12) {
        if (action1 == null) {
            throw new IllegalArgumentException("onNext can not be null");
        } else if (action12 != null) {
            return new Subscriber<T>() {
                public final void onCompleted() {
                }

                public final void onError(Throwable th2) {
                    action12.call(th2);
                }

                public final void onNext(T t11) {
                    action1.call(t11);
                }
            };
        } else {
            throw new IllegalArgumentException("onError can not be null");
        }
    }

    public static <T> Subscriber<T> create(final Action1<? super T> action1, final Action1<Throwable> action12, final Action0 action0) {
        if (action1 == null) {
            throw new IllegalArgumentException("onNext can not be null");
        } else if (action12 == null) {
            throw new IllegalArgumentException("onError can not be null");
        } else if (action0 != null) {
            return new Subscriber<T>() {
                public final void onCompleted() {
                    action0.call();
                }

                public final void onError(Throwable th2) {
                    action12.call(th2);
                }

                public final void onNext(T t11) {
                    action1.call(t11);
                }
            };
        } else {
            throw new IllegalArgumentException("onComplete can not be null");
        }
    }
}
