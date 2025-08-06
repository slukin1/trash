package kotlin.text;

import java.util.Locale;

public final class p {
    public static final String a(char c11) {
        String valueOf = String.valueOf(c11);
        Locale locale = Locale.ROOT;
        String upperCase = valueOf.toUpperCase(locale);
        if (upperCase.length() <= 1) {
            return String.valueOf(Character.toTitleCase(c11));
        }
        if (c11 == 329) {
            return upperCase;
        }
        char charAt = upperCase.charAt(0);
        String lowerCase = upperCase.substring(1).toLowerCase(locale);
        return charAt + lowerCase;
    }
}
