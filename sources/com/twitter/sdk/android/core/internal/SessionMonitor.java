package com.twitter.sdk.android.core.internal;

import android.app.Activity;
import com.twitter.sdk.android.core.Session;
import com.twitter.sdk.android.core.SessionManager;
import com.twitter.sdk.android.core.internal.ActivityLifecycleManager;
import java.util.Calendar;
import java.util.TimeZone;
import java.util.concurrent.ExecutorService;

public class SessionMonitor<T extends Session> {
    private final ExecutorService executorService;
    public final MonitorState monitorState;
    private final SessionManager<T> sessionManager;
    private final SessionVerifier sessionVerifier;
    private final SystemCurrentTimeProvider time;

    public static class MonitorState {
        private static final long TIME_THRESHOLD_IN_MILLIS = 21600000;
        public long lastVerification;
        private final Calendar utcCalendar = Calendar.getInstance(TimeZone.getTimeZone(UtcDates.UTC));
        public boolean verifying;

        private boolean isOnSameDate(long j11, long j12) {
            this.utcCalendar.setTimeInMillis(j11);
            int i11 = this.utcCalendar.get(6);
            int i12 = this.utcCalendar.get(1);
            this.utcCalendar.setTimeInMillis(j12);
            int i13 = this.utcCalendar.get(6);
            int i14 = this.utcCalendar.get(1);
            if (i11 == i13 && i12 == i14) {
                return true;
            }
            return false;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0027, code lost:
            return false;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public synchronized boolean beginVerification(long r7) {
            /*
                r6 = this;
                monitor-enter(r6)
                long r0 = r6.lastVerification     // Catch:{ all -> 0x0028 }
                long r2 = r7 - r0
                r4 = 21600000(0x1499700, double:1.0671818E-316)
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                r3 = 1
                r4 = 0
                if (r2 <= 0) goto L_0x0010
                r2 = r3
                goto L_0x0011
            L_0x0010:
                r2 = r4
            L_0x0011:
                boolean r7 = r6.isOnSameDate(r7, r0)     // Catch:{ all -> 0x0028 }
                if (r7 != 0) goto L_0x0019
                r7 = r3
                goto L_0x001a
            L_0x0019:
                r7 = r4
            L_0x001a:
                boolean r8 = r6.verifying     // Catch:{ all -> 0x0028 }
                if (r8 != 0) goto L_0x0026
                if (r2 != 0) goto L_0x0022
                if (r7 == 0) goto L_0x0026
            L_0x0022:
                r6.verifying = r3     // Catch:{ all -> 0x0028 }
                monitor-exit(r6)
                return r3
            L_0x0026:
                monitor-exit(r6)
                return r4
            L_0x0028:
                r7 = move-exception
                monitor-exit(r6)
                throw r7
            */
            throw new UnsupportedOperationException("Method not decompiled: com.twitter.sdk.android.core.internal.SessionMonitor.MonitorState.beginVerification(long):boolean");
        }

        public synchronized void endVerification(long j11) {
            this.verifying = false;
            this.lastVerification = j11;
        }
    }

    public SessionMonitor(SessionManager<T> sessionManager2, ExecutorService executorService2, SessionVerifier<T> sessionVerifier2) {
        this(sessionManager2, new SystemCurrentTimeProvider(), executorService2, new MonitorState(), sessionVerifier2);
    }

    public void monitorActivityLifecycle(ActivityLifecycleManager activityLifecycleManager) {
        activityLifecycleManager.registerCallbacks(new ActivityLifecycleManager.Callbacks() {
            public void onActivityStarted(Activity activity) {
                SessionMonitor.this.triggerVerificationIfNecessary();
            }
        });
    }

    public void triggerVerificationIfNecessary() {
        if (this.sessionManager.getActiveSession() != null && this.monitorState.beginVerification(this.time.getCurrentTimeMillis())) {
            this.executorService.submit(new c(this));
        }
    }

    public void verifyAll() {
        for (T verifySession : this.sessionManager.getSessionMap().values()) {
            this.sessionVerifier.verifySession(verifySession);
        }
        this.monitorState.endVerification(this.time.getCurrentTimeMillis());
    }

    public SessionMonitor(SessionManager<T> sessionManager2, SystemCurrentTimeProvider systemCurrentTimeProvider, ExecutorService executorService2, MonitorState monitorState2, SessionVerifier sessionVerifier2) {
        this.time = systemCurrentTimeProvider;
        this.sessionManager = sessionManager2;
        this.executorService = executorService2;
        this.monitorState = monitorState2;
        this.sessionVerifier = sessionVerifier2;
    }
}
