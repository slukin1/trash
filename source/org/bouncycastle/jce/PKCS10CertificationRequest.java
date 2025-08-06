package org.bouncycastle.jce;

import com.huochat.community.util.FileTool;
import java.io.IOException;
import java.security.AlgorithmParameters;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.SignatureException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PSSParameterSpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Set;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Encoding;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERBitString;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.nist.NISTObjectIdentifiers;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.CertificationRequest;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSASSAPSSparams;
import org.bouncycastle.asn1.teletrust.TeleTrusTObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.X509Name;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.jmrtd.lds.SignedDataUtil;

public class PKCS10CertificationRequest extends CertificationRequest {
    private static Hashtable algorithms = new Hashtable();
    private static Hashtable keyAlgorithms = new Hashtable();
    private static Set noParams = new HashSet();
    private static Hashtable oids = new Hashtable();
    private static Hashtable params = new Hashtable();

    static {
        algorithms.put("MD2WITHRSAENCRYPTION", new ASN1ObjectIdentifier(SignedDataUtil.PKCS1_MD2_WITH_RSA_OID));
        algorithms.put("MD2WITHRSA", new ASN1ObjectIdentifier(SignedDataUtil.PKCS1_MD2_WITH_RSA_OID));
        algorithms.put("MD5WITHRSAENCRYPTION", new ASN1ObjectIdentifier(SignedDataUtil.PKCS1_MD5_WITH_RSA_OID));
        algorithms.put("MD5WITHRSA", new ASN1ObjectIdentifier(SignedDataUtil.PKCS1_MD5_WITH_RSA_OID));
        algorithms.put("RSAWITHMD5", new ASN1ObjectIdentifier(SignedDataUtil.PKCS1_MD5_WITH_RSA_OID));
        algorithms.put("SHA1WITHRSAENCRYPTION", new ASN1ObjectIdentifier(SignedDataUtil.PKCS1_SHA1_WITH_RSA_OID));
        algorithms.put("SHA1WITHRSA", new ASN1ObjectIdentifier(SignedDataUtil.PKCS1_SHA1_WITH_RSA_OID));
        Hashtable hashtable = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier = PKCSObjectIdentifiers.sha224WithRSAEncryption;
        hashtable.put("SHA224WITHRSAENCRYPTION", aSN1ObjectIdentifier);
        algorithms.put("SHA224WITHRSA", aSN1ObjectIdentifier);
        Hashtable hashtable2 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier2 = PKCSObjectIdentifiers.sha256WithRSAEncryption;
        hashtable2.put("SHA256WITHRSAENCRYPTION", aSN1ObjectIdentifier2);
        algorithms.put("SHA256WITHRSA", aSN1ObjectIdentifier2);
        Hashtable hashtable3 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier3 = PKCSObjectIdentifiers.sha384WithRSAEncryption;
        hashtable3.put("SHA384WITHRSAENCRYPTION", aSN1ObjectIdentifier3);
        algorithms.put("SHA384WITHRSA", aSN1ObjectIdentifier3);
        Hashtable hashtable4 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier4 = PKCSObjectIdentifiers.sha512WithRSAEncryption;
        hashtable4.put("SHA512WITHRSAENCRYPTION", aSN1ObjectIdentifier4);
        algorithms.put("SHA512WITHRSA", aSN1ObjectIdentifier4);
        Hashtable hashtable5 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier5 = PKCSObjectIdentifiers.id_RSASSA_PSS;
        hashtable5.put("SHA1WITHRSAANDMGF1", aSN1ObjectIdentifier5);
        algorithms.put("SHA224WITHRSAANDMGF1", aSN1ObjectIdentifier5);
        algorithms.put("SHA256WITHRSAANDMGF1", aSN1ObjectIdentifier5);
        algorithms.put("SHA384WITHRSAANDMGF1", aSN1ObjectIdentifier5);
        algorithms.put("SHA512WITHRSAANDMGF1", aSN1ObjectIdentifier5);
        algorithms.put("RSAWITHSHA1", new ASN1ObjectIdentifier(SignedDataUtil.PKCS1_SHA1_WITH_RSA_OID));
        Hashtable hashtable6 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier6 = TeleTrusTObjectIdentifiers.rsaSignatureWithripemd128;
        hashtable6.put("RIPEMD128WITHRSAENCRYPTION", aSN1ObjectIdentifier6);
        algorithms.put("RIPEMD128WITHRSA", aSN1ObjectIdentifier6);
        Hashtable hashtable7 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier7 = TeleTrusTObjectIdentifiers.rsaSignatureWithripemd160;
        hashtable7.put("RIPEMD160WITHRSAENCRYPTION", aSN1ObjectIdentifier7);
        algorithms.put("RIPEMD160WITHRSA", aSN1ObjectIdentifier7);
        Hashtable hashtable8 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier8 = TeleTrusTObjectIdentifiers.rsaSignatureWithripemd256;
        hashtable8.put("RIPEMD256WITHRSAENCRYPTION", aSN1ObjectIdentifier8);
        algorithms.put("RIPEMD256WITHRSA", aSN1ObjectIdentifier8);
        Hashtable hashtable9 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier9 = new ASN1ObjectIdentifier("1.2.840.10040.4.3");
        String str = SignedDataUtil.PKCS1_MD2_WITH_RSA_OID;
        hashtable9.put("SHA1WITHDSA", aSN1ObjectIdentifier9);
        algorithms.put("DSAWITHSHA1", new ASN1ObjectIdentifier("1.2.840.10040.4.3"));
        Hashtable hashtable10 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier10 = NISTObjectIdentifiers.dsa_with_sha224;
        hashtable10.put("SHA224WITHDSA", aSN1ObjectIdentifier10);
        Hashtable hashtable11 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier11 = aSN1ObjectIdentifier10;
        ASN1ObjectIdentifier aSN1ObjectIdentifier12 = NISTObjectIdentifiers.dsa_with_sha256;
        hashtable11.put("SHA256WITHDSA", aSN1ObjectIdentifier12);
        ASN1ObjectIdentifier aSN1ObjectIdentifier13 = aSN1ObjectIdentifier12;
        algorithms.put("SHA384WITHDSA", NISTObjectIdentifiers.dsa_with_sha384);
        algorithms.put("SHA512WITHDSA", NISTObjectIdentifiers.dsa_with_sha512);
        Hashtable hashtable12 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier14 = X9ObjectIdentifiers.ecdsa_with_SHA1;
        hashtable12.put("SHA1WITHECDSA", aSN1ObjectIdentifier14);
        Hashtable hashtable13 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier15 = X9ObjectIdentifiers.ecdsa_with_SHA224;
        hashtable13.put("SHA224WITHECDSA", aSN1ObjectIdentifier15);
        Hashtable hashtable14 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier16 = aSN1ObjectIdentifier15;
        ASN1ObjectIdentifier aSN1ObjectIdentifier17 = X9ObjectIdentifiers.ecdsa_with_SHA256;
        hashtable14.put("SHA256WITHECDSA", aSN1ObjectIdentifier17);
        Hashtable hashtable15 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier18 = aSN1ObjectIdentifier17;
        ASN1ObjectIdentifier aSN1ObjectIdentifier19 = X9ObjectIdentifiers.ecdsa_with_SHA384;
        hashtable15.put("SHA384WITHECDSA", aSN1ObjectIdentifier19);
        Hashtable hashtable16 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier20 = X9ObjectIdentifiers.ecdsa_with_SHA512;
        ASN1ObjectIdentifier aSN1ObjectIdentifier21 = aSN1ObjectIdentifier19;
        hashtable16.put("SHA512WITHECDSA", aSN1ObjectIdentifier20);
        algorithms.put("ECDSAWITHSHA1", aSN1ObjectIdentifier14);
        Hashtable hashtable17 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier22 = CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_94;
        ASN1ObjectIdentifier aSN1ObjectIdentifier23 = aSN1ObjectIdentifier20;
        hashtable17.put("GOST3411WITHGOST3410", aSN1ObjectIdentifier22);
        algorithms.put("GOST3410WITHGOST3411", aSN1ObjectIdentifier22);
        Hashtable hashtable18 = algorithms;
        ASN1ObjectIdentifier aSN1ObjectIdentifier24 = CryptoProObjectIdentifiers.gostR3411_94_with_gostR3410_2001;
        ASN1ObjectIdentifier aSN1ObjectIdentifier25 = aSN1ObjectIdentifier14;
        hashtable18.put("GOST3411WITHECGOST3410", aSN1ObjectIdentifier24);
        algorithms.put("GOST3411WITHECGOST3410-2001", aSN1ObjectIdentifier24);
        algorithms.put("GOST3411WITHGOST3410-2001", aSN1ObjectIdentifier24);
        oids.put(new ASN1ObjectIdentifier(SignedDataUtil.PKCS1_SHA1_WITH_RSA_OID), "SHA1WITHRSA");
        oids.put(aSN1ObjectIdentifier, "SHA224WITHRSA");
        oids.put(aSN1ObjectIdentifier2, "SHA256WITHRSA");
        oids.put(aSN1ObjectIdentifier3, "SHA384WITHRSA");
        oids.put(aSN1ObjectIdentifier4, "SHA512WITHRSA");
        oids.put(aSN1ObjectIdentifier22, "GOST3411WITHGOST3410");
        oids.put(aSN1ObjectIdentifier24, "GOST3411WITHECGOST3410");
        oids.put(new ASN1ObjectIdentifier(SignedDataUtil.PKCS1_MD5_WITH_RSA_OID), "MD5WITHRSA");
        oids.put(new ASN1ObjectIdentifier(str), "MD2WITHRSA");
        Object obj = "SHA1WITHDSA";
        oids.put(new ASN1ObjectIdentifier("1.2.840.10040.4.3"), obj);
        ASN1ObjectIdentifier aSN1ObjectIdentifier26 = aSN1ObjectIdentifier25;
        oids.put(aSN1ObjectIdentifier26, "SHA1WITHECDSA");
        ASN1ObjectIdentifier aSN1ObjectIdentifier27 = aSN1ObjectIdentifier16;
        oids.put(aSN1ObjectIdentifier27, "SHA224WITHECDSA");
        ASN1ObjectIdentifier aSN1ObjectIdentifier28 = aSN1ObjectIdentifier18;
        oids.put(aSN1ObjectIdentifier28, "SHA256WITHECDSA");
        ASN1ObjectIdentifier aSN1ObjectIdentifier29 = aSN1ObjectIdentifier21;
        oids.put(aSN1ObjectIdentifier29, "SHA384WITHECDSA");
        ASN1ObjectIdentifier aSN1ObjectIdentifier30 = aSN1ObjectIdentifier23;
        oids.put(aSN1ObjectIdentifier30, "SHA512WITHECDSA");
        oids.put(OIWObjectIdentifiers.sha1WithRSA, "SHA1WITHRSA");
        Hashtable hashtable19 = oids;
        ASN1ObjectIdentifier aSN1ObjectIdentifier31 = OIWObjectIdentifiers.dsaWithSHA1;
        hashtable19.put(aSN1ObjectIdentifier31, obj);
        ASN1ObjectIdentifier aSN1ObjectIdentifier32 = aSN1ObjectIdentifier11;
        oids.put(aSN1ObjectIdentifier32, "SHA224WITHDSA");
        ASN1ObjectIdentifier aSN1ObjectIdentifier33 = aSN1ObjectIdentifier13;
        oids.put(aSN1ObjectIdentifier33, "SHA256WITHDSA");
        keyAlgorithms.put(PKCSObjectIdentifiers.rsaEncryption, "RSA");
        keyAlgorithms.put(X9ObjectIdentifiers.id_dsa, "DSA");
        noParams.add(aSN1ObjectIdentifier26);
        noParams.add(aSN1ObjectIdentifier27);
        noParams.add(aSN1ObjectIdentifier28);
        noParams.add(aSN1ObjectIdentifier29);
        noParams.add(aSN1ObjectIdentifier30);
        noParams.add(X9ObjectIdentifiers.id_dsa_with_sha1);
        noParams.add(aSN1ObjectIdentifier31);
        noParams.add(aSN1ObjectIdentifier32);
        noParams.add(aSN1ObjectIdentifier33);
        noParams.add(aSN1ObjectIdentifier22);
        noParams.add(aSN1ObjectIdentifier24);
        ASN1ObjectIdentifier aSN1ObjectIdentifier34 = OIWObjectIdentifiers.idSHA1;
        DERNull dERNull = DERNull.INSTANCE;
        Object obj2 = "SHA1WITHRSAANDMGF1";
        params.put(obj2, creatPSSParams(new AlgorithmIdentifier(aSN1ObjectIdentifier34, dERNull), 20));
        Object obj3 = "SHA224WITHRSAANDMGF1";
        params.put(obj3, creatPSSParams(new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha224, dERNull), 28));
        Object obj4 = "SHA256WITHRSAANDMGF1";
        params.put(obj4, creatPSSParams(new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha256, dERNull), 32));
        Object obj5 = "SHA384WITHRSAANDMGF1";
        params.put(obj5, creatPSSParams(new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha384, dERNull), 48));
        AlgorithmIdentifier algorithmIdentifier = new AlgorithmIdentifier(NISTObjectIdentifiers.id_sha512, dERNull);
        params.put("SHA512WITHRSAANDMGF1", creatPSSParams(algorithmIdentifier, 64));
    }

    public PKCS10CertificationRequest(String str, X500Principal x500Principal, PublicKey publicKey, ASN1Set aSN1Set, PrivateKey privateKey) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
        this(str, convertName(x500Principal), publicKey, aSN1Set, privateKey, BouncyCastleProvider.PROVIDER_NAME);
    }

    public PKCS10CertificationRequest(String str, X500Principal x500Principal, PublicKey publicKey, ASN1Set aSN1Set, PrivateKey privateKey, String str2) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
        this(str, convertName(x500Principal), publicKey, aSN1Set, privateKey, str2);
    }

    public PKCS10CertificationRequest(String str, X509Name x509Name, PublicKey publicKey, ASN1Set aSN1Set, PrivateKey privateKey) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
        this(str, x509Name, publicKey, aSN1Set, privateKey, BouncyCastleProvider.PROVIDER_NAME);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x006a  */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public PKCS10CertificationRequest(java.lang.String r5, org.bouncycastle.asn1.x509.X509Name r6, java.security.PublicKey r7, org.bouncycastle.asn1.ASN1Set r8, java.security.PrivateKey r9, java.lang.String r10) throws java.security.NoSuchAlgorithmException, java.security.NoSuchProviderException, java.security.InvalidKeyException, java.security.SignatureException {
        /*
            r4 = this;
            r4.<init>()
            java.lang.String r0 = org.bouncycastle.util.Strings.toUpperCase(r5)
            java.util.Hashtable r1 = algorithms
            java.lang.Object r1 = r1.get(r0)
            org.bouncycastle.asn1.ASN1ObjectIdentifier r1 = (org.bouncycastle.asn1.ASN1ObjectIdentifier) r1
            if (r1 != 0) goto L_0x001f
            org.bouncycastle.asn1.ASN1ObjectIdentifier r1 = new org.bouncycastle.asn1.ASN1ObjectIdentifier     // Catch:{ Exception -> 0x0017 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0017 }
            goto L_0x001f
        L_0x0017:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "Unknown signature type requested"
            r5.<init>(r6)
            throw r5
        L_0x001f:
            if (r6 == 0) goto L_0x00b5
            if (r7 == 0) goto L_0x00ad
            java.util.Set r2 = noParams
            boolean r2 = r2.contains(r1)
            if (r2 == 0) goto L_0x0033
            org.bouncycastle.asn1.x509.AlgorithmIdentifier r0 = new org.bouncycastle.asn1.x509.AlgorithmIdentifier
            r0.<init>((org.bouncycastle.asn1.ASN1ObjectIdentifier) r1)
        L_0x0030:
            r4.sigAlgId = r0
            goto L_0x0053
        L_0x0033:
            java.util.Hashtable r2 = params
            boolean r2 = r2.containsKey(r0)
            if (r2 == 0) goto L_0x004b
            org.bouncycastle.asn1.x509.AlgorithmIdentifier r2 = new org.bouncycastle.asn1.x509.AlgorithmIdentifier
            java.util.Hashtable r3 = params
            java.lang.Object r0 = r3.get(r0)
            org.bouncycastle.asn1.ASN1Encodable r0 = (org.bouncycastle.asn1.ASN1Encodable) r0
            r2.<init>(r1, r0)
            r4.sigAlgId = r2
            goto L_0x0053
        L_0x004b:
            org.bouncycastle.asn1.x509.AlgorithmIdentifier r0 = new org.bouncycastle.asn1.x509.AlgorithmIdentifier
            org.bouncycastle.asn1.DERNull r2 = org.bouncycastle.asn1.DERNull.INSTANCE
            r0.<init>(r1, r2)
            goto L_0x0030
        L_0x0053:
            byte[] r7 = r7.getEncoded()     // Catch:{ IOException -> 0x00a5 }
            org.bouncycastle.asn1.ASN1Primitive r7 = org.bouncycastle.asn1.ASN1Primitive.fromByteArray(r7)     // Catch:{ IOException -> 0x00a5 }
            org.bouncycastle.asn1.ASN1Sequence r7 = (org.bouncycastle.asn1.ASN1Sequence) r7     // Catch:{ IOException -> 0x00a5 }
            org.bouncycastle.asn1.pkcs.CertificationRequestInfo r0 = new org.bouncycastle.asn1.pkcs.CertificationRequestInfo     // Catch:{ IOException -> 0x00a5 }
            org.bouncycastle.asn1.x509.SubjectPublicKeyInfo r7 = org.bouncycastle.asn1.x509.SubjectPublicKeyInfo.getInstance(r7)     // Catch:{ IOException -> 0x00a5 }
            r0.<init>((org.bouncycastle.asn1.x509.X509Name) r6, (org.bouncycastle.asn1.x509.SubjectPublicKeyInfo) r7, (org.bouncycastle.asn1.ASN1Set) r8)     // Catch:{ IOException -> 0x00a5 }
            r4.reqInfo = r0     // Catch:{ IOException -> 0x00a5 }
            if (r10 != 0) goto L_0x006f
            java.security.Signature r5 = java.security.Signature.getInstance(r5)
            goto L_0x0073
        L_0x006f:
            java.security.Signature r5 = java.security.Signature.getInstance(r5, r10)
        L_0x0073:
            r5.initSign(r9)
            org.bouncycastle.asn1.pkcs.CertificationRequestInfo r6 = r4.reqInfo     // Catch:{ Exception -> 0x008d }
            java.lang.String r7 = "DER"
            byte[] r6 = r6.getEncoded(r7)     // Catch:{ Exception -> 0x008d }
            r5.update(r6)     // Catch:{ Exception -> 0x008d }
            org.bouncycastle.asn1.DERBitString r6 = new org.bouncycastle.asn1.DERBitString
            byte[] r5 = r5.sign()
            r6.<init>((byte[]) r5)
            r4.sigBits = r6
            return
        L_0x008d:
            r5 = move-exception
            java.lang.IllegalArgumentException r6 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "exception encoding TBS cert request - "
            r7.append(r8)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            r6.<init>(r5)
            throw r6
        L_0x00a5:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "can't encode public key"
            r5.<init>(r6)
            throw r5
        L_0x00ad:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "public key must not be null"
            r5.<init>(r6)
            throw r5
        L_0x00b5:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "subject must not be null"
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jce.PKCS10CertificationRequest.<init>(java.lang.String, org.bouncycastle.asn1.x509.X509Name, java.security.PublicKey, org.bouncycastle.asn1.ASN1Set, java.security.PrivateKey, java.lang.String):void");
    }

    public PKCS10CertificationRequest(ASN1Sequence aSN1Sequence) {
        super(aSN1Sequence);
    }

    public PKCS10CertificationRequest(byte[] bArr) {
        super(toDERSequence(bArr));
    }

    private static X509Name convertName(X500Principal x500Principal) {
        try {
            return new X509Principal(x500Principal.getEncoded());
        } catch (IOException unused) {
            throw new IllegalArgumentException("can't convert name");
        }
    }

    private static RSASSAPSSparams creatPSSParams(AlgorithmIdentifier algorithmIdentifier, int i11) {
        return new RSASSAPSSparams(algorithmIdentifier, new AlgorithmIdentifier(PKCSObjectIdentifiers.id_mgf1, algorithmIdentifier), new ASN1Integer((long) i11), new ASN1Integer(1));
    }

    private static String getDigestAlgName(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        return PKCSObjectIdentifiers.md5.equals((ASN1Primitive) aSN1ObjectIdentifier) ? FileTool.HASH_TYPE_MD5 : OIWObjectIdentifiers.idSHA1.equals((ASN1Primitive) aSN1ObjectIdentifier) ? FileTool.HASH_TYPE_SHA1 : NISTObjectIdentifiers.id_sha224.equals((ASN1Primitive) aSN1ObjectIdentifier) ? "SHA224" : NISTObjectIdentifiers.id_sha256.equals((ASN1Primitive) aSN1ObjectIdentifier) ? "SHA256" : NISTObjectIdentifiers.id_sha384.equals((ASN1Primitive) aSN1ObjectIdentifier) ? "SHA384" : NISTObjectIdentifiers.id_sha512.equals((ASN1Primitive) aSN1ObjectIdentifier) ? "SHA512" : TeleTrusTObjectIdentifiers.ripemd128.equals((ASN1Primitive) aSN1ObjectIdentifier) ? "RIPEMD128" : TeleTrusTObjectIdentifiers.ripemd160.equals((ASN1Primitive) aSN1ObjectIdentifier) ? "RIPEMD160" : TeleTrusTObjectIdentifiers.ripemd256.equals((ASN1Primitive) aSN1ObjectIdentifier) ? "RIPEMD256" : CryptoProObjectIdentifiers.gostR3411.equals((ASN1Primitive) aSN1ObjectIdentifier) ? "GOST3411" : aSN1ObjectIdentifier.getId();
    }

    public static String getSignatureName(AlgorithmIdentifier algorithmIdentifier) {
        ASN1Encodable parameters = algorithmIdentifier.getParameters();
        if (parameters == null || DERNull.INSTANCE.equals(parameters) || !algorithmIdentifier.getAlgorithm().equals((ASN1Primitive) PKCSObjectIdentifiers.id_RSASSA_PSS)) {
            return algorithmIdentifier.getAlgorithm().getId();
        }
        RSASSAPSSparams instance = RSASSAPSSparams.getInstance(parameters);
        return getDigestAlgName(instance.getHashAlgorithm().getAlgorithm()) + "withRSAandMGF1";
    }

    private void setSignatureParameters(Signature signature, ASN1Encodable aSN1Encodable) throws NoSuchAlgorithmException, SignatureException, InvalidKeyException {
        if (aSN1Encodable != null && !DERNull.INSTANCE.equals(aSN1Encodable)) {
            AlgorithmParameters instance = AlgorithmParameters.getInstance(signature.getAlgorithm(), signature.getProvider());
            try {
                instance.init(aSN1Encodable.toASN1Primitive().getEncoded(ASN1Encoding.DER));
                if (signature.getAlgorithm().endsWith("MGF1")) {
                    try {
                        signature.setParameter(instance.getParameterSpec(PSSParameterSpec.class));
                    } catch (GeneralSecurityException e11) {
                        throw new SignatureException("Exception extracting parameters: " + e11.getMessage());
                    }
                }
            } catch (IOException e12) {
                throw new SignatureException("IOException decoding parameters: " + e12.getMessage());
            }
        }
    }

    private static ASN1Sequence toDERSequence(byte[] bArr) {
        try {
            return (ASN1Sequence) new ASN1InputStream(bArr).readObject();
        } catch (Exception unused) {
            throw new IllegalArgumentException("badly encoded request");
        }
    }

    public byte[] getEncoded() {
        try {
            return getEncoded(ASN1Encoding.DER);
        } catch (IOException e11) {
            throw new RuntimeException(e11.toString());
        }
    }

    public PublicKey getPublicKey() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        return getPublicKey(BouncyCastleProvider.PROVIDER_NAME);
    }

    public PublicKey getPublicKey(String str) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException {
        X509EncodedKeySpec x509EncodedKeySpec;
        AlgorithmIdentifier algorithm;
        SubjectPublicKeyInfo subjectPublicKeyInfo = this.reqInfo.getSubjectPublicKeyInfo();
        try {
            x509EncodedKeySpec = new X509EncodedKeySpec(new DERBitString((ASN1Encodable) subjectPublicKeyInfo).getOctets());
            algorithm = subjectPublicKeyInfo.getAlgorithm();
            return str == null ? KeyFactory.getInstance(algorithm.getAlgorithm().getId()).generatePublic(x509EncodedKeySpec) : KeyFactory.getInstance(algorithm.getAlgorithm().getId(), str).generatePublic(x509EncodedKeySpec);
        } catch (NoSuchAlgorithmException e11) {
            if (keyAlgorithms.get(algorithm.getAlgorithm()) != null) {
                String str2 = (String) keyAlgorithms.get(algorithm.getAlgorithm());
                return str == null ? KeyFactory.getInstance(str2).generatePublic(x509EncodedKeySpec) : KeyFactory.getInstance(str2, str).generatePublic(x509EncodedKeySpec);
            }
            throw e11;
        } catch (InvalidKeySpecException unused) {
            throw new InvalidKeyException("error decoding public key");
        } catch (IOException unused2) {
            throw new InvalidKeyException("error decoding public key");
        }
    }

    public boolean verify() throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
        return verify(BouncyCastleProvider.PROVIDER_NAME);
    }

    public boolean verify(String str) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
        return verify(getPublicKey(str), str);
    }

    public boolean verify(PublicKey publicKey, String str) throws NoSuchAlgorithmException, NoSuchProviderException, InvalidKeyException, SignatureException {
        Signature signature;
        if (str == null) {
            try {
                signature = Signature.getInstance(getSignatureName(this.sigAlgId));
            } catch (NoSuchAlgorithmException e11) {
                if (oids.get(this.sigAlgId.getAlgorithm()) != null) {
                    String str2 = (String) oids.get(this.sigAlgId.getAlgorithm());
                    signature = str == null ? Signature.getInstance(str2) : Signature.getInstance(str2, str);
                } else {
                    throw e11;
                }
            }
        } else {
            signature = Signature.getInstance(getSignatureName(this.sigAlgId), str);
        }
        setSignatureParameters(signature, this.sigAlgId.getParameters());
        signature.initVerify(publicKey);
        try {
            signature.update(this.reqInfo.getEncoded(ASN1Encoding.DER));
            return signature.verify(this.sigBits.getOctets());
        } catch (Exception e12) {
            throw new SignatureException("exception encoding TBS cert request - " + e12);
        }
    }
}
