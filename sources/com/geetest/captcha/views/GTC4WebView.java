package com.geetest.captcha.views;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.webkit.SslErrorHandler;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.geetest.captcha.ac;
import com.geetest.captcha.ad;
import com.geetest.captcha.ag;
import com.geetest.captcha.u;
import com.geetest.captcha.w;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.x;
import org.json.JSONObject;

@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u0000 #2\u00020\u0001:\u0003#$%B\u0011\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004B\u001b\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B#\b\u0016\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nB+\b\u0017\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\u000b\u001a\u00020\t¢\u0006\u0002\u0010\fJ \u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\b\u0010\u0019\u001a\u00020\u0012H\u0014J\b\u0010\u001a\u001a\u00020\u0012H\u0016J(\u0010\u001b\u001a\u00020\u00122\u0006\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\t2\u0006\u0010\u001e\u001a\u00020\t2\u0006\u0010\u001f\u001a\u00020\tH\u0014J\u0010\u0010 \u001a\u00020\u00122\u0006\u0010!\u001a\u00020\u0018H\u0002J\u000e\u0010\"\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u000e¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/geetest/captcha/views/GTC4WebView;", "Landroid/webkit/WebView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "defStyleRes", "(Landroid/content/Context;Landroid/util/AttributeSet;II)V", "myWebViewClient", "Lcom/geetest/captcha/views/GTC4WebView$MyWebViewClient;", "resumeTimers", "", "init", "", "observable", "Lcom/geetest/captcha/observer/WebViewObservable;", "dataBean", "Lcom/geetest/captcha/model/DataBean;", "loadUrl", "", "onDetachedFromWindow", "onResume", "onSizeChanged", "newWidth", "newHeight", "oldWidth", "oldHeight", "parseUrl", "url", "setWebViewObservable", "Companion", "MyWebChromeClient", "MyWebViewClient", "captcha_release"}, k = 1, mv = {1, 1, 16})
public final class GTC4WebView extends WebView {

    /* renamed from: b  reason: collision with root package name */
    public static final a f65276b = new a((byte) 0);

    /* renamed from: a  reason: collision with root package name */
    public c f65277a;

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/geetest/captcha/views/GTC4WebView$Companion;", "", "()V", "TAG", "", "captcha_release"}, k = 1, mv = {1, 1, 16})
    public static final class a {
        private a() {
        }

        public /* synthetic */ a(byte b11) {
            this();
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016J\u0018\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u000bH\u0016¨\u0006\f"}, d2 = {"Lcom/geetest/captcha/views/GTC4WebView$MyWebChromeClient;", "Landroid/webkit/WebChromeClient;", "()V", "onProgressChanged", "", "view", "Landroid/webkit/WebView;", "newProgress", "", "onReceivedTitle", "title", "", "captcha_release"}, k = 1, mv = {1, 1, 16})
    public static final class b extends WebChromeClient {
        public final void onProgressChanged(WebView webView, int i11) {
            super.onProgressChanged(webView, i11);
            ag agVar = ag.f65177a;
            ag.a("GTC4WebView", "onProgressChanged: ".concat(String.valueOf(i11)));
        }

        public final void onReceivedTitle(WebView webView, String str) {
            super.onReceivedTitle(webView, str);
            ag agVar = ag.f65177a;
            ag.a("onReceivedTitle: ".concat(String.valueOf(str)));
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public GTC4WebView(Context context) {
        super(context);
        if (context == null) {
            x.j();
        }
    }

    public final void onDetachedFromWindow() {
        ag agVar = ag.f65177a;
        ag.b("GTC4WebView.onDetachedFromWindow");
        super.onDetachedFromWindow();
        removeJavascriptInterface("JSInterface");
        removeAllViews();
        removeAllViewsInLayout();
        loadUrl("");
        SensorsDataAutoTrackHelper.loadUrl2(this, "");
    }

    public final void onResume() {
        super.onResume();
        resumeTimers();
    }

    public final void onSizeChanged(int i11, int i12, int i13, int i14) {
        super.onSizeChanged(i11, i12, i13, i14);
        ag agVar = ag.f65177a;
        ag.a("GTC4WebView", "newWidth: " + i11 + ", newHeight: " + i12 + ", oldWidth: " + i13 + ", oldHeight: " + i14);
    }

    public final void setWebViewObservable(w wVar) {
        c cVar = this.f65277a;
        if (cVar != null) {
            cVar.f65278a = wVar;
        }
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0016J&\u0010\r\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0016J \u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J(\u0010\u0010\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00032\u0006\u0010\u0018\u001a\u00020\u0003H\u0016J \u0010\u0019\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J \u0010\u001c\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0013\u001a\u00020\u001fH\u0016J\u000e\u0010 \u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005J\u001c\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0016J\u001c\u0010!\u001a\u00020\"2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0003H\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/geetest/captcha/views/GTC4WebView$MyWebViewClient;", "Landroid/webkit/WebViewClient;", "loadUrl", "", "observable", "Lcom/geetest/captcha/observer/WebViewObservable;", "(Ljava/lang/String;Lcom/geetest/captcha/observer/WebViewObservable;)V", "onLoadResource", "", "view", "Landroid/webkit/WebView;", "url", "onPageFinished", "onPageStarted", "favicon", "Landroid/graphics/Bitmap;", "onReceivedError", "request", "Landroid/webkit/WebResourceRequest;", "error", "Landroid/webkit/WebResourceError;", "errorCode", "", "description", "failingUrl", "onReceivedHttpError", "errorResponse", "Landroid/webkit/WebResourceResponse;", "onReceivedSslError", "handler", "Landroid/webkit/SslErrorHandler;", "Landroid/net/http/SslError;", "setObservable", "shouldOverrideUrlLoading", "", "captcha_release"}, k = 1, mv = {1, 1, 16})
    public static final class c extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        public w f65278a;

        /* renamed from: b  reason: collision with root package name */
        private String f65279b;

        public c(String str, w wVar) {
            this.f65279b = str;
            this.f65278a = wVar;
        }

        public final void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
            ag agVar = ag.f65177a;
            ag.b("onLoadResource: ".concat(String.valueOf(str)));
        }

        public final void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            ag agVar = ag.f65177a;
            ag.b("onPageFinished: ".concat(String.valueOf(str)));
        }

        public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            ag agVar = ag.f65177a;
            ag.b("onPageStarted: ".concat(String.valueOf(str)));
        }

        public final void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 23) {
                ag agVar = ag.f65177a;
                ag.b("WebViewClient.onReceivedError: URL: " + webResourceRequest.getUrl() + ", Method: " + webResourceRequest.getMethod() + ", ErrorCode: " + webResourceError.getErrorCode() + ", Description: " + webResourceError.getDescription());
            } else if (i11 >= 21) {
                ag agVar2 = ag.f65177a;
                ag.b("WebViewClient.onReceivedError LOLLIPOP: URL: " + webResourceRequest.getUrl() + ", Method: " + webResourceRequest.getMethod());
            }
        }

        public final void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            if (Build.VERSION.SDK_INT >= 21) {
                ag agVar = ag.f65177a;
                ag.b("WebViewClient.onReceivedHttpError: URL: " + webResourceRequest.getUrl() + ", Code: " + webResourceResponse.getStatusCode() + ", Message: " + webResourceResponse.getReasonPhrase());
            }
        }

        public final void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            ag agVar = ag.f65177a;
            ag.b("WebViewClient.onReceivedSslError: URL: " + sslError.getUrl() + ", ErrorCode: " + sslError.getPrimaryError() + ", Description: " + sslError);
            d0 d0Var = d0.f56774a;
            String format = String.format(TimeModel.ZERO_LEADING_NUMBER_FORMAT, Arrays.copyOf(new Object[]{Integer.valueOf(Math.abs(sslError.getPrimaryError()))}, 1));
            ad adVar = ad.f65162a;
            String b11 = ad.b();
            u.a aVar = u.f65270a;
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", sslError.getUrl());
            jSONObject.put("description", sslError.toString());
            this.f65278a.a(ac.a.WEB_VIEW_SSL.getType() + format, b11, jSONObject);
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            Context context;
            if (Build.VERSION.SDK_INT < 21) {
                return true;
            }
            ag agVar = ag.f65177a;
            StringBuilder sb2 = new StringBuilder("shouldOverrideUrlLoading(high): ");
            Uri uri = null;
            sb2.append(webResourceRequest != null ? webResourceRequest.getUrl() : null);
            ag.b(sb2.toString());
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                if (webResourceRequest != null) {
                    uri = webResourceRequest.getUrl();
                }
                intent.setData(Uri.parse(String.valueOf(uri)));
                if (webView == null || (context = webView.getContext()) == null) {
                    return true;
                }
                context.startActivity(intent);
                return true;
            } catch (Exception e11) {
                e11.printStackTrace();
                return true;
            }
        }

        public final void onReceivedError(WebView webView, int i11, String str, String str2) {
            super.onReceivedError(webView, i11, str, str2);
            if (Build.VERSION.SDK_INT < 23) {
                ag agVar = ag.f65177a;
                ag.b("WebViewClient.onReceivedError(Deprecated): URL: " + str2 + ", ErrorCode: " + i11 + ", Description: " + str);
            }
        }

        public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
            Context context;
            int i11 = Build.VERSION.SDK_INT;
            if (i11 >= 21) {
                return true;
            }
            ag agVar = ag.f65177a;
            ag.b("shouldOverrideUrlLoading(low): ".concat(String.valueOf(str)));
            if (i11 >= 21) {
                return true;
            }
            try {
                Intent intent = new Intent("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                if (webView == null || (context = webView.getContext()) == null) {
                    return true;
                }
                context.startActivity(intent);
                return true;
            } catch (Exception e11) {
                e11.printStackTrace();
                return true;
            }
        }
    }
}
