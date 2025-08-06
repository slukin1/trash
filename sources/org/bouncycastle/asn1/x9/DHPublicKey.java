package org.bouncycastle.asn1.x9;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1TaggedObject;

public class DHPublicKey extends ASN1Object {

    /* renamed from: y  reason: collision with root package name */
    private ASN1Integer f59086y;

    public DHPublicKey(BigInteger bigInteger) {
        if (bigInteger != null) {
            this.f59086y = new ASN1Integer(bigInteger);
            return;
        }
        throw new IllegalArgumentException("'y' cannot be null");
    }

    private DHPublicKey(ASN1Integer aSN1Integer) {
        if (aSN1Integer != null) {
            this.f59086y = aSN1Integer;
            return;
        }
        throw new IllegalArgumentException("'y' cannot be null");
    }

    public static DHPublicKey getInstance(Object obj) {
        if (obj == null || (obj instanceof DHPublicKey)) {
            return (DHPublicKey) obj;
        }
        if (obj instanceof ASN1Integer) {
            return new DHPublicKey((ASN1Integer) obj);
        }
        throw new IllegalArgumentException("Invalid DHPublicKey: " + obj.getClass().getName());
    }

    public static DHPublicKey getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        return getInstance(ASN1Integer.getInstance(aSN1TaggedObject, z11));
    }

    public BigInteger getY() {
        return this.f59086y.getPositiveValue();
    }

    public ASN1Primitive toASN1Primitive() {
        return this.f59086y;
    }
}
