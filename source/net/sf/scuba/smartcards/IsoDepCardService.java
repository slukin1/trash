package net.sf.scuba.smartcards;

import android.annotation.TargetApi;
import android.nfc.Tag;
import android.nfc.tech.IsoDep;
import android.nfc.tech.NfcA;
import android.nfc.tech.NfcB;
import android.os.Build;
import java.io.IOException;

public class IsoDepCardService extends CardService {
    private int apduCount = 0;
    private IsoDep isoDep;

    public IsoDepCardService(IsoDep isoDep2) {
        this.isoDep = isoDep2;
    }

    private boolean isDirectConnectionLost(Throwable th2) {
        if (!this.isoDep.isConnected()) {
            return true;
        }
        if (th2 == null) {
            return false;
        }
        if (th2.getClass().getName().contains("TagLostException")) {
            return true;
        }
        String message = th2.getMessage();
        if (message == null) {
            message = "";
        }
        return message.toLowerCase().contains("tag was lost");
    }

    public void close() {
        try {
            this.isoDep.close();
            this.state = 0;
        } catch (IOException unused) {
        }
    }

    public byte[] getATR() {
        Tag tag;
        IsoDep isoDep2 = this.isoDep;
        if (isoDep2 == null || (tag = isoDep2.getTag()) == null) {
            return null;
        }
        if (NfcA.get(tag) != null) {
            return this.isoDep.getHistoricalBytes();
        }
        if (NfcB.get(tag) != null) {
            return this.isoDep.getHiLayerResponse();
        }
        return this.isoDep.getHistoricalBytes();
    }

    /* JADX WARNING: Incorrect type for immutable var: ssa=java.lang.Exception, code=java.lang.Throwable, for r4v0, types: [java.lang.Throwable, java.lang.Exception] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isConnectionLost(java.lang.Throwable r4) {
        /*
            r3 = this;
            boolean r0 = r3.isDirectConnectionLost(r4)
            r1 = 1
            if (r0 == 0) goto L_0x0008
            return r1
        L_0x0008:
            r0 = 0
            if (r4 != 0) goto L_0x000c
            return r0
        L_0x000c:
            java.lang.Throwable r2 = r4.getCause()
            if (r2 == 0) goto L_0x001d
            if (r4 == r2) goto L_0x001d
            boolean r4 = r3.isDirectConnectionLost(r2)
            if (r4 == 0) goto L_0x001b
            return r1
        L_0x001b:
            r4 = r2
            goto L_0x000c
        L_0x001d:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: net.sf.scuba.smartcards.IsoDepCardService.isConnectionLost(java.lang.Exception):boolean");
    }

    @TargetApi(16)
    public boolean isExtendedAPDULengthSupported() {
        if (Build.VERSION.SDK_INT >= 16) {
            return this.isoDep.isExtendedLengthApduSupported();
        }
        return this.isoDep.getMaxTransceiveLength() > 261;
    }

    public boolean isOpen() {
        if (this.isoDep.isConnected()) {
            this.state = 1;
            return true;
        }
        this.state = 0;
        return false;
    }

    public void open() throws CardServiceException {
        if (!isOpen()) {
            try {
                this.isoDep.connect();
                if (this.isoDep.isConnected()) {
                    this.state = 1;
                    return;
                }
                throw new CardServiceException("Failed to connect");
            } catch (IOException e11) {
                throw new CardServiceException("Failed to connect", (Throwable) e11);
            }
        }
    }

    public ResponseAPDU transmit(CommandAPDU commandAPDU) throws CardServiceException {
        try {
            if (this.isoDep.isConnected()) {
                byte[] transceive = this.isoDep.transceive(commandAPDU.getBytes());
                if (transceive == null || transceive.length < 2) {
                    throw new CardServiceException("Failed response");
                }
                ResponseAPDU responseAPDU = new ResponseAPDU(transceive);
                int i11 = this.apduCount + 1;
                this.apduCount = i11;
                notifyExchangedAPDU(new APDUEvent(this, "ISODep", i11, commandAPDU, responseAPDU));
                return responseAPDU;
            }
            throw new CardServiceException("Not connected");
        } catch (CardServiceException e11) {
            throw e11;
        } catch (Exception e12) {
            throw new CardServiceException("Could not tranceive APDU", (Throwable) e12);
        }
    }
}
