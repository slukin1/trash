package org.bouncycastle.pqc.crypto.rainbow.util;

import java.lang.reflect.Array;

public class ComputeInField {
    private short[][] A;

    /* renamed from: x  reason: collision with root package name */
    public short[] f59602x;

    private void computeZerosAbove() throws RuntimeException {
        for (int length = this.A.length - 1; length > 0; length--) {
            int i11 = length - 1;
            while (i11 >= 0) {
                short[][] sArr = this.A;
                short s11 = sArr[i11][length];
                short invElem = GF2Field.invElem(sArr[length][length]);
                if (invElem != 0) {
                    int i12 = length;
                    while (true) {
                        short[][] sArr2 = this.A;
                        if (i12 >= sArr2.length * 2) {
                            break;
                        }
                        short multElem = GF2Field.multElem(s11, GF2Field.multElem(sArr2[length][i12], invElem));
                        short[][] sArr3 = this.A;
                        sArr3[i11][i12] = GF2Field.addElem(sArr3[i11][i12], multElem);
                        i12++;
                    }
                    i11--;
                } else {
                    throw new RuntimeException("The matrix is not invertible");
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0058, code lost:
        r0 = r1;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void computeZerosUnder(boolean r10) throws java.lang.RuntimeException {
        /*
            r9 = this;
            if (r10 == 0) goto L_0x0008
            short[][] r10 = r9.A
            int r10 = r10.length
            int r10 = r10 * 2
            goto L_0x000d
        L_0x0008:
            short[][] r10 = r9.A
            int r10 = r10.length
            int r10 = r10 + 1
        L_0x000d:
            r0 = 0
        L_0x000e:
            short[][] r1 = r9.A
            int r1 = r1.length
            int r1 = r1 + -1
            if (r0 >= r1) goto L_0x005a
            int r1 = r0 + 1
            r2 = r1
        L_0x0018:
            short[][] r3 = r9.A
            int r4 = r3.length
            if (r2 >= r4) goto L_0x0058
            r4 = r3[r2]
            short r4 = r4[r0]
            r3 = r3[r0]
            short r3 = r3[r0]
            short r3 = org.bouncycastle.pqc.crypto.rainbow.util.GF2Field.invElem(r3)
            if (r3 == 0) goto L_0x0050
            r5 = r0
        L_0x002c:
            if (r5 >= r10) goto L_0x004d
            short[][] r6 = r9.A
            r6 = r6[r0]
            short r6 = r6[r5]
            short r6 = org.bouncycastle.pqc.crypto.rainbow.util.GF2Field.multElem(r6, r3)
            short r6 = org.bouncycastle.pqc.crypto.rainbow.util.GF2Field.multElem(r4, r6)
            short[][] r7 = r9.A
            r8 = r7[r2]
            r7 = r7[r2]
            short r7 = r7[r5]
            short r6 = org.bouncycastle.pqc.crypto.rainbow.util.GF2Field.addElem(r7, r6)
            r8[r5] = r6
            int r5 = r5 + 1
            goto L_0x002c
        L_0x004d:
            int r2 = r2 + 1
            goto L_0x0018
        L_0x0050:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException
            java.lang.String r0 = "Matrix not invertible! We have to choose another one!"
            r10.<init>(r0)
            throw r10
        L_0x0058:
            r0 = r1
            goto L_0x000e
        L_0x005a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.bouncycastle.pqc.crypto.rainbow.util.ComputeInField.computeZerosUnder(boolean):void");
    }

    private void substitute() throws IllegalStateException {
        short[][] sArr = this.A;
        short invElem = GF2Field.invElem(sArr[sArr.length - 1][sArr.length - 1]);
        if (invElem != 0) {
            short[] sArr2 = this.f59602x;
            short[][] sArr3 = this.A;
            sArr2[sArr3.length - 1] = GF2Field.multElem(sArr3[sArr3.length - 1][sArr3.length], invElem);
            int length = this.A.length - 2;
            while (length >= 0) {
                short[][] sArr4 = this.A;
                short s11 = sArr4[length][sArr4.length];
                for (int length2 = sArr4.length - 1; length2 > length; length2--) {
                    s11 = GF2Field.addElem(s11, GF2Field.multElem(this.A[length][length2], this.f59602x[length2]));
                }
                short invElem2 = GF2Field.invElem(this.A[length][length]);
                if (invElem2 != 0) {
                    this.f59602x[length] = GF2Field.multElem(s11, invElem2);
                    length--;
                } else {
                    throw new IllegalStateException("Not solvable equation system");
                }
            }
            return;
        }
        throw new IllegalStateException("The equation system is not solvable");
    }

    public short[][] addSquareMatrix(short[][] sArr, short[][] sArr2) {
        if (sArr.length == sArr2.length && sArr[0].length == sArr2[0].length) {
            int length = sArr.length;
            int[] iArr = new int[2];
            iArr[1] = sArr.length;
            iArr[0] = length;
            short[][] sArr3 = (short[][]) Array.newInstance(short.class, iArr);
            for (int i11 = 0; i11 < sArr.length; i11++) {
                for (int i12 = 0; i12 < sArr2.length; i12++) {
                    sArr3[i11][i12] = GF2Field.addElem(sArr[i11][i12], sArr2[i11][i12]);
                }
            }
            return sArr3;
        }
        throw new RuntimeException("Addition is not possible!");
    }

    public short[] addVect(short[] sArr, short[] sArr2) {
        if (sArr.length == sArr2.length) {
            int length = sArr.length;
            short[] sArr3 = new short[length];
            for (int i11 = 0; i11 < length; i11++) {
                sArr3[i11] = GF2Field.addElem(sArr[i11], sArr2[i11]);
            }
            return sArr3;
        }
        throw new RuntimeException("Multiplication is not possible!");
    }

    public short[][] inverse(short[][] sArr) {
        Class<short> cls = short.class;
        try {
            int length = sArr.length;
            int[] iArr = new int[2];
            iArr[1] = sArr.length * 2;
            int i11 = 0;
            iArr[0] = length;
            this.A = (short[][]) Array.newInstance(cls, iArr);
            if (sArr.length == sArr[0].length) {
                for (int i12 = 0; i12 < sArr.length; i12++) {
                    for (int i13 = 0; i13 < sArr.length; i13++) {
                        this.A[i12][i13] = sArr[i12][i13];
                    }
                    for (int length2 = sArr.length; length2 < sArr.length * 2; length2++) {
                        this.A[i12][length2] = 0;
                    }
                    short[][] sArr2 = this.A;
                    sArr2[i12][sArr2.length + i12] = 1;
                }
                computeZerosUnder(true);
                int i14 = 0;
                while (true) {
                    short[][] sArr3 = this.A;
                    if (i14 >= sArr3.length) {
                        break;
                    }
                    short invElem = GF2Field.invElem(sArr3[i14][i14]);
                    int i15 = i14;
                    while (true) {
                        short[][] sArr4 = this.A;
                        if (i15 >= sArr4.length * 2) {
                            break;
                        }
                        sArr4[i14][i15] = GF2Field.multElem(sArr4[i14][i15], invElem);
                        i15++;
                    }
                    i14++;
                }
                computeZerosAbove();
                short[][] sArr5 = this.A;
                int length3 = sArr5.length;
                int[] iArr2 = new int[2];
                iArr2[1] = sArr5.length;
                iArr2[0] = length3;
                short[][] sArr6 = (short[][]) Array.newInstance(cls, iArr2);
                while (true) {
                    short[][] sArr7 = this.A;
                    if (i11 >= sArr7.length) {
                        return sArr6;
                    }
                    int length4 = sArr7.length;
                    while (true) {
                        short[][] sArr8 = this.A;
                        if (length4 >= sArr8.length * 2) {
                            break;
                        }
                        sArr6[i11][length4 - sArr8.length] = sArr8[i11][length4];
                        length4++;
                    }
                    i11++;
                }
            } else {
                throw new RuntimeException("The matrix is not invertible. Please choose another one!");
            }
        } catch (RuntimeException unused) {
            return null;
        }
    }

    public short[][] multMatrix(short s11, short[][] sArr) {
        int length = sArr.length;
        int[] iArr = new int[2];
        iArr[1] = sArr[0].length;
        iArr[0] = length;
        short[][] sArr2 = (short[][]) Array.newInstance(short.class, iArr);
        for (int i11 = 0; i11 < sArr.length; i11++) {
            for (int i12 = 0; i12 < sArr[0].length; i12++) {
                sArr2[i11][i12] = GF2Field.multElem(s11, sArr[i11][i12]);
            }
        }
        return sArr2;
    }

    public short[] multVect(short s11, short[] sArr) {
        int length = sArr.length;
        short[] sArr2 = new short[length];
        for (int i11 = 0; i11 < length; i11++) {
            sArr2[i11] = GF2Field.multElem(s11, sArr[i11]);
        }
        return sArr2;
    }

    public short[][] multVects(short[] sArr, short[] sArr2) {
        if (sArr.length == sArr2.length) {
            int length = sArr.length;
            int[] iArr = new int[2];
            iArr[1] = sArr2.length;
            iArr[0] = length;
            short[][] sArr3 = (short[][]) Array.newInstance(short.class, iArr);
            for (int i11 = 0; i11 < sArr.length; i11++) {
                for (int i12 = 0; i12 < sArr2.length; i12++) {
                    sArr3[i11][i12] = GF2Field.multElem(sArr[i11], sArr2[i12]);
                }
            }
            return sArr3;
        }
        throw new RuntimeException("Multiplication is not possible!");
    }

    public short[] multiplyMatrix(short[][] sArr, short[] sArr2) throws RuntimeException {
        if (sArr[0].length == sArr2.length) {
            short[] sArr3 = new short[sArr.length];
            for (int i11 = 0; i11 < sArr.length; i11++) {
                for (int i12 = 0; i12 < sArr2.length; i12++) {
                    sArr3[i11] = GF2Field.addElem(sArr3[i11], GF2Field.multElem(sArr[i11][i12], sArr2[i12]));
                }
            }
            return sArr3;
        }
        throw new RuntimeException("Multiplication is not possible!");
    }

    public short[][] multiplyMatrix(short[][] sArr, short[][] sArr2) throws RuntimeException {
        if (sArr[0].length == sArr2.length) {
            int length = sArr.length;
            int[] iArr = new int[2];
            iArr[1] = sArr2[0].length;
            iArr[0] = length;
            this.A = (short[][]) Array.newInstance(short.class, iArr);
            for (int i11 = 0; i11 < sArr.length; i11++) {
                for (int i12 = 0; i12 < sArr2.length; i12++) {
                    for (int i13 = 0; i13 < sArr2[0].length; i13++) {
                        short multElem = GF2Field.multElem(sArr[i11][i12], sArr2[i12][i13]);
                        short[][] sArr3 = this.A;
                        sArr3[i11][i13] = GF2Field.addElem(sArr3[i11][i13], multElem);
                    }
                }
            }
            return this.A;
        }
        throw new RuntimeException("Multiplication is not possible!");
    }

    public short[] solveEquation(short[][] sArr, short[] sArr2) {
        if (sArr.length != sArr2.length) {
            return null;
        }
        try {
            int length = sArr.length;
            int[] iArr = new int[2];
            iArr[1] = sArr.length + 1;
            iArr[0] = length;
            this.A = (short[][]) Array.newInstance(short.class, iArr);
            this.f59602x = new short[sArr.length];
            for (int i11 = 0; i11 < sArr.length; i11++) {
                for (int i12 = 0; i12 < sArr[0].length; i12++) {
                    this.A[i11][i12] = sArr[i11][i12];
                }
            }
            for (int i13 = 0; i13 < sArr2.length; i13++) {
                short[][] sArr3 = this.A;
                sArr3[i13][sArr2.length] = GF2Field.addElem(sArr2[i13], sArr3[i13][sArr2.length]);
            }
            computeZerosUnder(false);
            substitute();
            return this.f59602x;
        } catch (RuntimeException unused) {
            return null;
        }
    }
}
