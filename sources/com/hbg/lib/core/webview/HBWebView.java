package com.hbg.lib.core.webview;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.webkit.DownloadListener;
import android.webkit.MimeTypeMap;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.fragment.app.FragmentActivity;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.hbg.lib.common.utils.LogAndWoodRecorder;
import com.hbg.lib.common.utils.StringUtils;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.GlobalAppConfig;
import com.hbg.lib.core.util.CommonFunc;
import com.hbg.lib.core.webview.bean.HBWebViewOfflineEvent;
import com.hbg.lib.core.webview.trace.WebviewTracer;
import com.hbg.lib.network.hbg.retrofit.HbgRetrofit;
import com.hbg.lib.router.HbgRouter;
import com.huobi.webcache.CacheExtensionConfig;
import com.huobi.webcache.WebCacheInterecptRequest;
import com.huobi.webcache.g;
import com.huobi.woodpecker.WoodPeckerSDK;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import d6.a;
import i6.k;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.greenrobot.eventbus.EventBus;
import v6.w;
import x6.i;

public class HBWebView extends WebView {

    /* renamed from: o  reason: collision with root package name */
    public static b f68802o = null;

    /* renamed from: p  reason: collision with root package name */
    public static boolean f68803p = false;

    /* renamed from: b  reason: collision with root package name */
    public WebViewClient f68804b;

    /* renamed from: c  reason: collision with root package name */
    public FragmentActivity f68805c;

    /* renamed from: d  reason: collision with root package name */
    public i f68806d;

    /* renamed from: e  reason: collision with root package name */
    public e f68807e;

    /* renamed from: f  reason: collision with root package name */
    public String f68808f;

    /* renamed from: g  reason: collision with root package name */
    public String f68809g;

    /* renamed from: h  reason: collision with root package name */
    public d f68810h;

    /* renamed from: i  reason: collision with root package name */
    public boolean f68811i = true;

    /* renamed from: j  reason: collision with root package name */
    public int f68812j = 0;

    /* renamed from: k  reason: collision with root package name */
    public boolean f68813k = false;

    /* renamed from: l  reason: collision with root package name */
    public Boolean f68814l = null;

    /* renamed from: m  reason: collision with root package name */
    public boolean f68815m = false;

    /* renamed from: n  reason: collision with root package name */
    public String f68816n = "";

    public class a implements DownloadListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Context f68817a;

        public a(Context context) {
            this.f68817a = context;
        }

        public void onDownloadStart(String str, String str2, String str3, String str4, long j11) {
            Context context = HBWebView.this.getContext();
            if (context != null) {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse(str));
                if (!(this.f68817a instanceof Activity)) {
                    intent.addFlags(268435456);
                }
                context.startActivity(intent);
            }
        }
    }

    public interface b {
        boolean a();

        String b(String str);

        boolean c();

        String d(String str);
    }

    public class c extends WebViewClient {
        public c() {
        }

        public final boolean a() {
            OkHttpClient okHttpClient = HbgRetrofit.d().getOkHttpClient();
            Uri.Builder buildUpon = Uri.parse(HbgRetrofit.d().getHost()).buildUpon();
            buildUpon.path("/-/x/hbg/uc/hbg/open/invite/v2/muti/currentUid");
            try {
                Response execute = okHttpClient.newCall(new Request.Builder().url(buildUpon.build().toString()).build()).execute();
                if (!execute.isSuccessful()) {
                    return false;
                }
                JSONObject parseObject = JSON.parseObject(execute.body().string());
                if (parseObject.get("data") == null || !parseObject.getBooleanValue("data")) {
                    return false;
                }
                Uri.Builder buildUpon2 = Uri.parse(HbgRetrofit.d().getHost()).buildUpon();
                buildUpon2.path("/-/x/hbg/uc/hbg/open/invite/v2/inviter_award/checkKol");
                Response execute2 = okHttpClient.newCall(new Request.Builder().url(buildUpon2.build().toString()).build()).execute();
                if (!execute2.isSuccessful()) {
                    return false;
                }
                JSONObject parseObject2 = JSON.parseObject(execute2.body().string());
                if (parseObject2.getJSONObject("data") == null || parseObject2.getJSONObject("data").getInteger("inviter_flag").intValue() == 1) {
                    return false;
                }
                return true;
            } catch (Throwable th2) {
                th2.printStackTrace();
            }
        }

        public final WebResourceResponse b(WebView webView, WebResourceRequest webResourceRequest) {
            boolean z11;
            String str;
            String str2;
            FileInputStream fileInputStream = null;
            if (TextUtils.isEmpty(HBWebView.this.f68809g)) {
                return null;
            }
            Uri parse = Uri.parse(HBWebView.this.f68809g);
            if (!TextUtils.isEmpty(parse.getPath()) && webResourceRequest != null && webResourceRequest.getUrl() != null && !TextUtils.isEmpty(webResourceRequest.getUrl().getPath())) {
                if (HBWebView.this.f68814l == null) {
                    if ("/microapps/double-invite-retail/h5".equals(parse.getPath().replaceFirst(m6.a.h(), "/"))) {
                        Boolean unused = HBWebView.this.f68814l = Boolean.valueOf(a());
                    } else {
                        Boolean unused2 = HBWebView.this.f68814l = Boolean.TRUE;
                    }
                }
                if (!HBWebView.this.f68814l.booleanValue()) {
                    return null;
                }
                Uri url = webResourceRequest.getUrl();
                String path = parse.getPath();
                String path2 = url.getPath();
                if (!TextUtils.isEmpty(path) && !TextUtils.isEmpty(path2)) {
                    if (webResourceRequest.isForMainFrame() || TextUtils.equals(path, path2)) {
                        boolean unused3 = HBWebView.this.f68815m = false;
                        String unused4 = HBWebView.this.f68816n = "";
                        path2 = "/index.html";
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    if (path.endsWith("/")) {
                        path = path.substring(0, path.length() - 1);
                    }
                    if (!z11 && !HBWebView.this.f68815m) {
                        return null;
                    }
                    a.C0737a r11 = e6.i.q().r(path, path2);
                    if (r11 != null || HBWebView.this.f68815m) {
                        String uri = url.toString();
                        if (z11) {
                            str = "html";
                        } else {
                            str = CacheExtensionConfig.c(uri);
                        }
                        String mimeTypeFromExtension = MimeTypeMap.getSingleton().getMimeTypeFromExtension(str);
                        if (r11 != null) {
                            try {
                                if ("multi".equals(r11.f68114b)) {
                                    str2 = r11.f68113a;
                                } else {
                                    str2 = r11.f68113a + path2;
                                }
                                FileInputStream fileInputStream2 = new FileInputStream(str2);
                                if (z11) {
                                    boolean unused5 = HBWebView.this.f68815m = true;
                                    String unused6 = HBWebView.this.f68816n = r11.f68116d;
                                    HBWebViewOfflineEvent hBWebViewOfflineEvent = new HBWebViewOfflineEvent(true);
                                    hBWebViewOfflineEvent.md5 = r11.f68117e;
                                    hBWebViewOfflineEvent.packageName = r11.f68115c;
                                    k.d("HBRMSManager", "离线化命中 packageName: " + r11.f68115c + " md5: " + r11.f68117e);
                                    EventBus.d().k(hBWebViewOfflineEvent);
                                }
                                fileInputStream = fileInputStream2;
                            } catch (FileNotFoundException unused7) {
                                if (z11) {
                                    boolean unused8 = HBWebView.this.f68815m = false;
                                    String unused9 = HBWebView.this.f68816n = "";
                                    EventBus.d().k(new HBWebViewOfflineEvent(false));
                                }
                                if (z11 || !TextUtils.isEmpty(mimeTypeFromExtension) || !"GET".equals(webResourceRequest.getMethod()) || !TextUtils.equals(url.getHost(), parse.getHost())) {
                                    return null;
                                }
                                return c(webResourceRequest);
                            }
                        } else if (HBWebView.this.f68815m) {
                            if (!TextUtils.isEmpty(mimeTypeFromExtension) || !"GET".equals(webResourceRequest.getMethod()) || !TextUtils.equals(url.getHost(), parse.getHost())) {
                                return null;
                            }
                            return c(webResourceRequest);
                        }
                        WebResourceResponse webResourceResponse = new WebResourceResponse(mimeTypeFromExtension, "", fileInputStream);
                        webResourceResponse.setStatusCodeAndReasonPhrase(200, "OK");
                        HashMap hashMap = new HashMap();
                        hashMap.put("access-control-allow-origin", "*");
                        webResourceResponse.setResponseHeaders(hashMap);
                        return webResourceResponse;
                    }
                    if (z11) {
                        EventBus.d().k(new HBWebViewOfflineEvent(false));
                    }
                    return null;
                }
            }
            return null;
        }

        public final WebResourceResponse c(WebResourceRequest webResourceRequest) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            TimeUnit timeUnit = TimeUnit.SECONDS;
            builder.connectTimeout(15, timeUnit).readTimeout(15, timeUnit).writeTimeout(15, timeUnit).retryOnConnectionFailure(false);
            if (!c9.c.b().f70561b.isEmpty()) {
                for (Interceptor addInterceptor : c9.c.b().f70561b) {
                    builder.addInterceptor(addInterceptor);
                }
            }
            Uri.Builder buildUpon = Uri.parse(HbgRetrofit.d().getHost()).buildUpon();
            buildUpon.path(webResourceRequest.getUrl().getPath()).encodedQuery(webResourceRequest.getUrl().getEncodedQuery());
            Request.Builder url = new Request.Builder().url(buildUpon.build().toString());
            Map<String, String> requestHeaders = webResourceRequest.getRequestHeaders();
            requestHeaders.put("access-control-allow-origin", "*");
            url.get().headers(Headers.of(requestHeaders));
            try {
                Response execute = builder.build().newCall(url.build()).execute();
                if (!execute.isSuccessful()) {
                    return null;
                }
                String message = execute.message();
                if (TextUtils.isEmpty(message)) {
                    message = "OK";
                }
                return new WebResourceResponse("", "", execute.code(), message, e(execute.headers()), execute.body().byteStream());
            } catch (IOException e11) {
                e11.printStackTrace();
                return null;
            }
        }

        public final WebResourceResponse d(WebResourceRequest webResourceRequest) {
            if (BaseModuleConfig.a().b0() && webResourceRequest.getUrl() != null && webResourceRequest.getUrl().getPath() != null && webResourceRequest.getUrl().getPath().endsWith("static/script/sd.min.js") && !"hbg-fed-static-prd.hbfile.net".equals(webResourceRequest.getUrl().getHost())) {
                try {
                    return g.h().b("https://hbg-fed-static-prd.hbfile.net/enhome/static/script/sd.min.js");
                } catch (Exception unused) {
                }
            }
            return null;
        }

        public final Map<String, String> e(Headers headers) {
            HashMap hashMap = new HashMap();
            int size = headers.size();
            for (int i11 = 0; i11 < size; i11++) {
                hashMap.put(headers.name(i11), headers.value(i11));
            }
            hashMap.put("access-control-allow-origin", "*");
            return hashMap;
        }

        public void onPageFinished(WebView webView, String str) {
            LogAndWoodRecorder.b("DOMAIN_TEST", "HBWebView---> onPageFinished: " + str);
            if (HBWebView.this.f68804b != null) {
                HBWebView.this.f68804b.onPageFinished(webView, str);
            }
            HBWebView.this.f68806d.b();
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (HBWebView.this.f68804b != null) {
                HBWebView.this.f68804b.onPageStarted(webView, str, bitmap);
            }
            HBWebView.this.f68806d.c(str);
            String simpleName = HBWebView.class.getSimpleName();
            i6.d.c(simpleName, "onPageStarted mUrl----> " + str);
            LogAndWoodRecorder.b("DOMAIN_TEST", "HBWebView---> onPageStarted: " + str);
            WoodPeckerSDK.f().g().c("WebChangeDomainStartLoadRequest", str, "");
            WebviewTracer.f("WebChangeDomainStartLoadRequest");
        }

        public void onReceivedError(WebView webView, int i11, String str, String str2) {
            if (!HbgRouter.f(str2)) {
                LogAndWoodRecorder.b("DOMAIN_TEST", "HBWebView---> errorCode:" + i11 + "; description = " + str + "; url = " + HBWebView.this.getUrl());
                if (HBWebView.this.f68812j == 0) {
                    WoodPeckerSDK.f().g().c("WebChangeDomainLoadRequestFail", HBWebView.this.getUrl(), "");
                } else if (HBWebView.this.f68813k) {
                    WoodPeckerSDK.f().g().c("WebChangeDomainReplaceLoadRequestFail", HBWebView.this.getUrl(), "");
                } else {
                    WoodPeckerSDK.f().g().c("WebChangeDomainDynamicLoadRequestFail", HBWebView.this.getUrl(), "");
                }
                if (HBWebView.this.f68804b != null) {
                    HBWebView.this.f68804b.onReceivedError(webView, i11, str, str2);
                }
                HBWebView.this.f68806d.a(i11, str);
                if (HBWebView.f68802o != null) {
                    if (i11 == -12 || i11 == -11 || i11 == -8 || i11 == -6 || i11 == -4 || i11 == -2 || i11 == -1) {
                        boolean unused = HBWebView.f68803p = true;
                        if (HBWebView.this.f68812j != 0 || (!HBWebView.f68802o.a() && !HBWebView.f68802o.c())) {
                            LogAndWoodRecorder.a("DOMAIN_TEST", "H5指定异常，不满重试条件");
                            if (HBWebView.this.f68804b != null) {
                                HBWebView.this.f68804b.onReceivedError(webView, i11, str, str2);
                            }
                        } else {
                            LogAndWoodRecorder.a("DOMAIN_TEST", "H5满足条件，自动重试");
                            HBWebView.r(HBWebView.this);
                            HBWebView.this.reload();
                        }
                    } else {
                        LogAndWoodRecorder.a("DOMAIN_TEST", "H5其他异常，不重试");
                        if (HBWebView.this.f68804b != null) {
                            HBWebView.this.f68804b.onReceivedError(webView, i11, str, str2);
                        }
                    }
                } else if (HBWebView.this.f68804b != null) {
                    HBWebView.this.f68804b.onReceivedError(webView, i11, str, str2);
                }
                if (!str2.startsWith("huobiapp://") && HBWebView.this.f68810h != null) {
                    HBWebView.this.f68810h.onError(0, (String) null);
                }
            }
        }

        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            LogAndWoodRecorder.b("DOMAIN_TEST", "HBWebView---> onReceivedHttpError() called with:  request = [" + webResourceRequest.getUrl() + "], errorResponse = [" + webResourceResponse.getStatusCode() + "]");
            if (HBWebView.this.f68804b != null) {
                HBWebView.this.f68804b.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            LogAndWoodRecorder.b("DOMAIN_TEST", "HBWebView--->onReceivedSslError() called with: mUrl = [" + HBWebView.this.getUrl() + "], handler = [" + sslErrorHandler + "], error = [" + sslError + "]");
            sslErrorHandler.cancel();
            if (HBWebView.this.f68804b != null) {
                HBWebView.this.f68804b.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @TargetApi(21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (GlobalAppConfig.e()) {
                if (webResourceRequest.isForMainFrame()) {
                    String unused = HBWebView.this.f68808f = webResourceRequest.getUrl().toString();
                    HBWebView hBWebView = HBWebView.this;
                    String unused2 = hBWebView.f68809g = hBWebView.f68808f;
                }
            } else if (webResourceRequest.isForMainFrame()) {
                String unused3 = HBWebView.this.f68809g = webResourceRequest.getUrl() == null ? "" : webResourceRequest.getUrl().toString();
            }
            if (webResourceRequest.getUrl() != null && !TextUtils.isEmpty(webResourceRequest.getUrl().toString()) && (webResourceRequest.getUrl().toString().contains("amazonaws.com") || webResourceRequest.getUrl().toString().contains("wallet.advcash.com"))) {
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
            WebResourceResponse d11 = d(webResourceRequest);
            if (d11 != null) {
                return d11;
            }
            WebResourceResponse b11 = b(webView, webResourceRequest);
            if (b11 != null) {
                return b11;
            }
            WebResourceResponse f11 = WebCacheInterecptRequest.d().f(webView, webResourceRequest);
            return f11 == null ? super.shouldInterceptRequest(webView, webResourceRequest) : f11;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            String uri = webResourceRequest.getUrl() != null ? webResourceRequest.getUrl().toString() : "";
            if (HbgRouter.f(uri)) {
                if (HBWebView.this.f68805c != null) {
                    w.e().g(HBWebView.this.f68805c, uri);
                }
                return true;
            } else if (BaseModuleConfig.a().p0(webResourceRequest.getUrl().getPath(), "h5")) {
                HashMap hashMap = new HashMap();
                hashMap.put("canary", "always");
                if (webResourceRequest.getRequestHeaders() != null && !webResourceRequest.getRequestHeaders().isEmpty()) {
                    hashMap.putAll(webResourceRequest.getRequestHeaders());
                }
                HBWebView hBWebView = HBWebView.this;
                String uri2 = webResourceRequest.getUrl().toString();
                hBWebView.loadUrl(uri2, hashMap);
                SensorsDataAutoTrackHelper.loadUrl2(hBWebView, uri2, hashMap);
                return true;
            } else if (HbgRouter.g(uri)) {
                if (HBWebView.this.f68805c != null) {
                    w.e().h(HBWebView.this.f68805c, uri);
                }
                return true;
            } else {
                if (GlobalAppConfig.e() && webResourceRequest.isForMainFrame()) {
                    String unused = HBWebView.this.f68808f = webResourceRequest.getUrl().toString();
                }
                if (webResourceRequest.isForMainFrame()) {
                    String unused2 = HBWebView.this.f68809g = uri;
                    Boolean unused3 = HBWebView.this.f68814l = null;
                    boolean unused4 = HBWebView.this.f68815m = false;
                    String unused5 = HBWebView.this.f68816n = "";
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    return super.shouldOverrideUrlLoading(webView, webResourceRequest);
                }
                g.h().m(webView, webResourceRequest.getUrl().toString());
                return true;
            }
        }

        public /* synthetic */ c(HBWebView hBWebView, a aVar) {
            this();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            LogAndWoodRecorder.b("DOMAIN_TEST", "HBWebView---> shouldOverrideUrlLoading: " + str);
            boolean z11 = true;
            try {
                if (str.startsWith("huobiapp://?action=closebrowser")) {
                    if (HBWebView.this.f68805c != null) {
                        HBWebView.this.f68805c.finish();
                    }
                    return true;
                } else if (str.startsWith("huobiapp://?action=openbrowser")) {
                    String m11 = StringUtils.m(StringUtils.l(new URI(str).getQuery()), "url");
                    if (m11 != null) {
                        if (!m11.equals("")) {
                            if (HBWebView.this.f68805c != null) {
                                CommonFunc.a(HBWebView.this.f68805c, m11);
                                HBWebView.this.f68805c.finish();
                            }
                        }
                    }
                    return true;
                } else if (str.startsWith("alipayqr://platformapi/startapp")) {
                    Intent intent = new Intent();
                    intent.setData(Uri.parse(str));
                    if (HBWebView.this.f68805c != null) {
                        HBWebView.this.f68805c.startActivity(intent);
                    }
                    return true;
                } else if (str.startsWith("tel:")) {
                    Intent intent2 = new Intent("android.intent.action.VIEW", Uri.parse(str));
                    if (HBWebView.this.f68805c != null) {
                        HBWebView.this.f68805c.startActivity(intent2);
                    }
                    return true;
                } else {
                    boolean contains = str.contains(Constants.f68777a);
                    if (contains) {
                        try {
                            if (!(HBWebView.this.f68805c == null || w.e().c(HBWebView.this.f68805c, HBWebView.this.f68808f, "") || HBWebView.this.f68805c == null)) {
                                HBWebView.this.f68805c.finish();
                            }
                            return true;
                        } catch (Exception e11) {
                            e = e11;
                            z11 = contains;
                            e.printStackTrace();
                            return z11;
                        }
                    } else if (HBWebView.this.f68804b == null) {
                        return contains;
                    } else {
                        if (Build.VERSION.SDK_INT >= 21) {
                            return super.shouldOverrideUrlLoading(webView, str);
                        }
                        g.h().m(webView, str);
                        return true;
                    }
                }
            } catch (Exception e12) {
                e = e12;
                e.printStackTrace();
                return z11;
            }
        }
    }

    public interface d {
        void onError(int i11, String str);
    }

    public interface e {
        void onScrollChanged(int i11, int i12, int i13, int i14);
    }

    public HBWebView(Context context) {
        super(context);
        t(context);
    }

    public static /* synthetic */ int r(HBWebView hBWebView) {
        int i11 = hBWebView.f68812j;
        hBWebView.f68812j = i11 + 1;
        return i11;
    }

    public static void setErrorListener(b bVar) {
        f68802o = bVar;
    }

    public void destroy() {
        super.destroy();
    }

    public String getHBWebViewUrl() {
        return this.f68808f;
    }

    public String getPackageId() {
        return this.f68816n;
    }

    public void onMeasure(int i11, int i12) {
        if (!this.f68811i) {
            super.onMeasure(i11, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        } else {
            super.onMeasure(i11, i12);
        }
    }

    public void onOverScrolled(int i11, int i12, boolean z11, boolean z12) {
        if (z11) {
            super.requestDisallowInterceptTouchEvent(false);
        }
        super.onOverScrolled(i11, i12, z11, z12);
    }

    public void onScrollChanged(int i11, int i12, int i13, int i14) {
        super.onScrollChanged(i11, i12, i13, i14);
        e eVar = this.f68807e;
        if (eVar != null) {
            eVar.onScrollChanged(i11, i12, i13, i14);
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            if (!this.f68811i) {
                super.requestDisallowInterceptTouchEvent(false);
            } else {
                super.requestDisallowInterceptTouchEvent(true);
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void reload() {
        String url = getUrl();
        if (f68802o == null || !f68803p || TextUtils.isEmpty(url)) {
            super.reload();
            return;
        }
        String str = null;
        if (f68802o.c()) {
            str = f68802o.b(url);
        }
        if (TextUtils.isEmpty(str)) {
            str = f68802o.d(url);
        } else {
            k.d("DOMAIN_TEST_H5", "reload by switch suffix");
            this.f68813k = true;
        }
        loadUrl(str);
        SensorsDataAutoTrackHelper.loadUrl2(this, str);
        f68803p = false;
    }

    public final void s() {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setSaveFormData(false);
        settings.setUseWideViewPort(true);
        settings.setSavePassword(false);
        settings.setDomStorageEnabled(true);
        settings.setCacheMode(-1);
        getContext().getCacheDir().getAbsolutePath();
        settings.setMediaPlaybackRequiresUserGesture(false);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 16) {
            settings.setAllowFileAccessFromFileURLs(GlobalAppConfig.e());
            settings.setAllowUniversalAccessFromFileURLs(GlobalAppConfig.e());
        }
        if (i11 >= 21) {
            settings.setMixedContentMode(0);
        }
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setLoadWithOverviewMode(true);
        if (i11 >= 21) {
            settings.setMixedContentMode(0);
            setLayerType(2, (Paint) null);
        } else if (i11 >= 19) {
            setLayerType(2, (Paint) null);
        } else if (i11 < 19) {
            setLayerType(1, (Paint) null);
        }
    }

    public void setActivity(FragmentActivity fragmentActivity) {
        this.f68805c = fragmentActivity;
    }

    public void setCanScroll(boolean z11) {
        this.f68811i = z11;
    }

    public void setInitialUrl(String str) {
        this.f68808f = str;
    }

    public void setLoadErrorListener(d dVar) {
        this.f68810h = dVar;
    }

    public void setScrollChangeListener(e eVar) {
        this.f68807e = eVar;
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        this.f68804b = webViewClient;
    }

    public void t(Context context) {
        if ((context instanceof Activity) || (context instanceof FragmentActivity)) {
            this.f68805c = (FragmentActivity) context;
        }
        super.setWebViewClient(new c(this, (a) null));
        this.f68806d = new i(this);
        s();
        setDownloadListener(new a(context));
    }

    public boolean u() {
        return this.f68815m;
    }

    public HBWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        t(context);
    }

    public HBWebView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        t(context);
    }
}
