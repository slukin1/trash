package org.ejbca.cvc;

import java.math.BigInteger;
import org.ejbca.cvc.util.StringConverter;

public class ByteField extends AbstractDataField {
    private static final long serialVersionUID = 1;
    private byte[] data;
    private boolean showBitLength;

    public ByteField(CVCTagEnum cVCTagEnum) {
        super(cVCTagEnum);
        this.showBitLength = false;
    }

    public byte[] getData() {
        return this.data;
    }

    public byte[] getEncoded() {
        return this.data;
    }

    public boolean isShowBitLength() {
        return this.showBitLength;
    }

    public void setShowBitLength(boolean z11) {
        this.showBitLength = z11;
    }

    public String valueAsText() {
        String str;
        if (this.showBitLength) {
            int i11 = 0;
            if (this.data != null) {
                i11 = new BigInteger(1, this.data).bitLength();
            }
            str = "[" + i11 + "]  ";
        } else {
            str = "";
        }
        return str + StringConverter.byteToHex(this.data);
    }

    public ByteField(CVCTagEnum cVCTagEnum, byte[] bArr) {
        this(cVCTagEnum, bArr, false);
    }

    public ByteField(CVCTagEnum cVCTagEnum, byte[] bArr, boolean z11) {
        super(cVCTagEnum);
        this.showBitLength = false;
        this.data = bArr;
        this.showBitLength = z11;
    }
}
