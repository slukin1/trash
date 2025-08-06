package org.bouncycastle.crypto.io;

import java.io.IOException;
import java.io.OutputStream;
import org.bouncycastle.crypto.Mac;

public class MacOutputStream extends OutputStream {
    public Mac mac;

    public MacOutputStream(Mac mac2) {
        this.mac = mac2;
    }

    public byte[] getMac() {
        byte[] bArr = new byte[this.mac.getMacSize()];
        this.mac.doFinal(bArr, 0);
        return bArr;
    }

    public void write(int i11) throws IOException {
        this.mac.update((byte) i11);
    }

    public void write(byte[] bArr, int i11, int i12) throws IOException {
        this.mac.update(bArr, i11, i12);
    }
}
