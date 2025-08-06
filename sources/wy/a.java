package wy;

import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;
import java.nio.charset.CoderResult;
import java.nio.charset.IllegalCharsetNameException;
import java.nio.charset.UnsupportedCharsetException;
import org.xmlpull.v1.XmlSerializer;

public class a implements XmlSerializer {

    /* renamed from: h  reason: collision with root package name */
    public static final String[] f40631h = {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&quot;", null, null, null, "&amp;", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "&lt;", null, "&gt;", null};

    /* renamed from: a  reason: collision with root package name */
    public final char[] f40632a = new char[8192];

    /* renamed from: b  reason: collision with root package name */
    public int f40633b;

    /* renamed from: c  reason: collision with root package name */
    public Writer f40634c;

    /* renamed from: d  reason: collision with root package name */
    public OutputStream f40635d;

    /* renamed from: e  reason: collision with root package name */
    public CharsetEncoder f40636e;

    /* renamed from: f  reason: collision with root package name */
    public ByteBuffer f40637f = ByteBuffer.allocate(8192);

    /* renamed from: g  reason: collision with root package name */
    public boolean f40638g;

    public final void a(String str, int i11, int i12) throws IOException {
        if (i12 > 8192) {
            int i13 = i12 + i11;
            while (i11 < i13) {
                int i14 = i11 + 8192;
                a(str, i11, i14 < i13 ? 8192 : i13 - i11);
                i11 = i14;
            }
            return;
        }
        int i15 = this.f40633b;
        if (i15 + i12 > 8192) {
            flush();
            i15 = this.f40633b;
        }
        str.getChars(i11, i11 + i12, this.f40632a, i15);
        this.f40633b = i15 + i12;
    }

    public XmlSerializer attribute(String str, String str2, String str3) throws IOException, IllegalArgumentException, IllegalStateException {
        c(' ');
        if (str != null) {
            d(str);
            c(':');
        }
        d(str2);
        d("=\"");
        f(str3);
        c('\"');
        return this;
    }

    public final void b(char[] cArr, int i11, int i12) throws IOException {
        String str;
        String[] strArr = f40631h;
        char length = (char) strArr.length;
        int i13 = i12 + i11;
        int i14 = i11;
        while (i11 < i13) {
            char c11 = cArr[i11];
            if (c11 < length && (str = strArr[c11]) != null) {
                if (i14 < i11) {
                    e(cArr, i14, i11 - i14);
                }
                i14 = i11 + 1;
                d(str);
            }
            i11++;
        }
        if (i14 < i11) {
            e(cArr, i14, i11 - i14);
        }
    }

    public final void c(char c11) throws IOException {
        int i11 = this.f40633b;
        if (i11 >= 8191) {
            flush();
            i11 = this.f40633b;
        }
        this.f40632a[i11] = c11;
        this.f40633b = i11 + 1;
    }

    public void cdsect(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void comment(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void d(String str) throws IOException {
        a(str, 0, str.length());
    }

    public void docdecl(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void e(char[] cArr, int i11, int i12) throws IOException {
        if (i12 > 8192) {
            int i13 = i12 + i11;
            while (i11 < i13) {
                int i14 = i11 + 8192;
                e(cArr, i11, i14 < i13 ? 8192 : i13 - i11);
                i11 = i14;
            }
            return;
        }
        int i15 = this.f40633b;
        if (i15 + i12 > 8192) {
            flush();
            i15 = this.f40633b;
        }
        System.arraycopy(cArr, i11, this.f40632a, i15, i12);
        this.f40633b = i15 + i12;
    }

    public void endDocument() throws IOException, IllegalArgumentException, IllegalStateException {
        flush();
    }

    public XmlSerializer endTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f40638g) {
            d(" />\n");
        } else {
            d("</");
            if (str != null) {
                d(str);
                c(':');
            }
            d(str2);
            d(">\n");
        }
        this.f40638g = false;
        return this;
    }

    public void entityRef(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public final void f(String str) throws IOException {
        String str2;
        int length = str.length();
        String[] strArr = f40631h;
        char length2 = (char) strArr.length;
        int i11 = 0;
        int i12 = 0;
        while (i11 < length) {
            char charAt = str.charAt(i11);
            if (charAt < length2 && (str2 = strArr[charAt]) != null) {
                if (i12 < i11) {
                    a(str, i12, i11 - i12);
                }
                i12 = i11 + 1;
                d(str2);
            }
            i11++;
        }
        if (i12 < i11) {
            a(str, i12, i11 - i12);
        }
    }

    public void flush() throws IOException {
        int i11 = this.f40633b;
        if (i11 > 0) {
            if (this.f40635d != null) {
                CharBuffer wrap = CharBuffer.wrap(this.f40632a, 0, i11);
                CoderResult encode = this.f40636e.encode(wrap, this.f40637f, true);
                while (!encode.isError()) {
                    if (encode.isOverflow()) {
                        g();
                        encode = this.f40636e.encode(wrap, this.f40637f, true);
                    } else {
                        g();
                        this.f40635d.flush();
                    }
                }
                throw new IOException(encode.toString());
            }
            this.f40634c.write(this.f40632a, 0, i11);
            this.f40634c.flush();
            this.f40633b = 0;
        }
    }

    public final void g() throws IOException {
        int position = this.f40637f.position();
        if (position > 0) {
            this.f40637f.flip();
            this.f40635d.write(this.f40637f.array(), 0, position);
            this.f40637f.clear();
        }
    }

    public int getDepth() {
        throw new UnsupportedOperationException();
    }

    public boolean getFeature(String str) {
        throw new UnsupportedOperationException();
    }

    public String getName() {
        throw new UnsupportedOperationException();
    }

    public String getNamespace() {
        throw new UnsupportedOperationException();
    }

    public String getPrefix(String str, boolean z11) throws IllegalArgumentException {
        throw new UnsupportedOperationException();
    }

    public Object getProperty(String str) {
        throw new UnsupportedOperationException();
    }

    public void ignorableWhitespace(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void processingInstruction(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void setFeature(String str, boolean z11) throws IllegalArgumentException, IllegalStateException {
        if (!str.equals("http://xmlpull.org/v1/doc/features.html#indent-output")) {
            throw new UnsupportedOperationException();
        }
    }

    public void setOutput(OutputStream outputStream, String str) throws IOException, IllegalArgumentException, IllegalStateException {
        if (outputStream != null) {
            try {
                this.f40636e = Charset.forName(str).newEncoder();
                this.f40635d = outputStream;
            } catch (IllegalCharsetNameException e11) {
                throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e11));
            } catch (UnsupportedCharsetException e12) {
                throw ((UnsupportedEncodingException) new UnsupportedEncodingException(str).initCause(e12));
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public void setPrefix(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void setProperty(String str, Object obj) throws IllegalArgumentException, IllegalStateException {
        throw new UnsupportedOperationException();
    }

    public void startDocument(String str, Boolean bool) throws IOException, IllegalArgumentException, IllegalStateException {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("<?xml version='1.0' encoding='utf-8' standalone='");
        sb2.append(bool.booleanValue() ? "yes" : "no");
        sb2.append("' ?>\n");
        d(sb2.toString());
    }

    public XmlSerializer startTag(String str, String str2) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f40638g) {
            d(">\n");
        }
        c('<');
        if (str != null) {
            d(str);
            c(':');
        }
        d(str2);
        this.f40638g = true;
        return this;
    }

    public XmlSerializer text(char[] cArr, int i11, int i12) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f40638g) {
            d(">");
            this.f40638g = false;
        }
        b(cArr, i11, i12);
        return this;
    }

    public XmlSerializer text(String str) throws IOException, IllegalArgumentException, IllegalStateException {
        if (this.f40638g) {
            d(">");
            this.f40638g = false;
        }
        f(str);
        return this;
    }

    public void setOutput(Writer writer) throws IOException, IllegalArgumentException, IllegalStateException {
        this.f40634c = writer;
    }
}
