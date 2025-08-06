package com.hbg.lib.imsdk;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.net.http.SslError;
import android.os.Build;
import android.util.AttributeSet;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huobi.webcache.WebCacheInterecptRequest;
import i6.k;

public class HbgDialogWebView extends WebView {

    /* renamed from: b  reason: collision with root package name */
    public WebViewClient f69149b;

    /* renamed from: c  reason: collision with root package name */
    public Context f69150c;

    /* renamed from: d  reason: collision with root package name */
    public c f69151d;

    public class b extends WebViewClient {
        public b() {
        }

        public void onPageFinished(WebView webView, String str) {
            k.e("HbgDialogWebView---> onPageFinished: " + str);
            if (HbgDialogWebView.this.f69149b != null) {
                HbgDialogWebView.this.f69149b.onPageFinished(webView, str);
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (HbgDialogWebView.this.f69149b != null) {
                HbgDialogWebView.this.f69149b.onPageStarted(webView, str, bitmap);
            }
            k.e("HbgDialogWebView---> onPageStarted: " + str);
        }

        public void onReceivedError(WebView webView, int i11, String str, String str2) {
            k.e("HbgDialogWebView---> errorCode:" + i11 + "; description = " + str + "; url = " + HbgDialogWebView.this.getUrl());
            if (HbgDialogWebView.this.f69149b != null) {
                HbgDialogWebView.this.f69149b.onReceivedError(webView, i11, str, str2);
            }
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            sslErrorHandler.cancel();
            if (HbgDialogWebView.this.f69149b != null) {
                HbgDialogWebView.this.f69149b.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @TargetApi(21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            WebResourceResponse f11 = WebCacheInterecptRequest.d().f(webView, webResourceRequest);
            return f11 != null ? f11 : super.shouldInterceptRequest(webView, webResourceRequest);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            k.e("HbgDialogWebView---> shouldOverrideUrlLoading: " + str);
            try {
                if (HbgDialogWebView.this.f69149b != null) {
                    HbgDialogWebView.this.f69149b.shouldOverrideUrlLoading(webView, str);
                    return true;
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            return true;
        }
    }

    public interface c {
        void onScrollChanged(int i11, int i12, int i13, int i14);
    }

    public HbgDialogWebView(Context context) {
        super(context);
        c(context);
    }

    public final void b() {
        WebSettings settings = getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setAllowFileAccess(true);
        settings.setSaveFormData(false);
        settings.setUseWideViewPort(true);
        settings.setSavePassword(false);
        settings.setDomStorageEnabled(true);
        int i11 = Build.VERSION.SDK_INT;
        if (i11 >= 16) {
            settings.setAllowFileAccessFromFileURLs(false);
            settings.setAllowUniversalAccessFromFileURLs(false);
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

    public void c(Context context) {
        this.f69150c = context;
        super.setWebViewClient(new b());
        b();
    }

    public void onScrollChanged(int i11, int i12, int i13, int i14) {
        super.onScrollChanged(i11, i12, i13, i14);
        c cVar = this.f69151d;
        if (cVar != null) {
            cVar.onScrollChanged(i11, i12, i13, i14);
        }
    }

    public void setScrollChangeListener(c cVar) {
        this.f69151d = cVar;
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        this.f69149b = webViewClient;
    }

    public HbgDialogWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        c(context);
    }

    public HbgDialogWebView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        c(context);
    }
}
