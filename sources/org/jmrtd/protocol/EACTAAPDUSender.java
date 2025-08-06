package org.jmrtd.protocol;

import com.facebook.internal.FacebookRequestErrorClassification;
import net.sf.scuba.smartcards.APDUWrapper;
import net.sf.scuba.smartcards.CardService;
import net.sf.scuba.smartcards.CardServiceException;
import net.sf.scuba.smartcards.CommandAPDU;
import org.jmrtd.APDULevelEACTACapable;

public class EACTAAPDUSender implements APDULevelEACTACapable {
    private SecureMessagingAPDUSender secureMessagingSender;

    public EACTAAPDUSender(CardService cardService) {
        this.secureMessagingSender = new SecureMessagingAPDUSender(cardService);
    }

    public synchronized byte[] sendGetChallenge(APDUWrapper aPDUWrapper) throws CardServiceException {
        return this.secureMessagingSender.transmit(aPDUWrapper, new CommandAPDU(0, -124, 0, 0, 8)).getData();
    }

    public synchronized void sendMSESetATExtAuth(APDUWrapper aPDUWrapper, byte[] bArr) throws CardServiceException {
        short sw2 = (short) this.secureMessagingSender.transmit(aPDUWrapper, new CommandAPDU(0, 34, 129, 164, bArr)).getSW();
        if (sw2 != -28672) {
            throw new CardServiceException("Sending MSE AT failed", (int) sw2);
        }
    }

    public synchronized void sendMSESetDST(APDUWrapper aPDUWrapper, byte[] bArr) throws CardServiceException {
        short sw2 = (short) this.secureMessagingSender.transmit(aPDUWrapper, new CommandAPDU(0, 34, 129, 182, bArr)).getSW();
        if (sw2 != -28672) {
            throw new CardServiceException("Sending MSE Set DST failed", (int) sw2);
        }
    }

    public synchronized void sendMutualAuthenticate(APDUWrapper aPDUWrapper, byte[] bArr) throws CardServiceException {
        short sw2 = (short) this.secureMessagingSender.transmit(aPDUWrapper, new CommandAPDU(0, -126, 0, 0, bArr)).getSW();
        if (sw2 != -28672) {
            throw new CardServiceException("Sending External Authenticate failed.", (int) sw2);
        }
    }

    public synchronized void sendPSOExtendedLengthMode(APDUWrapper aPDUWrapper, byte[] bArr, byte[] bArr2) throws CardServiceException {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        short sw2 = (short) this.secureMessagingSender.transmit(aPDUWrapper, new CommandAPDU(0, 42, 0, (int) FacebookRequestErrorClassification.EC_INVALID_TOKEN, bArr3)).getSW();
        if (sw2 != -28672) {
            throw new CardServiceException("Sending PSO failed", (int) sw2);
        }
    }
}
