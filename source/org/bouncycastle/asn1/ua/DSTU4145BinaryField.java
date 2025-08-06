package org.bouncycastle.asn1.ua;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class DSTU4145BinaryField extends ASN1Object {

    /* renamed from: j  reason: collision with root package name */
    private int f59059j;

    /* renamed from: k  reason: collision with root package name */
    private int f59060k;

    /* renamed from: l  reason: collision with root package name */
    private int f59061l;

    /* renamed from: m  reason: collision with root package name */
    private int f59062m;

    public DSTU4145BinaryField(int i11, int i12) {
        this(i11, i12, 0, 0);
    }

    public DSTU4145BinaryField(int i11, int i12, int i13, int i14) {
        this.f59062m = i11;
        this.f59060k = i12;
        this.f59059j = i13;
        this.f59061l = i14;
    }

    private DSTU4145BinaryField(ASN1Sequence aSN1Sequence) {
        this.f59062m = ASN1Integer.getInstance(aSN1Sequence.getObjectAt(0)).intPositiveValueExact();
        if (aSN1Sequence.getObjectAt(1) instanceof ASN1Integer) {
            this.f59060k = ((ASN1Integer) aSN1Sequence.getObjectAt(1)).intPositiveValueExact();
        } else if (aSN1Sequence.getObjectAt(1) instanceof ASN1Sequence) {
            ASN1Sequence instance = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1));
            this.f59060k = ASN1Integer.getInstance(instance.getObjectAt(0)).intPositiveValueExact();
            this.f59059j = ASN1Integer.getInstance(instance.getObjectAt(1)).intPositiveValueExact();
            this.f59061l = ASN1Integer.getInstance(instance.getObjectAt(2)).intPositiveValueExact();
        } else {
            throw new IllegalArgumentException("object parse error");
        }
    }

    public static DSTU4145BinaryField getInstance(Object obj) {
        if (obj instanceof DSTU4145BinaryField) {
            return (DSTU4145BinaryField) obj;
        }
        if (obj != null) {
            return new DSTU4145BinaryField(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public int getK1() {
        return this.f59060k;
    }

    public int getK2() {
        return this.f59059j;
    }

    public int getK3() {
        return this.f59061l;
    }

    public int getM() {
        return this.f59062m;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(new ASN1Integer((long) this.f59062m));
        if (this.f59059j == 0) {
            aSN1EncodableVector.add(new ASN1Integer((long) this.f59060k));
        } else {
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector(3);
            aSN1EncodableVector2.add(new ASN1Integer((long) this.f59060k));
            aSN1EncodableVector2.add(new ASN1Integer((long) this.f59059j));
            aSN1EncodableVector2.add(new ASN1Integer((long) this.f59061l));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
