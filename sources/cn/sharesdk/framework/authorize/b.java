package cn.sharesdk.framework.authorize;

import android.webkit.WebView;
import cn.sharesdk.framework.h;

public abstract class b extends h {
    public WebAuthorizeActivity activity;
    public String authorizeUrl;
    public AuthorizeListener listener;
    public String redirectUri;

    public b(WebAuthorizeActivity webAuthorizeActivity) {
        this.activity = webAuthorizeActivity;
        AuthorizeHelper helper = webAuthorizeActivity.getHelper();
        this.authorizeUrl = helper.getAuthorizeUrl();
        this.redirectUri = helper.getRedirectUri();
        this.listener = helper.getAuthorizeListener();
    }

    public abstract void onComplete(String str);

    public void onReceivedError(WebView webView, int i11, String str, String str2) {
        webView.stopLoading();
        AuthorizeListener authorizeListener = this.activity.getHelper().getAuthorizeListener();
        this.activity.finish();
        if (authorizeListener != null) {
            authorizeListener.onError(new Throwable(str + " (" + i11 + "): " + str2));
        }
    }
}
