package com.huobi.utils;

import android.net.Uri;
import android.text.TextUtils;
import com.blankj.utilcode.util.x;
import com.twitter.sdk.android.core.identity.AuthHandler;
import zn.a;

public final class t0 {

    /* renamed from: a  reason: collision with root package name */
    public static String f83779a;

    public static String a() {
        return f83779a;
    }

    public static boolean b(String str) {
        try {
            Uri parse = Uri.parse(str);
            String scheme = parse.getScheme();
            String str2 = parse.getHost() + parse.getPath();
            String queryParameter = parse.getQueryParameter("tsvToken");
            String queryParameter2 = parse.getQueryParameter(AuthHandler.EXTRA_TOKEN_SECRET);
            String queryParameter3 = parse.getQueryParameter("sign");
            if (!"holigeit".equalsIgnoreCase(scheme) || !"v1/open/face-authentication".equalsIgnoreCase(str2) || TextUtils.isEmpty(queryParameter) || TextUtils.isEmpty(queryParameter2) || TextUtils.isEmpty(queryParameter3)) {
                return false;
            }
            return true;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            Uri parse = Uri.parse(str);
            if (parse != null) {
                String scheme = parse.getScheme();
                String host = parse.getHost();
                String path = parse.getPath();
                f83779a = parse.getQueryParameter("code");
                if (!TextUtils.equals(scheme, "holigeit") || !TextUtils.equals(host, "v1") || !TextUtils.equals(path, "/open/scan-login") || TextUtils.isEmpty(f83779a)) {
                    return false;
                }
                return true;
            }
        } catch (Exception unused) {
        }
        return false;
    }

    public static boolean d(String str) {
        if (x.d(str)) {
            return false;
        }
        if (str.startsWith("http") || a.d().j(Uri.parse(str))) {
            return true;
        }
        return false;
    }
}
