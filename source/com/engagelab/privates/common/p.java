package com.engagelab.privates.common;

import com.engagelab.privates.common.log.MTCommonLog;
import com.engagelab.privates.push.api.MTPushPrivatesApi;
import java.util.concurrent.ConcurrentLinkedQueue;

public class p {

    /* renamed from: a  reason: collision with root package name */
    public static ConcurrentLinkedQueue<Long> f64974a = new ConcurrentLinkedQueue<>();

    public int a() {
        long currentTimeMillis = System.currentTimeMillis();
        if (f64974a.size() < 10) {
            f64974a.offer(Long.valueOf(currentTimeMillis));
            return 0;
        }
        long longValue = currentTimeMillis - ((Long) f64974a.element()).longValue();
        if (longValue < 0) {
            f64974a.clear();
            MTCommonLog.w("MTOperationBusiness", "set tags/alias failed, time shaft error，please try again");
            return MTPushPrivatesApi.Code.INVOKE_TOO_SOON;
        } else if (longValue > 10000) {
            while (f64974a.size() >= 10) {
                f64974a.poll();
            }
            f64974a.offer(Long.valueOf(currentTimeMillis));
            return 0;
        } else {
            MTCommonLog.w("MTOperationBusiness", "set tags/alias too soon, over 10 times in 10s");
            return MTPushPrivatesApi.Code.INVOKE_TOO_SOON;
        }
    }
}
