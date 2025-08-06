package retrofit2.adapter.rxjava;

import retrofit2.Call;
import retrofit2.Response;
import rx.Observable;
import rx.Subscriber;
import rx.exceptions.Exceptions;

final class CallExecuteOnSubscribe<T> implements Observable.OnSubscribe<Response<T>> {
    private final Call<T> originalCall;

    public CallExecuteOnSubscribe(Call<T> call) {
        this.originalCall = call;
    }

    public void call(Subscriber<? super Response<T>> subscriber) {
        Call<T> clone = this.originalCall.clone();
        CallArbiter callArbiter = new CallArbiter(clone, subscriber);
        subscriber.add(callArbiter);
        subscriber.setProducer(callArbiter);
        try {
            callArbiter.emitResponse(clone.execute());
        } catch (Throwable th2) {
            Exceptions.throwIfFatal(th2);
            callArbiter.emitError(th2);
        }
    }
}
