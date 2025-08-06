package com.huobi.vulcan.utils;

import android.text.TextUtils;
import com.iproov.sdk.bridge.OptionsBridge;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f20615a = Pattern.compile("^([\\w|\\s|\\(|\\)|\\[|\\]|\\{|\\}|=|-]+)\\.?([\\w|\\s|\\(|\\)|\\[|\\]|\\{|\\}|=|-]+)?\\.?([\\w|\\s|\\(|\\)|\\[|\\]|\\{|\\}|=|-]+)?\\.?.*$");

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f20616b = Pattern.compile("\\d+");

    public static String a(String str) {
        if (str == null || str.length() <= 0) {
            return "";
        }
        Matcher matcher = f20615a.matcher(str);
        StringBuilder sb2 = new StringBuilder();
        if (!matcher.matches()) {
            return "";
        }
        String b11 = b(matcher.group(1));
        String b12 = b(matcher.group(2));
        String b13 = b(matcher.group(3));
        if (b11 == null) {
            b11 = "0";
        }
        sb2.append(b11);
        sb2.append('.');
        if (b12 == null) {
            b12 = "0";
        }
        sb2.append(b12);
        sb2.append('.');
        if (b13 == null) {
            b13 = "0";
        }
        sb2.append(b13);
        return sb2.toString();
    }

    public static String b(String str) {
        if (str == null || str.length() <= 0) {
            return null;
        }
        Matcher matcher = f20616b.matcher(str);
        if (matcher.find()) {
            return matcher.group(0);
        }
        return null;
    }

    public static String c(long j11, String str) {
        try {
            return new SimpleDateFormat(str).format(Long.valueOf(new Date(j11).getTime()));
        } catch (Exception e11) {
            LogUtils.b(e11);
            return "";
        }
    }

    public static boolean d(CharSequence charSequence) {
        return e(charSequence, false);
    }

    public static boolean e(CharSequence charSequence, boolean z11) {
        if (z11 && charSequence != null) {
            charSequence = String.valueOf(charSequence).trim();
        }
        return TextUtils.isEmpty(charSequence) || OptionsBridge.NULL_VALUE.equalsIgnoreCase(charSequence.toString());
    }

    public static boolean f(CharSequence charSequence) {
        return !d(charSequence);
    }
}
