package rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observers.SerializedObserver;
import rx.observers.SerializedSubscriber;
import rx.subjects.PublishSubject;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.RefCountSubscription;

public final class OnSubscribeGroupJoin<T1, T2, D1, D2, R> implements Observable.OnSubscribe<R> {
    public final Observable<T1> left;
    public final Func1<? super T1, ? extends Observable<D1>> leftDuration;
    public final Func2<? super T1, ? super Observable<T2>, ? extends R> resultSelector;
    public final Observable<T2> right;
    public final Func1<? super T2, ? extends Observable<D2>> rightDuration;

    public final class ResultManager extends HashMap<Integer, Observer<T2>> implements Subscription {
        private static final long serialVersionUID = -3035156013812425335L;
        public final RefCountSubscription cancel;
        public final CompositeSubscription group;
        public boolean leftDone;
        public int leftIds;
        public boolean rightDone;
        public int rightIds;
        public final Map<Integer, T2> rightMap = new HashMap();
        public final Subscriber<? super R> subscriber;

        public final class LeftDurationObserver extends Subscriber<D1> {

            /* renamed from: id  reason: collision with root package name */
            public final int f53407id;
            public boolean once = true;

            public LeftDurationObserver(int i11) {
                this.f53407id = i11;
            }

            public void onCompleted() {
                Observer observer;
                if (this.once) {
                    this.once = false;
                    synchronized (ResultManager.this) {
                        observer = (Observer) ResultManager.this.leftMap().remove(Integer.valueOf(this.f53407id));
                    }
                    if (observer != null) {
                        observer.onCompleted();
                    }
                    ResultManager.this.group.remove(this);
                }
            }

            public void onError(Throwable th2) {
                ResultManager.this.errorMain(th2);
            }

            public void onNext(D1 d12) {
                onCompleted();
            }
        }

        public final class LeftObserver extends Subscriber<T1> {
            public LeftObserver() {
            }

            public void onCompleted() {
                ArrayList arrayList;
                synchronized (ResultManager.this) {
                    ResultManager resultManager = ResultManager.this;
                    resultManager.leftDone = true;
                    if (resultManager.rightDone) {
                        arrayList = new ArrayList(ResultManager.this.leftMap().values());
                        ResultManager.this.leftMap().clear();
                        ResultManager.this.rightMap.clear();
                    } else {
                        arrayList = null;
                    }
                }
                ResultManager.this.complete(arrayList);
            }

            public void onError(Throwable th2) {
                ResultManager.this.errorAll(th2);
            }

            public void onNext(T1 t12) {
                int i11;
                ArrayList<Object> arrayList;
                try {
                    PublishSubject create = PublishSubject.create();
                    SerializedObserver serializedObserver = new SerializedObserver(create);
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i11 = resultManager.leftIds;
                        resultManager.leftIds = i11 + 1;
                        resultManager.leftMap().put(Integer.valueOf(i11), serializedObserver);
                    }
                    Observable unsafeCreate = Observable.unsafeCreate(new WindowObservableFunc(create, ResultManager.this.cancel));
                    LeftDurationObserver leftDurationObserver = new LeftDurationObserver(i11);
                    ResultManager.this.group.add(leftDurationObserver);
                    ((Observable) OnSubscribeGroupJoin.this.leftDuration.call(t12)).unsafeSubscribe(leftDurationObserver);
                    Object call = OnSubscribeGroupJoin.this.resultSelector.call(t12, unsafeCreate);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList<>(ResultManager.this.rightMap.values());
                    }
                    ResultManager.this.subscriber.onNext(call);
                    for (Object onNext : arrayList) {
                        serializedObserver.onNext(onNext);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwOrReport(th2, (Observer<?>) this);
                }
            }
        }

        public final class RightDurationObserver extends Subscriber<D2> {

            /* renamed from: id  reason: collision with root package name */
            public final int f53408id;
            public boolean once = true;

            public RightDurationObserver(int i11) {
                this.f53408id = i11;
            }

            public void onCompleted() {
                if (this.once) {
                    this.once = false;
                    synchronized (ResultManager.this) {
                        ResultManager.this.rightMap.remove(Integer.valueOf(this.f53408id));
                    }
                    ResultManager.this.group.remove(this);
                }
            }

            public void onError(Throwable th2) {
                ResultManager.this.errorMain(th2);
            }

            public void onNext(D2 d22) {
                onCompleted();
            }
        }

        public final class RightObserver extends Subscriber<T2> {
            public RightObserver() {
            }

            public void onCompleted() {
                ArrayList arrayList;
                synchronized (ResultManager.this) {
                    ResultManager resultManager = ResultManager.this;
                    resultManager.rightDone = true;
                    if (resultManager.leftDone) {
                        arrayList = new ArrayList(ResultManager.this.leftMap().values());
                        ResultManager.this.leftMap().clear();
                        ResultManager.this.rightMap.clear();
                    } else {
                        arrayList = null;
                    }
                }
                ResultManager.this.complete(arrayList);
            }

            public void onError(Throwable th2) {
                ResultManager.this.errorAll(th2);
            }

            public void onNext(T2 t22) {
                int i11;
                ArrayList<Observer> arrayList;
                try {
                    synchronized (ResultManager.this) {
                        ResultManager resultManager = ResultManager.this;
                        i11 = resultManager.rightIds;
                        resultManager.rightIds = i11 + 1;
                        resultManager.rightMap.put(Integer.valueOf(i11), t22);
                    }
                    RightDurationObserver rightDurationObserver = new RightDurationObserver(i11);
                    ResultManager.this.group.add(rightDurationObserver);
                    ((Observable) OnSubscribeGroupJoin.this.rightDuration.call(t22)).unsafeSubscribe(rightDurationObserver);
                    synchronized (ResultManager.this) {
                        arrayList = new ArrayList<>(ResultManager.this.leftMap().values());
                    }
                    for (Observer onNext : arrayList) {
                        onNext.onNext(t22);
                    }
                } catch (Throwable th2) {
                    Exceptions.throwOrReport(th2, (Observer<?>) this);
                }
            }
        }

        public ResultManager(Subscriber<? super R> subscriber2) {
            this.subscriber = subscriber2;
            CompositeSubscription compositeSubscription = new CompositeSubscription();
            this.group = compositeSubscription;
            this.cancel = new RefCountSubscription(compositeSubscription);
        }

        public void complete(List<Observer<T2>> list) {
            if (list != null) {
                for (Observer<T2> onCompleted : list) {
                    onCompleted.onCompleted();
                }
                this.subscriber.onCompleted();
                this.cancel.unsubscribe();
            }
        }

        public void errorAll(Throwable th2) {
            ArrayList<Observer> arrayList;
            synchronized (this) {
                arrayList = new ArrayList<>(leftMap().values());
                leftMap().clear();
                this.rightMap.clear();
            }
            for (Observer onError : arrayList) {
                onError.onError(th2);
            }
            this.subscriber.onError(th2);
            this.cancel.unsubscribe();
        }

        public void errorMain(Throwable th2) {
            synchronized (this) {
                leftMap().clear();
                this.rightMap.clear();
            }
            this.subscriber.onError(th2);
            this.cancel.unsubscribe();
        }

        public void init() {
            LeftObserver leftObserver = new LeftObserver();
            RightObserver rightObserver = new RightObserver();
            this.group.add(leftObserver);
            this.group.add(rightObserver);
            OnSubscribeGroupJoin.this.left.unsafeSubscribe(leftObserver);
            OnSubscribeGroupJoin.this.right.unsafeSubscribe(rightObserver);
        }

        public boolean isUnsubscribed() {
            return this.cancel.isUnsubscribed();
        }

        public Map<Integer, Observer<T2>> leftMap() {
            return this;
        }

        public void unsubscribe() {
            this.cancel.unsubscribe();
        }
    }

    public static final class WindowObservableFunc<T> implements Observable.OnSubscribe<T> {
        public final RefCountSubscription refCount;
        public final Observable<T> underlying;

        public final class WindowSubscriber extends Subscriber<T> {
            private final Subscription ref;
            public final Subscriber<? super T> subscriber;

            public WindowSubscriber(Subscriber<? super T> subscriber2, Subscription subscription) {
                super(subscriber2);
                this.subscriber = subscriber2;
                this.ref = subscription;
            }

            public void onCompleted() {
                this.subscriber.onCompleted();
                this.ref.unsubscribe();
            }

            public void onError(Throwable th2) {
                this.subscriber.onError(th2);
                this.ref.unsubscribe();
            }

            public void onNext(T t11) {
                this.subscriber.onNext(t11);
            }
        }

        public WindowObservableFunc(Observable<T> observable, RefCountSubscription refCountSubscription) {
            this.refCount = refCountSubscription;
            this.underlying = observable;
        }

        public void call(Subscriber<? super T> subscriber) {
            Subscription subscription = this.refCount.get();
            WindowSubscriber windowSubscriber = new WindowSubscriber(subscriber, subscription);
            windowSubscriber.add(subscription);
            this.underlying.unsafeSubscribe(windowSubscriber);
        }
    }

    public OnSubscribeGroupJoin(Observable<T1> observable, Observable<T2> observable2, Func1<? super T1, ? extends Observable<D1>> func1, Func1<? super T2, ? extends Observable<D2>> func12, Func2<? super T1, ? super Observable<T2>, ? extends R> func2) {
        this.left = observable;
        this.right = observable2;
        this.leftDuration = func1;
        this.rightDuration = func12;
        this.resultSelector = func2;
    }

    public void call(Subscriber<? super R> subscriber) {
        ResultManager resultManager = new ResultManager(new SerializedSubscriber(subscriber));
        subscriber.add(resultManager);
        resultManager.init();
    }
}
