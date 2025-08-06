package org.bouncycastle.asn1;

import java.io.IOException;

class DLTaggedObjectParser extends BERTaggedObjectParser {
    private final boolean _constructed;

    public DLTaggedObjectParser(int i11, int i12, boolean z11, ASN1StreamParser aSN1StreamParser) {
        super(i11, i12, aSN1StreamParser);
        this._constructed = z11;
    }

    public ASN1Primitive getLoadedObject() throws IOException {
        return this._parser.loadTaggedDL(this._tagClass, this._tagNo, this._constructed);
    }

    public boolean isConstructed() {
        return this._constructed;
    }

    public ASN1Encodable parseBaseUniversal(boolean z11, int i11) throws IOException {
        if (!z11) {
            return this._constructed ? this._parser.parseImplicitConstructedDL(i11) : this._parser.parseImplicitPrimitive(i11);
        }
        if (this._constructed) {
            return this._parser.parseObject(i11);
        }
        throw new IOException("Explicit tags must be constructed (see X.690 8.14.2)");
    }

    public ASN1Encodable parseExplicitBaseObject() throws IOException {
        if (this._constructed) {
            return this._parser.readObject();
        }
        throw new IOException("Explicit tags must be constructed (see X.690 8.14.2)");
    }

    public ASN1TaggedObjectParser parseExplicitBaseTagged() throws IOException {
        if (this._constructed) {
            return this._parser.parseTaggedObject();
        }
        throw new IOException("Explicit tags must be constructed (see X.690 8.14.2)");
    }

    public ASN1TaggedObjectParser parseImplicitBaseTagged(int i11, int i12) throws IOException {
        return 64 == i11 ? (DLApplicationSpecific) this._parser.loadTaggedDL(i11, i12, this._constructed) : new DLTaggedObjectParser(i11, i12, this._constructed, this._parser);
    }
}
