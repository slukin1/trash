package org.ejbca.cvc;

import java.io.Serializable;
import okio.Utf8;
import org.ejbca.cvc.util.StringConverter;

public class AccessRightAuthTerm implements AccessRights, Serializable {
    public static final int BIT_AGE_VERIFICATION = 0;
    public static final int BIT_CAN_ALLOWED = 4;
    public static final int BIT_COMMUNITY_ID_VERIFICATION = 1;
    public static final int BIT_INSTALL_CERT = 6;
    public static final int BIT_INSTALL_QUALIFIED_CERT = 7;
    public static final int BIT_PIN_MANAGEMENT = 5;
    public static final int BIT_PRIVILEGED_TERMINAL = 3;
    public static final int BIT_READ_DG1 = 8;
    public static final int BIT_READ_DG10 = 17;
    public static final int BIT_READ_DG11 = 18;
    public static final int BIT_READ_DG12 = 19;
    public static final int BIT_READ_DG13 = 20;
    public static final int BIT_READ_DG14 = 21;
    public static final int BIT_READ_DG15 = 22;
    public static final int BIT_READ_DG16 = 23;
    public static final int BIT_READ_DG17 = 24;
    public static final int BIT_READ_DG18 = 25;
    public static final int BIT_READ_DG19 = 26;
    public static final int BIT_READ_DG2 = 9;
    public static final int BIT_READ_DG20 = 27;
    public static final int BIT_READ_DG21 = 28;
    public static final int BIT_READ_DG3 = 10;
    public static final int BIT_READ_DG4 = 11;
    public static final int BIT_READ_DG5 = 12;
    public static final int BIT_READ_DG6 = 13;
    public static final int BIT_READ_DG7 = 14;
    public static final int BIT_READ_DG8 = 15;
    public static final int BIT_READ_DG9 = 16;
    public static final int BIT_RESTRICTED_IDENTIFICATION = 2;
    public static final int BIT_WRITE_DG17 = 37;
    public static final int BIT_WRITE_DG18 = 36;
    public static final int BIT_WRITE_DG19 = 35;
    public static final int BIT_WRITE_DG20 = 34;
    public static final int BIT_WRITE_DG21 = 33;
    private static final int MAX_BIT = 37;
    private static final long serialVersionUID = 1;
    private final byte[] bytes;

    public AccessRightAuthTerm() {
        this.bytes = new byte[5];
    }

    private static String flagToString(int i11) {
        if (i11 < 0 || i11 > 37) {
            throw new ArrayIndexOutOfBoundsException(i11);
        } else if (i11 >= 33) {
            return "W-DG" + (54 - i11);
        } else if (i11 > 28) {
            return "RFU-" + i11;
        } else if (i11 >= 8) {
            return "R-DG" + ((i11 - 8) + 1);
        } else {
            switch (i11) {
                case 0:
                    return "Age Verification";
                case 1:
                    return "Community ID Verification";
                case 2:
                    return "Restricted Identification";
                case 3:
                    return "Privileged Terminal";
                case 4:
                    return "CAN Allowed";
                case 5:
                    return "PIN Management";
                case 6:
                    return "Install Certificate";
                case 7:
                    return "Install Qualified Certificate";
                default:
                    throw new IllegalStateException();
            }
        }
    }

    public byte[] getEncoded() {
        return (byte[]) this.bytes.clone();
    }

    public boolean getFlag(int i11) {
        if (i11 < 0 || i11 > 37) {
            throw new ArrayIndexOutOfBoundsException(i11);
        }
        byte[] bArr = this.bytes;
        if (((bArr[(bArr.length - 1) - (i11 >> 3)] >> (i11 & 7)) & 1) == 1) {
            return true;
        }
        return false;
    }

    public String name() {
        return "ACCESS_RIGHT_AT_" + StringConverter.byteToHex(this.bytes);
    }

    public void setFlag(int i11, boolean z11) {
        if (i11 < 0 || i11 > 37) {
            throw new ArrayIndexOutOfBoundsException(i11);
        }
        byte[] bArr = this.bytes;
        int length = (bArr.length - 1) - (i11 >> 3);
        int i12 = 1 << (i11 & 7);
        bArr[length] = (byte) (bArr[length] & (~i12));
        byte b11 = bArr[length];
        if (!z11) {
            i12 = 0;
        }
        bArr[length] = (byte) (i12 | b11);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 <= 37; i11++) {
            if (getFlag(i11)) {
                sb2.append(flagToString(i11));
                sb2.append(", ");
            }
        }
        if (sb2.length() > 0) {
            sb2.delete(sb2.length() - 2, sb2.length());
        }
        return sb2.toString();
    }

    public AccessRightAuthTerm(byte[] bArr) {
        if (bArr.length == 5) {
            byte[] bArr2 = (byte[]) bArr.clone();
            this.bytes = bArr2;
            bArr2[0] = (byte) (bArr2[0] & Utf8.REPLACEMENT_BYTE);
            return;
        }
        throw new IllegalArgumentException("byte array length must be 5, was " + bArr.length);
    }
}
