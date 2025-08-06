package org.bouncycastle.pqc.crypto.util;

import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.bc.BCObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA256Digest;
import org.bouncycastle.crypto.digests.SHA512Digest;
import org.bouncycastle.crypto.digests.SHAKEDigest;
import org.bouncycastle.pqc.asn1.PQCObjectIdentifiers;
import org.bouncycastle.pqc.asn1.SPHINCS256KeyParams;
import org.bouncycastle.pqc.crypto.cmce.CMCEParameters;
import org.bouncycastle.pqc.crypto.frodo.FrodoParameters;
import org.bouncycastle.pqc.crypto.saber.SABERParameters;
import org.bouncycastle.pqc.crypto.sphincs.SPHINCSKeyParameters;
import org.bouncycastle.pqc.crypto.sphincsplus.SPHINCSPlusParameters;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.bouncycastle.util.Integers;

class Utils {
    public static final AlgorithmIdentifier AlgID_qTESLA_p_I;
    public static final AlgorithmIdentifier AlgID_qTESLA_p_III;
    public static final AlgorithmIdentifier SPHINCS_SHA3_256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha3_256);
    public static final AlgorithmIdentifier SPHINCS_SHA512_256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512_256);
    public static final AlgorithmIdentifier XMSS_SHA256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256);
    public static final AlgorithmIdentifier XMSS_SHA512 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512);
    public static final AlgorithmIdentifier XMSS_SHAKE128 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_shake128);
    public static final AlgorithmIdentifier XMSS_SHAKE256 = new AlgorithmIdentifier(NISTObjectIdentifiers.id_shake256);
    public static final Map categories;
    public static final Map frodoOids;
    public static final Map frodoParams;
    public static final Map mcElieceOids;
    public static final Map mcElieceParams;
    public static final Map saberOids;
    public static final Map saberParams;
    public static final Map sphincsPlusOids = new HashMap();
    public static final Map sphincsPlusParams = new HashMap();

    static {
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PQCObjectIdentifiers.qTESLA_p_I;
        AlgID_qTESLA_p_I = new AlgorithmIdentifier(aSN1ObjectIdentifier);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = PQCObjectIdentifiers.qTESLA_p_III;
        AlgID_qTESLA_p_III = new AlgorithmIdentifier(aSN1ObjectIdentifier2);
        HashMap hashMap = new HashMap();
        categories = hashMap;
        HashMap hashMap2 = new HashMap();
        frodoOids = hashMap2;
        HashMap hashMap3 = new HashMap();
        frodoParams = hashMap3;
        HashMap hashMap4 = new HashMap();
        saberOids = hashMap4;
        HashMap hashMap5 = new HashMap();
        saberParams = hashMap5;
        HashMap hashMap6 = new HashMap();
        mcElieceOids = hashMap6;
        HashMap hashMap7 = new HashMap();
        mcElieceParams = hashMap7;
        hashMap.put(aSN1ObjectIdentifier, Integers.valueOf(5));
        hashMap.put(aSN1ObjectIdentifier2, Integers.valueOf(6));
        CMCEParameters cMCEParameters = CMCEParameters.mceliece348864r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = BCObjectIdentifiers.mceliece348864_r3;
        hashMap6.put(cMCEParameters, aSN1ObjectIdentifier3);
        CMCEParameters cMCEParameters2 = CMCEParameters.mceliece348864fr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = BCObjectIdentifiers.mceliece348864f_r3;
        hashMap6.put(cMCEParameters2, aSN1ObjectIdentifier4);
        CMCEParameters cMCEParameters3 = CMCEParameters.mceliece460896r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = BCObjectIdentifiers.mceliece460896_r3;
        hashMap6.put(cMCEParameters3, aSN1ObjectIdentifier5);
        CMCEParameters cMCEParameters4 = CMCEParameters.mceliece460896fr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = BCObjectIdentifiers.mceliece460896f_r3;
        hashMap6.put(cMCEParameters4, aSN1ObjectIdentifier6);
        CMCEParameters cMCEParameters5 = CMCEParameters.mceliece6688128r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = BCObjectIdentifiers.mceliece6688128_r3;
        hashMap6.put(cMCEParameters5, aSN1ObjectIdentifier7);
        HashMap hashMap8 = hashMap5;
        CMCEParameters cMCEParameters6 = CMCEParameters.mceliece6688128fr3;
        HashMap hashMap9 = hashMap4;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = BCObjectIdentifiers.mceliece6688128f_r3;
        hashMap6.put(cMCEParameters6, aSN1ObjectIdentifier8);
        HashMap hashMap10 = hashMap3;
        CMCEParameters cMCEParameters7 = CMCEParameters.mceliece6960119r3;
        HashMap hashMap11 = hashMap2;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = BCObjectIdentifiers.mceliece6960119_r3;
        hashMap6.put(cMCEParameters7, aSN1ObjectIdentifier9);
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = aSN1ObjectIdentifier9;
        CMCEParameters cMCEParameters8 = CMCEParameters.mceliece6960119fr3;
        CMCEParameters cMCEParameters9 = cMCEParameters7;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = BCObjectIdentifiers.mceliece6960119f_r3;
        hashMap6.put(cMCEParameters8, aSN1ObjectIdentifier11);
        CMCEParameters cMCEParameters10 = cMCEParameters8;
        CMCEParameters cMCEParameters11 = CMCEParameters.mceliece8192128r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = aSN1ObjectIdentifier11;
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = BCObjectIdentifiers.mceliece8192128_r3;
        hashMap6.put(cMCEParameters11, aSN1ObjectIdentifier13);
        CMCEParameters cMCEParameters12 = cMCEParameters11;
        CMCEParameters cMCEParameters13 = CMCEParameters.mceliece8192128fr3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = aSN1ObjectIdentifier13;
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = BCObjectIdentifiers.mceliece8192128f_r3;
        hashMap6.put(cMCEParameters13, aSN1ObjectIdentifier15);
        hashMap7.put(aSN1ObjectIdentifier3, cMCEParameters);
        hashMap7.put(aSN1ObjectIdentifier4, cMCEParameters2);
        hashMap7.put(aSN1ObjectIdentifier5, cMCEParameters3);
        hashMap7.put(aSN1ObjectIdentifier6, cMCEParameters4);
        hashMap7.put(aSN1ObjectIdentifier7, cMCEParameters5);
        hashMap7.put(aSN1ObjectIdentifier8, cMCEParameters6);
        hashMap7.put(aSN1ObjectIdentifier10, cMCEParameters9);
        hashMap7.put(aSN1ObjectIdentifier12, cMCEParameters10);
        hashMap7.put(aSN1ObjectIdentifier14, cMCEParameters12);
        hashMap7.put(aSN1ObjectIdentifier15, cMCEParameters13);
        FrodoParameters frodoParameters = FrodoParameters.frodokem19888r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = BCObjectIdentifiers.frodokem19888r3;
        HashMap hashMap12 = hashMap11;
        hashMap12.put(frodoParameters, aSN1ObjectIdentifier16);
        FrodoParameters frodoParameters2 = FrodoParameters.frodokem19888shaker3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = BCObjectIdentifiers.frodokem19888shaker3;
        hashMap12.put(frodoParameters2, aSN1ObjectIdentifier17);
        FrodoParameters frodoParameters3 = FrodoParameters.frodokem31296r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier18 = BCObjectIdentifiers.frodokem31296r3;
        hashMap12.put(frodoParameters3, aSN1ObjectIdentifier18);
        FrodoParameters frodoParameters4 = FrodoParameters.frodokem31296shaker3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier19 = BCObjectIdentifiers.frodokem31296shaker3;
        hashMap12.put(frodoParameters4, aSN1ObjectIdentifier19);
        FrodoParameters frodoParameters5 = FrodoParameters.frodokem43088r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier20 = BCObjectIdentifiers.frodokem43088r3;
        hashMap12.put(frodoParameters5, aSN1ObjectIdentifier20);
        FrodoParameters frodoParameters6 = FrodoParameters.frodokem43088shaker3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier21 = BCObjectIdentifiers.frodokem43088shaker3;
        hashMap12.put(frodoParameters6, aSN1ObjectIdentifier21);
        HashMap hashMap13 = hashMap10;
        hashMap13.put(aSN1ObjectIdentifier16, frodoParameters);
        hashMap13.put(aSN1ObjectIdentifier17, frodoParameters2);
        hashMap13.put(aSN1ObjectIdentifier18, frodoParameters3);
        hashMap13.put(aSN1ObjectIdentifier19, frodoParameters4);
        hashMap13.put(aSN1ObjectIdentifier20, frodoParameters5);
        hashMap13.put(aSN1ObjectIdentifier21, frodoParameters6);
        SABERParameters sABERParameters = SABERParameters.lightsaberkem128r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier22 = BCObjectIdentifiers.lightsaberkem128r3;
        HashMap hashMap14 = hashMap9;
        hashMap14.put(sABERParameters, aSN1ObjectIdentifier22);
        SABERParameters sABERParameters2 = SABERParameters.saberkem128r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier23 = BCObjectIdentifiers.saberkem128r3;
        hashMap14.put(sABERParameters2, aSN1ObjectIdentifier23);
        SABERParameters sABERParameters3 = SABERParameters.firesaberkem128r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier24 = BCObjectIdentifiers.firesaberkem128r3;
        hashMap14.put(sABERParameters3, aSN1ObjectIdentifier24);
        SABERParameters sABERParameters4 = SABERParameters.lightsaberkem192r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier25 = BCObjectIdentifiers.lightsaberkem192r3;
        hashMap14.put(sABERParameters4, aSN1ObjectIdentifier25);
        SABERParameters sABERParameters5 = SABERParameters.saberkem192r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier26 = BCObjectIdentifiers.saberkem192r3;
        hashMap14.put(sABERParameters5, aSN1ObjectIdentifier26);
        SABERParameters sABERParameters6 = SABERParameters.firesaberkem192r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier27 = BCObjectIdentifiers.firesaberkem192r3;
        hashMap14.put(sABERParameters6, aSN1ObjectIdentifier27);
        SABERParameters sABERParameters7 = SABERParameters.lightsaberkem256r3;
        ASN1ObjectIdentifier aSN1ObjectIdentifier28 = BCObjectIdentifiers.lightsaberkem256r3;
        hashMap14.put(sABERParameters7, aSN1ObjectIdentifier28);
        SABERParameters sABERParameters8 = SABERParameters.saberkem256r3;
        SABERParameters sABERParameters9 = sABERParameters7;
        ASN1ObjectIdentifier aSN1ObjectIdentifier29 = BCObjectIdentifiers.saberkem256r3;
        hashMap14.put(sABERParameters8, aSN1ObjectIdentifier29);
        ASN1ObjectIdentifier aSN1ObjectIdentifier30 = aSN1ObjectIdentifier29;
        SABERParameters sABERParameters10 = SABERParameters.firesaberkem256r3;
        SABERParameters sABERParameters11 = sABERParameters8;
        ASN1ObjectIdentifier aSN1ObjectIdentifier31 = BCObjectIdentifiers.firesaberkem256r3;
        hashMap14.put(sABERParameters10, aSN1ObjectIdentifier31);
        HashMap hashMap15 = hashMap8;
        hashMap15.put(aSN1ObjectIdentifier22, sABERParameters);
        hashMap15.put(aSN1ObjectIdentifier23, sABERParameters2);
        hashMap15.put(aSN1ObjectIdentifier24, sABERParameters3);
        hashMap15.put(aSN1ObjectIdentifier25, sABERParameters4);
        hashMap15.put(aSN1ObjectIdentifier26, sABERParameters5);
        hashMap15.put(aSN1ObjectIdentifier27, sABERParameters6);
        hashMap15.put(aSN1ObjectIdentifier28, sABERParameters9);
        hashMap15.put(aSN1ObjectIdentifier30, sABERParameters11);
        hashMap15.put(aSN1ObjectIdentifier31, sABERParameters10);
    }

    public static ASN1ObjectIdentifier frodoOidLookup(FrodoParameters frodoParameters) {
        return (ASN1ObjectIdentifier) frodoOids.get(frodoParameters);
    }

    public static FrodoParameters frodoParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (FrodoParameters) frodoParams.get(aSN1ObjectIdentifier);
    }

    public static AlgorithmIdentifier getAlgorithmIdentifier(String str) {
        if (str.equals(McElieceCCA2KeyGenParameterSpec.SHA1)) {
            return new AlgorithmIdentifier(OIWObjectIdentifiers.idSHA1, DERNull.INSTANCE);
        }
        if (str.equals(McElieceCCA2KeyGenParameterSpec.SHA224)) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha224);
        }
        if (str.equals("SHA-256")) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256);
        }
        if (str.equals("SHA-384")) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha384);
        }
        if (str.equals("SHA-512")) {
            return new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512);
        }
        throw new IllegalArgumentException("unrecognised digest algorithm: " + str);
    }

    public static Digest getDigest(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_sha256)) {
            return new SHA256Digest();
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_sha512)) {
            return new SHA512Digest();
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_shake128)) {
            return new SHAKEDigest(128);
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_shake256)) {
            return new SHAKEDigest(256);
        }
        throw new IllegalArgumentException("unrecognized digest OID: " + aSN1ObjectIdentifier);
    }

    public static String getDigestName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) OIWObjectIdentifiers.idSHA1)) {
            return McElieceCCA2KeyGenParameterSpec.SHA1;
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_sha224)) {
            return McElieceCCA2KeyGenParameterSpec.SHA224;
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_sha256)) {
            return "SHA-256";
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_sha384)) {
            return "SHA-384";
        }
        if (aSN1ObjectIdentifier.equals((ASN1Primitive) NISTObjectIdentifiers.id_sha512)) {
            return "SHA-512";
        }
        throw new IllegalArgumentException("unrecognised digest algorithm: " + aSN1ObjectIdentifier);
    }

    public static ASN1ObjectIdentifier mcElieceOidLookup(CMCEParameters cMCEParameters) {
        return (ASN1ObjectIdentifier) mcElieceOids.get(cMCEParameters);
    }

    public static CMCEParameters mcElieceParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (CMCEParameters) mcElieceParams.get(aSN1ObjectIdentifier);
    }

    public static AlgorithmIdentifier qTeslaLookupAlgID(int i11) {
        if (i11 == 5) {
            return AlgID_qTESLA_p_I;
        }
        if (i11 == 6) {
            return AlgID_qTESLA_p_III;
        }
        throw new IllegalArgumentException("unknown security category: " + i11);
    }

    public static int qTeslaLookupSecurityCategory(AlgorithmIdentifier algorithmIdentifier) {
        return ((Integer) categories.get(algorithmIdentifier.getAlgorithm())).intValue();
    }

    public static ASN1ObjectIdentifier saberOidLookup(SABERParameters sABERParameters) {
        return (ASN1ObjectIdentifier) saberOids.get(sABERParameters);
    }

    public static SABERParameters saberParamsLookup(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return (SABERParameters) saberParams.get(aSN1ObjectIdentifier);
    }

    public static AlgorithmIdentifier sphincs256LookupTreeAlgID(String str) {
        if (str.equals("SHA3-256")) {
            return SPHINCS_SHA3_256;
        }
        if (str.equals(SPHINCSKeyParameters.SHA512_256)) {
            return SPHINCS_SHA512_256;
        }
        throw new IllegalArgumentException("unknown tree digest: " + str);
    }

    public static String sphincs256LookupTreeAlgName(SPHINCS256KeyParams sPHINCS256KeyParams) {
        AlgorithmIdentifier treeDigest = sPHINCS256KeyParams.getTreeDigest();
        if (treeDigest.getAlgorithm().equals((ASN1Primitive) SPHINCS_SHA3_256.getAlgorithm())) {
            return "SHA3-256";
        }
        if (treeDigest.getAlgorithm().equals((ASN1Primitive) SPHINCS_SHA512_256.getAlgorithm())) {
            return SPHINCSKeyParameters.SHA512_256;
        }
        throw new IllegalArgumentException("unknown tree digest: " + treeDigest.getAlgorithm());
    }

    public static ASN1ObjectIdentifier sphincsPlusOidLookup(SPHINCSPlusParameters sPHINCSPlusParameters) {
        int intValue = SPHINCSPlusParameters.getID(sPHINCSPlusParameters).intValue();
        return (intValue & 131072) == 131072 ? BCObjectIdentifiers.sphincsPlus_shake_256 : ((intValue & 5) == 5 || (intValue & 6) == 6) ? BCObjectIdentifiers.sphincsPlus_sha_512 : BCObjectIdentifiers.sphincsPlus_sha_256;
    }

    public static AlgorithmIdentifier xmssLookupTreeAlgID(String str) {
        if (str.equals("SHA-256")) {
            return XMSS_SHA256;
        }
        if (str.equals("SHA-512")) {
            return XMSS_SHA512;
        }
        if (str.equals("SHAKE128")) {
            return XMSS_SHAKE128;
        }
        if (str.equals("SHAKE256")) {
            return XMSS_SHAKE256;
        }
        throw new IllegalArgumentException("unknown tree digest: " + str);
    }
}
