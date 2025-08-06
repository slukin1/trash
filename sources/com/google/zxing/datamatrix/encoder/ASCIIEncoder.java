package com.google.zxing.datamatrix.encoder;

final class ASCIIEncoder implements Encoder {
    private static char encodeASCIIDigits(char c11, char c12) {
        if (HighLevelEncoder.isDigit(c11) && HighLevelEncoder.isDigit(c12)) {
            return (char) (((c11 - '0') * 10) + (c12 - '0') + 130);
        }
        throw new IllegalArgumentException("not digits: " + c11 + c12);
    }

    public void encode(EncoderContext encoderContext) {
        if (HighLevelEncoder.determineConsecutiveDigitCount(encoderContext.getMessage(), encoderContext.pos) >= 2) {
            encoderContext.writeCodeword(encodeASCIIDigits(encoderContext.getMessage().charAt(encoderContext.pos), encoderContext.getMessage().charAt(encoderContext.pos + 1)));
            encoderContext.pos += 2;
            return;
        }
        char currentChar = encoderContext.getCurrentChar();
        int lookAheadTest = HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode());
        if (lookAheadTest != getEncodingMode()) {
            if (lookAheadTest == 1) {
                encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_C40);
                encoderContext.signalEncoderChange(1);
            } else if (lookAheadTest == 2) {
                encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_TEXT);
                encoderContext.signalEncoderChange(2);
            } else if (lookAheadTest == 3) {
                encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_ANSIX12);
                encoderContext.signalEncoderChange(3);
            } else if (lookAheadTest == 4) {
                encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_EDIFACT);
                encoderContext.signalEncoderChange(4);
            } else if (lookAheadTest == 5) {
                encoderContext.writeCodeword(HighLevelEncoder.LATCH_TO_BASE256);
                encoderContext.signalEncoderChange(5);
            } else {
                throw new IllegalStateException("Illegal mode: ".concat(String.valueOf(lookAheadTest)));
            }
        } else if (HighLevelEncoder.isExtendedASCII(currentChar)) {
            encoderContext.writeCodeword(HighLevelEncoder.UPPER_SHIFT);
            encoderContext.writeCodeword((char) ((currentChar - 128) + 1));
            encoderContext.pos++;
        } else {
            encoderContext.writeCodeword((char) (currentChar + 1));
            encoderContext.pos++;
        }
    }

    public int getEncodingMode() {
        return 0;
    }
}
