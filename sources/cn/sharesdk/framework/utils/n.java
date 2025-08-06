package cn.sharesdk.framework.utils;

import android.os.Build;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class n {
    public static void a(WebView webView, boolean z11) {
        if (webView != null) {
            try {
                webView.getSettings().setAllowFileAccess(z11);
                webView.getSettings().setSavePassword(z11);
                if (Build.VERSION.SDK_INT >= 16) {
                    webView.getSettings().setAllowFileAccessFromFileURLs(z11);
                    webView.getSettings().setAllowUniversalAccessFromFileURLs(z11);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public static void a(WebSettings webSettings, boolean z11) {
        if (webSettings != null) {
            try {
                String a11 = i.a("opxLWrBMJweIF1SCwqo+hR2cd4CvxbDxONkTFgKvZMc=");
                if (!TextUtils.isEmpty(a11)) {
                    webSettings.getClass().getMethod(a11, new Class[]{Boolean.TYPE}).invoke(webSettings, new Object[]{Boolean.valueOf(z11)});
                }
                SSDKLog.b().b("wvs");
            } catch (Throwable th2) {
                SSDKLog.b().c(th2);
            }
        }
    }
}
