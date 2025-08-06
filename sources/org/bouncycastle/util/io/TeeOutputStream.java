package org.bouncycastle.util.io;

import java.io.IOException;
import java.io.OutputStream;

public class TeeOutputStream extends OutputStream {
    private OutputStream output1;
    private OutputStream output2;

    public TeeOutputStream(OutputStream outputStream, OutputStream outputStream2) {
        this.output1 = outputStream;
        this.output2 = outputStream2;
    }

    public void close() throws IOException {
        this.output1.close();
        this.output2.close();
    }

    public void flush() throws IOException {
        this.output1.flush();
        this.output2.flush();
    }

    public void write(int i11) throws IOException {
        this.output1.write(i11);
        this.output2.write(i11);
    }

    public void write(byte[] bArr) throws IOException {
        this.output1.write(bArr);
        this.output2.write(bArr);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        this.output1.write(bArr, i11, i12);
        this.output2.write(bArr, i11, i12);
    }
}
