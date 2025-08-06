package org.jmrtd;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.Serializable;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.scuba.smartcards.APDUWrapper;
import net.sf.scuba.smartcards.CardServiceException;
import net.sf.scuba.smartcards.FileInfo;
import net.sf.scuba.smartcards.FileSystemStructured;
import net.sf.scuba.tlv.TLVInputStream;
import net.sf.scuba.util.Hex;
import org.jmrtd.io.FragmentBuffer;
import org.jmrtd.lds.LDSFileUtil;
import org.jmrtd.protocol.SecureMessagingWrapper;

public class DefaultFileSystem implements FileSystemStructured {
    private static final Logger LOGGER = Logger.getLogger("org.jmrtd");
    public static final int NO_SFI = -1;
    private static final int READ_AHEAD_LENGTH = 8;
    private Map<Short, Byte> fidToSFI;
    private Map<Short, DefaultFileInfo> fileInfos;
    private boolean isSFIEnabled;
    private boolean isSelected;
    private int maxReadBinaryLength;
    private APDUWrapper oldWrapper;
    private short selectedFID;
    private APDULevelReadBinaryCapable service;
    private APDUWrapper wrapper;

    public static class DefaultFileInfo extends FileInfo implements Serializable {
        private static final long serialVersionUID = 6727369753765119839L;
        private FragmentBuffer buffer;
        private short fid;

        public DefaultFileInfo(short s11, int i11) {
            this.fid = s11;
            this.buffer = new FragmentBuffer(i11);
        }

        public void addFragment(int i11, byte[] bArr) {
            this.buffer.addFragment(i11, bArr);
        }

        public byte[] getBuffer() {
            return this.buffer.getBuffer();
        }

        public short getFID() {
            return this.fid;
        }

        public int getFileLength() {
            return this.buffer.getLength();
        }

        public FragmentBuffer.Fragment getSmallestUnbufferedFragment(int i11, int i12) {
            return this.buffer.getSmallestUnbufferedFragment(i11, i12);
        }

        public String toString() {
            return Integer.toHexString(this.fid);
        }
    }

    public DefaultFileSystem(APDULevelReadBinaryCapable aPDULevelReadBinaryCapable, boolean z11) {
        this(aPDULevelReadBinaryCapable, z11, LDSFileUtil.FID_TO_SFI);
    }

    private synchronized DefaultFileInfo getFileInfo() throws CardServiceException {
        byte[] bArr;
        short s11 = this.selectedFID;
        if (s11 > 0) {
            DefaultFileInfo defaultFileInfo = this.fileInfos.get(Short.valueOf(s11));
            if (defaultFileInfo != null) {
                return defaultFileInfo;
            }
            try {
                if (this.isSFIEnabled) {
                    Byte b11 = this.fidToSFI.get(Short.valueOf(this.selectedFID));
                    if (b11 != null) {
                        bArr = sendReadBinary((b11.byteValue() & 255) | 128, 0, 8, false);
                        this.isSelected = true;
                    } else {
                        throw new NumberFormatException("Unknown FID " + Integer.toHexString(this.selectedFID));
                    }
                } else {
                    if (!this.isSelected) {
                        sendSelectFile(this.selectedFID);
                        this.isSelected = true;
                    }
                    bArr = sendReadBinary(0, 8, false);
                }
                if (bArr != null) {
                    if (bArr.length != 0) {
                        int fileLength = getFileLength(this.selectedFID, 8, bArr);
                        if (fileLength < bArr.length) {
                            bArr = Arrays.copyOf(bArr, fileLength);
                        }
                        DefaultFileInfo defaultFileInfo2 = new DefaultFileInfo(this.selectedFID, fileLength);
                        defaultFileInfo2.addFragment(0, bArr);
                        this.fileInfos.put(Short.valueOf(this.selectedFID), defaultFileInfo2);
                        return defaultFileInfo2;
                    }
                }
                Logger logger = LOGGER;
                logger.warning("Something is wrong with prefix, prefix = " + Hex.bytesToHexString(bArr));
                return null;
            } catch (IOException e11) {
                throw new CardServiceException("Error getting file info for " + Integer.toHexString(this.selectedFID), (Throwable) e11);
            }
        } else {
            throw new CardServiceException("No file selected");
        }
    }

    private static int getFileLength(short s11, int i11, byte[] bArr) throws IOException {
        if (bArr.length < i11) {
            return bArr.length;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        TLVInputStream tLVInputStream = new TLVInputStream(byteArrayInputStream);
        try {
            if (tLVInputStream.readTag() == 66) {
                return 36;
            }
            int length = (bArr.length - byteArrayInputStream.available()) + tLVInputStream.readLength();
            try {
                tLVInputStream.close();
            } catch (IOException e11) {
                LOGGER.log(Level.FINE, "Error closing stream", e11);
            }
            return length;
        } finally {
            try {
                tLVInputStream.close();
            } catch (IOException e12) {
                LOGGER.log(Level.FINE, "Error closing stream", e12);
            }
        }
    }

    public int getMaxReadBinaryLength() {
        return this.maxReadBinaryLength;
    }

    public synchronized FileInfo[] getSelectedPath() throws CardServiceException {
        DefaultFileInfo fileInfo = getFileInfo();
        if (fileInfo == null) {
            return null;
        }
        return new DefaultFileInfo[]{fileInfo};
    }

    public APDUWrapper getWrapper() {
        return this.wrapper;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: org.jmrtd.DefaultFileSystem$DefaultFileInfo} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v14, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v15, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized byte[] readBinary(int r8, int r9) throws net.sf.scuba.smartcards.CardServiceException {
        /*
            r7 = this;
            monitor-enter(r7)
            r0 = 0
            r1 = 0
            short r2 = r7.selectedFID     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            if (r2 <= 0) goto L_0x00b7
            org.jmrtd.DefaultFileSystem$DefaultFileInfo r1 = r7.getFileInfo()     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            if (r1 == 0) goto L_0x00af
            int r2 = r7.maxReadBinaryLength     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            int r9 = java.lang.Math.min(r9, r2)     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            org.jmrtd.io.FragmentBuffer$Fragment r2 = r1.getSmallestUnbufferedFragment(r8, r9)     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            int r3 = r2.getLength()     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            if (r3 <= 0) goto L_0x00a4
            boolean r3 = r7.isSFIEnabled     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            r4 = 1
            if (r3 == 0) goto L_0x006a
            r3 = 256(0x100, float:3.59E-43)
            if (r8 >= r3) goto L_0x006a
            java.util.Map<java.lang.Short, java.lang.Byte> r3 = r7.fidToSFI     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            short r5 = r7.selectedFID     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            java.lang.Short r5 = java.lang.Short.valueOf(r5)     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            java.lang.Object r3 = r3.get(r5)     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            java.lang.Byte r3 = (java.lang.Byte) r3     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            if (r3 == 0) goto L_0x004d
            byte r3 = r3.byteValue()     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            r3 = r3 & 255(0xff, float:3.57E-43)
            r3 = r3 | 128(0x80, float:1.794E-43)
            int r5 = r2.getOffset()     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            int r6 = r2.getLength()     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            byte[] r3 = r7.sendReadBinary(r3, r5, r6, r0)     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            r7.isSelected = r4     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            goto L_0x0087
        L_0x004d:
            java.lang.NumberFormatException r8 = new java.lang.NumberFormatException     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            java.lang.StringBuilder r9 = new java.lang.StringBuilder     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            r9.<init>()     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            java.lang.String r2 = "Unknown FID "
            r9.append(r2)     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            short r2 = r7.selectedFID     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            java.lang.String r2 = java.lang.Integer.toHexString(r2)     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            r9.append(r2)     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            java.lang.String r9 = r9.toString()     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            r8.<init>(r9)     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            throw r8     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
        L_0x006a:
            boolean r3 = r7.isSelected     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            if (r3 != 0) goto L_0x0075
            short r3 = r7.selectedFID     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            r7.sendSelectFile(r3)     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            r7.isSelected = r4     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
        L_0x0075:
            int r3 = r2.getOffset()     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            int r5 = r2.getLength()     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            r6 = 32767(0x7fff, float:4.5916E-41)
            if (r8 <= r6) goto L_0x0082
            goto L_0x0083
        L_0x0082:
            r4 = r0
        L_0x0083:
            byte[] r3 = r7.sendReadBinary(r3, r5, r4)     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
        L_0x0087:
            if (r3 == 0) goto L_0x009c
            int r4 = r3.length     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            if (r4 <= 0) goto L_0x0093
            int r4 = r2.getOffset()     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            r1.addFragment(r4, r3)     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
        L_0x0093:
            int r4 = r3.length     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            int r2 = r2.getLength()     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            if (r4 >= r2) goto L_0x00a4
            int r9 = r3.length     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            goto L_0x00a4
        L_0x009c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            java.lang.String r9 = "Could not read bytes"
            r8.<init>(r9)     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            throw r8     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
        L_0x00a4:
            byte[] r2 = r1.getBuffer()     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            byte[] r3 = new byte[r9]     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            java.lang.System.arraycopy(r2, r8, r3, r0, r9)     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            monitor-exit(r7)
            return r3
        L_0x00af:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            java.lang.String r9 = "Could not get file info"
            r8.<init>(r9)     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            throw r8     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
        L_0x00b7:
            net.sf.scuba.smartcards.CardServiceException r8 = new net.sf.scuba.smartcards.CardServiceException     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            java.lang.String r9 = "No file selected"
            r8.<init>(r9)     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
            throw r8     // Catch:{ CardServiceException -> 0x00e1, Exception -> 0x00c1 }
        L_0x00bf:
            r8 = move-exception
            goto L_0x011b
        L_0x00c1:
            r8 = move-exception
            net.sf.scuba.smartcards.CardServiceException r9 = new net.sf.scuba.smartcards.CardServiceException     // Catch:{ all -> 0x00bf }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bf }
            r0.<init>()     // Catch:{ all -> 0x00bf }
            java.lang.String r2 = "Read binary failed on file "
            r0.append(r2)     // Catch:{ all -> 0x00bf }
            if (r1 != 0) goto L_0x00d6
            short r1 = r7.selectedFID     // Catch:{ all -> 0x00bf }
            java.lang.String r1 = java.lang.Integer.toHexString(r1)     // Catch:{ all -> 0x00bf }
        L_0x00d6:
            r0.append(r1)     // Catch:{ all -> 0x00bf }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00bf }
            r9.<init>((java.lang.String) r0, (java.lang.Throwable) r8)     // Catch:{ all -> 0x00bf }
            throw r9     // Catch:{ all -> 0x00bf }
        L_0x00e1:
            r8 = move-exception
            int r9 = r8.getSW()     // Catch:{ all -> 0x00bf }
            short r9 = (short) r9     // Catch:{ all -> 0x00bf }
            r2 = 26368(0x6700, float:3.695E-41)
            r9 = r9 & r2
            if (r9 != r2) goto L_0x00fc
            int r9 = r7.maxReadBinaryLength     // Catch:{ all -> 0x00bf }
            r2 = 223(0xdf, float:3.12E-43)
            if (r9 <= r2) goto L_0x00fc
            net.sf.scuba.smartcards.APDUWrapper r8 = r7.oldWrapper     // Catch:{ all -> 0x00bf }
            r7.wrapper = r8     // Catch:{ all -> 0x00bf }
            r7.maxReadBinaryLength = r2     // Catch:{ all -> 0x00bf }
            byte[] r8 = new byte[r0]     // Catch:{ all -> 0x00bf }
            monitor-exit(r7)
            return r8
        L_0x00fc:
            net.sf.scuba.smartcards.CardServiceException r9 = new net.sf.scuba.smartcards.CardServiceException     // Catch:{ all -> 0x00bf }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x00bf }
            r0.<init>()     // Catch:{ all -> 0x00bf }
            java.lang.String r2 = "Read binary failed on file "
            r0.append(r2)     // Catch:{ all -> 0x00bf }
            if (r1 != 0) goto L_0x0110
            short r1 = r7.selectedFID     // Catch:{ all -> 0x00bf }
            java.lang.String r1 = java.lang.Integer.toHexString(r1)     // Catch:{ all -> 0x00bf }
        L_0x0110:
            r0.append(r1)     // Catch:{ all -> 0x00bf }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x00bf }
            r9.<init>((java.lang.String) r0, (java.lang.Throwable) r8)     // Catch:{ all -> 0x00bf }
            throw r9     // Catch:{ all -> 0x00bf }
        L_0x011b:
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: org.jmrtd.DefaultFileSystem.readBinary(int, int):byte[]");
    }

    public synchronized void selectFile(short s11) throws CardServiceException {
        if (this.selectedFID != s11) {
            this.selectedFID = s11;
            this.isSelected = false;
        }
    }

    public synchronized byte[] sendReadBinary(int i11, int i12, boolean z11) throws CardServiceException {
        APDUWrapper aPDUWrapper = this.wrapper;
        if (aPDUWrapper instanceof SecureMessagingWrapper) {
            aPDUWrapper = SecureMessagingWrapper.getInstance((SecureMessagingWrapper) aPDUWrapper);
        }
        this.oldWrapper = aPDUWrapper;
        return this.service.sendReadBinary(this.wrapper, -1, i11, i12, false, z11);
    }

    public synchronized void sendSelectFile(short s11) throws CardServiceException {
        this.service.sendSelectFile(this.wrapper, s11);
    }

    public void setWrapper(APDUWrapper aPDUWrapper) {
        this.oldWrapper = this.wrapper;
        this.wrapper = aPDUWrapper;
    }

    public DefaultFileSystem(APDULevelReadBinaryCapable aPDULevelReadBinaryCapable, boolean z11, Map<Short, Byte> map) {
        this.service = aPDULevelReadBinaryCapable;
        this.fileInfos = new HashMap();
        this.selectedFID = 0;
        this.isSelected = false;
        this.isSFIEnabled = z11;
        this.fidToSFI = map;
        this.maxReadBinaryLength = 65536;
    }

    public synchronized byte[] sendReadBinary(int i11, int i12, int i13, boolean z11) throws CardServiceException {
        return this.service.sendReadBinary(this.wrapper, i11, i12, i13, true, z11);
    }
}
