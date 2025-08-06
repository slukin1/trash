package rx.internal.util.unsafe;

abstract class SpscUnboundedArrayQueueProducerColdFields<E> extends SpscUnboundedArrayQueueProducerFields<E> {
    public E[] producerBuffer;
    public long producerLookAhead;
    public int producerLookAheadStep;
    public long producerMask;
}
