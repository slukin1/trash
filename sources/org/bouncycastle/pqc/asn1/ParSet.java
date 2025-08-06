package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.util.Arrays;

public class ParSet extends ASN1Object {

    /* renamed from: h  reason: collision with root package name */
    private int[] f59501h;

    /* renamed from: k  reason: collision with root package name */
    private int[] f59502k;

    /* renamed from: t  reason: collision with root package name */
    private int f59503t;

    /* renamed from: w  reason: collision with root package name */
    private int[] f59504w;

    public ParSet(int i11, int[] iArr, int[] iArr2, int[] iArr3) {
        this.f59503t = i11;
        this.f59501h = iArr;
        this.f59504w = iArr2;
        this.f59502k = iArr3;
    }

    private ParSet(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 4) {
            this.f59503t = checkBigIntegerInIntRangeAndPositive(aSN1Sequence.getObjectAt(0));
            ASN1Sequence aSN1Sequence2 = (ASN1Sequence) aSN1Sequence.getObjectAt(1);
            ASN1Sequence aSN1Sequence3 = (ASN1Sequence) aSN1Sequence.getObjectAt(2);
            ASN1Sequence aSN1Sequence4 = (ASN1Sequence) aSN1Sequence.getObjectAt(3);
            if (aSN1Sequence2.size() == this.f59503t && aSN1Sequence3.size() == this.f59503t && aSN1Sequence4.size() == this.f59503t) {
                this.f59501h = new int[aSN1Sequence2.size()];
                this.f59504w = new int[aSN1Sequence3.size()];
                this.f59502k = new int[aSN1Sequence4.size()];
                for (int i11 = 0; i11 < this.f59503t; i11++) {
                    this.f59501h[i11] = checkBigIntegerInIntRangeAndPositive(aSN1Sequence2.getObjectAt(i11));
                    this.f59504w[i11] = checkBigIntegerInIntRangeAndPositive(aSN1Sequence3.getObjectAt(i11));
                    this.f59502k[i11] = checkBigIntegerInIntRangeAndPositive(aSN1Sequence4.getObjectAt(i11));
                }
                return;
            }
            throw new IllegalArgumentException("invalid size of sequences");
        }
        throw new IllegalArgumentException("sie of seqOfParams = " + aSN1Sequence.size());
    }

    private static int checkBigIntegerInIntRangeAndPositive(ASN1Encodable aSN1Encodable) {
        int intValueExact = ((ASN1Integer) aSN1Encodable).intValueExact();
        if (intValueExact > 0) {
            return intValueExact;
        }
        throw new IllegalArgumentException("BigInteger not in Range: " + intValueExact);
    }

    public static ParSet getInstance(Object obj) {
        if (obj instanceof ParSet) {
            return (ParSet) obj;
        }
        if (obj != null) {
            return new ParSet(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public int[] getH() {
        return Arrays.clone(this.f59501h);
    }

    public int[] getK() {
        return Arrays.clone(this.f59502k);
    }

    public int getT() {
        return this.f59503t;
    }

    public int[] getW() {
        return Arrays.clone(this.f59504w);
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector();
        ASN1EncodableVector aSN1EncodableVector3 = new ASN1EncodableVector();
        for (int i11 = 0; i11 < this.f59501h.length; i11++) {
            aSN1EncodableVector.add(new ASN1Integer((long) this.f59501h[i11]));
            aSN1EncodableVector2.add(new ASN1Integer((long) this.f59504w[i11]));
            aSN1EncodableVector3.add(new ASN1Integer((long) this.f59502k[i11]));
        }
        ASN1EncodableVector aSN1EncodableVector4 = new ASN1EncodableVector();
        aSN1EncodableVector4.add(new ASN1Integer((long) this.f59503t));
        aSN1EncodableVector4.add(new DERSequence(aSN1EncodableVector));
        aSN1EncodableVector4.add(new DERSequence(aSN1EncodableVector2));
        aSN1EncodableVector4.add(new DERSequence(aSN1EncodableVector3));
        return new DERSequence(aSN1EncodableVector4);
    }
}
