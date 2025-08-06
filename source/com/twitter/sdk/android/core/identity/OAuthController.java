package com.twitter.sdk.android.core.identity;

import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import com.huobi.woodpecker.aop.WoodPeckerWebViewAspect;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.twitter.sdk.android.core.Callback;
import com.twitter.sdk.android.core.Logger;
import com.twitter.sdk.android.core.Result;
import com.twitter.sdk.android.core.Twitter;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterAuthToken;
import com.twitter.sdk.android.core.TwitterException;
import com.twitter.sdk.android.core.identity.OAuthWebViewClient;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aService;
import com.twitter.sdk.android.core.internal.oauth.OAuthConstants;
import com.twitter.sdk.android.core.internal.oauth.OAuthResponse;
import org.aspectj.lang.JoinPoint;
import org.aspectj.runtime.internal.AroundClosure;
import org.aspectj.runtime.reflect.c;

class OAuthController implements OAuthWebViewClient.Listener {
    private static final /* synthetic */ JoinPoint.StaticPart ajc$tjp_0 = null;
    /* access modifiers changed from: private */
    public final TwitterAuthConfig authConfig;
    public final Listener listener;
    /* access modifiers changed from: private */
    public final OAuth1aService oAuth1aService;
    public TwitterAuthToken requestToken;
    private final ProgressBar spinner;
    /* access modifiers changed from: private */
    public final WebView webView;

    public class AjcClosure1 extends AroundClosure {
        public AjcClosure1(Object[] objArr) {
            super(objArr);
        }

        public Object run(Object[] objArr) {
            Object[] objArr2 = this.state;
            ((WebView) objArr2[1]).setWebViewClient((WebViewClient) objArr2[2]);
            return null;
        }
    }

    public interface Listener {
        void onComplete(int i11, Intent intent);
    }

    static {
        ajc$preClinit();
    }

    public OAuthController(ProgressBar progressBar, WebView webView2, TwitterAuthConfig twitterAuthConfig, OAuth1aService oAuth1aService2, Listener listener2) {
        this.spinner = progressBar;
        this.webView = webView2;
        this.authConfig = twitterAuthConfig;
        this.oAuth1aService = oAuth1aService2;
        this.listener = listener2;
    }

    private static /* synthetic */ void ajc$preClinit() {
        c cVar = new c("OAuthController.java", OAuthController.class);
        ajc$tjp_0 = cVar.h("method-call", cVar.g("1", "setWebViewClient", "android.webkit.WebView", "android.webkit.WebViewClient", "client", "", "void"), 117);
    }

    private void dismissSpinner() {
        this.spinner.setVisibility(8);
    }

    private void dismissWebView() {
        this.webView.stopLoading();
        dismissSpinner();
    }

    private void handleWebViewError(WebViewException webViewException) {
        Twitter.getLogger().e("Twitter", "OAuth web view completed with an error", webViewException);
        handleAuthError(1, new TwitterAuthException("OAuth web view completed with an error"));
    }

    private void handleWebViewSuccess(Bundle bundle) {
        String string;
        Twitter.getLogger().d("Twitter", "OAuth web view completed successfully");
        if (bundle == null || (string = bundle.getString(OAuthConstants.PARAM_VERIFIER)) == null) {
            Logger logger = Twitter.getLogger();
            logger.e("Twitter", "Failed to get authorization, bundle incomplete " + bundle, (Throwable) null);
            handleAuthError(1, new TwitterAuthException("Failed to get authorization, bundle incomplete"));
            return;
        }
        Twitter.getLogger().d("Twitter", "Converting the request token to an access token.");
        this.oAuth1aService.requestAccessToken(newRequestAccessTokenCallback(), this.requestToken, string);
    }

    public void handleAuthError(int i11, TwitterAuthException twitterAuthException) {
        Intent intent = new Intent();
        intent.putExtra(AuthHandler.EXTRA_AUTH_ERROR, twitterAuthException);
        this.listener.onComplete(i11, intent);
    }

    public Callback<OAuthResponse> newRequestAccessTokenCallback() {
        return new Callback<OAuthResponse>() {
            public void failure(TwitterException twitterException) {
                Twitter.getLogger().e("Twitter", "Failed to get access token", twitterException);
                OAuthController.this.handleAuthError(1, new TwitterAuthException("Failed to get access token"));
            }

            public void success(Result<OAuthResponse> result) {
                Intent intent = new Intent();
                OAuthResponse oAuthResponse = (OAuthResponse) result.data;
                intent.putExtra("screen_name", oAuthResponse.userName);
                intent.putExtra("user_id", oAuthResponse.userId);
                intent.putExtra(AuthHandler.EXTRA_TOKEN, oAuthResponse.authToken.token);
                intent.putExtra(AuthHandler.EXTRA_TOKEN_SECRET, oAuthResponse.authToken.secret);
                OAuthController.this.listener.onComplete(-1, intent);
            }
        };
    }

    public Callback<OAuthResponse> newRequestTempTokenCallback() {
        return new Callback<OAuthResponse>() {
            public void failure(TwitterException twitterException) {
                Twitter.getLogger().e("Twitter", "Failed to get request token", twitterException);
                OAuthController.this.handleAuthError(1, new TwitterAuthException("Failed to get request token"));
            }

            public void success(Result<OAuthResponse> result) {
                OAuthController oAuthController = OAuthController.this;
                oAuthController.requestToken = ((OAuthResponse) result.data).authToken;
                String authorizeUrl = oAuthController.oAuth1aService.getAuthorizeUrl(OAuthController.this.requestToken);
                Twitter.getLogger().d("Twitter", "Redirecting user to web view to complete authorization flow");
                OAuthController oAuthController2 = OAuthController.this;
                oAuthController2.setUpWebView(oAuthController2.webView, new OAuthWebViewClient(OAuthController.this.oAuth1aService.buildCallbackUrl(OAuthController.this.authConfig), OAuthController.this), authorizeUrl, new OAuthWebChromeClient());
            }
        };
    }

    public void onError(WebViewException webViewException) {
        handleWebViewError(webViewException);
        dismissWebView();
    }

    public void onPageFinished(WebView webView2, String str) {
        dismissSpinner();
        webView2.setVisibility(0);
    }

    public void onSuccess(Bundle bundle) {
        handleWebViewSuccess(bundle);
        dismissWebView();
    }

    public void setUpWebView(WebView webView2, WebViewClient webViewClient, String str, WebChromeClient webChromeClient) {
        WebSettings settings = webView2.getSettings();
        settings.setAllowFileAccess(false);
        settings.setJavaScriptEnabled(false);
        settings.setSaveFormData(false);
        webView2.setVerticalScrollBarEnabled(false);
        webView2.setHorizontalScrollBarEnabled(false);
        JoinPoint c11 = c.c(ajc$tjp_0, this, webView2, webViewClient);
        WoodPeckerWebViewAspect.h().g(new AjcClosure1(new Object[]{this, webView2, webViewClient, c11}).linkClosureAndJoinPoint(4112));
        webView2.loadUrl(str);
        SensorsDataAutoTrackHelper.loadUrl2(webView2, str);
        webView2.setVisibility(4);
        webView2.setWebChromeClient(webChromeClient);
    }

    public void startAuth() {
        Twitter.getLogger().d("Twitter", "Obtaining request token to start the sign in flow");
        this.oAuth1aService.requestTempToken(newRequestTempTokenCallback());
    }
}
