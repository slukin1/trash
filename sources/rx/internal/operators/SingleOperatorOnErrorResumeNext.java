package rx.internal.operators;

import java.util.Objects;
import rx.Single;
import rx.SingleSubscriber;
import rx.exceptions.Exceptions;
import rx.functions.Func1;

public final class SingleOperatorOnErrorResumeNext<T> implements Single.OnSubscribe<T> {
    private final Single<? extends T> originalSingle;
    public final Func1<Throwable, ? extends Single<? extends T>> resumeFunctionInCaseOfError;

    private SingleOperatorOnErrorResumeNext(Single<? extends T> single, Func1<Throwable, ? extends Single<? extends T>> func1) {
        Objects.requireNonNull(single, "originalSingle must not be null");
        Objects.requireNonNull(func1, "resumeFunctionInCaseOfError must not be null");
        this.originalSingle = single;
        this.resumeFunctionInCaseOfError = func1;
    }

    public static <T> SingleOperatorOnErrorResumeNext<T> withFunction(Single<? extends T> single, Func1<Throwable, ? extends Single<? extends T>> func1) {
        return new SingleOperatorOnErrorResumeNext<>(single, func1);
    }

    public static <T> SingleOperatorOnErrorResumeNext<T> withOther(Single<? extends T> single, final Single<? extends T> single2) {
        Objects.requireNonNull(single2, "resumeSingleInCaseOfError must not be null");
        return new SingleOperatorOnErrorResumeNext<>(single, new Func1<Throwable, Single<? extends T>>() {
            public Single<? extends T> call(Throwable th2) {
                return single2;
            }
        });
    }

    public void call(final SingleSubscriber<? super T> singleSubscriber) {
        AnonymousClass2 r02 = new SingleSubscriber<T>() {
            public void onError(Throwable th2) {
                try {
                    ((Single) SingleOperatorOnErrorResumeNext.this.resumeFunctionInCaseOfError.call(th2)).subscribe(singleSubscriber);
                } catch (Throwable th3) {
                    Exceptions.throwOrReport(th3, (SingleSubscriber<?>) singleSubscriber);
                }
            }

            public void onSuccess(T t11) {
                singleSubscriber.onSuccess(t11);
            }
        };
        singleSubscriber.add(r02);
        this.originalSingle.subscribe(r02);
    }
}
