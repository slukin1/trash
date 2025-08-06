package rx.internal.util.atomic;

import java.util.Objects;

public final class MpscLinkedAtomicQueue<E> extends BaseLinkedAtomicQueue<E> {
    public MpscLinkedAtomicQueue() {
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode();
        spConsumerNode(linkedQueueNode);
        xchgProducerNode(linkedQueueNode);
    }

    public boolean offer(E e11) {
        Objects.requireNonNull(e11, "null elements not allowed");
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode(e11);
        xchgProducerNode(linkedQueueNode).soNext(linkedQueueNode);
        return true;
    }

    public E peek() {
        LinkedQueueNode lvNext;
        LinkedQueueNode lpConsumerNode = lpConsumerNode();
        LinkedQueueNode lvNext2 = lpConsumerNode.lvNext();
        if (lvNext2 != null) {
            return lvNext2.lpValue();
        }
        if (lpConsumerNode == lvProducerNode()) {
            return null;
        }
        do {
            lvNext = lpConsumerNode.lvNext();
        } while (lvNext == null);
        return lvNext.lpValue();
    }

    public E poll() {
        LinkedQueueNode lvNext;
        LinkedQueueNode lpConsumerNode = lpConsumerNode();
        LinkedQueueNode lvNext2 = lpConsumerNode.lvNext();
        if (lvNext2 != null) {
            E andNullValue = lvNext2.getAndNullValue();
            spConsumerNode(lvNext2);
            return andNullValue;
        } else if (lpConsumerNode == lvProducerNode()) {
            return null;
        } else {
            do {
                lvNext = lpConsumerNode.lvNext();
            } while (lvNext == null);
            E andNullValue2 = lvNext.getAndNullValue();
            spConsumerNode(lvNext);
            return andNullValue2;
        }
    }
}
