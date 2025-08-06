package org.bouncycastle.pqc.crypto.xmss;

import java.util.Objects;

final class WOTSPlusPrivateKeyParameters {
    private final byte[][] privateKey;

    public WOTSPlusPrivateKeyParameters(WOTSPlusParameters wOTSPlusParameters, byte[][] bArr) {
        Objects.requireNonNull(wOTSPlusParameters, "params == null");
        Objects.requireNonNull(bArr, "privateKey == null");
        if (XMSSUtil.hasNullPointer(bArr)) {
            throw new NullPointerException("privateKey byte array == null");
        } else if (bArr.length == wOTSPlusParameters.getLen()) {
            int i11 = 0;
            while (i11 < bArr.length) {
                if (bArr[i11].length == wOTSPlusParameters.getTreeDigestSize()) {
                    i11++;
                } else {
                    throw new IllegalArgumentException("wrong privateKey format");
                }
            }
            this.privateKey = XMSSUtil.cloneArray(bArr);
        } else {
            throw new IllegalArgumentException("wrong privateKey format");
        }
    }

    public byte[][] toByteArray() {
        return XMSSUtil.cloneArray(this.privateKey);
    }
}
