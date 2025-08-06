package cn.sharesdk.line.utils;

import android.net.Uri;
import cn.sharesdk.line.utils.LineAuthenticationConfig;

public final class b {
    public static LineAuthenticationConfig a(String str, boolean z11) {
        LineAuthenticationConfig.a c11 = new LineAuthenticationConfig.a(str).a(Uri.parse("https://access.line.me/.well-known/openid-configuration")).b(Uri.parse("https://api.line.me/")).c(Uri.parse("https://access.line.me/oauth2/v2.1/login"));
        if (z11) {
            c11.a();
        }
        return c11.b();
    }
}
