package org.jmrtd;

import java.math.BigInteger;
import net.sf.scuba.smartcards.APDUWrapper;
import net.sf.scuba.smartcards.CardServiceException;

public interface APDULevelEACCACapable {
    byte[] sendGeneralAuthenticate(APDUWrapper aPDUWrapper, byte[] bArr, boolean z11) throws CardServiceException;

    void sendMSEKAT(APDUWrapper aPDUWrapper, byte[] bArr, byte[] bArr2) throws CardServiceException;

    void sendMSESetATIntAuth(APDUWrapper aPDUWrapper, String str, BigInteger bigInteger) throws CardServiceException;
}
