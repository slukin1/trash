package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

@SuppressAnimalSniffer
abstract class SpscArrayQueueProducerFields<E> extends SpscArrayQueueL1Pad<E> {
    public static final long P_INDEX_OFFSET = UnsafeAccess.addressOf(SpscArrayQueueProducerFields.class, "producerIndex");
    public long producerIndex;
    public long producerLookAhead;

    public SpscArrayQueueProducerFields(int i11) {
        super(i11);
    }
}
