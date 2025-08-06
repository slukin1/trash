package org.bouncycastle.oer.its.ieee1609dot2dot1;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;
import org.bouncycastle.oer.its.ieee1609dot2.basetypes.PublicEncryptionKey;

public class AdditionalParams extends ASN1Object implements ASN1Choice {
    public static final int compactUnified = 2;
    public static final int encryptionKey = 3;
    public static final int original = 0;
    public static final int unified = 1;
    public final ASN1Encodable additionalParams;
    public final int choice;

    private AdditionalParams(int i11, ASN1Encodable aSN1Encodable) {
        ASN1Encodable aSN1Encodable2;
        if (i11 == 0) {
            aSN1Encodable2 = ButterflyParamsOriginal.getInstance(aSN1Encodable);
        } else if (i11 == 1 || i11 == 2) {
            aSN1Encodable2 = ButterflyExpansion.getInstance(aSN1Encodable);
        } else if (i11 == 3) {
            aSN1Encodable2 = PublicEncryptionKey.getInstance(aSN1Encodable);
        } else {
            throw new IllegalArgumentException("invalid choice value " + i11);
        }
        this.additionalParams = aSN1Encodable2;
        this.choice = i11;
    }

    private AdditionalParams(ASN1TaggedObject aSN1TaggedObject) {
        this(aSN1TaggedObject.getTagNo(), aSN1TaggedObject.getObject());
    }

    public static AdditionalParams compactUnified(ButterflyExpansion butterflyExpansion) {
        return new AdditionalParams(2, butterflyExpansion);
    }

    public static AdditionalParams encryptionKey(PublicEncryptionKey publicEncryptionKey) {
        return new AdditionalParams(3, publicEncryptionKey);
    }

    public static AdditionalParams getInstance(Object obj) {
        if (obj instanceof AdditionalParams) {
            return (AdditionalParams) obj;
        }
        if (obj == null) {
            return null;
        }
        ASN1TaggedObject instance = ASN1TaggedObject.getInstance(obj);
        return new AdditionalParams(instance.getTagNo(), instance.getObject());
    }

    public static AdditionalParams original(ButterflyParamsOriginal butterflyParamsOriginal) {
        return new AdditionalParams(0, butterflyParamsOriginal);
    }

    public static AdditionalParams unified(ButterflyExpansion butterflyExpansion) {
        return new AdditionalParams(1, butterflyExpansion);
    }

    public ASN1Encodable getAdditionalParams() {
        return this.additionalParams;
    }

    public int getChoice() {
        return this.choice;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERTaggedObject(this.choice, this.additionalParams);
    }
}
