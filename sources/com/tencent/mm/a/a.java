package com.tencent.mm.a;

import android.util.Base64;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.twitter.sdk.android.core.internal.network.UrlUtils;
import javax.crypto.Cipher;

public final class a {

    /* renamed from: j  reason: collision with root package name */
    private Cipher f22722j;

    public final String h(String str) {
        try {
            return new String(this.f22722j.doFinal(Base64.decode(str, 0)), UrlUtils.UTF8);
        } catch (Exception e11) {
            return "[des]" + str + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + e11.toString();
        }
    }
}
