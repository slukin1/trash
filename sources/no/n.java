package no;

import android.text.TextUtils;
import bh.j;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.hbg.lib.widgets.utils.HuobiToastUtil;
import com.huobi.utils.MapDeserializerDoubleAsIntFix;
import i6.k;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;
import org.greenrobot.eventbus.EventBus;
import tg.r;

public final class n implements Interceptor {

    /* renamed from: b  reason: collision with root package name */
    public static final n f84507b = new n();

    /* renamed from: a  reason: collision with root package name */
    public Gson f84508a;

    public class a extends TypeToken<Map<String, Object>> {
        public a() {
        }
    }

    public class b extends TypeToken<Map<String, Object>> {
        public b() {
        }
    }

    public n() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(new a().getType(), new MapDeserializerDoubleAsIntFix());
        this.f84508a = gsonBuilder.create();
    }

    public static String a(Response response) {
        String httpUrl = response != null ? response.request().url().toString() : "";
        return " t - [" + Thread.currentThread().getName() + "] from - [" + httpUrl + "] isLogin [" + r.x().F0() + "]";
    }

    public static n b() {
        return f84507b;
    }

    public final boolean c(Map map) {
        if (map.get("code") == null) {
            return false;
        }
        return String.valueOf(512).equals(map.get("code").toString());
    }

    public final void d(Response response, Request request, Map<String, Object> map) {
        r x11 = r.x();
        x11.m("UCTokenInterceptor#tokenFailed - " + a(response), false);
        EventBus.d().k(new mo.a(String.valueOf(response.code()), response.message()));
        EventBus.d().k(new p6.a(String.valueOf(response.code()), response.message()));
        k.f("LOGIN", "UC-TOKEN token Failed " + a(response));
        Object obj = map.get("message");
        if (obj != null && !TextUtils.isEmpty(obj.toString())) {
            HuobiToastUtil.l(j.c(), obj.toString());
        }
    }

    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        Response proceed = chain.proceed(request);
        try {
            ResponseBody body = proceed.body();
            Map map = (Map) this.f84508a.fromJson(body.source().buffer().clone().readString(body.contentType() != null ? body.contentType().charset(StandardCharsets.UTF_8) : StandardCharsets.UTF_8), new b().getType());
            if (map == null) {
                map = new HashMap();
            } else {
                map.remove("data");
            }
            if (c(map)) {
                k.f("LOGIN", "UC-TOKEN token hasTokenError " + a(proceed));
                d(proceed, request, map);
                return proceed;
            }
            k.f("LOGIN", "UC-TOKEN no token error code" + a(proceed));
            return proceed;
        } catch (Exception e11) {
            k.g("LOGIN", "UC-TOKEN token Exception", e11);
            e11.printStackTrace();
            k.f("LOGIN", "UC-TOKEN token zzzzz " + a(proceed));
            return proceed;
        }
    }
}
