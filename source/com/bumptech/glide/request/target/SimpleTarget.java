package com.bumptech.glide.request.target;

import c4.f;
import f4.i;

@Deprecated
public abstract class SimpleTarget<Z> extends BaseTarget<Z> {
    private final int height;
    private final int width;

    public SimpleTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public final void getSize(f fVar) {
        if (i.t(this.width, this.height)) {
            fVar.d(this.width, this.height);
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + this.width + " and height: " + this.height + ", either provide dimensions in the constructor or call override()");
    }

    public void removeCallback(f fVar) {
    }

    public SimpleTarget(int i11, int i12) {
        this.width = i11;
        this.height = i12;
    }
}
