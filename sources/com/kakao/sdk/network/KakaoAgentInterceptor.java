package com.kakao.sdk.network;

import com.kakao.sdk.common.KakaoSdk;
import com.kakao.sdk.common.model.ContextInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0006¢\u0006\u0004\b\f\u0010\rJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0017\u0010\u000b\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\t\u0010\n¨\u0006\u000e"}, d2 = {"Lcom/kakao/sdk/network/KakaoAgentInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "Lcom/kakao/sdk/common/model/ContextInfo;", "a", "Lcom/kakao/sdk/common/model/ContextInfo;", "getContextInfo", "()Lcom/kakao/sdk/common/model/ContextInfo;", "contextInfo", "<init>", "(Lcom/kakao/sdk/common/model/ContextInfo;)V", "network_release"}, k = 1, mv = {1, 6, 0})
public final class KakaoAgentInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public final ContextInfo f25121a;

    public KakaoAgentInterceptor() {
        this((ContextInfo) null, 1, (r) null);
    }

    public KakaoAgentInterceptor(ContextInfo contextInfo) {
        this.f25121a = contextInfo;
    }

    public Response intercept(Interceptor.Chain chain) {
        Request request = chain.request();
        return chain.proceed(request.newBuilder().addHeader("KA", this.f25121a.c()).build());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ KakaoAgentInterceptor(ContextInfo contextInfo, int i11, r rVar) {
        this((i11 & 1) != 0 ? KakaoSdk.f25078a.a() : contextInfo);
    }
}
