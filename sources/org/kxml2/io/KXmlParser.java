package org.kxml2.io;

import com.huawei.hms.framework.common.ContainerUtils;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import java.io.IOException;
import java.io.Reader;
import java.util.Hashtable;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

public class KXmlParser implements XmlPullParser {
    public int A;
    public String[] B;
    public int C;
    public String D;
    public int[] E;
    public int F;
    public boolean G;
    public boolean H;
    public boolean I;

    /* renamed from: b  reason: collision with root package name */
    public Object f25493b;

    /* renamed from: c  reason: collision with root package name */
    public String f25494c;

    /* renamed from: d  reason: collision with root package name */
    public Boolean f25495d;

    /* renamed from: e  reason: collision with root package name */
    public boolean f25496e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f25497f;

    /* renamed from: g  reason: collision with root package name */
    public Hashtable f25498g;

    /* renamed from: h  reason: collision with root package name */
    public int f25499h;

    /* renamed from: i  reason: collision with root package name */
    public String[] f25500i = new String[16];

    /* renamed from: j  reason: collision with root package name */
    public String[] f25501j = new String[8];

    /* renamed from: k  reason: collision with root package name */
    public int[] f25502k = new int[4];

    /* renamed from: l  reason: collision with root package name */
    public Reader f25503l;

    /* renamed from: m  reason: collision with root package name */
    public String f25504m;

    /* renamed from: n  reason: collision with root package name */
    public char[] f25505n;

    /* renamed from: o  reason: collision with root package name */
    public int f25506o;

    /* renamed from: p  reason: collision with root package name */
    public int f25507p;

    /* renamed from: q  reason: collision with root package name */
    public int f25508q;

    /* renamed from: r  reason: collision with root package name */
    public int f25509r;

    /* renamed from: s  reason: collision with root package name */
    public char[] f25510s;

    /* renamed from: t  reason: collision with root package name */
    public int f25511t;

    /* renamed from: u  reason: collision with root package name */
    public int f25512u;

    /* renamed from: v  reason: collision with root package name */
    public boolean f25513v;

    /* renamed from: w  reason: collision with root package name */
    public String f25514w;

    /* renamed from: x  reason: collision with root package name */
    public String f25515x;

    /* renamed from: y  reason: collision with root package name */
    public String f25516y;

    /* renamed from: z  reason: collision with root package name */
    public boolean f25517z;

    public KXmlParser() {
        int i11 = 128;
        this.f25510s = new char[128];
        this.B = new String[16];
        this.C = 0;
        this.E = new int[2];
        this.f25505n = new char[(Runtime.getRuntime().freeMemory() >= 1048576 ? 8192 : i11)];
    }

    public final boolean a() throws XmlPullParserException {
        int i11;
        String str;
        int i12 = 0;
        boolean z11 = false;
        while (true) {
            i11 = this.A;
            if (i12 >= (i11 << 2)) {
                break;
            }
            String str2 = this.B[i12 + 2];
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
                int[] iArr = this.f25502k;
                int i13 = this.f25499h;
                int i14 = iArr[i13];
                iArr[i13] = i14 + 1;
                int i15 = i14 << 1;
                String[] b11 = b(this.f25501j, i15 + 2);
                this.f25501j = b11;
                b11[i15] = str;
                String[] strArr = this.B;
                int i16 = i12 + 3;
                b11[i15 + 1] = strArr[i16];
                if (str != null && strArr[i16].equals("")) {
                    c("illegal empty namespace");
                }
                String[] strArr2 = this.B;
                int i17 = this.A - 1;
                this.A = i17;
                System.arraycopy(strArr2, i12 + 4, strArr2, i12, (i17 << 2) - i12);
                i12 -= 4;
            }
            i12 += 4;
        }
        if (z11) {
            int i18 = (i11 << 2) - 4;
            while (i18 >= 0) {
                int i19 = i18 + 2;
                String str3 = this.B[i19];
                int indexOf2 = str3.indexOf(58);
                if (indexOf2 != 0 || this.f25497f) {
                    if (indexOf2 != -1) {
                        String substring2 = str3.substring(0, indexOf2);
                        String substring3 = str3.substring(indexOf2 + 1);
                        String namespace = getNamespace(substring2);
                        if (namespace != null || this.f25497f) {
                            String[] strArr3 = this.B;
                            strArr3[i18] = namespace;
                            strArr3[i18 + 1] = substring2;
                            strArr3[i19] = substring3;
                        } else {
                            StringBuffer stringBuffer = new StringBuffer();
                            stringBuffer.append("Undefined Prefix: ");
                            stringBuffer.append(substring2);
                            stringBuffer.append(" in ");
                            stringBuffer.append(this);
                            throw new RuntimeException(stringBuffer.toString());
                        }
                    }
                    i18 -= 4;
                } else {
                    StringBuffer stringBuffer2 = new StringBuffer();
                    stringBuffer2.append("illegal attribute name: ");
                    stringBuffer2.append(str3);
                    stringBuffer2.append(" at ");
                    stringBuffer2.append(this);
                    throw new RuntimeException(stringBuffer2.toString());
                }
            }
        }
        int indexOf3 = this.f25516y.indexOf(58);
        if (indexOf3 == 0) {
            StringBuffer stringBuffer3 = new StringBuffer();
            stringBuffer3.append("illegal tag name: ");
            stringBuffer3.append(this.f25516y);
            c(stringBuffer3.toString());
        }
        if (indexOf3 != -1) {
            this.f25515x = this.f25516y.substring(0, indexOf3);
            this.f25516y = this.f25516y.substring(indexOf3 + 1);
        }
        String namespace2 = getNamespace(this.f25515x);
        this.f25514w = namespace2;
        if (namespace2 == null) {
            if (this.f25515x != null) {
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append("undefined prefix: ");
                stringBuffer4.append(this.f25515x);
                c(stringBuffer4.toString());
            }
            this.f25514w = "";
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
        if (!this.f25497f) {
            d(str);
        } else if (this.D == null) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("ERR: ");
            stringBuffer.append(str);
            this.D = stringBuffer.toString();
        }
    }

    public final void d(String str) throws XmlPullParserException {
        if (str.length() >= 100) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(str.substring(0, 100));
            stringBuffer.append("\n");
            str = stringBuffer.toString();
        }
        throw new XmlPullParserException(str, this, (Throwable) null);
    }

    public void defineEntityReplacementText(String str, String str2) throws XmlPullParserException {
        Hashtable hashtable = this.f25498g;
        if (hashtable != null) {
            hashtable.put(str, str2);
            return;
        }
        throw new RuntimeException("entity replacement text must be defined after setInput!");
    }

    public final String e(int i11) {
        return new String(this.f25510s, i11, this.f25511t - i11);
    }

    public final boolean f(String str, boolean z11, String str2) {
        if (!str.startsWith("http://xmlpull.org/v1/doc/")) {
            return false;
        }
        return str.substring(z11 ? 42 : 40).equals(str2);
    }

    public final void g() throws IOException, XmlPullParserException {
        int j11;
        if (this.f25503l == null) {
            d("No Input specified");
        }
        if (this.f25512u == 3) {
            this.f25499h--;
        }
        do {
            this.A = -1;
            if (this.f25517z) {
                this.f25517z = false;
                this.f25512u = 3;
                return;
            } else if (this.D != null) {
                for (int i11 = 0; i11 < this.D.length(); i11++) {
                    n(this.D.charAt(i11));
                }
                this.D = null;
                this.f25512u = 9;
                return;
            } else if (!this.f25497f || (this.C <= 0 && (l(0) != -1 || this.f25499h <= 0))) {
                this.f25515x = null;
                this.f25516y = null;
                this.f25514w = null;
                int m11 = m();
                this.f25512u = m11;
                if (m11 == 1) {
                    return;
                }
                if (m11 == 2) {
                    k(false);
                    return;
                } else if (m11 == 3) {
                    i();
                    return;
                } else if (m11 == 4) {
                    p(60, !this.I);
                    if (this.f25499h == 0 && this.f25513v) {
                        this.f25512u = 7;
                        return;
                    }
                    return;
                } else if (m11 != 6) {
                    j11 = j(this.I);
                    this.f25512u = j11;
                } else {
                    o();
                    return;
                }
            } else {
                int i12 = (this.f25499h - 1) << 2;
                this.f25512u = 3;
                String[] strArr = this.f25500i;
                this.f25514w = strArr[i12];
                this.f25515x = strArr[i12 + 1];
                this.f25516y = strArr[i12 + 2];
                if (this.C != 1) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("missing end tag /");
                    stringBuffer.append(this.f25516y);
                    stringBuffer.append(" inserted");
                    this.D = stringBuffer.toString();
                }
                int i13 = this.C;
                if (i13 > 0) {
                    this.C = i13 - 1;
                    return;
                }
                return;
            }
        } while (j11 == 998);
    }

    public int getAttributeCount() {
        return this.A;
    }

    public String getAttributeName(int i11) {
        if (i11 < this.A) {
            return this.B[(i11 << 2) + 2];
        }
        throw new IndexOutOfBoundsException();
    }

    public String getAttributeNamespace(int i11) {
        if (i11 < this.A) {
            return this.B[i11 << 2];
        }
        throw new IndexOutOfBoundsException();
    }

    public String getAttributePrefix(int i11) {
        if (i11 < this.A) {
            return this.B[(i11 << 2) + 1];
        }
        throw new IndexOutOfBoundsException();
    }

    public String getAttributeType(int i11) {
        return "CDATA";
    }

    public String getAttributeValue(int i11) {
        if (i11 < this.A) {
            return this.B[(i11 << 2) + 3];
        }
        throw new IndexOutOfBoundsException();
    }

    public String getAttributeValue(String str, String str2) {
        for (int i11 = (this.A << 2) - 4; i11 >= 0; i11 -= 4) {
            if (this.B[i11 + 2].equals(str2) && (str == null || this.B[i11].equals(str))) {
                return this.B[i11 + 3];
            }
        }
        return null;
    }

    public int getColumnNumber() {
        return this.f25509r;
    }

    public int getDepth() {
        return this.f25499h;
    }

    public int getEventType() throws XmlPullParserException {
        return this.f25512u;
    }

    public boolean getFeature(String str) {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(str)) {
            return this.f25496e;
        }
        if (f(str, false, "relaxed")) {
            return this.f25497f;
        }
        return false;
    }

    public String getInputEncoding() {
        return this.f25504m;
    }

    public int getLineNumber() {
        return this.f25508q;
    }

    public String getName() {
        return this.f25516y;
    }

    public String getNamespace() {
        return this.f25514w;
    }

    public String getNamespace(String str) {
        if ("xml".equals(str)) {
            return "http://www.w3.org/XML/1998/namespace";
        }
        if ("xmlns".equals(str)) {
            return "http://www.w3.org/2000/xmlns/";
        }
        for (int namespaceCount = (getNamespaceCount(this.f25499h) << 1) - 2; namespaceCount >= 0; namespaceCount -= 2) {
            String[] strArr = this.f25501j;
            if (str == null) {
                if (strArr[namespaceCount] == null) {
                    return strArr[namespaceCount + 1];
                }
            } else if (str.equals(strArr[namespaceCount])) {
                return this.f25501j[namespaceCount + 1];
            }
        }
        return null;
    }

    public int getNamespaceCount(int i11) {
        if (i11 <= this.f25499h) {
            return this.f25502k[i11];
        }
        throw new IndexOutOfBoundsException();
    }

    public String getNamespacePrefix(int i11) {
        return this.f25501j[i11 << 1];
    }

    public String getNamespaceUri(int i11) {
        return this.f25501j[(i11 << 1) + 1];
    }

    public String getPositionDescription() {
        String text;
        int i11 = this.f25512u;
        String[] strArr = XmlPullParser.TYPES;
        StringBuffer stringBuffer = new StringBuffer(i11 < strArr.length ? strArr[i11] : "unknown");
        stringBuffer.append(' ');
        int i12 = this.f25512u;
        if (i12 == 2 || i12 == 3) {
            if (this.f25517z) {
                stringBuffer.append("(empty) ");
            }
            stringBuffer.append('<');
            if (this.f25512u == 3) {
                stringBuffer.append('/');
            }
            if (this.f25515x != null) {
                StringBuffer stringBuffer2 = new StringBuffer();
                stringBuffer2.append("{");
                stringBuffer2.append(this.f25514w);
                stringBuffer2.append("}");
                stringBuffer2.append(this.f25515x);
                stringBuffer2.append(":");
                stringBuffer.append(stringBuffer2.toString());
            }
            stringBuffer.append(this.f25516y);
            int i13 = this.A << 2;
            for (int i14 = 0; i14 < i13; i14 += 4) {
                stringBuffer.append(' ');
                int i15 = i14 + 1;
                if (this.B[i15] != null) {
                    StringBuffer stringBuffer3 = new StringBuffer();
                    stringBuffer3.append("{");
                    stringBuffer3.append(this.B[i14]);
                    stringBuffer3.append("}");
                    stringBuffer3.append(this.B[i15]);
                    stringBuffer3.append(":");
                    stringBuffer.append(stringBuffer3.toString());
                }
                StringBuffer stringBuffer4 = new StringBuffer();
                stringBuffer4.append(this.B[i14 + 2]);
                stringBuffer4.append("='");
                stringBuffer4.append(this.B[i14 + 3]);
                stringBuffer4.append("'");
                stringBuffer.append(stringBuffer4.toString());
            }
            stringBuffer.append('>');
        } else if (i12 != 7) {
            if (i12 != 4) {
                text = getText();
            } else if (this.f25513v) {
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
        StringBuffer stringBuffer6 = new StringBuffer();
        stringBuffer6.append(TIMMentionEditText.TIM_MENTION_TAG);
        stringBuffer6.append(this.f25508q);
        stringBuffer6.append(":");
        stringBuffer6.append(this.f25509r);
        stringBuffer.append(stringBuffer6.toString());
        if (this.f25493b != null) {
            stringBuffer.append(" in ");
            stringBuffer.append(this.f25493b);
        } else if (this.f25503l != null) {
            stringBuffer.append(" in ");
            stringBuffer.append(this.f25503l.toString());
        }
        return stringBuffer.toString();
    }

    public String getPrefix() {
        return this.f25515x;
    }

    public Object getProperty(String str) {
        if (f(str, true, "xmldecl-version")) {
            return this.f25494c;
        }
        if (f(str, true, "xmldecl-standalone")) {
            return this.f25495d;
        }
        if (!f(str, true, "location")) {
            return null;
        }
        Object obj = this.f25493b;
        return obj != null ? obj : this.f25503l.toString();
    }

    public String getText() {
        int i11 = this.f25512u;
        if (i11 < 4 || (i11 == 6 && this.H)) {
            return null;
        }
        return e(0);
    }

    public char[] getTextCharacters(int[] iArr) {
        int i11 = this.f25512u;
        if (i11 < 4) {
            iArr[0] = -1;
            iArr[1] = -1;
            return null;
        } else if (i11 == 6) {
            iArr[0] = 0;
            iArr[1] = this.f25516y.length();
            return this.f25516y.toCharArray();
        } else {
            iArr[0] = 0;
            iArr[1] = this.f25511t;
            return this.f25510s;
        }
    }

    public final void h(boolean z11) throws IOException, XmlPullParserException {
        int i11 = 1;
        boolean z12 = false;
        while (true) {
            int q11 = q();
            if (q11 != -1) {
                if (q11 == 39) {
                    z12 = !z12;
                } else if (q11 != 60) {
                    if (q11 == 62 && !z12 && i11 - 1 == 0) {
                        return;
                    }
                } else if (!z12) {
                    i11++;
                }
                if (z11) {
                    n(q11);
                }
            } else {
                c("Unexpected EOF");
                return;
            }
        }
    }

    public final void i() throws IOException, XmlPullParserException {
        q();
        q();
        this.f25516y = s();
        t();
        r('>');
        int i11 = this.f25499h;
        int i12 = (i11 - 1) << 2;
        if (i11 == 0) {
            c("element stack empty");
            this.f25512u = 9;
            return;
        }
        int i13 = i12 + 3;
        if (!this.f25516y.equals(this.f25500i[i13])) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("expected: /");
            stringBuffer.append(this.f25500i[i13]);
            stringBuffer.append(" read: ");
            stringBuffer.append(this.f25516y);
            c(stringBuffer.toString());
            int i14 = i12;
            while (i14 >= 0 && !this.f25516y.toLowerCase().equals(this.f25500i[i14 + 3].toLowerCase())) {
                this.C++;
                i14 -= 4;
            }
            if (i14 < 0) {
                this.C = 0;
                this.f25512u = 9;
                return;
            }
        }
        String[] strArr = this.f25500i;
        this.f25514w = strArr[i12];
        this.f25515x = strArr[i12 + 1];
        this.f25516y = strArr[i12 + 2];
    }

    public boolean isAttributeDefault(int i11) {
        return false;
    }

    public boolean isEmptyElementTag() throws XmlPullParserException {
        if (this.f25512u != 2) {
            d("Wrong event type");
        }
        return this.f25517z;
    }

    public boolean isWhitespace() throws XmlPullParserException {
        int i11 = this.f25512u;
        if (!(i11 == 4 || i11 == 7 || i11 == 5)) {
            d("Wrong event type");
        }
        return this.f25513v;
    }

    public final int j(boolean z11) throws IOException, XmlPullParserException {
        String str;
        int i11;
        int i12;
        String str2;
        Boolean bool;
        q();
        int q11 = q();
        if (q11 == 63) {
            if ((l(0) == 120 || l(0) == 88) && (l(1) == 109 || l(1) == 77)) {
                if (z11) {
                    n(l(0));
                    n(l(1));
                }
                q();
                q();
                if ((l(0) == 108 || l(0) == 76) && l(1) <= 32) {
                    if (this.f25508q != 1 || this.f25509r > 4) {
                        c("PI must not start with xml");
                    }
                    k(true);
                    int i13 = 2;
                    if (this.A < 1 || !"version".equals(this.B[2])) {
                        c("version expected");
                    }
                    String[] strArr = this.B;
                    this.f25494c = strArr[3];
                    if (1 >= this.A || !"encoding".equals(strArr[6])) {
                        i13 = 1;
                    } else {
                        this.f25504m = this.B[7];
                    }
                    if (i13 < this.A) {
                        int i14 = i13 * 4;
                        if ("standalone".equals(this.B[i14 + 2])) {
                            String str3 = this.B[i14 + 3];
                            if ("yes".equals(str3)) {
                                bool = new Boolean(true);
                            } else if ("no".equals(str3)) {
                                bool = new Boolean(false);
                            } else {
                                StringBuffer stringBuffer = new StringBuffer();
                                stringBuffer.append("illegal standalone value: ");
                                stringBuffer.append(str3);
                                c(stringBuffer.toString());
                                i13++;
                            }
                            this.f25495d = bool;
                            i13++;
                        }
                    }
                    if (i13 != this.A) {
                        c("illegal xmldecl");
                    }
                    this.f25513v = true;
                    this.f25511t = 0;
                    return 998;
                }
            }
            i11 = 8;
            str2 = "";
            i12 = 63;
        } else if (q11 != 33) {
            StringBuffer stringBuffer2 = new StringBuffer();
            stringBuffer2.append("illegal: <");
            stringBuffer2.append(q11);
            str = stringBuffer2.toString();
            c(str);
            return 9;
        } else if (l(0) == 45) {
            i11 = 9;
            str2 = "--";
            i12 = 45;
        } else if (l(0) == 91) {
            i11 = 5;
            str2 = "[CDATA[";
            i12 = 93;
            z11 = true;
        } else {
            i11 = 10;
            str2 = "DOCTYPE";
            i12 = -1;
        }
        for (int i15 = 0; i15 < str2.length(); i15++) {
            r(str2.charAt(i15));
        }
        if (i11 == 10) {
            h(z11);
        } else {
            int i16 = 0;
            while (true) {
                int q12 = q();
                if (q12 == -1) {
                    str = "Unexpected EOF";
                    break;
                }
                if (z11) {
                    n(q12);
                }
                if ((i12 == 63 || q12 == i12) && l(0) == i12 && l(1) == 62) {
                    if (i12 == 45 && i16 == 45) {
                        c("illegal comment delimiter: --->");
                    }
                    q();
                    q();
                    if (z11 && i12 != 63) {
                        this.f25511t--;
                    }
                } else {
                    i16 = q12;
                }
            }
            c(str);
            return 9;
        }
        return i11;
    }

    public final void k(boolean z11) throws IOException, XmlPullParserException {
        if (!z11) {
            q();
        }
        this.f25516y = s();
        this.A = 0;
        while (true) {
            t();
            int l11 = l(0);
            if (!z11) {
                if (l11 != 47) {
                    if (l11 == 62 && !z11) {
                        q();
                        break;
                    }
                } else {
                    this.f25517z = true;
                    q();
                    t();
                    r('>');
                    break;
                }
            } else if (l11 == 63) {
                q();
                r('>');
                return;
            }
            if (l11 == -1) {
                c("Unexpected EOF");
                return;
            }
            String s11 = s();
            if (s11.length() == 0) {
                c("attr name expected");
                break;
            }
            int i11 = this.A;
            this.A = i11 + 1;
            int i12 = i11 << 2;
            String[] b11 = b(this.B, i12 + 4);
            this.B = b11;
            int i13 = i12 + 1;
            b11[i12] = "";
            int i14 = i13 + 1;
            b11[i13] = null;
            int i15 = i14 + 1;
            b11[i14] = s11;
            t();
            if (l(0) != 61) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Attr.value missing f. ");
                stringBuffer.append(s11);
                c(stringBuffer.toString());
                this.B[i15] = "1";
            } else {
                r('=');
                t();
                int l12 = l(0);
                if (l12 == 39 || l12 == 34) {
                    q();
                } else {
                    c("attr value delimiter missing!");
                    l12 = 32;
                }
                int i16 = this.f25511t;
                p(l12, true);
                this.B[i15] = e(i16);
                this.f25511t = i16;
                if (l12 != 32) {
                    q();
                }
            }
        }
        int i17 = this.f25499h;
        this.f25499h = i17 + 1;
        int i18 = i17 << 2;
        String[] b12 = b(this.f25500i, i18 + 4);
        this.f25500i = b12;
        b12[i18 + 3] = this.f25516y;
        int i19 = this.f25499h;
        int[] iArr = this.f25502k;
        if (i19 >= iArr.length) {
            int[] iArr2 = new int[(i19 + 4)];
            System.arraycopy(iArr, 0, iArr2, 0, iArr.length);
            this.f25502k = iArr2;
        }
        int[] iArr3 = this.f25502k;
        int i21 = this.f25499h;
        iArr3[i21] = iArr3[i21 - 1];
        if (this.f25496e) {
            a();
        } else {
            this.f25514w = "";
        }
        String[] strArr = this.f25500i;
        strArr[i18] = this.f25514w;
        strArr[i18 + 1] = this.f25515x;
        strArr[i18 + 2] = this.f25516y;
    }

    public final int l(int i11) throws IOException {
        int i12;
        while (i11 >= this.F) {
            char[] cArr = this.f25505n;
            if (cArr.length <= 1) {
                i12 = this.f25503l.read();
            } else {
                int i13 = this.f25506o;
                if (i13 < this.f25507p) {
                    this.f25506o = i13 + 1;
                    i12 = cArr[i13];
                } else {
                    int read = this.f25503l.read(cArr, 0, cArr.length);
                    this.f25507p = read;
                    char c11 = read <= 0 ? 65535 : this.f25505n[0];
                    this.f25506o = 1;
                    i12 = c11;
                }
            }
            if (i12 == 13) {
                this.G = true;
                int[] iArr = this.E;
                int i14 = this.F;
                this.F = i14 + 1;
                iArr[i14] = 10;
            } else {
                if (i12 != 10) {
                    int[] iArr2 = this.E;
                    int i15 = this.F;
                    this.F = i15 + 1;
                    iArr2[i15] = i12;
                } else if (!this.G) {
                    int[] iArr3 = this.E;
                    int i16 = this.F;
                    this.F = i16 + 1;
                    iArr3[i16] = 10;
                }
                this.G = false;
            }
        }
        return this.E[i11];
    }

    public final int m() throws IOException {
        int l11 = l(0);
        if (l11 == -1) {
            return 1;
        }
        if (l11 == 38) {
            return 6;
        }
        if (l11 != 60) {
            return 4;
        }
        int l12 = l(1);
        if (l12 == 33) {
            return 999;
        }
        if (l12 != 47) {
            return l12 != 63 ? 2 : 999;
        }
        return 3;
    }

    public final void n(int i11) {
        this.f25513v &= i11 <= 32;
        int i12 = this.f25511t;
        char[] cArr = this.f25510s;
        if (i12 == cArr.length) {
            char[] cArr2 = new char[(((i12 * 4) / 3) + 4)];
            System.arraycopy(cArr, 0, cArr2, 0, i12);
            this.f25510s = cArr2;
        }
        char[] cArr3 = this.f25510s;
        int i13 = this.f25511t;
        this.f25511t = i13 + 1;
        cArr3[i13] = (char) i11;
    }

    public int next() throws XmlPullParserException, IOException {
        this.f25511t = 0;
        this.f25513v = true;
        this.I = false;
        int i11 = 9999;
        while (true) {
            g();
            int i12 = this.f25512u;
            if (i12 < i11) {
                i11 = i12;
            }
            if (i11 > 6 || (i11 >= 4 && m() >= 4)) {
            }
        }
        this.f25512u = i11;
        if (i11 > 4) {
            this.f25512u = 4;
        }
        return this.f25512u;
    }

    public int nextTag() throws XmlPullParserException, IOException {
        next();
        if (this.f25512u == 4 && this.f25513v) {
            next();
        }
        int i11 = this.f25512u;
        if (!(i11 == 3 || i11 == 2)) {
            d("unexpected type");
        }
        return this.f25512u;
    }

    public String nextText() throws XmlPullParserException, IOException {
        String str;
        if (this.f25512u != 2) {
            d("precondition: START_TAG");
        }
        next();
        if (this.f25512u == 4) {
            str = getText();
            next();
        } else {
            str = "";
        }
        if (this.f25512u != 3) {
            d("END_TAG expected");
        }
        return str;
    }

    public int nextToken() throws XmlPullParserException, IOException {
        this.f25513v = true;
        this.f25511t = 0;
        this.I = true;
        g();
        return this.f25512u;
    }

    public final void o() throws IOException, XmlPullParserException {
        n(q());
        int i11 = this.f25511t;
        while (true) {
            int q11 = q();
            if (q11 == 59) {
                String e11 = e(i11);
                boolean z11 = true;
                this.f25511t = i11 - 1;
                if (this.I && this.f25512u == 6) {
                    this.f25516y = e11;
                }
                if (e11.charAt(0) == '#') {
                    n(e11.charAt(1) == 'x' ? Integer.parseInt(e11.substring(2), 16) : Integer.parseInt(e11.substring(1)));
                    return;
                }
                String str = (String) this.f25498g.get(e11);
                if (str != null) {
                    z11 = false;
                }
                this.H = z11;
                if (!z11) {
                    for (int i12 = 0; i12 < str.length(); i12++) {
                        n(str.charAt(i12));
                    }
                    return;
                } else if (!this.I) {
                    StringBuffer stringBuffer = new StringBuffer();
                    stringBuffer.append("unresolved: &");
                    stringBuffer.append(e11);
                    stringBuffer.append(";");
                    c(stringBuffer.toString());
                    return;
                } else {
                    return;
                }
            } else if (q11 >= 128 || ((q11 >= 48 && q11 <= 57) || ((q11 >= 97 && q11 <= 122) || ((q11 >= 65 && q11 <= 90) || q11 == 95 || q11 == 45 || q11 == 35)))) {
                n(q11);
            } else {
                if (!this.f25497f) {
                    c("unterminated entity ref");
                }
                if (q11 != -1) {
                    n(q11);
                    return;
                }
                return;
            }
        }
    }

    public final void p(int i11, boolean z11) throws IOException, XmlPullParserException {
        int l11 = l(0);
        int i12 = 0;
        while (l11 != -1 && l11 != i11) {
            int i13 = 32;
            if (i11 != 32 || (l11 > 32 && l11 != 62)) {
                if (l11 != 38) {
                    if (l11 == 10 && this.f25512u == 2) {
                        q();
                    } else {
                        i13 = q();
                    }
                    n(i13);
                } else if (z11) {
                    o();
                } else {
                    return;
                }
                if (l11 == 62 && i12 >= 2 && i11 != 93) {
                    c("Illegal: ]]>");
                }
                i12 = l11 == 93 ? i12 + 1 : 0;
                l11 = l(0);
            } else {
                return;
            }
        }
    }

    public final int q() throws IOException {
        int i11;
        if (this.F == 0) {
            i11 = l(0);
        } else {
            int[] iArr = this.E;
            int i12 = iArr[0];
            iArr[0] = iArr[1];
            i11 = i12;
        }
        this.F--;
        this.f25509r++;
        if (i11 == 10) {
            this.f25508q++;
            this.f25509r = 1;
        }
        return i11;
    }

    public final void r(char c11) throws IOException, XmlPullParserException {
        int q11 = q();
        if (q11 != c11) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("expected: '");
            stringBuffer.append(c11);
            stringBuffer.append("' actual: '");
            stringBuffer.append((char) q11);
            stringBuffer.append("'");
            c(stringBuffer.toString());
        }
    }

    public void require(int i11, String str, String str2) throws XmlPullParserException, IOException {
        if (i11 != this.f25512u || ((str != null && !str.equals(getNamespace())) || (str2 != null && !str2.equals(getName())))) {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("expected: ");
            stringBuffer.append(XmlPullParser.TYPES[i11]);
            stringBuffer.append(" {");
            stringBuffer.append(str);
            stringBuffer.append("}");
            stringBuffer.append(str2);
            d(stringBuffer.toString());
        }
    }

    public final String s() throws IOException, XmlPullParserException {
        int i11 = this.f25511t;
        int l11 = l(0);
        if ((l11 < 97 || l11 > 122) && ((l11 < 65 || l11 > 90) && l11 != 95 && l11 != 58 && l11 < 192 && !this.f25497f)) {
            c("name expected");
        }
        while (true) {
            n(q());
            int l12 = l(0);
            if ((l12 < 97 || l12 > 122) && ((l12 < 65 || l12 > 90) && !((l12 >= 48 && l12 <= 57) || l12 == 95 || l12 == 45 || l12 == 58 || l12 == 46 || l12 >= 183))) {
                String e11 = e(i11);
                this.f25511t = i11;
                return e11;
            }
        }
    }

    public void setFeature(String str, boolean z11) throws XmlPullParserException {
        if (XmlPullParser.FEATURE_PROCESS_NAMESPACES.equals(str)) {
            this.f25496e = z11;
        } else if (f(str, false, "relaxed")) {
            this.f25497f = z11;
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("unsupported feature: ");
            stringBuffer.append(str);
            d(stringBuffer.toString());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x003f, code lost:
        r3 = r14.read();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0043, code lost:
        if (r3 != -1) goto L_0x0047;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0047, code lost:
        r4 = r13.f25505n;
        r7 = r13.f25507p;
        r10 = r7 + 1;
        r13.f25507p = r10;
        r4[r7] = (char) r3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0054, code lost:
        if (r3 != 62) goto L_0x003f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0056, code lost:
        r3 = new java.lang.String(r4, 0, r10);
        r4 = r3.indexOf("encoding");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0061, code lost:
        if (r4 == -1) goto L_0x00ae;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0069, code lost:
        if (r3.charAt(r4) == '\"') goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0071, code lost:
        if (r3.charAt(r4) == '\'') goto L_0x0076;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0073, code lost:
        r4 = r4 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0076, code lost:
        r7 = r4 + 1;
        r3 = r3.substring(r7, r3.indexOf(r3.charAt(r4), r7));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x009e, code lost:
        r1 = "UTF-16BE";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ac, code lost:
        r1 = "UTF-32LE";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00ae, code lost:
        r3 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00af, code lost:
        r4 = -65536 & r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b5, code lost:
        if (r4 != -16842752) goto L_0x00c6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00b7, code lost:
        r1 = r13.f25505n;
        r1[0] = (char) ((r1[2] << 8) | r1[3]);
        r13.f25507p = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00c8, code lost:
        if (r4 != -131072) goto L_0x00d9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00ca, code lost:
        r2 = r13.f25505n;
        r2[0] = (char) ((r2[3] << 8) | r2[2]);
        r13.f25507p = 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00de, code lost:
        if ((r6 & -256) != -272908544) goto L_0x00ea;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00e0, code lost:
        r1 = r13.f25505n;
        r1[0] = r1[3];
        r13.f25507p = 1;
        r1 = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00ea, code lost:
        r1 = r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setInput(java.io.InputStream r14, java.lang.String r15) throws org.xmlpull.v1.XmlPullParserException {
        /*
            r13 = this;
            r0 = 0
            r13.f25506o = r0
            r13.f25507p = r0
            if (r14 == 0) goto L_0x011c
            java.lang.String r1 = "UTF-16LE"
            java.lang.String r2 = "UTF-16BE"
            java.lang.String r3 = "UTF-32BE"
            java.lang.String r4 = "UTF-32LE"
            java.lang.String r5 = "UTF-8"
            if (r15 != 0) goto L_0x00ec
            r6 = r0
        L_0x0014:
            int r7 = r13.f25507p     // Catch:{ Exception -> 0x0100 }
            r8 = 4
            r9 = -1
            if (r7 >= r8) goto L_0x0030
            int r7 = r14.read()     // Catch:{ Exception -> 0x0100 }
            if (r7 != r9) goto L_0x0021
            goto L_0x0030
        L_0x0021:
            int r6 = r6 << 8
            r6 = r6 | r7
            char[] r8 = r13.f25505n     // Catch:{ Exception -> 0x0100 }
            int r9 = r13.f25507p     // Catch:{ Exception -> 0x0100 }
            int r10 = r9 + 1
            r13.f25507p = r10     // Catch:{ Exception -> 0x0100 }
            char r7 = (char) r7     // Catch:{ Exception -> 0x0100 }
            r8[r9] = r7     // Catch:{ Exception -> 0x0100 }
            goto L_0x0014
        L_0x0030:
            int r7 = r13.f25507p     // Catch:{ Exception -> 0x0100 }
            if (r7 != r8) goto L_0x00ec
            r7 = 63
            r8 = 2
            r10 = 60
            r11 = 1
            switch(r6) {
                case -131072: goto L_0x00aa;
                case 60: goto L_0x00a3;
                case 65279: goto L_0x00a0;
                case 3932223: goto L_0x0096;
                case 1006632960: goto L_0x008f;
                case 1006649088: goto L_0x0085;
                case 1010792557: goto L_0x003f;
                default: goto L_0x003d;
            }     // Catch:{ Exception -> 0x0100 }
        L_0x003d:
            goto L_0x00ae
        L_0x003f:
            int r3 = r14.read()     // Catch:{ Exception -> 0x0100 }
            if (r3 != r9) goto L_0x0047
            goto L_0x00ae
        L_0x0047:
            char[] r4 = r13.f25505n     // Catch:{ Exception -> 0x0100 }
            int r7 = r13.f25507p     // Catch:{ Exception -> 0x0100 }
            int r10 = r7 + 1
            r13.f25507p = r10     // Catch:{ Exception -> 0x0100 }
            char r12 = (char) r3     // Catch:{ Exception -> 0x0100 }
            r4[r7] = r12     // Catch:{ Exception -> 0x0100 }
            r7 = 62
            if (r3 != r7) goto L_0x003f
            java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x0100 }
            r3.<init>(r4, r0, r10)     // Catch:{ Exception -> 0x0100 }
            java.lang.String r4 = "encoding"
            int r4 = r3.indexOf(r4)     // Catch:{ Exception -> 0x0100 }
            if (r4 == r9) goto L_0x00ae
        L_0x0063:
            char r7 = r3.charAt(r4)     // Catch:{ Exception -> 0x0100 }
            r9 = 34
            if (r7 == r9) goto L_0x0076
            char r7 = r3.charAt(r4)     // Catch:{ Exception -> 0x0100 }
            r9 = 39
            if (r7 == r9) goto L_0x0076
            int r4 = r4 + 1
            goto L_0x0063
        L_0x0076:
            int r7 = r4 + 1
            char r4 = r3.charAt(r4)     // Catch:{ Exception -> 0x0100 }
            int r4 = r3.indexOf(r4, r7)     // Catch:{ Exception -> 0x0100 }
            java.lang.String r3 = r3.substring(r7, r4)     // Catch:{ Exception -> 0x0100 }
            goto L_0x00af
        L_0x0085:
            char[] r2 = r13.f25505n     // Catch:{ Exception -> 0x0100 }
            r2[r0] = r10     // Catch:{ Exception -> 0x0100 }
            r2[r11] = r7     // Catch:{ Exception -> 0x0100 }
            r13.f25507p = r8     // Catch:{ Exception -> 0x0100 }
            goto L_0x00ed
        L_0x008f:
            char[] r1 = r13.f25505n     // Catch:{ Exception -> 0x0100 }
            r1[r0] = r10     // Catch:{ Exception -> 0x0100 }
            r13.f25507p = r11     // Catch:{ Exception -> 0x0100 }
            goto L_0x00ac
        L_0x0096:
            char[] r1 = r13.f25505n     // Catch:{ Exception -> 0x0100 }
            r1[r0] = r10     // Catch:{ Exception -> 0x0100 }
            r1[r11] = r7     // Catch:{ Exception -> 0x0100 }
            r13.f25507p = r8     // Catch:{ Exception -> 0x0100 }
        L_0x009e:
            r1 = r2
            goto L_0x00ed
        L_0x00a0:
            r13.f25507p = r0     // Catch:{ Exception -> 0x0100 }
            goto L_0x00ea
        L_0x00a3:
            char[] r1 = r13.f25505n     // Catch:{ Exception -> 0x0100 }
            r1[r0] = r10     // Catch:{ Exception -> 0x0100 }
            r13.f25507p = r11     // Catch:{ Exception -> 0x0100 }
            goto L_0x00ea
        L_0x00aa:
            r13.f25507p = r0     // Catch:{ Exception -> 0x0100 }
        L_0x00ac:
            r1 = r4
            goto L_0x00ed
        L_0x00ae:
            r3 = r15
        L_0x00af:
            r4 = -65536(0xffffffffffff0000, float:NaN)
            r4 = r4 & r6
            r7 = -16842752(0xfffffffffeff0000, float:-1.6947657E38)
            r9 = 3
            if (r4 != r7) goto L_0x00c6
            char[] r1 = r13.f25505n     // Catch:{ Exception -> 0x0100 }
            char r3 = r1[r8]     // Catch:{ Exception -> 0x0100 }
            int r3 = r3 << 8
            char r4 = r1[r9]     // Catch:{ Exception -> 0x0100 }
            r3 = r3 | r4
            char r3 = (char) r3     // Catch:{ Exception -> 0x0100 }
            r1[r0] = r3     // Catch:{ Exception -> 0x0100 }
            r13.f25507p = r11     // Catch:{ Exception -> 0x0100 }
            goto L_0x009e
        L_0x00c6:
            r2 = -131072(0xfffffffffffe0000, float:NaN)
            if (r4 != r2) goto L_0x00d9
            char[] r2 = r13.f25505n     // Catch:{ Exception -> 0x0100 }
            char r3 = r2[r9]     // Catch:{ Exception -> 0x0100 }
            int r3 = r3 << 8
            char r4 = r2[r8]     // Catch:{ Exception -> 0x0100 }
            r3 = r3 | r4
            char r3 = (char) r3     // Catch:{ Exception -> 0x0100 }
            r2[r0] = r3     // Catch:{ Exception -> 0x0100 }
            r13.f25507p = r11     // Catch:{ Exception -> 0x0100 }
            goto L_0x00ed
        L_0x00d9:
            r1 = r6 & -256(0xffffffffffffff00, float:NaN)
            r2 = -272908544(0xffffffffefbbbf00, float:-1.162092E29)
            if (r1 != r2) goto L_0x00ea
            char[] r1 = r13.f25505n     // Catch:{ Exception -> 0x0100 }
            char r2 = r1[r9]     // Catch:{ Exception -> 0x0100 }
            r1[r0] = r2     // Catch:{ Exception -> 0x0100 }
            r13.f25507p = r11     // Catch:{ Exception -> 0x0100 }
            r1 = r5
            goto L_0x00ed
        L_0x00ea:
            r1 = r3
            goto L_0x00ed
        L_0x00ec:
            r1 = r15
        L_0x00ed:
            if (r1 != 0) goto L_0x00f0
            goto L_0x00f1
        L_0x00f0:
            r5 = r1
        L_0x00f1:
            int r0 = r13.f25507p     // Catch:{ Exception -> 0x0100 }
            java.io.InputStreamReader r1 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0100 }
            r1.<init>(r14, r5)     // Catch:{ Exception -> 0x0100 }
            r13.setInput(r1)     // Catch:{ Exception -> 0x0100 }
            r13.f25504m = r15     // Catch:{ Exception -> 0x0100 }
            r13.f25507p = r0     // Catch:{ Exception -> 0x0100 }
            return
        L_0x0100:
            r14 = move-exception
            org.xmlpull.v1.XmlPullParserException r15 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            java.lang.String r1 = "Invalid stream or encoding: "
            r0.append(r1)
            java.lang.String r1 = r14.toString()
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            r15.<init>(r0, r13, r14)
            throw r15
        L_0x011c:
            java.lang.IllegalArgumentException r14 = new java.lang.IllegalArgumentException
            r14.<init>()
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: org.kxml2.io.KXmlParser.setInput(java.io.InputStream, java.lang.String):void");
    }

    public void setInput(Reader reader) throws XmlPullParserException {
        this.f25503l = reader;
        this.f25508q = 1;
        this.f25509r = 0;
        this.f25512u = 0;
        this.f25516y = null;
        this.f25514w = null;
        this.f25517z = false;
        this.A = -1;
        this.f25504m = null;
        this.f25494c = null;
        this.f25495d = null;
        if (reader != null) {
            this.f25506o = 0;
            this.f25507p = 0;
            this.F = 0;
            this.f25499h = 0;
            Hashtable hashtable = new Hashtable();
            this.f25498g = hashtable;
            hashtable.put("amp", ContainerUtils.FIELD_DELIMITER);
            this.f25498g.put("apos", "'");
            this.f25498g.put("gt", ">");
            this.f25498g.put("lt", "<");
            this.f25498g.put("quot", "\"");
        }
    }

    public void setProperty(String str, Object obj) throws XmlPullParserException {
        if (f(str, true, "location")) {
            this.f25493b = obj;
            return;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("unsupported property: ");
        stringBuffer.append(str);
        throw new XmlPullParserException(stringBuffer.toString());
    }

    public final void t() throws IOException {
        while (true) {
            int l11 = l(0);
            if (l11 <= 32 && l11 != -1) {
                q();
            } else {
                return;
            }
        }
    }
}
