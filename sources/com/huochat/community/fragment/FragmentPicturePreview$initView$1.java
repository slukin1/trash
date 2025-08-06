package com.huochat.community.fragment;

import android.view.View;
import uk.co.senab.photoview.c;

public final class FragmentPicturePreview$initView$1 implements c.f {
    public final /* synthetic */ FragmentPicturePreview this$0;

    public FragmentPicturePreview$initView$1(FragmentPicturePreview fragmentPicturePreview) {
        this.this$0 = fragmentPicturePreview;
    }

    public void onOutsidePhotoTap() {
        this.this$0.closePage();
    }

    public void onPhotoTap(View view, float f11, float f12) {
        this.this$0.closePage();
    }
}
