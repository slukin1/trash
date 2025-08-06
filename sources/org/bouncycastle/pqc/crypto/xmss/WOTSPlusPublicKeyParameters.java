package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;

final class WOTSPlusPublicKeyParameters {
    private final byte[][] publicKey;

    public WOTSPlusPublicKeyParameters(WOTSPlusParameters wOTSPlusParameters, byte[][] bArr) {
        Objects.requireNonNull(wOTSPlusParameters, "params == null");
        Objects.requireNonNull(bArr, "publicKey == null");
        if (XMSSUtil.hasNullPointer(bArr)) {
            throw new NullPointerException("publicKey byte array == null");
        } else if (bArr.length == wOTSPlusParameters.getLen()) {
            int i11 = 0;
            while (i11 < bArr.length) {
                if (bArr[i11].length == wOTSPlusParameters.getTreeDigestSize()) {
                    i11++;
                } else {
                    throw new IllegalArgumentException("wrong publicKey format");
                }
            }
            this.publicKey = XMSSUtil.cloneArray(bArr);
        } else {
            throw new IllegalArgumentException("wrong publicKey size");
        }
    }

    public byte[][] toByteArray() {
        return XMSSUtil.cloneArray(this.publicKey);
    }
}
