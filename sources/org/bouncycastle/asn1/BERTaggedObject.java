package org.bouncycastle.asn1;

import java.io.IOException;

public class BERTaggedObject extends ASN1TaggedObject {
    public BERTaggedObject(int i11) {
        super(false, i11, new BERSequence());
    }

    public BERTaggedObject(int i11, int i12, int i13, ASN1Encodable aSN1Encodable) {
        super(i11, i12, i13, aSN1Encodable);
    }

    public BERTaggedObject(int i11, int i12, ASN1Encodable aSN1Encodable) {
        super(true, i11, i12, aSN1Encodable);
    }

    public BERTaggedObject(int i11, ASN1Encodable aSN1Encodable) {
        super(true, i11, aSN1Encodable);
    }

    public BERTaggedObject(boolean z11, int i11, int i12, ASN1Encodable aSN1Encodable) {
        super(z11, i11, i12, aSN1Encodable);
    }

    public BERTaggedObject(boolean z11, int i11, ASN1Encodable aSN1Encodable) {
        super(z11, i11, aSN1Encodable);
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
        ASN1Primitive aSN1Primitive = this.obj.toASN1Primitive();
        boolean isExplicit = isExplicit();
        if (z11) {
            int i11 = this.tagClass;
            if (isExplicit || aSN1Primitive.encodeConstructed()) {
                i11 |= 32;
            }
            aSN1OutputStream.writeIdentifier(true, i11, this.tagNo);
        }
        if (isExplicit) {
            aSN1OutputStream.write(128);
            aSN1Primitive.encode(aSN1OutputStream, true);
            aSN1OutputStream.write(0);
            aSN1OutputStream.write(0);
            return;
        }
        aSN1Primitive.encode(aSN1OutputStream, false);
    }

    public boolean encodeConstructed() {
        return isExplicit() || this.obj.toASN1Primitive().encodeConstructed();
    }

    public int encodedLength(boolean z11) throws IOException {
        ASN1Primitive aSN1Primitive = this.obj.toASN1Primitive();
        boolean isExplicit = isExplicit();
        int encodedLength = aSN1Primitive.encodedLength(isExplicit);
        if (isExplicit) {
            encodedLength += 3;
        }
        return encodedLength + (z11 ? ASN1OutputStream.getLengthOfIdentifier(this.tagNo) : 0);
    }

    public String getASN1Encoding() {
        return ASN1Encoding.BER;
    }

    public ASN1Sequence rebuildConstructed(ASN1Primitive aSN1Primitive) {
        return new BERSequence((ASN1Encodable) aSN1Primitive);
    }

    public ASN1TaggedObject replaceTag(int i11, int i12) {
        return new BERTaggedObject(this.explicitness, i11, i12, this.obj);
    }
}
