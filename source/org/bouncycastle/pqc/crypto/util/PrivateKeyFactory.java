package org.bouncycastle.pqc.crypto.util;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.bc.BCObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.pqc.asn1.CMCEPrivateKey;
import org.bouncycastle.pqc.asn1.McElieceCCA2PrivateKey;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.SPHINCS256KeyParams;
import org.bouncycastle.pqc.asn1.XMSSKeyParams;
import org.bouncycastle.pqc.asn1.XMSSMTKeyParams;
import org.bouncycastle.pqc.asn1.XMSSMTPrivateKey;
import org.bouncycastle.pqc.asn1.XMSSPrivateKey;
import org.bouncycastle.pqc.crypto.cmce.CMCEPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.frodo.FrodoPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.lms.HSSPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.lms.LMSPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.mceliece.McElieceCCA2PrivateKeyParameters;
import org.bouncycastle.pqc.crypto.newhope.NHPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.qtesla.QTESLAPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.saber.SABERPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.sphincsplus.SPHINCSPlusParameters;
import org.bouncycastle.pqc.crypto.sphincsplus.SPHINCSPlusPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.BDS;
import org.bouncycastle.pqc.crypto.xmss.BDSStateMap;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSMTPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSPrivateKeyParameters;
import org.bouncycastle.pqc.crypto.xmss.XMSSUtil;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Pack;

public class PrivateKeyFactory {
    private static short[] convert(byte[] bArr) {
        int length = bArr.length / 2;
        short[] sArr = new short[length];
        for (int i11 = 0; i11 != length; i11++) {
            sArr[i11] = Pack.littleEndianToShort(bArr, i11 * 2);
        }
        return sArr;
    }

    public static AsymmetricKeyParameter createKey(InputStream inputStream) throws IOException {
        return createKey(PrivateKeyInfo.getInstance(new ASN1InputStream(inputStream).readObject()));
    }

    public static AsymmetricKeyParameter createKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        ASN1ObjectIdentifier algorithm = privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm();
        if (algorithm.on(BCObjectIdentifiers.qTESLA)) {
            return new QTESLAPrivateKeyParameters(Utils.qTeslaLookupSecurityCategory(privateKeyInfo.getPrivateKeyAlgorithm()), ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey()).getOctets());
        } else if (algorithm.equals((ASN1Primitive) BCObjectIdentifiers.sphincs256)) {
            return new SPHINCSPrivateKeyParameters(ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey()).getOctets(), Utils.sphincs256LookupTreeAlgName(SPHINCS256KeyParams.getInstance(privateKeyInfo.getPrivateKeyAlgorithm().getParameters())));
        } else {
            if (algorithm.equals((ASN1Primitive) BCObjectIdentifiers.newHope)) {
                return new NHPrivateKeyParameters(convert(ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey()).getOctets()));
            }
            if (algorithm.equals((ASN1Primitive) PKCSObjectIdentifiers.id_alg_hss_lms_hashsig)) {
                byte[] octets = ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey()).getOctets();
                ASN1BitString publicKeyData = privateKeyInfo.getPublicKeyData();
                if (Pack.bigEndianToInt(octets, 0) == 1) {
                    if (publicKeyData == null) {
                        return LMSPrivateKeyParameters.getInstance(Arrays.copyOfRange(octets, 4, octets.length));
                    }
                    byte[] octets2 = publicKeyData.getOctets();
                    return LMSPrivateKeyParameters.getInstance(Arrays.copyOfRange(octets, 4, octets.length), Arrays.copyOfRange(octets2, 4, octets2.length));
                } else if (publicKeyData == null) {
                    return HSSPrivateKeyParameters.getInstance(Arrays.copyOfRange(octets, 4, octets.length));
                } else {
                    return HSSPrivateKeyParameters.getInstance(Arrays.copyOfRange(octets, 4, octets.length), publicKeyData.getOctets());
                }
            } else if (algorithm.on(BCObjectIdentifiers.sphincsPlus)) {
                byte[] octets3 = ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey()).getOctets();
                return new SPHINCSPlusPrivateKeyParameters(SPHINCSPlusParameters.getParams(Integers.valueOf(Pack.bigEndianToInt(octets3, 0))), Arrays.copyOfRange(octets3, 4, octets3.length));
            } else if (algorithm.on(BCObjectIdentifiers.pqc_kem_mceliece)) {
                CMCEPrivateKey instance = CMCEPrivateKey.getInstance(privateKeyInfo.parsePrivateKey());
                return new CMCEPrivateKeyParameters(Utils.mcElieceParamsLookup(privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm()), instance.getDelta(), instance.getC(), instance.getG(), instance.getAlpha(), instance.getS());
            } else if (algorithm.on(BCObjectIdentifiers.pqc_kem_frodo)) {
                return new FrodoPrivateKeyParameters(Utils.frodoParamsLookup(privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm()), ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey()).getOctets());
            } else if (algorithm.on(BCObjectIdentifiers.pqc_kem_saber)) {
                return new SABERPrivateKeyParameters(Utils.saberParamsLookup(privateKeyInfo.getPrivateKeyAlgorithm().getAlgorithm()), ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey()).getOctets());
            } else if (algorithm.equals((ASN1Primitive) BCObjectIdentifiers.xmss)) {
                XMSSKeyParams instance2 = XMSSKeyParams.getInstance(privateKeyInfo.getPrivateKeyAlgorithm().getParameters());
                ASN1ObjectIdentifier algorithm2 = instance2.getTreeDigest().getAlgorithm();
                XMSSPrivateKey instance3 = XMSSPrivateKey.getInstance(privateKeyInfo.parsePrivateKey());
                try {
                    XMSSPrivateKeyParameters.Builder withRoot = new XMSSPrivateKeyParameters.Builder(new XMSSParameters(instance2.getHeight(), Utils.getDigest(algorithm2))).withIndex(instance3.getIndex()).withSecretKeySeed(instance3.getSecretKeySeed()).withSecretKeyPRF(instance3.getSecretKeyPRF()).withPublicSeed(instance3.getPublicSeed()).withRoot(instance3.getRoot());
                    if (instance3.getVersion() != 0) {
                        withRoot.withMaxIndex(instance3.getMaxIndex());
                    }
                    if (instance3.getBdsState() != null) {
                        withRoot.withBDSState(((BDS) XMSSUtil.deserialize(instance3.getBdsState(), BDS.class)).withWOTSDigest(algorithm2));
                    }
                    return withRoot.build();
                } catch (ClassNotFoundException e11) {
                    throw new IOException("ClassNotFoundException processing BDS state: " + e11.getMessage());
                }
            } else if (algorithm.equals((ASN1Primitive) PQCObjectIdentifiers.xmss_mt)) {
                XMSSMTKeyParams instance4 = XMSSMTKeyParams.getInstance(privateKeyInfo.getPrivateKeyAlgorithm().getParameters());
                ASN1ObjectIdentifier algorithm3 = instance4.getTreeDigest().getAlgorithm();
                try {
                    XMSSMTPrivateKey instance5 = XMSSMTPrivateKey.getInstance(privateKeyInfo.parsePrivateKey());
                    XMSSMTPrivateKeyParameters.Builder withRoot2 = new XMSSMTPrivateKeyParameters.Builder(new XMSSMTParameters(instance4.getHeight(), instance4.getLayers(), Utils.getDigest(algorithm3))).withIndex(instance5.getIndex()).withSecretKeySeed(instance5.getSecretKeySeed()).withSecretKeyPRF(instance5.getSecretKeyPRF()).withPublicSeed(instance5.getPublicSeed()).withRoot(instance5.getRoot());
                    if (instance5.getVersion() != 0) {
                        withRoot2.withMaxIndex(instance5.getMaxIndex());
                    }
                    if (instance5.getBdsState() != null) {
                        withRoot2.withBDSState(((BDSStateMap) XMSSUtil.deserialize(instance5.getBdsState(), BDSStateMap.class)).withWOTSDigest(algorithm3));
                    }
                    return withRoot2.build();
                } catch (ClassNotFoundException e12) {
                    throw new IOException("ClassNotFoundException processing BDS state: " + e12.getMessage());
                }
            } else if (algorithm.equals((ASN1Primitive) PQCObjectIdentifiers.mcElieceCca2)) {
                McElieceCCA2PrivateKey instance6 = McElieceCCA2PrivateKey.getInstance(privateKeyInfo.parsePrivateKey());
                return new McElieceCCA2PrivateKeyParameters(instance6.getN(), instance6.getK(), instance6.getField(), instance6.getGoppaPoly(), instance6.getP(), Utils.getDigestName(instance6.getDigest().getAlgorithm()));
            } else {
                throw new RuntimeException("algorithm identifier in private key not recognised");
            }
        }
    }

    public static AsymmetricKeyParameter createKey(byte[] bArr) throws IOException {
        return createKey(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray(bArr)));
    }
}
