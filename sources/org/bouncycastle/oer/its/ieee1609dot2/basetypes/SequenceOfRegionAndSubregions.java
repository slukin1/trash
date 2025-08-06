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

public class SequenceOfRegionAndSubregions extends ASN1Object {
    private final List<RegionAndSubregions> regionAndSubregions;

    public SequenceOfRegionAndSubregions(List<RegionAndSubregions> list) {
        this.regionAndSubregions = Collections.unmodifiableList(list);
    }

    private SequenceOfRegionAndSubregions(ASN1Sequence aSN1Sequence) {
        ArrayList arrayList = new ArrayList();
        Iterator<ASN1Encodable> it2 = aSN1Sequence.iterator();
        while (it2.hasNext()) {
            arrayList.add(RegionAndSubregions.getInstance(it2.next()));
        }
        this.regionAndSubregions = Collections.unmodifiableList(arrayList);
    }

    public static SequenceOfRegionAndSubregions getInstance(Object obj) {
        if (obj instanceof SequenceOfRegionAndSubregions) {
            return (SequenceOfRegionAndSubregions) obj;
        }
        if (obj != null) {
            return new SequenceOfRegionAndSubregions(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public List<RegionAndSubregions> getRegionAndSubregions() {
        return this.regionAndSubregions;
    }

    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence((List) this.regionAndSubregions);
    }
}
