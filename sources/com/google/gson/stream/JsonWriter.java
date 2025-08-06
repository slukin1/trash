package com.google.gson.stream;

import com.iproov.sdk.bridge.OptionsBridge;
import com.sumsub.sns.internal.core.analytics.d;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Objects;

public class JsonWriter implements Closeable, Flushable {
    private static final String[] HTML_SAFE_REPLACEMENT_CHARS;
    private static final String[] REPLACEMENT_CHARS = new String[128];
    private String deferredName;
    private boolean htmlSafe;
    private String indent;
    private boolean lenient;
    private final Writer out;
    private String separator;
    private boolean serializeNulls;
    private int[] stack = new int[32];
    private int stackSize = 0;

    static {
        for (int i11 = 0; i11 <= 31; i11++) {
            REPLACEMENT_CHARS[i11] = String.format("\\u%04x", new Object[]{Integer.valueOf(i11)});
        }
        String[] strArr = REPLACEMENT_CHARS;
        strArr[34] = "\\\"";
        strArr[92] = "\\\\";
        strArr[9] = "\\t";
        strArr[8] = "\\b";
        strArr[10] = "\\n";
        strArr[13] = "\\r";
        strArr[12] = "\\f";
        String[] strArr2 = (String[]) strArr.clone();
        HTML_SAFE_REPLACEMENT_CHARS = strArr2;
        strArr2[60] = "\\u003c";
        strArr2[62] = "\\u003e";
        strArr2[38] = "\\u0026";
        strArr2[61] = "\\u003d";
        strArr2[39] = "\\u0027";
    }

    public JsonWriter(Writer writer) {
        push(6);
        this.separator = ":";
        this.serializeNulls = true;
        Objects.requireNonNull(writer, "out == null");
        this.out = writer;
    }

    private void beforeName() throws IOException {
        int peek = peek();
        if (peek == 5) {
            this.out.write(44);
        } else if (peek != 3) {
            throw new IllegalStateException("Nesting problem.");
        }
        newline();
        replaceTop(4);
    }

    private void beforeValue() throws IOException {
        int peek = peek();
        if (peek == 1) {
            replaceTop(2);
            newline();
        } else if (peek == 2) {
            this.out.append(',');
            newline();
        } else if (peek != 4) {
            if (peek != 6) {
                if (peek != 7) {
                    throw new IllegalStateException("Nesting problem.");
                } else if (!this.lenient) {
                    throw new IllegalStateException("JSON must have only one top-level value.");
                }
            }
            replaceTop(7);
        } else {
            this.out.append(this.separator);
            replaceTop(5);
        }
    }

    private JsonWriter close(int i11, int i12, String str) throws IOException {
        int peek = peek();
        if (peek != i12 && peek != i11) {
            throw new IllegalStateException("Nesting problem.");
        } else if (this.deferredName == null) {
            this.stackSize--;
            if (peek == i12) {
                newline();
            }
            this.out.write(str);
            return this;
        } else {
            throw new IllegalStateException("Dangling name: " + this.deferredName);
        }
    }

    private void newline() throws IOException {
        if (this.indent != null) {
            this.out.write("\n");
            int i11 = this.stackSize;
            for (int i12 = 1; i12 < i11; i12++) {
                this.out.write(this.indent);
            }
        }
    }

    private JsonWriter open(int i11, String str) throws IOException {
        beforeValue();
        push(i11);
        this.out.write(str);
        return this;
    }

    private int peek() {
        int i11 = this.stackSize;
        if (i11 != 0) {
            return this.stack[i11 - 1];
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    private void push(int i11) {
        int i12 = this.stackSize;
        int[] iArr = this.stack;
        if (i12 == iArr.length) {
            int[] iArr2 = new int[(i12 * 2)];
            System.arraycopy(iArr, 0, iArr2, 0, i12);
            this.stack = iArr2;
        }
        int[] iArr3 = this.stack;
        int i13 = this.stackSize;
        this.stackSize = i13 + 1;
        iArr3[i13] = i11;
    }

    private void replaceTop(int i11) {
        this.stack[this.stackSize - 1] = i11;
    }

    private void string(String str) throws IOException {
        String str2;
        String[] strArr = this.htmlSafe ? HTML_SAFE_REPLACEMENT_CHARS : REPLACEMENT_CHARS;
        this.out.write("\"");
        int length = str.length();
        int i11 = 0;
        for (int i12 = 0; i12 < length; i12++) {
            char charAt = str.charAt(i12);
            if (charAt < 128) {
                str2 = strArr[charAt];
                if (str2 == null) {
                }
            } else if (charAt == 8232) {
                str2 = "\\u2028";
            } else if (charAt == 8233) {
                str2 = "\\u2029";
            }
            if (i11 < i12) {
                this.out.write(str, i11, i12 - i11);
            }
            this.out.write(str2);
            i11 = i12 + 1;
        }
        if (i11 < length) {
            this.out.write(str, i11, length - i11);
        }
        this.out.write("\"");
    }

    private void writeDeferredName() throws IOException {
        if (this.deferredName != null) {
            beforeName();
            string(this.deferredName);
            this.deferredName = null;
        }
    }

    public JsonWriter beginArray() throws IOException {
        writeDeferredName();
        return open(1, "[");
    }

    public JsonWriter beginObject() throws IOException {
        writeDeferredName();
        return open(3, "{");
    }

    public JsonWriter endArray() throws IOException {
        return close(1, 2, "]");
    }

    public JsonWriter endObject() throws IOException {
        return close(3, 5, "}");
    }

    public void flush() throws IOException {
        if (this.stackSize != 0) {
            this.out.flush();
            return;
        }
        throw new IllegalStateException("JsonWriter is closed.");
    }

    public final boolean getSerializeNulls() {
        return this.serializeNulls;
    }

    public final boolean isHtmlSafe() {
        return this.htmlSafe;
    }

    public boolean isLenient() {
        return this.lenient;
    }

    public JsonWriter jsonValue(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue();
        this.out.append(str);
        return this;
    }

    public JsonWriter name(String str) throws IOException {
        Objects.requireNonNull(str, "name == null");
        if (this.deferredName != null) {
            throw new IllegalStateException();
        } else if (this.stackSize != 0) {
            this.deferredName = str;
            return this;
        } else {
            throw new IllegalStateException("JsonWriter is closed.");
        }
    }

    public JsonWriter nullValue() throws IOException {
        if (this.deferredName != null) {
            if (this.serializeNulls) {
                writeDeferredName();
            } else {
                this.deferredName = null;
                return this;
            }
        }
        beforeValue();
        this.out.write(OptionsBridge.NULL_VALUE);
        return this;
    }

    public final void setHtmlSafe(boolean z11) {
        this.htmlSafe = z11;
    }

    public final void setIndent(String str) {
        if (str.length() == 0) {
            this.indent = null;
            this.separator = ":";
            return;
        }
        this.indent = str;
        this.separator = l.f34627b;
    }

    public final void setLenient(boolean z11) {
        this.lenient = z11;
    }

    public final void setSerializeNulls(boolean z11) {
        this.serializeNulls = z11;
    }

    public JsonWriter value(String str) throws IOException {
        if (str == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue();
        string(str);
        return this;
    }

    public JsonWriter value(boolean z11) throws IOException {
        writeDeferredName();
        beforeValue();
        this.out.write(z11 ? "true" : d.f31895b);
        return this;
    }

    public void close() throws IOException {
        this.out.close();
        int i11 = this.stackSize;
        if (i11 > 1 || (i11 == 1 && this.stack[i11 - 1] != 7)) {
            throw new IOException("Incomplete document");
        }
        this.stackSize = 0;
    }

    public JsonWriter value(Boolean bool) throws IOException {
        if (bool == null) {
            return nullValue();
        }
        writeDeferredName();
        beforeValue();
        this.out.write(bool.booleanValue() ? "true" : d.f31895b);
        return this;
    }

    public JsonWriter value(double d11) throws IOException {
        writeDeferredName();
        if (this.lenient || (!Double.isNaN(d11) && !Double.isInfinite(d11))) {
            beforeValue();
            this.out.append(Double.toString(d11));
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + d11);
    }

    public JsonWriter value(long j11) throws IOException {
        writeDeferredName();
        beforeValue();
        this.out.write(Long.toString(j11));
        return this;
    }

    public JsonWriter value(Number number) throws IOException {
        if (number == null) {
            return nullValue();
        }
        writeDeferredName();
        String obj = number.toString();
        if (this.lenient || (!obj.equals("-Infinity") && !obj.equals("Infinity") && !obj.equals("NaN"))) {
            beforeValue();
            this.out.append(obj);
            return this;
        }
        throw new IllegalArgumentException("Numeric values must be finite, but was " + number);
    }
}
