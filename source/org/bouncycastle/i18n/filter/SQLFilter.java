package org.bouncycastle.i18n.filter;

public class SQLFilter implements Filter {
    public String doFilter(String str) {
        String str2;
        int i11;
        StringBuffer stringBuffer = new StringBuffer(str);
        int i12 = 0;
        while (i12 < stringBuffer.length()) {
            char charAt = stringBuffer.charAt(i12);
            if (charAt == 10) {
                i11 = i12 + 1;
                str2 = "\\n";
            } else if (charAt == 13) {
                i11 = i12 + 1;
                str2 = "\\r";
            } else if (charAt == '\"') {
                i11 = i12 + 1;
                str2 = "\\\"";
            } else if (charAt == '\'') {
                i11 = i12 + 1;
                str2 = "\\'";
            } else if (charAt == '-') {
                i11 = i12 + 1;
                str2 = "\\-";
            } else if (charAt == '/') {
                i11 = i12 + 1;
                str2 = "\\/";
            } else if (charAt == ';') {
                i11 = i12 + 1;
                str2 = "\\;";
            } else if (charAt == '=') {
                i11 = i12 + 1;
                str2 = "\\=";
            } else if (charAt != '\\') {
                i12++;
            } else {
                i11 = i12 + 1;
                str2 = "\\\\";
            }
            stringBuffer.replace(i12, i11, str2);
            i12 = i11;
            i12++;
        }
        return stringBuffer.toString();
    }

    public String doFilterUrl(String str) {
        return doFilter(str);
    }
}
