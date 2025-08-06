package org.ejbca.cvc;

import org.bouncycastle.util.encoders.Hex;

public class AccessRightsRawValue implements AccessRights {
    private final byte[] bytes;

    public AccessRightsRawValue(byte[] bArr) {
        this.bytes = bArr;
    }

    public byte[] getEncoded() {
        return this.bytes;
    }

    public String name() {
        return "RAW_ACCESS_RIGHTS";
    }

    public String toString() {
        return "AccessRightsRawValue(" + Hex.toHexString(this.bytes).toUpperCase() + ")";
    }
}
