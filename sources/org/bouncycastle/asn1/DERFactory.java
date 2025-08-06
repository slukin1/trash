package org.bouncycastle.asn1;

class DERFactory {
    public static final DERSequence EMPTY_SEQUENCE = new DERSequence();
    public static final DERSet EMPTY_SET = new DERSet();

    public static DERSequence createSequence(ASN1EncodableVector aSN1EncodableVector) {
        return aSN1EncodableVector.size() < 1 ? EMPTY_SEQUENCE : new DERSequence(aSN1EncodableVector);
    }

    public static DERSet createSet(ASN1EncodableVector aSN1EncodableVector) {
        return aSN1EncodableVector.size() < 1 ? EMPTY_SET : new DERSet(aSN1EncodableVector);
    }
}
