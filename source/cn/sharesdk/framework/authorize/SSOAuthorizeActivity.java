package cn.sharesdk.framework.authorize;

import android.content.Intent;
import cn.sharesdk.framework.utils.SSDKLog;

public class SSOAuthorizeActivity extends AbstractAuthorizeActivity {
    private static final int DEFAULT_AUTH_ACTIVITY_CODE = 32973;
    public SSOListener listener;
    private c sso;

    public void onActivityResult(int i11, int i12, Intent intent) {
        try {
            this.sso.a(i11, i12, intent);
        } catch (Throwable th2) {
            finish();
            SSDKLog.b().a(th2);
        }
    }

    public void onCreate() {
        try {
            c sSOProcessor = this.helper.getSSOProcessor(this);
            this.sso = sSOProcessor;
            if (sSOProcessor == null) {
                finish();
                AuthorizeListener authorizeListener = this.helper.getAuthorizeListener();
                if (authorizeListener != null) {
                    authorizeListener.onError(new Throwable("Failed to start SSO for " + this.helper.getPlatform().getName()));
                    return;
                }
                return;
            }
            sSOProcessor.a((int) DEFAULT_AUTH_ACTIVITY_CODE);
            this.sso.a();
        } catch (Throwable th2) {
            finish();
            SSDKLog.b().a(th2);
        }
    }

    public void onNewIntent(Intent intent) {
        try {
            this.sso.a(intent);
        } catch (Throwable th2) {
            finish();
            SSDKLog.b().a(th2);
        }
    }

    public void setSSOListener(SSOListener sSOListener) {
        this.listener = sSOListener;
    }
}
