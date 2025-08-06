package org.jmrtd.lds;

import java.security.NoSuchAlgorithmException;
import java.util.logging.Logger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DLSequence;

public class ActiveAuthenticationInfo extends SecurityInfo {
    public static final String ECDSA_PLAIN_RIPEMD160_OID = "0.4.0.127.0.7.1.1.4.1.6";
    public static final String ECDSA_PLAIN_SHA1_OID = "0.4.0.127.0.7.1.1.4.1.1";
    public static final String ECDSA_PLAIN_SHA224_OID = "0.4.0.127.0.7.1.1.4.1.2";
    public static final String ECDSA_PLAIN_SHA256_OID = "0.4.0.127.0.7.1.1.4.1.3";
    public static final String ECDSA_PLAIN_SHA384_OID = "0.4.0.127.0.7.1.1.4.1.4";
    public static final String ECDSA_PLAIN_SHA512_OID = "0.4.0.127.0.7.1.1.4.1.5";
    public static final String ECDSA_PLAIN_SIGNATURES = "0.4.0.127.0.7.1.1.4.1";
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd.lds");
    public static final int VERSION_1 = 1;
    private static final long serialVersionUID = 6830847342039845308L;
    private String oid;
    private String signatureAlgorithmOID;
    private int version;

    public ActiveAuthenticationInfo(String str, int i11, String str2) {
        this.oid = str;
        this.version = i11;
        this.signatureAlgorithmOID = str2;
        checkFields();
    }

    private void checkFields() {
        try {
            if (checkRequiredIdentifier(this.oid)) {
                if (this.version != 1) {
                    Logger logger = LOGGER;
                    logger.warning("Wrong version: " + this.version);
                }
                if (!ECDSA_PLAIN_SHA1_OID.equals(this.signatureAlgorithmOID) && !ECDSA_PLAIN_SHA224_OID.equals(this.signatureAlgorithmOID) && !ECDSA_PLAIN_SHA256_OID.equals(this.signatureAlgorithmOID) && !ECDSA_PLAIN_SHA384_OID.equals(this.signatureAlgorithmOID) && !ECDSA_PLAIN_SHA512_OID.equals(this.signatureAlgorithmOID)) {
                    if (!ECDSA_PLAIN_RIPEMD160_OID.equals(this.signatureAlgorithmOID)) {
                        throw new IllegalArgumentException("Wrong signature algorithm OID: " + this.signatureAlgorithmOID);
                    }
                    return;
                }
                return;
            }
            throw new IllegalArgumentException("Wrong identifier: " + this.oid);
        } catch (Exception e11) {
            throw new IllegalArgumentException("Malformed ActiveAuthenticationInfo", e11);
        }
    }

    public static boolean checkRequiredIdentifier(String str) {
        return SecurityInfo.ID_AA.equals(str);
    }

    public static String lookupMnemonicByOID(String str) throws NoSuchAlgorithmException {
        if (ECDSA_PLAIN_SHA1_OID.equals(str)) {
            return "SHA1withECDSA";
        }
        if (ECDSA_PLAIN_SHA224_OID.equals(str)) {
            return "SHA224withECDSA";
        }
        if (ECDSA_PLAIN_SHA256_OID.equals(str)) {
            return "SHA256withECDSA";
        }
        if (ECDSA_PLAIN_SHA384_OID.equals(str)) {
            return "SHA384withECDSA";
        }
        if (ECDSA_PLAIN_SHA512_OID.equals(str)) {
            return "SHA512withECDSA";
        }
        if (ECDSA_PLAIN_RIPEMD160_OID.equals(str)) {
            return "RIPEMD160withECDSA";
        }
        throw new NoSuchAlgorithmException("Unknown OID " + str);
    }

    private String toProtocolOIDString(String str) {
        return SecurityInfo.ID_AA.equals(str) ? "id-AA" : str;
    }

    public static String toSignatureAlgorithmOIDString(String str) {
        if (ECDSA_PLAIN_SHA1_OID.equals(str)) {
            return "ecdsa-plain-SHA1";
        }
        if (ECDSA_PLAIN_SHA224_OID.equals(str)) {
            return "ecdsa-plain-SHA224";
        }
        if (ECDSA_PLAIN_SHA256_OID.equals(str)) {
            return "ecdsa-plain-SHA256";
        }
        if (ECDSA_PLAIN_SHA384_OID.equals(str)) {
            return "ecdsa-plain-SHA384";
        }
        if (ECDSA_PLAIN_SHA512_OID.equals(str)) {
            return "ecdsa-plain-SHA512";
        }
        return ECDSA_PLAIN_RIPEMD160_OID.equals(str) ? "ecdsa-plain-RIPEMD160" : str;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!ActiveAuthenticationInfo.class.equals(obj.getClass())) {
            return false;
        }
        return getDERObject().equals(((ActiveAuthenticationInfo) obj).getDERObject());
    }

    @Deprecated
    public ASN1Primitive getDERObject() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1ObjectIdentifier(this.oid));
        aSN1EncodableVector.add(new ASN1Integer((long) this.version));
        if (this.signatureAlgorithmOID != null) {
            aSN1EncodableVector.add(new ASN1ObjectIdentifier(this.signatureAlgorithmOID));
        }
        return new DLSequence(aSN1EncodableVector);
    }

    public String getObjectIdentifier() {
        return this.oid;
    }

    public String getProtocolOIDString() {
        return toProtocolOIDString(this.oid);
    }

    public String getSignatureAlgorithmOID() {
        return this.signatureAlgorithmOID;
    }

    public int getVersion() {
        return this.version;
    }

    public int hashCode() {
        String str = this.oid;
        int hashCode = ((str == null ? 0 : str.hashCode()) * 3) + 12345 + (this.version * 5);
        String str2 = this.signatureAlgorithmOID;
        return hashCode + ((str2 == null ? 1 : str2.hashCode()) * 11);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("ActiveAuthenticationInfo");
        sb2.append(" [");
        sb2.append("protocol: " + toProtocolOIDString(this.oid));
        sb2.append(", ");
        sb2.append("version: " + this.version);
        sb2.append(", ");
        sb2.append("signatureAlgorithmOID: " + toSignatureAlgorithmOIDString(getSignatureAlgorithmOID()));
        sb2.append("]");
        return sb2.toString();
    }

    public ActiveAuthenticationInfo(String str) {
        this(SecurityInfo.ID_AA, 1, str);
    }
}
