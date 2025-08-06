package rx.internal.util.unsafe;

import java.util.Iterator;
import rx.internal.util.SuppressAnimalSniffer;
import rx.internal.util.atomic.LinkedQueueNode;

@SuppressAnimalSniffer
abstract class BaseLinkedQueue<E> extends BaseLinkedQueueConsumerNodeRef<E> {

    /* renamed from: p00  reason: collision with root package name */
    public long f40558p00;
    public long p01;
    public long p02;
    public long p03;
    public long p04;
    public long p05;
    public long p06;
    public long p07;
    public long p30;
    public long p31;
    public long p32;
    public long p33;
    public long p34;
    public long p35;
    public long p36;
    public long p37;

    public final boolean isEmpty() {
        return lvConsumerNode() == lvProducerNode();
    }

    public final Iterator<E> iterator() {
        throw new UnsupportedOperationException();
    }

    public final int size() {
        LinkedQueueNode lvNext;
        LinkedQueueNode lvConsumerNode = lvConsumerNode();
        LinkedQueueNode lvProducerNode = lvProducerNode();
        int i11 = 0;
        while (lvConsumerNode != lvProducerNode && i11 < Integer.MAX_VALUE) {
            do {
                lvNext = lvConsumerNode.lvNext();
            } while (lvNext == null);
            i11++;
            lvConsumerNode = lvNext;
        }
        return i11;
    }
}
