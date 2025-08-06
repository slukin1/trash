package com.kakao.network;

import com.kakao.network.callback.ResponseCallback;
import com.kakao.network.response.ResponseStringConverter;
import java.util.concurrent.Future;
import uw.b;
import uw.e;
import xw.c;

public interface NetworkService {

    public static class Factory {
        public static NetworkService a() {
            return new b(c.b());
        }
    }

    <T> Future<T> a(e eVar, ResponseStringConverter<T> responseStringConverter, ResponseCallback<T> responseCallback);
}
