package com.google.zxing.aztec.encoder;

import com.google.zxing.common.BitArray;
import java.util.LinkedList;

final class State {
    public static final State INITIAL_STATE = new State(Token.EMPTY, 0, 0, 0);
    private final int binaryShiftByteCount;
    private final int bitCount;
    private final int mode;
    private final Token token;

    private State(Token token2, int i11, int i12, int i13) {
        this.token = token2;
        this.mode = i11;
        this.binaryShiftByteCount = i12;
        this.bitCount = i13;
    }

    public State addBinaryShiftChar(int i11) {
        Token token2 = this.token;
        int i12 = this.mode;
        int i13 = this.bitCount;
        if (i12 == 4 || i12 == 2) {
            int i14 = HighLevelEncoder.LATCH_TABLE[i12][0];
            int i15 = 65535 & i14;
            int i16 = i14 >> 16;
            token2 = token2.add(i15, i16);
            i13 += i16;
            i12 = 0;
        }
        int i17 = this.binaryShiftByteCount;
        State state = new State(token2, i12, i17 + 1, i13 + ((i17 == 0 || i17 == 31) ? 18 : i17 == 62 ? 9 : 8));
        return state.binaryShiftByteCount == 2078 ? state.endBinaryShift(i11 + 1) : state;
    }

    public State endBinaryShift(int i11) {
        int i12 = this.binaryShiftByteCount;
        if (i12 == 0) {
            return this;
        }
        return new State(this.token.addBinaryShift(i11 - i12, i12), this.mode, 0, this.bitCount);
    }

    public int getBinaryShiftByteCount() {
        return this.binaryShiftByteCount;
    }

    public int getBitCount() {
        return this.bitCount;
    }

    public int getMode() {
        return this.mode;
    }

    public Token getToken() {
        return this.token;
    }

    public boolean isBetterThanOrEqualTo(State state) {
        int i11;
        int i12 = this.bitCount + (HighLevelEncoder.LATCH_TABLE[this.mode][state.mode] >> 16);
        int i13 = state.binaryShiftByteCount;
        if (i13 > 0 && ((i11 = this.binaryShiftByteCount) == 0 || i11 > i13)) {
            i12 += 10;
        }
        return i12 <= state.bitCount;
    }

    public State latchAndAppend(int i11, int i12) {
        int i13 = this.bitCount;
        Token token2 = this.token;
        int i14 = this.mode;
        if (i11 != i14) {
            int i15 = HighLevelEncoder.LATCH_TABLE[i14][i11];
            int i16 = 65535 & i15;
            int i17 = i15 >> 16;
            token2 = token2.add(i16, i17);
            i13 += i17;
        }
        int i18 = i11 == 2 ? 4 : 5;
        return new State(token2.add(i12, i18), i11, 0, i13 + i18);
    }

    public State shiftAndAppend(int i11, int i12) {
        Token token2 = this.token;
        int i13 = this.mode;
        int i14 = i13 == 2 ? 4 : 5;
        return new State(token2.add(HighLevelEncoder.SHIFT_TABLE[i13][i11], i14).add(i12, 5), this.mode, 0, this.bitCount + i14 + 5);
    }

    public BitArray toBitArray(byte[] bArr) {
        LinkedList<Token> linkedList = new LinkedList<>();
        for (Token token2 = endBinaryShift(bArr.length).token; token2 != null; token2 = token2.getPrevious()) {
            linkedList.addFirst(token2);
        }
        BitArray bitArray = new BitArray();
        for (Token appendTo : linkedList) {
            appendTo.appendTo(bitArray, bArr);
        }
        return bitArray;
    }

    public String toString() {
        return String.format("%s bits=%d bytes=%d", new Object[]{HighLevelEncoder.MODE_NAMES[this.mode], Integer.valueOf(this.bitCount), Integer.valueOf(this.binaryShiftByteCount)});
    }
}
