package com.huobi.network.listener;

import android.text.TextUtils;
import bh.u;
import c9.b;
import com.hbg.lib.common.network.interceptor.LogginInterceptor;
import com.hbg.lib.common.utils.SystemUtils;
import com.huobi.domain.DomainSwitcher;
import com.huobi.network.interceptor.HeaderInterceptor;
import com.huobi.network.interceptor.UcInterceptor;
import com.huobi.network.interceptor.VulcanInterceptor;
import com.huobi.network.listener.HttpLoggingInterceptor;
import com.huobi.otc.aliyun.global.AliyunGlobalInterceptor;
import no.n;
import okhttp3.OkHttpClient;

public class HbUcInterceptorListener implements b {
    public void buildOkHttpClient(OkHttpClient.Builder builder) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor("UC");
        httpLoggingInterceptor.d(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(new UcInterceptor()).addInterceptor(n.b()).addInterceptor(new LogginInterceptor()).addInterceptor(new VulcanInterceptor()).addInterceptor(new HeaderInterceptor()).addInterceptor(new AliyunGlobalInterceptor()).addInterceptor(httpLoggingInterceptor).build();
        u.a(builder);
    }

    public void buildSocketOkHttpClient(OkHttpClient.Builder builder) {
    }

    public String getHost() {
        String str = wi.b.f48039c;
        if (!SystemUtils.c()) {
            return str;
        }
        String Z = DomainSwitcher.Z();
        return !TextUtils.isEmpty(Z) ? str.replace("l10n-uc.huobi.cn/", Z) : str;
    }

    public String getWebSocketHost() {
        return null;
    }
}
