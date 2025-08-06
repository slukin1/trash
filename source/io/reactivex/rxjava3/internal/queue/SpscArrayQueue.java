package io.reactivex.rxjava3.internal.queue;

import io.reactivex.rxjava3.internal.util.f;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReferenceArray;
import k00.e;

public final class SpscArrayQueue<E> extends AtomicReferenceArray<E> implements e<E> {
    private static final Integer MAX_LOOK_AHEAD_STEP = Integer.getInteger("jctools.spsc.max.lookahead.step", 4096);
    private static final long serialVersionUID = -1296597691183856449L;
    public final AtomicLong consumerIndex = new AtomicLong();
    public final int lookAheadStep;
    public final int mask = (length() - 1);
    public final AtomicLong producerIndex = new AtomicLong();
    public long producerLookAhead;

    public SpscArrayQueue(int i11) {
        super(f.a(i11));
        this.lookAheadStep = Math.min(i11 / 4, MAX_LOOK_AHEAD_STEP.intValue());
    }

    public int calcElementOffset(long j11) {
        return ((int) j11) & this.mask;
    }

    public int calcElementOffset(long j11, int i11) {
        return ((int) j11) & i11;
    }

    public void clear() {
        while (true) {
            if (poll() == null && isEmpty()) {
                return;
            }
        }
    }

    public boolean isEmpty() {
        return this.producerIndex.get() == this.consumerIndex.get();
    }

    public E lvElement(int i11) {
        return get(i11);
    }

    public boolean offer(E e11) {
        Objects.requireNonNull(e11, "Null is not a valid element");
        int i11 = this.mask;
        long j11 = this.producerIndex.get();
        int calcElementOffset = calcElementOffset(j11, i11);
        if (j11 >= this.producerLookAhead) {
            long j12 = ((long) this.lookAheadStep) + j11;
            if (lvElement(calcElementOffset(j12, i11)) == null) {
                this.producerLookAhead = j12;
            } else if (lvElement(calcElementOffset) != null) {
                return false;
            }
        }
        soElement(calcElementOffset, e11);
        soProducerIndex(j11 + 1);
        return true;
    }

    public E poll() {
        long j11 = this.consumerIndex.get();
        int calcElementOffset = calcElementOffset(j11);
        E lvElement = lvElement(calcElementOffset);
        if (lvElement == null) {
            return null;
        }
        soConsumerIndex(j11 + 1);
        soElement(calcElementOffset, (Object) null);
        return lvElement;
    }

    public void soConsumerIndex(long j11) {
        this.consumerIndex.lazySet(j11);
    }

    public void soElement(int i11, E e11) {
        lazySet(i11, e11);
    }

    public void soProducerIndex(long j11) {
        this.producerIndex.lazySet(j11);
    }

    public boolean offer(E e11, E e12) {
        return offer(e11) && offer(e12);
    }
}
