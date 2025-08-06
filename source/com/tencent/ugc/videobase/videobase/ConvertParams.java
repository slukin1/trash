package com.tencent.ugc.videobase.videobase;

import com.tencent.liteav.base.util.k;

public class ConvertParams {
    public final int height;
    public final boolean mirror;
    public final k rotation;
    public final int width;

    public ConvertParams() {
        this(0, 0);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ConvertParams)) {
            return false;
        }
        ConvertParams convertParams = (ConvertParams) obj;
        return convertParams.width == this.width && convertParams.height == this.height && convertParams.rotation == this.rotation && convertParams.mirror == this.mirror;
    }

    public int hashCode() {
        return (((this.width * 32713) + this.height) << 4) + (this.rotation.ordinal() << 1) + (this.mirror ? 1 : 0);
    }

    public ConvertParams(int i11, int i12) {
        this(i11, i12, k.NORMAL, false);
    }

    public ConvertParams(int i11, int i12, k kVar, boolean z11) {
        this.width = i11;
        this.height = i12;
        this.rotation = kVar == null ? k.NORMAL : kVar;
        this.mirror = z11;
    }
}
