package rx.internal.util;

import java.util.List;
import java.util.concurrent.TimeUnit;
import rx.Notification;
import rx.Observable;
import rx.Scheduler;
import rx.exceptions.OnErrorNotImplementedException;
import rx.functions.Action1;
import rx.functions.Action2;
import rx.functions.Func0;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.internal.operators.OperatorAny;
import rx.observables.ConnectableObservable;

public enum InternalObservableUtils {
    ;
    
    public static final PlusOneFunc2 COUNTER = null;
    public static final NotificationErrorExtractor ERROR_EXTRACTOR = null;
    public static final Action1<Throwable> ERROR_NOT_IMPLEMENTED = null;
    public static final Observable.Operator<Boolean, Object> IS_EMPTY = null;
    public static final PlusOneLongFunc2 LONG_COUNTER = null;
    public static final ObjectEqualsFunc2 OBJECT_EQUALS = null;
    public static final ReturnsVoidFunc1 RETURNS_VOID = null;
    public static final ToArrayFunc1 TO_ARRAY = null;

    public static final class CollectorCaller<T, R> implements Func2<R, T, R> {
        public final Action2<R, ? super T> collector;

        public CollectorCaller(Action2<R, ? super T> action2) {
            this.collector = action2;
        }

        public R call(R r11, T t11) {
            this.collector.call(r11, t11);
            return r11;
        }
    }

    public static final class EqualsWithFunc1 implements Func1<Object, Boolean> {
        public final Object other;

        public EqualsWithFunc1(Object obj) {
            this.other = obj;
        }

        public Boolean call(Object obj) {
            Object obj2 = this.other;
            return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
        }
    }

    public static final class ErrorNotImplementedAction implements Action1<Throwable> {
        public void call(Throwable th2) {
            throw new OnErrorNotImplementedException(th2);
        }
    }

    public static final class IsInstanceOfFunc1 implements Func1<Object, Boolean> {
        public final Class<?> clazz;

        public IsInstanceOfFunc1(Class<?> cls) {
            this.clazz = cls;
        }

        public Boolean call(Object obj) {
            return Boolean.valueOf(this.clazz.isInstance(obj));
        }
    }

    public static final class NotificationErrorExtractor implements Func1<Notification<?>, Throwable> {
        public Throwable call(Notification<?> notification) {
            return notification.getThrowable();
        }
    }

    public static final class ObjectEqualsFunc2 implements Func2<Object, Object, Boolean> {
        public Boolean call(Object obj, Object obj2) {
            return Boolean.valueOf(obj == obj2 || (obj != null && obj.equals(obj2)));
        }
    }

    public static final class PlusOneFunc2 implements Func2<Integer, Object, Integer> {
        public Integer call(Integer num, Object obj) {
            return Integer.valueOf(num.intValue() + 1);
        }
    }

    public static final class PlusOneLongFunc2 implements Func2<Long, Object, Long> {
        public Long call(Long l11, Object obj) {
            return Long.valueOf(l11.longValue() + 1);
        }
    }

    public static final class RepeatNotificationDematerializer implements Func1<Observable<? extends Notification<?>>, Observable<?>> {
        public final Func1<? super Observable<? extends Void>, ? extends Observable<?>> notificationHandler;

        public RepeatNotificationDematerializer(Func1<? super Observable<? extends Void>, ? extends Observable<?>> func1) {
            this.notificationHandler = func1;
        }

        public Observable<?> call(Observable<? extends Notification<?>> observable) {
            return (Observable) this.notificationHandler.call(observable.map(InternalObservableUtils.RETURNS_VOID));
        }
    }

    public static final class ReplaySupplierBuffer<T> implements Func0<ConnectableObservable<T>> {
        private final int bufferSize;
        private final Observable<T> source;

        public ReplaySupplierBuffer(Observable<T> observable, int i11) {
            this.source = observable;
            this.bufferSize = i11;
        }

        public ConnectableObservable<T> call() {
            return this.source.replay(this.bufferSize);
        }
    }

    public static final class ReplaySupplierBufferTime<T> implements Func0<ConnectableObservable<T>> {
        private final Scheduler scheduler;
        private final Observable<T> source;
        private final long time;
        private final TimeUnit unit;

        public ReplaySupplierBufferTime(Observable<T> observable, long j11, TimeUnit timeUnit, Scheduler scheduler2) {
            this.unit = timeUnit;
            this.source = observable;
            this.time = j11;
            this.scheduler = scheduler2;
        }

        public ConnectableObservable<T> call() {
            return this.source.replay(this.time, this.unit, this.scheduler);
        }
    }

    public static final class ReplaySupplierNoParams<T> implements Func0<ConnectableObservable<T>> {
        private final Observable<T> source;

        public ReplaySupplierNoParams(Observable<T> observable) {
            this.source = observable;
        }

        public ConnectableObservable<T> call() {
            return this.source.replay();
        }
    }

    public static final class ReplaySupplierTime<T> implements Func0<ConnectableObservable<T>> {
        private final int bufferSize;
        private final Scheduler scheduler;
        private final Observable<T> source;
        private final long time;
        private final TimeUnit unit;

        public ReplaySupplierTime(Observable<T> observable, int i11, long j11, TimeUnit timeUnit, Scheduler scheduler2) {
            this.time = j11;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
            this.bufferSize = i11;
            this.source = observable;
        }

        public ConnectableObservable<T> call() {
            return this.source.replay(this.bufferSize, this.time, this.unit, this.scheduler);
        }
    }

    public static final class RetryNotificationDematerializer implements Func1<Observable<? extends Notification<?>>, Observable<?>> {
        public final Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> notificationHandler;

        public RetryNotificationDematerializer(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> func1) {
            this.notificationHandler = func1;
        }

        public Observable<?> call(Observable<? extends Notification<?>> observable) {
            return (Observable) this.notificationHandler.call(observable.map(InternalObservableUtils.ERROR_EXTRACTOR));
        }
    }

    public static final class ReturnsVoidFunc1 implements Func1<Object, Void> {
        public Void call(Object obj) {
            return null;
        }
    }

    public static final class SelectorAndObserveOn<T, R> implements Func1<Observable<T>, Observable<R>> {
        public final Scheduler scheduler;
        public final Func1<? super Observable<T>, ? extends Observable<R>> selector;

        public SelectorAndObserveOn(Func1<? super Observable<T>, ? extends Observable<R>> func1, Scheduler scheduler2) {
            this.selector = func1;
            this.scheduler = scheduler2;
        }

        public Observable<R> call(Observable<T> observable) {
            return ((Observable) this.selector.call(observable)).observeOn(this.scheduler);
        }
    }

    public static final class ToArrayFunc1 implements Func1<List<? extends Observable<?>>, Observable<?>[]> {
        public Observable<?>[] call(List<? extends Observable<?>> list) {
            return (Observable[]) list.toArray(new Observable[list.size()]);
        }
    }

    /* access modifiers changed from: public */
    static {
        LONG_COUNTER = new PlusOneLongFunc2();
        OBJECT_EQUALS = new ObjectEqualsFunc2();
        TO_ARRAY = new ToArrayFunc1();
        RETURNS_VOID = new ReturnsVoidFunc1();
        COUNTER = new PlusOneFunc2();
        ERROR_EXTRACTOR = new NotificationErrorExtractor();
        ERROR_NOT_IMPLEMENTED = new ErrorNotImplementedAction();
        IS_EMPTY = new OperatorAny(UtilityFunctions.alwaysTrue(), true);
    }

    public static <T, R> Func2<R, T, R> createCollectorCaller(Action2<R, ? super T> action2) {
        return new CollectorCaller(action2);
    }

    public static Func1<Observable<? extends Notification<?>>, Observable<?>> createRepeatDematerializer(Func1<? super Observable<? extends Void>, ? extends Observable<?>> func1) {
        return new RepeatNotificationDematerializer(func1);
    }

    public static <T, R> Func1<Observable<T>, Observable<R>> createReplaySelectorAndObserveOn(Func1<? super Observable<T>, ? extends Observable<R>> func1, Scheduler scheduler) {
        return new SelectorAndObserveOn(func1, scheduler);
    }

    public static <T> Func0<ConnectableObservable<T>> createReplaySupplier(Observable<T> observable) {
        return new ReplaySupplierNoParams(observable);
    }

    public static Func1<Observable<? extends Notification<?>>, Observable<?>> createRetryDematerializer(Func1<? super Observable<? extends Throwable>, ? extends Observable<?>> func1) {
        return new RetryNotificationDematerializer(func1);
    }

    public static Func1<Object, Boolean> equalsWith(Object obj) {
        return new EqualsWithFunc1(obj);
    }

    public static Func1<Object, Boolean> isInstanceOf(Class<?> cls) {
        return new IsInstanceOfFunc1(cls);
    }

    public static <T> Func0<ConnectableObservable<T>> createReplaySupplier(Observable<T> observable, int i11) {
        return new ReplaySupplierBuffer(observable, i11);
    }

    public static <T> Func0<ConnectableObservable<T>> createReplaySupplier(Observable<T> observable, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return new ReplaySupplierBufferTime(observable, j11, timeUnit, scheduler);
    }

    public static <T> Func0<ConnectableObservable<T>> createReplaySupplier(Observable<T> observable, int i11, long j11, TimeUnit timeUnit, Scheduler scheduler) {
        return new ReplaySupplierTime(observable, i11, j11, timeUnit, scheduler);
    }
}
