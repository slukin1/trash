package org.jmrtd.protocol;

import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.scuba.smartcards.APDUWrapper;
import net.sf.scuba.smartcards.CardService;
import net.sf.scuba.smartcards.CardServiceException;
import net.sf.scuba.smartcards.CommandAPDU;
import net.sf.scuba.smartcards.ResponseAPDU;
import net.sf.scuba.tlv.TLVUtil;
import org.jmrtd.APDULevelEACCACapable;

public class EACCAAPDUSender implements APDULevelEACCACapable {
    private static final byte INS_BSI_GENERAL_AUTHENTICATE = -122;
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd.protocol");
    private SecureMessagingAPDUSender secureMessagingSender;

    public EACCAAPDUSender(CardService cardService) {
        this.secureMessagingSender = new SecureMessagingAPDUSender(cardService);
    }

    public synchronized byte[] sendGeneralAuthenticate(APDUWrapper aPDUWrapper, byte[] bArr, boolean z11) throws CardServiceException {
        return sendGeneralAuthenticate(aPDUWrapper, bArr, 256, z11);
    }

    public synchronized void sendMSEKAT(APDUWrapper aPDUWrapper, byte[] bArr, byte[] bArr2) throws CardServiceException {
        byte[] bArr3 = new byte[(bArr.length + (bArr2 != null ? bArr2.length : 0))];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        if (bArr2 != null) {
            System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        }
        short sw2 = (short) this.secureMessagingSender.transmit(aPDUWrapper, new CommandAPDU(0, 34, 65, 166, bArr3)).getSW();
        if (sw2 != -28672) {
            throw new CardServiceException("Sending MSE KAT failed", (int) sw2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x0064 A[Catch:{ IOException -> 0x002d }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0066 A[Catch:{ IOException -> 0x002d }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x006f A[DONT_GENERATE] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0071 A[SYNTHETIC, Splitter:B:23:0x0071] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void sendMSESetATIntAuth(net.sf.scuba.smartcards.APDUWrapper r7, java.lang.String r8, java.math.BigInteger r9) throws net.sf.scuba.smartcards.CardServiceException {
        /*
            r6 = this;
            monitor-enter(r6)
            r3 = 65
            r4 = 164(0xa4, float:2.3E-43)
            if (r9 == 0) goto L_0x004b
            java.math.BigInteger r0 = java.math.BigInteger.ZERO     // Catch:{ all -> 0x0079 }
            int r0 = r9.compareTo(r0)     // Catch:{ all -> 0x0079 }
            if (r0 >= 0) goto L_0x0010
            goto L_0x004b
        L_0x0010:
            byte[] r8 = org.jmrtd.Util.toOIDBytes(r8)     // Catch:{ all -> 0x0079 }
            r0 = 132(0x84, float:1.85E-43)
            byte[] r9 = org.jmrtd.Util.i2os(r9)     // Catch:{ all -> 0x0079 }
            byte[] r9 = net.sf.scuba.tlv.TLVUtil.wrapDO(r0, r9)     // Catch:{ all -> 0x0079 }
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x0079 }
            r0.<init>()     // Catch:{ all -> 0x0079 }
            r0.write(r8)     // Catch:{ IOException -> 0x002d }
            r0.write(r9)     // Catch:{ IOException -> 0x002d }
            r0.close()     // Catch:{ IOException -> 0x002d }
            goto L_0x0037
        L_0x002d:
            r8 = move-exception
            java.util.logging.Logger r9 = LOGGER     // Catch:{ all -> 0x0079 }
            java.util.logging.Level r1 = java.util.logging.Level.WARNING     // Catch:{ all -> 0x0079 }
            java.lang.String r2 = "Exception"
            r9.log(r1, r2, r8)     // Catch:{ all -> 0x0079 }
        L_0x0037:
            net.sf.scuba.smartcards.CommandAPDU r8 = new net.sf.scuba.smartcards.CommandAPDU     // Catch:{ all -> 0x0079 }
            r1 = 0
            r2 = 34
            byte[] r5 = r0.toByteArray()     // Catch:{ all -> 0x0079 }
            r0 = r8
            r0.<init>((int) r1, (int) r2, (int) r3, (int) r4, (byte[]) r5)     // Catch:{ all -> 0x0079 }
            org.jmrtd.protocol.SecureMessagingAPDUSender r9 = r6.secureMessagingSender     // Catch:{ all -> 0x0079 }
            net.sf.scuba.smartcards.ResponseAPDU r7 = r9.transmit(r7, r8)     // Catch:{ all -> 0x0079 }
            goto L_0x0062
        L_0x004b:
            net.sf.scuba.smartcards.CommandAPDU r9 = new net.sf.scuba.smartcards.CommandAPDU     // Catch:{ all -> 0x0079 }
            r1 = 0
            r2 = 34
            byte[] r5 = org.jmrtd.Util.toOIDBytes(r8)     // Catch:{ all -> 0x0079 }
            r3 = 65
            r4 = 164(0xa4, float:2.3E-43)
            r0 = r9
            r0.<init>((int) r1, (int) r2, (int) r3, (int) r4, (byte[]) r5)     // Catch:{ all -> 0x0079 }
            org.jmrtd.protocol.SecureMessagingAPDUSender r8 = r6.secureMessagingSender     // Catch:{ all -> 0x0079 }
            net.sf.scuba.smartcards.ResponseAPDU r7 = r8.transmit(r7, r9)     // Catch:{ all -> 0x0079 }
        L_0x0062:
            if (r7 != 0) goto L_0x0066
            r7 = -1
            goto L_0x006b
        L_0x0066:
            int r7 = r7.getSW()     // Catch:{ all -> 0x0079 }
            short r7 = (short) r7
        L_0x006b:
            r8 = -28672(0xffffffffffff9000, float:NaN)
            if (r7 != r8) goto L_0x0071
            monitor-exit(r6)
            return
        L_0x0071:
            net.sf.scuba.smartcards.CardServiceException r8 = new net.sf.scuba.smartcards.CardServiceException     // Catch:{ all -> 0x0079 }
            java.lang.String r9 = "Sending MSE AT failed"
            r8.<init>((java.lang.String) r9, (int) r7)     // Catch:{ all -> 0x0079 }
            throw r8     // Catch:{ all -> 0x0079 }
        L_0x0079:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jmrtd.protocol.EACCAAPDUSender.sendMSESetATIntAuth(net.sf.scuba.smartcards.APDUWrapper, java.lang.String, java.math.BigInteger):void");
    }

    public synchronized byte[] sendGeneralAuthenticate(APDUWrapper aPDUWrapper, byte[] bArr, int i11, boolean z11) throws CardServiceException {
        byte[] data;
        byte[] wrapDO = TLVUtil.wrapDO(124, bArr);
        ResponseAPDU transmit = this.secureMessagingSender.transmit(aPDUWrapper, new CommandAPDU(z11 ? 0 : 16, -122, 0, 0, wrapDO, i11));
        short sw2 = (short) transmit.getSW();
        if (sw2 == 26368) {
            transmit = this.secureMessagingSender.transmit(aPDUWrapper, new CommandAPDU(z11 ? 0 : 16, -122, 0, 0, wrapDO, 256));
        }
        if (sw2 == -28672) {
            data = transmit.getData();
            try {
                data = TLVUtil.unwrapDO(124, data);
            } catch (Exception e11) {
                LOGGER.log(Level.WARNING, "Could not unwrap response to GENERAL AUTHENTICATE", e11);
            }
        } else {
            throw new CardServiceException("Sending general authenticate failed", (int) sw2);
        }
        return data;
    }
}
