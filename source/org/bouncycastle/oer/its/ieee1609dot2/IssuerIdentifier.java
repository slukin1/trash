package org.bouncycastle.oer.its.ieee1609dot2;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.oer.its.ieee1609dot2.basetypes.HashAlgorithm;
import org.bouncycastle.oer.its.ieee1609dot2.basetypes.HashedId8;

public class IssuerIdentifier extends ASN1Object implements ASN1Choice {
    public static final int self = 1;
    public static final int sha256AndDigest = 0;
    public static final int sha384AndDigest = 2;
    private final int choice;
    private final ASN1Encodable issuerIdentifier;

    public IssuerIdentifier(int i11, ASN1Encodable aSN1Encodable) {
        this.choice = i11;
        this.issuerIdentifier = aSN1Encodable;
    }

    private IssuerIdentifier(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable aSN1Encodable;
        int tagNo = aSN1TaggedObject.getTagNo();
        this.choice = tagNo;
        ASN1Primitive object = aSN1TaggedObject.getObject();
        if (tagNo != 0) {
            if (tagNo == 1) {
                aSN1Encodable = HashAlgorithm.getInstance(object);
                this.issuerIdentifier = aSN1Encodable;
            } else if (tagNo != 2) {
                throw new IllegalArgumentException("invalid choice value " + tagNo);
            }
        }
        aSN1Encodable = HashedId8.getInstance(object);
        this.issuerIdentifier = aSN1Encodable;
    }

    public static IssuerIdentifier getInstance(Object obj) {
        if (obj instanceof IssuerIdentifier) {
            return (IssuerIdentifier) obj;
        }
        if (obj != null) {
            return new IssuerIdentifier(ASN1TaggedObject.getInstance(obj));
        }
        return null;
    }

    public static IssuerIdentifier self(HashAlgorithm hashAlgorithm) {
        return new IssuerIdentifier(1, hashAlgorithm);
    }

    public static IssuerIdentifier sha256AndDigest(HashedId8 hashedId8) {
        return new IssuerIdentifier(0, hashedId8);
    }

    public static IssuerIdentifier sha384AndDigest(HashedId8 hashedId8) {
        return new IssuerIdentifier(2, hashedId8);
    }

    public int getChoice() {
        return this.choice;
    }

    public ASN1Encodable getIssuerIdentifier() {
        return this.issuerIdentifier;
    }

    public boolean isSelf() {
        return this.choice == 1;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.choice, this.issuerIdentifier);
    }
}
