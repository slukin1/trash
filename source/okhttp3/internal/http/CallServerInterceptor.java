package okhttp3.internal.http;

import okhttp3.Interceptor;

public final class CallServerInterceptor implements Interceptor {
    private final boolean forWebSocket;

    public CallServerInterceptor(boolean z11) {
        this.forWebSocket = z11;
    }

    private final boolean shouldIgnoreAndWaitForRealResponse(int i11) {
        if (i11 != 100) {
            if (!(102 <= i11 && i11 < 200)) {
                return false;
            }
        }
        return true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0088, code lost:
        if (r3.isDuplex() == false) goto L_0x008a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0098  */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x00a0 A[SYNTHETIC, Splitter:B:40:0x00a0] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x00d4 A[Catch:{ IOException -> 0x0190 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x010c A[Catch:{ IOException -> 0x0190 }] */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x011b A[Catch:{ IOException -> 0x0190 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x0155 A[Catch:{ IOException -> 0x0190 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x015a A[Catch:{ IOException -> 0x0190 }] */
    /* JADX WARNING: Removed duplicated region for block: B:71:0x0162 A[Catch:{ IOException -> 0x0190 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0199  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public okhttp3.Response intercept(okhttp3.Interceptor.Chain r14) throws java.io.IOException {
        /*
            r13 = this;
            java.lang.String r0 = "Connection"
            java.lang.String r1 = "close"
            okhttp3.internal.http.RealInterceptorChain r14 = (okhttp3.internal.http.RealInterceptorChain) r14
            okhttp3.internal.connection.Exchange r2 = r14.getExchange$okhttp()
            okhttp3.Request r14 = r14.getRequest$okhttp()
            okhttp3.RequestBody r3 = r14.body()
            long r4 = java.lang.System.currentTimeMillis()
            r6 = 0
            r7 = 0
            r8 = 1
            r2.writeRequestHeaders(r14)     // Catch:{ IOException -> 0x0091 }
            java.lang.String r9 = r14.method()     // Catch:{ IOException -> 0x0091 }
            boolean r9 = okhttp3.internal.http.HttpMethod.permitsRequestBody(r9)     // Catch:{ IOException -> 0x0091 }
            if (r9 == 0) goto L_0x007d
            if (r3 == 0) goto L_0x007d
            java.lang.String r9 = "100-continue"
            java.lang.String r10 = "Expect"
            java.lang.String r10 = r14.header(r10)     // Catch:{ IOException -> 0x0091 }
            boolean r9 = kotlin.text.StringsKt__StringsJVMKt.w(r9, r10, r8)     // Catch:{ IOException -> 0x0091 }
            if (r9 == 0) goto L_0x0044
            r2.flushRequest()     // Catch:{ IOException -> 0x0091 }
            okhttp3.Response$Builder r9 = r2.readResponseHeaders(r8)     // Catch:{ IOException -> 0x0091 }
            r2.responseHeadersStart()     // Catch:{ IOException -> 0x0042 }
            r10 = r6
            goto L_0x0046
        L_0x0042:
            r3 = move-exception
            goto L_0x0093
        L_0x0044:
            r9 = r7
            r10 = r8
        L_0x0046:
            if (r9 != 0) goto L_0x006c
            boolean r11 = r3.isDuplex()     // Catch:{ IOException -> 0x008f }
            if (r11 == 0) goto L_0x005d
            r2.flushRequest()     // Catch:{ IOException -> 0x008f }
            okio.Sink r11 = r2.createRequestBody(r14, r8)     // Catch:{ IOException -> 0x008f }
            okio.BufferedSink r11 = okio.Okio.buffer((okio.Sink) r11)     // Catch:{ IOException -> 0x008f }
            r3.writeTo(r11)     // Catch:{ IOException -> 0x008f }
            goto L_0x0082
        L_0x005d:
            okio.Sink r11 = r2.createRequestBody(r14, r6)     // Catch:{ IOException -> 0x008f }
            okio.BufferedSink r11 = okio.Okio.buffer((okio.Sink) r11)     // Catch:{ IOException -> 0x008f }
            r3.writeTo(r11)     // Catch:{ IOException -> 0x008f }
            r11.close()     // Catch:{ IOException -> 0x008f }
            goto L_0x0082
        L_0x006c:
            r2.noRequestBody()     // Catch:{ IOException -> 0x008f }
            okhttp3.internal.connection.RealConnection r11 = r2.getConnection$okhttp()     // Catch:{ IOException -> 0x008f }
            boolean r11 = r11.isMultiplexed$okhttp()     // Catch:{ IOException -> 0x008f }
            if (r11 != 0) goto L_0x0082
            r2.noNewExchangesOnConnection()     // Catch:{ IOException -> 0x008f }
            goto L_0x0082
        L_0x007d:
            r2.noRequestBody()     // Catch:{ IOException -> 0x0091 }
            r9 = r7
            r10 = r8
        L_0x0082:
            if (r3 == 0) goto L_0x008a
            boolean r3 = r3.isDuplex()     // Catch:{ IOException -> 0x008f }
            if (r3 != 0) goto L_0x008d
        L_0x008a:
            r2.finishRequest()     // Catch:{ IOException -> 0x008f }
        L_0x008d:
            r3 = r7
            goto L_0x009e
        L_0x008f:
            r3 = move-exception
            goto L_0x0094
        L_0x0091:
            r3 = move-exception
            r9 = r7
        L_0x0093:
            r10 = r8
        L_0x0094:
            boolean r11 = r3 instanceof okhttp3.internal.http2.ConnectionShutdownException
            if (r11 != 0) goto L_0x0199
            boolean r11 = r2.getHasFailure$okhttp()
            if (r11 == 0) goto L_0x0198
        L_0x009e:
            if (r9 != 0) goto L_0x00aa
            okhttp3.Response$Builder r9 = r2.readResponseHeaders(r6)     // Catch:{ IOException -> 0x0190 }
            if (r10 == 0) goto L_0x00aa
            r2.responseHeadersStart()     // Catch:{ IOException -> 0x0190 }
            r10 = r6
        L_0x00aa:
            okhttp3.Response$Builder r9 = r9.request(r14)     // Catch:{ IOException -> 0x0190 }
            okhttp3.internal.connection.RealConnection r11 = r2.getConnection$okhttp()     // Catch:{ IOException -> 0x0190 }
            okhttp3.Handshake r11 = r11.handshake()     // Catch:{ IOException -> 0x0190 }
            okhttp3.Response$Builder r9 = r9.handshake(r11)     // Catch:{ IOException -> 0x0190 }
            okhttp3.Response$Builder r9 = r9.sentRequestAtMillis(r4)     // Catch:{ IOException -> 0x0190 }
            long r11 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0190 }
            okhttp3.Response$Builder r9 = r9.receivedResponseAtMillis(r11)     // Catch:{ IOException -> 0x0190 }
            okhttp3.Response r9 = r9.build()     // Catch:{ IOException -> 0x0190 }
            int r11 = r9.code()     // Catch:{ IOException -> 0x0190 }
            boolean r12 = r13.shouldIgnoreAndWaitForRealResponse(r11)     // Catch:{ IOException -> 0x0190 }
            if (r12 == 0) goto L_0x0101
            okhttp3.Response$Builder r6 = r2.readResponseHeaders(r6)     // Catch:{ IOException -> 0x0190 }
            if (r10 == 0) goto L_0x00dd
            r2.responseHeadersStart()     // Catch:{ IOException -> 0x0190 }
        L_0x00dd:
            okhttp3.Response$Builder r14 = r6.request(r14)     // Catch:{ IOException -> 0x0190 }
            okhttp3.internal.connection.RealConnection r6 = r2.getConnection$okhttp()     // Catch:{ IOException -> 0x0190 }
            okhttp3.Handshake r6 = r6.handshake()     // Catch:{ IOException -> 0x0190 }
            okhttp3.Response$Builder r14 = r14.handshake(r6)     // Catch:{ IOException -> 0x0190 }
            okhttp3.Response$Builder r14 = r14.sentRequestAtMillis(r4)     // Catch:{ IOException -> 0x0190 }
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ IOException -> 0x0190 }
            okhttp3.Response$Builder r14 = r14.receivedResponseAtMillis(r4)     // Catch:{ IOException -> 0x0190 }
            okhttp3.Response r9 = r14.build()     // Catch:{ IOException -> 0x0190 }
            int r11 = r9.code()     // Catch:{ IOException -> 0x0190 }
        L_0x0101:
            r2.responseHeadersEnd(r9)     // Catch:{ IOException -> 0x0190 }
            boolean r14 = r13.forWebSocket     // Catch:{ IOException -> 0x0190 }
            if (r14 == 0) goto L_0x011b
            r14 = 101(0x65, float:1.42E-43)
            if (r11 != r14) goto L_0x011b
            okhttp3.Response$Builder r14 = r9.newBuilder()     // Catch:{ IOException -> 0x0190 }
            okhttp3.ResponseBody r4 = okhttp3.internal.Util.EMPTY_RESPONSE     // Catch:{ IOException -> 0x0190 }
            okhttp3.Response$Builder r14 = r14.body(r4)     // Catch:{ IOException -> 0x0190 }
            okhttp3.Response r14 = r14.build()     // Catch:{ IOException -> 0x0190 }
            goto L_0x012b
        L_0x011b:
            okhttp3.Response$Builder r14 = r9.newBuilder()     // Catch:{ IOException -> 0x0190 }
            okhttp3.ResponseBody r4 = r2.openResponseBody(r9)     // Catch:{ IOException -> 0x0190 }
            okhttp3.Response$Builder r14 = r14.body(r4)     // Catch:{ IOException -> 0x0190 }
            okhttp3.Response r14 = r14.build()     // Catch:{ IOException -> 0x0190 }
        L_0x012b:
            okhttp3.Request r4 = r14.request()     // Catch:{ IOException -> 0x0190 }
            java.lang.String r4 = r4.header(r0)     // Catch:{ IOException -> 0x0190 }
            boolean r4 = kotlin.text.StringsKt__StringsJVMKt.w(r1, r4, r8)     // Catch:{ IOException -> 0x0190 }
            if (r4 != 0) goto L_0x0144
            r4 = 2
            java.lang.String r0 = okhttp3.Response.header$default(r14, r0, r7, r4, r7)     // Catch:{ IOException -> 0x0190 }
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.w(r1, r0, r8)     // Catch:{ IOException -> 0x0190 }
            if (r0 == 0) goto L_0x0147
        L_0x0144:
            r2.noNewExchangesOnConnection()     // Catch:{ IOException -> 0x0190 }
        L_0x0147:
            r0 = 204(0xcc, float:2.86E-43)
            if (r11 == r0) goto L_0x014f
            r0 = 205(0xcd, float:2.87E-43)
            if (r11 != r0) goto L_0x018f
        L_0x014f:
            okhttp3.ResponseBody r0 = r14.body()     // Catch:{ IOException -> 0x0190 }
            if (r0 == 0) goto L_0x015a
            long r0 = r0.contentLength()     // Catch:{ IOException -> 0x0190 }
            goto L_0x015c
        L_0x015a:
            r0 = -1
        L_0x015c:
            r4 = 0
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x018f
            java.net.ProtocolException r0 = new java.net.ProtocolException     // Catch:{ IOException -> 0x0190 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0190 }
            r1.<init>()     // Catch:{ IOException -> 0x0190 }
            java.lang.String r2 = "HTTP "
            r1.append(r2)     // Catch:{ IOException -> 0x0190 }
            r1.append(r11)     // Catch:{ IOException -> 0x0190 }
            java.lang.String r2 = " had non-zero Content-Length: "
            r1.append(r2)     // Catch:{ IOException -> 0x0190 }
            okhttp3.ResponseBody r14 = r14.body()     // Catch:{ IOException -> 0x0190 }
            if (r14 == 0) goto L_0x0184
            long r4 = r14.contentLength()     // Catch:{ IOException -> 0x0190 }
            java.lang.Long r7 = java.lang.Long.valueOf(r4)     // Catch:{ IOException -> 0x0190 }
        L_0x0184:
            r1.append(r7)     // Catch:{ IOException -> 0x0190 }
            java.lang.String r14 = r1.toString()     // Catch:{ IOException -> 0x0190 }
            r0.<init>(r14)     // Catch:{ IOException -> 0x0190 }
            throw r0     // Catch:{ IOException -> 0x0190 }
        L_0x018f:
            return r14
        L_0x0190:
            r14 = move-exception
            if (r3 == 0) goto L_0x0197
            kotlin.ExceptionsKt__ExceptionsKt.a(r3, r14)
            throw r3
        L_0x0197:
            throw r14
        L_0x0198:
            throw r3
        L_0x0199:
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.http.CallServerInterceptor.intercept(okhttp3.Interceptor$Chain):okhttp3.Response");
    }
}
