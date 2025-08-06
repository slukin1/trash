package org.jmrtd.protocol;

import java.security.PublicKey;
import net.sf.scuba.smartcards.CardServiceException;
import org.jmrtd.APDULevelAACapable;
import org.jmrtd.CardServiceProtocolException;

public class AAProtocol {
    private APDULevelAACapable service;
    private SecureMessagingWrapper wrapper;

    public AAProtocol(APDULevelAACapable aPDULevelAACapable, SecureMessagingWrapper secureMessagingWrapper) {
        this.service = aPDULevelAACapable;
        this.wrapper = secureMessagingWrapper;
    }

    public AAResult doAA(PublicKey publicKey, String str, String str2, byte[] bArr) throws CardServiceException {
        if (bArr != null) {
            try {
                if (bArr.length == 8) {
                    return new AAResult(publicKey, str, str2, bArr, this.service.sendInternalAuthenticate(this.wrapper, bArr));
                }
            } catch (Exception e11) {
                throw new CardServiceProtocolException("Exception", 1, (Throwable) e11);
            }
        }
        throw new IllegalArgumentException("AA failed: bad challenge");
    }
}
