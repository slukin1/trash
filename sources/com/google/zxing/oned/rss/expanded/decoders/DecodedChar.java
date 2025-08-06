package com.google.zxing.oned.rss.expanded.decoders;

final class DecodedChar extends DecodedObject {
    public static final char FNC1 = '$';
    private final char value;

    public DecodedChar(int i11, char c11) {
        super(i11);
        this.value = c11;
    }

    public char getValue() {
        return this.value;
    }

    public boolean isFNC1() {
        return this.value == '$';
    }
}
