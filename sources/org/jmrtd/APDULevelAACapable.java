package org.jmrtd;

import net.sf.scuba.smartcards.APDUWrapper;
import net.sf.scuba.smartcards.CardServiceException;

public interface APDULevelAACapable {
    byte[] sendInternalAuthenticate(APDUWrapper aPDUWrapper, byte[] bArr) throws CardServiceException;
}
