package org.bouncycastle.pqc.math.linearalgebra;

import java.security.SecureRandom;
import org.bouncycastle.util.Arrays;

public class Permutation {
    private int[] perm;

    public Permutation(int i11) {
        if (i11 > 0) {
            this.perm = new int[i11];
            for (int i12 = i11 - 1; i12 >= 0; i12--) {
                this.perm[i12] = i12;
            }
            return;
        }
        throw new IllegalArgumentException("invalid length");
    }

    public Permutation(int i11, SecureRandom secureRandom) {
        if (i11 > 0) {
            this.perm = new int[i11];
            int[] iArr = new int[i11];
            for (int i12 = 0; i12 < i11; i12++) {
                iArr[i12] = i12;
            }
            int i13 = i11;
            for (int i14 = 0; i14 < i11; i14++) {
                int nextInt = RandUtils.nextInt(secureRandom, i13);
                i13--;
                this.perm[i14] = iArr[nextInt];
                iArr[nextInt] = iArr[i13];
            }
            return;
        }
        throw new IllegalArgumentException("invalid length");
    }

    public Permutation(byte[] bArr) {
        if (bArr.length > 4) {
            int OS2IP = LittleEndianConversions.OS2IP(bArr, 0);
            int ceilLog256 = IntegerFunctions.ceilLog256(OS2IP - 1);
            if (bArr.length == (OS2IP * ceilLog256) + 4) {
                this.perm = new int[OS2IP];
                for (int i11 = 0; i11 < OS2IP; i11++) {
                    this.perm[i11] = LittleEndianConversions.OS2IP(bArr, (i11 * ceilLog256) + 4, ceilLog256);
                }
                if (!isPermutation(this.perm)) {
                    throw new IllegalArgumentException("invalid encoding");
                }
                return;
            }
            throw new IllegalArgumentException("invalid encoding");
        }
        throw new IllegalArgumentException("invalid encoding");
    }

    public Permutation(int[] iArr) {
        if (isPermutation(iArr)) {
            this.perm = IntUtils.clone(iArr);
            return;
        }
        throw new IllegalArgumentException("array is not a permutation vector");
    }

    private boolean isPermutation(int[] iArr) {
        int length = iArr.length;
        boolean[] zArr = new boolean[length];
        for (int i11 = 0; i11 < length; i11++) {
            if (iArr[i11] < 0 || iArr[i11] >= length || zArr[iArr[i11]]) {
                return false;
            }
            zArr[iArr[i11]] = true;
        }
        return true;
    }

    public Permutation computeInverse() {
        Permutation permutation = new Permutation(this.perm.length);
        for (int length = this.perm.length - 1; length >= 0; length--) {
            permutation.perm[this.perm[length]] = length;
        }
        return permutation;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Permutation)) {
            return false;
        }
        return IntUtils.equals(this.perm, ((Permutation) obj).perm);
    }

    public byte[] getEncoded() {
        int length = this.perm.length;
        int ceilLog256 = IntegerFunctions.ceilLog256(length - 1);
        byte[] bArr = new byte[((length * ceilLog256) + 4)];
        LittleEndianConversions.I2OSP(length, bArr, 0);
        for (int i11 = 0; i11 < length; i11++) {
            LittleEndianConversions.I2OSP(this.perm[i11], bArr, (i11 * ceilLog256) + 4, ceilLog256);
        }
        return bArr;
    }

    public int[] getVector() {
        return IntUtils.clone(this.perm);
    }

    public int hashCode() {
        return Arrays.hashCode(this.perm);
    }

    public Permutation rightMultiply(Permutation permutation) {
        int length = permutation.perm.length;
        int[] iArr = this.perm;
        if (length == iArr.length) {
            Permutation permutation2 = new Permutation(iArr.length);
            for (int length2 = this.perm.length - 1; length2 >= 0; length2--) {
                permutation2.perm[length2] = this.perm[permutation.perm[length2]];
            }
            return permutation2;
        }
        throw new IllegalArgumentException("length mismatch");
    }

    public String toString() {
        String str = "[" + this.perm[0];
        for (int i11 = 1; i11 < this.perm.length; i11++) {
            str = str + ", " + this.perm[i11];
        }
        return str + "]";
    }
}
