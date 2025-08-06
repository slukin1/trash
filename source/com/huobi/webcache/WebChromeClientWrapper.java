package com.huobi.webcache;

import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

public class WebChromeClientWrapper extends WebChromeClient {

    /* renamed from: a  reason: collision with root package name */
    public WebChromeClient f20680a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f20681b = false;

    public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        String message;
        if (!(consoleMessage == null || (message = consoleMessage.message()) == null || !this.f20681b)) {
            Log.w("WebChromeClientWrapper", "onConsoleMessage() called with: msg = [" + message + "]");
        }
        WebChromeClient webChromeClient = this.f20680a;
        return webChromeClient != null ? webChromeClient.onConsoleMessage(consoleMessage) : super.onConsoleMessage(consoleMessage);
    }

    public void onProgressChanged(WebView webView, int i11) {
        WebChromeClient webChromeClient = this.f20680a;
        if (webChromeClient == null) {
            super.onProgressChanged(webView, i11);
        } else {
            webChromeClient.onProgressChanged(webView, i11);
        }
    }
}
