package rx.internal.util.unsafe;

import java.util.Objects;
import rx.internal.util.SuppressAnimalSniffer;

@SuppressAnimalSniffer
public class MpmcArrayQueue<E> extends MpmcArrayQueueConsumerField<E> {
    public long p30;
    public long p31;
    public long p32;
    public long p33;
    public long p34;
    public long p35;
    public long p36;
    public long p37;
    public long p40;
    public long p41;
    public long p42;
    public long p43;
    public long p44;
    public long p45;
    public long p46;

    public MpmcArrayQueue(int i11) {
        super(Math.max(2, i11));
    }

    public boolean isEmpty() {
        return lvConsumerIndex() == lvProducerIndex();
    }

    public boolean offer(E e11) {
        E e12 = e11;
        Objects.requireNonNull(e12, "Null is not a valid element");
        long j11 = this.mask + 1;
        long[] jArr = this.sequenceBuffer;
        long j12 = Long.MAX_VALUE;
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long calcSequenceOffset = calcSequenceOffset(lvProducerIndex);
            int i11 = ((lvSequence(jArr, calcSequenceOffset) - lvProducerIndex) > 0 ? 1 : ((lvSequence(jArr, calcSequenceOffset) - lvProducerIndex) == 0 ? 0 : -1));
            if (i11 == 0) {
                long j13 = lvProducerIndex + 1;
                if (casProducerIndex(lvProducerIndex, j13)) {
                    spElement(calcElementOffset(lvProducerIndex), e12);
                    soSequence(jArr, calcSequenceOffset, j13);
                    return true;
                }
            } else if (i11 < 0) {
                long j14 = lvProducerIndex - j11;
                if (j14 <= j12) {
                    j12 = lvConsumerIndex();
                    if (j14 <= j12) {
                        return false;
                    }
                } else {
                    continue;
                }
            } else {
                continue;
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:0:0x0000 A[LOOP_START, MTH_ENTER_BLOCK] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public E peek() {
        /*
            r5 = this;
        L_0x0000:
            long r0 = r5.lvConsumerIndex()
            long r2 = r5.calcElementOffset(r0)
            java.lang.Object r2 = r5.lpElement(r2)
            if (r2 != 0) goto L_0x0016
            long r3 = r5.lvProducerIndex()
            int r0 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r0 != 0) goto L_0x0000
        L_0x0016:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: rx.internal.util.unsafe.MpmcArrayQueue.peek():java.lang.Object");
    }

    public E poll() {
        long[] jArr = this.sequenceBuffer;
        long j11 = -1;
        while (true) {
            long lvConsumerIndex = lvConsumerIndex();
            long calcSequenceOffset = calcSequenceOffset(lvConsumerIndex);
            long j12 = lvConsumerIndex + 1;
            int i11 = ((lvSequence(jArr, calcSequenceOffset) - j12) > 0 ? 1 : ((lvSequence(jArr, calcSequenceOffset) - j12) == 0 ? 0 : -1));
            if (i11 == 0) {
                if (casConsumerIndex(lvConsumerIndex, j12)) {
                    long calcElementOffset = calcElementOffset(lvConsumerIndex);
                    E lpElement = lpElement(calcElementOffset);
                    spElement(calcElementOffset, null);
                    soSequence(jArr, calcSequenceOffset, lvConsumerIndex + this.mask + 1);
                    return lpElement;
                }
            } else if (i11 < 0 && lvConsumerIndex >= j11) {
                j11 = lvProducerIndex();
                if (lvConsumerIndex == j11) {
                    return null;
                }
            }
        }
    }

    public int size() {
        long lvConsumerIndex = lvConsumerIndex();
        while (true) {
            long lvProducerIndex = lvProducerIndex();
            long lvConsumerIndex2 = lvConsumerIndex();
            if (lvConsumerIndex == lvConsumerIndex2) {
                return (int) (lvProducerIndex - lvConsumerIndex2);
            }
            lvConsumerIndex = lvConsumerIndex2;
        }
    }
}
