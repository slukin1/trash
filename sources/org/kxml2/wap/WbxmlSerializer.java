package org.kxml2.wap;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.Hashtable;
import java.util.Vector;
import org.xmlpull.v1.XmlSerializer;

public class WbxmlSerializer implements XmlSerializer {

    /* renamed from: a  reason: collision with root package name */
    public Hashtable f25554a = new Hashtable();

    /* renamed from: b  reason: collision with root package name */
    public OutputStream f25555b;

    /* renamed from: c  reason: collision with root package name */
    public ByteArrayOutputStream f25556c = new ByteArrayOutputStream();

    /* renamed from: d  reason: collision with root package name */
    public ByteArrayOutputStream f25557d = new ByteArrayOutputStream();

    /* renamed from: e  reason: collision with root package name */
    public String f25558e;

    /* renamed from: f  reason: collision with root package name */
    public int f25559f;

    /* renamed from: g  reason: collision with root package name */
    public Vector f25560g = new Vector();

    /* renamed from: h  reason: collision with root package name */
    public Hashtable f25561h = new Hashtable();

    /* renamed from: i  reason: collision with root package name */
    public Hashtable f25562i = new Hashtable();

    /* renamed from: j  reason: collision with root package name */
    public Hashtable f25563j = new Hashtable();

    /* renamed from: k  reason: collision with root package name */
    public int f25564k;

    /* renamed from: l  reason: collision with root package name */
    public int f25565l;

    /* renamed from: m  reason: collision with root package name */
    public String f25566m;

    public static void b(OutputStream outputStream, int i11) throws IOException {
        int i12;
        byte[] bArr = new byte[5];
        int i13 = 0;
        while (true) {
            i12 = i13 + 1;
            bArr[i13] = (byte) (i11 & 127);
            i11 >>= 7;
            if (i11 == 0) {
                break;
            }
            i13 = i12;
        }
        while (i12 > 1) {
            i12--;
            outputStream.write(bArr[i12] | 128);
        }
        outputStream.write(bArr[0]);
    }

    public void a(boolean z11) throws IOException {
        if (this.f25558e != null) {
            int size = this.f25560g.size();
            int[] iArr = (int[]) this.f25563j.get(this.f25558e);
            if (iArr == null) {
                this.f25556c.write(size == 0 ? z11 ? 4 : 68 : z11 ? 132 : 196);
                e(this.f25558e, false);
            } else {
                if (iArr[0] != this.f25565l) {
                    this.f25565l = iArr[0];
                    this.f25556c.write(0);
                    this.f25556c.write(this.f25565l);
                }
                this.f25556c.write(size == 0 ? z11 ? iArr[1] : iArr[1] | 64 : z11 ? iArr[1] | 128 : iArr[1] | 192);
            }
            int i11 = 0;
            while (i11 < size) {
                int[] iArr2 = (int[]) this.f25561h.get(this.f25560g.elementAt(i11));
                if (iArr2 == null) {
                    this.f25556c.write(4);
                    e((String) this.f25560g.elementAt(i11), false);
                } else {
                    if (iArr2[0] != this.f25564k) {
                        this.f25564k = iArr2[0];
                        this.f25556c.write(0);
                        this.f25556c.write(this.f25564k);
                    }
                    this.f25556c.write(iArr2[1]);
                }
                int i12 = i11 + 1;
                int[] iArr3 = (int[]) this.f25562i.get(this.f25560g.elementAt(i12));
                if (iArr3 == null) {
                    c((String) this.f25560g.elementAt(i12));
                } else {
                    if (iArr3[0] != this.f25564k) {
                        this.f25564k = iArr3[0];
                        this.f25556c.write(0);
                        this.f25556c.write(this.f25564k);
                    }
                    this.f25556c.write(iArr3[1]);
                }
                i11 = i12 + 1;
            }
            if (size > 0) {
                this.f25556c.write(1);
            }
            this.f25558e = null;
            this.f25560g.removeAllElements();
        }
    }

    public XmlSerializer attribute(String str, String str2, String str3) {
        this.f25560g.addElement(str2);
        this.f25560g.addElement(str3);
        return this;
    }

    public final void c(String str) throws IOException {
        int length = str.length();
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            while (i11 < length && str.charAt(i11) < 'A') {
                i11++;
            }
            int i13 = i11;
            while (i13 < length && str.charAt(i13) >= 'A') {
                i13++;
            }
            if (i13 - i11 > 10) {
                if (i11 > i12 && str.charAt(i11 - 1) == ' ' && this.f25554a.get(str.substring(i11, i13)) == null) {
                    this.f25556c.write(131);
                    e(str.substring(i12, i13), false);
                } else {
                    if (i11 > i12 && str.charAt(i11 - 1) == ' ') {
                        i11--;
                    }
                    if (i11 > i12) {
                        this.f25556c.write(131);
                        e(str.substring(i12, i11), false);
                    }
                    this.f25556c.write(131);
                    e(str.substring(i11, i13), true);
                }
                i12 = i13;
            }
            i11 = i13;
        }
        if (i12 < length) {
            this.f25556c.write(131);
            e(str.substring(i12, length), false);
        }
    }

    public void cdsect(String str) throws IOException {
        text(str);
    }

    public void comment(String str) {
    }

    public void d(OutputStream outputStream, String str) throws IOException {
        outputStream.write(str.getBytes(this.f25566m));
        outputStream.write(0);
    }

    public void docdecl(String str) {
        throw new RuntimeException("Cannot write docdecl for WBXML");
    }

    public final void e(String str, boolean z11) throws IOException {
        Integer num = (Integer) this.f25554a.get(str);
        if (num != null) {
            b(this.f25556c, num.intValue());
            return;
        }
        int size = this.f25557d.size();
        if (str.charAt(0) < '0' || !z11) {
            b(this.f25556c, size);
        } else {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(' ');
            stringBuffer.append(str);
            str = stringBuffer.toString();
            b(this.f25556c, size + 1);
        }
        this.f25554a.put(str, new Integer(size));
        if (str.charAt(0) == ' ') {
            this.f25554a.put(str.substring(1), new Integer(size + 1));
        }
        int lastIndexOf = str.lastIndexOf(32);
        if (lastIndexOf > 1) {
            int i11 = size + lastIndexOf;
            this.f25554a.put(str.substring(lastIndexOf), new Integer(i11));
            this.f25554a.put(str.substring(lastIndexOf + 1), new Integer(i11 + 1));
        }
        d(this.f25557d, str);
        this.f25557d.flush();
    }

    public void endDocument() throws IOException {
        b(this.f25555b, this.f25557d.size());
        this.f25555b.write(this.f25557d.toByteArray());
        this.f25555b.write(this.f25556c.toByteArray());
        this.f25555b.flush();
    }

    public XmlSerializer endTag(String str, String str2) throws IOException {
        if (this.f25558e != null) {
            a(true);
        } else {
            this.f25556c.write(1);
        }
        this.f25559f--;
        return this;
    }

    public void entityRef(String str) {
        throw new RuntimeException("EntityReference not supported for WBXML");
    }

    public void flush() {
    }

    public int getDepth() {
        return this.f25559f;
    }

    public boolean getFeature(String str) {
        return false;
    }

    public String getName() {
        throw new RuntimeException("NYI");
    }

    public String getNamespace() {
        throw new RuntimeException("NYI");
    }

    public String getPrefix(String str, boolean z11) {
        throw new RuntimeException("NYI");
    }

    public Object getProperty(String str) {
        return null;
    }

    public void ignorableWhitespace(String str) {
    }

    public void processingInstruction(String str) {
        throw new RuntimeException("PI NYI");
    }

    public void setFeature(String str, boolean z11) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("unknown feature ");
        stringBuffer.append(str);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    public void setOutput(OutputStream outputStream, String str) throws IOException {
        if (str == null) {
            str = "UTF-8";
        }
        this.f25566m = str;
        this.f25555b = outputStream;
        this.f25556c = new ByteArrayOutputStream();
        this.f25557d = new ByteArrayOutputStream();
    }

    public void setOutput(Writer writer) {
        throw new RuntimeException("Wbxml requires an OutputStream!");
    }

    public void setPrefix(String str, String str2) {
        throw new RuntimeException("NYI");
    }

    public void setProperty(String str, Object obj) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("unknown property ");
        stringBuffer.append(str);
        throw new IllegalArgumentException(stringBuffer.toString());
    }

    public void startDocument(String str, Boolean bool) throws IOException {
        OutputStream outputStream;
        int i11;
        this.f25555b.write(3);
        this.f25555b.write(1);
        if (str != null) {
            this.f25566m = str;
        }
        if (this.f25566m.toUpperCase().equals("UTF-8")) {
            outputStream = this.f25555b;
            i11 = 106;
        } else if (this.f25566m.toUpperCase().equals("ISO-8859-1")) {
            outputStream = this.f25555b;
            i11 = 4;
        } else {
            throw new UnsupportedEncodingException(str);
        }
        outputStream.write(i11);
    }

    public XmlSerializer startTag(String str, String str2) throws IOException {
        if (str == null || "".equals(str)) {
            a(false);
            this.f25558e = str2;
            this.f25559f++;
            return this;
        }
        throw new RuntimeException("NSP NYI");
    }

    public XmlSerializer text(String str) throws IOException {
        a(false);
        c(str);
        return this;
    }

    public XmlSerializer text(char[] cArr, int i11, int i12) throws IOException {
        a(false);
        c(new String(cArr, i11, i12));
        return this;
    }
}
