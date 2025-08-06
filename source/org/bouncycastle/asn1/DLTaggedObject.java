package org.bouncycastle.asn1;

import java.io.IOException;

public class DLTaggedObject extends ASN1TaggedObject {
    public DLTaggedObject(int i11, int i12, int i13, ASN1Encodable aSN1Encodable) {
        super(i11, i12, i13, aSN1Encodable);
    }

    public DLTaggedObject(int i11, int i12, ASN1Encodable aSN1Encodable) {
        super(true, i11, i12, aSN1Encodable);
    }

    public DLTaggedObject(int i11, ASN1Encodable aSN1Encodable) {
        super(true, i11, aSN1Encodable);
    }

    public DLTaggedObject(boolean z11, int i11, int i12, ASN1Encodable aSN1Encodable) {
        super(z11, i11, i12, aSN1Encodable);
    }

    public DLTaggedObject(boolean z11, int i11, ASN1Encodable aSN1Encodable) {
        super(z11, i11, aSN1Encodable);
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
        ASN1Primitive dLObject = this.obj.toASN1Primitive().toDLObject();
        boolean isExplicit = isExplicit();
        if (z11) {
            int i11 = this.tagClass;
            if (isExplicit || dLObject.encodeConstructed()) {
                i11 |= 32;
            }
            aSN1OutputStream.writeIdentifier(true, i11, this.tagNo);
        }
        if (isExplicit) {
            aSN1OutputStream.writeDL(dLObject.encodedLength(true));
        }
        dLObject.encode(aSN1OutputStream.getDLSubStream(), isExplicit);
    }

    public boolean encodeConstructed() {
        return isExplicit() || this.obj.toASN1Primitive().toDLObject().encodeConstructed();
    }

    public int encodedLength(boolean z11) throws IOException {
        ASN1Primitive dLObject = this.obj.toASN1Primitive().toDLObject();
        boolean isExplicit = isExplicit();
        int encodedLength = dLObject.encodedLength(isExplicit);
        if (isExplicit) {
            encodedLength += ASN1OutputStream.getLengthOfDL(encodedLength);
        }
        return encodedLength + (z11 ? ASN1OutputStream.getLengthOfIdentifier(this.tagNo) : 0);
    }

    public String getASN1Encoding() {
        return ASN1Encoding.DL;
    }

    public ASN1Sequence rebuildConstructed(ASN1Primitive aSN1Primitive) {
        return new DLSequence((ASN1Encodable) aSN1Primitive);
    }

    public ASN1TaggedObject replaceTag(int i11, int i12) {
        return new DLTaggedObject(this.explicitness, i11, i12, this.obj);
    }

    public ASN1Primitive toDLObject() {
        return this;
    }
}
