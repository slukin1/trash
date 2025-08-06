package com.google.firebase.crashlytics.internal.common;

interface CrashlyticsLifecycleEvents {
    void onBeginSession(String str, long j11);

    void onCustomKey(String str, String str2);

    void onLog(long j11, String str);

    void onUserId(String str);
}
