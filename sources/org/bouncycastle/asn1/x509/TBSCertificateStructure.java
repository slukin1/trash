package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1BitString;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.pkcs.PKCSObjectIdentifiers;
import org.bouncycastle.asn1.x500.X500Name;

public class TBSCertificateStructure extends ASN1Object implements X509ObjectIdentifiers, PKCSObjectIdentifiers {
    public Time endDate;
    public X509Extensions extensions;
    public X500Name issuer;
    public ASN1BitString issuerUniqueId;
    public ASN1Sequence seq;
    public ASN1Integer serialNumber;
    public AlgorithmIdentifier signature;
    public Time startDate;
    public X500Name subject;
    public SubjectPublicKeyInfo subjectPublicKeyInfo;
    public ASN1BitString subjectUniqueId;
    public ASN1Integer version;

    public TBSCertificateStructure(ASN1Sequence aSN1Sequence) {
        int i11;
        this.seq = aSN1Sequence;
        if (aSN1Sequence.getObjectAt(0) instanceof ASN1TaggedObject) {
            this.version = ASN1Integer.getInstance((ASN1TaggedObject) aSN1Sequence.getObjectAt(0), true);
            i11 = 0;
        } else {
            this.version = new ASN1Integer(0);
            i11 = -1;
        }
        this.serialNumber = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(i11 + 1));
        this.signature = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(i11 + 2));
        this.issuer = X500Name.getInstance(aSN1Sequence.getObjectAt(i11 + 3));
        ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Sequence.getObjectAt(i11 + 4);
        this.startDate = Time.getInstance(aSN1Sequence2.getObjectAt(0));
        this.endDate = Time.getInstance(aSN1Sequence2.getObjectAt(1));
        this.subject = X500Name.getInstance(aSN1Sequence.getObjectAt(i11 + 5));
        int i12 = i11 + 6;
        this.subjectPublicKeyInfo = SubjectPublicKeyInfo.getInstance(aSN1Sequence.getObjectAt(i12));
        for (int size = (aSN1Sequence.size() - i12) - 1; size > 0; size--) {
            ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(i12 + size));
            int tagNo = instance.getTagNo();
            if (tagNo == 1) {
                this.issuerUniqueId = ASN1BitString.getInstance(instance, false);
            } else if (tagNo == 2) {
                this.subjectUniqueId = ASN1BitString.getInstance(instance, false);
            } else if (tagNo == 3) {
                this.extensions = X509Extensions.getInstance(instance);
            }
        }
    }

    public static TBSCertificateStructure getInstance(Object obj) {
        if (obj instanceof TBSCertificateStructure) {
            return (TBSCertificateStructure) obj;
        }
        if (obj != null) {
            return new TBSCertificateStructure(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static TBSCertificateStructure getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z11));
    }

    public Time getEndDate() {
        return this.endDate;
    }

    public X509Extensions getExtensions() {
        return this.extensions;
    }

    public X500Name getIssuer() {
        return this.issuer;
    }

    public ASN1BitString getIssuerUniqueId() {
        return this.issuerUniqueId;
    }

    public ASN1Integer getSerialNumber() {
        return this.serialNumber;
    }

    public AlgorithmIdentifier getSignature() {
        return this.signature;
    }

    public Time getStartDate() {
        return this.startDate;
    }

    public X500Name getSubject() {
        return this.subject;
    }

    public SubjectPublicKeyInfo getSubjectPublicKeyInfo() {
        return this.subjectPublicKeyInfo;
    }

    public ASN1BitString getSubjectUniqueId() {
        return this.subjectUniqueId;
    }

    public int getVersion() {
        return this.version.intValueExact() + 1;
    }

    public ASN1Integer getVersionNumber() {
        return this.version;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.seq;
    }
}
