package cn.sharesdk.line.utils;

import android.net.Uri;
import java.util.LinkedHashMap;
import java.util.Map;

public final class g {
    public static Uri.Builder a(Uri uri, String... strArr) {
        Uri.Builder buildUpon = uri.buildUpon();
        for (String appendEncodedPath : strArr) {
            buildUpon.appendEncodedPath(appendEncodedPath);
        }
        return buildUpon;
    }

    public static Uri.Builder a(Uri.Builder builder, Map<String, String> map) {
        for (Map.Entry next : map.entrySet()) {
            builder.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        return builder;
    }

    public static Uri a(String str, Map<String, String> map) {
        return a(Uri.parse(str), map);
    }

    public static Uri a(Uri uri, Map<String, String> map) {
        return a(a(uri, new String[0]), map).build();
    }

    public static Map<String, String> a(String... strArr) {
        if (strArr.length % 2 == 0) {
            LinkedHashMap linkedHashMap = new LinkedHashMap();
            for (int i11 = 0; i11 < strArr.length; i11 += 2) {
                linkedHashMap.put(strArr[i11], strArr[i11 + 1]);
            }
            return linkedHashMap;
        }
        throw new IllegalArgumentException("Odd number of key and Value");
    }
}
