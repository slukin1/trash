package rx.internal.operators;

import rx.Observable;
import rx.functions.Func2;
import rx.internal.util.UtilityFunctions;

public final class OperatorSequenceEqual {
    public static final Object LOCAL_ON_COMPLETED = new Object();

    private OperatorSequenceEqual() {
        throw new IllegalStateException("No instances!");
    }

    public static <T> Observable<Object> materializeLite(Observable<T> observable) {
        return Observable.concat(observable, Observable.just(LOCAL_ON_COMPLETED));
    }

    public static <T> Observable<Boolean> sequenceEqual(Observable<? extends T> observable, Observable<? extends T> observable2, final Func2<? super T, ? super T, Boolean> func2) {
        return Observable.zip(materializeLite(observable), materializeLite(observable2), new Func2<Object, Object, Boolean>() {
            public Boolean call(Object obj, Object obj2) {
                Object obj3 = OperatorSequenceEqual.LOCAL_ON_COMPLETED;
                boolean z11 = true;
                boolean z12 = obj == obj3;
                if (obj2 != obj3) {
                    z11 = false;
                }
                if (z12 && z11) {
                    return Boolean.TRUE;
                }
                if (z12 || z11) {
                    return Boolean.FALSE;
                }
                return (Boolean) func2.call(obj, obj2);
            }
        }).all(UtilityFunctions.identity());
    }
}
