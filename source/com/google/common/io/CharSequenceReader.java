package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.IOException;
import java.io.Reader;
import java.nio.CharBuffer;

@GwtIncompatible
final class CharSequenceReader extends Reader {
    private int mark;
    private int pos;
    private CharSequence seq;

    public CharSequenceReader(CharSequence charSequence) {
        this.seq = (CharSequence) Preconditions.checkNotNull(charSequence);
    }

    private void checkOpen() throws IOException {
        if (this.seq == null) {
            throw new IOException("reader closed");
        }
    }

    private boolean hasRemaining() {
        return remaining() > 0;
    }

    private int remaining() {
        return this.seq.length() - this.pos;
    }

    public synchronized void close() throws IOException {
        this.seq = null;
    }

    public synchronized void mark(int i11) throws IOException {
        Preconditions.checkArgument(i11 >= 0, "readAheadLimit (%s) may not be negative", i11);
        checkOpen();
        this.mark = this.pos;
    }

    public boolean markSupported() {
        return true;
    }

    public synchronized int read(CharBuffer charBuffer) throws IOException {
        Preconditions.checkNotNull(charBuffer);
        checkOpen();
        if (!hasRemaining()) {
            return -1;
        }
        int min = Math.min(charBuffer.remaining(), remaining());
        for (int i11 = 0; i11 < min; i11++) {
            CharSequence charSequence = this.seq;
            int i12 = this.pos;
            this.pos = i12 + 1;
            charBuffer.put(charSequence.charAt(i12));
        }
        return min;
    }

    public synchronized boolean ready() throws IOException {
        checkOpen();
        return true;
    }

    public synchronized void reset() throws IOException {
        checkOpen();
        this.pos = this.mark;
    }

    public synchronized long skip(long j11) throws IOException {
        int min;
        Preconditions.checkArgument(j11 >= 0, "n (%s) may not be negative", j11);
        checkOpen();
        min = (int) Math.min((long) remaining(), j11);
        this.pos += min;
        return (long) min;
    }

    public synchronized int read() throws IOException {
        char c11;
        checkOpen();
        if (hasRemaining()) {
            CharSequence charSequence = this.seq;
            int i11 = this.pos;
            this.pos = i11 + 1;
            c11 = charSequence.charAt(i11);
        } else {
            c11 = 65535;
        }
        return c11;
    }

    public synchronized int read(char[] cArr, int i11, int i12) throws IOException {
        Preconditions.checkPositionIndexes(i11, i11 + i12, cArr.length);
        checkOpen();
        if (!hasRemaining()) {
            return -1;
        }
        int min = Math.min(i12, remaining());
        for (int i13 = 0; i13 < min; i13++) {
            CharSequence charSequence = this.seq;
            int i14 = this.pos;
            this.pos = i14 + 1;
            cArr[i11 + i13] = charSequence.charAt(i14);
        }
        return min;
    }
}
