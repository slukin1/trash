package kotlin.text;

import kotlin.ranges.h;

class CharsKt__CharJVMKt {
    public static int a(int i11) {
        if (new h(2, 36).h(i11)) {
            return i11;
        }
        throw new IllegalArgumentException("radix " + i11 + " was not in valid range " + new h(2, 36));
    }

    public static final int b(char c11, int i11) {
        return Character.digit(c11, i11);
    }

    public static boolean c(char c11) {
        return Character.isWhitespace(c11) || Character.isSpaceChar(c11);
    }
}
