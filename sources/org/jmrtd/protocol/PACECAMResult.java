package org.jmrtd.protocol;

import java.security.KeyPair;
import java.security.PublicKey;
import java.util.Arrays;
import net.sf.scuba.util.Hex;
import org.jmrtd.AccessKeySpec;
import org.jmrtd.lds.PACEInfo;

public class PACECAMResult extends PACEResult {
    private static final long serialVersionUID = -4288710920347109329L;
    private byte[] chipAuthenticationData;
    private byte[] encryptedChipAuthenticationData = null;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PACECAMResult(AccessKeySpec accessKeySpec, String str, String str2, String str3, int i11, PACEMappingResult pACEMappingResult, KeyPair keyPair, PublicKey publicKey, byte[] bArr, byte[] bArr2, SecureMessagingWrapper secureMessagingWrapper) {
        super(accessKeySpec, PACEInfo.MappingType.CAM, str, str2, str3, i11, pACEMappingResult, keyPair, publicKey, secureMessagingWrapper);
        byte[] bArr3 = bArr;
        byte[] bArr4 = bArr2;
        if (bArr3 != null) {
            byte[] bArr5 = new byte[bArr3.length];
            this.encryptedChipAuthenticationData = bArr5;
            System.arraycopy(bArr3, 0, bArr5, 0, bArr3.length);
        }
        this.chipAuthenticationData = null;
        if (bArr4 != null) {
            byte[] bArr6 = new byte[bArr4.length];
            this.chipAuthenticationData = bArr6;
            System.arraycopy(bArr4, 0, bArr6, 0, bArr4.length);
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!super.equals(obj) || getClass() != obj.getClass()) {
            return false;
        }
        PACECAMResult pACECAMResult = (PACECAMResult) obj;
        if (!Arrays.equals(this.chipAuthenticationData, pACECAMResult.chipAuthenticationData) || !Arrays.equals(this.encryptedChipAuthenticationData, pACECAMResult.encryptedChipAuthenticationData)) {
            return false;
        }
        return true;
    }

    public byte[] getChipAuthenticationData() {
        byte[] bArr = this.chipAuthenticationData;
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public byte[] getEncryptedChipAuthenticationData() {
        byte[] bArr = this.encryptedChipAuthenticationData;
        if (bArr == null) {
            return null;
        }
        byte[] bArr2 = new byte[bArr.length];
        System.arraycopy(bArr, 0, bArr2, 0, bArr.length);
        return bArr2;
    }

    public int hashCode() {
        return (((super.hashCode() * 31) + Arrays.hashCode(this.chipAuthenticationData)) * 31) + Arrays.hashCode(this.encryptedChipAuthenticationData);
    }

    public String toString() {
        return "PACECAMResult [" + "paceKey: " + getPACEKey() + ", " + "mappingType: " + getMappingType() + ", " + "agreementAlg: " + getAgreementAlg() + ", " + "cipherAlg: " + getCipherAlg() + ", " + "digestAlg: " + getDigestAlg() + ", " + "keyLength: " + getKeyLength() + ", " + "mappingResult: " + getMappingResult() + ", " + "pcdKeyPair: " + getPCDKeyPair() + ", " + "piccPublicKey: " + getPICCPublicKey() + ", " + "encryptedChipAuthenticationData: " + Hex.bytesToHexString(this.encryptedChipAuthenticationData) + ", " + "wrapper: " + getWrapper() + ", " + "chipAuthenticationData: " + Hex.bytesToHexString(this.chipAuthenticationData) + "]";
    }
}
