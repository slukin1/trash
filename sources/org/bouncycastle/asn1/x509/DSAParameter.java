package org.bouncycastle.asn1.x509;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class DSAParameter extends ASN1Object {

    /* renamed from: g  reason: collision with root package name */
    public ASN1Integer f59077g;

    /* renamed from: p  reason: collision with root package name */
    public ASN1Integer f59078p;

    /* renamed from: q  reason: collision with root package name */
    public ASN1Integer f59079q;

    public DSAParameter(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3) {
        this.f59078p = new ASN1Integer(bigInteger);
        this.f59079q = new ASN1Integer(bigInteger2);
        this.f59077g = new ASN1Integer(bigInteger3);
    }

    private DSAParameter(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 3) {
            Enumeration objects = aSN1Sequence.getObjects();
            this.f59078p = ASN1Integer.getInstance(objects.nextElement());
            this.f59079q = ASN1Integer.getInstance(objects.nextElement());
            this.f59077g = ASN1Integer.getInstance(objects.nextElement());
            return;
        }
        throw new IllegalArgumentException("Bad sequence size: " + aSN1Sequence.size());
    }

    public static DSAParameter getInstance(Object obj) {
        if (obj instanceof DSAParameter) {
            return (DSAParameter) obj;
        }
        if (obj != null) {
            return new DSAParameter(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public static DSAParameter getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z11));
    }

    public BigInteger getG() {
        return this.f59077g.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f59078p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.f59079q.getPositiveValue();
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.add(this.f59078p);
        aSN1EncodableVector.add(this.f59079q);
        aSN1EncodableVector.add(this.f59077g);
        return new DERSequence(aSN1EncodableVector);
    }
}
