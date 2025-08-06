package org.bouncycastle.oer.its.ieee1609dot2.basetypes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.oer.its.ItsUtils;

public class SequenceOfIdentifiedRegion extends ASN1Object {
    private final List<IdentifiedRegion> identifiedRegions;

    public SequenceOfIdentifiedRegion(List<IdentifiedRegion> list) {
        this.identifiedRegions = Collections.unmodifiableList(list);
    }

    private SequenceOfIdentifiedRegion(ASN1Sequence aSN1Sequence) {
        ArrayList arrayList = new ArrayList();
        Iterator<ASN1Encodable> it2 = aSN1Sequence.iterator();
        while (it2.hasNext()) {
            arrayList.add(IdentifiedRegion.getInstance(it2.next()));
        }
        this.identifiedRegions = Collections.unmodifiableList(arrayList);
    }

    public static SequenceOfIdentifiedRegion getInstance(Object obj) {
        if (obj instanceof SequenceOfIdentifiedRegion) {
            return (SequenceOfIdentifiedRegion) obj;
        }
        if (obj != null) {
            return new SequenceOfIdentifiedRegion(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public List<IdentifiedRegion> getIdentifiedRegions() {
        return this.identifiedRegions;
    }

    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence((List) this.identifiedRegions);
    }
}
