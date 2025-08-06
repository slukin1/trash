package org.bouncycastle.asn1;

import java.io.IOException;

public class DERExternalParser implements ASN1ExternalParser {
    private ASN1StreamParser _parser;

    public DERExternalParser(ASN1StreamParser aSN1StreamParser) {
        this._parser = aSN1StreamParser;
    }

    public static DLExternal parse(ASN1StreamParser aSN1StreamParser) throws IOException {
        try {
            return new DLExternal(aSN1StreamParser.readVector());
        } catch (IllegalArgumentException e11) {
            throw new ASN1Exception(e11.getMessage(), e11);
        }
    }

    public ASN1Primitive getLoadedObject() throws IOException {
        return parse(this._parser);
    }

    public ASN1Encodable readObject() throws IOException {
        return this._parser.readObject();
    }

    public ASN1Primitive toASN1Primitive() {
        try {
            return getLoadedObject();
        } catch (IOException e11) {
            throw new ASN1ParsingException("unable to get DER object", e11);
        } catch (IllegalArgumentException e12) {
            throw new ASN1ParsingException("unable to get DER object", e12);
        }
    }
}
