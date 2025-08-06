package com.google.zxing.datamatrix.encoder;

final class X12Encoder extends C40Encoder {
    public void encode(EncoderContext encoderContext) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            if (!encoderContext.hasMoreCharacters()) {
                break;
            }
            char currentChar = encoderContext.getCurrentChar();
            encoderContext.pos++;
            encodeChar(currentChar, sb2);
            if (sb2.length() % 3 == 0) {
                C40Encoder.writeNextTriplet(encoderContext, sb2);
                if (HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode()) != getEncodingMode()) {
                    encoderContext.signalEncoderChange(0);
                    break;
                }
            }
        }
        handleEOD(encoderContext, sb2);
    }

    public int encodeChar(char c11, StringBuilder sb2) {
        if (c11 == 13) {
            sb2.append(0);
        } else if (c11 == ' ') {
            sb2.append(3);
        } else if (c11 == '*') {
            sb2.append(1);
        } else if (c11 == '>') {
            sb2.append(2);
        } else if (c11 >= '0' && c11 <= '9') {
            sb2.append((char) ((c11 - '0') + 4));
        } else if (c11 < 'A' || c11 > 'Z') {
            HighLevelEncoder.illegalCharacter(c11);
        } else {
            sb2.append((char) ((c11 - 'A') + 14));
        }
        return 1;
    }

    public int getEncodingMode() {
        return 3;
    }

    public void handleEOD(EncoderContext encoderContext, StringBuilder sb2) {
        encoderContext.updateSymbolInfo();
        int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount();
        encoderContext.pos -= sb2.length();
        if (encoderContext.getRemainingCharacters() > 1 || dataCapacity > 1 || encoderContext.getRemainingCharacters() != dataCapacity) {
            encoderContext.writeCodeword(254);
        }
        if (encoderContext.getNewEncoding() < 0) {
            encoderContext.signalEncoderChange(0);
        }
    }
}
