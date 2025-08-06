package io.reactivex.rxjava3.internal.operators.flowable;

import java.util.Iterator;
import k00.a;

final class FlowableFromIterable$IteratorConditionalSubscription<T> extends FlowableFromIterable$BaseRangeSubscription<T> {
    private static final long serialVersionUID = -6022804456014692607L;
    public final a<? super T> downstream;

    public FlowableFromIterable$IteratorConditionalSubscription(a<? super T> aVar, Iterator<? extends T> it2) {
        super(it2);
        this.downstream = aVar;
    }

    public void fastPath() {
        Iterator<? extends T> it2 = this.iterator;
        a<? super T> aVar = this.downstream;
        while (!this.cancelled) {
            try {
                Object next = it2.next();
                if (!this.cancelled) {
                    if (next == null) {
                        aVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                        return;
                    }
                    aVar.tryOnNext(next);
                    if (!this.cancelled) {
                        try {
                            if (!it2.hasNext()) {
                                if (!this.cancelled) {
                                    aVar.onComplete();
                                    return;
                                }
                                return;
                            }
                        } catch (Throwable th2) {
                            io.reactivex.rxjava3.exceptions.a.b(th2);
                            aVar.onError(th2);
                            return;
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            } catch (Throwable th3) {
                io.reactivex.rxjava3.exceptions.a.b(th3);
                aVar.onError(th3);
                return;
            }
        }
    }

    public void slowPath(long j11) {
        Iterator<? extends T> it2 = this.iterator;
        a<? super T> aVar = this.downstream;
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
                                aVar.onError(new NullPointerException("Iterator.next() returned a null value"));
                                return;
                            }
                            boolean tryOnNext = aVar.tryOnNext(next);
                            if (!this.cancelled) {
                                try {
                                    if (!it2.hasNext()) {
                                        if (!this.cancelled) {
                                            aVar.onComplete();
                                            return;
                                        }
                                        return;
                                    } else if (tryOnNext) {
                                        j12++;
                                    }
                                } catch (Throwable th2) {
                                    io.reactivex.rxjava3.exceptions.a.b(th2);
                                    aVar.onError(th2);
                                    return;
                                }
                            } else {
                                return;
                            }
                        } else {
                            return;
                        }
                    } catch (Throwable th3) {
                        io.reactivex.rxjava3.exceptions.a.b(th3);
                        aVar.onError(th3);
                        return;
                    }
                } else {
                    return;
                }
            }
        } while (j11 != 0);
    }
}
