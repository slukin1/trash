package com.huobi.webcache;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.URLUtil;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.common.net.HttpHeaders;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSession;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Call;
import okhttp3.Dns;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pu.a;

public class g {

    /* renamed from: a  reason: collision with root package name */
    public int f20709a;

    /* renamed from: b  reason: collision with root package name */
    public pu.a f20710b;

    /* renamed from: c  reason: collision with root package name */
    public SoftReference<ArrayList<String>> f20711c;

    /* renamed from: d  reason: collision with root package name */
    public Call.Factory f20712d;

    /* renamed from: e  reason: collision with root package name */
    public long f20713e;

    /* renamed from: f  reason: collision with root package name */
    public long f20714f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f20715g;

    /* renamed from: h  reason: collision with root package name */
    public SSLSocketFactory f20716h;

    /* renamed from: i  reason: collision with root package name */
    public X509TrustManager f20717i;

    /* renamed from: j  reason: collision with root package name */
    public Dns f20718j;

    /* renamed from: k  reason: collision with root package name */
    public List<Interceptor> f20719k;

    /* renamed from: l  reason: collision with root package name */
    public CacheExtensionConfig f20720l;

    /* renamed from: m  reason: collision with root package name */
    public boolean f20721m;

    /* renamed from: n  reason: collision with root package name */
    public boolean f20722n;

    /* renamed from: o  reason: collision with root package name */
    public CacheStrategy f20723o;

    /* renamed from: p  reason: collision with root package name */
    public String f20724p;

    /* renamed from: q  reason: collision with root package name */
    public long f20725q;

    /* renamed from: r  reason: collision with root package name */
    public Context f20726r;

    /* renamed from: s  reason: collision with root package name */
    public boolean f20727s;

    /* renamed from: t  reason: collision with root package name */
    public long f20728t;

    /* renamed from: u  reason: collision with root package name */
    public b f20729u;

    /* renamed from: v  reason: collision with root package name */
    public String f20730v;

    /* renamed from: w  reason: collision with root package name */
    public String f20731w;

    /* renamed from: x  reason: collision with root package name */
    public String f20732x;

    public class a implements HostnameVerifier {
        public a() {
        }

        public boolean verify(String str, SSLSession sSLSession) {
            return true;
        }
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        public static g f20734a = new g((a) null);
    }

    public /* synthetic */ g(a aVar) {
        this();
    }

    public static InputStream e(a.e eVar) {
        if (eVar != null) {
            return new BufferedInputStream(eVar.a(0));
        }
        return null;
    }

    public static g h() {
        return b.f20734a;
    }

    public void a(Request.Builder builder, Map<String, String> map) {
        if (map != null) {
            for (Map.Entry next : map.entrySet()) {
                builder.addHeader((String) next.getKey(), (String) next.getValue());
            }
        }
    }

    public WebResourceResponse b(String str) throws Exception {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Response execute = this.f20712d.newCall(new Request.Builder().url(str).build()).execute();
            String e11 = this.f20720l.e(str);
            if (execute.code() < 200 || execute.code() >= 300) {
                Log.e("WebCacheManager", "doRequest() called with: url = [" + str + "], response.code() = [" + execute.code() + "], 缓存失败");
                throw new Exception("doRequest() called with: url = [" + str + "], response.code() = [" + execute.code() + "], 缓存失败");
            }
            long contentLength = execute.body().contentLength();
            WebResourceResponse webResourceResponse = new WebResourceResponse(e11, "", execute.body().byteStream());
            String message = execute.message();
            if (TextUtils.isEmpty(message)) {
                message = "OK";
            }
            webResourceResponse.setStatusCodeAndReasonPhrase(execute.code(), message);
            webResourceResponse.setResponseHeaders(H5HttpUtils.m(execute.headers().toMultimap()));
            if (this.f20721m) {
                Log.w("WebCacheManager", "doRequest() called with: url = [" + str + "] finish  cost=" + (System.currentTimeMillis() - currentTimeMillis) + "ms  size=" + H5HttpUtils.n(contentLength));
            }
            return webResourceResponse;
        } catch (Exception e12) {
            Log.e("WebCacheManager", "doRequest() called with: url = [" + str + "], IOException = [" + e12 + "], 缓存失败");
            throw e12;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: pu.a$c} */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: type inference failed for: r4v8, types: [java.io.OutputStream] */
    /* JADX WARNING: type inference failed for: r4v9 */
    /* JADX WARNING: type inference failed for: r4v11 */
    /* JADX WARNING: type inference failed for: r4v12 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00c0 A[SYNTHETIC, Splitter:B:39:0x00c0] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(java.lang.String r11, java.lang.String r12, java.util.Map<java.lang.String, java.lang.String> r13) throws java.io.IOException {
        /*
            r10 = this;
            java.lang.String r0 = "], key = ["
            java.lang.String r1 = "], 缓存失败"
            java.lang.String r2 = "WebCacheManager"
            java.lang.String r3 = "doRequest() called with: url = ["
            okhttp3.Request$Builder r4 = new okhttp3.Request$Builder     // Catch:{ IOException -> 0x0131 }
            r4.<init>()     // Catch:{ IOException -> 0x0131 }
            if (r13 == 0) goto L_0x001d
            boolean r5 = r10.f20727s     // Catch:{ IOException -> 0x0131 }
            if (r5 == 0) goto L_0x001d
            java.lang.String r5 = "If-None-Match"
            r13.remove(r5)     // Catch:{ IOException -> 0x0131 }
            java.lang.String r5 = "If-Modified-Since"
            r13.remove(r5)     // Catch:{ IOException -> 0x0131 }
        L_0x001d:
            r10.a(r4, r13)     // Catch:{ IOException -> 0x0131 }
            r4.url((java.lang.String) r11)     // Catch:{ IOException -> 0x0131 }
            okhttp3.Request r13 = r4.build()     // Catch:{ IOException -> 0x0131 }
            okhttp3.Call$Factory r4 = r10.f20712d     // Catch:{ IOException -> 0x0131 }
            okhttp3.Call r13 = r4.newCall(r13)     // Catch:{ IOException -> 0x0131 }
            okhttp3.Response r13 = r13.execute()     // Catch:{ IOException -> 0x0131 }
            int r4 = r13.code()     // Catch:{ IOException -> 0x0131 }
            r5 = 200(0xc8, float:2.8E-43)
            java.lang.String r6 = "], response.code() = ["
            if (r4 < r5) goto L_0x010f
            int r4 = r13.code()     // Catch:{ IOException -> 0x0131 }
            r5 = 300(0x12c, float:4.2E-43)
            if (r4 >= r5) goto L_0x010f
            pu.a r4 = r10.f20710b     // Catch:{ IOException -> 0x0131 }
            if (r4 == 0) goto L_0x0107
            boolean r4 = r4.isClosed()     // Catch:{ IOException -> 0x0131 }
            if (r4 != 0) goto L_0x0107
            r4 = 0
            pu.a r5 = r10.f20710b     // Catch:{ all -> 0x009e }
            pu.a$c r5 = r5.s(r12)     // Catch:{ all -> 0x009e }
            if (r5 == 0) goto L_0x0090
            r7 = 0
            java.io.OutputStream r4 = r5.f(r7)     // Catch:{ all -> 0x008b }
            okhttp3.ResponseBody r7 = r13.body()     // Catch:{ all -> 0x008b }
            byte[] r7 = r7.bytes()     // Catch:{ all -> 0x008b }
            r4.write(r7)     // Catch:{ all -> 0x008b }
            r5.e()     // Catch:{ all -> 0x008b }
            boolean r7 = r10.f20721m     // Catch:{ all -> 0x008b }
            if (r7 == 0) goto L_0x0090
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x008b }
            r7.<init>()     // Catch:{ all -> 0x008b }
            r7.append(r3)     // Catch:{ all -> 0x008b }
            r7.append(r11)     // Catch:{ all -> 0x008b }
            r7.append(r0)     // Catch:{ all -> 0x008b }
            r7.append(r12)     // Catch:{ all -> 0x008b }
            java.lang.String r8 = "], 成功缓存"
            r7.append(r8)     // Catch:{ all -> 0x008b }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x008b }
            android.util.Log.d(r2, r7)     // Catch:{ all -> 0x008b }
            goto L_0x0090
        L_0x008b:
            r7 = move-exception
            r9 = r5
            r5 = r4
            r4 = r9
            goto L_0x00a0
        L_0x0090:
            if (r4 == 0) goto L_0x009d
            r4.flush()     // Catch:{ IOException -> 0x0099 }
            r4.close()     // Catch:{ IOException -> 0x0099 }
            goto L_0x009d
        L_0x0099:
            r12 = move-exception
            r12.printStackTrace()     // Catch:{ IOException -> 0x0131 }
        L_0x009d:
            return
        L_0x009e:
            r7 = move-exception
            r5 = r4
        L_0x00a0:
            r7.printStackTrace()     // Catch:{ all -> 0x00f8 }
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f8 }
            r8.<init>()     // Catch:{ all -> 0x00f8 }
            r8.append(r3)     // Catch:{ all -> 0x00f8 }
            r8.append(r11)     // Catch:{ all -> 0x00f8 }
            r8.append(r0)     // Catch:{ all -> 0x00f8 }
            r8.append(r12)     // Catch:{ all -> 0x00f8 }
            r8.append(r1)     // Catch:{ all -> 0x00f8 }
            java.lang.String r12 = r8.toString()     // Catch:{ all -> 0x00f8 }
            android.util.Log.e(r2, r12)     // Catch:{ all -> 0x00f8 }
            if (r4 == 0) goto L_0x00cd
            r4.a()     // Catch:{ IOException -> 0x00c9, Exception -> 0x00c4 }
            goto L_0x00cd
        L_0x00c4:
            r12 = move-exception
            r12.printStackTrace()     // Catch:{ all -> 0x00f8 }
            goto L_0x00cd
        L_0x00c9:
            r12 = move-exception
            r12.printStackTrace()     // Catch:{ all -> 0x00f8 }
        L_0x00cd:
            java.io.IOException r12 = new java.io.IOException     // Catch:{ all -> 0x00f8 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f8 }
            r0.<init>()     // Catch:{ all -> 0x00f8 }
            r0.append(r3)     // Catch:{ all -> 0x00f8 }
            r0.append(r11)     // Catch:{ all -> 0x00f8 }
            r0.append(r6)     // Catch:{ all -> 0x00f8 }
            int r13 = r13.code()     // Catch:{ all -> 0x00f8 }
            r0.append(r13)     // Catch:{ all -> 0x00f8 }
            java.lang.String r13 = "], 缓存失败:"
            r0.append(r13)     // Catch:{ all -> 0x00f8 }
            java.lang.String r13 = r7.getMessage()     // Catch:{ all -> 0x00f8 }
            r0.append(r13)     // Catch:{ all -> 0x00f8 }
            java.lang.String r13 = r0.toString()     // Catch:{ all -> 0x00f8 }
            r12.<init>(r13)     // Catch:{ all -> 0x00f8 }
            throw r12     // Catch:{ all -> 0x00f8 }
        L_0x00f8:
            r12 = move-exception
            if (r5 == 0) goto L_0x0106
            r5.flush()     // Catch:{ IOException -> 0x0102 }
            r5.close()     // Catch:{ IOException -> 0x0102 }
            goto L_0x0106
        L_0x0102:
            r13 = move-exception
            r13.printStackTrace()     // Catch:{ IOException -> 0x0131 }
        L_0x0106:
            throw r12     // Catch:{ IOException -> 0x0131 }
        L_0x0107:
            java.io.IOException r12 = new java.io.IOException     // Catch:{ IOException -> 0x0131 }
            java.lang.String r13 = "diskLruCache io Exception"
            r12.<init>(r13)     // Catch:{ IOException -> 0x0131 }
            throw r12     // Catch:{ IOException -> 0x0131 }
        L_0x010f:
            java.io.IOException r12 = new java.io.IOException     // Catch:{ IOException -> 0x0131 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0131 }
            r0.<init>()     // Catch:{ IOException -> 0x0131 }
            r0.append(r3)     // Catch:{ IOException -> 0x0131 }
            r0.append(r11)     // Catch:{ IOException -> 0x0131 }
            r0.append(r6)     // Catch:{ IOException -> 0x0131 }
            int r13 = r13.code()     // Catch:{ IOException -> 0x0131 }
            r0.append(r13)     // Catch:{ IOException -> 0x0131 }
            r0.append(r1)     // Catch:{ IOException -> 0x0131 }
            java.lang.String r13 = r0.toString()     // Catch:{ IOException -> 0x0131 }
            r12.<init>(r13)     // Catch:{ IOException -> 0x0131 }
            throw r12     // Catch:{ IOException -> 0x0131 }
        L_0x0131:
            r12 = move-exception
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>()
            r13.append(r3)
            r13.append(r11)
            java.lang.String r11 = "], IOException = ["
            r13.append(r11)
            r13.append(r12)
            r13.append(r1)
            java.lang.String r11 = r13.toString()
            android.util.Log.e(r2, r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.webcache.g.c(java.lang.String, java.lang.String, java.util.Map):void");
    }

    public final String d(String str, String str2, String str3) {
        Object[] objArr = new Object[3];
        if (TextUtils.isEmpty(str2)) {
            str2 = "mimeType";
        }
        objArr[0] = str2;
        if (TextUtils.isEmpty(str3)) {
            str3 = "encoding";
        }
        objArr[1] = str3;
        objArr[2] = str;
        return H5HttpUtils.l(String.format("key_%s_%s_url=%s", objArr));
    }

    public a.e f(String str, String str2, String str3) {
        return g(str, str2, str3, System.currentTimeMillis(), d(str, str2, str3));
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x005f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0060 A[RETURN] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final pu.a.e g(java.lang.String r2, java.lang.String r3, java.lang.String r4, long r5, java.lang.String r7) {
        /*
            r1 = this;
            pu.a r3 = r1.f20710b
            r4 = 0
            if (r3 == 0) goto L_0x0060
            boolean r3 = r3.isClosed()
            if (r3 != 0) goto L_0x0060
            pu.a r3 = r1.f20710b     // Catch:{ IOException -> 0x0045 }
            pu.a$e r3 = r3.u(r7)     // Catch:{ IOException -> 0x0045 }
            boolean r5 = r1.f20721m     // Catch:{ IOException -> 0x0043 }
            if (r5 == 0) goto L_0x005d
            java.lang.String r5 = "WebCacheManager"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0043 }
            r6.<init>()     // Catch:{ IOException -> 0x0043 }
            java.lang.String r0 = "WebCacheManager get "
            r6.append(r0)     // Catch:{ IOException -> 0x0043 }
            r6.append(r2)     // Catch:{ IOException -> 0x0043 }
            java.lang.String r2 = " ->  "
            r6.append(r2)     // Catch:{ IOException -> 0x0043 }
            r6.append(r7)     // Catch:{ IOException -> 0x0043 }
            java.lang.String r2 = " "
            r6.append(r2)     // Catch:{ IOException -> 0x0043 }
            if (r3 == 0) goto L_0x0036
            java.lang.String r2 = "命中"
            goto L_0x0038
        L_0x0036:
            java.lang.String r2 = "无缓存"
        L_0x0038:
            r6.append(r2)     // Catch:{ IOException -> 0x0043 }
            java.lang.String r2 = r6.toString()     // Catch:{ IOException -> 0x0043 }
            android.util.Log.d(r5, r2)     // Catch:{ IOException -> 0x0043 }
            goto L_0x005d
        L_0x0043:
            r2 = move-exception
            goto L_0x0047
        L_0x0045:
            r2 = move-exception
            r3 = r4
        L_0x0047:
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r6 = "WebCacheManager has.IOException "
            r5.append(r6)
            r5.append(r2)
            java.lang.String r2 = r5.toString()
            java.lang.String r5 = "Error"
            android.util.Log.e(r5, r2)
        L_0x005d:
            if (r3 == 0) goto L_0x0060
            return r3
        L_0x0060:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.huobi.webcache.g.g(java.lang.String, java.lang.String, java.lang.String, long, java.lang.String):pu.a$e");
    }

    public final void i() {
        X509TrustManager x509TrustManager;
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (this.f20722n) {
            builder.cache(new Cache(new File(this.f20724p, "CacheWebViewCache"), this.f20725q));
        }
        long j11 = this.f20713e;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        builder.connectTimeout(j11, timeUnit).readTimeout(this.f20714f, timeUnit);
        if (this.f20715g) {
            builder.hostnameVerifier(new a());
        }
        SSLSocketFactory sSLSocketFactory = this.f20716h;
        if (!(sSLSocketFactory == null || (x509TrustManager = this.f20717i) == null)) {
            builder.sslSocketFactory(sSLSocketFactory, x509TrustManager);
        }
        Dns dns = this.f20718j;
        if (dns != null) {
            builder.dns(dns);
        }
        List<Interceptor> list = this.f20719k;
        if (list != null && !list.isEmpty()) {
            for (Interceptor addInterceptor : this.f20719k) {
                builder.addInterceptor(addInterceptor);
            }
        }
        this.f20712d = builder.build();
    }

    public void j(String str, int i11, long j11) {
        if (!this.f20722n) {
            this.f20709a = i11;
            this.f20724p = str;
            this.f20728t = j11;
            File file = new File(this.f20724p, "webcache");
            if (!file.exists()) {
                file.mkdirs();
            }
            try {
                if (this.f20721m) {
                    Log.d("WebCacheManager", "init() called " + file.getPath());
                }
                this.f20710b = pu.a.w(file, this.f20709a, 1, j11);
            } catch (Exception e11) {
                Log.e("Error", "WebCacheManager initTravel Exception:" + e11);
            }
        }
    }

    public boolean k(a.e eVar) {
        System.currentTimeMillis();
        pu.a aVar = this.f20710b;
        return (aVar == null || aVar.isClosed() || eVar == null) ? false : true;
    }

    public boolean l(String str) {
        return URLUtil.isValidUrl(str);
    }

    public void m(WebView webView, String str) {
        WebViewClient webViewClient;
        if (l(str)) {
            if (Build.VERSION.SDK_INT >= 26 && (webViewClient = webView.getWebViewClient()) != null && (webViewClient instanceof a)) {
                ((a) webViewClient).b(str);
            }
            webView.loadUrl(str);
            SensorsDataAutoTrackHelper.loadUrl2(webView, str);
            String url = webView.getUrl();
            this.f20731w = url;
            this.f20730v = H5HttpUtils.g(url);
            this.f20732x = webView.getSettings().getUserAgentString();
        }
    }

    public void n(WebView webView, String str, Map<String, String> map) {
        WebViewClient webViewClient;
        if (l(str)) {
            b bVar = this.f20729u;
            if (bVar != null) {
                bVar.b(webView, str);
                Map<String, String> a11 = this.f20729u.a();
                if (a11 != null && !a11.isEmpty()) {
                    if (map != null) {
                        map.putAll(a11);
                    } else {
                        map = a11;
                    }
                }
            }
            if (Build.VERSION.SDK_INT >= 26 && (webViewClient = webView.getWebViewClient()) != null && (webViewClient instanceof a)) {
                ((a) webViewClient).b(str);
            }
            webView.loadUrl(str, map);
            SensorsDataAutoTrackHelper.loadUrl2(webView, str, map);
            String url = webView.getUrl();
            this.f20731w = url;
            this.f20730v = H5HttpUtils.g(url);
            this.f20732x = webView.getSettings().getUserAgentString();
        }
    }

    public void o(String str, String str2, String str3, Map<String, String> map) throws IOException {
        c(str, d(str, str2, str3), map);
    }

    public void p() {
        Log.e("WebCacheManager", String.format("removeAll() called mHttpClient= %s mHttpClient= %s  diskLruCache = %s", new Object[]{this.f20712d, Boolean.valueOf(this.f20722n), this.f20710b}));
        if (this.f20722n) {
            H5HttpUtils.f(new File(this.f20724p, "CacheWebViewCache").getPath());
        }
        pu.a aVar = this.f20710b;
        if (aVar != null && !aVar.isClosed()) {
            try {
                this.f20710b.p();
                j(this.f20724p, this.f20709a, this.f20728t);
            } catch (IOException e11) {
                Log.e("Error", "removeAll:   Exce:", e11);
            }
        }
    }

    public WebResourceResponse q(String str, Map<String, String> map) throws IllegalArgumentException, IOException {
        Request.Builder url = new Request.Builder().url(str);
        if (this.f20720l.h(CacheExtensionConfig.c(str))) {
            map.put("WebResourceInterceptor-Key-Cache", "1");
        }
        if (map != null && this.f20727s) {
            map.remove(HttpHeaders.IF_NONE_MATCH);
            map.remove(HttpHeaders.IF_MODIFIED_SINCE);
        }
        a(url, map);
        if (!H5HttpUtils.h(this.f20726r)) {
            url.cacheControl(CacheControl.FORCE_CACHE);
        }
        Response execute = this.f20712d.newCall(url.build()).execute();
        if (execute.cacheResponse() != null) {
            if (this.f20721m) {
                Log.e("WebCacheManager", String.format("from cache zp::: %s", new Object[]{str}));
            }
            if (WebCacheInterecptRequest.f20660m) {
                WebCacheInterecptRequest.f20665r.add(str);
                WebCacheInterecptRequest.f20663p++;
            }
        } else if (this.f20721m) {
            Log.e("WebCacheManager", String.format("from server zp::: %s", new Object[]{str}));
        }
        WebResourceResponse webResourceResponse = new WebResourceResponse(this.f20720l.e(str), "", execute.body().byteStream());
        if (this.f20721m) {
            Log.d("WebCacheManager", "request() called with: url = [" + str + "], headers = [" + map + "]response.code()=" + execute.code());
        }
        if (execute.code() != 504 || H5HttpUtils.h(this.f20726r)) {
            if (Build.VERSION.SDK_INT >= 21) {
                String message = execute.message();
                if (TextUtils.isEmpty(message)) {
                    message = "OK";
                }
                try {
                    webResourceResponse.setStatusCodeAndReasonPhrase(execute.code(), message);
                    webResourceResponse.setResponseHeaders(H5HttpUtils.m(execute.headers().toMultimap()));
                } catch (IllegalArgumentException e11) {
                    e11.printStackTrace();
                    throw e11;
                }
            }
            return webResourceResponse;
        }
        throw new IOException("response.code()" + execute.code());
    }

    public void r(CacheStrategy cacheStrategy) {
        this.f20723o = cacheStrategy;
    }

    public void s(boolean z11) {
        this.f20727s = z11;
    }

    public void t(Context context) {
        this.f20726r = context;
    }

    public void u(boolean z11) {
        this.f20721m = z11;
    }

    public void v(String str, long j11, long j12, long j13, boolean z11, SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager, Dns dns, List<Interceptor> list) {
        this.f20713e = j12;
        this.f20714f = j13;
        this.f20715g = z11;
        this.f20716h = sSLSocketFactory;
        this.f20717i = x509TrustManager;
        this.f20718j = dns;
        this.f20724p = str;
        this.f20725q = j11;
        if (list != null && !list.isEmpty()) {
            this.f20719k.clear();
            this.f20719k.addAll(list);
        }
        i();
    }

    public void w(b bVar) {
        this.f20729u = bVar;
    }

    public void x(boolean z11) {
        this.f20722n = z11;
        if (!z11) {
            j(this.f20724p, this.f20709a, this.f20728t);
        }
    }

    public g() {
        this.f20709a = 1;
        this.f20711c = new SoftReference<>(new ArrayList(500));
        this.f20713e = 5;
        this.f20714f = 5;
        this.f20719k = new ArrayList();
        this.f20720l = new CacheExtensionConfig();
        this.f20721m = false;
        this.f20722n = true;
        this.f20723o = CacheStrategy.FORCE;
        this.f20727s = false;
        this.f20728t = 524288000;
        this.f20730v = "";
        this.f20731w = "";
        this.f20732x = "";
    }
}
