package com.hbg.module.huobi.im.group.ui.active;

import android.webkit.WebView;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WebView f20045b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f20046c;

    public /* synthetic */ a(WebView webView, String str) {
        this.f20045b = webView;
        this.f20046c = str;
    }

    public final void run() {
        ActiveInterface.lambda$dispatchWebViewFunction$0(this.f20045b, this.f20046c);
    }
}
