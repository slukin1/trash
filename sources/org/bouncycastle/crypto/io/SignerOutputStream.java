package org.bouncycastle.crypto.io;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.Signer;

public class SignerOutputStream extends OutputStream {
    public Signer signer;

    public SignerOutputStream(Signer signer2) {
        this.signer = signer2;
    }

    public Signer getSigner() {
        return this.signer;
    }

    public void write(int i11) throws IOException {
        this.signer.update((byte) i11);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        this.signer.update(bArr, i11, i12);
    }
}
