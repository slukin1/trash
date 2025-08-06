package com.kakao.network.response;

import com.kakao.network.response.ResponseBody;

public interface a<F, T> {
    T convert(F f11) throws ResponseBody.ResponseBodyException;
}
