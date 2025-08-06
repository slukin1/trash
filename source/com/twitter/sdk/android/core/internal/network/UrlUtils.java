package com.twitter.sdk.android.core.internal.network;

import android.text.TextUtils;
import com.huawei.hms.framework.common.ContainerUtils;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.TreeMap;

public final class UrlUtils {
    public static final String UTF8 = "UTF8";

    private UrlUtils() {
    }

    public static TreeMap<String, String> getQueryParams(URI uri, boolean z11) {
        return getQueryParams(uri.getRawQuery(), z11);
    }

    public static String percentEncode(String str) {
        int i11;
        if (str == null) {
            return "";
        }
        StringBuilder sb2 = new StringBuilder();
        String urlEncode = urlEncode(str);
        int length = urlEncode.length();
        int i12 = 0;
        while (i12 < length) {
            char charAt = urlEncode.charAt(i12);
            if (charAt == '*') {
                sb2.append("%2A");
            } else if (charAt == '+') {
                sb2.append("%20");
            } else if (charAt == '%' && (i11 = i12 + 2) < length && urlEncode.charAt(i12 + 1) == '7' && urlEncode.charAt(i11) == 'E') {
                sb2.append('~');
                i12 = i11;
            } else {
                sb2.append(charAt);
            }
            i12++;
        }
        return sb2.toString();
    }

    public static String urlDecode(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLDecoder.decode(str, UTF8);
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException(e11.getMessage(), e11);
        }
    }

    public static String urlEncode(String str) {
        if (str == null) {
            return "";
        }
        try {
            return URLEncoder.encode(str, UTF8);
        } catch (UnsupportedEncodingException e11) {
            throw new RuntimeException(e11.getMessage(), e11);
        }
    }

    public static TreeMap<String, String> getQueryParams(String str, boolean z11) {
        TreeMap<String, String> treeMap = new TreeMap<>();
        if (str == null) {
            return treeMap;
        }
        for (String split : str.split(ContainerUtils.FIELD_DELIMITER)) {
            String[] split2 = split.split(ContainerUtils.KEY_VALUE_DELIMITER);
            if (split2.length == 2) {
                if (z11) {
                    treeMap.put(urlDecode(split2[0]), urlDecode(split2[1]));
                } else {
                    treeMap.put(split2[0], split2[1]);
                }
            } else if (!TextUtils.isEmpty(split2[0])) {
                if (z11) {
                    treeMap.put(urlDecode(split2[0]), "");
                } else {
                    treeMap.put(split2[0], "");
                }
            }
        }
        return treeMap;
    }
}
