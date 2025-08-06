package com.bumptech.glide.request.target;

import android.graphics.drawable.Drawable;
import c4.g;
import com.bumptech.glide.request.c;

@Deprecated
public abstract class BaseTarget<Z> implements g<Z> {
    private c request;

    public c getRequest() {
        return this.request;
    }

    public void onDestroy() {
    }

    public void onLoadCleared(Drawable drawable) {
    }

    public void onLoadFailed(Drawable drawable) {
    }

    public void onLoadStarted(Drawable drawable) {
    }

    public void onStart() {
    }

    public void onStop() {
    }

    public void setRequest(c cVar) {
        this.request = cVar;
    }
}
