package org.jmrtd;

import java.security.GeneralSecurityException;
import java.util.Arrays;
import net.sf.scuba.util.Hex;
import org.jmrtd.protocol.PACEProtocol;

public class PACEKeySpec implements AccessKeySpec {
    private static final long serialVersionUID = -7113246293247012560L;
    private byte[] key;
    private byte keyReference;

    public PACEKeySpec(String str, byte b11) {
        this(Util.getBytes(str), b11);
    }

    public static PACEKeySpec createCANKey(String str) {
        return new PACEKeySpec(str, (byte) 2);
    }

    public static PACEKeySpec createMRZKey(BACKeySpec bACKeySpec) throws GeneralSecurityException {
        return new PACEKeySpec(PACEProtocol.computeKeySeedForPACE((AccessKeySpec) bACKeySpec), (byte) 1);
    }

    public static PACEKeySpec createPINKey(String str) {
        return new PACEKeySpec(str, (byte) 3);
    }

    public static PACEKeySpec createPUKKey(String str) {
        return new PACEKeySpec(str, (byte) 4);
    }

    private static String keyReferenceToString(byte b11) {
        if (b11 == 0) {
            return "NO";
        }
        if (b11 == 1) {
            return "MRZ";
        }
        if (b11 == 2) {
            return "CAN";
        }
        if (b11 != 3) {
            return b11 != 4 ? Integer.toString(b11) : "PUK";
        }
        return "PIN";
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PACEKeySpec pACEKeySpec = (PACEKeySpec) obj;
        return Arrays.equals(this.key, pACEKeySpec.key) && this.keyReference == pACEKeySpec.keyReference;
    }

    public String getAlgorithm() {
        return "PACE";
    }

    public byte[] getKey() {
        return this.key;
    }

    public byte getKeyReference() {
        return this.keyReference;
    }

    public int hashCode() {
        return ((Arrays.hashCode(this.key) + 31) * 31) + this.keyReference;
    }

    public String toString() {
        return "PACEKeySpec [" + "key: " + Hex.bytesToHexString(this.key) + ", " + "keyReference: " + keyReferenceToString(this.keyReference) + "]";
    }

    public PACEKeySpec(byte[] bArr, byte b11) {
        this.keyReference = b11;
        this.key = bArr;
    }
}
