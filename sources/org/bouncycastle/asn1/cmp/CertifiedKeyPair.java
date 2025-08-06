package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.asn1.crmf.EncryptedKey;
import org.bouncycastle.asn1.crmf.EncryptedValue;
import org.bouncycastle.asn1.crmf.PKIPublicationInfo;

public class CertifiedKeyPair extends ASN1Object {
    private final CertOrEncCert certOrEncCert;
    private EncryptedKey privateKey;
    private PKIPublicationInfo publicationInfo;

    private CertifiedKeyPair(ASN1Sequence aSN1Sequence) {
        ASN1Primitive aSN1Primitive;
        this.certOrEncCert = CertOrEncCert.getInstance(aSN1Sequence.getObjectAt(0));
        if (aSN1Sequence.size() >= 2) {
            if (aSN1Sequence.size() == 2) {
                ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1));
                int tagNo = instance.getTagNo();
                aSN1Primitive = instance.getObject();
                if (tagNo == 0) {
                    this.privateKey = EncryptedKey.getInstance(aSN1Primitive);
                    return;
                }
            } else {
                this.privateKey = EncryptedKey.getInstance(ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(1)).getObject());
                aSN1Primitive = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(2)).getObject();
            }
            this.publicationInfo = PKIPublicationInfo.getInstance(aSN1Primitive);
        }
    }

    public CertifiedKeyPair(CertOrEncCert certOrEncCert2) {
        this(certOrEncCert2, (EncryptedKey) null, (PKIPublicationInfo) null);
    }

    public CertifiedKeyPair(CertOrEncCert certOrEncCert2, EncryptedKey encryptedKey, PKIPublicationInfo pKIPublicationInfo) {
        if (certOrEncCert2 != null) {
            this.certOrEncCert = certOrEncCert2;
            this.privateKey = encryptedKey;
            this.publicationInfo = pKIPublicationInfo;
            return;
        }
        throw new IllegalArgumentException("'certOrEncCert' cannot be null");
    }

    public CertifiedKeyPair(CertOrEncCert certOrEncCert2, EncryptedValue encryptedValue, PKIPublicationInfo pKIPublicationInfo) {
        if (certOrEncCert2 != null) {
            this.certOrEncCert = certOrEncCert2;
            this.privateKey = encryptedValue != null ? new EncryptedKey(encryptedValue) : null;
            this.publicationInfo = pKIPublicationInfo;
            return;
        }
        throw new IllegalArgumentException("'certOrEncCert' cannot be null");
    }

    public static CertifiedKeyPair getInstance(Object obj) {
        if (obj instanceof CertifiedKeyPair) {
            return (CertifiedKeyPair) obj;
        }
        if (obj != null) {
            return new CertifiedKeyPair(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CertOrEncCert getCertOrEncCert() {
        return this.certOrEncCert;
    }

    public EncryptedKey getPrivateKey() {
        return this.privateKey;
    }

    public PKIPublicationInfo getPublicationInfo() {
        return this.publicationInfo;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.add(this.certOrEncCert);
        EncryptedKey encryptedKey = this.privateKey;
        if (encryptedKey != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, (ASN1Encodable) encryptedKey));
        }
        PKIPublicationInfo pKIPublicationInfo = this.publicationInfo;
        if (pKIPublicationInfo != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, (ASN1Encodable) pKIPublicationInfo));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
