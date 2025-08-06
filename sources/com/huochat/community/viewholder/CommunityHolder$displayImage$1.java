package com.huochat.community.viewholder;

import android.widget.ImageView;
import c4.g;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.e;

public final class CommunityHolder$displayImage$1 implements e<Object> {
    public final /* synthetic */ ImageView $it;

    public CommunityHolder$displayImage$1(ImageView imageView) {
        this.$it = imageView;
    }

    public boolean onLoadFailed(GlideException glideException, Object obj, g<Object> gVar, boolean z11) {
        this.$it.setScaleType(ImageView.ScaleType.CENTER_CROP);
        return true;
    }

    public boolean onResourceReady(Object obj, Object obj2, g<Object> gVar, DataSource dataSource, boolean z11) {
        this.$it.setScaleType(ImageView.ScaleType.FIT_START);
        return false;
    }
}
