package org.bouncycastle.crypto.digests;

import java.io.ByteArrayOutputStream;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.util.Arrays;

public class NullDigest implements Digest {
    private OpenByteArrayOutputStream bOut = new OpenByteArrayOutputStream();

    public static class OpenByteArrayOutputStream extends ByteArrayOutputStream {
        private OpenByteArrayOutputStream() {
        }

        public void copy(byte[] bArr, int i11) {
            System.arraycopy(this.buf, 0, bArr, i11, size());
        }

        public void reset() {
            super.reset();
            Arrays.clear(this.buf);
        }
    }

    public int doFinal(byte[] bArr, int i11) {
        int size = this.bOut.size();
        this.bOut.copy(bArr, i11);
        reset();
        return size;
    }

    public String getAlgorithmName() {
        return "NULL";
    }

    public int getDigestSize() {
        return this.bOut.size();
    }

    public void reset() {
        this.bOut.reset();
    }

    public void update(byte b11) {
        this.bOut.write(b11);
    }

    public void update(byte[] bArr, int i11, int i12) {
        this.bOut.write(bArr, i11, i12);
    }
}
