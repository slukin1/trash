package org.bouncycastle.asn1.x500;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Set;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERSet;

public class RDN extends ASN1Object {
    private ASN1Set values;

    public RDN(ASN1ObjectIdentifier aSN1ObjectIdentifier, ASN1Encodable aSN1Encodable) {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(aSN1ObjectIdentifier);
        aSN1EncodableVector.add(aSN1Encodable);
        this.values = new DERSet((ASN1Encodable) new DERSequence(aSN1EncodableVector));
    }

    private RDN(ASN1Set aSN1Set) {
        this.values = aSN1Set;
    }

    public RDN(AttributeTypeAndValue attributeTypeAndValue) {
        this.values = new DERSet((ASN1Encodable) attributeTypeAndValue);
    }

    public RDN(AttributeTypeAndValue[] attributeTypeAndValueArr) {
        this.values = new DERSet((ASN1Encodable[]) attributeTypeAndValueArr);
    }

    public static RDN getInstance(Object obj) {
        if (obj instanceof RDN) {
            return (RDN) obj;
        }
        if (obj != null) {
            return new RDN(ASN1Set.getInstance(obj));
        }
        return null;
    }

    public int collectAttributeTypes(ASN1ObjectIdentifier[] aSN1ObjectIdentifierArr, int i11) {
        int size = this.values.size();
        for (int i12 = 0; i12 < size; i12++) {
            aSN1ObjectIdentifierArr[i11 + i12] = AttributeTypeAndValue.getInstance(this.values.getObjectAt(i12)).getType();
        }
        return size;
    }

    public boolean containsAttributeType(ASN1ObjectIdentifier aSN1ObjectIdentifier) {
        int size = this.values.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (AttributeTypeAndValue.getInstance(this.values.getObjectAt(i11)).getType().equals((ASN1Primitive) aSN1ObjectIdentifier)) {
                return true;
            }
        }
        return false;
    }

    public AttributeTypeAndValue getFirst() {
        if (this.values.size() == 0) {
            return null;
        }
        return AttributeTypeAndValue.getInstance(this.values.getObjectAt(0));
    }

    public AttributeTypeAndValue[] getTypesAndValues() {
        int size = this.values.size();
        AttributeTypeAndValue[] attributeTypeAndValueArr = new AttributeTypeAndValue[size];
        for (int i11 = 0; i11 != size; i11++) {
            attributeTypeAndValueArr[i11] = AttributeTypeAndValue.getInstance(this.values.getObjectAt(i11));
        }
        return attributeTypeAndValueArr;
    }

    public boolean isMultiValued() {
        return this.values.size() > 1;
    }

    public int size() {
        return this.values.size();
    }

    public ASN1Primitive toASN1Primitive() {
        return this.values;
    }
}
