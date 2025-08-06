package org.bouncycastle.asn1;

import java.io.IOException;

public class DLSequenceParser implements ASN1SequenceParser {
    private ASN1StreamParser _parser;

    public DLSequenceParser(ASN1StreamParser aSN1StreamParser) {
        this._parser = aSN1StreamParser;
    }

    public ASN1Primitive getLoadedObject() throws IOException {
        return DLFactory.createSequence(this._parser.readVector());
    }

    public ASN1Encodable readObject() throws IOException {
        return this._parser.readObject();
    }

    public ASN1Primitive toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e11) {
            throw new IllegalStateException(e11.getMessage());
        }
    }
}
