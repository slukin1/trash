package org.bouncycastle.jcajce.provider.digest;

import java.security.DigestException;
import java.security.MessageDigest;
import org.bouncycastle.crypto.Digest;

public class BCMessageDigest extends MessageDigest {
    public Digest digest;
    public int digestSize;

    public BCMessageDigest(Digest digest2) {
        super(digest2.getAlgorithmName());
        this.digest = digest2;
        this.digestSize = digest2.getDigestSize();
    }

    public int engineDigest(byte[] bArr, int i11, int i12) throws DigestException {
        int i13 = this.digestSize;
        if (i12 < i13) {
            throw new DigestException("partial digests not returned");
        } else if (bArr.length - i11 >= i13) {
            this.digest.doFinal(bArr, i11);
            return this.digestSize;
        } else {
            throw new DigestException("insufficient space in the output buffer to store the digest");
        }
    }

    public byte[] engineDigest() {
        byte[] bArr = new byte[this.digestSize];
        this.digest.doFinal(bArr, 0);
        return bArr;
    }

    public int engineGetDigestLength() {
        return this.digestSize;
    }

    public void engineReset() {
        this.digest.reset();
    }

    public void engineUpdate(byte b11) {
        this.digest.update(b11);
    }

    public void engineUpdate(byte[] bArr, int i11, int i12) {
        this.digest.update(bArr, i11, i12);
    }
}
