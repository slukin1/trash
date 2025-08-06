package rx.internal.operators;

import java.util.LinkedList;
import java.util.List;
import rx.Observable;
import rx.Observer;
import rx.Subscriber;
import rx.functions.Func1;
import rx.observers.SerializedObserver;
import rx.observers.SerializedSubscriber;
import rx.subjects.UnicastSubject;
import rx.subscriptions.CompositeSubscription;

public final class OperatorWindowWithStartEndObservable<T, U, V> implements Observable.Operator<Observable<T>, T> {
    public final Func1<? super U, ? extends Observable<? extends V>> windowClosingSelector;
    public final Observable<? extends U> windowOpenings;

    public static final class SerializedSubject<T> {
        public final Observer<T> consumer;
        public final Observable<T> producer;

        public SerializedSubject(Observer<T> observer, Observable<T> observable) {
            this.consumer = new SerializedObserver(observer);
            this.producer = observable;
        }
    }

    public final class SourceSubscriber extends Subscriber<T> {
        public final Subscriber<? super Observable<T>> child;
        public final List<SerializedSubject<T>> chunks = new LinkedList();
        public final CompositeSubscription composite;
        public boolean done;
        public final Object guard = new Object();

        public SourceSubscriber(Subscriber<? super Observable<T>> subscriber, CompositeSubscription compositeSubscription) {
            this.child = new SerializedSubscriber(subscriber);
            this.composite = compositeSubscription;
        }

        public void beginWindow(U u11) {
            final SerializedSubject createSerializedSubject = createSerializedSubject();
            synchronized (this.guard) {
                if (!this.done) {
                    this.chunks.add(createSerializedSubject);
                    this.child.onNext(createSerializedSubject.producer);
                    try {
                        Observable observable = (Observable) OperatorWindowWithStartEndObservable.this.windowClosingSelector.call(u11);
                        AnonymousClass1 r12 = new Subscriber<V>() {
                            public boolean once = true;

                            public void onCompleted() {
                                if (this.once) {
                                    this.once = false;
                                    SourceSubscriber.this.endWindow(createSerializedSubject);
                                    SourceSubscriber.this.composite.remove(this);
                                }
                            }

                            public void onError(Throwable th2) {
                                SourceSubscriber.this.onError(th2);
                            }

                            public void onNext(V v11) {
                                onCompleted();
                            }
                        };
                        this.composite.add(r12);
                        observable.unsafeSubscribe(r12);
                    } catch (Throwable th2) {
                        onError(th2);
                    }
                }
            }
        }

        public SerializedSubject<T> createSerializedSubject() {
            UnicastSubject create = UnicastSubject.create();
            return new SerializedSubject<>(create, create);
        }

        /* JADX WARNING: Code restructure failed: missing block: B:15:0x0024, code lost:
            if (r2 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
            r4.consumer.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void endWindow(rx.internal.operators.OperatorWindowWithStartEndObservable.SerializedSubject<T> r4) {
            /*
                r3 = this;
                java.lang.Object r0 = r3.guard
                monitor-enter(r0)
                boolean r1 = r3.done     // Catch:{ all -> 0x002c }
                if (r1 == 0) goto L_0x0009
                monitor-exit(r0)     // Catch:{ all -> 0x002c }
                return
            L_0x0009:
                java.util.List<rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject<T>> r1 = r3.chunks     // Catch:{ all -> 0x002c }
                java.util.Iterator r1 = r1.iterator()     // Catch:{ all -> 0x002c }
            L_0x000f:
                boolean r2 = r1.hasNext()     // Catch:{ all -> 0x002c }
                if (r2 == 0) goto L_0x0022
                java.lang.Object r2 = r1.next()     // Catch:{ all -> 0x002c }
                rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject r2 = (rx.internal.operators.OperatorWindowWithStartEndObservable.SerializedSubject) r2     // Catch:{ all -> 0x002c }
                if (r2 != r4) goto L_0x000f
                r2 = 1
                r1.remove()     // Catch:{ all -> 0x002c }
                goto L_0x0023
            L_0x0022:
                r2 = 0
            L_0x0023:
                monitor-exit(r0)     // Catch:{ all -> 0x002c }
                if (r2 == 0) goto L_0x002b
                rx.Observer<T> r4 = r4.consumer
                r4.onCompleted()
            L_0x002b:
                return
            L_0x002c:
                r4 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002c }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithStartEndObservable.SourceSubscriber.endWindow(rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
            r0 = r1.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
            if (r0.hasNext() == false) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0028, code lost:
            ((rx.internal.operators.OperatorWindowWithStartEndObservable.SerializedSubject) r0.next()).consumer.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
            r3.child.onCompleted();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
            r3.composite.unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003e, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onCompleted() {
            /*
                r3 = this;
                java.lang.Object r0 = r3.guard     // Catch:{ all -> 0x0042 }
                monitor-enter(r0)     // Catch:{ all -> 0x0042 }
                boolean r1 = r3.done     // Catch:{ all -> 0x003f }
                if (r1 == 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x003f }
                rx.subscriptions.CompositeSubscription r0 = r3.composite
                r0.unsubscribe()
                return
            L_0x000e:
                r1 = 1
                r3.done = r1     // Catch:{ all -> 0x003f }
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x003f }
                java.util.List<rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject<T>> r2 = r3.chunks     // Catch:{ all -> 0x003f }
                r1.<init>(r2)     // Catch:{ all -> 0x003f }
                java.util.List<rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject<T>> r2 = r3.chunks     // Catch:{ all -> 0x003f }
                r2.clear()     // Catch:{ all -> 0x003f }
                monitor-exit(r0)     // Catch:{ all -> 0x003f }
                java.util.Iterator r0 = r1.iterator()     // Catch:{ all -> 0x0042 }
            L_0x0022:
                boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0042 }
                if (r1 == 0) goto L_0x0034
                java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0042 }
                rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject r1 = (rx.internal.operators.OperatorWindowWithStartEndObservable.SerializedSubject) r1     // Catch:{ all -> 0x0042 }
                rx.Observer<T> r1 = r1.consumer     // Catch:{ all -> 0x0042 }
                r1.onCompleted()     // Catch:{ all -> 0x0042 }
                goto L_0x0022
            L_0x0034:
                rx.Subscriber<? super rx.Observable<T>> r0 = r3.child     // Catch:{ all -> 0x0042 }
                r0.onCompleted()     // Catch:{ all -> 0x0042 }
                rx.subscriptions.CompositeSubscription r0 = r3.composite
                r0.unsubscribe()
                return
            L_0x003f:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x003f }
                throw r1     // Catch:{ all -> 0x0042 }
            L_0x0042:
                r0 = move-exception
                rx.subscriptions.CompositeSubscription r1 = r3.composite
                r1.unsubscribe()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithStartEndObservable.SourceSubscriber.onCompleted():void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
            r0 = r1.iterator();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:16:0x0026, code lost:
            if (r0.hasNext() == false) goto L_0x0034;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:17:0x0028, code lost:
            ((rx.internal.operators.OperatorWindowWithStartEndObservable.SerializedSubject) r0.next()).consumer.onError(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0034, code lost:
            r3.child.onError(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0039, code lost:
            r3.composite.unsubscribe();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x003e, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onError(java.lang.Throwable r4) {
            /*
                r3 = this;
                java.lang.Object r0 = r3.guard     // Catch:{ all -> 0x0042 }
                monitor-enter(r0)     // Catch:{ all -> 0x0042 }
                boolean r1 = r3.done     // Catch:{ all -> 0x003f }
                if (r1 == 0) goto L_0x000e
                monitor-exit(r0)     // Catch:{ all -> 0x003f }
                rx.subscriptions.CompositeSubscription r4 = r3.composite
                r4.unsubscribe()
                return
            L_0x000e:
                r1 = 1
                r3.done = r1     // Catch:{ all -> 0x003f }
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x003f }
                java.util.List<rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject<T>> r2 = r3.chunks     // Catch:{ all -> 0x003f }
                r1.<init>(r2)     // Catch:{ all -> 0x003f }
                java.util.List<rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject<T>> r2 = r3.chunks     // Catch:{ all -> 0x003f }
                r2.clear()     // Catch:{ all -> 0x003f }
                monitor-exit(r0)     // Catch:{ all -> 0x003f }
                java.util.Iterator r0 = r1.iterator()     // Catch:{ all -> 0x0042 }
            L_0x0022:
                boolean r1 = r0.hasNext()     // Catch:{ all -> 0x0042 }
                if (r1 == 0) goto L_0x0034
                java.lang.Object r1 = r0.next()     // Catch:{ all -> 0x0042 }
                rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject r1 = (rx.internal.operators.OperatorWindowWithStartEndObservable.SerializedSubject) r1     // Catch:{ all -> 0x0042 }
                rx.Observer<T> r1 = r1.consumer     // Catch:{ all -> 0x0042 }
                r1.onError(r4)     // Catch:{ all -> 0x0042 }
                goto L_0x0022
            L_0x0034:
                rx.Subscriber<? super rx.Observable<T>> r0 = r3.child     // Catch:{ all -> 0x0042 }
                r0.onError(r4)     // Catch:{ all -> 0x0042 }
                rx.subscriptions.CompositeSubscription r4 = r3.composite
                r4.unsubscribe()
                return
            L_0x003f:
                r4 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x003f }
                throw r4     // Catch:{ all -> 0x0042 }
            L_0x0042:
                r4 = move-exception
                rx.subscriptions.CompositeSubscription r0 = r3.composite
                r0.unsubscribe()
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithStartEndObservable.SourceSubscriber.onError(java.lang.Throwable):void");
        }

        /* JADX WARNING: Code restructure failed: missing block: B:11:0x0019, code lost:
            if (r0.hasNext() == false) goto L_0x0027;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:0x001b, code lost:
            ((rx.internal.operators.OperatorWindowWithStartEndObservable.SerializedSubject) r0.next()).consumer.onNext(r4);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:0x0027, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x0011, code lost:
            r0 = r1.iterator();
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onNext(T r4) {
            /*
                r3 = this;
                java.lang.Object r0 = r3.guard
                monitor-enter(r0)
                boolean r1 = r3.done     // Catch:{ all -> 0x0028 }
                if (r1 == 0) goto L_0x0009
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                return
            L_0x0009:
                java.util.ArrayList r1 = new java.util.ArrayList     // Catch:{ all -> 0x0028 }
                java.util.List<rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject<T>> r2 = r3.chunks     // Catch:{ all -> 0x0028 }
                r1.<init>(r2)     // Catch:{ all -> 0x0028 }
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                java.util.Iterator r0 = r1.iterator()
            L_0x0015:
                boolean r1 = r0.hasNext()
                if (r1 == 0) goto L_0x0027
                java.lang.Object r1 = r0.next()
                rx.internal.operators.OperatorWindowWithStartEndObservable$SerializedSubject r1 = (rx.internal.operators.OperatorWindowWithStartEndObservable.SerializedSubject) r1
                rx.Observer<T> r1 = r1.consumer
                r1.onNext(r4)
                goto L_0x0015
            L_0x0027:
                return
            L_0x0028:
                r4 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0028 }
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: rx.internal.operators.OperatorWindowWithStartEndObservable.SourceSubscriber.onNext(java.lang.Object):void");
        }

        public void onStart() {
            request(Long.MAX_VALUE);
        }
    }

    public OperatorWindowWithStartEndObservable(Observable<? extends U> observable, Func1<? super U, ? extends Observable<? extends V>> func1) {
        this.windowOpenings = observable;
        this.windowClosingSelector = func1;
    }

    public Subscriber<? super T> call(Subscriber<? super Observable<T>> subscriber) {
        CompositeSubscription compositeSubscription = new CompositeSubscription();
        subscriber.add(compositeSubscription);
        final SourceSubscriber sourceSubscriber = new SourceSubscriber(subscriber, compositeSubscription);
        AnonymousClass1 r32 = new Subscriber<U>() {
            public void onCompleted() {
                sourceSubscriber.onCompleted();
            }

            public void onError(Throwable th2) {
                sourceSubscriber.onError(th2);
            }

            public void onNext(U u11) {
                sourceSubscriber.beginWindow(u11);
            }

            public void onStart() {
                request(Long.MAX_VALUE);
            }
        };
        compositeSubscription.add(sourceSubscriber);
        compositeSubscription.add(r32);
        this.windowOpenings.unsafeSubscribe(r32);
        return sourceSubscriber;
    }
}
