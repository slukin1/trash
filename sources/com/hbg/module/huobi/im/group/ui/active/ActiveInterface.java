package com.hbg.module.huobi.im.group.ui.active;

import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import com.google.gson.Gson;
import com.hbg.lib.core.BaseModuleConfig;
import com.hbg.lib.core.util.DokitJsActionHelper;
import com.hbg.lib.core.webview.bean.JsMessage;
import com.hbg.module.huobi.im.group.ui.active.ActiveView;
import com.hbg.module.huobi.im.manager.ActiveViewManager;
import com.huobi.webview2.action.JsBusinessActionHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import i6.d;
import i6.k;
import v6.u;
import x6.b;

public class ActiveInterface {
    public static final String ACTION_FINISH = "20010006";
    public static final int CODE_OK = 200;
    public static final String TAG = (ActiveInterface.class.getSimpleName() + " hbactive");
    public int activeType = 1;
    /* access modifiers changed from: private */
    public ActiveView.ActiveEventCallback mCallback;
    private u mWebViewUI;

    public ActiveInterface(u uVar, ActiveView.ActiveEventCallback activeEventCallback, int i11) {
        this.mWebViewUI = uVar;
        this.mCallback = activeEventCallback;
        this.activeType = i11;
    }

    public static void dispatchWebViewFunction(JsMessage jsMessage, WebView webView) {
        String jsString = getJsString(jsMessage);
        d.b("JsActionHelper-->dispatchWebViewFunction-->jsString:" + jsString);
        if (webView != null) {
            k.o(JsBusinessActionHelper.LOG_TAG, "dispatchWebViewFunction " + jsString);
            DokitJsActionHelper.b(jsMessage, jsString);
            webView.post(new a(webView, jsString));
        }
    }

    public static String getJsString(JsMessage jsMessage) {
        String json = new Gson().toJson((Object) jsMessage);
        return "javascript:huobiWeb.postMessage(" + json + ")";
    }

    public static void getUcTokenFromH5(JsMessage jsMessage, WebView webView) {
        String callback = jsMessage.getCallback();
        String f11 = BaseModuleConfig.a().f();
        d.b("WebViewJsCallback-->dealWithSession--> action:" + callback + " ucToken:" + f11);
        JsMessage jsMessage2 = new JsMessage();
        jsMessage2.setCode(200);
        jsMessage2.setData(f11);
        jsMessage2.setAction(callback);
        dispatchWebViewFunction(jsMessage, webView);
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ void lambda$dispatchWebViewFunction$0(WebView webView, String str) {
        webView.loadUrl(str);
        SensorsDataAutoTrackHelper.loadUrl2(webView, str);
    }

    public void closeWebView(JsMessage jsMessage) {
        d.b(TAG + " jsMessage:" + jsMessage);
        u uVar = this.mWebViewUI;
        if (uVar != null && uVar.getWebView() != null) {
            this.mWebViewUI.getWebView().post(new Runnable() {
                public void run() {
                    if (ActiveInterface.this.mCallback != null) {
                        ActiveInterface.this.mCallback.onClose((String) null);
                    }
                }
            });
        }
    }

    @JavascriptInterface
    public void postMessage(String str) {
        d.b(TAG + " h5回调了该方法  data:" + str);
        JsMessage h11 = b.h(str);
        if (h11 != null) {
            if ("20010006".equals(h11.getAction())) {
                closeWebView(h11);
            } else if ("liveRewards".equals(h11.getAction())) {
                ActiveViewManager.e().k(h11);
            } else {
                b.c(h11, this.mWebViewUI);
            }
        }
    }
}
