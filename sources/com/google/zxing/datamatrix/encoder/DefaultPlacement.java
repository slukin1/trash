package com.google.zxing.datamatrix.encoder;

import java.util.Arrays;

public class DefaultPlacement {
    private final byte[] bits;
    private final CharSequence codewords;
    private final int numcols;
    private final int numrows;

    public DefaultPlacement(CharSequence charSequence, int i11, int i12) {
        this.codewords = charSequence;
        this.numcols = i11;
        this.numrows = i12;
        byte[] bArr = new byte[(i11 * i12)];
        this.bits = bArr;
        Arrays.fill(bArr, (byte) -1);
    }

    private void corner1(int i11) {
        module(this.numrows - 1, 0, i11, 1);
        module(this.numrows - 1, 1, i11, 2);
        module(this.numrows - 1, 2, i11, 3);
        module(0, this.numcols - 2, i11, 4);
        module(0, this.numcols - 1, i11, 5);
        module(1, this.numcols - 1, i11, 6);
        module(2, this.numcols - 1, i11, 7);
        module(3, this.numcols - 1, i11, 8);
    }

    private void corner2(int i11) {
        module(this.numrows - 3, 0, i11, 1);
        module(this.numrows - 2, 0, i11, 2);
        module(this.numrows - 1, 0, i11, 3);
        module(0, this.numcols - 4, i11, 4);
        module(0, this.numcols - 3, i11, 5);
        module(0, this.numcols - 2, i11, 6);
        module(0, this.numcols - 1, i11, 7);
        module(1, this.numcols - 1, i11, 8);
    }

    private void corner3(int i11) {
        module(this.numrows - 3, 0, i11, 1);
        module(this.numrows - 2, 0, i11, 2);
        module(this.numrows - 1, 0, i11, 3);
        module(0, this.numcols - 2, i11, 4);
        module(0, this.numcols - 1, i11, 5);
        module(1, this.numcols - 1, i11, 6);
        module(2, this.numcols - 1, i11, 7);
        module(3, this.numcols - 1, i11, 8);
    }

    private void corner4(int i11) {
        module(this.numrows - 1, 0, i11, 1);
        module(this.numrows - 1, this.numcols - 1, i11, 2);
        module(0, this.numcols - 3, i11, 3);
        module(0, this.numcols - 2, i11, 4);
        module(0, this.numcols - 1, i11, 5);
        module(1, this.numcols - 3, i11, 6);
        module(1, this.numcols - 2, i11, 7);
        module(1, this.numcols - 1, i11, 8);
    }

    private boolean hasBit(int i11, int i12) {
        return this.bits[(i12 * this.numcols) + i11] >= 0;
    }

    private void module(int i11, int i12, int i13, int i14) {
        if (i11 < 0) {
            int i15 = this.numrows;
            i11 += i15;
            i12 += 4 - ((i15 + 4) % 8);
        }
        if (i12 < 0) {
            int i16 = this.numcols;
            i12 += i16;
            i11 += 4 - ((i16 + 4) % 8);
        }
        boolean z11 = true;
        if ((this.codewords.charAt(i13) & (1 << (8 - i14))) == 0) {
            z11 = false;
        }
        setBit(i12, i11, z11);
    }

    private void setBit(int i11, int i12, boolean z11) {
        this.bits[(i12 * this.numcols) + i11] = z11 ? (byte) 1 : 0;
    }

    private void utah(int i11, int i12, int i13) {
        int i14 = i11 - 2;
        int i15 = i12 - 2;
        module(i14, i15, i13, 1);
        int i16 = i12 - 1;
        module(i14, i16, i13, 2);
        int i17 = i11 - 1;
        module(i17, i15, i13, 3);
        module(i17, i16, i13, 4);
        module(i17, i12, i13, 5);
        module(i11, i15, i13, 6);
        module(i11, i16, i13, 7);
        module(i11, i12, i13, 8);
    }

    public final boolean getBit(int i11, int i12) {
        return this.bits[(i12 * this.numcols) + i11] == 1;
    }

    public final byte[] getBits() {
        return this.bits;
    }

    public final int getNumcols() {
        return this.numcols;
    }

    public final int getNumrows() {
        return this.numrows;
    }

    public final void place() {
        int i11;
        int i12;
        int i13 = 0;
        int i14 = 0;
        int i15 = 4;
        while (true) {
            if (i15 == this.numrows && i13 == 0) {
                corner1(i14);
                i14++;
            }
            if (i15 == this.numrows - 2 && i13 == 0 && this.numcols % 4 != 0) {
                corner2(i14);
                i14++;
            }
            if (i15 == this.numrows - 2 && i13 == 0 && this.numcols % 8 == 4) {
                corner3(i14);
                i14++;
            }
            if (i15 == this.numrows + 4 && i13 == 2 && this.numcols % 8 == 0) {
                corner4(i14);
                i14++;
            }
            do {
                if (i15 < this.numrows && i13 >= 0 && !hasBit(i13, i15)) {
                    utah(i15, i13, i14);
                    i14++;
                }
                i15 -= 2;
                i13 += 2;
                if (i15 < 0 || i13 >= this.numcols) {
                    int i16 = i15 + 1;
                    int i17 = i13 + 3;
                }
                utah(i15, i13, i14);
                i14++;
                i15 -= 2;
                i13 += 2;
                break;
            } while (i13 >= this.numcols);
            int i162 = i15 + 1;
            int i172 = i13 + 3;
            do {
                if (i162 >= 0 && i172 < this.numcols && !hasBit(i172, i162)) {
                    utah(i162, i172, i14);
                    i14++;
                }
                i162 += 2;
                i172 -= 2;
                i11 = this.numrows;
                if (i162 >= i11) {
                    break;
                }
            } while (i172 >= 0);
            i15 = i162 + 3;
            i13 = i172 + 1;
            if (i15 >= i11 && i13 >= (i12 = this.numcols)) {
                break;
            }
        }
        if (!hasBit(i12 - 1, i11 - 1)) {
            setBit(this.numcols - 1, this.numrows - 1, true);
            setBit(this.numcols - 2, this.numrows - 2, true);
        }
    }
}
