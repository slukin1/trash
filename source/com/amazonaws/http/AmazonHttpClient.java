package com.amazonaws.http;

import com.amazonaws.AmazonClientException;
import com.amazonaws.AmazonServiceException;
import com.amazonaws.AmazonWebServiceRequest;
import com.amazonaws.AmazonWebServiceResponse;
import com.amazonaws.ClientConfiguration;
import com.amazonaws.Request;
import com.amazonaws.Response;
import com.amazonaws.handlers.CredentialsRequestHandler;
import com.amazonaws.handlers.RequestHandler2;
import com.amazonaws.internal.CRC32MismatchException;
import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.metrics.RequestMetricCollector;
import com.amazonaws.retry.RetryPolicy;
import com.amazonaws.util.AWSRequestMetrics;
import com.amazonaws.util.DateUtils;
import com.amazonaws.util.TimingInfo;
import com.amazonaws.util.URIBuilder;
import com.google.common.net.HttpHeaders;
import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class AmazonHttpClient {

    /* renamed from: e  reason: collision with root package name */
    public static final Log f14873e = LogFactory.c("com.amazonaws.request");

    /* renamed from: f  reason: collision with root package name */
    public static final Log f14874f = LogFactory.b(AmazonHttpClient.class);

    /* renamed from: a  reason: collision with root package name */
    public final HttpClient f14875a;

    /* renamed from: b  reason: collision with root package name */
    public final ClientConfiguration f14876b;

    /* renamed from: c  reason: collision with root package name */
    public final RequestMetricCollector f14877c;

    /* renamed from: d  reason: collision with root package name */
    public final HttpRequestFactory f14878d = new HttpRequestFactory();

    public AmazonHttpClient(ClientConfiguration clientConfiguration, HttpClient httpClient) {
        this.f14876b = clientConfiguration;
        this.f14875a = httpClient;
        this.f14877c = null;
    }

    public static String c(String str, String str2) {
        if (str.contains(str2)) {
            return str;
        }
        return str.trim() + " " + str2.trim();
    }

    public static boolean l(HttpResponse httpResponse) {
        int e11 = httpResponse.e();
        String str = httpResponse.c().get(HttpHeaders.LOCATION);
        return e11 == 307 && str != null && !str.isEmpty();
    }

    public void a(Request<?> request, Response<?> response, List<RequestHandler2> list, AmazonClientException amazonClientException) {
        for (RequestHandler2 afterError : list) {
            afterError.afterError(request, response, amazonClientException);
        }
    }

    public <T> void b(Request<?> request, List<RequestHandler2> list, Response<T> response, TimingInfo timingInfo) {
        for (RequestHandler2 afterResponse : list) {
            afterResponse.afterResponse(request, response);
        }
    }

    public <T> Response<T> d(Request<?> request, HttpResponseHandler<AmazonWebServiceResponse<T>> httpResponseHandler, HttpResponseHandler<AmazonServiceException> httpResponseHandler2, ExecutionContext executionContext) {
        if (request.h() != null) {
            try {
                URI t11 = request.t();
                request.u(URIBuilder.b(t11).c(request.h() + t11.getHost()).a());
            } catch (URISyntaxException e11) {
                Log log = f14874f;
                if (log.i()) {
                    log.d("Failed to prepend host prefix: " + e11.getMessage(), e11);
                }
            }
        }
        if (executionContext != null) {
            List<RequestHandler2> o11 = o(request, executionContext);
            AWSRequestMetrics a11 = executionContext.a();
            Response<T> response = null;
            try {
                response = e(request, httpResponseHandler, httpResponseHandler2, executionContext);
                b(request, o11, response, a11.c().c());
                return response;
            } catch (AmazonClientException e12) {
                a(request, response, o11, e12);
                throw e12;
            }
        } else {
            throw new AmazonClientException("Internal SDK Error: No execution context parameter specified.");
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v6, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v7, resolved type: long} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v3, resolved type: com.amazonaws.http.HttpResponse} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v8, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v8, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v21, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v23, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v24, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v25, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v20, resolved type: com.amazonaws.http.HttpResponse} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v30, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v21, resolved type: com.amazonaws.http.HttpResponse} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v31, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v24, resolved type: com.amazonaws.http.HttpResponse} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v25, resolved type: com.amazonaws.http.HttpResponse} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v52, resolved type: boolean} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v31, resolved type: com.amazonaws.http.HttpResponseHandler<com.amazonaws.AmazonWebServiceResponse<T>>} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v30, resolved type: com.amazonaws.http.HttpResponse} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v31, resolved type: com.amazonaws.http.HttpResponse} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v61, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v32, resolved type: com.amazonaws.http.HttpResponse} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v33, resolved type: int} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v34, resolved type: com.amazonaws.http.HttpResponse} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v35, resolved type: com.amazonaws.http.HttpResponse} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v63, resolved type: long} */
    /* JADX WARNING: type inference failed for: r6v10 */
    /* JADX WARNING: type inference failed for: r1v62 */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01c1, code lost:
        r9 = "Cannot close the response content.";
        r6 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01c5, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01c6, code lost:
        r9 = "Cannot close the response content.";
        r6 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:124:0x0255, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:175:0x0329, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:176:0x032b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:177:0x032c, code lost:
        r9 = "Cannot close the response content.";
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:179:0x0332, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:180:0x0333, code lost:
        r9 = "Cannot close the response content.";
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:182:0x0338, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x0339, code lost:
        r9 = "Cannot close the response content.";
        r11 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:197:0x0362, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x0363, code lost:
        r21 = r1;
        r9 = "Cannot close the response content.";
        r24 = r5;
        r25 = r6;
        r23 = r11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x036f, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x0370, code lost:
        r21 = r1;
        r9 = "Cannot close the response content.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0375, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0376, code lost:
        r9 = "Cannot close the response content.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:207:0x037e, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x037f, code lost:
        r9 = "Cannot close the response content.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:214:0x038b, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:215:0x038c, code lost:
        r9 = "Cannot close the response content.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:220:0x0398, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:221:0x0399, code lost:
        r2 = r0;
        r6 = r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:229:?, code lost:
        r1.d("Unable to execute HTTP request: " + r0.getMessage(), r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:232:0x0408, code lost:
        p(r8, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:237:0x0413, code lost:
        if (r19.d() != null) goto L_0x0415;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:238:0x0415, code lost:
        r19.d().close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:239:0x041d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:240:0x041e, code lost:
        f14874f.f(r9, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:241:0x0423, code lost:
        r5 = r15;
        r6 = r19;
        r1 = r20;
        r2 = r21;
        r4 = r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:244:?, code lost:
        throw r24;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:251:0x0442, code lost:
        r6.d().close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00da, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x00db, code lost:
        r21 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00de, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:?, code lost:
        r10.b(com.amazonaws.util.AWSRequestMetrics.Field.RetryPauseTime);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00e4, code lost:
        throw r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00e5, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00e6, code lost:
        r2 = r0;
        r9 = "Cannot close the response content.";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ea, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00eb, code lost:
        r9 = "Cannot close the response content.";
        r15 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x012d, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:57:0x012e, code lost:
        r4 = r0;
        r10.b(com.amazonaws.util.AWSRequestMetrics.Field.RequestSigningTime);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:58:0x0134, code lost:
        throw r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x01ba, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01bb, code lost:
        r2 = r0;
        r9 = "Cannot close the response content.";
        r6 = r4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:99:0x01c0, code lost:
        r0 = e;
     */
    /* JADX WARNING: Failed to insert additional move for type inference */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:101:0x01c5 A[ExcHandler: RuntimeException (e java.lang.RuntimeException), Splitter:B:73:0x0171] */
    /* JADX WARNING: Removed duplicated region for block: B:176:0x032b A[ExcHandler: all (th java.lang.Throwable), Splitter:B:70:0x0168] */
    /* JADX WARNING: Removed duplicated region for block: B:179:0x0332 A[ExcHandler: Error (e java.lang.Error), Splitter:B:70:0x0168] */
    /* JADX WARNING: Removed duplicated region for block: B:182:0x0338 A[ExcHandler: RuntimeException (e java.lang.RuntimeException), Splitter:B:70:0x0168] */
    /* JADX WARNING: Removed duplicated region for block: B:202:0x0375 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:41:0x00f7] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x037e A[ExcHandler: Error (e java.lang.Error), Splitter:B:17:0x00b4] */
    /* JADX WARNING: Removed duplicated region for block: B:214:0x038b A[Catch:{ IOException -> 0x0362, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x0375, all -> 0x0398 }, ExcHandler: RuntimeException (e java.lang.RuntimeException), Splitter:B:17:0x00b4] */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x03af A[SYNTHETIC, Splitter:B:228:0x03af] */
    /* JADX WARNING: Removed duplicated region for block: B:232:0x0408 A[Catch:{ all -> 0x0435 }] */
    /* JADX WARNING: Removed duplicated region for block: B:243:0x0434 A[EDGE_INSN: B:243:0x0434->B:244:? ?: BREAK  , SYNTHETIC, Splitter:B:243:0x0434] */
    /* JADX WARNING: Removed duplicated region for block: B:251:0x0442 A[Catch:{ IOException -> 0x044a }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e5 A[ExcHandler: all (r0v108 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:17:0x00b4] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01ba A[ExcHandler: all (r0v89 'th' java.lang.Throwable A[CUSTOM_DECLARE]), Splitter:B:73:0x0171] */
    /* JADX WARNING: Removed duplicated region for block: B:99:0x01c0 A[ExcHandler: Error (e java.lang.Error), Splitter:B:73:0x0171] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public <T> com.amazonaws.Response<T> e(com.amazonaws.Request<?> r27, com.amazonaws.http.HttpResponseHandler<com.amazonaws.AmazonWebServiceResponse<T>> r28, com.amazonaws.http.HttpResponseHandler<com.amazonaws.AmazonServiceException> r29, com.amazonaws.http.ExecutionContext r30) {
        /*
            r26 = this;
            r7 = r26
            r8 = r27
            r9 = r30
            com.amazonaws.util.AWSRequestMetrics r10 = r30.a()
            com.amazonaws.util.AWSRequestMetrics$Field r0 = com.amazonaws.util.AWSRequestMetrics.Field.ServiceName
            java.lang.String r1 = r27.n()
            r10.a(r0, r1)
            com.amazonaws.util.AWSRequestMetrics$Field r0 = com.amazonaws.util.AWSRequestMetrics.Field.ServiceEndpoint
            java.net.URI r1 = r27.t()
            r10.a(r0, r1)
            r26.q(r27)
            java.util.UUID r0 = java.util.UUID.randomUUID()
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "aws-sdk-invocation-id"
            r8.a(r1, r0)
            java.util.LinkedHashMap r11 = new java.util.LinkedHashMap
            java.util.Map r0 = r27.getParameters()
            r11.<init>(r0)
            java.util.HashMap r12 = new java.util.HashMap
            java.util.Map r0 = r27.getHeaders()
            r12.<init>(r0)
            java.io.InputStream r13 = r27.getContent()
            if (r13 == 0) goto L_0x004e
            boolean r0 = r13.markSupported()
            if (r0 == 0) goto L_0x004e
            r0 = -1
            r13.mark(r0)
        L_0x004e:
            com.amazonaws.auth.AWSCredentials r14 = r30.c()
            r0 = 0
            r1 = 0
            r2 = r1
            r4 = 0
            r5 = 0
            r6 = 0
            r16 = 0
            r17 = 0
            r1 = r0
        L_0x005e:
            r15 = 1
            r19 = r6
            int r6 = r0 + 1
            com.amazonaws.util.AWSRequestMetrics$Field r0 = com.amazonaws.util.AWSRequestMetrics.Field.RequestCount
            r20 = r1
            r21 = r2
            long r1 = (long) r6
            r10.f(r0, r1)
            if (r6 <= r15) goto L_0x0078
            r8.s(r11)
            r8.g(r12)
            r8.b(r13)
        L_0x0078:
            if (r16 == 0) goto L_0x00b0
            java.net.URI r0 = r27.t()
            if (r0 != 0) goto L_0x00b0
            java.lang.String r0 = r27.l()
            if (r0 != 0) goto L_0x00b0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = r16.getScheme()
            r0.append(r1)
            java.lang.String r1 = "://"
            r0.append(r1)
            java.lang.String r1 = r16.getAuthority()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.net.URI r0 = java.net.URI.create(r0)
            r8.u(r0)
            java.lang.String r0 = r16.getPath()
            r8.d(r0)
        L_0x00b0:
            java.lang.String r3 = "Cannot close the response content."
            if (r6 <= r15) goto L_0x00f3
            com.amazonaws.util.AWSRequestMetrics$Field r0 = com.amazonaws.util.AWSRequestMetrics.Field.RetryPauseTime     // Catch:{ IOException -> 0x00ea, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x00e5 }
            r10.g(r0)     // Catch:{ IOException -> 0x00ea, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x00e5 }
            com.amazonaws.AmazonWebServiceRequest r1 = r27.q()     // Catch:{ all -> 0x00de }
            com.amazonaws.ClientConfiguration r2 = r7.f14876b     // Catch:{ all -> 0x00de }
            com.amazonaws.retry.RetryPolicy r2 = r2.d()     // Catch:{ all -> 0x00de }
            long r1 = r7.n(r1, r4, r6, r2)     // Catch:{ all -> 0x00de }
            r10.b(r0)     // Catch:{ IOException -> 0x00da, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x00e5 }
            java.io.InputStream r0 = r27.getContent()     // Catch:{ IOException -> 0x00da, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x00e5 }
            if (r0 == 0) goto L_0x00f5
            boolean r4 = r0.markSupported()     // Catch:{ IOException -> 0x00da, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x00e5 }
            if (r4 == 0) goto L_0x00f5
            r0.reset()     // Catch:{ IOException -> 0x00da, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x00e5 }
            goto L_0x00f5
        L_0x00da:
            r0 = move-exception
            r21 = r1
            goto L_0x00eb
        L_0x00de:
            r0 = move-exception
            com.amazonaws.util.AWSRequestMetrics$Field r1 = com.amazonaws.util.AWSRequestMetrics.Field.RetryPauseTime     // Catch:{ IOException -> 0x00ea, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x00e5 }
            r10.b(r1)     // Catch:{ IOException -> 0x00ea, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x00e5 }
            throw r0     // Catch:{ IOException -> 0x00ea, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x00e5 }
        L_0x00e5:
            r0 = move-exception
            r2 = r0
            r9 = r3
            goto L_0x0378
        L_0x00ea:
            r0 = move-exception
        L_0x00eb:
            r9 = r3
            r15 = r5
        L_0x00ed:
            r25 = r6
        L_0x00ef:
            r23 = r11
            goto L_0x03a5
        L_0x00f3:
            r1 = r21
        L_0x00f5:
            java.lang.String r0 = "aws-sdk-retry"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x039c, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x0375 }
            r4.<init>()     // Catch:{ IOException -> 0x039c, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x0375 }
            int r15 = r6 + -1
            r4.append(r15)     // Catch:{ IOException -> 0x039c, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x0375 }
            java.lang.String r15 = "/"
            r4.append(r15)     // Catch:{ IOException -> 0x039c, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x0375 }
            r4.append(r1)     // Catch:{ IOException -> 0x039c, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x0375 }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x039c, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x0375 }
            r8.a(r0, r4)     // Catch:{ IOException -> 0x039c, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x0375 }
            if (r5 != 0) goto L_0x011c
            java.net.URI r0 = r27.t()     // Catch:{ IOException -> 0x00da, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x00e5 }
            com.amazonaws.auth.Signer r0 = r9.e(r0)     // Catch:{ IOException -> 0x00da, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x00e5 }
            r15 = r0
            goto L_0x011d
        L_0x011c:
            r15 = r5
        L_0x011d:
            if (r15 == 0) goto L_0x0135
            if (r14 == 0) goto L_0x0135
            com.amazonaws.util.AWSRequestMetrics$Field r0 = com.amazonaws.util.AWSRequestMetrics.Field.RequestSigningTime     // Catch:{ IOException -> 0x036f, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x00e5 }
            r10.g(r0)     // Catch:{ IOException -> 0x036f, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x00e5 }
            r15.sign(r8, r14)     // Catch:{ all -> 0x012d }
            r10.b(r0)     // Catch:{ IOException -> 0x036f, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x00e5 }
            goto L_0x0135
        L_0x012d:
            r0 = move-exception
            r4 = r0
            com.amazonaws.util.AWSRequestMetrics$Field r0 = com.amazonaws.util.AWSRequestMetrics.Field.RequestSigningTime     // Catch:{ IOException -> 0x036f, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x00e5 }
            r10.b(r0)     // Catch:{ IOException -> 0x036f, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x00e5 }
            throw r4     // Catch:{ IOException -> 0x036f, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x00e5 }
        L_0x0135:
            com.amazonaws.logging.Log r0 = f14873e     // Catch:{ IOException -> 0x036f, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x0375 }
            boolean r4 = r0.i()     // Catch:{ IOException -> 0x036f, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x0375 }
            if (r4 == 0) goto L_0x0155
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x036f, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x00e5 }
            r4.<init>()     // Catch:{ IOException -> 0x036f, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x00e5 }
            java.lang.String r5 = "Sending Request: "
            r4.append(r5)     // Catch:{ IOException -> 0x036f, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x00e5 }
            java.lang.String r5 = r27.toString()     // Catch:{ IOException -> 0x036f, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x00e5 }
            r4.append(r5)     // Catch:{ IOException -> 0x036f, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x00e5 }
            java.lang.String r4 = r4.toString()     // Catch:{ IOException -> 0x036f, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x00e5 }
            r0.h(r4)     // Catch:{ IOException -> 0x036f, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x00e5 }
        L_0x0155:
            com.amazonaws.http.HttpRequestFactory r0 = r7.f14878d     // Catch:{ IOException -> 0x036f, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x0375 }
            com.amazonaws.ClientConfiguration r4 = r7.f14876b     // Catch:{ IOException -> 0x036f, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x0375 }
            com.amazonaws.http.HttpRequest r5 = r0.b(r8, r4, r9)     // Catch:{ IOException -> 0x036f, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x0375 }
            com.amazonaws.util.AWSRequestMetrics$Field r0 = com.amazonaws.util.AWSRequestMetrics.Field.HttpRequestTime     // Catch:{ IOException -> 0x0362, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x0375 }
            r10.g(r0)     // Catch:{ IOException -> 0x0362, RuntimeException -> 0x038b, Error -> 0x037e, all -> 0x0375 }
            com.amazonaws.http.HttpClient r4 = r7.f14875a     // Catch:{ all -> 0x034c }
            com.amazonaws.http.HttpResponse r4 = r4.a(r5)     // Catch:{ all -> 0x034c }
            r10.b(r0)     // Catch:{ IOException -> 0x033e, RuntimeException -> 0x0338, Error -> 0x0332, all -> 0x032b }
            boolean r0 = r7.k(r4)     // Catch:{ IOException -> 0x033e, RuntimeException -> 0x0338, Error -> 0x0332, all -> 0x032b }
            if (r0 == 0) goto L_0x01d4
            com.amazonaws.util.AWSRequestMetrics$Field r0 = com.amazonaws.util.AWSRequestMetrics.Field.StatusCode     // Catch:{ IOException -> 0x01ca, RuntimeException -> 0x01c5, Error -> 0x01c0, all -> 0x01ba }
            int r17 = r4.e()     // Catch:{ IOException -> 0x01ca, RuntimeException -> 0x01c5, Error -> 0x01c0, all -> 0x01ba }
            r21 = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r17)     // Catch:{ IOException -> 0x0255, RuntimeException -> 0x01c5, Error -> 0x01c0, all -> 0x01ba }
            r10.a(r0, r1)     // Catch:{ IOException -> 0x0255, RuntimeException -> 0x01c5, Error -> 0x01c0, all -> 0x01ba }
            boolean r1 = r28.a()     // Catch:{ IOException -> 0x0255, RuntimeException -> 0x01c5, Error -> 0x01c0, all -> 0x01ba }
            r2 = r28
            java.lang.Object r0 = r7.i(r8, r2, r4, r9)     // Catch:{ IOException -> 0x01b6, RuntimeException -> 0x01b1, Error -> 0x01ac, all -> 0x01a6 }
            com.amazonaws.Response r2 = new com.amazonaws.Response     // Catch:{ IOException -> 0x01b6, RuntimeException -> 0x01b1, Error -> 0x01ac, all -> 0x01a6 }
            r2.<init>(r0, r4)     // Catch:{ IOException -> 0x01b6, RuntimeException -> 0x01b1, Error -> 0x01ac, all -> 0x01a6 }
            if (r1 != 0) goto L_0x01a5
            java.io.InputStream r0 = r4.d()     // Catch:{ IOException -> 0x019f }
            if (r0 == 0) goto L_0x01a5
            java.io.InputStream r0 = r4.d()     // Catch:{ IOException -> 0x019f }
            r0.close()     // Catch:{ IOException -> 0x019f }
            goto L_0x01a5
        L_0x019f:
            r0 = move-exception
            com.amazonaws.logging.Log r1 = f14874f
            r1.f(r3, r0)
        L_0x01a5:
            return r2
        L_0x01a6:
            r0 = move-exception
            r2 = r0
            r9 = r3
            r6 = r4
            goto L_0x0438
        L_0x01ac:
            r0 = move-exception
            r9 = r3
            r6 = r4
            goto L_0x0384
        L_0x01b1:
            r0 = move-exception
            r9 = r3
            r6 = r4
            goto L_0x0391
        L_0x01b6:
            r0 = move-exception
            r20 = r1
            goto L_0x01cd
        L_0x01ba:
            r0 = move-exception
            r2 = r0
            r9 = r3
            r6 = r4
            goto L_0x037a
        L_0x01c0:
            r0 = move-exception
            r9 = r3
            r6 = r4
            goto L_0x0382
        L_0x01c5:
            r0 = move-exception
            r9 = r3
            r6 = r4
            goto L_0x038f
        L_0x01ca:
            r0 = move-exception
            r21 = r1
        L_0x01cd:
            r9 = r3
            r19 = r4
            r17 = r5
            goto L_0x00ed
        L_0x01d4:
            r21 = r1
            boolean r0 = l(r4)     // Catch:{ IOException -> 0x0329, RuntimeException -> 0x0338, Error -> 0x0332, all -> 0x032b }
            if (r0 == 0) goto L_0x0258
            java.util.Map r0 = r4.c()     // Catch:{ IOException -> 0x0255, RuntimeException -> 0x01c5, Error -> 0x01c0, all -> 0x01ba }
            java.lang.String r1 = "Location"
            java.lang.Object r0 = r0.get(r1)     // Catch:{ IOException -> 0x0255, RuntimeException -> 0x01c5, Error -> 0x01c0, all -> 0x01ba }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ IOException -> 0x0255, RuntimeException -> 0x01c5, Error -> 0x01c0, all -> 0x01ba }
            com.amazonaws.logging.Log r1 = f14874f     // Catch:{ IOException -> 0x0255, RuntimeException -> 0x01c5, Error -> 0x01c0, all -> 0x01ba }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0255, RuntimeException -> 0x01c5, Error -> 0x01c0, all -> 0x01ba }
            r2.<init>()     // Catch:{ IOException -> 0x0255, RuntimeException -> 0x01c5, Error -> 0x01c0, all -> 0x01ba }
            r23 = r3
            java.lang.String r3 = "Redirecting to: "
            r2.append(r3)     // Catch:{ IOException -> 0x024a, RuntimeException -> 0x0242, Error -> 0x023a, all -> 0x0231 }
            r2.append(r0)     // Catch:{ IOException -> 0x024a, RuntimeException -> 0x0242, Error -> 0x023a, all -> 0x0231 }
            java.lang.String r2 = r2.toString()     // Catch:{ IOException -> 0x024a, RuntimeException -> 0x0242, Error -> 0x023a, all -> 0x0231 }
            r1.h(r2)     // Catch:{ IOException -> 0x024a, RuntimeException -> 0x0242, Error -> 0x023a, all -> 0x0231 }
            java.net.URI r16 = java.net.URI.create(r0)     // Catch:{ IOException -> 0x024a, RuntimeException -> 0x0242, Error -> 0x023a, all -> 0x0231 }
            r1 = 0
            r8.u(r1)     // Catch:{ IOException -> 0x024a, RuntimeException -> 0x0242, Error -> 0x023a, all -> 0x0231 }
            r8.d(r1)     // Catch:{ IOException -> 0x024a, RuntimeException -> 0x0242, Error -> 0x023a, all -> 0x0231 }
            com.amazonaws.util.AWSRequestMetrics$Field r1 = com.amazonaws.util.AWSRequestMetrics.Field.StatusCode     // Catch:{ IOException -> 0x024a, RuntimeException -> 0x0242, Error -> 0x023a, all -> 0x0231 }
            int r2 = r4.e()     // Catch:{ IOException -> 0x024a, RuntimeException -> 0x0242, Error -> 0x023a, all -> 0x0231 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x024a, RuntimeException -> 0x0242, Error -> 0x023a, all -> 0x0231 }
            r10.a(r1, r2)     // Catch:{ IOException -> 0x024a, RuntimeException -> 0x0242, Error -> 0x023a, all -> 0x0231 }
            com.amazonaws.util.AWSRequestMetrics$Field r1 = com.amazonaws.util.AWSRequestMetrics.Field.RedirectLocation     // Catch:{ IOException -> 0x024a, RuntimeException -> 0x0242, Error -> 0x023a, all -> 0x0231 }
            r10.a(r1, r0)     // Catch:{ IOException -> 0x024a, RuntimeException -> 0x0242, Error -> 0x023a, all -> 0x0231 }
            com.amazonaws.util.AWSRequestMetrics$Field r0 = com.amazonaws.util.AWSRequestMetrics.Field.AWSRequestID     // Catch:{ IOException -> 0x024a, RuntimeException -> 0x0242, Error -> 0x023a, all -> 0x0231 }
            r1 = 0
            r10.a(r0, r1)     // Catch:{ IOException -> 0x024a, RuntimeException -> 0x0242, Error -> 0x023a, all -> 0x0231 }
            r24 = r5
            r25 = r6
            r1 = r20
            r9 = r23
            r2 = 0
            r23 = r11
            r11 = r4
            goto L_0x02bb
        L_0x0231:
            r0 = move-exception
            r2 = r0
            r6 = r4
            r1 = r20
            r9 = r23
            goto L_0x0438
        L_0x023a:
            r0 = move-exception
            r6 = r4
            r1 = r20
            r9 = r23
            goto L_0x0384
        L_0x0242:
            r0 = move-exception
            r6 = r4
            r1 = r20
            r9 = r23
            goto L_0x0391
        L_0x024a:
            r0 = move-exception
            r19 = r4
            r17 = r5
            r25 = r6
            r9 = r23
            goto L_0x00ef
        L_0x0255:
            r0 = move-exception
            goto L_0x01cd
        L_0x0258:
            r23 = r3
            boolean r17 = r29.a()     // Catch:{ IOException -> 0x0321, RuntimeException -> 0x031c, Error -> 0x0317, all -> 0x0312 }
            r3 = r29
            com.amazonaws.AmazonServiceException r0 = r7.h(r8, r3, r4)     // Catch:{ IOException -> 0x0302, RuntimeException -> 0x02f9, Error -> 0x02f0, all -> 0x02e6 }
            com.amazonaws.util.AWSRequestMetrics$Field r1 = com.amazonaws.util.AWSRequestMetrics.Field.AWSRequestID     // Catch:{ IOException -> 0x0302, RuntimeException -> 0x02f9, Error -> 0x02f0, all -> 0x02e6 }
            java.lang.String r2 = r0.getRequestId()     // Catch:{ IOException -> 0x0302, RuntimeException -> 0x02f9, Error -> 0x02f0, all -> 0x02e6 }
            r10.a(r1, r2)     // Catch:{ IOException -> 0x0302, RuntimeException -> 0x02f9, Error -> 0x02f0, all -> 0x02e6 }
            com.amazonaws.util.AWSRequestMetrics$Field r1 = com.amazonaws.util.AWSRequestMetrics.Field.AWSErrorCode     // Catch:{ IOException -> 0x0302, RuntimeException -> 0x02f9, Error -> 0x02f0, all -> 0x02e6 }
            java.lang.String r2 = r0.getErrorCode()     // Catch:{ IOException -> 0x0302, RuntimeException -> 0x02f9, Error -> 0x02f0, all -> 0x02e6 }
            r10.a(r1, r2)     // Catch:{ IOException -> 0x0302, RuntimeException -> 0x02f9, Error -> 0x02f0, all -> 0x02e6 }
            com.amazonaws.util.AWSRequestMetrics$Field r1 = com.amazonaws.util.AWSRequestMetrics.Field.StatusCode     // Catch:{ IOException -> 0x0302, RuntimeException -> 0x02f9, Error -> 0x02f0, all -> 0x02e6 }
            int r2 = r0.getStatusCode()     // Catch:{ IOException -> 0x0302, RuntimeException -> 0x02f9, Error -> 0x02f0, all -> 0x02e6 }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ IOException -> 0x0302, RuntimeException -> 0x02f9, Error -> 0x02f0, all -> 0x02e6 }
            r10.a(r1, r2)     // Catch:{ IOException -> 0x0302, RuntimeException -> 0x02f9, Error -> 0x02f0, all -> 0x02e6 }
            com.amazonaws.AmazonWebServiceRequest r2 = r27.q()     // Catch:{ IOException -> 0x0302, RuntimeException -> 0x02f9, Error -> 0x02f0, all -> 0x02e6 }
            java.io.InputStream r19 = r5.a()     // Catch:{ IOException -> 0x0302, RuntimeException -> 0x02f9, Error -> 0x02f0, all -> 0x02e6 }
            com.amazonaws.ClientConfiguration r1 = r7.f14876b     // Catch:{ IOException -> 0x0302, RuntimeException -> 0x02f9, Error -> 0x02f0, all -> 0x02e6 }
            com.amazonaws.retry.RetryPolicy r20 = r1.d()     // Catch:{ IOException -> 0x0302, RuntimeException -> 0x02f9, Error -> 0x02f0, all -> 0x02e6 }
            r1 = r26
            r9 = r23
            r3 = r19
            r23 = r11
            r11 = r4
            r4 = r0
            r24 = r5
            r5 = r6
            r25 = r6
            r6 = r20
            boolean r1 = r1.r(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x02e4, RuntimeException -> 0x02e2, Error -> 0x02e0, all -> 0x02de }
            if (r1 == 0) goto L_0x02dd
            boolean r1 = com.amazonaws.retry.RetryUtils.a(r0)     // Catch:{ IOException -> 0x02e4, RuntimeException -> 0x02e2, Error -> 0x02e0, all -> 0x02de }
            if (r1 == 0) goto L_0x02b5
            long r1 = r7.m(r11, r0)     // Catch:{ IOException -> 0x02e4, RuntimeException -> 0x02e2, Error -> 0x02e0, all -> 0x02de }
            com.amazonaws.SDKGlobalConfiguration.b(r1)     // Catch:{ IOException -> 0x02e4, RuntimeException -> 0x02e2, Error -> 0x02e0, all -> 0x02de }
        L_0x02b5:
            r7.p(r8, r0)     // Catch:{ IOException -> 0x02e4, RuntimeException -> 0x02e2, Error -> 0x02e0, all -> 0x02de }
            r2 = r0
            r1 = r17
        L_0x02bb:
            if (r1 != 0) goto L_0x02d3
            if (r11 == 0) goto L_0x02d3
            java.io.InputStream r0 = r11.d()     // Catch:{ IOException -> 0x02cd }
            if (r0 == 0) goto L_0x02d3
            java.io.InputStream r0 = r11.d()     // Catch:{ IOException -> 0x02cd }
            r0.close()     // Catch:{ IOException -> 0x02cd }
            goto L_0x02d3
        L_0x02cd:
            r0 = move-exception
            com.amazonaws.logging.Log r3 = f14874f
            r3.f(r9, r0)
        L_0x02d3:
            r4 = r2
            r6 = r11
            r5 = r15
            r2 = r21
            r17 = r24
            r11 = 0
            goto L_0x042c
        L_0x02dd:
            throw r0     // Catch:{ IOException -> 0x02e4, RuntimeException -> 0x02e2, Error -> 0x02e0, all -> 0x02de }
        L_0x02de:
            r0 = move-exception
            goto L_0x02ea
        L_0x02e0:
            r0 = move-exception
            goto L_0x02f4
        L_0x02e2:
            r0 = move-exception
            goto L_0x02fd
        L_0x02e4:
            r0 = move-exception
            goto L_0x030c
        L_0x02e6:
            r0 = move-exception
            r11 = r4
            r9 = r23
        L_0x02ea:
            r2 = r0
            r6 = r11
            r1 = r17
            goto L_0x0438
        L_0x02f0:
            r0 = move-exception
            r11 = r4
            r9 = r23
        L_0x02f4:
            r6 = r11
            r1 = r17
            goto L_0x0384
        L_0x02f9:
            r0 = move-exception
            r11 = r4
            r9 = r23
        L_0x02fd:
            r6 = r11
            r1 = r17
            goto L_0x0391
        L_0x0302:
            r0 = move-exception
            r24 = r5
            r25 = r6
            r9 = r23
            r23 = r11
            r11 = r4
        L_0x030c:
            r19 = r11
            r20 = r17
            goto L_0x036c
        L_0x0312:
            r0 = move-exception
            r11 = r4
            r9 = r23
            goto L_0x032e
        L_0x0317:
            r0 = move-exception
            r11 = r4
            r9 = r23
            goto L_0x0335
        L_0x031c:
            r0 = move-exception
            r11 = r4
            r9 = r23
            goto L_0x033b
        L_0x0321:
            r0 = move-exception
            r24 = r5
            r25 = r6
            r9 = r23
            goto L_0x0346
        L_0x0329:
            r0 = move-exception
            goto L_0x0341
        L_0x032b:
            r0 = move-exception
            r9 = r3
            r11 = r4
        L_0x032e:
            r2 = r0
            r6 = r11
            goto L_0x037a
        L_0x0332:
            r0 = move-exception
            r9 = r3
            r11 = r4
        L_0x0335:
            r6 = r11
            goto L_0x0382
        L_0x0338:
            r0 = move-exception
            r9 = r3
            r11 = r4
        L_0x033b:
            r6 = r11
            goto L_0x038f
        L_0x033e:
            r0 = move-exception
            r21 = r1
        L_0x0341:
            r9 = r3
            r24 = r5
            r25 = r6
        L_0x0346:
            r23 = r11
            r11 = r4
            r19 = r11
            goto L_0x036c
        L_0x034c:
            r0 = move-exception
            r21 = r1
            r9 = r3
            r24 = r5
            r25 = r6
            r23 = r11
            com.amazonaws.util.AWSRequestMetrics$Field r1 = com.amazonaws.util.AWSRequestMetrics.Field.HttpRequestTime     // Catch:{ IOException -> 0x0360, RuntimeException -> 0x035e, Error -> 0x035c }
            r10.b(r1)     // Catch:{ IOException -> 0x0360, RuntimeException -> 0x035e, Error -> 0x035c }
            throw r0     // Catch:{ IOException -> 0x0360, RuntimeException -> 0x035e, Error -> 0x035c }
        L_0x035c:
            r0 = move-exception
            goto L_0x0380
        L_0x035e:
            r0 = move-exception
            goto L_0x038d
        L_0x0360:
            r0 = move-exception
            goto L_0x036c
        L_0x0362:
            r0 = move-exception
            r21 = r1
            r9 = r3
            r24 = r5
            r25 = r6
            r23 = r11
        L_0x036c:
            r17 = r24
            goto L_0x03a5
        L_0x036f:
            r0 = move-exception
            r21 = r1
            r9 = r3
            goto L_0x00ed
        L_0x0375:
            r0 = move-exception
            r9 = r3
        L_0x0377:
            r2 = r0
        L_0x0378:
            r6 = r19
        L_0x037a:
            r1 = r20
            goto L_0x0438
        L_0x037e:
            r0 = move-exception
            r9 = r3
        L_0x0380:
            r6 = r19
        L_0x0382:
            r1 = r20
        L_0x0384:
            java.lang.Throwable r0 = r7.j(r0, r10)     // Catch:{ all -> 0x0398 }
            java.lang.Error r0 = (java.lang.Error) r0     // Catch:{ all -> 0x0398 }
            throw r0     // Catch:{ all -> 0x0398 }
        L_0x038b:
            r0 = move-exception
            r9 = r3
        L_0x038d:
            r6 = r19
        L_0x038f:
            r1 = r20
        L_0x0391:
            java.lang.Throwable r0 = r7.j(r0, r10)     // Catch:{ all -> 0x0398 }
            java.lang.RuntimeException r0 = (java.lang.RuntimeException) r0     // Catch:{ all -> 0x0398 }
            throw r0     // Catch:{ all -> 0x0398 }
        L_0x0398:
            r0 = move-exception
            r2 = r0
            goto L_0x0438
        L_0x039c:
            r0 = move-exception
            r21 = r1
            r9 = r3
            r25 = r6
            r23 = r11
            r15 = r5
        L_0x03a5:
            com.amazonaws.logging.Log r1 = f14874f     // Catch:{ all -> 0x0435 }
            boolean r2 = r1.i()     // Catch:{ all -> 0x0435 }
            java.lang.String r3 = "Unable to execute HTTP request: "
            if (r2 == 0) goto L_0x03c5
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0435 }
            r2.<init>()     // Catch:{ all -> 0x0435 }
            r2.append(r3)     // Catch:{ all -> 0x0435 }
            java.lang.String r4 = r0.getMessage()     // Catch:{ all -> 0x0435 }
            r2.append(r4)     // Catch:{ all -> 0x0435 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0435 }
            r1.d(r2, r0)     // Catch:{ all -> 0x0435 }
        L_0x03c5:
            com.amazonaws.util.AWSRequestMetrics$Field r1 = com.amazonaws.util.AWSRequestMetrics.Field.Exception     // Catch:{ all -> 0x0435 }
            r10.d(r1)     // Catch:{ all -> 0x0435 }
            r10.a(r1, r0)     // Catch:{ all -> 0x0435 }
            com.amazonaws.util.AWSRequestMetrics$Field r1 = com.amazonaws.util.AWSRequestMetrics.Field.AWSRequestID     // Catch:{ all -> 0x0435 }
            r11 = 0
            r10.a(r1, r11)     // Catch:{ all -> 0x0435 }
            com.amazonaws.AmazonClientException r6 = new com.amazonaws.AmazonClientException     // Catch:{ all -> 0x0435 }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0435 }
            r1.<init>()     // Catch:{ all -> 0x0435 }
            r1.append(r3)     // Catch:{ all -> 0x0435 }
            java.lang.String r2 = r0.getMessage()     // Catch:{ all -> 0x0435 }
            r1.append(r2)     // Catch:{ all -> 0x0435 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0435 }
            r6.<init>(r1, r0)     // Catch:{ all -> 0x0435 }
            com.amazonaws.AmazonWebServiceRequest r2 = r27.q()     // Catch:{ all -> 0x0435 }
            java.io.InputStream r3 = r17.a()     // Catch:{ all -> 0x0435 }
            com.amazonaws.ClientConfiguration r1 = r7.f14876b     // Catch:{ all -> 0x0435 }
            com.amazonaws.retry.RetryPolicy r18 = r1.d()     // Catch:{ all -> 0x0435 }
            r1 = r26
            r4 = r6
            r5 = r25
            r24 = r6
            r6 = r18
            boolean r1 = r1.r(r2, r3, r4, r5, r6)     // Catch:{ all -> 0x0435 }
            if (r1 == 0) goto L_0x0434
            r7.p(r8, r0)     // Catch:{ all -> 0x0435 }
            if (r20 != 0) goto L_0x0423
            if (r19 == 0) goto L_0x0423
            java.io.InputStream r0 = r19.d()     // Catch:{ IOException -> 0x041d }
            if (r0 == 0) goto L_0x0423
            java.io.InputStream r0 = r19.d()     // Catch:{ IOException -> 0x041d }
            r0.close()     // Catch:{ IOException -> 0x041d }
            goto L_0x0423
        L_0x041d:
            r0 = move-exception
            com.amazonaws.logging.Log r1 = f14874f
            r1.f(r9, r0)
        L_0x0423:
            r5 = r15
            r6 = r19
            r1 = r20
            r2 = r21
            r4 = r24
        L_0x042c:
            r9 = r30
            r11 = r23
            r0 = r25
            goto L_0x005e
        L_0x0434:
            throw r24     // Catch:{ all -> 0x0435 }
        L_0x0435:
            r0 = move-exception
            goto L_0x0377
        L_0x0438:
            if (r1 != 0) goto L_0x0450
            if (r6 == 0) goto L_0x0450
            java.io.InputStream r0 = r6.d()     // Catch:{ IOException -> 0x044a }
            if (r0 == 0) goto L_0x0450
            java.io.InputStream r0 = r6.d()     // Catch:{ IOException -> 0x044a }
            r0.close()     // Catch:{ IOException -> 0x044a }
            goto L_0x0450
        L_0x044a:
            r0 = move-exception
            com.amazonaws.logging.Log r1 = f14874f
            r1.f(r9, r0)
        L_0x0450:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.http.AmazonHttpClient.e(com.amazonaws.Request, com.amazonaws.http.HttpResponseHandler, com.amazonaws.http.HttpResponseHandler, com.amazonaws.http.ExecutionContext):com.amazonaws.Response");
    }

    public RequestMetricCollector f() {
        return this.f14877c;
    }

    public void finalize() throws Throwable {
        s();
        super.finalize();
    }

    public final String g(String str) {
        int i11;
        int indexOf = str.indexOf("(");
        if (str.contains(" + 15")) {
            i11 = str.indexOf(" + 15");
        } else {
            i11 = str.indexOf(" - 15");
        }
        return str.substring(indexOf + 1, i11);
    }

    public AmazonServiceException h(Request<?> request, HttpResponseHandler<AmazonServiceException> httpResponseHandler, HttpResponse httpResponse) throws IOException {
        AmazonServiceException amazonServiceException;
        int e11 = httpResponse.e();
        try {
            amazonServiceException = httpResponseHandler.b(httpResponse);
            Log log = f14873e;
            log.h("Received error response: " + amazonServiceException.toString());
        } catch (Exception e12) {
            if (e11 == 413) {
                amazonServiceException = new AmazonServiceException("Request entity too large");
                amazonServiceException.setServiceName(request.n());
                amazonServiceException.setStatusCode(413);
                amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Client);
                amazonServiceException.setErrorCode("Request entity too large");
            } else if (e11 == 503 && "Service Unavailable".equalsIgnoreCase(httpResponse.f())) {
                amazonServiceException = new AmazonServiceException("Service unavailable");
                amazonServiceException.setServiceName(request.n());
                amazonServiceException.setStatusCode(503);
                amazonServiceException.setErrorType(AmazonServiceException.ErrorType.Service);
                amazonServiceException.setErrorCode("Service unavailable");
            } else if (e12 instanceof IOException) {
                throw ((IOException) e12);
            } else {
                throw new AmazonClientException("Unable to unmarshall error response (" + e12.getMessage() + "). Response Code: " + e11 + ", Response Text: " + httpResponse.f() + ", Response Headers: " + httpResponse.c(), e12);
            }
        }
        amazonServiceException.setStatusCode(e11);
        amazonServiceException.setServiceName(request.n());
        amazonServiceException.fillInStackTrace();
        return amazonServiceException;
    }

    public <T> T i(Request<?> request, HttpResponseHandler<AmazonWebServiceResponse<T>> httpResponseHandler, HttpResponse httpResponse, ExecutionContext executionContext) throws IOException {
        AWSRequestMetrics a11;
        try {
            a11 = executionContext.a();
            AWSRequestMetrics.Field field = AWSRequestMetrics.Field.ResponseProcessingTime;
            a11.g(field);
            AmazonWebServiceResponse b11 = httpResponseHandler.b(httpResponse);
            a11.b(field);
            if (b11 != null) {
                Log log = f14873e;
                if (log.i()) {
                    log.h("Received successful response: " + httpResponse.e() + ", AWS Request ID: " + b11.a());
                }
                a11.a(AWSRequestMetrics.Field.AWSRequestID, b11.a());
                return b11.b();
            }
            throw new RuntimeException("Unable to unmarshall response metadata. Response Code: " + httpResponse.e() + ", Response Text: " + httpResponse.f());
        } catch (CRC32MismatchException e11) {
            throw e11;
        } catch (IOException e12) {
            throw e12;
        } catch (Exception e13) {
            throw new AmazonClientException("Unable to unmarshall response (" + e13.getMessage() + "). Response Code: " + httpResponse.e() + ", Response Text: " + httpResponse.f(), e13);
        } catch (Throwable th2) {
            a11.b(AWSRequestMetrics.Field.ResponseProcessingTime);
            throw th2;
        }
    }

    public final <T extends Throwable> T j(T t11, AWSRequestMetrics aWSRequestMetrics) {
        AWSRequestMetrics.Field field = AWSRequestMetrics.Field.Exception;
        aWSRequestMetrics.d(field);
        aWSRequestMetrics.a(field, t11);
        return t11;
    }

    public final boolean k(HttpResponse httpResponse) {
        int e11 = httpResponse.e();
        return e11 >= 200 && e11 < 300;
    }

    public long m(HttpResponse httpResponse, AmazonServiceException amazonServiceException) {
        Date date;
        Date date2 = new Date();
        String str = httpResponse.c().get(HttpHeaders.DATE);
        if (str != null) {
            try {
                if (!str.isEmpty()) {
                    try {
                        date = DateUtils.i(str);
                        return (date2.getTime() - date.getTime()) / 1000;
                    } catch (RuntimeException e11) {
                        e = e11;
                        f14874f.f("Unable to parse clock skew offset from response: " + str, e);
                        return 0;
                    }
                }
            } catch (RuntimeException e12) {
                e = e12;
                str = null;
                f14874f.f("Unable to parse clock skew offset from response: " + str, e);
                return 0;
            }
        }
        str = g(amazonServiceException.getMessage());
        date = DateUtils.g(str);
        return (date2.getTime() - date.getTime()) / 1000;
    }

    public final long n(AmazonWebServiceRequest amazonWebServiceRequest, AmazonClientException amazonClientException, int i11, RetryPolicy retryPolicy) {
        int i12 = (i11 - 1) - 1;
        long a11 = retryPolicy.a().a(amazonWebServiceRequest, amazonClientException, i12);
        Log log = f14874f;
        if (log.i()) {
            log.h("Retriable error detected, will retry in " + a11 + "ms, attempt number: " + i12);
        }
        try {
            Thread.sleep(a11);
            return a11;
        } catch (InterruptedException e11) {
            Thread.currentThread().interrupt();
            throw new AmazonClientException(e11.getMessage(), e11);
        }
    }

    public List<RequestHandler2> o(Request<?> request, ExecutionContext executionContext) {
        List<RequestHandler2> d11 = executionContext.d();
        if (d11 == null) {
            return Collections.emptyList();
        }
        for (RequestHandler2 next : d11) {
            if (next instanceof CredentialsRequestHandler) {
                ((CredentialsRequestHandler) next).a(executionContext.c());
            }
            next.beforeRequest(request);
        }
        return d11;
    }

    public void p(Request<?> request, Exception exc) {
        if (request.getContent() != null) {
            if (request.getContent().markSupported()) {
                try {
                    request.getContent().reset();
                } catch (IOException unused) {
                    throw new AmazonClientException("Encountered an exception and couldn't reset the stream to retry", exc);
                }
            } else {
                throw new AmazonClientException("Encountered an exception and stream is not resettable", exc);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000e, code lost:
        r1 = (r1 = r1.getRequestClientOptions()).c(com.amazonaws.RequestClientOptions.Marker.USER_AGENT);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void q(com.amazonaws.Request<?> r4) {
        /*
            r3 = this;
            java.lang.String r0 = com.amazonaws.ClientConfiguration.f14772u
            com.amazonaws.AmazonWebServiceRequest r1 = r4.q()
            if (r1 == 0) goto L_0x001b
            com.amazonaws.RequestClientOptions r1 = r1.getRequestClientOptions()
            if (r1 == 0) goto L_0x001b
            com.amazonaws.RequestClientOptions$Marker r2 = com.amazonaws.RequestClientOptions.Marker.USER_AGENT
            java.lang.String r1 = r1.c(r2)
            if (r1 == 0) goto L_0x001b
            java.lang.String r1 = c(r0, r1)
            goto L_0x001c
        L_0x001b:
            r1 = r0
        L_0x001c:
            com.amazonaws.ClientConfiguration r2 = r3.f14876b
            java.lang.String r2 = r2.h()
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x0032
            com.amazonaws.ClientConfiguration r0 = r3.f14876b
            java.lang.String r0 = r0.h()
            java.lang.String r1 = c(r1, r0)
        L_0x0032:
            com.amazonaws.ClientConfiguration r0 = r3.f14876b
            java.lang.String r0 = r0.i()
            if (r0 == 0) goto L_0x0040
            com.amazonaws.ClientConfiguration r0 = r3.f14876b
            java.lang.String r1 = r0.i()
        L_0x0040:
            java.lang.String r0 = "User-Agent"
            r4.a(r0, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amazonaws.http.AmazonHttpClient.q(com.amazonaws.Request):void");
    }

    public final boolean r(AmazonWebServiceRequest amazonWebServiceRequest, InputStream inputStream, AmazonClientException amazonClientException, int i11, RetryPolicy retryPolicy) {
        int i12 = i11 - 1;
        int b11 = this.f14876b.b();
        if (b11 < 0 || !retryPolicy.d()) {
            b11 = retryPolicy.b();
        }
        if (i12 >= b11) {
            return false;
        }
        if (inputStream == null || inputStream.markSupported()) {
            return retryPolicy.c().a(amazonWebServiceRequest, amazonClientException, i12);
        }
        Log log = f14874f;
        if (log.i()) {
            log.h("Content not repeatable");
        }
        return false;
    }

    public void s() {
        this.f14875a.shutdown();
    }
}
