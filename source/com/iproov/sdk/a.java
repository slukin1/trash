package com.iproov.sdk;

import android.webkit.ValueCallback;
import android.webkit.WebView;
import com.iproov.sdk.p014for.Cdo;

public final /* synthetic */ class a implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ WebView f38732b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Cdo f38733c;

    public /* synthetic */ a(WebView webView, Cdo doVar) {
        this.f38732b = webView;
        this.f38733c = doVar;
    }

    public final void run() {
        this.f38732b.evaluateJavascript(this.f38733c.m687do(), (ValueCallback) null);
    }
}
