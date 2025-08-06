package com.google.zxing.oned.rss.expanded.decoders;

abstract class DecodedObject {
    private final int newPosition;

    public DecodedObject(int i11) {
        this.newPosition = i11;
    }

    public final int getNewPosition() {
        return this.newPosition;
    }
}
