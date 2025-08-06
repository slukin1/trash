package rx.internal.util.unsafe;

abstract class SpscUnboundedArrayQueueConsumerColdField<E> extends SpscUnboundedArrayQueueL2Pad<E> {
    public E[] consumerBuffer;
    public long consumerMask;
}
