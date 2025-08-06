package org.bouncycastle.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.ArrayList;
import java.util.Vector;
import org.bouncycastle.util.encoders.UTF8;

public final class Strings {
    private static String LINE_SEPARATOR;

    public static class StringListImpl extends ArrayList<String> implements StringList {
        private StringListImpl() {
        }

        public void add(int i11, String str) {
            super.add(i11, str);
        }

        public boolean add(String str) {
            return super.add(str);
        }

        public /* bridge */ /* synthetic */ String get(int i11) {
            return (String) super.get(i11);
        }

        public String set(int i11, String str) {
            return (String) super.set(i11, str);
        }

        public String[] toStringArray() {
            int size = size();
            String[] strArr = new String[size];
            for (int i11 = 0; i11 != size; i11++) {
                strArr[i11] = (String) get(i11);
            }
            return strArr;
        }

        public String[] toStringArray(int i11, int i12) {
            String[] strArr = new String[(i12 - i11)];
            int i13 = i11;
            while (i13 != size() && i13 != i12) {
                strArr[i13 - i11] = (String) get(i13);
                i13++;
            }
            return strArr;
        }
    }

    static {
        try {
            LINE_SEPARATOR = (String) AccessController.doPrivileged(new PrivilegedAction<String>() {
                public String run() {
                    return System.getProperty("line.separator");
                }
            });
        } catch (Exception unused) {
            try {
                LINE_SEPARATOR = String.format("%n", new Object[0]);
            } catch (Exception unused2) {
                LINE_SEPARATOR = "\n";
            }
        }
    }

    public static char[] asCharArray(byte[] bArr) {
        int length = bArr.length;
        char[] cArr = new char[length];
        for (int i11 = 0; i11 != length; i11++) {
            cArr[i11] = (char) (bArr[i11] & 255);
        }
        return cArr;
    }

    public static boolean constantTimeAreEqual(String str, String str2) {
        boolean z11 = str.length() == str2.length();
        int length = str.length();
        for (int i11 = 0; i11 != length; i11++) {
            z11 &= str.charAt(i11) == str2.charAt(i11);
        }
        return z11;
    }

    public static String fromByteArray(byte[] bArr) {
        return new String(asCharArray(bArr));
    }

    public static String fromUTF8ByteArray(byte[] bArr) {
        char[] cArr = new char[bArr.length];
        int transcodeToUTF16 = UTF8.transcodeToUTF16(bArr, cArr);
        if (transcodeToUTF16 >= 0) {
            return new String(cArr, 0, transcodeToUTF16);
        }
        throw new IllegalArgumentException("Invalid UTF-8 input");
    }

    public static String fromUTF8ByteArray(byte[] bArr, int i11, int i12) {
        char[] cArr = new char[i12];
        int transcodeToUTF16 = UTF8.transcodeToUTF16(bArr, i11, i12, cArr);
        if (transcodeToUTF16 >= 0) {
            return new String(cArr, 0, transcodeToUTF16);
        }
        throw new IllegalArgumentException("Invalid UTF-8 input");
    }

    public static String lineSeparator() {
        return LINE_SEPARATOR;
    }

    public static StringList newList() {
        return new StringListImpl();
    }

    public static String[] split(String str, char c11) {
        int i11;
        Vector vector = new Vector();
        boolean z11 = true;
        while (true) {
            if (!z11) {
                break;
            }
            int indexOf = str.indexOf(c11);
            if (indexOf > 0) {
                vector.addElement(str.substring(0, indexOf));
                str = str.substring(indexOf + 1);
            } else {
                vector.addElement(str);
                z11 = false;
            }
        }
        int size = vector.size();
        String[] strArr = new String[size];
        for (i11 = 0; i11 != size; i11++) {
            strArr[i11] = (String) vector.elementAt(i11);
        }
        return strArr;
    }

    public static int toByteArray(String str, byte[] bArr, int i11) {
        int length = str.length();
        for (int i12 = 0; i12 < length; i12++) {
            bArr[i11 + i12] = (byte) str.charAt(i12);
        }
        return length;
    }

    public static byte[] toByteArray(String str) {
        int length = str.length();
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 != length; i11++) {
            bArr[i11] = (byte) str.charAt(i11);
        }
        return bArr;
    }

    public static byte[] toByteArray(char[] cArr) {
        int length = cArr.length;
        byte[] bArr = new byte[length];
        for (int i11 = 0; i11 != length; i11++) {
            bArr[i11] = (byte) cArr[i11];
        }
        return bArr;
    }

    public static String toLowerCase(String str) {
        char[] charArray = str.toCharArray();
        boolean z11 = false;
        for (int i11 = 0; i11 != charArray.length; i11++) {
            char c11 = charArray[i11];
            if ('A' <= c11 && 'Z' >= c11) {
                charArray[i11] = (char) ((c11 - 'A') + 97);
                z11 = true;
            }
        }
        return z11 ? new String(charArray) : str;
    }

    public static void toUTF8ByteArray(char[] cArr, OutputStream outputStream) throws IOException {
        int i11;
        int i12;
        int i13 = 0;
        while (i13 < cArr.length) {
            char c11 = cArr[i13];
            char c12 = c11;
            if (c11 >= 128) {
                if (c11 < 2048) {
                    i12 = (c11 >> 6) | 192;
                } else if (c11 < 55296 || c11 > 57343) {
                    outputStream.write((c11 >> 12) | 224);
                    i12 = ((c11 >> 6) & 63) | 128;
                } else {
                    i13++;
                    if (i13 < cArr.length) {
                        char c13 = cArr[i13];
                        if (c11 <= 56319) {
                            i11 = (((c11 & 1023) << 10) | (c13 & 1023)) + 0;
                            outputStream.write((i11 >> 18) | 240);
                            outputStream.write(((i11 >> 12) & 63) | 128);
                            outputStream.write(((i11 >> 6) & 63) | 128);
                            c12 = (i11 & true) | true;
                        } else {
                            throw new IllegalStateException("invalid UTF-16 codepoint");
                        }
                    } else {
                        throw new IllegalStateException("invalid UTF-16 codepoint");
                    }
                }
                outputStream.write(i12);
                i11 = c11;
                c12 = (i11 & true) | true;
            }
            outputStream.write(c12);
            i13++;
        }
    }

    public static byte[] toUTF8ByteArray(String str) {
        return toUTF8ByteArray(str.toCharArray());
    }

    public static byte[] toUTF8ByteArray(char[] cArr) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            toUTF8ByteArray(cArr, byteArrayOutputStream);
            return byteArrayOutputStream.toByteArray();
        } catch (IOException unused) {
            throw new IllegalStateException("cannot encode string to byte array!");
        }
    }

    public static String toUpperCase(String str) {
        char[] charArray = str.toCharArray();
        boolean z11 = false;
        for (int i11 = 0; i11 != charArray.length; i11++) {
            char c11 = charArray[i11];
            if ('a' <= c11 && 'z' >= c11) {
                charArray[i11] = (char) ((c11 - 'a') + 65);
                z11 = true;
            }
        }
        return z11 ? new String(charArray) : str;
    }
}
