package com.google.firebase.analytics;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class zza extends ThreadPoolExecutor {
    public zza(FirebaseAnalytics firebaseAnalytics, int i11, int i12, long j11, TimeUnit timeUnit, BlockingQueue blockingQueue) {
        super(0, 1, 30, timeUnit, blockingQueue);
    }
}
