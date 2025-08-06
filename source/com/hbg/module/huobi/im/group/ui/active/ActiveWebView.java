package com.hbg.module.huobi.im.group.ui.active;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Paint;
import android.net.http.SslError;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.hbg.lib.core.GlobalAppConfig;
import com.hbg.lib.core.webview.HBWebView;
import com.hbg.lib.router.HbgRouter;
import com.huobi.webcache.WebCacheInterecptRequest;
import com.huobi.webcache.g;
import i6.d;
import i6.k;
import v6.w;

public class ActiveWebView extends WebView {
    private Context context;
    /* access modifiers changed from: private */
    public OnLoadErrorListener mLoadErrorListener;
    private OnWebViewScrollChangeListener mScrollChangeListener;
    /* access modifiers changed from: private */
    public String mUrl;
    /* access modifiers changed from: private */
    public WebViewClient mWebViewClient;

    public interface OnLoadErrorListener {
        void onError(int i11, String str);
    }

    public interface OnWebViewScrollChangeListener {
        void onScrollChanged(int i11, int i12, int i13, int i14);
    }

    public ActiveWebView(Context context2) {
        super(context2);
        initWebView(context2);
    }

    private void initWebSettings() {
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

    public void initWebView(Context context2) {
        this.context = context2;
        super.setWebViewClient(new HBWebViewClient());
        initWebSettings();
    }

    public void onScrollChanged(int i11, int i12, int i13, int i14) {
        super.onScrollChanged(i11, i12, i13, i14);
        OnWebViewScrollChangeListener onWebViewScrollChangeListener = this.mScrollChangeListener;
        if (onWebViewScrollChangeListener != null) {
            onWebViewScrollChangeListener.onScrollChanged(i11, i12, i13, i14);
        }
    }

    public void setLoadErrorListener(OnLoadErrorListener onLoadErrorListener) {
        this.mLoadErrorListener = onLoadErrorListener;
    }

    public void setScrollChangeListener(OnWebViewScrollChangeListener onWebViewScrollChangeListener) {
        this.mScrollChangeListener = onWebViewScrollChangeListener;
    }

    public void setWebViewClient(WebViewClient webViewClient) {
        this.mWebViewClient = webViewClient;
    }

    public ActiveWebView(Context context2, AttributeSet attributeSet) {
        super(context2, attributeSet);
        initWebView(context2);
    }

    public ActiveWebView(Context context2, AttributeSet attributeSet, int i11) {
        super(context2, attributeSet, i11);
        initWebView(context2);
    }

    public ActiveWebView(Context context2, AttributeSet attributeSet, int i11, int i12) {
        super(context2, attributeSet, i11, i12);
        initWebView(context2);
    }

    public ActiveWebView(Context context2, AttributeSet attributeSet, int i11, boolean z11) {
        super(context2, attributeSet, i11, z11);
        initWebView(context2);
    }

    public class HBWebViewClient extends WebViewClient {
        private HBWebViewClient() {
        }

        public void onPageFinished(WebView webView, String str) {
            k.e("HBWebView---> onPageFinished: " + str);
            if (ActiveWebView.this.mWebViewClient != null) {
                ActiveWebView.this.mWebViewClient.onPageFinished(webView, str);
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            if (ActiveWebView.this.mWebViewClient != null) {
                ActiveWebView.this.mWebViewClient.onPageStarted(webView, str, bitmap);
            }
            String simpleName = HBWebView.class.getSimpleName();
            d.c(simpleName, "onPageStarted mUrl----> " + str);
            k.e("HBWebView---> onPageStarted: " + str);
        }

        public void onReceivedError(WebView webView, int i11, String str, String str2) {
            if (ActiveWebView.this.mLoadErrorListener != null) {
                ActiveWebView.this.mLoadErrorListener.onError(i11, str);
            }
            if (!HbgRouter.f(str2)) {
                k.e("HBWebView---> errorCode:" + i11 + "; description = " + str + "; url = " + ActiveWebView.this.getUrl());
                if (ActiveWebView.this.mWebViewClient != null) {
                    ActiveWebView.this.mWebViewClient.onReceivedError(webView, i11, str, str2);
                }
                str2.startsWith("huobiapp://");
            }
        }

        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            if (!(ActiveWebView.this.mLoadErrorListener == null || webResourceResponse == null || !webResourceRequest.isForMainFrame())) {
                ActiveWebView.this.mLoadErrorListener.onError(webResourceResponse.getStatusCode(), (String) null);
            }
            k.c("onReceivedHttpError() called with: view = [" + webView + "], request = [" + webResourceRequest.getUrl() + "], errorResponse = [" + webResourceResponse.getStatusCode() + "]");
            if (ActiveWebView.this.mWebViewClient != null) {
                ActiveWebView.this.mWebViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            if (ActiveWebView.this.mLoadErrorListener != null) {
                ActiveWebView.this.mLoadErrorListener.onError(0, (String) null);
            }
            sslErrorHandler.cancel();
            if (ActiveWebView.this.mWebViewClient != null) {
                ActiveWebView.this.mWebViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
        }

        @TargetApi(21)
        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            if (webResourceRequest.getUrl() != null && !TextUtils.isEmpty(webResourceRequest.getUrl().toString()) && webResourceRequest.getUrl().toString().contains("amazonaws.com")) {
                return super.shouldInterceptRequest(webView, webResourceRequest);
            }
            WebResourceResponse f11 = WebCacheInterecptRequest.d().f(webView, webResourceRequest);
            return f11 != null ? f11 : super.shouldInterceptRequest(webView, webResourceRequest);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            String uri = webResourceRequest.getUrl() != null ? webResourceRequest.getUrl().toString() : "";
            if (HbgRouter.f(uri)) {
                w.e().g((Activity) ActiveWebView.this.getContext(), uri);
                return true;
            } else if (HbgRouter.g(uri)) {
                w.e().h((Activity) ActiveWebView.this.getContext(), uri);
                return true;
            } else {
                if (GlobalAppConfig.e() && webResourceRequest.isForMainFrame()) {
                    String unused = ActiveWebView.this.mUrl = webResourceRequest.getUrl().toString();
                }
                if (Build.VERSION.SDK_INT >= 21) {
                    return super.shouldOverrideUrlLoading(webView, webResourceRequest);
                }
                g.h().m(webView, webResourceRequest.getUrl().toString());
                return true;
            }
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            k.e("HBWebView---> shouldOverrideUrlLoading: " + str);
            try {
                if (ActiveWebView.this.mWebViewClient != null) {
                    if (Build.VERSION.SDK_INT >= 21) {
                        return super.shouldOverrideUrlLoading(webView, str);
                    }
                    g.h().m(webView, str);
                    return true;
                }
            } catch (Exception e11) {
                e11.printStackTrace();
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }
    }
}
