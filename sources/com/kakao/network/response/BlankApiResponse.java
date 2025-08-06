package com.kakao.network.response;

import com.kakao.network.response.ResponseBody;

public final class BlankApiResponse {

    /* renamed from: a  reason: collision with root package name */
    public static final ResponseStringConverter<Boolean> f25066a = new a();

    public static class a extends ResponseStringConverter<Boolean> {
        /* renamed from: a */
        public Boolean convert(String str) throws ResponseBody.ResponseBodyException {
            return Boolean.TRUE;
        }
    }
}
