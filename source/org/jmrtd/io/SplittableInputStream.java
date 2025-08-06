package org.jmrtd.io;

import java.io.IOException;
import java.io.InputStream;
import org.jmrtd.io.InputStreamBuffer;

public class SplittableInputStream extends InputStream {
    private InputStreamBuffer.SubInputStream carrier;
    private InputStreamBuffer inputStreamBuffer;

    public SplittableInputStream(InputStream inputStream, int i11) {
        InputStreamBuffer inputStreamBuffer2 = new InputStreamBuffer(inputStream, i11);
        this.inputStreamBuffer = inputStreamBuffer2;
        this.carrier = inputStreamBuffer2.getInputStream();
    }

    public int available() throws IOException {
        return this.carrier.available();
    }

    public void close() throws IOException {
        this.carrier.close();
    }

    public int getBytesBuffered() {
        return this.inputStreamBuffer.getBytesBuffered();
    }

    public InputStream getInputStream(int i11) {
        try {
            InputStreamBuffer.SubInputStream inputStream = this.inputStreamBuffer.getInputStream();
            long j11 = 0;
            while (true) {
                long j12 = (long) i11;
                if (j11 >= j12) {
                    return inputStream;
                }
                j11 += inputStream.skip(j12 - j11);
            }
        } catch (IOException e11) {
            throw new IllegalStateException(e11);
        }
    }

    public int getLength() {
        return this.inputStreamBuffer.getLength();
    }

    public int getPosition() {
        return this.carrier.getPosition();
    }

    public synchronized void mark(int i11) {
        this.carrier.mark(i11);
    }

    public boolean markSupported() {
        return this.carrier.markSupported();
    }

    public int read() throws IOException {
        return this.carrier.read();
    }

    public synchronized void reset() throws IOException {
        this.carrier.reset();
    }

    public long skip(long j11) throws IOException {
        return this.carrier.skip(j11);
    }

    public void updateFrom(SplittableInputStream splittableInputStream) {
        this.inputStreamBuffer.updateFrom(splittableInputStream.inputStreamBuffer);
    }
}
