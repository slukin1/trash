package org.bouncycastle.pqc.asn1;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DEROctetString;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.AlgorithmIdentifier;
import org.bouncycastle.pqc.math.linearalgebra.GF2Matrix;

public class McElieceCCA2PublicKey extends ASN1Object {
    private final AlgorithmIdentifier digest;

    /* renamed from: g  reason: collision with root package name */
    private final GF2Matrix f59493g;

    /* renamed from: n  reason: collision with root package name */
    private final int f59494n;

    /* renamed from: t  reason: collision with root package name */
    private final int f59495t;

    public McElieceCCA2PublicKey(int i11, int i12, GF2Matrix gF2Matrix, AlgorithmIdentifier algorithmIdentifier) {
        this.f59494n = i11;
        this.f59495t = i12;
        this.f59493g = new GF2Matrix(gF2Matrix.getEncoded());
        this.digest = algorithmIdentifier;
    }

    private McElieceCCA2PublicKey(ASN1Sequence aSN1Sequence) {
        this.f59494n = ((ASN1Integer) aSN1Sequence.getObjectAt(0)).intValueExact();
        this.f59495t = ((ASN1Integer) aSN1Sequence.getObjectAt(1)).intValueExact();
        this.f59493g = new GF2Matrix(((ASN1OctetString) aSN1Sequence.getObjectAt(2)).getOctets());
        this.digest = AlgorithmIdentifier.getInstance(aSN1Sequence.getObjectAt(3));
    }

    public static McElieceCCA2PublicKey getInstance(Object obj) {
        if (obj instanceof McElieceCCA2PublicKey) {
            return (McElieceCCA2PublicKey) obj;
        }
        if (obj != null) {
            return new McElieceCCA2PublicKey(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public AlgorithmIdentifier getDigest() {
        return this.digest;
    }

    public GF2Matrix getG() {
        return this.f59493g;
    }

    public int getN() {
        return this.f59494n;
    }

    public int getT() {
        return this.f59495t;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(new ASN1Integer((long) this.f59494n));
        aSN1EncodableVector.add(new ASN1Integer((long) this.f59495t));
        aSN1EncodableVector.add(new DEROctetString(this.f59493g.getEncoded()));
        aSN1EncodableVector.add(this.digest);
        return new DERSequence(aSN1EncodableVector);
    }
}
