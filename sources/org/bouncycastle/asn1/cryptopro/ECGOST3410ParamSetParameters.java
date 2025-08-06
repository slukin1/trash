package org.bouncycastle.asn1.cryptopro;

import java.math.BigInteger;
import java.util.Enumeration;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;

public class ECGOST3410ParamSetParameters extends ASN1Object {

    /* renamed from: a  reason: collision with root package name */
    public ASN1Integer f59039a;

    /* renamed from: b  reason: collision with root package name */
    public ASN1Integer f59040b;

    /* renamed from: p  reason: collision with root package name */
    public ASN1Integer f59041p;

    /* renamed from: q  reason: collision with root package name */
    public ASN1Integer f59042q;

    /* renamed from: x  reason: collision with root package name */
    public ASN1Integer f59043x;

    /* renamed from: y  reason: collision with root package name */
    public ASN1Integer f59044y;

    public ECGOST3410ParamSetParameters(BigInteger bigInteger, BigInteger bigInteger2, BigInteger bigInteger3, BigInteger bigInteger4, int i11, BigInteger bigInteger5) {
        this.f59039a = new ASN1Integer(bigInteger);
        this.f59040b = new ASN1Integer(bigInteger2);
        this.f59041p = new ASN1Integer(bigInteger3);
        this.f59042q = new ASN1Integer(bigInteger4);
        this.f59043x = new ASN1Integer((long) i11);
        this.f59044y = new ASN1Integer(bigInteger5);
    }

    public ECGOST3410ParamSetParameters(ASN1Sequence aSN1Sequence) {
        Enumeration objects = aSN1Sequence.getObjects();
        this.f59039a = (ASN1Integer) objects.nextElement();
        this.f59040b = (ASN1Integer) objects.nextElement();
        this.f59041p = (ASN1Integer) objects.nextElement();
        this.f59042q = (ASN1Integer) objects.nextElement();
        this.f59043x = (ASN1Integer) objects.nextElement();
        this.f59044y = (ASN1Integer) objects.nextElement();
    }

    public static ECGOST3410ParamSetParameters getInstance(Object obj) {
        if (obj == null || (obj instanceof ECGOST3410ParamSetParameters)) {
            return (ECGOST3410ParamSetParameters) obj;
        }
        if (obj instanceof ASN1Sequence) {
            return new ECGOST3410ParamSetParameters((ASN1Sequence) obj);
        }
        throw new IllegalArgumentException("Invalid GOST3410Parameter: " + obj.getClass().getName());
    }

    public static ECGOST3410ParamSetParameters getInstance(ASN1TaggedObject aSN1TaggedObject, boolean z11) {
        return getInstance(ASN1Sequence.getInstance(aSN1TaggedObject, z11));
    }

    public BigInteger getA() {
        return this.f59039a.getPositiveValue();
    }

    public BigInteger getP() {
        return this.f59041p.getPositiveValue();
    }

    public BigInteger getQ() {
        return this.f59042q.getPositiveValue();
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(6);
        aSN1EncodableVector.add(this.f59039a);
        aSN1EncodableVector.add(this.f59040b);
        aSN1EncodableVector.add(this.f59041p);
        aSN1EncodableVector.add(this.f59042q);
        aSN1EncodableVector.add(this.f59043x);
        aSN1EncodableVector.add(this.f59044y);
        return new DERSequence(aSN1EncodableVector);
    }
}
