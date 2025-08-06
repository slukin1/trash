package org.jmrtd.protocol;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.scuba.smartcards.APDUWrapper;
import net.sf.scuba.smartcards.CardService;
import net.sf.scuba.smartcards.CardServiceException;
import net.sf.scuba.smartcards.CommandAPDU;
import net.sf.scuba.smartcards.ResponseAPDU;
import net.sf.scuba.tlv.TLVUtil;
import org.jmrtd.APDULevelPACECapable;
import org.jmrtd.Util;

public class PACEAPDUSender implements APDULevelPACECapable {
    public static final byte CAN_PACE_KEY_REFERENCE = 2;
    private static final byte INS_PACE_GENERAL_AUTHENTICATE = -122;
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd.protocol");
    public static final byte MRZ_PACE_KEY_REFERENCE = 1;
    public static final byte NO_PACE_KEY_REFERENCE = 0;
    public static final byte PIN_PACE_KEY_REFERENCE = 3;
    public static final byte PUK_PACE_KEY_REFERENCE = 4;
    private SecureMessagingAPDUSender secureMessagingSender;

    public PACEAPDUSender(CardService cardService) {
        this.secureMessagingSender = new SecureMessagingAPDUSender(cardService);
    }

    public synchronized byte[] sendGeneralAuthenticate(APDUWrapper aPDUWrapper, byte[] bArr, int i11, boolean z11) throws CardServiceException {
        ResponseAPDU transmit;
        transmit = this.secureMessagingSender.transmit(aPDUWrapper, new CommandAPDU(z11 ? 0 : 16, -122, 0, 0, TLVUtil.wrapDO(124, bArr), i11));
        short sw2 = (short) transmit.getSW();
        if (sw2 != -28672) {
            throw new CardServiceException("Sending general authenticate failed", (int) sw2);
        }
        return TLVUtil.unwrapDO(124, transmit.getData());
    }

    public synchronized void sendMSESetATMutualAuth(APDUWrapper aPDUWrapper, String str, int i11, byte[] bArr) throws CardServiceException {
        if (str != null) {
            try {
                byte[] oIDBytes = Util.toOIDBytes(str);
                if (!(i11 == 1 || i11 == 2 || i11 == 3)) {
                    if (i11 != 4) {
                        throw new IllegalArgumentException("Unsupported key type reference (MRZ, CAN, etc), found " + i11);
                    }
                }
                byte[] wrapDO = TLVUtil.wrapDO(131, new byte[]{(byte) i11});
                if (bArr != null) {
                    bArr = TLVUtil.wrapDO(132, bArr);
                }
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byteArrayOutputStream.write(oIDBytes);
                byteArrayOutputStream.write(wrapDO);
                if (bArr != null) {
                    byteArrayOutputStream.write(bArr);
                }
                short sw2 = (short) this.secureMessagingSender.transmit(aPDUWrapper, new CommandAPDU(0, 34, 193, 164, byteArrayOutputStream.toByteArray())).getSW();
                if (sw2 != -28672) {
                    throw new CardServiceException("Sending MSE AT failed", (int) sw2);
                }
            } catch (IOException e11) {
                LOGGER.log(Level.WARNING, "Error while copying data", e11);
                throw new IllegalStateException("Error while copying data");
            } catch (Throwable th2) {
                throw th2;
            }
        } else {
            throw new IllegalArgumentException("OID cannot be null");
        }
    }
}
