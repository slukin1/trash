package com.google.android.exoplayer2.decoder;

public abstract class Buffer {
    private int flags;

    public final void addFlag(int i11) {
        this.flags = i11 | this.flags;
    }

    public void clear() {
        this.flags = 0;
    }

    public final void clearFlag(int i11) {
        this.flags = (~i11) & this.flags;
    }

    public final boolean getFlag(int i11) {
        return (this.flags & i11) == i11;
    }

    public final boolean hasSupplementalData() {
        return getFlag(268435456);
    }

    public final boolean isDecodeOnly() {
        return getFlag(Integer.MIN_VALUE);
    }

    public final boolean isEndOfStream() {
        return getFlag(4);
    }

    public final boolean isKeyFrame() {
        return getFlag(1);
    }

    public final void setFlags(int i11) {
        this.flags = i11;
    }
}
