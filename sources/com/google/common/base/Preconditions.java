package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.Objects;

@GwtCompatible
public final class Preconditions {
    private Preconditions() {
    }

    private static String badElementIndex(int i11, int i12, String str) {
        if (i11 < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i11));
        } else if (i12 >= 0) {
            return Strings.lenientFormat("%s (%s) must be less than size (%s)", str, Integer.valueOf(i11), Integer.valueOf(i12));
        } else {
            throw new IllegalArgumentException("negative size: " + i12);
        }
    }

    private static String badPositionIndex(int i11, int i12, String str) {
        if (i11 < 0) {
            return Strings.lenientFormat("%s (%s) must not be negative", str, Integer.valueOf(i11));
        } else if (i12 >= 0) {
            return Strings.lenientFormat("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i11), Integer.valueOf(i12));
        } else {
            throw new IllegalArgumentException("negative size: " + i12);
        }
    }

    private static String badPositionIndexes(int i11, int i12, int i13) {
        if (i11 < 0 || i11 > i13) {
            return badPositionIndex(i11, i13, "start index");
        }
        if (i12 < 0 || i12 > i13) {
            return badPositionIndex(i12, i13, "end index");
        }
        return Strings.lenientFormat("end index (%s) must not be less than start index (%s)", Integer.valueOf(i12), Integer.valueOf(i11));
    }

    public static void checkArgument(boolean z11) {
        if (!z11) {
            throw new IllegalArgumentException();
        }
    }

    @CanIgnoreReturnValue
    public static int checkElementIndex(int i11, int i12) {
        return checkElementIndex(i11, i12, "index");
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11) {
        Objects.requireNonNull(t11);
        return t11;
    }

    @CanIgnoreReturnValue
    public static int checkPositionIndex(int i11, int i12) {
        return checkPositionIndex(i11, i12, "index");
    }

    public static void checkPositionIndexes(int i11, int i12, int i13) {
        if (i11 < 0 || i12 < i11 || i12 > i13) {
            throw new IndexOutOfBoundsException(badPositionIndexes(i11, i12, i13));
        }
    }

    public static void checkState(boolean z11) {
        if (!z11) {
            throw new IllegalStateException();
        }
    }

    public static void checkArgument(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @CanIgnoreReturnValue
    public static int checkElementIndex(int i11, int i12, String str) {
        if (i11 >= 0 && i11 < i12) {
            return i11;
        }
        throw new IndexOutOfBoundsException(badElementIndex(i11, i12, str));
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11, Object obj) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @CanIgnoreReturnValue
    public static int checkPositionIndex(int i11, int i12, String str) {
        if (i11 >= 0 && i11 <= i12) {
            return i11;
        }
        throw new IndexOutOfBoundsException(badPositionIndex(i11, i12, str));
    }

    public static void checkState(boolean z11, Object obj) {
        if (!z11) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void checkArgument(boolean z11, String str, Object... objArr) {
        if (!z11) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, objArr));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11, String str, Object... objArr) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(Strings.lenientFormat(str, objArr));
    }

    public static void checkState(boolean z11, String str, Object... objArr) {
        if (!z11) {
            throw new IllegalStateException(Strings.lenientFormat(str, objArr));
        }
    }

    public static void checkArgument(boolean z11, String str, char c11) {
        if (!z11) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c11)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11, String str, char c11) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c11)));
    }

    public static void checkState(boolean z11, String str, char c11) {
        if (!z11) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c11)));
        }
    }

    public static void checkArgument(boolean z11, String str, int i11) {
        if (!z11) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i11)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11, String str, int i11) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i11)));
    }

    public static void checkState(boolean z11, String str, int i11) {
        if (!z11) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i11)));
        }
    }

    public static void checkArgument(boolean z11, String str, long j11) {
        if (!z11) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j11)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11, String str, long j11) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j11)));
    }

    public static void checkState(boolean z11, String str, long j11) {
        if (!z11) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j11)));
        }
    }

    public static void checkArgument(boolean z11, String str, Object obj) {
        if (!z11) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11, String str, Object obj) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj));
    }

    public static void checkState(boolean z11, String str, Object obj) {
        if (!z11) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj));
        }
    }

    public static void checkArgument(boolean z11, String str, char c11, char c12) {
        if (!z11) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c11), Character.valueOf(c12)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11, String str, char c11, char c12) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c11), Character.valueOf(c12)));
    }

    public static void checkState(boolean z11, String str, char c11, char c12) {
        if (!z11) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c11), Character.valueOf(c12)));
        }
    }

    public static void checkArgument(boolean z11, String str, char c11, int i11) {
        if (!z11) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c11), Integer.valueOf(i11)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11, String str, char c11, int i11) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c11), Integer.valueOf(i11)));
    }

    public static void checkState(boolean z11, String str, char c11, int i11) {
        if (!z11) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c11), Integer.valueOf(i11)));
        }
    }

    public static void checkArgument(boolean z11, String str, char c11, long j11) {
        if (!z11) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c11), Long.valueOf(j11)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11, String str, char c11, long j11) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c11), Long.valueOf(j11)));
    }

    public static void checkState(boolean z11, String str, char c11, long j11) {
        if (!z11) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c11), Long.valueOf(j11)));
        }
    }

    public static void checkArgument(boolean z11, String str, char c11, Object obj) {
        if (!z11) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Character.valueOf(c11), obj));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11, String str, char c11, Object obj) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Character.valueOf(c11), obj));
    }

    public static void checkState(boolean z11, String str, char c11, Object obj) {
        if (!z11) {
            throw new IllegalStateException(Strings.lenientFormat(str, Character.valueOf(c11), obj));
        }
    }

    public static void checkArgument(boolean z11, String str, int i11, char c11) {
        if (!z11) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i11), Character.valueOf(c11)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11, String str, int i11, char c11) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i11), Character.valueOf(c11)));
    }

    public static void checkState(boolean z11, String str, int i11, char c11) {
        if (!z11) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i11), Character.valueOf(c11)));
        }
    }

    public static void checkArgument(boolean z11, String str, int i11, int i12) {
        if (!z11) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i11), Integer.valueOf(i12)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11, String str, int i11, int i12) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i11), Integer.valueOf(i12)));
    }

    public static void checkState(boolean z11, String str, int i11, int i12) {
        if (!z11) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i11), Integer.valueOf(i12)));
        }
    }

    public static void checkArgument(boolean z11, String str, int i11, long j11) {
        if (!z11) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i11), Long.valueOf(j11)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11, String str, int i11, long j11) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i11), Long.valueOf(j11)));
    }

    public static void checkState(boolean z11, String str, int i11, long j11) {
        if (!z11) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i11), Long.valueOf(j11)));
        }
    }

    public static void checkArgument(boolean z11, String str, int i11, Object obj) {
        if (!z11) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Integer.valueOf(i11), obj));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11, String str, int i11, Object obj) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Integer.valueOf(i11), obj));
    }

    public static void checkState(boolean z11, String str, int i11, Object obj) {
        if (!z11) {
            throw new IllegalStateException(Strings.lenientFormat(str, Integer.valueOf(i11), obj));
        }
    }

    public static void checkArgument(boolean z11, String str, long j11, char c11) {
        if (!z11) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j11), Character.valueOf(c11)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11, String str, long j11, char c11) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j11), Character.valueOf(c11)));
    }

    public static void checkState(boolean z11, String str, long j11, char c11) {
        if (!z11) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j11), Character.valueOf(c11)));
        }
    }

    public static void checkArgument(boolean z11, String str, long j11, int i11) {
        if (!z11) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j11), Integer.valueOf(i11)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11, String str, long j11, int i11) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j11), Integer.valueOf(i11)));
    }

    public static void checkState(boolean z11, String str, long j11, int i11) {
        if (!z11) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j11), Integer.valueOf(i11)));
        }
    }

    public static void checkArgument(boolean z11, String str, long j11, long j12) {
        if (!z11) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j11), Long.valueOf(j12)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11, String str, long j11, long j12) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j11), Long.valueOf(j12)));
    }

    public static void checkState(boolean z11, String str, long j11, long j12) {
        if (!z11) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j11), Long.valueOf(j12)));
        }
    }

    public static void checkArgument(boolean z11, String str, long j11, Object obj) {
        if (!z11) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, Long.valueOf(j11), obj));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11, String str, long j11, Object obj) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(Strings.lenientFormat(str, Long.valueOf(j11), obj));
    }

    public static void checkState(boolean z11, String str, long j11, Object obj) {
        if (!z11) {
            throw new IllegalStateException(Strings.lenientFormat(str, Long.valueOf(j11), obj));
        }
    }

    public static void checkArgument(boolean z11, String str, Object obj, char c11) {
        if (!z11) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Character.valueOf(c11)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11, String str, Object obj, char c11) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Character.valueOf(c11)));
    }

    public static void checkState(boolean z11, String str, Object obj, char c11) {
        if (!z11) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Character.valueOf(c11)));
        }
    }

    public static void checkArgument(boolean z11, String str, Object obj, int i11) {
        if (!z11) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Integer.valueOf(i11)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11, String str, Object obj, int i11) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Integer.valueOf(i11)));
    }

    public static void checkState(boolean z11, String str, Object obj, int i11) {
        if (!z11) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Integer.valueOf(i11)));
        }
    }

    public static void checkArgument(boolean z11, String str, Object obj, long j11) {
        if (!z11) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, Long.valueOf(j11)));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11, String str, Object obj, long j11) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, Long.valueOf(j11)));
    }

    public static void checkState(boolean z11, String str, Object obj, long j11) {
        if (!z11) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, Long.valueOf(j11)));
        }
    }

    public static void checkArgument(boolean z11, String str, Object obj, Object obj2) {
        if (!z11) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11, String str, Object obj, Object obj2) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2));
    }

    public static void checkState(boolean z11, String str, Object obj, Object obj2) {
        if (!z11) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    public static void checkArgument(boolean z11, String str, Object obj, Object obj2, Object obj3) {
        if (!z11) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11, String str, Object obj, Object obj2, Object obj3) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2, obj3));
    }

    public static void checkState(boolean z11, String str, Object obj, Object obj2, Object obj3) {
        if (!z11) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    public static void checkArgument(boolean z11, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (!z11) {
            throw new IllegalArgumentException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T checkNotNull(T t11, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (t11 != null) {
            return t11;
        }
        throw new NullPointerException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
    }

    public static void checkState(boolean z11, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (!z11) {
            throw new IllegalStateException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }
}
