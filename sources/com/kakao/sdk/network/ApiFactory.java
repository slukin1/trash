package com.kakao.sdk.network;

import com.kakao.sdk.common.util.a;
import kotlin.Metadata;
import kotlin.i;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Metadata(bv = {}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u001d\u0010\u001eJ\"\u0010\t\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00042\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006R\u001b\u0010\u000e\u001a\u00020\n8FX\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\u000b\u0010\rR\u001b\u0010\u0013\u001a\u00020\u000f8FX\u0002¢\u0006\f\n\u0004\b\u0010\u0010\f\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0017\u001a\u00020\u00148FX\u0002¢\u0006\f\n\u0004\b\u0015\u0010\f\u001a\u0004\b\u0015\u0010\u0016R\u001b\u0010\u0019\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\t\u0010\f\u001a\u0004\b\u0010\u0010\u0018R\u001b\u0010\u001c\u001a\u00020\b8FX\u0002¢\u0006\f\n\u0004\b\u001a\u0010\f\u001a\u0004\b\u001b\u0010\u0018¨\u0006\u001f"}, d2 = {"Lcom/kakao/sdk/network/ApiFactory;", "", "", "url", "Lokhttp3/OkHttpClient$Builder;", "clientBuilder", "Lretrofit2/CallAdapter$Factory;", "factory", "Lretrofit2/Retrofit;", "e", "Lcom/kakao/sdk/network/KakaoAgentInterceptor;", "b", "Lkotlin/i;", "()Lcom/kakao/sdk/network/KakaoAgentInterceptor;", "kakaoAgentInterceptor", "Lcom/kakao/sdk/network/AppKeyInterceptor;", "c", "a", "()Lcom/kakao/sdk/network/AppKeyInterceptor;", "appKeyInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "d", "()Lokhttp3/logging/HttpLoggingInterceptor;", "loggingInterceptor", "()Lretrofit2/Retrofit;", "kapi", "f", "getKapiNoLog", "kapiNoLog", "<init>", "()V", "network_release"}, k = 1, mv = {1, 6, 0})
public final class ApiFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final ApiFactory f25114a = new ApiFactory();

    /* renamed from: b  reason: collision with root package name */
    public static final i f25115b = LazyKt__LazyJVMKt.a(ApiFactory$kakaoAgentInterceptor$2.INSTANCE);

    /* renamed from: c  reason: collision with root package name */
    public static final i f25116c = LazyKt__LazyJVMKt.a(ApiFactory$appKeyInterceptor$2.INSTANCE);

    /* renamed from: d  reason: collision with root package name */
    public static final i f25117d = LazyKt__LazyJVMKt.a(ApiFactory$loggingInterceptor$2.INSTANCE);

    /* renamed from: e  reason: collision with root package name */
    public static final i f25118e = LazyKt__LazyJVMKt.a(ApiFactory$kapi$2.INSTANCE);

    /* renamed from: f  reason: collision with root package name */
    public static final i f25119f = LazyKt__LazyJVMKt.a(ApiFactory$kapiNoLog$2.INSTANCE);

    public static /* synthetic */ Retrofit f(ApiFactory apiFactory, String str, OkHttpClient.Builder builder, CallAdapter.Factory factory, int i11, Object obj) {
        if ((i11 & 4) != 0) {
            factory = null;
        }
        return apiFactory.e(str, builder, factory);
    }

    public final AppKeyInterceptor a() {
        return (AppKeyInterceptor) f25116c.getValue();
    }

    public final KakaoAgentInterceptor b() {
        return (KakaoAgentInterceptor) f25115b.getValue();
    }

    public final Retrofit c() {
        return (Retrofit) f25118e.getValue();
    }

    public final HttpLoggingInterceptor d() {
        return (HttpLoggingInterceptor) f25117d.getValue();
    }

    public final Retrofit e(String str, OkHttpClient.Builder builder, CallAdapter.Factory factory) {
        Retrofit.Builder client = new Retrofit.Builder().baseUrl(str).addConverterFactory(new KakaoRetrofitConverterFactory()).addConverterFactory(GsonConverterFactory.create(a.f25105a.b())).client(builder.build());
        if (factory != null) {
            client.addCallAdapterFactory(factory);
        }
        return client.build();
    }
}
