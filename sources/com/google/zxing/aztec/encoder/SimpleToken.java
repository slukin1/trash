package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

final class SimpleToken extends Token {
    private final short bitCount;
    private final short value;

    public SimpleToken(Token token, int i11, int i12) {
        super(token);
        this.value = (short) i11;
        this.bitCount = (short) i12;
    }

    public void appendTo(BitArray bitArray, byte[] bArr) {
        bitArray.appendBits(this.value, this.bitCount);
    }

    public String toString() {
        short s11 = this.value;
        short s12 = this.bitCount;
        short s13 = (s11 & ((1 << s12) - 1)) | (1 << s12);
        return "<" + Integer.toBinaryString(s13 | (1 << this.bitCount)).substring(1) + '>';
    }
}
