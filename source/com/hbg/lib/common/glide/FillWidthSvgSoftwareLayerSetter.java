package com.hbg.lib.common.glide;

import android.graphics.Paint;
import android.graphics.drawable.PictureDrawable;
import android.view.ViewGroup;
import android.widget.ImageView;
import c4.d;
import c4.g;
import com.bumptech.glide.load.DataSource;

public class FillWidthSvgSoftwareLayerSetter extends SvgSoftwareLayerSetter {
    /* renamed from: a */
    public boolean onResourceReady(PictureDrawable pictureDrawable, Object obj, g<PictureDrawable> gVar, DataSource dataSource, boolean z11) {
        ImageView imageView = (ImageView) ((d) gVar).b();
        imageView.setLayerType(1, (Paint) null);
        if (pictureDrawable != null && imageView.getWidth() > 0 && pictureDrawable.getIntrinsicWidth() > 0 && imageView.getWidth() != pictureDrawable.getIntrinsicWidth()) {
            ViewGroup.LayoutParams layoutParams = imageView.getLayoutParams();
            layoutParams.height = (int) ((((float) imageView.getWidth()) / ((float) pictureDrawable.getIntrinsicWidth())) * ((float) pictureDrawable.getIntrinsicHeight()));
            imageView.setLayoutParams(layoutParams);
        }
        super.onResourceReady(pictureDrawable, obj, gVar, dataSource, z11);
        return false;
    }
}
