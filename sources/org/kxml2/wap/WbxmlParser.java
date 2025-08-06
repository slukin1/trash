package org.kxml2.wap;

import com.tencent.thumbplayer.tcmedia.core.common.TPCodecParamers;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.Hashtable;
import java.util.Vector;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class WbxmlParser implements XmlPullParser {
    public int A;
    public int B;
    public boolean C;
    public boolean D;
    public String E;

    /* renamed from: b  reason: collision with root package name */
    public InputStream f25529b;

    /* renamed from: c  reason: collision with root package name */
    public int f25530c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f25531d = 1;

    /* renamed from: e  reason: collision with root package name */
    public int f25532e = 2;

    /* renamed from: f  reason: collision with root package name */
    public String[] f25533f;

    /* renamed from: g  reason: collision with root package name */
    public String[] f25534g;

    /* renamed from: h  reason: collision with root package name */
    public String[] f25535h;

    /* renamed from: i  reason: collision with root package name */
    public byte[] f25536i;

    /* renamed from: j  reason: collision with root package name */
    public Hashtable f25537j = null;

    /* renamed from: k  reason: collision with root package name */
    public boolean f25538k;

    /* renamed from: l  reason: collision with root package name */
    public int f25539l;

    /* renamed from: m  reason: collision with root package name */
    public String[] f25540m = new String[16];

    /* renamed from: n  reason: collision with root package name */
    public String[] f25541n = new String[8];

    /* renamed from: o  reason: collision with root package name */
    public int[] f25542o = new int[4];

    /* renamed from: p  reason: collision with root package name */
    public int f25543p;

    /* renamed from: q  reason: collision with root package name */
    public String[] f25544q = new String[16];

    /* renamed from: r  reason: collision with root package name */
    public int f25545r = -2;

    /* renamed from: s  reason: collision with root package name */
    public Vector f25546s = new Vector();

    /* renamed from: t  reason: collision with root package name */
    public int f25547t;

    /* renamed from: u  reason: collision with root package name */
    public int f25548u;

    /* renamed from: v  reason: collision with root package name */
    public String f25549v;

    /* renamed from: w  reason: collision with root package name */
    public String f25550w;

    /* renamed from: x  reason: collision with root package name */
    public String f25551x;

    /* renamed from: y  reason: collision with root package name */
    public String f25552y;

    /* renamed from: z  reason: collision with root package name */
    public Object f25553z;

    public final boolean a() throws XmlPullParserException {
        int i11;
        String str;
        int i12 = 0;
        boolean z11 = false;
        while (true) {
            i11 = this.f25543p;
            if (i12 >= (i11 << 2)) {
                break;
            }
            String str2 = this.f25544q[i12 + 2];
            int indexOf = str2.indexOf(58);
            if (indexOf != -1) {
                String substring = str2.substring(0, indexOf);
                str = str2.substring(indexOf + 1);
                str2 = substring;
            } else if (str2.equals("xmlns")) {
                str = null;
            } else {
                i12 += 4;
            }
            if (!str2.equals("xmlns")) {
                z11 = true;
            } else {
                int[] iArr = this.f25542o;
                int i13 = this.f25539l;
                int i14 = iArr[i13];
                iArr[i13] = i14 + 1;
                int i15 = i14 << 1;
                String[] b11 = b(this.f25541n, i15 + 2);
                this.f25541n = b11;
                b11[i15] = str;
                String[] strArr = this.f25544q;
                int i16 = i12 + 3;
                b11[i15 + 1] = strArr[i16];
                if (str != null && strArr[i16].equals("")) {
                    c("illegal empty namespace");
                }
                String[] strArr2 = this.f25544q;
                int i17 = this.f25543p - 1;
                this.f25543p = i17;
                System.arraycopy(strArr2, i12 + 4, strArr2, i12, (i17 << 2) - i12);
                i12 -= 4;
            }
            i12 += 4;
        }
        if (z11) {
            int i18 = (i11 << 2) - 4;
            while (i18 >= 0) {
                int i19 = i18 + 2;
                String str3 = this.f25544q[i19];
                int indexOf2 = str3.indexOf(58);
                if (indexOf2 != 0) {
                    if (indexOf2 != -1) {
                        String substring2 = str3.substring(0, indexOf2);
                        String substring3 = str3.substring(indexOf2 + 1);
                        String namespace = getNamespace(substring2);
                        if (namespace != null) {
                            String[] strArr3 = this.f25544q;
                            strArr3[i18] = namespace;
                            strArr3[i18 + 1] = substring2;
                            strArr3[i19] = substring3;
                            for (int i21 = (this.f25543p << 2) - 4; i21 > i18; i21 -= 4) {
                                if (substring3.equals(this.f25544q[i21 + 2]) && namespace.equals(this.f25544q[i21])) {
                                    StringBuffer stringBuffer = new StringBuffer();
                                    stringBuffer.append("Duplicate Attribute: {");
                                    stringBuffer.append(namespace);
                                    stringBuffer.append("}");
                                    stringBuffer.append(substring3);
                                    c(stringBuffer.toString());
                                }
                            }
                        } else {
                            StringBuffer stringBuffer2 = new StringBuffer();
                            stringBuffer2.append("Undefined Prefix: ");
                            stringBuffer2.append(substring2);
                            stringBuffer2.append(" in ");
                            stringBuffer2.append(this);
                            throw new RuntimeException(stringBuffer2.toString());
                        }
                    }
                    i18 -= 4;
                } else {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("illegal attribute name: ");
                    stringBuffer3.append(str3);
                    stringBuffer3.append(" at ");
                    stringBuffer3.append(this);
                    throw new RuntimeException(stringBuffer3.toString());
                }
            }
        }
        int indexOf3 = this.f25551x.indexOf(58);
        if (indexOf3 == 0) {
            StringBuffer stringBuffer4 = new StringBuffer();
            stringBuffer4.append("illegal tag name: ");
            stringBuffer4.append(this.f25551x);
            c(stringBuffer4.toString());
        } else if (indexOf3 != -1) {
            this.f25549v = this.f25551x.substring(0, indexOf3);
            this.f25551x = this.f25551x.substring(indexOf3 + 1);
        }
        String namespace2 = getNamespace(this.f25549v);
        this.f25550w = namespace2;
        if (namespace2 == null) {
            if (this.f25549v != null) {
                StringBuffer stringBuffer5 = new StringBuffer();
                stringBuffer5.append("undefined prefix: ");
                stringBuffer5.append(this.f25549v);
                c(stringBuffer5.toString());
            }
            this.f25550w = "";
        }
        return z11;
    }

    public final String[] b(String[] strArr, int i11) {
        if (strArr.length >= i11) {
            return strArr;
        }
        String[] strArr2 = new String[(i11 + 16)];
        System.arraycopy(strArr, 0, strArr2, 0, strArr.length);
        return strArr2;
    }

    public final void c(String str) throws XmlPullParserException {
        throw new XmlPullParserException(str, this, (Throwable) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0054, code lost:
        r4.B = 64;
        r4.A = r0;
        r4.f25553z = f(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void d() throws java.io.IOException, org.xmlpull.v1.XmlPullParserException {
        /*
            r4 = this;
            int r0 = r4.B
            r1 = 3
            r2 = 1
            if (r0 != r1) goto L_0x000b
            int r0 = r4.f25539l
            int r0 = r0 - r2
            r4.f25539l = r0
        L_0x000b:
            boolean r0 = r4.C
            if (r0 == 0) goto L_0x0015
            r4.B = r1
            r0 = 0
            r4.C = r0
            return
        L_0x0015:
            r0 = 0
            r4.f25552y = r0
            r4.f25549v = r0
            r4.f25551x = r0
        L_0x001c:
            int r0 = r4.g()
            r3 = -2
            r4.f25545r = r3
            if (r0 != 0) goto L_0x002d
            int r0 = r4.i()
            r4.o(r0, r2)
            goto L_0x001c
        L_0x002d:
            r3 = -1
            if (r0 == r3) goto L_0x00af
            r3 = 2
            if (r0 == r2) goto L_0x0097
            if (r0 == r3) goto L_0x006a
            r2 = 4
            if (r0 == r1) goto L_0x0061
            switch(r0) {
                case 64: goto L_0x0054;
                case 65: goto L_0x0054;
                case 66: goto L_0x0054;
                case 67: goto L_0x004c;
                default: goto L_0x003b;
            }
        L_0x003b:
            switch(r0) {
                case 128: goto L_0x0054;
                case 129: goto L_0x0054;
                case 130: goto L_0x0054;
                case 131: goto L_0x0045;
                default: goto L_0x003e;
            }
        L_0x003e:
            switch(r0) {
                case 192: goto L_0x0054;
                case 193: goto L_0x0054;
                case 194: goto L_0x0054;
                case 195: goto L_0x0054;
                default: goto L_0x0041;
            }
        L_0x0041:
            r4.e(r0)
            goto L_0x00b1
        L_0x0045:
            r4.B = r2
            java.lang.String r0 = r4.l()
            goto L_0x0067
        L_0x004c:
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            java.lang.String r1 = "PI curr. not supp."
            r0.<init>(r1)
            throw r0
        L_0x0054:
            r1 = 64
            r4.B = r1
            r4.A = r0
            java.lang.Object r0 = r4.f(r0)
            r4.f25553z = r0
            goto L_0x00b1
        L_0x0061:
            r4.B = r2
            java.lang.String r0 = r4.k()
        L_0x0067:
            r4.f25552y = r0
            goto L_0x00b1
        L_0x006a:
            r0 = 6
            r4.B = r0
            int r0 = r4.j()
            char r0 = (char) r0
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            java.lang.String r2 = ""
            r1.append(r2)
            r1.append(r0)
            java.lang.String r1 = r1.toString()
            r4.f25552y = r1
            java.lang.StringBuffer r1 = new java.lang.StringBuffer
            r1.<init>()
            java.lang.String r2 = "#"
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            goto L_0x00ac
        L_0x0097:
            int r0 = r4.f25539l
            int r0 = r0 - r2
            int r0 = r0 << r3
            r4.B = r1
            java.lang.String[] r1 = r4.f25540m
            r2 = r1[r0]
            r4.f25550w = r2
            int r2 = r0 + 1
            r2 = r1[r2]
            r4.f25549v = r2
            int r0 = r0 + r3
            r0 = r1[r0]
        L_0x00ac:
            r4.f25551x = r0
            goto L_0x00b1
        L_0x00af:
            r4.B = r2
        L_0x00b1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.kxml2.wap.WbxmlParser.d():void");
    }

    public void defineEntityReplacementText(String str, String str2) throws XmlPullParserException {
    }

    public void e(int i11) throws IOException, XmlPullParserException {
        this.B = 2;
        this.f25551x = m(this.f25535h, i11 & 63);
        this.f25543p = 0;
        if ((i11 & 128) != 0) {
            h();
        }
        this.C = (i11 & 64) == 0;
        int i12 = this.f25539l;
        this.f25539l = i12 + 1;
        int i13 = i12 << 2;
        String[] b11 = b(this.f25540m, i13 + 4);
        this.f25540m = b11;
        b11[i13 + 3] = this.f25551x;
        int i14 = this.f25539l;
        int[] iArr = this.f25542o;
        if (i14 >= iArr.length) {
            int[] iArr2 = new int[(i14 + 4)];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.f25542o = iArr2;
        }
        int[] iArr3 = this.f25542o;
        int i15 = this.f25539l;
        iArr3[i15] = iArr3[i15 - 1];
        for (int i16 = this.f25543p - 1; i16 > 0; i16--) {
            for (int i17 = 0; i17 < i16; i17++) {
                if (getAttributeName(i16).equals(getAttributeName(i17))) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("Duplicate Attribute: ");
                    stringBuffer.append(getAttributeName(i16));
                    c(stringBuffer.toString());
                }
            }
        }
        if (this.f25538k) {
            a();
        } else {
            this.f25550w = "";
        }
        String[] strArr = this.f25540m;
        strArr[i13] = this.f25550w;
        strArr[i13 + 1] = this.f25549v;
        strArr[i13 + 2] = this.f25551x;
    }

    public Object f(int i11) throws IOException, XmlPullParserException {
        switch (i11) {
            case 64:
            case 65:
            case 66:
                return k();
            default:
                switch (i11) {
                    case 128:
                    case 129:
                    case 130:
                        return new Integer(j());
                    default:
                        byte[] bArr = null;
                        switch (i11) {
                            case 192:
                            case 193:
                            case TPCodecParamers.TP_PROFILE_MJPEG_HUFFMAN_PROGRESSIVE_DCT /*194*/:
                                break;
                            case TPCodecParamers.TP_PROFILE_MJPEG_HUFFMAN_LOSSLESS /*195*/:
                                int j11 = j();
                                bArr = new byte[j11];
                                int i12 = j11;
                                while (i12 > 0) {
                                    i12 -= this.f25529b.read(bArr, j11 - i12, i12);
                                }
                                break;
                            default:
                                StringBuffer stringBuffer = new StringBuffer();
                                stringBuffer.append("illegal id: ");
                                stringBuffer.append(i11);
                                c(stringBuffer.toString());
                                return null;
                        }
                        return bArr;
                }
        }
    }

    public final int g() throws IOException {
        if (this.f25545r == -2) {
            this.f25545r = this.f25529b.read();
        }
        return this.f25545r;
    }

    public int getAttributeCount() {
        return this.f25543p;
    }

    public String getAttributeName(int i11) {
        if (i11 < this.f25543p) {
            return this.f25544q[(i11 << 2) + 2];
        }
        throw new IndexOutOfBoundsException();
    }

    public String getAttributeNamespace(int i11) {
        if (i11 < this.f25543p) {
            return this.f25544q[i11 << 2];
        }
        throw new IndexOutOfBoundsException();
    }

    public String getAttributePrefix(int i11) {
        if (i11 < this.f25543p) {
            return this.f25544q[(i11 << 2) + 1];
        }
        throw new IndexOutOfBoundsException();
    }

    public String getAttributeType(int i11) {
        return "CDATA";
    }

    public String getAttributeValue(int i11) {
        if (i11 < this.f25543p) {
            return this.f25544q[(i11 << 2) + 3];
        }
        throw new IndexOutOfBoundsException();
    }

    public String getAttributeValue(String str, String str2) {
        for (int i11 = (this.f25543p << 2) - 4; i11 >= 0; i11 -= 4) {
            if (this.f25544q[i11 + 2].equals(str2) && (str == null || this.f25544q[i11].equals(str))) {
                return this.f25544q[i11 + 3];
            }
        }
        return null;
    }

    public int getColumnNumber() {
        return -1;
    }

    public int getDepth() {
        return this.f25539l;
    }

    public int getEventType() throws XmlPullParserException {
        return this.B;
    }

    public boolean getFeature(String str) {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(str)) {
            return this.f25538k;
        }
        return false;
    }

    public String getInputEncoding() {
        return this.E;
    }

    public int getLineNumber() {
        return -1;
    }

    public String getName() {
        return this.f25551x;
    }

    public String getNamespace() {
        return this.f25550w;
    }

    public String getNamespace(String str) {
        if ("xml".equals(str)) {
            return "http://www.w3.org/XML/1998/namespace";
        }
        if ("xmlns".equals(str)) {
            return "http://www.w3.org/2000/xmlns/";
        }
        for (int namespaceCount = (getNamespaceCount(this.f25539l) << 1) - 2; namespaceCount >= 0; namespaceCount -= 2) {
            String[] strArr = this.f25541n;
            if (str == null) {
                if (strArr[namespaceCount] == null) {
                    return strArr[namespaceCount + 1];
                }
            } else if (str.equals(strArr[namespaceCount])) {
                return this.f25541n[namespaceCount + 1];
            }
        }
        return null;
    }

    public int getNamespaceCount(int i11) {
        if (i11 <= this.f25539l) {
            return this.f25542o[i11];
        }
        throw new IndexOutOfBoundsException();
    }

    public String getNamespacePrefix(int i11) {
        return this.f25541n[i11 << 1];
    }

    public String getNamespaceUri(int i11) {
        return this.f25541n[(i11 << 1) + 1];
    }

    public String getPositionDescription() {
        String text;
        int i11 = this.B;
        String[] strArr = XmlPullParser.TYPES;
        StringBuffer stringBuffer = new StringBuffer(i11 < strArr.length ? strArr[i11] : "unknown");
        stringBuffer.append(' ');
        int i12 = this.B;
        if (i12 == 2 || i12 == 3) {
            if (this.C) {
                stringBuffer.append("(empty) ");
            }
            stringBuffer.append('<');
            if (this.B == 3) {
                stringBuffer.append('/');
            }
            if (this.f25549v != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("{");
                stringBuffer2.append(this.f25550w);
                stringBuffer2.append("}");
                stringBuffer2.append(this.f25549v);
                stringBuffer2.append(":");
                stringBuffer.append(stringBuffer2.toString());
            }
            stringBuffer.append(this.f25551x);
            int i13 = this.f25543p << 2;
            for (int i14 = 0; i14 < i13; i14 += 4) {
                stringBuffer.append(' ');
                int i15 = i14 + 1;
                if (this.f25544q[i15] != null) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("{");
                    stringBuffer3.append(this.f25544q[i14]);
                    stringBuffer3.append("}");
                    stringBuffer3.append(this.f25544q[i15]);
                    stringBuffer3.append(":");
                    stringBuffer.append(stringBuffer3.toString());
                }
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append(this.f25544q[i14 + 2]);
                stringBuffer4.append("='");
                stringBuffer4.append(this.f25544q[i14 + 3]);
                stringBuffer4.append("'");
                stringBuffer.append(stringBuffer4.toString());
            }
            stringBuffer.append('>');
        } else if (i12 != 7) {
            if (i12 != 4) {
                text = getText();
            } else if (this.D) {
                text = "(whitespace)";
            } else {
                text = getText();
                if (text.length() > 16) {
                    StringBuffer stringBuffer5 = new StringBuffer();
                    stringBuffer5.append(text.substring(0, 16));
                    stringBuffer5.append("...");
                    text = stringBuffer5.toString();
                }
            }
            stringBuffer.append(text);
        }
        return stringBuffer.toString();
    }

    public String getPrefix() {
        return this.f25549v;
    }

    public Object getProperty(String str) {
        return null;
    }

    public String getText() {
        return this.f25552y;
    }

    public char[] getTextCharacters(int[] iArr) {
        if (this.B >= 4) {
            iArr[0] = 0;
            iArr[1] = this.f25552y.length();
            char[] cArr = new char[this.f25552y.length()];
            String str = this.f25552y;
            str.getChars(0, str.length(), cArr, 0);
            return cArr;
        }
        iArr[0] = -1;
        iArr[1] = -1;
        return null;
    }

    public void h() throws IOException, XmlPullParserException {
        StringBuffer stringBuffer;
        int i11;
        String str;
        int i12 = i();
        int i13 = 0;
        while (i12 != 1) {
            while (i12 == 0) {
                o(i(), false);
                i12 = i();
            }
            String m11 = m(this.f25533f, i12);
            int indexOf = m11.indexOf(61);
            if (indexOf == -1) {
                stringBuffer = new StringBuffer();
            } else {
                StringBuffer stringBuffer2 = new StringBuffer(m11.substring(indexOf + 1));
                m11 = m11.substring(0, indexOf);
                stringBuffer = stringBuffer2;
            }
            while (true) {
                i11 = i();
                if (i11 > 128 || i11 == 0 || i11 == 2 || i11 == 3 || i11 == 131 || ((i11 >= 64 && i11 <= 66) || (i11 >= 128 && i11 <= 130))) {
                    if (i11 == 0) {
                        o(i(), false);
                    } else if (i11 != 2) {
                        if (i11 != 3) {
                            switch (i11) {
                                case 64:
                                case 65:
                                case 66:
                                    str = n(i11, f(i11));
                                    break;
                                default:
                                    switch (i11) {
                                        case 128:
                                        case 129:
                                        case 130:
                                            break;
                                        case 131:
                                            str = l();
                                            break;
                                        default:
                                            switch (i11) {
                                                case 192:
                                                case 193:
                                                case TPCodecParamers.TP_PROFILE_MJPEG_HUFFMAN_PROGRESSIVE_DCT /*194*/:
                                                case TPCodecParamers.TP_PROFILE_MJPEG_HUFFMAN_LOSSLESS /*195*/:
                                                    break;
                                                default:
                                                    str = m(this.f25534g, i11);
                                                    break;
                                            }
                                    }
                                    str = n(i11, f(i11));
                                    break;
                            }
                        } else {
                            str = k();
                        }
                        stringBuffer.append(str);
                    } else {
                        stringBuffer.append((char) j());
                    }
                }
            }
            String[] b11 = b(this.f25544q, i13 + 4);
            this.f25544q = b11;
            int i14 = i13 + 1;
            b11[i13] = "";
            int i15 = i14 + 1;
            b11[i14] = null;
            int i16 = i15 + 1;
            b11[i15] = m11;
            i13 = i16 + 1;
            b11[i16] = stringBuffer.toString();
            this.f25543p++;
            i12 = i11;
        }
    }

    public int i() throws IOException {
        int read = this.f25529b.read();
        if (read != -1) {
            return read;
        }
        throw new IOException("Unexpected EOF");
    }

    public boolean isAttributeDefault(int i11) {
        return false;
    }

    public boolean isEmptyElementTag() throws XmlPullParserException {
        if (this.B != 2) {
            c("Wrong event type");
        }
        return this.C;
    }

    public boolean isWhitespace() throws XmlPullParserException {
        int i11 = this.B;
        if (!(i11 == 4 || i11 == 7 || i11 == 5)) {
            c("Wrong event type");
        }
        return this.D;
    }

    public int j() throws IOException {
        int i11;
        int i12 = 0;
        do {
            i11 = i();
            i12 = (i12 << 7) | (i11 & 127);
        } while ((i11 & 128) != 0);
        return i12;
    }

    public String k() throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        boolean z11 = true;
        while (true) {
            int read = this.f25529b.read();
            if (read == 0) {
                this.D = z11;
                String str = new String(byteArrayOutputStream.toByteArray(), this.E);
                byteArrayOutputStream.close();
                return str;
            } else if (read != -1) {
                if (read > 32) {
                    z11 = false;
                }
                byteArrayOutputStream.write(read);
            } else {
                throw new IOException("Unexpected EOF");
            }
        }
    }

    public String l() throws IOException {
        byte[] bArr;
        int j11 = j();
        if (this.f25537j == null) {
            this.f25537j = new Hashtable();
        }
        String str = (String) this.f25537j.get(new Integer(j11));
        if (str != null) {
            return str;
        }
        int i11 = j11;
        while (true) {
            bArr = this.f25536i;
            if (i11 >= bArr.length || bArr[i11] == 0) {
                String str2 = new String(bArr, j11, i11 - j11, this.E);
                this.f25537j.put(new Integer(j11), str2);
            } else {
                i11++;
            }
        }
        String str22 = new String(bArr, j11, i11 - j11, this.E);
        this.f25537j.put(new Integer(j11), str22);
        return str22;
    }

    public String m(String[] strArr, int i11) throws IOException {
        int i12 = (i11 & 127) - 5;
        if (i12 == -1) {
            this.A = -1;
            return l();
        } else if (i12 < 0 || strArr == null || i12 >= strArr.length || strArr[i12] == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("id ");
            stringBuffer.append(i11);
            stringBuffer.append(" undef.");
            throw new IOException(stringBuffer.toString());
        } else {
            this.A = i12 + 5;
            return strArr[i12];
        }
    }

    public String n(int i11, Object obj) {
        if (obj instanceof byte[]) {
            StringBuffer stringBuffer = new StringBuffer();
            byte[] bArr = (byte[]) obj;
            for (int i12 = 0; i12 < bArr.length; i12++) {
                stringBuffer.append("0123456789abcdef".charAt((bArr[i12] >> 4) & 15));
                stringBuffer.append("0123456789abcdef".charAt(bArr[i12] & 15));
            }
            return stringBuffer.toString();
        }
        StringBuffer stringBuffer2 = new StringBuffer();
        stringBuffer2.append("$(");
        stringBuffer2.append(obj);
        stringBuffer2.append(")");
        return stringBuffer2.toString();
    }

    public int next() throws XmlPullParserException, IOException {
        this.D = true;
        int i11 = 9999;
        while (true) {
            String str = this.f25552y;
            d();
            int i12 = this.B;
            if (i12 < i11) {
                i11 = i12;
            }
            if (i11 <= 5) {
                if (i11 >= 4) {
                    if (str != null) {
                        if (this.f25552y != null) {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append(str);
                            stringBuffer.append(this.f25552y);
                            str = stringBuffer.toString();
                        }
                        this.f25552y = str;
                    }
                    int g11 = g();
                    if (!(g11 == 2 || g11 == 3 || g11 == 4 || g11 == 68 || g11 == 196 || g11 == 131 || g11 == 132)) {
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        this.B = i11;
        if (i11 > 4) {
            this.B = 4;
        }
        return this.B;
    }

    public int nextTag() throws XmlPullParserException, IOException {
        next();
        if (this.B == 4 && this.D) {
            next();
        }
        int i11 = this.B;
        if (!(i11 == 3 || i11 == 2)) {
            c("unexpected type");
        }
        return this.B;
    }

    public String nextText() throws XmlPullParserException, IOException {
        String str;
        if (this.B != 2) {
            c("precondition: START_TAG");
        }
        next();
        if (this.B == 4) {
            str = getText();
            next();
        } else {
            str = "";
        }
        if (this.B != 3) {
            c("END_TAG expected");
        }
        return str;
    }

    public int nextToken() throws XmlPullParserException, IOException {
        this.D = true;
        d();
        return this.B;
    }

    public final void o(int i11, boolean z11) throws XmlPullParserException {
        if (this.f25546s.size() != 0 || i11 != 0) {
            int i12 = i11 * 3;
            if (i12 > this.f25546s.size()) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Code Page ");
                stringBuffer.append(i11);
                stringBuffer.append(" undefined!");
                c(stringBuffer.toString());
            }
            Vector vector = this.f25546s;
            if (z11) {
                this.f25535h = (String[]) vector.elementAt(i12 + this.f25530c);
                return;
            }
            this.f25533f = (String[]) vector.elementAt(this.f25531d + i12);
            this.f25534g = (String[]) this.f25546s.elementAt(i12 + this.f25532e);
        }
    }

    public void require(int i11, String str, String str2) throws XmlPullParserException, IOException {
        String str3;
        if (i11 != this.B || ((str != null && !str.equals(getNamespace())) || (str2 != null && !str2.equals(getName())))) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("expected: ");
            if (i11 == 64) {
                str3 = "WAP Ext.";
            } else {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append(XmlPullParser.TYPES[i11]);
                stringBuffer2.append(" {");
                stringBuffer2.append(str);
                stringBuffer2.append("}");
                stringBuffer2.append(str2);
                str3 = stringBuffer2.toString();
            }
            stringBuffer.append(str3);
            c(stringBuffer.toString());
        }
    }

    public void setFeature(String str, boolean z11) throws XmlPullParserException {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(str)) {
            this.f25538k = z11;
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("unsupported feature: ");
        stringBuffer.append(str);
        c(stringBuffer.toString());
    }

    public void setInput(InputStream inputStream, String str) throws XmlPullParserException {
        this.f25529b = inputStream;
        try {
            this.f25547t = i();
            int j11 = j();
            this.f25548u = j11;
            if (j11 == 0) {
                j();
            }
            int j12 = j();
            if (str == null) {
                if (j12 == 4) {
                    str = "ISO-8859-1";
                } else if (j12 == 106) {
                    str = "UTF-8";
                } else {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("");
                    stringBuffer.append(j12);
                    throw new UnsupportedEncodingException(stringBuffer.toString());
                }
            }
            this.E = str;
            int j13 = j();
            this.f25536i = new byte[j13];
            int i11 = 0;
            while (true) {
                if (i11 >= j13) {
                    break;
                }
                int read = inputStream.read(this.f25536i, i11, j13 - i11);
                if (read <= 0) {
                    break;
                }
                i11 += read;
            }
            o(0, true);
            o(0, false);
        } catch (IOException unused) {
            c("Illegal input format");
        }
    }

    public void setInput(Reader reader) throws XmlPullParserException {
        c("InputStream required");
    }

    public void setProperty(String str, Object obj) throws XmlPullParserException {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("unsupported property: ");
        stringBuffer.append(str);
        throw new XmlPullParserException(stringBuffer.toString());
    }
}
