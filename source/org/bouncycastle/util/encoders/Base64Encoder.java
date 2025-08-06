package org.bouncycastle.util.encoders;

import java.io.IOException;
import java.io.OutputStream;
import net.sf.scuba.smartcards.ISO7816;
import net.sf.scuba.smartcards.ISOFileInfo;
import okio.Utf8;
import org.jmrtd.lds.CVCAFile;

public class Base64Encoder implements Encoder {
    public final byte[] decodingTable = new byte[128];
    public final byte[] encodingTable = {65, CVCAFile.CAR_TAG, 67, ISO7816.INS_REHABILITATE_CHV, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 97, ISOFileInfo.FCP_BYTE, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, ISOFileInfo.FCI_BYTE, ISO7816.INS_MANAGE_CHANNEL, 113, 114, 115, 116, 117, 118, 119, Framer.EXIT_FRAME_PREFIX, 121, 122, ISO7816.INS_DECREASE, Framer.STDOUT_FRAME_PREFIX, 50, 51, ISO7816.INS_DECREASE_STAMPED, 53, 54, 55, 56, 57, 43, 47};
    public byte padding = 61;

    public Base64Encoder() {
        initialiseDecodingTable();
    }

    private int decodeLastBlock(OutputStream outputStream, char c11, char c12, char c13, char c14) throws IOException {
        byte b11 = this.padding;
        if (c13 == b11) {
            if (c14 == b11) {
                byte[] bArr = this.decodingTable;
                byte b12 = bArr[c11];
                byte b13 = bArr[c12];
                if ((b12 | b13) >= 0) {
                    outputStream.write((b12 << 2) | (b13 >> 4));
                    return 1;
                }
                throw new IOException("invalid characters encountered at end of base64 data");
            }
            throw new IOException("invalid characters encountered at end of base64 data");
        } else if (c14 == b11) {
            byte[] bArr2 = this.decodingTable;
            byte b14 = bArr2[c11];
            byte b15 = bArr2[c12];
            byte b16 = bArr2[c13];
            if ((b14 | b15 | b16) >= 0) {
                outputStream.write((b14 << 2) | (b15 >> 4));
                outputStream.write((b15 << 4) | (b16 >> 2));
                return 2;
            }
            throw new IOException("invalid characters encountered at end of base64 data");
        } else {
            byte[] bArr3 = this.decodingTable;
            byte b17 = bArr3[c11];
            byte b18 = bArr3[c12];
            byte b19 = bArr3[c13];
            byte b21 = bArr3[c14];
            if ((b17 | b18 | b19 | b21) >= 0) {
                outputStream.write((b17 << 2) | (b18 >> 4));
                outputStream.write((b18 << 4) | (b19 >> 2));
                outputStream.write((b19 << 6) | b21);
                return 3;
            }
            throw new IOException("invalid characters encountered at end of base64 data");
        }
    }

    private boolean ignore(char c11) {
        return c11 == 10 || c11 == 13 || c11 == 9 || c11 == ' ';
    }

    private int nextI(String str, int i11, int i12) {
        while (i11 < i12 && ignore(str.charAt(i11))) {
            i11++;
        }
        return i11;
    }

    private int nextI(byte[] bArr, int i11, int i12) {
        while (i11 < i12 && ignore((char) bArr[i11])) {
            i11++;
        }
        return i11;
    }

    public int decode(String str, OutputStream outputStream) throws IOException {
        String str2 = str;
        OutputStream outputStream2 = outputStream;
        byte[] bArr = new byte[54];
        int length = str.length();
        while (length > 0 && ignore(str2.charAt(length - 1))) {
            length--;
        }
        if (length == 0) {
            return 0;
        }
        int i11 = length;
        int i12 = 0;
        while (i11 > 0 && i12 != 4) {
            if (!ignore(str2.charAt(i11 - 1))) {
                i12++;
            }
            i11--;
        }
        int nextI = nextI(str2, 0, i11);
        int i13 = 0;
        int i14 = 0;
        while (nextI < i11) {
            int i15 = nextI + 1;
            byte b11 = this.decodingTable[str2.charAt(nextI)];
            int nextI2 = nextI(str2, i15, i11);
            int i16 = nextI2 + 1;
            byte b12 = this.decodingTable[str2.charAt(nextI2)];
            int nextI3 = nextI(str2, i16, i11);
            int i17 = nextI3 + 1;
            byte b13 = this.decodingTable[str2.charAt(nextI3)];
            int nextI4 = nextI(str2, i17, i11);
            int i18 = nextI4 + 1;
            byte b14 = this.decodingTable[str2.charAt(nextI4)];
            if ((b11 | b12 | b13 | b14) >= 0) {
                int i19 = i13 + 1;
                bArr[i13] = (byte) ((b11 << 2) | (b12 >> 4));
                int i21 = i19 + 1;
                bArr[i19] = (byte) ((b12 << 4) | (b13 >> 2));
                i13 = i21 + 1;
                bArr[i21] = (byte) ((b13 << 6) | b14);
                i14 += 3;
                if (i13 == 54) {
                    outputStream2.write(bArr);
                    i13 = 0;
                }
                nextI = nextI(str2, i18, i11);
            } else {
                throw new IOException("invalid characters encountered in base64 data");
            }
        }
        if (i13 > 0) {
            outputStream2.write(bArr, 0, i13);
        }
        int nextI5 = nextI(str2, nextI, length);
        int nextI6 = nextI(str2, nextI5 + 1, length);
        int nextI7 = nextI(str2, nextI6 + 1, length);
        return i14 + decodeLastBlock(outputStream, str2.charAt(nextI5), str2.charAt(nextI6), str2.charAt(nextI7), str2.charAt(nextI(str2, nextI7 + 1, length)));
    }

    public int decode(byte[] bArr, int i11, int i12, OutputStream outputStream) throws IOException {
        byte[] bArr2 = bArr;
        int i13 = i11;
        OutputStream outputStream2 = outputStream;
        byte[] bArr3 = new byte[54];
        int i14 = i13 + i12;
        while (i14 > i13 && ignore((char) bArr2[i14 - 1])) {
            i14--;
        }
        if (i14 == 0) {
            return 0;
        }
        int i15 = i14;
        int i16 = 0;
        while (i15 > i13 && i16 != 4) {
            if (!ignore((char) bArr2[i15 - 1])) {
                i16++;
            }
            i15--;
        }
        int nextI = nextI(bArr2, i13, i15);
        int i17 = 0;
        int i18 = 0;
        while (nextI < i15) {
            int i19 = nextI + 1;
            byte b11 = this.decodingTable[bArr2[nextI]];
            int nextI2 = nextI(bArr2, i19, i15);
            int i21 = nextI2 + 1;
            byte b12 = this.decodingTable[bArr2[nextI2]];
            int nextI3 = nextI(bArr2, i21, i15);
            int i22 = nextI3 + 1;
            byte b13 = this.decodingTable[bArr2[nextI3]];
            int nextI4 = nextI(bArr2, i22, i15);
            int i23 = nextI4 + 1;
            byte b14 = this.decodingTable[bArr2[nextI4]];
            if ((b11 | b12 | b13 | b14) >= 0) {
                int i24 = i17 + 1;
                bArr3[i17] = (byte) ((b11 << 2) | (b12 >> 4));
                int i25 = i24 + 1;
                bArr3[i24] = (byte) ((b12 << 4) | (b13 >> 2));
                i17 = i25 + 1;
                bArr3[i25] = (byte) ((b13 << 6) | b14);
                if (i17 == 54) {
                    outputStream2.write(bArr3);
                    i17 = 0;
                }
                i18 += 3;
                nextI = nextI(bArr2, i23, i15);
            } else {
                throw new IOException("invalid characters encountered in base64 data");
            }
        }
        if (i17 > 0) {
            outputStream2.write(bArr3, 0, i17);
        }
        int nextI5 = nextI(bArr2, nextI, i14);
        int nextI6 = nextI(bArr2, nextI5 + 1, i14);
        int nextI7 = nextI(bArr2, nextI6 + 1, i14);
        return i18 + decodeLastBlock(outputStream, (char) bArr2[nextI5], (char) bArr2[nextI6], (char) bArr2[nextI7], (char) bArr2[nextI(bArr2, nextI7 + 1, i14)]);
    }

    public int encode(byte[] bArr, int i11, int i12, OutputStream outputStream) throws IOException {
        if (i12 < 0) {
            return 0;
        }
        byte[] bArr2 = new byte[72];
        int i13 = i12;
        while (i13 > 0) {
            int min = Math.min(54, i13);
            outputStream.write(bArr2, 0, encode(bArr, i11, min, bArr2, 0));
            i11 += min;
            i13 -= min;
        }
        return ((i12 + 2) / 3) * 4;
    }

    public int encode(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws IOException {
        int i14 = (i11 + i12) - 2;
        int i15 = i11;
        int i16 = i13;
        while (i15 < i14) {
            int i17 = i15 + 1;
            byte b11 = bArr[i15];
            int i18 = i17 + 1;
            byte b12 = bArr[i17] & 255;
            int i19 = i18 + 1;
            byte b13 = bArr[i18] & 255;
            int i21 = i16 + 1;
            byte[] bArr3 = this.encodingTable;
            bArr2[i16] = bArr3[(b11 >>> 2) & 63];
            int i22 = i21 + 1;
            bArr2[i21] = bArr3[((b11 << 4) | (b12 >>> 4)) & 63];
            int i23 = i22 + 1;
            bArr2[i22] = bArr3[((b12 << 2) | (b13 >>> 6)) & 63];
            i16 = i23 + 1;
            bArr2[i23] = bArr3[b13 & Utf8.REPLACEMENT_BYTE];
            i15 = i19;
        }
        int i24 = i12 - (i15 - i11);
        if (i24 == 1) {
            byte b14 = bArr[i15] & 255;
            int i25 = i16 + 1;
            byte[] bArr4 = this.encodingTable;
            bArr2[i16] = bArr4[(b14 >>> 2) & 63];
            int i26 = i25 + 1;
            bArr2[i25] = bArr4[(b14 << 4) & 63];
            int i27 = i26 + 1;
            byte b15 = this.padding;
            bArr2[i26] = b15;
            i16 = i27 + 1;
            bArr2[i27] = b15;
        } else if (i24 == 2) {
            byte b16 = bArr[i15] & 255;
            byte b17 = bArr[i15 + 1] & 255;
            int i28 = i16 + 1;
            byte[] bArr5 = this.encodingTable;
            bArr2[i16] = bArr5[(b16 >>> 2) & 63];
            int i29 = i28 + 1;
            bArr2[i28] = bArr5[((b16 << 4) | (b17 >>> 4)) & 63];
            int i30 = i29 + 1;
            bArr2[i29] = bArr5[(b17 << 2) & 63];
            i16 = i30 + 1;
            bArr2[i30] = this.padding;
        }
        return i16 - i13;
    }

    public int getEncodedLength(int i11) {
        return ((i11 + 2) / 3) * 4;
    }

    public int getMaxDecodedLength(int i11) {
        return (i11 / 4) * 3;
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
                return;
            }
        }
    }
}
