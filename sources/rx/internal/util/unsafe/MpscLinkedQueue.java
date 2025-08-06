package rx.internal.util.unsafe;

import androidx.test.espresso.core.internal.deps.guava.util.concurrent.a;
import java.util.Objects;
import rx.internal.util.SuppressAnimalSniffer;
import rx.internal.util.atomic.LinkedQueueNode;

@SuppressAnimalSniffer
public final class MpscLinkedQueue<E> extends BaseLinkedQueue<E> {
    public MpscLinkedQueue() {
        LinkedQueueNode<E> linkedQueueNode = new LinkedQueueNode<>();
        this.consumerNode = linkedQueueNode;
        xchgProducerNode(linkedQueueNode);
    }

    public boolean offer(E e11) {
        Objects.requireNonNull(e11, "null elements not allowed");
        LinkedQueueNode linkedQueueNode = new LinkedQueueNode(e11);
        xchgProducerNode(linkedQueueNode).soNext(linkedQueueNode);
        return true;
    }

    public E peek() {
        LinkedQueueNode<E> lvNext;
        LinkedQueueNode<E> linkedQueueNode = this.consumerNode;
        LinkedQueueNode<E> lvNext2 = linkedQueueNode.lvNext();
        if (lvNext2 != null) {
            return lvNext2.lpValue();
        }
        if (linkedQueueNode == lvProducerNode()) {
            return null;
        }
        do {
            lvNext = linkedQueueNode.lvNext();
        } while (lvNext == null);
        return lvNext.lpValue();
    }

    public E poll() {
        LinkedQueueNode<E> lvNext;
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
            this.consumerNode = lvNext;
            return andNullValue2;
        }
    }

    public LinkedQueueNode<E> xchgProducerNode(LinkedQueueNode<E> linkedQueueNode) {
        LinkedQueueNode<E> linkedQueueNode2;
        do {
            linkedQueueNode2 = this.producerNode;
        } while (!a.a(UnsafeAccess.UNSAFE, this, BaseLinkedQueueProducerNodeRef.P_NODE_OFFSET, linkedQueueNode2, linkedQueueNode));
        return linkedQueueNode2;
    }
}
