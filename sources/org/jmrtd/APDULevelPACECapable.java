package org.jmrtd;

import net.sf.scuba.smartcards.APDUWrapper;
import net.sf.scuba.smartcards.CardServiceException;

public interface APDULevelPACECapable {
    byte[] sendGeneralAuthenticate(APDUWrapper aPDUWrapper, byte[] bArr, int i11, boolean z11) throws CardServiceException;

    void sendMSESetATMutualAuth(APDUWrapper aPDUWrapper, String str, int i11, byte[] bArr) throws CardServiceException;
}
