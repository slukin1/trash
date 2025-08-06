package org.jmrtd.lds;

import com.xiaomi.mipush.sdk.Constants;
import java.math.BigInteger;
import java.security.PublicKey;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DLSequence;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.jmrtd.Util;

public class ChipAuthenticationPublicKeyInfo extends SecurityInfo {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    private static final long serialVersionUID = 5687291829854501771L;
    private BigInteger keyId;
    private String oid;
    private PublicKey publicKey;

    public ChipAuthenticationPublicKeyInfo(PublicKey publicKey2) {
        this(publicKey2, (BigInteger) null);
    }

    public static boolean checkRequiredIdentifier(String str) {
        return SecurityInfo.ID_PK_DH.equals(str) || SecurityInfo.ID_PK_ECDH.equals(str);
    }

    public static String toKeyAgreementAlgorithm(String str) {
        if (str == null) {
            throw new NumberFormatException("Unknown OID: null");
        } else if (SecurityInfo.ID_PK_DH.equals(str)) {
            return "DH";
        } else {
            if (SecurityInfo.ID_PK_ECDH.equals(str)) {
                return "ECDH";
            }
            throw new NumberFormatException("Unknown OID: \"" + str + "\"");
        }
    }

    private static String toProtocolOIDString(String str) {
        if (SecurityInfo.ID_PK_DH.equals(str)) {
            return "id-PK-DH";
        }
        return SecurityInfo.ID_PK_ECDH.equals(str) ? "id-PK-ECDH" : str;
    }

    public void checkFields() {
        try {
            if (!checkRequiredIdentifier(this.oid)) {
                throw new IllegalArgumentException("Wrong identifier: " + this.oid);
            }
        } catch (Exception e11) {
            throw new IllegalArgumentException("Malformed ChipAuthenticationInfo", e11);
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!ChipAuthenticationPublicKeyInfo.class.equals(obj.getClass())) {
            return false;
        }
        ChipAuthenticationPublicKeyInfo chipAuthenticationPublicKeyInfo = (ChipAuthenticationPublicKeyInfo) obj;
        if (!this.oid.equals(chipAuthenticationPublicKeyInfo.oid)) {
            return false;
        }
        BigInteger bigInteger = this.keyId;
        if (((bigInteger != null || chipAuthenticationPublicKeyInfo.keyId != null) && (bigInteger == null || !bigInteger.equals(chipAuthenticationPublicKeyInfo.keyId))) || !this.publicKey.equals(chipAuthenticationPublicKeyInfo.publicKey)) {
            return false;
        }
        return true;
    }

    @Deprecated
    public ASN1Primitive getDERObject() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        SubjectPublicKeyInfo subjectPublicKeyInfo = Util.toSubjectPublicKeyInfo(this.publicKey);
        if (subjectPublicKeyInfo == null) {
            LOGGER.log(Level.WARNING, "Could not convert public key to subject-public-key-info structure");
        } else {
            aSN1EncodableVector.add(new ASN1ObjectIdentifier(this.oid));
            aSN1EncodableVector.add(subjectPublicKeyInfo.toASN1Primitive());
            if (this.keyId != null) {
                aSN1EncodableVector.add(new ASN1Integer(this.keyId));
            }
        }
        return new DLSequence(aSN1EncodableVector);
    }

    public BigInteger getKeyId() {
        return this.keyId;
    }

    public String getObjectIdentifier() {
        return this.oid;
    }

    public String getProtocolOIDString() {
        return toProtocolOIDString(this.oid);
    }

    public PublicKey getSubjectPublicKey() {
        return this.publicKey;
    }

    public int hashCode() {
        int hashCode = this.oid.hashCode();
        BigInteger bigInteger = this.keyId;
        int i11 = 111;
        int hashCode2 = hashCode + (bigInteger == null ? 111 : bigInteger.hashCode());
        PublicKey publicKey2 = this.publicKey;
        if (publicKey2 != null) {
            i11 = publicKey2.hashCode();
        }
        return ((hashCode2 + i11) * 1337) + 123;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ChipAuthenticationPublicKeyInfo [protocol: ");
        sb2.append(toProtocolOIDString(this.oid));
        sb2.append(", chipAuthenticationPublicKey: ");
        sb2.append(Util.getDetailedPublicKeyAlgorithm(getSubjectPublicKey()));
        sb2.append(", keyId: ");
        BigInteger bigInteger = this.keyId;
        sb2.append(bigInteger == null ? Constants.ACCEPT_TIME_SEPARATOR_SERVER : bigInteger.toString());
        sb2.append("]");
        return sb2.toString();
    }

    public ChipAuthenticationPublicKeyInfo(PublicKey publicKey2, BigInteger bigInteger) {
        this(Util.inferProtocolIdentifier(publicKey2), publicKey2, bigInteger);
    }

    public ChipAuthenticationPublicKeyInfo(String str, PublicKey publicKey2) {
        this(str, publicKey2, (BigInteger) null);
    }

    public ChipAuthenticationPublicKeyInfo(String str, PublicKey publicKey2, BigInteger bigInteger) {
        this.oid = str;
        this.publicKey = Util.reconstructPublicKey(publicKey2);
        this.keyId = bigInteger;
        checkFields();
    }
}
