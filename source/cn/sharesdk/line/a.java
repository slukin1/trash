package cn.sharesdk.line;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.WebView;
import cn.sharesdk.framework.authorize.AuthorizeListener;
import cn.sharesdk.framework.authorize.WebAuthorizeActivity;
import cn.sharesdk.framework.authorize.b;
import com.facebook.AccessToken;
import com.facebook.internal.NativeProtocol;
import com.mob.tools.utils.Hashon;
import com.mob.tools.utils.ResHelper;
import java.util.HashMap;

public class a extends b {

    /* renamed from: a  reason: collision with root package name */
    private boolean f13606a;

    public a(WebAuthorizeActivity webAuthorizeActivity) {
        super(webAuthorizeActivity);
    }

    public void onComplete(String str) {
        AuthorizeListener authorizeListener;
        if (!this.f13606a) {
            this.f13606a = true;
            Bundle urlToBundle = ResHelper.urlToBundle(str);
            String string = urlToBundle.getString(NativeProtocol.BRIDGE_ARG_ERROR_DESCRIPTION);
            if (!(string == null || (authorizeListener = this.listener) == null)) {
                authorizeListener.onError(new Throwable(urlToBundle.toString()));
            }
            if (string == null && this.listener != null) {
                final String string2 = urlToBundle.getString("code");
                if (!TextUtils.isEmpty(string2)) {
                    new Thread() {
                        public void run() {
                            String str;
                            try {
                                str = c.a().b(string2);
                            } catch (Throwable th2) {
                                if (a.this.listener != null) {
                                    a.this.listener.onError(th2);
                                }
                                str = null;
                            }
                            if (str != null || a.this.listener == null) {
                                HashMap fromJson = new Hashon().fromJson(str);
                                Bundle bundle = new Bundle();
                                bundle.putString("access_token", String.valueOf(fromJson.get("access_token")));
                                bundle.putString("token_type", String.valueOf(fromJson.get("token_type")));
                                bundle.putString("refresh_token", String.valueOf(fromJson.get("refresh_token")));
                                bundle.putString(AccessToken.EXPIRES_IN_KEY, String.valueOf(fromJson.get(AccessToken.EXPIRES_IN_KEY)));
                                bundle.putString("scope", String.valueOf(fromJson.get("scope")));
                                bundle.putString("id_token", String.valueOf(fromJson.get("id_token")));
                                a.this.listener.onComplete(bundle);
                                return;
                            }
                            a.this.listener.onError(new Throwable("Authorize token is empty"));
                        }
                    }.start();
                } else {
                    this.listener.onError(new Throwable(str));
                }
            }
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!str.startsWith("https://www.mob.com")) {
            return super.shouldOverrideUrlLoading(webView, str);
        }
        webView.stopLoading();
        this.activity.finish();
        onComplete(str);
        return true;
    }
}
