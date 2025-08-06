package org.bouncycastle.asn1;

import java.io.IOException;
import java.util.Date;
import org.bouncycastle.util.Strings;

public class DERGeneralizedTime extends ASN1GeneralizedTime {
    public DERGeneralizedTime(String str) {
        super(str);
    }

    public DERGeneralizedTime(Date date) {
        super(date);
    }

    public DERGeneralizedTime(byte[] bArr) {
        super(bArr);
    }

    private byte[] getDERTime() {
        byte[] bArr = this.contents;
        if (bArr[bArr.length - 1] != 90) {
            return bArr;
        }
        if (!hasMinutes()) {
            byte[] bArr2 = this.contents;
            byte[] bArr3 = new byte[(bArr2.length + 4)];
            System.arraycopy(bArr2, 0, bArr3, 0, bArr2.length - 1);
            System.arraycopy(Strings.toByteArray("0000Z"), 0, bArr3, this.contents.length - 1, 5);
            return bArr3;
        } else if (!hasSeconds()) {
            byte[] bArr4 = this.contents;
            byte[] bArr5 = new byte[(bArr4.length + 2)];
            System.arraycopy(bArr4, 0, bArr5, 0, bArr4.length - 1);
            System.arraycopy(Strings.toByteArray("00Z"), 0, bArr5, this.contents.length - 1, 3);
            return bArr5;
        } else if (!hasFractionalSeconds()) {
            return this.contents;
        } else {
            int length = this.contents.length - 2;
            while (length > 0 && this.contents[length] == 48) {
                length--;
            }
            byte[] bArr6 = this.contents;
            if (bArr6[length] == 46) {
                byte[] bArr7 = new byte[(length + 1)];
                System.arraycopy(bArr6, 0, bArr7, 0, length);
                bArr7[length] = 90;
                return bArr7;
            }
            byte[] bArr8 = new byte[(length + 2)];
            int i11 = length + 1;
            System.arraycopy(bArr6, 0, bArr8, 0, i11);
            bArr8[i11] = 90;
            return bArr8;
        }
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
        aSN1OutputStream.writeEncodingDL(z11, 24, getDERTime());
    }

    public int encodedLength(boolean z11) {
        return ASN1OutputStream.getLengthOfEncodingDL(z11, getDERTime().length);
    }

    public ASN1Primitive toDERObject() {
        return this;
    }

    public ASN1Primitive toDLObject() {
        return this;
    }
}
