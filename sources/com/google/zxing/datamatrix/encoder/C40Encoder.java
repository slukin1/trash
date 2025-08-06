package com.google.zxing.datamatrix.encoder;

class C40Encoder implements Encoder {
    private int backtrackOneCharacter(EncoderContext encoderContext, StringBuilder sb2, StringBuilder sb3, int i11) {
        int length = sb2.length();
        sb2.delete(length - i11, length);
        encoderContext.pos--;
        int encodeChar = encodeChar(encoderContext.getCurrentChar(), sb3);
        encoderContext.resetSymbolInfo();
        return encodeChar;
    }

    private static String encodeToCodewords(CharSequence charSequence, int i11) {
        int charAt = (charSequence.charAt(i11) * 1600) + (charSequence.charAt(i11 + 1) * '(') + charSequence.charAt(i11 + 2) + 1;
        return new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)});
    }

    public static void writeNextTriplet(EncoderContext encoderContext, StringBuilder sb2) {
        encoderContext.writeCodewords(encodeToCodewords(sb2, 0));
        sb2.delete(0, 3);
    }

    public void encode(EncoderContext encoderContext) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            if (!encoderContext.hasMoreCharacters()) {
                break;
            }
            char currentChar = encoderContext.getCurrentChar();
            encoderContext.pos++;
            int encodeChar = encodeChar(currentChar, sb2);
            int codewordCount = encoderContext.getCodewordCount() + ((sb2.length() / 3) << 1);
            encoderContext.updateSymbolInfo(codewordCount);
            int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - codewordCount;
            if (encoderContext.hasMoreCharacters()) {
                if (sb2.length() % 3 == 0 && HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode()) != getEncodingMode()) {
                    encoderContext.signalEncoderChange(0);
                    break;
                }
            } else {
                StringBuilder sb3 = new StringBuilder();
                if (sb2.length() % 3 == 2 && (dataCapacity < 2 || dataCapacity > 2)) {
                    encodeChar = backtrackOneCharacter(encoderContext, sb2, sb3, encodeChar);
                }
                while (sb2.length() % 3 == 1 && ((encodeChar <= 3 && dataCapacity != 1) || encodeChar > 3)) {
                    encodeChar = backtrackOneCharacter(encoderContext, sb2, sb3, encodeChar);
                }
            }
        }
        handleEOD(encoderContext, sb2);
    }

    public int encodeChar(char c11, StringBuilder sb2) {
        if (c11 == ' ') {
            sb2.append(3);
            return 1;
        } else if (c11 >= '0' && c11 <= '9') {
            sb2.append((char) ((c11 - '0') + 4));
            return 1;
        } else if (c11 >= 'A' && c11 <= 'Z') {
            sb2.append((char) ((c11 - 'A') + 14));
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
        } else if (c11 < '`' || c11 > 127) {
            sb2.append("\u0001\u001e");
            return encodeChar((char) (c11 - 128), sb2) + 2;
        } else {
            sb2.append(2);
            sb2.append((char) (c11 - '`'));
            return 2;
        }
    }

    public int getEncodingMode() {
        return 1;
    }

    public void handleEOD(EncoderContext encoderContext, StringBuilder sb2) {
        int length = sb2.length() % 3;
        int codewordCount = encoderContext.getCodewordCount() + ((sb2.length() / 3) << 1);
        encoderContext.updateSymbolInfo(codewordCount);
        int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - codewordCount;
        if (length == 2) {
            sb2.append(0);
            while (sb2.length() >= 3) {
                writeNextTriplet(encoderContext, sb2);
            }
            if (encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword(254);
            }
        } else if (dataCapacity == 1 && length == 1) {
            while (sb2.length() >= 3) {
                writeNextTriplet(encoderContext, sb2);
            }
            if (encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword(254);
            }
            encoderContext.pos--;
        } else if (length == 0) {
            while (sb2.length() >= 3) {
                writeNextTriplet(encoderContext, sb2);
            }
            if (dataCapacity > 0 || encoderContext.hasMoreCharacters()) {
                encoderContext.writeCodeword(254);
            }
        } else {
            throw new IllegalStateException("Unexpected case. Please report!");
        }
        encoderContext.signalEncoderChange(0);
    }
}
