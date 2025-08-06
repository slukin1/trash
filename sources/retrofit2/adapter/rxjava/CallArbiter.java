package retrofit2.adapter.rxjava;

import java.util.concurrent.atomic.AtomicInteger;
import retrofit2.Call;
import retrofit2.Response;
import rx.Producer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.CompositeException;
import rx.exceptions.Exceptions;
import rx.exceptions.OnCompletedFailedException;
import rx.exceptions.OnErrorFailedException;
import rx.exceptions.OnErrorNotImplementedException;
import rx.plugins.RxJavaPlugins;

final class CallArbiter<T> extends AtomicInteger implements Subscription, Producer {
    private static final int STATE_HAS_RESPONSE = 2;
    private static final int STATE_REQUESTED = 1;
    private static final int STATE_TERMINATED = 3;
    private static final int STATE_WAITING = 0;
    private final Call<T> call;
    private volatile Response<T> response;
    private final Subscriber<? super Response<T>> subscriber;

    public CallArbiter(Call<T> call2, Subscriber<? super Response<T>> subscriber2) {
        super(0);
        this.call = call2;
        this.subscriber = subscriber2;
    }

    private void deliverResponse(Response<T> response2) {
        try {
            if (!isUnsubscribed()) {
                this.subscriber.onNext(response2);
            }
            try {
                if (!isUnsubscribed()) {
                    this.subscriber.onCompleted();
                }
            } catch (OnCompletedFailedException | OnErrorFailedException | OnErrorNotImplementedException e11) {
                RxJavaPlugins.getInstance().getErrorHandler().handleError(e11);
            } catch (Throwable th2) {
                Exceptions.throwIfFatal(th2);
                RxJavaPlugins.getInstance().getErrorHandler().handleError(th2);
            }
        } catch (OnCompletedFailedException | OnErrorFailedException | OnErrorNotImplementedException e12) {
            RxJavaPlugins.getInstance().getErrorHandler().handleError(e12);
        } catch (Throwable th3) {
            Exceptions.throwIfFatal(th3);
            try {
                this.subscriber.onError(th3);
            } catch (OnCompletedFailedException | OnErrorFailedException | OnErrorNotImplementedException e13) {
                RxJavaPlugins.getInstance().getErrorHandler().handleError(e13);
            } catch (Throwable th4) {
                Exceptions.throwIfFatal(th4);
                RxJavaPlugins.getInstance().getErrorHandler().handleError(new CompositeException(th3, th4));
            }
        }
    }

    public void emitError(Throwable th2) {
        set(3);
        if (!isUnsubscribed()) {
            try {
                this.subscriber.onError(th2);
            } catch (OnCompletedFailedException | OnErrorFailedException | OnErrorNotImplementedException e11) {
                RxJavaPlugins.getInstance().getErrorHandler().handleError(e11);
            } catch (Throwable th3) {
                Exceptions.throwIfFatal(th3);
                RxJavaPlugins.getInstance().getErrorHandler().handleError(new CompositeException(th2, th3));
            }
        }
    }

    public void emitResponse(Response<T> response2) {
        while (true) {
            int i11 = get();
            if (i11 == 0) {
                this.response = response2;
                if (compareAndSet(0, 2)) {
                    return;
                }
            } else if (i11 != 1) {
                if (i11 == 2 || i11 == 3) {
                    throw new AssertionError();
                }
                throw new IllegalStateException("Unknown state: " + i11);
            } else if (compareAndSet(1, 3)) {
                deliverResponse(response2);
                return;
            }
        }
    }

    public boolean isUnsubscribed() {
        return this.call.isCanceled();
    }

    public void request(long j11) {
        if (j11 != 0) {
            while (true) {
                int i11 = get();
                if (i11 != 0) {
                    if (i11 == 1) {
                        return;
                    }
                    if (i11 != 2) {
                        if (i11 != 3) {
                            throw new IllegalStateException("Unknown state: " + i11);
                        }
                        return;
                    } else if (compareAndSet(2, 3)) {
                        deliverResponse(this.response);
                        return;
                    }
                } else if (compareAndSet(0, 1)) {
                    return;
                }
            }
        }
    }

    public void unsubscribe() {
        this.call.cancel();
    }
}
