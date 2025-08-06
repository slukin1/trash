package io.reactivex.rxjava3.internal.operators.observable;

import h00.k;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.ArrayList;

final class ObservableReplay$UnboundedReplayBuffer<T> extends ArrayList<Object> implements f<T> {
    private static final long serialVersionUID = 7063189396499112664L;
    public volatile int size;

    public ObservableReplay$UnboundedReplayBuffer(int i11) {
        super(i11);
    }

    public void complete() {
        add(NotificationLite.complete());
        this.size++;
    }

    public void error(Throwable th2) {
        add(NotificationLite.error(th2));
        this.size++;
    }

    public void next(T t11) {
        add(NotificationLite.next(t11));
        this.size++;
    }

    public void replay(ObservableReplay$InnerDisposable<T> observableReplay$InnerDisposable) {
        if (observableReplay$InnerDisposable.getAndIncrement() == 0) {
            k<? super T> kVar = observableReplay$InnerDisposable.child;
            int i11 = 1;
            while (!observableReplay$InnerDisposable.isDisposed()) {
                int i12 = this.size;
                Integer num = (Integer) observableReplay$InnerDisposable.index();
                int intValue = num != null ? num.intValue() : 0;
                while (intValue < i12) {
                    if (!NotificationLite.accept(get(intValue), kVar) && !observableReplay$InnerDisposable.isDisposed()) {
                        intValue++;
                    } else {
                        return;
                    }
                }
                observableReplay$InnerDisposable.index = Integer.valueOf(intValue);
                i11 = observableReplay$InnerDisposable.addAndGet(-i11);
                if (i11 == 0) {
                    return;
                }
            }
        }
    }
}
