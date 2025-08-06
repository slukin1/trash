package org.bouncycastle.crypto.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.crypto.Signer;

public class SignerInputStream extends FilterInputStream {
    public Signer signer;

    public SignerInputStream(InputStream inputStream, Signer signer2) {
        super(inputStream);
        this.signer = signer2;
    }

    public Signer getSigner() {
        return this.signer;
    }

    public int read() throws IOException {
        int read = this.in.read();
        if (read >= 0) {
            this.signer.update((byte) read);
        }
        return read;
    }

    public int read(byte[] bArr, int i11, int i12) throws IOException {
        int read = this.in.read(bArr, i11, i12);
        if (read > 0) {
            this.signer.update(bArr, i11, read);
        }
        return read;
    }
}
