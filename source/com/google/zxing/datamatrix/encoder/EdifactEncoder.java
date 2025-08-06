package com.google.zxing.datamatrix.encoder;

final class EdifactEncoder implements Encoder {
    private static void encodeChar(char c11, StringBuilder sb2) {
        if (c11 >= ' ' && c11 <= '?') {
            sb2.append(c11);
        } else if (c11 < '@' || c11 > '^') {
            HighLevelEncoder.illegalCharacter(c11);
        } else {
            sb2.append((char) (c11 - '@'));
        }
    }

    private static String encodeToCodewords(CharSequence charSequence, int i11) {
        int length = charSequence.length() - i11;
        if (length != 0) {
            char charAt = charSequence.charAt(i11);
            char c11 = 0;
            char charAt2 = length >= 2 ? charSequence.charAt(i11 + 1) : 0;
            char charAt3 = length >= 3 ? charSequence.charAt(i11 + 2) : 0;
            if (length >= 4) {
                c11 = charSequence.charAt(i11 + 3);
            }
            int i12 = (charAt << 18) + (charAt2 << 12) + (charAt3 << 6) + c11;
            char c12 = (char) ((i12 >> 8) & 255);
            char c13 = (char) (i12 & 255);
            StringBuilder sb2 = new StringBuilder(3);
            sb2.append((char) ((i12 >> 16) & 255));
            if (length >= 2) {
                sb2.append(c12);
            }
            if (length >= 3) {
                sb2.append(c13);
            }
            return sb2.toString();
        }
        throw new IllegalStateException("StringBuilder must not be empty");
    }

    private static void handleEOD(EncoderContext encoderContext, CharSequence charSequence) {
        try {
            int length = charSequence.length();
            if (length != 0) {
                boolean z11 = true;
                if (length == 1) {
                    encoderContext.updateSymbolInfo();
                    int dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount();
                    int remainingCharacters = encoderContext.getRemainingCharacters();
                    if (remainingCharacters > dataCapacity) {
                        encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + 1);
                        dataCapacity = encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount();
                    }
                    if (remainingCharacters <= dataCapacity && dataCapacity <= 2) {
                        encoderContext.signalEncoderChange(0);
                        return;
                    }
                }
                if (length <= 4) {
                    int i11 = length - 1;
                    String encodeToCodewords = encodeToCodewords(charSequence, 0);
                    if (!(!encoderContext.hasMoreCharacters()) || i11 > 2) {
                        z11 = false;
                    }
                    if (i11 <= 2) {
                        encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + i11);
                        if (encoderContext.getSymbolInfo().getDataCapacity() - encoderContext.getCodewordCount() >= 3) {
                            encoderContext.updateSymbolInfo(encoderContext.getCodewordCount() + encodeToCodewords.length());
                            z11 = false;
                        }
                    }
                    if (z11) {
                        encoderContext.resetSymbolInfo();
                        encoderContext.pos -= i11;
                    } else {
                        encoderContext.writeCodewords(encodeToCodewords);
                    }
                    encoderContext.signalEncoderChange(0);
                    return;
                }
                throw new IllegalStateException("Count must not exceed 4");
            }
        } finally {
            encoderContext.signalEncoderChange(0);
        }
    }

    public void encode(EncoderContext encoderContext) {
        StringBuilder sb2 = new StringBuilder();
        while (true) {
            if (!encoderContext.hasMoreCharacters()) {
                break;
            }
            encodeChar(encoderContext.getCurrentChar(), sb2);
            encoderContext.pos++;
            if (sb2.length() >= 4) {
                encoderContext.writeCodewords(encodeToCodewords(sb2, 0));
                sb2.delete(0, 4);
                if (HighLevelEncoder.lookAheadTest(encoderContext.getMessage(), encoderContext.pos, getEncodingMode()) != getEncodingMode()) {
                    encoderContext.signalEncoderChange(0);
                    break;
                }
            }
        }
        sb2.append(31);
        handleEOD(encoderContext, sb2);
    }

    public int getEncodingMode() {
        return 4;
    }
}
