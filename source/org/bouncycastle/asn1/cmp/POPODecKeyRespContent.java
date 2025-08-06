package org.bouncycastle.asn1.cmp;

import org.bouncycastle.asn1.ASN1Integer;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;

public class POPODecKeyRespContent extends ASN1Object {
    private final ASN1Sequence content;

    private POPODecKeyRespContent(ASN1Sequence aSN1Sequence) {
        this.content = aSN1Sequence;
    }

    public static POPODecKeyRespContent getInstance(Object obj) {
        if (obj instanceof POPODecKeyRespContent) {
            return (POPODecKeyRespContent) obj;
        }
        if (obj != null) {
            return new POPODecKeyRespContent(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public ASN1Integer[] toASN1IntegerArray() {
        int size = this.content.size();
        ASN1Integer[] aSN1IntegerArr = new ASN1Integer[size];
        for (int i11 = 0; i11 != size; i11++) {
            aSN1IntegerArr[i11] = ASN1Integer.getInstance(this.content.getObjectAt(i11));
        }
        return aSN1IntegerArr;
    }

    public ASN1Primitive toASN1Primitive() {
        return this.content;
    }
}
