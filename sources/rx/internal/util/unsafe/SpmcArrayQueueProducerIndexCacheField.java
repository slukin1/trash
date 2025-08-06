package rx.internal.util.unsafe;

import rx.internal.util.SuppressAnimalSniffer;

@SuppressAnimalSniffer
abstract class SpmcArrayQueueProducerIndexCacheField<E> extends SpmcArrayQueueMidPad<E> {
    private volatile long producerIndexCache;

    public SpmcArrayQueueProducerIndexCacheField(int i11) {
        super(i11);
    }

    public final long lvProducerIndexCache() {
        return this.producerIndexCache;
    }

    public final void svProducerIndexCache(long j11) {
        this.producerIndexCache = j11;
    }
}
