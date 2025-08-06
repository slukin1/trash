package org.jmrtd.protocol;

import java.util.logging.Logger;
import net.sf.scuba.smartcards.CardService;
import org.jmrtd.APDULevelAACapable;

public class AAAPDUSender implements APDULevelAACapable {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd.protocol");
    private SecureMessagingAPDUSender secureMessagingSender;

    public AAAPDUSender(CardService cardService) {
        this.secureMessagingSender = new SecureMessagingAPDUSender(cardService);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004f A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00a3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized byte[] sendInternalAuthenticate(net.sf.scuba.smartcards.APDUWrapper r12, byte[] r13) throws net.sf.scuba.smartcards.CardServiceException {
        /*
            r11 = this;
            monitor-enter(r11)
            if (r13 == 0) goto L_0x00d7
            int r0 = r13.length     // Catch:{ all -> 0x00df }
            r1 = 8
            if (r0 != r1) goto L_0x00d7
            net.sf.scuba.smartcards.CommandAPDU r0 = new net.sf.scuba.smartcards.CommandAPDU     // Catch:{ all -> 0x00df }
            r3 = 0
            r4 = -120(0xffffffffffffff88, float:NaN)
            r5 = 0
            r6 = 0
            r8 = 256(0x100, float:3.59E-43)
            r2 = r0
            r7 = r13
            r2.<init>(r3, r4, r5, r6, r7, r8)     // Catch:{ all -> 0x00df }
            r1 = 0
            org.jmrtd.protocol.SecureMessagingAPDUSender r2 = r11.secureMessagingSender     // Catch:{ CardServiceException -> 0x0024 }
            net.sf.scuba.smartcards.ResponseAPDU r2 = r2.transmit(r12, r0)     // Catch:{ CardServiceException -> 0x0024 }
            int r0 = r2.getSW()     // Catch:{ CardServiceException -> 0x0022 }
            goto L_0x004a
        L_0x0022:
            r3 = move-exception
            goto L_0x0026
        L_0x0024:
            r3 = move-exception
            r2 = r1
        L_0x0026:
            java.util.logging.Logger r4 = LOGGER     // Catch:{ all -> 0x00df }
            java.util.logging.Level r5 = java.util.logging.Level.INFO     // Catch:{ all -> 0x00df }
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x00df }
            r6.<init>()     // Catch:{ all -> 0x00df }
            java.lang.String r7 = "Exception during transmission of command APDU = "
            r6.append(r7)     // Catch:{ all -> 0x00df }
            byte[] r0 = r0.getBytes()     // Catch:{ all -> 0x00df }
            java.lang.String r0 = net.sf.scuba.util.Hex.bytesToHexString(r0)     // Catch:{ all -> 0x00df }
            r6.append(r0)     // Catch:{ all -> 0x00df }
            java.lang.String r0 = r6.toString()     // Catch:{ all -> 0x00df }
            r4.log(r5, r0, r3)     // Catch:{ all -> 0x00df }
            int r0 = r3.getSW()     // Catch:{ all -> 0x00df }
        L_0x004a:
            short r0 = (short) r0     // Catch:{ all -> 0x00df }
            r3 = -28672(0xffffffffffff9000, float:NaN)
            if (r0 != r3) goto L_0x0057
            if (r2 == 0) goto L_0x0057
            byte[] r12 = r2.getData()     // Catch:{ all -> 0x00df }
            monitor-exit(r11)
            return r12
        L_0x0057:
            r3 = 65280(0xff00, float:9.1477E-41)
            r3 = r3 & r0
            r4 = 24832(0x6100, float:3.4797E-41)
            if (r3 != r4) goto L_0x00a3
            if (r2 != 0) goto L_0x0063
            r2 = r1
            goto L_0x0067
        L_0x0063:
            byte[] r2 = r2.getData()     // Catch:{ all -> 0x00df }
        L_0x0067:
            net.sf.scuba.smartcards.CommandAPDU r10 = new net.sf.scuba.smartcards.CommandAPDU     // Catch:{ all -> 0x00df }
            r4 = 0
            r5 = -120(0xffffffffffffff88, float:NaN)
            r6 = 0
            r7 = 0
            r9 = 65536(0x10000, float:9.18355E-41)
            r3 = r10
            r8 = r13
            r3.<init>(r4, r5, r6, r7, r8, r9)     // Catch:{ all -> 0x00df }
            org.jmrtd.protocol.SecureMessagingAPDUSender r13 = r11.secureMessagingSender     // Catch:{ all -> 0x00df }
            net.sf.scuba.smartcards.ResponseAPDU r12 = r13.transmit(r12, r10)     // Catch:{ all -> 0x00df }
            if (r12 != 0) goto L_0x007e
            goto L_0x0082
        L_0x007e:
            byte[] r1 = r12.getData()     // Catch:{ all -> 0x00df }
        L_0x0082:
            if (r2 != 0) goto L_0x008f
            if (r1 == 0) goto L_0x0087
            goto L_0x008f
        L_0x0087:
            net.sf.scuba.smartcards.CardServiceException r12 = new net.sf.scuba.smartcards.CardServiceException     // Catch:{ all -> 0x00df }
            java.lang.String r13 = "Internal Authenticate failed"
            r12.<init>((java.lang.String) r13, (int) r0)     // Catch:{ all -> 0x00df }
            throw r12     // Catch:{ all -> 0x00df }
        L_0x008f:
            if (r2 == 0) goto L_0x0095
            if (r1 != 0) goto L_0x0095
            monitor-exit(r11)
            return r2
        L_0x0095:
            if (r2 != 0) goto L_0x009b
            if (r1 == 0) goto L_0x009b
            monitor-exit(r11)
            return r1
        L_0x009b:
            int r12 = r2.length     // Catch:{ all -> 0x00df }
            int r13 = r1.length     // Catch:{ all -> 0x00df }
            if (r12 <= r13) goto L_0x00a1
            monitor-exit(r11)
            return r2
        L_0x00a1:
            monitor-exit(r11)
            return r1
        L_0x00a3:
            if (r2 == 0) goto L_0x00cf
            byte[] r12 = r2.getData()     // Catch:{ all -> 0x00df }
            if (r12 == 0) goto L_0x00cf
            java.util.logging.Logger r12 = LOGGER     // Catch:{ all -> 0x00df }
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x00df }
            r13.<init>()     // Catch:{ all -> 0x00df }
            java.lang.String r1 = "Internal Authenticate may not have succeeded, got status word "
            r13.append(r1)     // Catch:{ all -> 0x00df }
            r1 = 65535(0xffff, float:9.1834E-41)
            r0 = r0 & r1
            java.lang.String r0 = java.lang.Integer.toHexString(r0)     // Catch:{ all -> 0x00df }
            r13.append(r0)     // Catch:{ all -> 0x00df }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x00df }
            r12.warning(r13)     // Catch:{ all -> 0x00df }
            byte[] r12 = r2.getData()     // Catch:{ all -> 0x00df }
            monitor-exit(r11)
            return r12
        L_0x00cf:
            net.sf.scuba.smartcards.CardServiceException r12 = new net.sf.scuba.smartcards.CardServiceException     // Catch:{ all -> 0x00df }
            java.lang.String r13 = "Internal Authenticate failed"
            r12.<init>((java.lang.String) r13, (int) r0)     // Catch:{ all -> 0x00df }
            throw r12     // Catch:{ all -> 0x00df }
        L_0x00d7:
            java.lang.IllegalArgumentException r12 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00df }
            java.lang.String r13 = "rndIFD wrong length"
            r12.<init>(r13)     // Catch:{ all -> 0x00df }
            throw r12     // Catch:{ all -> 0x00df }
        L_0x00df:
            r12 = move-exception
            monitor-exit(r11)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jmrtd.protocol.AAAPDUSender.sendInternalAuthenticate(net.sf.scuba.smartcards.APDUWrapper, byte[]):byte[]");
    }
}
