package com.huobi.network.listener;

import android.text.TextUtils;
import bh.u;
import c9.b;
import com.hbg.lib.common.network.interceptor.LogginInterceptor;
import com.hbg.lib.common.utils.SystemUtils;
import com.huobi.domain.DomainSwitcher;
import com.huobi.network.interceptor.ContractSocketHeaderInterceptor;
import com.huobi.network.interceptor.HeaderInterceptor;
import com.huobi.network.interceptor.SwapInterceptor;
import com.huobi.network.interceptor.SwapLoganInterceptor;
import com.huobi.network.interceptor.VulcanInterceptor;
import com.huobi.network.listener.HttpLoggingInterceptor;
import com.huobi.otc.aliyun.global.AliyunGlobalInterceptor;
import i6.d;
import no.a;
import okhttp3.OkHttpClient;

public class HbIndexInterceptorListener implements b {
    public void buildOkHttpClient(OkHttpClient.Builder builder) {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor("DM");
        httpLoggingInterceptor.d(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(new SwapInterceptor()).addInterceptor(a.d()).addInterceptor(new SwapLoganInterceptor()).addInterceptor(new LogginInterceptor()).addInterceptor(new VulcanInterceptor()).addInterceptor(new AliyunGlobalInterceptor()).addInterceptor(new HeaderInterceptor()).addInterceptor(httpLoggingInterceptor);
        u.a(builder);
    }

    public void buildSocketOkHttpClient(OkHttpClient.Builder builder) {
        builder.addInterceptor(new ContractSocketHeaderInterceptor());
    }

    public String getHost() {
        String str = wi.b.f48046j;
        if (SystemUtils.c()) {
            String u11 = DomainSwitcher.u();
            if (!TextUtils.isEmpty(u11)) {
                str = str.replace("l10n-dm-index.xfilecache.com", u11);
            }
        }
        d.j("swap", "index host - " + str);
        return str;
    }

    public String getWebSocketHost() {
        String str = wi.b.f48055s;
        if (SystemUtils.c()) {
            String u11 = DomainSwitcher.u();
            if (!TextUtils.isEmpty(u11)) {
                str = str.replace("l10n-dm-index.xfilecache.com", u11);
            }
        }
        d.j("swap", "index WebSocketHost - " + str);
        return str;
    }
}
