package org.kxml2.io;

import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.jumio.commons.log.LogUtils;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import org.xmlpull.v1.XmlSerializer;

public class KXmlSerializer implements XmlSerializer {

    /* renamed from: a  reason: collision with root package name */
    public Writer f25518a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f25519b;

    /* renamed from: c  reason: collision with root package name */
    public int f25520c;

    /* renamed from: d  reason: collision with root package name */
    public int f25521d;

    /* renamed from: e  reason: collision with root package name */
    public String[] f25522e = new String[12];

    /* renamed from: f  reason: collision with root package name */
    public int[] f25523f = new int[4];

    /* renamed from: g  reason: collision with root package name */
    public String[] f25524g = new String[8];

    /* renamed from: h  reason: collision with root package name */
    public boolean[] f25525h = new boolean[4];

    /* renamed from: i  reason: collision with root package name */
    public boolean f25526i;

    /* renamed from: j  reason: collision with root package name */
    public String f25527j;

    public final void a(boolean z11) throws IOException {
        if (this.f25519b) {
            int i11 = this.f25521d + 1;
            this.f25521d = i11;
            this.f25519b = false;
            boolean[] zArr = this.f25525h;
            if (zArr.length <= i11) {
                boolean[] zArr2 = new boolean[(i11 + 4)];
                System.arraycopy(zArr, 0, zArr2, 0, i11);
                this.f25525h = zArr2;
            }
            boolean[] zArr3 = this.f25525h;
            int i12 = this.f25521d;
            zArr3[i12] = zArr3[i12 - 1];
            int i13 = this.f25523f[i12 - 1];
            while (true) {
                int[] iArr = this.f25523f;
                int i14 = this.f25521d;
                if (i13 < iArr[i14]) {
                    this.f25518a.write(32);
                    this.f25518a.write("xmlns");
                    int i15 = i13 * 2;
                    if (!"".equals(this.f25524g[i15])) {
                        this.f25518a.write(58);
                        this.f25518a.write(this.f25524g[i15]);
                    } else if ("".equals(getNamespace()) && !"".equals(this.f25524g[i15 + 1])) {
                        throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
                    }
                    this.f25518a.write("=\"");
                    c(this.f25524g[i15 + 1], 34);
                    this.f25518a.write(34);
                    i13++;
                } else {
                    if (iArr.length <= i14 + 1) {
                        int[] iArr2 = new int[(i14 + 8)];
                        System.arraycopy(iArr, 0, iArr2, 0, i14 + 1);
                        this.f25523f = iArr2;
                    }
                    int[] iArr3 = this.f25523f;
                    int i16 = this.f25521d;
                    iArr3[i16 + 1] = iArr3[i16];
                    this.f25518a.write(z11 ? " />" : ">");
                    return;
                }
            }
        }
    }

    public XmlSerializer attribute(String str, String str2, String str3) throws IOException {
        if (this.f25519b) {
            if (str == null) {
                str = "";
            }
            String b11 = "".equals(str) ? "" : b(str, false, true);
            this.f25518a.write(32);
            if (!"".equals(b11)) {
                this.f25518a.write(b11);
                this.f25518a.write(58);
            }
            this.f25518a.write(str2);
            this.f25518a.write(61);
            int i11 = 34;
            if (str3.indexOf(34) != -1) {
                i11 = 39;
            }
            this.f25518a.write(i11);
            c(str3, i11);
            this.f25518a.write(i11);
            return this;
        }
        throw new IllegalStateException("illegal position for attribute");
    }

    public final String b(String str, boolean z11, boolean z12) throws IOException {
        int i11 = this.f25523f[this.f25521d + 1] * 2;
        while (true) {
            i11 -= 2;
            String str2 = null;
            String str3 = "";
            if (i11 >= 0) {
                if (this.f25524g[i11 + 1].equals(str) && (z11 || !this.f25524g[i11].equals(str3))) {
                    String str4 = this.f25524g[i11];
                    int i12 = i11 + 2;
                    while (true) {
                        if (i12 >= this.f25523f[this.f25521d + 1] * 2) {
                            str2 = str4;
                            break;
                        } else if (this.f25524g[i12].equals(str4)) {
                            break;
                        } else {
                            i12++;
                        }
                    }
                    if (str2 != null) {
                        return str2;
                    }
                }
            } else if (!z12) {
                return null;
            } else {
                if (!str3.equals(str)) {
                    do {
                        StringBuffer stringBuffer = new StringBuffer();
                        stringBuffer.append(GoogleApiAvailabilityLight.TRACKING_SOURCE_NOTIFICATION);
                        int i13 = this.f25520c;
                        this.f25520c = i13 + 1;
                        stringBuffer.append(i13);
                        String stringBuffer2 = stringBuffer.toString();
                        int i14 = (this.f25523f[this.f25521d + 1] * 2) - 2;
                        while (true) {
                            if (i14 < 0) {
                                str3 = stringBuffer2;
                                continue;
                                break;
                            } else if (stringBuffer2.equals(this.f25524g[i14])) {
                                str3 = null;
                                continue;
                                break;
                            } else {
                                i14 -= 2;
                            }
                        }
                    } while (str3 == null);
                } else {
                    boolean z13 = this.f25519b;
                    this.f25519b = false;
                    setPrefix(str3, str);
                    this.f25519b = z13;
                }
                boolean z132 = this.f25519b;
                this.f25519b = false;
                setPrefix(str3, str);
                this.f25519b = z132;
                return str3;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002b, code lost:
        if (r1 != '\'') goto L_0x004f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void c(java.lang.String r6, int r7) throws java.io.IOException {
        /*
            r5 = this;
            r0 = 0
        L_0x0001:
            int r1 = r6.length()
            if (r0 >= r1) goto L_0x009a
            char r1 = r6.charAt(r0)
            r2 = 9
            java.lang.String r3 = "&#"
            if (r1 == r2) goto L_0x007a
            r2 = 10
            if (r1 == r2) goto L_0x007a
            r2 = 13
            if (r1 == r2) goto L_0x007a
            r2 = 34
            if (r1 == r2) goto L_0x0040
            r4 = 60
            if (r1 == r4) goto L_0x003b
            r4 = 62
            if (r1 == r4) goto L_0x0036
            r4 = 38
            if (r1 == r4) goto L_0x002e
            r4 = 39
            if (r1 == r4) goto L_0x0040
            goto L_0x004f
        L_0x002e:
            java.io.Writer r1 = r5.f25518a
            java.lang.String r2 = "&amp;"
        L_0x0032:
            r1.write(r2)
            goto L_0x0096
        L_0x0036:
            java.io.Writer r1 = r5.f25518a
            java.lang.String r2 = "&gt;"
            goto L_0x0032
        L_0x003b:
            java.io.Writer r1 = r5.f25518a
            java.lang.String r2 = "&lt;"
            goto L_0x0032
        L_0x0040:
            if (r1 != r7) goto L_0x004f
            java.io.Writer r3 = r5.f25518a
            if (r1 != r2) goto L_0x0049
            java.lang.String r1 = "&quot;"
            goto L_0x004b
        L_0x0049:
            java.lang.String r1 = "&apos;"
        L_0x004b:
            r3.write(r1)
            goto L_0x0096
        L_0x004f:
            r2 = 32
            if (r1 < r2) goto L_0x0060
            r2 = 64
            if (r1 == r2) goto L_0x0060
            r2 = 127(0x7f, float:1.78E-43)
            if (r1 < r2) goto L_0x007d
            boolean r2 = r5.f25526i
            if (r2 == 0) goto L_0x0060
            goto L_0x007d
        L_0x0060:
            java.io.Writer r2 = r5.f25518a
            java.lang.StringBuffer r4 = new java.lang.StringBuffer
            r4.<init>()
            r4.append(r3)
            r4.append(r1)
            java.lang.String r1 = ";"
            r4.append(r1)
        L_0x0072:
            java.lang.String r1 = r4.toString()
            r2.write(r1)
            goto L_0x0096
        L_0x007a:
            r2 = -1
            if (r7 != r2) goto L_0x0083
        L_0x007d:
            java.io.Writer r2 = r5.f25518a
            r2.write(r1)
            goto L_0x0096
        L_0x0083:
            java.io.Writer r2 = r5.f25518a
            java.lang.StringBuffer r4 = new java.lang.StringBuffer
            r4.<init>()
            r4.append(r3)
            r4.append(r1)
            r1 = 59
            r4.append(r1)
            goto L_0x0072
        L_0x0096:
            int r0 = r0 + 1
            goto L_0x0001
        L_0x009a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.kxml2.io.KXmlSerializer.c(java.lang.String, int):void");
    }

    public void cdsect(String str) throws IOException {
        a(false);
        this.f25518a.write("<![CDATA[");
        this.f25518a.write(str);
        this.f25518a.write("]]>");
    }

    public void comment(String str) throws IOException {
        a(false);
        this.f25518a.write("<!--");
        this.f25518a.write(str);
        this.f25518a.write("-->");
    }

    public void docdecl(String str) throws IOException {
        this.f25518a.write("<!DOCTYPE");
        this.f25518a.write(str);
        this.f25518a.write(">");
    }

    public void endDocument() throws IOException {
        while (true) {
            int i11 = this.f25521d;
            if (i11 > 0) {
                String[] strArr = this.f25522e;
                endTag(strArr[(i11 * 3) - 3], strArr[(i11 * 3) - 1]);
            } else {
                flush();
                return;
            }
        }
    }

    public XmlSerializer endTag(String str, String str2) throws IOException {
        if (!this.f25519b) {
            this.f25521d--;
        }
        if ((str != null || this.f25522e[this.f25521d * 3] == null) && ((str == null || str.equals(this.f25522e[this.f25521d * 3])) && this.f25522e[(this.f25521d * 3) + 2].equals(str2))) {
            if (this.f25519b) {
                a(true);
                this.f25521d--;
            } else {
                if (this.f25525h[this.f25521d + 1]) {
                    this.f25518a.write(LogUtils.NEW_LINE);
                    for (int i11 = 0; i11 < this.f25521d; i11++) {
                        this.f25518a.write("  ");
                    }
                }
                this.f25518a.write("</");
                String str3 = this.f25522e[(this.f25521d * 3) + 1];
                if (!"".equals(str3)) {
                    this.f25518a.write(str3);
                    this.f25518a.write(58);
                }
                this.f25518a.write(str2);
                this.f25518a.write(62);
            }
            int[] iArr = this.f25523f;
            int i12 = this.f25521d;
            iArr[i12 + 1] = iArr[i12];
            return this;
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("</{");
        stringBuffer.append(str);
        stringBuffer.append("}");
        stringBuffer.append(str2);
        stringBuffer.append("> does not match start");
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    public void entityRef(String str) throws IOException {
        a(false);
        this.f25518a.write(38);
        this.f25518a.write(str);
        this.f25518a.write(59);
    }

    public void flush() throws IOException {
        a(false);
        this.f25518a.flush();
    }

    public int getDepth() {
        return this.f25519b ? this.f25521d + 1 : this.f25521d;
    }

    public boolean getFeature(String str) {
        if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(str)) {
            return this.f25525h[this.f25521d];
        }
        return false;
    }

    public String getName() {
        if (getDepth() == 0) {
            return null;
        }
        return this.f25522e[(getDepth() * 3) - 1];
    }

    public String getNamespace() {
        if (getDepth() == 0) {
            return null;
        }
        return this.f25522e[(getDepth() * 3) - 3];
    }

    public String getPrefix(String str, boolean z11) {
        try {
            return b(str, false, z11);
        } catch (IOException e11) {
            throw new RuntimeException(e11.toString());
        }
    }

    public Object getProperty(String str) {
        throw new RuntimeException("Unsupported property");
    }

    public void ignorableWhitespace(String str) throws IOException {
        text(str);
    }

    public void processingInstruction(String str) throws IOException {
        a(false);
        this.f25518a.write("<?");
        this.f25518a.write(str);
        this.f25518a.write("?>");
    }

    public void setFeature(String str, boolean z11) {
        if ("http://xmlpull.org/v1/doc/features.html#indent-output".equals(str)) {
            this.f25525h[this.f25521d] = z11;
            return;
        }
        throw new RuntimeException("Unsupported Feature");
    }

    public void setOutput(OutputStream outputStream, String str) throws IOException {
        OutputStreamWriter outputStreamWriter;
        if (outputStream != null) {
            if (str != null) {
                outputStreamWriter = new OutputStreamWriter(outputStream, str);
            }
            setOutput(outputStreamWriter);
            this.f25527j = str;
            if (str != null && str.toLowerCase().startsWith("utf")) {
                this.f25526i = true;
                return;
            }
            return;
        }
        throw new IllegalArgumentException();
    }

    public void setOutput(Writer writer) {
        this.f25518a = writer;
        int[] iArr = this.f25523f;
        iArr[0] = 2;
        iArr[1] = 2;
        String[] strArr = this.f25524g;
        strArr[0] = "";
        strArr[1] = "";
        strArr[2] = "xml";
        strArr[3] = "http://www.w3.org/XML/1998/namespace";
        this.f25519b = false;
        this.f25520c = 0;
        this.f25521d = 0;
        this.f25526i = false;
    }

    public void setPrefix(String str, String str2) throws IOException {
        a(false);
        if (str == null) {
            str = "";
        }
        if (str2 == null) {
            str2 = "";
        }
        if (!str.equals(b(str2, true, false))) {
            int[] iArr = this.f25523f;
            int i11 = this.f25521d + 1;
            int i12 = iArr[i11];
            iArr[i11] = i12 + 1;
            int i13 = i12 << 1;
            String[] strArr = this.f25524g;
            int i14 = i13 + 1;
            if (strArr.length < i14) {
                String[] strArr2 = new String[(strArr.length + 16)];
                System.arraycopy(strArr, 0, strArr2, 0, i13);
                this.f25524g = strArr2;
            }
            String[] strArr3 = this.f25524g;
            strArr3[i13] = str;
            strArr3[i14] = str2;
        }
    }

    public void setProperty(String str, Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("Unsupported Property:");
        stringBuffer.append(obj);
        throw new RuntimeException(stringBuffer.toString());
    }

    public void startDocument(String str, Boolean bool) throws IOException {
        this.f25518a.write("<?xml version='1.0' ");
        if (str != null) {
            this.f25527j = str;
            if (str.toLowerCase().startsWith("utf")) {
                this.f25526i = true;
            }
        }
        if (this.f25527j != null) {
            this.f25518a.write("encoding='");
            this.f25518a.write(this.f25527j);
            this.f25518a.write("' ");
        }
        if (bool != null) {
            this.f25518a.write("standalone='");
            this.f25518a.write(bool.booleanValue() ? "yes" : "no");
            this.f25518a.write("' ");
        }
        this.f25518a.write("?>");
    }

    public XmlSerializer startTag(String str, String str2) throws IOException {
        a(false);
        if (this.f25525h[this.f25521d]) {
            this.f25518a.write(LogUtils.NEW_LINE);
            for (int i11 = 0; i11 < this.f25521d; i11++) {
                this.f25518a.write("  ");
            }
        }
        int i12 = this.f25521d * 3;
        String[] strArr = this.f25522e;
        if (strArr.length < i12 + 3) {
            String[] strArr2 = new String[(strArr.length + 12)];
            System.arraycopy(strArr, 0, strArr2, 0, i12);
            this.f25522e = strArr2;
        }
        String b11 = str == null ? "" : b(str, true, true);
        if ("".equals(str)) {
            int i13 = this.f25523f[this.f25521d];
            while (i13 < this.f25523f[this.f25521d + 1]) {
                int i14 = i13 * 2;
                if (!"".equals(this.f25524g[i14]) || "".equals(this.f25524g[i14 + 1])) {
                    i13++;
                } else {
                    throw new IllegalStateException("Cannot set default namespace for elements in no namespace");
                }
            }
        }
        String[] strArr3 = this.f25522e;
        int i15 = i12 + 1;
        strArr3[i12] = str;
        strArr3[i15] = b11;
        strArr3[i15 + 1] = str2;
        this.f25518a.write(60);
        if (!"".equals(b11)) {
            this.f25518a.write(b11);
            this.f25518a.write(58);
        }
        this.f25518a.write(str2);
        this.f25519b = true;
        return this;
    }

    public XmlSerializer text(String str) throws IOException {
        a(false);
        this.f25525h[this.f25521d] = false;
        c(str, -1);
        return this;
    }

    public XmlSerializer text(char[] cArr, int i11, int i12) throws IOException {
        text(new String(cArr, i11, i12));
        return this;
    }
}
