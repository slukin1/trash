package com.huobi.vulcan.net;

import com.huobi.kalle.Response;
import java.lang.reflect.Type;
import lm.d;
import lm.h;
import lu.a;

public abstract class JsonConverter<S> implements d {
    public h<S, String> a(Type type, Type type2, Response response, boolean z11) throws Exception {
        String str;
        int b11 = response.b();
        String string = response.a().string();
        a.f("JsonConverter", "Server Data:" + string);
        Object obj = null;
        if (b11 < 200 || b11 >= 300) {
            str = (b11 < 400 || b11 >= 500) ? b11 >= 500 ? "服务器开小差啦" : null : "发生未知异常";
        } else {
            HttpEntity fromJsonStr = HttpEntity.fromJsonStr(string);
            if (fromJsonStr.isSucceed()) {
                try {
                    obj = b(fromJsonStr.getData(), type);
                    str = null;
                } catch (Exception unused) {
                    str = "服务器数据格式异常";
                }
            } else {
                str = fromJsonStr.isNoUploadCollectData() ? String.valueOf(HttpEntity.CODE_NO_UPLOAD_COLLECT_DATA) : fromJsonStr.getMessage();
            }
        }
        return h.d().g(response.b()).j(response.e()).i(z11).k(obj).h(str).f();
    }

    public abstract S b(String str, Type type);
}
