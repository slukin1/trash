package org.jmrtd.protocol;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.scuba.smartcards.APDUEvent;
import net.sf.scuba.smartcards.APDUListener;
import net.sf.scuba.smartcards.APDUWrapper;
import net.sf.scuba.smartcards.CardService;
import net.sf.scuba.smartcards.CardServiceException;
import net.sf.scuba.smartcards.CommandAPDU;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ResponseAPDU;
import net.sf.scuba.util.Hex;
import org.jmrtd.Util;
import org.jmrtd.WrappedAPDUEvent;

public class SecureMessagingAPDUSender {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd.protocol");
    private int apduCount = 0;
    private CardService service;

    public SecureMessagingAPDUSender(CardService cardService) {
        this.service = cardService;
    }

    private byte[] continueSendingUsingResponseChaining(APDUWrapper aPDUWrapper, short s11, byte[] bArr) throws CardServiceException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            if ((65280 & s11) != 24832) {
                break;
            }
            try {
                byteArrayOutputStream.write(bArr);
                short s12 = s11 & 255;
                if (s12 <= 0) {
                    break;
                }
                ResponseAPDU transmit = transmit(aPDUWrapper, new CommandAPDU(0, -64, 0, 0, (int) s12));
                byte[] data = transmit.getData();
                s11 = (short) transmit.getSW();
                bArr = data;
            } catch (IOException e11) {
                throw new CardServiceException("Could not write to stream", e11, s11);
            } catch (Throwable th2) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException e12) {
                    LOGGER.log(Level.FINE, "Error closing stream", e12);
                }
                throw th2;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (IOException e13) {
            LOGGER.log(Level.FINE, "Error closing stream", e13);
        }
        return byteArray;
    }

    private List<ResponseAPDU> sendUsingCommandChaining(CommandAPDU commandAPDU, int i11) throws CardServiceException {
        List<byte[]> partition = Util.partition(i11, commandAPDU.getData());
        ArrayList arrayList = new ArrayList(partition.size());
        int i12 = 0;
        for (byte[] next : partition) {
            boolean z11 = true;
            i12++;
            if (i12 < partition.size()) {
                z11 = false;
            }
            int cla = commandAPDU.getCLA();
            arrayList.add(this.service.transmit(new CommandAPDU(!z11 ? cla | 16 : cla, commandAPDU.getINS(), commandAPDU.getP1(), commandAPDU.getP2(), next, commandAPDU.getNe())));
        }
        return arrayList;
    }

    public void addAPDUListener(APDUListener aPDUListener) {
        this.service.addAPDUListener(aPDUListener);
    }

    public boolean isExtendedAPDULengthSupported() {
        return this.service.isExtendedAPDULengthSupported();
    }

    public void notifyExchangedAPDU(APDUEvent aPDUEvent) {
        Collection<APDUListener> aPDUListeners = this.service.getAPDUListeners();
        if (aPDUListeners != null && !aPDUListeners.isEmpty()) {
            for (APDUListener exchangedAPDU : aPDUListeners) {
                exchangedAPDU.exchangedAPDU(aPDUEvent);
            }
        }
    }

    public void removeAPDUListener(APDUListener aPDUListener) {
        this.service.removeAPDUListener(aPDUListener);
    }

    public ResponseAPDU transmit(APDUWrapper aPDUWrapper, CommandAPDU commandAPDU) throws CardServiceException {
        CommandAPDU wrap = aPDUWrapper != null ? aPDUWrapper.wrap(commandAPDU) : commandAPDU;
        ResponseAPDU transmit = this.service.transmit(wrap);
        short sw2 = (short) transmit.getSW();
        if (aPDUWrapper == null) {
            int i11 = this.apduCount + 1;
            this.apduCount = i11;
            notifyExchangedAPDU(new APDUEvent(this, "PLAIN", i11, wrap, transmit));
            return transmit;
        } else if ((sw2 & ISO7816.SW_WRONG_LENGTH) == 26368) {
            String type = aPDUWrapper.getType();
            int i12 = this.apduCount + 1;
            this.apduCount = i12;
            notifyExchangedAPDU(new WrappedAPDUEvent(this, type, i12, commandAPDU, transmit, wrap, transmit));
            return transmit;
        } else {
            try {
                if (transmit.getBytes().length > 2) {
                    ResponseAPDU unwrap = aPDUWrapper.unwrap(transmit);
                    String type2 = aPDUWrapper.getType();
                    int i13 = this.apduCount + 1;
                    this.apduCount = i13;
                    notifyExchangedAPDU(new WrappedAPDUEvent(this, type2, i13, commandAPDU, unwrap, wrap, transmit));
                    return unwrap;
                }
                throw new CardServiceException("Exception during transmission of wrapped APDU, C=" + Hex.bytesToHexString(commandAPDU.getBytes()), (int) sw2);
            } catch (CardServiceException e11) {
                throw e11;
            } catch (Exception e12) {
                throw new CardServiceException("Exception during transmission of wrapped APDU, C=" + Hex.bytesToHexString(commandAPDU.getBytes()), e12, sw2);
            } catch (Throwable th2) {
                String type3 = aPDUWrapper.getType();
                int i14 = this.apduCount + 1;
                this.apduCount = i14;
                notifyExchangedAPDU(new WrappedAPDUEvent(this, type3, i14, commandAPDU, transmit, wrap, transmit));
                throw th2;
            }
        }
    }
}
