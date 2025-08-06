package org.commonmark.internal.util;

import java.nio.charset.Charset;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Escaping {

    /* renamed from: a  reason: collision with root package name */
    public static final Pattern f59747a = Pattern.compile("[\\\\&]");

    /* renamed from: b  reason: collision with root package name */
    public static final Pattern f59748b = Pattern.compile("\\\\[!\"#$%&'()*+,./:;<=>?@\\[\\\\\\]^_`{|}~-]|&(?:#x[a-f0-9]{1,6}|#[0-9]{1,7}|[a-z][a-z0-9]{1,31});", 2);

    /* renamed from: c  reason: collision with root package name */
    public static final Pattern f59749c = Pattern.compile("(%[a-fA-F0-9]{0,2}|[^:/?#@!$&'()*+,;=a-zA-Z0-9\\-._~])");

    /* renamed from: d  reason: collision with root package name */
    public static final char[] f59750d = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

    /* renamed from: e  reason: collision with root package name */
    public static final Pattern f59751e = Pattern.compile("[ \t\r\n]+");

    /* renamed from: f  reason: collision with root package name */
    public static final c f59752f = new a();

    /* renamed from: g  reason: collision with root package name */
    public static final c f59753g = new b();

    public static class a implements c {
        public void a(String str, StringBuilder sb2) {
            if (str.charAt(0) == '\\') {
                sb2.append(str, 1, str.length());
            } else {
                sb2.append(Html5Entities.a(str));
            }
        }
    }

    public static class b implements c {
        public void a(String str, StringBuilder sb2) {
            if (!str.startsWith("%")) {
                for (byte b11 : str.getBytes(Charset.forName("UTF-8"))) {
                    sb2.append('%');
                    sb2.append(Escaping.f59750d[(b11 >> 4) & 15]);
                    sb2.append(Escaping.f59750d[b11 & 15]);
                }
            } else if (str.length() == 3) {
                sb2.append(str);
            } else {
                sb2.append("%25");
                sb2.append(str, 1, str.length());
            }
        }
    }

    public interface c {
        void a(String str, StringBuilder sb2);
    }

    public static String b(String str) {
        return f59751e.matcher(str.trim().toLowerCase(Locale.ROOT)).replaceAll(" ");
    }

    public static String c(String str) {
        return b(str.substring(1, str.length() - 1));
    }

    public static String d(Pattern pattern, String str, c cVar) {
        Matcher matcher = pattern.matcher(str);
        if (!matcher.find()) {
            return str;
        }
        StringBuilder sb2 = new StringBuilder(str.length() + 16);
        int i11 = 0;
        do {
            sb2.append(str, i11, matcher.start());
            cVar.a(matcher.group(), sb2);
            i11 = matcher.end();
        } while (matcher.find());
        if (i11 != str.length()) {
            sb2.append(str, i11, str.length());
        }
        return sb2.toString();
    }

    public static String e(String str) {
        return f59747a.matcher(str).find() ? d(f59748b, str, f59752f) : str;
    }
}
