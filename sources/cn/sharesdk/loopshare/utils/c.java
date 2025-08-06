package cn.sharesdk.loopshare.utils;

import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.adjust.sdk.Constants;

public class c {
    /* JADX WARNING: Code restructure failed: missing block: B:1:0x0002, code lost:
        r2 = r2.getData();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(android.content.Intent r2) {
        /*
            if (r2 == 0) goto L_0x000d
            android.net.Uri r2 = r2.getData()
            if (r2 == 0) goto L_0x000d
            java.lang.String r2 = r2.getPath()
            goto L_0x000e
        L_0x000d:
            r2 = 0
        L_0x000e:
            if (r2 != 0) goto L_0x0012
            java.lang.String r2 = ""
        L_0x0012:
            java.lang.String r0 = "/"
            boolean r0 = r2.startsWith(r0)
            if (r0 == 0) goto L_0x0023
            r0 = 1
            int r1 = r2.length()
            java.lang.String r2 = r2.substring(r0, r1)
        L_0x0023:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: cn.sharesdk.loopshare.utils.c.a(android.content.Intent):java.lang.String");
    }

    public static boolean b(Intent intent) {
        if (intent == null) {
            return false;
        }
        return b(intent.getData());
    }

    public static String c(Uri uri) {
        String uri2 = uri != null ? uri.toString() : null;
        return uri2 == null ? "" : uri2;
    }

    public static boolean d(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        String path = uri.getPath();
        if (("http".equals(scheme) || Constants.SCHEME.equals(scheme)) && !TextUtils.isEmpty(path)) {
            return true;
        }
        return false;
    }

    public static boolean e(Uri uri) {
        if (uri == null) {
            return false;
        }
        String scheme = uri.getScheme();
        String queryParameter = uri.getQueryParameter("params");
        String queryParameter2 = uri.getQueryParameter("data");
        if (TextUtils.isEmpty(scheme)) {
            return false;
        }
        if (!TextUtils.isEmpty(queryParameter) || !TextUtils.isEmpty(queryParameter2)) {
            return true;
        }
        return false;
    }

    public static String c(Intent intent) {
        Uri data;
        if (intent == null || (data = intent.getData()) == null) {
            return null;
        }
        return data.getScheme();
    }

    public static boolean b(Uri uri) {
        return e(uri) || d(uri);
    }

    public static String a(Uri uri) {
        if (uri != null) {
            return uri.getPath();
        }
        return null;
    }

    public static boolean a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        Uri parse = Uri.parse(str);
        if (d(parse) || e(parse)) {
            return true;
        }
        return false;
    }
}
