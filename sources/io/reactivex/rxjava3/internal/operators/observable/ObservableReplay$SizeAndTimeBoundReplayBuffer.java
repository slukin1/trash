package io.reactivex.rxjava3.internal.operators.observable;

import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.util.concurrent.TimeUnit;
import p00.b;

final class ObservableReplay$SizeAndTimeBoundReplayBuffer<T> extends ObservableReplay$BoundedReplayBuffer<T> {
    private static final long serialVersionUID = 3457957419649567404L;
    public final int limit;
    public final long maxAge;
    public final Scheduler scheduler;
    public final TimeUnit unit;

    public ObservableReplay$SizeAndTimeBoundReplayBuffer(int i11, long j11, TimeUnit timeUnit, Scheduler scheduler2, boolean z11) {
        super(z11);
        this.scheduler = scheduler2;
        this.limit = i11;
        this.maxAge = j11;
        this.unit = timeUnit;
    }

    public Object enterTransform(Object obj) {
        return new b(obj, this.scheduler.b(this.unit), this.unit);
    }

    public ObservableReplay$Node getHead() {
        ObservableReplay$Node observableReplay$Node;
        long b11 = this.scheduler.b(this.unit) - this.maxAge;
        ObservableReplay$Node observableReplay$Node2 = (ObservableReplay$Node) get();
        Object obj = observableReplay$Node2.get();
        while (true) {
            ObservableReplay$Node observableReplay$Node3 = (ObservableReplay$Node) obj;
            observableReplay$Node = observableReplay$Node2;
            observableReplay$Node2 = observableReplay$Node3;
            if (observableReplay$Node2 != null) {
                b bVar = (b) observableReplay$Node2.value;
                if (NotificationLite.isComplete(bVar.b()) || NotificationLite.isError(bVar.b()) || bVar.a() > b11) {
                    break;
                }
                obj = observableReplay$Node2.get();
            } else {
                break;
            }
        }
        return observableReplay$Node;
    }

    public Object leaveTransform(Object obj) {
        return ((b) obj).b();
    }

    public void truncate() {
        ObservableReplay$Node observableReplay$Node;
        long b11 = this.scheduler.b(this.unit) - this.maxAge;
        ObservableReplay$Node observableReplay$Node2 = (ObservableReplay$Node) get();
        ObservableReplay$Node observableReplay$Node3 = (ObservableReplay$Node) observableReplay$Node2.get();
        int i11 = 0;
        while (true) {
            ObservableReplay$Node observableReplay$Node4 = observableReplay$Node3;
            observableReplay$Node = observableReplay$Node2;
            observableReplay$Node2 = observableReplay$Node4;
            int i12 = this.size;
            if (i12 > 1) {
                if (i12 <= this.limit) {
                    if (((b) observableReplay$Node2.value).a() > b11) {
                        break;
                    }
                    i11++;
                    this.size--;
                    observableReplay$Node3 = (ObservableReplay$Node) observableReplay$Node2.get();
                } else {
                    i11++;
                    this.size = i12 - 1;
                    observableReplay$Node3 = (ObservableReplay$Node) observableReplay$Node2.get();
                }
            } else {
                break;
            }
        }
        if (i11 != 0) {
            setFirst(observableReplay$Node);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x003c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void truncateFinal() {
        /*
            r10 = this;
            io.reactivex.rxjava3.core.Scheduler r0 = r10.scheduler
            java.util.concurrent.TimeUnit r1 = r10.unit
            long r0 = r0.b(r1)
            long r2 = r10.maxAge
            long r0 = r0 - r2
            java.lang.Object r2 = r10.get()
            io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$Node r2 = (io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$Node) r2
            java.lang.Object r3 = r2.get()
            io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$Node r3 = (io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$Node) r3
            r4 = 0
        L_0x0018:
            r9 = r3
            r3 = r2
            r2 = r9
            int r5 = r10.size
            r6 = 1
            if (r5 <= r6) goto L_0x003a
            java.lang.Object r5 = r2.value
            p00.b r5 = (p00.b) r5
            long r7 = r5.a()
            int r5 = (r7 > r0 ? 1 : (r7 == r0 ? 0 : -1))
            if (r5 > 0) goto L_0x003a
            int r4 = r4 + 1
            int r3 = r10.size
            int r3 = r3 - r6
            r10.size = r3
            java.lang.Object r3 = r2.get()
            io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$Node r3 = (io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$Node) r3
            goto L_0x0018
        L_0x003a:
            if (r4 == 0) goto L_0x003f
            r10.setFirst(r3)
        L_0x003f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.operators.observable.ObservableReplay$SizeAndTimeBoundReplayBuffer.truncateFinal():void");
    }
}
