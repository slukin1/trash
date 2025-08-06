package com.kakao.sdk.network;

import java.util.Map;
import retrofit2.Converter;

public final /* synthetic */ class e implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ e f25125a = new e();

    public final Object convert(Object obj) {
        return KakaoRetrofitConverterFactory.g((Map) obj);
    }
}
