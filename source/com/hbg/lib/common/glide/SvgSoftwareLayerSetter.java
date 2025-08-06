package com.hbg.lib.common.glide;

import android.graphics.Paint;
import android.graphics.drawable.PictureDrawable;
import android.widget.ImageView;
import c4.d;
import c4.g;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.e;

public class SvgSoftwareLayerSetter implements e<PictureDrawable> {
    /* renamed from: a */
    public boolean onResourceReady(PictureDrawable pictureDrawable, Object obj, g<PictureDrawable> gVar, DataSource dataSource, boolean z11) {
        ((ImageView) ((d) gVar).b()).setLayerType(1, (Paint) null);
        return false;
    }

    public boolean onLoadFailed(GlideException glideException, Object obj, g<PictureDrawable> gVar, boolean z11) {
        ((ImageView) ((d) gVar).b()).setLayerType(0, (Paint) null);
        return false;
    }
}
