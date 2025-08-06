package org.bouncycastle.asn1;

import java.io.IOException;

abstract class ASN1UniversalType extends ASN1Type {
    public final ASN1Tag tag;

    public ASN1UniversalType(Class cls, int i11) {
        super(cls);
        this.tag = ASN1Tag.create(0, i11);
    }

    public final ASN1Primitive checkedCast(ASN1Primitive aSN1Primitive) {
        if (this.javaClass.isInstance(aSN1Primitive)) {
            return aSN1Primitive;
        }
        throw new IllegalStateException("unexpected object: " + aSN1Primitive.getClass().getName());
    }

    public final ASN1Primitive fromByteArray(byte[] bArr) throws IOException {
        return checkedCast(ASN1Primitive.fromByteArray(bArr));
    }

    public ASN1Primitive fromImplicitConstructed(ASN1Sequence aSN1Sequence) {
        throw new IllegalStateException("unexpected implicit constructed encoding");
    }

    public ASN1Primitive fromImplicitPrimitive(DEROctetString dEROctetString) {
        throw new IllegalStateException("unexpected implicit primitive encoding");
    }

    public final ASN1Primitive getContextInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        if (128 == aSN1TaggedObject.getTagClass()) {
            return checkedCast(aSN1TaggedObject.getBaseUniversal(z11, this));
        }
        throw new IllegalStateException("this method only valid for CONTEXT_SPECIFIC tags");
    }

    public final ASN1Tag getTag() {
        return this.tag;
    }
}
