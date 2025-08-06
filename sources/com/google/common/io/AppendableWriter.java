package com.google.common.io;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Preconditions;
import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;

@GwtIncompatible
class AppendableWriter extends Writer {
    private boolean closed;
    private final Appendable target;

    public AppendableWriter(Appendable appendable) {
        this.target = (Appendable) Preconditions.checkNotNull(appendable);
    }

    private void checkNotClosed() throws IOException {
        if (this.closed) {
            throw new IOException("Cannot write to a closed writer.");
        }
    }

    public void close() throws IOException {
        this.closed = true;
        Appendable appendable = this.target;
        if (appendable instanceof Closeable) {
            ((Closeable) appendable).close();
        }
    }

    public void flush() throws IOException {
        checkNotClosed();
        Appendable appendable = this.target;
        if (appendable instanceof Flushable) {
            ((Flushable) appendable).flush();
        }
    }

    public void write(char[] cArr, int i11, int i12) throws IOException {
        checkNotClosed();
        this.target.append(new String(cArr, i11, i12));
    }

    public void write(int i11) throws IOException {
        checkNotClosed();
        this.target.append((char) i11);
    }

    public Writer append(char c11) throws IOException {
        checkNotClosed();
        this.target.append(c11);
        return this;
    }

    public void write(String str) throws IOException {
        checkNotClosed();
        this.target.append(str);
    }

    public Writer append(CharSequence charSequence) throws IOException {
        checkNotClosed();
        this.target.append(charSequence);
        return this;
    }

    public void write(String str, int i11, int i12) throws IOException {
        checkNotClosed();
        this.target.append(str, i11, i12 + i11);
    }

    public Writer append(CharSequence charSequence, int i11, int i12) throws IOException {
        checkNotClosed();
        this.target.append(charSequence, i11, i12);
        return this;
    }
}
