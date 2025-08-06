package com.twitter.sdk.android.core.internal;

import android.net.Uri;
import android.os.Build;
import java.text.Normalizer;

public class TwitterApi {
    public static final String BASE_HOST = "api.twitter.com";
    public static final String BASE_HOST_URL = "https://api.twitter.com";
    private final String baseHostUrl;

    public TwitterApi() {
        this(BASE_HOST_URL);
    }

    public static String buildUserAgent(String str, String str2) {
        StringBuilder sb2 = new StringBuilder(str);
        sb2.append('/');
        sb2.append(str2);
        sb2.append(' ');
        String str3 = Build.MODEL;
        sb2.append(str3);
        sb2.append('/');
        sb2.append(Build.VERSION.RELEASE);
        sb2.append(" (");
        sb2.append(Build.MANUFACTURER);
        sb2.append(';');
        sb2.append(str3);
        sb2.append(';');
        sb2.append(Build.BRAND);
        sb2.append(';');
        sb2.append(Build.PRODUCT);
        sb2.append(')');
        return normalizeString(sb2.toString());
    }

    public static String normalizeString(String str) {
        return stripNonAscii(Normalizer.normalize(str, Normalizer.Form.NFD));
    }

    public static String stripNonAscii(String str) {
        StringBuilder sb2 = new StringBuilder(str.length());
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (charAt > 31 && charAt < 127) {
                sb2.append(charAt);
            }
        }
        return sb2.toString();
    }

    public Uri.Builder buildUponBaseHostUrl(String... strArr) {
        Uri.Builder buildUpon = Uri.parse(getBaseHostUrl()).buildUpon();
        if (strArr != null) {
            for (String appendPath : strArr) {
                buildUpon.appendPath(appendPath);
            }
        }
        return buildUpon;
    }

    public String getBaseHostUrl() {
        return this.baseHostUrl;
    }

    public TwitterApi(String str) {
        this.baseHostUrl = str;
    }
}
