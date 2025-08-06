package com.jumio.sdk.views;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Message;
import android.util.AttributeSet;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.FrameLayout;
import com.jumio.core.interfaces.DigitalIdScanPartInterface;
import com.jumio.core.util.DeviceUtilKt;
import com.jumio.sdk.scanpart.JumioScanPart;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import kotlin.jvm.internal.r;

@SuppressLint({"SetJavaScriptEnabled"})
public final class JumioDigitalIdentityView extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    public final WebView f25018a;

    /* renamed from: b  reason: collision with root package name */
    public DigitalIdScanPartInterface f25019b;

    public final class a extends WebChromeClient {

        /* renamed from: a  reason: collision with root package name */
        public final JumioDigitalIdentityView f25020a;

        public a(JumioDigitalIdentityView jumioDigitalIdentityView) {
            this.f25020a = jumioDigitalIdentityView;
        }

        public final boolean onCreateWindow(WebView webView, boolean z11, boolean z12, Message message) {
            ((WebView.WebViewTransport) message.obj).setWebView(new WebView(webView.getContext()));
            message.sendToTarget();
            JumioDigitalIdentityView.access$externalRequestStarted(this.f25020a);
            return true;
        }
    }

    public JumioDigitalIdentityView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        WebView webView = new WebView(getContext());
        this.f25018a = webView;
        if (!isInEditMode()) {
            WebView.setWebContentsDebuggingEnabled(DeviceUtilKt.getDeviceUtil().isDebug(getContext()));
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setSupportMultipleWindows(true);
            webView.setWebChromeClient(new a(this));
            addView(webView, new FrameLayout.LayoutParams(-1, -1));
        }
    }

    public static final void access$externalRequestStarted(JumioDigitalIdentityView jumioDigitalIdentityView) {
        DigitalIdScanPartInterface digitalIdScanPartInterface = jumioDigitalIdentityView.f25019b;
        if (digitalIdScanPartInterface != null) {
            digitalIdScanPartInterface.thirdPartyVerificationStarted();
        }
    }

    public void attach(JumioScanPart jumioScanPart) {
        if (jumioScanPart.getScanPart$jumio_core_release() instanceof DigitalIdScanPartInterface) {
            DigitalIdScanPartInterface digitalIdScanPartInterface = (DigitalIdScanPartInterface) jumioScanPart.getScanPart$jumio_core_release();
            this.f25019b = digitalIdScanPartInterface;
            if (digitalIdScanPartInterface != null) {
                WebView webView = this.f25018a;
                WebView webView2 = webView;
                String baseUrl = digitalIdScanPartInterface.getBaseUrl();
                String html = digitalIdScanPartInterface.getHtml();
                String str = "text/html";
                String str2 = "UTF-8";
                webView2.loadDataWithBaseURL(baseUrl, html, str, str2, (String) null);
                SensorsDataAutoTrackHelper.loadDataWithBaseURL2(webView2, baseUrl, html, str, str2, (String) null);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("Wrong scan part provided!".toString());
    }

    public final void restoreState(Bundle bundle) {
        this.f25018a.restoreState(bundle);
    }

    public final void saveState(Bundle bundle) {
        this.f25018a.saveState(bundle);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ JumioDigitalIdentityView(Context context, AttributeSet attributeSet, int i11, r rVar) {
        this(context, (i11 & 2) != 0 ? null : attributeSet);
    }

    public JumioDigitalIdentityView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        WebView webView = new WebView(getContext());
        this.f25018a = webView;
        if (!isInEditMode()) {
            WebView.setWebContentsDebuggingEnabled(DeviceUtilKt.getDeviceUtil().isDebug(getContext()));
            WebSettings settings = webView.getSettings();
            settings.setJavaScriptEnabled(true);
            settings.setDomStorageEnabled(true);
            settings.setSupportMultipleWindows(true);
            webView.setWebChromeClient(new a(this));
            addView(webView, new FrameLayout.LayoutParams(-1, -1));
        }
    }
}
