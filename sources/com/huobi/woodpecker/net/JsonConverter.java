package com.huobi.woodpecker.net;

import bv.d;
import bv.h;
import com.huobi.woodpecker.kalle.Response;
import java.lang.reflect.Type;
import kv.e;

public abstract class JsonConverter<S> implements d {
    public h<S, String> a(Type type, Type type2, Response response, boolean z11) throws Exception {
        String str;
        int b11 = response.b();
        String string = response.a().string();
        e.m("JsonConverter", "Server Data:" + string);
        Object obj = null;
        if (b11 < 200 || b11 >= 300) {
            str = (b11 < 400 || b11 >= 500) ? b11 >= 500 ? "服务器开小差啦" : null : "发生未知异常";
        } else {
            HttpEntity fromJsonStr = HttpEntity.fromJsonStr(string);
            if (fromJsonStr.isSuccess()) {
                try {
                    obj = b(fromJsonStr.getData(), type);
                    str = null;
                } catch (Exception unused) {
                    str = "服务器数据格式异常";
                }
            } else {
                str = fromJsonStr.getMessage();
            }
        }
        return h.d().g(response.b()).j(response.e()).i(z11).k(obj).h(str).f();
    }

    public abstract S b(String str, Type type);
}
