package com.kakao.sdk.network;

import java.util.Date;
import retrofit2.Converter;

public final /* synthetic */ class d implements Converter {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ d f25124a = new d();

    public final Object convert(Object obj) {
        return KakaoRetrofitConverterFactory.f((Date) obj);
    }
}
