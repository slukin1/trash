package com.hbg.lib.core.webview.trace;

public enum StepType {
    WebViewCreate("WebViewCreate"),
    WebViewShow("WebViewShow"),
    WebViewRequest("WebViewRequest"),
    WebViewDidSuccess("WebViewDidSuccess"),
    WebViewDidFail("WebViewDidFail"),
    WebViewDisappear("WebViewDisappear"),
    WebViewClose("WebViewClose");
    
    public final String step;

    private StepType(String str) {
        this.step = str;
    }
}
