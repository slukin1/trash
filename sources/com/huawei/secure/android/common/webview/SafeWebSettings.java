package com.huawei.secure.android.common.webview;

import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class SafeWebSettings {
    public static void a(WebSettings webSettings) {
        if (Build.VERSION.SDK_INT >= 11) {
            webSettings.setAllowContentAccess(false);
        }
    }

    public static void b(WebSettings webSettings) {
        webSettings.setAllowFileAccess(false);
        if (Build.VERSION.SDK_INT >= 16) {
            webSettings.setAllowFileAccessFromFileURLs(false);
            webSettings.setAllowUniversalAccessFromFileURLs(false);
        }
    }

    public static void c(WebSettings webSettings) {
        webSettings.setGeolocationEnabled(false);
    }

    public static void d(WebSettings webSettings) {
        if (Build.VERSION.SDK_INT >= 21) {
            webSettings.setMixedContentMode(1);
        }
    }

    public static void e(WebSettings webSettings) {
        if (Build.VERSION.SDK_INT <= 18) {
            webSettings.setSavePassword(false);
        }
    }

    public static void f(WebView webView) {
        WebSettings settings = webView.getSettings();
        b(settings);
        g(webView);
        e(settings);
        c(settings);
        d(settings);
        a(settings);
    }

    public static void g(WebView webView) {
        if (Build.VERSION.SDK_INT >= 11) {
            webView.removeJavascriptInterface("searchBoxJavaBridge_");
            webView.removeJavascriptInterface("accessibility");
            webView.removeJavascriptInterface("accessibilityTraversal");
        }
    }
}
