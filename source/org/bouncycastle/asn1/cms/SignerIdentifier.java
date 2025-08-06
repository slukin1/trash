package org.bouncycastle.asn1.cms;

import org.bouncycastle.asn1.ASN1Choice;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERTaggedObject;

public class SignerIdentifier extends ASN1Object implements ASN1Choice {

    /* renamed from: id  reason: collision with root package name */
    private ASN1Encodable f59038id;

    public SignerIdentifier(ASN1OctetString aSN1OctetString) {
        this.f59038id = new DERTaggedObject(false, 0, (ASN1Encodable) aSN1OctetString);
    }

    public SignerIdentifier(ASN1Primitive aSN1Primitive) {
        this.f59038id = aSN1Primitive;
    }

    public SignerIdentifier(IssuerAndSerialNumber issuerAndSerialNumber) {
        this.f59038id = issuerAndSerialNumber;
    }

    public static SignerIdentifier getInstance(Object obj) {
        if (obj == null || (obj instanceof SignerIdentifier)) {
            return (SignerIdentifier) obj;
        }
        if (obj instanceof IssuerAndSerialNumber) {
            return new SignerIdentifier((IssuerAndSerialNumber) obj);
        }
        if (obj instanceof ASN1OctetString) {
            return new SignerIdentifier((ASN1OctetString) obj);
        }
        if (obj instanceof ASN1Primitive) {
            return new SignerIdentifier((ASN1Primitive) obj);
        }
        throw new IllegalArgumentException("Illegal object in SignerIdentifier: " + obj.getClass().getName());
    }

    public ASN1Encodable getId() {
        ASN1Encodable aSN1Encodable = this.f59038id;
        return aSN1Encodable instanceof ASN1TaggedObject ? ASN1OctetString.getInstance((ASN1TaggedObject) aSN1Encodable, false) : aSN1Encodable;
    }

    public boolean isTagged() {
        return this.f59038id instanceof ASN1TaggedObject;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.f59038id.toASN1Primitive();
    }
}
