package com.huochat.community.fragment;

import android.net.Uri;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.a;
import com.huochat.community.model.MediaBean;
import java.io.File;

public final class FragmentPicturePreview$initData$1$1 extends SimpleTarget<File> {
    public final /* synthetic */ MediaBean $it;
    public final /* synthetic */ FragmentPicturePreview this$0;

    public FragmentPicturePreview$initData$1$1(FragmentPicturePreview fragmentPicturePreview, MediaBean mediaBean) {
        this.this$0 = fragmentPicturePreview;
        this.$it = mediaBean;
    }

    public void onResourceReady(File file, a<? super File> aVar) {
        FragmentPicturePreview fragmentPicturePreview = this.this$0;
        String path = Uri.fromFile(file).getPath();
        MediaBean mediaBean = this.$it;
        fragmentPicturePreview.resetSubScaleViewImageShowSize(path, mediaBean.width, mediaBean.height);
    }
}
