package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;

@GwtCompatible
public final class Verify {
    private Verify() {
    }

    public static void verify(boolean z11) {
        if (!z11) {
            throw new VerifyException();
        }
    }

    @CanIgnoreReturnValue
    public static <T> T verifyNotNull(T t11) {
        return verifyNotNull(t11, "expected a non-null reference", new Object[0]);
    }

    public static void verify(boolean z11, String str, Object... objArr) {
        if (!z11) {
            throw new VerifyException(Strings.lenientFormat(str, objArr));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T verifyNotNull(T t11, String str, Object... objArr) {
        verify(t11 != null, str, objArr);
        return t11;
    }

    public static void verify(boolean z11, String str, char c11) {
        if (!z11) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c11)));
        }
    }

    public static void verify(boolean z11, String str, int i11) {
        if (!z11) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i11)));
        }
    }

    public static void verify(boolean z11, String str, long j11) {
        if (!z11) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j11)));
        }
    }

    public static void verify(boolean z11, String str, Object obj) {
        if (!z11) {
            throw new VerifyException(Strings.lenientFormat(str, obj));
        }
    }

    public static void verify(boolean z11, String str, char c11, char c12) {
        if (!z11) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c11), Character.valueOf(c12)));
        }
    }

    public static void verify(boolean z11, String str, int i11, char c11) {
        if (!z11) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i11), Character.valueOf(c11)));
        }
    }

    public static void verify(boolean z11, String str, long j11, char c11) {
        if (!z11) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j11), Character.valueOf(c11)));
        }
    }

    public static void verify(boolean z11, String str, Object obj, char c11) {
        if (!z11) {
            throw new VerifyException(Strings.lenientFormat(str, obj, Character.valueOf(c11)));
        }
    }

    public static void verify(boolean z11, String str, char c11, int i11) {
        if (!z11) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c11), Integer.valueOf(i11)));
        }
    }

    public static void verify(boolean z11, String str, int i11, int i12) {
        if (!z11) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i11), Integer.valueOf(i12)));
        }
    }

    public static void verify(boolean z11, String str, long j11, int i11) {
        if (!z11) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j11), Integer.valueOf(i11)));
        }
    }

    public static void verify(boolean z11, String str, Object obj, int i11) {
        if (!z11) {
            throw new VerifyException(Strings.lenientFormat(str, obj, Integer.valueOf(i11)));
        }
    }

    public static void verify(boolean z11, String str, char c11, long j11) {
        if (!z11) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c11), Long.valueOf(j11)));
        }
    }

    public static void verify(boolean z11, String str, int i11, long j11) {
        if (!z11) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i11), Long.valueOf(j11)));
        }
    }

    public static void verify(boolean z11, String str, long j11, long j12) {
        if (!z11) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j11), Long.valueOf(j12)));
        }
    }

    public static void verify(boolean z11, String str, Object obj, long j11) {
        if (!z11) {
            throw new VerifyException(Strings.lenientFormat(str, obj, Long.valueOf(j11)));
        }
    }

    public static void verify(boolean z11, String str, char c11, Object obj) {
        if (!z11) {
            throw new VerifyException(Strings.lenientFormat(str, Character.valueOf(c11), obj));
        }
    }

    public static void verify(boolean z11, String str, int i11, Object obj) {
        if (!z11) {
            throw new VerifyException(Strings.lenientFormat(str, Integer.valueOf(i11), obj));
        }
    }

    public static void verify(boolean z11, String str, long j11, Object obj) {
        if (!z11) {
            throw new VerifyException(Strings.lenientFormat(str, Long.valueOf(j11), obj));
        }
    }

    public static void verify(boolean z11, String str, Object obj, Object obj2) {
        if (!z11) {
            throw new VerifyException(Strings.lenientFormat(str, obj, obj2));
        }
    }

    public static void verify(boolean z11, String str, Object obj, Object obj2, Object obj3) {
        if (!z11) {
            throw new VerifyException(Strings.lenientFormat(str, obj, obj2, obj3));
        }
    }

    public static void verify(boolean z11, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (!z11) {
            throw new VerifyException(Strings.lenientFormat(str, obj, obj2, obj3, obj4));
        }
    }
}
