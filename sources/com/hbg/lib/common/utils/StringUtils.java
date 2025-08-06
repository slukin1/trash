package com.hbg.lib.common.utils;

import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.Patterns;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huochat.community.network.domain.DomainTool;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import i6.d;
import i6.m;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.regex.Pattern;

public class StringUtils {

    /* renamed from: a  reason: collision with root package name */
    public static Pattern f67488a = Pattern.compile("\t|\r|\n");

    /* renamed from: b  reason: collision with root package name */
    public static Pattern f67489b = Pattern.compile("^[a-zA-Z]{1}.{7,31}$");

    /* renamed from: c  reason: collision with root package name */
    public static int f67490c = 11;

    /* renamed from: d  reason: collision with root package name */
    public static int f67491d = 2;

    public static int a(String str, String str2) {
        int min = Math.min(str.length(), str2.length());
        int i11 = 0;
        for (int i12 = 0; i12 < min; i12++) {
            if (str.charAt(i12) != str2.charAt(i12)) {
                i11++;
            }
        }
        return i11;
    }

    public static String b(String str) {
        try {
            return URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e11) {
            d.g(e11);
            return str;
        }
    }

    public static boolean c(String str, String str2) {
        if (!q(str) || !q(str2)) {
            return false;
        }
        return str.equalsIgnoreCase(str2);
    }

    public static String d(String str, CharSequence... charSequenceArr) {
        for (int i11 = 0; i11 < charSequenceArr.length; i11++) {
            str = str.replace(String.format(Locale.US, "{{%d}}", new Object[]{Integer.valueOf(i11)}), charSequenceArr[i11]);
        }
        return str;
    }

    public static String e(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        try {
            String substring = str.substring(0, 1);
            return str.replace(substring, substring.toUpperCase());
        } catch (Exception e11) {
            e11.printStackTrace();
            return str;
        }
    }

    public static SpannableStringBuilder f(String str, char c11, char c12, int i11) {
        char c13;
        StringBuffer stringBuffer = new StringBuffer();
        int i12 = -1;
        int i13 = -1;
        for (int i14 = 0; i14 < str.length(); i14++) {
            char charAt = str.charAt(i14);
            char c14 = ' ';
            if (charAt == c11 && i13 == -1) {
                i13 = i14;
                c13 = ' ';
            } else {
                c13 = charAt;
            }
            if (charAt == c12 && i12 == -1) {
                i12 = i14;
            } else {
                c14 = c13;
            }
            stringBuffer.append(c14);
        }
        if (i12 <= i13 || i12 > stringBuffer.length()) {
            return new SpannableStringBuilder(str);
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(stringBuffer.toString());
        spannableStringBuilder.setSpan(new ForegroundColorSpan(i11), i13, i12, 34);
        return spannableStringBuilder;
    }

    public static String g(String str) {
        return h(str, "");
    }

    public static String h(String str, String str2) {
        return str != null ? str.toLowerCase(Locale.US) : str2;
    }

    public static String i(String str) {
        return j(str, "");
    }

    public static String j(String str, String str2) {
        return str != null ? str.toUpperCase(Locale.US) : str2;
    }

    public static int k(String str) {
        if (str == null) {
            return 0;
        }
        try {
            if (str.length() < 8) {
                return 0;
            }
            int t11 = t("[0-9]+", str);
            if (t("[a-zA-Z]+", str)) {
                t11++;
            }
            if (t("[!@#$%^&*?_~-£(,)]+", str)) {
                return t11 + 1;
            }
            return t11;
        } catch (Exception e11) {
            e11.printStackTrace();
            return 0;
        }
    }

    public static HashMap<String, String> l(String str) {
        try {
            HashMap<String, String> hashMap = new HashMap<>(10);
            for (String split : str.split("\\&")) {
                String[] split2 = split.split(ContainerUtils.KEY_VALUE_DELIMITER);
                if (split2[0] != null) {
                    if (split2[0].equals("url") && str.contains("(") && str.contains(")")) {
                        hashMap.put(URLDecoder.decode(split2[0], "UTF-8"), URLDecoder.decode((String) str.subSequence(str.indexOf("(") + 1, str.indexOf(")")), "UTF-8"));
                    }
                }
                hashMap.put(URLDecoder.decode(split2[0], "UTF-8"), URLDecoder.decode(split2[1], "UTF-8"));
            }
            return hashMap;
        } catch (Exception e11) {
            e11.printStackTrace();
            return null;
        }
    }

    @Deprecated
    public static String m(HashMap<String, String> hashMap, String str) {
        if (hashMap == null) {
            return "";
        }
        try {
            if (hashMap.size() <= 0) {
                return "";
            }
            if (p(str)) {
                return "";
            }
            String str2 = hashMap.get(str);
            if (str2 == null) {
                str2 = "";
            }
            if ("image".equals(str)) {
                if (str2.startsWith("(")) {
                    str2 = str2.substring(1, str2.length());
                }
                if (str2.endsWith(")")) {
                    str2 = str2.substring(0, str2.length() - 1);
                }
            }
            return str2;
        } catch (Exception e11) {
            e11.printStackTrace();
            return "";
        }
    }

    public static boolean n(String str) {
        if (!o(str) && !m.Y(str)) {
            return true;
        }
        return false;
    }

    public static boolean o(String str) {
        try {
            return Patterns.EMAIL_ADDRESS.matcher(str).matches();
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static boolean p(String str) {
        return str == null || "".equals(str);
    }

    public static boolean q(String str) {
        return str != null && !"".equals(str);
    }

    public static boolean r(String str) {
        return str == null || str.trim().length() == 0;
    }

    @Deprecated
    public static boolean s(String str) {
        return f67489b.matcher(str).matches();
    }

    public static boolean t(String str, String str2) {
        try {
            return Pattern.compile(str).matcher(str2).find();
        } catch (Exception e11) {
            e11.printStackTrace();
            return false;
        }
    }

    public static String u(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        if (n(str)) {
            return v(str);
        }
        StringBuilder sb2 = new StringBuilder();
        if (o(str)) {
            String[] split = str.split(TIMMentionEditText.TIM_MENTION_TAG);
            if (split.length < 1) {
                return str;
            }
            if (split[0].length() > 3 || split[0].length() < 1) {
                sb2.append(str.substring(0, 3));
            } else {
                sb2.append(str.substring(0, 1));
            }
            sb2.append("****");
            sb2.append(split[1]);
        } else if (str.length() >= 5) {
            if (str.length() % 2 == 0) {
                if (str.length() == 6) {
                    String substring = str.substring(0, 1);
                    String substring2 = str.substring(5);
                    sb2.append(substring);
                    sb2.append("****");
                    sb2.append(substring2);
                } else if (str.length() == 8) {
                    String substring3 = str.substring(0, 2);
                    String substring4 = str.substring(6);
                    sb2.append(substring3);
                    sb2.append("****");
                    sb2.append(substring4);
                } else if (str.length() == 10) {
                    String substring5 = str.substring(0, 3);
                    String substring6 = str.substring(7);
                    sb2.append(substring5);
                    sb2.append("****");
                    sb2.append(substring6);
                }
            } else if (str.length() == 5) {
                sb2.append(str.substring(0, 1));
                sb2.append("****");
            } else if (str.length() == 7) {
                String substring7 = str.substring(0, 2);
                String substring8 = str.substring(6);
                sb2.append(substring7);
                sb2.append("****");
                sb2.append(substring8);
            } else if (str.length() == 9 || str.length() == 11) {
                String substring9 = str.substring(0, 3);
                String substring10 = str.substring(7);
                sb2.append(substring9);
                sb2.append("****");
                sb2.append(substring10);
            }
        }
        return sb2.toString();
    }

    public static String v(String str) {
        if (TextUtils.isEmpty(str) || str.length() < 6) {
            return str;
        }
        int length = str.length();
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str, 0, 3);
        sb2.append("****");
        sb2.append(str, length - 2, length);
        return sb2.toString();
    }

    public static String w(String str) {
        return (!TextUtils.isEmpty(str) && str.startsWith(DomainTool.DOMAIN_PREFIX_HTTP)) ? str.replaceFirst(DomainTool.DOMAIN_PREFIX_HTTP, DomainTool.DOMAIN_PREFIX) : str;
    }
}
