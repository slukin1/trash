package com.huobi.webcache;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.http.SslError;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class a extends WebViewClient {

    /* renamed from: a  reason: collision with root package name */
    public boolean f20682a = true;

    /* renamed from: b  reason: collision with root package name */
    public boolean f20683b = false;

    /* renamed from: c  reason: collision with root package name */
    public boolean f20684c = false;

    /* renamed from: d  reason: collision with root package name */
    public boolean f20685d = false;

    /* renamed from: e  reason: collision with root package name */
    public int f20686e = 2;

    /* renamed from: f  reason: collision with root package name */
    public Handler f20687f;

    /* renamed from: g  reason: collision with root package name */
    public String f20688g;

    /* renamed from: h  reason: collision with root package name */
    public final CacheExtensionConfig f20689h = new CacheExtensionConfig();

    public a(int i11, Handler handler, boolean z11) {
        this.f20686e = i11;
        this.f20687f = handler;
        this.f20682a = z11;
    }

    public final void a(WebView webView, String str, String str2) {
        Handler handler;
        if (this.f20682a) {
            Log.e("CacheWebViewClient", "handLoadFinish, , description:" + str2 + ", getProgress:" + webView.getProgress() + ", failingUrl:" + str);
        }
        if (webView.getProgress() == 100) {
            this.f20684c = true;
            Handler handler2 = this.f20687f;
            if (handler2 != null) {
                handler2.sendMessageDelayed(Message.obtain(handler2, 34, webView), 1000);
            }
        } else if (webView.getProgress() == 10 && str2.contains("ERR_") && (handler = this.f20687f) != null) {
            handler.sendMessageDelayed(Message.obtain(handler, 34, webView), 10);
            c.f20691m.put(str, str2);
        }
    }

    public void b(String str) {
        this.f20688g = str;
    }

    public void onLoadResource(WebView webView, String str) {
    }

    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        if (this.f20682a) {
            Log.e("CacheWebViewClient", "onPageFinished() called with: redirect = [" + this.f20685d + "], url = [" + str + "], view = [" + webView.getUrl() + "], getProgress=" + webView.getProgress());
        }
        if (!this.f20685d) {
            this.f20683b = true;
        } else {
            this.f20685d = false;
        }
        a(webView, str, "finish");
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.f20683b = false;
    }

    public void onReceivedError(WebView webView, int i11, String str, String str2) {
        super.onReceivedError(webView, i11, str, str2);
        if (this.f20682a) {
            Log.e("CacheWebViewClient", "onReceivedError, , description:" + str + ", failingUrl:" + str2);
        }
        a(webView, str2, i11 + ":" + str);
    }

    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
        String uri = webResourceRequest.getUrl().toString();
        String c11 = CacheExtensionConfig.c(uri);
        if (this.f20682a) {
            Log.e("CacheWebViewClient", "onReceivedHttpError() called with: errorUrl = [" + uri + "], getMimeType = [" + webResourceResponse.getMimeType() + "], getEncoding = [" + webResourceResponse.getEncoding() + "],statucode=" + webResourceResponse.getStatusCode());
        }
        if (webResourceRequest.isForMainFrame() || this.f20689h.g(c11)) {
            a(webView, uri, "ERR_,statucode=" + webResourceResponse.getStatusCode() + webResourceResponse.toString());
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (this.f20682a) {
            Log.d("CacheWebViewClient", "onReceivedSslError() called with: view = [" + webView + "], handler = [" + sslErrorHandler + "], error = [" + sslError + "]");
        }
        sslErrorHandler.cancel();
    }

    @TargetApi(21)
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        if (this.f20682a && webResourceRequest.isForMainFrame()) {
            this.f20688g = webResourceRequest.getUrl().toString();
        }
        WebResourceResponse s11 = WebCacheInterecptRequest.d().s(webView, webResourceRequest, this.f20686e, c.f20692n);
        if (s11 != null) {
            return s11;
        }
        if (this.f20682a) {
            Log.d("CacheWebViewClient", "shouldInterceptRequest(WebResourceRequest) called with: rs = [" + s11 + "], request = [" + webResourceRequest.getUrl() + "], isForMainFrame = [" + webResourceRequest.isForMainFrame() + "], getMethod = [" + webResourceRequest.getMethod() + "]");
        }
        return super.shouldInterceptRequest(webView, webResourceRequest);
    }

    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (!this.f20683b) {
            this.f20685d = true;
        }
        this.f20683b = false;
        if (this.f20682a) {
            Log.e("CacheWebViewClient", "shouldOverrideUrlLoading(WebResourceRequest) called with: request = [" + webResourceRequest.getUrl() + "], isForMainFrame = [" + webResourceRequest.isForMainFrame() + "], redirect = [" + this.f20685d + "], loadingFinished = [" + this.f20683b + "]");
            if (webResourceRequest.isForMainFrame()) {
                this.f20688g = webResourceRequest.getUrl().toString();
            }
        }
        return super.shouldOverrideUrlLoading(webView, webResourceRequest);
    }

    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        if (this.f20682a) {
            Log.e("CacheWebViewClient", "onReceivedError() called with: isForMainFrame = [" + webResourceRequest.isForMainFrame() + "], getMethod = [" + webResourceRequest.getMethod() + "], request = [" + webResourceRequest.getUrl().toString() + "], error = [" + webResourceError.getErrorCode() + ":" + webResourceError.getDescription() + "]");
        }
        String uri = webResourceRequest.getUrl().toString();
        String c11 = CacheExtensionConfig.c(uri);
        if (webResourceRequest.isForMainFrame() || this.f20689h.g(c11)) {
            a(webView, uri, webResourceError.getErrorCode() + ":" + webResourceError.getDescription());
        }
    }
}
