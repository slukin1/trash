package com.huawei.hms.stats;

import com.huawei.hms.support.log.HMSLog;

public class HianalyticsExist {

    /* renamed from: a  reason: collision with root package name */
    private static final Object f38456a = new Object();

    /* renamed from: b  reason: collision with root package name */
    private static boolean f38457b = false;

    /* renamed from: c  reason: collision with root package name */
    private static boolean f38458c = false;

    public static boolean isHianalyticsExist() {
        synchronized (f38456a) {
            if (!f38457b) {
                try {
                    Class.forName("com.huawei.hianalytics.process.HiAnalyticsInstance");
                } catch (ClassNotFoundException unused) {
                    HMSLog.i("HianalyticsExist", "In isHianalyticsExist, Failed to find class HiAnalyticsConfig.");
                }
                f38457b = true;
                HMSLog.i("HianalyticsExist", "hianalytics exist: " + f38458c);
            }
        }
        return f38458c;
    }
}
