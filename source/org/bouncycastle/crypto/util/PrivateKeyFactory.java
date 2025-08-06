package org.bouncycastle.crypto.util;

import java.io.IOException;
import java.io.InputStream;
import org.bouncycastle.asn1.ASN1InputStream;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.pkcs.PrivateKeyInfo;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;

public class PrivateKeyFactory {
    public static AsymmetricKeyParameter createKey(InputStream inputStream) throws IOException {
        return createKey(PrivateKeyInfo.getInstance(new ASN1InputStream(inputStream).readObject()));
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [org.bouncycastle.crypto.params.ECDomainParameters] */
    /* JADX WARNING: type inference failed for: r1v3 */
    /* JADX WARNING: type inference failed for: r3v4, types: [org.bouncycastle.crypto.params.ECGOST3410Parameters] */
    /* JADX WARNING: type inference failed for: r3v5, types: [org.bouncycastle.crypto.params.ECGOST3410Parameters] */
    /* JADX WARNING: type inference failed for: r1v7, types: [org.bouncycastle.crypto.params.ECGOST3410Parameters] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.bouncycastle.crypto.params.AsymmetricKeyParameter createKey(org.bouncycastle.asn1.pkcs.PrivateKeyInfo r10) throws java.io.IOException {
        /*
            org.bouncycastle.asn1.x509.AlgorithmIdentifier r0 = r10.getPrivateKeyAlgorithm()
            org.bouncycastle.asn1.ASN1ObjectIdentifier r1 = r0.getAlgorithm()
            org.bouncycastle.asn1.ASN1ObjectIdentifier r2 = org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.rsaEncryption
            boolean r2 = r1.equals((org.bouncycastle.asn1.ASN1Primitive) r2)
            if (r2 != 0) goto L_0x02a1
            org.bouncycastle.asn1.ASN1ObjectIdentifier r2 = org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.id_RSASSA_PSS
            boolean r2 = r1.equals((org.bouncycastle.asn1.ASN1Primitive) r2)
            if (r2 != 0) goto L_0x02a1
            org.bouncycastle.asn1.ASN1ObjectIdentifier r2 = org.bouncycastle.asn1.x509.X509ObjectIdentifiers.id_ea_rsa
            boolean r2 = r1.equals((org.bouncycastle.asn1.ASN1Primitive) r2)
            if (r2 == 0) goto L_0x0022
            goto L_0x02a1
        L_0x0022:
            org.bouncycastle.asn1.ASN1ObjectIdentifier r2 = org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers.dhKeyAgreement
            boolean r2 = r1.equals((org.bouncycastle.asn1.ASN1Primitive) r2)
            r3 = 0
            if (r2 == 0) goto L_0x005c
            org.bouncycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            org.bouncycastle.asn1.pkcs.DHParameter r0 = org.bouncycastle.asn1.pkcs.DHParameter.getInstance(r0)
            org.bouncycastle.asn1.ASN1Encodable r10 = r10.parsePrivateKey()
            org.bouncycastle.asn1.ASN1Integer r10 = (org.bouncycastle.asn1.ASN1Integer) r10
            java.math.BigInteger r1 = r0.getL()
            if (r1 != 0) goto L_0x0041
            r1 = 0
            goto L_0x0045
        L_0x0041:
            int r1 = r1.intValue()
        L_0x0045:
            org.bouncycastle.crypto.params.DHParameters r2 = new org.bouncycastle.crypto.params.DHParameters
            java.math.BigInteger r4 = r0.getP()
            java.math.BigInteger r0 = r0.getG()
            r2.<init>(r4, r0, r3, r1)
            org.bouncycastle.crypto.params.DHPrivateKeyParameters r0 = new org.bouncycastle.crypto.params.DHPrivateKeyParameters
            java.math.BigInteger r10 = r10.getValue()
            r0.<init>(r10, r2)
            return r0
        L_0x005c:
            org.bouncycastle.asn1.ASN1ObjectIdentifier r2 = org.bouncycastle.asn1.oiw.OIWObjectIdentifiers.elGamalAlgorithm
            boolean r2 = r1.equals((org.bouncycastle.asn1.ASN1Primitive) r2)
            if (r2 == 0) goto L_0x0089
            org.bouncycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            org.bouncycastle.asn1.oiw.ElGamalParameter r0 = org.bouncycastle.asn1.oiw.ElGamalParameter.getInstance(r0)
            org.bouncycastle.asn1.ASN1Encodable r10 = r10.parsePrivateKey()
            org.bouncycastle.asn1.ASN1Integer r10 = (org.bouncycastle.asn1.ASN1Integer) r10
            org.bouncycastle.crypto.params.ElGamalPrivateKeyParameters r1 = new org.bouncycastle.crypto.params.ElGamalPrivateKeyParameters
            java.math.BigInteger r10 = r10.getValue()
            org.bouncycastle.crypto.params.ElGamalParameters r2 = new org.bouncycastle.crypto.params.ElGamalParameters
            java.math.BigInteger r3 = r0.getP()
            java.math.BigInteger r0 = r0.getG()
            r2.<init>(r3, r0)
            r1.<init>(r10, r2)
            return r1
        L_0x0089:
            org.bouncycastle.asn1.ASN1ObjectIdentifier r2 = org.bouncycastle.asn1.x9.X9ObjectIdentifiers.id_dsa
            boolean r2 = r1.equals((org.bouncycastle.asn1.ASN1Primitive) r2)
            if (r2 == 0) goto L_0x00c0
            org.bouncycastle.asn1.ASN1Encodable r10 = r10.parsePrivateKey()
            org.bouncycastle.asn1.ASN1Integer r10 = (org.bouncycastle.asn1.ASN1Integer) r10
            org.bouncycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            if (r0 == 0) goto L_0x00b6
            org.bouncycastle.asn1.ASN1Primitive r0 = r0.toASN1Primitive()
            org.bouncycastle.asn1.x509.DSAParameter r0 = org.bouncycastle.asn1.x509.DSAParameter.getInstance(r0)
            org.bouncycastle.crypto.params.DSAParameters r3 = new org.bouncycastle.crypto.params.DSAParameters
            java.math.BigInteger r1 = r0.getP()
            java.math.BigInteger r2 = r0.getQ()
            java.math.BigInteger r0 = r0.getG()
            r3.<init>(r1, r2, r0)
        L_0x00b6:
            org.bouncycastle.crypto.params.DSAPrivateKeyParameters r0 = new org.bouncycastle.crypto.params.DSAPrivateKeyParameters
            java.math.BigInteger r10 = r10.getValue()
            r0.<init>(r10, r3)
            return r0
        L_0x00c0:
            org.bouncycastle.asn1.ASN1ObjectIdentifier r2 = org.bouncycastle.asn1.x9.X9ObjectIdentifiers.id_ecPublicKey
            boolean r2 = r1.equals((org.bouncycastle.asn1.ASN1Primitive) r2)
            if (r2 == 0) goto L_0x011d
            org.bouncycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            org.bouncycastle.asn1.x9.X962Parameters r0 = org.bouncycastle.asn1.x9.X962Parameters.getInstance(r0)
            boolean r1 = r0.isNamedCurve()
            org.bouncycastle.asn1.ASN1Primitive r0 = r0.getParameters()
            if (r1 == 0) goto L_0x00ec
            org.bouncycastle.asn1.ASN1ObjectIdentifier r0 = (org.bouncycastle.asn1.ASN1ObjectIdentifier) r0
            org.bouncycastle.asn1.x9.X9ECParameters r1 = org.bouncycastle.crypto.ec.CustomNamedCurves.getByOID(r0)
            if (r1 != 0) goto L_0x00e6
            org.bouncycastle.asn1.x9.X9ECParameters r1 = org.bouncycastle.asn1.x9.ECNamedCurveTable.getByOID(r0)
        L_0x00e6:
            org.bouncycastle.crypto.params.ECNamedDomainParameters r2 = new org.bouncycastle.crypto.params.ECNamedDomainParameters
            r2.<init>((org.bouncycastle.asn1.ASN1ObjectIdentifier) r0, (org.bouncycastle.asn1.x9.X9ECParameters) r1)
            goto L_0x010b
        L_0x00ec:
            org.bouncycastle.asn1.x9.X9ECParameters r0 = org.bouncycastle.asn1.x9.X9ECParameters.getInstance(r0)
            org.bouncycastle.crypto.params.ECDomainParameters r7 = new org.bouncycastle.crypto.params.ECDomainParameters
            org.bouncycastle.math.ec.ECCurve r2 = r0.getCurve()
            org.bouncycastle.math.ec.ECPoint r3 = r0.getG()
            java.math.BigInteger r4 = r0.getN()
            java.math.BigInteger r5 = r0.getH()
            byte[] r6 = r0.getSeed()
            r1 = r7
            r1.<init>(r2, r3, r4, r5, r6)
            r2 = r7
        L_0x010b:
            org.bouncycastle.asn1.ASN1Encodable r10 = r10.parsePrivateKey()
            org.bouncycastle.asn1.sec.ECPrivateKey r10 = org.bouncycastle.asn1.sec.ECPrivateKey.getInstance(r10)
            java.math.BigInteger r10 = r10.getKey()
            org.bouncycastle.crypto.params.ECPrivateKeyParameters r0 = new org.bouncycastle.crypto.params.ECPrivateKeyParameters
            r0.<init>(r10, r2)
            return r0
        L_0x011d:
            org.bouncycastle.asn1.ASN1ObjectIdentifier r2 = org.bouncycastle.asn1.edec.EdECObjectIdentifiers.id_X25519
            boolean r2 = r1.equals((org.bouncycastle.asn1.ASN1Primitive) r2)
            if (r2 == 0) goto L_0x012f
            org.bouncycastle.crypto.params.X25519PrivateKeyParameters r0 = new org.bouncycastle.crypto.params.X25519PrivateKeyParameters
            byte[] r10 = getRawKey(r10)
            r0.<init>((byte[]) r10)
            return r0
        L_0x012f:
            org.bouncycastle.asn1.ASN1ObjectIdentifier r2 = org.bouncycastle.asn1.edec.EdECObjectIdentifiers.id_X448
            boolean r2 = r1.equals((org.bouncycastle.asn1.ASN1Primitive) r2)
            if (r2 == 0) goto L_0x0141
            org.bouncycastle.crypto.params.X448PrivateKeyParameters r0 = new org.bouncycastle.crypto.params.X448PrivateKeyParameters
            byte[] r10 = getRawKey(r10)
            r0.<init>((byte[]) r10)
            return r0
        L_0x0141:
            org.bouncycastle.asn1.ASN1ObjectIdentifier r2 = org.bouncycastle.asn1.edec.EdECObjectIdentifiers.id_Ed25519
            boolean r2 = r1.equals((org.bouncycastle.asn1.ASN1Primitive) r2)
            if (r2 == 0) goto L_0x0153
            org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters r0 = new org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters
            byte[] r10 = getRawKey(r10)
            r0.<init>((byte[]) r10)
            return r0
        L_0x0153:
            org.bouncycastle.asn1.ASN1ObjectIdentifier r2 = org.bouncycastle.asn1.edec.EdECObjectIdentifiers.id_Ed448
            boolean r2 = r1.equals((org.bouncycastle.asn1.ASN1Primitive) r2)
            if (r2 == 0) goto L_0x0165
            org.bouncycastle.crypto.params.Ed448PrivateKeyParameters r0 = new org.bouncycastle.crypto.params.Ed448PrivateKeyParameters
            byte[] r10 = getRawKey(r10)
            r0.<init>((byte[]) r10)
            return r0
        L_0x0165:
            org.bouncycastle.asn1.ASN1ObjectIdentifier r2 = org.bouncycastle.asn1.cryptopro.CryptoProObjectIdentifiers.gostR3410_2001
            boolean r2 = r1.equals((org.bouncycastle.asn1.ASN1Primitive) r2)
            if (r2 != 0) goto L_0x0186
            org.bouncycastle.asn1.ASN1ObjectIdentifier r2 = org.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers.id_tc26_gost_3410_12_512
            boolean r2 = r1.equals((org.bouncycastle.asn1.ASN1Primitive) r2)
            if (r2 != 0) goto L_0x0186
            org.bouncycastle.asn1.ASN1ObjectIdentifier r2 = org.bouncycastle.asn1.rosstandart.RosstandartObjectIdentifiers.id_tc26_gost_3410_12_256
            boolean r2 = r1.equals((org.bouncycastle.asn1.ASN1Primitive) r2)
            if (r2 == 0) goto L_0x017e
            goto L_0x0186
        L_0x017e:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException
            java.lang.String r0 = "algorithm identifier in private key not recognised"
            r10.<init>(r0)
            throw r10
        L_0x0186:
            org.bouncycastle.asn1.ASN1Encodable r2 = r0.getParameters()
            org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters r4 = org.bouncycastle.asn1.cryptopro.GOST3410PublicKeyAlgParameters.getInstance(r2)
            org.bouncycastle.asn1.ASN1Primitive r2 = r2.toASN1Primitive()
            boolean r5 = r2 instanceof org.bouncycastle.asn1.ASN1Sequence
            if (r5 == 0) goto L_0x021a
            org.bouncycastle.asn1.ASN1Sequence r5 = org.bouncycastle.asn1.ASN1Sequence.getInstance(r2)
            int r5 = r5.size()
            r6 = 2
            if (r5 == r6) goto L_0x01ac
            org.bouncycastle.asn1.ASN1Sequence r2 = org.bouncycastle.asn1.ASN1Sequence.getInstance(r2)
            int r2 = r2.size()
            r5 = 3
            if (r2 != r5) goto L_0x021a
        L_0x01ac:
            org.bouncycastle.asn1.ASN1ObjectIdentifier r0 = r4.getPublicKeyParamSet()
            org.bouncycastle.asn1.x9.X9ECParameters r0 = org.bouncycastle.asn1.cryptopro.ECGOST3410NamedCurves.getByOIDX9(r0)
            org.bouncycastle.crypto.params.ECGOST3410Parameters r1 = new org.bouncycastle.crypto.params.ECGOST3410Parameters
            org.bouncycastle.crypto.params.ECNamedDomainParameters r2 = new org.bouncycastle.crypto.params.ECNamedDomainParameters
            org.bouncycastle.asn1.ASN1ObjectIdentifier r3 = r4.getPublicKeyParamSet()
            r2.<init>((org.bouncycastle.asn1.ASN1ObjectIdentifier) r3, (org.bouncycastle.asn1.x9.X9ECParameters) r0)
            org.bouncycastle.asn1.ASN1ObjectIdentifier r0 = r4.getPublicKeyParamSet()
            org.bouncycastle.asn1.ASN1ObjectIdentifier r3 = r4.getDigestParamSet()
            org.bouncycastle.asn1.ASN1ObjectIdentifier r5 = r4.getEncryptionParamSet()
            r1.<init>(r2, r0, r3, r5)
            org.bouncycastle.asn1.ASN1OctetString r0 = r10.getPrivateKey()
            byte[] r2 = r0.getOctets()
            int r2 = r2.length
            r3 = 32
            r5 = 1
            if (r2 == r3) goto L_0x020c
            byte[] r2 = r0.getOctets()
            int r2 = r2.length
            r3 = 64
            if (r2 != r3) goto L_0x01e6
            goto L_0x020c
        L_0x01e6:
            org.bouncycastle.asn1.ASN1Encodable r10 = r10.parsePrivateKey()
            boolean r0 = r10 instanceof org.bouncycastle.asn1.ASN1Integer
            if (r0 == 0) goto L_0x01f8
            org.bouncycastle.asn1.ASN1Integer r10 = org.bouncycastle.asn1.ASN1Integer.getInstance(r10)
            java.math.BigInteger r10 = r10.getPositiveValue()
            goto L_0x028a
        L_0x01f8:
            org.bouncycastle.asn1.ASN1OctetString r10 = org.bouncycastle.asn1.ASN1OctetString.getInstance(r10)
            byte[] r10 = r10.getOctets()
            byte[] r10 = org.bouncycastle.util.Arrays.reverse((byte[]) r10)
            java.math.BigInteger r0 = new java.math.BigInteger
            r0.<init>(r5, r10)
            r10 = r0
            goto L_0x028a
        L_0x020c:
            java.math.BigInteger r10 = new java.math.BigInteger
            byte[] r0 = r0.getOctets()
            byte[] r0 = org.bouncycastle.util.Arrays.reverse((byte[]) r0)
            r10.<init>(r5, r0)
            goto L_0x028a
        L_0x021a:
            org.bouncycastle.asn1.ASN1Encodable r0 = r0.getParameters()
            org.bouncycastle.asn1.x9.X962Parameters r0 = org.bouncycastle.asn1.x9.X962Parameters.getInstance(r0)
            boolean r2 = r0.isNamedCurve()
            if (r2 == 0) goto L_0x024b
            org.bouncycastle.asn1.ASN1Primitive r0 = r0.getParameters()
            org.bouncycastle.asn1.ASN1ObjectIdentifier r0 = org.bouncycastle.asn1.ASN1ObjectIdentifier.getInstance(r0)
            org.bouncycastle.asn1.x9.X9ECParameters r1 = org.bouncycastle.asn1.x9.ECNamedCurveTable.getByOID(r0)
            org.bouncycastle.crypto.params.ECGOST3410Parameters r3 = new org.bouncycastle.crypto.params.ECGOST3410Parameters
            org.bouncycastle.crypto.params.ECNamedDomainParameters r2 = new org.bouncycastle.crypto.params.ECNamedDomainParameters
            r2.<init>((org.bouncycastle.asn1.ASN1ObjectIdentifier) r0, (org.bouncycastle.asn1.x9.X9ECParameters) r1)
            org.bouncycastle.asn1.ASN1ObjectIdentifier r0 = r4.getPublicKeyParamSet()
            org.bouncycastle.asn1.ASN1ObjectIdentifier r1 = r4.getDigestParamSet()
            org.bouncycastle.asn1.ASN1ObjectIdentifier r5 = r4.getEncryptionParamSet()
            r3.<init>(r2, r0, r1, r5)
            goto L_0x0270
        L_0x024b:
            boolean r2 = r0.isImplicitlyCA()
            if (r2 == 0) goto L_0x0252
            goto L_0x0270
        L_0x0252:
            org.bouncycastle.asn1.ASN1Primitive r0 = r0.getParameters()
            org.bouncycastle.asn1.x9.X9ECParameters r0 = org.bouncycastle.asn1.x9.X9ECParameters.getInstance(r0)
            org.bouncycastle.crypto.params.ECGOST3410Parameters r3 = new org.bouncycastle.crypto.params.ECGOST3410Parameters
            org.bouncycastle.crypto.params.ECNamedDomainParameters r2 = new org.bouncycastle.crypto.params.ECNamedDomainParameters
            r2.<init>((org.bouncycastle.asn1.ASN1ObjectIdentifier) r1, (org.bouncycastle.asn1.x9.X9ECParameters) r0)
            org.bouncycastle.asn1.ASN1ObjectIdentifier r0 = r4.getPublicKeyParamSet()
            org.bouncycastle.asn1.ASN1ObjectIdentifier r1 = r4.getDigestParamSet()
            org.bouncycastle.asn1.ASN1ObjectIdentifier r5 = r4.getEncryptionParamSet()
            r3.<init>(r2, r0, r1, r5)
        L_0x0270:
            org.bouncycastle.asn1.ASN1Encodable r10 = r10.parsePrivateKey()
            boolean r0 = r10 instanceof org.bouncycastle.asn1.ASN1Integer
            if (r0 == 0) goto L_0x0281
            org.bouncycastle.asn1.ASN1Integer r10 = org.bouncycastle.asn1.ASN1Integer.getInstance(r10)
            java.math.BigInteger r10 = r10.getValue()
            goto L_0x0289
        L_0x0281:
            org.bouncycastle.asn1.sec.ECPrivateKey r10 = org.bouncycastle.asn1.sec.ECPrivateKey.getInstance(r10)
            java.math.BigInteger r10 = r10.getKey()
        L_0x0289:
            r1 = r3
        L_0x028a:
            org.bouncycastle.crypto.params.ECPrivateKeyParameters r0 = new org.bouncycastle.crypto.params.ECPrivateKeyParameters
            org.bouncycastle.crypto.params.ECGOST3410Parameters r2 = new org.bouncycastle.crypto.params.ECGOST3410Parameters
            org.bouncycastle.asn1.ASN1ObjectIdentifier r3 = r4.getPublicKeyParamSet()
            org.bouncycastle.asn1.ASN1ObjectIdentifier r5 = r4.getDigestParamSet()
            org.bouncycastle.asn1.ASN1ObjectIdentifier r4 = r4.getEncryptionParamSet()
            r2.<init>(r1, r3, r5, r4)
            r0.<init>(r10, r2)
            return r0
        L_0x02a1:
            org.bouncycastle.asn1.ASN1Encodable r10 = r10.parsePrivateKey()
            org.bouncycastle.asn1.pkcs.RSAPrivateKey r10 = org.bouncycastle.asn1.pkcs.RSAPrivateKey.getInstance(r10)
            org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters r9 = new org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters
            java.math.BigInteger r1 = r10.getModulus()
            java.math.BigInteger r2 = r10.getPublicExponent()
            java.math.BigInteger r3 = r10.getPrivateExponent()
            java.math.BigInteger r4 = r10.getPrime1()
            java.math.BigInteger r5 = r10.getPrime2()
            java.math.BigInteger r6 = r10.getExponent1()
            java.math.BigInteger r7 = r10.getExponent2()
            java.math.BigInteger r8 = r10.getCoefficient()
            r0 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.util.PrivateKeyFactory.createKey(org.bouncycastle.asn1.pkcs.PrivateKeyInfo):org.bouncycastle.crypto.params.AsymmetricKeyParameter");
    }

    public static AsymmetricKeyParameter createKey(byte[] bArr) throws IOException {
        return createKey(PrivateKeyInfo.getInstance(ASN1Primitive.fromByteArray(bArr)));
    }

    private static byte[] getRawKey(PrivateKeyInfo privateKeyInfo) throws IOException {
        return ASN1OctetString.getInstance(privateKeyInfo.parsePrivateKey()).getOctets();
    }
}
