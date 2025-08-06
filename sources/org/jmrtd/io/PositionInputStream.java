package org.jmrtd.io;

import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Logger;

public class PositionInputStream extends InputStream {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long MARK_NOT_SET = -1;
    private InputStream carrier;
    private long markedPosition = -1;
    private long position = 0;

    public PositionInputStream(InputStream inputStream) {
        this.carrier = inputStream;
    }

    public long getPosition() {
        return this.position;
    }

    public synchronized void mark(int i11) {
        this.carrier.mark(i11);
        this.markedPosition = this.position;
    }

    public boolean markSupported() {
        return this.carrier.markSupported();
    }

    public int read() throws IOException {
        int read = this.carrier.read();
        if (read >= 0) {
            this.position++;
        }
        return read;
    }

    public synchronized void reset() throws IOException {
        this.carrier.reset();
        this.position = this.markedPosition;
    }

    public long skip(long j11) throws IOException {
        long skip = this.carrier.skip(j11);
        if (skip <= 0) {
            LOGGER.warning("Carrier (" + this.carrier.getClass().getCanonicalName() + ")'s skip(" + j11 + ") only skipped " + skip + ", position = " + this.position);
        }
        this.position += skip;
        return skip;
    }

    public int read(byte[] bArr) throws IOException {
        return read(bArr, 0, bArr.length);
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int read = this.carrier.read(bArr, i11, i12);
        this.position += (long) read;
        return read;
    }
}
