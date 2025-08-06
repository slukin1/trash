package org.bouncycastle.oer.its.etsi102941;

import org.bouncycastle.asn1.ASN1Sequence;
import org.bouncycastle.oer.its.etsi103097.EtsiTs103097DataEncryptedUnicast;
import org.bouncycastle.oer.its.ieee1609dot2.Ieee1609Dot2Content;

public class AuthorizationRequestMessageWithPop extends EtsiTs103097DataEncryptedUnicast {
    public AuthorizationRequestMessageWithPop(ASN1Sequence aSN1Sequence) {
        super(aSN1Sequence);
    }

    public AuthorizationRequestMessageWithPop(Ieee1609Dot2Content ieee1609Dot2Content) {
        super(ieee1609Dot2Content);
    }

    public static AuthorizationRequestMessageWithPop getInstance(Object obj) {
        if (obj instanceof AuthorizationRequestMessageWithPop) {
            return (AuthorizationRequestMessageWithPop) obj;
        }
        if (obj != null) {
            return new AuthorizationRequestMessageWithPop(ASN1Sequence.getInstance(obj));
        }
        return null;
    }
}
