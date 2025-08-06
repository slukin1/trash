package org.bouncycastle.asn1;

import java.io.IOException;

public class BERTaggedObjectParser implements ASN1TaggedObjectParser {
    public final ASN1StreamParser _parser;
    public final int _tagClass;
    public final int _tagNo;

    public BERTaggedObjectParser(int i11, int i12, ASN1StreamParser aSN1StreamParser) {
        this._tagClass = i11;
        this._tagNo = i12;
        this._parser = aSN1StreamParser;
    }

    public ASN1Primitive getLoadedObject() throws IOException {
        return this._parser.loadTaggedIL(this._tagClass, this._tagNo);
    }

    public ASN1Encodable getObjectParser(int i11, boolean z11) throws IOException {
        if (128 == getTagClass()) {
            return parseBaseUniversal(z11, i11);
        }
        throw new ASN1Exception("this method only valid for CONTEXT_SPECIFIC tags");
    }

    public int getTagClass() {
        return this._tagClass;
    }

    public int getTagNo() {
        return this._tagNo;
    }

    public boolean hasContextTag(int i11) {
        return this._tagClass == 128 && this._tagNo == i11;
    }

    public boolean hasTag(int i11, int i12) {
        return this._tagClass == i11 && this._tagNo == i12;
    }

    public boolean isConstructed() {
        return true;
    }

    public ASN1Encodable parseBaseUniversal(boolean z11, int i11) throws IOException {
        return z11 ? this._parser.parseObject(i11) : this._parser.parseImplicitConstructedIL(i11);
    }

    public ASN1Encodable parseExplicitBaseObject() throws IOException {
        return this._parser.readObject();
    }

    public ASN1TaggedObjectParser parseExplicitBaseTagged() throws IOException {
        return this._parser.parseTaggedObject();
    }

    public ASN1TaggedObjectParser parseImplicitBaseTagged(int i11, int i12) throws IOException {
        return 64 == i11 ? new BERApplicationSpecificParser(i12, this._parser) : new BERTaggedObjectParser(i11, i12, this._parser);
    }

    public ASN1Primitive toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e11) {
            throw new ASN1ParsingException(e11.getMessage());
        }
    }
}
