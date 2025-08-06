package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import c4.f;
import c4.g;
import com.bumptech.glide.request.c;
import f4.i;

public abstract class CustomTarget<T> implements g<T> {
    private final int height;
    private c request;
    private final int width;

    public CustomTarget() {
        this(Integer.MIN_VALUE, Integer.MIN_VALUE);
    }

    public final c getRequest() {
        return this.request;
    }

    public final void getSize(f fVar) {
        fVar.d(this.width, this.height);
    }

    public void onDestroy() {
    }

    public void onLoadFailed(Drawable drawable) {
    }

    public void onLoadStarted(Drawable drawable) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public final void removeCallback(f fVar) {
    }

    public final void setRequest(c cVar) {
        this.request = cVar;
    }

    public CustomTarget(int i11, int i12) {
        if (i.t(i11, i12)) {
            this.width = i11;
            this.height = i12;
            return;
        }
        throw new IllegalArgumentException("Width and height must both be > 0 or Target#SIZE_ORIGINAL, but given width: " + i11 + " and height: " + i12);
    }
}
