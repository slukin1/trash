package org.bouncycastle.oer.its.etsi102941;

import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.oer.its.etsi103097.EtsiTs103097DataSigned;
import org.bouncycastle.oer.its.ieee1609dot2.Ieee1609Dot2Content;

public class CertificateRevocationListMessage extends EtsiTs103097DataSigned {
    public CertificateRevocationListMessage(ASN1Sequence aSN1Sequence) {
        super(aSN1Sequence);
    }

    public CertificateRevocationListMessage(Ieee1609Dot2Content ieee1609Dot2Content) {
        super(ieee1609Dot2Content);
    }

    public static CertificateRevocationListMessage getInstance(Object obj) {
        if (obj instanceof CertificateRevocationListMessage) {
            return (CertificateRevocationListMessage) obj;
        }
        if (obj != null) {
            return new CertificateRevocationListMessage(ASN1Sequence.getInstance(obj));
        }
        return null;
    }
}
