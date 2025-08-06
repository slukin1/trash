package com.huochat.community.adapter;

import c4.g;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.engine.GlideException;
import com.bumptech.glide.request.e;

public final class CommunityShareImageAdapter$displayImage$2 implements e<Object> {
    public final /* synthetic */ String $url;
    public final /* synthetic */ CommunityShareImageAdapter this$0;

    public CommunityShareImageAdapter$displayImage$2(CommunityShareImageAdapter communityShareImageAdapter, String str) {
        this.this$0 = communityShareImageAdapter;
        this.$url = str;
    }

    public boolean onLoadFailed(GlideException glideException, Object obj, g<Object> gVar, boolean z11) {
        this.this$0.loadImageFinish(this.$url, false);
        return true;
    }

    public boolean onResourceReady(Object obj, Object obj2, g<Object> gVar, DataSource dataSource, boolean z11) {
        this.this$0.loadImageFinish(this.$url, true);
        return false;
    }
}
