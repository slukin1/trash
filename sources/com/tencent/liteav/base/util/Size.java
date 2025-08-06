package com.tencent.liteav.base.util;

import com.tencent.liteav.base.annotations.JNINamespace;

@JNINamespace("liteav")
public class Size {
    public int height = 0;
    public int width = 0;

    public Size() {
    }

    public double aspectRatio() {
        return (((double) this.width) * 1.0d) / ((double) this.height);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        return size.width == this.width && size.height == this.height;
    }

    public int getArea() {
        if (!isValid()) {
            return 0;
        }
        return this.width * this.height;
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

    public boolean isValid() {
        return this.width > 0 && this.height > 0;
    }

    public void set(Size size) {
        if (size != null) {
            this.width = size.width;
            this.height = size.height;
            return;
        }
        this.width = 0;
        this.height = 0;
    }

    public void swap() {
        int i11 = this.width;
        this.width = this.height;
        this.height = i11;
    }

    public String toString() {
        return "Size(" + this.width + ", " + this.height + ")";
    }

    public Size(int i11, int i12) {
        this.width = i11;
        this.height = i12;
    }

    public void set(int i11, int i12) {
        this.width = i11;
        this.height = i12;
    }

    public Size(Size size) {
        set(size);
    }
}
