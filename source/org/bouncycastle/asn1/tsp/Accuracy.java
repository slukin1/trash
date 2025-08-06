package org.bouncycastle.asn1.tsp;

import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.ASN1TaggedObject;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.DERTaggedObject;

public class Accuracy extends ASN1Object {
    public static final int MAX_MICROS = 999;
    public static final int MAX_MILLIS = 999;
    public static final int MIN_MICROS = 1;
    public static final int MIN_MILLIS = 1;
    public ASN1Integer micros;
    public ASN1Integer millis;
    public ASN1Integer seconds;

    public Accuracy() {
    }

    public Accuracy(ASN1Integer aSN1Integer, ASN1Integer aSN1Integer2, ASN1Integer aSN1Integer3) {
        int intValueExact;
        int intValueExact2;
        if (aSN1Integer2 != null && ((intValueExact2 = aSN1Integer2.intValueExact()) < 1 || intValueExact2 > 999)) {
            throw new IllegalArgumentException("Invalid millis field : not in (1..999)");
        } else if (aSN1Integer3 == null || ((intValueExact = aSN1Integer3.intValueExact()) >= 1 && intValueExact <= 999)) {
            this.seconds = aSN1Integer;
            this.millis = aSN1Integer2;
            this.micros = aSN1Integer3;
        } else {
            throw new IllegalArgumentException("Invalid micros field : not in (1..999)");
        }
    }

    private Accuracy(ASN1Sequence aSN1Sequence) {
        this.seconds = null;
        this.millis = null;
        this.micros = null;
        for (int i11 = 0; i11 < aSN1Sequence.size(); i11++) {
            if (aSN1Sequence.getObjectAt(i11) instanceof ASN1Integer) {
                this.seconds = (ASN1Integer) aSN1Sequence.getObjectAt(i11);
            } else if (!(aSN1Sequence.getObjectAt(i11) instanceof ASN1TaggedObject)) {
                continue;
            } else {
                ASN1TaggedObject aSN1TaggedObject = (ASN1TaggedObject) aSN1Sequence.getObjectAt(i11);
                int tagNo = aSN1TaggedObject.getTagNo();
                if (tagNo == 0) {
                    ASN1Integer instance = ASN1Integer.getInstance(aSN1TaggedObject, false);
                    this.millis = instance;
                    int intValueExact = instance.intValueExact();
                    if (intValueExact < 1 || intValueExact > 999) {
                        throw new IllegalArgumentException("Invalid millis field : not in (1..999)");
                    }
                } else if (tagNo == 1) {
                    ASN1Integer instance2 = ASN1Integer.getInstance(aSN1TaggedObject, false);
                    this.micros = instance2;
                    int intValueExact2 = instance2.intValueExact();
                    if (intValueExact2 < 1 || intValueExact2 > 999) {
                        throw new IllegalArgumentException("Invalid micros field : not in (1..999)");
                    }
                } else {
                    throw new IllegalArgumentException("Invalid tag number");
                }
            }
        }
    }

    public static Accuracy getInstance(Object obj) {
        if (obj instanceof Accuracy) {
            return (Accuracy) obj;
        }
        if (obj != null) {
            return new Accuracy(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Integer getMicros() {
        return this.micros;
    }

    public ASN1Integer getMillis() {
        return this.millis;
    }

    public ASN1Integer getSeconds() {
        return this.seconds;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(3);
        ASN1Integer aSN1Integer = this.seconds;
        if (aSN1Integer != null) {
            aSN1EncodableVector.add(aSN1Integer);
        }
        ASN1Integer aSN1Integer2 = this.millis;
        if (aSN1Integer2 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 0, (ASN1Encodable) aSN1Integer2));
        }
        ASN1Integer aSN1Integer3 = this.micros;
        if (aSN1Integer3 != null) {
            aSN1EncodableVector.add(new DERTaggedObject(false, 1, (ASN1Encodable) aSN1Integer3));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
