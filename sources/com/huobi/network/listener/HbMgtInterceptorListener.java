package com.huobi.network.listener;

import android.text.TextUtils;
import bh.u;
import c9.b;
import com.hbg.lib.common.network.interceptor.LogginInterceptor;
import com.hbg.lib.common.utils.SystemUtils;
import com.huobi.domain.DomainSwitcher;
import com.huobi.network.interceptor.HeaderInterceptor;
import com.huobi.network.interceptor.ProInterceptor;
import com.huobi.network.interceptor.VulcanInterceptor;
import com.huobi.network.listener.HttpLoggingInterceptor;
import com.huobi.otc.aliyun.global.AliyunGlobalInterceptor;
import no.m;
import okhttp3.OkHttpClient;

public class HbMgtInterceptorListener implements b {
    public void buildOkHttpClient(OkHttpClient.Builder builder) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor("MGT");
        httpLoggingInterceptor.d(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(m.f()).addInterceptor(new ProInterceptor()).addInterceptor(new LogginInterceptor()).addInterceptor(new VulcanInterceptor()).addInterceptor(new AliyunGlobalInterceptor()).addInterceptor(new HeaderInterceptor()).addInterceptor(httpLoggingInterceptor);
        u.a(builder);
    }

    public void buildSocketOkHttpClient(OkHttpClient.Builder builder) {
    }

    public String getHost() {
        String str = wi.b.f48040d;
        if (!SystemUtils.c()) {
            return str;
        }
        String I = DomainSwitcher.I();
        return !TextUtils.isEmpty(I) ? str.replace("l10n-api.huobi.cn/", I) : str;
    }

    public String getWebSocketHost() {
        return null;
    }
}
