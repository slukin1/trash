package org.bouncycastle.asn1.cmp;

import java.util.Iterator;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class RootCaKeyUpdateContent extends ASN1Object {
    private final CMPCertificate newWithNew;
    private final CMPCertificate newWithOld;
    private final CMPCertificate oldWithNew;

    private RootCaKeyUpdateContent(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() < 1 || aSN1Sequence.size() > 3) {
            throw new IllegalArgumentException("expected sequence of 1 to 3 elements only");
        }
        Iterator<ASN1Encodable> it2 = aSN1Sequence.iterator();
        CMPCertificate instance = CMPCertificate.getInstance(it2.next());
        CMPCertificate cMPCertificate = null;
        CMPCertificate cMPCertificate2 = null;
        while (it2.hasNext()) {
            ASN1TaggedObject instance2 = ASN1TaggedObject.getInstance(it2.next());
            if (instance2.getTagNo() == 0) {
                cMPCertificate = CMPCertificate.getInstance(instance2, true);
            } else if (instance2.getTagNo() == 1) {
                cMPCertificate2 = CMPCertificate.getInstance(instance2, true);
            }
        }
        this.newWithNew = instance;
        this.newWithOld = cMPCertificate;
        this.oldWithNew = cMPCertificate2;
    }

    public RootCaKeyUpdateContent(CMPCertificate cMPCertificate, CMPCertificate cMPCertificate2, CMPCertificate cMPCertificate3) {
        this.newWithNew = cMPCertificate;
        this.newWithOld = cMPCertificate2;
        this.oldWithNew = cMPCertificate3;
    }

    public static RootCaKeyUpdateContent getInstance(Object obj) {
        if (obj instanceof RootCaKeyUpdateContent) {
            return (RootCaKeyUpdateContent) obj;
        }
        if (obj != null) {
            return new RootCaKeyUpdateContent(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CMPCertificate getNewWithNew() {
        return this.newWithNew;
    }

    public CMPCertificate getNewWithOld() {
        return this.newWithOld;
    }

    public CMPCertificate getOldWithNew() {
        return this.oldWithNew;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.newWithNew);
        CMPCertificate cMPCertificate = this.newWithOld;
        if (cMPCertificate != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 0, (ASN1Encodable) cMPCertificate));
        }
        CMPCertificate cMPCertificate2 = this.oldWithNew;
        if (cMPCertificate2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(true, 1, (ASN1Encodable) cMPCertificate2));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
