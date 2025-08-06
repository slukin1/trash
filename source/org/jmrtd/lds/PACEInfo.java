package org.jmrtd.lds;

import com.iproov.sdk.bridge.OptionsBridge;
import com.sumsub.sns.prooface.network.b;
import java.math.BigInteger;
import java.security.spec.AlgorithmParameterSpec;
import java.security.spec.ECParameterSpec;
import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.logging.Logger;
import javax.crypto.spec.DHParameterSpec;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DLSequence;
import org.bouncycastle.jce.ECNamedCurveTable;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.jmrtd.Util;

public class PACEInfo extends SecurityInfo {
    private static final Set<String> ALLOWED_REQUIRED_IDENTIFIERS = new TreeSet(Arrays.asList(new String[]{SecurityInfo.ID_PACE_DH_GM_3DES_CBC_CBC, SecurityInfo.ID_PACE_DH_GM_AES_CBC_CMAC_128, SecurityInfo.ID_PACE_DH_GM_AES_CBC_CMAC_192, SecurityInfo.ID_PACE_DH_GM_AES_CBC_CMAC_256, SecurityInfo.ID_PACE_DH_IM_3DES_CBC_CBC, SecurityInfo.ID_PACE_DH_IM_AES_CBC_CMAC_128, SecurityInfo.ID_PACE_DH_IM_AES_CBC_CMAC_192, SecurityInfo.ID_PACE_DH_IM_AES_CBC_CMAC_256, SecurityInfo.ID_PACE_ECDH_GM_3DES_CBC_CBC, SecurityInfo.ID_PACE_ECDH_GM_AES_CBC_CMAC_128, SecurityInfo.ID_PACE_ECDH_GM_AES_CBC_CMAC_192, SecurityInfo.ID_PACE_ECDH_GM_AES_CBC_CMAC_256, SecurityInfo.ID_PACE_ECDH_IM_3DES_CBC_CBC, SecurityInfo.ID_PACE_ECDH_IM_AES_CBC_CMAC_128, SecurityInfo.ID_PACE_ECDH_IM_AES_CBC_CMAC_192, SecurityInfo.ID_PACE_ECDH_IM_AES_CBC_CMAC_256, SecurityInfo.ID_PACE_ECDH_CAM_AES_CBC_CMAC_128, SecurityInfo.ID_PACE_ECDH_CAM_AES_CBC_CMAC_192, SecurityInfo.ID_PACE_ECDH_CAM_AES_CBC_CMAC_256}));
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd.lds");
    private static final ECParameterSpec PARAMS_ECP_BRAINPOOL_P192_R1 = Util.toExplicitECParameterSpec(ECNamedCurveTable.getParameterSpec("brainpoolp192r1"));
    private static final ECParameterSpec PARAMS_ECP_BRAINPOOL_P224_R1 = Util.toExplicitECParameterSpec(ECNamedCurveTable.getParameterSpec("brainpoolp224r1"));
    private static final ECParameterSpec PARAMS_ECP_BRAINPOOL_P256_R1 = Util.toExplicitECParameterSpec(ECNamedCurveTable.getParameterSpec("brainpoolp256r1"));
    private static final ECParameterSpec PARAMS_ECP_BRAINPOOL_P320_R1 = Util.toExplicitECParameterSpec(ECNamedCurveTable.getParameterSpec("brainpoolp320r1"));
    private static final ECParameterSpec PARAMS_ECP_BRAINPOOL_P384_R1 = Util.toExplicitECParameterSpec(ECNamedCurveTable.getParameterSpec("brainpoolp384r1"));
    private static final ECParameterSpec PARAMS_ECP_BRAINPOOL_P512_R1 = Util.toExplicitECParameterSpec(ECNamedCurveTable.getParameterSpec("brainpoolp512r1"));
    private static final ECParameterSpec PARAMS_ECP_NIST_P192_R1 = Util.toExplicitECParameterSpec(ECNamedCurveTable.getParameterSpec("secp192r1"));
    private static final ECParameterSpec PARAMS_ECP_NIST_P224_R1 = Util.toExplicitECParameterSpec(ECNamedCurveTable.getParameterSpec("secp224r1"));
    private static final ECParameterSpec PARAMS_ECP_NIST_P256_R1 = Util.toExplicitECParameterSpec(ECNamedCurveTable.getParameterSpec(b.f40264g));
    private static final ECParameterSpec PARAMS_ECP_NIST_P384_R1 = Util.toExplicitECParameterSpec(ECNamedCurveTable.getParameterSpec("secp384r1"));
    private static final ECParameterSpec PARAMS_ECP_NIST_P521_R1 = Util.toExplicitECParameterSpec(ECNamedCurveTable.getParameterSpec("secp521r1"));
    private static final DHParameterSpec PARAMS_GFP_1024_160 = Util.toExplicitDHParameterSpec(Util.RFC5114_1024_160);
    private static final DHParameterSpec PARAMS_GFP_2048_224 = Util.toExplicitDHParameterSpec(Util.RFC5114_2048_224);
    private static final DHParameterSpec PARAMS_GFP_2048_256 = Util.toExplicitDHParameterSpec(Util.RFC5114_2048_256);
    public static final int PARAM_ID_ECP_BRAINPOOL_P192_R1 = 9;
    public static final int PARAM_ID_ECP_BRAINPOOL_P224_R1 = 11;
    public static final int PARAM_ID_ECP_BRAINPOOL_P256_R1 = 13;
    public static final int PARAM_ID_ECP_BRAINPOOL_P320_R1 = 14;
    public static final int PARAM_ID_ECP_BRAINPOOL_P384_R1 = 16;
    public static final int PARAM_ID_ECP_BRAINPOOL_P512_R1 = 17;
    public static final int PARAM_ID_ECP_NIST_P192_R1 = 8;
    public static final int PARAM_ID_ECP_NIST_P224_R1 = 10;
    public static final int PARAM_ID_ECP_NIST_P256_R1 = 12;
    public static final int PARAM_ID_ECP_NIST_P384_R1 = 15;
    public static final int PARAM_ID_ECP_NIST_P521_R1 = 18;
    public static final int PARAM_ID_GFP_1024_160 = 0;
    public static final int PARAM_ID_GFP_2048_224 = 1;
    public static final int PARAM_ID_GFP_2048_256 = 2;
    private static final int VERSION_2 = 2;
    private static final long serialVersionUID = 7960925013249578359L;
    private BigInteger parameterId;
    private String protocolOID;
    private int version;

    public static class DHCParameterSpec extends DHParameterSpec {

        /* renamed from: q  reason: collision with root package name */
        private BigInteger f70372q;

        public DHCParameterSpec(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
            super(bigInteger, bigInteger2);
            this.f70372q = bigInteger3;
        }

        public BigInteger getQ() {
            return this.f70372q;
        }
    }

    public enum MappingType {
        GM,
        IM,
        CAM
    }

    public PACEInfo(String str, int i11, int i12) {
        this(str, i11, BigInteger.valueOf((long) i12));
    }

    public static boolean checkRequiredIdentifier(String str) {
        return ALLOWED_REQUIRED_IDENTIFIERS.contains(str);
    }

    public static PACEInfo createPACEInfo(byte[] bArr) {
        ASN1Sequence instance = ASN1Sequence.getInstance(bArr);
        String id2 = ((ASN1ObjectIdentifier) instance.getObjectAt(0)).getId();
        ASN1Primitive aSN1Primitive = instance.getObjectAt(1).toASN1Primitive();
        BigInteger bigInteger = null;
        ASN1Primitive aSN1Primitive2 = instance.size() == 3 ? instance.getObjectAt(2).toASN1Primitive() : null;
        int intValue = ((ASN1Integer) aSN1Primitive).getValue().intValue();
        if (aSN1Primitive2 != null) {
            bigInteger = ((ASN1Integer) aSN1Primitive2).getValue();
        }
        return new PACEInfo(id2, intValue, bigInteger);
    }

    public static String toCipherAlgorithm(String str) {
        if (SecurityInfo.ID_PACE_DH_GM_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_PACE_DH_IM_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_PACE_ECDH_GM_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_PACE_ECDH_IM_3DES_CBC_CBC.equals(str)) {
            return "DESede";
        }
        if (SecurityInfo.ID_PACE_DH_GM_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_PACE_DH_GM_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_PACE_DH_GM_AES_CBC_CMAC_256.equals(str) || SecurityInfo.ID_PACE_DH_IM_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_PACE_DH_IM_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_PACE_DH_IM_AES_CBC_CMAC_256.equals(str) || SecurityInfo.ID_PACE_ECDH_GM_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_PACE_ECDH_GM_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_PACE_ECDH_GM_AES_CBC_CMAC_256.equals(str) || SecurityInfo.ID_PACE_ECDH_IM_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_PACE_ECDH_IM_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_PACE_ECDH_IM_AES_CBC_CMAC_256.equals(str) || SecurityInfo.ID_PACE_ECDH_CAM_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_PACE_ECDH_CAM_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_PACE_ECDH_CAM_AES_CBC_CMAC_256.equals(str)) {
            return b.f40261d;
        }
        throw new NumberFormatException("Unknown OID: \"" + str + "\"");
    }

    public static String toDigestAlgorithm(String str) {
        if (SecurityInfo.ID_PACE_DH_GM_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_PACE_DH_IM_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_PACE_ECDH_GM_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_PACE_ECDH_IM_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_PACE_DH_GM_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_PACE_DH_IM_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_PACE_ECDH_GM_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_PACE_ECDH_IM_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_PACE_ECDH_CAM_AES_CBC_CMAC_128.equals(str)) {
            return McElieceCCA2KeyGenParameterSpec.SHA1;
        }
        if (SecurityInfo.ID_PACE_DH_GM_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_PACE_DH_IM_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_PACE_ECDH_GM_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_PACE_ECDH_IM_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_PACE_ECDH_CAM_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_PACE_DH_GM_AES_CBC_CMAC_256.equals(str) || SecurityInfo.ID_PACE_DH_IM_AES_CBC_CMAC_256.equals(str) || SecurityInfo.ID_PACE_ECDH_GM_AES_CBC_CMAC_256.equals(str) || SecurityInfo.ID_PACE_ECDH_IM_AES_CBC_CMAC_256.equals(str) || SecurityInfo.ID_PACE_ECDH_CAM_AES_CBC_CMAC_256.equals(str)) {
            return "SHA-256";
        }
        throw new NumberFormatException("Unknown OID: \"" + str + "\"");
    }

    public static String toKeyAgreementAlgorithm(String str) {
        if (SecurityInfo.ID_PACE_DH_GM_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_PACE_DH_GM_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_PACE_DH_GM_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_PACE_DH_GM_AES_CBC_CMAC_256.equals(str) || SecurityInfo.ID_PACE_DH_IM_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_PACE_DH_IM_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_PACE_DH_IM_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_PACE_DH_IM_AES_CBC_CMAC_256.equals(str)) {
            return "DH";
        }
        if (SecurityInfo.ID_PACE_ECDH_GM_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_PACE_ECDH_GM_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_PACE_ECDH_GM_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_PACE_ECDH_GM_AES_CBC_CMAC_256.equals(str) || SecurityInfo.ID_PACE_ECDH_IM_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_PACE_ECDH_IM_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_PACE_ECDH_IM_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_PACE_ECDH_IM_AES_CBC_CMAC_256.equals(str) || SecurityInfo.ID_PACE_ECDH_CAM_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_PACE_ECDH_CAM_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_PACE_ECDH_CAM_AES_CBC_CMAC_256.equals(str)) {
            return "ECDH";
        }
        throw new NumberFormatException("Unknown OID: \"" + str + "\"");
    }

    public static int toKeyLength(String str) {
        if (SecurityInfo.ID_PACE_DH_GM_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_PACE_DH_IM_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_PACE_ECDH_GM_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_PACE_ECDH_IM_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_PACE_DH_GM_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_PACE_DH_IM_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_PACE_ECDH_GM_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_PACE_ECDH_IM_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_PACE_ECDH_CAM_AES_CBC_CMAC_128.equals(str)) {
            return 128;
        }
        if (SecurityInfo.ID_PACE_DH_GM_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_PACE_ECDH_GM_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_PACE_DH_IM_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_PACE_ECDH_IM_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_PACE_ECDH_CAM_AES_CBC_CMAC_192.equals(str)) {
            return 192;
        }
        if (SecurityInfo.ID_PACE_DH_GM_AES_CBC_CMAC_256.equals(str) || SecurityInfo.ID_PACE_DH_IM_AES_CBC_CMAC_256.equals(str) || SecurityInfo.ID_PACE_ECDH_GM_AES_CBC_CMAC_256.equals(str) || SecurityInfo.ID_PACE_ECDH_IM_AES_CBC_CMAC_256.equals(str) || SecurityInfo.ID_PACE_ECDH_CAM_AES_CBC_CMAC_256.equals(str)) {
            return 256;
        }
        throw new NumberFormatException("Unknown OID: \"" + str + "\"");
    }

    public static MappingType toMappingType(String str) {
        if (SecurityInfo.ID_PACE_DH_GM_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_PACE_DH_GM_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_PACE_DH_GM_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_PACE_DH_GM_AES_CBC_CMAC_256.equals(str) || SecurityInfo.ID_PACE_ECDH_GM_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_PACE_ECDH_GM_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_PACE_ECDH_GM_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_PACE_ECDH_GM_AES_CBC_CMAC_256.equals(str)) {
            return MappingType.GM;
        }
        if (SecurityInfo.ID_PACE_DH_IM_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_PACE_DH_IM_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_PACE_DH_IM_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_PACE_DH_IM_AES_CBC_CMAC_256.equals(str) || SecurityInfo.ID_PACE_ECDH_IM_3DES_CBC_CBC.equals(str) || SecurityInfo.ID_PACE_ECDH_IM_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_PACE_ECDH_IM_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_PACE_ECDH_IM_AES_CBC_CMAC_256.equals(str)) {
            return MappingType.IM;
        }
        if (SecurityInfo.ID_PACE_ECDH_CAM_AES_CBC_CMAC_128.equals(str) || SecurityInfo.ID_PACE_ECDH_CAM_AES_CBC_CMAC_192.equals(str) || SecurityInfo.ID_PACE_ECDH_CAM_AES_CBC_CMAC_256.equals(str)) {
            return MappingType.CAM;
        }
        throw new NumberFormatException("Unknown OID: \"" + str + "\"");
    }

    public static AlgorithmParameterSpec toParameterSpec(BigInteger bigInteger) {
        return toParameterSpec(bigInteger.intValue());
    }

    private String toProtocolOIDString(String str) {
        if (SecurityInfo.ID_PACE_DH_GM_3DES_CBC_CBC.equals(str)) {
            return "id-PACE-DH-GM-3DES-CBC-CBC";
        }
        if (SecurityInfo.ID_PACE_DH_GM_AES_CBC_CMAC_128.equals(str)) {
            return "id-PACE-DH-GM-AES-CBC-CMAC-128";
        }
        if (SecurityInfo.ID_PACE_DH_GM_AES_CBC_CMAC_192.equals(str)) {
            return "id-PACE-DH-GM-AES-CBC-CMAC-192";
        }
        if (SecurityInfo.ID_PACE_DH_GM_AES_CBC_CMAC_256.equals(str)) {
            return "id-PACE-DH-GM-AES-CBC-CMAC-256";
        }
        if (SecurityInfo.ID_PACE_DH_IM_3DES_CBC_CBC.equals(str)) {
            return "id-PACE-DH-IM-3DES-CBC-CBC";
        }
        if (SecurityInfo.ID_PACE_DH_IM_AES_CBC_CMAC_128.equals(str)) {
            return "id-PACE-DH-IM-AES-CBC-CMAC-128";
        }
        if (SecurityInfo.ID_PACE_DH_IM_AES_CBC_CMAC_192.equals(str)) {
            return "id-PACE-DH-IM-AES-CBC-CMAC-192";
        }
        if (SecurityInfo.ID_PACE_DH_IM_AES_CBC_CMAC_256.equals(str)) {
            return "id-PACE-DH-IM-AES-CBC-CMAC-256";
        }
        if (SecurityInfo.ID_PACE_ECDH_GM_3DES_CBC_CBC.equals(str)) {
            return "id-PACE-ECDH-GM-3DES-CBC-CBC";
        }
        if (SecurityInfo.ID_PACE_ECDH_GM_AES_CBC_CMAC_128.equals(str)) {
            return "id-PACE-ECDH-GM-AES-CBC-CMAC-128";
        }
        if (SecurityInfo.ID_PACE_ECDH_GM_AES_CBC_CMAC_192.equals(str)) {
            return "id-PACE-ECDH-GM-AES-CBC-CMAC-192";
        }
        if (SecurityInfo.ID_PACE_ECDH_GM_AES_CBC_CMAC_256.equals(str)) {
            return "id-PACE-ECDH-GM-AES-CBC-CMAC-256";
        }
        if (SecurityInfo.ID_PACE_ECDH_IM_3DES_CBC_CBC.equals(str)) {
            return "id-PACE-ECDH-IM-3DES-CBC-CBC";
        }
        if (SecurityInfo.ID_PACE_ECDH_IM_AES_CBC_CMAC_128.equals(str)) {
            return "id-PACE-ECDH-IM-AES-CBC-CMAC-128";
        }
        if (SecurityInfo.ID_PACE_ECDH_IM_AES_CBC_CMAC_192.equals(str)) {
            return "id-PACE-ECDH-IM-AES-CBC-CMAC-192";
        }
        if (SecurityInfo.ID_PACE_ECDH_IM_AES_CBC_CMAC_256.equals(str)) {
            return "id-PACE-ECDH-IM-AES-CBC-CMAC-256";
        }
        if (SecurityInfo.ID_PACE_ECDH_CAM_AES_CBC_CMAC_128.equals(str)) {
            return "id-PACE-ECDH-CAM-AES-CBC-CMAC-128";
        }
        if (SecurityInfo.ID_PACE_ECDH_CAM_AES_CBC_CMAC_192.equals(str)) {
            return "id-PACE-ECDH-CAM-AES-CBC-CMAC-192";
        }
        return SecurityInfo.ID_PACE_ECDH_CAM_AES_CBC_CMAC_256.equals(str) ? "id-PACE-ECDH-CAM-AES-CBC-CMAC-256" : str;
    }

    public static String toStandardizedParamIdString(BigInteger bigInteger) {
        if (bigInteger == null) {
            return OptionsBridge.NULL_VALUE;
        }
        int intValue = bigInteger.intValue();
        if (intValue == 0) {
            return "1024-bit MODP Group with 160-bit Prime Order Subgroup";
        }
        if (intValue == 1) {
            return "2048-bit MODP Group with 224-bit Prime Order Subgroup";
        }
        if (intValue == 2) {
            return "2048-bit MODP Group with 256-bit Prime Order Subgroup";
        }
        switch (intValue) {
            case 8:
                return "NIST P-192 (secp192r1)";
            case 9:
                return "BrainpoolP192r1";
            case 10:
                return "NIST P-224 (secp224r1)";
            case 11:
                return "BrainpoolP224r1";
            case 12:
                return "NIST P-256 (secp256r1)";
            case 13:
                return "BrainpoolP256r1";
            case 14:
                return "BrainpoolP320r1";
            case 15:
                return "NIST P-384 (secp384r1)";
            case 16:
                return "BrainpoolP384r1";
            case 17:
                return "BrainpoolP512r1";
            case 18:
                return "NIST P-521 (secp521r1)";
            default:
                return bigInteger.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!PACEInfo.class.equals(obj.getClass())) {
            return false;
        }
        PACEInfo pACEInfo = (PACEInfo) obj;
        String str = this.protocolOID;
        if (str == null && pACEInfo.protocolOID != null) {
            return false;
        }
        if ((str != null && !str.equals(pACEInfo.protocolOID)) || this.version != pACEInfo.version) {
            return false;
        }
        BigInteger bigInteger = this.parameterId;
        if (bigInteger != null || pACEInfo.parameterId == null) {
            return bigInteger == null || bigInteger.equals(pACEInfo.parameterId);
        }
        return false;
    }

    @Deprecated
    public ASN1Primitive getDERObject() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1ObjectIdentifier(this.protocolOID));
        aSN1EncodableVector.add(new ASN1Integer((long) this.version));
        if (this.parameterId != null) {
            aSN1EncodableVector.add(new ASN1Integer(this.parameterId));
        }
        return new DLSequence(aSN1EncodableVector);
    }

    public String getObjectIdentifier() {
        return this.protocolOID;
    }

    public BigInteger getParameterId() {
        return this.parameterId;
    }

    public String getProtocolOIDString() {
        return toProtocolOIDString(this.protocolOID);
    }

    public int getVersion() {
        return this.version;
    }

    public int hashCode() {
        int hashCode = (this.protocolOID.hashCode() * 7) + 1234567891 + (this.version * 5);
        BigInteger bigInteger = this.parameterId;
        return hashCode + ((bigInteger == null ? 1991 : bigInteger.hashCode()) * 3);
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("PACEInfo [");
        sb2.append("protocol: ");
        sb2.append(toProtocolOIDString(this.protocolOID));
        sb2.append(", version: ");
        sb2.append(this.version);
        if (this.parameterId != null) {
            sb2.append(", parameterId: ");
            sb2.append(toStandardizedParamIdString(this.parameterId));
        }
        sb2.append("]");
        return sb2.toString();
    }

    public PACEInfo(String str, int i11, BigInteger bigInteger) {
        if (checkRequiredIdentifier(str)) {
            if (i11 != 2) {
                LOGGER.warning("Invalid version, must be 2");
            }
            this.protocolOID = str;
            this.version = i11;
            this.parameterId = bigInteger;
            return;
        }
        throw new IllegalArgumentException("Invalid OID");
    }

    public static AlgorithmParameterSpec toParameterSpec(int i11) {
        if (i11 == 0) {
            return PARAMS_GFP_1024_160;
        }
        if (i11 == 1) {
            return PARAMS_GFP_2048_224;
        }
        if (i11 == 2) {
            return PARAMS_GFP_2048_256;
        }
        switch (i11) {
            case 8:
                return PARAMS_ECP_NIST_P192_R1;
            case 9:
                return PARAMS_ECP_BRAINPOOL_P192_R1;
            case 10:
                return PARAMS_ECP_NIST_P224_R1;
            case 11:
                return PARAMS_ECP_BRAINPOOL_P224_R1;
            case 12:
                return PARAMS_ECP_NIST_P256_R1;
            case 13:
                return PARAMS_ECP_BRAINPOOL_P256_R1;
            case 14:
                return PARAMS_ECP_BRAINPOOL_P320_R1;
            case 15:
                return PARAMS_ECP_NIST_P384_R1;
            case 16:
                return PARAMS_ECP_BRAINPOOL_P384_R1;
            case 17:
                return PARAMS_ECP_BRAINPOOL_P512_R1;
            case 18:
                return PARAMS_ECP_NIST_P521_R1;
            default:
                throw new NumberFormatException("Unknown standardized domain parameters " + i11);
        }
    }
}
