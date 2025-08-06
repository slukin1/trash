package org.bouncycastle.asn1;

import java.io.IOException;

public class BERApplicationSpecificParser extends BERTaggedObjectParser implements ASN1ApplicationSpecificParser {
    public BERApplicationSpecificParser(int i11, ASN1StreamParser aSN1StreamParser) {
        super(64, i11, aSN1StreamParser);
    }

    public ASN1Encodable readObject() throws IOException {
        return parseExplicitBaseObject();
    }
}
