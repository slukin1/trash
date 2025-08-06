package org.bouncycastle.asn1;

import java.io.IOException;

public abstract class ASN1ApplicationSpecific extends ASN1TaggedObject implements ASN1ApplicationSpecificParser {
    public final ASN1TaggedObject taggedObject;

    public ASN1ApplicationSpecific(ASN1TaggedObject aSN1TaggedObject) {
        super(aSN1TaggedObject.explicitness, checkTagClass(aSN1TaggedObject.tagClass), aSN1TaggedObject.tagNo, aSN1TaggedObject.obj);
        this.taggedObject = aSN1TaggedObject;
    }

    private static int checkTagClass(int i11) {
        if (64 == i11) {
            return i11;
        }
        throw new IllegalArgumentException();
    }

    public static ASN1ApplicationSpecific getInstance(Object obj) {
        if (obj == null || (obj instanceof ASN1ApplicationSpecific)) {
            return (ASN1ApplicationSpecific) obj;
        }
        if (obj instanceof byte[]) {
            try {
                return getInstance(ASN1Primitive.fromByteArray((byte[]) obj));
            } catch (IOException e11) {
                throw new IllegalArgumentException("Failed to construct object from byte[]: " + e11.getMessage());
            }
        } else {
            throw new IllegalArgumentException("unknown object in getInstance: " + obj.getClass().getName());
        }
    }

    public void encode(ASN1OutputStream aSN1OutputStream, boolean z11) throws IOException {
        this.taggedObject.encode(aSN1OutputStream, z11);
    }

    public boolean encodeConstructed() {
        return this.taggedObject.encodeConstructed();
    }

    public int encodedLength(boolean z11) throws IOException {
        return this.taggedObject.encodedLength(z11);
    }

    public String getASN1Encoding() {
        return this.taggedObject.getASN1Encoding();
    }

    public int getApplicationTag() {
        return this.taggedObject.getTagNo();
    }

    public byte[] getContents() {
        return this.taggedObject.getContents();
    }

    public ASN1Primitive getEnclosedObject() throws IOException {
        return this.taggedObject.getBaseObject().toASN1Primitive();
    }

    public ASN1Primitive getObject(int i11) throws IOException {
        return this.taggedObject.getBaseUniversal(false, i11);
    }

    public ASN1Encodable getObjectParser(int i11, boolean z11) throws IOException {
        throw new ASN1Exception("this method only valid for CONTEXT_SPECIFIC tags");
    }

    public ASN1TaggedObject getTaggedObject() {
        return this.taggedObject;
    }

    public boolean hasApplicationTag(int i11) {
        return this.tagNo == i11;
    }

    public boolean hasContextTag(int i11) {
        return false;
    }

    public boolean isConstructed() {
        return this.taggedObject.isConstructed();
    }

    public ASN1Encodable parseBaseUniversal(boolean z11, int i11) throws IOException {
        return this.taggedObject.parseBaseUniversal(z11, i11);
    }

    public ASN1Encodable parseExplicitBaseObject() throws IOException {
        return this.taggedObject.parseExplicitBaseObject();
    }

    public ASN1TaggedObjectParser parseExplicitBaseTagged() throws IOException {
        return this.taggedObject.parseExplicitBaseTagged();
    }

    public ASN1TaggedObjectParser parseImplicitBaseTagged(int i11, int i12) throws IOException {
        return this.taggedObject.parseImplicitBaseTagged(i11, i12);
    }

    public ASN1Encodable readObject() throws IOException {
        return parseExplicitBaseObject();
    }

    public ASN1Sequence rebuildConstructed(ASN1Primitive aSN1Primitive) {
        return this.taggedObject.rebuildConstructed(aSN1Primitive);
    }

    public ASN1TaggedObject replaceTag(int i11, int i12) {
        return this.taggedObject.replaceTag(i11, i12);
    }

    public ASN1Primitive toDERObject() {
        return new DERApplicationSpecific((ASN1TaggedObject) this.taggedObject.toDERObject());
    }

    public ASN1Primitive toDLObject() {
        return new DLApplicationSpecific((ASN1TaggedObject) this.taggedObject.toDLObject());
    }
}
