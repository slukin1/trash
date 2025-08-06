package com.huobi.vulcan.utils.riskinfo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReUtils {
    public static boolean a(String str, String str2) {
        return Pattern.compile(str2).matcher(str).find();
    }

    public static String b(String str, String str2, int i11) {
        Matcher matcher = Pattern.compile(str2, 32).matcher(str);
        if (matcher.find()) {
            return matcher.group(i11);
        }
        return null;
    }
}
