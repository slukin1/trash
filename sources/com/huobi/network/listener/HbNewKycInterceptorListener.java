package com.huobi.network.listener;

import android.text.TextUtils;
import bh.u;
import c9.b;
import com.hbg.lib.common.network.interceptor.LogginInterceptor;
import com.hbg.lib.common.utils.SystemUtils;
import com.huobi.domain.DomainSwitcher;
import com.huobi.network.interceptor.HeaderInterceptor;
import com.huobi.network.interceptor.NewKycInterceptor;
import com.huobi.network.interceptor.SocketHeaderInterceptor;
import com.huobi.network.interceptor.VulcanInterceptor;
import com.huobi.network.listener.HttpLoggingInterceptor;
import com.huobi.otc.aliyun.global.AliyunGlobalInterceptor;
import no.i;
import okhttp3.OkHttpClient;

public class HbNewKycInterceptorListener implements b {
    public void buildOkHttpClient(OkHttpClient.Builder builder) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor("NEW_KYC");
        httpLoggingInterceptor.d(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(i.e()).addInterceptor(new NewKycInterceptor()).addInterceptor(new LogginInterceptor()).addInterceptor(new VulcanInterceptor()).addInterceptor(new AliyunGlobalInterceptor()).addInterceptor(new HeaderInterceptor()).addInterceptor(httpLoggingInterceptor);
        u.a(builder);
    }

    public void buildSocketOkHttpClient(OkHttpClient.Builder builder) {
        builder.addInterceptor(new SocketHeaderInterceptor());
    }

    public String getHost() {
        String str = wi.b.f48040d;
        if (!SystemUtils.c()) {
            return str;
        }
        String z11 = DomainSwitcher.z();
        return !TextUtils.isEmpty(z11) ? str.replace("l10n-api.huobi.cn/", z11) : str;
    }

    public String getWebSocketHost() {
        return null;
    }
}
