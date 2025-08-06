package org.apache.commons.io.input;

import java.io.Reader;
import java.io.Serializable;
import java.util.Objects;

public class CharSequenceReader extends Reader implements Serializable {
    private static final long serialVersionUID = 3724187752191401220L;
    private final CharSequence charSequence;
    private int idx;
    private int mark;

    public CharSequenceReader(String str) {
        this.charSequence = str == null ? "" : str;
    }

    public void close() {
        this.idx = 0;
        this.mark = 0;
    }

    public void mark(int i11) {
        this.mark = this.idx;
    }

    public boolean markSupported() {
        return true;
    }

    public int read() {
        if (this.idx >= this.charSequence.length()) {
            return -1;
        }
        CharSequence charSequence2 = this.charSequence;
        int i11 = this.idx;
        this.idx = i11 + 1;
        return charSequence2.charAt(i11);
    }

    public void reset() {
        this.idx = this.mark;
    }

    public long skip(long j11) {
        if (j11 < 0) {
            throw new IllegalArgumentException("Number of characters to skip is less than zero: " + j11);
        } else if (this.idx >= this.charSequence.length()) {
            return -1;
        } else {
            int min = (int) Math.min((long) this.charSequence.length(), ((long) this.idx) + j11);
            this.idx = min;
            return (long) (min - this.idx);
        }
    }

    public String toString() {
        return this.charSequence.toString();
    }

    public int read(char[] cArr, int i11, int i12) {
        if (this.idx >= this.charSequence.length()) {
            return -1;
        }
        Objects.requireNonNull(cArr, "Character array is missing");
        if (i12 < 0 || i11 < 0 || i11 + i12 > cArr.length) {
            throw new IndexOutOfBoundsException("Array Size=" + cArr.length + ", offset=" + i11 + ", length=" + i12);
        }
        int i13 = 0;
        for (int i14 = 0; i14 < i12; i14++) {
            int read = read();
            if (read == -1) {
                return i13;
            }
            cArr[i11 + i14] = (char) read;
            i13++;
        }
        return i13;
    }
}
