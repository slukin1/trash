package okio;

import java.util.concurrent.atomic.AtomicReference;

public final class SegmentPool {
    private static final int HASH_BUCKET_COUNT;
    public static final SegmentPool INSTANCE = new SegmentPool();
    private static final Segment LOCK = new Segment(new byte[0], 0, 0, false, false);
    private static final int MAX_SIZE = 65536;
    private static final AtomicReference<Segment>[] hashBuckets;

    static {
        int highestOneBit = Integer.highestOneBit((Runtime.getRuntime().availableProcessors() * 2) - 1);
        HASH_BUCKET_COUNT = highestOneBit;
        AtomicReference<Segment>[] atomicReferenceArr = new AtomicReference[highestOneBit];
        for (int i11 = 0; i11 < highestOneBit; i11++) {
            atomicReferenceArr[i11] = new AtomicReference<>();
        }
        hashBuckets = atomicReferenceArr;
    }

    private SegmentPool() {
    }

    private final AtomicReference<Segment> firstRef() {
        return hashBuckets[(int) (Thread.currentThread().getId() & (((long) HASH_BUCKET_COUNT) - 1))];
    }

    public static final void recycle(Segment segment) {
        AtomicReference<Segment> firstRef;
        Segment segment2;
        Segment andSet;
        if (!(segment.next == null && segment.prev == null)) {
            throw new IllegalArgumentException("Failed requirement.".toString());
        } else if (!segment.shared && (andSet = firstRef.getAndSet(segment2)) != (segment2 = LOCK)) {
            int i11 = andSet != null ? andSet.limit : 0;
            if (i11 >= MAX_SIZE) {
                firstRef.set(andSet);
                return;
            }
            segment.next = andSet;
            segment.pos = 0;
            segment.limit = i11 + 8192;
            (firstRef = INSTANCE.firstRef()).set(segment);
        }
    }

    public static final Segment take() {
        AtomicReference<Segment> firstRef = INSTANCE.firstRef();
        Segment segment = LOCK;
        Segment andSet = firstRef.getAndSet(segment);
        if (andSet == segment) {
            return new Segment();
        }
        if (andSet == null) {
            firstRef.set((Object) null);
            return new Segment();
        }
        firstRef.set(andSet.next);
        andSet.next = null;
        andSet.limit = 0;
        return andSet;
    }

    public final int getByteCount() {
        Segment segment = firstRef().get();
        if (segment == null) {
            return 0;
        }
        return segment.limit;
    }

    public final int getMAX_SIZE() {
        return MAX_SIZE;
    }
}
