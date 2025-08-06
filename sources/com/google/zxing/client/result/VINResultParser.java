package com.google.zxing.client.result;

import com.engagelab.privates.common.constants.MTCommonConstants;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.Result;
import java.util.regex.Pattern;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

public final class VINResultParser extends ResultParser {
    private static final Pattern AZ09 = Pattern.compile("[A-Z0-9]{17}");
    private static final Pattern IOQ = Pattern.compile("[IOQ]");

    private static char checkChar(int i11) {
        if (i11 < 10) {
            return (char) (i11 + 48);
        }
        if (i11 == 10) {
            return 'X';
        }
        throw new IllegalArgumentException();
    }

    private static boolean checkChecksum(CharSequence charSequence) {
        int i11 = 0;
        int i12 = 0;
        while (i11 < charSequence.length()) {
            int i13 = i11 + 1;
            i12 += vinPositionWeight(i13) * vinCharValue(charSequence.charAt(i11));
            i11 = i13;
        }
        if (charSequence.charAt(8) == checkChar(i12 % 11)) {
            return true;
        }
        return false;
    }

    private static String countryCode(CharSequence charSequence) {
        char charAt = charSequence.charAt(0);
        char charAt2 = charSequence.charAt(1);
        if (charAt != '9') {
            if (charAt != 'S') {
                if (charAt != 'Z') {
                    switch (charAt) {
                        case '1':
                        case '4':
                        case '5':
                            return "US";
                        case '2':
                            return "CA";
                        case '3':
                            if (charAt2 < 'A' || charAt2 > 'W') {
                                return null;
                            }
                            return "MX";
                        default:
                            switch (charAt) {
                                case 'J':
                                    if (charAt2 < 'A' || charAt2 > 'T') {
                                        return null;
                                    }
                                    return "JP";
                                case 'K':
                                    if (charAt2 < 'L' || charAt2 > 'R') {
                                        return null;
                                    }
                                    return "KO";
                                case 'L':
                                    return "CN";
                                case 'M':
                                    if (charAt2 < 'A' || charAt2 > 'E') {
                                        return null;
                                    }
                                    return "IN";
                                default:
                                    switch (charAt) {
                                        case 'V':
                                            if (charAt2 >= 'F' && charAt2 <= 'R') {
                                                return "FR";
                                            }
                                            if (charAt2 < 'S' || charAt2 > 'W') {
                                                return null;
                                            }
                                            return "ES";
                                        case 'W':
                                            return "DE";
                                        case 'X':
                                            if (charAt2 == '0') {
                                                return "RU";
                                            }
                                            if (charAt2 < '3' || charAt2 > '9') {
                                                return null;
                                            }
                                            return "RU";
                                        default:
                                            return null;
                                    }
                            }
                    }
                } else if (charAt2 < 'A' || charAt2 > 'R') {
                    return null;
                } else {
                    return "IT";
                }
            } else if (charAt2 >= 'A' && charAt2 <= 'M') {
                return "UK";
            } else {
                if (charAt2 < 'N' || charAt2 > 'T') {
                    return null;
                }
                return "DE";
            }
        } else if (charAt2 >= 'A' && charAt2 <= 'E') {
            return "BR";
        } else {
            if (charAt2 < '3' || charAt2 > '9') {
                return null;
            }
            return "BR";
        }
    }

    private static int modelYear(char c11) {
        if (c11 >= 'E' && c11 <= 'H') {
            return (c11 - 'E') + 1984;
        }
        if (c11 >= 'J' && c11 <= 'N') {
            return (c11 - 'J') + 1988;
        }
        if (c11 == 'P') {
            return 1993;
        }
        if (c11 >= 'R' && c11 <= 'T') {
            return (c11 - Matrix.MATRIX_TYPE_RANDOM_REGULAR) + MTCommonConstants.RemoteWhat.TO_BACKGROUND;
        }
        if (c11 >= 'V' && c11 <= 'Y') {
            return (c11 - 'V') + MTCommonConstants.RemoteWhat.ON_NETWORK_CONNECTED;
        }
        if (c11 >= '1' && c11 <= '9') {
            return (c11 - '1') + 2001;
        }
        if (c11 >= 'A' && c11 <= 'D') {
            return (c11 - 'A') + 2010;
        }
        throw new IllegalArgumentException();
    }

    private static int vinCharValue(char c11) {
        if (c11 >= 'A' && c11 <= 'I') {
            return (c11 - 'A') + 1;
        }
        if (c11 >= 'J' && c11 <= 'R') {
            return (c11 - 'J') + 1;
        }
        if (c11 >= 'S' && c11 <= 'Z') {
            return (c11 - 'S') + 2;
        }
        if (c11 >= '0' && c11 <= '9') {
            return c11 - '0';
        }
        throw new IllegalArgumentException();
    }

    private static int vinPositionWeight(int i11) {
        if (i11 > 0 && i11 <= 7) {
            return 9 - i11;
        }
        if (i11 == 8) {
            return 10;
        }
        if (i11 == 9) {
            return 0;
        }
        if (i11 >= 10 && i11 <= 17) {
            return 19 - i11;
        }
        throw new IllegalArgumentException();
    }

    public VINParsedResult parse(Result result) {
        if (result.getBarcodeFormat() != BarcodeFormat.CODE_39) {
            return null;
        }
        String trim = IOQ.matcher(result.getText()).replaceAll("").trim();
        if (!AZ09.matcher(trim).matches()) {
            return null;
        }
        try {
            if (!checkChecksum(trim)) {
                return null;
            }
            String substring = trim.substring(0, 3);
            return new VINParsedResult(trim, substring, trim.substring(3, 9), trim.substring(9, 17), countryCode(substring), trim.substring(3, 8), modelYear(trim.charAt(9)), trim.charAt(10), trim.substring(11));
        } catch (IllegalArgumentException unused) {
            return null;
        }
    }
}
