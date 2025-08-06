package org.bouncycastle.oer.its.ieee1609dot2;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.oer.its.ieee1609dot2.basetypes.Hostname;

public class CertificateId extends ASN1Object implements ASN1Choice {
    public static final int binaryId = 2;
    public static final int linkageData = 0;
    public static final int name = 1;
    public static final int none = 3;
    private final ASN1Encodable certificateId;
    private final int choice;

    public CertificateId(int i11, ASN1Encodable aSN1Encodable) {
        this.choice = i11;
        this.certificateId = aSN1Encodable;
    }

    private CertificateId(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable aSN1Encodable;
        int tagNo = aSN1TaggedObject.getTagNo();
        this.choice = tagNo;
        if (tagNo == 0) {
            aSN1Encodable = LinkageData.getInstance(aSN1TaggedObject.getObject());
        } else if (tagNo == 1) {
            aSN1Encodable = Hostname.getInstance(aSN1TaggedObject.getObject());
        } else if (tagNo == 2) {
            aSN1Encodable = ASN1OctetString.getInstance(aSN1TaggedObject.getObject());
        } else if (tagNo == 3) {
            aSN1Encodable = ASN1Null.getInstance(aSN1TaggedObject.getObject());
        } else {
            throw new IllegalArgumentException("invalid choice value " + tagNo);
        }
        this.certificateId = aSN1Encodable;
    }

    public static CertificateId binaryId(ASN1OctetString aSN1OctetString) {
        return new CertificateId(2, aSN1OctetString);
    }

    public static CertificateId binaryId(byte[] bArr) {
        return new CertificateId(2, new DEROctetString(bArr));
    }

    public static CertificateId getInstance(Object obj) {
        if (obj instanceof CertificateId) {
            return (CertificateId) obj;
        }
        if (obj != null) {
            return new CertificateId(ASN1TaggedObject.getInstance(obj));
        }
        return null;
    }

    public static CertificateId linkageData(LinkageData linkageData2) {
        return new CertificateId(0, linkageData2);
    }

    public static CertificateId name(Hostname hostname) {
        return new CertificateId(1, hostname);
    }

    public static CertificateId none() {
        return new CertificateId(3, DERNull.INSTANCE);
    }

    public ASN1Encodable getCertificateId() {
        return this.certificateId;
    }

    public int getChoice() {
        return this.choice;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.choice, this.certificateId).toASN1Primitive();
    }
}
