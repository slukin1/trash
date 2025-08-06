package org.bouncycastle.x509;

import java.io.IOException;
import java.math.BigInteger;
import java.security.Principal;
import java.security.cert.CertSelector;
import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import javax.security.auth.x500.X500Principal;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.asn1.x509.GeneralName;
import org.bouncycastle.asn1.x509.GeneralNames;
import org.bouncycastle.asn1.x509.Holder;
import org.bouncycastle.asn1.x509.IssuerSerial;
import org.bouncycastle.asn1.x509.ObjectDigestInfo;
import org.bouncycastle.asn1.x509.X509Name;
import org.bouncycastle.jce.PrincipalUtil;
import org.bouncycastle.jce.X509Principal;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Selector;

public class AttributeCertificateHolder implements CertSelector, Selector {
    public final Holder holder;

    public AttributeCertificateHolder(int i11, String str, String str2, byte[] bArr) {
        this.holder = new Holder(new ObjectDigestInfo(i11, new ASN1ObjectIdentifier(str2), new AlgorithmIdentifier(new ASN1ObjectIdentifier(str)), Arrays.clone(bArr)));
    }

    public AttributeCertificateHolder(X509Certificate x509Certificate) throws CertificateParsingException {
        try {
            this.holder = new Holder(new IssuerSerial(generateGeneralNames(PrincipalUtil.getIssuerX509Principal(x509Certificate)), new ASN1Integer(x509Certificate.getSerialNumber())));
        } catch (Exception e11) {
            throw new CertificateParsingException(e11.getMessage());
        }
    }

    public AttributeCertificateHolder(X500Principal x500Principal) {
        this(X509Util.convertPrincipal(x500Principal));
    }

    public AttributeCertificateHolder(X500Principal x500Principal, BigInteger bigInteger) {
        this(X509Util.convertPrincipal(x500Principal), bigInteger);
    }

    public AttributeCertificateHolder(ASN1Sequence aSN1Sequence) {
        this.holder = Holder.getInstance(aSN1Sequence);
    }

    public AttributeCertificateHolder(X509Principal x509Principal) {
        this.holder = new Holder(generateGeneralNames(x509Principal));
    }

    public AttributeCertificateHolder(X509Principal x509Principal, BigInteger bigInteger) {
        this.holder = new Holder(new IssuerSerial(GeneralNames.getInstance(new DERSequence((ASN1Encodable) new GeneralName((X509Name) x509Principal))), new ASN1Integer(bigInteger)));
    }

    private GeneralNames generateGeneralNames(X509Principal x509Principal) {
        return GeneralNames.getInstance(new DERSequence((ASN1Encodable) new GeneralName((X509Name) x509Principal)));
    }

    private Object[] getNames(GeneralName[] generalNameArr) {
        ArrayList arrayList = new ArrayList(generalNameArr.length);
        for (int i11 = 0; i11 != generalNameArr.length; i11++) {
            if (generalNameArr[i11].getTagNo() == 4) {
                try {
                    arrayList.add(new X500Principal(generalNameArr[i11].getName().toASN1Primitive().getEncoded()));
                } catch (IOException unused) {
                    throw new RuntimeException("badly formed Name object");
                }
            }
        }
        return arrayList.toArray(new Object[arrayList.size()]);
    }

    private Principal[] getPrincipals(GeneralNames generalNames) {
        Object[] names = getNames(generalNames.getNames());
        ArrayList arrayList = new ArrayList();
        for (int i11 = 0; i11 != names.length; i11++) {
            if (names[i11] instanceof Principal) {
                arrayList.add(names[i11]);
            }
        }
        return (Principal[]) arrayList.toArray(new Principal[arrayList.size()]);
    }

    private boolean matchesDN(X509Principal x509Principal, GeneralNames generalNames) {
        GeneralName[] names = generalNames.getNames();
        for (int i11 = 0; i11 != names.length; i11++) {
            GeneralName generalName = names[i11];
            if (generalName.getTagNo() == 4) {
                try {
                    if (new X509Principal(generalName.getName().toASN1Primitive().getEncoded()).equals(x509Principal)) {
                        return true;
                    }
                } catch (IOException unused) {
                    continue;
                }
            }
        }
        return false;
    }

    public Object clone() {
        return new AttributeCertificateHolder((ASN1Sequence) this.holder.toASN1Primitive());
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AttributeCertificateHolder)) {
            return false;
        }
        return this.holder.equals(((AttributeCertificateHolder) obj).holder);
    }

    public String getDigestAlgorithm() {
        if (this.holder.getObjectDigestInfo() != null) {
            return this.holder.getObjectDigestInfo().getDigestAlgorithm().getAlgorithm().getId();
        }
        return null;
    }

    public int getDigestedObjectType() {
        if (this.holder.getObjectDigestInfo() != null) {
            return this.holder.getObjectDigestInfo().getDigestedObjectType().intValueExact();
        }
        return -1;
    }

    public Principal[] getEntityNames() {
        if (this.holder.getEntityName() != null) {
            return getPrincipals(this.holder.getEntityName());
        }
        return null;
    }

    public Principal[] getIssuer() {
        if (this.holder.getBaseCertificateID() != null) {
            return getPrincipals(this.holder.getBaseCertificateID().getIssuer());
        }
        return null;
    }

    public byte[] getObjectDigest() {
        if (this.holder.getObjectDigestInfo() != null) {
            return this.holder.getObjectDigestInfo().getObjectDigest().getBytes();
        }
        return null;
    }

    public String getOtherObjectTypeID() {
        if (this.holder.getObjectDigestInfo() == null) {
            return null;
        }
        this.holder.getObjectDigestInfo().getOtherObjectTypeID().getId();
        return null;
    }

    public BigInteger getSerialNumber() {
        if (this.holder.getBaseCertificateID() != null) {
            return this.holder.getBaseCertificateID().getSerial().getValue();
        }
        return null;
    }

    public int hashCode() {
        return this.holder.hashCode();
    }

    public boolean match(Object obj) {
        if (!(obj instanceof X509Certificate)) {
            return false;
        }
        return match((Certificate) obj);
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean match(java.security.cert.Certificate r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof java.security.cert.X509Certificate
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = r5
            java.security.cert.X509Certificate r0 = (java.security.cert.X509Certificate) r0
            org.bouncycastle.asn1.x509.Holder r2 = r4.holder     // Catch:{ CertificateEncodingException -> 0x008e }
            org.bouncycastle.asn1.x509.IssuerSerial r2 = r2.getBaseCertificateID()     // Catch:{ CertificateEncodingException -> 0x008e }
            r3 = 1
            if (r2 == 0) goto L_0x003c
            org.bouncycastle.asn1.x509.Holder r5 = r4.holder     // Catch:{ CertificateEncodingException -> 0x008e }
            org.bouncycastle.asn1.x509.IssuerSerial r5 = r5.getBaseCertificateID()     // Catch:{ CertificateEncodingException -> 0x008e }
            org.bouncycastle.asn1.ASN1Integer r5 = r5.getSerial()     // Catch:{ CertificateEncodingException -> 0x008e }
            java.math.BigInteger r2 = r0.getSerialNumber()     // Catch:{ CertificateEncodingException -> 0x008e }
            boolean r5 = r5.hasValue((java.math.BigInteger) r2)     // Catch:{ CertificateEncodingException -> 0x008e }
            if (r5 == 0) goto L_0x003b
            org.bouncycastle.jce.X509Principal r5 = org.bouncycastle.jce.PrincipalUtil.getIssuerX509Principal((java.security.cert.X509Certificate) r0)     // Catch:{ CertificateEncodingException -> 0x008e }
            org.bouncycastle.asn1.x509.Holder r0 = r4.holder     // Catch:{ CertificateEncodingException -> 0x008e }
            org.bouncycastle.asn1.x509.IssuerSerial r0 = r0.getBaseCertificateID()     // Catch:{ CertificateEncodingException -> 0x008e }
            org.bouncycastle.asn1.x509.GeneralNames r0 = r0.getIssuer()     // Catch:{ CertificateEncodingException -> 0x008e }
            boolean r5 = r4.matchesDN(r5, r0)     // Catch:{ CertificateEncodingException -> 0x008e }
            if (r5 == 0) goto L_0x003b
            r1 = r3
        L_0x003b:
            return r1
        L_0x003c:
            org.bouncycastle.asn1.x509.Holder r2 = r4.holder     // Catch:{ CertificateEncodingException -> 0x008e }
            org.bouncycastle.asn1.x509.GeneralNames r2 = r2.getEntityName()     // Catch:{ CertificateEncodingException -> 0x008e }
            if (r2 == 0) goto L_0x0055
            org.bouncycastle.jce.X509Principal r0 = org.bouncycastle.jce.PrincipalUtil.getSubjectX509Principal(r0)     // Catch:{ CertificateEncodingException -> 0x008e }
            org.bouncycastle.asn1.x509.Holder r2 = r4.holder     // Catch:{ CertificateEncodingException -> 0x008e }
            org.bouncycastle.asn1.x509.GeneralNames r2 = r2.getEntityName()     // Catch:{ CertificateEncodingException -> 0x008e }
            boolean r0 = r4.matchesDN(r0, r2)     // Catch:{ CertificateEncodingException -> 0x008e }
            if (r0 == 0) goto L_0x0055
            return r3
        L_0x0055:
            org.bouncycastle.asn1.x509.Holder r0 = r4.holder     // Catch:{ CertificateEncodingException -> 0x008e }
            org.bouncycastle.asn1.x509.ObjectDigestInfo r0 = r0.getObjectDigestInfo()     // Catch:{ CertificateEncodingException -> 0x008e }
            if (r0 == 0) goto L_0x008e
            java.lang.String r0 = r4.getDigestAlgorithm()     // Catch:{  }
            java.lang.String r2 = "BC"
            java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r0, r2)     // Catch:{  }
            int r2 = r4.getDigestedObjectType()     // Catch:{ CertificateEncodingException -> 0x008e }
            if (r2 == 0) goto L_0x0078
            if (r2 == r3) goto L_0x0070
            goto L_0x0083
        L_0x0070:
            byte[] r5 = r5.getEncoded()     // Catch:{ CertificateEncodingException -> 0x008e }
            r0.update(r5)     // Catch:{ CertificateEncodingException -> 0x008e }
            goto L_0x0083
        L_0x0078:
            java.security.PublicKey r5 = r5.getPublicKey()     // Catch:{ CertificateEncodingException -> 0x008e }
            byte[] r5 = r5.getEncoded()     // Catch:{ CertificateEncodingException -> 0x008e }
            r0.update(r5)     // Catch:{ CertificateEncodingException -> 0x008e }
        L_0x0083:
            byte[] r5 = r0.digest()     // Catch:{ CertificateEncodingException -> 0x008e }
            byte[] r0 = r4.getObjectDigest()     // Catch:{ CertificateEncodingException -> 0x008e }
            org.bouncycastle.util.Arrays.areEqual((byte[]) r5, (byte[]) r0)     // Catch:{ CertificateEncodingException -> 0x008e }
        L_0x008e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.x509.AttributeCertificateHolder.match(java.security.cert.Certificate):boolean");
    }
}
