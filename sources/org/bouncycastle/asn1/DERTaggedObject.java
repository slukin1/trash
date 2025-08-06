package org.bouncycastle.asn1;

import java.io.IOException;

public class DERTaggedObject extends ASN1TaggedObject {
    public DERTaggedObject(int i11, int i12, int i13, ASN1Encodable aSN1Encodable) {
        super(i11, i12, i13, aSN1Encodable);
    }

    public DERTaggedObject(int i11, int i12, ASN1Encodable aSN1Encodable) {
        super(true, i11, i12, aSN1Encodable);
    }

    public DERTaggedObject(int i11, ASN1Encodable aSN1Encodable) {
        super(true, i11, aSN1Encodable);
    }

    public DERTaggedObject(boolean z11, int i11, int i12, ASN1Encodable aSN1Encodable) {
        super(z11, i11, i12, aSN1Encodable);
    }

    public DERTaggedObject(boolean z11, int i11, ASN1Encodable aSN1Encodable) {
        super(z11, i11, aSN1Encodable);
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
        ASN1Primitive dERObject = this.obj.toASN1Primitive().toDERObject();
        boolean isExplicit = isExplicit();
        if (z11) {
            int i11 = this.tagClass;
            if (isExplicit || dERObject.encodeConstructed()) {
                i11 |= 32;
            }
            aSN1OutputStream.writeIdentifier(true, i11, this.tagNo);
        }
        if (isExplicit) {
            aSN1OutputStream.writeDL(dERObject.encodedLength(true));
        }
        dERObject.encode(aSN1OutputStream.getDERSubStream(), isExplicit);
    }

    public boolean encodeConstructed() {
        return isExplicit() || this.obj.toASN1Primitive().toDERObject().encodeConstructed();
    }

    public int encodedLength(boolean z11) throws IOException {
        ASN1Primitive dERObject = this.obj.toASN1Primitive().toDERObject();
        boolean isExplicit = isExplicit();
        int encodedLength = dERObject.encodedLength(isExplicit);
        if (isExplicit) {
            encodedLength += ASN1OutputStream.getLengthOfDL(encodedLength);
        }
        return encodedLength + (z11 ? ASN1OutputStream.getLengthOfIdentifier(this.tagNo) : 0);
    }

    public String getASN1Encoding() {
        return ASN1Encoding.DER;
    }

    public ASN1Sequence rebuildConstructed(ASN1Primitive aSN1Primitive) {
        return new DERSequence((ASN1Encodable) aSN1Primitive);
    }

    public ASN1TaggedObject replaceTag(int i11, int i12) {
        return new DERTaggedObject(this.explicitness, i11, i12, this.obj);
    }

    public ASN1Primitive toDERObject() {
        return this;
    }

    public ASN1Primitive toDLObject() {
        return this;
    }
}
