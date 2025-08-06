package net.sf.scuba.util;

import com.google.common.base.Ascii;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;

public final class Hex {
    private static final String HEXCHARS = "0123456789abcdefABCDEF";
    private static final boolean LEFT = true;
    private static final String PRINTABLE = " .,:;'`\"<>()[]{}?/\\!@#$%^&*_-=+|~0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final boolean RIGHT = false;

    private Hex() {
    }

    public static String byteToHexString(byte b11) {
        byte b12 = b11 & 255;
        StringBuilder sb2 = new StringBuilder();
        sb2.append(b12 < 16 ? "0" : "");
        sb2.append(Integer.toHexString(b12));
        return sb2.toString().toUpperCase();
    }

    public static String bytesToASCIIString(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        for (byte b11 : bArr) {
            char c11 = (char) b11;
            if (PRINTABLE.indexOf(c11) < 0) {
                c11 = '.';
            }
            sb2.append(Character.toString(c11));
        }
        return sb2.toString();
    }

    public static String[] bytesToASCIIStrings(byte[] bArr, int i11) {
        byte[][] split = split(bArr, i11);
        String[] strArr = new String[split.length];
        for (int i12 = 0; i12 < split.length; i12++) {
            strArr[i12] = bytesToASCIIString(split[i12]);
        }
        return strArr;
    }

    public static String bytesToHexString(byte[] bArr) {
        return bytesToHexString(bArr, 1000);
    }

    public static String bytesToPrettyString(byte[] bArr) {
        return bytesToPrettyString(bArr, 16, true, 4, (String) null, true);
    }

    public static String bytesToSpacedHexString(byte[] bArr) {
        StringBuilder sb2 = new StringBuilder();
        int i11 = 0;
        while (i11 < bArr.length) {
            sb2.append(byteToHexString(bArr[i11]));
            sb2.append(i11 < bArr.length + -1 ? " " : "");
            i11++;
        }
        return sb2.toString().toUpperCase();
    }

    private static String[] bytesToSpacedHexStrings(byte[] bArr, int i11, int i12) {
        byte[][] split = split(bArr, i11);
        String[] strArr = new String[split.length];
        for (int i13 = 0; i13 < split.length; i13++) {
            strArr[i13] = pad(bytesToSpacedHexString(split[i13]), i12, ' ', false);
        }
        return strArr;
    }

    public static int hexDigitToInt(char c11) throws NumberFormatException {
        switch (c11) {
            case '0':
                return 0;
            case '1':
                return 1;
            case '2':
                return 2;
            case '3':
                return 3;
            case '4':
                return 4;
            case '5':
                return 5;
            case '6':
                return 6;
            case '7':
                return 7;
            case '8':
                return 8;
            case '9':
                return 9;
            default:
                switch (c11) {
                    case 'A':
                        return 10;
                    case 'B':
                        return 11;
                    case 'C':
                        return 12;
                    case 'D':
                        return 13;
                    case 'E':
                        return 14;
                    case 'F':
                        return 15;
                    default:
                        switch (c11) {
                            case 'a':
                                return 10;
                            case 'b':
                                return 11;
                            case 'c':
                                return 12;
                            case 'd':
                                return 13;
                            case 'e':
                                return 14;
                            case 'f':
                                return 15;
                            default:
                                throw new NumberFormatException();
                        }
                }
        }
    }

    public static byte hexStringToByte(String str) throws NumberFormatException {
        byte[] hexStringToBytes = hexStringToBytes(str);
        if (hexStringToBytes != null && hexStringToBytes.length == 1) {
            return hexStringToBytes[0];
        }
        throw new NumberFormatException();
    }

    public static byte[] hexStringToBytes(String str) throws NumberFormatException {
        if (str == null) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i11 = 0; i11 < str.length(); i11++) {
            char charAt = str.charAt(i11);
            if (!Character.isWhitespace(charAt)) {
                if (HEXCHARS.indexOf(charAt) >= 0) {
                    sb2.append(charAt);
                } else {
                    throw new NumberFormatException();
                }
            }
        }
        if (sb2.length() % 2 != 0) {
            sb2.insert(0, "0");
        }
        byte[] bArr = new byte[(sb2.length() / 2)];
        for (int i12 = 0; i12 < sb2.length(); i12 += 2) {
            bArr[i12 / 2] = (byte) (((hexDigitToInt(sb2.charAt(i12)) & 255) << 4) | (hexDigitToInt(sb2.charAt(i12 + 1)) & 255));
        }
        return bArr;
    }

    public static int hexStringToInt(String str) throws NumberFormatException {
        byte[] hexStringToBytes = hexStringToBytes(str);
        if (hexStringToBytes == null || hexStringToBytes.length != 4) {
            throw new NumberFormatException();
        }
        return (hexStringToBytes[3] & 255) | ((hexStringToBytes[0] & 255) << Ascii.CAN) | ((hexStringToBytes[1] & 255) << 16) | ((hexStringToBytes[2] & 255) << 8);
    }

    public static short hexStringToShort(String str) throws NumberFormatException {
        byte[] hexStringToBytes = hexStringToBytes(str);
        if (hexStringToBytes == null || hexStringToBytes.length != 2) {
            throw new NumberFormatException();
        }
        return (short) ((hexStringToBytes[1] & 255) | ((hexStringToBytes[0] & 255) << 8));
    }

    public static String intToHexString(int i11) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        StringBuilder sb2 = new StringBuilder();
        String str6 = "0";
        sb2.append(i11 < 268435456 ? str6 : "");
        if (i11 < 16777216) {
            str = str6;
        } else {
            str = "";
        }
        sb2.append(str);
        if (i11 < 1048576) {
            str2 = str6;
        } else {
            str2 = "";
        }
        sb2.append(str2);
        if (i11 < 65536) {
            str3 = str6;
        } else {
            str3 = "";
        }
        sb2.append(str3);
        if (i11 < 4096) {
            str4 = str6;
        } else {
            str4 = "";
        }
        sb2.append(str4);
        if (i11 < 256) {
            str5 = str6;
        } else {
            str5 = "";
        }
        sb2.append(str5);
        if (i11 >= 16) {
            str6 = "";
        }
        sb2.append(str6);
        sb2.append(Integer.toHexString(i11));
        return sb2.toString().toUpperCase();
    }

    private static String pad(String str, int i11, char c11, boolean z11) {
        StringBuilder sb2 = new StringBuilder();
        int length = str.length();
        if (length >= i11) {
            return str;
        }
        int i12 = i11 - length;
        for (int i13 = 0; i13 < i12; i13++) {
            sb2.append(c11);
        }
        if (z11) {
            sb2.append(str);
            return sb2.toString();
        }
        return str + sb2.toString();
    }

    public static String shortToHexString(short s11) {
        short s12 = 65535 & s11;
        StringBuilder sb2 = new StringBuilder();
        String str = "0";
        sb2.append(s12 < 4096 ? str : "");
        sb2.append(s12 < 256 ? str : "");
        if (s12 >= 16) {
            str = "";
        }
        sb2.append(str);
        sb2.append(Integer.toHexString(s11));
        String sb3 = sb2.toString();
        if (sb3.length() > 4) {
            sb3 = sb3.substring(sb3.length() - 4, sb3.length());
        }
        return sb3.toUpperCase();
    }

    public static byte[][] split(byte[] bArr, int i11) {
        int length = bArr.length / i11;
        int length2 = bArr.length % i11;
        byte[][] bArr2 = new byte[((length2 > 0 ? 1 : 0) + length)][];
        int i12 = 0;
        for (int i13 = 0; i13 < length; i13++) {
            bArr2[i13] = new byte[i11];
            System.arraycopy(bArr, i12, bArr2[i13], 0, i11);
            i12 += i11;
        }
        if (length2 > 0) {
            bArr2[length] = new byte[length2];
            System.arraycopy(bArr, i12, bArr2[length], 0, length2);
        }
        return bArr2;
    }

    public static String toHexString(byte[] bArr) {
        return bytesToHexString(bArr, 0, bArr.length, 1000);
    }

    public static String bytesToHexString(byte[] bArr, int i11) {
        return bArr == null ? "NULL" : bytesToHexString(bArr, 0, bArr.length, i11);
    }

    public static String bytesToPrettyString(byte[] bArr, int i11, boolean z11, int i12, String str, boolean z12) {
        StringBuilder sb2 = new StringBuilder();
        String[] bytesToSpacedHexStrings = bytesToSpacedHexStrings(bArr, i11, i11 * 3);
        String[] bytesToASCIIStrings = bytesToASCIIStrings(bArr, i11);
        int i13 = 0;
        while (i13 < bytesToSpacedHexStrings.length) {
            if (z11) {
                String upperCase = Integer.toHexString(i13 * i11).toUpperCase();
                sb2.append(pad(upperCase, i12, '0', true) + l.f34627b);
            } else {
                String str2 = i13 == 0 ? str : "";
                sb2.append(pad(str2, i12, ' ', true) + " ");
            }
            sb2.append(bytesToSpacedHexStrings[i13]);
            if (z12) {
                sb2.append(" " + bytesToASCIIStrings[i13]);
            }
            sb2.append("\n");
            i13++;
        }
        return sb2.toString();
    }

    public static String toHexString(byte[] bArr, int i11) {
        return bytesToHexString(bArr, 0, bArr.length, i11);
    }

    public static String bytesToHexString(byte[] bArr, int i11, int i12, int i13) {
        if (bArr == null) {
            return "NULL";
        }
        StringBuilder sb2 = new StringBuilder();
        for (int i14 = 0; i14 < i12; i14++) {
            if (i14 != 0 && i14 % i13 == 0) {
                sb2.append("\n");
            }
            sb2.append(byteToHexString(bArr[i11 + i14]));
        }
        return sb2.toString();
    }

    public static String bytesToHexString(byte[] bArr, int i11, int i12) {
        return bytesToHexString(bArr, i11, i12, 1000);
    }
}
