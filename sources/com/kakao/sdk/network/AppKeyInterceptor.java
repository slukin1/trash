package com.kakao.sdk.network;

import com.kakao.sdk.common.KakaoSdk;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import okhttp3.Interceptor;
import okhttp3.Response;

@Metadata(bv = {}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0011\u0012\b\b\u0002\u0010\t\u001a\u00020\u0006¢\u0006\u0004\b\n\u0010\u000bJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0016R\u0014\u0010\t\u001a\u00020\u00068\u0002X\u0004¢\u0006\u0006\n\u0004\b\u0007\u0010\b¨\u0006\f"}, d2 = {"Lcom/kakao/sdk/network/AppKeyInterceptor;", "Lokhttp3/Interceptor;", "Lokhttp3/Interceptor$Chain;", "chain", "Lokhttp3/Response;", "intercept", "", "a", "Ljava/lang/String;", "appKey", "<init>", "(Ljava/lang/String;)V", "network_release"}, k = 1, mv = {1, 6, 0})
public final class AppKeyInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public final String f25120a;

    public AppKeyInterceptor() {
        this((String) null, 1, (r) null);
    }

    public AppKeyInterceptor(String str) {
        this.f25120a = str;
    }

    public Response intercept(Interceptor.Chain chain) {
        return chain.proceed(chain.request().newBuilder().addHeader("Authorization", x.i("KakaoAK ", this.f25120a)).build());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ AppKeyInterceptor(String str, int i11, r rVar) {
        this((i11 & 1) != 0 ? KakaoSdk.f25078a.a().d() : str);
    }
}
