package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

final class BinaryShiftToken extends Token {
    private final short binaryShiftByteCount;
    private final short binaryShiftStart;

    public BinaryShiftToken(Token token, int i11, int i12) {
        super(token);
        this.binaryShiftStart = (short) i11;
        this.binaryShiftByteCount = (short) i12;
    }

    public void appendTo(BitArray bitArray, byte[] bArr) {
        int i11 = 0;
        while (true) {
            short s11 = this.binaryShiftByteCount;
            if (i11 < s11) {
                if (i11 == 0 || (i11 == 31 && s11 <= 62)) {
                    bitArray.appendBits(31, 5);
                    short s12 = this.binaryShiftByteCount;
                    if (s12 > 62) {
                        bitArray.appendBits(s12 - 31, 16);
                    } else if (i11 == 0) {
                        bitArray.appendBits(Math.min(s12, 31), 5);
                    } else {
                        bitArray.appendBits(s12 - 31, 5);
                    }
                }
                bitArray.appendBits(bArr[this.binaryShiftStart + i11], 8);
                i11++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder("<");
        sb2.append(this.binaryShiftStart);
        sb2.append("::");
        sb2.append((this.binaryShiftStart + this.binaryShiftByteCount) - 1);
        sb2.append('>');
        return sb2.toString();
    }
}
