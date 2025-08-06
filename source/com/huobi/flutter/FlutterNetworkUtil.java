package com.huobi.flutter;

import com.google.gson.JsonObject;
import i6.d;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import lombok.NonNull;
import retrofit2.Response;
import u6.g;

public class FlutterNetworkUtil {

    public class a extends q6.a<Response<JsonObject>> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MethodChannel.Result f67684a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(g gVar, MethodChannel.Result result) {
            super(gVar);
            this.f67684a = result;
        }

        /* renamed from: a */
        public void onRequestSuccess(Response<JsonObject> response) {
            d.j("OtcNativeNetInterceptor", "native onRequestSuccess--request-->");
            FlutterNetworkUtil.f(response, this.f67684a);
        }

        public void onRequestFailure(Throwable th2) {
            d.j("OtcNativeNetInterceptor", "native onRequestFailure----->" + th2.getMessage());
            FlutterNetworkUtil.e(th2, this.f67684a);
        }
    }

    public static q6.a<Response<JsonObject>> c(g gVar, @NonNull MethodChannel.Result result) {
        Objects.requireNonNull(result, "result is marked @NonNull but is null");
        return new a(gVar, result);
    }

    public static void d(g gVar, MethodCall methodCall, MethodChannel.Result result) {
        try {
            String str = (String) methodCall.argument("method");
            String str2 = (String) methodCall.argument("url");
            Map map = (Map) methodCall.argument("queryParameters");
            Map map2 = (Map) methodCall.argument("data");
            Map map3 = (Map) methodCall.argument("header");
            d.j("OtcNativeNetInterceptor", "native methodName--->" + str);
            if ("GET".equalsIgnoreCase(str)) {
                if (map != null) {
                    map.values().removeAll(Collections.singleton((Object) null));
                }
                s8.a.a().otcGet(str2, map, map3).d(c(gVar, result));
                return;
            }
            if (map2 != null) {
                map2.values().removeAll(Collections.singleton((Object) null));
            }
            Object obj = map3.get("content-type");
            StringBuilder sb2 = new StringBuilder();
            sb2.append("native methodName--->");
            sb2.append(str);
            sb2.append("  ");
            String str3 = "";
            sb2.append(obj == null ? str3 : obj.toString());
            d.j("OtcNativeNetInterceptor", sb2.toString());
            if (obj != null) {
                str3 = obj.toString();
            }
            if (!str3.toLowerCase().contains("application/json")) {
                s8.a.a().otcPostFormUrlEncoded(str2, map2, map3).d(c(gVar, result));
            } else if (map2 == null || map2.isEmpty()) {
                s8.a.a().otcPostNoBody(str2, map3).d(c(gVar, result));
            } else {
                s8.a.a().otcPostBody(str2, map2, map3).d(c(gVar, result));
            }
        } catch (Exception unused) {
            result.notImplemented();
        }
    }

    public static void e(Throwable th2, MethodChannel.Result result) {
        HashMap hashMap = new HashMap();
        hashMap.put("error", th2.getMessage());
        result.success(hashMap);
    }

    public static void f(Response<JsonObject> response, MethodChannel.Result result) {
        if (response != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("code", Integer.valueOf(response.code()));
            hashMap.put("message", response.message());
            hashMap.put("data", response.body() != null ? response.body().toString() : "{}");
            hashMap.put("headers", response.headers().toMultimap());
            result.success(hashMap);
            return;
        }
        HashMap hashMap2 = new HashMap();
        hashMap2.put("error", "error");
        result.success(hashMap2);
    }
}
