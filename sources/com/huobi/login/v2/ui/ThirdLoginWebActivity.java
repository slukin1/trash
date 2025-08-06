package com.huobi.login.v2.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Message;
import android.webkit.CookieManager;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import com.hbg.lib.common.utils.PixelUtils;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.lib.core.webview.HBWebView;
import com.huobi.woodpecker.aop.WoodPeckerWebViewAspect;
import com.huochat.community.network.domain.DomainTool;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import i6.k;
import on.e;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.reflect.c;
import tn.n0;
import tn.o0;
import v6.u;
import w6.b;

public class ThirdLoginWebActivity extends HBBaseWebActivity {

    /* renamed from: b  reason: collision with root package name */
    public WebView f75913b;

    /* renamed from: c  reason: collision with root package name */
    public FrameLayout f75914c;

    public class a extends b {

        /* renamed from: h  reason: collision with root package name */
        public static final /* synthetic */ JoinPoint.StaticPart f75915h = null;

        static {
            i();
        }

        public a(u uVar) {
            super(uVar);
        }

        public static /* synthetic */ void i() {
            c cVar = new c("ThirdLoginWebActivity.java", a.class);
            f75915h = cVar.h("method-call", cVar.g("1", "setWebViewClient", "android.webkit.WebView", "android.webkit.WebViewClient", "client", "", "void"), 54);
        }

        public void onCloseWindow(WebView webView) {
            super.onCloseWindow(webView);
            CookieManager instance = CookieManager.getInstance();
            String cookie = instance.getCookie(DomainTool.DOMAIN_PREFIX + e.f76413e);
            k.o("TelegramLogin", "onCloseWindow cookie=" + cookie);
            Intent intent = new Intent();
            intent.putExtra("param_telegram_cookie", cookie);
            ThirdLoginWebActivity.this.setResult(0, intent);
            ThirdLoginWebActivity.this.finish();
        }

        public boolean onCreateWindow(WebView webView, boolean z11, boolean z12, Message message) {
            k.o("TelegramLogin", "onCreateWindow");
            WebView unused = ThirdLoginWebActivity.this.f75913b = new WebView(ThirdLoginWebActivity.this);
            WebView yh2 = ThirdLoginWebActivity.this.f75913b;
            WebViewClient webViewClient = new WebViewClient();
            JoinPoint c11 = c.c(f75915h, this, yh2, webViewClient);
            WoodPeckerWebViewAspect.h().g(new o0(new Object[]{this, yh2, webViewClient, c11}).linkClosureAndJoinPoint(4112));
            ThirdLoginWebActivity thirdLoginWebActivity = ThirdLoginWebActivity.this;
            thirdLoginWebActivity.Dh(thirdLoginWebActivity.f75913b);
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -1);
            layoutParams.topMargin = PixelUtils.a(50.0f);
            ThirdLoginWebActivity.this.f75914c.addView(ThirdLoginWebActivity.this.f75913b, layoutParams);
            ((WebView.WebViewTransport) message.obj).setWebView(ThirdLoginWebActivity.this.f75913b);
            message.sendToTarget();
            return true;
        }
    }

    public static /* synthetic */ void Ch(Boolean bool) {
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void Dh(WebView webView) {
        webView.setWebChromeClient(this.mChromeClient);
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);
        settings.setAllowFileAccess(true);
    }

    @JavascriptInterface
    public String getTelegramAuthUrl() {
        return getIntent().getStringExtra("param_telegram_auth_url");
    }

    public void init() {
        super.init();
        this.f75914c = (FrameLayout) findViewById(16908290);
        this.mChromeClient = new a(this);
        Dh(this.mWebView);
        HBWebView hBWebView = this.mWebView;
        hBWebView.loadUrl("file:///android_asset/web/telegram_login.html");
        SensorsDataAutoTrackHelper.loadUrl2(hBWebView, "file:///android_asset/web/telegram_login.html");
    }

    public void initView() {
        super.initView();
        CookieManager.getInstance().removeAllCookies(n0.f37295a);
        this.mWebView.addJavascriptInterface(this, "thirdLoginObj");
    }

    public void loadUrl(String str) {
    }
}
