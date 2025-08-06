package io.reactivex.rxjava3.subjects;

import h00.k;
import io.reactivex.rxjava3.core.Scheduler;
import io.reactivex.rxjava3.disposables.b;
import io.reactivex.rxjava3.internal.util.NotificationLite;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class ReplaySubject<T> extends Subject<T> {

    public static final class Node<T> extends AtomicReference<Node<T>> {
        private static final long serialVersionUID = 6404226426336033100L;
        public final T value;

        public Node(T t11) {
            this.value = t11;
        }
    }

    public static final class ReplayDisposable<T> extends AtomicInteger implements b {
        private static final long serialVersionUID = 466549804534799122L;
        public volatile boolean cancelled;
        public final k<? super T> downstream;
        public Object index;
        public final ReplaySubject<T> state;

        public ReplayDisposable(k<? super T> kVar, ReplaySubject<T> replaySubject) {
            this.downstream = kVar;
        }

        public void dispose() {
            if (!this.cancelled) {
                this.cancelled = true;
                throw null;
            }
        }

        public boolean isDisposed() {
            return this.cancelled;
        }
    }

    public static final class SizeAndTimeBoundReplayBuffer<T> extends AtomicReference<Object> {
        private static final long serialVersionUID = -8056260896137901749L;
        public volatile boolean done;
        public volatile TimedNode<Object> head;
        public final long maxAge;
        public final int maxSize;
        public final Scheduler scheduler;
        public int size;
        public TimedNode<Object> tail;
        public final TimeUnit unit;

        public SizeAndTimeBoundReplayBuffer(int i11, long j11, TimeUnit timeUnit, Scheduler scheduler2) {
            this.maxSize = i11;
            this.maxAge = j11;
            this.unit = timeUnit;
            this.scheduler = scheduler2;
            TimedNode<Object> timedNode = new TimedNode<>(null, 0);
            this.tail = timedNode;
            this.head = timedNode;
        }

        public void add(T t11) {
            TimedNode<Object> timedNode = new TimedNode<>(t11, this.scheduler.b(this.unit));
            TimedNode<Object> timedNode2 = this.tail;
            this.tail = timedNode;
            this.size++;
            timedNode2.set(timedNode);
            trim();
        }

        public void addFinal(Object obj) {
            TimedNode<Object> timedNode = new TimedNode<>(obj, Long.MAX_VALUE);
            TimedNode<Object> timedNode2 = this.tail;
            this.tail = timedNode;
            this.size++;
            timedNode2.lazySet(timedNode);
            trimFinal();
            this.done = true;
        }

        public TimedNode<Object> getHead() {
            TimedNode<Object> timedNode;
            TimedNode<Object> timedNode2 = this.head;
            long b11 = this.scheduler.b(this.unit) - this.maxAge;
            Object obj = timedNode2.get();
            while (true) {
                TimedNode<Object> timedNode3 = (TimedNode) obj;
                timedNode = timedNode2;
                timedNode2 = timedNode3;
                if (timedNode2 == null || timedNode2.time > b11) {
                    return timedNode;
                }
                obj = timedNode2.get();
            }
            return timedNode;
        }

        public T getValue() {
            T t11;
            TimedNode<Object> timedNode = this.head;
            TimedNode<Object> timedNode2 = null;
            while (true) {
                TimedNode<Object> timedNode3 = (TimedNode) timedNode.get();
                if (timedNode3 == null) {
                    break;
                }
                timedNode2 = timedNode;
                timedNode = timedNode3;
            }
            if (timedNode.time < this.scheduler.b(this.unit) - this.maxAge || (t11 = timedNode.value) == null) {
                return null;
            }
            if (NotificationLite.isComplete(t11) || NotificationLite.isError(t11)) {
                return timedNode2.value;
            }
            return t11;
        }

        public T[] getValues(T[] tArr) {
            TimedNode<Object> head2 = getHead();
            int size2 = size(head2);
            if (size2 != 0) {
                if (tArr.length < size2) {
                    tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size2);
                }
                for (int i11 = 0; i11 != size2; i11++) {
                    head2 = (TimedNode) head2.get();
                    tArr[i11] = head2.value;
                }
                if (tArr.length > size2) {
                    tArr[size2] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        public void replay(ReplayDisposable<T> replayDisposable) {
            if (replayDisposable.getAndIncrement() == 0) {
                k<? super T> kVar = replayDisposable.downstream;
                TimedNode<Object> timedNode = (TimedNode) replayDisposable.index;
                if (timedNode == null) {
                    timedNode = getHead();
                }
                int i11 = 1;
                while (!replayDisposable.cancelled) {
                    TimedNode<Object> timedNode2 = (TimedNode) timedNode.get();
                    if (timedNode2 == null) {
                        replayDisposable.index = timedNode;
                        i11 = replayDisposable.addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    } else {
                        T t11 = timedNode2.value;
                        if (!this.done || timedNode2.get() != null) {
                            kVar.onNext(t11);
                            timedNode = timedNode2;
                        } else {
                            if (NotificationLite.isComplete(t11)) {
                                kVar.onComplete();
                            } else {
                                kVar.onError(NotificationLite.getError(t11));
                            }
                            replayDisposable.index = null;
                            replayDisposable.cancelled = true;
                            return;
                        }
                    }
                }
                replayDisposable.index = null;
            }
        }

        public int size() {
            return size(getHead());
        }

        public void trim() {
            int i11 = this.size;
            if (i11 > this.maxSize) {
                this.size = i11 - 1;
                this.head = (TimedNode) this.head.get();
            }
            long b11 = this.scheduler.b(this.unit) - this.maxAge;
            TimedNode<Object> timedNode = this.head;
            while (this.size > 1) {
                TimedNode<Object> timedNode2 = (TimedNode) timedNode.get();
                if (timedNode2.time > b11) {
                    this.head = timedNode;
                    return;
                } else {
                    this.size--;
                    timedNode = timedNode2;
                }
            }
            this.head = timedNode;
        }

        public void trimFinal() {
            long b11 = this.scheduler.b(this.unit) - this.maxAge;
            TimedNode<Object> timedNode = this.head;
            while (true) {
                TimedNode<Object> timedNode2 = (TimedNode) timedNode.get();
                if (timedNode2.get() == null) {
                    if (timedNode.value != null) {
                        TimedNode<Object> timedNode3 = new TimedNode<>(null, 0);
                        timedNode3.lazySet(timedNode.get());
                        this.head = timedNode3;
                        return;
                    }
                    this.head = timedNode;
                    return;
                } else if (timedNode2.time <= b11) {
                    timedNode = timedNode2;
                } else if (timedNode.value != null) {
                    TimedNode<Object> timedNode4 = new TimedNode<>(null, 0);
                    timedNode4.lazySet(timedNode.get());
                    this.head = timedNode4;
                    return;
                } else {
                    this.head = timedNode;
                    return;
                }
            }
        }

        public void trimHead() {
            TimedNode<Object> timedNode = this.head;
            if (timedNode.value != null) {
                TimedNode<Object> timedNode2 = new TimedNode<>(null, 0);
                timedNode2.lazySet(timedNode.get());
                this.head = timedNode2;
            }
        }

        public int size(TimedNode<Object> timedNode) {
            int i11 = 0;
            while (i11 != Integer.MAX_VALUE) {
                TimedNode<Object> timedNode2 = (TimedNode) timedNode.get();
                if (timedNode2 == null) {
                    T t11 = timedNode.value;
                    return (NotificationLite.isComplete(t11) || NotificationLite.isError(t11)) ? i11 - 1 : i11;
                }
                i11++;
                timedNode = timedNode2;
            }
            return i11;
        }
    }

    public static final class SizeBoundReplayBuffer<T> extends AtomicReference<Object> {
        private static final long serialVersionUID = 1107649250281456395L;
        public volatile boolean done;
        public volatile Node<Object> head;
        public final int maxSize;
        public int size;
        public Node<Object> tail;

        public SizeBoundReplayBuffer(int i11) {
            this.maxSize = i11;
            Node<Object> node = new Node<>(null);
            this.tail = node;
            this.head = node;
        }

        public void add(T t11) {
            Node<Object> node = new Node<>(t11);
            Node<Object> node2 = this.tail;
            this.tail = node;
            this.size++;
            node2.set(node);
            trim();
        }

        public void addFinal(Object obj) {
            Node<Object> node = new Node<>(obj);
            Node<Object> node2 = this.tail;
            this.tail = node;
            this.size++;
            node2.lazySet(node);
            trimHead();
            this.done = true;
        }

        public T getValue() {
            Node<Object> node = this.head;
            Node<Object> node2 = null;
            while (true) {
                Node<Object> node3 = (Node) node.get();
                if (node3 == null) {
                    break;
                }
                node2 = node;
                node = node3;
            }
            T t11 = node.value;
            if (t11 == null) {
                return null;
            }
            if (NotificationLite.isComplete(t11) || NotificationLite.isError(t11)) {
                return node2.value;
            }
            return t11;
        }

        public T[] getValues(T[] tArr) {
            Node<Object> node = this.head;
            int size2 = size();
            if (size2 != 0) {
                if (tArr.length < size2) {
                    tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), size2);
                }
                for (int i11 = 0; i11 != size2; i11++) {
                    node = (Node) node.get();
                    tArr[i11] = node.value;
                }
                if (tArr.length > size2) {
                    tArr[size2] = null;
                }
            } else if (tArr.length != 0) {
                tArr[0] = null;
            }
            return tArr;
        }

        public void replay(ReplayDisposable<T> replayDisposable) {
            if (replayDisposable.getAndIncrement() == 0) {
                k<? super T> kVar = replayDisposable.downstream;
                Node<Object> node = (Node) replayDisposable.index;
                if (node == null) {
                    node = this.head;
                }
                int i11 = 1;
                while (!replayDisposable.cancelled) {
                    Node<Object> node2 = (Node) node.get();
                    if (node2 != null) {
                        T t11 = node2.value;
                        if (!this.done || node2.get() != null) {
                            kVar.onNext(t11);
                            node = node2;
                        } else {
                            if (NotificationLite.isComplete(t11)) {
                                kVar.onComplete();
                            } else {
                                kVar.onError(NotificationLite.getError(t11));
                            }
                            replayDisposable.index = null;
                            replayDisposable.cancelled = true;
                            return;
                        }
                    } else if (node.get() != null) {
                        continue;
                    } else {
                        replayDisposable.index = node;
                        i11 = replayDisposable.addAndGet(-i11);
                        if (i11 == 0) {
                            return;
                        }
                    }
                }
                replayDisposable.index = null;
            }
        }

        public int size() {
            Node<Object> node = this.head;
            int i11 = 0;
            while (i11 != Integer.MAX_VALUE) {
                Node<Object> node2 = (Node) node.get();
                if (node2 == null) {
                    T t11 = node.value;
                    return (NotificationLite.isComplete(t11) || NotificationLite.isError(t11)) ? i11 - 1 : i11;
                }
                i11++;
                node = node2;
            }
            return i11;
        }

        public void trim() {
            int i11 = this.size;
            if (i11 > this.maxSize) {
                this.size = i11 - 1;
                this.head = (Node) this.head.get();
            }
        }

        public void trimHead() {
            Node<Object> node = this.head;
            if (node.value != null) {
                Node<Object> node2 = new Node<>(null);
                node2.lazySet(node.get());
                this.head = node2;
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

    public static final class UnboundedReplayBuffer<T> extends AtomicReference<Object> {
        private static final long serialVersionUID = -733876083048047795L;
        public final List<Object> buffer;
        public volatile boolean done;
        public volatile int size;

        public UnboundedReplayBuffer(int i11) {
            this.buffer = new ArrayList(i11);
        }

        public void add(T t11) {
            this.buffer.add(t11);
            this.size++;
        }

        public void addFinal(Object obj) {
            this.buffer.add(obj);
            trimHead();
            this.size++;
            this.done = true;
        }

        public T getValue() {
            int i11 = this.size;
            if (i11 == 0) {
                return null;
            }
            List<Object> list = this.buffer;
            T t11 = list.get(i11 - 1);
            if (!NotificationLite.isComplete(t11) && !NotificationLite.isError(t11)) {
                return t11;
            }
            if (i11 == 1) {
                return null;
            }
            return list.get(i11 - 2);
        }

        public T[] getValues(T[] tArr) {
            int i11 = this.size;
            if (i11 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            List list = this.buffer;
            Object obj = list.get(i11 - 1);
            if ((NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) && i11 - 1 == 0) {
                if (tArr.length != 0) {
                    tArr[0] = null;
                }
                return tArr;
            }
            if (tArr.length < i11) {
                tArr = (Object[]) Array.newInstance(tArr.getClass().getComponentType(), i11);
            }
            for (int i12 = 0; i12 < i11; i12++) {
                tArr[i12] = list.get(i12);
            }
            if (tArr.length > i11) {
                tArr[i11] = null;
            }
            return tArr;
        }

        public void replay(ReplayDisposable<T> replayDisposable) {
            int i11;
            if (replayDisposable.getAndIncrement() == 0) {
                List<Object> list = this.buffer;
                k<? super T> kVar = replayDisposable.downstream;
                Integer num = (Integer) replayDisposable.index;
                int i12 = 0;
                if (num != null) {
                    i12 = num.intValue();
                } else {
                    replayDisposable.index = 0;
                }
                int i13 = 1;
                while (!replayDisposable.cancelled) {
                    int i14 = this.size;
                    while (i14 != i12) {
                        if (replayDisposable.cancelled) {
                            replayDisposable.index = null;
                            return;
                        }
                        Object obj = list.get(i12);
                        if (this.done && (i11 = i12 + 1) == i14 && i11 == (i14 = this.size)) {
                            if (NotificationLite.isComplete(obj)) {
                                kVar.onComplete();
                            } else {
                                kVar.onError(NotificationLite.getError(obj));
                            }
                            replayDisposable.index = null;
                            replayDisposable.cancelled = true;
                            return;
                        }
                        kVar.onNext(obj);
                        i12++;
                    }
                    if (i12 == this.size) {
                        replayDisposable.index = Integer.valueOf(i12);
                        i13 = replayDisposable.addAndGet(-i13);
                        if (i13 == 0) {
                            return;
                        }
                    }
                }
                replayDisposable.index = null;
            }
        }

        public int size() {
            int i11 = this.size;
            if (i11 == 0) {
                return 0;
            }
            int i12 = i11 - 1;
            Object obj = this.buffer.get(i12);
            return (NotificationLite.isComplete(obj) || NotificationLite.isError(obj)) ? i12 : i11;
        }

        public void trimHead() {
        }
    }
}
