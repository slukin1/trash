package org.bouncycastle.oer.its.ieee1609dot2.basetypes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1EncodableVector;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class SequenceOfPsidSspRange extends ASN1Object {
    private final List<PsidSspRange> psidSspRanges;

    public static class Builder {
        private final ArrayList<PsidSspRange> psidSspRanges = new ArrayList<>();

        public Builder add(PsidSspRange... psidSspRangeArr) {
            this.psidSspRanges.addAll(Arrays.asList(psidSspRangeArr));
            return this;
        }

        public SequenceOfPsidSspRange build() {
            return new SequenceOfPsidSspRange((List<PsidSspRange>) this.psidSspRanges);
        }
    }

    public SequenceOfPsidSspRange(List<PsidSspRange> list) {
        this.psidSspRanges = Collections.unmodifiableList(list);
    }

    private SequenceOfPsidSspRange(ASN1Sequence aSN1Sequence) {
        ArrayList arrayList = new ArrayList();
        Iterator<ASN1Encodable> it2 = aSN1Sequence.iterator();
        while (it2.hasNext()) {
            arrayList.add(PsidSspRange.getInstance(it2.next()));
        }
        this.psidSspRanges = Collections.unmodifiableList(arrayList);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static SequenceOfPsidSspRange getInstance(Object obj) {
        if (obj instanceof SequenceOfPsidSspRange) {
            return (SequenceOfPsidSspRange) obj;
        }
        if (obj != null) {
            return new SequenceOfPsidSspRange(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public List<PsidSspRange> getPsidSspRanges() {
        return this.psidSspRanges;
    }

    public ASN1Primitive toASN1Primitive() {
        ASN1EncodableVector aSN1EncodableVector = new ASN1EncodableVector();
        for (PsidSspRange add : this.psidSspRanges) {
            aSN1EncodableVector.add(add);
        }
        return new DERSequence(aSN1EncodableVector);
    }
}
