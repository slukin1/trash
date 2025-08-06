package org.apache.commons.io.output;

import java.io.Writer;

public class NullWriter extends Writer {

    /* renamed from: b  reason: collision with root package name */
    public static final NullWriter f58965b = new NullWriter();

    public Writer append(char c11) {
        return this;
    }

    public Writer append(CharSequence charSequence) {
        return this;
    }

    public Writer append(CharSequence charSequence, int i11, int i12) {
        return this;
    }

    public void close() {
    }

    public void flush() {
    }

    public void write(int i11) {
    }

    public void write(String str) {
    }

    public void write(String str, int i11, int i12) {
    }

    public void write(char[] cArr) {
    }

    public void write(char[] cArr, int i11, int i12) {
    }
}
