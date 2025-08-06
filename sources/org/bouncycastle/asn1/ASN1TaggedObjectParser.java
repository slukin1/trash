package org.bouncycastle.asn1;

import java.io.IOException;

public interface ASN1TaggedObjectParser extends ASN1Encodable, InMemoryRepresentable {
    ASN1Encodable getObjectParser(int i11, boolean z11) throws IOException;

    int getTagClass();

    int getTagNo();

    boolean hasContextTag(int i11);

    boolean hasTag(int i11, int i12);

    ASN1Encodable parseBaseUniversal(boolean z11, int i11) throws IOException;

    ASN1Encodable parseExplicitBaseObject() throws IOException;

    ASN1TaggedObjectParser parseExplicitBaseTagged() throws IOException;

    ASN1TaggedObjectParser parseImplicitBaseTagged(int i11, int i12) throws IOException;
}
