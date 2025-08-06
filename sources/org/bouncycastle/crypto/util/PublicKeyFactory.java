package org.bouncycastle.crypto.util;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers;
import org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves;
import org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters;
import org.bouncycastle.asn1.edec.EdECObjectIdentifiers;
import org.bouncycastle.asn1.oiw.ElGamalParameter;
import org.bouncycastle.asn1.oiw.OIWObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.DHParameter;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.pkcs.RSAPublicKey;
import org.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers;
import org.bouncycastle.asn1.ua.DSTU4145BinaryField;
import org.bouncycastle.asn1.ua.DSTU4145ECBinary;
import org.bouncycastle.asn1.ua.DSTU4145NamedCurves;
import org.bouncycastle.asn1.ua.DSTU4145Params;
import org.bouncycastle.asn1.ua.DSTU4145PointEncoder;
import org.bouncycastle.asn1.ua.UAObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.DSAParameter;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x509.X509ObjectIdentifiers;
import org.bouncycastle.asn1.x9.DHPublicKey;
import org.bouncycastle.asn1.x9.DomainParameters;
import org.bouncycastle.asn1.x9.ValidationParams;
import org.bouncycastle.asn1.x9.X9ObjectIdentifiers;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DHParameters;
import org.bouncycastle.crypto.params.DHPublicKeyParameters;
import org.bouncycastle.crypto.params.DHValidationParameters;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPublicKeyParameters;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECGOST3410Parameters;
import org.bouncycastle.crypto.params.ECNamedDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.bouncycastle.crypto.params.Ed448PublicKeyParameters;
import org.bouncycastle.crypto.params.ElGamalParameters;
import org.bouncycastle.crypto.params.ElGamalPublicKeyParameters;
import org.bouncycastle.crypto.params.RSAKeyParameters;
import org.bouncycastle.crypto.params.X25519PublicKeyParameters;
import org.bouncycastle.crypto.params.X448PublicKeyParameters;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.util.Arrays;

public class PublicKeyFactory {
    private static Map converters;

    public static class DHAgreementConverter extends SubjectPublicKeyInfoConverter {
        private DHAgreementConverter() {
            super();
        }

        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) throws IOException {
            DHParameter instance = DHParameter.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
            ASN1Integer aSN1Integer = (ASN1Integer) subjectPublicKeyInfo.parsePublicKey();
            BigInteger l11 = instance.getL();
            return new DHPublicKeyParameters(aSN1Integer.getValue(), new DHParameters(instance.getP(), instance.getG(), (BigInteger) null, l11 == null ? 0 : l11.intValue()));
        }
    }

    public static class DHPublicNumberConverter extends SubjectPublicKeyInfoConverter {
        private DHPublicNumberConverter() {
            super();
        }

        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) throws IOException {
            BigInteger y11 = DHPublicKey.getInstance(subjectPublicKeyInfo.parsePublicKey()).getY();
            DomainParameters instance = DomainParameters.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
            BigInteger p11 = instance.getP();
            BigInteger g11 = instance.getG();
            BigInteger q11 = instance.getQ();
            DHValidationParameters dHValidationParameters = null;
            BigInteger j11 = instance.getJ() != null ? instance.getJ() : null;
            ValidationParams validationParams = instance.getValidationParams();
            if (validationParams != null) {
                dHValidationParameters = new DHValidationParameters(validationParams.getSeed(), validationParams.getPgenCounter().intValue());
            }
            return new DHPublicKeyParameters(y11, new DHParameters(p11, g11, q11, j11, dHValidationParameters));
        }
    }

    public static class DSAConverter extends SubjectPublicKeyInfoConverter {
        private DSAConverter() {
            super();
        }

        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) throws IOException {
            DSAParameters dSAParameters;
            ASN1Integer aSN1Integer = (ASN1Integer) subjectPublicKeyInfo.parsePublicKey();
            ASN1Encodable parameters = subjectPublicKeyInfo.getAlgorithm().getParameters();
            if (parameters != null) {
                DSAParameter instance = DSAParameter.getInstance(parameters.toASN1Primitive());
                dSAParameters = new DSAParameters(instance.getP(), instance.getQ(), instance.getG());
            } else {
                dSAParameters = null;
            }
            return new DSAPublicKeyParameters(aSN1Integer.getValue(), dSAParameters);
        }
    }

    public static class DSTUConverter extends SubjectPublicKeyInfoConverter {
        private DSTUConverter() {
            super();
        }

        private void reverseBytes(byte[] bArr) {
            for (int i11 = 0; i11 < bArr.length / 2; i11++) {
                byte b11 = bArr[i11];
                bArr[i11] = bArr[(bArr.length - 1) - i11];
                bArr[(bArr.length - 1) - i11] = b11;
            }
        }

        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) throws IOException {
            ECDomainParameters eCDomainParameters;
            AlgorithmIdentifier algorithm = subjectPublicKeyInfo.getAlgorithm();
            ASN1ObjectIdentifier algorithm2 = algorithm.getAlgorithm();
            DSTU4145Params instance = DSTU4145Params.getInstance(algorithm.getParameters());
            try {
                byte[] clone = Arrays.clone(((ASN1OctetString) subjectPublicKeyInfo.parsePublicKey()).getOctets());
                ASN1ObjectIdentifier aSN1ObjectIdentifier = UAObjectIdentifiers.dstu4145le;
                if (algorithm2.equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                    reverseBytes(clone);
                }
                if (instance.isNamedCurve()) {
                    eCDomainParameters = DSTU4145NamedCurves.getByOID(instance.getNamedCurve());
                } else {
                    DSTU4145ECBinary eCBinary = instance.getECBinary();
                    byte[] b11 = eCBinary.getB();
                    if (algorithm2.equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                        reverseBytes(b11);
                    }
                    BigInteger bigInteger = new BigInteger(1, b11);
                    DSTU4145BinaryField field = eCBinary.getField();
                    ECCurve.F2m f2m = new ECCurve.F2m(field.getM(), field.getK1(), field.getK2(), field.getK3(), eCBinary.getA(), bigInteger);
                    byte[] g11 = eCBinary.getG();
                    if (algorithm2.equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                        reverseBytes(g11);
                    }
                    eCDomainParameters = new ECDomainParameters(f2m, DSTU4145PointEncoder.decodePoint(f2m, g11), eCBinary.getN());
                }
                return new ECPublicKeyParameters(DSTU4145PointEncoder.decodePoint(eCDomainParameters.getCurve(), clone), eCDomainParameters);
            } catch (IOException unused) {
                throw new IllegalArgumentException("error recovering DSTU public key");
            }
        }
    }

    public static class ECConverter extends SubjectPublicKeyInfoConverter {
        private ECConverter() {
            super();
        }

        /* JADX WARNING: type inference failed for: r5v6, types: [org.bouncycastle.asn1.ASN1Primitive] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public org.bouncycastle.crypto.params.AsymmetricKeyParameter getPublicKeyParameters(org.bouncycastle.asn1.x509.SubjectPublicKeyInfo r5, java.lang.Object r6) {
            /*
                r4 = this;
                org.bouncycastle.asn1.x509.AlgorithmIdentifier r0 = r5.getAlgorithm()
                org.bouncycastle.asn1.ASN1Encodable r0 = r0.getParameters()
                org.bouncycastle.asn1.x9.X962Parameters r0 = org.bouncycastle.asn1.x9.X962Parameters.getInstance(r0)
                boolean r1 = r0.isNamedCurve()
                if (r1 == 0) goto L_0x0028
                org.bouncycastle.asn1.ASN1Primitive r6 = r0.getParameters()
                org.bouncycastle.asn1.ASN1ObjectIdentifier r6 = (org.bouncycastle.asn1.ASN1ObjectIdentifier) r6
                org.bouncycastle.asn1.x9.X9ECParameters r0 = org.bouncycastle.crypto.ec.CustomNamedCurves.getByOID(r6)
                if (r0 != 0) goto L_0x0022
                org.bouncycastle.asn1.x9.X9ECParameters r0 = org.bouncycastle.asn1.x9.ECNamedCurveTable.getByOID(r6)
            L_0x0022:
                org.bouncycastle.crypto.params.ECNamedDomainParameters r1 = new org.bouncycastle.crypto.params.ECNamedDomainParameters
                r1.<init>((org.bouncycastle.asn1.ASN1ObjectIdentifier) r6, (org.bouncycastle.asn1.x9.X9ECParameters) r0)
                goto L_0x003f
            L_0x0028:
                boolean r1 = r0.isImplicitlyCA()
                if (r1 == 0) goto L_0x0032
                r1 = r6
                org.bouncycastle.crypto.params.ECDomainParameters r1 = (org.bouncycastle.crypto.params.ECDomainParameters) r1
                goto L_0x003f
            L_0x0032:
                org.bouncycastle.asn1.ASN1Primitive r6 = r0.getParameters()
                org.bouncycastle.asn1.x9.X9ECParameters r6 = org.bouncycastle.asn1.x9.X9ECParameters.getInstance(r6)
                org.bouncycastle.crypto.params.ECDomainParameters r1 = new org.bouncycastle.crypto.params.ECDomainParameters
                r1.<init>(r6)
            L_0x003f:
                org.bouncycastle.asn1.ASN1BitString r5 = r5.getPublicKeyData()
                byte[] r5 = r5.getBytes()
                org.bouncycastle.asn1.DEROctetString r6 = new org.bouncycastle.asn1.DEROctetString
                r6.<init>((byte[]) r5)
                r0 = 0
                byte r0 = r5[r0]
                r2 = 4
                if (r0 != r2) goto L_0x0084
                r0 = 1
                byte r0 = r5[r0]
                int r2 = r5.length
                r3 = 2
                int r2 = r2 - r3
                if (r0 != r2) goto L_0x0084
                byte r0 = r5[r3]
                r2 = 3
                if (r0 == r3) goto L_0x0063
                byte r0 = r5[r3]
                if (r0 != r2) goto L_0x0084
            L_0x0063:
                org.bouncycastle.asn1.x9.X9IntegerConverter r0 = new org.bouncycastle.asn1.x9.X9IntegerConverter
                r0.<init>()
                org.bouncycastle.math.ec.ECCurve r3 = r1.getCurve()
                int r0 = r0.getByteLength((org.bouncycastle.math.ec.ECCurve) r3)
                int r3 = r5.length
                int r3 = r3 - r2
                if (r0 < r3) goto L_0x0084
                org.bouncycastle.asn1.ASN1Primitive r5 = org.bouncycastle.asn1.ASN1Primitive.fromByteArray(r5)     // Catch:{ IOException -> 0x007c }
                r6 = r5
                org.bouncycastle.asn1.ASN1OctetString r6 = (org.bouncycastle.asn1.ASN1OctetString) r6     // Catch:{ IOException -> 0x007c }
                goto L_0x0084
            L_0x007c:
                java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
                java.lang.String r6 = "error recovering public key"
                r5.<init>(r6)
                throw r5
            L_0x0084:
                org.bouncycastle.asn1.x9.X9ECPoint r5 = new org.bouncycastle.asn1.x9.X9ECPoint
                org.bouncycastle.math.ec.ECCurve r0 = r1.getCurve()
                r5.<init>((org.bouncycastle.math.ec.ECCurve) r0, (org.bouncycastle.asn1.ASN1OctetString) r6)
                org.bouncycastle.crypto.params.ECPublicKeyParameters r6 = new org.bouncycastle.crypto.params.ECPublicKeyParameters
                org.bouncycastle.math.ec.ECPoint r5 = r5.getPoint()
                r6.<init>(r5, r1)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.util.PublicKeyFactory.ECConverter.getPublicKeyParameters(org.bouncycastle.asn1.x509.SubjectPublicKeyInfo, java.lang.Object):org.bouncycastle.crypto.params.AsymmetricKeyParameter");
        }
    }

    public static class Ed25519Converter extends SubjectPublicKeyInfoConverter {
        private Ed25519Converter() {
            super();
        }

        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            return new Ed25519PublicKeyParameters(PublicKeyFactory.getRawKey(subjectPublicKeyInfo, obj));
        }
    }

    public static class Ed448Converter extends SubjectPublicKeyInfoConverter {
        private Ed448Converter() {
            super();
        }

        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            return new Ed448PublicKeyParameters(PublicKeyFactory.getRawKey(subjectPublicKeyInfo, obj));
        }
    }

    public static class ElGamalConverter extends SubjectPublicKeyInfoConverter {
        private ElGamalConverter() {
            super();
        }

        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) throws IOException {
            ElGamalParameter instance = ElGamalParameter.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
            return new ElGamalPublicKeyParameters(((ASN1Integer) subjectPublicKeyInfo.parsePublicKey()).getValue(), new ElGamalParameters(instance.getP(), instance.getG()));
        }
    }

    public static class GOST3410_2001Converter extends SubjectPublicKeyInfoConverter {
        private GOST3410_2001Converter() {
            super();
        }

        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            GOST3410PublicKeyAlgParameters instance = GOST3410PublicKeyAlgParameters.getInstance(subjectPublicKeyInfo.getAlgorithm().getParameters());
            ASN1ObjectIdentifier publicKeyParamSet = instance.getPublicKeyParamSet();
            ECGOST3410Parameters eCGOST3410Parameters = new ECGOST3410Parameters(new ECNamedDomainParameters(publicKeyParamSet, ECGOST3410NamedCurves.getByOIDX9(publicKeyParamSet)), publicKeyParamSet, instance.getDigestParamSet(), instance.getEncryptionParamSet());
            try {
                byte[] octets = ((ASN1OctetString) subjectPublicKeyInfo.parsePublicKey()).getOctets();
                if (octets.length == 64) {
                    byte[] bArr = new byte[65];
                    bArr[0] = 4;
                    for (int i11 = 1; i11 <= 32; i11++) {
                        bArr[i11] = octets[32 - i11];
                        bArr[i11 + 32] = octets[64 - i11];
                    }
                    return new ECPublicKeyParameters(eCGOST3410Parameters.getCurve().decodePoint(bArr), eCGOST3410Parameters);
                }
                throw new IllegalArgumentException("invalid length for GOST3410_2001 public key");
            } catch (IOException unused) {
                throw new IllegalArgumentException("error recovering GOST3410_2001 public key");
            }
        }
    }

    public static class GOST3410_2012Converter extends SubjectPublicKeyInfoConverter {
        private GOST3410_2012Converter() {
            super();
        }

        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            AlgorithmIdentifier algorithm = subjectPublicKeyInfo.getAlgorithm();
            ASN1ObjectIdentifier algorithm2 = algorithm.getAlgorithm();
            GOST3410PublicKeyAlgParameters instance = GOST3410PublicKeyAlgParameters.getInstance(algorithm.getParameters());
            ASN1ObjectIdentifier publicKeyParamSet = instance.getPublicKeyParamSet();
            ECGOST3410Parameters eCGOST3410Parameters = new ECGOST3410Parameters(new ECNamedDomainParameters(publicKeyParamSet, ECGOST3410NamedCurves.getByOIDX9(publicKeyParamSet)), publicKeyParamSet, instance.getDigestParamSet(), instance.getEncryptionParamSet());
            try {
                ASN1OctetString aSN1OctetString = (ASN1OctetString) subjectPublicKeyInfo.parsePublicKey();
                int i11 = 32;
                if (algorithm2.equals((ASN1Primitive) RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512)) {
                    i11 = 64;
                }
                int i12 = i11 * 2;
                byte[] octets = aSN1OctetString.getOctets();
                if (octets.length == i12) {
                    byte[] bArr = new byte[(i12 + 1)];
                    bArr[0] = 4;
                    for (int i13 = 1; i13 <= i11; i13++) {
                        bArr[i13] = octets[i11 - i13];
                        bArr[i13 + i11] = octets[i12 - i13];
                    }
                    return new ECPublicKeyParameters(eCGOST3410Parameters.getCurve().decodePoint(bArr), eCGOST3410Parameters);
                }
                throw new IllegalArgumentException("invalid length for GOST3410_2012 public key");
            } catch (IOException unused) {
                throw new IllegalArgumentException("error recovering GOST3410_2012 public key");
            }
        }
    }

    public static class RSAConverter extends SubjectPublicKeyInfoConverter {
        private RSAConverter() {
            super();
        }

        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) throws IOException {
            RSAPublicKey instance = RSAPublicKey.getInstance(subjectPublicKeyInfo.parsePublicKey());
            return new RSAKeyParameters(false, instance.getModulus(), instance.getPublicExponent());
        }
    }

    public static abstract class SubjectPublicKeyInfoConverter {
        private SubjectPublicKeyInfoConverter() {
        }

        public abstract AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) throws IOException;
    }

    public static class X25519Converter extends SubjectPublicKeyInfoConverter {
        private X25519Converter() {
            super();
        }

        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            return new X25519PublicKeyParameters(PublicKeyFactory.getRawKey(subjectPublicKeyInfo, obj));
        }
    }

    public static class X448Converter extends SubjectPublicKeyInfoConverter {
        private X448Converter() {
            super();
        }

        public AsymmetricKeyParameter getPublicKeyParameters(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
            return new X448PublicKeyParameters(PublicKeyFactory.getRawKey(subjectPublicKeyInfo, obj));
        }
    }

    static {
        HashMap hashMap = new HashMap();
        converters = hashMap;
        hashMap.put(PKCSObjectIdentifiers.rsaEncryption, new RSAConverter());
        converters.put(PKCSObjectIdentifiers.id_RSASSA_PSS, new RSAConverter());
        converters.put(X509ObjectIdentifiers.id_ea_rsa, new RSAConverter());
        converters.put(X9ObjectIdentifiers.dhpublicnumber, new DHPublicNumberConverter());
        converters.put(PKCSObjectIdentifiers.dhKeyAgreement, new DHAgreementConverter());
        converters.put(X9ObjectIdentifiers.id_dsa, new DSAConverter());
        converters.put(OIWObjectIdentifiers.dsaWithSHA1, new DSAConverter());
        converters.put(OIWObjectIdentifiers.elGamalAlgorithm, new ElGamalConverter());
        converters.put(X9ObjectIdentifiers.id_ecPublicKey, new ECConverter());
        converters.put(CryptoProObjectIdentifiers.gostR3410_2001, new GOST3410_2001Converter());
        converters.put(RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256, new GOST3410_2012Converter());
        converters.put(RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512, new GOST3410_2012Converter());
        converters.put(UAObjectIdentifiers.dstu4145be, new DSTUConverter());
        converters.put(UAObjectIdentifiers.dstu4145le, new DSTUConverter());
        converters.put(EdECObjectIdentifiers.id_X25519, new X25519Converter());
        converters.put(EdECObjectIdentifiers.id_X448, new X448Converter());
        converters.put(EdECObjectIdentifiers.id_Ed25519, new Ed25519Converter());
        converters.put(EdECObjectIdentifiers.id_Ed448, new Ed448Converter());
    }

    public static AsymmetricKeyParameter createKey(InputStream inputStream) throws IOException {
        return createKey(SubjectPublicKeyInfo.getInstance(new ASN1InputStream(inputStream).readObject()));
    }

    public static AsymmetricKeyParameter createKey(SubjectPublicKeyInfo subjectPublicKeyInfo) throws IOException {
        return createKey(subjectPublicKeyInfo, (Object) null);
    }

    public static AsymmetricKeyParameter createKey(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) throws IOException {
        AlgorithmIdentifier algorithm = subjectPublicKeyInfo.getAlgorithm();
        SubjectPublicKeyInfoConverter subjectPublicKeyInfoConverter = (SubjectPublicKeyInfoConverter) converters.get(algorithm.getAlgorithm());
        if (subjectPublicKeyInfoConverter != null) {
            return subjectPublicKeyInfoConverter.getPublicKeyParameters(subjectPublicKeyInfo, obj);
        }
        throw new IOException("algorithm identifier in public key not recognised: " + algorithm.getAlgorithm());
    }

    public static AsymmetricKeyParameter createKey(byte[] bArr) throws IOException {
        return createKey(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray(bArr)));
    }

    /* access modifiers changed from: private */
    public static byte[] getRawKey(SubjectPublicKeyInfo subjectPublicKeyInfo, Object obj) {
        return subjectPublicKeyInfo.getPublicKeyData().getOctets();
    }
}
