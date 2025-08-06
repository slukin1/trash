package com.google.android.gms.common.util;

import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

final class zzc {
    private static final Pattern zza = Pattern.compile("\\\\u[0-9a-fA-F]{4}");

    public static String zza(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        Matcher matcher = zza.matcher(str);
        StringBuilder sb2 = null;
        int i11 = 0;
        while (matcher.find()) {
            if (sb2 == null) {
                sb2 = new StringBuilder();
            }
            int start = matcher.start();
            int i12 = start;
            while (i12 >= 0 && str.charAt(i12) == '\\') {
                i12--;
            }
            if ((start - i12) % 2 != 0) {
                int parseInt = Integer.parseInt(matcher.group().substring(2), 16);
                sb2.append(str, i11, matcher.start());
                if (parseInt == 92) {
                    sb2.append("\\\\");
                } else {
                    sb2.append(Character.toChars(parseInt));
                }
                i11 = matcher.end();
            }
        }
        if (sb2 == null) {
            return str;
        }
        if (i11 < matcher.regionEnd()) {
            sb2.append(str, i11, matcher.regionEnd());
        }
        return sb2.toString();
    }
}
