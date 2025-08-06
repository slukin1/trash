package org.bouncycastle.asn1;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Objects;
import org.bouncycastle.util.Arrays;

public abstract class ASN1TaggedObject extends ASN1Primitive implements ASN1TaggedObjectParser {
    private static final int DECLARED_EXPLICIT = 1;
    private static final int DECLARED_IMPLICIT = 2;
    private static final int PARSED_EXPLICIT = 3;
    private static final int PARSED_IMPLICIT = 4;
    public final int explicitness;
    public final ASN1Encodable obj;
    public final int tagClass;
    public final int tagNo;

    public ASN1TaggedObject(int i11, int i12, int i13, ASN1Encodable aSN1Encodable) {
        Objects.requireNonNull(aSN1Encodable, "'obj' cannot be null");
        if (i12 == 0 || (i12 & 192) != i12) {
            throw new IllegalArgumentException("invalid tag class: " + i12);
        }
        this.explicitness = aSN1Encodable instanceof ASN1Choice ? 1 : i11;
        this.tagClass = i12;
        this.tagNo = i13;
        this.obj = aSN1Encodable;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ASN1TaggedObject(boolean z11, int i11, int i12, ASN1Encodable aSN1Encodable) {
        this(z11 ? 1 : 2, i11, i12, aSN1Encodable);
    }

    public ASN1TaggedObject(boolean z11, int i11, ASN1Encodable aSN1Encodable) {
        this(z11, 128, i11, aSN1Encodable);
    }

    private static ASN1TaggedObject checkedCast(ASN1Primitive aSN1Primitive) {
        if (aSN1Primitive instanceof ASN1TaggedObject) {
            return (ASN1TaggedObject) aSN1Primitive;
        }
        throw new IllegalStateException("unexpected object: " + aSN1Primitive.getClass().getName());
    }

    public static ASN1Primitive createConstructedDL(int i11, int i12, ASN1EncodableVector aSN1EncodableVector) {
        DLTaggedObject dLTaggedObject;
        boolean z11 = true;
        if (aSN1EncodableVector.size() != 1) {
            z11 = false;
        }
        if (z11) {
            ASN1Encodable aSN1Encodable = aSN1EncodableVector.get(0);
        } else {
            dLTaggedObject = new DLTaggedObject(4, i11, i12, (ASN1Encodable) DLFactory.createSequence(aSN1EncodableVector));
        }
        return i11 != 64 ? dLTaggedObject : new DLApplicationSpecific(dLTaggedObject);
    }

    public static ASN1Primitive createConstructedIL(int i11, int i12, ASN1EncodableVector aSN1EncodableVector) {
        BERTaggedObject bERTaggedObject;
        boolean z11 = true;
        if (aSN1EncodableVector.size() != 1) {
            z11 = false;
        }
        if (z11) {
            ASN1Encodable aSN1Encodable = aSN1EncodableVector.get(0);
        } else {
            bERTaggedObject = new BERTaggedObject(4, i11, i12, (ASN1Encodable) BERFactory.createSequence(aSN1EncodableVector));
        }
        return i11 != 64 ? bERTaggedObject : new BERApplicationSpecific(bERTaggedObject);
    }

    public static ASN1Primitive createPrimitive(int i11, int i12, byte[] bArr) {
        DLTaggedObject dLTaggedObject = new DLTaggedObject(4, i11, i12, (ASN1Encodable) new DEROctetString(bArr));
        return i11 != 64 ? dLTaggedObject : new DLApplicationSpecific(dLTaggedObject);
    }

    public static ASN1TaggedObject getInstance(Object obj2) {
        if (obj2 == null || (obj2 instanceof ASN1TaggedObject)) {
            return (ASN1TaggedObject) obj2;
        }
        if (obj2 instanceof ASN1Encodable) {
            ASN1Primitive aSN1Primitive = ((ASN1Encodable) obj2).toASN1Primitive();
            if (aSN1Primitive instanceof ASN1TaggedObject) {
                return (ASN1TaggedObject) aSN1Primitive;
            }
        } else if (obj2 instanceof byte[]) {
            try {
                return checkedCast(ASN1Primitive.fromByteArray((byte[]) obj2));
            } catch (IOException e11) {
                throw new IllegalArgumentException("failed to construct tagged object from byte[]: " + e11.getMessage());
            }
        }
        throw new IllegalArgumentException("unknown object in getInstance: " + obj2.getClass().getName());
    }

    public static ASN1TaggedObject getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        if (128 != aSN1TaggedObject.getTagClass()) {
            throw new IllegalStateException("this method only valid for CONTEXT_SPECIFIC tags");
        } else if (z11) {
            return aSN1TaggedObject.getExplicitBaseTagged();
        } else {
            throw new IllegalArgumentException("this method not valid for implicitly tagged tagged objects");
        }
    }

    public final boolean asn1Equals(ASN1Primitive aSN1Primitive) {
        if (!(aSN1Primitive instanceof ASN1TaggedObject)) {
            return false;
        }
        ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Primitive;
        if (this.tagNo != aSN1TaggedObject.tagNo || this.tagClass != aSN1TaggedObject.tagClass) {
            return false;
        }
        if (this.explicitness != aSN1TaggedObject.explicitness && isExplicit() != aSN1TaggedObject.isExplicit()) {
            return false;
        }
        ASN1Primitive aSN1Primitive2 = this.obj.toASN1Primitive();
        ASN1Primitive aSN1Primitive3 = aSN1TaggedObject.obj.toASN1Primitive();
        if (aSN1Primitive2 == aSN1Primitive3) {
            return true;
        }
        if (isExplicit()) {
            return aSN1Primitive2.asn1Equals(aSN1Primitive3);
        }
        try {
            return Arrays.areEqual(getEncoded(), aSN1TaggedObject.getEncoded());
        } catch (IOException unused) {
            return false;
        }
    }

    public abstract String getASN1Encoding();

    public ASN1Object getBaseObject() {
        ASN1Encodable aSN1Encodable = this.obj;
        return aSN1Encodable instanceof ASN1Object ? (ASN1Object) aSN1Encodable : aSN1Encodable.toASN1Primitive();
    }

    public ASN1Primitive getBaseUniversal(boolean z11, int i11) {
        ASN1UniversalType aSN1UniversalType = ASN1UniversalTypes.get(i11);
        if (aSN1UniversalType != null) {
            return getBaseUniversal(z11, aSN1UniversalType);
        }
        throw new IllegalArgumentException("unsupported UNIVERSAL tag number: " + i11);
    }

    public ASN1Primitive getBaseUniversal(boolean z11, ASN1UniversalType aSN1UniversalType) {
        if (z11) {
            if (isExplicit()) {
                return aSN1UniversalType.checkedCast(this.obj.toASN1Primitive());
            }
            throw new IllegalStateException("object explicit - implicit expected.");
        } else if (1 != this.explicitness) {
            ASN1Primitive aSN1Primitive = this.obj.toASN1Primitive();
            int i11 = this.explicitness;
            return i11 != 3 ? i11 != 4 ? aSN1UniversalType.checkedCast(aSN1Primitive) : aSN1Primitive instanceof ASN1Sequence ? aSN1UniversalType.fromImplicitConstructed((ASN1Sequence) aSN1Primitive) : aSN1UniversalType.fromImplicitPrimitive((DEROctetString) aSN1Primitive) : aSN1UniversalType.fromImplicitConstructed(rebuildConstructed(aSN1Primitive));
        } else {
            throw new IllegalStateException("object explicit - implicit expected.");
        }
    }

    public byte[] getContents() {
        try {
            byte[] encoded = this.obj.toASN1Primitive().getEncoded(getASN1Encoding());
            if (isExplicit()) {
                return encoded;
            }
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(encoded);
            ASN1InputStream.readTagNumber(byteArrayInputStream, byteArrayInputStream.read());
            int readLength = ASN1InputStream.readLength(byteArrayInputStream, byteArrayInputStream.available(), false);
            int available = byteArrayInputStream.available();
            int i11 = readLength < 0 ? available - 2 : available;
            if (i11 >= 0) {
                byte[] bArr = new byte[i11];
                System.arraycopy(encoded, encoded.length - available, bArr, 0, i11);
                return bArr;
            }
            throw new ASN1ParsingException("failed to get contents");
        } catch (IOException e11) {
            throw new ASN1ParsingException("failed to get contents", e11);
        }
    }

    public ASN1Object getExplicitBaseObject() {
        if (isExplicit()) {
            ASN1Encodable aSN1Encodable = this.obj;
            return aSN1Encodable instanceof ASN1Object ? (ASN1Object) aSN1Encodable : aSN1Encodable.toASN1Primitive();
        }
        throw new IllegalStateException("object implicit - explicit expected.");
    }

    public ASN1TaggedObject getExplicitBaseTagged() {
        if (isExplicit()) {
            return checkedCast(this.obj.toASN1Primitive());
        }
        throw new IllegalStateException("object implicit - explicit expected.");
    }

    public ASN1TaggedObject getImplicitBaseTagged(int i11, int i12) {
        if (i11 == 0 || (i11 & 192) != i11) {
            throw new IllegalArgumentException("invalid base tag class: " + i11);
        }
        int i13 = this.explicitness;
        if (i13 != 1) {
            return i13 != 2 ? replaceTag(i11, i12) : ASN1Util.checkTag(checkedCast(this.obj.toASN1Primitive()), i11, i12);
        }
        throw new IllegalStateException("object explicit - implicit expected.");
    }

    public final ASN1Primitive getLoadedObject() {
        return this;
    }

    public ASN1Primitive getObject() {
        if (128 == getTagClass()) {
            return this.obj.toASN1Primitive();
        }
        throw new IllegalStateException("this method only valid for CONTEXT_SPECIFIC tags");
    }

    public ASN1Encodable getObjectParser(int i11, boolean z11) throws IOException {
        if (128 == getTagClass()) {
            return parseBaseUniversal(z11, i11);
        }
        throw new ASN1Exception("this method only valid for CONTEXT_SPECIFIC tags");
    }

    public int getTagClass() {
        return this.tagClass;
    }

    public int getTagNo() {
        return this.tagNo;
    }

    public boolean hasContextTag(int i11) {
        return this.tagClass == 128 && this.tagNo == i11;
    }

    public boolean hasTag(int i11, int i12) {
        return this.tagClass == i11 && this.tagNo == i12;
    }

    public int hashCode() {
        return (((this.tagClass * 7919) ^ this.tagNo) ^ (isExplicit() ? 15 : 240)) ^ this.obj.toASN1Primitive().hashCode();
    }

    public boolean isConstructed() {
        return encodeConstructed();
    }

    public boolean isExplicit() {
        int i11 = this.explicitness;
        return i11 == 1 || i11 == 3;
    }

    public boolean isParsed() {
        int i11 = this.explicitness;
        return i11 == 3 || i11 == 4;
    }

    public ASN1Encodable parseBaseUniversal(boolean z11, int i11) throws IOException {
        ASN1Primitive baseUniversal = getBaseUniversal(z11, i11);
        return i11 != 3 ? i11 != 4 ? i11 != 16 ? i11 != 17 ? baseUniversal : ((ASN1Set) baseUniversal).parser() : ((ASN1Sequence) baseUniversal).parser() : ((ASN1OctetString) baseUniversal).parser() : ((ASN1BitString) baseUniversal).parser();
    }

    public ASN1Encodable parseExplicitBaseObject() throws IOException {
        return getExplicitBaseObject();
    }

    public ASN1TaggedObjectParser parseExplicitBaseTagged() throws IOException {
        return getExplicitBaseTagged();
    }

    public ASN1TaggedObjectParser parseImplicitBaseTagged(int i11, int i12) throws IOException {
        return getImplicitBaseTagged(i11, i12);
    }

    public abstract ASN1Sequence rebuildConstructed(ASN1Primitive aSN1Primitive);

    public abstract ASN1TaggedObject replaceTag(int i11, int i12);

    public ASN1Primitive toDERObject() {
        return new DERTaggedObject(this.explicitness, this.tagClass, this.tagNo, this.obj);
    }

    public ASN1Primitive toDLObject() {
        return new DLTaggedObject(this.explicitness, this.tagClass, this.tagNo, this.obj);
    }

    public String toString() {
        return ASN1Util.getTagText(this.tagClass, this.tagNo) + this.obj;
    }
}
