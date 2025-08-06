package org.bouncycastle.util.encoders;

import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;

public class HexTranslator implements Translator {
    private static final byte[] hexTable = {ISO7816.INS_DECREASE, Framer.STDOUT_FRAME_PREFIX, 50, 51, ISO7816.INS_DECREASE_STAMPED, 53, 54, 55, 56, 57, 97, ISOFileInfo.FCP_BYTE, 99, 100, 101, 102};

    public int decode(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) {
        int i14 = i12 / 2;
        for (int i15 = 0; i15 < i14; i15++) {
            int i16 = (i15 * 2) + i11;
            byte b11 = bArr[i16];
            byte b12 = bArr[i16 + 1];
            if (b11 < 97) {
                bArr2[i13] = (byte) ((b11 + ISO7816.INS_WRITE_BINARY) << 4);
            } else {
                bArr2[i13] = (byte) (((b11 - 97) + 10) << 4);
            }
            if (b12 < 97) {
                bArr2[i13] = (byte) (bArr2[i13] + ((byte) (b12 + ISO7816.INS_WRITE_BINARY)));
            } else {
                bArr2[i13] = (byte) (bArr2[i13] + ((byte) ((b12 - 97) + 10)));
            }
            i13++;
        }
        return i14;
    }

    public int encode(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) {
        int i14 = 0;
        int i15 = 0;
        while (i14 < i12) {
            int i16 = i13 + i15;
            byte[] bArr3 = hexTable;
            bArr2[i16] = bArr3[(bArr[i11] >> 4) & 15];
            bArr2[i16 + 1] = bArr3[bArr[i11] & 15];
            i11++;
            i14++;
            i15 += 2;
        }
        return i12 * 2;
    }

    public int getDecodedBlockSize() {
        return 1;
    }

    public int getEncodedBlockSize() {
        return 2;
    }
}
