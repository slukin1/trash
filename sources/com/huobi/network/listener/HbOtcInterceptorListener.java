package com.huobi.network.listener;

import bh.u;
import c9.b;
import com.hbg.lib.common.network.interceptor.JsonLevelChangeInterceptor;
import com.hbg.lib.common.network.interceptor.LogginInterceptor;
import com.huobi.coupon.bean.Coupon;
import com.huobi.domain.DomainSwitcher;
import com.huobi.network.interceptor.HeaderInterceptor;
import com.huobi.network.interceptor.OtcActiveInterceptor;
import com.huobi.network.interceptor.OtcInterceptor;
import com.huobi.network.interceptor.VulcanInterceptor;
import com.huobi.network.listener.HttpLoggingInterceptor;
import com.huobi.otc.aliyun.global.AliyunGlobalInterceptor;
import com.huobi.otc.interceptor.NetBusinessLoganInterceptor;
import no.j;
import okhttp3.OkHttpClient;
import qu.d;

public class HbOtcInterceptorListener implements b {
    public void buildOkHttpClient(OkHttpClient.Builder builder) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(Coupon.OTC);
        httpLoggingInterceptor.d(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(j.d()).addInterceptor(new JsonLevelChangeInterceptor()).addInterceptor(new OtcInterceptor()).addInterceptor(new NetBusinessLoganInterceptor()).addInterceptor(new LogginInterceptor()).addInterceptor(new VulcanInterceptor()).addInterceptor(new HeaderInterceptor()).addInterceptor(new AliyunGlobalInterceptor()).addInterceptor(new OtcActiveInterceptor()).addInterceptor(httpLoggingInterceptor);
        u.a(builder);
    }

    public void buildSocketOkHttpClient(OkHttpClient.Builder builder) {
    }

    public String getHost() {
        return DomainSwitcher.M();
    }

    public String getWebSocketHost() {
        return d.i().l();
    }
}
