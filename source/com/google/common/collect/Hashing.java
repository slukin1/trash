package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;

@GwtCompatible
final class Hashing {
    private static final long C1 = -862048943;
    private static final long C2 = 461845907;
    private static final int MAX_TABLE_SIZE = 1073741824;

    private Hashing() {
    }

    public static int closedTableSize(int i11, double d11) {
        int max = Math.max(i11, 2);
        int highestOneBit = Integer.highestOneBit(max);
        if (max <= ((int) (d11 * ((double) highestOneBit)))) {
            return highestOneBit;
        }
        int i12 = highestOneBit << 1;
        if (i12 > 0) {
            return i12;
        }
        return 1073741824;
    }

    public static boolean needsResizing(int i11, int i12, double d11) {
        return ((double) i11) > d11 * ((double) i12) && i12 < 1073741824;
    }

    public static int smear(int i11) {
        return (int) (((long) Integer.rotateLeft((int) (((long) i11) * C1), 15)) * C2);
    }

    public static int smearedHash(Object obj) {
        return smear(obj == null ? 0 : obj.hashCode());
    }
}
