package androidx.test.espresso.core.internal.deps.guava.base;

public final class Ascii {
    public static boolean a(char c11) {
        return c11 >= 'A' && c11 <= 'Z';
    }

    public static String b(String str) {
        int length = str.length();
        int i11 = 0;
        while (i11 < length) {
            if (a(str.charAt(i11))) {
                char[] charArray = str.toCharArray();
                while (i11 < length) {
                    char c11 = charArray[i11];
                    if (a(c11)) {
                        charArray[i11] = (char) (c11 ^ ' ');
                    }
                    i11++;
                }
                return String.valueOf(charArray);
            }
            i11++;
        }
        return str;
    }
}
