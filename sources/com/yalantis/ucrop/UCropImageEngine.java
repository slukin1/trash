package com.yalantis.ucrop;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.widget.ImageView;

public interface UCropImageEngine {

    public interface OnCallbackListener<T> {
        void onCall(T t11);
    }

    void loadImage(Context context, Uri uri, int i11, int i12, OnCallbackListener<Bitmap> onCallbackListener);

    void loadImage(Context context, String str, ImageView imageView);
}
