package org.bouncycastle.asn1.x509;

public class X509NameTokenizer {
    private StringBuffer buf;
    private int index;
    private char separator;
    private String value;

    public X509NameTokenizer(String str) {
        this(str, ',');
    }

    public X509NameTokenizer(String str, char c11) {
        this.buf = new StringBuffer();
        this.value = str;
        this.index = -1;
        this.separator = c11;
    }

    public boolean hasMoreTokens() {
        return this.index != this.value.length();
    }

    public String nextToken() {
        if (this.index == this.value.length()) {
            return null;
        }
        int i11 = this.index + 1;
        this.buf.setLength(0);
        boolean z11 = false;
        boolean z12 = false;
        while (i11 != this.value.length()) {
            char charAt = this.value.charAt(i11);
            if (charAt == '\"') {
                if (!z11) {
                    z12 = !z12;
                }
            } else if (!z11 && !z12) {
                if (charAt == '\\') {
                    this.buf.append(charAt);
                    z11 = true;
                } else if (charAt == this.separator) {
                    break;
                } else {
                    this.buf.append(charAt);
                }
                i11++;
            }
            this.buf.append(charAt);
            z11 = false;
            i11++;
        }
        this.index = i11;
        return this.buf.toString();
    }
}
