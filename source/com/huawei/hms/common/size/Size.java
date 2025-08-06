package com.huawei.hms.common.size;

import com.huawei.hms.common.internal.Objects;

public class Size {

    /* renamed from: a  reason: collision with root package name */
    private final int f37956a;

    /* renamed from: b  reason: collision with root package name */
    private final int f37957b;

    public Size(int i11, int i12) {
        this.f37956a = i11;
        this.f37957b = i12;
    }

    public static Size parseSize(String str) {
        try {
            int indexOf = str.indexOf("x");
            if (indexOf < 0) {
                indexOf = str.indexOf("*");
            }
            return new Size(Integer.parseInt(str.substring(0, indexOf)), Integer.parseInt(str.substring(indexOf + 1)));
        } catch (Exception unused) {
            throw new IllegalArgumentException("Size parses failed");
        }
    }

    public final boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Size)) {
            return false;
        }
        Size size = (Size) obj;
        if (this.f37956a == size.f37956a && this.f37957b == size.f37957b) {
            return true;
        }
        return false;
    }

    public final int getHeight() {
        return this.f37957b;
    }

    public final int getWidth() {
        return this.f37956a;
    }

    public int hashCode() {
        return Objects.hashCode(Integer.valueOf(getWidth()), Integer.valueOf(getHeight()));
    }

    public final String toString() {
        int i11 = this.f37956a;
        int i12 = this.f37957b;
        return "Width is " + i11 + " Height is " + i12;
    }
}
