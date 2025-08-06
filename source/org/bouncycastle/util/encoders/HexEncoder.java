package org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Objects;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;

public class HexEncoder implements Encoder {
    public final byte[] decodingTable = new byte[128];
    public final byte[] encodingTable = {ISO7816.INS_DECREASE, Framer.STDOUT_FRAME_PREFIX, 50, 51, ISO7816.INS_DECREASE_STAMPED, 53, 54, 55, 56, 57, 97, ISOFileInfo.FCP_BYTE, 99, 100, 101, 102};

    public HexEncoder() {
        initialiseDecodingTable();
    }

    private static boolean ignore(char c11) {
        return c11 == 10 || c11 == 13 || c11 == 9 || c11 == ' ';
    }

    public int decode(String str, OutputStream outputStream) throws IOException {
        byte[] bArr = new byte[36];
        int length = str.length();
        while (length > 0 && ignore(str.charAt(length - 1))) {
            length--;
        }
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        while (i11 < length) {
            while (i11 < length && ignore(str.charAt(i11))) {
                i11++;
            }
            int i14 = i11 + 1;
            byte b11 = this.decodingTable[str.charAt(i11)];
            while (i14 < length && ignore(str.charAt(i14))) {
                i14++;
            }
            int i15 = i14 + 1;
            byte b12 = this.decodingTable[str.charAt(i14)];
            if ((b11 | b12) >= 0) {
                int i16 = i12 + 1;
                bArr[i12] = (byte) ((b11 << 4) | b12);
                if (i16 == 36) {
                    outputStream.write(bArr);
                    i12 = 0;
                } else {
                    i12 = i16;
                }
                i13++;
                i11 = i15;
            } else {
                throw new IOException("invalid characters encountered in Hex string");
            }
        }
        if (i12 > 0) {
            outputStream.write(bArr, 0, i12);
        }
        return i13;
    }

    public int decode(byte[] bArr, int i11, int i12, OutputStream outputStream) throws IOException {
        byte[] bArr2 = new byte[36];
        int i13 = i12 + i11;
        while (i13 > i11 && ignore((char) bArr[i13 - 1])) {
            i13--;
        }
        int i14 = 0;
        int i15 = 0;
        while (i11 < i13) {
            while (i11 < i13 && ignore((char) bArr[i11])) {
                i11++;
            }
            int i16 = i11 + 1;
            byte b11 = this.decodingTable[bArr[i11]];
            while (i16 < i13 && ignore((char) bArr[i16])) {
                i16++;
            }
            int i17 = i16 + 1;
            byte b12 = this.decodingTable[bArr[i16]];
            if ((b11 | b12) >= 0) {
                int i18 = i14 + 1;
                bArr2[i14] = (byte) ((b11 << 4) | b12);
                if (i18 == 36) {
                    outputStream.write(bArr2);
                    i14 = 0;
                } else {
                    i14 = i18;
                }
                i15++;
                i11 = i17;
            } else {
                throw new IOException("invalid characters encountered in Hex data");
            }
        }
        if (i14 > 0) {
            outputStream.write(bArr2, 0, i14);
        }
        return i15;
    }

    public byte[] decodeStrict(String str, int i11, int i12) throws IOException {
        Objects.requireNonNull(str, "'str' cannot be null");
        if (i11 < 0 || i12 < 0 || i11 > str.length() - i12) {
            throw new IndexOutOfBoundsException("invalid offset and/or length specified");
        } else if ((i12 & 1) == 0) {
            int i13 = i12 >>> 1;
            byte[] bArr = new byte[i13];
            int i14 = 0;
            while (i14 < i13) {
                int i15 = i11 + 1;
                int i16 = i15 + 1;
                byte b11 = (this.decodingTable[str.charAt(i11)] << 4) | this.decodingTable[str.charAt(i15)];
                if (b11 >= 0) {
                    bArr[i14] = (byte) b11;
                    i14++;
                    i11 = i16;
                } else {
                    throw new IOException("invalid characters encountered in Hex string");
                }
            }
            return bArr;
        } else {
            throw new IOException("a hexadecimal encoding must have an even number of characters");
        }
    }

    public int encode(byte[] bArr, int i11, int i12, OutputStream outputStream) throws IOException {
        if (i12 < 0) {
            return 0;
        }
        byte[] bArr2 = new byte[72];
        int i13 = i12;
        while (i13 > 0) {
            int min = Math.min(36, i13);
            outputStream.write(bArr2, 0, encode(bArr, i11, min, bArr2, 0));
            i11 += min;
            i13 -= min;
        }
        return i12 * 2;
    }

    public int encode(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws IOException {
        int i14 = i12 + i11;
        int i15 = i13;
        while (i11 < i14) {
            int i16 = i11 + 1;
            byte b11 = bArr[i11] & 255;
            int i17 = i15 + 1;
            byte[] bArr3 = this.encodingTable;
            bArr2[i15] = bArr3[b11 >>> 4];
            i15 = i17 + 1;
            bArr2[i17] = bArr3[b11 & 15];
            i11 = i16;
        }
        return i15 - i13;
    }

    public int getEncodedLength(int i11) {
        return i11 * 2;
    }

    public int getMaxDecodedLength(int i11) {
        return i11 / 2;
    }

    public void initialiseDecodingTable() {
        int i11 = 0;
        int i12 = 0;
        while (true) {
            byte[] bArr = this.decodingTable;
            if (i12 >= bArr.length) {
                break;
            }
            bArr[i12] = -1;
            i12++;
        }
        while (true) {
            byte[] bArr2 = this.encodingTable;
            if (i11 < bArr2.length) {
                this.decodingTable[bArr2[i11]] = (byte) i11;
                i11++;
            } else {
                byte[] bArr3 = this.decodingTable;
                bArr3[65] = bArr3[97];
                bArr3[66] = bArr3[98];
                bArr3[67] = bArr3[99];
                bArr3[68] = bArr3[100];
                bArr3[69] = bArr3[101];
                bArr3[70] = bArr3[102];
                return;
            }
        }
    }
}
