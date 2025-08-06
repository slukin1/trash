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

public class SequenceOfRectangularRegion extends ASN1Object {
    private final List<RectangularRegion> rectangularRegions;

    public SequenceOfRectangularRegion(List<RectangularRegion> list) {
        this.rectangularRegions = Collections.unmodifiableList(list);
    }

    private SequenceOfRectangularRegion(ASN1Sequence aSN1Sequence) {
        ArrayList arrayList = new ArrayList();
        Iterator<ASN1Encodable> it2 = aSN1Sequence.iterator();
        while (it2.hasNext()) {
            arrayList.add(RectangularRegion.getInstance(it2.next()));
        }
        this.rectangularRegions = Collections.unmodifiableList(arrayList);
    }

    public static SequenceOfRectangularRegion getInstance(Object obj) {
        if (obj instanceof SequenceOfRectangularRegion) {
            return (SequenceOfRectangularRegion) obj;
        }
        if (obj != null) {
            return new SequenceOfRectangularRegion(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public List<RectangularRegion> getRectangularRegions() {
        return this.rectangularRegions;
    }

    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence((List) this.rectangularRegions);
    }
}
