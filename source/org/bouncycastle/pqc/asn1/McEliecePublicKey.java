package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

public class McEliecePublicKey extends ASN1Object {

    /* renamed from: g  reason: collision with root package name */
    private final GF2Matrix f59498g;

    /* renamed from: n  reason: collision with root package name */
    private final int f59499n;

    /* renamed from: t  reason: collision with root package name */
    private final int f59500t;

    public McEliecePublicKey(int i11, int i12, GF2Matrix gF2Matrix) {
        this.f59499n = i11;
        this.f59500t = i12;
        this.f59498g = new GF2Matrix(gF2Matrix);
    }

    private McEliecePublicKey(ASN1Sequence aSN1Sequence) {
        this.f59499n = ((ASN1Integer) aSN1Sequence.getObjectAt(0)).intValueExact();
        this.f59500t = ((ASN1Integer) aSN1Sequence.getObjectAt(1)).intValueExact();
        this.f59498g = new GF2Matrix(((ASN1OctetString) aSN1Sequence.getObjectAt(2)).getOctets());
    }

    public static McEliecePublicKey getInstance(Object obj) {
        if (obj instanceof McEliecePublicKey) {
            return (McEliecePublicKey) obj;
        }
        if (obj != null) {
            return new McEliecePublicKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public GF2Matrix getG() {
        return new GF2Matrix(this.f59498g);
    }

    public int getN() {
        return this.f59499n;
    }

    public int getT() {
        return this.f59500t;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer((long) this.f59499n));
        aSN1EncodableVector.add(new ASN1Integer((long) this.f59500t));
        aSN1EncodableVector.add(new DEROctetString(this.f59498g.getEncoded()));
        return new DERSequence(aSN1EncodableVector);
    }
}
