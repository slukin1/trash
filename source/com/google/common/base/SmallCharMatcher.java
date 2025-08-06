package com.google.common.base;

import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.CharMatcher;
import java.util.BitSet;

@GwtIncompatible
final class SmallCharMatcher extends CharMatcher.NamedFastMatcher {
    private static final int C1 = -862048943;
    private static final int C2 = 461845907;
    private static final double DESIRED_LOAD_FACTOR = 0.5d;
    public static final int MAX_SIZE = 1023;
    private final boolean containsZero;
    private final long filter;
    private final char[] table;

    private SmallCharMatcher(char[] cArr, long j11, boolean z11, String str) {
        super(str);
        this.table = cArr;
        this.filter = j11;
        this.containsZero = z11;
    }

    private boolean checkFilter(int i11) {
        return 1 == ((this.filter >> i11) & 1);
    }

    @VisibleForTesting
    public static int chooseTableSize(int i11) {
        if (i11 == 1) {
            return 2;
        }
        int highestOneBit = Integer.highestOneBit(i11 - 1) << 1;
        while (((double) highestOneBit) * DESIRED_LOAD_FACTOR < ((double) i11)) {
            highestOneBit <<= 1;
        }
        return highestOneBit;
    }

    public static CharMatcher from(BitSet bitSet, String str) {
        int i11;
        int cardinality = bitSet.cardinality();
        boolean z11 = bitSet.get(0);
        int chooseTableSize = chooseTableSize(cardinality);
        char[] cArr = new char[chooseTableSize];
        int i12 = chooseTableSize - 1;
        int nextSetBit = bitSet.nextSetBit(0);
        long j11 = 0;
        while (nextSetBit != -1) {
            long j12 = (1 << nextSetBit) | j11;
            int smear = smear(nextSetBit);
            while (true) {
                i11 = smear & i12;
                if (cArr[i11] == 0) {
                    break;
                }
                smear = i11 + 1;
            }
            cArr[i11] = (char) nextSetBit;
            nextSetBit = bitSet.nextSetBit(nextSetBit + 1);
            j11 = j12;
        }
        return new SmallCharMatcher(cArr, j11, z11, str);
    }

    public static int smear(int i11) {
        return Integer.rotateLeft(i11 * C1, 15) * C2;
    }

    public boolean matches(char c11) {
        if (c11 == 0) {
            return this.containsZero;
        }
        if (!checkFilter(c11)) {
            return false;
        }
        int length = this.table.length - 1;
        int smear = smear(c11) & length;
        int i11 = smear;
        do {
            char[] cArr = this.table;
            if (cArr[i11] == 0) {
                return false;
            }
            if (cArr[i11] == c11) {
                return true;
            }
            i11 = (i11 + 1) & length;
        } while (i11 != smear);
        return false;
    }

    public void setBits(BitSet bitSet) {
        if (this.containsZero) {
            bitSet.set(0);
        }
        for (char c11 : this.table) {
            if (c11 != 0) {
                bitSet.set(c11);
            }
        }
    }
}
