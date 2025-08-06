package com.facebook.internal;

import android.graphics.Bitmap;

public class ImageResponse {
    private Bitmap bitmap;
    private Exception error;
    private boolean isCachedRedirect;
    private ImageRequest request;

    public ImageResponse(ImageRequest imageRequest, Exception exc, boolean z11, Bitmap bitmap2) {
        this.request = imageRequest;
        this.error = exc;
        this.bitmap = bitmap2;
        this.isCachedRedirect = z11;
    }

    public Bitmap getBitmap() {
        return this.bitmap;
    }

    public Exception getError() {
        return this.error;
    }

    public ImageRequest getRequest() {
        return this.request;
    }

    public boolean isCachedRedirect() {
        return this.isCachedRedirect;
    }
}
