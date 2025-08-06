package org.jmrtd;

import net.sf.scuba.smartcards.APDUWrapper;
import net.sf.scuba.smartcards.CardServiceException;

public interface APDULevelReadBinaryCapable {
    byte[] sendReadBinary(APDUWrapper aPDUWrapper, int i11, int i12, int i13, boolean z11, boolean z12) throws CardServiceException;

    void sendSelectApplet(APDUWrapper aPDUWrapper, byte[] bArr) throws CardServiceException;

    void sendSelectFile(APDUWrapper aPDUWrapper, short s11) throws CardServiceException;

    void sendSelectMF() throws CardServiceException;
}
