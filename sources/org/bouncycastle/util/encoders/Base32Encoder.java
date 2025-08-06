package org.bouncycastle.util.encoders;

import com.google.common.base.Ascii;
import java.io.IOException;
import java.io.OutputStream;
import net.sf.scuba.smartcards.ISO7816;
import org.bouncycastle.util.Arrays;
import org.bouncycastle.util.Strings;
import org.jmrtd.lds.CVCAFile;

public class Base32Encoder implements Encoder {
    private static final byte[] DEAULT_ENCODING_TABLE = {65, CVCAFile.CAR_TAG, 67, ISO7816.INS_REHABILITATE_CHV, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 50, 51, ISO7816.INS_DECREASE_STAMPED, 53, 54, 55};
    private static final byte DEFAULT_PADDING = 61;
    private final byte[] decodingTable;
    private final byte[] encodingTable;
    private final byte padding;

    public Base32Encoder() {
        this.decodingTable = new byte[128];
        this.encodingTable = DEAULT_ENCODING_TABLE;
        this.padding = DEFAULT_PADDING;
        initialiseDecodingTable();
    }

    public Base32Encoder(byte[] bArr, byte b11) {
        this.decodingTable = new byte[128];
        if (bArr.length == 32) {
            this.encodingTable = Arrays.clone(bArr);
            this.padding = b11;
            initialiseDecodingTable();
            return;
        }
        throw new IllegalArgumentException("encoding table needs to be length 32");
    }

    private int decodeLastBlock(OutputStream outputStream, char c11, char c12, char c13, char c14, char c15, char c16, char c17, char c18) throws IOException {
        byte b11 = this.padding;
        if (c18 != b11) {
            byte[] bArr = this.decodingTable;
            byte b12 = bArr[c11];
            byte b13 = bArr[c12];
            byte b14 = bArr[c13];
            byte b15 = bArr[c14];
            byte b16 = bArr[c15];
            byte b17 = bArr[c16];
            byte b18 = bArr[c17];
            byte b19 = bArr[c18];
            if ((b12 | b13 | b14 | b15 | b16 | b17 | b18 | b19) >= 0) {
                outputStream.write((b12 << 3) | (b13 >> 2));
                outputStream.write((b13 << 6) | (b14 << 1) | (b15 >> 4));
                outputStream.write((b15 << 4) | (b16 >> 1));
                outputStream.write((b16 << 7) | (b17 << 2) | (b18 >> 3));
                outputStream.write((b18 << 5) | b19);
                return 5;
            }
            throw new IOException("invalid characters encountered at end of base32 data");
        } else if (c17 != b11) {
            byte[] bArr2 = this.decodingTable;
            byte b21 = bArr2[c11];
            byte b22 = bArr2[c12];
            byte b23 = bArr2[c13];
            byte b24 = bArr2[c14];
            byte b25 = bArr2[c15];
            byte b26 = bArr2[c16];
            byte b27 = bArr2[c17];
            if ((b21 | b22 | b23 | b24 | b25 | b26 | b27) >= 0) {
                outputStream.write((b21 << 3) | (b22 >> 2));
                outputStream.write((b22 << 6) | (b23 << 1) | (b24 >> 4));
                outputStream.write((b24 << 4) | (b25 >> 1));
                outputStream.write((b25 << 7) | (b26 << 2) | (b27 >> 3));
                return 4;
            }
            throw new IOException("invalid characters encountered at end of base32 data");
        } else if (c16 != b11) {
            throw new IOException("invalid characters encountered at end of base32 data");
        } else if (c15 != b11) {
            byte[] bArr3 = this.decodingTable;
            byte b28 = bArr3[c11];
            byte b29 = bArr3[c12];
            byte b31 = bArr3[c13];
            byte b32 = bArr3[c14];
            byte b33 = bArr3[c15];
            if ((b28 | b29 | b31 | b32 | b33) >= 0) {
                outputStream.write((b28 << 3) | (b29 >> 2));
                outputStream.write((b29 << 6) | (b31 << 1) | (b32 >> 4));
                outputStream.write((b32 << 4) | (b33 >> 1));
                return 3;
            }
            throw new IOException("invalid characters encountered at end of base32 data");
        } else if (c14 != b11) {
            byte[] bArr4 = this.decodingTable;
            byte b34 = bArr4[c11];
            byte b35 = bArr4[c12];
            byte b36 = bArr4[c13];
            byte b37 = bArr4[c14];
            if ((b34 | b35 | b36 | b37) >= 0) {
                outputStream.write((b34 << 3) | (b35 >> 2));
                outputStream.write((b35 << 6) | (b36 << 1) | (b37 >> 4));
                return 2;
            }
            throw new IOException("invalid characters encountered at end of base32 data");
        } else if (c13 == b11) {
            byte[] bArr5 = this.decodingTable;
            byte b38 = bArr5[c11];
            byte b39 = bArr5[c12];
            if ((b38 | b39) >= 0) {
                outputStream.write((b38 << 3) | (b39 >> 2));
                return 1;
            }
            throw new IOException("invalid characters encountered at end of base32 data");
        } else {
            throw new IOException("invalid characters encountered at end of base32 data");
        }
    }

    private void encodeBlock(byte[] bArr, int i11, byte[] bArr2, int i12) {
        int i13 = i11 + 1;
        byte b11 = bArr[i11];
        int i14 = i13 + 1;
        byte b12 = bArr[i13] & 255;
        int i15 = i14 + 1;
        byte b13 = bArr[i14] & 255;
        int i16 = i15 + 1;
        byte b14 = bArr[i15] & 255;
        byte b15 = bArr[i16] & 255;
        int i17 = i12 + 1;
        byte[] bArr3 = this.encodingTable;
        bArr2[i12] = bArr3[(b11 >>> 3) & 31];
        int i18 = i17 + 1;
        bArr2[i17] = bArr3[((b11 << 2) | (b12 >>> 6)) & 31];
        int i19 = i18 + 1;
        bArr2[i18] = bArr3[(b12 >>> 1) & 31];
        int i21 = i19 + 1;
        bArr2[i19] = bArr3[((b12 << 4) | (b13 >>> 4)) & 31];
        int i22 = i21 + 1;
        bArr2[i21] = bArr3[((b13 << 1) | (b14 >>> 7)) & 31];
        int i23 = i22 + 1;
        bArr2[i22] = bArr3[(b14 >>> 2) & 31];
        bArr2[i23] = bArr3[((b14 << 3) | (b15 >>> 5)) & 31];
        bArr2[i23 + 1] = bArr3[b15 & Ascii.US];
    }

    private boolean ignore(char c11) {
        return c11 == 10 || c11 == 13 || c11 == 9 || c11 == ' ';
    }

    private int nextI(byte[] bArr, int i11, int i12) {
        while (i11 < i12 && ignore((char) bArr[i11])) {
            i11++;
        }
        return i11;
    }

    public int decode(String str, OutputStream outputStream) throws IOException {
        byte[] byteArray = Strings.toByteArray(str);
        return decode(byteArray, 0, byteArray.length, outputStream);
    }

    public int decode(byte[] bArr, int i11, int i12, OutputStream outputStream) throws IOException {
        byte[] bArr2 = bArr;
        int i13 = i11;
        OutputStream outputStream2 = outputStream;
        byte[] bArr3 = new byte[55];
        int i14 = i13 + i12;
        while (i14 > i13 && ignore((char) bArr2[i14 - 1])) {
            i14--;
        }
        if (i14 == 0) {
            return 0;
        }
        int i15 = i14;
        int i16 = 0;
        while (i15 > i13 && i16 != 8) {
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
            int nextI5 = nextI(bArr2, i23, i15);
            int i24 = nextI5 + 1;
            byte b15 = this.decodingTable[bArr2[nextI5]];
            int nextI6 = nextI(bArr2, i24, i15);
            int i25 = nextI6 + 1;
            byte b16 = this.decodingTable[bArr2[nextI6]];
            int nextI7 = nextI(bArr2, i25, i15);
            int i26 = i14;
            int i27 = nextI7 + 1;
            byte b17 = this.decodingTable[bArr2[nextI7]];
            int nextI8 = nextI(bArr2, i27, i15);
            int i28 = i15;
            int i29 = nextI8 + 1;
            byte b18 = this.decodingTable[bArr2[nextI8]];
            if ((b11 | b12 | b13 | b14 | b15 | b16 | b17 | b18) >= 0) {
                int i30 = i17 + 1;
                bArr3[i17] = (byte) ((b11 << 3) | (b12 >> 2));
                int i31 = i30 + 1;
                bArr3[i30] = (byte) ((b12 << 6) | (b13 << 1) | (b14 >> 4));
                int i32 = i31 + 1;
                bArr3[i31] = (byte) ((b14 << 4) | (b15 >> 1));
                int i33 = i32 + 1;
                bArr3[i32] = (byte) ((b16 << 2) | (b15 << 7) | (b17 >> 3));
                int i34 = i33 + 1;
                bArr3[i33] = (byte) ((b17 << 5) | b18);
                if (i34 == 55) {
                    outputStream2.write(bArr3);
                    i17 = 0;
                } else {
                    i17 = i34;
                }
                i18 += 5;
                int i35 = i28;
                int nextI9 = nextI(bArr2, i29, i35);
                i15 = i35;
                i14 = i26;
                nextI = nextI9;
            } else {
                throw new IOException("invalid characters encountered in base32 data");
            }
        }
        int i36 = i14;
        if (i17 > 0) {
            outputStream2.write(bArr3, 0, i17);
        }
        int i37 = i36;
        int nextI10 = nextI(bArr2, nextI, i37);
        int nextI11 = nextI(bArr2, nextI10 + 1, i37);
        int nextI12 = nextI(bArr2, nextI11 + 1, i37);
        int nextI13 = nextI(bArr2, nextI12 + 1, i37);
        int nextI14 = nextI(bArr2, nextI13 + 1, i37);
        int nextI15 = nextI(bArr2, nextI14 + 1, i37);
        int nextI16 = nextI(bArr2, nextI15 + 1, i37);
        return i18 + decodeLastBlock(outputStream, (char) bArr2[nextI10], (char) bArr2[nextI11], (char) bArr2[nextI12], (char) bArr2[nextI13], (char) bArr2[nextI14], (char) bArr2[nextI15], (char) bArr2[nextI16], (char) bArr2[nextI(bArr2, nextI16 + 1, i37)]);
    }

    public int encode(byte[] bArr, int i11, int i12, OutputStream outputStream) throws IOException {
        if (i12 < 0) {
            return 0;
        }
        byte[] bArr2 = new byte[72];
        int i13 = i12;
        while (i13 > 0) {
            int min = Math.min(45, i13);
            outputStream.write(bArr2, 0, encode(bArr, i11, min, bArr2, 0));
            i11 += min;
            i13 -= min;
        }
        return ((i12 + 2) / 3) * 4;
    }

    public int encode(byte[] bArr, int i11, int i12, byte[] bArr2, int i13) throws IOException {
        int i14 = (i11 + i12) - 4;
        int i15 = i11;
        int i16 = i13;
        while (i15 < i14) {
            encodeBlock(bArr, i15, bArr2, i16);
            i15 += 5;
            i16 += 8;
        }
        int i17 = i12 - (i15 - i11);
        if (i17 > 0) {
            byte[] bArr3 = new byte[5];
            System.arraycopy(bArr, i15, bArr3, 0, i17);
            encodeBlock(bArr3, 0, bArr2, i16);
            if (i17 == 1) {
                byte b11 = this.padding;
                bArr2[i16 + 2] = b11;
                bArr2[i16 + 3] = b11;
                bArr2[i16 + 4] = b11;
                bArr2[i16 + 5] = b11;
                bArr2[i16 + 6] = b11;
                bArr2[i16 + 7] = b11;
            } else if (i17 == 2) {
                byte b12 = this.padding;
                bArr2[i16 + 4] = b12;
                bArr2[i16 + 5] = b12;
                bArr2[i16 + 6] = b12;
                bArr2[i16 + 7] = b12;
            } else if (i17 == 3) {
                byte b13 = this.padding;
                bArr2[i16 + 5] = b13;
                bArr2[i16 + 6] = b13;
                bArr2[i16 + 7] = b13;
            } else if (i17 == 4) {
                bArr2[i16 + 7] = this.padding;
            }
            i16 += 8;
        }
        return i16 - i13;
    }

    public int getEncodedLength(int i11) {
        return ((i11 + 4) / 5) * 8;
    }

    public int getMaxDecodedLength(int i11) {
        return (i11 / 8) * 5;
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
