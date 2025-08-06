package rx.internal.operators;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.Subscription;
import rx.exceptions.Exceptions;
import rx.functions.Func1;
import rx.functions.Func2;
import rx.observers.SerializedSubscriber;
import rx.subscriptions.CompositeSubscription;
import rx.subscriptions.SerialSubscription;

public final class OnSubscribeJoin<TLeft, TRight, TLeftDuration, TRightDuration, R> implements Observable.OnSubscribe<R> {
    public final Observable<TLeft> left;
    public final Func1<TLeft, Observable<TLeftDuration>> leftDurationSelector;
    public final Func2<TLeft, TRight, R> resultSelector;
    public final Observable<TRight> right;
    public final Func1<TRight, Observable<TRightDuration>> rightDurationSelector;

    public final class ResultSink extends HashMap<Integer, TLeft> {
        private static final long serialVersionUID = 3491669543549085380L;
        public final CompositeSubscription group = new CompositeSubscription();
        public boolean leftDone;
        public int leftId;
        public boolean rightDone;
        public int rightId;
        public final Map<Integer, TRight> rightMap = new HashMap();
        public final Subscriber<? super R> subscriber;

        public final class LeftSubscriber extends Subscriber<TLeft> {

            public final class LeftDurationSubscriber extends Subscriber<TLeftDuration> {

                /* renamed from: id  reason: collision with root package name */
                public final int f53409id;
                public boolean once = true;

                public LeftDurationSubscriber(int i11) {
                    this.f53409id = i11;
                }

                public void onCompleted() {
                    if (this.once) {
                        this.once = false;
                        LeftSubscriber.this.expire(this.f53409id, this);
                    }
                }

                public void onError(Throwable th2) {
                    LeftSubscriber.this.onError(th2);
                }

                public void onNext(TLeftDuration tleftduration) {
                    onCompleted();
                }
            }

            public LeftSubscriber() {
            }

            public void expire(int i11, Subscription subscription) {
                boolean z11;
                synchronized (ResultSink.this) {
                    z11 = ResultSink.this.leftMap().remove(Integer.valueOf(i11)) != null && ResultSink.this.leftMap().isEmpty() && ResultSink.this.leftDone;
                }
                if (z11) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.remove(subscription);
            }

            public void onCompleted() {
                boolean z11;
                synchronized (ResultSink.this) {
                    ResultSink resultSink = ResultSink.this;
                    z11 = true;
                    resultSink.leftDone = true;
                    if (!resultSink.rightDone) {
                        if (!resultSink.leftMap().isEmpty()) {
                            z11 = false;
                        }
                    }
                }
                if (z11) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.remove(this);
            }

            public void onError(Throwable th2) {
                ResultSink.this.subscriber.onError(th2);
                ResultSink.this.subscriber.unsubscribe();
            }

            public void onNext(TLeft tleft) {
                int i11;
                ResultSink resultSink;
                int i12;
                synchronized (ResultSink.this) {
                    ResultSink resultSink2 = ResultSink.this;
                    i11 = resultSink2.leftId;
                    resultSink2.leftId = i11 + 1;
                    resultSink2.leftMap().put(Integer.valueOf(i11), tleft);
                    resultSink = ResultSink.this;
                    i12 = resultSink.rightId;
                }
                try {
                    LeftDurationSubscriber leftDurationSubscriber = new LeftDurationSubscriber(i11);
                    ResultSink.this.group.add(leftDurationSubscriber);
                    OnSubscribeJoin.this.leftDurationSelector.call(tleft).unsafeSubscribe(leftDurationSubscriber);
                    ArrayList<Object> arrayList = new ArrayList<>();
                    synchronized (ResultSink.this) {
                        for (Map.Entry next : ResultSink.this.rightMap.entrySet()) {
                            if (((Integer) next.getKey()).intValue() < i12) {
                                arrayList.add(next.getValue());
                            }
                        }
                    }
                    for (Object call : arrayList) {
                        ResultSink.this.subscriber.onNext(OnSubscribeJoin.this.resultSelector.call(tleft, call));
                    }
                } catch (Throwable th2) {
                    Exceptions.throwOrReport(th2, (Observer<?>) this);
                }
            }
        }

        public final class RightSubscriber extends Subscriber<TRight> {

            public final class RightDurationSubscriber extends Subscriber<TRightDuration> {

                /* renamed from: id  reason: collision with root package name */
                public final int f53410id;
                public boolean once = true;

                public RightDurationSubscriber(int i11) {
                    this.f53410id = i11;
                }

                public void onCompleted() {
                    if (this.once) {
                        this.once = false;
                        RightSubscriber.this.expire(this.f53410id, this);
                    }
                }

                public void onError(Throwable th2) {
                    RightSubscriber.this.onError(th2);
                }

                public void onNext(TRightDuration trightduration) {
                    onCompleted();
                }
            }

            public RightSubscriber() {
            }

            public void expire(int i11, Subscription subscription) {
                boolean z11;
                synchronized (ResultSink.this) {
                    z11 = ResultSink.this.rightMap.remove(Integer.valueOf(i11)) != null && ResultSink.this.rightMap.isEmpty() && ResultSink.this.rightDone;
                }
                if (z11) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.remove(subscription);
            }

            public void onCompleted() {
                boolean z11;
                synchronized (ResultSink.this) {
                    ResultSink resultSink = ResultSink.this;
                    z11 = true;
                    resultSink.rightDone = true;
                    if (!resultSink.leftDone) {
                        if (!resultSink.rightMap.isEmpty()) {
                            z11 = false;
                        }
                    }
                }
                if (z11) {
                    ResultSink.this.subscriber.onCompleted();
                    ResultSink.this.subscriber.unsubscribe();
                    return;
                }
                ResultSink.this.group.remove(this);
            }

            public void onError(Throwable th2) {
                ResultSink.this.subscriber.onError(th2);
                ResultSink.this.subscriber.unsubscribe();
            }

            public void onNext(TRight tright) {
                int i11;
                int i12;
                synchronized (ResultSink.this) {
                    ResultSink resultSink = ResultSink.this;
                    i11 = resultSink.rightId;
                    resultSink.rightId = i11 + 1;
                    resultSink.rightMap.put(Integer.valueOf(i11), tright);
                    i12 = ResultSink.this.leftId;
                }
                ResultSink.this.group.add(new SerialSubscription());
                try {
                    RightDurationSubscriber rightDurationSubscriber = new RightDurationSubscriber(i11);
                    ResultSink.this.group.add(rightDurationSubscriber);
                    OnSubscribeJoin.this.rightDurationSelector.call(tright).unsafeSubscribe(rightDurationSubscriber);
                    ArrayList<Object> arrayList = new ArrayList<>();
                    synchronized (ResultSink.this) {
                        for (Map.Entry entry : ResultSink.this.leftMap().entrySet()) {
                            if (((Integer) entry.getKey()).intValue() < i12) {
                                arrayList.add(entry.getValue());
                            }
                        }
                    }
                    for (Object call : arrayList) {
                        ResultSink.this.subscriber.onNext(OnSubscribeJoin.this.resultSelector.call(call, tright));
                    }
                } catch (Throwable th2) {
                    Exceptions.throwOrReport(th2, (Observer<?>) this);
                }
            }
        }

        public ResultSink(Subscriber<? super R> subscriber2) {
            this.subscriber = subscriber2;
        }

        public HashMap<Integer, TLeft> leftMap() {
            return this;
        }

        public void run() {
            this.subscriber.add(this.group);
            LeftSubscriber leftSubscriber = new LeftSubscriber();
            RightSubscriber rightSubscriber = new RightSubscriber();
            this.group.add(leftSubscriber);
            this.group.add(rightSubscriber);
            OnSubscribeJoin.this.left.unsafeSubscribe(leftSubscriber);
            OnSubscribeJoin.this.right.unsafeSubscribe(rightSubscriber);
        }
    }

    public OnSubscribeJoin(Observable<TLeft> observable, Observable<TRight> observable2, Func1<TLeft, Observable<TLeftDuration>> func1, Func1<TRight, Observable<TRightDuration>> func12, Func2<TLeft, TRight, R> func2) {
        this.left = observable;
        this.right = observable2;
        this.leftDurationSelector = func1;
        this.rightDurationSelector = func12;
        this.resultSelector = func2;
    }

    public void call(Subscriber<? super R> subscriber) {
        new ResultSink(new SerializedSubscriber(subscriber)).run();
    }
}
