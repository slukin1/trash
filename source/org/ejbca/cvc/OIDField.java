package org.ejbca.cvc;

import java.io.IOException;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERTaggedObject;

public class OIDField extends AbstractDataField {
    private static final long serialVersionUID = 5212215839749666908L;

    /* renamed from: id  reason: collision with root package name */
    private String f68257id;

    public OIDField() {
        super(CVCTagEnum.OID);
    }

    public boolean equals(Object obj) {
        if (obj instanceof OIDField) {
            return this.f68257id.equals(((OIDField) obj).getValue());
        }
        return false;
    }

    public byte[] getEncoded() {
        try {
            byte[] encoded = new ASN1ObjectIdentifier(this.f68257id).getEncoded();
            int length = encoded.length - 2;
            byte[] bArr = new byte[length];
            System.arraycopy(encoded, 2, bArr, 0, length);
            return bArr;
        } catch (IOException e11) {
            throw new RuntimeException(e11.getMessage());
        }
    }

    public String getValue() {
        return this.f68257id;
    }

    public String toString() {
        return getValue();
    }

    public String valueAsText() {
        return this.f68257id;
    }

    public OIDField(String str) {
        this();
        this.f68257id = str;
    }

    public OIDField(byte[] bArr) {
        this();
        this.f68257id = ASN1ObjectIdentifier.getInstance(new DERTaggedObject(true, 0, (ASN1Encodable) new DEROctetString(bArr)), false).getId();
    }
}
