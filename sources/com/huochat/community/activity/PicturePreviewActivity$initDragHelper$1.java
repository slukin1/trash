package com.huochat.community.activity;

import com.huochat.community.widget.DragImageHelperLayout;

public final class PicturePreviewActivity$initDragHelper$1 implements DragImageHelperLayout.OnMoveExitListener {
    public final /* synthetic */ PicturePreviewActivity this$0;

    public PicturePreviewActivity$initDragHelper$1(PicturePreviewActivity picturePreviewActivity) {
        this.this$0 = picturePreviewActivity;
    }

    public void onExit() {
        this.this$0.onBackPressed();
    }

    public void onMove(float f11) {
        this.this$0.flMaskParent.getBackground().mutate().setAlpha((int) (f11 * ((float) 255)));
    }

    public void restore() {
        this.this$0.flMaskParent.getBackground().mutate().setAlpha(255);
    }
}
