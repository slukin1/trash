package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;

abstract class Token {
    public static final Token EMPTY = new SimpleToken((Token) null, 0, 0);
    private final Token previous;

    public Token(Token token) {
        this.previous = token;
    }

    public final Token add(int i11, int i12) {
        return new SimpleToken(this, i11, i12);
    }

    public final Token addBinaryShift(int i11, int i12) {
        return new BinaryShiftToken(this, i11, i12);
    }

    public abstract void appendTo(BitArray bitArray, byte[] bArr);

    public final Token getPrevious() {
        return this.previous;
    }
}
