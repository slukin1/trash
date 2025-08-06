package org.bouncycastle.asn1;

import java.io.IOException;
import org.bouncycastle.util.Arrays;

public class DLApplicationSpecific extends ASN1ApplicationSpecific {
    public DLApplicationSpecific(int i11, ASN1Encodable aSN1Encodable) throws IOException {
        this(true, i11, aSN1Encodable);
    }

    public DLApplicationSpecific(int i11, ASN1EncodableVector aSN1EncodableVector) {
        super(new DLTaggedObject(false, 64, i11, (ASN1Encodable) DLFactory.createSequence(aSN1EncodableVector)));
    }

    public DLApplicationSpecific(int i11, byte[] bArr) {
        super(new DLTaggedObject(false, 64, i11, (ASN1Encodable) new DEROctetString(Arrays.clone(bArr))));
    }

    public DLApplicationSpecific(ASN1TaggedObject aSN1TaggedObject) {
        super(aSN1TaggedObject);
    }

    public DLApplicationSpecific(boolean z11, int i11, ASN1Encodable aSN1Encodable) throws IOException {
        super(new DLTaggedObject(z11, 64, i11, aSN1Encodable));
    }

    public ASN1Primitive toDLObject() {
        return this;
    }
}
