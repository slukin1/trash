package com.huochat.community.network;

import com.google.common.net.HttpHeaders;
import com.huochat.community.base.CommunityConstants;
import com.sumsub.sns.internal.core.common.n0;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/* renamed from: com.huochat.community.network.CommunityIntercepter$buildOkHttpClient$$inlined$-addInterceptor$1  reason: invalid class name */
public final class CommunityIntercepter$buildOkHttpClient$$inlined$addInterceptor$1 implements Interceptor {
    public final Response intercept(Interceptor.Chain chain) {
        Request request = chain.request();
        return chain.proceed(request.newBuilder().headers(request.headers().newBuilder().add("HB-IM-VERSION", CommunityConstants.COMMUNITY_SDK_VERSION).add("HB-IM-OS", n0.f32119g).add("HB-IM-CHANNEL", CommunityConstants.COMMUNITY_SDK_CHANNEL).add("User-Agent", "agent").add(HttpHeaders.CONNECTION, "close").build()).build());
    }
}
