package org.bouncycastle.oer.its.ieee1609dot2;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Null;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERNull;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.oer.its.ieee1609dot2.basetypes.HashedId8;

public class SignerIdentifier extends ASN1Object implements ASN1Choice {
    public static final int certificate = 1;
    public static final int digest = 0;
    public static final int self = 2;
    private final int choice;
    private final ASN1Encodable signerIdentifier;

    public SignerIdentifier(int i11, ASN1Encodable aSN1Encodable) {
        this.choice = i11;
        this.signerIdentifier = aSN1Encodable;
    }

    private SignerIdentifier(ASN1TaggedObject aSN1TaggedObject) {
        ASN1Encodable aSN1Encodable;
        int tagNo = aSN1TaggedObject.getTagNo();
        this.choice = tagNo;
        if (tagNo == 0) {
            aSN1Encodable = HashedId8.getInstance(aSN1TaggedObject.getObject());
        } else if (tagNo == 1) {
            aSN1Encodable = SequenceOfCertificate.getInstance(aSN1TaggedObject.getObject());
        } else if (tagNo == 2) {
            aSN1Encodable = ASN1Null.getInstance(aSN1TaggedObject.getObject());
        } else {
            throw new IllegalArgumentException("invalid choice value " + tagNo);
        }
        this.signerIdentifier = aSN1Encodable;
    }

    public static SignerIdentifier certificate(SequenceOfCertificate sequenceOfCertificate) {
        return new SignerIdentifier(1, sequenceOfCertificate);
    }

    public static SignerIdentifier digest(HashedId8 hashedId8) {
        return new SignerIdentifier(0, hashedId8);
    }

    public static SignerIdentifier getInstance(Object obj) {
        if (obj instanceof SignerIdentifier) {
            return (SignerIdentifier) obj;
        }
        if (obj != null) {
            return new SignerIdentifier(ASN1TaggedObject.getInstance(obj));
        }
        return null;
    }

    public static SignerIdentifier self() {
        return new SignerIdentifier(2, DERNull.INSTANCE);
    }

    public int getChoice() {
        return this.choice;
    }

    public ASN1Encodable getSignerIdentifier() {
        return this.signerIdentifier;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.choice, this.signerIdentifier);
    }
}
