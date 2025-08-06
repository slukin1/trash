package io.reactivex.rxjava3.internal.operators.flowable;

import io.reactivex.rxjava3.exceptions.a;
import java.util.Iterator;
import z20.c;

final class FlowableFromIterable$IteratorSubscription<T> extends FlowableFromIterable$BaseRangeSubscription<T> {
    private static final long serialVersionUID = -6022804456014692607L;
    public final c<? super T> downstream;

    public FlowableFromIterable$IteratorSubscription(c<? super T> cVar, Iterator<? extends T> it2) {
        super(it2);
        this.downstream = cVar;
    }

    public void fastPath() {
        Iterator<? extends T> it2 = this.iterator;
        c<? super T> cVar = this.downstream;
        while (!this.cancelled) {
            try {
                Object next = it2.next();
                if (!this.cancelled) {
                    if (next == null) {
                        cVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    cVar.onNext(next);
                    if (!this.cancelled) {
                        try {
                            if (!it2.hasNext()) {
                                if (!this.cancelled) {
                                    cVar.onComplete();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th2) {
                            a.b(th2);
                            cVar.onError(th2);
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th3) {
                a.b(th3);
                cVar.onError(th3);
                return;
            }
        }
    }

    public void slowPath(long j11) {
        Iterator<? extends T> it2 = this.iterator;
        c<? super T> cVar = this.downstream;
        do {
            long j12 = 0;
            while (true) {
                if (j12 == j11) {
                    j11 = get();
                    if (j12 == j11) {
                        j11 = addAndGet(-j12);
                    }
                } else if (!this.cancelled) {
                    try {
                        Object next = it2.next();
                        if (!this.cancelled) {
                            if (next == null) {
                                cVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                                return;
                            }
                            cVar.onNext(next);
                            if (!this.cancelled) {
                                try {
                                    if (it2.hasNext()) {
                                        j12++;
                                    } else if (!this.cancelled) {
                                        cVar.onComplete();
                                        return;
                                    } else {
                                        return;
                                    }
                                } catch (Throwable th2) {
                                    a.b(th2);
                                    cVar.onError(th2);
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th3) {
                        a.b(th3);
                        cVar.onError(th3);
                        return;
                    }
                } else {
                    return;
                }
            }
        } while (j11 != 0);
    }
}
