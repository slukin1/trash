package com.tencent.tpns.baseapi.base.util;

import android.content.Context;
import com.tencent.android.tpush.stat.ServiceStat;
import com.tencent.tpns.baseapi.base.logger.TBaseLogger;

public class StatHelper {
    public static void reportCloudControl(Context context, long j11, int i11, String str, long j12) {
        String str2 = str;
        if (CloudManager.getInstance(context).disableRepoCloudArrive()) {
            TBaseLogger.d("StatHelper", "disable reportCloudControl");
            return;
        }
        TBaseLogger.i("StatHelper", "action - reportCloudControl, cloudVersion:" + j11 + ", msg:" + str2 + ", req:" + j12);
        Class<ServiceStat> cls = ServiceStat.class;
        try {
            String str3 = ServiceStat.SRV_ACK_EVENT_ID;
            Class cls2 = Long.TYPE;
            cls.getDeclaredMethod("reportCloudControl", new Class[]{Context.class, cls2, Integer.TYPE, String.class, cls2}).invoke(cls, new Object[]{context, Long.valueOf(j11), Integer.valueOf(i11), str2, Long.valueOf(j12)});
        } catch (Throwable th2) {
            TBaseLogger.ww("StatHelper", "unexpected for reportCloudControl, exception:", th2);
        }
    }

    public static void reportErrCode(Context context, int i11, String str, long j11, String str2) {
        Class<String> cls = String.class;
        TBaseLogger.i("StatHelper", "action - reportErrCode, errCode:" + i11 + ", msg:" + str + ", req:" + j11);
        Class<ServiceStat> cls2 = ServiceStat.class;
        try {
            String str3 = ServiceStat.SRV_ACK_EVENT_ID;
            cls2.getDeclaredMethod("reportErrCode", new Class[]{Context.class, Integer.TYPE, cls, Long.TYPE, cls}).invoke(cls2, new Object[]{context, Integer.valueOf(i11), str, Long.valueOf(j11), str2});
        } catch (Throwable th2) {
            TBaseLogger.ww("StatHelper", "unexpected for reportErrCode, exception:", th2);
        }
    }
}
