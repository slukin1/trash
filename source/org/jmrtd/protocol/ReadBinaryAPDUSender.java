package org.jmrtd.protocol;

import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.scuba.smartcards.APDUWrapper;
import net.sf.scuba.smartcards.CardService;
import net.sf.scuba.smartcards.CardServiceException;
import net.sf.scuba.smartcards.CommandAPDU;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ResponseAPDU;
import net.sf.scuba.util.Hex;
import okio.Utf8;
import org.jmrtd.APDULevelReadBinaryCapable;

public class ReadBinaryAPDUSender implements APDULevelReadBinaryCapable {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd.protocol");
    private SecureMessagingAPDUSender secureMessagingSender;
    private CardService service;

    public ReadBinaryAPDUSender(CardService cardService) {
        this.service = cardService;
        this.secureMessagingSender = new SecureMessagingAPDUSender(cardService);
    }

    private static void checkStatusWordAfterFileOperation(CommandAPDU commandAPDU, ResponseAPDU responseAPDU) throws CardServiceException {
        if (responseAPDU != null) {
            byte[] data = responseAPDU.getData();
            short sw2 = (short) responseAPDU.getSW();
            String str = "CAPDU = " + Hex.bytesToHexString(commandAPDU.getBytes()) + ", RAPDU = " + Hex.bytesToHexString(responseAPDU.getBytes());
            if ((sw2 & ISO7816.SW_WRONG_LENGTH) == 26368 && (data == null || data.length == 0)) {
                throw new CardServiceException("Wrong length, " + str, (int) sw2);
            } else if (sw2 == -28672) {
            } else {
                if (sw2 != 25218) {
                    if (sw2 != 27010) {
                        if (sw2 == 27266) {
                            throw new CardServiceException("File not found, " + str, (int) sw2);
                        } else if (!(sw2 == 27013 || sw2 == 27014)) {
                            throw new CardServiceException("Error occured, " + str, (int) sw2);
                        }
                    }
                    throw new CardServiceException("Access to file denied, " + str, (int) sw2);
                } else if (data == null || data.length == 0) {
                    throw new CardServiceException("End of file, " + str, (int) sw2);
                }
            }
        } else {
            throw new CardServiceException("No response APDU");
        }
    }

    private static byte[] getResponseData(ResponseAPDU responseAPDU, boolean z11) throws CardServiceException {
        if (responseAPDU == null) {
            return null;
        }
        byte[] data = responseAPDU.getData();
        if (data == null) {
            throw new CardServiceException("Malformed read binary long response data");
        } else if (!z11) {
            return data;
        } else {
            if (data[0] == 83) {
                int i11 = (((byte) (data[1] & 128)) == Byte.MIN_VALUE ? (data[1] & 15) + 1 : 1) + 1;
                int length = data.length - i11;
                byte[] bArr = new byte[length];
                System.arraycopy(data, i11, bArr, 0, length);
                return bArr;
            }
            throw new CardServiceException("Malformed read binary long response data");
        }
    }

    public synchronized byte[] sendReadBinary(APDUWrapper aPDUWrapper, int i11, int i12, int i13, boolean z11, boolean z12) throws CardServiceException {
        CommandAPDU commandAPDU;
        int i14;
        CommandAPDU commandAPDU2;
        int i15 = i12;
        int i16 = i13;
        boolean z13 = z12;
        synchronized (this) {
            ResponseAPDU responseAPDU = null;
            if (i16 == 0) {
                return null;
            }
            byte b11 = (byte) ((65280 & i15) >> 8);
            byte b12 = (byte) (i15 & 255);
            if (z13) {
                int i17 = i16 < 128 ? i16 + 2 : i16 < 256 ? i16 + 3 : i16;
                if (i17 > 256) {
                    i17 = 256;
                }
                commandAPDU = new CommandAPDU(0, -79, 0, 0, new byte[]{84, 2, b11, b12}, i17);
                i16 = i17;
            } else {
                if (z11) {
                    commandAPDU2 = new CommandAPDU(0, -80, (int) (byte) i11, (int) b12, i13);
                } else {
                    commandAPDU2 = new CommandAPDU(0, -80, (int) b11, (int) b12, i13);
                }
                commandAPDU = commandAPDU2;
            }
            try {
                responseAPDU = this.secureMessagingSender.transmit(aPDUWrapper, commandAPDU);
                i14 = responseAPDU.getSW();
            } catch (CardServiceException e11) {
                if (!this.service.isConnectionLost(e11)) {
                    LOGGER.log(Level.FINE, "Exception during READ BINARY", e11);
                    i14 = e11.getSW();
                } else {
                    throw e11;
                }
            }
            short s11 = (short) i14;
            byte[] responseData = getResponseData(responseAPDU, z13);
            if (responseData == null || responseData.length == 0) {
                LOGGER.warning("Empty response data: response APDU bytes = " + Arrays.toString(responseData) + ", le = " + i16 + ", sw = " + Integer.toHexString(s11));
            }
            checkStatusWordAfterFileOperation(commandAPDU, responseAPDU);
            return responseData;
        }
    }

    public synchronized void sendSelectApplet(APDUWrapper aPDUWrapper, byte[] bArr) throws CardServiceException {
        if (bArr != null) {
            CommandAPDU commandAPDU = new CommandAPDU(0, -92, 4, 12, bArr);
            checkStatusWordAfterFileOperation(commandAPDU, this.secureMessagingSender.transmit(aPDUWrapper, commandAPDU));
        } else {
            throw new IllegalArgumentException("AID cannot be null");
        }
    }

    public synchronized void sendSelectFile(APDUWrapper aPDUWrapper, short s11) throws CardServiceException {
        CommandAPDU commandAPDU = new CommandAPDU(0, -92, 2, 12, new byte[]{(byte) ((s11 >> 8) & 255), (byte) (s11 & 255)}, 0);
        ResponseAPDU transmit = this.secureMessagingSender.transmit(aPDUWrapper, commandAPDU);
        if (transmit != null) {
            checkStatusWordAfterFileOperation(commandAPDU, transmit);
        }
    }

    public synchronized void sendSelectMF() throws CardServiceException {
        CommandAPDU commandAPDU = new CommandAPDU(0, -92, 0, 12, new byte[]{Utf8.REPLACEMENT_BYTE, 0});
        checkStatusWordAfterFileOperation(commandAPDU, this.secureMessagingSender.transmit((APDUWrapper) null, commandAPDU));
    }
}
