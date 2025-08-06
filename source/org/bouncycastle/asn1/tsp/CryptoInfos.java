package org.bouncycastle.asn1.tsp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.cms.Attribute;

public class CryptoInfos extends ASN1Object {
    private ASN1Sequence attributes;

    private CryptoInfos(ASN1Sequence aSN1Sequence) {
        this.attributes = aSN1Sequence;
    }

    public CryptoInfos(Attribute[] attributeArr) {
        this.attributes = new DERSequence((ASN1Encodable[]) attributeArr);
    }

    public static CryptoInfos getInstance(Object obj) {
        if (obj instanceof CryptoInfos) {
            return (CryptoInfos) obj;
        }
        if (obj != null) {
            return new CryptoInfos(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static CryptoInfos getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z11));
    }

    public Attribute[] getAttributes() {
        int size = this.attributes.size();
        Attribute[] attributeArr = new Attribute[size];
        for (int i11 = 0; i11 != size; i11++) {
            attributeArr[i11] = Attribute.getInstance(this.attributes.getObjectAt(i11));
        }
        return attributeArr;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.attributes;
    }
}
