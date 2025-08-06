package com.huawei.hms.api;

import com.huawei.hms.support.log.HMSLog;
import java.sql.Timestamp;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class FailedBinderCallBack {
    private static final long AGING_TIME = 10000;
    public static final String CALLER_ID = "callId";
    private static final Object LOCK_OBJECT = new Object();
    private static final String TAG = "FailedBinderCallBack";
    private static Map<Long, BinderCallBack> binderCallBackMap = new ConcurrentHashMap();
    private static FailedBinderCallBack instance;

    public interface BinderCallBack {
        void binderCallBack(int i11);
    }

    private FailedBinderCallBack() {
    }

    private void agingCheck() {
        long time = new Timestamp(System.currentTimeMillis()).getTime() - 10000;
        for (Long next : binderCallBackMap.keySet()) {
            if (time >= next.longValue()) {
                binderCallBackMap.remove(next);
            }
        }
    }

    public static FailedBinderCallBack getInstance() {
        synchronized (LOCK_OBJECT) {
            if (instance == null) {
                instance = new FailedBinderCallBack();
            }
        }
        return instance;
    }

    private void putCallBackInMap(Long l11, BinderCallBack binderCallBack) {
        if (binderCallBackMap == null) {
            HMSLog.e(TAG, "binderCallBackMap is null");
            return;
        }
        agingCheck();
        binderCallBackMap.put(l11, binderCallBack);
    }

    public BinderCallBack getCallBack(Long l11) {
        Map<Long, BinderCallBack> map = binderCallBackMap;
        if (map != null) {
            return map.remove(l11);
        }
        HMSLog.e(TAG, "binderCallBackMap is null");
        return null;
    }

    public void setCallBack(Long l11, BinderCallBack binderCallBack) {
        putCallBackInMap(l11, binderCallBack);
    }
}
