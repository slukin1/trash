package org.bouncycastle.asn1;

import java.io.IOException;

public class DERApplicationSpecific extends ASN1ApplicationSpecific {
    public DERApplicationSpecific(int i11, ASN1Encodable aSN1Encodable) throws IOException {
        this(true, i11, aSN1Encodable);
    }

    public DERApplicationSpecific(int i11, ASN1EncodableVector aSN1EncodableVector) {
        super(new DERTaggedObject(false, 64, i11, (ASN1Encodable) DERFactory.createSequence(aSN1EncodableVector)));
    }

    public DERApplicationSpecific(int i11, byte[] bArr) {
        super(new DERTaggedObject(false, 64, i11, (ASN1Encodable) new DEROctetString(bArr)));
    }

    public DERApplicationSpecific(ASN1TaggedObject aSN1TaggedObject) {
        super(aSN1TaggedObject);
    }

    public DERApplicationSpecific(boolean z11, int i11, ASN1Encodable aSN1Encodable) throws IOException {
        super(new DERTaggedObject(z11, 64, i11, aSN1Encodable));
    }

    public ASN1Primitive toDERObject() {
        return this;
    }

    public ASN1Primitive toDLObject() {
        return this;
    }
}
