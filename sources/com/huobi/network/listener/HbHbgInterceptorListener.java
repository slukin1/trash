package com.huobi.network.listener;

import android.text.TextUtils;
import bh.u;
import c9.b;
import com.hbg.lib.common.network.interceptor.LogginInterceptor;
import com.hbg.lib.common.utils.SystemUtils;
import com.huobi.domain.DomainSwitcher;
import com.huobi.network.interceptor.ActiveInterceptor;
import com.huobi.network.interceptor.HeaderInterceptor;
import com.huobi.network.interceptor.ProInterceptor;
import com.huobi.network.interceptor.SocketHeaderInterceptor;
import com.huobi.network.interceptor.VulcanInterceptor;
import com.huobi.network.listener.HttpLoggingInterceptor;
import com.huobi.otc.aliyun.global.AliyunGlobalInterceptor;
import no.m;
import okhttp3.OkHttpClient;

public class HbHbgInterceptorListener implements b {
    public static String a() {
        String str = wi.b.f48049m;
        if (!SystemUtils.c()) {
            return str;
        }
        String O = DomainSwitcher.O();
        if (TextUtils.isEmpty(O) || !str.contains("l10n-api.huobi.cn")) {
            return str;
        }
        String[] split = str.split("l10n-api.huobi.cn");
        if (split.length <= 1 || !split[1].startsWith("/") || !O.endsWith("/")) {
            return str;
        }
        String substring = split[1].substring(1);
        return split[0] + O + substring;
    }

    public void buildOkHttpClient(OkHttpClient.Builder builder) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor("HBG");
        httpLoggingInterceptor.d(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(m.f()).addInterceptor(new ProInterceptor()).addInterceptor(new LogginInterceptor()).addInterceptor(new VulcanInterceptor()).addInterceptor(new AliyunGlobalInterceptor()).addInterceptor(new HeaderInterceptor()).addInterceptor(httpLoggingInterceptor).addInterceptor(new ActiveInterceptor());
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
        String y11 = DomainSwitcher.y();
        return !TextUtils.isEmpty(y11) ? str.replace("l10n-api.huobi.cn/", y11) : str;
    }

    public String getWebSocketHost() {
        return a();
    }
}
