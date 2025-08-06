package org.bouncycastle.crypto.util;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.crypto.CryptoServicesRegistrar;
import org.bouncycastle.crypto.params.AsymmetricKeyParameter;
import org.bouncycastle.crypto.params.DSAParameters;
import org.bouncycastle.crypto.params.DSAPrivateKeyParameters;
import org.bouncycastle.crypto.params.ECPrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters;
import org.bouncycastle.crypto.params.Ed25519PublicKeyParameters;
import org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;

public class OpenSSHPrivateKeyUtil {
    public static final byte[] AUTH_MAGIC = Strings.toByteArray("openssh-key-v1\u0000");

    private OpenSSHPrivateKeyUtil() {
    }

    private static boolean allIntegers(ASN1Sequence aSN1Sequence) {
        for (int i11 = 0; i11 < aSN1Sequence.size(); i11++) {
            if (!(aSN1Sequence.getObjectAt(i11) instanceof ASN1Integer)) {
                return false;
            }
        }
        return true;
    }

    public static byte[] encodePrivateKey(AsymmetricKeyParameter asymmetricKeyParameter) throws IOException {
        if (asymmetricKeyParameter == null) {
            throw new IllegalArgumentException("param is null");
        } else if (asymmetricKeyParameter instanceof RSAPrivateCrtKeyParameters) {
            return PrivateKeyInfoFactory.createPrivateKeyInfo(asymmetricKeyParameter).parsePrivateKey().toASN1Primitive().getEncoded();
        } else {
            if (asymmetricKeyParameter instanceof ECPrivateKeyParameters) {
                return PrivateKeyInfoFactory.createPrivateKeyInfo(asymmetricKeyParameter).parsePrivateKey().toASN1Primitive().getEncoded();
            }
            if (asymmetricKeyParameter instanceof DSAPrivateKeyParameters) {
                DSAPrivateKeyParameters dSAPrivateKeyParameters = (DSAPrivateKeyParameters) asymmetricKeyParameter;
                DSAParameters parameters = dSAPrivateKeyParameters.getParameters();
                ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
                aSN1EncodableVector.add(new ASN1Integer(0));
                aSN1EncodableVector.add(new ASN1Integer(parameters.getP()));
                aSN1EncodableVector.add(new ASN1Integer(parameters.getQ()));
                aSN1EncodableVector.add(new ASN1Integer(parameters.getG()));
                aSN1EncodableVector.add(new ASN1Integer(parameters.getG().modPow(dSAPrivateKeyParameters.getX(), parameters.getP())));
                aSN1EncodableVector.add(new ASN1Integer(dSAPrivateKeyParameters.getX()));
                try {
                    return new DERSequence(aSN1EncodableVector).getEncoded();
                } catch (Exception e11) {
                    throw new IllegalStateException("unable to encode DSAPrivateKeyParameters " + e11.getMessage());
                }
            } else if (asymmetricKeyParameter instanceof Ed25519PrivateKeyParameters) {
                Ed25519PrivateKeyParameters ed25519PrivateKeyParameters = (Ed25519PrivateKeyParameters) asymmetricKeyParameter;
                Ed25519PublicKeyParameters generatePublicKey = ed25519PrivateKeyParameters.generatePublicKey();
                SSHBuilder sSHBuilder = new SSHBuilder();
                sSHBuilder.writeBytes(AUTH_MAGIC);
                sSHBuilder.writeString("none");
                sSHBuilder.writeString("none");
                sSHBuilder.writeString("");
                sSHBuilder.u32(1);
                sSHBuilder.writeBlock(OpenSSHPublicKeyUtil.encodePublicKey(generatePublicKey));
                SSHBuilder sSHBuilder2 = new SSHBuilder();
                int nextInt = CryptoServicesRegistrar.getSecureRandom().nextInt();
                sSHBuilder2.u32(nextInt);
                sSHBuilder2.u32(nextInt);
                sSHBuilder2.writeString("ssh-ed25519");
                byte[] encoded = generatePublicKey.getEncoded();
                sSHBuilder2.writeBlock(encoded);
                sSHBuilder2.writeBlock(Arrays.concatenate(ed25519PrivateKeyParameters.getEncoded(), encoded));
                sSHBuilder2.writeString("");
                sSHBuilder.writeBlock(sSHBuilder2.getPaddedBytes());
                return sSHBuilder.getBytes();
            } else {
                throw new IllegalArgumentException("unable to convert " + asymmetricKeyParameter.getClass().getName() + " to openssh private key");
            }
        }
    }

    /* JADX WARNING: type inference failed for: r4v7, types: [org.bouncycastle.crypto.params.ECPrivateKeyParameters] */
    /* JADX WARNING: type inference failed for: r3v7, types: [org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters] */
    /* JADX WARNING: type inference failed for: r3v8, types: [org.bouncycastle.crypto.params.ECPrivateKeyParameters] */
    /* JADX WARNING: type inference failed for: r3v11, types: [org.bouncycastle.crypto.params.DSAPrivateKeyParameters] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.bouncycastle.crypto.params.AsymmetricKeyParameter parsePrivateKeyBlob(byte[] r13) {
        /*
            r0 = 0
            byte r1 = r13[r0]
            r2 = 1
            r3 = 0
            r4 = 48
            if (r1 != r4) goto L_0x00e7
            org.bouncycastle.asn1.ASN1Sequence r13 = org.bouncycastle.asn1.ASN1Sequence.getInstance(r13)
            int r1 = r13.size()
            r4 = 6
            r5 = 2
            r6 = 3
            if (r1 != r4) goto L_0x0063
            boolean r1 = allIntegers(r13)
            if (r1 == 0) goto L_0x020f
            org.bouncycastle.asn1.ASN1Encodable r0 = r13.getObjectAt(r0)
            org.bouncycastle.asn1.ASN1Integer r0 = (org.bouncycastle.asn1.ASN1Integer) r0
            java.math.BigInteger r0 = r0.getPositiveValue()
            java.math.BigInteger r1 = org.bouncycastle.util.BigIntegers.ZERO
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x020f
            org.bouncycastle.crypto.params.DSAPrivateKeyParameters r3 = new org.bouncycastle.crypto.params.DSAPrivateKeyParameters
            r0 = 5
            org.bouncycastle.asn1.ASN1Encodable r0 = r13.getObjectAt(r0)
            org.bouncycastle.asn1.ASN1Integer r0 = (org.bouncycastle.asn1.ASN1Integer) r0
            java.math.BigInteger r0 = r0.getPositiveValue()
            org.bouncycastle.crypto.params.DSAParameters r1 = new org.bouncycastle.crypto.params.DSAParameters
            org.bouncycastle.asn1.ASN1Encodable r2 = r13.getObjectAt(r2)
            org.bouncycastle.asn1.ASN1Integer r2 = (org.bouncycastle.asn1.ASN1Integer) r2
            java.math.BigInteger r2 = r2.getPositiveValue()
            org.bouncycastle.asn1.ASN1Encodable r4 = r13.getObjectAt(r5)
            org.bouncycastle.asn1.ASN1Integer r4 = (org.bouncycastle.asn1.ASN1Integer) r4
            java.math.BigInteger r4 = r4.getPositiveValue()
            org.bouncycastle.asn1.ASN1Encodable r13 = r13.getObjectAt(r6)
            org.bouncycastle.asn1.ASN1Integer r13 = (org.bouncycastle.asn1.ASN1Integer) r13
            java.math.BigInteger r13 = r13.getPositiveValue()
            r1.<init>(r2, r4, r13)
            r3.<init>(r0, r1)
            goto L_0x020f
        L_0x0063:
            int r1 = r13.size()
            r2 = 9
            if (r1 != r2) goto L_0x00b0
            boolean r1 = allIntegers(r13)
            if (r1 == 0) goto L_0x020f
            org.bouncycastle.asn1.ASN1Encodable r0 = r13.getObjectAt(r0)
            org.bouncycastle.asn1.ASN1Integer r0 = (org.bouncycastle.asn1.ASN1Integer) r0
            java.math.BigInteger r0 = r0.getPositiveValue()
            java.math.BigInteger r1 = org.bouncycastle.util.BigIntegers.ZERO
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x020f
            org.bouncycastle.asn1.pkcs.RSAPrivateKey r13 = org.bouncycastle.asn1.pkcs.RSAPrivateKey.getInstance(r13)
            org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters r9 = new org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters
            java.math.BigInteger r1 = r13.getModulus()
            java.math.BigInteger r2 = r13.getPublicExponent()
            java.math.BigInteger r3 = r13.getPrivateExponent()
            java.math.BigInteger r4 = r13.getPrime1()
            java.math.BigInteger r5 = r13.getPrime2()
            java.math.BigInteger r6 = r13.getExponent1()
            java.math.BigInteger r7 = r13.getExponent2()
            java.math.BigInteger r8 = r13.getCoefficient()
            r0 = r9
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8)
            r3 = r9
            goto L_0x020f
        L_0x00b0:
            int r0 = r13.size()
            r1 = 4
            if (r0 != r1) goto L_0x020f
            org.bouncycastle.asn1.ASN1Encodable r0 = r13.getObjectAt(r6)
            boolean r0 = r0 instanceof org.bouncycastle.asn1.ASN1TaggedObject
            if (r0 == 0) goto L_0x020f
            org.bouncycastle.asn1.ASN1Encodable r0 = r13.getObjectAt(r5)
            boolean r0 = r0 instanceof org.bouncycastle.asn1.ASN1TaggedObject
            if (r0 == 0) goto L_0x020f
            org.bouncycastle.asn1.sec.ECPrivateKey r13 = org.bouncycastle.asn1.sec.ECPrivateKey.getInstance(r13)
            org.bouncycastle.asn1.ASN1Object r0 = r13.getParametersObject()
            org.bouncycastle.asn1.ASN1ObjectIdentifier r0 = org.bouncycastle.asn1.ASN1ObjectIdentifier.getInstance(r0)
            org.bouncycastle.asn1.x9.X9ECParameters r1 = org.bouncycastle.asn1.x9.ECNamedCurveTable.getByOID(r0)
            org.bouncycastle.crypto.params.ECPrivateKeyParameters r3 = new org.bouncycastle.crypto.params.ECPrivateKeyParameters
            java.math.BigInteger r13 = r13.getKey()
            org.bouncycastle.crypto.params.ECNamedDomainParameters r2 = new org.bouncycastle.crypto.params.ECNamedDomainParameters
            r2.<init>((org.bouncycastle.asn1.ASN1ObjectIdentifier) r0, (org.bouncycastle.asn1.x9.X9ECParameters) r1)
            r3.<init>(r13, r2)
            goto L_0x020f
        L_0x00e7:
            org.bouncycastle.crypto.util.SSHBuffer r1 = new org.bouncycastle.crypto.util.SSHBuffer
            byte[] r4 = AUTH_MAGIC
            r1.<init>(r4, r13)
            java.lang.String r13 = r1.readString()
            java.lang.String r4 = "none"
            boolean r13 = r4.equals(r13)
            if (r13 == 0) goto L_0x023a
            r1.skipBlock()
            r1.skipBlock()
            int r13 = r1.readU32()
            if (r13 != r2) goto L_0x0232
            byte[] r13 = r1.readBlock()
            org.bouncycastle.crypto.util.OpenSSHPublicKeyUtil.parsePublicKey((byte[]) r13)
            byte[] r13 = r1.readPaddedBlock()
            boolean r1 = r1.hasRemaining()
            if (r1 != 0) goto L_0x022a
            org.bouncycastle.crypto.util.SSHBuffer r1 = new org.bouncycastle.crypto.util.SSHBuffer
            r1.<init>(r13)
            int r13 = r1.readU32()
            int r4 = r1.readU32()
            if (r13 != r4) goto L_0x0222
            java.lang.String r13 = r1.readString()
            java.lang.String r4 = "ssh-ed25519"
            boolean r4 = r4.equals(r13)
            if (r4 == 0) goto L_0x014d
            r1.readBlock()
            byte[] r13 = r1.readBlock()
            int r2 = r13.length
            r3 = 64
            if (r2 != r3) goto L_0x0145
            org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters r3 = new org.bouncycastle.crypto.params.Ed25519PrivateKeyParameters
            r3.<init>(r13, r0)
            goto L_0x0206
        L_0x0145:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "private key value of wrong length"
            r13.<init>(r0)
            throw r13
        L_0x014d:
            java.lang.String r0 = "ecdsa"
            boolean r0 = r13.startsWith(r0)
            if (r0 == 0) goto L_0x01b0
            byte[] r0 = r1.readBlock()
            java.lang.String r0 = org.bouncycastle.util.Strings.fromByteArray(r0)
            org.bouncycastle.asn1.ASN1ObjectIdentifier r0 = org.bouncycastle.crypto.util.SSHNamedCurves.getByName(r0)
            if (r0 == 0) goto L_0x0199
            org.bouncycastle.asn1.x9.X9ECParameters r13 = org.bouncycastle.asn1.nist.NISTNamedCurves.getByOID(r0)
            if (r13 == 0) goto L_0x0182
            r1.readBlock()
            byte[] r3 = r1.readBlock()
            org.bouncycastle.crypto.params.ECPrivateKeyParameters r4 = new org.bouncycastle.crypto.params.ECPrivateKeyParameters
            java.math.BigInteger r5 = new java.math.BigInteger
            r5.<init>(r2, r3)
            org.bouncycastle.crypto.params.ECNamedDomainParameters r2 = new org.bouncycastle.crypto.params.ECNamedDomainParameters
            r2.<init>((org.bouncycastle.asn1.ASN1ObjectIdentifier) r0, (org.bouncycastle.asn1.x9.X9ECParameters) r13)
            r4.<init>(r5, r2)
            r3 = r4
            goto L_0x0206
        L_0x0182:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Curve not found for: "
            r1.append(r2)
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            r13.<init>(r0)
            throw r13
        L_0x0199:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "OID not found for: "
            r1.append(r2)
            r1.append(r13)
            java.lang.String r13 = r1.toString()
            r0.<init>(r13)
            throw r0
        L_0x01b0:
            java.lang.String r0 = "ssh-rsa"
            boolean r13 = r13.startsWith(r0)
            if (r13 == 0) goto L_0x0206
            java.math.BigInteger r5 = new java.math.BigInteger
            byte[] r13 = r1.readBlock()
            r5.<init>(r2, r13)
            java.math.BigInteger r6 = new java.math.BigInteger
            byte[] r13 = r1.readBlock()
            r6.<init>(r2, r13)
            java.math.BigInteger r7 = new java.math.BigInteger
            byte[] r13 = r1.readBlock()
            r7.<init>(r2, r13)
            java.math.BigInteger r12 = new java.math.BigInteger
            byte[] r13 = r1.readBlock()
            r12.<init>(r2, r13)
            java.math.BigInteger r8 = new java.math.BigInteger
            byte[] r13 = r1.readBlock()
            r8.<init>(r2, r13)
            java.math.BigInteger r9 = new java.math.BigInteger
            byte[] r13 = r1.readBlock()
            r9.<init>(r2, r13)
            java.math.BigInteger r13 = org.bouncycastle.util.BigIntegers.ONE
            java.math.BigInteger r0 = r8.subtract(r13)
            java.math.BigInteger r13 = r9.subtract(r13)
            java.math.BigInteger r10 = r7.remainder(r0)
            java.math.BigInteger r11 = r7.remainder(r13)
            org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters r3 = new org.bouncycastle.crypto.params.RSAPrivateCrtKeyParameters
            r4 = r3
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)
        L_0x0206:
            r1.skipBlock()
            boolean r13 = r1.hasRemaining()
            if (r13 != 0) goto L_0x021a
        L_0x020f:
            if (r3 == 0) goto L_0x0212
            return r3
        L_0x0212:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "unable to parse key"
            r13.<init>(r0)
            throw r13
        L_0x021a:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "private key block has trailing data"
            r13.<init>(r0)
            throw r13
        L_0x0222:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "private key check values are not the same"
            r13.<init>(r0)
            throw r13
        L_0x022a:
            java.lang.IllegalArgumentException r13 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "decoded key has trailing data"
            r13.<init>(r0)
            throw r13
        L_0x0232:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "multiple keys not supported"
            r13.<init>(r0)
            throw r13
        L_0x023a:
            java.lang.IllegalStateException r13 = new java.lang.IllegalStateException
            java.lang.String r0 = "encrypted keys not supported"
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.crypto.util.OpenSSHPrivateKeyUtil.parsePrivateKeyBlob(byte[]):org.bouncycastle.crypto.params.AsymmetricKeyParameter");
    }
}
