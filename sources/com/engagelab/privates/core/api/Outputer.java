package com.engagelab.privates.core.api;

public class Outputer {
    private byte[] array;
    private int pos;
    private int saved_pos;

    public Outputer(int i11) {
        this.array = new byte[i11];
        this.pos = 0;
        this.saved_pos = -1;
    }

    private void check(long j11, int i11) {
    }

    private void need(int i11) {
        byte[] bArr = this.array;
        int length = bArr.length;
        int i12 = this.pos;
        if (length - i12 < i11) {
            int length2 = bArr.length * 2;
            int i13 = i11 + i12;
            if (length2 < i13) {
                length2 = i13;
            }
            byte[] bArr2 = new byte[length2];
            System.arraycopy(bArr, 0, bArr2, 0, i12);
            this.array = bArr2;
        }
    }

    public int current() {
        return this.pos;
    }

    public void jump(int i11) {
        if (i11 <= this.pos) {
            this.pos = i11;
            return;
        }
        throw new IllegalArgumentException("cannot jump past end of data");
    }

    public void restore() {
        int i11 = this.saved_pos;
        if (i11 >= 0) {
            this.pos = i11;
            this.saved_pos = -1;
            return;
        }
        throw new IllegalStateException("no previous state");
    }

    public void save() {
        this.saved_pos = this.pos;
    }

    public byte[] toByteArray() {
        int i11 = this.pos;
        byte[] bArr = new byte[i11];
        System.arraycopy(this.array, 0, bArr, 0, i11);
        return bArr;
    }

    public void writeByteArray(byte[] bArr, int i11, int i12) {
        need(i12);
        System.arraycopy(bArr, i11, this.array, this.pos, i12);
        this.pos += i12;
    }

    public void writeByteArrayIncludeLength(byte[] bArr) {
        writeU16(bArr.length);
        writeByteArray(bArr, 0, bArr.length);
    }

    public void writeCountedString(byte[] bArr) {
        if (bArr.length <= 255) {
            need(bArr.length + 1);
            byte[] bArr2 = this.array;
            int i11 = this.pos;
            this.pos = i11 + 1;
            bArr2[i11] = (byte) (255 & bArr.length);
            writeByteArray(bArr, 0, bArr.length);
            return;
        }
        throw new IllegalArgumentException("Invalid counted string");
    }

    public void writeU16(int i11) {
        check((long) i11, 16);
        need(2);
        byte[] bArr = this.array;
        int i12 = this.pos;
        int i13 = i12 + 1;
        this.pos = i13;
        bArr[i12] = (byte) ((i11 >>> 8) & 255);
        this.pos = i13 + 1;
        bArr[i13] = (byte) (i11 & 255);
    }

    public void writeU16At(int i11, int i12) {
        check((long) i11, 16);
        if (i12 <= this.pos - 2) {
            byte[] bArr = this.array;
            bArr[i12] = (byte) ((i11 >>> 8) & 255);
            bArr[i12 + 1] = (byte) (i11 & 255);
            return;
        }
        throw new IllegalArgumentException("cannot write past end of data");
    }

    public void writeU32(long j11) {
        check(j11, 32);
        need(4);
        byte[] bArr = this.array;
        int i11 = this.pos;
        int i12 = i11 + 1;
        this.pos = i12;
        bArr[i11] = (byte) ((int) ((j11 >>> 24) & 255));
        int i13 = i12 + 1;
        this.pos = i13;
        bArr[i12] = (byte) ((int) ((j11 >>> 16) & 255));
        int i14 = i13 + 1;
        this.pos = i14;
        bArr[i13] = (byte) ((int) ((j11 >>> 8) & 255));
        this.pos = i14 + 1;
        bArr[i14] = (byte) ((int) (j11 & 255));
    }

    public void writeU32At(long j11, int i11) {
        check(j11, 32);
        if (i11 <= this.pos - 4) {
            byte[] bArr = this.array;
            int i12 = i11 + 1;
            bArr[i11] = (byte) ((int) ((j11 >>> 24) & 255));
            int i13 = i12 + 1;
            bArr[i12] = (byte) ((int) ((j11 >>> 16) & 255));
            bArr[i13] = (byte) ((int) ((j11 >>> 8) & 255));
            bArr[i13 + 1] = (byte) ((int) (j11 & 255));
            return;
        }
        throw new IllegalArgumentException("cannot write past end of data");
    }

    public void writeU64(long j11) {
        need(8);
        byte[] bArr = this.array;
        int i11 = this.pos;
        int i12 = i11 + 1;
        this.pos = i12;
        bArr[i11] = (byte) ((int) ((j11 >>> 56) & 255));
        int i13 = i12 + 1;
        this.pos = i13;
        bArr[i12] = (byte) ((int) ((j11 >>> 48) & 255));
        int i14 = i13 + 1;
        this.pos = i14;
        bArr[i13] = (byte) ((int) ((j11 >>> 40) & 255));
        int i15 = i14 + 1;
        this.pos = i15;
        bArr[i14] = (byte) ((int) ((j11 >>> 32) & 255));
        int i16 = i15 + 1;
        this.pos = i16;
        bArr[i15] = (byte) ((int) ((j11 >>> 24) & 255));
        int i17 = i16 + 1;
        this.pos = i17;
        bArr[i16] = (byte) ((int) ((j11 >>> 16) & 255));
        int i18 = i17 + 1;
        this.pos = i18;
        bArr[i17] = (byte) ((int) ((j11 >>> 8) & 255));
        this.pos = i18 + 1;
        bArr[i18] = (byte) ((int) (j11 & 255));
    }

    public void writeU64At(long j11, int i11) {
        check(j11, 64);
        if (i11 <= this.pos - 8) {
            byte[] bArr = this.array;
            int i12 = i11 + 1;
            bArr[i11] = (byte) ((int) ((j11 >>> 56) & 255));
            int i13 = i12 + 1;
            bArr[i12] = (byte) ((int) ((j11 >>> 48) & 255));
            int i14 = i13 + 1;
            bArr[i13] = (byte) ((int) ((j11 >>> 40) & 255));
            int i15 = i14 + 1;
            bArr[i14] = (byte) ((int) ((j11 >>> 32) & 255));
            int i16 = i15 + 1;
            bArr[i15] = (byte) ((int) ((j11 >>> 24) & 255));
            int i17 = i16 + 1;
            bArr[i16] = (byte) ((int) ((j11 >>> 16) & 255));
            bArr[i17] = (byte) ((int) ((j11 >>> 8) & 255));
            bArr[i17 + 1] = (byte) ((int) (j11 & 255));
            return;
        }
        throw new IllegalArgumentException("cannot write past end of data");
    }

    public void writeU8(int i11) {
        check((long) i11, 8);
        need(1);
        byte[] bArr = this.array;
        int i12 = this.pos;
        this.pos = i12 + 1;
        bArr[i12] = (byte) (i11 & 255);
    }

    public void writeU8At(int i11, int i12) {
        check((long) i11, 8);
        if (i12 <= this.pos - 1) {
            this.array[i12] = (byte) (i11 & 255);
            return;
        }
        throw new IllegalArgumentException("cannot write past end of data");
    }

    public void writeByteArray(byte[] bArr) {
        writeByteArray(bArr, 0, bArr.length);
    }

    public Outputer() {
        this(32);
    }
}
