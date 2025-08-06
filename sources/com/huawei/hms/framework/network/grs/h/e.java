package com.huawei.hms.framework.network.grs.h;

import com.huawei.hms.framework.common.Logger;

public class e {

    /* renamed from: a  reason: collision with root package name */
    private static final String f38096a = "e";

    public static boolean a(Long l11) {
        if (l11 == null) {
            Logger.v(f38096a, "Method isTimeExpire input param expireTime is null.");
            return true;
        }
        try {
            if (l11.longValue() - System.currentTimeMillis() >= 0) {
                Logger.i(f38096a, "isSpExpire false.");
                return false;
            }
            Logger.i(f38096a, "isSpExpire true.");
            return true;
        } catch (NumberFormatException unused) {
            Logger.v(f38096a, "isSpExpire spValue NumberFormatException.");
        }
    }

    public static boolean a(Long l11, long j11) {
        if (l11 == null) {
            Logger.v(f38096a, "Method isTimeWillExpire input param expireTime is null.");
            return true;
        }
        try {
            if (l11.longValue() - (System.currentTimeMillis() + j11) >= 0) {
                Logger.v(f38096a, "isSpExpire false.");
                return false;
            }
        } catch (NumberFormatException unused) {
            Logger.v(f38096a, "isSpExpire spValue NumberFormatException.");
        }
        return true;
    }
}
