package com.google.android.exoplayer2.util;

import java.io.IOException;
import java.util.Collections;
import java.util.PriorityQueue;

public final class PriorityTaskManager {
    private int highestPriority = Integer.MIN_VALUE;
    private final Object lock = new Object();
    private final PriorityQueue<Integer> queue = new PriorityQueue<>(10, Collections.reverseOrder());

    public static class PriorityTooLowException extends IOException {
        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public PriorityTooLowException(int r3, int r4) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = 60
                r0.<init>(r1)
                java.lang.String r1 = "Priority too low [priority="
                r0.append(r1)
                r0.append(r3)
                java.lang.String r3 = ", highest="
                r0.append(r3)
                r0.append(r4)
                java.lang.String r3 = "]"
                r0.append(r3)
                java.lang.String r3 = r0.toString()
                r2.<init>(r3)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.util.PriorityTaskManager.PriorityTooLowException.<init>(int, int):void");
        }
    }

    public void add(int i11) {
        synchronized (this.lock) {
            this.queue.add(Integer.valueOf(i11));
            this.highestPriority = Math.max(this.highestPriority, i11);
        }
    }

    public void proceed(int i11) throws InterruptedException {
        synchronized (this.lock) {
            while (this.highestPriority != i11) {
                this.lock.wait();
            }
        }
    }

    public boolean proceedNonBlocking(int i11) {
        boolean z11;
        synchronized (this.lock) {
            z11 = this.highestPriority == i11;
        }
        return z11;
    }

    public void proceedOrThrow(int i11) throws PriorityTooLowException {
        synchronized (this.lock) {
            if (this.highestPriority != i11) {
                throw new PriorityTooLowException(i11, this.highestPriority);
            }
        }
    }

    public void remove(int i11) {
        synchronized (this.lock) {
            this.queue.remove(Integer.valueOf(i11));
            this.highestPriority = this.queue.isEmpty() ? Integer.MIN_VALUE : ((Integer) Util.castNonNull(this.queue.peek())).intValue();
            this.lock.notifyAll();
        }
    }
}
