package com.yalantis.ucrop.callback;

import android.net.Uri;

public interface BitmapCropCallback {
    void onBitmapCropped(Uri uri, int i11, int i12, int i13, int i14);

    void onCropFailure(Throwable th2);
}
