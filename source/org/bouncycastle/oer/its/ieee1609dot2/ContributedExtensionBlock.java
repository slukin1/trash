package org.bouncycastle.oer.its.ieee1609dot2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.bouncycastle.asn1.ASN1Encodable;
import org.bouncycastle.asn1.ASN1Object;
import org.bouncycastle.asn1.ASN1Primitive;
import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.oer.its.ItsUtils;
import org.bouncycastle.oer.its.etsi103097.extension.EtsiOriginatingHeaderInfoExtension;

public class ContributedExtensionBlock extends ASN1Object {
    private final HeaderInfoContributorId contributorId;
    private final List<EtsiOriginatingHeaderInfoExtension> extns;

    private ContributedExtensionBlock(ASN1Sequence aSN1Sequence) {
        if (aSN1Sequence.size() == 2) {
            this.contributorId = HeaderInfoContributorId.getInstance(aSN1Sequence.getObjectAt(0));
            Iterator<ASN1Encodable> it2 = ASN1Sequence.getInstance(aSN1Sequence.getObjectAt(1)).iterator();
            ArrayList arrayList = new ArrayList();
            while (it2.hasNext()) {
                arrayList.add(EtsiOriginatingHeaderInfoExtension.getInstance(it2.next()));
            }
            this.extns = Collections.unmodifiableList(arrayList);
            return;
        }
        throw new IllegalArgumentException("expected sequence size of 2");
    }

    public ContributedExtensionBlock(HeaderInfoContributorId headerInfoContributorId, List<EtsiOriginatingHeaderInfoExtension> list) {
        this.contributorId = headerInfoContributorId;
        this.extns = list;
    }

    public static ContributedExtensionBlock getInstance(Object obj) {
        if (obj instanceof ContributedExtensionBlock) {
            return (ContributedExtensionBlock) obj;
        }
        if (obj != null) {
            return new ContributedExtensionBlock(ASN1Sequence.getInstance(obj));
        }
        return null;
    }

    public HeaderInfoContributorId getContributorId() {
        return this.contributorId;
    }

    public List<EtsiOriginatingHeaderInfoExtension> getExtns() {
        return this.extns;
    }

    public ASN1Primitive toASN1Primitive() {
        return ItsUtils.toSequence(this.contributorId, ItsUtils.toSequence((List) this.extns));
    }
}
