package com.huobi.network.listener;

import com.facebook.stetho.inspector.network.DecompressionHelper;
import com.google.common.net.HttpHeaders;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import com.xiaomi.mipush.sdk.Constants;
import java.io.EOFException;
import java.nio.charset.Charset;
import java.util.Collections;
import java.util.Objects;
import java.util.Set;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okio.Buffer;

public final class HttpLoggingInterceptor implements Interceptor {

    /* renamed from: d  reason: collision with root package name */
    public static final Charset f78052d = Charset.forName("UTF-8");

    /* renamed from: a  reason: collision with root package name */
    public final a f78053a;

    /* renamed from: b  reason: collision with root package name */
    public volatile Set<String> f78054b;

    /* renamed from: c  reason: collision with root package name */
    public volatile Level f78055c;

    public enum Level {
        NONE,
        BASIC,
        HEADERS,
        BODY
    }

    public interface a {
        void log(String str);
    }

    public HttpLoggingInterceptor() {
        this((a) new HbInterceptorLogger());
    }

    public static boolean a(Headers headers) {
        String str = headers.get(HttpHeaders.CONTENT_ENCODING);
        return str != null && !str.equalsIgnoreCase("identity") && !str.equalsIgnoreCase(DecompressionHelper.GZIP_ENCODING);
    }

    public static boolean b(Buffer buffer) {
        try {
            Buffer buffer2 = new Buffer();
            buffer.copyTo(buffer2, 0, buffer.size() < 64 ? buffer.size() : 64);
            for (int i11 = 0; i11 < 16; i11++) {
                if (buffer2.exhausted()) {
                    return true;
                }
                int readUtf8CodePoint = buffer2.readUtf8CodePoint();
                if (Character.isISOControl(readUtf8CodePoint) && !Character.isWhitespace(readUtf8CodePoint)) {
                    return false;
                }
            }
            return true;
        } catch (EOFException unused) {
            return false;
        }
    }

    public final void c(StringBuffer stringBuffer, Headers headers, int i11) {
        String value = this.f78054b.contains(headers.name(i11)) ? "██" : headers.value(i11);
        stringBuffer.append(headers.name(i11) + l.f34627b + value);
        stringBuffer.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
    }

    public HttpLoggingInterceptor d(Level level) {
        Objects.requireNonNull(level, "level == null. Use Level.NONE instead.");
        this.f78055c = level;
        return this;
    }

    /* JADX WARNING: type inference failed for: r1v32, types: [java.lang.Long] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:88:0x0324  */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r24) throws java.io.IOException {
        /*
            r23 = this;
            r1 = r23
            r0 = r24
            java.lang.String r2 = "data"
            com.huobi.network.listener.HttpLoggingInterceptor$Level r3 = r1.f78055c
            okhttp3.Request r4 = r24.request()
            com.huobi.network.listener.HttpLoggingInterceptor$Level r5 = com.huobi.network.listener.HttpLoggingInterceptor.Level.NONE
            if (r3 != r5) goto L_0x0015
            okhttp3.Response r0 = r0.proceed(r4)
            return r0
        L_0x0015:
            com.huobi.network.listener.HttpLoggingInterceptor$Level r5 = com.huobi.network.listener.HttpLoggingInterceptor.Level.BODY
            r6 = 1
            if (r3 != r5) goto L_0x001c
            r5 = r6
            goto L_0x001d
        L_0x001c:
            r5 = 0
        L_0x001d:
            if (r5 != 0) goto L_0x0026
            com.huobi.network.listener.HttpLoggingInterceptor$Level r8 = com.huobi.network.listener.HttpLoggingInterceptor.Level.HEADERS
            if (r3 != r8) goto L_0x0024
            goto L_0x0026
        L_0x0024:
            r3 = 0
            goto L_0x0027
        L_0x0026:
            r3 = r6
        L_0x0027:
            okhttp3.RequestBody r8 = r4.body()
            if (r8 == 0) goto L_0x002e
            goto L_0x002f
        L_0x002e:
            r6 = 0
        L_0x002f:
            okhttp3.Connection r9 = r24.connection()
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "\n--> "
            r10.append(r11)
            java.lang.String r11 = r4.method()
            r10.append(r11)
            r11 = 32
            r10.append(r11)
            okhttp3.HttpUrl r12 = r4.url()
            r10.append(r12)
            java.lang.String r12 = ""
            if (r9 == 0) goto L_0x006a
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            java.lang.String r14 = " "
            r13.append(r14)
            okhttp3.Protocol r9 = r9.protocol()
            r13.append(r9)
            java.lang.String r9 = r13.toString()
            goto L_0x006b
        L_0x006a:
            r9 = r12
        L_0x006b:
            r10.append(r9)
            java.lang.String r9 = r10.toString()
            java.lang.String r10 = "-byte body)"
            java.lang.String r13 = " ("
            if (r3 != 0) goto L_0x0096
            if (r6 == 0) goto L_0x0096
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r9)
            r14.append(r13)
            r16 = r12
            long r11 = r8.contentLength()
            r14.append(r11)
            r14.append(r10)
            java.lang.String r9 = r14.toString()
            goto L_0x0098
        L_0x0096:
            r16 = r12
        L_0x0098:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            r11.append(r9)
            java.lang.String r9 = " isLogin ["
            r11.append(r9)
            tg.r r12 = tg.r.x()
            boolean r12 = r12.F0()
            r11.append(r12)
            java.lang.String r12 = "]"
            r11.append(r12)
            java.lang.String r11 = r11.toString()
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            r14.append(r11)
            java.lang.String r11 = " t name ["
            r14.append(r11)
            java.lang.Thread r11 = java.lang.Thread.currentThread()
            java.lang.String r11 = r11.getName()
            r14.append(r11)
            r14.append(r12)
            java.lang.String r11 = r14.toString()
            java.lang.StringBuffer r14 = new java.lang.StringBuffer
            r14.<init>(r11)
            java.lang.String r11 = "-byte body omitted)"
            java.lang.String r7 = "\n"
            if (r3 == 0) goto L_0x01d3
            if (r6 == 0) goto L_0x00eb
            r8.contentType()
            r8.contentLength()
        L_0x00eb:
            okhttp3.Headers r15 = r4.headers()
            r18 = r2
            int r2 = r15.size()
            r19 = r12
            r12 = 0
        L_0x00f8:
            if (r12 >= r2) goto L_0x011c
            r17 = r2
            java.lang.String r2 = r15.name(r12)
            r20 = r9
            java.lang.String r9 = "Content-Type"
            boolean r9 = r9.equalsIgnoreCase(r2)
            if (r9 != 0) goto L_0x0115
            java.lang.String r9 = "Content-Length"
            boolean r2 = r9.equalsIgnoreCase(r2)
            if (r2 != 0) goto L_0x0115
            r1.c(r14, r15, r12)
        L_0x0115:
            int r12 = r12 + 1
            r2 = r17
            r9 = r20
            goto L_0x00f8
        L_0x011c:
            r20 = r9
            java.lang.String r2 = "--> END "
            if (r5 == 0) goto L_0x01b9
            if (r6 != 0) goto L_0x0126
            goto L_0x01b9
        L_0x0126:
            okhttp3.Headers r6 = r4.headers()
            boolean r6 = a(r6)
            if (r6 == 0) goto L_0x0150
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            java.lang.String r2 = r4.method()
            r6.append(r2)
            java.lang.String r2 = " (encoded body omitted)"
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            r14.append(r2)
            r14.append(r7)
            goto L_0x01d9
        L_0x0150:
            okio.Buffer r6 = new okio.Buffer
            r6.<init>()
            r8.writeTo(r6)
            java.nio.charset.Charset r9 = f78052d
            okhttp3.MediaType r12 = r8.contentType()
            if (r12 == 0) goto L_0x0163
            r12.charset(r9)
        L_0x0163:
            boolean r6 = b(r6)
            if (r6 == 0) goto L_0x0190
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            java.lang.String r2 = r4.method()
            r6.append(r2)
            r6.append(r13)
            long r8 = r8.contentLength()
            r6.append(r8)
            r6.append(r10)
            java.lang.String r2 = r6.toString()
            r14.append(r2)
            r14.append(r7)
            goto L_0x01d9
        L_0x0190:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            java.lang.String r2 = r4.method()
            r6.append(r2)
            java.lang.String r2 = " (binary "
            r6.append(r2)
            long r8 = r8.contentLength()
            r6.append(r8)
            r6.append(r11)
            java.lang.String r2 = r6.toString()
            r14.append(r2)
            r14.append(r7)
            goto L_0x01d9
        L_0x01b9:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            r6.append(r2)
            java.lang.String r2 = r4.method()
            r6.append(r2)
            java.lang.String r2 = r6.toString()
            r14.append(r2)
            r14.append(r7)
            goto L_0x01d9
        L_0x01d3:
            r18 = r2
            r20 = r9
            r19 = r12
        L_0x01d9:
            java.lang.StringBuffer r2 = new java.lang.StringBuffer
            r2.<init>()
            long r8 = java.lang.System.nanoTime()
            okhttp3.Response r4 = r0.proceed(r4)     // Catch:{ Exception -> 0x04a9 }
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.NANOSECONDS
            long r21 = java.lang.System.nanoTime()
            long r8 = r21 - r8
            long r8 = r0.toMillis(r8)
            okhttp3.ResponseBody r0 = r4.body()
            r6 = r14
            long r14 = r0.contentLength()
            r21 = -1
            int r12 = (r14 > r21 ? 1 : (r14 == r21 ? 0 : -1))
            if (r12 == 0) goto L_0x0215
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            r12.append(r14)
            r24 = r6
            java.lang.String r6 = "-byte"
            r12.append(r6)
            java.lang.String r6 = r12.toString()
            goto L_0x0219
        L_0x0215:
            r24 = r6
            java.lang.String r6 = "unknown-length"
        L_0x0219:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            java.lang.String r1 = "<-- "
            r12.append(r1)
            int r1 = r4.code()
            r12.append(r1)
            java.lang.String r1 = r4.message()
            boolean r1 = r1.isEmpty()
            if (r1 == 0) goto L_0x0239
            r17 = r10
            r1 = r16
            goto L_0x0250
        L_0x0239:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r17 = r10
            r10 = 32
            r1.append(r10)
            java.lang.String r10 = r4.message()
            r1.append(r10)
            java.lang.String r1 = r1.toString()
        L_0x0250:
            r12.append(r1)
            r1 = 32
            r12.append(r1)
            okhttp3.Request r1 = r4.request()
            okhttp3.HttpUrl r1 = r1.url()
            r12.append(r1)
            r12.append(r13)
            r12.append(r8)
            java.lang.String r1 = "ms"
            r12.append(r1)
            if (r3 != 0) goto L_0x0287
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r8 = ", "
            r1.append(r8)
            r1.append(r6)
            java.lang.String r6 = " body"
            r1.append(r6)
            java.lang.String r1 = r1.toString()
            goto L_0x0289
        L_0x0287:
            r1 = r16
        L_0x0289:
            r12.append(r1)
            r1 = 41
            r12.append(r1)
            r1 = r20
            r12.append(r1)
            tg.r r1 = tg.r.x()
            boolean r1 = r1.F0()
            r12.append(r1)
            java.lang.String r1 = "] t name ["
            r12.append(r1)
            java.lang.Thread r1 = java.lang.Thread.currentThread()
            java.lang.String r1 = r1.getName()
            r12.append(r1)
            r1 = r19
            r12.append(r1)
            java.lang.String r1 = r12.toString()
            r2.append(r1)
            r2.append(r7)
            if (r3 == 0) goto L_0x04a6
            okhttp3.Headers r1 = r4.headers()
            if (r5 == 0) goto L_0x049e
            boolean r3 = okhttp3.internal.http.HttpHeaders.hasBody(r4)
            if (r3 != 0) goto L_0x02d0
            goto L_0x049e
        L_0x02d0:
            okhttp3.Headers r3 = r4.headers()
            boolean r3 = a(r3)
            if (r3 == 0) goto L_0x02e1
            java.lang.String r0 = "<-- END HTTP (encoded body omitted)"
            r2.append(r0)
            goto L_0x04a6
        L_0x02e1:
            okio.BufferedSource r3 = r0.source()
            r5 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            r3.request(r5)
            okio.Buffer r3 = r3.buffer()
            java.lang.String r5 = "Content-Encoding"
            java.lang.String r1 = r1.get(r5)
            java.lang.String r5 = "gzip"
            boolean r1 = r5.equalsIgnoreCase(r1)
            r5 = 0
            if (r1 == 0) goto L_0x0328
            long r8 = r3.size()
            java.lang.Long r1 = java.lang.Long.valueOf(r8)
            okio.GzipSource r6 = new okio.GzipSource     // Catch:{ all -> 0x0321 }
            okio.Buffer r3 = r3.clone()     // Catch:{ all -> 0x0321 }
            r6.<init>(r3)     // Catch:{ all -> 0x0321 }
            okio.Buffer r3 = new okio.Buffer     // Catch:{ all -> 0x031e }
            r3.<init>()     // Catch:{ all -> 0x031e }
            r3.writeAll(r6)     // Catch:{ all -> 0x031e }
            r6.close()
            r5 = r1
            goto L_0x0328
        L_0x031e:
            r0 = move-exception
            r5 = r6
            goto L_0x0322
        L_0x0321:
            r0 = move-exception
        L_0x0322:
            if (r5 == 0) goto L_0x0327
            r5.close()
        L_0x0327:
            throw r0
        L_0x0328:
            java.nio.charset.Charset r1 = f78052d
            okhttp3.MediaType r0 = r0.contentType()
            if (r0 == 0) goto L_0x0334
            java.nio.charset.Charset r1 = r0.charset(r1)
        L_0x0334:
            boolean r0 = b(r3)
            if (r0 != 0) goto L_0x0359
            r2.append(r7)
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "<-- END HTTP (binary "
            r0.append(r1)
            long r5 = r3.size()
            r0.append(r5)
            r0.append(r11)
            java.lang.String r0 = r0.toString()
            r2.append(r0)
            return r4
        L_0x0359:
            r8 = 0
            int r0 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r0 == 0) goto L_0x0436
            r8 = 3072(0xc00, double:1.518E-320)
            int r0 = (r14 > r8 ? 1 : (r14 == r8 ? 0 : -1))
            if (r0 >= 0) goto L_0x0436
            com.google.gson.Gson r0 = new com.google.gson.Gson     // Catch:{ all -> 0x0415 }
            r0.<init>()     // Catch:{ all -> 0x0415 }
            okio.Buffer r6 = r3.clone()     // Catch:{ all -> 0x0415 }
            java.lang.String r6 = r6.readString(r1)     // Catch:{ all -> 0x0415 }
            java.lang.Class<java.util.Map> r8 = java.util.Map.class
            java.lang.Object r0 = r0.fromJson((java.lang.String) r6, r8)     // Catch:{ all -> 0x0415 }
            java.util.Map r0 = (java.util.Map) r0     // Catch:{ all -> 0x0415 }
            r6 = r18
            boolean r8 = r0.containsKey(r6)     // Catch:{ all -> 0x0415 }
            if (r8 == 0) goto L_0x03ee
            r0.remove(r6)     // Catch:{ all -> 0x0415 }
            java.lang.String r6 = r0.toString()     // Catch:{ all -> 0x0415 }
            boolean r8 = com.alibaba.android.arouter.utils.TextUtils.c(r6)     // Catch:{ all -> 0x0415 }
            if (r8 != 0) goto L_0x0436
            java.lang.String r8 = "ok"
            boolean r8 = r6.contains(r8)     // Catch:{ all -> 0x0415 }
            if (r8 != 0) goto L_0x03c7
            java.lang.String r8 = "true"
            boolean r6 = r6.contains(r8)     // Catch:{ all -> 0x0415 }
            if (r6 == 0) goto L_0x03a0
            goto L_0x03c7
        L_0x03a0:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0415 }
            r6.<init>()     // Catch:{ all -> 0x0415 }
            java.lang.String r8 = "parse abnormal response from - "
            r6.append(r8)     // Catch:{ all -> 0x0415 }
            okhttp3.Request r8 = r4.request()     // Catch:{ all -> 0x0415 }
            okhttp3.HttpUrl r8 = r8.url()     // Catch:{ all -> 0x0415 }
            r6.append(r8)     // Catch:{ all -> 0x0415 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0415 }
            r2.append(r6)     // Catch:{ all -> 0x0415 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0415 }
            r2.append(r0)     // Catch:{ all -> 0x0415 }
            r2.append(r7)     // Catch:{ all -> 0x0415 }
            goto L_0x0436
        L_0x03c7:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0415 }
            r6.<init>()     // Catch:{ all -> 0x0415 }
            java.lang.String r8 = "parse normal response from - "
            r6.append(r8)     // Catch:{ all -> 0x0415 }
            okhttp3.Request r8 = r4.request()     // Catch:{ all -> 0x0415 }
            okhttp3.HttpUrl r8 = r8.url()     // Catch:{ all -> 0x0415 }
            r6.append(r8)     // Catch:{ all -> 0x0415 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0415 }
            r2.append(r6)     // Catch:{ all -> 0x0415 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0415 }
            r2.append(r0)     // Catch:{ all -> 0x0415 }
            r2.append(r7)     // Catch:{ all -> 0x0415 }
            goto L_0x0436
        L_0x03ee:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0415 }
            r6.<init>()     // Catch:{ all -> 0x0415 }
            java.lang.String r8 = "parse no-data response from - "
            r6.append(r8)     // Catch:{ all -> 0x0415 }
            okhttp3.Request r8 = r4.request()     // Catch:{ all -> 0x0415 }
            okhttp3.HttpUrl r8 = r8.url()     // Catch:{ all -> 0x0415 }
            r6.append(r8)     // Catch:{ all -> 0x0415 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0415 }
            r2.append(r6)     // Catch:{ all -> 0x0415 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0415 }
            r2.append(r0)     // Catch:{ all -> 0x0415 }
            r2.append(r7)     // Catch:{ all -> 0x0415 }
            goto L_0x0436
        L_0x0415:
            r0 = move-exception
            java.lang.String r6 = "parse response has error"
            r2.append(r6)
            r2.append(r7)
            java.lang.String r0 = r0.getMessage()
            r2.append(r0)
            r2.append(r7)
            okio.Buffer r0 = r3.clone()
            java.lang.String r0 = r0.readString(r1)
            r2.append(r0)
            r2.append(r7)
        L_0x0436:
            java.lang.String r0 = "<-- END HTTP ("
            if (r5 == 0) goto L_0x045e
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            long r8 = r3.size()
            r1.append(r8)
            java.lang.String r0 = "-byte, "
            r1.append(r0)
            r1.append(r5)
            java.lang.String r0 = "-gzipped-byte body)"
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r2.append(r0)
            goto L_0x0479
        L_0x045e:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r0)
            long r5 = r3.size()
            r1.append(r5)
            r3 = r17
            r1.append(r3)
            java.lang.String r0 = r1.toString()
            r2.append(r0)
        L_0x0479:
            r2.append(r7)
            r1 = r23
            com.huobi.network.listener.HttpLoggingInterceptor$a r0 = r1.f78053a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r5 = r24.toString()
            r3.append(r5)
            r3.append(r7)
            java.lang.String r2 = r2.toString()
            r3.append(r2)
            java.lang.String r2 = r3.toString()
            r0.log(r2)
            goto L_0x04a8
        L_0x049e:
            r1 = r23
            java.lang.String r0 = "<-- END HTTP"
            r2.append(r0)
            goto L_0x04a8
        L_0x04a6:
            r1 = r23
        L_0x04a8:
            return r4
        L_0x04a9:
            r0 = move-exception
            r2 = r0
            com.huobi.network.listener.HttpLoggingInterceptor$a r0 = r1.f78053a
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "<-- HTTP FAILED: "
            r3.append(r4)
            r3.append(r2)
            java.lang.String r3 = r3.toString()
            r0.log(r3)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.network.listener.HttpLoggingInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }

    public HttpLoggingInterceptor(String str) {
        this((a) new HbInterceptorLogger(str));
    }

    public HttpLoggingInterceptor(a aVar) {
        this.f78054b = Collections.emptySet();
        this.f78055c = Level.NONE;
        this.f78053a = aVar;
    }
}
