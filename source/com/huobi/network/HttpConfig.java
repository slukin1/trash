package com.huobi.network;

import bh.u;
import com.hbg.lib.common.network.interceptor.JsonLevelChangeInterceptor;
import com.hbg.lib.network.contract.retrofit.ContractRetrofit;
import com.hbg.lib.network.hbg.retrofit.HbgRetrofit;
import com.hbg.lib.network.otc.retrofit.OtcRetrofit;
import com.hbg.lib.network.pro.retrofit.ProRetrofit;
import com.huobi.domain.DomainTestInterceptor;
import com.huobi.network.interceptor.EtfErrorCheckInterceptor;
import com.huobi.network.interceptor.EtfInterceptor;
import com.huobi.network.interceptor.HeaderInterceptor;
import com.huobi.network.interceptor.PhpInterceptor;
import com.huobi.network.interceptor.RiskLoganInterceptor;
import com.huobi.network.interceptor.UcInterceptor;
import com.huobi.network.interceptor.VulcanInterceptor;
import com.huobi.network.listener.HttpLoggingInterceptor;
import com.huobi.otc.aliyun.global.AliyunGlobalInterceptor;
import java.util.concurrent.TimeUnit;
import no.g;
import no.n;
import okhttp3.OkHttpClient;

public class HttpConfig {

    /* renamed from: a  reason: collision with root package name */
    public static OkHttpClient f78029a;

    /* renamed from: b  reason: collision with root package name */
    public static OkHttpClient f78030b;

    /* renamed from: c  reason: collision with root package name */
    public static OkHttpClient f78031c;

    /* renamed from: d  reason: collision with root package name */
    public static OkHttpClient f78032d;

    /* renamed from: e  reason: collision with root package name */
    public static OkHttpClient f78033e;

    public static OkHttpClient.Builder a(boolean z11) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(15, timeUnit).readTimeout(15, timeUnit).writeTimeout(15, timeUnit).retryOnConnectionFailure(z11).addInterceptor(new HeaderInterceptor());
        u.a(builder);
        return builder;
    }

    public static OkHttpClient b() {
        return ContractRetrofit.i().getOkHttpClient();
    }

    public static OkHttpClient c() {
        if (f78032d == null) {
            OkHttpClient.Builder a11 = a(false);
            TimeUnit timeUnit = TimeUnit.SECONDS;
            f78032d = a11.connectTimeout(5, timeUnit).readTimeout(5, timeUnit).writeTimeout(5, timeUnit).addInterceptor(new HeaderInterceptor()).addInterceptor(new AliyunGlobalInterceptor()).addInterceptor(new DomainTestInterceptor()).build();
        }
        return f78032d;
    }

    public static OkHttpClient d() {
        if (f78031c == null) {
            new HttpLoggingInterceptor("ETF").d(HttpLoggingInterceptor.Level.BODY);
            f78031c = a(false).addInterceptor(EtfErrorCheckInterceptor.q()).addInterceptor(new EtfInterceptor()).build();
        }
        return f78031c;
    }

    public static OkHttpClient e() {
        return HbgRetrofit.d().getOkHttpClient();
    }

    public static OkHttpClient f() {
        return OtcRetrofit.g().getOkHttpClient();
    }

    public static OkHttpClient g() {
        if (f78029a == null) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor("HB");
            httpLoggingInterceptor.d(HttpLoggingInterceptor.Level.BASIC);
            f78029a = a(false).addInterceptor(g.e()).addInterceptor(new JsonLevelChangeInterceptor()).addInterceptor(new PhpInterceptor()).addInterceptor(new VulcanInterceptor()).addInterceptor(new AliyunGlobalInterceptor()).addInterceptor(httpLoggingInterceptor).build();
        }
        return f78029a;
    }

    public static OkHttpClient h() {
        return ProRetrofit.g().getOkHttpClient();
    }

    public static OkHttpClient i() {
        if (f78033e == null) {
            f78033e = a(false).addInterceptor(new VulcanInterceptor()).addInterceptor(new AliyunGlobalInterceptor()).addInterceptor(new RiskLoganInterceptor()).build();
        }
        return f78033e;
    }

    public static OkHttpClient j() {
        if (f78030b == null) {
            new HttpLoggingInterceptor("UC").d(HttpLoggingInterceptor.Level.BODY);
            f78030b = a(false).addInterceptor(n.b()).addInterceptor(new UcInterceptor()).addInterceptor(new VulcanInterceptor()).addInterceptor(new AliyunGlobalInterceptor()).build();
        }
        return f78030b;
    }
}
