package com.huobi.app.startuptasks;

import com.hbg.lib.core.util.m0;
import com.huobi.bugsdk.FirebaseHelper;
import com.huobi.woodpecker.b;
import com.huobi.woodpecker.utils.ContextUtil;
import com.huobi.woodpecker.utils.TimeZoneUtils;
import com.sumsub.sns.internal.core.analytics.d;
import com.tencent.android.tpush.common.Constants;
import tg.r;

public final class FirebaseInitTask extends BaseAppStartTask {
    public void c() {
        FirebaseHelper.b();
        FirebaseHelper.h(r.x().Q());
        FirebaseHelper.g(Constants.FLAG_DEVICE_ID, m0.a());
        FirebaseHelper.g("BuildConfig.DEBUG", d.f31895b);
        FirebaseHelper.g("sid", b.o());
        FirebaseHelper.g("timezone", TimeZoneUtils.a());
        FirebaseHelper.g("NetISP", ContextUtil.i());
        FirebaseHelper.f(true);
    }
}
