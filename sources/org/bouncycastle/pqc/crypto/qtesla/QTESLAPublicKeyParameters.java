package org.bouncycastle.pqc.crypto.qtesla;

import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.util.Arrays;

public final class QTESLAPublicKeyParameters extends AsymmetricKeyParameter {
    private byte[] publicKey;
    private int securityCategory;

    public QTESLAPublicKeyParameters(int i11, byte[] bArr) {
        super(false);
        if (bArr.length == QTESLASecurityCategory.getPublicSize(i11)) {
            this.securityCategory = i11;
            this.publicKey = Arrays.clone(bArr);
            return;
        }
        throw new IllegalArgumentException("invalid key size for security category");
    }

    public byte[] getPublicData() {
        return Arrays.clone(this.publicKey);
    }

    public int getSecurityCategory() {
        return this.securityCategory;
    }
}
