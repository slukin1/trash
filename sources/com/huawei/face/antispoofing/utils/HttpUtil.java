package com.huawei.face.antispoofing.utils;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;

public class HttpUtil {
    public static final MediaType JSON = MediaType.parse("application/json;charset=UTF-8");
    public static final long TIME_OUT_FIVE_SECOND = 5;
    public static final String X_APIG_APPCODE = "X-Apig-AppCode";
    public static final String X_AUTH_TOKEN = "X-Auth-Token";

    /* renamed from: a  reason: collision with root package name */
    private static final Interceptor f37603a = new a();

    public static class a implements Interceptor {
        public Response intercept(Interceptor.Chain chain) throws IOException {
            String str;
            try {
                str = System.getProperty("http.agent");
            } catch (Exception unused) {
                str = "Dalvik/0.0.0 (Linux; U; Android -1; Android Phone)";
            }
            return chain.proceed(chain.request().newBuilder().removeHeader("User-Agent").addHeader("User-Agent", str).build());
        }
    }

    private HttpUtil() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0045, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0046, code lost:
        if (r3 != null) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x004c, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004d, code lost:
        r0.addSuppressed(r3);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0050, code lost:
        throw r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String doGet(java.lang.String r3) throws java.io.IOException {
        /*
            okhttp3.OkHttpClient r0 = new okhttp3.OkHttpClient
            r0.<init>()
            okhttp3.Request$Builder r1 = new okhttp3.Request$Builder
            r1.<init>()
            okhttp3.Request$Builder r3 = r1.url((java.lang.String) r3)
            okhttp3.Request r3 = r3.build()
            okhttp3.Call r3 = r0.newCall(r3)
            okhttp3.Response r3 = r3.execute()
            boolean r0 = r3.isSuccessful()     // Catch:{ all -> 0x0043 }
            if (r0 == 0) goto L_0x002c
            okhttp3.ResponseBody r0 = r3.body()     // Catch:{ all -> 0x0043 }
            java.lang.String r0 = r0.string()     // Catch:{ all -> 0x0043 }
            r3.close()
            return r0
        L_0x002c:
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0043 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0043 }
            r1.<init>()     // Catch:{ all -> 0x0043 }
            java.lang.String r2 = "Unexpected code "
            r1.append(r2)     // Catch:{ all -> 0x0043 }
            r1.append(r3)     // Catch:{ all -> 0x0043 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0043 }
            r0.<init>(r1)     // Catch:{ all -> 0x0043 }
            throw r0     // Catch:{ all -> 0x0043 }
        L_0x0043:
            r0 = move-exception
            throw r0     // Catch:{ all -> 0x0045 }
        L_0x0045:
            r1 = move-exception
            if (r3 == 0) goto L_0x0050
            r3.close()     // Catch:{ all -> 0x004c }
            goto L_0x0050
        L_0x004c:
            r3 = move-exception
            r0.addSuppressed(r3)
        L_0x0050:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huawei.face.antispoofing.utils.HttpUtil.doGet(java.lang.String):java.lang.String");
    }

    public static Response doPost(String str, String str2, String str3, boolean z11, String str4) throws IOException {
        Request build = new Request.Builder().url(str).header(str4, str3).post(RequestBody.create(JSON, str2)).build();
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(5, timeUnit).readTimeout(5, timeUnit).writeTimeout(5, timeUnit).addInterceptor(f37603a);
        if (z11) {
            HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
            httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(httpLoggingInterceptor);
        }
        return builder.build().newCall(build).execute();
    }
}
