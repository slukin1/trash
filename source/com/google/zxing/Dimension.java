package com.google.zxing;

public final class Dimension {
    private final int height;
    private final int width;

    public Dimension(int i11, int i12) {
        if (i11 < 0 || i12 < 0) {
            throw new IllegalArgumentException();
        }
        this.width = i11;
        this.height = i12;
    }

    public boolean equals(Object obj) {
        if (obj instanceof Dimension) {
            Dimension dimension = (Dimension) obj;
            if (this.width == dimension.width && this.height == dimension.height) {
                return true;
            }
            return false;
        }
        return false;
    }

    public int getHeight() {
        return this.height;
    }

    public int getWidth() {
        return this.width;
    }

    public int hashCode() {
        return (this.width * 32713) + this.height;
    }

    public String toString() {
        return this.width + "x" + this.height;
    }
}
