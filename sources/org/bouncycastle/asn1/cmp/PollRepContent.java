package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class PollRepContent extends ASN1Object {
    private final ASN1Integer[] certReqId;
    private final ASN1Integer[] checkAfter;
    private final PKIFreeText[] reason;

    public PollRepContent(ASN1Integer aSN1Integer, ASN1Integer aSN1Integer2) {
        this(aSN1Integer, aSN1Integer2, (PKIFreeText) null);
    }

    public PollRepContent(ASN1Integer aSN1Integer, ASN1Integer aSN1Integer2, PKIFreeText pKIFreeText) {
        ASN1Integer[] aSN1IntegerArr = new ASN1Integer[1];
        this.certReqId = aSN1IntegerArr;
        ASN1Integer[] aSN1IntegerArr2 = new ASN1Integer[1];
        this.checkAfter = aSN1IntegerArr2;
        PKIFreeText[] pKIFreeTextArr = new PKIFreeText[1];
        this.reason = pKIFreeTextArr;
        aSN1IntegerArr[0] = aSN1Integer;
        aSN1IntegerArr2[0] = aSN1Integer2;
        pKIFreeTextArr[0] = pKIFreeText;
    }

    private PollRepContent(ASN1Sequence aSN1Sequence) {
        this.certReqId = new ASN1Integer[aSN1Sequence.size()];
        this.checkAfter = new ASN1Integer[aSN1Sequence.size()];
        this.reason = new PKIFreeText[aSN1Sequence.size()];
        for (int i11 = 0; i11 != aSN1Sequence.size(); i11++) {
            ASN1Sequence instance = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(i11));
            this.certReqId[i11] = ASN1Integer.getInstance(instance.getObjectAt(0));
            this.checkAfter[i11] = ASN1Integer.getInstance(instance.getObjectAt(1));
            if (instance.size() > 2) {
                this.reason[i11] = PKIFreeText.getInstance(instance.getObjectAt(2));
            }
        }
    }

    public static PollRepContent getInstance(Object obj) {
        if (obj instanceof PollRepContent) {
            return (PollRepContent) obj;
        }
        if (obj != null) {
            return new PollRepContent(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Integer getCertReqId(int i11) {
        return this.certReqId[i11];
    }

    public ASN1Integer getCheckAfter(int i11) {
        return this.checkAfter[i11];
    }

    public PKIFreeText getReason(int i11) {
        return this.reason[i11];
    }

    public int size() {
        return this.certReqId.length;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector(this.certReqId.length);
        for (int i11 = 0; i11 != this.certReqId.length; i11++) {
            ASN1EncodableVector aSN1EncodableVector2 = new ASN1EncodableVector(3);
            aSN1EncodableVector2.add(this.certReqId[i11]);
            aSN1EncodableVector2.add(this.checkAfter[i11]);
            PKIFreeText[] pKIFreeTextArr = this.reason;
            if (pKIFreeTextArr[i11] != null) {
                aSN1EncodableVector2.add(pKIFreeTextArr[i11]);
            }
            aSN1EncodableVector.add(new DERSequence(aSN1EncodableVector2));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
