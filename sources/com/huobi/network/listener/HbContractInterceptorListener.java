package com.huobi.network.listener;

import android.text.TextUtils;
import bh.u;
import c9.b;
import com.hbg.lib.common.network.interceptor.LogginInterceptor;
import com.hbg.lib.common.utils.SystemUtils;
import com.huobi.domain.DomainSwitcher;
import com.huobi.network.interceptor.ContractInterceptor;
import com.huobi.network.interceptor.ContractSocketHeaderInterceptor;
import com.huobi.network.interceptor.HeaderInterceptor;
import com.huobi.network.interceptor.VulcanInterceptor;
import com.huobi.network.listener.HttpLoggingInterceptor;
import com.huobi.otc.aliyun.global.AliyunGlobalInterceptor;
import no.a;
import okhttp3.OkHttpClient;

public class HbContractInterceptorListener implements b {
    public void buildOkHttpClient(OkHttpClient.Builder builder) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor("DM");
        httpLoggingInterceptor.d(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(new ContractInterceptor()).addInterceptor(a.d()).addInterceptor(new LogginInterceptor()).addInterceptor(new VulcanInterceptor()).addInterceptor(new AliyunGlobalInterceptor()).addInterceptor(new HeaderInterceptor()).addInterceptor(httpLoggingInterceptor);
        u.a(builder);
    }

    public void buildSocketOkHttpClient(OkHttpClient.Builder builder) {
        builder.addInterceptor(new ContractSocketHeaderInterceptor());
    }

    public String getHost() {
        String str = wi.b.f48044h;
        if (!SystemUtils.c()) {
            return str;
        }
        String x11 = DomainSwitcher.x();
        return !TextUtils.isEmpty(x11) ? str.replace("l10n-dm.huobi.cn", x11) : str;
    }

    public String getWebSocketHost() {
        String str = wi.b.f48050n;
        if (!SystemUtils.c()) {
            return str;
        }
        String x11 = DomainSwitcher.x();
        return !TextUtils.isEmpty(x11) ? str.replace("l10n-dm.huobi.cn", x11) : str;
    }
}
