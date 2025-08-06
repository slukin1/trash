package org.bouncycastle.asn1.x509;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1PrintableString;
import org.bouncycastle.util.encoders.Hex;

public abstract class X509NameEntryConverter {
    public boolean canBePrintable(String str) {
        return ASN1PrintableString.isPrintableString(str);
    }

    public ASN1Primitive convertHexEncoded(String str, int i11) throws IOException {
        return ASN1Primitive.fromByteArray(Hex.decodeStrict(str, i11, str.length() - i11));
    }

    public abstract ASN1Primitive getConvertedValue(ASN1ObjectIdentifier aSN1ObjectIdentifier, String str);
}
