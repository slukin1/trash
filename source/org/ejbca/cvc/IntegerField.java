package org.ejbca.cvc;

import java.math.BigInteger;

public class IntegerField extends AbstractDataField {
    private static final long serialVersionUID = 1;
    private int intValue;

    public IntegerField(CVCTagEnum cVCTagEnum, int i11) {
        super(cVCTagEnum);
        this.intValue = i11;
    }

    public byte[] getEncoded() {
        return CVCObject.toByteArray(Integer.valueOf(this.intValue));
    }

    public int getValue() {
        return this.intValue;
    }

    public void setValue(int i11) {
        this.intValue = i11;
    }

    public String valueAsText() {
        return "" + this.intValue;
    }

    public IntegerField(CVCTagEnum cVCTagEnum, byte[] bArr) {
        super(cVCTagEnum);
        if (bArr == null || bArr.length <= 4) {
            this.intValue = new BigInteger(1, bArr).intValue();
            return;
        }
        throw new IllegalArgumentException("Byte array too long, max is 4, was " + bArr.length);
    }
}
