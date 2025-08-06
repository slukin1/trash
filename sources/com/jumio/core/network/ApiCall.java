package com.jumio.core.network;

import android.net.ConnectivityManager;
import com.adjust.sdk.Constants;
import com.google.common.net.HttpHeaders;
import com.jumio.analytics.Analytics;
import com.jumio.analytics.MobileEvents;
import com.jumio.commons.log.Log;
import com.jumio.commons.log.LogUtils;
import com.jumio.core.api.BackendManager;
import com.jumio.core.models.ApiCallDataModel;
import com.jumio.core.util.LocaleUtil;
import com.jumio.core.util.LocaleUtilKt;
import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Callable;
import javax.net.ssl.HttpsURLConnection;
import jumio.core.d;
import jumio.core.d1;
import jumio.core.f2;
import jumio.core.h;
import jumio.core.s2;
import jumio.core.t2;
import jumio.core.w1;
import kotlin.jvm.internal.x;
import kotlin.l;
import org.json.JSONObject;

public abstract class ApiCall<T> extends f2<T> implements Callable<T> {

    /* renamed from: c  reason: collision with root package name */
    public final h f39413c;

    /* renamed from: d  reason: collision with root package name */
    public final ApiCallDataModel<?> f39414d;

    /* renamed from: e  reason: collision with root package name */
    public final String f39415e;

    /* renamed from: f  reason: collision with root package name */
    public final String f39416f;

    /* renamed from: g  reason: collision with root package name */
    public final Map<String, String> f39417g;

    public final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        public final HttpURLConnection f39418a;

        /* renamed from: b  reason: collision with root package name */
        public final d1 f39419b;

        public a(HttpURLConnection httpURLConnection, d1 d1Var) {
            this.f39418a = httpURLConnection;
            this.f39419b = d1Var;
        }

        public final void run() {
            try {
                this.f39418a.getResponseCode();
            } catch (Exception e11) {
                Log.printStackTrace(e11);
            } finally {
                this.f39419b.a();
                this.f39418a.disconnect();
            }
        }
    }

    public ApiCall(h hVar, ApiCallDataModel<?> apiCallDataModel) {
        this.f39413c = hVar;
        this.f39414d = apiCallDataModel;
        Locale locale = LocaleUtil.INSTANCE.getLocale(hVar.getContext());
        locale = locale == null ? Locale.getDefault() : locale;
        String simpleName = getClass().getSimpleName();
        this.f39415e = "Network/" + simpleName;
        this.f39416f = "POST";
        this.f39417g = MapsKt__MapsKt.l(l.a("User-Agent", hVar.getUserAgent()), l.a("Accept-Language", LocaleUtilKt.getBcp47(locale)), l.a(HttpHeaders.CONTENT_ENCODING, "identity"), l.a(HttpHeaders.ACCEPT_ENCODING, "identity"), l.a("Accept", "application/json"));
    }

    public static /* synthetic */ void getTAG$annotations() {
    }

    public final boolean a() {
        return ((ConnectivityManager) this.f39413c.getContext().getSystemService("connectivity")).getActiveNetworkInfo() == null;
    }

    public T call() throws Exception {
        T t11;
        Log.i(this.f39415e, "-> call()");
        try {
            if (!a()) {
                Log.v(this.f39415e, "execute()");
                try {
                    t11 = execute();
                } catch (d e11) {
                    Log.w(this.f39415e, "### ALE key update required. Re-execute call", (Throwable) e11);
                    t11 = execute();
                }
                publishResult(t11);
                Log.i(this.f39415e, "<- call(success)");
                return t11;
            }
            Log.w(this.f39415e, "Device is offline");
            throw new Exception("Device is offline");
        } catch (SocketTimeoutException e12) {
            Log.i(this.f39415e, "<- call(failed)");
            if (this.f39414d.getIgnoreErrors()) {
                publishResult(null);
                return null;
            }
            publishError(e12);
            return null;
        } catch (w1 e13) {
            Log.i(this.f39415e, "<- call(failed)");
            if (this.f39414d.getIgnoreErrors()) {
                publishResult(null);
                return null;
            }
            publishError(e13);
            return null;
        } catch (Exception e14) {
            Log.w(this.f39415e, "<- call(failed general error)", (Throwable) e14);
            if (this.f39414d.getIgnoreErrors()) {
                publishResult(null);
                return null;
            }
            publishError(e14);
            return null;
        }
    }

    public final HttpURLConnection createClient(String str) throws IOException, KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        URL url = new URL(str);
        if (url.getProtocol().equals(Constants.SCHEME)) {
            HttpsURLConnection httpsURLConnection = (HttpsURLConnection) url.openConnection();
            httpsURLConnection.setSSLSocketFactory(new s2(new TrustManagerInterface[]{this.f39413c.getTrustManager()}));
            httpsURLConnection.setRequestMethod(getMethod());
            httpsURLConnection.setUseCaches(false);
            httpsURLConnection.setDoInput(true);
            httpsURLConnection.setDoOutput(!x.b("GET", getMethod()));
            for (Map.Entry next : getHeaders().entrySet()) {
                httpsURLConnection.setRequestProperty((String) next.getKey(), (String) next.getValue());
            }
            httpsURLConnection.setRequestProperty("Content-Type", "application/ale");
            httpsURLConnection.setConnectTimeout(this.f39414d.getTimeout());
            httpsURLConnection.setReadTimeout(this.f39414d.getTimeout());
            return httpsURLConnection;
        }
        throw new Exception("Only https ApiCalls are supported!");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x005b, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x005c, code lost:
        r2 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:120:0x0210, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x0212, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:122:0x0214, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:127:0x0221, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:128:0x0222, code lost:
        r14 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:129:0x0223, code lost:
        r2 = r14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:130:0x0225, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:131:0x0226, code lost:
        r17 = 0;
        r11 = r4;
        r15 = r6;
        r2 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:139:0x023c, code lost:
        r11.reportResponse(r15, r10, (java.lang.Integer) null, r12, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:150:0x0258, code lost:
        r1 = new jumio.core.t2(900, r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:151:0x0264, code lost:
        r1 = new jumio.core.w1(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0114, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x0115, code lost:
        r11 = r4;
        r14 = r5;
        r16 = r15;
        r3 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:84:0x01aa, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x01ac, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x01ad, code lost:
        r16 = r15;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:90:0x01bf, B:115:0x01fc] */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x005b A[ExcHandler: all (th java.lang.Throwable), Splitter:B:8:0x0053] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x0204 A[Catch:{ Exception -> 0x0212, all -> 0x0210 }] */
    /* JADX WARNING: Removed duplicated region for block: B:120:0x0210 A[ExcHandler: all (th java.lang.Throwable), PHI: r14 
      PHI: (r14v6 java.net.HttpURLConnection) = (r14v7 java.net.HttpURLConnection), (r14v16 java.net.HttpURLConnection), (r14v19 java.net.HttpURLConnection) binds: [B:115:0x01fc, B:90:0x01bf, B:98:0x01d6] A[DONT_GENERATE, DONT_INLINE], Splitter:B:90:0x01bf] */
    /* JADX WARNING: Removed duplicated region for block: B:127:0x0221 A[ExcHandler: all (th java.lang.Throwable), Splitter:B:3:0x002d] */
    /* JADX WARNING: Removed duplicated region for block: B:139:0x023c A[Catch:{ all -> 0x022d }] */
    /* JADX WARNING: Removed duplicated region for block: B:150:0x0258 A[Catch:{ all -> 0x022d }] */
    /* JADX WARNING: Removed duplicated region for block: B:151:0x0264 A[Catch:{ all -> 0x022d }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final T execute() throws java.net.SocketTimeoutException, jumio.core.w1, jumio.core.t2, javax.net.ssl.SSLException {
        /*
            r22 = this;
            r7 = r22
            java.lang.String r1 = ""
            java.lang.String r6 = r22.getCallId()
            com.jumio.core.util.DataDogHelper r0 = com.jumio.core.util.DataDogHelper.INSTANCE
            com.jumio.core.plugins.AnalyticsPlugin r4 = r0.getPlugin()
            r2 = 0
            r3 = 0
            jumio.core.h r0 = r7.f39413c     // Catch:{ Exception -> 0x022f }
            java.lang.String r0 = r0.getHost()     // Catch:{ Exception -> 0x022f }
            java.lang.String r5 = r22.getUri()     // Catch:{ Exception -> 0x022f }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x022f }
            r8.<init>()     // Catch:{ Exception -> 0x022f }
            r8.append(r0)     // Catch:{ Exception -> 0x022f }
            r8.append(r5)     // Catch:{ Exception -> 0x022f }
            java.lang.String r0 = r8.toString()     // Catch:{ Exception -> 0x022f }
            java.net.HttpURLConnection r5 = r7.createClient(r0)     // Catch:{ Exception -> 0x022f }
            int r0 = r22.prepareRequest()     // Catch:{ Exception -> 0x0225, all -> 0x0221 }
            java.net.URL r8 = r5.getURL()     // Catch:{ Exception -> 0x0225, all -> 0x0221 }
            java.lang.String r15 = r8.toString()     // Catch:{ Exception -> 0x0225, all -> 0x0221 }
            java.lang.String r8 = r7.f39415e     // Catch:{ Exception -> 0x0214, all -> 0x0221 }
            kotlin.jvm.internal.d0 r9 = kotlin.jvm.internal.d0.f56774a     // Catch:{ Exception -> 0x0214, all -> 0x0221 }
            java.lang.String r9 = "Sending request %s"
            r10 = 1
            java.lang.Object[] r11 = new java.lang.Object[r10]     // Catch:{ Exception -> 0x0214, all -> 0x0221 }
            r11[r3] = r15     // Catch:{ Exception -> 0x0214, all -> 0x0221 }
            java.lang.Object[] r11 = java.util.Arrays.copyOf(r11, r10)     // Catch:{ Exception -> 0x0214, all -> 0x0221 }
            java.lang.String r9 = java.lang.String.format(r9, r11)     // Catch:{ Exception -> 0x0214, all -> 0x0221 }
            com.jumio.commons.log.Log.d((java.lang.String) r8, (java.lang.String) r9)     // Catch:{ Exception -> 0x0214, all -> 0x0221 }
            com.jumio.commons.log.LogLevel r8 = com.jumio.commons.log.LogLevel.OFF     // Catch:{ Exception -> 0x0214, all -> 0x0221 }
            if (r4 == 0) goto L_0x0062
            java.lang.String r8 = r5.getRequestMethod()     // Catch:{ Exception -> 0x005f, all -> 0x005b }
            r4.reportRequest(r6, r15, r0, r8)     // Catch:{ Exception -> 0x005f, all -> 0x005b }
            goto L_0x0062
        L_0x005b:
            r0 = move-exception
            r2 = r5
            goto L_0x026b
        L_0x005f:
            r0 = move-exception
            goto L_0x0217
        L_0x0062:
            long r8 = java.lang.System.nanoTime()     // Catch:{ Exception -> 0x0214, all -> 0x0221 }
            jumio.core.h r11 = r7.f39413c     // Catch:{ Exception -> 0x0214, all -> 0x0221 }
            jumio.core.d1 r11 = r11.getEncryptionProvider()     // Catch:{ Exception -> 0x0214, all -> 0x0221 }
            if (r11 != 0) goto L_0x008e
            com.jumio.core.error.Error r0 = new com.jumio.core.error.Error     // Catch:{ Exception -> 0x005f, all -> 0x005b }
            com.jumio.core.enums.ErrorCase r17 = com.jumio.core.enums.ErrorCase.OCR_LOADING_FAILED     // Catch:{ Exception -> 0x005f, all -> 0x005b }
            r18 = 0
            r19 = 0
            r20 = 6
            r21 = 0
            r16 = r0
            r16.<init>(r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x005f, all -> 0x005b }
            r7.publishError(r0)     // Catch:{ Exception -> 0x005f, all -> 0x005b }
            com.jumio.core.models.ApiCallDataModel<?> r0 = r7.f39414d
            boolean r0 = r0.getFireAndForget()
            if (r0 != 0) goto L_0x008d
            r5.disconnect()
        L_0x008d:
            return r2
        L_0x008e:
            r12 = 4696837146684686336(0x412e848000000000, double:1000000.0)
            java.lang.String r14 = r5.getRequestMethod()     // Catch:{ all -> 0x01f4 }
            java.lang.String r10 = "GET"
            boolean r10 = kotlin.jvm.internal.x.b(r14, r10)     // Catch:{ all -> 0x01f4 }
            if (r10 != 0) goto L_0x00d4
            java.io.OutputStream r10 = r5.getOutputStream()     // Catch:{ all -> 0x00cc }
            java.util.Map r14 = r22.getHeaders()     // Catch:{ all -> 0x00cc }
            java.lang.String r3 = "Content-Type"
            java.lang.Object r3 = r14.get(r3)     // Catch:{ all -> 0x00cc }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00cc }
            if (r3 != 0) goto L_0x00b3
            java.lang.String r3 = "application/json"
        L_0x00b3:
            com.jumio.ale.swig.ALEOutputStream r3 = r11.a(r10, r0, r3)     // Catch:{ all -> 0x00cc }
            r7.fillRequest(r3)     // Catch:{ all -> 0x00c3 }
            r3.flush()     // Catch:{ all -> 0x00c3 }
            kotlin.Unit r0 = kotlin.Unit.f56620a     // Catch:{ all -> 0x00c3 }
            kotlin.io.b.a(r3, r2)     // Catch:{ all -> 0x00cc }
            goto L_0x00d4
        L_0x00c3:
            r0 = move-exception
            r1 = r0
            throw r1     // Catch:{ all -> 0x00c6 }
        L_0x00c6:
            r0 = move-exception
            r2 = r0
            kotlin.io.b.a(r3, r1)     // Catch:{ all -> 0x00cc }
            throw r2     // Catch:{ all -> 0x00cc }
        L_0x00cc:
            r0 = move-exception
            r11 = r4
            r14 = r5
            r16 = r15
            r3 = 0
            goto L_0x01fb
        L_0x00d4:
            com.jumio.core.models.ApiCallDataModel<?> r0 = r7.f39414d     // Catch:{ all -> 0x01e9 }
            boolean r0 = r0.getFireAndForget()     // Catch:{ all -> 0x01e9 }
            if (r0 == 0) goto L_0x011c
            java.lang.Thread r0 = new java.lang.Thread     // Catch:{ all -> 0x00cc }
            com.jumio.core.network.ApiCall$a r2 = new com.jumio.core.network.ApiCall$a     // Catch:{ all -> 0x00cc }
            r2.<init>(r5, r11)     // Catch:{ all -> 0x00cc }
            r0.<init>(r2)     // Catch:{ all -> 0x00cc }
            r0.start()     // Catch:{ all -> 0x00cc }
            java.lang.String r0 = r7.f39415e     // Catch:{ all -> 0x00cc }
            java.lang.String r2 = "Started fire&forget call - return with empty response"
            com.jumio.commons.log.Log.d((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ all -> 0x00cc }
            java.lang.Object r0 = r7.parseResponse(r1)     // Catch:{ all -> 0x00cc }
            com.jumio.core.models.ApiCallDataModel<?> r1 = r7.f39414d     // Catch:{ Exception -> 0x0114, all -> 0x005b }
            boolean r1 = r1.getFireAndForget()     // Catch:{ Exception -> 0x0114, all -> 0x005b }
            if (r1 != 0) goto L_0x0108
            long r1 = java.lang.System.nanoTime()     // Catch:{ Exception -> 0x0114, all -> 0x005b }
            long r1 = r1 - r8
            double r1 = (double) r1     // Catch:{ Exception -> 0x0114, all -> 0x005b }
            double r1 = r1 / r12
            long r1 = (long) r1     // Catch:{ Exception -> 0x0114, all -> 0x005b }
            r3 = 0
            r7.responseReceived(r3, r1)     // Catch:{ Exception -> 0x0114, all -> 0x005b }
        L_0x0108:
            com.jumio.core.models.ApiCallDataModel<?> r1 = r7.f39414d
            boolean r1 = r1.getFireAndForget()
            if (r1 != 0) goto L_0x0113
            r5.disconnect()
        L_0x0113:
            return r0
        L_0x0114:
            r0 = move-exception
            r11 = r4
            r14 = r5
            r16 = r15
            r3 = 0
            goto L_0x021b
        L_0x011c:
            int r3 = r5.getResponseCode()     // Catch:{ all -> 0x01e9 }
            java.lang.String r0 = r7.f39415e     // Catch:{ all -> 0x01e6 }
            java.util.Locale r1 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x01e6 }
            java.lang.String r2 = "Response was %d, %s"
            r10 = 2
            java.lang.Object[] r14 = new java.lang.Object[r10]     // Catch:{ all -> 0x01e6 }
            java.lang.Integer r18 = java.lang.Integer.valueOf(r3)     // Catch:{ all -> 0x01e6 }
            r17 = 0
            r14[r17] = r18     // Catch:{ all -> 0x01e6 }
            java.lang.String r18 = r5.getResponseMessage()     // Catch:{ all -> 0x01e6 }
            r16 = 1
            r14[r16] = r18     // Catch:{ all -> 0x01e6 }
            java.lang.Object[] r14 = java.util.Arrays.copyOf(r14, r10)     // Catch:{ all -> 0x01e6 }
            java.lang.String r2 = java.lang.String.format(r1, r2, r14)     // Catch:{ all -> 0x01e6 }
            com.jumio.commons.log.Log.d((java.lang.String) r0, (java.lang.String) r2)     // Catch:{ all -> 0x01e6 }
            java.lang.String r0 = r7.f39415e     // Catch:{ all -> 0x01e6 }
            java.lang.String r2 = "Received response for %s in %d ms"
            java.lang.Object[] r14 = new java.lang.Object[r10]     // Catch:{ all -> 0x01e6 }
            java.net.URL r18 = r5.getURL()     // Catch:{ all -> 0x01e6 }
            java.lang.String r18 = r18.toString()     // Catch:{ all -> 0x01e6 }
            r17 = 0
            r14[r17] = r18     // Catch:{ all -> 0x01e6 }
            r17 = 0
            java.lang.Long r19 = java.lang.Long.valueOf(r17)     // Catch:{ all -> 0x01e6 }
            r16 = 1
            r14[r16] = r19     // Catch:{ all -> 0x01e6 }
            java.lang.Object[] r10 = java.util.Arrays.copyOf(r14, r10)     // Catch:{ all -> 0x01e6 }
            java.lang.String r1 = java.lang.String.format(r1, r2, r10)     // Catch:{ all -> 0x01e6 }
            com.jumio.commons.log.Log.v((java.lang.String) r0, (java.lang.String) r1)     // Catch:{ all -> 0x01e6 }
            com.jumio.core.models.ApiCallDataModel<?> r0 = r7.f39414d     // Catch:{ Exception -> 0x01e3, all -> 0x0221 }
            boolean r0 = r0.getFireAndForget()     // Catch:{ Exception -> 0x01e3, all -> 0x0221 }
            if (r0 != 0) goto L_0x0180
            long r0 = java.lang.System.nanoTime()     // Catch:{ Exception -> 0x005f, all -> 0x005b }
            long r0 = r0 - r8
            double r0 = (double) r0     // Catch:{ Exception -> 0x005f, all -> 0x005b }
            double r0 = r0 / r12
            long r0 = (long) r0     // Catch:{ Exception -> 0x005f, all -> 0x005b }
            r7.responseReceived(r3, r0)     // Catch:{ Exception -> 0x005f, all -> 0x005b }
            r17 = r0
        L_0x0180:
            r0 = 200(0xc8, float:2.8E-43)
            if (r3 != r0) goto L_0x0189
            java.io.InputStream r0 = r5.getInputStream()     // Catch:{ t2 -> 0x01cf }
            goto L_0x018d
        L_0x0189:
            java.io.InputStream r0 = r5.getErrorStream()     // Catch:{  }
        L_0x018d:
            java.lang.String r0 = r11.a(r0)     // Catch:{  }
            if (r4 == 0) goto L_0x01b3
            int r1 = r5.getContentLength()     // Catch:{ Exception -> 0x01ac, all -> 0x005b }
            java.lang.Integer r11 = java.lang.Integer.valueOf(r1)     // Catch:{ Exception -> 0x01ac, all -> 0x005b }
            r13 = 0
            r14 = 16
            r1 = 0
            r8 = r4
            r9 = r6
            r10 = r15
            r12 = r3
            r16 = r15
            r15 = r1
            com.jumio.core.plugins.AnalyticsPlugin.DefaultImpls.reportResponse$default(r8, r9, r10, r11, r12, r13, r14, r15)     // Catch:{ Exception -> 0x01aa, all -> 0x005b }
            goto L_0x01b5
        L_0x01aa:
            r0 = move-exception
            goto L_0x01af
        L_0x01ac:
            r0 = move-exception
            r16 = r15
        L_0x01af:
            r11 = r4
            r14 = r5
            goto L_0x021b
        L_0x01b3:
            r16 = r15
        L_0x01b5:
            r1 = r22
            r2 = r5
            r10 = r3
            r11 = r4
            r14 = r5
            r4 = r17
            r15 = r6
            r6 = r0
            java.lang.Object r0 = r1.a(r2, r3, r4, r6)     // Catch:{ Exception -> 0x01e0, all -> 0x0210 }
            com.jumio.core.models.ApiCallDataModel<?> r1 = r7.f39414d
            boolean r1 = r1.getFireAndForget()
            if (r1 != 0) goto L_0x01ce
            r14.disconnect()
        L_0x01ce:
            return r0
        L_0x01cf:
            r0 = move-exception
            r10 = r3
            r11 = r4
            r14 = r5
            r16 = r15
            r15 = r6
            int r1 = r0.a()     // Catch:{ Exception -> 0x01e0, all -> 0x0210 }
            if (r1 != 0) goto L_0x01df
            r0.a(r10)     // Catch:{ Exception -> 0x01e0, all -> 0x0210 }
        L_0x01df:
            throw r0     // Catch:{ Exception -> 0x01e0, all -> 0x0210 }
        L_0x01e0:
            r0 = move-exception
            r3 = r10
            goto L_0x021c
        L_0x01e3:
            r0 = move-exception
            r10 = r3
            goto L_0x0217
        L_0x01e6:
            r0 = move-exception
            r10 = r3
            goto L_0x01f7
        L_0x01e9:
            r0 = move-exception
            r11 = r4
            r14 = r5
            r16 = r15
            r17 = 0
            r15 = r6
            r3 = r17
            goto L_0x01fc
        L_0x01f4:
            r0 = move-exception
            r17 = r3
        L_0x01f7:
            r11 = r4
            r14 = r5
            r16 = r15
        L_0x01fb:
            r15 = r6
        L_0x01fc:
            com.jumio.core.models.ApiCallDataModel<?> r1 = r7.f39414d     // Catch:{ Exception -> 0x0212, all -> 0x0210 }
            boolean r1 = r1.getFireAndForget()     // Catch:{ Exception -> 0x0212, all -> 0x0210 }
            if (r1 != 0) goto L_0x020f
            long r1 = java.lang.System.nanoTime()     // Catch:{ Exception -> 0x0212, all -> 0x0210 }
            long r1 = r1 - r8
            double r1 = (double) r1     // Catch:{ Exception -> 0x0212, all -> 0x0210 }
            double r1 = r1 / r12
            long r1 = (long) r1     // Catch:{ Exception -> 0x0212, all -> 0x0210 }
            r7.responseReceived(r3, r1)     // Catch:{ Exception -> 0x0212, all -> 0x0210 }
        L_0x020f:
            throw r0     // Catch:{ Exception -> 0x0212, all -> 0x0210 }
        L_0x0210:
            r0 = move-exception
            goto L_0x0223
        L_0x0212:
            r0 = move-exception
            goto L_0x021c
        L_0x0214:
            r0 = move-exception
            r17 = r3
        L_0x0217:
            r11 = r4
            r14 = r5
            r16 = r15
        L_0x021b:
            r15 = r6
        L_0x021c:
            r12 = r3
            r2 = r14
            r10 = r16
            goto L_0x0237
        L_0x0221:
            r0 = move-exception
            r14 = r5
        L_0x0223:
            r2 = r14
            goto L_0x026b
        L_0x0225:
            r0 = move-exception
            r17 = r3
            r11 = r4
            r14 = r5
            r15 = r6
            r2 = r14
            goto L_0x0234
        L_0x022d:
            r0 = move-exception
            goto L_0x026b
        L_0x022f:
            r0 = move-exception
            r17 = r3
            r11 = r4
            r15 = r6
        L_0x0234:
            r10 = r1
            r12 = r17
        L_0x0237:
            com.jumio.commons.log.Log.printStackTrace(r0)     // Catch:{ all -> 0x022d }
            if (r11 == 0) goto L_0x0244
            r1 = 0
            r8 = r11
            r9 = r15
            r11 = r1
            r13 = r0
            r8.reportResponse(r9, r10, r11, r12, r13)     // Catch:{ all -> 0x022d }
        L_0x0244:
            boolean r1 = r0 instanceof java.net.SocketTimeoutException     // Catch:{ all -> 0x022d }
            if (r1 != 0) goto L_0x026a
            boolean r1 = r0 instanceof jumio.core.d     // Catch:{ all -> 0x022d }
            if (r1 != 0) goto L_0x026a
            boolean r1 = r0 instanceof jumio.core.t2     // Catch:{ all -> 0x022d }
            if (r1 != 0) goto L_0x026a
            boolean r1 = r0 instanceof javax.net.ssl.SSLException     // Catch:{ all -> 0x022d }
            if (r1 != 0) goto L_0x026a
            boolean r1 = r0 instanceof java.net.ConnectException     // Catch:{ all -> 0x022d }
            if (r1 == 0) goto L_0x0264
            jumio.core.t2 r1 = new jumio.core.t2     // Catch:{ all -> 0x022d }
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x022d }
            r3 = 900(0x384, float:1.261E-42)
            r1.<init>(r3, r0)     // Catch:{ all -> 0x022d }
            goto L_0x0269
        L_0x0264:
            jumio.core.w1 r1 = new jumio.core.w1     // Catch:{ all -> 0x022d }
            r1.<init>(r0)     // Catch:{ all -> 0x022d }
        L_0x0269:
            r0 = r1
        L_0x026a:
            throw r0     // Catch:{ all -> 0x022d }
        L_0x026b:
            com.jumio.core.models.ApiCallDataModel<?> r1 = r7.f39414d
            boolean r1 = r1.getFireAndForget()
            if (r1 != 0) goto L_0x0278
            if (r2 == 0) goto L_0x0278
            r2.disconnect()
        L_0x0278:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.network.ApiCall.execute():java.lang.Object");
    }

    public abstract void fillRequest(OutputStream outputStream) throws IOException;

    public final ApiCallDataModel<?> getApiCallDataModel() {
        return this.f39414d;
    }

    public final h getApiCallSettings() {
        return this.f39413c;
    }

    public String getCallId() {
        return getClass().getSimpleName();
    }

    public Map<String, String> getHeaders() {
        return this.f39417g;
    }

    public String getMethod() {
        return this.f39416f;
    }

    public final String getTAG() {
        return this.f39415e;
    }

    public abstract String getUri();

    public abstract T parseResponse(String str);

    public abstract int prepareRequest() throws Exception;

    public void responseReceived(int i11, long j11) {
        Analytics.Companion.add(MobileEvents.networkRequest(BackendManager.Companion.requestCode$jumio_core_release(getClass()), i11, j11));
    }

    public final T a(HttpURLConnection httpURLConnection, int i11, long j11, String str) {
        LogUtils.INSTANCE.logServerResponse(getClass().getSimpleName(), i11, j11, str);
        if (i11 == 200) {
            Log.d(this.f39415e, "parsing response");
            String str2 = this.f39415e;
            Log.v(str2, "Response: " + str);
            return parseResponse(str);
        }
        String responseMessage = httpURLConnection.getResponseMessage();
        try {
            responseMessage = new JSONObject(str).getString("message");
        } catch (Exception e11) {
            Log.printStackTrace(e11);
        }
        throw new t2(i11, responseMessage);
    }
}
