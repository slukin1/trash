package cn.sharesdk.telegram;

import android.os.Bundle;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.WebView;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.authorize.WebAuthorizeActivity;
import cn.sharesdk.framework.utils.SSDKLog;
import com.facebook.internal.NativeProtocol;
import com.huawei.hms.framework.common.ContainerUtils;
import com.mob.tools.utils.ResHelper;
import java.util.HashMap;

public class b extends cn.sharesdk.framework.authorize.b {

    /* renamed from: a  reason: collision with root package name */
    private Platform f13751a;

    public b(WebAuthorizeActivity webAuthorizeActivity) {
        super(webAuthorizeActivity);
        this.f13751a = webAuthorizeActivity.getHelper().getPlatform();
    }

    public void onComplete(String str) {
        try {
            String[] split = CookieManager.getInstance().getCookie(str).split("; ");
            HashMap hashMap = new HashMap();
            int i11 = 0;
            for (String split2 : split) {
                String[] split3 = split2.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split3.length > 1) {
                    hashMap.put(split3[0], split3[1]);
                } else if (split3.length == 1) {
                    hashMap.put(split3[0], "");
                }
            }
            String str2 = (String) hashMap.get("stel_ssid");
            String str3 = (String) hashMap.get("stel_token");
            Bundle bundle = new Bundle();
            bundle.putString("stel_ssid", str2);
            bundle.putString("stel_token", str3);
            if (str2 == null || str2.equals("") || str3 == null || str3.equals("")) {
                Bundle urlToBundle = ResHelper.urlToBundle(str);
                String string = urlToBundle.getString("error");
                String string2 = urlToBundle.getString(NativeProtocol.BRIDGE_ARG_ERROR_CODE);
                if (this.listener != null && string != null) {
                    i11 = ResHelper.parseInt(string2);
                    this.listener.onError(new Throwable(string + " (" + i11 + " )"));
                    return;
                }
                return;
            }
            this.listener.onComplete(bundle);
        } catch (Throwable th2) {
            SSDKLog.b().a(th2);
        }
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!TextUtils.isEmpty("https://oauth.telegram.org/auth/push") && str.startsWith("https://oauth.telegram.org/auth/push")) {
            webView.stopLoading();
            webView.postDelayed(new Runnable() {
                public void run() {
                    b.this.activity.finish();
                }
            }, 500);
            onComplete(str);
        }
        return super.shouldOverrideUrlLoading(webView, str);
    }
}
