package org.bouncycastle.jcajce.io;

import java.io.IOException;
import java.io.OutputStream;
import java.security.Signature;
import java.security.SignatureException;

class SignatureUpdatingOutputStream extends OutputStream {
    private Signature sig;

    public SignatureUpdatingOutputStream(Signature signature) {
        this.sig = signature;
    }

    public void write(int i11) throws IOException {
        try {
            this.sig.update((byte) i11);
        } catch (SignatureException e11) {
            throw new IOException(e11.getMessage());
        }
    }

    public void write(byte[] bArr) throws IOException {
        try {
            this.sig.update(bArr);
        } catch (SignatureException e11) {
            throw new IOException(e11.getMessage());
        }
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        try {
            this.sig.update(bArr, i11, i12);
        } catch (SignatureException e11) {
            throw new IOException(e11.getMessage());
        }
    }
}
