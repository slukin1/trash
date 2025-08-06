package org.bouncycastle.crypto.prng;

import com.google.common.base.Ascii;
import com.google.common.primitives.SignedBytes;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import okio.Utf8;
import org.bouncycastle.crypto.signers.PSSSigner;
import org.bouncycastle.util.Pack;
import org.jmrtd.lds.CVCAFile;

public class VMPCRandomGenerator implements RandomGenerator {
    private byte[] P = {-69, ISO7816.INS_UNBLOCK_CHV, ISOFileInfo.FCP_BYTE, Ascii.DEL, -75, -86, -44, 13, ISOFileInfo.DATA_BYTES2, -2, -78, -126, -53, ISOFileInfo.A0, ISOFileInfo.A1, 8, Ascii.CAN, 113, 86, -24, 73, 2, 16, -60, -34, 53, ISOFileInfo.A5, -20, Byte.MIN_VALUE, 18, -72, 105, ISO7816.INS_PUT_DATA, 47, 117, -52, -94, 9, 54, 3, 97, Framer.STDIN_FRAME_PREFIX, -3, ISO7816.INS_CREATE_FILE, -35, 5, 67, -112, -83, -56, -31, -81, 87, -101, 76, ISO7816.INS_LOAD_KEY_FILE, 81, -82, 80, ISOFileInfo.PROP_INFO, 60, 10, ISO7816.INS_DELETE_FILE, -13, -100, 38, 35, 83, -55, ISOFileInfo.FILE_IDENTIFIER, -105, 70, ISO7816.INS_READ_BINARY2, -103, 100, Framer.STDOUT_FRAME_PREFIX, 119, -43, 29, ISO7816.INS_UPDATE_BINARY, Framer.EXIT_FRAME_PREFIX, -67, 94, ISO7816.INS_READ_BINARY, ISOFileInfo.LCS_BYTE, ISO7816.INS_MSE, 56, -8, 104, 43, ISO7816.INS_PSO, -59, -45, -9, PSSSigner.TRAILER_IMPLICIT, ISOFileInfo.FCI_BYTE, -33, 4, -27, -107, 62, 37, -122, -90, 11, -113, -15, ISO7816.INS_CHANGE_CHV, 14, -41, SignedBytes.MAX_POWER_OF_TWO, ISO7816.INS_READ_RECORD2, -49, 126, 6, 21, -102, 77, 28, -93, -37, 50, -110, 88, 17, 39, -12, 89, ISO7816.INS_WRITE_BINARY, 78, 106, 23, 91, -84, -1, 7, ISO7816.INS_GET_RESPONSE, 101, 121, -4, -57, -51, 118, CVCAFile.CAR_TAG, 93, -25, 58, ISO7816.INS_DECREASE_STAMPED, 122, ISO7816.INS_DECREASE, 40, 15, 115, 1, -7, -47, ISO7816.INS_WRITE_RECORD, Ascii.EM, -23, -111, -71, 90, -19, 65, 109, ISO7816.INS_READ_BINARY_STAMPED, -61, -98, -65, 99, -6, Ascii.US, 51, 96, 71, -119, -16, -106, Ascii.SUB, 95, -109, 61, 55, 75, -39, -88, -63, Ascii.ESC, -10, 57, ISOFileInfo.SECURITY_ATTR_EXP, -73, 12, 32, -50, -120, 110, ISO7816.INS_READ_RECORD_STAMPED, 116, ISOFileInfo.CHANNEL_SECURITY, ISOFileInfo.ENV_TEMP_EF, 22, 41, -14, ISOFileInfo.FCI_EXT, -11, -21, ISO7816.INS_MANAGE_CHANNEL, -29, -5, 85, -97, -58, ISO7816.INS_REHABILITATE_CHV, 74, 69, 125, ISO7816.INS_APPEND_RECORD, 107, 92, 108, 102, -87, ISOFileInfo.SECURITY_ATTR_COMPACT, -18, -124, 19, -89, 30, -99, ISO7816.INS_UPDATE_RECORD, 103, 72, -70, 46, -26, -92, ISOFileInfo.AB, 124, -108, 0, Framer.ENTER_FRAME_PREFIX, -17, -22, -66, ISO7816.INS_GET_DATA, 114, 79, 82, -104, Utf8.REPLACEMENT_BYTE, ISO7816.INS_ENVELOPE, 20, 123, 59, 84};

    /* renamed from: n  reason: collision with root package name */
    private byte f59307n = 0;

    /* renamed from: s  reason: collision with root package name */
    private byte f59308s = -66;

    public void addSeedMaterial(long j11) {
        addSeedMaterial(Pack.longToBigEndian(j11));
    }

    public void addSeedMaterial(byte[] bArr) {
        for (byte b11 : bArr) {
            byte[] bArr2 = this.P;
            byte b12 = this.f59308s;
            byte b13 = this.f59307n;
            byte b14 = bArr2[(b12 + bArr2[b13 & 255] + b11) & 255];
            this.f59308s = b14;
            byte b15 = bArr2[b13 & 255];
            bArr2[b13 & 255] = bArr2[b14 & 255];
            bArr2[b14 & 255] = b15;
            this.f59307n = (byte) ((b13 + 1) & 255);
        }
    }

    public void nextBytes(byte[] bArr) {
        nextBytes(bArr, 0, bArr.length);
    }

    public void nextBytes(byte[] bArr, int i11, int i12) {
        synchronized (this.P) {
            int i13 = i12 + i11;
            while (i11 != i13) {
                byte[] bArr2 = this.P;
                byte b11 = this.f59308s;
                byte b12 = this.f59307n;
                byte b13 = bArr2[(b11 + bArr2[b12 & 255]) & 255];
                this.f59308s = b13;
                bArr[i11] = bArr2[(bArr2[bArr2[b13 & 255] & 255] + 1) & 255];
                byte b14 = bArr2[b12 & 255];
                bArr2[b12 & 255] = bArr2[b13 & 255];
                bArr2[b13 & 255] = b14;
                this.f59307n = (byte) ((b12 + 1) & 255);
                i11++;
            }
        }
    }
}
