package io.flutter.embedding.android;

import android.util.LongSparseArray;
import android.view.MotionEvent;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

public final class MotionEventTracker {
    private static MotionEventTracker INSTANCE;
    private final LongSparseArray<MotionEvent> eventById = new LongSparseArray<>();
    private final PriorityQueue<Long> unusedEvents = new PriorityQueue<>();

    public static class MotionEventId {
        private static final AtomicLong ID_COUNTER = new AtomicLong(0);
        /* access modifiers changed from: private */

        /* renamed from: id  reason: collision with root package name */
        public final long f55116id;

        private MotionEventId(long j11) {
            this.f55116id = j11;
        }

        public static MotionEventId createUnique() {
            return from(ID_COUNTER.incrementAndGet());
        }

        public static MotionEventId from(long j11) {
            return new MotionEventId(j11);
        }

        public long getId() {
            return this.f55116id;
        }
    }

    private MotionEventTracker() {
    }

    public static MotionEventTracker getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new MotionEventTracker();
        }
        return INSTANCE;
    }

    public MotionEvent pop(MotionEventId motionEventId) {
        while (!this.unusedEvents.isEmpty() && this.unusedEvents.peek().longValue() < motionEventId.f55116id) {
            this.eventById.remove(this.unusedEvents.poll().longValue());
        }
        if (!this.unusedEvents.isEmpty() && this.unusedEvents.peek().longValue() == motionEventId.f55116id) {
            this.unusedEvents.poll();
        }
        MotionEvent motionEvent = this.eventById.get(motionEventId.f55116id);
        this.eventById.remove(motionEventId.f55116id);
        return motionEvent;
    }

    public MotionEventId track(MotionEvent motionEvent) {
        MotionEventId createUnique = MotionEventId.createUnique();
        this.eventById.put(createUnique.f55116id, MotionEvent.obtain(motionEvent));
        this.unusedEvents.add(Long.valueOf(createUnique.f55116id));
        return createUnique;
    }
}
