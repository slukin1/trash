package com.kakao.sdk.network;

import com.huochat.community.network.domain.DomainTool;
import com.kakao.sdk.common.KakaoSdk;
import d10.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.x;
import okhttp3.OkHttpClient;
import retrofit2.CallAdapter;
import retrofit2.Retrofit;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lretrofit2/Retrofit;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ApiFactory$kapiNoLog$2 extends Lambda implements a<Retrofit> {
    public static final ApiFactory$kapiNoLog$2 INSTANCE = new ApiFactory$kapiNoLog$2();

    public ApiFactory$kapiNoLog$2() {
        super(0);
    }

    public final Retrofit invoke() {
        ApiFactory apiFactory = ApiFactory.f25114a;
        return ApiFactory.f(apiFactory, x.i(DomainTool.DOMAIN_PREFIX, KakaoSdk.f25078a.b().a()), new OkHttpClient.Builder().addInterceptor(apiFactory.b()).addInterceptor(apiFactory.a()), (CallAdapter.Factory) null, 4, (Object) null);
    }
}
