package org.bouncycastle.oer.its.etsi102941;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.asn1.DERSequence;

public class SequenceOfCrlEntry extends ASN1Object {
    private final List<CrlEntry> crlEntries;

    public static class Builder {
        private final List<CrlEntry> items = new ArrayList();

        public Builder addCrlEntry(CrlEntry... crlEntryArr) {
            this.items.addAll(Arrays.asList(crlEntryArr));
            return this;
        }

        public SequenceOfCrlEntry build() {
            return new SequenceOfCrlEntry(this.items);
        }
    }

    public SequenceOfCrlEntry(List<CrlEntry> list) {
        this.crlEntries = Collections.unmodifiableList(list);
    }

    private SequenceOfCrlEntry(ASN1Sequence aSN1Sequence) {
        ArrayList arrayList = new ArrayList();
        Iterator<ASN1Encodable> it2 = aSN1Sequence.iterator();
        while (it2.hasNext()) {
            arrayList.add(CrlEntry.getInstance(it2.next()));
        }
        this.crlEntries = Collections.unmodifiableList(arrayList);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static SequenceOfCrlEntry getInstance(Object obj) {
        if (obj instanceof SequenceOfCrlEntry) {
            return (SequenceOfCrlEntry) obj;
        }
        if (obj != null) {
            return new SequenceOfCrlEntry(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public List<CrlEntry> getCrlEntries() {
        return this.crlEntries;
    }

    public ASN1Primitive toASN1Primitive() {
        return new DERSequence((ASN1Encodable[]) this.crlEntries.toArray(new ASN1Encodable[0]));
    }
}
