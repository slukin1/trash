package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;
import org.bouncycastle.asn1.x509.Time;

public class CRLStatus extends ASN1Object {
    private final CRLSource source;
    private final Time time;

    private CRLStatus(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 1 || aSN1Sequence.size() == 2) {
            this.source = CRLSource.getInstance(aSN1Sequence.getObjectAt(0));
            this.time = aSN1Sequence.size() == 2 ? Time.getInstance(aSN1Sequence.getObjectAt(1)) : null;
            return;
        }
        throw new IllegalArgumentException("expected sequence size of 1 or 2, got " + aSN1Sequence.size());
    }

    public CRLStatus(CRLSource cRLSource, Time time2) {
        this.source = cRLSource;
        this.time = time2;
    }

    public static CRLStatus getInstance(Object obj) {
        if (obj instanceof CRLStatus) {
            return (CRLStatus) obj;
        }
        if (obj != null) {
            return new CRLStatus(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public CRLSource getSource() {
        return this.source;
    }

    public Time getTime() {
        return this.time;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        aSN1EncodableVector.add(this.source);
        Time time2 = this.time;
        if (time2 != null) {
            aSN1EncodableVector.add(time2);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
