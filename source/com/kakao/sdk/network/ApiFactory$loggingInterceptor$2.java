package com.kakao.sdk.network;

import com.kakao.sdk.common.util.SdkLog;
import d10.a;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import okhttp3.logging.HttpLoggingInterceptor;

@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "Lokhttp3/logging/HttpLoggingInterceptor;", "invoke"}, k = 3, mv = {1, 6, 0}, xi = 48)
public final class ApiFactory$loggingInterceptor$2 extends Lambda implements a<HttpLoggingInterceptor> {
    public static final ApiFactory$loggingInterceptor$2 INSTANCE = new ApiFactory$loggingInterceptor$2();

    public ApiFactory$loggingInterceptor$2() {
        super(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: invoke$lambda-0  reason: not valid java name */
    public static final void m13invoke$lambda0(String str) {
        SdkLog.f25100d.d(str);
    }

    public final HttpLoggingInterceptor invoke() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(a.f25122a);
        httpLoggingInterceptor.level(HttpLoggingInterceptor.Level.HEADERS);
        return httpLoggingInterceptor;
    }
}
