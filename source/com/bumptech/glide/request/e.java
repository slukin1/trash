package com.bumptech.glide.request;

import c4.g;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;

public interface e<R> {
    boolean onLoadFailed(GlideException glideException, Object obj, g<R> gVar, boolean z11);

    boolean onResourceReady(R r11, Object obj, g<R> gVar, DataSource dataSource, boolean z11);
}
