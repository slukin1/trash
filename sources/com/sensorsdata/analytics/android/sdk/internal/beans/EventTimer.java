package com.sensorsdata.analytics.android.sdk.internal.beans;

import java.util.concurrent.TimeUnit;

public class EventTimer {
    private long endTime;
    private long eventAccumulatedDuration;
    private boolean isPaused = false;
    private long startTime;
    private final TimeUnit timeUnit;

    public EventTimer(TimeUnit timeUnit2, long j11) {
        this.startTime = j11;
        this.timeUnit = timeUnit2;
        this.eventAccumulatedDuration = 0;
        this.endTime = -1;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0054 A[Catch:{ Exception -> 0x0070 }] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0059 A[Catch:{ Exception -> 0x0070 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String duration() {
        /*
            r7 = this;
            boolean r0 = r7.isPaused
            r1 = 0
            if (r0 == 0) goto L_0x000b
            long r3 = r7.startTime
            r7.endTime = r3
            goto L_0x0017
        L_0x000b:
            long r3 = r7.endTime
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0015
            long r3 = android.os.SystemClock.elapsedRealtime()
        L_0x0015:
            r7.endTime = r3
        L_0x0017:
            long r3 = r7.endTime
            long r5 = r7.startTime
            long r3 = r3 - r5
            long r5 = r7.eventAccumulatedDuration
            long r3 = r3 + r5
            int r0 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            r1 = 0
            if (r0 < 0) goto L_0x006b
            r5 = 86400000(0x5265c00, double:4.2687272E-316)
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 <= 0) goto L_0x002c
            goto L_0x006b
        L_0x002c:
            java.util.concurrent.TimeUnit r0 = r7.timeUnit     // Catch:{ Exception -> 0x0070 }
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ Exception -> 0x0070 }
            if (r0 != r2) goto L_0x0034
        L_0x0032:
            float r0 = (float) r3     // Catch:{ Exception -> 0x0070 }
            goto L_0x004f
        L_0x0034:
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.SECONDS     // Catch:{ Exception -> 0x0070 }
            r5 = 1148846080(0x447a0000, float:1000.0)
            if (r0 != r2) goto L_0x003d
            float r0 = (float) r3     // Catch:{ Exception -> 0x0070 }
            float r0 = r0 / r5
            goto L_0x004f
        L_0x003d:
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.MINUTES     // Catch:{ Exception -> 0x0070 }
            r6 = 1114636288(0x42700000, float:60.0)
            if (r0 != r2) goto L_0x0047
            float r0 = (float) r3     // Catch:{ Exception -> 0x0070 }
            float r0 = r0 / r5
        L_0x0045:
            float r0 = r0 / r6
            goto L_0x004f
        L_0x0047:
            java.util.concurrent.TimeUnit r2 = java.util.concurrent.TimeUnit.HOURS     // Catch:{ Exception -> 0x0070 }
            if (r0 != r2) goto L_0x0032
            float r0 = (float) r3     // Catch:{ Exception -> 0x0070 }
            float r0 = r0 / r5
            float r0 = r0 / r6
            goto L_0x0045
        L_0x004f:
            r2 = 0
            int r2 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r2 >= 0) goto L_0x0059
            java.lang.String r0 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0070 }
            goto L_0x006a
        L_0x0059:
            java.util.Locale r2 = java.util.Locale.CHINA     // Catch:{ Exception -> 0x0070 }
            java.lang.String r3 = "%.3f"
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0070 }
            java.lang.Float r0 = java.lang.Float.valueOf(r0)     // Catch:{ Exception -> 0x0070 }
            r4[r1] = r0     // Catch:{ Exception -> 0x0070 }
            java.lang.String r0 = java.lang.String.format(r2, r3, r4)     // Catch:{ Exception -> 0x0070 }
        L_0x006a:
            return r0
        L_0x006b:
            java.lang.String r0 = java.lang.String.valueOf(r1)     // Catch:{ Exception -> 0x0070 }
            return r0
        L_0x0070:
            r0 = move-exception
            com.sensorsdata.analytics.android.sdk.SALog.printStackTrace(r0)
            java.lang.String r0 = java.lang.String.valueOf(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sensorsdata.analytics.android.sdk.internal.beans.EventTimer.duration():java.lang.String");
    }

    public long getEndTime() {
        return this.endTime;
    }

    public long getEventAccumulatedDuration() {
        return this.eventAccumulatedDuration;
    }

    public long getStartTime() {
        return this.startTime;
    }

    public boolean isPaused() {
        return this.isPaused;
    }

    public void setEndTime(long j11) {
        this.endTime = j11;
    }

    public void setEventAccumulatedDuration(long j11) {
        this.eventAccumulatedDuration = j11;
    }

    public void setStartTime(long j11) {
        this.startTime = j11;
    }

    public void setTimerState(boolean z11, long j11) {
        this.isPaused = z11;
        if (z11) {
            this.eventAccumulatedDuration = (this.eventAccumulatedDuration + j11) - this.startTime;
        }
        this.startTime = j11;
    }
}
