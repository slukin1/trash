package org.bouncycastle.asn1;

import java.io.IOException;

public class BERApplicationSpecific extends ASN1ApplicationSpecific {
    public BERApplicationSpecific(int i11, ASN1Encodable aSN1Encodable) throws IOException {
        this(true, i11, aSN1Encodable);
    }

    public BERApplicationSpecific(int i11, ASN1EncodableVector aSN1EncodableVector) {
        super(new BERTaggedObject(false, 64, i11, (ASN1Encodable) BERFactory.createSequence(aSN1EncodableVector)));
    }

    public BERApplicationSpecific(ASN1TaggedObject aSN1TaggedObject) {
        super(aSN1TaggedObject);
    }

    public BERApplicationSpecific(boolean z11, int i11, ASN1Encodable aSN1Encodable) throws IOException {
        super(new BERTaggedObject(z11, 64, i11, aSN1Encodable));
    }
}
