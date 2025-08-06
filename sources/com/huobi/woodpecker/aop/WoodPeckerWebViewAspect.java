package com.huobi.woodpecker.aop;

import android.app.Activity;
import android.graphics.Bitmap;
import android.net.Uri;
import android.net.http.SslError;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.webkit.ClientCertRequest;
import android.webkit.HttpAuthHandler;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SafeBrowsingResponse;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.huobi.woodpecker.core.ActionType;
import com.huobi.woodpecker.model.WebTimingData;
import com.huobi.woodpecker.model.WebViewMonitorRecord;
import com.huobi.woodpecker.monitor.OpPathMonitor;
import com.huobi.woodpecker.net.NetUtils;
import com.huobi.woodpecker.utils.ContextUtil;
import com.huobi.woodpecker.utils.RecordUtil;
import com.huobi.woodpecker.utils.StringUtils;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Set;
import kv.e;
import org.aspectj.lang.NoAspectBoundException;
import org.aspectj.lang.ProceedingJoinPoint;
import vu.d;
import wu.c;

public class WoodPeckerWebViewAspect {

    /* renamed from: a  reason: collision with root package name */
    public static final String f20994a = "com.huobi.woodpecker.aop.WoodPeckerWebViewAspect";

    /* renamed from: b  reason: collision with root package name */
    public static final Set<Class> f20995b = new HashSet();

    /* renamed from: c  reason: collision with root package name */
    public static String f20996c;

    /* renamed from: d  reason: collision with root package name */
    public static /* synthetic */ Throwable f20997d;

    /* renamed from: e  reason: collision with root package name */
    public static final /* synthetic */ WoodPeckerWebViewAspect f20998e = null;

    static {
        try {
            f20998e = new WoodPeckerWebViewAspect();
        } catch (Throwable th2) {
            f20997d = th2;
        }
    }

    public static void c(Class cls) {
        f20995b.add(cls);
    }

    public static WoodPeckerWebViewAspect h() {
        WoodPeckerWebViewAspect woodPeckerWebViewAspect = f20998e;
        if (woodPeckerWebViewAspect != null) {
            return woodPeckerWebViewAspect;
        }
        throw new NoAspectBoundException(f20994a, f20997d);
    }

    public static void i(String str, int i11, String str2, String str3) {
        if (StringUtils.a(str)) {
            WebTimingData webTimingData = new WebTimingData(str, i11, str2);
            webTimingData.f21146op = OpPathMonitor.c().d();
            WebViewMonitorRecord webViewMonitorRecord = new WebViewMonitorRecord();
            webViewMonitorRecord.setData(webTimingData);
            webViewMonitorRecord.setAction(ActionType.APP_WEBVIEW);
            webViewMonitorRecord.setUrl(str);
            webViewMonitorRecord.setUa(str3);
            RecordUtil.a(webViewMonitorRecord);
            if (e.l()) {
                String str4 = f20994a;
                e.c(str4, "uploadWebViewErrorRecord: " + webViewMonitorRecord.toJsonString());
            }
            c.b(webViewMonitorRecord);
        }
    }

    public void g(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        WebViewClient webViewClient;
        String d11 = f20994a;
        StringBuilder sb2 = new StringBuilder();
        sb2.append("aroundSetWebViewClient enable:");
        ActionType actionType = ActionType.APP_WEBVIEW;
        sb2.append(actionType.isEnable());
        sb2.append(" > joinPoint.target=");
        sb2.append(proceedingJoinPoint.getTarget());
        e.m(d11, sb2.toString());
        if (actionType.isDisable()) {
            proceedingJoinPoint.a();
            return;
        }
        Object target = proceedingJoinPoint.getTarget();
        Object[] c11 = proceedingJoinPoint.c();
        if ((target instanceof WebView) && !f20995b.contains(target.getClass())) {
            WebView webView = (WebView) target;
            webView.addJavascriptInterface(new lv.a(webView.getSettings().getUserAgentString()), "woodWatcher");
            if (c11 == null || c11.length == 0 || !(c11[0] instanceof WebViewClient)) {
                webViewClient = Build.VERSION.SDK_INT >= 26 ? webView.getWebViewClient() : null;
            } else {
                webViewClient = (WebViewClient) c11[0];
            }
            if (c11 == null || c11.length == 0) {
                c11 = new Object[0];
                c11[0] = new a((WebViewClient) null);
            } else if (webViewClient == null || (webViewClient instanceof a)) {
                c11[0] = new a((WebViewClient) null);
            } else {
                c11[0] = new a(webViewClient);
            }
        }
        proceedingJoinPoint.e(c11);
    }

    public static class a extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        public WebViewClient f20999a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f21000b = false;

        public a(WebViewClient webViewClient) {
            this.f20999a = webViewClient;
        }

        public void doUpdateVisitedHistory(WebView webView, String str, boolean z11) {
            super.doUpdateVisitedHistory(webView, str, z11);
            WebViewClient webViewClient = this.f20999a;
            if (webViewClient != null) {
                webViewClient.doUpdateVisitedHistory(webView, str, z11);
            }
        }

        public void onFormResubmission(WebView webView, Message message, Message message2) {
            super.onFormResubmission(webView, message, message2);
            WebViewClient webViewClient = this.f20999a;
            if (webViewClient != null) {
                webViewClient.onFormResubmission(webView, message, message2);
            }
        }

        public void onLoadResource(WebView webView, String str) {
            super.onLoadResource(webView, str);
            WebViewClient webViewClient = this.f20999a;
            if (webViewClient != null) {
                webViewClient.onLoadResource(webView, str);
            }
        }

        public void onPageCommitVisible(WebView webView, String str) {
            super.onPageCommitVisible(webView, str);
            WebViewClient webViewClient = this.f20999a;
            if (webViewClient != null) {
                webViewClient.onPageCommitVisible(webView, str);
            }
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            Activity a11 = ContextUtil.a(webView.getContext());
            if (a11 != null && !a11.isFinishing()) {
                if (e.l()) {
                    String a12 = WoodPeckerWebViewAspect.f20994a;
                    e.c(a12, "onPageFinished url:" + str + "    ,isInjection=" + this.f21000b);
                }
                WebViewClient webViewClient = this.f20999a;
                if (webViewClient != null) {
                    webViewClient.onPageFinished(webView, str);
                }
                if (this.f21000b) {
                    if (e.l()) {
                        String a13 = WoodPeckerWebViewAspect.f20994a;
                        e.c(a13, "onPageFinished-- called with: view = [重复了~~], url = [" + str + "]");
                    }
                } else if (ActionType.APP_WEBVIEW.isEnable()) {
                    e.c(WoodPeckerWebViewAspect.f20994a, "start Injection  cacheStatisticsJs");
                    if (TextUtils.isEmpty(WoodPeckerWebViewAspect.f20996c)) {
                        InputStream inputStream = null;
                        try {
                            InputStream open = webView.getContext().getAssets().open("monitor_opt.js");
                            byte[] bArr = new byte[open.available()];
                            if (open.read(bArr) > 0) {
                                String str2 = new String(bArr, "utf-8");
                                if (!TextUtils.isEmpty(str2)) {
                                    WoodPeckerWebViewAspect.f20996c = "javascript:   (function() {        var script=document.createElement('script');         script.setAttribute('type','text/javascript');         script.textContent='" + str2 + "';         document.head.appendChild(script);     }    )();";
                                    e.c(WoodPeckerWebViewAspect.f20994a, "使用本地js注入");
                                }
                            }
                            try {
                                open.close();
                            } catch (IOException e11) {
                                e11.printStackTrace();
                            }
                        } catch (IOException e12) {
                            e12.printStackTrace();
                            String a14 = WoodPeckerWebViewAspect.f20994a;
                            e.c(a14, "onPageFinished e:" + e12.getMessage());
                            if (inputStream != null) {
                                inputStream.close();
                            }
                        } catch (Throwable th2) {
                            if (inputStream != null) {
                                try {
                                    inputStream.close();
                                } catch (IOException e13) {
                                    e13.printStackTrace();
                                }
                            }
                            throw th2;
                        }
                    }
                    if (!TextUtils.isEmpty(WoodPeckerWebViewAspect.f20996c)) {
                        double m11 = d.k().m();
                        if (m11 > 0.0d) {
                            String str3 = WoodPeckerWebViewAspect.f20996c;
                            WoodPeckerWebViewAspect.f20996c = str3.replaceFirst("JSON\\.parse\\(\\d+\\.?\\d+?\\)", "JSON.parse(" + m11 + ")");
                        }
                        String str4 = WoodPeckerWebViewAspect.f20996c;
                        webView.loadUrl(str4);
                        SensorsDataAutoTrackHelper.loadUrl2(webView, str4);
                        String a15 = WoodPeckerWebViewAspect.f20994a;
                        e.c(a15, "注入:\n" + WoodPeckerWebViewAspect.f20996c);
                        this.f21000b = true;
                    }
                }
            } else if (e.l()) {
                String a16 = WoodPeckerWebViewAspect.f20994a;
                e.c(a16, "onPageFinished activity isFinished or activity = " + a11);
            }
        }

        public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
            super.onPageStarted(webView, str, bitmap);
            this.f21000b = false;
            if (e.l()) {
                String a11 = WoodPeckerWebViewAspect.f20994a;
                e.c(a11, "onPageStarted url:" + str);
            }
            WebViewClient webViewClient = this.f20999a;
            if (webViewClient != null) {
                webViewClient.onPageStarted(webView, str, bitmap);
            }
        }

        public void onReceivedClientCertRequest(WebView webView, ClientCertRequest clientCertRequest) {
            super.onReceivedClientCertRequest(webView, clientCertRequest);
            WebViewClient webViewClient = this.f20999a;
            if (webViewClient != null) {
                webViewClient.onReceivedClientCertRequest(webView, clientCertRequest);
            }
        }

        public void onReceivedError(WebView webView, int i11, String str, String str2) {
            String str3;
            super.onReceivedError(webView, i11, str, str2);
            WebViewClient webViewClient = this.f20999a;
            if (webViewClient != null) {
                webViewClient.onReceivedError(webView, i11, str, str2);
            }
            if (Build.VERSION.SDK_INT < 23) {
                Activity a11 = ContextUtil.a(webView.getContext());
                if (a11 == null || a11.isFinishing()) {
                    str3 = "onReceivedError onPageFinished activity isFinished or activity = " + a11;
                } else {
                    str3 = "onReceivedError <M errorCode:" + i11 + ", description:" + str + ", failingUrl:" + str2;
                }
                try {
                    WoodPeckerWebViewAspect.i(str2, i11, NetUtils.c(Uri.parse(str2).getHost(), str3), webView.getSettings().getUserAgentString());
                } catch (Exception e11) {
                    e11.printStackTrace();
                    WoodPeckerWebViewAspect.i(str2, i11, str3, webView.getSettings().getUserAgentString());
                }
            }
        }

        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            super.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            WebViewClient webViewClient = this.f20999a;
            if (webViewClient != null) {
                webViewClient.onReceivedHttpAuthRequest(webView, httpAuthHandler, str, str2);
            }
        }

        public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
            String str;
            super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            WebViewClient webViewClient = this.f20999a;
            if (webViewClient != null) {
                webViewClient.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
            }
            if (webResourceRequest.isForMainFrame()) {
                Activity a11 = ContextUtil.a(webView.getContext());
                String uri = webResourceRequest.getUrl().toString();
                int statusCode = webResourceResponse.getStatusCode();
                if (a11 == null || a11.isFinishing()) {
                    str = "onReceivedError onPageFinished activity isFinished or activity = " + a11;
                } else {
                    str = "onReceivedError <M errorCode:" + statusCode + ", description:net::ERR_BADREQUEST:" + webResourceResponse.getStatusCode() + ", failingUrl:" + uri;
                }
                try {
                    WoodPeckerWebViewAspect.i(uri, statusCode, NetUtils.c(Uri.parse(uri).getHost(), str), webView.getSettings().getUserAgentString());
                } catch (Exception e11) {
                    e11.printStackTrace();
                    WoodPeckerWebViewAspect.i(uri, statusCode, str, webView.getSettings().getUserAgentString());
                }
            }
        }

        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            super.onReceivedLoginRequest(webView, str, str2, str3);
            WebViewClient webViewClient = this.f20999a;
            if (webViewClient != null) {
                webViewClient.onReceivedLoginRequest(webView, str, str2, str3);
            }
        }

        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String str;
            super.onReceivedSslError(webView, sslErrorHandler, sslError);
            WebViewClient webViewClient = this.f20999a;
            if (webViewClient != null) {
                webViewClient.onReceivedSslError(webView, sslErrorHandler, sslError);
            }
            try {
                String c11 = NetUtils.c(Uri.parse(sslError.getUrl()).getHost(), sslError.toString());
                if (Build.VERSION.SDK_INT >= 29) {
                    str = c11 + "webSSLInfo：" + NetUtils.a(sslError.getCertificate().getX509Certificate());
                } else {
                    str = c11 + "webSSLInfo：" + sslError.getCertificate().toString();
                }
                WoodPeckerWebViewAspect.i(sslError.getUrl(), sslError.getPrimaryError(), str, webView.getSettings().getUserAgentString());
            } catch (Exception e11) {
                e11.printStackTrace();
                WoodPeckerWebViewAspect.i(sslError.getUrl(), sslError.getPrimaryError(), sslError.toString(), webView.getSettings().getUserAgentString());
            }
        }

        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            WebViewClient webViewClient = this.f20999a;
            if (webViewClient != null) {
                return webViewClient.onRenderProcessGone(webView, renderProcessGoneDetail);
            }
            return super.onRenderProcessGone(webView, renderProcessGoneDetail);
        }

        public void onSafeBrowsingHit(WebView webView, WebResourceRequest webResourceRequest, int i11, SafeBrowsingResponse safeBrowsingResponse) {
            super.onSafeBrowsingHit(webView, webResourceRequest, i11, safeBrowsingResponse);
            WebViewClient webViewClient = this.f20999a;
            if (webViewClient != null) {
                webViewClient.onSafeBrowsingHit(webView, webResourceRequest, i11, safeBrowsingResponse);
            }
        }

        public void onScaleChanged(WebView webView, float f11, float f12) {
            super.onScaleChanged(webView, f11, f12);
            WebViewClient webViewClient = this.f20999a;
            if (webViewClient != null) {
                webViewClient.onScaleChanged(webView, f11, f12);
            }
        }

        public void onTooManyRedirects(WebView webView, Message message, Message message2) {
            super.onTooManyRedirects(webView, message, message2);
            WebViewClient webViewClient = this.f20999a;
            if (webViewClient != null) {
                webViewClient.onTooManyRedirects(webView, message, message2);
            }
        }

        public void onUnhandledKeyEvent(WebView webView, KeyEvent keyEvent) {
            super.onUnhandledKeyEvent(webView, keyEvent);
            WebViewClient webViewClient = this.f20999a;
            if (webViewClient != null) {
                webViewClient.onUnhandledKeyEvent(webView, keyEvent);
            }
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            WebViewClient webViewClient = this.f20999a;
            if (webViewClient != null) {
                return webViewClient.shouldInterceptRequest(webView, str);
            }
            return super.shouldInterceptRequest(webView, str);
        }

        public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
            WebViewClient webViewClient = this.f20999a;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideKeyEvent(webView, keyEvent);
            }
            return super.shouldOverrideKeyEvent(webView, keyEvent);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, String str) {
            WebViewClient webViewClient = this.f20999a;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideUrlLoading(webView, str);
            }
            if (e.l()) {
                String a11 = WoodPeckerWebViewAspect.f20994a;
                e.c(a11, "shouldOverrideUrlLoading url:" + str);
            }
            return super.shouldOverrideUrlLoading(webView, str);
        }

        public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            WebViewClient webViewClient = this.f20999a;
            if (webViewClient != null) {
                return webViewClient.shouldInterceptRequest(webView, webResourceRequest);
            }
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            WebViewClient webViewClient = this.f20999a;
            if (webViewClient != null) {
                return webViewClient.shouldOverrideUrlLoading(webView, webResourceRequest);
            }
            if (e.l()) {
                String a11 = WoodPeckerWebViewAspect.f20994a;
                e.c(a11, "shouldOverrideUrlLoading request.url:" + webResourceRequest.getUrl());
            }
            return super.shouldOverrideUrlLoading(webView, webResourceRequest);
        }

        public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
            String str;
            super.onReceivedError(webView, webResourceRequest, webResourceError);
            WebViewClient webViewClient = this.f20999a;
            if (webViewClient != null) {
                webViewClient.onReceivedError(webView, webResourceRequest, webResourceError);
            }
            if (webResourceRequest.isForMainFrame()) {
                Activity a11 = ContextUtil.a(webView.getContext());
                String uri = webResourceRequest.getUrl().toString();
                int errorCode = webResourceError.getErrorCode();
                if (a11 == null || a11.isFinishing()) {
                    str = "onReceivedError onPageFinished activity isFinished or activity = " + a11;
                } else {
                    str = "onReceivedError <M errorCode:" + errorCode + ", description:" + webResourceError.getDescription() + ", failingUrl:" + uri;
                }
                try {
                    WoodPeckerWebViewAspect.i(uri, errorCode, NetUtils.c(Uri.parse(uri).getHost(), str), webView.getSettings().getUserAgentString());
                } catch (Exception e11) {
                    e11.printStackTrace();
                    WoodPeckerWebViewAspect.i(uri, errorCode, str, webView.getSettings().getUserAgentString());
                }
            }
        }
    }
}
