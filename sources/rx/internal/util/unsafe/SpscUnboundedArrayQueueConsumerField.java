package rx.internal.util.unsafe;

abstract class SpscUnboundedArrayQueueConsumerField<E> extends SpscUnboundedArrayQueueConsumerColdField<E> {
    public long consumerIndex;
}
