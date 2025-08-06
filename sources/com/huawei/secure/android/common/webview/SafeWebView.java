package com.huawei.secure.android.common.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Message;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.URLUtil;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huawei.secure.android.common.util.LogsUtil;
import com.huawei.secure.android.common.webview.WebViewLoadCallBack;
import com.huobi.woodpecker.aop.WoodPeckerWebViewAspect;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import java.util.Arrays;
import java.util.Map;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.c;

public class SafeWebView extends WebView {

    /* renamed from: g  reason: collision with root package name */
    public static final /* synthetic */ JoinPoint.StaticPart f38674g = null;

    /* renamed from: b  reason: collision with root package name */
    public String f38675b;

    /* renamed from: c  reason: collision with root package name */
    public String[] f38676c;

    /* renamed from: d  reason: collision with root package name */
    public String[] f38677d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f38678e;

    /* renamed from: f  reason: collision with root package name */
    public WebViewLoadCallBack f38679f;

    public final class b extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        public WebViewClient f38680a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f38681b;

        public void doUpdateVisitedHistory(WebView webView, String str, boolean z11) {
            WebViewClient webViewClient = this.f38680a;
            if (webViewClient != null) {
                webViewClient.doUpdateVisitedHistory(webView, str, z11);
            } else {
                super.doUpdateVisitedHistory(webView, str, z11);
            }
        }

        public void onFormResubmission(WebView webView, Message message, Message message2) {
            WebViewClient webViewClient = this.f38680a;
            if (webViewClient != null) {
                webViewClient.onFormResubmission(webView, message, message2);
            } else {
                super.onFormResubmission(webView, message, message2);
            }
        }

        public void onLoadResource(WebView webView, String str) {
            WebViewClient webViewClient = this.f38680a;
            if (webViewClient != null) {
                webViewClient.onLoadResource(webView, str);
            } else {
                super.onLoadResource(webView, str);
            }
        }

        @TargetApi(23)
        public void onPageCommitVisible(WebView webView, String str) {
            WebViewClient webViewClient = this.f38680a;
            if (webViewClient != null) {
                webViewClient.onPageCommitVisible(webView, str);
            } else {
                super.onPageCommitVisible(webView, str);
            }
        }

        public void onPageFinished(WebView webView, String str) {
            WebViewClient webViewClient = this.f38680a;
            if (webViewClient != null) {
                webViewClient.onPageFinished(webView, str);
            } else {
                super.onPageFinished(webView, str);
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            WebViewClient webViewClient = this.f38680a;
            if (webViewClient != null && !this.f38681b) {
                webViewClient.onPageStarted(webView, str, bitmap);
            } else if (!SafeWebView.this.d(str)) {
                SafeWebView.this.e(webView, str);
            } else {
                super.onPageStarted(webView, str, bitmap);
            }
        }

        @TargetApi(21)
        public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
            WebViewClient webViewClient = this.f38680a;
            if (webViewClient != null) {
                webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
            } else {
                super.onReceivedClientCertRequest(webView, clientCertRequest);
            }
        }

        public void onReceivedError(WebView webView, int i11, String str, String str2) {
            WebViewClient webViewClient = this.f38680a;
            if (webViewClient != null) {
                webViewClient.onReceivedError(webView, i11, str, str2);
            } else {
                super.onReceivedError(webView, i11, str, str2);
            }
        }

        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            WebViewClient webViewClient = this.f38680a;
            if (webViewClient != null) {
                webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            } else {
                super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
        }

        @TargetApi(23)
        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            WebViewClient webViewClient = this.f38680a;
            if (webViewClient != null) {
                webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            } else {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        }

        @TargetApi(12)
        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            WebViewClient webViewClient = this.f38680a;
            if (webViewClient != null) {
                webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
            } else {
                super.onReceivedLoginRequest(webView, str, str2, str3);
            }
        }

        @TargetApi(8)
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            WebViewClient webViewClient = this.f38680a;
            if (webViewClient != null) {
                webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
            } else {
                super.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @SuppressLint({"NewApi"})
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            WebViewClient webViewClient = this.f38680a;
            if (webViewClient != null) {
                return webViewClient.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }

        @SuppressLint({"NewApi"})
        public void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i11, SafeBrowsingResponse safeBrowsingResponse) {
            WebViewClient webViewClient = this.f38680a;
            if (webViewClient != null) {
                webViewClient.onSafeBrowsingHit(webView, webResourceRequest, i11, safeBrowsingResponse);
            } else {
                super.onSafeBrowsingHit(webView, webResourceRequest, i11, safeBrowsingResponse);
            }
        }

        public void onScaleChanged(WebView webView, float f11, float f12) {
            WebViewClient webViewClient = this.f38680a;
            if (webViewClient != null) {
                webViewClient.onScaleChanged(webView, f11, f12);
            } else {
                super.onScaleChanged(webView, f11, f12);
            }
        }

        public void onTooManyRedirects(WebView webView, Message message, Message message2) {
            WebViewClient webViewClient = this.f38680a;
            if (webViewClient != null) {
                webViewClient.onTooManyRedirects(webView, message, message2);
            } else {
                super.onTooManyRedirects(webView, message, message2);
            }
        }

        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            WebViewClient webViewClient = this.f38680a;
            if (webViewClient != null) {
                webViewClient.onUnhandledKeyEvent(webView, keyEvent);
            } else {
                super.onUnhandledKeyEvent(webView, keyEvent);
            }
        }

        @TargetApi(21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            WebViewClient webViewClient = this.f38680a;
            if (webViewClient != null) {
                return webViewClient.shouldInterceptRequest(webView, webResourceRequest);
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            WebViewClient webViewClient = this.f38680a;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideKeyEvent(webView, keyEvent);
            }
            return super.shouldOverrideKeyEvent(webView, keyEvent);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            WebViewClient webViewClient = this.f38680a;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideUrlLoading(webView, str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        public b(WebViewClient webViewClient, boolean z11) {
            this.f38680a = webViewClient;
            this.f38681b = z11;
        }

        @TargetApi(23)
        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            WebViewClient webViewClient = this.f38680a;
            if (webViewClient != null) {
                webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
            } else {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
            }
        }

        @TargetApi(11)
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            WebViewClient webViewClient = this.f38680a;
            if (webViewClient != null) {
                return webViewClient.shouldInterceptRequest(webView, str);
            }
            return super.shouldInterceptRequest(webView, str);
        }

        @TargetApi(24)
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            WebViewClient webViewClient = this.f38680a;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }
    }

    static {
        c();
    }

    public SafeWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public static /* synthetic */ void c() {
        c cVar = new c("SourceFile", SafeWebView.class);
        f38674g = cVar.h("method-call", cVar.g("1", "setWebViewClient", "com.huawei.secure.android.common.webview.SafeWebView", "android.webkit.WebViewClient", "arg0", "", "void"), 4);
    }

    public final void a() {
        SafeWebSettings.f(this);
        JoinPoint c11 = c.c(f38674g, this, this, (Object) null);
        WoodPeckerWebViewAspect.h().g(new mg.a(new Object[]{this, this, null, c11}).linkClosureAndJoinPoint(4112));
    }

    public final boolean b(String str) {
        return URLUtil.isHttpUrl(str);
    }

    @TargetApi(9)
    public boolean d(String str) {
        boolean z11 = false;
        if (TextUtils.isEmpty(str)) {
            LogsUtil.d("SafeWebView", "url is null");
            return false;
        } else if (!URLUtil.isNetworkUrl(str)) {
            return true;
        } else {
            String[] whitelistWithPath = getWhitelistWithPath();
            String[] whitelistNotMatchSubDomain = getWhitelistNotMatchSubDomain();
            String[] whitelist = getWhitelist();
            boolean z12 = whitelistWithPath == null || whitelistWithPath.length == 0;
            boolean z13 = whitelistNotMatchSubDomain == null || whitelistNotMatchSubDomain.length == 0;
            if (whitelist == null || whitelist.length == 0) {
                z11 = true;
            }
            if (z12 && z13 && z11) {
                return true;
            }
            if (whitelistWithPath != null && whitelistWithPath.length != 0) {
                return UriUtil.c(str, whitelistWithPath);
            }
            if (whitelistNotMatchSubDomain == null || whitelistNotMatchSubDomain.length == 0) {
                return UriUtil.e(str, whitelist);
            }
            return UriUtil.h(str, whitelistNotMatchSubDomain);
        }
    }

    public final void e(WebView webView, String str) {
        LogsUtil.e("SafeWebView", "onCheckError url is not in white list ", str);
        webView.stopLoading();
        String defaultErrorPage = getDefaultErrorPage();
        if (!TextUtils.isEmpty(defaultErrorPage)) {
            webView.loadUrl(defaultErrorPage);
            SensorsDataAutoTrackHelper.loadUrl2(webView, defaultErrorPage);
        } else if (getWebViewLoadCallBack() != null) {
            Log.e("SafeWebView", "onPageStarted WebViewLoadCallBack");
            getWebViewLoadCallBack().a(str, WebViewLoadCallBack.ErrorCode.URL_NOT_IN_WHITE_LIST);
        }
    }

    public String getDefaultErrorPage() {
        return this.f38675b;
    }

    public WebViewLoadCallBack getWebViewLoadCallBack() {
        return this.f38679f;
    }

    @TargetApi(9)
    @Deprecated
    public String[] getWhitelist() {
        String[] strArr = this.f38676c;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public String[] getWhitelistNotMatchSubDomain() {
        String[] strArr = this.f38677d;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    @Deprecated
    public String[] getWhitelistNotMathcSubDomain() {
        String[] strArr = this.f38677d;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    @TargetApi(9)
    public String[] getWhitelistWithPath() {
        String[] strArr = this.f38678e;
        if (strArr == null) {
            return null;
        }
        return (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (b(str)) {
            Log.e("SafeWebView", "loadDataWithBaseURL: http url , not safe");
            if (!TextUtils.isEmpty(this.f38675b)) {
                super.loadDataWithBaseURL(this.f38675b, str2, str3, str4, str5);
            } else if (getWebViewLoadCallBack() != null) {
                Log.e("SafeWebView", "WebViewLoadCallBack");
                getWebViewLoadCallBack().a(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
            }
        } else {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    public void loadUrl(String str) {
        if (!d(str) || b(str)) {
            Log.e("SafeWebView", "loadUrl: url is not in white list or http url not safe");
            if (!TextUtils.isEmpty(this.f38675b)) {
                super.loadUrl(this.f38675b);
            } else if (getWebViewLoadCallBack() != null) {
                Log.e("SafeWebView", "WebViewLoadCallBack");
                getWebViewLoadCallBack().a(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
            }
        } else {
            super.loadUrl(str);
        }
    }

    public void postUrl(String str, byte[] bArr) {
        if (!d(str) || b(str)) {
            Log.e("SafeWebView", "postUrl: url is not in white list or http url not safe");
            if (!TextUtils.isEmpty(this.f38675b)) {
                super.postUrl(this.f38675b, bArr);
            } else if (getWebViewLoadCallBack() != null) {
                Log.e("SafeWebView", "WebViewLoadCallBack");
                getWebViewLoadCallBack().a(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
            }
        } else {
            super.postUrl(str, bArr);
        }
    }

    public void setDefaultErrorPage(String str) {
        this.f38675b = str;
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(new b(webViewClient, true));
    }

    public void setWebViewLoadCallBack(WebViewLoadCallBack webViewLoadCallBack) {
        this.f38679f = webViewLoadCallBack;
    }

    @TargetApi(9)
    @Deprecated
    public void setWhitelist(String[] strArr) {
        this.f38676c = strArr == null ? null : (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    public void setWhitelistNotMatchSubDomain(String[] strArr) {
        String[] strArr2;
        if (strArr == null) {
            strArr2 = null;
        } else {
            strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
        this.f38677d = strArr2;
    }

    @Deprecated
    public void setWhitelistNotMathcSubDomain(String[] strArr) {
        String[] strArr2;
        if (strArr == null) {
            strArr2 = null;
        } else {
            strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
        this.f38677d = strArr2;
    }

    @TargetApi(9)
    public void setWhitelistWithPath(String[] strArr) {
        String[] strArr2;
        if (strArr == null) {
            strArr2 = null;
        } else {
            strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length);
        }
        this.f38678e = strArr2;
    }

    public SafeWebView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        a();
    }

    public void loadUrl(String str, Map<String, String> map) {
        if (!d(str) || b(str)) {
            Log.e("SafeWebView", "loadUrl: url is not in white list or http url not safe");
            if (!TextUtils.isEmpty(this.f38675b)) {
                super.loadUrl(this.f38675b, map);
            } else if (getWebViewLoadCallBack() != null) {
                Log.e("SafeWebView", "WebViewLoadCallBack");
                getWebViewLoadCallBack().a(str, WebViewLoadCallBack.ErrorCode.HTTP_URL);
            }
        } else {
            super.loadUrl(str, map);
        }
    }
}
