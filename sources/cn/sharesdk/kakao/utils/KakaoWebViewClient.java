package cn.sharesdk.kakao.utils;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.webkit.WebView;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.WebAuthorizeActivity;
import cn.sharesdk.framework.authorize.b;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import java.util.HashMap;

public class KakaoWebViewClient extends b {

    /* renamed from: a  reason: collision with root package name */
    private static final CharSequence f13587a = "kauth.kakao.com";

    /* renamed from: b  reason: collision with root package name */
    private static final CharSequence f13588b = "kapi.kakao.com";

    public KakaoWebViewClient(WebAuthorizeActivity webAuthorizeActivity) {
        super(webAuthorizeActivity);
    }

    public void onComplete(String str) {
        if (str.contains("error")) {
            this.listener.onCancel();
            return;
        }
        Bundle bundle = new Bundle();
        bundle.putString("com.kakao.sdk.talk.redirectUrl", str);
        this.listener.onComplete(bundle);
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
    }

    public void onReceivedError(WebView webView, int i11, String str, String str2) {
        super.onReceivedError(webView, i11, str, str2);
        this.activity.finish();
        AuthorizeListener authorizeListener = this.listener;
        if (authorizeListener != null) {
            authorizeListener.onError(new Throwable("error code=" + i11 + "msg=" + str + "url=" + str2));
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (str.contains(f13587a) || str.contains(f13588b)) {
            HashMap hashMap = new HashMap();
            hashMap.put("KA", a.a());
            webView.loadUrl(str, hashMap);
            SensorsDataAutoTrackHelper.loadUrl2(webView, str, hashMap);
            return true;
        }
        webView.stopLoading();
        this.activity.finish();
        onComplete(str);
        return true;
    }
}
