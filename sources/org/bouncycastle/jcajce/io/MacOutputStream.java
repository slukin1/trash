package org.bouncycastle.jcajce.io;

import java.io.IOException;
import java.io.OutputStream;
import javax.crypto.Mac;

public final class MacOutputStream extends OutputStream {
    private Mac mac;

    public MacOutputStream(Mac mac2) {
        this.mac = mac2;
    }

    public byte[] getMac() {
        return this.mac.doFinal();
    }

    public void write(int i11) throws IOException {
        this.mac.update((byte) i11);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        this.mac.update(bArr, i11, i12);
    }
}
