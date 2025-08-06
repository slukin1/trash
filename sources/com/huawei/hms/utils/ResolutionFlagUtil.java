package com.huawei.hms.utils;

import android.text.TextUtils;
import com.huawei.hms.support.log.HMSLog;
import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ResolutionFlagUtil {

    /* renamed from: a  reason: collision with root package name */
    private static volatile ResolutionFlagUtil f38622a;

    /* renamed from: b  reason: collision with root package name */
    private static final Map<String, Long> f38623b = new ConcurrentHashMap();

    /* renamed from: c  reason: collision with root package name */
    private static final Object f38624c = new Object();

    private ResolutionFlagUtil() {
    }

    private void a() {
        long time = new Timestamp(System.currentTimeMillis()).getTime() - 10800000;
        for (String next : f38623b.keySet()) {
            Map<String, Long> map = f38623b;
            Long l11 = map.get(next);
            if (l11 == null || l11.longValue() == 0) {
                map.remove(next);
                HMSLog.i("ResolutionFlagUtil", "remove resolution flag because the data in this pair was abnormal: " + next);
            } else if (time >= l11.longValue()) {
                map.remove(next);
                HMSLog.i("ResolutionFlagUtil", "remove resolution flag because aging time: " + next);
            }
        }
    }

    public static ResolutionFlagUtil getInstance() {
        if (f38622a != null) {
            return f38622a;
        }
        synchronized (f38624c) {
            if (f38622a == null) {
                f38622a = new ResolutionFlagUtil();
            }
        }
        return f38622a;
    }

    public long getResolutionFlag(String str) {
        if (str == null) {
            HMSLog.e("ResolutionFlagUtil", "transactionId is null");
            return 0;
        }
        Map<String, Long> map = f38623b;
        if (map.get(str) != null) {
            return map.get(str).longValue();
        }
        return 0;
    }

    public void removeResolutionFlag(String str) {
        if (str == null) {
            HMSLog.e("ResolutionFlagUtil", "transactionId is null");
            return;
        }
        f38623b.remove(str);
        HMSLog.i("ResolutionFlagUtil", "remove resolution flag");
    }

    public void saveResolutionFlag(String str, long j11) {
        if (TextUtils.isEmpty(str) || j11 == 0) {
            HMSLog.e("ResolutionFlagUtil", "saveResolutionFlag error, transactionId: " + str + ", timestamp: " + j11);
            return;
        }
        a(str, j11);
    }

    private void a(String str, long j11) {
        Map<String, Long> map = f38623b;
        synchronized (map) {
            a();
            map.put(str, Long.valueOf(j11));
            HMSLog.i("ResolutionFlagUtil", "save resolution flag");
        }
    }
}
