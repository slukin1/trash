package org.bouncycastle.jcajce.provider.asymmetric.dstu;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECParameterSpec;
import java.security.spec.ECPublicKeySpec;
import java.security.spec.EllipticCurve;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.ua.DSTU4145Params;
import org.bouncycastle.asn1.ua.DSTU4145PointEncoder;
import org.bouncycastle.asn1.ua.UAObjectIdentifiers;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.SubjectPublicKeyInfo;
import org.bouncycastle.asn1.x9.X962Parameters;
import org.bouncycastle.asn1.x9.X9ECParameters;
import org.bouncycastle.asn1.x9.X9ECPoint;
import org.bouncycastle.crypto.params.ECDomainParameters;
import org.bouncycastle.crypto.params.ECPublicKeyParameters;
import org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util;
import org.bouncycastle.jcajce.provider.asymmetric.util.ECUtil;
import org.bouncycastle.jcajce.provider.asymmetric.util.KeyUtil;
import org.bouncycastle.jcajce.provider.config.ProviderConfiguration;
import org.bouncycastle.jce.interfaces.ECPointEncoder;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.jce.spec.ECNamedCurveSpec;
import org.bouncycastle.math.ec.ECCurve;
import org.bouncycastle.math.ec.ECPoint;

public class BCDSTU4145PublicKey implements ECPublicKey, org.bouncycastle.jce.interfaces.ECPublicKey, ECPointEncoder {
    public static final long serialVersionUID = 7026240464295649314L;
    private String algorithm = "DSTU4145";
    private transient DSTU4145Params dstuParams;
    private transient ECPublicKeyParameters ecPublicKey;
    private transient ECParameterSpec ecSpec;
    private boolean withCompression;

    public BCDSTU4145PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters) {
        this.algorithm = str;
        this.ecPublicKey = eCPublicKeyParameters;
        this.ecSpec = null;
    }

    public BCDSTU4145PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, ECParameterSpec eCParameterSpec) {
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.ecPublicKey = eCPublicKeyParameters;
        if (eCParameterSpec == null) {
            this.ecSpec = createSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), parameters);
        } else {
            this.ecSpec = eCParameterSpec;
        }
    }

    public BCDSTU4145PublicKey(String str, ECPublicKeyParameters eCPublicKeyParameters, org.bouncycastle.jce.spec.ECParameterSpec eCParameterSpec) {
        ECDomainParameters parameters = eCPublicKeyParameters.getParameters();
        this.algorithm = str;
        this.ecSpec = eCParameterSpec == null ? createSpec(EC5Util.convertCurve(parameters.getCurve(), parameters.getSeed()), parameters) : EC5Util.convertSpec(EC5Util.convertCurve(eCParameterSpec.getCurve(), eCParameterSpec.getSeed()), eCParameterSpec);
        this.ecPublicKey = eCPublicKeyParameters;
    }

    public BCDSTU4145PublicKey(ECPublicKeySpec eCPublicKeySpec) {
        ECParameterSpec params = eCPublicKeySpec.getParams();
        this.ecSpec = params;
        this.ecPublicKey = new ECPublicKeyParameters(EC5Util.convertPoint(params, eCPublicKeySpec.getW()), EC5Util.getDomainParameters((ProviderConfiguration) null, this.ecSpec));
    }

    public BCDSTU4145PublicKey(SubjectPublicKeyInfo subjectPublicKeyInfo) {
        populateFromPubKeyInfo(subjectPublicKeyInfo);
    }

    public BCDSTU4145PublicKey(BCDSTU4145PublicKey bCDSTU4145PublicKey) {
        this.ecPublicKey = bCDSTU4145PublicKey.ecPublicKey;
        this.ecSpec = bCDSTU4145PublicKey.ecSpec;
        this.withCompression = bCDSTU4145PublicKey.withCompression;
        this.dstuParams = bCDSTU4145PublicKey.dstuParams;
    }

    public BCDSTU4145PublicKey(org.bouncycastle.jce.spec.ECPublicKeySpec eCPublicKeySpec, ProviderConfiguration providerConfiguration) {
        if (eCPublicKeySpec.getParams() != null) {
            EllipticCurve convertCurve = EC5Util.convertCurve(eCPublicKeySpec.getParams().getCurve(), eCPublicKeySpec.getParams().getSeed());
            this.ecPublicKey = new ECPublicKeyParameters(eCPublicKeySpec.getQ(), ECUtil.getDomainParameters(providerConfiguration, eCPublicKeySpec.getParams()));
            this.ecSpec = EC5Util.convertSpec(convertCurve, eCPublicKeySpec.getParams());
            return;
        }
        this.ecPublicKey = new ECPublicKeyParameters(providerConfiguration.getEcImplicitlyCa().getCurve().createPoint(eCPublicKeySpec.getQ().getAffineXCoord().toBigInteger(), eCPublicKeySpec.getQ().getAffineYCoord().toBigInteger()), EC5Util.getDomainParameters(providerConfiguration, (ECParameterSpec) null));
        this.ecSpec = null;
    }

    private ECParameterSpec createSpec(EllipticCurve ellipticCurve, ECDomainParameters eCDomainParameters) {
        return new ECParameterSpec(ellipticCurve, EC5Util.convertPoint(eCDomainParameters.getG()), eCDomainParameters.getN(), eCDomainParameters.getH().intValue());
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v3, resolved type: org.bouncycastle.jce.spec.ECNamedCurveSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v5, resolved type: java.security.spec.ECParameterSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v9, resolved type: java.security.spec.ECParameterSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v21, resolved type: org.bouncycastle.jce.spec.ECNamedCurveSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v22, resolved type: org.bouncycastle.jce.spec.ECNamedCurveSpec} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v8, resolved type: org.bouncycastle.jce.spec.ECNamedCurveSpec} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void populateFromPubKeyInfo(org.bouncycastle.asn1.x509.SubjectPublicKeyInfo r15) {
        /*
            r14 = this;
            org.bouncycastle.asn1.ASN1BitString r0 = r15.getPublicKeyData()
            java.lang.String r1 = "DSTU4145"
            r14.algorithm = r1
            byte[] r0 = r0.getBytes()     // Catch:{ IOException -> 0x015c }
            org.bouncycastle.asn1.ASN1Primitive r0 = org.bouncycastle.asn1.ASN1Primitive.fromByteArray(r0)     // Catch:{ IOException -> 0x015c }
            org.bouncycastle.asn1.ASN1OctetString r0 = (org.bouncycastle.asn1.ASN1OctetString) r0     // Catch:{ IOException -> 0x015c }
            byte[] r0 = r0.getOctets()
            org.bouncycastle.asn1.x509.AlgorithmIdentifier r1 = r15.getAlgorithm()
            org.bouncycastle.asn1.ASN1ObjectIdentifier r1 = r1.getAlgorithm()
            org.bouncycastle.asn1.ASN1ObjectIdentifier r2 = org.bouncycastle.asn1.ua.UAObjectIdentifiers.dstu4145le
            boolean r1 = r1.equals((org.bouncycastle.asn1.ASN1Primitive) r2)
            if (r1 == 0) goto L_0x0029
            r14.reverseBytes(r0)
        L_0x0029:
            org.bouncycastle.asn1.x509.AlgorithmIdentifier r1 = r15.getAlgorithm()
            org.bouncycastle.asn1.ASN1Encodable r1 = r1.getParameters()
            org.bouncycastle.asn1.ASN1Sequence r1 = org.bouncycastle.asn1.ASN1Sequence.getInstance(r1)
            r3 = 0
            org.bouncycastle.asn1.ASN1Encodable r3 = r1.getObjectAt(r3)
            boolean r3 = r3 instanceof org.bouncycastle.asn1.ASN1Integer
            r4 = 0
            if (r3 == 0) goto L_0x005f
            org.bouncycastle.asn1.x9.X9ECParameters r15 = org.bouncycastle.asn1.x9.X9ECParameters.getInstance(r1)
            org.bouncycastle.jce.spec.ECParameterSpec r1 = new org.bouncycastle.jce.spec.ECParameterSpec
            org.bouncycastle.math.ec.ECCurve r6 = r15.getCurve()
            org.bouncycastle.math.ec.ECPoint r7 = r15.getG()
            java.math.BigInteger r8 = r15.getN()
            java.math.BigInteger r9 = r15.getH()
            byte[] r10 = r15.getSeed()
            r5 = r1
            r5.<init>(r6, r7, r8, r9, r10)
            goto L_0x00f9
        L_0x005f:
            org.bouncycastle.asn1.ua.DSTU4145Params r1 = org.bouncycastle.asn1.ua.DSTU4145Params.getInstance(r1)
            r14.dstuParams = r1
            boolean r1 = r1.isNamedCurve()
            if (r1 == 0) goto L_0x0096
            org.bouncycastle.asn1.ua.DSTU4145Params r15 = r14.dstuParams
            org.bouncycastle.asn1.ASN1ObjectIdentifier r15 = r15.getNamedCurve()
            org.bouncycastle.crypto.params.ECDomainParameters r1 = org.bouncycastle.asn1.ua.DSTU4145NamedCurves.getByOID(r15)
            org.bouncycastle.jce.spec.ECNamedCurveParameterSpec r2 = new org.bouncycastle.jce.spec.ECNamedCurveParameterSpec
            java.lang.String r6 = r15.getId()
            org.bouncycastle.math.ec.ECCurve r7 = r1.getCurve()
            org.bouncycastle.math.ec.ECPoint r8 = r1.getG()
            java.math.BigInteger r9 = r1.getN()
            java.math.BigInteger r10 = r1.getH()
            byte[] r11 = r1.getSeed()
            r5 = r2
            r5.<init>(r6, r7, r8, r9, r10, r11)
            r1 = r2
        L_0x0094:
            r15 = r4
            goto L_0x00f9
        L_0x0096:
            org.bouncycastle.asn1.ua.DSTU4145Params r1 = r14.dstuParams
            org.bouncycastle.asn1.ua.DSTU4145ECBinary r1 = r1.getECBinary()
            byte[] r3 = r1.getB()
            org.bouncycastle.asn1.x509.AlgorithmIdentifier r5 = r15.getAlgorithm()
            org.bouncycastle.asn1.ASN1ObjectIdentifier r5 = r5.getAlgorithm()
            boolean r5 = r5.equals((org.bouncycastle.asn1.ASN1Primitive) r2)
            if (r5 == 0) goto L_0x00b1
            r14.reverseBytes(r3)
        L_0x00b1:
            org.bouncycastle.asn1.ua.DSTU4145BinaryField r5 = r1.getField()
            org.bouncycastle.math.ec.ECCurve$F2m r13 = new org.bouncycastle.math.ec.ECCurve$F2m
            int r7 = r5.getM()
            int r8 = r5.getK1()
            int r9 = r5.getK2()
            int r10 = r5.getK3()
            java.math.BigInteger r11 = r1.getA()
            java.math.BigInteger r12 = new java.math.BigInteger
            r5 = 1
            r12.<init>(r5, r3)
            r6 = r13
            r6.<init>((int) r7, (int) r8, (int) r9, (int) r10, (java.math.BigInteger) r11, (java.math.BigInteger) r12)
            byte[] r3 = r1.getG()
            org.bouncycastle.asn1.x509.AlgorithmIdentifier r15 = r15.getAlgorithm()
            org.bouncycastle.asn1.ASN1ObjectIdentifier r15 = r15.getAlgorithm()
            boolean r15 = r15.equals((org.bouncycastle.asn1.ASN1Primitive) r2)
            if (r15 == 0) goto L_0x00ea
            r14.reverseBytes(r3)
        L_0x00ea:
            org.bouncycastle.jce.spec.ECParameterSpec r15 = new org.bouncycastle.jce.spec.ECParameterSpec
            org.bouncycastle.math.ec.ECPoint r2 = org.bouncycastle.asn1.ua.DSTU4145PointEncoder.decodePoint(r13, r3)
            java.math.BigInteger r1 = r1.getN()
            r15.<init>(r13, r2, r1)
            r1 = r15
            goto L_0x0094
        L_0x00f9:
            org.bouncycastle.math.ec.ECCurve r2 = r1.getCurve()
            byte[] r3 = r1.getSeed()
            java.security.spec.EllipticCurve r7 = org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.convertCurve(r2, r3)
            org.bouncycastle.asn1.ua.DSTU4145Params r3 = r14.dstuParams
            if (r3 == 0) goto L_0x0144
            org.bouncycastle.math.ec.ECPoint r15 = r1.getG()
            java.security.spec.ECPoint r8 = org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.convertPoint(r15)
            org.bouncycastle.asn1.ua.DSTU4145Params r15 = r14.dstuParams
            boolean r15 = r15.isNamedCurve()
            if (r15 == 0) goto L_0x0132
            org.bouncycastle.asn1.ua.DSTU4145Params r15 = r14.dstuParams
            org.bouncycastle.asn1.ASN1ObjectIdentifier r15 = r15.getNamedCurve()
            java.lang.String r6 = r15.getId()
            org.bouncycastle.jce.spec.ECNamedCurveSpec r15 = new org.bouncycastle.jce.spec.ECNamedCurveSpec
            java.math.BigInteger r9 = r1.getN()
            java.math.BigInteger r10 = r1.getH()
            r5 = r15
            r5.<init>((java.lang.String) r6, (java.security.spec.EllipticCurve) r7, (java.security.spec.ECPoint) r8, (java.math.BigInteger) r9, (java.math.BigInteger) r10)
            goto L_0x0148
        L_0x0132:
            java.security.spec.ECParameterSpec r15 = new java.security.spec.ECParameterSpec
            java.math.BigInteger r3 = r1.getN()
            java.math.BigInteger r1 = r1.getH()
            int r1 = r1.intValue()
            r15.<init>(r7, r8, r3, r1)
            goto L_0x0148
        L_0x0144:
            java.security.spec.ECParameterSpec r15 = org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.convertToSpec((org.bouncycastle.asn1.x9.X9ECParameters) r15)
        L_0x0148:
            r14.ecSpec = r15
            org.bouncycastle.crypto.params.ECPublicKeyParameters r15 = new org.bouncycastle.crypto.params.ECPublicKeyParameters
            org.bouncycastle.math.ec.ECPoint r0 = org.bouncycastle.asn1.ua.DSTU4145PointEncoder.decodePoint(r2, r0)
            java.security.spec.ECParameterSpec r1 = r14.ecSpec
            org.bouncycastle.crypto.params.ECDomainParameters r1 = org.bouncycastle.jcajce.provider.asymmetric.util.EC5Util.getDomainParameters(r4, r1)
            r15.<init>(r0, r1)
            r14.ecPublicKey = r15
            return
        L_0x015c:
            java.lang.IllegalArgumentException r15 = new java.lang.IllegalArgumentException
            java.lang.String r0 = "error recovering public key"
            r15.<init>(r0)
            throw r15
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.jcajce.provider.asymmetric.dstu.BCDSTU4145PublicKey.populateFromPubKeyInfo(org.bouncycastle.asn1.x509.SubjectPublicKeyInfo):void");
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        populateFromPubKeyInfo(SubjectPublicKeyInfo.getInstance(ASN1Primitive.fromByteArray((byte[]) objectInputStream.readObject())));
    }

    private void reverseBytes(byte[] bArr) {
        for (int i11 = 0; i11 < bArr.length / 2; i11++) {
            byte b11 = bArr[i11];
            bArr[i11] = bArr[(bArr.length - 1) - i11];
            bArr[(bArr.length - 1) - i11] = b11;
        }
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(getEncoded());
    }

    public ECPublicKeyParameters engineGetKeyParameters() {
        return this.ecPublicKey;
    }

    public org.bouncycastle.jce.spec.ECParameterSpec engineGetSpec() {
        ECParameterSpec eCParameterSpec = this.ecSpec;
        return eCParameterSpec != null ? EC5Util.convertSpec(eCParameterSpec) : BouncyCastleProvider.CONFIGURATION.getEcImplicitlyCa();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof BCDSTU4145PublicKey)) {
            return false;
        }
        BCDSTU4145PublicKey bCDSTU4145PublicKey = (BCDSTU4145PublicKey) obj;
        return this.ecPublicKey.getQ().equals(bCDSTU4145PublicKey.ecPublicKey.getQ()) && engineGetSpec().equals(bCDSTU4145PublicKey.engineGetSpec());
    }

    public String getAlgorithm() {
        return this.algorithm;
    }

    public byte[] getEncoded() {
        ASN1Encodable aSN1Encodable = this.dstuParams;
        if (aSN1Encodable == null) {
            ECParameterSpec eCParameterSpec = this.ecSpec;
            if (eCParameterSpec instanceof ECNamedCurveSpec) {
                aSN1Encodable = new DSTU4145Params(new ASN1ObjectIdentifier(((ECNamedCurveSpec) this.ecSpec).getName()));
            } else {
                ECCurve convertCurve = EC5Util.convertCurve(eCParameterSpec.getCurve());
                aSN1Encodable = new X962Parameters(new X9ECParameters(convertCurve, new X9ECPoint(EC5Util.convertPoint(convertCurve, this.ecSpec.getGenerator()), this.withCompression), this.ecSpec.getOrder(), BigInteger.valueOf((long) this.ecSpec.getCofactor()), this.ecSpec.getCurve().getSeed()));
            }
        }
        try {
            return KeyUtil.getEncodedSubjectPublicKeyInfo(new SubjectPublicKeyInfo(new AlgorithmIdentifier(UAObjectIdentifiers.dstu4145be, aSN1Encodable), (ASN1Encodable) new DEROctetString(DSTU4145PointEncoder.encodePoint(this.ecPublicKey.getQ()))));
        } catch (IOException unused) {
            return null;
        }
    }

    public String getFormat() {
        return "X.509";
    }

    public org.bouncycastle.jce.spec.ECParameterSpec getParameters() {
        ECParameterSpec eCParameterSpec = this.ecSpec;
        if (eCParameterSpec == null) {
            return null;
        }
        return EC5Util.convertSpec(eCParameterSpec);
    }

    public ECParameterSpec getParams() {
        return this.ecSpec;
    }

    public ECPoint getQ() {
        ECPoint q11 = this.ecPublicKey.getQ();
        return this.ecSpec == null ? q11.getDetachedPoint() : q11;
    }

    public byte[] getSbox() {
        DSTU4145Params dSTU4145Params = this.dstuParams;
        return dSTU4145Params != null ? dSTU4145Params.getDKE() : DSTU4145Params.getDefaultDKE();
    }

    public java.security.spec.ECPoint getW() {
        return EC5Util.convertPoint(this.ecPublicKey.getQ());
    }

    public int hashCode() {
        return this.ecPublicKey.getQ().hashCode() ^ engineGetSpec().hashCode();
    }

    public void setPointFormat(String str) {
        this.withCompression = !"UNCOMPRESSED".equalsIgnoreCase(str);
    }

    public String toString() {
        return ECUtil.publicKeyToString(this.algorithm, this.ecPublicKey.getQ(), engineGetSpec());
    }
}
