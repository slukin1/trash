package org.bouncycastle.asn1.x9;

import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.math.ec.ECFieldElement;

public class X9FieldElement extends ASN1Object {
    private static X9IntegerConverter converter = new X9IntegerConverter();

    /* renamed from: f  reason: collision with root package name */
    public ECFieldElement f59096f;

    public X9FieldElement(ECFieldElement eCFieldElement) {
        this.f59096f = eCFieldElement;
    }

    public ECFieldElement getValue() {
        return this.f59096f;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DEROctetString(converter.integerToBytes(this.f59096f.toBigInteger(), converter.getByteLength(this.f59096f)));
    }
}
