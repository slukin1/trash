package com.alibaba.android.arouter.utils;

import android.net.Uri;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class TextUtils {
    public static String a(StackTraceElement[] stackTraceElementArr) {
        StringBuilder sb2 = new StringBuilder();
        for (StackTraceElement stackTraceElement : stackTraceElementArr) {
            sb2.append("    at ");
            sb2.append(stackTraceElement.toString());
            sb2.append("\n");
        }
        return sb2.toString();
    }

    public static String b(String str) {
        return (!str.contains(HiAnalyticsConstant.REPORT_VAL_SEPARATOR) || str.endsWith(HiAnalyticsConstant.REPORT_VAL_SEPARATOR)) ? str : str.substring(0, str.indexOf(HiAnalyticsConstant.REPORT_VAL_SEPARATOR));
    }

    public static boolean c(CharSequence charSequence) {
        return charSequence == null || charSequence.length() == 0;
    }

    public static Map<String, String> d(Uri uri) {
        String str;
        String encodedQuery = uri.getEncodedQuery();
        if (encodedQuery == null) {
            return Collections.emptyMap();
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        int i11 = 0;
        do {
            int indexOf = encodedQuery.indexOf(38, i11);
            if (indexOf == -1) {
                indexOf = encodedQuery.length();
            }
            int indexOf2 = encodedQuery.indexOf(61, i11);
            if (indexOf2 > indexOf || indexOf2 == -1) {
                indexOf2 = indexOf;
            }
            String substring = encodedQuery.substring(i11, indexOf2);
            if (!android.text.TextUtils.isEmpty(substring)) {
                if (indexOf2 == indexOf) {
                    str = "";
                } else {
                    str = encodedQuery.substring(indexOf2 + 1, indexOf);
                }
                linkedHashMap.put(Uri.decode(substring), Uri.decode(str));
            }
            i11 = indexOf + 1;
        } while (i11 < encodedQuery.length());
        return Collections.unmodifiableMap(linkedHashMap);
    }
}
