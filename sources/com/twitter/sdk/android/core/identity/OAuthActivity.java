package com.twitter.sdk.android.core.identity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.ProgressBar;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.aop.push.PushAutoTrackHelper;
import com.twitter.sdk.android.core.R;
import com.twitter.sdk.android.core.TwitterAuthConfig;
import com.twitter.sdk.android.core.TwitterAuthException;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.identity.OAuthController;
import com.twitter.sdk.android.core.internal.TwitterApi;
import com.twitter.sdk.android.core.internal.oauth.OAuth1aService;

public class OAuthActivity extends Activity implements OAuthController.Listener {
    public static final String EXTRA_AUTH_CONFIG = "auth_config";
    private static final String STATE_PROGRESS = "progress";
    public OAuthController oAuthController;
    private ProgressBar spinner;
    private WebView webView;

    public void onBackPressed() {
        this.oAuthController.handleAuthError(0, new TwitterAuthException("Authorization failed, request was canceled."));
    }

    public void onComplete(int i11, Intent intent) {
        setResult(i11, intent);
        finish();
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.tw__activity_oauth);
        this.spinner = (ProgressBar) findViewById(R.id.tw__spinner);
        this.webView = (WebView) findViewById(R.id.tw__web_view);
        int i11 = 0;
        boolean z11 = bundle != null ? bundle.getBoolean(STATE_PROGRESS, false) : true;
        ProgressBar progressBar = this.spinner;
        if (!z11) {
            i11 = 8;
        }
        progressBar.setVisibility(i11);
        OAuthController oAuthController2 = new OAuthController(this.spinner, this.webView, (TwitterAuthConfig) getIntent().getParcelableExtra(EXTRA_AUTH_CONFIG), new OAuth1aService(TwitterCore.getInstance(), new TwitterApi()), this);
        this.oAuthController = oAuthController2;
        oAuthController2.startAuth();
    }

    @SensorsDataInstrumented
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        PushAutoTrackHelper.onNewIntent(this, intent);
    }

    public void onSaveInstanceState(Bundle bundle) {
        if (this.spinner.getVisibility() == 0) {
            bundle.putBoolean(STATE_PROGRESS, true);
        }
        super.onSaveInstanceState(bundle);
    }
}
