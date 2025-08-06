package org.bouncycastle.asn1.x9;

import java.math.BigInteger;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1ObjectIdentifier;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class X9FieldID extends ASN1Object implements X9ObjectIdentifiers {

    /* renamed from: id  reason: collision with root package name */
    private ASN1ObjectIdentifier f59097id;
    private ASN1Primitive parameters;

    public X9FieldID(int i11, int i12) {
        this(i11, i12, 0, 0);
    }

    public X9FieldID(int i11, int i12, int i13, int i14) {
        this.f59097id = X9ObjectIdentifiers.characteristic_two_field;
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        aSN1EncodableVector.add(new ASN1Integer((long) i11));
        if (i13 == 0) {
            if (i14 == 0) {
                aSN1EncodableVector.add(X9ObjectIdentifiers.tpBasis);
                aSN1EncodableVector.add(new ASN1Integer((long) i12));
            } else {
                throw new IllegalArgumentException("inconsistent k values");
            }
        } else if (i13 <= i12 || i14 <= i13) {
            throw new IllegalArgumentException("inconsistent k values");
        } else {
            aSN1EncodableVector.add(X9ObjectIdentifiers.ppBasis);
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector(3);
            aSN1EncodableVector2.add(new ASN1Integer((long) i12));
            aSN1EncodableVector2.add(new ASN1Integer((long) i13));
            aSN1EncodableVector2.add(new ASN1Integer((long) i14));
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        }
        this.parameters = new DERSequence(aSN1EncodableVector);
    }

    public X9FieldID(BigInteger bigInteger) {
        this.f59097id = X9ObjectIdentifiers.prime_field;
        this.parameters = new ASN1Integer(bigInteger);
    }

    private X9FieldID(ASN1Sequence aSN1Sequence) {
        this.f59097id = ASN1ObjectIdentifier.getInstance(aSN1Sequence.getObjectAt(0));
        this.parameters = aSN1Sequence.getObjectAt(1).toASN1Primitive();
    }

    public static X9FieldID getInstance(Object obj) {
        if (obj instanceof X9FieldID) {
            return (X9FieldID) obj;
        }
        if (obj != null) {
            return new X9FieldID(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1ObjectIdentifier getIdentifier() {
        return this.f59097id;
    }

    public ASN1Primitive getParameters() {
        return this.parameters;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(2);
        aSN1EncodableVector.add(this.f59097id);
        aSN1EncodableVector.add(this.parameters);
        return new DERSequence(aSN1EncodableVector);
    }
}
