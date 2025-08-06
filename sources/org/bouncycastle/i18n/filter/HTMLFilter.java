package org.bouncycastle.i18n.filter;

public class HTMLFilter implements Filter {
    public String doFilter(String str) {
        String str2;
        int i11;
        StringBuffer stringBuffer = new StringBuffer(str);
        int i12 = 0;
        while (i12 < stringBuffer.length()) {
            char charAt = stringBuffer.charAt(i12);
            if (charAt == '\"') {
                i11 = i12 + 1;
                str2 = "&#34";
            } else if (charAt == '#') {
                i11 = i12 + 1;
                str2 = "&#35";
            } else if (charAt == '+') {
                i11 = i12 + 1;
                str2 = "&#43";
            } else if (charAt == '-') {
                i11 = i12 + 1;
                str2 = "&#45";
            } else if (charAt == '>') {
                i11 = i12 + 1;
                str2 = "&#62";
            } else if (charAt == ';') {
                i11 = i12 + 1;
                str2 = "&#59";
            } else if (charAt != '<') {
                switch (charAt) {
                    case '%':
                        i11 = i12 + 1;
                        str2 = "&#37";
                        break;
                    case '&':
                        i11 = i12 + 1;
                        str2 = "&#38";
                        break;
                    case '\'':
                        i11 = i12 + 1;
                        str2 = "&#39";
                        break;
                    case '(':
                        i11 = i12 + 1;
                        str2 = "&#40";
                        break;
                    case ')':
                        i11 = i12 + 1;
                        str2 = "&#41";
                        break;
                    default:
                        i12 -= 3;
                        continue;
                }
            } else {
                i11 = i12 + 1;
                str2 = "&#60";
            }
            stringBuffer.replace(i12, i11, str2);
            i12 += 4;
        }
        return stringBuffer.toString();
    }

    public String doFilterUrl(String str) {
        return doFilter(str);
    }
}
