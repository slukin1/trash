package kotlin.text;

class CharsKt__CharKt extends CharsKt__CharJVMKt {
    public static int d(char c11) {
        int b11 = CharsKt__CharJVMKt.b(c11, 10);
        if (b11 >= 0) {
            return b11;
        }
        throw new IllegalArgumentException("Char " + c11 + " is not a decimal digit");
    }

    public static boolean e(char c11, char c12, boolean z11) {
        if (c11 == c12) {
            return true;
        }
        if (!z11) {
            return false;
        }
        char upperCase = Character.toUpperCase(c11);
        char upperCase2 = Character.toUpperCase(c12);
        if (upperCase == upperCase2 || Character.toLowerCase(upperCase) == Character.toLowerCase(upperCase2)) {
            return true;
        }
        return false;
    }

    public static String f(char c11) {
        return p.a(c11);
    }
}
