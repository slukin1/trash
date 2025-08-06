package io.reactivex.rxjava3.internal.queue;

import java.util.Objects;
import java.util.concurrent.atomic.AtomicReference;
import k00.e;

public final class MpscLinkedQueue<T> implements e<T> {

    /* renamed from: b  reason: collision with root package name */
    public final AtomicReference<LinkedQueueNode<T>> f55610b = new AtomicReference<>();

    /* renamed from: c  reason: collision with root package name */
    public final AtomicReference<LinkedQueueNode<T>> f55611c = new AtomicReference<>();

    public static final class LinkedQueueNode<E> extends AtomicReference<LinkedQueueNode<E>> {
        private static final long serialVersionUID = 2404266111789071508L;
        private E value;

        public LinkedQueueNode() {
        }

        public E getAndNullValue() {
            E lpValue = lpValue();
            spValue((Object) null);
            return lpValue;
        }

        public E lpValue() {
            return this.value;
        }

        public LinkedQueueNode<E> lvNext() {
            return (LinkedQueueNode) get();
        }

        public void soNext(LinkedQueueNode<E> linkedQueueNode) {
            lazySet(linkedQueueNode);
        }

        public void spValue(E e11) {
            this.value = e11;
        }

        public LinkedQueueNode(E e11) {
            spValue(e11);
        }
    }

    public MpscLinkedQueue() {
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode();
        d(linkedQueueNode);
        e(linkedQueueNode);
    }

    public LinkedQueueNode<T> a() {
        return this.f55611c.get();
    }

    public LinkedQueueNode<T> b() {
        return this.f55611c.get();
    }

    public LinkedQueueNode<T> c() {
        return this.f55610b.get();
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP:0: B:0:0x0000->B:3:0x000a, LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void clear() {
        /*
            r1 = this;
        L_0x0000:
            java.lang.Object r0 = r1.poll()
            if (r0 == 0) goto L_0x000d
            boolean r0 = r1.isEmpty()
            if (r0 != 0) goto L_0x000d
            goto L_0x0000
        L_0x000d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: io.reactivex.rxjava3.internal.queue.MpscLinkedQueue.clear():void");
    }

    public void d(LinkedQueueNode<T> linkedQueueNode) {
        this.f55611c.lazySet(linkedQueueNode);
    }

    public LinkedQueueNode<T> e(LinkedQueueNode<T> linkedQueueNode) {
        return this.f55610b.getAndSet(linkedQueueNode);
    }

    public boolean isEmpty() {
        return b() == c();
    }

    public boolean offer(T t11) {
        Objects.requireNonNull(t11, "Null is not a valid element");
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode(t11);
        e(linkedQueueNode).soNext(linkedQueueNode);
        return true;
    }

    public T poll() {
        LinkedQueueNode lvNext;
        LinkedQueueNode a11 = a();
        LinkedQueueNode lvNext2 = a11.lvNext();
        if (lvNext2 != null) {
            T andNullValue = lvNext2.getAndNullValue();
            d(lvNext2);
            return andNullValue;
        } else if (a11 == c()) {
            return null;
        } else {
            do {
                lvNext = a11.lvNext();
            } while (lvNext == null);
            T andNullValue2 = lvNext.getAndNullValue();
            d(lvNext);
            return andNullValue2;
        }
    }
}
