package org.bouncycastle.jcajce.provider.util;

import com.huochat.community.util.FileTool;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;
import org.bouncycastle.util.Strings;

public class DigestFactory {
    private static Set md5 = new HashSet();
    private static Map oids = new HashMap();
    private static Set sha1 = new HashSet();
    private static Set sha224 = new HashSet();
    private static Set sha256 = new HashSet();
    private static Set sha384 = new HashSet();
    private static Set sha3_224 = new HashSet();
    private static Set sha3_256 = new HashSet();
    private static Set sha3_384 = new HashSet();
    private static Set sha3_512 = new HashSet();
    private static Set sha512 = new HashSet();
    private static Set sha512_224 = new HashSet();
    private static Set sha512_256 = new HashSet();
    private static Set shake128 = new HashSet();
    private static Set shake256 = new HashSet();

    static {
        md5.add(FileTool.HASH_TYPE_MD5);
        Set set = md5;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.md5;
        set.add(aSN1ObjectIdentifier.getId());
        sha1.add(FileTool.HASH_TYPE_SHA1);
        sha1.add(McElieceCCA2KeyGenParameterSpec.SHA1);
        Set set2 = sha1;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = OIWObjectIdentifiers.idSHA1;
        set2.add(aSN1ObjectIdentifier2.getId());
        sha224.add("SHA224");
        sha224.add(McElieceCCA2KeyGenParameterSpec.SHA224);
        Set set3 = sha224;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = NISTObjectIdentifiers.id_sha224;
        set3.add(aSN1ObjectIdentifier3.getId());
        sha256.add("SHA256");
        sha256.add("SHA-256");
        Set set4 = sha256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = NISTObjectIdentifiers.id_sha256;
        set4.add(aSN1ObjectIdentifier4.getId());
        sha384.add("SHA384");
        sha384.add("SHA-384");
        Set set5 = sha384;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = NISTObjectIdentifiers.id_sha384;
        set5.add(aSN1ObjectIdentifier5.getId());
        sha512.add("SHA512");
        sha512.add("SHA-512");
        Set set6 = sha512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = NISTObjectIdentifiers.id_sha512;
        set6.add(aSN1ObjectIdentifier6.getId());
        sha512_224.add("SHA512(224)");
        sha512_224.add("SHA-512(224)");
        Set set7 = sha512_224;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = NISTObjectIdentifiers.id_sha512_224;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = aSN1ObjectIdentifier6;
        set7.add(aSN1ObjectIdentifier7.getId());
        sha512_256.add("SHA512(256)");
        sha512_256.add("SHA-512(256)");
        Set set8 = sha512_256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = NISTObjectIdentifiers.id_sha512_256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = aSN1ObjectIdentifier7;
        set8.add(aSN1ObjectIdentifier9.getId());
        sha3_224.add("SHA3-224");
        Set set9 = sha3_224;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = NISTObjectIdentifiers.id_sha3_224;
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = aSN1ObjectIdentifier9;
        set9.add(aSN1ObjectIdentifier11.getId());
        sha3_256.add("SHA3-256");
        Set set10 = sha3_256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = NISTObjectIdentifiers.id_sha3_256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = aSN1ObjectIdentifier11;
        set10.add(aSN1ObjectIdentifier13.getId());
        sha3_384.add("SHA3-384");
        Set set11 = sha3_384;
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = NISTObjectIdentifiers.id_sha3_384;
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = aSN1ObjectIdentifier13;
        set11.add(aSN1ObjectIdentifier15.getId());
        sha3_512.add("SHA3-512");
        Set set12 = sha3_512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = NISTObjectIdentifiers.id_sha3_512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier18 = aSN1ObjectIdentifier15;
        set12.add(aSN1ObjectIdentifier17.getId());
        shake128.add("SHAKE128");
        Set set13 = shake128;
        ASN1ObjectIdentifier aSN1ObjectIdentifier19 = NISTObjectIdentifiers.id_shake128;
        ASN1ObjectIdentifier aSN1ObjectIdentifier20 = aSN1ObjectIdentifier17;
        set13.add(aSN1ObjectIdentifier19.getId());
        shake256.add("SHAKE256");
        Set set14 = shake256;
        ASN1ObjectIdentifier aSN1ObjectIdentifier21 = NISTObjectIdentifiers.id_shake256;
        set14.add(aSN1ObjectIdentifier21.getId());
        oids.put(FileTool.HASH_TYPE_MD5, aSN1ObjectIdentifier);
        oids.put(aSN1ObjectIdentifier.getId(), aSN1ObjectIdentifier);
        oids.put(FileTool.HASH_TYPE_SHA1, aSN1ObjectIdentifier2);
        oids.put(McElieceCCA2KeyGenParameterSpec.SHA1, aSN1ObjectIdentifier2);
        oids.put(aSN1ObjectIdentifier2.getId(), aSN1ObjectIdentifier2);
        oids.put("SHA224", aSN1ObjectIdentifier3);
        oids.put(McElieceCCA2KeyGenParameterSpec.SHA224, aSN1ObjectIdentifier3);
        oids.put(aSN1ObjectIdentifier3.getId(), aSN1ObjectIdentifier3);
        oids.put("SHA256", aSN1ObjectIdentifier4);
        oids.put("SHA-256", aSN1ObjectIdentifier4);
        oids.put(aSN1ObjectIdentifier4.getId(), aSN1ObjectIdentifier4);
        oids.put("SHA384", aSN1ObjectIdentifier5);
        oids.put("SHA-384", aSN1ObjectIdentifier5);
        oids.put(aSN1ObjectIdentifier5.getId(), aSN1ObjectIdentifier5);
        ASN1ObjectIdentifier aSN1ObjectIdentifier22 = aSN1ObjectIdentifier8;
        oids.put("SHA512", aSN1ObjectIdentifier22);
        oids.put("SHA-512", aSN1ObjectIdentifier22);
        oids.put(aSN1ObjectIdentifier22.getId(), aSN1ObjectIdentifier22);
        ASN1ObjectIdentifier aSN1ObjectIdentifier23 = aSN1ObjectIdentifier10;
        oids.put("SHA512(224)", aSN1ObjectIdentifier23);
        oids.put("SHA-512(224)", aSN1ObjectIdentifier23);
        oids.put(aSN1ObjectIdentifier23.getId(), aSN1ObjectIdentifier23);
        ASN1ObjectIdentifier aSN1ObjectIdentifier24 = aSN1ObjectIdentifier12;
        oids.put("SHA512(256)", aSN1ObjectIdentifier24);
        oids.put("SHA-512(256)", aSN1ObjectIdentifier24);
        oids.put(aSN1ObjectIdentifier24.getId(), aSN1ObjectIdentifier24);
        ASN1ObjectIdentifier aSN1ObjectIdentifier25 = aSN1ObjectIdentifier14;
        oids.put("SHA3-224", aSN1ObjectIdentifier25);
        oids.put(aSN1ObjectIdentifier25.getId(), aSN1ObjectIdentifier25);
        ASN1ObjectIdentifier aSN1ObjectIdentifier26 = aSN1ObjectIdentifier16;
        oids.put("SHA3-256", aSN1ObjectIdentifier26);
        oids.put(aSN1ObjectIdentifier26.getId(), aSN1ObjectIdentifier26);
        ASN1ObjectIdentifier aSN1ObjectIdentifier27 = aSN1ObjectIdentifier18;
        oids.put("SHA3-384", aSN1ObjectIdentifier27);
        oids.put(aSN1ObjectIdentifier27.getId(), aSN1ObjectIdentifier27);
        ASN1ObjectIdentifier aSN1ObjectIdentifier28 = aSN1ObjectIdentifier20;
        oids.put("SHA3-512", aSN1ObjectIdentifier28);
        oids.put(aSN1ObjectIdentifier28.getId(), aSN1ObjectIdentifier28);
        ASN1ObjectIdentifier aSN1ObjectIdentifier29 = aSN1ObjectIdentifier19;
        oids.put("SHAKE128", aSN1ObjectIdentifier29);
        oids.put(aSN1ObjectIdentifier29.getId(), aSN1ObjectIdentifier29);
        oids.put("SHAKE256", aSN1ObjectIdentifier21);
        oids.put(aSN1ObjectIdentifier21.getId(), aSN1ObjectIdentifier21);
    }

    public static Digest getDigest(String str) {
        String upperCase = Strings.toUpperCase(str);
        if (sha1.contains(upperCase)) {
            return org.bouncycastle.crypto.util.DigestFactory.createSHA1();
        }
        if (md5.contains(upperCase)) {
            return org.bouncycastle.crypto.util.DigestFactory.createMD5();
        }
        if (sha224.contains(upperCase)) {
            return org.bouncycastle.crypto.util.DigestFactory.createSHA224();
        }
        if (sha256.contains(upperCase)) {
            return org.bouncycastle.crypto.util.DigestFactory.createSHA256();
        }
        if (sha384.contains(upperCase)) {
            return org.bouncycastle.crypto.util.DigestFactory.createSHA384();
        }
        if (sha512.contains(upperCase)) {
            return org.bouncycastle.crypto.util.DigestFactory.createSHA512();
        }
        if (sha512_224.contains(upperCase)) {
            return org.bouncycastle.crypto.util.DigestFactory.createSHA512_224();
        }
        if (sha512_256.contains(upperCase)) {
            return org.bouncycastle.crypto.util.DigestFactory.createSHA512_256();
        }
        if (sha3_224.contains(upperCase)) {
            return org.bouncycastle.crypto.util.DigestFactory.createSHA3_224();
        }
        if (sha3_256.contains(upperCase)) {
            return org.bouncycastle.crypto.util.DigestFactory.createSHA3_256();
        }
        if (sha3_384.contains(upperCase)) {
            return org.bouncycastle.crypto.util.DigestFactory.createSHA3_384();
        }
        if (sha3_512.contains(upperCase)) {
            return org.bouncycastle.crypto.util.DigestFactory.createSHA3_512();
        }
        if (shake128.contains(upperCase)) {
            return org.bouncycastle.crypto.util.DigestFactory.createSHAKE128();
        }
        if (shake256.contains(upperCase)) {
            return org.bouncycastle.crypto.util.DigestFactory.createSHAKE256();
        }
        return null;
    }

    public static ASN1ObjectIdentifier getOID(String str) {
        return (ASN1ObjectIdentifier) oids.get(str);
    }

    public static boolean isSameDigest(String str, String str2) {
        return (sha1.contains(str) && sha1.contains(str2)) || (sha224.contains(str) && sha224.contains(str2)) || ((sha256.contains(str) && sha256.contains(str2)) || ((sha384.contains(str) && sha384.contains(str2)) || ((sha512.contains(str) && sha512.contains(str2)) || ((sha512_224.contains(str) && sha512_224.contains(str2)) || ((sha512_256.contains(str) && sha512_256.contains(str2)) || ((sha3_224.contains(str) && sha3_224.contains(str2)) || ((sha3_256.contains(str) && sha3_256.contains(str2)) || ((sha3_384.contains(str) && sha3_384.contains(str2)) || ((sha3_512.contains(str) && sha3_512.contains(str2)) || (md5.contains(str) && md5.contains(str2)))))))))));
    }
}
