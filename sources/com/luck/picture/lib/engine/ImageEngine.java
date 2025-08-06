package com.luck.picture.lib.engine;

import android.content.Context;
import android.widget.ImageView;

public interface ImageEngine {
    void loadAlbumCover(Context context, String str, ImageView imageView);

    void loadGridImage(Context context, String str, ImageView imageView);

    void loadImage(Context context, ImageView imageView, String str, int i11, int i12);

    void loadImage(Context context, String str, ImageView imageView);

    void pauseRequests(Context context);

    void resumeRequests(Context context);
}
