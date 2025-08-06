package okhttp3;

import d10.l;
import okhttp3.Interceptor;

public final class OkHttpClient$Builder$addNetworkInterceptor$2 implements Interceptor {
    public final /* synthetic */ l<Interceptor.Chain, Response> $block;

    public OkHttpClient$Builder$addNetworkInterceptor$2(l<? super Interceptor.Chain, Response> lVar) {
        this.$block = lVar;
    }

    public final Response intercept(Interceptor.Chain chain) {
        return this.$block.invoke(chain);
    }
}
