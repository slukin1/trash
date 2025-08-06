package com.kakao.network.response;

import com.kakao.network.response.ResponseBody;

public abstract class ResponseStringConverter<T> implements a<String, T> {

    /* renamed from: a  reason: collision with root package name */
    public static final ResponseStringConverter<String> f25068a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final ResponseStringConverter<Long> f25069b = new b();

    public static class a extends ResponseStringConverter<String> {
        /* renamed from: a */
        public String convert(String str) {
            return str;
        }
    }

    public static class b extends ResponseStringConverter<Long> {
        /* renamed from: a */
        public Long convert(String str) throws ResponseBody.ResponseBodyException {
            return Long.valueOf(str);
        }
    }
}
