package com.google.zxing.oned.rss.expanded.decoders;

import com.google.zxing.FormatException;

final class DecodedNumeric extends DecodedObject {
    public static final int FNC1 = 10;
    private final int firstDigit;
    private final int secondDigit;

    public DecodedNumeric(int i11, int i12, int i13) throws FormatException {
        super(i11);
        if (i12 < 0 || i12 > 10 || i13 < 0 || i13 > 10) {
            throw FormatException.getFormatInstance();
        }
        this.firstDigit = i12;
        this.secondDigit = i13;
    }

    public int getFirstDigit() {
        return this.firstDigit;
    }

    public int getSecondDigit() {
        return this.secondDigit;
    }

    public int getValue() {
        return (this.firstDigit * 10) + this.secondDigit;
    }

    public boolean isAnyFNC1() {
        return this.firstDigit == 10 || this.secondDigit == 10;
    }

    public boolean isFirstDigitFNC1() {
        return this.firstDigit == 10;
    }

    public boolean isSecondDigitFNC1() {
        return this.secondDigit == 10;
    }
}
