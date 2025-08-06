package org.bouncycastle.jcajce.provider.asymmetric.util;

import com.sumsub.sns.prooface.network.b;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.AlgorithmParameterSpec;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;
import javax.crypto.KeyAgreementSpi;
import javax.crypto.SecretKey;
import javax.crypto.ShortBufferException;
import javax.crypto.spec.SecretKeySpec;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.gnu.GNUObjectIdentifiers;
import org.bouncycastle.asn1.kisa.KISAObjectIdentifiers;
import org.bouncycastle.asn1.misc.MiscObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.ntt.NTTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.DerivationFunction;
import org.bouncycastle.crypto.DerivationParameters;
import org.bouncycastle.crypto.agreement.kdf.DHKDFParameters;
import org.bouncycastle.crypto.agreement.kdf.DHKEKGenerator;
import org.bouncycastle.crypto.params.DESParameters;
import org.bouncycastle.crypto.params.KDFParameters;
import org.bouncycastle.jcajce.spec.HybridValueParameterSpec;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Integers;
import org.bouncycastle.util.Strings;

public abstract class BaseAgreementSpi extends KeyAgreementSpi {
    private static final Map<String, ASN1ObjectIdentifier> defaultOids;
    private static final Hashtable des;
    private static final Map<String, Integer> keySizes;
    private static final Map<String, String> nameTable;
    private static final Hashtable oids;
    private HybridValueParameterSpec hybridSpec;
    public final String kaAlgorithm;
    public final DerivationFunction kdf;
    public byte[] ukmParameters;

    static {
        HashMap hashMap = new HashMap();
        defaultOids = hashMap;
        HashMap hashMap2 = new HashMap();
        keySizes = hashMap2;
        HashMap hashMap3 = new HashMap();
        nameTable = hashMap3;
        Hashtable hashtable = new Hashtable();
        oids = hashtable;
        Hashtable hashtable2 = new Hashtable();
        des = hashtable2;
        Integer valueOf = Integers.valueOf(64);
        Integer valueOf2 = Integers.valueOf(128);
        Integer valueOf3 = Integers.valueOf(192);
        Integer valueOf4 = Integers.valueOf(256);
        hashMap2.put("DES", valueOf);
        hashMap2.put("DESEDE", valueOf3);
        hashMap2.put("BLOWFISH", valueOf2);
        hashMap2.put(b.f40261d, valueOf4);
        hashMap2.put(NISTObjectIdentifiers.id_aes128_ECB.getId(), valueOf2);
        hashMap2.put(NISTObjectIdentifiers.id_aes192_ECB.getId(), valueOf3);
        hashMap2.put(NISTObjectIdentifiers.id_aes256_ECB.getId(), valueOf4);
        hashMap2.put(NISTObjectIdentifiers.id_aes128_CBC.getId(), valueOf2);
        hashMap2.put(NISTObjectIdentifiers.id_aes192_CBC.getId(), valueOf3);
        ASN1ObjectIdentifier aSN1ObjectIdentifier = NISTObjectIdentifiers.id_aes256_CBC;
        hashMap2.put(aSN1ObjectIdentifier.getId(), valueOf4);
        hashMap2.put(NISTObjectIdentifiers.id_aes128_CFB.getId(), valueOf2);
        hashMap2.put(NISTObjectIdentifiers.id_aes192_CFB.getId(), valueOf3);
        hashMap2.put(NISTObjectIdentifiers.id_aes256_CFB.getId(), valueOf4);
        hashMap2.put(NISTObjectIdentifiers.id_aes128_OFB.getId(), valueOf2);
        hashMap2.put(NISTObjectIdentifiers.id_aes192_OFB.getId(), valueOf3);
        hashMap2.put(NISTObjectIdentifiers.id_aes256_OFB.getId(), valueOf4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = NISTObjectIdentifiers.id_aes128_wrap;
        hashMap2.put(aSN1ObjectIdentifier2.getId(), valueOf2);
        hashMap2.put(NISTObjectIdentifiers.id_aes192_wrap.getId(), valueOf3);
        hashMap2.put(NISTObjectIdentifiers.id_aes256_wrap.getId(), valueOf4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_aes128_CCM;
        hashMap2.put(aSN1ObjectIdentifier3.getId(), valueOf2);
        hashMap2.put(NISTObjectIdentifiers.id_aes192_CCM.getId(), valueOf3);
        hashMap2.put(NISTObjectIdentifiers.id_aes256_CCM.getId(), valueOf4);
        hashMap2.put(NISTObjectIdentifiers.id_aes128_GCM.getId(), valueOf2);
        hashMap2.put(NISTObjectIdentifiers.id_aes192_GCM.getId(), valueOf3);
        hashMap2.put(NISTObjectIdentifiers.id_aes256_GCM.getId(), valueOf4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NTTObjectIdentifiers.id_camellia128_wrap;
        Hashtable hashtable3 = hashtable2;
        hashMap2.put(aSN1ObjectIdentifier4.getId(), valueOf2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NTTObjectIdentifiers.id_camellia192_wrap;
        Hashtable hashtable4 = hashtable;
        hashMap2.put(aSN1ObjectIdentifier5.getId(), valueOf3);
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = NTTObjectIdentifiers.id_camellia256_wrap;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = aSN1ObjectIdentifier3;
        hashMap2.put(aSN1ObjectIdentifier6.getId(), valueOf4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = KISAObjectIdentifiers.id_npki_app_cmsSeed_wrap;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = aSN1ObjectIdentifier2;
        hashMap2.put(aSN1ObjectIdentifier8.getId(), valueOf2);
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = PKCSObjectIdentifiers.id_alg_CMS3DESwrap;
        hashMap2.put(aSN1ObjectIdentifier10.getId(), valueOf3);
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = PKCSObjectIdentifiers.des_EDE3_CBC;
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = aSN1ObjectIdentifier8;
        hashMap2.put(aSN1ObjectIdentifier11.getId(), valueOf3);
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = OIWObjectIdentifiers.desCBC;
        hashMap2.put(aSN1ObjectIdentifier13.getId(), valueOf);
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = CryptoProObjectIdentifiers.gostR28147_gcfb;
        hashMap2.put(aSN1ObjectIdentifier14.getId(), valueOf4);
        hashMap2.put(CryptoProObjectIdentifiers.id_Gost28147_89_None_KeyWrap.getId(), valueOf4);
        hashMap2.put(CryptoProObjectIdentifiers.id_Gost28147_89_CryptoPro_KeyWrap.getId(), valueOf4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = PKCSObjectIdentifiers.id_hmacWithSHA1;
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = aSN1ObjectIdentifier14;
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = aSN1ObjectIdentifier6;
        hashMap2.put(aSN1ObjectIdentifier15.getId(), Integers.valueOf(160));
        ASN1ObjectIdentifier aSN1ObjectIdentifier18 = PKCSObjectIdentifiers.id_hmacWithSHA256;
        hashMap2.put(aSN1ObjectIdentifier18.getId(), valueOf4);
        ASN1ObjectIdentifier aSN1ObjectIdentifier19 = PKCSObjectIdentifiers.id_hmacWithSHA384;
        ASN1ObjectIdentifier aSN1ObjectIdentifier20 = aSN1ObjectIdentifier5;
        hashMap2.put(aSN1ObjectIdentifier19.getId(), Integers.valueOf(com.sumsub.sns.internal.ml.autocapture.b.f34945b));
        ASN1ObjectIdentifier aSN1ObjectIdentifier21 = PKCSObjectIdentifiers.id_hmacWithSHA512;
        hashMap2.put(aSN1ObjectIdentifier21.getId(), Integers.valueOf(512));
        hashMap.put("DESEDE", aSN1ObjectIdentifier11);
        hashMap.put(b.f40261d, aSN1ObjectIdentifier);
        ASN1ObjectIdentifier aSN1ObjectIdentifier22 = NTTObjectIdentifiers.id_camellia256_cbc;
        hashMap.put("CAMELLIA", aSN1ObjectIdentifier22);
        ASN1ObjectIdentifier aSN1ObjectIdentifier23 = KISAObjectIdentifiers.id_seedCBC;
        hashMap.put("SEED", aSN1ObjectIdentifier23);
        hashMap.put("DES", aSN1ObjectIdentifier13);
        hashMap3.put(MiscObjectIdentifiers.cast5CBC.getId(), "CAST5");
        hashMap3.put(MiscObjectIdentifiers.as_sys_sec_alg_ideaCBC.getId(), "IDEA");
        hashMap3.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_ECB.getId(), "Blowfish");
        hashMap3.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_CBC.getId(), "Blowfish");
        hashMap3.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_CFB.getId(), "Blowfish");
        hashMap3.put(MiscObjectIdentifiers.cryptlib_algorithm_blowfish_OFB.getId(), "Blowfish");
        hashMap3.put(OIWObjectIdentifiers.desECB.getId(), "DES");
        hashMap3.put(aSN1ObjectIdentifier13.getId(), "DES");
        hashMap3.put(OIWObjectIdentifiers.desCFB.getId(), "DES");
        hashMap3.put(OIWObjectIdentifiers.desOFB.getId(), "DES");
        hashMap3.put(OIWObjectIdentifiers.desEDE.getId(), "DESede");
        hashMap3.put(aSN1ObjectIdentifier11.getId(), "DESede");
        hashMap3.put(aSN1ObjectIdentifier10.getId(), "DESede");
        hashMap3.put(PKCSObjectIdentifiers.id_alg_CMSRC2wrap.getId(), "RC2");
        hashMap3.put(aSN1ObjectIdentifier15.getId(), "HmacSHA1");
        hashMap3.put(PKCSObjectIdentifiers.id_hmacWithSHA224.getId(), "HmacSHA224");
        hashMap3.put(aSN1ObjectIdentifier18.getId(), "HmacSHA256");
        hashMap3.put(aSN1ObjectIdentifier19.getId(), "HmacSHA384");
        hashMap3.put(aSN1ObjectIdentifier21.getId(), "HmacSHA512");
        hashMap3.put(NTTObjectIdentifiers.id_camellia128_cbc.getId(), "Camellia");
        hashMap3.put(NTTObjectIdentifiers.id_camellia192_cbc.getId(), "Camellia");
        hashMap3.put(aSN1ObjectIdentifier22.getId(), "Camellia");
        hashMap3.put(aSN1ObjectIdentifier4.getId(), "Camellia");
        hashMap3.put(aSN1ObjectIdentifier20.getId(), "Camellia");
        hashMap3.put(aSN1ObjectIdentifier17.getId(), "Camellia");
        hashMap3.put(aSN1ObjectIdentifier12.getId(), "SEED");
        hashMap3.put(aSN1ObjectIdentifier23.getId(), "SEED");
        hashMap3.put(KISAObjectIdentifiers.id_seedMAC.getId(), "SEED");
        hashMap3.put(aSN1ObjectIdentifier16.getId(), "GOST28147");
        hashMap3.put(aSN1ObjectIdentifier9.getId(), b.f40261d);
        hashMap3.put(aSN1ObjectIdentifier7.getId(), b.f40261d);
        hashMap3.put(aSN1ObjectIdentifier7.getId(), b.f40261d);
        Hashtable hashtable5 = hashtable4;
        hashtable5.put("DESEDE", aSN1ObjectIdentifier11);
        hashtable5.put(b.f40261d, aSN1ObjectIdentifier);
        hashtable5.put("DES", aSN1ObjectIdentifier13);
        Hashtable hashtable6 = hashtable3;
        hashtable6.put("DES", "DES");
        hashtable6.put("DESEDE", "DES");
        hashtable6.put(aSN1ObjectIdentifier13.getId(), "DES");
        hashtable6.put(aSN1ObjectIdentifier11.getId(), "DES");
        hashtable6.put(aSN1ObjectIdentifier10.getId(), "DES");
    }

    public BaseAgreementSpi(String str, DerivationFunction derivationFunction) {
        this.kaAlgorithm = str;
        this.kdf = derivationFunction;
    }

    private byte[] calcSecret() {
        if (this.hybridSpec == null) {
            return doCalcSecret();
        }
        byte[] doCalcSecret = doCalcSecret();
        byte[] concatenate = Arrays.concatenate(doCalcSecret, this.hybridSpec.getT());
        Arrays.clear(doCalcSecret);
        return concatenate;
    }

    public static String getAlgorithm(String str) {
        if (str.indexOf(91) > 0) {
            return str.substring(0, str.indexOf(91));
        }
        if (str.startsWith(NISTObjectIdentifiers.aes.getId())) {
            return b.f40261d;
        }
        if (str.startsWith(GNUObjectIdentifiers.Serpent.getId())) {
            return "Serpent";
        }
        String str2 = nameTable.get(Strings.toUpperCase(str));
        return str2 != null ? str2 : str;
    }

    public static int getKeySize(String str) {
        if (str.indexOf(91) > 0) {
            return Integer.parseInt(str.substring(str.indexOf(91) + 1, str.indexOf(93)));
        }
        String upperCase = Strings.toUpperCase(str);
        Map<String, Integer> map = keySizes;
        if (!map.containsKey(upperCase)) {
            return -1;
        }
        return map.get(upperCase).intValue();
    }

    private byte[] getSharedSecretBytes(byte[] bArr, String str, int i11) throws NoSuchAlgorithmException {
        DerivationParameters derivationParameters;
        DerivationFunction derivationFunction = this.kdf;
        if (derivationFunction != null) {
            if (i11 >= 0) {
                int i12 = i11 / 8;
                byte[] bArr2 = new byte[i12];
                if (!(derivationFunction instanceof DHKEKGenerator)) {
                    derivationParameters = new KDFParameters(bArr, this.ukmParameters);
                } else if (str != null) {
                    try {
                        derivationParameters = new DHKDFParameters(new ASN1ObjectIdentifier(str), i11, bArr, this.ukmParameters);
                    } catch (IllegalArgumentException unused) {
                        throw new NoSuchAlgorithmException("no OID for algorithm: " + str);
                    }
                } else {
                    throw new NoSuchAlgorithmException("algorithm OID is null");
                }
                this.kdf.init(derivationParameters);
                this.kdf.generateBytes(bArr2, 0, i12);
                Arrays.clear(bArr);
                return bArr2;
            }
            throw new NoSuchAlgorithmException("unknown algorithm encountered: " + str);
        } else if (i11 <= 0) {
            return bArr;
        } else {
            int i13 = i11 / 8;
            byte[] bArr3 = new byte[i13];
            System.arraycopy(bArr, 0, bArr3, 0, i13);
            Arrays.clear(bArr);
            return bArr3;
        }
    }

    public static byte[] trimZeroes(byte[] bArr) {
        if (bArr[0] != 0) {
            return bArr;
        }
        int i11 = 0;
        while (i11 < bArr.length && bArr[i11] == 0) {
            i11++;
        }
        int length = bArr.length - i11;
        byte[] bArr2 = new byte[length];
        System.arraycopy(bArr, i11, bArr2, 0, length);
        return bArr2;
    }

    public abstract byte[] doCalcSecret();

    public abstract void doInitFromKey(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException;

    public int engineGenerateSecret(byte[] bArr, int i11) throws IllegalStateException, ShortBufferException {
        byte[] engineGenerateSecret = engineGenerateSecret();
        if (bArr.length - i11 >= engineGenerateSecret.length) {
            System.arraycopy(engineGenerateSecret, 0, bArr, i11, engineGenerateSecret.length);
            return engineGenerateSecret.length;
        }
        throw new ShortBufferException(this.kaAlgorithm + " key agreement: need " + engineGenerateSecret.length + " bytes");
    }

    public SecretKey engineGenerateSecret(String str) throws NoSuchAlgorithmException {
        String upperCase = Strings.toUpperCase(str);
        Hashtable hashtable = oids;
        String id2 = hashtable.containsKey(upperCase) ? ((ASN1ObjectIdentifier) hashtable.get(upperCase)).getId() : str;
        byte[] sharedSecretBytes = getSharedSecretBytes(calcSecret(), id2, getKeySize(id2));
        String algorithm = getAlgorithm(str);
        if (des.containsKey(algorithm)) {
            DESParameters.setOddParity(sharedSecretBytes);
        }
        return new SecretKeySpec(sharedSecretBytes, algorithm);
    }

    public byte[] engineGenerateSecret() throws IllegalStateException {
        if (this.kdf == null) {
            return calcSecret();
        }
        byte[] calcSecret = calcSecret();
        try {
            return getSharedSecretBytes(calcSecret, (String) null, calcSecret.length * 8);
        } catch (NoSuchAlgorithmException e11) {
            throw new IllegalStateException(e11.getMessage());
        }
    }

    public void engineInit(Key key, SecureRandom secureRandom) throws InvalidKeyException {
        try {
            doInitFromKey(key, (AlgorithmParameterSpec) null, secureRandom);
        } catch (InvalidAlgorithmParameterException e11) {
            throw new InvalidKeyException(e11.getMessage());
        }
    }

    public void engineInit(Key key, AlgorithmParameterSpec algorithmParameterSpec, SecureRandom secureRandom) throws InvalidKeyException, InvalidAlgorithmParameterException {
        if (algorithmParameterSpec instanceof HybridValueParameterSpec) {
            HybridValueParameterSpec hybridValueParameterSpec = (HybridValueParameterSpec) algorithmParameterSpec;
            this.hybridSpec = hybridValueParameterSpec;
            algorithmParameterSpec = hybridValueParameterSpec.getBaseParameterSpec();
        } else {
            this.hybridSpec = null;
        }
        doInitFromKey(key, algorithmParameterSpec, secureRandom);
    }
}
