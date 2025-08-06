package com.huobi.network.interceptor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.huobi.utils.MapDeserializerDoubleAsIntFix;
import i6.d;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.Request;
import okhttp3.RequestBody;
import okio.Buffer;

public class VulcanInterceptor implements Interceptor {

    /* renamed from: a  reason: collision with root package name */
    public static final MediaType f78047a = MediaType.parse("application/json; charset=utf-8");

    public class a extends TypeToken<Map<String, Object>> {
        public a() {
        }
    }

    public class b extends TypeToken<Map<String, Object>> {
        public b() {
        }
    }

    public final Request a(Request request, int i11) {
        if (request == null) {
            return null;
        }
        HttpUrl.Builder newBuilder = request.url().newBuilder();
        Map<String, String> g11 = iu.a.f().g(i11);
        if (g11 != null && !g11.isEmpty()) {
            for (Map.Entry next : g11.entrySet()) {
                newBuilder.addEncodedQueryParameter((String) next.getKey(), (String) next.getValue());
            }
        }
        return request.newBuilder().url(newBuilder.build()).build();
    }

    public final Request b(Request request, int i11) throws IOException {
        Request request2;
        RequestBody body = request.body();
        HashMap hashMap = new HashMap();
        if (body instanceof FormBody) {
            FormBody.Builder builder = new FormBody.Builder();
            int i12 = 0;
            while (true) {
                FormBody formBody = (FormBody) body;
                if (i12 >= formBody.size()) {
                    break;
                }
                hashMap.put(formBody.name(i12), formBody.value(i12));
                i12++;
            }
            Map<String, String> d11 = iu.a.f().d(i11);
            if (d11 != null && !d11.isEmpty()) {
                hashMap.putAll(d11);
            }
            for (Map.Entry entry : hashMap.entrySet()) {
                builder.add((String) entry.getKey(), (String) entry.getValue());
            }
            request2 = request.newBuilder().post(builder.build()).build();
        } else if (body instanceof MultipartBody) {
            d.j("vulcan", "RequestBody = MultipartBody");
            request2 = null;
        } else {
            Buffer buffer = new Buffer();
            body.writeTo(buffer);
            String readUtf8 = buffer.readUtf8();
            GsonBuilder gsonBuilder = new GsonBuilder();
            gsonBuilder.registerTypeAdapter(new a().getType(), new MapDeserializerDoubleAsIntFix());
            Gson create = gsonBuilder.create();
            HashMap hashMap2 = (HashMap) create.fromJson(readUtf8, new b().getType());
            Map<String, String> d12 = iu.a.f().d(i11);
            if (d12 != null && !d12.isEmpty()) {
                hashMap2.putAll(d12);
            }
            request2 = request.newBuilder().post(RequestBody.create(f78047a, create.toJson((Object) hashMap2))).build();
        }
        if (request2 == null) {
            return request2;
        }
        HttpUrl.Builder newBuilder = request2.url().newBuilder();
        Map<String, String> g11 = iu.a.f().g(i11);
        if (g11 != null && !g11.isEmpty()) {
            for (Map.Entry next : g11.entrySet()) {
                newBuilder.addEncodedQueryParameter((String) next.getKey(), (String) next.getValue());
            }
        }
        return request2.newBuilder().url(newBuilder.build()).build();
    }

    public final int c(String str) {
        return po.a.c().b(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x003f  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x0044  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r6) throws java.io.IOException {
        /*
            r5 = this;
            okhttp3.Request r0 = r6.request()
            java.lang.String r1 = r0.method()
            okhttp3.HttpUrl r2 = r0.url()
            java.lang.String r2 = r2.encodedPath()
            int r2 = r5.c(r2)
            r3 = -999(0xfffffffffffffc19, float:NaN)
            if (r2 != r3) goto L_0x001d
            okhttp3.Response r6 = r6.proceed(r0)
            return r6
        L_0x001d:
            r3 = 0
            java.lang.String r4 = "POST"
            boolean r4 = r4.equals(r1)     // Catch:{ Exception -> 0x0039 }
            if (r4 == 0) goto L_0x002c
            okhttp3.Request r1 = r5.b(r0, r2)     // Catch:{ Exception -> 0x0039 }
        L_0x002a:
            r3 = r1
            goto L_0x003d
        L_0x002c:
            java.lang.String r4 = "GET"
            boolean r1 = r4.equals(r1)     // Catch:{ Exception -> 0x0039 }
            if (r1 == 0) goto L_0x003d
            okhttp3.Request r1 = r5.a(r0, r2)     // Catch:{ Exception -> 0x0039 }
            goto L_0x002a
        L_0x0039:
            r1 = move-exception
            r1.printStackTrace()
        L_0x003d:
            if (r3 == 0) goto L_0x0044
            okhttp3.Response r6 = r6.proceed(r3)
            return r6
        L_0x0044:
            okhttp3.Response r6 = r6.proceed(r0)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.network.interceptor.VulcanInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
