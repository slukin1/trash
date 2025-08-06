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

public class SequenceOfPsid extends ASN1Object {
    private final List<Psid> psids;

    public static class Builder {
        private List<Psid> items = new ArrayList();

        public SequenceOfPsid createSequenceOfPsidSsp() {
            return new SequenceOfPsid(this.items);
        }

        public Builder setItem(Psid... psidArr) {
            for (int i11 = 0; i11 != psidArr.length; i11++) {
                this.items.add(psidArr[i11]);
            }
            return this;
        }

        public Builder setItems(List<Psid> list) {
            this.items = list;
            return this;
        }
    }

    public SequenceOfPsid(List<Psid> list) {
        this.psids = Collections.unmodifiableList(list);
    }

    private SequenceOfPsid(ASN1Sequence aSN1Sequence) {
        ArrayList arrayList = new ArrayList();
        Iterator<ASN1Encodable> it2 = aSN1Sequence.iterator();
        while (it2.hasNext()) {
            arrayList.add(Psid.getInstance(it2.next()));
        }
        this.psids = Collections.unmodifiableList(arrayList);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static SequenceOfPsid getInstance(Object obj) {
        if (obj instanceof SequenceOfPsid) {
            return (SequenceOfPsid) obj;
        }
        if (obj != null) {
            return new SequenceOfPsid(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public List<Psid> getPsids() {
        return this.psids;
    }

    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence((List) this.psids);
    }
}
