package org.bouncycastle.oer.its.ieee1609dot2.basetypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1OctetString;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class SequenceOfOctetString extends ASN1Object {
    private final List<ASN1OctetString> octetStrings;

    public SequenceOfOctetString(List<ASN1OctetString> list) {
        this.octetStrings = Collections.unmodifiableList(list);
    }

    private SequenceOfOctetString(ASN1Sequence aSN1Sequence) {
        ArrayList arrayList = new ArrayList();
        Iterator<ASN1Encodable> it2 = aSN1Sequence.iterator();
        while (it2.hasNext()) {
            arrayList.add(ASN1OctetString.getInstance(it2.next()));
        }
        this.octetStrings = Collections.unmodifiableList(arrayList);
    }

    public static SequenceOfOctetString getInstance(Object obj) {
        if (obj instanceof SequenceOfOctetString) {
            return (SequenceOfOctetString) obj;
        }
        if (obj != null) {
            return new SequenceOfOctetString(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public List<ASN1OctetString> getOctetStrings() {
        return this.octetStrings;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (int i11 = 0; i11 != this.octetStrings.size(); i11++) {
            aSN1EncodableVector.add(this.octetStrings.get(i11));
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
