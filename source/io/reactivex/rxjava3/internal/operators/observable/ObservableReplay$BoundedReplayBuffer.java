package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicReference;

abstract class ObservableReplay$BoundedReplayBuffer<T> extends AtomicReference<ObservableReplay$Node> implements f<T> {
    private static final long serialVersionUID = 2346567790059478686L;
    public final boolean eagerTruncate;
    public int size;
    public ObservableReplay$Node tail;

    public ObservableReplay$BoundedReplayBuffer(boolean z11) {
        this.eagerTruncate = z11;
        ObservableReplay$Node observableReplay$Node = new ObservableReplay$Node((Object) null);
        this.tail = observableReplay$Node;
        set(observableReplay$Node);
    }

    public final void addLast(ObservableReplay$Node observableReplay$Node) {
        this.tail.set(observableReplay$Node);
        this.tail = observableReplay$Node;
        this.size++;
    }

    public final void collect(Collection<? super T> collection) {
        ObservableReplay$Node head = getHead();
        while (true) {
            head = (ObservableReplay$Node) head.get();
            if (head != null) {
                Object leaveTransform = leaveTransform(head.value);
                if (!NotificationLite.isComplete(leaveTransform) && !NotificationLite.isError(leaveTransform)) {
                    collection.add(NotificationLite.getValue(leaveTransform));
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final void complete() {
        addLast(new ObservableReplay$Node(enterTransform(NotificationLite.complete())));
        truncateFinal();
    }

    public Object enterTransform(Object obj) {
        return obj;
    }

    public final void error(Throwable th2) {
        addLast(new ObservableReplay$Node(enterTransform(NotificationLite.error(th2))));
        truncateFinal();
    }

    public ObservableReplay$Node getHead() {
        return (ObservableReplay$Node) get();
    }

    public boolean hasCompleted() {
        Object obj = this.tail.value;
        return obj != null && NotificationLite.isComplete(leaveTransform(obj));
    }

    public boolean hasError() {
        Object obj = this.tail.value;
        return obj != null && NotificationLite.isError(leaveTransform(obj));
    }

    public Object leaveTransform(Object obj) {
        return obj;
    }

    public final void next(T t11) {
        addLast(new ObservableReplay$Node(enterTransform(NotificationLite.next(t11))));
        truncate();
    }

    public final void removeFirst() {
        this.size--;
        setFirst((ObservableReplay$Node) ((ObservableReplay$Node) get()).get());
    }

    public final void removeSome(int i11) {
        ObservableReplay$Node observableReplay$Node = (ObservableReplay$Node) get();
        while (i11 > 0) {
            observableReplay$Node = (ObservableReplay$Node) observableReplay$Node.get();
            i11--;
            this.size--;
        }
        setFirst(observableReplay$Node);
        ObservableReplay$Node observableReplay$Node2 = (ObservableReplay$Node) get();
        if (observableReplay$Node2.get() == null) {
            this.tail = observableReplay$Node2;
        }
    }

    public final void replay(ObservableReplay$InnerDisposable<T> observableReplay$InnerDisposable) {
        if (observableReplay$InnerDisposable.getAndIncrement() == 0) {
            int i11 = 1;
            do {
                ObservableReplay$Node observableReplay$Node = (ObservableReplay$Node) observableReplay$InnerDisposable.index();
                if (observableReplay$Node == null) {
                    observableReplay$Node = getHead();
                    observableReplay$InnerDisposable.index = observableReplay$Node;
                }
                while (!observableReplay$InnerDisposable.isDisposed()) {
                    ObservableReplay$Node observableReplay$Node2 = (ObservableReplay$Node) observableReplay$Node.get();
                    if (observableReplay$Node2 == null) {
                        observableReplay$InnerDisposable.index = observableReplay$Node;
                        i11 = observableReplay$InnerDisposable.addAndGet(-i11);
                    } else if (NotificationLite.accept(leaveTransform(observableReplay$Node2.value), observableReplay$InnerDisposable.child)) {
                        observableReplay$InnerDisposable.index = null;
                        return;
                    } else {
                        observableReplay$Node = observableReplay$Node2;
                    }
                }
                observableReplay$InnerDisposable.index = null;
                return;
            } while (i11 != 0);
        }
    }

    public final void setFirst(ObservableReplay$Node observableReplay$Node) {
        if (this.eagerTruncate) {
            ObservableReplay$Node observableReplay$Node2 = new ObservableReplay$Node((Object) null);
            observableReplay$Node2.lazySet(observableReplay$Node.get());
            observableReplay$Node = observableReplay$Node2;
        }
        set(observableReplay$Node);
    }

    public final void trimHead() {
        ObservableReplay$Node observableReplay$Node = (ObservableReplay$Node) get();
        if (observableReplay$Node.value != null) {
            ObservableReplay$Node observableReplay$Node2 = new ObservableReplay$Node((Object) null);
            observableReplay$Node2.lazySet(observableReplay$Node.get());
            set(observableReplay$Node2);
        }
    }

    public abstract void truncate();

    public void truncateFinal() {
        trimHead();
    }
}
