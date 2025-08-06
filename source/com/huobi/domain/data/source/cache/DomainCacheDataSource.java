package com.huobi.domain.data.source.cache;

import com.hbg.lib.network.hbg.core.bean.SmartDomainData;
import com.huobi.domain.AppDomainConfigUtils;
import com.huobi.domain.c;
import com.huobi.domain.data.DomainInfo;

public class DomainCacheDataSource {

    /* renamed from: a  reason: collision with root package name */
    public static DomainInfo f43851a;

    /* renamed from: b  reason: collision with root package name */
    public static String f43852b;

    public static DomainInfo a() {
        if (f43851a == null) {
            if (!AppDomainConfigUtils.f43773a.exists()) {
                return null;
            }
            AppDomainConfigUtils.i();
            String d11 = AppDomainConfigUtils.d(AppDomainConfigUtils.f43773a);
            f43852b = d11;
            SmartDomainData d12 = c.d();
            if (d12 == null) {
                d12 = c.c();
            }
            f43851a = AppDomainConfigUtils.j(d11, d12);
        }
        return f43851a;
    }
}
