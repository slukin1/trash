package io.reactivex.rxjava3.processors;

import io.reactivex.rxjava3.internal.subscriptions.SubscriptionHelper;
import io.reactivex.rxjava3.internal.util.b;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;
import z20.c;
import z20.d;

public final class ReplayProcessor<T> extends FlowableProcessor<T> {

    public static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        public final T value;

        public Node(T t11) {
            this.value = t11;
        }
    }

    public static final class ReplaySubscription<T> extends AtomicInteger implements d {
        private static final long serialVersionUID = 466549804534799122L;
        public volatile boolean cancelled;
        public final c<? super T> downstream;
        public long emitted;
        public Object index;
        public final AtomicLong requested = new AtomicLong();
        public final ReplayProcessor<T> state;

        public ReplaySubscription(c<? super T> cVar, ReplayProcessor<T> replayProcessor) {
            this.downstream = cVar;
        }

        public void cancel() {
            if (!this.cancelled) {
                this.cancelled = true;
                throw null;
            }
        }

        public void request(long j11) {
            if (SubscriptionHelper.validate(j11)) {
                b.a(this.requested, j11);
                throw null;
            }
        }
    }

    public static final class TimedNode<T> extends AtomicReference<TimedNode<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        public final long time;
        public final T value;

        public TimedNode(T t11, long j11) {
            this.value = t11;
            this.time = j11;
        }
    }
}
