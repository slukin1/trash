package org.bouncycastle.asn1.oiw;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class ElGamalParameter extends ASN1Object {

    /* renamed from: g  reason: collision with root package name */
    public ASN1Integer f59052g;

    /* renamed from: p  reason: collision with root package name */
    public ASN1Integer f59053p;

    public ElGamalParameter(BigInteger bigInteger, BigInteger bigInteger2) {
        this.f59053p = new ASN1Integer(bigInteger);
        this.f59052g = new ASN1Integer(bigInteger2);
    }

    private ElGamalParameter(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f59053p = (ASN1Integer) objects.nextElement();
        this.f59052g = (ASN1Integer) objects.nextElement();
    }

    public static ElGamalParameter getInstance(Object obj) {
        if (obj instanceof ElGamalParameter) {
            return (ElGamalParameter) obj;
        }
        if (obj != null) {
            return new ElGamalParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public BigInteger getG() {
        return this.f59052g.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f59053p.getPositiveValue();
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(this.f59053p);
        aSN1EncodableVector.add(this.f59052g);
        return new DERSequence(aSN1EncodableVector);
    }
}
