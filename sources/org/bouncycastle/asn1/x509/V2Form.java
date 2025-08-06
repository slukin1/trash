package org.bouncycastle.asn1.x509;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class V2Form extends ASN1Object {
    public IssuerSerial baseCertificateID;
    public GeneralNames issuerName;
    public ObjectDigestInfo objectDigestInfo;

    private V2Form(ASN1Sequence aSN1Sequence) {
        int i11;
        if (aSN1Sequence.size() <= 3) {
            if (!(aSN1Sequence.getObjectAt(0) instanceof ASN1TaggedObject)) {
                this.issuerName = GeneralNames.getInstance(aSN1Sequence.getObjectAt(0));
                i11 = 1;
            } else {
                i11 = 0;
            }
            while (i11 != aSN1Sequence.size()) {
                ASN1TaggedObject instance = ASN1TaggedObject.getInstance(aSN1Sequence.getObjectAt(i11));
                if (instance.getTagNo() == 0) {
                    this.baseCertificateID = IssuerSerial.getInstance(instance, false);
                } else if (instance.getTagNo() == 1) {
                    this.objectDigestInfo = ObjectDigestInfo.getInstance(instance, false);
                } else {
                    throw new IllegalArgumentException("Bad tag number: " + instance.getTagNo());
                }
                i11++;
            }
            return;
        }
        throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
    }

    public V2Form(GeneralNames generalNames) {
        this(generalNames, (IssuerSerial) null, (ObjectDigestInfo) null);
    }

    public V2Form(GeneralNames generalNames, IssuerSerial issuerSerial) {
        this(generalNames, issuerSerial, (ObjectDigestInfo) null);
    }

    public V2Form(GeneralNames generalNames, IssuerSerial issuerSerial, ObjectDigestInfo objectDigestInfo2) {
        this.issuerName = generalNames;
        this.baseCertificateID = issuerSerial;
        this.objectDigestInfo = objectDigestInfo2;
    }

    public V2Form(GeneralNames generalNames, ObjectDigestInfo objectDigestInfo2) {
        this(generalNames, (IssuerSerial) null, objectDigestInfo2);
    }

    public static V2Form getInstance(Object obj) {
        if (obj instanceof V2Form) {
            return (V2Form) obj;
        }
        if (obj != null) {
            return new V2Form(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static V2Form getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z11));
    }

    public IssuerSerial getBaseCertificateID() {
        return this.baseCertificateID;
    }

    public GeneralNames getIssuerName() {
        return this.issuerName;
    }

    public ObjectDigestInfo getObjectDigestInfo() {
        return this.objectDigestInfo;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        GeneralNames generalNames = this.issuerName;
        if (generalNames != null) {
            aSN1EncodableVector.add(generalNames);
        }
        IssuerSerial issuerSerial = this.baseCertificateID;
        if (issuerSerial != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, (ASN1Encodable) issuerSerial));
        }
        ObjectDigestInfo objectDigestInfo2 = this.objectDigestInfo;
        if (objectDigestInfo2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, (ASN1Encodable) objectDigestInfo2));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
