package org.jmrtd.protocol;

import java.io.Serializable;
import java.security.KeyPair;
import java.security.PublicKey;
import org.jmrtd.AccessKeySpec;
import org.jmrtd.Util;
import org.jmrtd.lds.PACEInfo;

public class PACEResult implements Serializable {
    private static final long serialVersionUID = -6819675856205885052L;
    private String agreementAlg;
    private String cipherAlg;
    private String digestAlg;
    private int keyLength;
    private PACEMappingResult mappingResult;
    private PACEInfo.MappingType mappingType;
    private AccessKeySpec paceKey;
    private KeyPair pcdKeyPair;
    private PublicKey piccPublicKey;
    private SecureMessagingWrapper wrapper;

    public PACEResult(AccessKeySpec accessKeySpec, PACEInfo.MappingType mappingType2, String str, String str2, String str3, int i11, PACEMappingResult pACEMappingResult, KeyPair keyPair, PublicKey publicKey, SecureMessagingWrapper secureMessagingWrapper) {
        this.paceKey = accessKeySpec;
        this.mappingType = mappingType2;
        this.agreementAlg = str;
        this.cipherAlg = str2;
        this.digestAlg = str3;
        this.keyLength = i11;
        this.mappingResult = pACEMappingResult;
        this.pcdKeyPair = keyPair;
        this.piccPublicKey = publicKey;
        this.wrapper = secureMessagingWrapper;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        PACEResult pACEResult = (PACEResult) obj;
        AccessKeySpec accessKeySpec = this.paceKey;
        if (accessKeySpec == null) {
            if (pACEResult.paceKey != null) {
                return false;
            }
        } else if (!accessKeySpec.equals(pACEResult.paceKey)) {
            return false;
        }
        String str = this.agreementAlg;
        if (str == null) {
            if (pACEResult.agreementAlg != null) {
                return false;
            }
        } else if (!str.equals(pACEResult.agreementAlg)) {
            return false;
        }
        String str2 = this.cipherAlg;
        if (str2 == null) {
            if (pACEResult.cipherAlg != null) {
                return false;
            }
        } else if (!str2.equals(pACEResult.cipherAlg)) {
            return false;
        }
        String str3 = this.digestAlg;
        if (str3 == null) {
            if (pACEResult.digestAlg != null) {
                return false;
            }
        } else if (!str3.equals(pACEResult.digestAlg)) {
            return false;
        }
        PACEMappingResult pACEMappingResult = this.mappingResult;
        if (pACEMappingResult == null) {
            if (pACEResult.mappingResult != null) {
                return false;
            }
        } else if (!pACEMappingResult.equals(pACEResult.mappingResult)) {
            return false;
        }
        if (this.keyLength != pACEResult.keyLength || this.mappingType != pACEResult.mappingType) {
            return false;
        }
        KeyPair keyPair = this.pcdKeyPair;
        if (keyPair == null) {
            if (pACEResult.pcdKeyPair != null) {
                return false;
            }
        } else if (!keyPair.equals(pACEResult.pcdKeyPair)) {
            return false;
        }
        PublicKey publicKey = this.piccPublicKey;
        if (publicKey == null) {
            if (pACEResult.piccPublicKey != null) {
                return false;
            }
        } else if (!publicKey.equals(pACEResult.piccPublicKey)) {
            return false;
        }
        SecureMessagingWrapper secureMessagingWrapper = this.wrapper;
        if (secureMessagingWrapper == null) {
            if (pACEResult.wrapper != null) {
                return false;
            }
        } else if (!secureMessagingWrapper.equals(pACEResult.wrapper)) {
            return false;
        }
        return true;
    }

    public String getAgreementAlg() {
        return this.agreementAlg;
    }

    public String getCipherAlg() {
        return this.cipherAlg;
    }

    public String getDigestAlg() {
        return this.digestAlg;
    }

    public int getKeyLength() {
        return this.keyLength;
    }

    public PACEMappingResult getMappingResult() {
        return this.mappingResult;
    }

    public PACEInfo.MappingType getMappingType() {
        return this.mappingType;
    }

    public AccessKeySpec getPACEKey() {
        return this.paceKey;
    }

    public KeyPair getPCDKeyPair() {
        return this.pcdKeyPair;
    }

    public PublicKey getPICCPublicKey() {
        return this.piccPublicKey;
    }

    public SecureMessagingWrapper getWrapper() {
        return this.wrapper;
    }

    public int hashCode() {
        AccessKeySpec accessKeySpec = this.paceKey;
        int i11 = 0;
        int hashCode = (21901 + (accessKeySpec == null ? 0 : accessKeySpec.hashCode())) * 1991;
        String str = this.agreementAlg;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 1991;
        String str2 = this.cipherAlg;
        int hashCode3 = (hashCode2 + (str2 == null ? 0 : str2.hashCode())) * 1991;
        String str3 = this.digestAlg;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 1991;
        PACEMappingResult pACEMappingResult = this.mappingResult;
        int hashCode5 = (((hashCode4 + (pACEMappingResult == null ? 0 : pACEMappingResult.hashCode())) * 1991) + this.keyLength) * 1991;
        PACEInfo.MappingType mappingType2 = this.mappingType;
        int hashCode6 = (hashCode5 + (mappingType2 == null ? 0 : mappingType2.hashCode())) * 1991;
        KeyPair keyPair = this.pcdKeyPair;
        int hashCode7 = (hashCode6 + (keyPair == null ? 0 : keyPair.hashCode())) * 1991;
        PublicKey publicKey = this.piccPublicKey;
        int hashCode8 = (hashCode7 + (publicKey == null ? 0 : publicKey.hashCode())) * 1991;
        SecureMessagingWrapper secureMessagingWrapper = this.wrapper;
        if (secureMessagingWrapper != null) {
            i11 = secureMessagingWrapper.hashCode();
        }
        return hashCode8 + i11;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("PACEResult [");
        sb2.append("paceKey: ");
        sb2.append(this.paceKey);
        sb2.append(", mappingType: ");
        sb2.append(this.mappingType);
        sb2.append(", agreementAlg: " + this.agreementAlg);
        sb2.append(", cipherAlg: " + this.cipherAlg);
        sb2.append(", digestAlg: " + this.digestAlg);
        sb2.append(", keyLength: " + this.keyLength);
        sb2.append(", mappingResult: " + this.mappingResult);
        sb2.append(", piccPublicKey: " + Util.getDetailedPublicKeyAlgorithm(this.piccPublicKey));
        sb2.append(", pcdPrivateKey: " + Util.getDetailedPrivateKeyAlgorithm(this.pcdKeyPair.getPrivate()));
        sb2.append(", pcdPublicKey: " + Util.getDetailedPublicKeyAlgorithm(this.pcdKeyPair.getPublic()));
        return sb2.toString();
    }
}
