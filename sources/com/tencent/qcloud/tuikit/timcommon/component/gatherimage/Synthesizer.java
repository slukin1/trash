package com.tencent.qcloud.tuikit.timcommon.component.gatherimage;

import android.graphics.Bitmap;
import android.graphics.Canvas;

public interface Synthesizer {
    boolean asyncLoadImageList(MultiImageData multiImageData);

    void drawDrawable(Canvas canvas, MultiImageData multiImageData);

    Bitmap synthesizeImageList(MultiImageData multiImageData);
}
