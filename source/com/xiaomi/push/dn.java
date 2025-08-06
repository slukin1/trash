package com.xiaomi.push;

import android.content.Context;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.xiaomi.mipush.sdk.Constants;

public class dn extends dm {
    public dn(Context context, int i11) {
        super(context, i11);
    }

    public gi a() {
        return gi.Storage;
    }

    /* renamed from: a  reason: collision with other method in class */
    public String m2525a() {
        return "23";
    }

    public String b() {
        return "ram:" + i.a() + Constants.ACCEPT_TIME_SEPARATOR_SP + "rom:" + i.b() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + "ramOriginal:" + i.c() + Constants.ACCEPT_TIME_SEPARATOR_SP + "romOriginal:" + i.d();
    }
}
