package com.google.zxing.datamatrix.encoder;

final class TextEncoder extends C40Encoder {
    public int encodeChar(char c11, StringBuilder sb2) {
        if (c11 == ' ') {
            sb2.append(3);
            return 1;
        } else if (c11 >= '0' && c11 <= '9') {
            sb2.append((char) ((c11 - '0') + 4));
            return 1;
        } else if (c11 >= 'a' && c11 <= 'z') {
            sb2.append((char) ((c11 - 'a') + 14));
            return 1;
        } else if (c11 < ' ') {
            sb2.append(0);
            sb2.append(c11);
            return 2;
        } else if (c11 >= '!' && c11 <= '/') {
            sb2.append(1);
            sb2.append((char) (c11 - '!'));
            return 2;
        } else if (c11 >= ':' && c11 <= '@') {
            sb2.append(1);
            sb2.append((char) ((c11 - ':') + 15));
            return 2;
        } else if (c11 >= '[' && c11 <= '_') {
            sb2.append(1);
            sb2.append((char) ((c11 - '[') + 22));
            return 2;
        } else if (c11 == '`') {
            sb2.append(2);
            sb2.append((char) (c11 - '`'));
            return 2;
        } else if (c11 >= 'A' && c11 <= 'Z') {
            sb2.append(2);
            sb2.append((char) ((c11 - 'A') + 1));
            return 2;
        } else if (c11 < '{' || c11 > 127) {
            sb2.append("\u0001\u001e");
            return encodeChar((char) (c11 - 128), sb2) + 2;
        } else {
            sb2.append(2);
            sb2.append((char) ((c11 - '{') + 27));
            return 2;
        }
    }

    public int getEncodingMode() {
        return 2;
    }
}
