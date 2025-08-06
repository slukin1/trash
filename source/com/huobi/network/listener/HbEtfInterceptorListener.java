package com.huobi.network.listener;

import android.text.TextUtils;
import bh.u;
import c9.b;
import com.hbg.lib.common.network.interceptor.LogginInterceptor;
import com.hbg.lib.common.utils.SystemUtils;
import com.huobi.domain.DomainSwitcher;
import com.huobi.network.interceptor.EtfErrorCheckInterceptor;
import com.huobi.network.interceptor.EtfInterceptor;
import com.huobi.network.interceptor.SocketHeaderInterceptor;
import com.huobi.network.listener.HttpLoggingInterceptor;
import okhttp3.OkHttpClient;

public class HbEtfInterceptorListener implements b {
    public void buildOkHttpClient(OkHttpClient.Builder builder) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor("ETF");
        httpLoggingInterceptor.d(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(EtfErrorCheckInterceptor.q()).addInterceptor(new EtfInterceptor()).addInterceptor(new LogginInterceptor()).addInterceptor(httpLoggingInterceptor);
        u.a(builder);
    }

    public void buildSocketOkHttpClient(OkHttpClient.Builder builder) {
        builder.addInterceptor(new SocketHeaderInterceptor());
    }

    public String getHost() {
        String str = wi.b.f48041e;
        if (!SystemUtils.c()) {
            return str;
        }
        String v11 = DomainSwitcher.v();
        return !TextUtils.isEmpty(v11) ? str.replace("l10n-api.huobi.cn/", v11) : str;
    }

    public String getWebSocketHost() {
        return null;
    }
}
