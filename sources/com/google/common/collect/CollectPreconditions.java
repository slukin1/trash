package com.google.common.collect;

import com.google.common.annotations.GwtCompatible;
import com.google.common.base.Preconditions;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@GwtCompatible
final class CollectPreconditions {
    public static void checkEntryNotNull(Object obj, Object obj2) {
        if (obj == null) {
            throw new NullPointerException("null key in entry: null=" + obj2);
        } else if (obj2 == null) {
            throw new NullPointerException("null value in entry: " + obj + "=null");
        }
    }

    @CanIgnoreReturnValue
    public static int checkNonnegative(int i11, String str) {
        if (i11 >= 0) {
            return i11;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + i11);
    }

    public static void checkPositive(int i11, String str) {
        if (i11 <= 0) {
            throw new IllegalArgumentException(str + " must be positive but was: " + i11);
        }
    }

    public static void checkRemove(boolean z11) {
        Preconditions.checkState(z11, "no calls to next() since the last call to remove()");
    }

    @CanIgnoreReturnValue
    public static long checkNonnegative(long j11, String str) {
        if (j11 >= 0) {
            return j11;
        }
        throw new IllegalArgumentException(str + " cannot be negative but was: " + j11);
    }
}
